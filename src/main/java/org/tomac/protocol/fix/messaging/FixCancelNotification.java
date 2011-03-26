package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixCancelNotification extends FixInMessage {
	private short hasAvgPx;
	long avgPx = 0;		
	private short hasClOrdID;
	byte[] clOrdID = new byte[20];		
	private short hasCumQty;
	long cumQty = 0;		
	private short hasCurrency;
	byte[] currency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasExecID;
	byte[] execID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasExecTransType;
	byte execTransType = (byte)' ';		
	private short hasOrderID;
	byte[] orderID = new byte[32];		
	private short hasOrdStatus;
	byte ordStatus = (byte)' ';		
	private short hasSecurityID;
	byte[] securityID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSide;
	byte side = (byte)' ';		
	private short hasSymbol;
	byte[] symbol = new byte[6];		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasClientID;
	byte[] clientID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasExecType;
	byte execType = (byte)' ';		
	private short hasLeavesQty;
	long leavesQty = 0;		
	private short hasSettlBrkrCode;
	byte[] settlBrkrCode = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasNoContraBrokers;
	long noContraBrokers = 0;		
	private short hasContraBroker;
	byte[] contraBroker = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradeReportID;
	byte[] tradeReportID = new byte[20];		
	private short hasTradeReportType;
	byte[] tradeReportType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTrdMatchID;
	byte[] trdMatchID = new byte[10];		
	private short hasSubMktID;
	byte[] subMktID = new byte[3];		
	private short hasClRefID;
	byte[] clRefID = new byte[15];		
	private short hasBrSeqNbr;
	byte[] brSeqNbr = new byte[10];		
	
	public FixCancelNotification() {
		super(FixMessageInfo.MessageTypes.CANCELNOTIFICATION);


		hasAvgPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasClOrdID = FixUtils.TAG_HAS_NO_VALUE;		
		clOrdID = new byte[20];		
		hasCumQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		currency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasExecID = FixUtils.TAG_HAS_NO_VALUE;		
		execID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasExecTransType = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrderID = FixUtils.TAG_HAS_NO_VALUE;		
		orderID = new byte[32];		
		hasOrdStatus = FixUtils.TAG_HAS_NO_VALUE;		
		hasSecurityID = FixUtils.TAG_HAS_NO_VALUE;		
		securityID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSide = FixUtils.TAG_HAS_NO_VALUE;		
		hasSymbol = FixUtils.TAG_HAS_NO_VALUE;		
		symbol = new byte[6];		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasClientID = FixUtils.TAG_HAS_NO_VALUE;		
		clientID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasExecType = FixUtils.TAG_HAS_NO_VALUE;		
		hasLeavesQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlBrkrCode = FixUtils.TAG_HAS_NO_VALUE;		
		settlBrkrCode = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasNoContraBrokers = FixUtils.TAG_HAS_NO_VALUE;		
		hasContraBroker = FixUtils.TAG_HAS_NO_VALUE;		
		contraBroker = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradeReportID = FixUtils.TAG_HAS_NO_VALUE;		
		tradeReportID = new byte[20];		
		hasTradeReportType = FixUtils.TAG_HAS_NO_VALUE;		
		tradeReportType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTrdMatchID = FixUtils.TAG_HAS_NO_VALUE;		
		trdMatchID = new byte[10];		
		hasSubMktID = FixUtils.TAG_HAS_NO_VALUE;		
		subMktID = new byte[3];		
		hasClRefID = FixUtils.TAG_HAS_NO_VALUE;		
		clRefID = new byte[15];		
		hasBrSeqNbr = FixUtils.TAG_HAS_NO_VALUE;		
		brSeqNbr = new byte[10];		

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixMessage.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.AVGPX_INT:		
            		hasAvgPx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CLORDID_INT:		
            		hasClOrdID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CUMQTY_INT:		
            		hasCumQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CURRENCY_INT:		
            		hasCurrency = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.EXECID_INT:		
            		hasExecID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.EXECTRANSTYPE_INT:		
            		hasExecTransType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ORDERID_INT:		
            		hasOrderID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ORDSTATUS_INT:		
            		hasOrdStatus = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SECURITYID_INT:		
            		hasSecurityID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SIDE_INT:		
            		hasSide = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SYMBOL_INT:		
            		hasSymbol = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TEXT_INT:		
            		hasText = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CLIENTID_INT:		
            		hasClientID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.EXECTYPE_INT:		
            		hasExecType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.LEAVESQTY_INT:		
            		hasLeavesQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SETTLBRKRCODE_INT:		
            		hasSettlBrkrCode = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.NOCONTRABROKERS_INT:		
            		hasNoContraBrokers = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CONTRABROKER_INT:		
            		hasContraBroker = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRADEREPORTID_INT:		
            		hasTradeReportID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRADEREPORTTYPE_INT:		
            		hasTradeReportType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRDMATCHID_INT:		
            		hasTrdMatchID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.SUBMKTID_INT:		
            		hasSubMktID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CLREFID_INT:		
            		hasClRefID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.BRSEQNBR_INT:		
            		hasBrSeqNbr = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	default:
        			if ( standardHeader.isKeyTag(tag)) {
        				tag = standardHeader.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( standardTrailer.isKeyTag(tag)) {
        				tag = standardTrailer.setBuffer( tag, buf, err);
        				FixMessage.unreadLastTag(tag, buf);
        				if (!err.hasError()) hasRequiredTags(err);
            			return; // always last, we are done now
            		} else {
 						FixMessage.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else break; //Ugha
					}

			}

            	tag = FixMessage.getTag(buf, err);		
        		if (err.hasError()) break;

		}

	}		

	private boolean hasRequiredTags(FixValidationError err) {
		if (!hasAvgPx()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag AvgPx missing", FixTags.AVGPX_INT, FixMessageInfo.MessageTypes.CANCELNOTIFICATION);
			return false;
		}
		if (!hasCumQty()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag CumQty missing", FixTags.CUMQTY_INT, FixMessageInfo.MessageTypes.CANCELNOTIFICATION);
			return false;
		}
		if (!hasCurrency()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag Currency missing", FixTags.CURRENCY_INT, FixMessageInfo.MessageTypes.CANCELNOTIFICATION);
			return false;
		}
		if (!hasExecID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag ExecID missing", FixTags.EXECID_INT, FixMessageInfo.MessageTypes.CANCELNOTIFICATION);
			return false;
		}
		if (!hasExecTransType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag ExecTransType missing", FixTags.EXECTRANSTYPE_INT, FixMessageInfo.MessageTypes.CANCELNOTIFICATION);
			return false;
		}
		if (!hasOrderID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag OrderID missing", FixTags.ORDERID_INT, FixMessageInfo.MessageTypes.CANCELNOTIFICATION);
			return false;
		}
		if (!hasOrdStatus()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag OrdStatus missing", FixTags.ORDSTATUS_INT, FixMessageInfo.MessageTypes.CANCELNOTIFICATION);
			return false;
		}
		if (!hasSecurityID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag SecurityID missing", FixTags.SECURITYID_INT, FixMessageInfo.MessageTypes.CANCELNOTIFICATION);
			return false;
		}
		if (!hasSide()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag Side missing", FixTags.SIDE_INT, FixMessageInfo.MessageTypes.CANCELNOTIFICATION);
			return false;
		}
		if (!hasSymbol()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag Symbol missing", FixTags.SYMBOL_INT, FixMessageInfo.MessageTypes.CANCELNOTIFICATION);
			return false;
		}
		if (!hasText()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag Text missing", FixTags.TEXT_INT, FixMessageInfo.MessageTypes.CANCELNOTIFICATION);
			return false;
		}
		if (!hasClientID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag ClientID missing", FixTags.CLIENTID_INT, FixMessageInfo.MessageTypes.CANCELNOTIFICATION);
			return false;
		}
		if (!hasExecType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag ExecType missing", FixTags.EXECTYPE_INT, FixMessageInfo.MessageTypes.CANCELNOTIFICATION);
			return false;
		}
		if (!hasLeavesQty()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag LeavesQty missing", FixTags.LEAVESQTY_INT, FixMessageInfo.MessageTypes.CANCELNOTIFICATION);
			return false;
		}
		if (!hasTradeReportID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag TradeReportID missing", FixTags.TRADEREPORTID_INT, FixMessageInfo.MessageTypes.CANCELNOTIFICATION);
			return false;
		}
		if (!hasTradeReportType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag TradeReportType missing", FixTags.TRADEREPORTTYPE_INT, FixMessageInfo.MessageTypes.CANCELNOTIFICATION);
			return false;
		}
		if (!hasTrdMatchID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag TrdMatchID missing", FixTags.TRDMATCHID_INT, FixMessageInfo.MessageTypes.CANCELNOTIFICATION);
			return false;
		}
		if (!hasSubMktID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag SubMktID missing", FixTags.SUBMKTID_INT, FixMessageInfo.MessageTypes.CANCELNOTIFICATION);
			return false;
		}
		return true;
	}
	@Override		
	public void getAll() {		
		/* not needed, just for the inet dudes recognition */		
	}		
		
	@Override		
	public int encode(ByteBuffer out) {

		int startPos = out.position();
		super.standardHeader.setBodyLength(1000);

		super.standardHeader.encode(out);		
		if (hasAvgPx()) {		
			out.put(FixTags.AVGPX);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)avgPx);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasClOrdID()) {		
			out.put(FixTags.CLORDID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clOrdID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCumQty()) {		
			out.put(FixTags.CUMQTY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)cumQty);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCurrency()) {		
			out.put(FixTags.CURRENCY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,currency); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasExecID()) {		
			out.put(FixTags.EXECID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,execID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasExecTransType()) {		
			out.put(FixTags.EXECTRANSTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,execTransType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOrderID()) {		
			out.put(FixTags.ORDERID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,orderID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOrdStatus()) {		
			out.put(FixTags.ORDSTATUS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,ordStatus); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSecurityID()) {		
			out.put(FixTags.SECURITYID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,securityID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSide()) {		
			out.put(FixTags.SIDE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,side); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSymbol()) {		
			out.put(FixTags.SYMBOL);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,symbol); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasText()) {		
			out.put(FixTags.TEXT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,text); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasClientID()) {		
			out.put(FixTags.CLIENTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clientID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasExecType()) {		
			out.put(FixTags.EXECTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,execType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasLeavesQty()) {		
			out.put(FixTags.LEAVESQTY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)leavesQty);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSettlBrkrCode()) {		
			out.put(FixTags.SETTLBRKRCODE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,settlBrkrCode); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasNoContraBrokers()) {		
			out.put(FixTags.NOCONTRABROKERS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)noContraBrokers);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasContraBroker()) {		
			out.put(FixTags.CONTRABROKER);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,contraBroker); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradeReportID()) {		
			out.put(FixTags.TRADEREPORTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,tradeReportID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTradeReportType()) {		
			out.put(FixTags.TRADEREPORTTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,tradeReportType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTrdMatchID()) {		
			out.put(FixTags.TRDMATCHID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,trdMatchID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSubMktID()) {		
			out.put(FixTags.SUBMKTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,subMktID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasClRefID()) {		
			out.put(FixTags.CLREFID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clRefID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasBrSeqNbr()) {		
			out.put(FixTags.BRSEQNBR);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,brSeqNbr); 		
		
			out.put(FixUtils.SOH);		
		}		
		
		// set body length

		int endPos = out.position();

		super.standardHeader.setBodyLength(endPos - FixUtils.FIX_MESSAGE_START);

		out.position(startPos + FixUtils.FIX_HEADER);

		if (super.standardHeader.getBodyLength()>999) {
			FixUtils.put(out, super.standardHeader.getBodyLength());
		} else if (super.standardHeader.getBodyLength()>99) {
			FixUtils.put(out, 0);
			FixUtils.put(out, super.standardHeader.getBodyLength());
		} else {
			FixUtils.put(out, 0);
			FixUtils.put(out, 0);
			FixUtils.put(out, super.standardHeader.getBodyLength());
		}
		final byte[] tmpCheckSum = new byte[FixTags.CHECKSUM_LENGTH];
		FixUtils.generateCheckSum(tmpCheckSum, out, startPos, endPos);
		super.standardTrailer.setCheckSum(tmpCheckSum);

		out.position(endPos);

		super.standardTrailer.encode(out);
		out.limit(out.position());
		out.flip();

		return (int) super.standardHeader.getBodyLength();

	}			
			
			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		int startPos = out.position();		
					
		super.standardHeader.encode(out);		
		
		if (hasAvgPx()) {		
			FixUtils.put(out, (long)avgPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClOrdID()) {		
			FixUtils.put(out,clOrdID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCumQty()) {		
			FixUtils.put(out, (long)cumQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCurrency()) {		
			FixUtils.put(out,currency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExecID()) {		
			FixUtils.put(out,execID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExecTransType()) {		
			FixUtils.put(out,execTransType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrderID()) {		
			FixUtils.put(out,orderID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrdStatus()) {		
			FixUtils.put(out,ordStatus); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecurityID()) {		
			FixUtils.put(out,securityID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSide()) {		
			FixUtils.put(out,side); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSymbol()) {		
			FixUtils.put(out,symbol); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasText()) {		
			FixUtils.put(out,text); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClientID()) {		
			FixUtils.put(out,clientID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExecType()) {		
			FixUtils.put(out,execType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLeavesQty()) {		
			FixUtils.put(out, (long)leavesQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlBrkrCode()) {		
			FixUtils.put(out,settlBrkrCode); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasNoContraBrokers()) {		
			FixUtils.put(out, (long)noContraBrokers);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasContraBroker()) {		
			FixUtils.put(out,contraBroker); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradeReportID()) {		
			FixUtils.put(out,tradeReportID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradeReportType()) {		
			FixUtils.put(out,tradeReportType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTrdMatchID()) {		
			FixUtils.put(out,trdMatchID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSubMktID()) {		
			FixUtils.put(out,subMktID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClRefID()) {		
			FixUtils.put(out,clRefID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBrSeqNbr()) {		
			FixUtils.put(out,brSeqNbr); 		
		
	        out.put( (byte)' ' );		
		}		
		
		super.standardTrailer.encode(out);		
		
		int endPos = out.position();		
		
		// set body length		
				
		super.standardHeader.setBodyLength( out.position() - startPos );		
				
		out.position(startPos + FixUtils.FIX_HEADER); 		
		
		FixUtils.put( out, super.standardHeader.getBodyLength() );		
		
		out.position(endPos);		
		
	}			
			
	public void crackAvgPx() {		
		getAvgPx();		
	}		
			
	public long getAvgPx() { 		
		if ( hasAvgPx()) {		
			if (hasAvgPx == FixUtils.TAG_HAS_VALUE) {		
				return avgPx; 		
			} else {

				buf.position(hasAvgPx);

			avgPx = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasAvgPx = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return avgPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasAvgPx() { return hasAvgPx != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setAvgPx(byte[] src) {		
		if (src == null ) return;
		if (hasAvgPx()) avgPx = FixUtils.TAG_HAS_NO_VALUE;		
		avgPx = FixUtils.longValueOf(src, 0, src.length);
		hasAvgPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAvgPx(long src) {		
		avgPx = src;
		hasAvgPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setAvgPx(String str) {		
		if (str == null ) return;
		if (hasAvgPx()) avgPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		avgPx = FixUtils.longValueOf(src, 0, src.length);
		hasAvgPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackClOrdID() {		
		getClOrdID();		
	}		
			
	public byte[] getClOrdID() { 		
		if ( hasClOrdID()) {		
			if (hasClOrdID == FixUtils.TAG_HAS_VALUE) {		
				return clOrdID; 		
			} else {

				buf.position(hasClOrdID);

			FixMessage.getTagStringValue(buf, clOrdID, 0, clOrdID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasClOrdID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return clOrdID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasClOrdID() { return hasClOrdID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setClOrdID(byte[] src) {		
		if (src == null ) return;
		if (hasClOrdID()) FixUtils.fillSpace(clOrdID);		
		FixUtils.copy(clOrdID, src); 		
		hasClOrdID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setClOrdID(String str) {		
		if (str == null ) return;
		if (hasClOrdID()) FixUtils.fillSpace(clOrdID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(clOrdID, src); 		
		hasClOrdID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCumQty() {		
		getCumQty();		
	}		
			
	public long getCumQty() { 		
		if ( hasCumQty()) {		
			if (hasCumQty == FixUtils.TAG_HAS_VALUE) {		
				return cumQty; 		
			} else {

				buf.position(hasCumQty);

			cumQty = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasCumQty = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return cumQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasCumQty() { return hasCumQty != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCumQty(byte[] src) {		
		if (src == null ) return;
		if (hasCumQty()) cumQty = FixUtils.TAG_HAS_NO_VALUE;		
		cumQty = FixUtils.longValueOf(src, 0, src.length);
		hasCumQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCumQty(long src) {		
		cumQty = src;
		hasCumQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCumQty(String str) {		
		if (str == null ) return;
		if (hasCumQty()) cumQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		cumQty = FixUtils.longValueOf(src, 0, src.length);
		hasCumQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCurrency() {		
		getCurrency();		
	}		
			
	public byte[] getCurrency() { 		
		if ( hasCurrency()) {		
			if (hasCurrency == FixUtils.TAG_HAS_VALUE) {		
				return currency; 		
			} else {

				buf.position(hasCurrency);

			FixMessage.getTagStringValue(buf, currency, 0, currency.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasCurrency = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return currency;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCurrency() { return hasCurrency != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCurrency(byte[] src) {		
		if (src == null ) return;
		if (hasCurrency()) FixUtils.fillSpace(currency);		
		FixUtils.copy(currency, src); 		
		hasCurrency = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCurrency(String str) {		
		if (str == null ) return;
		if (hasCurrency()) FixUtils.fillSpace(currency);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(currency, src); 		
		hasCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackExecID() {		
		getExecID();		
	}		
			
	public byte[] getExecID() { 		
		if ( hasExecID()) {		
			if (hasExecID == FixUtils.TAG_HAS_VALUE) {		
				return execID; 		
			} else {

				buf.position(hasExecID);

			FixMessage.getTagStringValue(buf, execID, 0, execID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasExecID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return execID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasExecID() { return hasExecID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setExecID(byte[] src) {		
		if (src == null ) return;
		if (hasExecID()) FixUtils.fillSpace(execID);		
		FixUtils.copy(execID, src); 		
		hasExecID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExecID(String str) {		
		if (str == null ) return;
		if (hasExecID()) FixUtils.fillSpace(execID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(execID, src); 		
		hasExecID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackExecTransType() {		
		getExecTransType();		
	}		
			
	public byte getExecTransType() { 		
		if ( hasExecTransType()) {		
			if (hasExecTransType == FixUtils.TAG_HAS_VALUE) {		
				return execTransType; 		
			} else {

				buf.position(hasExecTransType);

			execTransType = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (execTransType != (byte)'2') && (execTransType != (byte)'1') && (execTransType != (byte)'0') && (execTransType != (byte)'8') && (execTransType != (byte)'I') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 20);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasExecTransType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return execTransType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasExecTransType() { return hasExecTransType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setExecTransType(byte[] src) {		
		if (src == null ) return;
		if (hasExecTransType()) execTransType = (byte)' ';		
		execTransType = src[0];		
		hasExecTransType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExecTransType(byte src) {		
		execTransType = src;
		hasExecTransType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExecTransType(String str) {		
		if (str == null ) return;
		if (hasExecTransType()) execTransType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		execTransType = src[0];		
		hasExecTransType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOrderID() {		
		getOrderID();		
	}		
			
	public byte[] getOrderID() { 		
		if ( hasOrderID()) {		
			if (hasOrderID == FixUtils.TAG_HAS_VALUE) {		
				return orderID; 		
			} else {

				buf.position(hasOrderID);

			FixMessage.getTagStringValue(buf, orderID, 0, orderID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasOrderID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return orderID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOrderID() { return hasOrderID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOrderID(byte[] src) {		
		if (src == null ) return;
		if (hasOrderID()) FixUtils.fillSpace(orderID);		
		FixUtils.copy(orderID, src); 		
		hasOrderID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrderID(String str) {		
		if (str == null ) return;
		if (hasOrderID()) FixUtils.fillSpace(orderID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(orderID, src); 		
		hasOrderID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOrdStatus() {		
		getOrdStatus();		
	}		
			
	public byte getOrdStatus() { 		
		if ( hasOrdStatus()) {		
			if (hasOrdStatus == FixUtils.TAG_HAS_VALUE) {		
				return ordStatus; 		
			} else {

				buf.position(hasOrdStatus);

			ordStatus = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (ordStatus != (byte)'2') && (ordStatus != (byte)'1') && (ordStatus != (byte)'0') && (ordStatus != (byte)'6') && (ordStatus != (byte)'5') && (ordStatus != (byte)'4') && (ordStatus != (byte)'8') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 39);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasOrdStatus = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return ordStatus;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasOrdStatus() { return hasOrdStatus != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOrdStatus(byte[] src) {		
		if (src == null ) return;
		if (hasOrdStatus()) ordStatus = (byte)' ';		
		ordStatus = src[0];		
		hasOrdStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrdStatus(byte src) {		
		ordStatus = src;
		hasOrdStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrdStatus(String str) {		
		if (str == null ) return;
		if (hasOrdStatus()) ordStatus = (byte)' ';		
		byte[] src = str.getBytes(); 		
		ordStatus = src[0];		
		hasOrdStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSecurityID() {		
		getSecurityID();		
	}		
			
	public byte[] getSecurityID() { 		
		if ( hasSecurityID()) {		
			if (hasSecurityID == FixUtils.TAG_HAS_VALUE) {		
				return securityID; 		
			} else {

				buf.position(hasSecurityID);

			FixMessage.getTagStringValue(buf, securityID, 0, securityID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSecurityID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return securityID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecurityID() { return hasSecurityID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSecurityID(byte[] src) {		
		if (src == null ) return;
		if (hasSecurityID()) FixUtils.fillSpace(securityID);		
		FixUtils.copy(securityID, src); 		
		hasSecurityID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecurityID(String str) {		
		if (str == null ) return;
		if (hasSecurityID()) FixUtils.fillSpace(securityID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(securityID, src); 		
		hasSecurityID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSide() {		
		getSide();		
	}		
			
	public byte getSide() { 		
		if ( hasSide()) {		
			if (hasSide == FixUtils.TAG_HAS_VALUE) {		
				return side; 		
			} else {

				buf.position(hasSide);

			side = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (side != (byte)'2') && (side != (byte)'1') && (side != (byte)'7') && (side != (byte)'8') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 54);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasSide = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return side;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasSide() { return hasSide != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSide(byte[] src) {		
		if (src == null ) return;
		if (hasSide()) side = (byte)' ';		
		side = src[0];		
		hasSide = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSide(byte src) {		
		side = src;
		hasSide = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSide(String str) {		
		if (str == null ) return;
		if (hasSide()) side = (byte)' ';		
		byte[] src = str.getBytes(); 		
		side = src[0];		
		hasSide = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSymbol() {		
		getSymbol();		
	}		
			
	public byte[] getSymbol() { 		
		if ( hasSymbol()) {		
			if (hasSymbol == FixUtils.TAG_HAS_VALUE) {		
				return symbol; 		
			} else {

				buf.position(hasSymbol);

			FixMessage.getTagStringValue(buf, symbol, 0, symbol.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSymbol = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return symbol;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSymbol() { return hasSymbol != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSymbol(byte[] src) {		
		if (src == null ) return;
		if (hasSymbol()) FixUtils.fillSpace(symbol);		
		FixUtils.copy(symbol, src); 		
		hasSymbol = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSymbol(String str) {		
		if (str == null ) return;
		if (hasSymbol()) FixUtils.fillSpace(symbol);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(symbol, src); 		
		hasSymbol = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackText() {		
		getText();		
	}		
			
	public byte[] getText() { 		
		if ( hasText()) {		
			if (hasText == FixUtils.TAG_HAS_VALUE) {		
				return text; 		
			} else {

				buf.position(hasText);

			FixMessage.getTagStringValue(buf, text, 0, text.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasText = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return text;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasText() { return hasText != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setText(byte[] src) {		
		if (src == null ) return;
		if (hasText()) FixUtils.fillSpace(text);		
		FixUtils.copy(text, src); 		
		hasText = FixUtils.TAG_HAS_VALUE;		
	}

	public void setText(String str) {		
		if (str == null ) return;
		if (hasText()) FixUtils.fillSpace(text);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(text, src); 		
		hasText = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackClientID() {		
		getClientID();		
	}		
			
	public byte[] getClientID() { 		
		if ( hasClientID()) {		
			if (hasClientID == FixUtils.TAG_HAS_VALUE) {		
				return clientID; 		
			} else {

				buf.position(hasClientID);

			FixMessage.getTagStringValue(buf, clientID, 0, clientID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasClientID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return clientID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasClientID() { return hasClientID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setClientID(byte[] src) {		
		if (src == null ) return;
		if (hasClientID()) FixUtils.fillSpace(clientID);		
		FixUtils.copy(clientID, src); 		
		hasClientID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setClientID(String str) {		
		if (str == null ) return;
		if (hasClientID()) FixUtils.fillSpace(clientID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(clientID, src); 		
		hasClientID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackExecType() {		
		getExecType();		
	}		
			
	public byte getExecType() { 		
		if ( hasExecType()) {		
			if (hasExecType == FixUtils.TAG_HAS_VALUE) {		
				return execType; 		
			} else {

				buf.position(hasExecType);

			execType = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (execType != (byte)'D') && (execType != (byte)'2') && (execType != (byte)'F') && (execType != (byte)'1') && (execType != (byte)'0') && (execType != (byte)'6') && (execType != (byte)'5') && (execType != (byte)'4') && (execType != (byte)'8') && (execType != (byte)'I') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 150);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasExecType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return execType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasExecType() { return hasExecType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setExecType(byte[] src) {		
		if (src == null ) return;
		if (hasExecType()) execType = (byte)' ';		
		execType = src[0];		
		hasExecType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExecType(byte src) {		
		execType = src;
		hasExecType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExecType(String str) {		
		if (str == null ) return;
		if (hasExecType()) execType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		execType = src[0];		
		hasExecType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackLeavesQty() {		
		getLeavesQty();		
	}		
			
	public long getLeavesQty() { 		
		if ( hasLeavesQty()) {		
			if (hasLeavesQty == FixUtils.TAG_HAS_VALUE) {		
				return leavesQty; 		
			} else {

				buf.position(hasLeavesQty);

			leavesQty = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasLeavesQty = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return leavesQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLeavesQty() { return hasLeavesQty != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setLeavesQty(byte[] src) {		
		if (src == null ) return;
		if (hasLeavesQty()) leavesQty = FixUtils.TAG_HAS_NO_VALUE;		
		leavesQty = FixUtils.longValueOf(src, 0, src.length);
		hasLeavesQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLeavesQty(long src) {		
		leavesQty = src;
		hasLeavesQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLeavesQty(String str) {		
		if (str == null ) return;
		if (hasLeavesQty()) leavesQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		leavesQty = FixUtils.longValueOf(src, 0, src.length);
		hasLeavesQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSettlBrkrCode() {		
		getSettlBrkrCode();		
	}		
			
	public byte[] getSettlBrkrCode() { 		
		if ( hasSettlBrkrCode()) {		
			if (hasSettlBrkrCode == FixUtils.TAG_HAS_VALUE) {		
				return settlBrkrCode; 		
			} else {

				buf.position(hasSettlBrkrCode);

			FixMessage.getTagStringValue(buf, settlBrkrCode, 0, settlBrkrCode.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSettlBrkrCode = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return settlBrkrCode;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSettlBrkrCode() { return hasSettlBrkrCode != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSettlBrkrCode(byte[] src) {		
		if (src == null ) return;
		if (hasSettlBrkrCode()) FixUtils.fillSpace(settlBrkrCode);		
		FixUtils.copy(settlBrkrCode, src); 		
		hasSettlBrkrCode = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlBrkrCode(String str) {		
		if (str == null ) return;
		if (hasSettlBrkrCode()) FixUtils.fillSpace(settlBrkrCode);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlBrkrCode, src); 		
		hasSettlBrkrCode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackNoContraBrokers() {		
		getNoContraBrokers();		
	}		
			
	public long getNoContraBrokers() { 		
		if ( hasNoContraBrokers()) {		
			if (hasNoContraBrokers == FixUtils.TAG_HAS_VALUE) {		
				return noContraBrokers; 		
			} else {

				buf.position(hasNoContraBrokers);

			noContraBrokers = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasNoContraBrokers = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return noContraBrokers;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasNoContraBrokers() { return hasNoContraBrokers != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setNoContraBrokers(byte[] src) {		
		if (src == null ) return;
		if (hasNoContraBrokers()) noContraBrokers = FixUtils.TAG_HAS_NO_VALUE;		
		noContraBrokers = FixUtils.longValueOf(src, 0, src.length);
		hasNoContraBrokers = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNoContraBrokers(long src) {		
		noContraBrokers = src;
		hasNoContraBrokers = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNoContraBrokers(String str) {		
		if (str == null ) return;
		if (hasNoContraBrokers()) noContraBrokers = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		noContraBrokers = FixUtils.longValueOf(src, 0, src.length);
		hasNoContraBrokers = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackContraBroker() {		
		getContraBroker();		
	}		
			
	public byte[] getContraBroker() { 		
		if ( hasContraBroker()) {		
			if (hasContraBroker == FixUtils.TAG_HAS_VALUE) {		
				return contraBroker; 		
			} else {

				buf.position(hasContraBroker);

			FixMessage.getTagStringValue(buf, contraBroker, 0, contraBroker.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasContraBroker = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return contraBroker;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasContraBroker() { return hasContraBroker != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setContraBroker(byte[] src) {		
		if (src == null ) return;
		if (hasContraBroker()) FixUtils.fillSpace(contraBroker);		
		FixUtils.copy(contraBroker, src); 		
		hasContraBroker = FixUtils.TAG_HAS_VALUE;		
	}

	public void setContraBroker(String str) {		
		if (str == null ) return;
		if (hasContraBroker()) FixUtils.fillSpace(contraBroker);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(contraBroker, src); 		
		hasContraBroker = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTradeReportID() {		
		getTradeReportID();		
	}		
			
	public byte[] getTradeReportID() { 		
		if ( hasTradeReportID()) {		
			if (hasTradeReportID == FixUtils.TAG_HAS_VALUE) {		
				return tradeReportID; 		
			} else {

				buf.position(hasTradeReportID);

			FixMessage.getTagStringValue(buf, tradeReportID, 0, tradeReportID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasTradeReportID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return tradeReportID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradeReportID() { return hasTradeReportID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTradeReportID(byte[] src) {		
		if (src == null ) return;
		if (hasTradeReportID()) FixUtils.fillSpace(tradeReportID);		
		FixUtils.copy(tradeReportID, src); 		
		hasTradeReportID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradeReportID(String str) {		
		if (str == null ) return;
		if (hasTradeReportID()) FixUtils.fillSpace(tradeReportID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradeReportID, src); 		
		hasTradeReportID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTradeReportType() {		
		getTradeReportType();		
	}		
			
	public byte[] getTradeReportType() { 		
		if ( hasTradeReportType()) {		
			if (hasTradeReportType == FixUtils.TAG_HAS_VALUE) {		
				return tradeReportType; 		
			} else {

				buf.position(hasTradeReportType);

			FixMessage.getTagStringValue(buf, tradeReportType, 0, tradeReportType.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasTradeReportType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return tradeReportType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradeReportType() { return hasTradeReportType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTradeReportType(byte[] src) {		
		if (src == null ) return;
		if (hasTradeReportType()) FixUtils.fillSpace(tradeReportType);		
		FixUtils.copy(tradeReportType, src); 		
		hasTradeReportType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradeReportType(String str) {		
		if (str == null ) return;
		if (hasTradeReportType()) FixUtils.fillSpace(tradeReportType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradeReportType, src); 		
		hasTradeReportType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTrdMatchID() {		
		getTrdMatchID();		
	}		
			
	public byte[] getTrdMatchID() { 		
		if ( hasTrdMatchID()) {		
			if (hasTrdMatchID == FixUtils.TAG_HAS_VALUE) {		
				return trdMatchID; 		
			} else {

				buf.position(hasTrdMatchID);

			FixMessage.getTagStringValue(buf, trdMatchID, 0, trdMatchID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasTrdMatchID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return trdMatchID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTrdMatchID() { return hasTrdMatchID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTrdMatchID(byte[] src) {		
		if (src == null ) return;
		if (hasTrdMatchID()) FixUtils.fillSpace(trdMatchID);		
		FixUtils.copy(trdMatchID, src); 		
		hasTrdMatchID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTrdMatchID(String str) {		
		if (str == null ) return;
		if (hasTrdMatchID()) FixUtils.fillSpace(trdMatchID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(trdMatchID, src); 		
		hasTrdMatchID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSubMktID() {		
		getSubMktID();		
	}		
			
	public byte[] getSubMktID() { 		
		if ( hasSubMktID()) {		
			if (hasSubMktID == FixUtils.TAG_HAS_VALUE) {		
				return subMktID; 		
			} else {

				buf.position(hasSubMktID);

			FixMessage.getTagStringValue(buf, subMktID, 0, subMktID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSubMktID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return subMktID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSubMktID() { return hasSubMktID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSubMktID(byte[] src) {		
		if (src == null ) return;
		if (hasSubMktID()) FixUtils.fillSpace(subMktID);		
		FixUtils.copy(subMktID, src); 		
		hasSubMktID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSubMktID(String str) {		
		if (str == null ) return;
		if (hasSubMktID()) FixUtils.fillSpace(subMktID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(subMktID, src); 		
		hasSubMktID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackClRefID() {		
		getClRefID();		
	}		
			
	public byte[] getClRefID() { 		
		if ( hasClRefID()) {		
			if (hasClRefID == FixUtils.TAG_HAS_VALUE) {		
				return clRefID; 		
			} else {

				buf.position(hasClRefID);

			FixMessage.getTagStringValue(buf, clRefID, 0, clRefID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasClRefID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return clRefID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasClRefID() { return hasClRefID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setClRefID(byte[] src) {		
		if (src == null ) return;
		if (hasClRefID()) FixUtils.fillSpace(clRefID);		
		FixUtils.copy(clRefID, src); 		
		hasClRefID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setClRefID(String str) {		
		if (str == null ) return;
		if (hasClRefID()) FixUtils.fillSpace(clRefID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(clRefID, src); 		
		hasClRefID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackBrSeqNbr() {		
		getBrSeqNbr();		
	}		
			
	public byte[] getBrSeqNbr() { 		
		if ( hasBrSeqNbr()) {		
			if (hasBrSeqNbr == FixUtils.TAG_HAS_VALUE) {		
				return brSeqNbr; 		
			} else {

				buf.position(hasBrSeqNbr);

			FixMessage.getTagStringValue(buf, brSeqNbr, 0, brSeqNbr.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasBrSeqNbr = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return brSeqNbr;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasBrSeqNbr() { return hasBrSeqNbr != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setBrSeqNbr(byte[] src) {		
		if (src == null ) return;
		if (hasBrSeqNbr()) FixUtils.fillSpace(brSeqNbr);		
		FixUtils.copy(brSeqNbr, src); 		
		hasBrSeqNbr = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBrSeqNbr(String str) {		
		if (str == null ) return;
		if (hasBrSeqNbr()) FixUtils.fillSpace(brSeqNbr);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(brSeqNbr, src); 		
		hasBrSeqNbr = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
		try {
					if (standardHeader.hasBeginString()) s += "BeginString(8)= " + new String( FixUtils.trim(standardHeader.getBeginString()) ) + "\n" ; 
		if (standardHeader.hasBodyLength()) s += "BodyLength(9)= " + standardHeader.getBodyLength() + "\n" ; 
		if (standardHeader.hasMsgType()) s += "MsgType(35)= " + new String( FixUtils.trim(standardHeader.getMsgType()) ) + "\n" ; 
		if (standardHeader.hasMsgSeqNum()) s += "MsgSeqNum(34)= " + standardHeader.getMsgSeqNum() + "\n" ; 
		if (standardHeader.hasPossDupFlag()) s += "PossDupFlag(43)= " + standardHeader.getPossDupFlag() + "\n" ; 
		if (standardHeader.hasSenderCompID()) s += "SenderCompID(49)= " + new String( FixUtils.trim(standardHeader.getSenderCompID()) ) + "\n" ; 
		if (standardHeader.hasSenderSubID()) s += "SenderSubID(50)= " + new String( FixUtils.trim(standardHeader.getSenderSubID()) ) + "\n" ; 
		if (standardHeader.hasSendingTime()) s += "SendingTime(52)= " + new String( FixUtils.trim(standardHeader.getSendingTime()) ) + "\n" ; 
		if (standardHeader.hasTargetCompID()) s += "TargetCompID(56)= " + new String( FixUtils.trim(standardHeader.getTargetCompID()) ) + "\n" ; 
		if (standardHeader.hasTargetSubID()) s += "TargetSubID(57)= " + new String( FixUtils.trim(standardHeader.getTargetSubID()) ) + "\n" ; 
		if (standardHeader.hasPossResend()) s += "PossResend(97)= " + standardHeader.getPossResend() + "\n" ; 
		if (standardHeader.hasOnBehalfOfCompID()) s += "OnBehalfOfCompID(115)= " + new String( FixUtils.trim(standardHeader.getOnBehalfOfCompID()) ) + "\n" ; 
		if (standardHeader.hasOnBehalfOfSubID()) s += "OnBehalfOfSubID(116)= " + new String( FixUtils.trim(standardHeader.getOnBehalfOfSubID()) ) + "\n" ; 
		if (standardHeader.hasOrigSendingTime()) s += "OrigSendingTime(122)= " + new String( FixUtils.trim(standardHeader.getOrigSendingTime()) ) + "\n" ; 
		if (standardHeader.hasDeliverToCompID()) s += "DeliverToCompID(128)= " + new String( FixUtils.trim(standardHeader.getDeliverToCompID()) ) + "\n" ; 
		if (standardHeader.hasDeliverToSubID()) s += "DeliverToSubID(129)= " + new String( FixUtils.trim(standardHeader.getDeliverToSubID()) ) + "\n" ; 

					if (hasAvgPx()) s += "AvgPx(6)= " + getAvgPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasClOrdID()) s += "ClOrdID(11)= " + new String( FixUtils.trim(getClOrdID()) ) + "\n" ; 
		if (hasCumQty()) s += "CumQty(14)= " + getCumQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasCurrency()) s += "Currency(15)= " + new String( FixUtils.trim(getCurrency()) ) + "\n" ; 
		if (hasExecID()) s += "ExecID(17)= " + new String( FixUtils.trim(getExecID()) ) + "\n" ; 
		if (hasExecTransType()) s += "ExecTransType(20)= " + getExecTransType() + "\n" ; 
		if (hasOrderID()) s += "OrderID(37)= " + new String( FixUtils.trim(getOrderID()) ) + "\n" ; 
		if (hasOrdStatus()) s += "OrdStatus(39)= " + getOrdStatus() + "\n" ; 
		if (hasSecurityID()) s += "SecurityID(48)= " + new String( FixUtils.trim(getSecurityID()) ) + "\n" ; 
		if (hasSide()) s += "Side(54)= " + getSide() + "\n" ; 
		if (hasSymbol()) s += "Symbol(55)= " + new String( FixUtils.trim(getSymbol()) ) + "\n" ; 
		if (hasText()) s += "Text(58)= " + new String( FixUtils.trim(getText()) ) + "\n" ; 
		if (hasClientID()) s += "ClientID(109)= " + new String( FixUtils.trim(getClientID()) ) + "\n" ; 
		if (hasExecType()) s += "ExecType(150)= " + getExecType() + "\n" ; 
		if (hasLeavesQty()) s += "LeavesQty(151)= " + getLeavesQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasSettlBrkrCode()) s += "SettlBrkrCode(174)= " + new String( FixUtils.trim(getSettlBrkrCode()) ) + "\n" ; 
		if (hasNoContraBrokers()) s += "NoContraBrokers(382)= " + getNoContraBrokers() + "\n" ; 
		if (hasContraBroker()) s += "ContraBroker(375)= " + new String( FixUtils.trim(getContraBroker()) ) + "\n" ; 
		if (hasTradeReportID()) s += "TradeReportID(571)= " + new String( FixUtils.trim(getTradeReportID()) ) + "\n" ; 
		if (hasTradeReportType()) s += "TradeReportType(856)= " + new String( FixUtils.trim(getTradeReportType()) ) + "\n" ; 
		if (hasTrdMatchID()) s += "TrdMatchID(880)= " + new String( FixUtils.trim(getTrdMatchID()) ) + "\n" ; 
		if (hasSubMktID()) s += "SubMktID(5815)= " + new String( FixUtils.trim(getSubMktID()) ) + "\n" ; 
		if (hasClRefID()) s += "ClRefID(6209)= " + new String( FixUtils.trim(getClRefID()) ) + "\n" ; 
		if (hasBrSeqNbr()) s += "BrSeqNbr(9861)= " + new String( FixUtils.trim(getBrSeqNbr()) ) + "\n" ; 

					if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixCancelNotification)) return false;

		FixCancelNotification msg = (FixCancelNotification) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasAvgPx() && !msg.hasAvgPx()) || (!hasAvgPx() && msg.hasAvgPx())) return false;
		if (!(!hasAvgPx() && !msg.hasAvgPx()) && !(getAvgPx()==msg.getAvgPx())) return false;
		if ((hasClOrdID() && !msg.hasClOrdID()) || (!hasClOrdID() && msg.hasClOrdID())) return false;
		if (!(!hasClOrdID() && !msg.hasClOrdID()) && !FixUtils.equals(getClOrdID(), msg.getClOrdID())) return false;
		if ((hasCumQty() && !msg.hasCumQty()) || (!hasCumQty() && msg.hasCumQty())) return false;
		if (!(!hasCumQty() && !msg.hasCumQty()) && !(getCumQty()==msg.getCumQty())) return false;
		if ((hasCurrency() && !msg.hasCurrency()) || (!hasCurrency() && msg.hasCurrency())) return false;
		if (!(!hasCurrency() && !msg.hasCurrency()) && !FixUtils.equals(getCurrency(), msg.getCurrency())) return false;
		if ((hasExecID() && !msg.hasExecID()) || (!hasExecID() && msg.hasExecID())) return false;
		if (!(!hasExecID() && !msg.hasExecID()) && !FixUtils.equals(getExecID(), msg.getExecID())) return false;
		if ((hasExecTransType() && !msg.hasExecTransType()) || (!hasExecTransType() && msg.hasExecTransType())) return false;
		if (!(!hasExecTransType() && !msg.hasExecTransType()) && !(getExecTransType()==msg.getExecTransType())) return false;
		if ((hasOrderID() && !msg.hasOrderID()) || (!hasOrderID() && msg.hasOrderID())) return false;
		if (!(!hasOrderID() && !msg.hasOrderID()) && !FixUtils.equals(getOrderID(), msg.getOrderID())) return false;
		if ((hasOrdStatus() && !msg.hasOrdStatus()) || (!hasOrdStatus() && msg.hasOrdStatus())) return false;
		if (!(!hasOrdStatus() && !msg.hasOrdStatus()) && !(getOrdStatus()==msg.getOrdStatus())) return false;
		if ((hasSecurityID() && !msg.hasSecurityID()) || (!hasSecurityID() && msg.hasSecurityID())) return false;
		if (!(!hasSecurityID() && !msg.hasSecurityID()) && !FixUtils.equals(getSecurityID(), msg.getSecurityID())) return false;
		if ((hasSide() && !msg.hasSide()) || (!hasSide() && msg.hasSide())) return false;
		if (!(!hasSide() && !msg.hasSide()) && !(getSide()==msg.getSide())) return false;
		if ((hasSymbol() && !msg.hasSymbol()) || (!hasSymbol() && msg.hasSymbol())) return false;
		if (!(!hasSymbol() && !msg.hasSymbol()) && !FixUtils.equals(getSymbol(), msg.getSymbol())) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasClientID() && !msg.hasClientID()) || (!hasClientID() && msg.hasClientID())) return false;
		if (!(!hasClientID() && !msg.hasClientID()) && !FixUtils.equals(getClientID(), msg.getClientID())) return false;
		if ((hasExecType() && !msg.hasExecType()) || (!hasExecType() && msg.hasExecType())) return false;
		if (!(!hasExecType() && !msg.hasExecType()) && !(getExecType()==msg.getExecType())) return false;
		if ((hasLeavesQty() && !msg.hasLeavesQty()) || (!hasLeavesQty() && msg.hasLeavesQty())) return false;
		if (!(!hasLeavesQty() && !msg.hasLeavesQty()) && !(getLeavesQty()==msg.getLeavesQty())) return false;
		if ((hasSettlBrkrCode() && !msg.hasSettlBrkrCode()) || (!hasSettlBrkrCode() && msg.hasSettlBrkrCode())) return false;
		if (!(!hasSettlBrkrCode() && !msg.hasSettlBrkrCode()) && !FixUtils.equals(getSettlBrkrCode(), msg.getSettlBrkrCode())) return false;
		if ((hasNoContraBrokers() && !msg.hasNoContraBrokers()) || (!hasNoContraBrokers() && msg.hasNoContraBrokers())) return false;
		if (!(!hasNoContraBrokers() && !msg.hasNoContraBrokers()) && !(getNoContraBrokers()==msg.getNoContraBrokers())) return false;
		if ((hasContraBroker() && !msg.hasContraBroker()) || (!hasContraBroker() && msg.hasContraBroker())) return false;
		if (!(!hasContraBroker() && !msg.hasContraBroker()) && !FixUtils.equals(getContraBroker(), msg.getContraBroker())) return false;
		if ((hasTradeReportID() && !msg.hasTradeReportID()) || (!hasTradeReportID() && msg.hasTradeReportID())) return false;
		if (!(!hasTradeReportID() && !msg.hasTradeReportID()) && !FixUtils.equals(getTradeReportID(), msg.getTradeReportID())) return false;
		if ((hasTradeReportType() && !msg.hasTradeReportType()) || (!hasTradeReportType() && msg.hasTradeReportType())) return false;
		if (!(!hasTradeReportType() && !msg.hasTradeReportType()) && !FixUtils.equals(getTradeReportType(), msg.getTradeReportType())) return false;
		if ((hasTrdMatchID() && !msg.hasTrdMatchID()) || (!hasTrdMatchID() && msg.hasTrdMatchID())) return false;
		if (!(!hasTrdMatchID() && !msg.hasTrdMatchID()) && !FixUtils.equals(getTrdMatchID(), msg.getTrdMatchID())) return false;
		if ((hasSubMktID() && !msg.hasSubMktID()) || (!hasSubMktID() && msg.hasSubMktID())) return false;
		if (!(!hasSubMktID() && !msg.hasSubMktID()) && !FixUtils.equals(getSubMktID(), msg.getSubMktID())) return false;
		if ((hasClRefID() && !msg.hasClRefID()) || (!hasClRefID() && msg.hasClRefID())) return false;
		if (!(!hasClRefID() && !msg.hasClRefID()) && !FixUtils.equals(getClRefID(), msg.getClRefID())) return false;
		if ((hasBrSeqNbr() && !msg.hasBrSeqNbr()) || (!hasBrSeqNbr() && msg.hasBrSeqNbr())) return false;
		if (!(!hasBrSeqNbr() && !msg.hasBrSeqNbr()) && !FixUtils.equals(getBrSeqNbr(), msg.getBrSeqNbr())) return false;
		return true;
	}
	@Override
	public FixCancelNotification clone () {
		FixCancelNotification out = (FixCancelNotification) FixUtils.fixMessagePool.getFixMessage(FixMessageInfo.MessageTypes.CANCELNOTIFICATION_INT);

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixCancelNotification clone ( FixCancelNotification out ) {
		if ( hasAvgPx())
			out.setAvgPx(getAvgPx());
		if ( hasClOrdID())
			out.setClOrdID(getClOrdID());
		if ( hasCumQty())
			out.setCumQty(getCumQty());
		if ( hasCurrency())
			out.setCurrency(getCurrency());
		if ( hasExecID())
			out.setExecID(getExecID());
		if ( hasExecTransType())
			out.setExecTransType(getExecTransType());
		if ( hasOrderID())
			out.setOrderID(getOrderID());
		if ( hasOrdStatus())
			out.setOrdStatus(getOrdStatus());
		if ( hasSecurityID())
			out.setSecurityID(getSecurityID());
		if ( hasSide())
			out.setSide(getSide());
		if ( hasSymbol())
			out.setSymbol(getSymbol());
		if ( hasText())
			out.setText(getText());
		if ( hasClientID())
			out.setClientID(getClientID());
		if ( hasExecType())
			out.setExecType(getExecType());
		if ( hasLeavesQty())
			out.setLeavesQty(getLeavesQty());
		if ( hasSettlBrkrCode())
			out.setSettlBrkrCode(getSettlBrkrCode());
		if ( hasNoContraBrokers())
			out.setNoContraBrokers(getNoContraBrokers());
		if ( hasContraBroker())
			out.setContraBroker(getContraBroker());
		if ( hasTradeReportID())
			out.setTradeReportID(getTradeReportID());
		if ( hasTradeReportType())
			out.setTradeReportType(getTradeReportType());
		if ( hasTrdMatchID())
			out.setTrdMatchID(getTrdMatchID());
		if ( hasSubMktID())
			out.setSubMktID(getSubMktID());
		if ( hasClRefID())
			out.setClRefID(getClRefID());
		if ( hasBrSeqNbr())
			out.setBrSeqNbr(getBrSeqNbr());
		return out;
	}

}
