package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixTrdSessLstGrp extends FixGroup {
	private short hasTradingSessionID;
	byte[] tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradingSessionSubID;
	byte[] tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecurityExchange;
	byte[] securityExchange = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradSesMethod;
	long tradSesMethod = 0;		
	private short hasTradSesMode;
	long tradSesMode = 0;		
	private short hasUnsolicitedIndicator;
		boolean unsolicitedIndicator = false;		
	private short hasTradSesStatus;
	long tradSesStatus = 0;		
	private short hasTradSesStatusRejReason;
	long tradSesStatusRejReason = 0;		
	private short hasTradSesStartTime;
	byte[] tradSesStartTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasMarketID;
	byte[] marketID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMarketSegmentID;
	byte[] marketSegmentID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradingSessionDesc;
	byte[] tradingSessionDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradSesUpdateAction;
	byte tradSesUpdateAction = (byte)' ';		
	private short hasTradSesOpenTime;
	byte[] tradSesOpenTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasTradSesPreCloseTime;
	byte[] tradSesPreCloseTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasTradSesCloseTime;
	byte[] tradSesCloseTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasTradSesEndTime;
	byte[] tradSesEndTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasTotalVolumeTraded;
	long totalVolumeTraded = 0;		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedTextLen;
	long encodedTextLen = 0;		
	private short hasEncodedText;
	byte[] encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasTransactTime;
	byte[] transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		public FixTradingSessionRules tradingSessionRules;
	
	public FixTrdSessLstGrp() {
		this(false);
	}

	public FixTrdSessLstGrp(boolean isRequired) {
		super(FixTags.TRADINGSESSIONID_INT);

		this.isRequired = isRequired;
		
		hasTradingSessionID = FixUtils.TAG_HAS_NO_VALUE;		
		tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradingSessionSubID = FixUtils.TAG_HAS_NO_VALUE;		
		tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecurityExchange = FixUtils.TAG_HAS_NO_VALUE;		
		securityExchange = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradSesMethod = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradSesMode = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnsolicitedIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradSesStatus = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradSesStatusRejReason = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradSesStartTime = FixUtils.TAG_HAS_NO_VALUE;		
		tradSesStartTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasMarketID = FixUtils.TAG_HAS_NO_VALUE;		
		marketID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMarketSegmentID = FixUtils.TAG_HAS_NO_VALUE;		
		marketSegmentID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradingSessionDesc = FixUtils.TAG_HAS_NO_VALUE;		
		tradingSessionDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradSesUpdateAction = FixUtils.TAG_HAS_NO_VALUE;		
		hasTradSesOpenTime = FixUtils.TAG_HAS_NO_VALUE;		
		tradSesOpenTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasTradSesPreCloseTime = FixUtils.TAG_HAS_NO_VALUE;		
		tradSesPreCloseTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasTradSesCloseTime = FixUtils.TAG_HAS_NO_VALUE;		
		tradSesCloseTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasTradSesEndTime = FixUtils.TAG_HAS_NO_VALUE;		
		tradSesEndTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasTotalVolumeTraded = FixUtils.TAG_HAS_NO_VALUE;		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;		
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		tradingSessionRules = new FixTradingSessionRules();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasTradingSessionID()) return true;
		else return false;
	}


	/**
     * Parse FIX Group. The buffer is positioned at the value of the tag.
     */
    public int setBuffer( int tag, ByteBuffer buf, FixValidationError err)
    {

		super.err = err;
		super.err.clear();
		super.setBuffer(buf, err);


        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.TRADINGSESSIONID_INT:		
            		hasTradingSessionID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRADINGSESSIONSUBID_INT:		
            		hasTradingSessionSubID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SECURITYEXCHANGE_INT:		
            		hasSecurityExchange = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRADSESMETHOD_INT:		
            		hasTradSesMethod = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRADSESMODE_INT:		
            		hasTradSesMode = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNSOLICITEDINDICATOR_INT:		
            		hasUnsolicitedIndicator = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRADSESSTATUS_INT:		
            		hasTradSesStatus = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRADSESSTATUSREJREASON_INT:		
            		hasTradSesStatusRejReason = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRADSESSTARTTIME_INT:		
            		hasTradSesStartTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MARKETID_INT:		
            		hasMarketID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MARKETSEGMENTID_INT:		
            		hasMarketSegmentID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRADINGSESSIONDESC_INT:		
            		hasTradingSessionDesc = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRADSESUPDATEACTION_INT:		
            		hasTradSesUpdateAction = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRADSESOPENTIME_INT:		
            		hasTradSesOpenTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRADSESPRECLOSETIME_INT:		
            		hasTradSesPreCloseTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRADSESCLOSETIME_INT:		
            		hasTradSesCloseTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRADSESENDTIME_INT:		
            		hasTradSesEndTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TOTALVOLUMETRADED_INT:		
            		hasTotalVolumeTraded = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TEXT_INT:		
            		hasText = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ENCODEDTEXTLEN_INT:		
            		hasEncodedTextLen = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ENCODEDTEXT_INT:		
            		hasEncodedText = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRANSACTTIME_INT:		
            		hasTransactTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tradingSessionRules.isKeyTag(tag)) {
        				tag = tradingSessionRules.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
            		} else { return tag; }
            }

            tag = FixMessage.getTag(buf, err);
            if (err.hasError()) return tag; // what to do now? 
            if (isKeyTag(tag)) return tag; // next in repeating group
        }		
        return tag;
    }		
	public boolean hasRequiredTags(FixValidationError err) {
		if (!hasTradingSessionID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.TRADINGSESSIONID_INT);
			return false;
		}
		if (!hasTradSesStatus()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.TRADSESSTATUS_INT);
			return false;
		}
		return true;
	}
	@Override
	public void clear() {
		// just set the length to header + trailer but still we set it...
		hasTradingSessionID = FixUtils.TAG_HAS_NO_VALUE;
		hasTradingSessionSubID = FixUtils.TAG_HAS_NO_VALUE;
		hasSecurityExchange = FixUtils.TAG_HAS_NO_VALUE;
		hasTradSesMethod = FixUtils.TAG_HAS_NO_VALUE;
		hasTradSesMode = FixUtils.TAG_HAS_NO_VALUE;
		hasUnsolicitedIndicator = FixUtils.TAG_HAS_NO_VALUE;
		hasTradSesStatus = FixUtils.TAG_HAS_NO_VALUE;
		hasTradSesStatusRejReason = FixUtils.TAG_HAS_NO_VALUE;
		hasTradSesStartTime = FixUtils.TAG_HAS_NO_VALUE;
		hasMarketID = FixUtils.TAG_HAS_NO_VALUE;
		hasMarketSegmentID = FixUtils.TAG_HAS_NO_VALUE;
		hasTradingSessionDesc = FixUtils.TAG_HAS_NO_VALUE;
		hasTradSesUpdateAction = FixUtils.TAG_HAS_NO_VALUE;
		hasTradSesOpenTime = FixUtils.TAG_HAS_NO_VALUE;
		hasTradSesPreCloseTime = FixUtils.TAG_HAS_NO_VALUE;
		hasTradSesCloseTime = FixUtils.TAG_HAS_NO_VALUE;
		hasTradSesEndTime = FixUtils.TAG_HAS_NO_VALUE;
		hasTotalVolumeTraded = FixUtils.TAG_HAS_NO_VALUE;
		hasText = FixUtils.TAG_HAS_NO_VALUE;
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;
		tradingSessionRules.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasTradingSessionID()) {		
			out.put(FixTags.TRADINGSESSIONID);

			out.put((byte) '=');

			FixUtils.put(out,tradingSessionID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTradingSessionSubID()) {		
			out.put(FixTags.TRADINGSESSIONSUBID);

			out.put((byte) '=');

			FixUtils.put(out,tradingSessionSubID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSecurityExchange()) {		
			out.put(FixTags.SECURITYEXCHANGE);

			out.put((byte) '=');

			FixUtils.put(out,securityExchange); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTradSesMethod()) {		
			out.put(FixTags.TRADSESMETHOD);

			out.put((byte) '=');

			FixUtils.put(out, (long)tradSesMethod);
		
			out.put(FixUtils.SOH);

            }

		if (hasTradSesMode()) {		
			out.put(FixTags.TRADSESMODE);

			out.put((byte) '=');

			FixUtils.put(out, (long)tradSesMode);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnsolicitedIndicator()) {		
			out.put(FixTags.UNSOLICITEDINDICATOR);

			out.put((byte) '=');

			out.put(unsolicitedIndicator?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);

            }

		if (hasTradSesStatus()) {		
			out.put(FixTags.TRADSESSTATUS);

			out.put((byte) '=');

			FixUtils.put(out, (long)tradSesStatus);
		
			out.put(FixUtils.SOH);

            }

		if (hasTradSesStatusRejReason()) {		
			out.put(FixTags.TRADSESSTATUSREJREASON);

			out.put((byte) '=');

			FixUtils.put(out, (long)tradSesStatusRejReason);
		
			out.put(FixUtils.SOH);

            }

		if (hasTradSesStartTime()) {		
			out.put(FixTags.TRADSESSTARTTIME);

			out.put((byte) '=');

			FixUtils.put(out,tradSesStartTime); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasMarketID()) {		
			out.put(FixTags.MARKETID);

			out.put((byte) '=');

			FixUtils.put(out,marketID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasMarketSegmentID()) {		
			out.put(FixTags.MARKETSEGMENTID);

			out.put((byte) '=');

			FixUtils.put(out,marketSegmentID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTradingSessionDesc()) {		
			out.put(FixTags.TRADINGSESSIONDESC);

			out.put((byte) '=');

			FixUtils.put(out,tradingSessionDesc); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTradSesUpdateAction()) {		
			out.put(FixTags.TRADSESUPDATEACTION);

			out.put((byte) '=');

			FixUtils.put(out,tradSesUpdateAction); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTradSesOpenTime()) {		
			out.put(FixTags.TRADSESOPENTIME);

			out.put((byte) '=');

			FixUtils.put(out,tradSesOpenTime); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTradSesPreCloseTime()) {		
			out.put(FixTags.TRADSESPRECLOSETIME);

			out.put((byte) '=');

			FixUtils.put(out,tradSesPreCloseTime); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTradSesCloseTime()) {		
			out.put(FixTags.TRADSESCLOSETIME);

			out.put((byte) '=');

			FixUtils.put(out,tradSesCloseTime); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTradSesEndTime()) {		
			out.put(FixTags.TRADSESENDTIME);

			out.put((byte) '=');

			FixUtils.put(out,tradSesEndTime); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTotalVolumeTraded()) {		
			out.put(FixTags.TOTALVOLUMETRADED);

			out.put((byte) '=');

			FixUtils.put(out, (long)totalVolumeTraded);
		
			out.put(FixUtils.SOH);

            }

		if (hasText()) {		
			out.put(FixTags.TEXT);

			out.put((byte) '=');

			FixUtils.put(out,text); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasEncodedTextLen()) {		
			out.put(FixTags.ENCODEDTEXTLEN);

			out.put((byte) '=');

			FixUtils.put(out, (long)encodedTextLen);
		
			out.put(FixUtils.SOH);

            }

		if (hasEncodedText()) {		
			out.put(FixTags.ENCODEDTEXT);

			out.put((byte) '=');

			FixUtils.put(out,encodedText); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTransactTime()) {		
			out.put(FixTags.TRANSACTTIME);

			out.put((byte) '=');

			FixUtils.put(out,transactTime); 		
		
			out.put(FixUtils.SOH);

            }

		tradingSessionRules.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasTradingSessionID()) {		
			FixUtils.put(out,tradingSessionID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradingSessionSubID()) {		
			FixUtils.put(out,tradingSessionSubID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecurityExchange()) {		
			FixUtils.put(out,securityExchange); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradSesMethod()) {		
			FixUtils.put(out, (long)tradSesMethod);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradSesMode()) {		
			FixUtils.put(out, (long)tradSesMode);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnsolicitedIndicator()) {		
			out.put(unsolicitedIndicator?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradSesStatus()) {		
			FixUtils.put(out, (long)tradSesStatus);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradSesStatusRejReason()) {		
			FixUtils.put(out, (long)tradSesStatusRejReason);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradSesStartTime()) {		
			FixUtils.put(out,tradSesStartTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMarketID()) {		
			FixUtils.put(out,marketID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMarketSegmentID()) {		
			FixUtils.put(out,marketSegmentID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradingSessionDesc()) {		
			FixUtils.put(out,tradingSessionDesc); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradSesUpdateAction()) {		
			FixUtils.put(out,tradSesUpdateAction); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradSesOpenTime()) {		
			FixUtils.put(out,tradSesOpenTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradSesPreCloseTime()) {		
			FixUtils.put(out,tradSesPreCloseTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradSesCloseTime()) {		
			FixUtils.put(out,tradSesCloseTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradSesEndTime()) {		
			FixUtils.put(out,tradSesEndTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTotalVolumeTraded()) {		
			FixUtils.put(out, (long)totalVolumeTraded);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasText()) {		
			FixUtils.put(out,text); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedTextLen()) {		
			FixUtils.put(out, (long)encodedTextLen);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedText()) {		
			FixUtils.put(out,encodedText); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTransactTime()) {		
			FixUtils.put(out,transactTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		tradingSessionRules.printBuffer(out);
	}

	public byte[] getTradingSessionID() { 		
		if ( hasTradingSessionID()) {		
			if (hasTradingSessionID == FixUtils.TAG_HAS_VALUE) {		
				return tradingSessionID; 		
			} else {		
		
				buf.position(hasTradingSessionID);		
		
			FixMessage.getTagStringValue(buf, tradingSessionID, 0, tradingSessionID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTradingSessionID);		
					return null;		
				}		
			}		
			hasTradingSessionID = FixUtils.TAG_HAS_VALUE;		
			return tradingSessionID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradingSessionID() { return hasTradingSessionID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTradingSessionID(byte[] src) {		
		if (src == null ) return;
		if (hasTradingSessionID()) FixUtils.fillNul(tradingSessionID);		
		FixUtils.copy(tradingSessionID, src); 		
		hasTradingSessionID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTradingSessionID(String str) {		
		if (str == null ) return;
		if (hasTradingSessionID()) FixUtils.fillNul(tradingSessionID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradingSessionID, src); 		
		hasTradingSessionID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTradingSessionSubID() { 		
		if ( hasTradingSessionSubID()) {		
			if (hasTradingSessionSubID == FixUtils.TAG_HAS_VALUE) {		
				return tradingSessionSubID; 		
			} else {		
		
				buf.position(hasTradingSessionSubID);		
		
			FixMessage.getTagStringValue(buf, tradingSessionSubID, 0, tradingSessionSubID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTradingSessionSubID);		
					return null;		
				}		
			}		
			hasTradingSessionSubID = FixUtils.TAG_HAS_VALUE;		
			return tradingSessionSubID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradingSessionSubID() { return hasTradingSessionSubID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTradingSessionSubID(byte[] src) {		
		if (src == null ) return;
		if (hasTradingSessionSubID()) FixUtils.fillNul(tradingSessionSubID);		
		FixUtils.copy(tradingSessionSubID, src); 		
		hasTradingSessionSubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTradingSessionSubID(String str) {		
		if (str == null ) return;
		if (hasTradingSessionSubID()) FixUtils.fillNul(tradingSessionSubID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradingSessionSubID, src); 		
		hasTradingSessionSubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSecurityExchange() { 		
		if ( hasSecurityExchange()) {		
			if (hasSecurityExchange == FixUtils.TAG_HAS_VALUE) {		
				return securityExchange; 		
			} else {		
		
				buf.position(hasSecurityExchange);		
		
			FixMessage.getTagStringValue(buf, securityExchange, 0, securityExchange.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSecurityExchange);		
					return null;		
				}		
			}		
			hasSecurityExchange = FixUtils.TAG_HAS_VALUE;		
			return securityExchange;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecurityExchange() { return hasSecurityExchange != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSecurityExchange(byte[] src) {		
		if (src == null ) return;
		if (hasSecurityExchange()) FixUtils.fillNul(securityExchange);		
		FixUtils.copy(securityExchange, src); 		
		hasSecurityExchange = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSecurityExchange(String str) {		
		if (str == null ) return;
		if (hasSecurityExchange()) FixUtils.fillNul(securityExchange);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(securityExchange, src); 		
		hasSecurityExchange = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getTradSesMethod() { 		
		if ( hasTradSesMethod()) {		
			if (hasTradSesMethod == FixUtils.TAG_HAS_VALUE) {		
				return tradSesMethod; 		
			} else {		
		
				buf.position(hasTradSesMethod);		
		
			tradSesMethod = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasTradSesMethod);		
					return 0;		
				}		
			}		
			hasTradSesMethod = FixUtils.TAG_HAS_VALUE;		
			return tradSesMethod;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTradSesMethod() { return hasTradSesMethod != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTradSesMethod(long src) {		
		tradSesMethod = src;
		hasTradSesMethod = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradSesMethod(byte[] src) {		
		if (src == null ) return;
		if (hasTradSesMethod()) tradSesMethod = FixUtils.TAG_HAS_NO_VALUE;		
		tradSesMethod = FixUtils.longValueOf(src, 0, src.length);
		hasTradSesMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTradSesMethod(String str) {		
		if (str == null ) return;
		if (hasTradSesMethod()) tradSesMethod = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		tradSesMethod = FixUtils.longValueOf(src, 0, src.length);
		hasTradSesMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getTradSesMode() { 		
		if ( hasTradSesMode()) {		
			if (hasTradSesMode == FixUtils.TAG_HAS_VALUE) {		
				return tradSesMode; 		
			} else {		
		
				buf.position(hasTradSesMode);		
		
			tradSesMode = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasTradSesMode);		
					return 0;		
				}		
			}		
			hasTradSesMode = FixUtils.TAG_HAS_VALUE;		
			return tradSesMode;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTradSesMode() { return hasTradSesMode != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTradSesMode(long src) {		
		tradSesMode = src;
		hasTradSesMode = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradSesMode(byte[] src) {		
		if (src == null ) return;
		if (hasTradSesMode()) tradSesMode = FixUtils.TAG_HAS_NO_VALUE;		
		tradSesMode = FixUtils.longValueOf(src, 0, src.length);
		hasTradSesMode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTradSesMode(String str) {		
		if (str == null ) return;
		if (hasTradSesMode()) tradSesMode = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		tradSesMode = FixUtils.longValueOf(src, 0, src.length);
		hasTradSesMode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public boolean getUnsolicitedIndicator() { 		
		if ( hasUnsolicitedIndicator()) {		
			if (hasUnsolicitedIndicator == FixUtils.TAG_HAS_VALUE) {		
				return unsolicitedIndicator; 		
			} else {		
		
				buf.position(hasUnsolicitedIndicator);		
		
			unsolicitedIndicator = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(hasUnsolicitedIndicator);		
					return false;		
				}		
			}		
			hasUnsolicitedIndicator = FixUtils.TAG_HAS_VALUE;		
			return unsolicitedIndicator;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasUnsolicitedIndicator() { return hasUnsolicitedIndicator != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnsolicitedIndicator(boolean src) {		
		unsolicitedIndicator = src;
		hasUnsolicitedIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnsolicitedIndicator(byte[] src) {		
		if (src == null ) return;
		if (hasUnsolicitedIndicator()) unsolicitedIndicator = false;		
		unsolicitedIndicator = src[0]==(byte)'Y'?true:false;		
		hasUnsolicitedIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnsolicitedIndicator(String str) {		
		if (str == null ) return;
		if (hasUnsolicitedIndicator()) unsolicitedIndicator = false;		
		byte[] src = str.getBytes(); 		
		unsolicitedIndicator = src[0]==(byte)'Y'?true:false;		
		hasUnsolicitedIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getTradSesStatus() { 		
		if ( hasTradSesStatus()) {		
			if (hasTradSesStatus == FixUtils.TAG_HAS_VALUE) {		
				return tradSesStatus; 		
			} else {		
		
				buf.position(hasTradSesStatus);		
		
			tradSesStatus = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasTradSesStatus);		
					return 0;		
				}		
			}		
			hasTradSesStatus = FixUtils.TAG_HAS_VALUE;		
			return tradSesStatus;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTradSesStatus() { return hasTradSesStatus != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTradSesStatus(long src) {		
		tradSesStatus = src;
		hasTradSesStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradSesStatus(byte[] src) {		
		if (src == null ) return;
		if (hasTradSesStatus()) tradSesStatus = FixUtils.TAG_HAS_NO_VALUE;		
		tradSesStatus = FixUtils.longValueOf(src, 0, src.length);
		hasTradSesStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTradSesStatus(String str) {		
		if (str == null ) return;
		if (hasTradSesStatus()) tradSesStatus = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		tradSesStatus = FixUtils.longValueOf(src, 0, src.length);
		hasTradSesStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getTradSesStatusRejReason() { 		
		if ( hasTradSesStatusRejReason()) {		
			if (hasTradSesStatusRejReason == FixUtils.TAG_HAS_VALUE) {		
				return tradSesStatusRejReason; 		
			} else {		
		
				buf.position(hasTradSesStatusRejReason);		
		
			tradSesStatusRejReason = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasTradSesStatusRejReason);		
					return 0;		
				}		
			}		
			hasTradSesStatusRejReason = FixUtils.TAG_HAS_VALUE;		
			return tradSesStatusRejReason;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTradSesStatusRejReason() { return hasTradSesStatusRejReason != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTradSesStatusRejReason(long src) {		
		tradSesStatusRejReason = src;
		hasTradSesStatusRejReason = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradSesStatusRejReason(byte[] src) {		
		if (src == null ) return;
		if (hasTradSesStatusRejReason()) tradSesStatusRejReason = FixUtils.TAG_HAS_NO_VALUE;		
		tradSesStatusRejReason = FixUtils.longValueOf(src, 0, src.length);
		hasTradSesStatusRejReason = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTradSesStatusRejReason(String str) {		
		if (str == null ) return;
		if (hasTradSesStatusRejReason()) tradSesStatusRejReason = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		tradSesStatusRejReason = FixUtils.longValueOf(src, 0, src.length);
		hasTradSesStatusRejReason = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTradSesStartTime() { 		
		if ( hasTradSesStartTime()) {		
			if (hasTradSesStartTime == FixUtils.TAG_HAS_VALUE) {		
				return tradSesStartTime; 		
			} else {		
		
				buf.position(hasTradSesStartTime);		
		
			FixMessage.getTagStringValue(buf, tradSesStartTime, 0, tradSesStartTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTradSesStartTime);		
					return null;		
				}		
			}		
			hasTradSesStartTime = FixUtils.TAG_HAS_VALUE;		
			return tradSesStartTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradSesStartTime() { return hasTradSesStartTime != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTradSesStartTime(byte[] src) {		
		if (src == null ) return;
		if (hasTradSesStartTime()) FixUtils.fillNul(tradSesStartTime);		
		FixUtils.copy(tradSesStartTime, src); 		
		hasTradSesStartTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTradSesStartTime(String str) {		
		if (str == null ) return;
		if (hasTradSesStartTime()) FixUtils.fillNul(tradSesStartTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradSesStartTime, src); 		
		hasTradSesStartTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getMarketID() { 		
		if ( hasMarketID()) {		
			if (hasMarketID == FixUtils.TAG_HAS_VALUE) {		
				return marketID; 		
			} else {		
		
				buf.position(hasMarketID);		
		
			FixMessage.getTagStringValue(buf, marketID, 0, marketID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasMarketID);		
					return null;		
				}		
			}		
			hasMarketID = FixUtils.TAG_HAS_VALUE;		
			return marketID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMarketID() { return hasMarketID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMarketID(byte[] src) {		
		if (src == null ) return;
		if (hasMarketID()) FixUtils.fillNul(marketID);		
		FixUtils.copy(marketID, src); 		
		hasMarketID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMarketID(String str) {		
		if (str == null ) return;
		if (hasMarketID()) FixUtils.fillNul(marketID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(marketID, src); 		
		hasMarketID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getMarketSegmentID() { 		
		if ( hasMarketSegmentID()) {		
			if (hasMarketSegmentID == FixUtils.TAG_HAS_VALUE) {		
				return marketSegmentID; 		
			} else {		
		
				buf.position(hasMarketSegmentID);		
		
			FixMessage.getTagStringValue(buf, marketSegmentID, 0, marketSegmentID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasMarketSegmentID);		
					return null;		
				}		
			}		
			hasMarketSegmentID = FixUtils.TAG_HAS_VALUE;		
			return marketSegmentID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMarketSegmentID() { return hasMarketSegmentID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMarketSegmentID(byte[] src) {		
		if (src == null ) return;
		if (hasMarketSegmentID()) FixUtils.fillNul(marketSegmentID);		
		FixUtils.copy(marketSegmentID, src); 		
		hasMarketSegmentID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMarketSegmentID(String str) {		
		if (str == null ) return;
		if (hasMarketSegmentID()) FixUtils.fillNul(marketSegmentID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(marketSegmentID, src); 		
		hasMarketSegmentID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTradingSessionDesc() { 		
		if ( hasTradingSessionDesc()) {		
			if (hasTradingSessionDesc == FixUtils.TAG_HAS_VALUE) {		
				return tradingSessionDesc; 		
			} else {		
		
				buf.position(hasTradingSessionDesc);		
		
			FixMessage.getTagStringValue(buf, tradingSessionDesc, 0, tradingSessionDesc.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTradingSessionDesc);		
					return null;		
				}		
			}		
			hasTradingSessionDesc = FixUtils.TAG_HAS_VALUE;		
			return tradingSessionDesc;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradingSessionDesc() { return hasTradingSessionDesc != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTradingSessionDesc(byte[] src) {		
		if (src == null ) return;
		if (hasTradingSessionDesc()) FixUtils.fillNul(tradingSessionDesc);		
		FixUtils.copy(tradingSessionDesc, src); 		
		hasTradingSessionDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTradingSessionDesc(String str) {		
		if (str == null ) return;
		if (hasTradingSessionDesc()) FixUtils.fillNul(tradingSessionDesc);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradingSessionDesc, src); 		
		hasTradingSessionDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getTradSesUpdateAction() { 		
		if ( hasTradSesUpdateAction()) {		
			if (hasTradSesUpdateAction == FixUtils.TAG_HAS_VALUE) {		
				return tradSesUpdateAction; 		
			} else {		
		
				buf.position(hasTradSesUpdateAction);		
		
			tradSesUpdateAction = FixMessage.getTagCharValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasTradSesUpdateAction);		
					return (byte)'0';		
				}		
			}		
			hasTradSesUpdateAction = FixUtils.TAG_HAS_VALUE;		
			return tradSesUpdateAction;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasTradSesUpdateAction() { return hasTradSesUpdateAction != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTradSesUpdateAction(byte src) {		
		tradSesUpdateAction = src;
		hasTradSesUpdateAction = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTradSesUpdateAction(byte[] src) {		
		if (src == null ) return;
		if (hasTradSesUpdateAction()) tradSesUpdateAction = (byte)' ';		
		tradSesUpdateAction = src[0];		
		hasTradSesUpdateAction = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTradSesUpdateAction(String str) {		
		if (str == null ) return;
		if (hasTradSesUpdateAction()) tradSesUpdateAction = (byte)' ';		
		byte[] src = str.getBytes(); 		
		tradSesUpdateAction = src[0];		
		hasTradSesUpdateAction = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTradSesOpenTime() { 		
		if ( hasTradSesOpenTime()) {		
			if (hasTradSesOpenTime == FixUtils.TAG_HAS_VALUE) {		
				return tradSesOpenTime; 		
			} else {		
		
				buf.position(hasTradSesOpenTime);		
		
			FixMessage.getTagStringValue(buf, tradSesOpenTime, 0, tradSesOpenTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTradSesOpenTime);		
					return null;		
				}		
			}		
			hasTradSesOpenTime = FixUtils.TAG_HAS_VALUE;		
			return tradSesOpenTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradSesOpenTime() { return hasTradSesOpenTime != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTradSesOpenTime(byte[] src) {		
		if (src == null ) return;
		if (hasTradSesOpenTime()) FixUtils.fillNul(tradSesOpenTime);		
		FixUtils.copy(tradSesOpenTime, src); 		
		hasTradSesOpenTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTradSesOpenTime(String str) {		
		if (str == null ) return;
		if (hasTradSesOpenTime()) FixUtils.fillNul(tradSesOpenTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradSesOpenTime, src); 		
		hasTradSesOpenTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTradSesPreCloseTime() { 		
		if ( hasTradSesPreCloseTime()) {		
			if (hasTradSesPreCloseTime == FixUtils.TAG_HAS_VALUE) {		
				return tradSesPreCloseTime; 		
			} else {		
		
				buf.position(hasTradSesPreCloseTime);		
		
			FixMessage.getTagStringValue(buf, tradSesPreCloseTime, 0, tradSesPreCloseTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTradSesPreCloseTime);		
					return null;		
				}		
			}		
			hasTradSesPreCloseTime = FixUtils.TAG_HAS_VALUE;		
			return tradSesPreCloseTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradSesPreCloseTime() { return hasTradSesPreCloseTime != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTradSesPreCloseTime(byte[] src) {		
		if (src == null ) return;
		if (hasTradSesPreCloseTime()) FixUtils.fillNul(tradSesPreCloseTime);		
		FixUtils.copy(tradSesPreCloseTime, src); 		
		hasTradSesPreCloseTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTradSesPreCloseTime(String str) {		
		if (str == null ) return;
		if (hasTradSesPreCloseTime()) FixUtils.fillNul(tradSesPreCloseTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradSesPreCloseTime, src); 		
		hasTradSesPreCloseTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTradSesCloseTime() { 		
		if ( hasTradSesCloseTime()) {		
			if (hasTradSesCloseTime == FixUtils.TAG_HAS_VALUE) {		
				return tradSesCloseTime; 		
			} else {		
		
				buf.position(hasTradSesCloseTime);		
		
			FixMessage.getTagStringValue(buf, tradSesCloseTime, 0, tradSesCloseTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTradSesCloseTime);		
					return null;		
				}		
			}		
			hasTradSesCloseTime = FixUtils.TAG_HAS_VALUE;		
			return tradSesCloseTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradSesCloseTime() { return hasTradSesCloseTime != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTradSesCloseTime(byte[] src) {		
		if (src == null ) return;
		if (hasTradSesCloseTime()) FixUtils.fillNul(tradSesCloseTime);		
		FixUtils.copy(tradSesCloseTime, src); 		
		hasTradSesCloseTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTradSesCloseTime(String str) {		
		if (str == null ) return;
		if (hasTradSesCloseTime()) FixUtils.fillNul(tradSesCloseTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradSesCloseTime, src); 		
		hasTradSesCloseTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTradSesEndTime() { 		
		if ( hasTradSesEndTime()) {		
			if (hasTradSesEndTime == FixUtils.TAG_HAS_VALUE) {		
				return tradSesEndTime; 		
			} else {		
		
				buf.position(hasTradSesEndTime);		
		
			FixMessage.getTagStringValue(buf, tradSesEndTime, 0, tradSesEndTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTradSesEndTime);		
					return null;		
				}		
			}		
			hasTradSesEndTime = FixUtils.TAG_HAS_VALUE;		
			return tradSesEndTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradSesEndTime() { return hasTradSesEndTime != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTradSesEndTime(byte[] src) {		
		if (src == null ) return;
		if (hasTradSesEndTime()) FixUtils.fillNul(tradSesEndTime);		
		FixUtils.copy(tradSesEndTime, src); 		
		hasTradSesEndTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTradSesEndTime(String str) {		
		if (str == null ) return;
		if (hasTradSesEndTime()) FixUtils.fillNul(tradSesEndTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradSesEndTime, src); 		
		hasTradSesEndTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getTotalVolumeTraded() { 		
		if ( hasTotalVolumeTraded()) {		
			if (hasTotalVolumeTraded == FixUtils.TAG_HAS_VALUE) {		
				return totalVolumeTraded; 		
			} else {		
		
				buf.position(hasTotalVolumeTraded);		
		
			totalVolumeTraded = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasTotalVolumeTraded);		
					return 0;		
				}		
			}		
			hasTotalVolumeTraded = FixUtils.TAG_HAS_VALUE;		
			return totalVolumeTraded;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTotalVolumeTraded() { return hasTotalVolumeTraded != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTotalVolumeTraded(long src) {		
		totalVolumeTraded = src;
		hasTotalVolumeTraded = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTotalVolumeTraded(byte[] src) {		
		if (src == null ) return;
		if (hasTotalVolumeTraded()) totalVolumeTraded = FixUtils.TAG_HAS_NO_VALUE;		
		totalVolumeTraded = FixUtils.longValueOf(src, 0, src.length);
		hasTotalVolumeTraded = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTotalVolumeTraded(String str) {		
		if (str == null ) return;
		if (hasTotalVolumeTraded()) totalVolumeTraded = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		totalVolumeTraded = FixUtils.longValueOf(src, 0, src.length);
		hasTotalVolumeTraded = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getText() { 		
		if ( hasText()) {		
			if (hasText == FixUtils.TAG_HAS_VALUE) {		
				return text; 		
			} else {		
		
				buf.position(hasText);		
		
			FixMessage.getTagStringValue(buf, text, 0, text.length, err);
		
				if (err.hasError()) {		
					buf.position(hasText);		
					return null;		
				}		
			}		
			hasText = FixUtils.TAG_HAS_VALUE;		
			return text;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasText() { return hasText != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setText(byte[] src) {		
		if (src == null ) return;
		if (hasText()) FixUtils.fillNul(text);		
		FixUtils.copy(text, src); 		
		hasText = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setText(String str) {		
		if (str == null ) return;
		if (hasText()) FixUtils.fillNul(text);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(text, src); 		
		hasText = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getEncodedTextLen() { 		
		if ( hasEncodedTextLen()) {		
			if (hasEncodedTextLen == FixUtils.TAG_HAS_VALUE) {		
				return encodedTextLen; 		
			} else {		
		
				buf.position(hasEncodedTextLen);		
		
			encodedTextLen = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasEncodedTextLen);		
					return 0;		
				}		
			}		
			hasEncodedTextLen = FixUtils.TAG_HAS_VALUE;		
			return encodedTextLen;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEncodedTextLen() { return hasEncodedTextLen != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEncodedTextLen(long src) {		
		encodedTextLen = src;
		hasEncodedTextLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedTextLen(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedTextLen()) encodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		encodedTextLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedTextLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEncodedTextLen(String str) {		
		if (str == null ) return;
		if (hasEncodedTextLen()) encodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		encodedTextLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedTextLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getEncodedText() { 		
		if ( hasEncodedText()) {		
			if (hasEncodedText == FixUtils.TAG_HAS_VALUE) {		
				return encodedText; 		
			} else {		
		
				buf.position(hasEncodedText);		
		
			FixMessage.getTagStringValue(buf, encodedText, 0, encodedText.length, err);
		
				if (err.hasError()) {		
					buf.position(hasEncodedText);		
					return null;		
				}		
			}		
			hasEncodedText = FixUtils.TAG_HAS_VALUE;		
			return encodedText;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasEncodedText() { return hasEncodedText != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEncodedText(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedText()) FixUtils.fillNul(encodedText);		
		FixUtils.copy(encodedText, src); 		
		hasEncodedText = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEncodedText(String str) {		
		if (str == null ) return;
		if (hasEncodedText()) FixUtils.fillNul(encodedText);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(encodedText, src); 		
		hasEncodedText = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTransactTime() { 		
		if ( hasTransactTime()) {		
			if (hasTransactTime == FixUtils.TAG_HAS_VALUE) {		
				return transactTime; 		
			} else {		
		
				buf.position(hasTransactTime);		
		
			FixMessage.getTagStringValue(buf, transactTime, 0, transactTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTransactTime);		
					return null;		
				}		
			}		
			hasTransactTime = FixUtils.TAG_HAS_VALUE;		
			return transactTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTransactTime() { return hasTransactTime != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTransactTime(byte[] src) {		
		if (src == null ) return;
		if (hasTransactTime()) FixUtils.fillNul(transactTime);		
		FixUtils.copy(transactTime, src); 		
		hasTransactTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTransactTime(String str) {		
		if (str == null ) return;
		if (hasTransactTime()) FixUtils.fillNul(transactTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(transactTime, src); 		
		hasTransactTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasTradingSessionID()) s += "TradingSessionID(336)= " + new String( FixUtils.trim(getTradingSessionID()) ) + "\n" ; 
		if (hasTradingSessionSubID()) s += "TradingSessionSubID(625)= " + new String( FixUtils.trim(getTradingSessionSubID()) ) + "\n" ; 
		if (hasSecurityExchange()) s += "SecurityExchange(207)= " + new String( FixUtils.trim(getSecurityExchange()) ) + "\n" ; 
		if (hasTradSesMethod()) s += "TradSesMethod(338)= " + getTradSesMethod() + "\n" ; 
		if (hasTradSesMode()) s += "TradSesMode(339)= " + getTradSesMode() + "\n" ; 
		if (hasUnsolicitedIndicator()) s += "UnsolicitedIndicator(325)= " + getUnsolicitedIndicator() + "\n" ; 
		if (hasTradSesStatus()) s += "TradSesStatus(340)= " + getTradSesStatus() + "\n" ; 
		if (hasTradSesStatusRejReason()) s += "TradSesStatusRejReason(567)= " + getTradSesStatusRejReason() + "\n" ; 
		if (hasTradSesStartTime()) s += "TradSesStartTime(341)= " + new String( FixUtils.trim(getTradSesStartTime()) ) + "\n" ; 
		if (hasMarketID()) s += "MarketID(1301)= " + new String( FixUtils.trim(getMarketID()) ) + "\n" ; 
		if (hasMarketSegmentID()) s += "MarketSegmentID(1300)= " + new String( FixUtils.trim(getMarketSegmentID()) ) + "\n" ; 
		if (hasTradingSessionDesc()) s += "TradingSessionDesc(1326)= " + new String( FixUtils.trim(getTradingSessionDesc()) ) + "\n" ; 
		if (hasTradSesUpdateAction()) s += "TradSesUpdateAction(1327)= " + getTradSesUpdateAction() + "\n" ; 
		if (hasTradSesOpenTime()) s += "TradSesOpenTime(342)= " + new String( FixUtils.trim(getTradSesOpenTime()) ) + "\n" ; 
		if (hasTradSesPreCloseTime()) s += "TradSesPreCloseTime(343)= " + new String( FixUtils.trim(getTradSesPreCloseTime()) ) + "\n" ; 
		if (hasTradSesCloseTime()) s += "TradSesCloseTime(344)= " + new String( FixUtils.trim(getTradSesCloseTime()) ) + "\n" ; 
		if (hasTradSesEndTime()) s += "TradSesEndTime(345)= " + new String( FixUtils.trim(getTradSesEndTime()) ) + "\n" ; 
		if (hasTotalVolumeTraded()) s += "TotalVolumeTraded(387)= " + getTotalVolumeTraded() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasText()) s += "Text(58)= " + new String( FixUtils.trim(getText()) ) + "\n" ; 
		if (hasEncodedTextLen()) s += "EncodedTextLen(354)= " + getEncodedTextLen() + "\n" ; 
		if (hasEncodedText()) s += "EncodedText(355)= " + new String( FixUtils.trim(getEncodedText()) ) + "\n" ; 
		if (hasTransactTime()) s += "TransactTime(60)= " + new String( FixUtils.trim(getTransactTime()) ) + "\n" ; 

		s += tradingSessionRules.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixTrdSessLstGrp)) return false;

		FixTrdSessLstGrp msg = (FixTrdSessLstGrp) o;

		if (!tradingSessionRules.equals(msg.tradingSessionRules)) return false;
		if ((hasTradingSessionID() && !msg.hasTradingSessionID()) || (!hasTradingSessionID() && msg.hasTradingSessionID())) return false;
		if (!(!hasTradingSessionID() && !msg.hasTradingSessionID()) && !FixUtils.equals(getTradingSessionID(), msg.getTradingSessionID())) return false;
		if ((hasTradingSessionSubID() && !msg.hasTradingSessionSubID()) || (!hasTradingSessionSubID() && msg.hasTradingSessionSubID())) return false;
		if (!(!hasTradingSessionSubID() && !msg.hasTradingSessionSubID()) && !FixUtils.equals(getTradingSessionSubID(), msg.getTradingSessionSubID())) return false;
		if ((hasSecurityExchange() && !msg.hasSecurityExchange()) || (!hasSecurityExchange() && msg.hasSecurityExchange())) return false;
		if (!(!hasSecurityExchange() && !msg.hasSecurityExchange()) && !FixUtils.equals(getSecurityExchange(), msg.getSecurityExchange())) return false;
		if ((hasTradSesMethod() && !msg.hasTradSesMethod()) || (!hasTradSesMethod() && msg.hasTradSesMethod())) return false;
		if (!(!hasTradSesMethod() && !msg.hasTradSesMethod()) && !(getTradSesMethod()==msg.getTradSesMethod())) return false;
		if ((hasTradSesMode() && !msg.hasTradSesMode()) || (!hasTradSesMode() && msg.hasTradSesMode())) return false;
		if (!(!hasTradSesMode() && !msg.hasTradSesMode()) && !(getTradSesMode()==msg.getTradSesMode())) return false;
		if ((hasUnsolicitedIndicator() && !msg.hasUnsolicitedIndicator()) || (!hasUnsolicitedIndicator() && msg.hasUnsolicitedIndicator())) return false;
		if (!(!hasUnsolicitedIndicator() && !msg.hasUnsolicitedIndicator()) && !(getUnsolicitedIndicator()==msg.getUnsolicitedIndicator())) return false;
		if ((hasTradSesStatus() && !msg.hasTradSesStatus()) || (!hasTradSesStatus() && msg.hasTradSesStatus())) return false;
		if (!(!hasTradSesStatus() && !msg.hasTradSesStatus()) && !(getTradSesStatus()==msg.getTradSesStatus())) return false;
		if ((hasTradSesStatusRejReason() && !msg.hasTradSesStatusRejReason()) || (!hasTradSesStatusRejReason() && msg.hasTradSesStatusRejReason())) return false;
		if (!(!hasTradSesStatusRejReason() && !msg.hasTradSesStatusRejReason()) && !(getTradSesStatusRejReason()==msg.getTradSesStatusRejReason())) return false;
		if ((hasTradSesStartTime() && !msg.hasTradSesStartTime()) || (!hasTradSesStartTime() && msg.hasTradSesStartTime())) return false;
		if ((hasMarketID() && !msg.hasMarketID()) || (!hasMarketID() && msg.hasMarketID())) return false;
		if (!(!hasMarketID() && !msg.hasMarketID()) && !FixUtils.equals(getMarketID(), msg.getMarketID())) return false;
		if ((hasMarketSegmentID() && !msg.hasMarketSegmentID()) || (!hasMarketSegmentID() && msg.hasMarketSegmentID())) return false;
		if (!(!hasMarketSegmentID() && !msg.hasMarketSegmentID()) && !FixUtils.equals(getMarketSegmentID(), msg.getMarketSegmentID())) return false;
		if ((hasTradingSessionDesc() && !msg.hasTradingSessionDesc()) || (!hasTradingSessionDesc() && msg.hasTradingSessionDesc())) return false;
		if (!(!hasTradingSessionDesc() && !msg.hasTradingSessionDesc()) && !FixUtils.equals(getTradingSessionDesc(), msg.getTradingSessionDesc())) return false;
		if ((hasTradSesUpdateAction() && !msg.hasTradSesUpdateAction()) || (!hasTradSesUpdateAction() && msg.hasTradSesUpdateAction())) return false;
		if (!(!hasTradSesUpdateAction() && !msg.hasTradSesUpdateAction()) && !(getTradSesUpdateAction()==msg.getTradSesUpdateAction())) return false;
		if ((hasTradSesOpenTime() && !msg.hasTradSesOpenTime()) || (!hasTradSesOpenTime() && msg.hasTradSesOpenTime())) return false;
		if ((hasTradSesPreCloseTime() && !msg.hasTradSesPreCloseTime()) || (!hasTradSesPreCloseTime() && msg.hasTradSesPreCloseTime())) return false;
		if ((hasTradSesCloseTime() && !msg.hasTradSesCloseTime()) || (!hasTradSesCloseTime() && msg.hasTradSesCloseTime())) return false;
		if ((hasTradSesEndTime() && !msg.hasTradSesEndTime()) || (!hasTradSesEndTime() && msg.hasTradSesEndTime())) return false;
		if ((hasTotalVolumeTraded() && !msg.hasTotalVolumeTraded()) || (!hasTotalVolumeTraded() && msg.hasTotalVolumeTraded())) return false;
		if (!(!hasTotalVolumeTraded() && !msg.hasTotalVolumeTraded()) && !(getTotalVolumeTraded()==msg.getTotalVolumeTraded())) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasEncodedTextLen() && !msg.hasEncodedTextLen()) || (!hasEncodedTextLen() && msg.hasEncodedTextLen())) return false;
		if (!(!hasEncodedTextLen() && !msg.hasEncodedTextLen()) && !(getEncodedTextLen()==msg.getEncodedTextLen())) return false;
		if ((hasEncodedText() && !msg.hasEncodedText()) || (!hasEncodedText() && msg.hasEncodedText())) return false;
		if (!(!hasEncodedText() && !msg.hasEncodedText()) && !FixUtils.equals(getEncodedText(), msg.getEncodedText())) return false;
		if ((hasTransactTime() && !msg.hasTransactTime()) || (!hasTransactTime() && msg.hasTransactTime())) return false;
		return true;
	}
	public FixTrdSessLstGrp clone ( FixTrdSessLstGrp out ) {
		if ( hasTradingSessionID())
			out.setTradingSessionID(getTradingSessionID());
		if ( hasTradingSessionSubID())
			out.setTradingSessionSubID(getTradingSessionSubID());
		if ( hasSecurityExchange())
			out.setSecurityExchange(getSecurityExchange());
		if ( hasTradSesMethod())
			out.setTradSesMethod(getTradSesMethod());
		if ( hasTradSesMode())
			out.setTradSesMode(getTradSesMode());
		if ( hasUnsolicitedIndicator())
			out.setUnsolicitedIndicator(getUnsolicitedIndicator());
		if ( hasTradSesStatus())
			out.setTradSesStatus(getTradSesStatus());
		if ( hasTradSesStatusRejReason())
			out.setTradSesStatusRejReason(getTradSesStatusRejReason());
		if ( hasTradSesStartTime())
			out.setTradSesStartTime(getTradSesStartTime());
		if ( hasMarketID())
			out.setMarketID(getMarketID());
		if ( hasMarketSegmentID())
			out.setMarketSegmentID(getMarketSegmentID());
		if ( hasTradingSessionDesc())
			out.setTradingSessionDesc(getTradingSessionDesc());
		if ( hasTradSesUpdateAction())
			out.setTradSesUpdateAction(getTradSesUpdateAction());
		if ( hasTradSesOpenTime())
			out.setTradSesOpenTime(getTradSesOpenTime());
		if ( hasTradSesPreCloseTime())
			out.setTradSesPreCloseTime(getTradSesPreCloseTime());
		if ( hasTradSesCloseTime())
			out.setTradSesCloseTime(getTradSesCloseTime());
		if ( hasTradSesEndTime())
			out.setTradSesEndTime(getTradSesEndTime());
		if ( hasTotalVolumeTraded())
			out.setTotalVolumeTraded(getTotalVolumeTraded());
		if ( hasText())
			out.setText(getText());
		if ( hasEncodedTextLen())
			out.setEncodedTextLen(getEncodedTextLen());
		if ( hasEncodedText())
			out.setEncodedText(getEncodedText());
		if ( hasTransactTime())
			out.setTransactTime(getTransactTime());
		if (tradingSessionRules.hasGroup())
			out.tradingSessionRules = tradingSessionRules.clone( out.tradingSessionRules);
		return out;
	}

}
