package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixOrderSingle extends FixInMessage {
	private short hasClOrdID;
	byte[] clOrdID = new byte[20];		
	private short hasCurrency;
	byte[] currency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasExecInst;
	byte[] execInst = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasHandlInst;
	byte handlInst = (byte)' ';		
	private short hasOrderQty;
	long orderQty = 0;		
	private short hasOrdType;
	byte ordType = (byte)' ';		
	private short hasPrice;
	long price = 0;		
	private short hasSecurityID;
	byte[] securityID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSide;
	byte side = (byte)' ';		
	private short hasSymbol;
	byte[] symbol = new byte[8];		
	private short hasTimeInForce;
	byte timeInForce = (byte)' ';		
	private short hasTransactTime;
	byte[] transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasExecBroker;
	byte[] execBroker = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMinQty;
	long minQty = 0;		
	private short hasMaxFloor;
	long maxFloor = 0;		
	private short hasExpireTime;
	byte[] expireTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasPegDifference;
	long pegDifference = 0;		
	private short hasDiscretionInst;
	byte discretionInst = (byte)' ';		
	private short hasDiscretionOffset;
	long discretionOffset = 0;		
	private short hasClearingFirm;
	byte[] clearingFirm = new byte[4];		
	private short hasClearingAccount;
	byte[] clearingAccount = new byte[12];		
	private short hasOrderCapacity;
	byte[] orderCapacity = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasOrderRestrictions;
	byte[] orderRestrictions = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSubMktID;
	byte[] subMktID = new byte[3];		
	private short hasClRefID;
	byte[] clRefID = new byte[15];		
	private short hasDisplayInst;
	byte displayInst = (byte)' ';		
	private short hasCrossTradeFlag;
	byte crossTradeFlag = (byte)' ';		
	private short hasBrSeqNbr;
	byte[] brSeqNbr = new byte[10];		
	
	public FixOrderSingle() {
		super(FixMessageInfo.MessageTypes.ORDERSINGLE);


		hasClOrdID = FixUtils.TAG_HAS_NO_VALUE;		
		clOrdID = new byte[20];		
		hasCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		currency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasExecInst = FixUtils.TAG_HAS_NO_VALUE;		
		execInst = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasHandlInst = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrderQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrdType = FixUtils.TAG_HAS_NO_VALUE;		
		hasPrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasSecurityID = FixUtils.TAG_HAS_NO_VALUE;		
		securityID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSide = FixUtils.TAG_HAS_NO_VALUE;		
		hasSymbol = FixUtils.TAG_HAS_NO_VALUE;		
		symbol = new byte[8];		
		hasTimeInForce = FixUtils.TAG_HAS_NO_VALUE;		
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;		
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasExecBroker = FixUtils.TAG_HAS_NO_VALUE;		
		execBroker = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMinQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasMaxFloor = FixUtils.TAG_HAS_NO_VALUE;		
		hasExpireTime = FixUtils.TAG_HAS_NO_VALUE;		
		expireTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasPegDifference = FixUtils.TAG_HAS_NO_VALUE;		
		hasDiscretionInst = FixUtils.TAG_HAS_NO_VALUE;		
		hasDiscretionOffset = FixUtils.TAG_HAS_NO_VALUE;		
		hasClearingFirm = FixUtils.TAG_HAS_NO_VALUE;		
		clearingFirm = new byte[4];		
		hasClearingAccount = FixUtils.TAG_HAS_NO_VALUE;		
		clearingAccount = new byte[12];		
		hasOrderCapacity = FixUtils.TAG_HAS_NO_VALUE;		
		orderCapacity = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasOrderRestrictions = FixUtils.TAG_HAS_NO_VALUE;		
		orderRestrictions = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSubMktID = FixUtils.TAG_HAS_NO_VALUE;		
		subMktID = new byte[3];		
		hasClRefID = FixUtils.TAG_HAS_NO_VALUE;		
		clRefID = new byte[15];		
		hasDisplayInst = FixUtils.TAG_HAS_NO_VALUE;		
		hasCrossTradeFlag = FixUtils.TAG_HAS_NO_VALUE;		
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
            	case FixTags.CLORDID_INT:		
            		hasClOrdID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CURRENCY_INT:		
            		hasCurrency = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.EXECINST_INT:		
            		hasExecInst = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.HANDLINST_INT:		
            		hasHandlInst = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ORDERQTY_INT:		
            		hasOrderQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ORDTYPE_INT:		
            		hasOrdType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.PRICE_INT:		
            		hasPrice = (short) buf.position();		
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
            	case FixTags.TIMEINFORCE_INT:		
            		hasTimeInForce = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.TRANSACTTIME_INT:		
            		hasTransactTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.EXECBROKER_INT:		
            		hasExecBroker = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MINQTY_INT:		
            		hasMinQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.MAXFLOOR_INT:		
            		hasMaxFloor = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.EXPIRETIME_INT:		
            		hasExpireTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.PEGDIFFERENCE_INT:		
            		hasPegDifference = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.DISCRETIONINST_INT:		
            		hasDiscretionInst = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.DISCRETIONOFFSET_INT:		
            		hasDiscretionOffset = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CLEARINGFIRM_INT:		
            		hasClearingFirm = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CLEARINGACCOUNT_INT:		
            		hasClearingAccount = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ORDERCAPACITY_INT:		
            		hasOrderCapacity = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.ORDERRESTRICTIONS_INT:		
            		hasOrderRestrictions = (short) buf.position();		
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
            	case FixTags.DISPLAYINST_INT:		
            		hasDisplayInst = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break;
            	case FixTags.CROSSTRADEFLAG_INT:		
            		hasCrossTradeFlag = (short) buf.position();		
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
		if (!hasClOrdID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag ClOrdID missing", FixTags.CLORDID_INT, FixMessageInfo.MessageTypes.ORDERSINGLE);
			return false;
		}
		if (!hasHandlInst()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag HandlInst missing", FixTags.HANDLINST_INT, FixMessageInfo.MessageTypes.ORDERSINGLE);
			return false;
		}
		if (!hasOrderQty()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag OrderQty missing", FixTags.ORDERQTY_INT, FixMessageInfo.MessageTypes.ORDERSINGLE);
			return false;
		}
		if (!hasOrdType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag OrdType missing", FixTags.ORDTYPE_INT, FixMessageInfo.MessageTypes.ORDERSINGLE);
			return false;
		}
		if (!hasSide()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag Side missing", FixTags.SIDE_INT, FixMessageInfo.MessageTypes.ORDERSINGLE);
			return false;
		}
		if (!hasSymbol()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag Symbol missing", FixTags.SYMBOL_INT, FixMessageInfo.MessageTypes.ORDERSINGLE);
			return false;
		}
		if (!hasTransactTime()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "requirde tag TransactTime missing", FixTags.TRANSACTTIME_INT, FixMessageInfo.MessageTypes.ORDERSINGLE);
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
		if (hasClOrdID()) {		
			out.put(FixTags.CLORDID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clOrdID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCurrency()) {		
			out.put(FixTags.CURRENCY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,currency); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasExecInst()) {		
			out.put(FixTags.EXECINST);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,execInst); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasHandlInst()) {		
			out.put(FixTags.HANDLINST);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,handlInst); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOrderQty()) {		
			out.put(FixTags.ORDERQTY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)orderQty);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOrdType()) {		
			out.put(FixTags.ORDTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,ordType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPrice()) {		
			out.put(FixTags.PRICE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)price);
		
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
		if (hasTimeInForce()) {		
			out.put(FixTags.TIMEINFORCE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,timeInForce); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTransactTime()) {		
			out.put(FixTags.TRANSACTTIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,transactTime); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasExecBroker()) {		
			out.put(FixTags.EXECBROKER);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,execBroker); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMinQty()) {		
			out.put(FixTags.MINQTY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)minQty);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMaxFloor()) {		
			out.put(FixTags.MAXFLOOR);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)maxFloor);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasExpireTime()) {		
			out.put(FixTags.EXPIRETIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,expireTime); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPegDifference()) {		
			out.put(FixTags.PEGDIFFERENCE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)pegDifference);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasDiscretionInst()) {		
			out.put(FixTags.DISCRETIONINST);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,discretionInst); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasDiscretionOffset()) {		
			out.put(FixTags.DISCRETIONOFFSET);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)discretionOffset);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasClearingFirm()) {		
			out.put(FixTags.CLEARINGFIRM);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clearingFirm); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasClearingAccount()) {		
			out.put(FixTags.CLEARINGACCOUNT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,clearingAccount); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOrderCapacity()) {		
			out.put(FixTags.ORDERCAPACITY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,orderCapacity); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOrderRestrictions()) {		
			out.put(FixTags.ORDERRESTRICTIONS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,orderRestrictions); 		
		
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
		if (hasDisplayInst()) {		
			out.put(FixTags.DISPLAYINST);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,displayInst); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCrossTradeFlag()) {		
			out.put(FixTags.CROSSTRADEFLAG);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,crossTradeFlag); 		
		
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
		
		if (hasClOrdID()) {		
			FixUtils.put(out,clOrdID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCurrency()) {		
			FixUtils.put(out,currency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExecInst()) {		
			FixUtils.put(out,execInst); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasHandlInst()) {		
			FixUtils.put(out,handlInst); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrderQty()) {		
			FixUtils.put(out, (long)orderQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrdType()) {		
			FixUtils.put(out,ordType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPrice()) {		
			FixUtils.put(out, (long)price);
		
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
		
		if (hasTimeInForce()) {		
			FixUtils.put(out,timeInForce); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTransactTime()) {		
			FixUtils.put(out,transactTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExecBroker()) {		
			FixUtils.put(out,execBroker); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMinQty()) {		
			FixUtils.put(out, (long)minQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMaxFloor()) {		
			FixUtils.put(out, (long)maxFloor);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExpireTime()) {		
			FixUtils.put(out,expireTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPegDifference()) {		
			FixUtils.put(out, (long)pegDifference);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDiscretionInst()) {		
			FixUtils.put(out,discretionInst); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDiscretionOffset()) {		
			FixUtils.put(out, (long)discretionOffset);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClearingFirm()) {		
			FixUtils.put(out,clearingFirm); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClearingAccount()) {		
			FixUtils.put(out,clearingAccount); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrderCapacity()) {		
			FixUtils.put(out,orderCapacity); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrderRestrictions()) {		
			FixUtils.put(out,orderRestrictions); 		
		
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
		
		if (hasDisplayInst()) {		
			FixUtils.put(out,displayInst); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCrossTradeFlag()) {		
			FixUtils.put(out,crossTradeFlag); 		
		
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
			
	public void crackExecInst() {		
		getExecInst();		
	}		
			
	public byte[] getExecInst() { 		
		if ( hasExecInst()) {		
			if (hasExecInst == FixUtils.TAG_HAS_VALUE) {		
				return execInst; 		
			} else {

				buf.position(hasExecInst);

			FixMessage.getTagStringValue(buf, execInst, 0, execInst.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasExecInst = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return execInst;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasExecInst() { return hasExecInst != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setExecInst(byte[] src) {		
		if (src == null ) return;
		if (hasExecInst()) FixUtils.fillSpace(execInst);		
		FixUtils.copy(execInst, src); 		
		hasExecInst = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExecInst(String str) {		
		if (str == null ) return;
		if (hasExecInst()) FixUtils.fillSpace(execInst);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(execInst, src); 		
		hasExecInst = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackHandlInst() {		
		getHandlInst();		
	}		
			
	public byte getHandlInst() { 		
		if ( hasHandlInst()) {		
			if (hasHandlInst == FixUtils.TAG_HAS_VALUE) {		
				return handlInst; 		
			} else {

				buf.position(hasHandlInst);

			handlInst = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (handlInst != (byte)'1') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 21);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasHandlInst = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return handlInst;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasHandlInst() { return hasHandlInst != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setHandlInst(byte[] src) {		
		if (src == null ) return;
		if (hasHandlInst()) handlInst = (byte)' ';		
		handlInst = src[0];		
		hasHandlInst = FixUtils.TAG_HAS_VALUE;		
	}

	public void setHandlInst(byte src) {		
		handlInst = src;
		hasHandlInst = FixUtils.TAG_HAS_VALUE;		
	}

	public void setHandlInst(String str) {		
		if (str == null ) return;
		if (hasHandlInst()) handlInst = (byte)' ';		
		byte[] src = str.getBytes(); 		
		handlInst = src[0];		
		hasHandlInst = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOrderQty() {		
		getOrderQty();		
	}		
			
	public long getOrderQty() { 		
		if ( hasOrderQty()) {		
			if (hasOrderQty == FixUtils.TAG_HAS_VALUE) {		
				return orderQty; 		
			} else {

				buf.position(hasOrderQty);

			orderQty = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasOrderQty = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return orderQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasOrderQty() { return hasOrderQty != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOrderQty(byte[] src) {		
		if (src == null ) return;
		if (hasOrderQty()) orderQty = FixUtils.TAG_HAS_NO_VALUE;		
		orderQty = FixUtils.longValueOf(src, 0, src.length);
		hasOrderQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrderQty(long src) {		
		orderQty = src;
		hasOrderQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrderQty(String str) {		
		if (str == null ) return;
		if (hasOrderQty()) orderQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		orderQty = FixUtils.longValueOf(src, 0, src.length);
		hasOrderQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOrdType() {		
		getOrdType();		
	}		
			
	public byte getOrdType() { 		
		if ( hasOrdType()) {		
			if (hasOrdType == FixUtils.TAG_HAS_VALUE) {		
				return ordType; 		
			} else {

				buf.position(hasOrdType);

			ordType = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (ordType != (byte)'2') && (ordType != (byte)'1') && (ordType != (byte)'P') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 40);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasOrdType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return ordType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasOrdType() { return hasOrdType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOrdType(byte[] src) {		
		if (src == null ) return;
		if (hasOrdType()) ordType = (byte)' ';		
		ordType = src[0];		
		hasOrdType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrdType(byte src) {		
		ordType = src;
		hasOrdType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrdType(String str) {		
		if (str == null ) return;
		if (hasOrdType()) ordType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		ordType = src[0];		
		hasOrdType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackPrice() {		
		getPrice();		
	}		
			
	public long getPrice() { 		
		if ( hasPrice()) {		
			if (hasPrice == FixUtils.TAG_HAS_VALUE) {		
				return price; 		
			} else {

				buf.position(hasPrice);

			price = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasPrice = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return price;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPrice() { return hasPrice != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPrice(byte[] src) {		
		if (src == null ) return;
		if (hasPrice()) price = FixUtils.TAG_HAS_NO_VALUE;		
		price = FixUtils.longValueOf(src, 0, src.length);
		hasPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPrice(long src) {		
		price = src;
		hasPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPrice(String str) {		
		if (str == null ) return;
		if (hasPrice()) price = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		price = FixUtils.longValueOf(src, 0, src.length);
		hasPrice = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackTimeInForce() {		
		getTimeInForce();		
	}		
			
	public byte getTimeInForce() { 		
		if ( hasTimeInForce()) {		
			if (hasTimeInForce == FixUtils.TAG_HAS_VALUE) {		
				return timeInForce; 		
			} else {

				buf.position(hasTimeInForce);

			timeInForce = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (timeInForce != (byte)'3') && (timeInForce != (byte)'1') && (timeInForce != (byte)'0') && (timeInForce != (byte)'6') && (timeInForce != (byte)'4') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 59);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasTimeInForce = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return timeInForce;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasTimeInForce() { return hasTimeInForce != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTimeInForce(byte[] src) {		
		if (src == null ) return;
		if (hasTimeInForce()) timeInForce = (byte)' ';		
		timeInForce = src[0];		
		hasTimeInForce = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTimeInForce(byte src) {		
		timeInForce = src;
		hasTimeInForce = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTimeInForce(String str) {		
		if (str == null ) return;
		if (hasTimeInForce()) timeInForce = (byte)' ';		
		byte[] src = str.getBytes(); 		
		timeInForce = src[0];		
		hasTimeInForce = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTransactTime() {		
		getTransactTime();		
	}		
			
	public byte[] getTransactTime() { 		
		if ( hasTransactTime()) {		
			if (hasTransactTime == FixUtils.TAG_HAS_VALUE) {		
				return transactTime; 		
			} else {

				buf.position(hasTransactTime);

			FixMessage.getTagStringValue(buf, transactTime, 0, transactTime.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasTransactTime = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return transactTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTransactTime() { return hasTransactTime != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTransactTime(byte[] src) {		
		if (src == null ) return;
		if (hasTransactTime()) FixUtils.fillSpace(transactTime);		
		FixUtils.copy(transactTime, src); 		
		hasTransactTime = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTransactTime(String str) {		
		if (str == null ) return;
		if (hasTransactTime()) FixUtils.fillSpace(transactTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(transactTime, src); 		
		hasTransactTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackExecBroker() {		
		getExecBroker();		
	}		
			
	public byte[] getExecBroker() { 		
		if ( hasExecBroker()) {		
			if (hasExecBroker == FixUtils.TAG_HAS_VALUE) {		
				return execBroker; 		
			} else {

				buf.position(hasExecBroker);

			FixMessage.getTagStringValue(buf, execBroker, 0, execBroker.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasExecBroker = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return execBroker;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasExecBroker() { return hasExecBroker != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setExecBroker(byte[] src) {		
		if (src == null ) return;
		if (hasExecBroker()) FixUtils.fillSpace(execBroker);		
		FixUtils.copy(execBroker, src); 		
		hasExecBroker = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExecBroker(String str) {		
		if (str == null ) return;
		if (hasExecBroker()) FixUtils.fillSpace(execBroker);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(execBroker, src); 		
		hasExecBroker = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMinQty() {		
		getMinQty();		
	}		
			
	public long getMinQty() { 		
		if ( hasMinQty()) {		
			if (hasMinQty == FixUtils.TAG_HAS_VALUE) {		
				return minQty; 		
			} else {

				buf.position(hasMinQty);

			minQty = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasMinQty = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return minQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMinQty() { return hasMinQty != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMinQty(byte[] src) {		
		if (src == null ) return;
		if (hasMinQty()) minQty = FixUtils.TAG_HAS_NO_VALUE;		
		minQty = FixUtils.longValueOf(src, 0, src.length);
		hasMinQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMinQty(long src) {		
		minQty = src;
		hasMinQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMinQty(String str) {		
		if (str == null ) return;
		if (hasMinQty()) minQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		minQty = FixUtils.longValueOf(src, 0, src.length);
		hasMinQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMaxFloor() {		
		getMaxFloor();		
	}		
			
	public long getMaxFloor() { 		
		if ( hasMaxFloor()) {		
			if (hasMaxFloor == FixUtils.TAG_HAS_VALUE) {		
				return maxFloor; 		
			} else {

				buf.position(hasMaxFloor);

			maxFloor = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasMaxFloor = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return maxFloor;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMaxFloor() { return hasMaxFloor != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMaxFloor(byte[] src) {		
		if (src == null ) return;
		if (hasMaxFloor()) maxFloor = FixUtils.TAG_HAS_NO_VALUE;		
		maxFloor = FixUtils.longValueOf(src, 0, src.length);
		hasMaxFloor = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMaxFloor(long src) {		
		maxFloor = src;
		hasMaxFloor = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMaxFloor(String str) {		
		if (str == null ) return;
		if (hasMaxFloor()) maxFloor = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		maxFloor = FixUtils.longValueOf(src, 0, src.length);
		hasMaxFloor = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackExpireTime() {		
		getExpireTime();		
	}		
			
	public byte[] getExpireTime() { 		
		if ( hasExpireTime()) {		
			if (hasExpireTime == FixUtils.TAG_HAS_VALUE) {		
				return expireTime; 		
			} else {

				buf.position(hasExpireTime);

			FixMessage.getTagStringValue(buf, expireTime, 0, expireTime.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasExpireTime = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return expireTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasExpireTime() { return hasExpireTime != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setExpireTime(byte[] src) {		
		if (src == null ) return;
		if (hasExpireTime()) FixUtils.fillSpace(expireTime);		
		FixUtils.copy(expireTime, src); 		
		hasExpireTime = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExpireTime(String str) {		
		if (str == null ) return;
		if (hasExpireTime()) FixUtils.fillSpace(expireTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(expireTime, src); 		
		hasExpireTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackPegDifference() {		
		getPegDifference();		
	}		
			
	public long getPegDifference() { 		
		if ( hasPegDifference()) {		
			if (hasPegDifference == FixUtils.TAG_HAS_VALUE) {		
				return pegDifference; 		
			} else {

				buf.position(hasPegDifference);

			pegDifference = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasPegDifference = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return pegDifference;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPegDifference() { return hasPegDifference != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPegDifference(byte[] src) {		
		if (src == null ) return;
		if (hasPegDifference()) pegDifference = FixUtils.TAG_HAS_NO_VALUE;		
		pegDifference = FixUtils.longValueOf(src, 0, src.length);
		hasPegDifference = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPegDifference(long src) {		
		pegDifference = src;
		hasPegDifference = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPegDifference(String str) {		
		if (str == null ) return;
		if (hasPegDifference()) pegDifference = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		pegDifference = FixUtils.longValueOf(src, 0, src.length);
		hasPegDifference = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackDiscretionInst() {		
		getDiscretionInst();		
	}		
			
	public byte getDiscretionInst() { 		
		if ( hasDiscretionInst()) {		
			if (hasDiscretionInst == FixUtils.TAG_HAS_VALUE) {		
				return discretionInst; 		
			} else {

				buf.position(hasDiscretionInst);

			discretionInst = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (discretionInst != (byte)'0') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 388);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasDiscretionInst = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return discretionInst;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasDiscretionInst() { return hasDiscretionInst != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setDiscretionInst(byte[] src) {		
		if (src == null ) return;
		if (hasDiscretionInst()) discretionInst = (byte)' ';		
		discretionInst = src[0];		
		hasDiscretionInst = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDiscretionInst(byte src) {		
		discretionInst = src;
		hasDiscretionInst = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDiscretionInst(String str) {		
		if (str == null ) return;
		if (hasDiscretionInst()) discretionInst = (byte)' ';		
		byte[] src = str.getBytes(); 		
		discretionInst = src[0];		
		hasDiscretionInst = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackDiscretionOffset() {		
		getDiscretionOffset();		
	}		
			
	public long getDiscretionOffset() { 		
		if ( hasDiscretionOffset()) {		
			if (hasDiscretionOffset == FixUtils.TAG_HAS_VALUE) {		
				return discretionOffset; 		
			} else {

				buf.position(hasDiscretionOffset);

			discretionOffset = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasDiscretionOffset = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return discretionOffset;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDiscretionOffset() { return hasDiscretionOffset != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setDiscretionOffset(byte[] src) {		
		if (src == null ) return;
		if (hasDiscretionOffset()) discretionOffset = FixUtils.TAG_HAS_NO_VALUE;		
		discretionOffset = FixUtils.longValueOf(src, 0, src.length);
		hasDiscretionOffset = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDiscretionOffset(long src) {		
		discretionOffset = src;
		hasDiscretionOffset = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDiscretionOffset(String str) {		
		if (str == null ) return;
		if (hasDiscretionOffset()) discretionOffset = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		discretionOffset = FixUtils.longValueOf(src, 0, src.length);
		hasDiscretionOffset = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackClearingFirm() {		
		getClearingFirm();		
	}		
			
	public byte[] getClearingFirm() { 		
		if ( hasClearingFirm()) {		
			if (hasClearingFirm == FixUtils.TAG_HAS_VALUE) {		
				return clearingFirm; 		
			} else {

				buf.position(hasClearingFirm);

			FixMessage.getTagStringValue(buf, clearingFirm, 0, clearingFirm.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasClearingFirm = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return clearingFirm;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasClearingFirm() { return hasClearingFirm != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setClearingFirm(byte[] src) {		
		if (src == null ) return;
		if (hasClearingFirm()) FixUtils.fillSpace(clearingFirm);		
		FixUtils.copy(clearingFirm, src); 		
		hasClearingFirm = FixUtils.TAG_HAS_VALUE;		
	}

	public void setClearingFirm(String str) {		
		if (str == null ) return;
		if (hasClearingFirm()) FixUtils.fillSpace(clearingFirm);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(clearingFirm, src); 		
		hasClearingFirm = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackClearingAccount() {		
		getClearingAccount();		
	}		
			
	public byte[] getClearingAccount() { 		
		if ( hasClearingAccount()) {		
			if (hasClearingAccount == FixUtils.TAG_HAS_VALUE) {		
				return clearingAccount; 		
			} else {

				buf.position(hasClearingAccount);

			FixMessage.getTagStringValue(buf, clearingAccount, 0, clearingAccount.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasClearingAccount = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return clearingAccount;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasClearingAccount() { return hasClearingAccount != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setClearingAccount(byte[] src) {		
		if (src == null ) return;
		if (hasClearingAccount()) FixUtils.fillSpace(clearingAccount);		
		FixUtils.copy(clearingAccount, src); 		
		hasClearingAccount = FixUtils.TAG_HAS_VALUE;		
	}

	public void setClearingAccount(String str) {		
		if (str == null ) return;
		if (hasClearingAccount()) FixUtils.fillSpace(clearingAccount);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(clearingAccount, src); 		
		hasClearingAccount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOrderCapacity() {		
		getOrderCapacity();		
	}		
			
	public byte[] getOrderCapacity() { 		
		if ( hasOrderCapacity()) {		
			if (hasOrderCapacity == FixUtils.TAG_HAS_VALUE) {		
				return orderCapacity; 		
			} else {

				buf.position(hasOrderCapacity);

			FixMessage.getTagStringValue(buf, orderCapacity, 0, orderCapacity.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasOrderCapacity = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return orderCapacity;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOrderCapacity() { return hasOrderCapacity != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOrderCapacity(byte[] src) {		
		if (src == null ) return;
		if (hasOrderCapacity()) FixUtils.fillSpace(orderCapacity);		
		FixUtils.copy(orderCapacity, src); 		
		hasOrderCapacity = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrderCapacity(String str) {		
		if (str == null ) return;
		if (hasOrderCapacity()) FixUtils.fillSpace(orderCapacity);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(orderCapacity, src); 		
		hasOrderCapacity = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOrderRestrictions() {		
		getOrderRestrictions();		
	}		
			
	public byte[] getOrderRestrictions() { 		
		if ( hasOrderRestrictions()) {		
			if (hasOrderRestrictions == FixUtils.TAG_HAS_VALUE) {		
				return orderRestrictions; 		
			} else {

				buf.position(hasOrderRestrictions);

			FixMessage.getTagStringValue(buf, orderRestrictions, 0, orderRestrictions.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasOrderRestrictions = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return orderRestrictions;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOrderRestrictions() { return hasOrderRestrictions != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOrderRestrictions(byte[] src) {		
		if (src == null ) return;
		if (hasOrderRestrictions()) FixUtils.fillSpace(orderRestrictions);		
		FixUtils.copy(orderRestrictions, src); 		
		hasOrderRestrictions = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrderRestrictions(String str) {		
		if (str == null ) return;
		if (hasOrderRestrictions()) FixUtils.fillSpace(orderRestrictions);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(orderRestrictions, src); 		
		hasOrderRestrictions = FixUtils.TAG_HAS_VALUE;		
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
			
	public void crackDisplayInst() {		
		getDisplayInst();		
	}		
			
	public byte getDisplayInst() { 		
		if ( hasDisplayInst()) {		
			if (hasDisplayInst == FixUtils.TAG_HAS_VALUE) {		
				return displayInst; 		
			} else {

				buf.position(hasDisplayInst);

			displayInst = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (displayInst != (byte)'D') && (displayInst != (byte)'R') && (displayInst != (byte)'N') && (displayInst != (byte)'Y') && (displayInst != (byte)'I') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 9140);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasDisplayInst = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return displayInst;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasDisplayInst() { return hasDisplayInst != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setDisplayInst(byte[] src) {		
		if (src == null ) return;
		if (hasDisplayInst()) displayInst = (byte)' ';		
		displayInst = src[0];		
		hasDisplayInst = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDisplayInst(byte src) {		
		displayInst = src;
		hasDisplayInst = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDisplayInst(String str) {		
		if (str == null ) return;
		if (hasDisplayInst()) displayInst = (byte)' ';		
		byte[] src = str.getBytes(); 		
		displayInst = src[0];		
		hasDisplayInst = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCrossTradeFlag() {		
		getCrossTradeFlag();		
	}		
			
	public byte getCrossTradeFlag() { 		
		if ( hasCrossTradeFlag()) {		
			if (hasCrossTradeFlag == FixUtils.TAG_HAS_VALUE) {		
				return crossTradeFlag; 		
			} else {

				buf.position(hasCrossTradeFlag);

			crossTradeFlag = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (crossTradeFlag != (byte)'C') && (crossTradeFlag != (byte)'O') && (crossTradeFlag != (byte)'H') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 9355);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasCrossTradeFlag = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return crossTradeFlag;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasCrossTradeFlag() { return hasCrossTradeFlag != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCrossTradeFlag(byte[] src) {		
		if (src == null ) return;
		if (hasCrossTradeFlag()) crossTradeFlag = (byte)' ';		
		crossTradeFlag = src[0];		
		hasCrossTradeFlag = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCrossTradeFlag(byte src) {		
		crossTradeFlag = src;
		hasCrossTradeFlag = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCrossTradeFlag(String str) {		
		if (str == null ) return;
		if (hasCrossTradeFlag()) crossTradeFlag = (byte)' ';		
		byte[] src = str.getBytes(); 		
		crossTradeFlag = src[0];		
		hasCrossTradeFlag = FixUtils.TAG_HAS_VALUE;		
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

					if (hasClOrdID()) s += "ClOrdID(11)= " + new String( FixUtils.trim(getClOrdID()) ) + "\n" ; 
		if (hasCurrency()) s += "Currency(15)= " + new String( FixUtils.trim(getCurrency()) ) + "\n" ; 
		if (hasExecInst()) s += "ExecInst(18)= " + new String( FixUtils.trim(getExecInst()) ) + "\n" ; 
		if (hasHandlInst()) s += "HandlInst(21)= " + getHandlInst() + "\n" ; 
		if (hasOrderQty()) s += "OrderQty(38)= " + getOrderQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasOrdType()) s += "OrdType(40)= " + getOrdType() + "\n" ; 
		if (hasPrice()) s += "Price(44)= " + getPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasSecurityID()) s += "SecurityID(48)= " + new String( FixUtils.trim(getSecurityID()) ) + "\n" ; 
		if (hasSide()) s += "Side(54)= " + getSide() + "\n" ; 
		if (hasSymbol()) s += "Symbol(55)= " + new String( FixUtils.trim(getSymbol()) ) + "\n" ; 
		if (hasTimeInForce()) s += "TimeInForce(59)= " + getTimeInForce() + "\n" ; 
		if (hasTransactTime()) s += "TransactTime(60)= " + new String( FixUtils.trim(getTransactTime()) ) + "\n" ; 
		if (hasExecBroker()) s += "ExecBroker(76)= " + new String( FixUtils.trim(getExecBroker()) ) + "\n" ; 
		if (hasMinQty()) s += "MinQty(110)= " + getMinQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasMaxFloor()) s += "MaxFloor(111)= " + getMaxFloor() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasExpireTime()) s += "ExpireTime(126)= " + new String( FixUtils.trim(getExpireTime()) ) + "\n" ; 
		if (hasPegDifference()) s += "PegDifference(211)= " + getPegDifference() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasDiscretionInst()) s += "DiscretionInst(388)= " + getDiscretionInst() + "\n" ; 
		if (hasDiscretionOffset()) s += "DiscretionOffset(389)= " + getDiscretionOffset() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasClearingFirm()) s += "ClearingFirm(439)= " + new String( FixUtils.trim(getClearingFirm()) ) + "\n" ; 
		if (hasClearingAccount()) s += "ClearingAccount(440)= " + new String( FixUtils.trim(getClearingAccount()) ) + "\n" ; 
		if (hasOrderCapacity()) s += "OrderCapacity(528)= " + new String( FixUtils.trim(getOrderCapacity()) ) + "\n" ; 
		if (hasOrderRestrictions()) s += "OrderRestrictions(529)= " + new String( FixUtils.trim(getOrderRestrictions()) ) + "\n" ; 
		if (hasSubMktID()) s += "SubMktID(5815)= " + new String( FixUtils.trim(getSubMktID()) ) + "\n" ; 
		if (hasClRefID()) s += "ClRefID(6209)= " + new String( FixUtils.trim(getClRefID()) ) + "\n" ; 
		if (hasDisplayInst()) s += "DisplayInst(9140)= " + getDisplayInst() + "\n" ; 
		if (hasCrossTradeFlag()) s += "CrossTradeFlag(9355)= " + getCrossTradeFlag() + "\n" ; 
		if (hasBrSeqNbr()) s += "BrSeqNbr(9861)= " + new String( FixUtils.trim(getBrSeqNbr()) ) + "\n" ; 

					if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixOrderSingle)) return false;

		FixOrderSingle msg = (FixOrderSingle) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasClOrdID() && !msg.hasClOrdID()) || (!hasClOrdID() && msg.hasClOrdID())) return false;
		if (!(!hasClOrdID() && !msg.hasClOrdID()) && !FixUtils.equals(getClOrdID(), msg.getClOrdID())) return false;
		if ((hasCurrency() && !msg.hasCurrency()) || (!hasCurrency() && msg.hasCurrency())) return false;
		if (!(!hasCurrency() && !msg.hasCurrency()) && !FixUtils.equals(getCurrency(), msg.getCurrency())) return false;
		if ((hasExecInst() && !msg.hasExecInst()) || (!hasExecInst() && msg.hasExecInst())) return false;
		if (!(!hasExecInst() && !msg.hasExecInst()) && !FixUtils.equals(getExecInst(), msg.getExecInst())) return false;
		if ((hasHandlInst() && !msg.hasHandlInst()) || (!hasHandlInst() && msg.hasHandlInst())) return false;
		if (!(!hasHandlInst() && !msg.hasHandlInst()) && !(getHandlInst()==msg.getHandlInst())) return false;
		if ((hasOrderQty() && !msg.hasOrderQty()) || (!hasOrderQty() && msg.hasOrderQty())) return false;
		if (!(!hasOrderQty() && !msg.hasOrderQty()) && !(getOrderQty()==msg.getOrderQty())) return false;
		if ((hasOrdType() && !msg.hasOrdType()) || (!hasOrdType() && msg.hasOrdType())) return false;
		if (!(!hasOrdType() && !msg.hasOrdType()) && !(getOrdType()==msg.getOrdType())) return false;
		if ((hasPrice() && !msg.hasPrice()) || (!hasPrice() && msg.hasPrice())) return false;
		if (!(!hasPrice() && !msg.hasPrice()) && !(getPrice()==msg.getPrice())) return false;
		if ((hasSecurityID() && !msg.hasSecurityID()) || (!hasSecurityID() && msg.hasSecurityID())) return false;
		if (!(!hasSecurityID() && !msg.hasSecurityID()) && !FixUtils.equals(getSecurityID(), msg.getSecurityID())) return false;
		if ((hasSide() && !msg.hasSide()) || (!hasSide() && msg.hasSide())) return false;
		if (!(!hasSide() && !msg.hasSide()) && !(getSide()==msg.getSide())) return false;
		if ((hasSymbol() && !msg.hasSymbol()) || (!hasSymbol() && msg.hasSymbol())) return false;
		if (!(!hasSymbol() && !msg.hasSymbol()) && !FixUtils.equals(getSymbol(), msg.getSymbol())) return false;
		if ((hasTimeInForce() && !msg.hasTimeInForce()) || (!hasTimeInForce() && msg.hasTimeInForce())) return false;
		if (!(!hasTimeInForce() && !msg.hasTimeInForce()) && !(getTimeInForce()==msg.getTimeInForce())) return false;
		if ((hasTransactTime() && !msg.hasTransactTime()) || (!hasTransactTime() && msg.hasTransactTime())) return false;
		if (!(!hasTransactTime() && !msg.hasTransactTime()) ) return false;
		if ((hasExecBroker() && !msg.hasExecBroker()) || (!hasExecBroker() && msg.hasExecBroker())) return false;
		if (!(!hasExecBroker() && !msg.hasExecBroker()) && !FixUtils.equals(getExecBroker(), msg.getExecBroker())) return false;
		if ((hasMinQty() && !msg.hasMinQty()) || (!hasMinQty() && msg.hasMinQty())) return false;
		if (!(!hasMinQty() && !msg.hasMinQty()) && !(getMinQty()==msg.getMinQty())) return false;
		if ((hasMaxFloor() && !msg.hasMaxFloor()) || (!hasMaxFloor() && msg.hasMaxFloor())) return false;
		if (!(!hasMaxFloor() && !msg.hasMaxFloor()) && !(getMaxFloor()==msg.getMaxFloor())) return false;
		if ((hasExpireTime() && !msg.hasExpireTime()) || (!hasExpireTime() && msg.hasExpireTime())) return false;
		if (!(!hasExpireTime() && !msg.hasExpireTime()) ) return false;
		if ((hasPegDifference() && !msg.hasPegDifference()) || (!hasPegDifference() && msg.hasPegDifference())) return false;
		if (!(!hasPegDifference() && !msg.hasPegDifference()) && !(getPegDifference()==msg.getPegDifference())) return false;
		if ((hasDiscretionInst() && !msg.hasDiscretionInst()) || (!hasDiscretionInst() && msg.hasDiscretionInst())) return false;
		if (!(!hasDiscretionInst() && !msg.hasDiscretionInst()) && !(getDiscretionInst()==msg.getDiscretionInst())) return false;
		if ((hasDiscretionOffset() && !msg.hasDiscretionOffset()) || (!hasDiscretionOffset() && msg.hasDiscretionOffset())) return false;
		if (!(!hasDiscretionOffset() && !msg.hasDiscretionOffset()) && !(getDiscretionOffset()==msg.getDiscretionOffset())) return false;
		if ((hasClearingFirm() && !msg.hasClearingFirm()) || (!hasClearingFirm() && msg.hasClearingFirm())) return false;
		if (!(!hasClearingFirm() && !msg.hasClearingFirm()) && !FixUtils.equals(getClearingFirm(), msg.getClearingFirm())) return false;
		if ((hasClearingAccount() && !msg.hasClearingAccount()) || (!hasClearingAccount() && msg.hasClearingAccount())) return false;
		if (!(!hasClearingAccount() && !msg.hasClearingAccount()) && !FixUtils.equals(getClearingAccount(), msg.getClearingAccount())) return false;
		if ((hasOrderCapacity() && !msg.hasOrderCapacity()) || (!hasOrderCapacity() && msg.hasOrderCapacity())) return false;
		if (!(!hasOrderCapacity() && !msg.hasOrderCapacity()) && !FixUtils.equals(getOrderCapacity(), msg.getOrderCapacity())) return false;
		if ((hasOrderRestrictions() && !msg.hasOrderRestrictions()) || (!hasOrderRestrictions() && msg.hasOrderRestrictions())) return false;
		if (!(!hasOrderRestrictions() && !msg.hasOrderRestrictions()) && !FixUtils.equals(getOrderRestrictions(), msg.getOrderRestrictions())) return false;
		if ((hasSubMktID() && !msg.hasSubMktID()) || (!hasSubMktID() && msg.hasSubMktID())) return false;
		if (!(!hasSubMktID() && !msg.hasSubMktID()) && !FixUtils.equals(getSubMktID(), msg.getSubMktID())) return false;
		if ((hasClRefID() && !msg.hasClRefID()) || (!hasClRefID() && msg.hasClRefID())) return false;
		if (!(!hasClRefID() && !msg.hasClRefID()) && !FixUtils.equals(getClRefID(), msg.getClRefID())) return false;
		if ((hasDisplayInst() && !msg.hasDisplayInst()) || (!hasDisplayInst() && msg.hasDisplayInst())) return false;
		if (!(!hasDisplayInst() && !msg.hasDisplayInst()) && !(getDisplayInst()==msg.getDisplayInst())) return false;
		if ((hasCrossTradeFlag() && !msg.hasCrossTradeFlag()) || (!hasCrossTradeFlag() && msg.hasCrossTradeFlag())) return false;
		if (!(!hasCrossTradeFlag() && !msg.hasCrossTradeFlag()) && !(getCrossTradeFlag()==msg.getCrossTradeFlag())) return false;
		if ((hasBrSeqNbr() && !msg.hasBrSeqNbr()) || (!hasBrSeqNbr() && msg.hasBrSeqNbr())) return false;
		if (!(!hasBrSeqNbr() && !msg.hasBrSeqNbr()) && !FixUtils.equals(getBrSeqNbr(), msg.getBrSeqNbr())) return false;
		return true;
	}
	@Override
	public FixOrderSingle clone () {
		FixOrderSingle out = new FixOrderSingle();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixOrderSingle clone ( FixOrderSingle out ) {
		if ( hasClOrdID())
			out.setClOrdID(getClOrdID());
		if ( hasCurrency())
			out.setCurrency(getCurrency());
		if ( hasExecInst())
			out.setExecInst(getExecInst());
		if ( hasHandlInst())
			out.setHandlInst(getHandlInst());
		if ( hasOrderQty())
			out.setOrderQty(getOrderQty());
		if ( hasOrdType())
			out.setOrdType(getOrdType());
		if ( hasPrice())
			out.setPrice(getPrice());
		if ( hasSecurityID())
			out.setSecurityID(getSecurityID());
		if ( hasSide())
			out.setSide(getSide());
		if ( hasSymbol())
			out.setSymbol(getSymbol());
		if ( hasTimeInForce())
			out.setTimeInForce(getTimeInForce());
		if ( hasTransactTime())
			out.setTransactTime(getTransactTime());
		if ( hasExecBroker())
			out.setExecBroker(getExecBroker());
		if ( hasMinQty())
			out.setMinQty(getMinQty());
		if ( hasMaxFloor())
			out.setMaxFloor(getMaxFloor());
		if ( hasExpireTime())
			out.setExpireTime(getExpireTime());
		if ( hasPegDifference())
			out.setPegDifference(getPegDifference());
		if ( hasDiscretionInst())
			out.setDiscretionInst(getDiscretionInst());
		if ( hasDiscretionOffset())
			out.setDiscretionOffset(getDiscretionOffset());
		if ( hasClearingFirm())
			out.setClearingFirm(getClearingFirm());
		if ( hasClearingAccount())
			out.setClearingAccount(getClearingAccount());
		if ( hasOrderCapacity())
			out.setOrderCapacity(getOrderCapacity());
		if ( hasOrderRestrictions())
			out.setOrderRestrictions(getOrderRestrictions());
		if ( hasSubMktID())
			out.setSubMktID(getSubMktID());
		if ( hasClRefID())
			out.setClRefID(getClRefID());
		if ( hasDisplayInst())
			out.setDisplayInst(getDisplayInst());
		if ( hasCrossTradeFlag())
			out.setCrossTradeFlag(getCrossTradeFlag());
		if ( hasBrSeqNbr())
			out.setBrSeqNbr(getBrSeqNbr());
		return out;
	}

}
