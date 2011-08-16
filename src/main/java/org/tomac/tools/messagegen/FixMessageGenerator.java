package org.tomac.tools.messagegen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.tomac.protocol.fix.FixGarbledException;
import org.tomac.protocol.fix.FixSessionException;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.fix42nordic.FixMessageInfo;
import org.tomac.protocol.fix.messaging.fix42nordic.FixTags;
import org.tomac.protocol.fix.messaging.fix42nordic.FixMessageInfo.MsgTypes;
import org.tomac.tools.messagegen.FixMessageDom.DomFixField;
import org.tomac.tools.messagegen.FixMessageDom.DomFixField.DomFixValue;
import org.tomac.tools.messagegen.FixMessageDom.DomFixMessage;
import org.tomac.utils.Utils;


public class FixMessageGenerator {
	
	// static include strings, allowing for cahnging the import libraries.
	private static String strInByteBuffer = "import java.nio.ByteBuffer;";
	private static String strOutByteBuffer = "";
	private static String strUtils = "import org.tomac.utils.Utils;";
	private static String strFixUtils = "import org.tomac.protocol.fix.FixUtils;";
	private static String strOtherUtils = "";
	private static String strFixException = "import org.tomac.protocol.fix.FixSessionException;";
	private static String strFixGarbledException = "import org.tomac.protocol.fix.FixGarbledException;";
	private static String strConstants = "import org.tomac.protocol.fix.FixConstants;";
	private static String strBaseUtils = "";
	
	private static String strReadableByteBuffer = "ByteBuffer";
	private static String strWritableByteBuffer = "ByteBuffer";
	private static String strUtil = "Utils";
	private static String strOtherUtil = "Utils";

	
	private static String capFirst(final String s) {
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

	static FixMessageDom fixLoadAndValidate(final File specFile) throws Exception {
		final FixMessageDom fixDom = new FixMessageDom();

		final SAXReader reader = new SAXReader();
		final Document doc = reader.read(specFile);

		fixDom.buildFrom(doc.getRootElement());

		return fixDom;
	}

	private static int getMsgTypeTagAsInt(final byte[] b, final int length) {
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

	private static String uncapFirst(final String s) {
		return s.substring(0, 1).toLowerCase() + s.substring(1);
	}

	private void clearField(DomFixField f, BufferedWriter out) throws Exception {
		
		switch (FixMessageDom.toInt(f.type)) {

		case FixMessageDom.STRING:
		case FixMessageDom.MULTIPLECHARVALUE:
		case FixMessageDom.MULTIPLESTRINGVALUE:
		case FixMessageDom.COUNTRY:
		case FixMessageDom.CURRENCY:
		case FixMessageDom.EXCHANGE:
		case FixMessageDom.MONTHYEAR:
		case FixMessageDom.UTCTIMESTAMP:
		case FixMessageDom.UTCTIMEONLY:
		case FixMessageDom.UTCDATEONLY:
		case FixMessageDom.LOCALMKTDATE:
		case FixMessageDom.TZTIMEONLY:
		case FixMessageDom.TZTIMESTAMP:
		case FixMessageDom.DATA:
		case FixMessageDom.XMLDATA:
		case FixMessageDom.LANGUAGE:
			out.write("\t\t" + strUtil + ".fill( " + uncapFirst(f.name) + ", (byte)0 );\n");
			break;

		case FixMessageDom.CHAR:
			out.write("\t\t" + uncapFirst(f.name) + " = Byte.MAX_VALUE;		\n");
			break;

		case FixMessageDom.INT:
		case FixMessageDom.LENGTH:
		case FixMessageDom.TAGNUM:
		case FixMessageDom.SEQNUM:
		case FixMessageDom.NUMINGROUP:
		case FixMessageDom.DAYOFMOUNTH:
			out.write("\t\t" + uncapFirst(f.name) + " = Long.MAX_VALUE;		\n");
			break;

		case FixMessageDom.FLOAT:
		case FixMessageDom.PRICE:
		case FixMessageDom.QTY:
		case FixMessageDom.PRICEOFFSET:
		case FixMessageDom.AMT:
		case FixMessageDom.PERCENTAGE:
			out.write("\t\t" + uncapFirst(f.name) + " = Long.MAX_VALUE;		\n");
			break;

		case FixMessageDom.BOOLEAN:
			out.write("\t\t" + uncapFirst(f.name) + " = false;		\n");
			break;

		default:
			throw new RuntimeException("No idea how to parse this field: " + f.name);
		}
	}

	private void allocateField(final DomFixField f, final BufferedWriter out) throws IOException {

		switch (FixMessageDom.toInt(f.type)) {

			case FixMessageDom.STRING:
			case FixMessageDom.MULTIPLECHARVALUE:
			case FixMessageDom.MULTIPLESTRINGVALUE:
			case FixMessageDom.COUNTRY:
			case FixMessageDom.CURRENCY:
			case FixMessageDom.EXCHANGE:
			case FixMessageDom.MONTHYEAR:
			case FixMessageDom.UTCTIMESTAMP:
			case FixMessageDom.UTCTIMEONLY:
			case FixMessageDom.UTCDATEONLY:
			case FixMessageDom.LOCALMKTDATE:
			case FixMessageDom.TZTIMEONLY:
			case FixMessageDom.TZTIMESTAMP:
			case FixMessageDom.DATA:
			case FixMessageDom.XMLDATA:
			case FixMessageDom.LANGUAGE:
				out.write("\t\t" + uncapFirst(f.name) + " = new byte[" + getJavaLength(f) + "];\n");
				break;
		}
	}	
	private void declareField(final DomFixField f, final BufferedWriter out) throws IOException {

		switch (FixMessageDom.toInt(f.type)) {

			case FixMessageDom.STRING:
			case FixMessageDom.MULTIPLECHARVALUE:
			case FixMessageDom.MULTIPLESTRINGVALUE:
			case FixMessageDom.COUNTRY:
			case FixMessageDom.CURRENCY:
			case FixMessageDom.EXCHANGE:
			case FixMessageDom.MONTHYEAR:
			case FixMessageDom.UTCTIMESTAMP:
			case FixMessageDom.UTCTIMEONLY:
			case FixMessageDom.UTCDATEONLY:
			case FixMessageDom.LOCALMKTDATE:
			case FixMessageDom.TZTIMEONLY:
			case FixMessageDom.TZTIMESTAMP:
			case FixMessageDom.DATA:
			case FixMessageDom.XMLDATA:
			case FixMessageDom.LANGUAGE:
				out.write("\tpublic byte[] " + uncapFirst(f.name) + ";\n");
				break;

			case FixMessageDom.CHAR:
				out.write("\tpublic byte " + uncapFirst(f.name) + " = (byte)' ';\n");
				break;

			case FixMessageDom.INT:
			case FixMessageDom.LENGTH:
			case FixMessageDom.TAGNUM:
			case FixMessageDom.SEQNUM:
			case FixMessageDom.NUMINGROUP:
			case FixMessageDom.DAYOFMOUNTH:
				out.write("\tpublic long " + uncapFirst(f.name) + " = 0;\n");
				break;

			case FixMessageDom.FLOAT:
			case FixMessageDom.PRICE:
			case FixMessageDom.QTY:
			case FixMessageDom.PRICEOFFSET:
			case FixMessageDom.AMT:
			case FixMessageDom.PERCENTAGE:
				out.write("\tpublic long " + uncapFirst(f.name) + " = 0;\n");
				break;

			case FixMessageDom.BOOLEAN:
				out.write("\tpublic boolean " + uncapFirst(f.name) + " = false;\n");
				break;

			default:
				throw new RuntimeException("No idea how to parse this field: " + f.name);
		}
	}

	private void decodeFieldValue(final DomFixField f, final BufferedWriter out) throws IOException {

 		out.write("\t\t\t\t" + uncapFirst(f.name) + " = ");

		switch (FixMessageDom.toInt(f.type)) {

			case FixMessageDom.STRING:
			case FixMessageDom.MULTIPLECHARVALUE:
			case FixMessageDom.MULTIPLESTRINGVALUE:
			case FixMessageDom.COUNTRY:
			case FixMessageDom.CURRENCY:
			case FixMessageDom.EXCHANGE:
			case FixMessageDom.MONTHYEAR:
			case FixMessageDom.UTCTIMESTAMP:
			case FixMessageDom.UTCTIMEONLY:
			case FixMessageDom.UTCDATEONLY:
			case FixMessageDom.LOCALMKTDATE:
			case FixMessageDom.TZTIMEONLY:
			case FixMessageDom.TZTIMESTAMP:
			case FixMessageDom.DATA:
			case FixMessageDom.XMLDATA:
			case FixMessageDom.LANGUAGE:
				out.write("FixUtils.getTagStringValue(value, " + uncapFirst(f.name) + ")");
				break;

			case FixMessageDom.INT:
			case FixMessageDom.LENGTH:
			case FixMessageDom.TAGNUM:
			case FixMessageDom.SEQNUM:
			case FixMessageDom.NUMINGROUP:
			case FixMessageDom.DAYOFMOUNTH:
				out.write("FixUtils.getTagIntValue( value )");
				break;
			case FixMessageDom.FLOAT:
			case FixMessageDom.PRICE:
			case FixMessageDom.QTY:
			case FixMessageDom.PRICEOFFSET:
			case FixMessageDom.AMT:
			case FixMessageDom.PERCENTAGE:
				out.write("FixUtils.getTagFloatValue(value)");
				break;
			case FixMessageDom.CHAR:
				out.write("FixUtils.getTagCharValue( value )");
				break;
			case FixMessageDom.BOOLEAN:
				out.write("FixUtils.getTagBooleanValue( value )");
				break;
			default:
				throw new RuntimeException("No idea how to parse this field: " + f.name);
		}
		
 		out.write(";\n");

	}	
	
	private void encodeTagField(final DomFixField f, final BufferedWriter out) throws IOException {
		String chk = "";
		
		switch (FixMessageDom.toInt(f.type)) {

			case FixMessageDom.STRING:
			case FixMessageDom.MULTIPLECHARVALUE:
			case FixMessageDom.MULTIPLESTRINGVALUE:
			case FixMessageDom.COUNTRY:
			case FixMessageDom.CURRENCY:
			case FixMessageDom.EXCHANGE:
			case FixMessageDom.DATA:
			case FixMessageDom.XMLDATA:
			case FixMessageDom.LANGUAGE:
				if (printIsSetCheck(f) != null) chk = "if (" + printIsSetCheck(f) + ") ";
				out.write("\t\t" + chk + "FixUtils.putFixTag( out, FixTags." + f.name.toUpperCase() + "_INT, " + uncapFirst(f.name) + ", 0, Utils.lastIndexTrim(" + uncapFirst(f.name) + ", (byte)0) );\n");
				break;

			case FixMessageDom.CHAR:
				if (printIsSetCheck(f) != null) chk = "if (" + printIsSetCheck(f) + ") ";
				out.write("\t\t" + chk + "FixUtils.putFixTag( out, FixTags." + f.name.toUpperCase() + "_INT, " + uncapFirst(f.name) + " );\n");
				break;

			case FixMessageDom.MONTHYEAR:
			case FixMessageDom.UTCTIMESTAMP: // TODO currently this is the only one that works, and the only one used.
			case FixMessageDom.UTCTIMEONLY:
			case FixMessageDom.UTCDATEONLY: 
			case FixMessageDom.LOCALMKTDATE: 
			case FixMessageDom.TZTIMEONLY:
			case FixMessageDom.TZTIMESTAMP:
				if (printIsSetCheck(f) != null) chk = "if (" + printIsSetCheck(f) + ") ";
				out.write("\t\t" + chk + "FixUtils.putFixTag( out, FixTags." + f.name.toUpperCase() + "_INT, " + uncapFirst(f.name) + ");\n");
				break;

			case FixMessageDom.INT:
			case FixMessageDom.LENGTH:
			case FixMessageDom.TAGNUM:
			case FixMessageDom.SEQNUM:
			case FixMessageDom.NUMINGROUP:
			case FixMessageDom.DAYOFMOUNTH:
			case FixMessageDom.AMT:
				if (printIsSetCheck(f) != null) chk = "if (" + printIsSetCheck(f) + ") ";
				out.write("\t\t" + chk + "FixUtils.putFixTag( out, FixTags." + f.name.toUpperCase() + "_INT, " + uncapFirst(f.name) + ");\n");
				break;

			case FixMessageDom.FLOAT:
			case FixMessageDom.PRICE:
			case FixMessageDom.PRICEOFFSET:
			case FixMessageDom.PERCENTAGE:
			case FixMessageDom.QTY:
				if (printIsSetCheck(f) != null) chk = "if (" + printIsSetCheck(f) + ") ";
				out.write("\t\t" + chk + "FixUtils.putFixFloatTag( out, FixTags." + f.name.toUpperCase() + "_INT, " + uncapFirst(f.name) + ");\n");
				break;

			case FixMessageDom.BOOLEAN:
				if (printIsSetCheck(f) != null) chk = "if (" + printIsSetCheck(f) + ") ";
				out.write("\t\t" + chk + "FixUtils.putFixTag( out, FixTags." + f.name.toUpperCase() + "_INT, " + uncapFirst(f.name) + "?(byte)'Y':(byte)'N' );\n");
				break;

			default:
				throw new RuntimeException("No idea how to parse this field: " + f.name);
		}
		
	}
	
	private void printTagField(final DomFixField f, final BufferedWriter out) throws IOException {
		String chk = "";
		
		switch (FixMessageDom.toInt(f.type)) {

		case FixMessageDom.STRING:
		case FixMessageDom.MULTIPLECHARVALUE:
		case FixMessageDom.MULTIPLESTRINGVALUE:
		case FixMessageDom.COUNTRY:
		case FixMessageDom.CURRENCY:
		case FixMessageDom.EXCHANGE:
		case FixMessageDom.MONTHYEAR:
		case FixMessageDom.UTCTIMESTAMP:
		case FixMessageDom.UTCTIMEONLY:
		case FixMessageDom.UTCDATEONLY:
		case FixMessageDom.LOCALMKTDATE:
		case FixMessageDom.TZTIMEONLY:
		case FixMessageDom.TZTIMESTAMP:
		case FixMessageDom.DATA:
		case FixMessageDom.XMLDATA:
		case FixMessageDom.LANGUAGE:
			if (printIsSetCheck(f) != null) chk = "if (" + printIsSetCheck(f) + ")";
			out.write("\t\t\t" + chk + " s += \"" + f.name + "(" + f.number + ")=\" + new String(" + uncapFirst(f.name) + ") + sep;\n");
			break;
			
		case FixMessageDom.CHAR:
			if (printIsSetCheck(f) != null) chk = "if (" + printIsSetCheck(f) + ")";
			out.write("\t\t\t" + chk + " s += \"" + f.name + "(" + f.number + ")=\" + String.valueOf(" + uncapFirst(f.name) + ") + sep;\n");
			break;

		case FixMessageDom.INT:
		case FixMessageDom.LENGTH:
		case FixMessageDom.TAGNUM:
		case FixMessageDom.SEQNUM:
		case FixMessageDom.NUMINGROUP:
		case FixMessageDom.DAYOFMOUNTH:
		case FixMessageDom.FLOAT:
		case FixMessageDom.PRICE:
		case FixMessageDom.QTY:
		case FixMessageDom.PRICEOFFSET:
		case FixMessageDom.AMT:
		case FixMessageDom.PERCENTAGE:
			if (printIsSetCheck(f) != null) chk = "if (" + printIsSetCheck(f) + ")";
			out.write("\t\t\t" + chk + " s += \"" + f.name + "(" + f.number + ")=\" + String.valueOf(" + uncapFirst(f.name) + ") + sep;\n");
			break;

		case FixMessageDom.BOOLEAN:
			if (printIsSetCheck(f) != null) chk = "if (" + printIsSetCheck(f) + ")";
			out.write("\t\t\t" + chk + " s += \"" + f.name + "(" + f.number + ")=\" + String.valueOf(" + uncapFirst(f.name) + ") + sep;\n");
			break;

		default:
			throw new RuntimeException("No idea how to parse this field: " + f.name);
		}
	}		
	
	private String printIsSetCheck(DomFixField f) {
		
		if (f.reqd.equals("Y")) return null;

		return "FixUtils.isSet(" + uncapFirst(f.name) + ")";
	}

	private void genConstants(final FixMessageDom dom, final BufferedWriter out) throws Exception {
		String unknown = "U0";
		
		// write package line
		out.write("package " + dom.packageName + ";\n\n");

		writeGeneratedFileHeader(out);

		out.write(strUtils + "\n\n");

		out.write("public interface " + dom.type + "MessageInfo\n");
		out.write("{\n\n");
		final String servicepack = Integer.valueOf(dom.major) > 4 ? "SP" + dom.servicepack : "";
		if (Integer.valueOf(dom.major) < 5) {
			out.write("\tpublic static final byte[] BEGINSTRING_VALUE = \"" + dom.type.toUpperCase() + "." + dom.major + "." + dom.minor + servicepack + "\".getBytes();\n");
			out.write("\tpublic static final byte[] BEGINSTRING_VALUE_WITH_TAG = \"8=" + dom.type.toUpperCase() + "." + dom.major + "." + dom.minor + servicepack + "\u0001\".getBytes();\n");
		} else {
			out.write("\tpublic static final byte[] BEGINSTRING_VALUE = \"FIXT.1.1\".getBytes();\n");
			out.write("\tpublic static final byte[] BEGINSTRING_VALUE_WITH_TAG = \"8=FIXT.1.1\u0001\".getBytes();\n");
		}
		out.write("\tpublic static final byte[] FLAVOUR = \"" + dom.flavour + "\".getBytes();\n");
		out.write("\tpublic static final byte SOH = ( byte )0x01;\n");
		out.write("\tpublic static final byte EQUALS = ( byte )'=';\n");
		out.write("\tpublic static final byte DECIMAL = ( byte )'.';\n\n");

		out.write("\tpublic static class MsgTypes\n");
		out.write("\t{\n");

		out.write("\t\tpublic static final byte[] UNKNOWN = \""+ unknown + "\".getBytes();\n");
		for (final DomFixMessage m : dom.domFixMessages) {
			final String name = m.name.toUpperCase();
			out.write("\t\tpublic static final byte[] " + name + " = \"" + m.msgtype + "\".getBytes();\n");
		}
		out.write("\n");

		out.write("\t\tpublic static final int UNKNOWN_INT = " + getMsgTypeTagAsInt(unknown.getBytes(), unknown.getBytes().length) + ";\n");
		for (final DomFixMessage m : dom.domFixMessages) {
			final String msgType = m.msgtype + (m.msgsubtype.length() > 0 ? m.msgsubtype : "");
			final int tmp = getMsgTypeTagAsInt(msgType.getBytes(), msgType.getBytes().length);
			out.write("\t\tpublic static final int "+ m.name.toUpperCase() + "_INT = " + tmp + ";\n");
		}
		
		out.write("\t}\n\n");

		for (final DomFixField f : dom.domFixFields)
			if (f.domFixValues.size() > 0) {
				out.write("\tpublic static class " + f.name + " {\n");

				for (final DomFixValue v : f.domFixValues)
					writeEnum(out, f, v);

				out.write("\t\tpublic static boolean isValid(" + getJavaType(f) + " val) {\n");
				for (final DomFixValue v : f.domFixValues) {
					out.write("\t\t\tif (" + getEqualExpression(v.description, f.type, "val"));
					out.write(") return true;\n");
				}
				out.write("\t\t\treturn false;\n");
				out.write("\t\t}\n");
				
				out.write("\t}\n\n");
			}

		out.write("}\n");

		// done. close out the file
		out.close();
	}

	private void generate(final FixMessageDom dom, final File outputDir) throws Exception {

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

		genTags(dom, new BufferedWriter((new FileWriter(f))));

		// generate the constants
		f = new File(packageDir, dom.type + "MessageInfo.java");

		genConstants(dom, new BufferedWriter(new FileWriter(f)));

		// generate the generated base message
		f = new File(packageDir, dom.type + "GeneratedBaseMessage.java");

		genBaseMessage(dom, new BufferedWriter(new FileWriter(f)));

		// generate the fix message
		f = new File(packageDir, dom.type + "Message.java");

		genFixMessage(dom, new BufferedWriter(new FileWriter(f), 8 * 1024));

		// generate the messages
		for (final DomFixMessage m : dom.domFixMessages) {

			f = new File(packageDir, dom.type + m.name + ".java");

			genMessage(m, dom, new BufferedWriter(new FileWriter(f)));

		}

		// generate a listener interface
		f = new File(packageDir, dom.type + "MessageListener.java");

		genListenerInterface(dom, new BufferedWriter(new FileWriter(f)));

		// generate a parser
		f = new File(packageDir, dom.type + "MessageParser.java");

		genParser(dom, new BufferedWriter(new FileWriter(f)));
	}

	private void genFixMessage(FixMessageDom dom, final BufferedWriter out) throws Exception 
	{
		
		// write package line
		out.write("package " + dom.packageName + ";\n\n");

		writeGeneratedFileHeader(out);

		// import ByteBuffer
		out.write(strInByteBuffer + "\n");
		out.write(strOutByteBuffer + "\n");
		out.write(strFixUtils + "\n");
		out.write(strFixException + "\n");
		out.write(strFixGarbledException + "\n");
		out.write(strUtils + "\n\n");
		out.write(strOtherUtils + "\n\n");
		
		// write out the open to the interface
		out.write("public abstract class FixMessage extends FixGeneratedBaseMessage\n{\n\n");
		
		out.write("\tpublic static boolean IGNORE_CHECKSUM = false;\n\n");
		out.write("\tprivate int msgTypeEnd;\n");
		out.write("\tint msgEnd = 0;\n\n");
		
		for (DomFixField f : dom.domFixTrailer.fields )
			declareField(f, out);
		for (DomFixField f : dom.domFixHeader.fields ) {
			if (f.name.equals("MsgType")) continue;
			declareField(f, out);
		}
		
		out.write("\t\n");
		out.write("\tprivate static byte[] tmpMsgType = new byte[4];\n");
		out.write("\tprivate static byte[] tmpBeginString = new byte[7];\n\n");

		out.write("\t/**\n");
		out.write("\t * crackMsgType performs a garbled check on the fix message. \n");
		out.write("\t * @param data\n");
		out.write("\t * @return msgType as an int.\n");
		out.write("\t * @throws FixSessionException\n");
		out.write("\t */\n");
		out.write("\tpublic static int crackMsgType( " + strReadableByteBuffer + " buf ) throws FixSessionException, FixGarbledException {\n");
		out.write("\t\tint startPos;\n");
		out.write("\t\tint checkSum;\n");
		out.write("\t\tint msgType = MsgTypes.UNKNOWN_INT;\n\n");
		
		genGetMsgType(dom, out, true);
		
		out.write("\t\treturn msgType;\n");
		out.write("\t}\n");
    
		out.write("\tpublic FixMessage() {\n");
		out.write("\t\tsuper();\n\n");
		for (DomFixField f : dom.domFixTrailer.fields )
			allocateField(f, out);
		for (DomFixField f : dom.domFixHeader.fields ) {
			if (f.name.equals("MsgType")) continue;
			allocateField(f, out);
		}
		out.write("\n\n");
		out.write("	}\n\n");
		
		out.write("\t@Override\n");
		out.write("\tpublic void clear()\n");
		out.write("\t{\n\n");

		out.write("\t\t// clear out all the fields that aren't msgType\n\n");
		for (DomFixField f : dom.domFixTrailer.fields )
			clearField(f, out);
		for (DomFixField f : dom.domFixHeader.fields ) {
			if (f.name.equals("MsgType")) continue;
			clearField(f, out);
		}

		out.write("\t}\n\n");

		out.write("\t/**\n");
		out.write("\t * getAll performs stateless session level message validations. Throws a FixSessionException if this fails \n");
		out.write("\t */\n");
		out.write("\t@Override\n");
		out.write("\tpublic void getAll() throws FixSessionException, FixGarbledException\n");
		out.write("\t{\n\n");
		
 		genGetMsgType(dom, out, false);

 		out.write("\t\t// assumption message is full otherwise decode would return null\n");
 		out.write("\t\t// so negative id means that we are at the end of the message\n");
 		out.write("\t\tint id;\n");
 		out.write("\t\tbuf.position(msgTypeEnd);\n");
 		out.write("\t\tint lastTagPosition = msgTypeEnd;\n");
 		out.write("\t\twhile ( ( id = FixUtils.getTagId( buf ) ) > 0 )\n");
 		out.write("\t\t{\n");
 		out.write("\t\t\t" + strReadableByteBuffer + " value;\n\n");
			
 		out.write("\t\t\tvalue = buf;\n\n");

 		out.write("\t\t\tswitch( id ) {\n\n");
 		
		for (DomFixField f : dom.domFixHeader.fields ) {
			if (f.name.contains("BeginString") || f.name.contains("BodyLength") || f.name.equals("MsgType") ) continue;
	 		out.write("\t\t\tcase FixTags." + f.name.toUpperCase() + "_INT:\n");
	 		decodeFieldValue(f, out);
			if (f.domFixValues.size() > 0 && FixMessageDom.toInt(f.type) != FixMessageDom.BOOLEAN ) {
				for (final DomFixValue v : f.domFixValues)
		 			out.write("\t\t\t\tif (!" + capFirst(f.name) + ".isValid("+ uncapFirst(f.name) + ") ) throw new FixSessionException(buf, \"Invalid enumerated value(\" + " + uncapFirst(f.name) + " + \") for tag: \" + id );\n");
			}
	 		out.write("\t\t\t\tbreak;\n\n");
		} 		
 		
 		out.write("\t\t\tdefault:\n");
 		// tag not in header, we are done\n");
 		out.write("\t\t\t\tbuf.position( lastTagPosition );\n\n");

 		out.write("\t\t\t\treturn;\n\n");

 		out.write("\t\t\t}\n\n");

 		out.write("\t\t\tlastTagPosition = buf.position();\n\n");

		out.write("\t\t}\n");
		out.write("\t}\n\n");

		out.write("\t/**\n");
		out.write("\t * @return the length written\n");
		out.write("\t *\n");
		out.write("\t */\n");
		out.write("\t@Override\n");
		out.write("\tpublic abstract void encode( " + strWritableByteBuffer + " out );\n\n");
    
		out.write("\t@Override\n");
		out.write("\tpublic abstract void printBuffer( " + strWritableByteBuffer + " out );\n\n");

		// equals
		out.write("\t@Override\n");
		out.write("\tpublic boolean equals(Object o) {\n");
		out.write("\t\tif (! ( o instanceof FixMessage)) return false;\n\n");
		out.write("\t\t\tFixMessage msg = (FixMessage) o;\n\n");
		printEquals(out, dom.domFixHeader.fields);

		out.write("\n");
		out.write("\t}\n\n");

		out.write("\t@Override\n");
		out.write("\tpublic abstract String toString();\n");
		
		// write out the close to the class
		out.write("}\n");

		// done. close out the file
		out.close();
	}	
	
	private void genGetMsgType(FixMessageDom dom, BufferedWriter out, boolean isCrackMsgType) throws Exception 
	{
		if (isCrackMsgType) 
			out.write("\t\ttry {\n");
		out.write("\t\tstartPos = buf.position();\n");

		out.write("\t\tif(buf.remaining() < (FixMessageInfo.BEGINSTRING_VALUE_WITH_TAG.length + 1 /* SOH */ + 5 /* 9=00SOH */) )\n");
		out.write("\t\t\tthrow new FixGarbledException(buf, \"Message too short to contain mandatory header tags\");\n\n");

		out.write("\t\tint begin = buf.position();\n\n");

		out.write("\t\tint tagId = FixUtils.getTagId(buf);\n");
		out.write("\t\tif(tagId != FixTags.BEGINSTRING_INT)\n");
		out.write("\t\t\tthrow new FixGarbledException(buf, \"First tag in FIX message is not BEGINSTRING (8)\");\n\n");

		out.write("\t\tFixUtils.getTagStringValue(buf, tmpBeginString);\n");
		if (!isCrackMsgType) {
			out.write("\t\tif(!Utils.equals(FixMessageInfo.BEGINSTRING_VALUE, tmpBeginString))\n");
			out.write("\t\t	throw new FixSessionException(buf, \"BeginString not equal to: \" + new String(FixMessageInfo.BEGINSTRING_VALUE));\n\n");
		}
		
		out.write("\t\t//now look to get bodyLength field\n");
		out.write("\t\ttagId = FixUtils.getTagId(buf);\n");
		out.write("\t\tif(tagId != FixTags.BODYLENGTH_INT)\n");
		out.write("\t\t\tthrow new FixGarbledException(buf, \"Second tag in FIX message is not BODYLENGTH (9)\");\n\n");

		out.write("\t\tint bodyLength = FixUtils.getTagIntValue(buf);\n");
		out.write("\t\tif(bodyLength < 0)\n\n");
		out.write("\t\t	throw new FixGarbledException(buf, \"Invalid BODYLENGTH (9) value: \" + bodyLength);\n\n");
		
		out.write("\t\tint checkSumBegin = buf.position() + bodyLength; \n");

		out.write("\t\tif(checkSumBegin > buf.limit()) \n\n");
		out.write("\t\t\tthrow new FixGarbledException(buf, \"Message too short to contain mandatory checksum\");\n\n");

		out.write("\t\t//FIRST, validate that we got a msgType field\n");
		out.write("\t\ttagId = FixUtils.getTagId(buf);\n");
		out.write("\t\tif(tagId != FixTags.MSGTYPE_INT)\n");
		out.write("\t\t	throw new FixGarbledException(buf, \"Third tag in FIX message is not MSGTYPE (35)\");\n\n");

		out.write("\t\tFixUtils.getTagStringValue(buf, tmpMsgType);\n\n");
		if (!isCrackMsgType)
			out.write("\t\tmsgTypeEnd = buf.position();\n\n");

		out.write("\t\t//we should verify that the final tag IS checksum here if we want to\n");
		out.write("\t\tbuf.position(checkSumBegin);\n");
		out.write("\t\ttagId = FixUtils.getTagId(buf);\n");
		out.write("\t\tif(tagId != FixTags.CHECKSUM_INT)\n");
		out.write("\t\t	throw new FixGarbledException(buf, \"Final tag in FIX message is not CHECKSUM (10)\");\n\n");

		out.write("\t\tcheckSum = FixUtils.getTagIntValue(buf);\n");
		out.write("\t\tint calculatedCheckSum = FixUtils.computeChecksum(buf, begin, checkSumBegin);\n");
		out.write("\t\tif(checkSum != calculatedCheckSum && !IGNORE_CHECKSUM)\n");
		out.write("\t\t	throw new FixGarbledException(buf, String.format(\"Checksum mismatch; calculated: %s is not equal message checksum: %s\", calculatedCheckSum, checkSum));\n\n");

		out.write("\t\t// finish-up\n");
		if (isCrackMsgType) 
			out.write("\t\tbuf.flip();\n\n");
		
		out.write("\t\tbuf.position(startPos);\n\n");

		out.write("\t\tmsgType = FixUtils.getMsgTypeTagAsInt(tmpMsgType, Utils.lastIndexTrim(tmpMsgType, (byte)0));\n\n");

		out.write("\t\tmsgType = FixUtils.crackNasdaqMsgType(msgType, buf);\n\n");
		
		if (!isCrackMsgType) {
			out.write("\t\tif (! MsgType.isValid(tmpMsgType))\n");
			out.write("\t\t\tthrow new FixSessionException(buf, msgEnd, String.format(\"MsgType not in specification: %s\", new String(tmpMsgType).trim()));");
		}
		
		if (isCrackMsgType) {
			out.write("\t\t} catch (FixSessionException e) {\n");
			out.write("\t\t\tthrow new FixGarbledException(buf, e.getMessage());\n");
			out.write("\t\t} catch (NumberFormatException e) {\n");
			out.write("\t\t\tthrow new FixGarbledException(buf, e.getMessage());\n");
			out.write("\t\t}\n\n");
		}
	}

	private void genBaseMessage(FixMessageDom dom, final BufferedWriter out) throws Exception 
	{
		
		// write package line
		out.write("package " + dom.packageName + ";\n\n");

		writeGeneratedFileHeader(out);

		// import ByteBuffer
		out.write(strInByteBuffer + "\n");
		out.write(strOutByteBuffer + "\n");
		out.write(strFixException + "\n");
		out.write(strFixGarbledException + "\n\n");
	
		// write out the open to the interface
		out.write("public abstract class FixGeneratedBaseMessage implements FixMessageInfo\n{\n\n");

	    out.write("\tpublic " + strReadableByteBuffer + " buf;\n\n");

	    out.write("\tpublic int startPos = Integer.MAX_VALUE;\n\n");

	    out.write("\tpublic int msgType;\n\n");

	    out.write("\tpublic int msgLen;\n\n");

	    out.write("\tpublic final StringBuffer status = new StringBuffer();\n\n");

	    out.write("\tpublic int size()\n");
	    out.write("\t{\n\n");

	    out.write("\t\treturn msgLen;\n");
	    out.write("\t}\n\n");

	    out.write("\tpublic abstract void encode( " + strWritableByteBuffer + " msg );\n\n");

	    out.write("\tpublic abstract void getAll() throws FixSessionException, FixGarbledException;\n\n");

	    out.write("\tpublic abstract void clear();\n\n");

	    out.write("\tpublic void setBuffer( " + strReadableByteBuffer + " buf )\n");
	    out.write("\t{\n\n");

	    out.write("\t\tthis.buf = buf;\n\n");

	    out.write("\t\tstartPos = buf.position();\n");
	    out.write("\t}\n\n");

	    out.write("\tpublic void setLen( int len )\n");
	    out.write("\t{\n\n");

	    out.write("\t\tmsgLen = len;\n");
	    out.write("\t}\n\n");

	    out.write("\tpublic abstract void printBuffer( " + strWritableByteBuffer + " out );\n\n");

		// write out the close to the class
		out.write("}\n");

		// done. close out the file
		out.close();
		
	}

	private void genListenerInterface(final FixMessageDom dom, final BufferedWriter out) throws Exception {

		// write package line
		out.write("package " + dom.packageName + ";\n\n");

		writeGeneratedFileHeader(out);

		out.write(strInByteBuffer + "\n");

		// write out the open to the interface
		out.write("public interface " + dom.type + "MessageListener\n{\n\n");

		// write out a handler for unknown message types 	
		out.write("\tpublic void onUnknownMessageType( " + strReadableByteBuffer + " msg, int msgType );\n\n");

		// write out each callback
		for (final DomFixMessage m : dom.domFixMessages)
			out.write("\tvoid on" + dom.type + m.name + "( " + dom.type + m.name + " msg );\n\n");

		// write out the close to the interface
		out.write("}\n");

		// done. close out the file
		out.close();
	}

	private void genMessage(final DomFixMessage m, final FixMessageDom dom, final BufferedWriter out) throws Exception {

		String name = dom.type + m.name;
		
		// write package line
		out.write("package " + dom.packageName + ";\n\n");

		writeGeneratedFileHeader(out);

		// import ByteBuffer
		out.write(strInByteBuffer + "\n");
		out.write(strOutByteBuffer + "\n");
		out.write(strFixUtils + "\n");
		out.write(strFixException + "\n");
		out.write(strFixGarbledException + "\n");
		out.write(strUtils + "\n");
		out.write(strConstants + "\n");
		out.write(strBaseUtils + "\n");
		out.write(strOtherUtils + "\n\n");
		
		// write out the open to the interface
		out.write("public class " + name + " extends FixMessage\n{\n\n");
		
		for (DomFixField f : m.fields ) {
			if (f.name.equals("MsgType")) continue;
			declareField(f, out);
		}

		out.write("\n");

		out.write("\tpublic " + name + "() {\n");
		out.write("\t\tsuper();\n\n");
		
		for (DomFixField f : m.fields ) {
			allocateField(f, out);
		}
		out.write("\t\tthis.clear();\n\n");

		out.write("\t\tmsgType = MsgTypes." + m.name.toUpperCase() + "_INT;\n\n");

		out.write("	}\n\n");
		
		out.write("\t@Override\n");
		out.write("\tpublic void clear()\n");
		out.write("\t{\n\n");

		out.write("\t\t// clear out all the fields that aren't msgType\n\n");
		for (DomFixField f : m.fields ) {
			if (f.name.equals("MsgType")) continue;
			clearField(f, out);
		}

		out.write("\t}\n\n");
		
		// getAll()
		out.write("\t@Override\n");
		out.write("\tpublic void getAll() throws FixSessionException, FixGarbledException\n");
		out.write("\t{\n\n");

 		out.write("\t\tint startTagPosition = buf.position();\n\n");

		out.write("\t\tsuper.getAll();\n\n");
		
 		out.write("\t\t// assumption message is full otherwise decode would return null\n");
 		out.write("\t\t// so negative id means that we are at the end of the message\n");
 		out.write("\t\tint id;\n");
 		out.write("\t\tint lastTagPosition = buf.position();\n");
 		out.write("\t\twhile ( ( id = FixUtils.getTagId( buf ) ) > 0 )\n");
 		out.write("\t\t{\n");
 		out.write("\t\t\t" + strReadableByteBuffer + " value;\n\n");
			
 		out.write("\t\t\tvalue = buf;\n\n");

 		out.write("\t\t\tswitch( id ) {\n\n");
 		
		for (DomFixField f : m.fields ) {
			if (f.name.contains("BeginString") || f.name.contains("BodyLength") || f.name.contains("MsgType") ) continue;
	 		out.write("\t\t\tcase FixTags." + f.name.toUpperCase() + "_INT:\n");
	 		decodeFieldValue(f, out);
	 		if (f.domFixValues.size() > 0) {
	 			out.write("\t\t\t\tif (!" + capFirst(f.name) + ".isValid("+ uncapFirst(f.name) + ") ) throw new FixSessionException(buf, \"Invalid enumerated value(\" + " + uncapFirst(f.name) + " + \") for tag: \" + id );\n");
	 		}
	 		out.write("\t\t\t\tbreak;\n\n");
		} 		

		out.write("\t\t\t// for a message always get the checksum\n");
		out.write("\t\t\tcase FixTags.CHECKSUM_INT:\n");
		out.write("\t\t\t\tcheckSum = FixUtils.getTagIntValue( value );\n\n");
		
		out.write("\t\t\t\tid = checkRequiredTags();\n");
		out.write("\t\t\t\tif (id > 0) throw new FixSessionException(buf, \"Required tag missing: \" + id );\n\n");
		
		out.write("\t\t\t\treturn;\n\n");

 		out.write("\t\t\tdefault:\n");
		out.write("\t\t\t\tthrow new FixSessionException(buf, \"Unknown tag: \" + id );\n\n");
 		// for components -> out.write("\t\t\t\tbuf.position( lastTagPosition );\n\n");
 		//out.write("\t\t\t\treturn;\n\n");

 		out.write("\t\t\t}\n\n");

 		out.write("\t\t\tlastTagPosition = buf.position();\n\n");

		out.write("\t\t}\n\n");

 		out.write("\t\tbuf.position(startTagPosition);\n\n");
 		
		out.write("\t}\n\n");
		
		out.write("\tprivate int checkRequiredTags() {\n");
		out.write("\t\tint tag = -1;\n\n");
		
		for (DomFixField f : dom.domFixHeader.fields ) {
			if (f.reqd.equals("N") || f.name.contains("BeginString") || f.name.contains("BodyLength") || f.name.contains("MsgType") ) continue;
			out.write("\t\tif (! FixUtils.isSet(" + uncapFirst(f.name) + ") ) return FixTags." + f.name.toUpperCase() + "_INT;\n");
		}
		
		for (DomFixField f : m.fields ) {
			if (f.reqd.equals("N") ) continue;
			out.write("\t\tif (! FixUtils.isSet(" + uncapFirst(f.name) + ") ) return FixTags." + f.name.toUpperCase() + "_INT;\n");
		}

		for (DomFixField f : dom.domFixTrailer.fields ) {
			if (f.reqd.equals("N") ) continue;
			out.write("\t\tif (! FixUtils.isSet(" + uncapFirst(f.name) + ") ) return FixTags." + f.name.toUpperCase() + "_INT;\n");
		}
		
		out.write("\t\treturn tag;\n\n");
		out.write("\t}\n");	
		
		// encode
		out.write("\t@Override\n");
		out.write("\tpublic void encode( " + strWritableByteBuffer + " out )\n");
		out.write("\t{\n");
		out.write("\t\t// Encode message. Set msgSeqNum and sendingTime and optional resend flags, before encoding. \n\n");
		
		out.write("\t\tint msgStart = out.position();\n\n");
		
		out.write("\t\tout.put( BEGINSTRING_VALUE_WITH_TAG );\n\n");
		
		out.write("\t\tint msgLengthValueStart = out.position() + 2 /* 9= */;\n\n");
		

		out.write("\t\t// placeholder\n");
		out.write("\t\tFixUtils.putFixTag(out, FixTags.BODYLENGTH_INT, FixConstants.MAX_MESSAGE_SIZE );\n\n");
		
		out.write("\t\tint msgTypeStart = out.position();\n\n");

		out.write("\t\tFixUtils.putFixTag( out, FixTags.MSGTYPE_INT, MsgTypes." + m.name.toUpperCase() + ");\n\n");

		out.write("\t\t// encode all fields including the header\n\n");
		for (DomFixField f : dom.domFixHeader.fields ) {
			if (f.name.contains("BeginString") || f.name.contains("BodyLength") || f.name.equals("MsgType") ) continue;
			encodeTagField(f, out);
		}
		out.write("\n");
		for (DomFixField f : m.fields ) {
			encodeTagField(f, out);
		}
		
		out.write("\t\t// the checksum at the end\n\n");
	    
		out.write("\t\tint checkSumStart = out.position();\n");
		out.write("\t\tout.position( msgLengthValueStart );\n");
		out.write("\t\tbodyLength = checkSumStart - msgTypeStart;\n");
		out.write("\t\t" + strOtherUtil + ".longToNumeric( out, bodyLength, " + strUtil + ".digits(FixConstants.MAX_MESSAGE_SIZE) );\n\n");
	    
		out.write("\t\tcheckSum = FixUtils.computeChecksum( out, msgStart, checkSumStart );\n");
		out.write("\t\tout.position( checkSumStart );\n");
		out.write("\t\tFixUtils.putFixTag( out, FixTags.CHECKSUM_INT, checkSum );\n\n");
	    
		out.write("\t\tout.flip();\n\n");
		
	    out.write("\t}\n");
		
		
		out.write("\t@Override		\n");
		out.write("\tpublic void printBuffer(" + strWritableByteBuffer + " out) {\n\n");
		out.write("\t\tout.put(buf);\n\n");
		out.write("\t\tout.flip();\n\n");
		out.write("\t}\n\n");

		// toString
		out.write("\t/**\n");
		out.write("\t * If you use toString for any other purpose than administrative printout.\n");
		out.write("\t * You will end up in nifelheim!\n");
		out.write("\t**/\n");
		out.write("\t@Override\n");
		out.write("\tpublic String toString() {\n");
		out.write("\t\tchar sep = '\\n';\n");
		out.write("\t\tif (Boolean.getBoolean(\"fix.useOneLiner\")) sep = SOH;\n\n");
		
		out.write("\t\tString s = \"BeginString(8)=\" + new String(BEGINSTRING_VALUE) + sep;\n");
		out.write("\t\ts += \"BodyLength(9)=\" + bodyLength + sep;\n");
		out.write("\t\ts += \"MsgType(35)=\" + new String(MsgTypes." + m.name.toUpperCase() + ") + sep;\n\n");

		out.write("\t\ttry {\n");
		out.write("\t\t\t// print all fields including the header\n\n");
		for (DomFixField f : dom.domFixHeader.fields ) {
			if (f.name.contains("BeginString") || f.name.contains("BodyLength") || f.name.equals("MsgType") ) continue;
			printTagField(f, out);
		}
		out.write("\n");
		for (DomFixField f : m.fields ) {
			printTagField(f, out);
		}
		out.write("\n");
		out.write("\t\t\ts += \"checkSum(10)=\" + String.valueOf(checkSum) + sep;\n\n");
		out.write("\t\t} catch(Exception e) {  };\n\n");
		
		out.write("\t\treturn s;\n");
		out.write("\t}\n\n");

		// equals
		name = capFirst(dom.type) + capFirst(m.name);
		out.write("\t@Override\n");
		out.write("\tpublic boolean equals(Object o) {\n");
		out.write("\t\tif (! ( o instanceof " + name + ")) return false;\n\n");
		out.write("\t\t\t" + name + " msg = (" + name + ") o;\n\n");
		out.write("\t\tif ( ! super.equals(msg) ) return false;\n\n");
		printEquals(out, m.fields);
		out.write("\t}\n");

		// write out the close to the class
		out.write("}\n");

		// done. close out the file
		out.close();
	}
	
	private void genParser(final FixMessageDom dom, final BufferedWriter out) throws Exception {

		// write package line
		out.write("package " + dom.packageName + ";\n\n");

		writeGeneratedFileHeader(out);

		out.write(strInByteBuffer + "\n");
		out.write(strFixException + "\n");
		out.write(strFixGarbledException + "\n");

		// write out the open to the parser class
		out.write("public class " + dom.type + "MessageParser implements " + dom.type + "MessageInfo\n{\n\n");

		for (final DomFixMessage m : dom.domFixMessages) {
			out.write("\t" + capFirst(dom.type.toLowerCase()) + capFirst(m.name) + " " + dom.type.toLowerCase() + capFirst(m.name) + 
					" = new " + dom.type + capFirst(m.name) + "();\n");
		}
		out.write("\n");
		
		out.write("\tpublic void parse( " + strReadableByteBuffer + " buf, FixMessageListener l) throws FixSessionException, FixGarbledException {\n\n");

		out.write("\t\tint msgTypeInt = FixMessage.crackMsgType(buf);\n\n");

		out.write("\t\tswitch (msgTypeInt) {\n\n");

		for (final DomFixMessage m : dom.domFixMessages) {

			final String name = dom.type.toLowerCase() + m.name;
			out.write("\t\t\tcase MsgTypes." + m.name.toUpperCase() + "_INT:\n");
			out.write("\t\t\t\t" + name + ".setBuffer( buf );\n");
			out.write("\t\t\t\tl.on" + capFirst(dom.type.toLowerCase()) + m.name + "(" + name + ");\n");
			out.write("\t\t\t\tbreak;\n");
		}
		out.write("\n");

		out.write("\t\t\tdefault:\n");
		out.write("\t\t\t\tl.onUnknownMessageType( buf, msgTypeInt );\n");
		out.write("\t\t\t\tbreak;\n\n");
		out.write("\t\t\t}\n\n");
		out.write("\t\t}\n\n");

		// write out the close to the parser class
		out.write("}\n");

		// done. close out the file
		out.close();
	}

	private void genTags(final FixMessageDom dom, final BufferedWriter out) throws IOException {
		// write package line
		out.write("package " + dom.packageName + ";\n\n");

		writeGeneratedFileHeader(out);

		out.write("public class FixTags {\n\n");

		// write out each callback
		for (final DomFixField f : dom.domFixFields) {

			out.write("\tpublic static final int " + f.name.toUpperCase() + "_INT = " + f.number + ";\n");
			out.write("\tpublic static final byte[]  " + f.name.toUpperCase() + " = \"" + f.number + "\".getBytes();\n");
			if (f.length > 0) {
				out.write("\tpublic static final int " + f.name.toUpperCase() + "_LENGTH = " + f.length + ";\n");
			}
			/* TODO no default length
			else
				try {
					final String l = getJavaLength(f);
					out.write("\t\tpublic static final int " + f.name.toUpperCase() + "_LENGTH = " + l + ";\n");
				} catch (final Exception e) {
					// ignore
				}
			*/
			out.write("\n");
		}

		// write out the close to the interface
		out.write("}\n");

		// done. close out the file
		out.close();
	}

	private String getEqualExpression(final String name, final String type, String prefix) {
		switch (FixMessageDom.toInt(type)) {

			case FixMessageDom.STRING:
			case FixMessageDom.MULTIPLECHARVALUE:
			case FixMessageDom.MULTIPLESTRINGVALUE:
			case FixMessageDom.COUNTRY:
			case FixMessageDom.CURRENCY:
			case FixMessageDom.EXCHANGE:
			case FixMessageDom.MONTHYEAR:
			case FixMessageDom.DATA:
			case FixMessageDom.XMLDATA:
			case FixMessageDom.LANGUAGE:
				return "" + strUtil + ".equals( " + name + ", " + prefix + ")";

			case FixMessageDom.CHAR:
			case FixMessageDom.INT:
			case FixMessageDom.LENGTH:
			case FixMessageDom.TAGNUM:
			case FixMessageDom.SEQNUM:
			case FixMessageDom.NUMINGROUP:
			case FixMessageDom.DAYOFMOUNTH:
			case FixMessageDom.BOOLEAN:
			case FixMessageDom.FLOAT:
			case FixMessageDom.PRICE:
			case FixMessageDom.QTY:
			case FixMessageDom.PRICEOFFSET:
			case FixMessageDom.AMT:
			case FixMessageDom.PERCENTAGE:
				return "( " + name + "==" + prefix + ")";

			case FixMessageDom.UTCTIMESTAMP: // timestamps are ignored
			case FixMessageDom.UTCTIMEONLY:
			case FixMessageDom.UTCDATEONLY:
			case FixMessageDom.LOCALMKTDATE:
			case FixMessageDom.TZTIMEONLY:
			case FixMessageDom.TZTIMESTAMP:
				return "true";
			default:
				throw new RuntimeException("No idea how to parse this field: " + name);
		}
	}

	String getJavaLength(final DomFixField f) {

		switch (FixMessageDom.toInt(f.type)) {

			// TODO more checks
			case FixMessageDom.STRING:
			case FixMessageDom.MULTIPLECHARVALUE:
			case FixMessageDom.MULTIPLESTRINGVALUE:
			case FixMessageDom.COUNTRY:
			case FixMessageDom.EXCHANGE:
			case FixMessageDom.MONTHYEAR:
			case FixMessageDom.UTCTIMEONLY:
			case FixMessageDom.UTCDATEONLY:
			case FixMessageDom.LOCALMKTDATE:
			case FixMessageDom.TZTIMEONLY:
			case FixMessageDom.TZTIMESTAMP:
			case FixMessageDom.DATA:
			case FixMessageDom.XMLDATA:
			case FixMessageDom.LANGUAGE: {
				if (f.length > 0)
					return String.valueOf(f.length);
				else if (f.name.toLowerCase().contains("text"))
					return "FixUtils.FIX_MAX_STRING_TEXT_LENGTH";
				else
					return "FixUtils.FIX_MAX_STRING_LENGTH";
			}

			case FixMessageDom.CURRENCY:
				return "FixUtils.CURRENCY_LENGTH";

			case FixMessageDom.UTCTIMESTAMP:
				return "FixUtils.UTCTIMESTAMP_LENGTH";

			default:
				throw new RuntimeException("No idea how to parse this field: " + f.name);
		}
	}

	String getJavaType(final DomFixField f) {

		switch (FixMessageDom.toInt(f.type)) {

			case FixMessageDom.STRING:
			case FixMessageDom.MULTIPLECHARVALUE:
			case FixMessageDom.MULTIPLESTRINGVALUE:
			case FixMessageDom.COUNTRY:
			case FixMessageDom.CURRENCY:
			case FixMessageDom.EXCHANGE:
			case FixMessageDom.MONTHYEAR:
			case FixMessageDom.UTCTIMESTAMP:
			case FixMessageDom.UTCTIMEONLY:
			case FixMessageDom.UTCDATEONLY:
			case FixMessageDom.LOCALMKTDATE:
			case FixMessageDom.TZTIMEONLY:
			case FixMessageDom.TZTIMESTAMP:
			case FixMessageDom.DATA:
			case FixMessageDom.XMLDATA:
			case FixMessageDom.LANGUAGE:
				return "byte[]";

			case FixMessageDom.CHAR:
				return "byte";

			case FixMessageDom.INT:
			case FixMessageDom.LENGTH:
			case FixMessageDom.TAGNUM:
			case FixMessageDom.SEQNUM:
			case FixMessageDom.NUMINGROUP:
			case FixMessageDom.DAYOFMOUNTH:
				return "long";

			case FixMessageDom.FLOAT:
			case FixMessageDom.PRICE:
			case FixMessageDom.QTY:
			case FixMessageDom.PRICEOFFSET:
			case FixMessageDom.AMT:
			case FixMessageDom.PERCENTAGE:
				return "long";

			case FixMessageDom.BOOLEAN:
				return "boolean";

			default:
				throw new RuntimeException("No idea how to parse this field: " + f.name);
		}
	}

	String getJavaTypeNull(final DomFixField f) {

		switch (FixMessageDom.toInt(f.type)) {

			case FixMessageDom.STRING:
			case FixMessageDom.MULTIPLECHARVALUE:
			case FixMessageDom.MULTIPLESTRINGVALUE:
			case FixMessageDom.COUNTRY:
			case FixMessageDom.CURRENCY:
			case FixMessageDom.EXCHANGE:
			case FixMessageDom.MONTHYEAR:
			case FixMessageDom.UTCTIMESTAMP:
			case FixMessageDom.UTCTIMEONLY:
			case FixMessageDom.UTCDATEONLY:
			case FixMessageDom.LOCALMKTDATE:
			case FixMessageDom.TZTIMEONLY:
			case FixMessageDom.TZTIMESTAMP:
			case FixMessageDom.DATA:
			case FixMessageDom.XMLDATA:
			case FixMessageDom.LANGUAGE:
				return "null";

			case FixMessageDom.CHAR:
				return "(byte)'0'";

			case FixMessageDom.INT:
			case FixMessageDom.LENGTH:
			case FixMessageDom.TAGNUM:
			case FixMessageDom.SEQNUM:
			case FixMessageDom.NUMINGROUP:
			case FixMessageDom.DAYOFMOUNTH:
				return "0";

			case FixMessageDom.FLOAT:
			case FixMessageDom.PRICE:
			case FixMessageDom.QTY:
			case FixMessageDom.PRICEOFFSET:
			case FixMessageDom.AMT:
			case FixMessageDom.PERCENTAGE:
				return "0";

			case FixMessageDom.BOOLEAN:
				return "false";

			default:
				throw new RuntimeException("No idea how to parse this field: " + f.name);
		}
	}

	/**
	 * @param type
	 * @return
	 */
	private boolean isPartOfEqualCopmarison(final String type) {
		switch (FixMessageDom.toInt(type)) {
			case FixMessageDom.UTCTIMESTAMP: // timestamps are ignored
			case FixMessageDom.UTCTIMEONLY:
			case FixMessageDom.UTCDATEONLY:
			case FixMessageDom.LOCALMKTDATE:
			case FixMessageDom.TZTIMEONLY:
			case FixMessageDom.TZTIMESTAMP:
				return false;
			default:
				return true;
		}
	}

	private void printEquals(final BufferedWriter out, final ArrayList<DomFixField> fields) throws IOException {
		for (final DomFixField f : fields) {
			if (f.name.equalsIgnoreCase("BodyLength") || f.name.equalsIgnoreCase("CheckSum") || f.name.equalsIgnoreCase("MsgType")) continue;
			if (isPartOfEqualCopmarison(f.type)) {
				out.write("\t\tif (!" + getEqualExpression(uncapFirst(f.name), f.type, "msg." + uncapFirst(f.name)));
				out.write(") return false;\n\n");
			}
		}
		out.write("		return true;\n");
	}
	
	private void writeEnum(final BufferedWriter out, final DomFixField f, final DomFixValue v) throws IOException {

		switch (FixMessageDom.toInt(f.type)) {

			case FixMessageDom.STRING:
			case FixMessageDom.MULTIPLECHARVALUE:
			case FixMessageDom.MULTIPLESTRINGVALUE:
			case FixMessageDom.COUNTRY:
			case FixMessageDom.CURRENCY:
			case FixMessageDom.EXCHANGE:
			case FixMessageDom.MONTHYEAR:
			case FixMessageDom.UTCTIMESTAMP:
			case FixMessageDom.UTCTIMEONLY:
			case FixMessageDom.UTCDATEONLY:
			case FixMessageDom.LOCALMKTDATE:
			case FixMessageDom.TZTIMEONLY:
			case FixMessageDom.TZTIMESTAMP:
			case FixMessageDom.DATA:
			case FixMessageDom.XMLDATA:
			case FixMessageDom.LANGUAGE:
				out.write("\t\tpublic static final byte[] " + v.description + " = \"" + v.fixEnum + "\".getBytes();\n");
				break;

			case FixMessageDom.CHAR:
				out.write("\t\tpublic static final byte " + v.description + " = \'" + v.fixEnum + "\';\n");
				break;

			case FixMessageDom.INT:
			case FixMessageDom.LENGTH:
			case FixMessageDom.TAGNUM:
			case FixMessageDom.SEQNUM:
			case FixMessageDom.NUMINGROUP:
			case FixMessageDom.DAYOFMOUNTH:
			case FixMessageDom.FLOAT:
			case FixMessageDom.PRICE:
			case FixMessageDom.QTY:
			case FixMessageDom.PRICEOFFSET:
			case FixMessageDom.AMT:
			case FixMessageDom.PERCENTAGE:
				out.write("\t\tpublic static final long " + v.description + " = " + v.fixEnum + ";\n");
				break;

			case FixMessageDom.BOOLEAN:
				out.write("\t\tpublic static final boolean " + v.description + " = " + (v.fixEnum.equals("Y") ? "true" : "false") + ";\n");
				break;

			default:
				throw new RuntimeException("No idea how to parse this field: " + f.name);
		}

	}

	private void writeGeneratedFileHeader(final BufferedWriter out) throws IOException {

		out.write("// DO NOT EDIT!!!\n");
		out.write("// This file is generated by FixMessageGenerator.\n");
		out.write("// If you need additional functionality, put it in a helper class\n");
		out.write("// that does not live in this folder!!!  Any java file in this folder \n");
		out.write("// will be deleted upon the next run of the FixMessageGenerator!\n\n");
	}

}