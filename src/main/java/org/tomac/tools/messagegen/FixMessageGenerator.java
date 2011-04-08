package org.tomac.tools.messagegen;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.tomac.protocol.fix.FixDataTypes;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixMessageInfo;
import org.tomac.protocol.fix.messaging.FixMessageInfo.MessageTypes;
import org.tomac.tools.converter.QuickFixComponent;
import org.tomac.tools.converter.QuickFixField;
import org.tomac.tools.converter.QuickFixField.QuickFixValue;
import org.tomac.tools.converter.QuickFixMessage;

public class FixMessageGenerator {

	public static final ArrayList<String>	reservedNames	= new ArrayList<String>();

	public static String capFirst(final String s) {
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

	static FixMessageDom fixLoadAndValidate(final File specFile) throws Exception {
		final FixMessageDom fixDom = new FixMessageDom();

		final SAXReader reader = new SAXReader();
		final Document doc = reader.read(specFile);

		fixDom.buildFrom(doc.getRootElement());

		return fixDom;
	}

	public static int getTagAsInt(final byte[] b, final int length) {
		int val = 0;

		val |= b[0];

		if (length > 1)
			for (int i = 1; i < length; i++) {
				val <<= 8;
				val |= b[i];
			}

		return val;
	}

	public static void main(final String[] args) {
		if (args.length < 1) {
			System.out.println("Usage: FixMessageGenerator [spec file] [output directory]");

			return;
		}

		final File specFile = new File(args[0]);

		if (!specFile.exists()) {
			System.out.println("Spec file " + args[0] + " cannot be found!");

			return;
		}

		File outputDir = new File(System.getProperty("user.dir"));

		if (args.length > 1) {
			outputDir = new File(args[1]);

			if (!outputDir.exists())
				outputDir.mkdir();
		}

		FixMessageDom fixDom = null;

		try {
			fixDom = fixLoadAndValidate(specFile);
		} catch (final Exception e) {

			System.out.println("Failure: " + e);

			e.printStackTrace();

			return;
		}

		try {
			new FixMessageGenerator().generate(fixDom, outputDir);
		} catch (final Exception e) {
			System.out.println("Failure: " + e);

			e.printStackTrace();

			return;
		}

		System.out.println("Done.");
	}

	public static String uncapFirst(final String s) {
		return s.substring(0, 1).toLowerCase() + s.substring(1);
	}

	protected void allocateField(final QuickFixField f, final OutputStreamWriter out) throws IOException {

		switch (FixDataTypes.toInt(f.type)) {
			// TODO more lenghts
			case FixDataTypes.STRING:
			case FixDataTypes.MULTIPLECHARVALUE:
			case FixDataTypes.MULTIPLESTRINGVALUE:
			case FixDataTypes.COUNTRY:
			case FixDataTypes.EXCHANGE:
			case FixDataTypes.MONTHYEAR:
			case FixDataTypes.UTCTIMEONLY:
			case FixDataTypes.UTCDATEONLY:
			case FixDataTypes.LOCALMKTDATE:
			case FixDataTypes.TZTIMEONLY:
			case FixDataTypes.TZTIMESTAMP:
			case FixDataTypes.DATA:
			case FixDataTypes.XMLDATA:
			case FixDataTypes.LANGUAGE:
				out.write("		" + uncapFirst(f.name) + " = new byte[" + getJavaLength(f) + "];		\n");
				break;

			case FixDataTypes.UTCTIMESTAMP:
				out.write("		" + uncapFirst(f.name) + " = new byte[FixUtils." + "UTCTIMESTAMP_LENGTH];		\n");
				break;

			case FixDataTypes.CURRENCY:
				out.write("		" + uncapFirst(f.name) + " = new byte[FixUtils." + "CURRENCY_LENGTH];		\n");
				break;

			default:
		}
	}

	protected void declareField(final QuickFixField f, final OutputStreamWriter out) throws IOException {

		switch (FixDataTypes.toInt(f.type)) {

			case FixDataTypes.STRING:
			case FixDataTypes.MULTIPLECHARVALUE:
			case FixDataTypes.MULTIPLESTRINGVALUE:
			case FixDataTypes.COUNTRY:
			case FixDataTypes.CURRENCY:
			case FixDataTypes.EXCHANGE:
			case FixDataTypes.MONTHYEAR:
			case FixDataTypes.UTCTIMESTAMP:
			case FixDataTypes.UTCTIMEONLY:
			case FixDataTypes.UTCDATEONLY:
			case FixDataTypes.LOCALMKTDATE:
			case FixDataTypes.TZTIMEONLY:
			case FixDataTypes.TZTIMESTAMP:
			case FixDataTypes.DATA:
			case FixDataTypes.XMLDATA:
			case FixDataTypes.LANGUAGE:
				out.write("	byte[] " + uncapFirst(f.name) + " = new byte[" + getJavaLength(f) + "];		\n");
				break;

			case FixDataTypes.CHAR:
				out.write("	byte " + uncapFirst(f.name) + " = (byte)' ';		\n");
				break;

			case FixDataTypes.INT:
			case FixDataTypes.LENGTH:
			case FixDataTypes.TAGNUM:
			case FixDataTypes.SEQNUM:
			case FixDataTypes.NUMINGROUP:
			case FixDataTypes.DAYOFMOUNTH:
				out.write("	long " + uncapFirst(f.name) + " = 0;		\n");
				break;

			case FixDataTypes.FLOAT:
			case FixDataTypes.PRICE:
			case FixDataTypes.QTY:
			case FixDataTypes.PRICEOFFSET:
			case FixDataTypes.AMT:
			case FixDataTypes.PERCENTAGE:
				out.write("	long " + uncapFirst(f.name) + " = 0;		\n");
				break;

			case FixDataTypes.BOOLEAN:
				out.write("		boolean " + uncapFirst(f.name) + " = false;		\n");
				break;

			default:
				throw new RuntimeException("No idea how to parse this field: " + f.name);
		}
	}

	private void decodeField(final QuickFixField f, final OutputStreamWriter out) throws IOException {

		switch (FixDataTypes.toInt(f.type)) {

			case FixDataTypes.STRING:
			case FixDataTypes.MULTIPLECHARVALUE:
			case FixDataTypes.MULTIPLESTRINGVALUE:
			case FixDataTypes.COUNTRY:
			case FixDataTypes.CURRENCY:
			case FixDataTypes.EXCHANGE:
			case FixDataTypes.MONTHYEAR:
			case FixDataTypes.UTCTIMESTAMP:
			case FixDataTypes.UTCTIMEONLY:
			case FixDataTypes.UTCDATEONLY:
			case FixDataTypes.LOCALMKTDATE:
			case FixDataTypes.TZTIMEONLY:
			case FixDataTypes.TZTIMESTAMP:
			case FixDataTypes.DATA:
			case FixDataTypes.XMLDATA:
			case FixDataTypes.LANGUAGE:
				out.write("\t\t\tFixMessage.getTagStringValue(buf, " + uncapFirst(f.name) + ", 0, " + uncapFirst(f.name) + ".length, err);\n");
				break;

			case FixDataTypes.INT:
			case FixDataTypes.LENGTH:
			case FixDataTypes.TAGNUM:
			case FixDataTypes.SEQNUM:
			case FixDataTypes.NUMINGROUP:
			case FixDataTypes.DAYOFMOUNTH:
				out.write("\t\t\t" + uncapFirst(f.name) + " = FixMessage.getTagIntValue(buf, err);\n");
				break;

			case FixDataTypes.FLOAT:
			case FixDataTypes.PRICE:
			case FixDataTypes.QTY:
			case FixDataTypes.PRICEOFFSET:
			case FixDataTypes.AMT:
			case FixDataTypes.PERCENTAGE:
				out.write("\t\t\t" + uncapFirst(f.name) + " = FixMessage.getTagFloatValue(buf, err);\n");
				break;

			case FixDataTypes.CHAR:
				out.write("\t\t\t" + uncapFirst(f.name) + " = FixMessage.getTagCharValue(buf, err);\n");
				if (f.quickFixValues.size() > 0) {
					out.write("\t\t\tif( !err.hasError() && ");
					for (final QuickFixValue v : f.quickFixValues)
						out.write("(" + uncapFirst(f.name) + " != (byte)'" + v.fixEnum + "') && ");
					out.write("true)\n");
					out.write("\t\t\t\terr.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,\n");
					out.write("\t\t\t\t\t\"Tag msgType missing got \" + " + f.number + ");");

				}
				break;

			case FixDataTypes.BOOLEAN:
				out.write("\t\t\t" + uncapFirst(f.name) + " = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;\n");
				break;

			default:
				throw new RuntimeException("No idea how to parse this field: " + f.name);
		}

	}

	private void encodeField(final QuickFixField f, final OutputStreamWriter out) throws IOException {

		switch (FixDataTypes.toInt(f.type)) {

			case FixDataTypes.STRING:
			case FixDataTypes.MULTIPLECHARVALUE:
			case FixDataTypes.MULTIPLESTRINGVALUE:
			case FixDataTypes.COUNTRY:
			case FixDataTypes.CURRENCY:
			case FixDataTypes.EXCHANGE:
			case FixDataTypes.MONTHYEAR:
			case FixDataTypes.UTCTIMESTAMP:
			case FixDataTypes.UTCTIMEONLY:
			case FixDataTypes.UTCDATEONLY:
			case FixDataTypes.LOCALMKTDATE:
			case FixDataTypes.TZTIMEONLY:
			case FixDataTypes.TZTIMESTAMP:
			case FixDataTypes.DATA:
			case FixDataTypes.XMLDATA:
			case FixDataTypes.LANGUAGE:
			case FixDataTypes.CHAR:
				out.write("\t\t\tFixUtils.put(out," + uncapFirst(f.name) + "); 		\n");
				break;

			case FixDataTypes.INT:
			case FixDataTypes.LENGTH:
			case FixDataTypes.TAGNUM:
			case FixDataTypes.SEQNUM:
			case FixDataTypes.NUMINGROUP:
			case FixDataTypes.DAYOFMOUNTH:
			case FixDataTypes.FLOAT:
			case FixDataTypes.PRICE:
			case FixDataTypes.QTY:
			case FixDataTypes.PRICEOFFSET:
			case FixDataTypes.AMT:
			case FixDataTypes.PERCENTAGE:
				out.write("\t\t\tFixUtils.put(out, (long)" + uncapFirst(f.name) + ");\n");
				break;

			case FixDataTypes.BOOLEAN:
				out.write("\t\t\tout.put(" + uncapFirst(f.name) + "?(byte)'Y':(byte)'N' );\n");
				break;

			default:
				throw new RuntimeException("No idea how to parse this field: " + f.name);
		}

	}

	public void genAllMessages(final FixMessageDom dom, final File packageDir) throws IOException {

		// dependent on FixMessage, FixInMessage and FixOutMessage in common.io.fix

		for (final QuickFixMessage m : dom.quickFixMessages) {

			final File f = new File(packageDir, dom.type + m.name + ".java");

			genMessage(m, dom, new FileWriter(f));

		}

		for (final QuickFixComponent c : dom.quickFixComponents) {

			final File f = new File(packageDir, dom.type + c.msgId + ".java");

			genComponent(c, dom, new FileWriter(f));

		}

		File f = new File(packageDir, dom.type + "StandardHeader" + ".java");

		dom.quickFixHeader.msgId = "StandardHeader";
		genComponent(dom.quickFixHeader, dom, new FileWriter(f));

		f = new File(packageDir, dom.type + "StrandardTrailer" + ".java");

		dom.quickFixTrailer.msgId = "StrandardTrailer";
		genComponent(dom.quickFixTrailer, dom, new FileWriter(f));

		f = new File(packageDir, dom.type + "MessagePool" + ".java");

		genMessagePool(dom, new FileWriter(f));

	}

	private void genCloneMethod(final boolean isMessage, final FixMessageDom dom, final String name, final ArrayList<QuickFixField> fields, final ArrayList<QuickFixComponent> components, final OutputStreamWriter out) throws IOException {

		if (isMessage) {
			out.write("\t@Override\n");
			out.write("\tpublic " + name + " clone () {\n");
			out.write("\t\t" + name + " out = new " + name + "();\n\n");

			out.write("\t\tstandardHeader.clone(out.standardHeader);\n");
			out.write("\t\tstandardTrailer.clone(out.standardTrailer);\n");

			out.write("\t\treturn clone(out);\n");
			out.write("\t}\n\n");
		}

		out.write("\tpublic " + name + " clone ( " + name + " out ) {\n");
		for (final QuickFixField f : fields) {
			out.write("\t\tif ( has" + capFirst(f.name) + "())\n");
			out.write("\t\t\tout.set" + capFirst(f.name) + "(get" + capFirst(f.name) + "());\n");
		}
		boolean first = true;
		for (final QuickFixComponent cc : components) {
			final QuickFixComponent c = dom.quickFixNamedComponents.get(cc.name);
			if (c.isRepeating) {
				if (first) {
					out.write("\t\tint count = 0;\n");
					first = false;
				}

				out.write("\t\tcount = 0;\n");
				out.write("\t\tfor (Fix" + capFirst(c.name) + " fix" + capFirst(c.name) + " : " + uncapFirst(c.name) + ") {\n");

				out.write("\t\t\tif (!fix" + capFirst(c.name) + ".hasGroup()) continue;\n");
				out.write("\t\t\tout." + uncapFirst(c.name) + "[count] = fix" + capFirst(c.name) + ".clone( out." + uncapFirst(c.name) + "[count] );\n");
				out.write("\t\t\tcount++;\n");
				out.write("\t\t}\n");
			} else {
				out.write("\t\tif (" + uncapFirst(c.name) + ".hasGroup())\n");
				out.write("\t\t\tout." + uncapFirst(c.name) + " = " + uncapFirst(c.name) + ".clone( out." + uncapFirst(c.name) + ");\n");
			}
		}
		out.write("\t\treturn out;\n");
		out.write("\t}\n\n");

	}

	public void genComponent(final QuickFixComponent c, final FixMessageDom dom, final FileWriter out) throws IOException {

		String name = dom.type + c.msgId;

		out.write("package " + dom.packageName + ";\n");
		out.write("\n");
		out.write("import java.nio.ByteBuffer;\n");
		out.write("import " + dom.packageNameBase + ".FixGroup;\n");
		out.write("import " + dom.packageNameBase + ".FixMessage;\n");
		out.write("import " + dom.packageNameBase + ".FixValidationError;\n");
		out.write("import " + dom.packageNameBase + ".FixUtils;\n");
		out.write("import " + dom.packageNameBase + ".messaging.FixTags;\n");

		out.write("		\n");
		out.write("public class " + name + " extends FixGroup {\n");

		for (final QuickFixField f : c.fields) {
			out.write("	private short has" + capFirst(f.name) + ";\n");
			declareField(f, out);
		}

		for (final QuickFixComponent cc : c.components) {
			final QuickFixComponent ccc = dom.quickFixNamedComponents.get(cc.name);
			if (ccc.isRepeating)
				out.write("		public Fix" + ccc.name + "[] " + uncapFirst(ccc.name) + ";\n");
			else
				out.write("		public Fix" + ccc.name + " " + uncapFirst(ccc.name) + ";\n");
		}

		out.write("	\n");

		// The constructor
		out.write("	public " + name + "() {\n");
		out.write("		this(false);\n");
		out.write("	}\n\n");
		
		out.write("	public " + name + "(boolean isRequired) {\n");
		if (c.name.equals("trailer")) // special case. Trailer CheckSum is last field but always the key tag.
			out.write("		super(FixTags." + "CheckSum".toUpperCase() + "_INT);\n\n");
		else
			out.write("		super(FixTags." + getKeyTagForComponent(dom, c.keyTag).toUpperCase() + "_INT);\n\n");
		out.write("		this.isRequired = isRequired;\n");
		if (c.msgId.equals("StandardHeader"))
			out.write("		System.arraycopy( msgType, 0, this.msgType, 0, msgType.length );\n");
		out.write("		\n");

		for (final QuickFixField f : c.fields) {
			out.write("		has" + capFirst(f.name) + " = FixUtils.TAG_HAS_NO_VALUE;		\n");
			allocateField(f, out);
		}
		for (final QuickFixComponent cc : c.components) {
			final QuickFixComponent ccc = dom.quickFixNamedComponents.get(cc.name);
			if (ccc.isRepeating) {
				out.write("		" + uncapFirst(ccc.name) + " = new Fix" + ccc.name + "[FixUtils.FIX_MAX_NOINGROUP];\n");
				if (cc.reqd.equals("Y"))
					out.write("		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) " + uncapFirst(ccc.name) + "[i] = new Fix" + ccc.name + "(true);\n");
				else
					out.write("		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) " + uncapFirst(ccc.name) + "[i] = new Fix" + ccc.name + "();\n");
			} else
				if (cc.reqd.equals("Y"))
					out.write("		" + uncapFirst(ccc.name) + " = new Fix" + ccc.name + "(true);\n");
				else
					out.write("		" + uncapFirst(ccc.name) + " = new Fix" + ccc.name + "();\n");
		}

		out.write("		\n");
		out.write("	}		\n");
		out.write("			\n");

		out.write("\n");
		out.write("	@Override\n");
		out.write("	public boolean hasGroup() {\n");

		final QuickFixComponent cc = dom.quickFixNamedComponents.get(c.keyTag);
		if (cc != null && !c.keyTag.equalsIgnoreCase("derivativeSecurityXML") && !c.keyTag.equalsIgnoreCase("rateSource") && !c.keyTag.equalsIgnoreCase("securityXML")) { // fixprotocol.org bug
			if (!cc.isRepeating)
				out.write("		if (" + uncapFirst(c.keyTag) + ".hasGroup()) return true;\n");
			else
				out.write("		if (" + uncapFirst(c.keyTag) + "[0].hasGroup()) return true;\n");
		} else
			out.write("		if (has" + capFirst(c.keyTag) + "()) return true;\n");
		out.write("		else return false;\n");
		out.write("	}\n");
		out.write("\n\n");

		out.write("	/**\n");
		out.write("     * Parse FIX Group. The buffer is positioned at the value of the tag.\n");
		out.write("     */\n");
		out.write("    public int setBuffer( int tag, ByteBuffer buf, FixValidationError err)\n");
		out.write("    {\n\n");
		out.write("		super.err = err;\n");
		out.write("		super.err.clear();\n");
		out.write("		super.setBuffer(buf, err);\n\n\n");

		out.write("        while ( buf.hasRemaining() ) {\n\n");

		out.write("            switch (tag) {		\n");

		for (final QuickFixField f : c.fields) {
			out.write("            	case FixTags." + f.name.toUpperCase() + "_INT:		\n");
			out.write("            		has" + capFirst(f.name) + " = (short) buf.position();		\n");
			out.write("            		FixMessage.getNext(buf, err);		\n");
			out.write("                	break; 		\n");
		}

		out.write("            	default:\n");

		processTags(dom, out, c.components, false);

		out.write("            }\n\n");
		out.write("            tag = FixMessage.getTag(buf, err);\n");
		out.write("            if (err.hasError()) return tag; // what to do now? \n");
		out.write("            if (isKeyTag(tag)) return tag; // next in repeating group\n");

		out.write("        }		\n");
		out.write("        return tag;\n");
		out.write("    }		\n");

		genHasRequiredTags(false, dom, out, c.name, c.fields, c.components);

		out.write("	@Override\n");
		out.write("	public void clear() {\n");
		out.write("		// just set the length to header + trailer but still we set it...\n");
		for (final QuickFixField f : c.fields)
			out.write("		has" + capFirst(f.name) + " = FixUtils.TAG_HAS_NO_VALUE;\n");
		for (final QuickFixComponent nnc : c.components) {
			final QuickFixComponent nc = dom.quickFixNamedComponents.get(nnc.name);
			if (nc.isRepeating)
				out.write("		for (Fix" + nc.name + " fix" + nc.name + " : " + uncapFirst(nc.name) + ") fix" + nc.name + ".clear();\n");
			else
				out.write("		" + uncapFirst(nc.name) + ".clear();\n");
		}
		out.write("	}\n");
		out.write("\n");

		out.write("	@Override		\n");
		out.write("	public void encode(ByteBuffer out) {\n\n");

		for (final QuickFixField f : c.fields) {
			out.write("		if (has" + capFirst(f.name) + "()) {		\n");
			out.write("			out.put(FixTags." + f.name.toUpperCase() + ");\n\n");
			out.write("			out.put((byte) '=');\n\n");
			encodeField(f, out);
			out.write("		\n");
			out.write("			out.put(FixUtils.SOH);\n\n");
			out.write("            }\n\n");
		}
		for (final QuickFixComponent nnc : c.components) {
			final QuickFixComponent nc = dom.quickFixNamedComponents.get(nnc.name);
			if (nc.isRepeating) {
				out.write("		if (FixUtils.getNoInGroup(" + uncapFirst(nc.name) + ")>0) {\n");
				out.write("			out.put(FixTags." + nc.noInGroupTag.toUpperCase() + ");\n\n");
				out.write("			out.put((byte) '=' );\n\n");
				out.write("			FixUtils.put(out, FixUtils.getNoInGroup(" + uncapFirst(nc.name) + "));\n\n");
				out.write("			out.put(FixUtils.SOH);\n\n");
				out.write("		}\n");
				out.write("		for (Fix" + nc.name + " fix" + nc.name + " : " + uncapFirst(nc.name) + ") if (fix" + nc.name + ".hasGroup()) fix" + nc.name + ".encode(out);\n");
			}
			else {
				out.write("		" + uncapFirst(nc.name) + ".encode(out);\n");
			}
		}

		out.write("	}\n\n");

		out.write("			\n");
		out.write("	@Override		\n");
		out.write("	public void printBuffer(ByteBuffer out) {		\n");
		out.write("		\n");

		for (final QuickFixField f : c.fields) {
			out.write("		if (has" + capFirst(f.name) + "()) {		\n");
			encodeField(f, out);
			out.write("		\n");
			out.write("	        out.put( (byte)' ' );		\n");
			out.write("		}		\n");
			out.write("		\n");
		}
		for (final QuickFixComponent nnc : c.components) {
			final QuickFixComponent nc = dom.quickFixNamedComponents.get(nnc.name);
			if (nc.isRepeating)
				out.write("		for (Fix" + nc.name + " fix" + nc.name + " : " + uncapFirst(nc.name) + ") fix" + nc.name + ".printBuffer(out);\n");
			else
				out.write("		" + uncapFirst(nc.name) + ".printBuffer(out);\n");
		}
		out.write("	}\n\n");

		for (final QuickFixField f : c.fields) {
			out.write("	public " + getJavaType(f) + " get" + capFirst(f.name) + "() { 		\n");
			out.write("		if ( has" + capFirst(f.name) + "()) {		\n");
			out.write("			if (has" + capFirst(f.name) + " == FixUtils.TAG_HAS_VALUE) {		\n");
			out.write("				return " + uncapFirst(f.name) + "; 		\n");
			out.write("			} else {		\n");
			out.write("		\n");
			out.write("				buf.position(has" + capFirst(f.name) + ");		\n");
			out.write("		\n");
			decodeField(f, out);
			out.write("		\n");
			out.write("				if (err.hasError()) {		\n");
			out.write("					buf.position(has" + capFirst(f.name) + ");		\n");
			out.write("					return " + getJavaTypeNull(f) + ";		\n");
			out.write("				}		\n");
			out.write("			}		\n");
			out.write("			has" + capFirst(f.name) + " = FixUtils.TAG_HAS_VALUE;		\n");
			out.write("			return " + uncapFirst(f.name) + ";		\n");
			out.write("		} else {		\n");
			out.write("			return " + getJavaTypeNull(f) + "; 		\n");
			out.write("		}		\n");
			out.write("	}		\n");
			out.write("			\n");
			out.write("	public boolean has" + capFirst(f.name) + "() { return has" + capFirst(f.name) + " != FixUtils.TAG_HAS_NO_VALUE; } 		\n");
			out.write("		\n");

			if (!getJavaType(f).equals("byte[]")) {
				out.write("	public void set" + capFirst(f.name) + "(" + getJavaType(f) + " src) {		\n");
				out.write("		" + uncapFirst(f.name) + " = src;\n");
				out.write("		has" + capFirst(f.name) + " = FixUtils.TAG_HAS_VALUE;		\n");
				out.write("	}\n\n");
			}

			out.write("	public void set" + capFirst(f.name) + "(byte[] src) {		\n");
			out.write("		if (src == null ) return;\n");
			zeroField(f, out);
			setFieldByteArrayValue(f, out);
			out.write("		has" + capFirst(f.name) + " = FixUtils.TAG_HAS_VALUE;		\n");
			out.write("	}		\n");
			out.write("			\n");
			out.write("	public void set" + capFirst(f.name) + "(String str) {		\n");
			out.write("		if (str == null ) return;\n");
			zeroField(f, out);
			out.write("		byte[] src = str.getBytes(); 		\n");
			setFieldByteArrayValue(f, out);
			out.write("		has" + capFirst(f.name) + " = FixUtils.TAG_HAS_VALUE;		\n");
			out.write("	}		\n");
			out.write("			\n");
		}

		// toString
		out.write("	/**\n");
		out.write("	 * If you use toString for any other purpose than administrative printout.\n");
		out.write("	 * You will burn in hell!\n");
		out.write("	**/\n");
		out.write("	@Override\n");
		out.write("	public String toString() {\n");
		out.write("		String s = \"\";\n");
		out.write("		" + printToString(c.fields, "") + "\n");
		for (final QuickFixComponent nnc : c.components) {
			final QuickFixComponent nc = dom.quickFixNamedComponents.get(nnc.name);
			if (nc.isRepeating)
				out.write("		for (Fix" + nc.name + " fix" + nc.name + " : " + uncapFirst(nc.name) + ") fix" + nc.name + ".toString();\n");
			else
				out.write("\t\ts += " + uncapFirst(nc.name) + ".toString();\n");
		}
		out.write("\t\t\treturn s;\n");
		out.write("	}\n\n");

		// equals
		name = capFirst(dom.type) + capFirst(c.msgId);
		out.write("	@Override\n");
		out.write("	public boolean equals(Object o) {\n");
		out.write("		if (! ( o instanceof " + name + ")) return false;\n\n");
		out.write("		" + name + " msg = (" + name + ") o;\n\n");
		for (final QuickFixComponent nnc : c.components) {
			final QuickFixComponent nc = dom.quickFixNamedComponents.get(nnc.name);
			if (nc.isRepeating) {
				out.write("		for (int i = 0; i < " + uncapFirst(nc.name) + ".length; i++)\n");
				out.write("			if (!" + uncapFirst(nc.name) + "[i].equals(msg." + uncapFirst(nc.name) + "[i])) return false;\n");
			} else
				out.write("\t\tif (!" + uncapFirst(nc.name) + ".equals(msg." + uncapFirst(nc.name) + ")) return false;\n");
		}
		printEquals(out, c.fields);
		out.write("	}\n");

		genCloneMethod(false, dom, name, c.fields, c.components, out);

		// write out the close to the class
		out.write("}\n");

		// done. close out the file
		out.close();

	}

	public void genConstants(final FixMessageDom dom, final OutputStreamWriter out) throws Exception {

		// write package line
		out.write("package " + dom.packageName + ";\n\n");

		writeGeneratedFileHeader(out);

		out.write("public interface " + dom.type + "MessageInfo\n");
		out.write("{\n\n");
		final String servicepack = Integer.valueOf(dom.major) > 4 ? "SP" + dom.servicepack : "";
		if (Integer.valueOf(dom.major) < 5) {
			out.write("\tpublic static final byte[] BEGINSTRING_VALUE = \"" + dom.type.toUpperCase() + "." + dom.major + "." + dom.minor + servicepack + "\".getBytes();\n");
		} else {
			out.write("\tpublic static final byte[] BEGINSTRING_VALUE = \"FIXT.1.1\".getBytes();\n");
		}
		out.write("\tpublic static final byte[] FLAVOUR = \"" + dom.flavour + "\".getBytes();\n\n");

		out.write("\tpublic static class MessageTypes\n");
		out.write("\t{\n");

		out.write("\t\tpublic static final byte[] UNKNOWN         = \"U0\".getBytes();\n");
		for (final QuickFixMessage m : dom.quickFixMessages) {
			final String name = m.name.toUpperCase();
			out.write("\t\tpublic static final byte[] " + name + " = \"" + m.msgtype + "\".getBytes();\n");
		}
		out.write("\n");

		out.write("\t\tpublic static final int UNKNOWN_INT         = " + getTagAsInt("U0".getBytes(), 2) + ";\n");
		for (final QuickFixMessage m : dom.quickFixMessages) {
			// TODO isNasdaqOMX
			final String msgType = m.msgtype + (m.msgsubtype.length() > 0 ? m.msgsubtype : "");
			final int tmp = getTagAsInt(msgType.getBytes(), msgType.getBytes().length);
			out.write("\t\tpublic static final int " + m.name.toUpperCase() + "_INT = " + tmp + ";\n");
		}
		out.write("}\n\n");

		for (final QuickFixField f : dom.quickFixFields)
			if (f.quickFixValues.size() > 0) {
				out.write("\tpublic class " + f.name + " {\n");

				for (final QuickFixValue v : f.quickFixValues)
					writeEnum(out, f, v);
				out.write("\t\t}\n\n");
			}

		out.write("}\n");

		// done. close out the file
		out.close();
	}

	public void generate(final FixMessageDom dom, final File outputDir) throws Exception {

		final File packageDir = new File(outputDir, dom.packageName.replace('.', File.separatorChar));

		// ensure the directory exists
		if (!packageDir.exists())
			packageDir.mkdir();
		else
			// delete all the old files
			for (final File f : packageDir.listFiles(new FilenameFilter() {
				public boolean accept(final File dir, final String name) {
					return name.endsWith(".java");
				}
			}))
				f.delete();

		// generate the tags
		File f = new File(packageDir, dom.type + "Tags.java");

		genTags(dom, new FileWriter(f));

		// generate the constants
		f = new File(packageDir, dom.type + "MessageInfo.java");

		genConstants(dom, new FileWriter(f));

		// generate the messages
		genAllMessages(dom, packageDir);

		// generate a listener interface
		f = new File(packageDir, dom.type + "MessageListener.java");

		genListenerInterface(dom, new FileWriter(f));

		// generate a listener interface
		f = new File(packageDir, dom.type + "MessageListenerImpl.java");

		genListenerInterfaceImpl(dom, new FileWriter(f));

		// generate a parser
		f = new File(packageDir, dom.type + "MessageParser.java");

		genParser(dom, new FileWriter(f));

	}

	public void genListenerInterface(final FixMessageDom dom, final OutputStreamWriter out) throws Exception {

		// write package line
		out.write("package " + dom.packageName + ";\n\n");

		writeGeneratedFileHeader(out);

		// import ByteBuffer
		out.write("import java.nio.ByteBuffer;\n\n");
		out.write("import " + dom.packageNameBase + ".replay.FixValidator;\n");
		out.write("import " + dom.packageNameBase + ".FixValidationError;\n");
		out.write("import " + dom.packageNameBase + ".FixInMessage;\n");
		out.write("import " + dom.packageNameBase + ".IFixSession;\n\n");

		// write out the open to the interface
		out.write("public interface " + dom.type + "MessageListener\n{\n\n");

		// write out a handler for unknown message types 	
		out.write("    public IFixSession getSession(long connectorID, FixValidationError err );\n\n");
		out.write("    public IFixSession getSession( long connectorID, FixLogon logon, FixValidationError err );\n\n");
		out.write("    public void addValidator( FixValidator validator );\n\n");
		out.write("    public FixValidator getValidator();\n\n");
		out.write("    public void onFixValidationError ( FixValidationError err );\n\n");
		out.write("    public void onUnknownMessageType( ByteBuffer msg, int msgType );\n\n");

		// write out each callback
		for (final QuickFixMessage m : dom.quickFixMessages)
			out.write("    void on" + dom.type + m.name + "( " + dom.type + m.name + " msg );\n\n");

		// write out the close to the interface
		out.write("}\n");

		// done. close out the file
		out.close();
	}

	public void genListenerInterfaceImpl(final FixMessageDom dom, final OutputStreamWriter out) throws Exception {

		// write package line
		out.write("package " + dom.packageName + ";\n\n");

		writeGeneratedFileHeader(out);

		// import ByteBuffer
		out.write("import java.nio.ByteBuffer;\n\n");
		out.write("import " + dom.packageNameBase + ".replay.FixValidator;\n");
		out.write("import " + dom.packageNameBase + ".FixValidationError;\n");
		out.write("import " + dom.packageNameBase + ".FixInMessage;\n");
		out.write("import " + dom.packageNameBase + ".IFixSession;\n\n");

		// write out the open to the interface
		out.write("public class " + dom.type + "MessageListenerImpl implements FixMessageListener \n{\n\n");

		out.write("    @Override\n");
		out.write("    public IFixSession getSession( long connectorID, FixValidationError err ) { return dummySession; }\n\n");

		out.write("    @Override\n");
		out.write("    public IFixSession getSession( long connectorID, FixLogon logon, FixValidationError err ) { return dummySession; }\n\n");

		out.write("    @Override\n");
		out.write("    public void addValidator( FixValidator validator ) {}\n\n");

		out.write("    @Override\n");
		out.write("    public FixValidator getValidator() { return null; }\n\n");

		out.write("    @Override\n");
		out.write("    public void onFixValidationError ( FixValidationError err ) {}\n\n");

		// write out a handler for unknown message types
		out.write("    @Override\n");
		out.write("    public void onUnknownMessageType( ByteBuffer msg, int msgType ) {}\n\n");

		// write out each callback
		for (final QuickFixMessage m : dom.quickFixMessages) {

			out.write("    @Override\n");
			out.write("    public void on" + dom.type + m.name + "( " + dom.type + m.name + " msg ) {}\n\n");
		}
		
		out.write("\tIFixSession dummySession = new IFixSession() {\n\n");
			
		out.write("\t\t@Override\n");
		out.write("\t\tpublic void setOutMsgSeqNum(long msgSeqNum) {}\n\n");
			
		out.write("\t\t@Override\n");
		out.write("\t\tpublic void setInMsgSeqNum(long msgSeqNum) {}\n\n");
			
		out.write("\t\t@Override\n");
		out.write("\t\tpublic void incrementOutMsgSeqNum() {}\n\n");
			
		out.write("\t\t@Override\n");
		out.write("\t\tpublic void incrementInMsgSeqNum(FixInMessage msg, FixValidationError err) {}\n\n");
			
		out.write("\t\t@Override\n");
		out.write("\t\tpublic int getSessionID() {	return 0; }\n\n");
			
		out.write("\t\t@Override\n");
		out.write("\t\tpublic long getOutMsgSeqNum() {	return 0; }\n\n");
			
		out.write("\t\t@Override\n");
		out.write("\t\tpublic long getInMsgSeqNum() { return 0; }\n");

		out.write("\t\t@Override\n");
		out.write("\t\tpublic boolean isEstablished() {	return true; }\n\n");
		
		out.write("\t};\n\n");

		// write out the close to the interface
		out.write("}\n");

		// done. close out the file
		out.close();
	}

	public void genMessage(final QuickFixMessage m, final FixMessageDom dom, final OutputStreamWriter out) throws IOException {

		String name = dom.type + m.name;

		out.write("package " + dom.packageName + ";\n");
		out.write("\n");
		out.write("import " + dom.packageNameBase + ".FixMessage;\n");
		out.write("import " + dom.packageNameBase + ".FixValidationError;\n");
		out.write("import java.nio.ByteBuffer;\n");
		out.write("import " + dom.packageNameBase + ".messaging.FixTags;\n");
		out.write("import " + dom.packageNameBase + ".Fix" + "In" + "Message;\n");
		out.write("import " + dom.packageNameBase + ".FixUtils;\n");

		out.write("		\n");
		out.write("public class " + name + " extends Fix" + "In" + "Message {\n");

		for (final QuickFixField f : m.fields) {
			out.write("	private short has" + capFirst(f.name) + ";\n");
			declareField(f, out);
		}
		for (final QuickFixComponent c : m.components)
			if (c.isRepeating)
				out.write("	public Fix" + c.name + "[] " + uncapFirst(c.name) + ";\n");
			else
				out.write("	public Fix" + c.name + " " + uncapFirst(c.name) + ";\n");

		out.write("	\n");
		out.write("	public " + name + "() {\n");
		out.write("		super(FixMessageInfo.MessageTypes." + m.name.toUpperCase() + ");\n\n\n");

		for (final QuickFixField f : m.fields) {
			out.write("		has" + capFirst(f.name) + " = FixUtils.TAG_HAS_NO_VALUE;		\n");
			allocateField(f, out);
		}
		for (final QuickFixComponent cc : m.components) {
			final QuickFixComponent c = dom.quickFixNamedComponents.get(cc.name);
			if (c.isRepeating) {
				out.write("		" + uncapFirst(c.name) + " = new Fix" + c.name + "[FixUtils.FIX_MAX_NOINGROUP];\n");
				out.write("		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) " + uncapFirst(c.name) + "[i] = new Fix" + c.name + "();\n");
			} else
				out.write("		" + uncapFirst(c.name) + " = new Fix" + c.name + "();\n");
		}

		out.write("\n");
		out.write("	}\n\n");

		if (true) {
			out.write("    public void setBuffer( ByteBuffer buf, FixValidationError err)		\n");
			out.write("    {		\n");
			out.write("				\n");
			out.write("		super.setBuffer(buf, err);\n");
			out.write("        if (err.hasError()) return;\n\n");
			out.write("        int tag = FixMessage.getTag(buf, err);\n");
			out.write("        if (err.hasError()) return;\n\n");

			out.write("        while ( buf.hasRemaining() ) {\n\n");

			out.write("            switch (tag) {		\n");

			for (final QuickFixField f : m.fields) {
				out.write("            	case FixTags." + f.name.toUpperCase() + "_INT:		\n");
				out.write("            		has" + capFirst(f.name) + " = (short) buf.position();		\n");
				out.write("            		FixMessage.getNext(buf, err);		\n");
				out.write("                	break;\n");
			}
			out.write("            	default:\n");
			out.write("        			if ( standardHeader.isKeyTag(tag)) {\n");
			out.write("        				tag = standardHeader.setBuffer( tag, buf, err);		\n");
			out.write("            			if (err.hasError()) break; 		\n");
			out.write("                		else continue;		\n");
			out.write("        			} else if ( standardTrailer.isKeyTag(tag)) {\n");
			out.write("        				tag = standardTrailer.setBuffer( tag, buf, err);\n");
			out.write("        				FixMessage.unreadLastTag(tag, buf);\n");
			out.write("        				if (!err.hasError()) hasRequiredTags(err);\n");
			out.write("            			return; // always last, we are done now\n");

			processTags(dom, out, m.components, true);

			out.write(" 						FixMessage.getNext(buf, err);		\n");
			out.write("                		if (err.hasError()) break; 		\n");
			out.write("                		else {\n");
			out.write("                			err.setError((int)FixMessageInfo.SessionRejectReason.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE, \"Tag not defined for this message type\", tag, FixMessageInfo.MessageTypes." + m.name.toUpperCase()+ ");\n");
			out.write("                			break;\n");
			out.write("                		}\n");

			out.write("					}\n\n");
			out.write("\t\t\t}\n\n");
			
			out.write("        		if (err.hasError()) return;\n\n");
			out.write("            	tag = FixMessage.getTag(buf, err);		\n");
			out.write("        		if (err.hasError()) break;\n\n");
			out.write("\t\t}\n\n");
			out.write("\t}		\n\n");

			genHasRequiredTags(true, dom, out, m.name, m.fields, m.components);

			out.write("	@Override		\n");
			out.write("	public void getAll() {		\n");
			for (final QuickFixField f : m.fields) {
				out.write("		get" + capFirst(f.name) + "();		\n");
			}
			out.write("	}		\n");
		}
		out.write("		\n");
		out.write("	@Override		\n");
		out.write("	public int encode(ByteBuffer out) {\n\n");
		out.write("		int startPos = out.position();\n");
		out.write("		super.standardHeader.setBodyLength(1000);\n\n");

		out.write("		// if this is the standardHeader for an out-bound message wee need to set default tags\n");
		out.write("		if (buf == null) {\n");
		out.write("			super.standardHeader.setBeginString(FixMessageInfo.BEGINSTRING_VALUE);\n");
		out.write("		}\n\n");
		
		out.write("		super.standardHeader.encode(out);\n");

		for (final QuickFixField f : m.fields) {
			out.write("		if (has" + capFirst(f.name) + "()) {		\n");
			out.write("			out.put(FixTags." + f.name.toUpperCase() + ");		\n");
			out.write("		\n");
			out.write("			out.put((byte) '=');		\n");
			out.write("		\n");
			encodeField(f, out);
			out.write("		\n");
			out.write("			out.put(FixUtils.SOH);		\n");
			out.write("		}		\n");
		}
		out.write("		\n");
		
		for (final QuickFixComponent cc : m.components) {
			final QuickFixComponent c = dom.quickFixNamedComponents.get(cc.name);
			if (c.isRepeating) {
				out.write("		if (FixUtils.getNoInGroup(" + uncapFirst(c.name) + ")>0) {\n");
				out.write("			out.put(FixTags." + c.noInGroupTag.toUpperCase() + ");\n\n");
				out.write("			out.put((byte) '=' );\n\n");
				out.write("			FixUtils.put(out, FixUtils.getNoInGroup(" + uncapFirst(c.name) + "));\n\n");
				out.write("			out.put(FixUtils.SOH);\n\n");
				out.write("		}\n");
				out.write("		for (Fix" + c.name + " fix" + c.name + " : " + uncapFirst(c.name) + ") if (fix" + c.name + ".hasGroup()) fix" + c.name + ".encode(out);\n");
			} else {
				out.write("		"+  uncapFirst(c.name) + ".encode(out);\n");
			}
		}
		out.write("		\n");
		
		out.write("		// set body length\n\n");
		out.write("		int endPos = out.position();\n\n");
		out.write("		super.standardHeader.setBodyLength(endPos - FixUtils.FIX_MESSAGE_START);\n\n");
		out.write("		out.position(startPos + FixUtils.FIX_HEADER);\n\n");
		out.write("		if (super.standardHeader.getBodyLength()>999) {\n");
		out.write("			FixUtils.put(out, super.standardHeader.getBodyLength());\n");
		out.write("		} else if (super.standardHeader.getBodyLength()>99) {\n");
		out.write("			FixUtils.put(out, 0);\n");
		out.write("			FixUtils.put(out, super.standardHeader.getBodyLength());\n");
		out.write("		} else {\n");
		out.write("			FixUtils.put(out, 0);\n");
		out.write("			FixUtils.put(out, 0);\n");
		out.write("			FixUtils.put(out, super.standardHeader.getBodyLength());\n");
		out.write("		}\n");

		out.write("		final byte[] tmpCheckSum = new byte[FixTags.CHECKSUM_LENGTH];\n");
		out.write("		FixUtils.generateCheckSum(tmpCheckSum, out, startPos, endPos);\n");
		out.write("		super.standardTrailer.setCheckSum(tmpCheckSum);\n\n");

		out.write("		out.position(endPos);\n\n");
		out.write("		super.standardTrailer.encode(out);\n");
		out.write("		out.limit(out.position());\n");
		out.write("		out.flip();\n\n");

		out.write("		return (int) super.standardHeader.getBodyLength();\n\n");
		out.write("	}			\n");
		out.write("			\n");
		out.write("			\n");
		out.write("	@Override		\n");
		out.write("	public void printBuffer(ByteBuffer out) {		\n");
		out.write("		\n");
		out.write("		int startPos = out.position();		\n");
		out.write("					\n");
		out.write("		super.standardHeader.encode(out);		\n");
		out.write("		\n");

		for (final QuickFixField f : m.fields) {
			out.write("		if (has" + capFirst(f.name) + "()) {		\n");
			encodeField(f, out);
			out.write("		\n");
			out.write("	        out.put( (byte)' ' );		\n");
			out.write("		}		\n");
			out.write("		\n");
		}
		out.write("		super.standardTrailer.encode(out);		\n");
		out.write("		\n");
		out.write("		int endPos = out.position();		\n");
		out.write("		\n");
		out.write("		// set body length		\n");
		out.write("				\n");
		out.write("		super.standardHeader.setBodyLength( out.position() - startPos );		\n");
		out.write("				\n");
		out.write("		out.position(startPos + FixUtils.FIX_HEADER); 		\n");
		out.write("		\n");
		out.write("		FixUtils.put( out, super.standardHeader.getBodyLength() );		\n");
		out.write("		\n");
		out.write("		out.position(endPos);		\n");
		out.write("		\n");
		out.write("	}			\n");
		out.write("			\n");

		for (final QuickFixField f : m.fields) {
			out.write("	public void crack" + capFirst(f.name) + "() {		\n");
			out.write("		get" + capFirst(f.name) + "();		\n");
			out.write("	}		\n");
			out.write("			\n");

			out.write("	public " + getJavaType(f) + " get" + capFirst(f.name) + "() { 		\n");
			out.write("		if ( has" + capFirst(f.name) + "()) {		\n");

			out.write("			if (has" + capFirst(f.name) + " == FixUtils.TAG_HAS_VALUE) {		\n");
			out.write("				return " + uncapFirst(f.name) + "; 		\n");
			out.write("			} else {\n\n");
			out.write("				buf.position(has" + capFirst(f.name) + ");\n\n");
			decodeField(f, out);
			out.write("		\n");
			out.write("				if (err.hasError()) {		\n");
			out.write("					buf.position(0);		\n");
			out.write("					return " + getJavaTypeNull(f) + ";		\n");
			out.write("				}		\n");
			out.write("			}		\n");
			out.write("			has" + capFirst(f.name) + " = FixUtils.TAG_HAS_VALUE;		\n");
			out.write("			buf.position(0);		\n");
			out.write("			return " + uncapFirst(f.name) + ";		\n");

			out.write("		} else {		\n");
			out.write("			return " + getJavaTypeNull(f) + "; 		\n");
			out.write("		}		\n");
			out.write("	}		\n");
			out.write("			\n");
			out.write("	public boolean has" + capFirst(f.name) + "() { return has" + capFirst(f.name) + " != FixUtils.TAG_HAS_NO_VALUE; } 		\n\n");

			out.write("	public void set" + capFirst(f.name) + "(byte[] src) {		\n");
			out.write("		if (src == null ) return;\n");
			zeroField(f, out);
			setFieldByteArrayValue(f, out);
			out.write("		has" + capFirst(f.name) + " = FixUtils.TAG_HAS_VALUE;		\n");
			out.write("	}\n\n");

			if (!getJavaType(f).equals("byte[]")) {
				out.write("	public void set" + capFirst(f.name) + "(" + getJavaType(f) + " src) {		\n");
				out.write("		" + uncapFirst(f.name) + " = src;\n");
				out.write("		has" + capFirst(f.name) + " = FixUtils.TAG_HAS_VALUE;		\n");
				out.write("	}\n\n");
			}

			out.write("	public void set" + capFirst(f.name) + "(String str) {		\n");
			out.write("		if (str == null ) return;\n");
			zeroField(f, out);
			out.write("		byte[] src = str.getBytes(); 		\n");
			setFieldByteArrayValue(f, out);
			out.write("		has" + capFirst(f.name) + " = FixUtils.TAG_HAS_VALUE;		\n");
			out.write("	}		\n");
			out.write("			\n");
		}

		// toString
		out.write("	/**\n");
		out.write("	 * If you use toString for any other purpose than administrative printout.\n");
		out.write("	 * You will burn in hell!\n");
		out.write("	**/\n");
		out.write("	@Override\n");
		out.write("	public String toString() {\n");
		out.write("		String s = \"\";\n");

		out.write("		try {\n");
		out.write("			" + printToString(dom.quickFixHeader.fields, "standardHeader.") + "\n");
		out.write("			" + printToString(m.fields, "") + "\n");
		out.write("			" + printToString(dom.quickFixTrailer.fields, "standardTrailer.") + "\n");
		out.write("		} catch(Exception e) {  };\n");

		out.write("\t\t\treturn s;\n");
		out.write("	}\n\n");

		// equals
		name = capFirst(dom.type) + capFirst(m.name);
		out.write("	@Override\n");
		out.write("	public boolean equals(Object o) {\n");
		out.write("		if (! ( o instanceof " + name + ")) return false;\n\n");
		out.write("		" + name + " msg = (" + name + ") o;\n\n");
		out.write("		if (!standardHeader.equals(msg.standardHeader)) return false;\n\n");
		printEquals(out, m.fields);
		out.write("	}\n");

		genCloneMethod(true, dom, name, m.fields, m.components, out);

		// write out the close to the class
		out.write("}\n");

		// done. close out the file
		out.close();
	}
	
	private void genHasRequiredTags(boolean isMessage, FixMessageDom dom, OutputStreamWriter out, String messageName, ArrayList<QuickFixField> fields, ArrayList<QuickFixComponent> components) throws IOException {
		out.write("\tpublic boolean hasRequiredTags(FixValidationError err) {\n");
		if (isMessage) {
			out.write("		standardHeader.hasRequiredTags(err); if (err.hasError()) return false; \n\n");
		}
		for (final QuickFixField f : fields) {
			if (f.reqd.equalsIgnoreCase("Y")) {
				out.write("\t\tif (!has" + capFirst(f.name) + "()) { \n");
				if (isMessage)
					out.write("\t\t\terr.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, \"Required tag missing\", FixTags." + f.name.toUpperCase() + "_INT, FixMessageInfo.MessageTypes."
						+ messageName.toUpperCase() + ");\n");
				else 
					out.write("\t\t\terr.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, \"Required tag missing\", FixTags." + f.name.toUpperCase() + "_INT);\n");
				out.write("\t\t\treturn false;\n");
				out.write("\t\t}\n");
			}
		}
		for (final QuickFixComponent cc : components) {
			final QuickFixComponent c = dom.quickFixNamedComponents.get(cc.name);
			if (c.isRepeating && cc.reqd != null && cc.reqd.equalsIgnoreCase("Y")) {
				out.write("		for (int i = 0; i< FixUtils.FIX_MAX_NOINGROUP; i++) { if ("+  uncapFirst(c.name) + "[i].hasGroup()) "+  uncapFirst(c.name) + "[i].hasRequiredTags(err); if (err.hasError()) return false; }\n");
			} else if (!c.isRepeating && cc.reqd.equalsIgnoreCase("Y")) {
				out.write("		if ("+  uncapFirst(c.name) + ".isRequired) "+  uncapFirst(c.name) + ".hasRequiredTags(err); if (err.hasError()) return false;\n");
			}
		}

		if (isMessage) {
			out.write("		standardTrailer.hasRequiredTags(err); if (err.hasError()) return false; \n\n");
		}
		out.write("\t\treturn true;\n");
		out.write("\t}\n");
		
	}

	public void genMessagePool(final FixMessageDom dom, final OutputStreamWriter out) throws IOException {

		out.write("package " + dom.packageName + ";\n\n");
		out.write("import java.nio.ByteBuffer;\n");
		out.write("import " + dom.packageNameBase + ".FixValidationError;\n");
		out.write("import " + dom.packageNameBase + ".messaging.FixMessageInfo;\n");
		out.write("import " + dom.packageNameBase + "." + capFirst(dom.type.toLowerCase()) + "Message;\n");
		out.write("import " + dom.packageNameBase + "." + capFirst(dom.type.toLowerCase()) + "InMessage;\n");
		for (final QuickFixMessage m : dom.quickFixMessages) {
			final String name = capFirst(dom.type.toLowerCase()) + m.name;
			out.write("import " + dom.packageNameBase + ".messaging." + name + ";\n");
		}
		out.write("\n");
		out.write("public class Fix" + "MessagePool<T extends FixMessage> {\n\n");
		for (final QuickFixMessage m : dom.quickFixMessages) {
			final String name = capFirst(dom.type.toLowerCase()) + m.name;
			out.write("	" + name + "[] pool" + name + ";\n");
			out.write("	boolean[] inUse" + name + ";\n");
		}
		out.write("\n");
		out.write("	public FixMessagePool() {\n");
		for (final QuickFixMessage m : dom.quickFixMessages) {
			final String name = capFirst(dom.type.toLowerCase()) + m.name;
			out.write("		pool" + name + " = new " + name + "[1];\n");
			out.write("		inUse" + name + " = new boolean[1];\n\n");
			out.write("		for (int i = pool" + name + ".length - 1; i >= 0; i--) {\n");
			out.write("			pool" + name + "[i] = new " + name + "();\n");
			out.write("			inUse" + name + "[i] = false;\n");
			out.write("		}\n");
		}
		out.write("	}\n\n");

		out.write("\tpublic T getFixMessage(ByteBuffer buf, FixValidationError err) {\n");
		out.write("\t\tint msgType = FixInMessage.crackMsgType( buf ,err );\n\n");

		out.write("\t\t// garbled message\n");
		out.write("\t\tif (err.hasError()) return null;\n\n");

		out.write("\t\treturn getFixMessage(msgType, buf, err);\n");
		out.write("\t}\n");

		out.write("	@SuppressWarnings(\"unchecked\")\n");
		out.write("	private T getFixMessage(int msgType, ByteBuffer buf, FixValidationError err) {\n");
		out.write("		switch(msgType) {\n");
		for (final QuickFixMessage m : dom.quickFixMessages) {
			final String name = capFirst(dom.type.toLowerCase()) + m.name;
			out.write("		case FixMessageInfo.MessageTypes." + m.name.toUpperCase() + "_INT:\n");
			out.write("			return (T) get" + name + "(buf, err);\n");
		}
		out.write("		default:\n");
		out.write("			return null;\n");
		out.write("		}\n");
		out.write("	}\n\n");

		out.write("	@SuppressWarnings(\"unchecked\")\n");
		out.write("	public T getFixMessage(int msgType) {\n");
		out.write("		switch(msgType) {\n");
		for (final QuickFixMessage m : dom.quickFixMessages) {
			final String name = capFirst(dom.type.toLowerCase()) + m.name;
			out.write("		case FixMessageInfo.MessageTypes." + m.name.toUpperCase() + "_INT:\n");
			out.write("			return (T) get" + name + "();\n");
		}
		out.write("		default:\n");
		out.write("			return null;\n");
		out.write("		}\n");
		out.write("	}\n\n");

		final String[] directions = { "in", "out" };
		for (final String direction : directions)
			for (final QuickFixMessage m : dom.quickFixMessages) {
				final String name = capFirst(dom.type.toLowerCase()) + m.name;
				if (direction.equalsIgnoreCase("in"))
					out.write("	public " + name + " get" + name + "(ByteBuffer buf, FixValidationError err) {\n");
				else
					out.write("	public " + name + " get" + name + "() {\n");
				out.write("		for (int i = inUse" + name + ".length - 1; i >= 0; i--)\n");
				out.write("			if (!inUse" + name + "[i]) {\n");
				out.write("				inUse" + name + "[i] = true;\n");
				if (direction.equalsIgnoreCase("in"))
					out.write("				pool" + name + "[i].setBuffer(buf, err);\n");
				out.write("				return pool" + name + "[i];\n");
				out.write("			}\n\n");
				out.write("		boolean[] old_inUse = inUse" + name + ";\n");
				out.write("		inUse" + name + " = new boolean[old_inUse.length + 10];\n");
				out.write("		System.arraycopy(old_inUse, 0, inUse" + name + ", 0, old_inUse.length);\n\n");

				out.write("		" + name + "[] old_pool = pool" + name + ";\n");
				out.write("		pool" + name + " = new " + name + "[old_pool.length + 10];\n");
				out.write("		System.arraycopy(old_pool, 0, pool" + name + ", 0, old_pool.length);\n\n");

				out.write("		for (int i = old_pool.length; i < pool" + name + ".length; i++) {\n");
				out.write("			pool" + name + "[i] = new " + name + "();\n");
				out.write("			inUse" + name + "[i] = false;\n");
				out.write("		}\n\n");
				out.write("		inUse" + name + "[pool" + name + ".length - 1] = true;\n");
				if (direction.equalsIgnoreCase("in"))
					out.write("		pool" + name + "[pool" + name + ".length - 1].setBuffer(buf, err);\n");
				out.write("		return pool" + name + "[pool" + name + ".length - 1];\n");
				out.write("	}\n\n");
			}

		out.write("	public void returnFixMessage(T msg) {\n");
		out.write("		switch(msg.msgType) {\n");
		for (final QuickFixMessage m : dom.quickFixMessages) {
			final String name = capFirst(dom.type.toLowerCase()) + m.name;
			out.write("			case FixMessageInfo.MessageTypes." + m.name.toUpperCase() + "_INT:\n");
			out.write("				return" + name + "((" + name + ")msg);\n");
			out.write("				break;\n");
		}
		out.write("			default:\n");
		out.write("				break;\n");
		out.write("		}\n\n");
		out.write("	}\n\n");

		for (final QuickFixMessage m : dom.quickFixMessages) {
			final String name = capFirst(dom.type.toLowerCase()) + m.name;
			out.write("	public void return" + name + "(" + name + " msg) {\n\n");
			out.write("		for (int i = inUse" + name + ".length - 1; i >= 0; i--) {\n");
			out.write("			if (pool" + name + "[i] == msg) {\n");
			out.write("				inUse" + name + "[i] = false;\n");
			out.write("				msg.clear();\n");
			out.write("				return;\n");
			out.write("			}\n");
			out.write("		}\n");
			out.write("	}\n\n");
		}
		// write out the close to the class
		out.write("}\n");

		// done. close out the file
		out.close();
	}

	public void genParser(final FixMessageDom dom, final OutputStreamWriter out) throws Exception {

		// write package line
		out.write("package " + dom.packageName + ";\n\n");

		writeGeneratedFileHeader(out);

		// import ByteBuffer
		out.write("import java.nio.ByteBuffer;\n");
		out.write("import " + dom.packageNameBase + ".FixMessage;\n");
		out.write("import " + dom.packageNameBase + ".FixValidationError;\n");
		out.write("import " + dom.packageNameBase + ".FixInMessage;\n");
		out.write("import " + dom.packageNameBase + ".IFixSession;\n");
		out.write("import " + dom.packageNameBase + ".FixUtils;\n\n");
		out.write("import " + dom.packageNameBase + ".FixEvent;\n\n");

		// write out the open to the parser class
		out.write("public class " + dom.type + "MessageParser implements " + dom.type + "MessageInfo\n{\n\n");

		out.write("\tpublic FixMessagePool<FixMessage> fixMessagePool;\n\n");

		out.write("\tpublic FixMessageParser(FixMessagePool<FixMessage> fixMessagePool) {\n");
		out.write("\t\tthis.fixMessagePool = fixMessagePool;\n");
		out.write("\t}\n\n");

		out.write("\tpublic FixMessageParser() {\n");
		out.write("\t\tfixMessagePool = new FixMessagePool<FixMessage>();\n");
		out.write("\t}\n\n");

		

		// crack the msgType of message
		out.write("\tpublic void parse( ByteBuffer buf, FixValidationError err, " + dom.type + "MessageListener l )\n");
		out.write("\t{\n\n");
		out.write("\t\tparse( 0, buf, err, l );\n");
		out.write("\t}\n\n");

		
		
		out.write("\tpublic void parse( long connectorID, ByteBuffer buf, FixValidationError err, " + dom.type + "MessageListener l )\n");
		out.write("\t{\n\n");
		out.write("\t\tIFixSession session = null;\n");

		out.write("\t\tint msgType = FixInMessage.crackMsgType( buf ,err );\n");

		out.write("\t\t// garbled message\n");
		out.write("\t\tif (err.hasError() && ( err.getSessionRejectReason() == FixEvent.GARBLED || err.getSessionRejectReason() == FixEvent.DISCONNECT) ) { return; }\n\n");
		out.write("\t\telse if (err.hasError()) { l.onFixValidationError(err); return; }\n\n");

		out.write("        switch( msgType )\n");
		out.write("        {\n\n");

		for (final QuickFixMessage m : dom.quickFixMessages) {

			final String name = dom.type.toLowerCase() + m.name;
			out.write("\t\tcase MessageTypes." + m.name.toUpperCase() + "_INT:\n");
			out.write("\t\t\t" + capFirst(dom.type.toLowerCase()) + m.name + " " + name + " = fixMessagePool.get" + capFirst(dom.type.toLowerCase()) + m.name + "(buf, err);\n");
			if (m.name.equalsIgnoreCase("logon")) {
				out.write("\t\t\t" + name + ".getAll();  // TODO why do I have to do this?\n");
			} 
			out.write("\t\t\tsession = FixUtils.crackSession(l, connectorID, " + name + ", err);\n");

			if (m.name.equalsIgnoreCase("logon")) {
				out.write("\t\t\tif (session != null) { \n");
				out.write("\t\t\t\tsession.incrementInMsgSeqNum(" + uncapFirst(dom.type.toLowerCase()) + m.name + ", err);\n");
				out.write("\t\t\t}\n");
				out.write("\t\t\tif(err.hasError()) {\n");
				out.write("\t\t\t\tl.onFixValidationError(err);\n");
				out.write("\t\t\t} else {\n");
				out.write("\t\t\t\tl.on" + capFirst(dom.type.toLowerCase()) + m.name + "(" + name + ");\n");
				out.write("\t\t\t}\n");

			} else {
				out.write("\t\t\tif (session != null) { \n");
				out.write("\t\t\t\tsession.incrementInMsgSeqNum(" + uncapFirst(dom.type.toLowerCase()) + m.name + ", err);\n");
				out.write("\t\t\t\tif(err.hasError()) {\n");
				out.write("\t\t\t\t\tl.onFixValidationError(err);\n");
				out.write("\t\t\t\t} else {\n");
				out.write("\t\t\t\t\tl.on" + capFirst(dom.type.toLowerCase()) + m.name + "(" + name + ");\n");
				out.write("\t\t\t\t}\n");
				out.write("\t\t\t}\n");
			}
			
			out.write("\t\t\tfixMessagePool.return" + capFirst(dom.type.toLowerCase()) + m.name + " (" + name + ");\n");
			out.write("\t\t\tbreak;\n");
		}

		out.write("\t\tdefault:\n");
		out.write("\t\tl.onUnknownMessageType( buf, msgType );\n");
		out.write("\t\tbreak;\n\n");

		out.write("\t}\n");
		out.write("\t}\n");

		// write out the close to the parser class
		out.write("}\n");

		// done. close out the file
		out.close();
	}

	private void genTags(final FixMessageDom dom, final FileWriter out) throws IOException {
		// write package line
		out.write("package " + dom.packageName + ";\n\n");

		writeGeneratedFileHeader(out);

		out.write("import " + dom.packageNameBase + ".messaging.FixTags;\n\n");
		out.write("import " + dom.packageNameBase + ".FixUtils;\n\n");

		out.write("public class FixTags {\n\n");

		// write out each callback
		for (final QuickFixField f : dom.quickFixFields) {

			out.write("	public static final int " + f.name.toUpperCase() + "_INT = " + f.number + ";\n");
			out.write("	public static final byte[]  " + f.name.toUpperCase() + " = \"" + f.number + "\".getBytes();\n");
			if (f.length > 0)
				out.write("\t\tpublic static final int " + f.name.toUpperCase() + "_LENGTH = " + f.length + ";\n");
			else
				try {
					final String l = getJavaLength(f);
					out.write("\t\tpublic static final int " + f.name.toUpperCase() + "_LENGTH = " + l + ";\n");
				} catch (final Exception e) {
					// ignore
				}
			out.write("\n");
		}

		// write out the close to the interface
		out.write("}\n");

		// done. close out the file
		out.close();
	}

	private String getAsStringExpression(final String prefix, final String name, final String type) {
		switch (FixDataTypes.toInt(type)) {

			case FixDataTypes.STRING:
			case FixDataTypes.MULTIPLECHARVALUE:
			case FixDataTypes.MULTIPLESTRINGVALUE:
			case FixDataTypes.COUNTRY:
			case FixDataTypes.CURRENCY:
			case FixDataTypes.EXCHANGE:
			case FixDataTypes.MONTHYEAR:
			case FixDataTypes.UTCTIMESTAMP:
			case FixDataTypes.UTCTIMEONLY:
			case FixDataTypes.UTCDATEONLY:
			case FixDataTypes.LOCALMKTDATE:
			case FixDataTypes.TZTIMEONLY:
			case FixDataTypes.TZTIMESTAMP:
			case FixDataTypes.DATA:
			case FixDataTypes.XMLDATA:
			case FixDataTypes.LANGUAGE:
				return "new String( FixUtils.trim(" + prefix + "get" + capFirst(name) + "()) )";

			case FixDataTypes.FLOAT:
			case FixDataTypes.PRICE:
			case FixDataTypes.QTY:
			case FixDataTypes.PRICEOFFSET:
			case FixDataTypes.AMT:
			case FixDataTypes.PERCENTAGE:
				return prefix + "get" + capFirst(name) + "() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS";

			case FixDataTypes.CHAR:
			case FixDataTypes.INT:
			case FixDataTypes.LENGTH:
			case FixDataTypes.TAGNUM:
			case FixDataTypes.SEQNUM:
			case FixDataTypes.NUMINGROUP:
			case FixDataTypes.DAYOFMOUNTH:
			case FixDataTypes.BOOLEAN:
				return prefix + "get" + capFirst(name) + "()";

			default:
				throw new RuntimeException("No idea how to parse this field: " + prefix + name);
		}
	}

	private String getEqualExpression(final String name, final String type) {
		switch (FixDataTypes.toInt(type)) {

			case FixDataTypes.STRING:
			case FixDataTypes.MULTIPLECHARVALUE:
			case FixDataTypes.MULTIPLESTRINGVALUE:
			case FixDataTypes.COUNTRY:
			case FixDataTypes.CURRENCY:
			case FixDataTypes.EXCHANGE:
			case FixDataTypes.MONTHYEAR:
			case FixDataTypes.DATA:
			case FixDataTypes.XMLDATA:
			case FixDataTypes.LANGUAGE:
				return "FixUtils.equals(get" + capFirst(name) + "(), msg.get" + capFirst(name) + "())";

			case FixDataTypes.CHAR:
			case FixDataTypes.INT:
			case FixDataTypes.LENGTH:
			case FixDataTypes.TAGNUM:
			case FixDataTypes.SEQNUM:
			case FixDataTypes.NUMINGROUP:
			case FixDataTypes.DAYOFMOUNTH:
			case FixDataTypes.BOOLEAN:
			case FixDataTypes.FLOAT:
			case FixDataTypes.PRICE:
			case FixDataTypes.QTY:
			case FixDataTypes.PRICEOFFSET:
			case FixDataTypes.AMT:
			case FixDataTypes.PERCENTAGE:
				return "(get" + capFirst(name) + "()==msg.get" + capFirst(name) + "())";

			case FixDataTypes.UTCTIMESTAMP: // timestamps are ignored
			case FixDataTypes.UTCTIMEONLY:
			case FixDataTypes.UTCDATEONLY:
			case FixDataTypes.LOCALMKTDATE:
			case FixDataTypes.TZTIMEONLY:
			case FixDataTypes.TZTIMESTAMP:
				return "true";
			default:
				throw new RuntimeException("No idea how to parse this field: " + name);
		}
	}

	String getJavaLength(final QuickFixField f) {

		switch (FixDataTypes.toInt(f.type)) {

			// TODO more checks
			case FixDataTypes.STRING:
			case FixDataTypes.MULTIPLECHARVALUE:
			case FixDataTypes.MULTIPLESTRINGVALUE:
			case FixDataTypes.COUNTRY:
			case FixDataTypes.EXCHANGE:
			case FixDataTypes.MONTHYEAR:
			case FixDataTypes.UTCTIMEONLY:
			case FixDataTypes.UTCDATEONLY:
			case FixDataTypes.LOCALMKTDATE:
			case FixDataTypes.TZTIMEONLY:
			case FixDataTypes.TZTIMESTAMP:
			case FixDataTypes.DATA:
			case FixDataTypes.XMLDATA:
			case FixDataTypes.LANGUAGE: {
				if (f.length > 0)
					return String.valueOf(f.length);
				else if (f.name.toLowerCase().contains("text"))
					return "FixUtils.FIX_MAX_STRING_TEXT_LENGTH";
				else
					return "FixUtils.FIX_MAX_STRING_LENGTH";
			}

			case FixDataTypes.CURRENCY:
				return "FixUtils.CURRENCY_LENGTH";

			case FixDataTypes.UTCTIMESTAMP:
				return "FixUtils.UTCTIMESTAMP_LENGTH";

			default:
				throw new RuntimeException("No idea how to parse this field: " + f.name);
		}
	}

	String getJavaType(final QuickFixField f) {

		switch (FixDataTypes.toInt(f.type)) {

			case FixDataTypes.STRING:
			case FixDataTypes.MULTIPLECHARVALUE:
			case FixDataTypes.MULTIPLESTRINGVALUE:
			case FixDataTypes.COUNTRY:
			case FixDataTypes.CURRENCY:
			case FixDataTypes.EXCHANGE:
			case FixDataTypes.MONTHYEAR:
			case FixDataTypes.UTCTIMESTAMP:
			case FixDataTypes.UTCTIMEONLY:
			case FixDataTypes.UTCDATEONLY:
			case FixDataTypes.LOCALMKTDATE:
			case FixDataTypes.TZTIMEONLY:
			case FixDataTypes.TZTIMESTAMP:
			case FixDataTypes.DATA:
			case FixDataTypes.XMLDATA:
			case FixDataTypes.LANGUAGE:
				return "byte[]";

			case FixDataTypes.CHAR:
				return "byte";

			case FixDataTypes.INT:
			case FixDataTypes.LENGTH:
			case FixDataTypes.TAGNUM:
			case FixDataTypes.SEQNUM:
			case FixDataTypes.NUMINGROUP:
			case FixDataTypes.DAYOFMOUNTH:
				return "long";

			case FixDataTypes.FLOAT:
			case FixDataTypes.PRICE:
			case FixDataTypes.QTY:
			case FixDataTypes.PRICEOFFSET:
			case FixDataTypes.AMT:
			case FixDataTypes.PERCENTAGE:
				return "long";

			case FixDataTypes.BOOLEAN:
				return "boolean";

			default:
				throw new RuntimeException("No idea how to parse this field: " + f.name);
		}
	}

	String getJavaTypeNull(final QuickFixField f) {

		switch (FixDataTypes.toInt(f.type)) {

			case FixDataTypes.STRING:
			case FixDataTypes.MULTIPLECHARVALUE:
			case FixDataTypes.MULTIPLESTRINGVALUE:
			case FixDataTypes.COUNTRY:
			case FixDataTypes.CURRENCY:
			case FixDataTypes.EXCHANGE:
			case FixDataTypes.MONTHYEAR:
			case FixDataTypes.UTCTIMESTAMP:
			case FixDataTypes.UTCTIMEONLY:
			case FixDataTypes.UTCDATEONLY:
			case FixDataTypes.LOCALMKTDATE:
			case FixDataTypes.TZTIMEONLY:
			case FixDataTypes.TZTIMESTAMP:
			case FixDataTypes.DATA:
			case FixDataTypes.XMLDATA:
			case FixDataTypes.LANGUAGE:
				return "null";

			case FixDataTypes.CHAR:
				return "(byte)'0'";

			case FixDataTypes.INT:
			case FixDataTypes.LENGTH:
			case FixDataTypes.TAGNUM:
			case FixDataTypes.SEQNUM:
			case FixDataTypes.NUMINGROUP:
			case FixDataTypes.DAYOFMOUNTH:
				return "0";

			case FixDataTypes.FLOAT:
			case FixDataTypes.PRICE:
			case FixDataTypes.QTY:
			case FixDataTypes.PRICEOFFSET:
			case FixDataTypes.AMT:
			case FixDataTypes.PERCENTAGE:
				return "0";

			case FixDataTypes.BOOLEAN:
				return "false";

			default:
				throw new RuntimeException("No idea how to parse this field: " + f.name);
		}
	}

	/**
	 * @param keyTag
	 * @return
	 */
	private String getKeyTagForComponent(final FixMessageDom dom, final String name) {

		final QuickFixField f = dom.quickFixNamedFields.get(name);
		if (f == null) {
			final QuickFixComponent cc = dom.quickFixNamedComponents.get(name);
			final QuickFixField ff = dom.quickFixNamedFields.get(cc.keyTag);
			if (ff == null) {
				final QuickFixComponent ccc = dom.quickFixNamedComponents.get(cc.keyTag);
				return ccc.keyTag;
			} else
				return ff.name;
		} else
			return f.name;

	}

	/**
	 * @param type
	 * @return
	 */
	private boolean isPartOfEqualCopmarison(final String type) {
		switch (FixDataTypes.toInt(type)) {
			case FixDataTypes.UTCTIMESTAMP: // timestamps are ignored
			case FixDataTypes.UTCTIMEONLY:
			case FixDataTypes.UTCDATEONLY:
			case FixDataTypes.LOCALMKTDATE:
			case FixDataTypes.TZTIMEONLY:
			case FixDataTypes.TZTIMESTAMP:
				return false;
			default:
				return true;
		}
	}

	private void printEquals(final OutputStreamWriter out, final ArrayList<QuickFixField> fields) throws IOException {
		for (final QuickFixField f : fields) {
			if (f.name.equalsIgnoreCase("BodyLength") || f.name.equalsIgnoreCase("CheckSum")) continue;
			out.write("		if ((has" + capFirst(f.name) + "() && !msg.has" + capFirst(f.name) + "()) ||" + " (!has" + capFirst(f.name) + "() && msg.has" + capFirst(f.name) + "())) return false;\n");
			if (isPartOfEqualCopmarison(f.type)) {
				out.write("		if (!(!has" + capFirst(f.name) + "() && !msg.has" + capFirst(f.name) + "()) ");
				out.write("&& !" + getEqualExpression(uncapFirst(f.name), f.type));
				out.write(") return false;\n");
			}
		}
		out.write("		return true;\n");
	}

	private String printToString(final ArrayList<QuickFixField> fields, final String prefix) {
		String s = "";
		for (final QuickFixField f : fields)
			s += "\t\tif (" + prefix + "has" + f.name + "()) s += \"" + f.name + "(" + f.number + ")= \" + " + getAsStringExpression(prefix, uncapFirst(f.name), f.type) + " + \"\\n\" ; \n";
		return s;
	}

	/**
	 * @param dom
	 * @param out
	 * @param components
	 * @param isMessage
	 * @throws IOException
	 */
	private void processTags(final FixMessageDom dom, final OutputStreamWriter out, final ArrayList<QuickFixComponent> components, final boolean isMessage) throws IOException {
		String start = "if";
		String end = "else { return tag; }";
		if (isMessage) {
			start = "} else if";
			end = "else {";
		}
		for (final QuickFixComponent cc : components) {
			final QuickFixComponent c = dom.quickFixNamedComponents.get(cc.name);
			if (c.isRepeating) {
				out.write("        			" + start + " ( tag == FixTags." + c.noInGroupTag.toUpperCase() + "_INT ) {\n");
				out.write("        				int count = 0;\n");
				out.write("        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);\n");
				out.write("        				if (err.hasError()) break;\n\n");
				out.write("        				int repeatingGroupTag = FixMessage.getTag(buf, err);\n");
				out.write("        				if (err.hasError()) break;\n");
				out.write("        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, \"no in group count exceeding max\", tag);\n");
				if (components.size() == 0 || isMessage)
					out.write("        							return; }\n");
				else
					out.write("        							return repeatingGroupTag; }\n");
				out.write("        				while ( count < noInGroupNumber ) {\n");
				out.write("        					if ( !" + uncapFirst(c.name) + "[count].isKeyTag(repeatingGroupTag) ) {\n");
				out.write("        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, \"no in group tag missing\", repeatingGroupTag);\n");
				if (components.size() == 0 || isMessage)
					out.write("        						return;\n");
				else
					out.write("        						return repeatingGroupTag;\n");
				out.write("        					}\n");
				out.write("        					count++;\n");
				out.write("        					repeatingGroupTag = " + uncapFirst(c.name) + "[count].setBuffer( repeatingGroupTag, buf, err);	\n");
				out.write("        					if (err.hasError()) break; 		\n");
				out.write("        				}\n");
				out.write("        				if (err.hasError()) break;\n");
				out.write("                		else { tag = repeatingGroupTag; continue; }\n");
			} else {
				out.write("        			" + start + " ( " + uncapFirst(c.name) + ".isKeyTag(tag)) {\n");
				out.write("        				tag = " + uncapFirst(c.name) + ".setBuffer( tag, buf, err);		\n");
				out.write("            			if (err.hasError()) break; 		\n");
				out.write("                		else continue;		\n");
			}
			start = "} else if";
		}
		if (isMessage || components.size() > 0)
			out.write("            		} " + end + "\n");
		else if (components.size() > 0)
			out.write("            		" + end + "\n\n");
		else
			out.write("            		return tag;\n\n");
	}

	private void setFieldByteArrayValue(final QuickFixField f, final OutputStreamWriter out) throws IOException {

		switch (FixDataTypes.toInt(f.type)) {

			case FixDataTypes.STRING:
			case FixDataTypes.MULTIPLECHARVALUE:
			case FixDataTypes.MULTIPLESTRINGVALUE:
			case FixDataTypes.COUNTRY:
			case FixDataTypes.CURRENCY:
			case FixDataTypes.EXCHANGE:
			case FixDataTypes.MONTHYEAR:
			case FixDataTypes.UTCTIMESTAMP:
			case FixDataTypes.UTCTIMEONLY:
			case FixDataTypes.UTCDATEONLY:
			case FixDataTypes.LOCALMKTDATE:
			case FixDataTypes.TZTIMEONLY:
			case FixDataTypes.TZTIMESTAMP:
			case FixDataTypes.DATA:
			case FixDataTypes.XMLDATA:
			case FixDataTypes.LANGUAGE:
				out.write("		FixUtils.copy(" + uncapFirst(f.name) + ", src); 		\n");
				break;

			case FixDataTypes.CHAR:
				out.write("		" + uncapFirst(f.name) + " = src[0];		\n");
				break;

			case FixDataTypes.INT:
			case FixDataTypes.LENGTH:
			case FixDataTypes.TAGNUM:
			case FixDataTypes.SEQNUM:
			case FixDataTypes.NUMINGROUP:
			case FixDataTypes.DAYOFMOUNTH:
			case FixDataTypes.FLOAT:
			case FixDataTypes.PRICE:
			case FixDataTypes.QTY:
			case FixDataTypes.PRICEOFFSET:
			case FixDataTypes.AMT:
			case FixDataTypes.PERCENTAGE:
				out.write("		" + uncapFirst(f.name) + " = FixUtils.longValueOf(src, 0, src.length);\n");
				break;

			case FixDataTypes.BOOLEAN:
				out.write("		" + uncapFirst(f.name) + " = src[0]==(byte)'Y'?true:false;		\n");
				break;

			default:
				throw new RuntimeException("No idea how to parse this field: " + f.name);
		}

	}

	private void writeEnum(final OutputStreamWriter out, final QuickFixField f, final QuickFixValue v) throws IOException {

		switch (FixDataTypes.toInt(f.type)) {

			case FixDataTypes.STRING:
			case FixDataTypes.MULTIPLECHARVALUE:
			case FixDataTypes.MULTIPLESTRINGVALUE:
			case FixDataTypes.COUNTRY:
			case FixDataTypes.CURRENCY:
			case FixDataTypes.EXCHANGE:
			case FixDataTypes.MONTHYEAR:
			case FixDataTypes.UTCTIMESTAMP:
			case FixDataTypes.UTCTIMEONLY:
			case FixDataTypes.UTCDATEONLY:
			case FixDataTypes.LOCALMKTDATE:
			case FixDataTypes.TZTIMEONLY:
			case FixDataTypes.TZTIMESTAMP:
			case FixDataTypes.DATA:
			case FixDataTypes.XMLDATA:
			case FixDataTypes.LANGUAGE:
				out.write("\t\t\tpublic static final byte[] " + v.description + " = \"" + v.fixEnum + "\".getBytes();\n");
				break;

			case FixDataTypes.CHAR:
				out.write("\t\t\tpublic static final byte " + v.description + " = \'" + v.fixEnum + "\';\n");
				break;

			case FixDataTypes.INT:
			case FixDataTypes.LENGTH:
			case FixDataTypes.TAGNUM:
			case FixDataTypes.SEQNUM:
			case FixDataTypes.NUMINGROUP:
			case FixDataTypes.DAYOFMOUNTH:
			case FixDataTypes.FLOAT:
			case FixDataTypes.PRICE:
			case FixDataTypes.QTY:
			case FixDataTypes.PRICEOFFSET:
			case FixDataTypes.AMT:
			case FixDataTypes.PERCENTAGE:
				out.write("\t\t\tpublic static final long " + v.description + " = " + v.fixEnum + ";\n");
				break;

			case FixDataTypes.BOOLEAN:
				out.write("\t\t\tpublic static final boolean " + v.description + " = " + (v.fixEnum.equals("Y") ? "true" : "false") + ";\n");
				break;

			default:
				throw new RuntimeException("No idea how to parse this field: " + f.name);
		}

	}

	public void writeGeneratedFileHeader(final OutputStreamWriter out) throws IOException {

		out.write("// DO NOT EDIT!!!\n");
		out.write("// This file is generated by FixMessageGenerator.\n");
		out.write("// If you need additional functionality, put it in a helper class\n");
		out.write("// that does not live in this folder!!!  Any java file in this folder \n");
		out.write("// will be deleted upon the next run of the FixMessageGenerator!\n\n");
	}

	private void zeroField(final QuickFixField f, final OutputStreamWriter out) throws IOException {

		switch (FixDataTypes.toInt(f.type)) {

			case FixDataTypes.STRING:
			case FixDataTypes.MULTIPLECHARVALUE:
			case FixDataTypes.MULTIPLESTRINGVALUE:
			case FixDataTypes.COUNTRY:
			case FixDataTypes.CURRENCY:
			case FixDataTypes.EXCHANGE:
			case FixDataTypes.MONTHYEAR:
			case FixDataTypes.UTCTIMESTAMP:
			case FixDataTypes.UTCTIMEONLY:
			case FixDataTypes.UTCDATEONLY:
			case FixDataTypes.LOCALMKTDATE:
			case FixDataTypes.TZTIMEONLY:
			case FixDataTypes.TZTIMESTAMP:
			case FixDataTypes.DATA:
			case FixDataTypes.XMLDATA:
			case FixDataTypes.LANGUAGE:
				out.write("		if (has" + capFirst(f.name) + "()) FixUtils.fillNul(" + uncapFirst(f.name) + ");		\n");
				break;

			case FixDataTypes.CHAR:
				out.write("		if (has" + capFirst(f.name) + "()) " + uncapFirst(f.name) + " = (byte)' ';		\n");
				break;

			case FixDataTypes.INT:
			case FixDataTypes.LENGTH:
			case FixDataTypes.TAGNUM:
			case FixDataTypes.SEQNUM:
			case FixDataTypes.NUMINGROUP:
			case FixDataTypes.DAYOFMOUNTH:
			case FixDataTypes.FLOAT:
			case FixDataTypes.PRICE:
			case FixDataTypes.QTY:
			case FixDataTypes.PRICEOFFSET:
			case FixDataTypes.AMT:
			case FixDataTypes.PERCENTAGE:
				out.write("		if (has" + capFirst(f.name) + "()) " + uncapFirst(f.name) + " = FixUtils.TAG_HAS_NO_VALUE;		\n");
				break;

			case FixDataTypes.BOOLEAN:
				out.write("		if (has" + capFirst(f.name) + "()) " + uncapFirst(f.name) + " = false;		\n");
				break;

			default:
				throw new RuntimeException("No idea how to parse this field: " + f.name);
		}

	}

}