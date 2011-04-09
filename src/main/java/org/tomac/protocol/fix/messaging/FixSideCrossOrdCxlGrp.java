package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixSideCrossOrdCxlGrp extends FixGroup {
	private short hasSide;
	byte side = (byte)' ';		
	private short hasOrigClOrdID;
	byte[] origClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasClOrdID;
	byte[] clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSecondaryClOrdID;
	byte[] secondaryClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasClOrdLinkID;
	byte[] clOrdLinkID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasOrigOrdModTime;
	byte[] origOrdModTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasTradeOriginationDate;
	byte[] tradeOriginationDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTradeDate;
	byte[] tradeDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasComplianceID;
	byte[] complianceID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedTextLen;
	long encodedTextLen = 0;		
	private short hasEncodedText;
	byte[] encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		public FixParties[] parties;
		public FixOrderQtyData orderQtyData;
	
	public FixSideCrossOrdCxlGrp() {
		this(false);
	}

	public FixSideCrossOrdCxlGrp(boolean isRequired) {
		super(FixTags.SIDE_INT);

		this.isRequired = isRequired;
		
		hasSide = FixUtils.TAG_HAS_NO_VALUE;		
		hasOrigClOrdID = FixUtils.TAG_HAS_NO_VALUE;		
		origClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasClOrdID = FixUtils.TAG_HAS_NO_VALUE;		
		clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSecondaryClOrdID = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasClOrdLinkID = FixUtils.TAG_HAS_NO_VALUE;		
		clOrdLinkID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasOrigOrdModTime = FixUtils.TAG_HAS_NO_VALUE;		
		origOrdModTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasTradeOriginationDate = FixUtils.TAG_HAS_NO_VALUE;		
		tradeOriginationDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTradeDate = FixUtils.TAG_HAS_NO_VALUE;		
		tradeDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasComplianceID = FixUtils.TAG_HAS_NO_VALUE;		
		complianceID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		parties = new FixParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) parties[i] = new FixParties();
		orderQtyData = new FixOrderQtyData(true);
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasSide()) return true;
		else return false;
	}


	/**
     * Parse FIX Group. The buffer is positioned at the value of the tag.
     */
    public int setBuffer( int tag, ByteBuffer buf, FixValidationError err)
    {

		super.err = err;
		super.setBuffer(buf, err);


        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.SIDE_INT:		
            		hasSide = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.ORIGCLORDID_INT:		
            		hasOrigClOrdID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.CLORDID_INT:		
            		hasClOrdID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SECONDARYCLORDID_INT:		
            		hasSecondaryClOrdID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.CLORDLINKID_INT:		
            		hasClOrdLinkID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.ORIGORDMODTIME_INT:		
            		hasOrigOrdModTime = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.TRADEORIGINATIONDATE_INT:		
            		hasTradeOriginationDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.TRADEDATE_INT:		
            		hasTradeDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.COMPLIANCEID_INT:		
            		hasComplianceID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.TEXT_INT:		
            		hasText = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.ENCODEDTEXTLEN_INT:		
            		hasEncodedTextLen = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.ENCODEDTEXT_INT:		
            		hasEncodedText = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NOPARTYIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !parties[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NOPARTYIDS_INT);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = parties[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( orderQtyData.isKeyTag(tag)) {
        				tag = orderQtyData.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
            		} else { return tag; }
            }

            tag = FixUtils.getTag(buf, err);
            if (err.hasError()) return tag; // what to do now? 
            if (isKeyTag(tag)) return tag; // next in repeating group
        }		
        return tag;
    }		
	public boolean hasRequiredTags(FixValidationError err) {
		if (!hasSide()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.SIDE_INT);
			return false;
		}
		if (!hasClOrdID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.CLORDID_INT);
			return false;
		}
		if (orderQtyData.isRequired) orderQtyData.hasRequiredTags(err); if (err.hasError()) return false;
		return true;
	}
	@Override
	public void clear() {
		// just set the length to header + trailer but still we set it...
		hasSide = FixUtils.TAG_HAS_NO_VALUE;
		hasOrigClOrdID = FixUtils.TAG_HAS_NO_VALUE;
		hasClOrdID = FixUtils.TAG_HAS_NO_VALUE;
		hasSecondaryClOrdID = FixUtils.TAG_HAS_NO_VALUE;
		hasClOrdLinkID = FixUtils.TAG_HAS_NO_VALUE;
		hasOrigOrdModTime = FixUtils.TAG_HAS_NO_VALUE;
		hasTradeOriginationDate = FixUtils.TAG_HAS_NO_VALUE;
		hasTradeDate = FixUtils.TAG_HAS_NO_VALUE;
		hasComplianceID = FixUtils.TAG_HAS_NO_VALUE;
		hasText = FixUtils.TAG_HAS_NO_VALUE;
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;
		for (FixParties fixParties : parties) fixParties.clear();
		orderQtyData.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasSide()) {		
			out.put(FixTags.SIDE);

			out.put((byte) '=');

			FixUtils.put(out,side); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasOrigClOrdID()) {		
			out.put(FixTags.ORIGCLORDID);

			out.put((byte) '=');

			FixUtils.put(out,origClOrdID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasClOrdID()) {		
			out.put(FixTags.CLORDID);

			out.put((byte) '=');

			FixUtils.put(out,clOrdID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSecondaryClOrdID()) {		
			out.put(FixTags.SECONDARYCLORDID);

			out.put((byte) '=');

			FixUtils.put(out,secondaryClOrdID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasClOrdLinkID()) {		
			out.put(FixTags.CLORDLINKID);

			out.put((byte) '=');

			FixUtils.put(out,clOrdLinkID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasOrigOrdModTime()) {		
			out.put(FixTags.ORIGORDMODTIME);

			out.put((byte) '=');

			FixUtils.put(out,origOrdModTime); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTradeOriginationDate()) {		
			out.put(FixTags.TRADEORIGINATIONDATE);

			out.put((byte) '=');

			FixUtils.put(out,tradeOriginationDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTradeDate()) {		
			out.put(FixTags.TRADEDATE);

			out.put((byte) '=');

			FixUtils.put(out,tradeDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasComplianceID()) {		
			out.put(FixTags.COMPLIANCEID);

			out.put((byte) '=');

			FixUtils.put(out,complianceID); 		
		
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

		if (FixUtils.getNoInGroup(parties)>0) {
			out.put(FixTags.NOPARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(parties));

			out.put(FixUtils.SOH);

		}
		for (FixParties fixParties : parties) if (fixParties.hasGroup()) fixParties.encode(out);
		orderQtyData.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasSide()) {		
			FixUtils.put(out,side); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrigClOrdID()) {		
			FixUtils.put(out,origClOrdID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClOrdID()) {		
			FixUtils.put(out,clOrdID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecondaryClOrdID()) {		
			FixUtils.put(out,secondaryClOrdID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasClOrdLinkID()) {		
			FixUtils.put(out,clOrdLinkID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrigOrdModTime()) {		
			FixUtils.put(out,origOrdModTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradeOriginationDate()) {		
			FixUtils.put(out,tradeOriginationDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTradeDate()) {		
			FixUtils.put(out,tradeDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasComplianceID()) {		
			FixUtils.put(out,complianceID); 		
		
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
		
		for (FixParties fixParties : parties) fixParties.printBuffer(out);
		orderQtyData.printBuffer(out);
	}

	public byte getSide() { 		
		if ( hasSide()) {		
			if (hasSide == FixUtils.TAG_HAS_VALUE) {		
				return side; 		
			} else {		
		
				buf.position(hasSide);		
		
			side = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (side != (byte)'D') && (side != (byte)'E') && (side != (byte)'F') && (side != (byte)'G') && (side != (byte)'A') && (side != (byte)'B') && (side != (byte)'C') && (side != (byte)'3') && (side != (byte)'2') && (side != (byte)'1') && (side != (byte)'7') && (side != (byte)'6') && (side != (byte)'5') && (side != (byte)'4') && (side != (byte)'9') && (side != (byte)'8') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 54);		
				if (err.hasError()) {		
					buf.position(hasSide);		
					return (byte)'0';		
				}		
			}		
			hasSide = FixUtils.TAG_HAS_VALUE;		
			return side;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasSide() { return hasSide != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSide(byte src) {		
		side = src;
		hasSide = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSide(byte[] src) {		
		if (src == null ) return;
		if (hasSide()) side = (byte)' ';		
		side = src[0];		
		hasSide = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSide(String str) {		
		if (str == null ) return;
		if (hasSide()) side = (byte)' ';		
		byte[] src = str.getBytes(); 		
		side = src[0];		
		hasSide = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getOrigClOrdID() { 		
		if ( hasOrigClOrdID()) {		
			if (hasOrigClOrdID == FixUtils.TAG_HAS_VALUE) {		
				return origClOrdID; 		
			} else {		
		
				buf.position(hasOrigClOrdID);		
		
			FixUtils.getTagStringValue(buf, origClOrdID, 0, origClOrdID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasOrigClOrdID);		
					return null;		
				}		
			}		
			hasOrigClOrdID = FixUtils.TAG_HAS_VALUE;		
			return origClOrdID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOrigClOrdID() { return hasOrigClOrdID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOrigClOrdID(byte[] src) {		
		if (src == null ) return;
		if (hasOrigClOrdID()) FixUtils.fillNul(origClOrdID);		
		FixUtils.copy(origClOrdID, src); 		
		hasOrigClOrdID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOrigClOrdID(String str) {		
		if (str == null ) return;
		if (hasOrigClOrdID()) FixUtils.fillNul(origClOrdID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(origClOrdID, src); 		
		hasOrigClOrdID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getClOrdID() { 		
		if ( hasClOrdID()) {		
			if (hasClOrdID == FixUtils.TAG_HAS_VALUE) {		
				return clOrdID; 		
			} else {		
		
				buf.position(hasClOrdID);		
		
			FixUtils.getTagStringValue(buf, clOrdID, 0, clOrdID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasClOrdID);		
					return null;		
				}		
			}		
			hasClOrdID = FixUtils.TAG_HAS_VALUE;		
			return clOrdID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasClOrdID() { return hasClOrdID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setClOrdID(byte[] src) {		
		if (src == null ) return;
		if (hasClOrdID()) FixUtils.fillNul(clOrdID);		
		FixUtils.copy(clOrdID, src); 		
		hasClOrdID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setClOrdID(String str) {		
		if (str == null ) return;
		if (hasClOrdID()) FixUtils.fillNul(clOrdID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(clOrdID, src); 		
		hasClOrdID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getSecondaryClOrdID() { 		
		if ( hasSecondaryClOrdID()) {		
			if (hasSecondaryClOrdID == FixUtils.TAG_HAS_VALUE) {		
				return secondaryClOrdID; 		
			} else {		
		
				buf.position(hasSecondaryClOrdID);		
		
			FixUtils.getTagStringValue(buf, secondaryClOrdID, 0, secondaryClOrdID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSecondaryClOrdID);		
					return null;		
				}		
			}		
			hasSecondaryClOrdID = FixUtils.TAG_HAS_VALUE;		
			return secondaryClOrdID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSecondaryClOrdID() { return hasSecondaryClOrdID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSecondaryClOrdID(byte[] src) {		
		if (src == null ) return;
		if (hasSecondaryClOrdID()) FixUtils.fillNul(secondaryClOrdID);		
		FixUtils.copy(secondaryClOrdID, src); 		
		hasSecondaryClOrdID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSecondaryClOrdID(String str) {		
		if (str == null ) return;
		if (hasSecondaryClOrdID()) FixUtils.fillNul(secondaryClOrdID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(secondaryClOrdID, src); 		
		hasSecondaryClOrdID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getClOrdLinkID() { 		
		if ( hasClOrdLinkID()) {		
			if (hasClOrdLinkID == FixUtils.TAG_HAS_VALUE) {		
				return clOrdLinkID; 		
			} else {		
		
				buf.position(hasClOrdLinkID);		
		
			FixUtils.getTagStringValue(buf, clOrdLinkID, 0, clOrdLinkID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasClOrdLinkID);		
					return null;		
				}		
			}		
			hasClOrdLinkID = FixUtils.TAG_HAS_VALUE;		
			return clOrdLinkID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasClOrdLinkID() { return hasClOrdLinkID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setClOrdLinkID(byte[] src) {		
		if (src == null ) return;
		if (hasClOrdLinkID()) FixUtils.fillNul(clOrdLinkID);		
		FixUtils.copy(clOrdLinkID, src); 		
		hasClOrdLinkID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setClOrdLinkID(String str) {		
		if (str == null ) return;
		if (hasClOrdLinkID()) FixUtils.fillNul(clOrdLinkID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(clOrdLinkID, src); 		
		hasClOrdLinkID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getOrigOrdModTime() { 		
		if ( hasOrigOrdModTime()) {		
			if (hasOrigOrdModTime == FixUtils.TAG_HAS_VALUE) {		
				return origOrdModTime; 		
			} else {		
		
				buf.position(hasOrigOrdModTime);		
		
			FixUtils.getTagStringValue(buf, origOrdModTime, 0, origOrdModTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasOrigOrdModTime);		
					return null;		
				}		
			}		
			hasOrigOrdModTime = FixUtils.TAG_HAS_VALUE;		
			return origOrdModTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOrigOrdModTime() { return hasOrigOrdModTime != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOrigOrdModTime(byte[] src) {		
		if (src == null ) return;
		if (hasOrigOrdModTime()) FixUtils.fillNul(origOrdModTime);		
		FixUtils.copy(origOrdModTime, src); 		
		hasOrigOrdModTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOrigOrdModTime(String str) {		
		if (str == null ) return;
		if (hasOrigOrdModTime()) FixUtils.fillNul(origOrdModTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(origOrdModTime, src); 		
		hasOrigOrdModTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTradeOriginationDate() { 		
		if ( hasTradeOriginationDate()) {		
			if (hasTradeOriginationDate == FixUtils.TAG_HAS_VALUE) {		
				return tradeOriginationDate; 		
			} else {		
		
				buf.position(hasTradeOriginationDate);		
		
			FixUtils.getTagStringValue(buf, tradeOriginationDate, 0, tradeOriginationDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTradeOriginationDate);		
					return null;		
				}		
			}		
			hasTradeOriginationDate = FixUtils.TAG_HAS_VALUE;		
			return tradeOriginationDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradeOriginationDate() { return hasTradeOriginationDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTradeOriginationDate(byte[] src) {		
		if (src == null ) return;
		if (hasTradeOriginationDate()) FixUtils.fillNul(tradeOriginationDate);		
		FixUtils.copy(tradeOriginationDate, src); 		
		hasTradeOriginationDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTradeOriginationDate(String str) {		
		if (str == null ) return;
		if (hasTradeOriginationDate()) FixUtils.fillNul(tradeOriginationDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradeOriginationDate, src); 		
		hasTradeOriginationDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTradeDate() { 		
		if ( hasTradeDate()) {		
			if (hasTradeDate == FixUtils.TAG_HAS_VALUE) {		
				return tradeDate; 		
			} else {		
		
				buf.position(hasTradeDate);		
		
			FixUtils.getTagStringValue(buf, tradeDate, 0, tradeDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTradeDate);		
					return null;		
				}		
			}		
			hasTradeDate = FixUtils.TAG_HAS_VALUE;		
			return tradeDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTradeDate() { return hasTradeDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTradeDate(byte[] src) {		
		if (src == null ) return;
		if (hasTradeDate()) FixUtils.fillNul(tradeDate);		
		FixUtils.copy(tradeDate, src); 		
		hasTradeDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTradeDate(String str) {		
		if (str == null ) return;
		if (hasTradeDate()) FixUtils.fillNul(tradeDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(tradeDate, src); 		
		hasTradeDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getComplianceID() { 		
		if ( hasComplianceID()) {		
			if (hasComplianceID == FixUtils.TAG_HAS_VALUE) {		
				return complianceID; 		
			} else {		
		
				buf.position(hasComplianceID);		
		
			FixUtils.getTagStringValue(buf, complianceID, 0, complianceID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasComplianceID);		
					return null;		
				}		
			}		
			hasComplianceID = FixUtils.TAG_HAS_VALUE;		
			return complianceID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasComplianceID() { return hasComplianceID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setComplianceID(byte[] src) {		
		if (src == null ) return;
		if (hasComplianceID()) FixUtils.fillNul(complianceID);		
		FixUtils.copy(complianceID, src); 		
		hasComplianceID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setComplianceID(String str) {		
		if (str == null ) return;
		if (hasComplianceID()) FixUtils.fillNul(complianceID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(complianceID, src); 		
		hasComplianceID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getText() { 		
		if ( hasText()) {		
			if (hasText == FixUtils.TAG_HAS_VALUE) {		
				return text; 		
			} else {		
		
				buf.position(hasText);		
		
			FixUtils.getTagStringValue(buf, text, 0, text.length, err);
		
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
		
			encodedTextLen = FixUtils.getTagIntValue(buf, err);
		
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
		
			FixUtils.getTagStringValue(buf, encodedText, 0, encodedText.length, err);
		
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
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasSide()) s += "Side(54)= " + getSide() + "\n" ; 
		if (hasOrigClOrdID()) s += "OrigClOrdID(41)= " + new String( FixUtils.trim(getOrigClOrdID()) ) + "\n" ; 
		if (hasClOrdID()) s += "ClOrdID(11)= " + new String( FixUtils.trim(getClOrdID()) ) + "\n" ; 
		if (hasSecondaryClOrdID()) s += "SecondaryClOrdID(526)= " + new String( FixUtils.trim(getSecondaryClOrdID()) ) + "\n" ; 
		if (hasClOrdLinkID()) s += "ClOrdLinkID(583)= " + new String( FixUtils.trim(getClOrdLinkID()) ) + "\n" ; 
		if (hasOrigOrdModTime()) s += "OrigOrdModTime(586)= " + new String( FixUtils.trim(getOrigOrdModTime()) ) + "\n" ; 
		if (hasTradeOriginationDate()) s += "TradeOriginationDate(229)= " + new String( FixUtils.trim(getTradeOriginationDate()) ) + "\n" ; 
		if (hasTradeDate()) s += "TradeDate(75)= " + new String( FixUtils.trim(getTradeDate()) ) + "\n" ; 
		if (hasComplianceID()) s += "ComplianceID(376)= " + new String( FixUtils.trim(getComplianceID()) ) + "\n" ; 
		if (hasText()) s += "Text(58)= " + new String( FixUtils.trim(getText()) ) + "\n" ; 
		if (hasEncodedTextLen()) s += "EncodedTextLen(354)= " + getEncodedTextLen() + "\n" ; 
		if (hasEncodedText()) s += "EncodedText(355)= " + new String( FixUtils.trim(getEncodedText()) ) + "\n" ; 

		for (FixParties fixParties : parties) fixParties.toString();
		s += orderQtyData.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixSideCrossOrdCxlGrp)) return false;

		FixSideCrossOrdCxlGrp msg = (FixSideCrossOrdCxlGrp) o;

		for (int i = 0; i < parties.length; i++)
			if (!parties[i].equals(msg.parties[i])) return false;
		if (!orderQtyData.equals(msg.orderQtyData)) return false;
		if ((hasSide() && !msg.hasSide()) || (!hasSide() && msg.hasSide())) return false;
		if (!(!hasSide() && !msg.hasSide()) && !(getSide()==msg.getSide())) return false;
		if ((hasOrigClOrdID() && !msg.hasOrigClOrdID()) || (!hasOrigClOrdID() && msg.hasOrigClOrdID())) return false;
		if (!(!hasOrigClOrdID() && !msg.hasOrigClOrdID()) && !FixUtils.equals(getOrigClOrdID(), msg.getOrigClOrdID())) return false;
		if ((hasClOrdID() && !msg.hasClOrdID()) || (!hasClOrdID() && msg.hasClOrdID())) return false;
		if (!(!hasClOrdID() && !msg.hasClOrdID()) && !FixUtils.equals(getClOrdID(), msg.getClOrdID())) return false;
		if ((hasSecondaryClOrdID() && !msg.hasSecondaryClOrdID()) || (!hasSecondaryClOrdID() && msg.hasSecondaryClOrdID())) return false;
		if (!(!hasSecondaryClOrdID() && !msg.hasSecondaryClOrdID()) && !FixUtils.equals(getSecondaryClOrdID(), msg.getSecondaryClOrdID())) return false;
		if ((hasClOrdLinkID() && !msg.hasClOrdLinkID()) || (!hasClOrdLinkID() && msg.hasClOrdLinkID())) return false;
		if (!(!hasClOrdLinkID() && !msg.hasClOrdLinkID()) && !FixUtils.equals(getClOrdLinkID(), msg.getClOrdLinkID())) return false;
		if ((hasOrigOrdModTime() && !msg.hasOrigOrdModTime()) || (!hasOrigOrdModTime() && msg.hasOrigOrdModTime())) return false;
		if ((hasTradeOriginationDate() && !msg.hasTradeOriginationDate()) || (!hasTradeOriginationDate() && msg.hasTradeOriginationDate())) return false;
		if ((hasTradeDate() && !msg.hasTradeDate()) || (!hasTradeDate() && msg.hasTradeDate())) return false;
		if ((hasComplianceID() && !msg.hasComplianceID()) || (!hasComplianceID() && msg.hasComplianceID())) return false;
		if (!(!hasComplianceID() && !msg.hasComplianceID()) && !FixUtils.equals(getComplianceID(), msg.getComplianceID())) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasEncodedTextLen() && !msg.hasEncodedTextLen()) || (!hasEncodedTextLen() && msg.hasEncodedTextLen())) return false;
		if (!(!hasEncodedTextLen() && !msg.hasEncodedTextLen()) && !(getEncodedTextLen()==msg.getEncodedTextLen())) return false;
		if ((hasEncodedText() && !msg.hasEncodedText()) || (!hasEncodedText() && msg.hasEncodedText())) return false;
		if (!(!hasEncodedText() && !msg.hasEncodedText()) && !FixUtils.equals(getEncodedText(), msg.getEncodedText())) return false;
		return true;
	}
	public FixSideCrossOrdCxlGrp clone ( FixSideCrossOrdCxlGrp out ) {
		if ( hasSide())
			out.setSide(getSide());
		if ( hasOrigClOrdID())
			out.setOrigClOrdID(getOrigClOrdID());
		if ( hasClOrdID())
			out.setClOrdID(getClOrdID());
		if ( hasSecondaryClOrdID())
			out.setSecondaryClOrdID(getSecondaryClOrdID());
		if ( hasClOrdLinkID())
			out.setClOrdLinkID(getClOrdLinkID());
		if ( hasOrigOrdModTime())
			out.setOrigOrdModTime(getOrigOrdModTime());
		if ( hasTradeOriginationDate())
			out.setTradeOriginationDate(getTradeOriginationDate());
		if ( hasTradeDate())
			out.setTradeDate(getTradeDate());
		if ( hasComplianceID())
			out.setComplianceID(getComplianceID());
		if ( hasText())
			out.setText(getText());
		if ( hasEncodedTextLen())
			out.setEncodedTextLen(getEncodedTextLen());
		if ( hasEncodedText())
			out.setEncodedText(getEncodedText());
		int count = 0;
		count = 0;
		for (FixParties fixParties : parties) {
			if (!fixParties.hasGroup()) continue;
			out.parties[count] = fixParties.clone( out.parties[count] );
			count++;
		}
		if (orderQtyData.hasGroup())
			out.orderQtyData = orderQtyData.clone( out.orderQtyData);
		return out;
	}

}
