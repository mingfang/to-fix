package org.tomac.protocol.fix.messaging.fix50sp2;

// DO NOT EDIT!!!
// This file is generated by FixMessageGenerator.
// If you need additional functionality, put it in a helper class
// that does not live in this folder!!!  Any java file in this folder 
// will be deleted upon the next run of the FixMessageGenerator!

import java.nio.ByteBuffer;

import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.FixSessionException;
import org.tomac.protocol.fix.FixGarbledException;
import org.tomac.utils.Utils;
import org.tomac.protocol.fix.FixConstants;


import org.tomac.protocol.fix.messaging.fix50sp2.component.FixHopGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixApplicationSequenceControl;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixUnderlyingInstrument;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixDerivativeSecurityDefinition;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixRelSymDerivSecGrp;

public class FixDerivativeSecurityList extends FixMessage
{

	public long securityReportID = 0;
	public FixApplicationSequenceControl applicationSequenceControl;
	public byte[] securityReqID;
	public byte[] securityResponseID;
	public long securityRequestResult = 0;
	public byte[] clearingBusinessDate;
	public byte[] transactTime;
	public FixUnderlyingInstrument underlyingInstrument;
	public FixDerivativeSecurityDefinition derivativeSecurityDefinition;
	public long totNoRelatedSym = 0;
	public boolean lastFragment = false;
	public FixRelSymDerivSecGrp relSymDerivSecGrp;

	public FixDerivativeSecurityList() {
		super();

		applicationSequenceControl = new FixApplicationSequenceControl();
		securityReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		securityResponseID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		clearingBusinessDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		underlyingInstrument = new FixUnderlyingInstrument();
		derivativeSecurityDefinition = new FixDerivativeSecurityDefinition();
		relSymDerivSecGrp = new FixRelSymDerivSecGrp();
		this.clear();

		msgType = MsgTypes.DERIVATIVESECURITYLIST_INT;

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		securityReportID = Long.MAX_VALUE;		
		Utils.fill( securityReqID, (byte)0 );
		Utils.fill( securityResponseID, (byte)0 );
		securityRequestResult = Long.MAX_VALUE;		
		Utils.fill( clearingBusinessDate, (byte)0 );
		Utils.fill( transactTime, (byte)0 );
		totNoRelatedSym = Long.MAX_VALUE;		
		lastFragment = false;		
		applicationSequenceControl.clear();
		underlyingInstrument.clear();
		derivativeSecurityDefinition.clear();
		relSymDerivSecGrp.clear();
	}

	@Override
	public void getAll() throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		super.getAll();

		// assumption message is full otherwise decode would return null
		// so negative id means that we are at the end of the message
		int id;
		int lastTagPosition = buf.position();
		while ( ( id = FixUtils.getTagId( buf ) ) > 0 )
		{
			ByteBuffer value;

			value = buf;

			switch( id ) {

			case FixTags.SECURITYREPORTID_INT:
				securityReportID = FixUtils.getTagIntValue( value );
				break;

			case FixTags.APPLID_INT:
				applicationSequenceControl.getAll(FixTags.APPLID_INT, value );
				break;

			case FixTags.SECURITYREQID_INT:
				securityReqID = FixUtils.getTagStringValue(value, securityReqID);
				break;

			case FixTags.SECURITYRESPONSEID_INT:
				securityResponseID = FixUtils.getTagStringValue(value, securityResponseID);
				break;

			case FixTags.SECURITYREQUESTRESULT_INT:
				securityRequestResult = FixUtils.getTagIntValue( value );
				if (!SecurityRequestResult.isValid(securityRequestResult) ) throw new FixSessionException(buf, "Invalid enumerated value(" + securityRequestResult + ") for tag: " + id );
				break;

			case FixTags.CLEARINGBUSINESSDATE_INT:
				clearingBusinessDate = FixUtils.getTagStringValue(value, clearingBusinessDate);
				break;

			case FixTags.TRANSACTTIME_INT:
				transactTime = FixUtils.getTagStringValue(value, transactTime);
				break;

			case FixTags.UNDERLYINGSYMBOL_INT:
				underlyingInstrument.getAll(FixTags.UNDERLYINGSYMBOL_INT, value );
				break;

			case FixTags.DERIVATIVESYMBOL_INT:
				derivativeSecurityDefinition.getAll(FixTags.DERIVATIVESYMBOL_INT, value );
				break;

			case FixTags.TOTNORELATEDSYM_INT:
				totNoRelatedSym = FixUtils.getTagIntValue( value );
				break;

			case FixTags.LASTFRAGMENT_INT:
				lastFragment = FixUtils.getTagBooleanValue( value );
				if (!LastFragment.isValid(lastFragment) ) throw new FixSessionException(buf, "Invalid enumerated value(" + lastFragment + ") for tag: " + id );
				break;

			case FixTags.NORELATEDSYM_INT:
				relSymDerivSecGrp.noRelatedSym = FixUtils.getTagIntValue( value );
				relSymDerivSecGrp.getAll(relSymDerivSecGrp.noRelatedSym, value );
				break;

			// for a message always get the checksum
			case FixTags.CHECKSUM_INT:
				checkSum = FixUtils.getTagIntValue( value );

				id = checkRequiredTags();
				if (id > 0) throw new FixSessionException(buf, "Required tag missing: " + id );

				return;

			default:
				throw new FixSessionException(buf, "Unknown tag: " + id );

			}

			lastTagPosition = buf.position();

		}

		buf.position(startTagPosition);

	}

	private int checkRequiredTags() {
		int tag = -1;

		if (! FixUtils.isSet(senderCompID) ) return FixTags.SENDERCOMPID_INT;
		if (! FixUtils.isSet(targetCompID) ) return FixTags.TARGETCOMPID_INT;
		if (! FixUtils.isSet(msgSeqNum) ) return FixTags.MSGSEQNUM_INT;
		if (! FixUtils.isSet(sendingTime) ) return FixTags.SENDINGTIME_INT;
		if (! FixUtils.isSet(checkSum) ) return FixTags.CHECKSUM_INT;
		return tag;

	}
	@Override
	public void encode( ByteBuffer out )
	{
		// Encode message. Set msgSeqNum and sendingTime and optional resend flags, before encoding. 

		int msgStart = out.position();

		out.put( BEGINSTRING_VALUE_WITH_TAG );

		int msgLengthValueStart = out.position() + 2 /* 9= */;

		// placeholder
		FixUtils.putFixTag(out, FixTags.BODYLENGTH_INT, FixConstants.MAX_MESSAGE_SIZE );

		int msgTypeStart = out.position();

		FixUtils.putFixTag( out, FixTags.MSGTYPE_INT, MsgTypes.DERIVATIVESECURITYLIST);

		// encode all fields including the header

		if (FixUtils.isSet(applVerID)) FixUtils.putFixTag( out, FixTags.APPLVERID_INT, applVerID, 0, Utils.lastIndexTrim(applVerID, (byte)0) );
		if (FixUtils.isSet(cstmApplVerID)) FixUtils.putFixTag( out, FixTags.CSTMAPPLVERID_INT, cstmApplVerID, 0, Utils.lastIndexTrim(cstmApplVerID, (byte)0) );
		if (FixUtils.isSet(applExtID)) FixUtils.putFixTag( out, FixTags.APPLEXTID_INT, applExtID);
		FixUtils.putFixTag( out, FixTags.SENDERCOMPID_INT, senderCompID, 0, Utils.lastIndexTrim(senderCompID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.TARGETCOMPID_INT, targetCompID, 0, Utils.lastIndexTrim(targetCompID, (byte)0) );
		if (FixUtils.isSet(onBehalfOfCompID)) FixUtils.putFixTag( out, FixTags.ONBEHALFOFCOMPID_INT, onBehalfOfCompID, 0, Utils.lastIndexTrim(onBehalfOfCompID, (byte)0) );
		if (FixUtils.isSet(deliverToCompID)) FixUtils.putFixTag( out, FixTags.DELIVERTOCOMPID_INT, deliverToCompID, 0, Utils.lastIndexTrim(deliverToCompID, (byte)0) );
		if (FixUtils.isSet(secureDataLen)) FixUtils.putFixTag( out, FixTags.SECUREDATALEN_INT, secureDataLen);
		if (FixUtils.isSet(secureData)) FixUtils.putFixTag( out, FixTags.SECUREDATA_INT, secureData, 0, Utils.lastIndexTrim(secureData, (byte)0) );
		FixUtils.putFixTag( out, FixTags.MSGSEQNUM_INT, msgSeqNum);
		if (FixUtils.isSet(senderSubID)) FixUtils.putFixTag( out, FixTags.SENDERSUBID_INT, senderSubID, 0, Utils.lastIndexTrim(senderSubID, (byte)0) );
		if (FixUtils.isSet(senderLocationID)) FixUtils.putFixTag( out, FixTags.SENDERLOCATIONID_INT, senderLocationID, 0, Utils.lastIndexTrim(senderLocationID, (byte)0) );
		if (FixUtils.isSet(targetSubID)) FixUtils.putFixTag( out, FixTags.TARGETSUBID_INT, targetSubID, 0, Utils.lastIndexTrim(targetSubID, (byte)0) );
		if (FixUtils.isSet(targetLocationID)) FixUtils.putFixTag( out, FixTags.TARGETLOCATIONID_INT, targetLocationID, 0, Utils.lastIndexTrim(targetLocationID, (byte)0) );
		if (FixUtils.isSet(onBehalfOfSubID)) FixUtils.putFixTag( out, FixTags.ONBEHALFOFSUBID_INT, onBehalfOfSubID, 0, Utils.lastIndexTrim(onBehalfOfSubID, (byte)0) );
		if (FixUtils.isSet(onBehalfOfLocationID)) FixUtils.putFixTag( out, FixTags.ONBEHALFOFLOCATIONID_INT, onBehalfOfLocationID, 0, Utils.lastIndexTrim(onBehalfOfLocationID, (byte)0) );
		if (FixUtils.isSet(deliverToSubID)) FixUtils.putFixTag( out, FixTags.DELIVERTOSUBID_INT, deliverToSubID, 0, Utils.lastIndexTrim(deliverToSubID, (byte)0) );
		if (FixUtils.isSet(deliverToLocationID)) FixUtils.putFixTag( out, FixTags.DELIVERTOLOCATIONID_INT, deliverToLocationID, 0, Utils.lastIndexTrim(deliverToLocationID, (byte)0) );
		if (FixUtils.isSet(possDupFlag)) FixUtils.putFixTag( out, FixTags.POSSDUPFLAG_INT, possDupFlag?(byte)'Y':(byte)'N' );
		if (FixUtils.isSet(possResend)) FixUtils.putFixTag( out, FixTags.POSSRESEND_INT, possResend?(byte)'Y':(byte)'N' );
		FixUtils.putFixTag( out, FixTags.SENDINGTIME_INT, sendingTime);
		if (FixUtils.isSet(origSendingTime)) FixUtils.putFixTag( out, FixTags.ORIGSENDINGTIME_INT, origSendingTime);
		if (FixUtils.isSet(xmlDataLen)) FixUtils.putFixTag( out, FixTags.XMLDATALEN_INT, xmlDataLen);
		if (FixUtils.isSet(xmlData)) FixUtils.putFixTag( out, FixTags.XMLDATA_INT, xmlData, 0, Utils.lastIndexTrim(xmlData, (byte)0) );
		if (FixUtils.isSet(messageEncoding)) FixUtils.putFixTag( out, FixTags.MESSAGEENCODING_INT, messageEncoding, 0, Utils.lastIndexTrim(messageEncoding, (byte)0) );
		if (FixUtils.isSet(lastMsgSeqNumProcessed)) FixUtils.putFixTag( out, FixTags.LASTMSGSEQNUMPROCESSED_INT, lastMsgSeqNumProcessed);
		if ( FixUtils.isSet(hopGrp.noHops) )hopGrp.encode( out );

		if (FixUtils.isSet(securityReportID)) FixUtils.putFixTag( out, FixTags.SECURITYREPORTID_INT, securityReportID);
		if (FixUtils.isSet(applicationSequenceControl.applID)) applicationSequenceControl.encode( out );
		if (FixUtils.isSet(securityReqID)) FixUtils.putFixTag( out, FixTags.SECURITYREQID_INT, securityReqID, 0, Utils.lastIndexTrim(securityReqID, (byte)0) );
		if (FixUtils.isSet(securityResponseID)) FixUtils.putFixTag( out, FixTags.SECURITYRESPONSEID_INT, securityResponseID, 0, Utils.lastIndexTrim(securityResponseID, (byte)0) );
		if (FixUtils.isSet(securityRequestResult)) FixUtils.putFixTag( out, FixTags.SECURITYREQUESTRESULT_INT, securityRequestResult);
		if (FixUtils.isSet(clearingBusinessDate)) FixUtils.putFixTag( out, FixTags.CLEARINGBUSINESSDATE_INT, clearingBusinessDate);
		if (FixUtils.isSet(transactTime)) FixUtils.putFixTag( out, FixTags.TRANSACTTIME_INT, transactTime);
		if (FixUtils.isSet(underlyingInstrument.underlyingSymbol)) underlyingInstrument.encode( out );
		if (FixUtils.isSet(derivativeSecurityDefinition.derivativeInstrument.derivativeSymbol)) derivativeSecurityDefinition.encode( out );
		if (FixUtils.isSet(totNoRelatedSym)) FixUtils.putFixTag( out, FixTags.TOTNORELATEDSYM_INT, totNoRelatedSym);
		if (FixUtils.isSet(lastFragment)) FixUtils.putFixTag( out, FixTags.LASTFRAGMENT_INT, lastFragment?(byte)'Y':(byte)'N' );
		if (FixUtils.isSet(relSymDerivSecGrp.noRelatedSym)) relSymDerivSecGrp.encode( out );
		// the checksum at the end

		int checkSumStart = out.position();
		out.position( msgLengthValueStart );
		bodyLength = checkSumStart - msgTypeStart;
		Utils.longToNumeric( out, bodyLength, Utils.digits(FixConstants.MAX_MESSAGE_SIZE) );

		checkSum = FixUtils.computeChecksum( out, msgStart, checkSumStart );
		out.position( checkSumStart );
		FixUtils.putFixTag( out, FixTags.CHECKSUM_INT, checkSum );

		out.flip();

	}
	@Override		
	public void printBuffer(ByteBuffer out) {

		out.put(buf);

		out.flip();

	}

	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will end up in nifelheim!
	**/
	@Override
	public String toString() {
		char sep = '\n';
		if (Boolean.getBoolean("fix.useOneLiner")) sep = SOH;

		String s = "BeginString(8)=" + new String(BEGINSTRING_VALUE) + sep;
		s += "BodyLength(9)=" + bodyLength + sep;
		s += "MsgType(35)=" + new String(MsgTypes.DERIVATIVESECURITYLIST) + sep;

		try {
			// print all fields including the header

			if (FixUtils.isSet(applVerID)) s += "ApplVerID(1128)=" + new String(applVerID) + sep;
			if (FixUtils.isSet(cstmApplVerID)) s += "CstmApplVerID(1129)=" + new String(cstmApplVerID) + sep;
			if (FixUtils.isSet(applExtID)) s += "ApplExtID(1156)=" + String.valueOf(applExtID) + sep;
			 s += "SenderCompID(49)=" + new String(senderCompID) + sep;
			 s += "TargetCompID(56)=" + new String(targetCompID) + sep;
			if (FixUtils.isSet(onBehalfOfCompID)) s += "OnBehalfOfCompID(115)=" + new String(onBehalfOfCompID) + sep;
			if (FixUtils.isSet(deliverToCompID)) s += "DeliverToCompID(128)=" + new String(deliverToCompID) + sep;
			if (FixUtils.isSet(secureDataLen)) s += "SecureDataLen(90)=" + String.valueOf(secureDataLen) + sep;
			if (FixUtils.isSet(secureData)) s += "SecureData(91)=" + new String(secureData) + sep;
			 s += "MsgSeqNum(34)=" + String.valueOf(msgSeqNum) + sep;
			if (FixUtils.isSet(senderSubID)) s += "SenderSubID(50)=" + new String(senderSubID) + sep;
			if (FixUtils.isSet(senderLocationID)) s += "SenderLocationID(142)=" + new String(senderLocationID) + sep;
			if (FixUtils.isSet(targetSubID)) s += "TargetSubID(57)=" + new String(targetSubID) + sep;
			if (FixUtils.isSet(targetLocationID)) s += "TargetLocationID(143)=" + new String(targetLocationID) + sep;
			if (FixUtils.isSet(onBehalfOfSubID)) s += "OnBehalfOfSubID(116)=" + new String(onBehalfOfSubID) + sep;
			if (FixUtils.isSet(onBehalfOfLocationID)) s += "OnBehalfOfLocationID(144)=" + new String(onBehalfOfLocationID) + sep;
			if (FixUtils.isSet(deliverToSubID)) s += "DeliverToSubID(129)=" + new String(deliverToSubID) + sep;
			if (FixUtils.isSet(deliverToLocationID)) s += "DeliverToLocationID(145)=" + new String(deliverToLocationID) + sep;
			if (FixUtils.isSet(possDupFlag)) s += "PossDupFlag(43)=" + String.valueOf(possDupFlag) + sep;
			if (FixUtils.isSet(possResend)) s += "PossResend(97)=" + String.valueOf(possResend) + sep;
			 s += "SendingTime(52)=" + new String(sendingTime) + sep;
			if (FixUtils.isSet(origSendingTime)) s += "OrigSendingTime(122)=" + new String(origSendingTime) + sep;
			if (FixUtils.isSet(xmlDataLen)) s += "XmlDataLen(212)=" + String.valueOf(xmlDataLen) + sep;
			if (FixUtils.isSet(xmlData)) s += "XmlData(213)=" + new String(xmlData) + sep;
			if (FixUtils.isSet(messageEncoding)) s += "MessageEncoding(347)=" + new String(messageEncoding) + sep;
			if (FixUtils.isSet(lastMsgSeqNumProcessed)) s += "LastMsgSeqNumProcessed(369)=" + String.valueOf(lastMsgSeqNumProcessed) + sep;
			if (FixUtils.isSet(hopGrp.noHops)) s += hopGrp.toString();

			if (FixUtils.isSet(securityReportID)) s += "SecurityReportID(964)=" + String.valueOf(securityReportID) + sep;
			if (FixUtils.isSet(applicationSequenceControl.applID)) s += applicationSequenceControl.toString();
			if (FixUtils.isSet(securityReqID)) s += "SecurityReqID(320)=" + new String(securityReqID) + sep;
			if (FixUtils.isSet(securityResponseID)) s += "SecurityResponseID(322)=" + new String(securityResponseID) + sep;
			if (FixUtils.isSet(securityRequestResult)) s += "SecurityRequestResult(560)=" + String.valueOf(securityRequestResult) + sep;
			if (FixUtils.isSet(clearingBusinessDate)) s += "ClearingBusinessDate(715)=" + new String(clearingBusinessDate) + sep;
			if (FixUtils.isSet(transactTime)) s += "TransactTime(60)=" + new String(transactTime) + sep;
			if (FixUtils.isSet(underlyingInstrument.underlyingSymbol)) s += underlyingInstrument.toString();
			if (FixUtils.isSet(derivativeSecurityDefinition.derivativeInstrument.derivativeSymbol)) s += derivativeSecurityDefinition.toString();
			if (FixUtils.isSet(totNoRelatedSym)) s += "TotNoRelatedSym(393)=" + String.valueOf(totNoRelatedSym) + sep;
			if (FixUtils.isSet(lastFragment)) s += "LastFragment(893)=" + String.valueOf(lastFragment) + sep;
			if (FixUtils.isSet(relSymDerivSecGrp.noRelatedSym)) s += relSymDerivSecGrp.toString();

			s += "checkSum(10)=" + String.valueOf(checkSum) + sep;

		} catch(Exception e) {  };

		return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixDerivativeSecurityList)) return false;

			FixDerivativeSecurityList msg = (FixDerivativeSecurityList) o;

		if ( ! super.equals(msg) ) return false;

		if (!( securityReportID==msg.securityReportID)) return false;

		if (!applicationSequenceControl.equals(msg.applicationSequenceControl)) return false;

		if (!Utils.equals( securityReqID, msg.securityReqID)) return false;

		if (!Utils.equals( securityResponseID, msg.securityResponseID)) return false;

		if (!( securityRequestResult==msg.securityRequestResult)) return false;

		if (!underlyingInstrument.equals(msg.underlyingInstrument)) return false;

		if (!derivativeSecurityDefinition.equals(msg.derivativeSecurityDefinition)) return false;

		if (!( totNoRelatedSym==msg.totNoRelatedSym)) return false;

		if (!( lastFragment==msg.lastFragment)) return false;

		if (!relSymDerivSecGrp.equals(msg.relSymDerivSecGrp)) return false;

		return true;
	}
}
