package org.tomac.tools.messagegen;

import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Element;
import org.tomac.tools.converter.FixRepositoryDom;
import org.tomac.tools.converter.QuickFixComponent;
import org.tomac.tools.converter.QuickFixField;
import org.tomac.tools.converter.QuickFixField.QuickFixValue;
import org.tomac.tools.converter.QuickFixMessage;

public class FixMessageDom extends FixRepositoryDom {

	public String	packageName;
	public String	packageNameBase;

	public FixMessageDom() {
		packageName = System.getProperty("packageName", "org.tomac.protocol.fix.messaging");
		final String[] ss = packageName.split("[.]");

		packageNameBase = ss[0];
		for (int i = 1; i < ss.length - 1; i++)
			packageNameBase = packageNameBase + "." + ss[i];

	}

	private void addUnique(final QuickFixField f, final QuickFixValue e) {
		QuickFixValue q = null;

		for (int i = 0; i < f.quickFixValues.size(); i++) {
			q = f.quickFixValues.get(i);
			if (q.fixEnum.equals(e.fixEnum) && q.description.equals(e.description))
				return;
		}

		f.quickFixValues.add(e);

	}

	/*
	 * <fix major="4" minor="2" servicepack="0" type="FIX">
	 */
	@SuppressWarnings({ "unchecked" })
	public void buildFrom(final Element fix) throws Exception {

		for (final Iterator<Attribute> i = fix.attributeIterator(); i.hasNext();) {
			final Attribute attribute = i.next();

			if (attribute.getName().equals("type")) {
				final String s = attribute.getValue().toLowerCase();
				type = s.substring(0, 1).toUpperCase() + s.substring(1);
			}
			if (attribute.getName().equals("major"))
				major = attribute.getValue();
			if (attribute.getName().equals("minor"))
				minor = attribute.getValue();
			if (attribute.getName().equals("servicepack"))
				servicepack = attribute.getValue();
			if (attribute.getName().equals("package"))
				packageName = attribute.getValue();
			if (attribute.getName().equals("flavour"))
				flavour = attribute.getValue();

		}

		// The order is important. Start from tag move up to component and message

		getFields(fix);

		for (final Iterator<Element> i = fix.elementIterator("header"); i.hasNext();) {
			final Element component = i.next();
			getComponent(component, quickFixHeader, "header");
		}

		for (final Iterator<Element> i = fix.elementIterator("trailer"); i.hasNext();) {
			final Element component = i.next();
			getComponent(component, quickFixTrailer, "trailer");
		}

		for (final Iterator<Element> i = fix.elementIterator("components"); i.hasNext();) {

			final Element components = i.next();
			quickFixNamedComponents.clear();

			// repeating groups
			for (final Iterator<Element> j = components.elementIterator("component"); j.hasNext();) {

				final QuickFixComponent c = new QuickFixComponent();

				final Element component = j.next();

				String name = null;
				for (final Iterator<Attribute> a = component.attributeIterator(); a.hasNext();) {
					final Attribute attribute = a.next();
					if (attribute.getName().equals("name"))
						name = attribute.getValue();
				}

				for (final Iterator<Element> k = component.elementIterator("group"); k.hasNext();) {

					final Element group = k.next();

					String noInGropuTag = null;
					for (final Iterator<Attribute> a = group.attributeIterator(); a.hasNext();) {
						final Attribute attribute = a.next();
						if (attribute.getName().equals("name"))
							noInGropuTag = attribute.getValue();
					}

					getComponent(group, c, name, noInGropuTag);

					if (quickFixNamedComponents.get(name) == null)
						quickFixNamedComponents.put(name, c);
				}
			}

			// non repeating groups
			for (final Iterator<Element> j = components.elementIterator("component"); j.hasNext();) {

				final QuickFixComponent c = new QuickFixComponent();

				final Element component = j.next();

				String name = null;
				for (final Iterator<Attribute> a = component.attributeIterator(); a.hasNext();) {
					final Attribute attribute = a.next();
					if (attribute.getName().equals("name"))
						name = attribute.getValue();
				}

				getComponent(component, c, name);

				if (quickFixNamedComponents.get(name) == null)
					quickFixNamedComponents.put(name, c);
			}

		}

		// set key for fix components
		for (final QuickFixComponent c : quickFixNamedComponents.values()) {

			final QuickFixField f = quickFixNamedFields.get(c.name);
			if (f == null) {
				final QuickFixComponent cc = quickFixNamedComponents.get(c.name);
				c.keyTag = cc.keyTag;
			} else
				c.keyTag = f.name;
			quickFixComponents.add(c);
		}

		getMessages(fix);

	}

	@SuppressWarnings("unchecked")
	private void getComponent(final Element component, final QuickFixComponent c, final String componentName) {
		boolean hasKeyTag = false;
		c.msgId = new String(componentName);
		c.name = new String(componentName);

		int pos = 0;
		for (final Iterator<Element> j = component.elementIterator(); j.hasNext();) {

			final Element field = j.next();

			if (field.getName().equals("field")) {
				String name = null;
				String required = "N";

				pos++;

				for (final Iterator<Attribute> k = field.attributeIterator(); k.hasNext();) {
					final Attribute attribute = k.next();

					if (attribute.getName().equals("name"))
						name = attribute.getValue();
					if (attribute.getName().equals("required"))
						required = attribute.getValue();
				}
				final QuickFixField f = new QuickFixField(quickFixNamedFields.get(name), required, String.valueOf(pos));
				c.fields.add(f);
				if (!hasKeyTag)
					c.keyTag = f.name;
				hasKeyTag = true;
			} else if (field.getName().equals("component")) {
				String name = null;
				String required = "N";

				pos++;

				for (final Iterator<Attribute> k = field.attributeIterator(); k.hasNext();) {
					final Attribute attribute = k.next();

					if (attribute.getName().equals("name"))
						name = attribute.getValue();
					if (attribute.getName().equals("required"))
						required = attribute.getValue();
				}

				QuickFixComponent cc;
				if (quickFixNamedComponents.get(name) == null) {
					System.out.println(name);
					cc = new QuickFixComponent();
					cc.name = new String(name);
					cc.reqd = new String(required == null ? "N" : required.equals("N") ? "N" : "Y");
					cc.position = String.valueOf(pos);
				} else
					cc = new QuickFixComponent(quickFixNamedComponents.get(name), required, String.valueOf(pos));

				c.components.add(cc);
				if (!hasKeyTag)
					c.keyTag = cc.name;
				hasKeyTag = true;

			}

		}

	}

	/*
	 * <header> <field name="BeginString" required="Y"/> .. </header> <trailer> <field name="CheckSum" required="Y"/> ..
	 */
	private void getComponent(final Element component, final QuickFixComponent c, final String componentName, final String noInGroupTag) {
		c.noInGroupTag = noInGroupTag;
		c.isRepeating = true;

		getComponent(component, c, componentName);
	}

	/*
	 * <fields> <field name="PegDifference" number="211" type="PRICEOFFSET"/> <field name="ExecTransType" number="20" type="CHAR"> <value enum="0" description="NEW"/> ..
	 */
	@SuppressWarnings("unchecked")
	private void getFields(final Element fix) {
		for (final Iterator<Element> i = fix.elementIterator("fields"); i.hasNext();) {

			final Element fields = i.next();

			for (final Iterator<Element> j = fields.elementIterator("field"); j.hasNext();) {
				final QuickFixField f = new QuickFixField();

				final Element field = j.next();

				for (final Iterator<Attribute> k = field.attributeIterator(); k.hasNext();) {
					final Attribute attribute = k.next();

					if (attribute.getName().equals("name"))
						f.name = attribute.getValue();
					if (attribute.getName().equals("number"))
						f.number = attribute.getValue();
					if (attribute.getName().equals("length"))
						f.length = Integer.valueOf(attribute.getValue());
					if (attribute.getName().equals("type"))
						f.type = attribute.getValue();
				}

				for (final Iterator<Element> k = field.elementIterator("value"); k.hasNext();) {
					String fixEnum = null;
					String description = null;
					final Element value = k.next();

					for (final Iterator<Attribute> l = value.attributeIterator(); l.hasNext();) {
						final Attribute attribute = l.next();

						if (attribute.getName().equals("enum"))
							fixEnum = attribute.getValue();
						if (attribute.getName().equals("description"))
							description = attribute.getValue();
					}
					final QuickFixValue e = f.new QuickFixValue(fixEnum, description);
					addUnique(f, e);
				}

				quickFixFields.add(f);
				quickFixNamedFields.put(f.name, f);

			}
		}
	}

	/*
	 * <messages> <message name="AcceptedCancelReplace" msgcat="app" msgtype="8"> <field name="AvgPx" required="Y"/> ..
	 */
	@SuppressWarnings("unchecked")
	private void getMessages(final Element fix) {
		for (final Iterator<Element> i = fix.elementIterator("messages"); i.hasNext();) {

			final Element messages = i.next();

			for (final Iterator<Element> j = messages.elementIterator("message"); j.hasNext();) {
				final QuickFixMessage m = new QuickFixMessage();

				final Element message = j.next();

				for (final Iterator<Attribute> k = message.attributeIterator(); k.hasNext();) {
					final Attribute attribute = k.next();

					if (attribute.getName().equals("name"))
						m.name = attribute.getValue();
					if (attribute.getName().equals("msgcat"))
						m.msgcat = attribute.getValue();
					if (attribute.getName().equals("msgtype"))
						m.msgtype = attribute.getValue();
					if (attribute.getName().equals("msgsubtype"))
						m.msgsubtype = attribute.getValue();
				}

				int pos = 0;
				for (final Iterator<Element> k = message.elementIterator("field"); k.hasNext();) {
					String name = null;
					String required = "N";

					pos++;
					final Element value = k.next();

					for (final Iterator<Attribute> l = value.attributeIterator(); l.hasNext();) {
						final Attribute attribute = l.next();

						if (attribute.getName().equals("name"))
							name = attribute.getValue();
						if (attribute.getName().equals("required"))
							required = attribute.getValue();
					}

					if (quickFixNamedFields.get(name) != null) {
						final QuickFixField f = new QuickFixField(quickFixNamedFields.get(name), required, String.valueOf(pos));
						m.fields.add(f);
					} else
						System.out.println("quickFixNamedFields: " + name);
				}

				pos = 0;
				for (final Iterator<Element> k = message.elementIterator("component"); k.hasNext();) {
					String name = null;
					String required = null;

					pos++;
					final Element value = k.next();

					for (final Iterator<Attribute> l = value.attributeIterator(); l.hasNext();) {
						final Attribute attribute = l.next();

						if (attribute.getName().equals("name"))
							name = attribute.getValue();
						if (attribute.getName().equals("required"))
							required = attribute.getValue();
					}

					if (quickFixNamedComponents.get(name) != null) {
						final QuickFixComponent c = new QuickFixComponent();
						c.name = name;
						c.reqd = required;
						c.isRepeating = quickFixNamedComponents.get(name).isRepeating;
						m.components.add(c);
					} else
						System.out.println(name);
				}

				quickFixMessages.add(m);
			}
		}
	}

}
