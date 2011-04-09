package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixUnderlyingLegInstrument extends FixGroup {
	private short hasUnderlyingLegSymbol;
	byte[] underlyingLegSymbol = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingLegSymbolSfx;
	byte[] underlyingLegSymbolSfx = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingLegSecurityID;
	byte[] underlyingLegSecurityID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingLegSecurityIDSource;
	byte[] underlyingLegSecurityIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingLegCFICode;
	byte[] underlyingLegCFICode = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingLegSecurityType;
	byte[] underlyingLegSecurityType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingLegSecuritySubType;
	byte[] underlyingLegSecuritySubType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingLegMaturityMonthYear;
	byte[] underlyingLegMaturityMonthYear = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingLegMaturityDate;
	byte[] underlyingLegMaturityDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingLegMaturityTime;
	byte[] underlyingLegMaturityTime = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingLegStrikePrice;
	long underlyingLegStrikePrice = 0;		
	private short hasUnderlyingLegOptAttribute;
	byte underlyingLegOptAttribute = (byte)' ';		
	private short hasUnderlyingLegPutOrCall;
	long underlyingLegPutOrCall = 0;		
	private short hasUnderlyingLegSecurityExchange;
	byte[] underlyingLegSecurityExchange = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingLegSecurityDesc;
	byte[] underlyingLegSecurityDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		public FixUnderlyingLegSecurityAltIDGrp[] underlyingLegSecurityAltIDGrp;
	
	public FixUnderlyingLegInstrument() {
		this(false);
	}

	public FixUnderlyingLegInstrument(boolean isRequired) {
		super(FixTags.UNDERLYINGLEGSYMBOL_INT);

		this.isRequired = isRequired;
		
		hasUnderlyingLegSymbol = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingLegSymbol = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingLegSymbolSfx = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingLegSymbolSfx = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingLegSecurityID = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingLegSecurityID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingLegSecurityIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingLegSecurityIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingLegCFICode = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingLegCFICode = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingLegSecurityType = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingLegSecurityType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingLegSecuritySubType = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingLegSecuritySubType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingLegMaturityMonthYear = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingLegMaturityMonthYear = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingLegMaturityDate = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingLegMaturityDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingLegMaturityTime = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingLegMaturityTime = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingLegStrikePrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingLegOptAttribute = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingLegPutOrCall = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingLegSecurityExchange = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingLegSecurityExchange = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingLegSecurityDesc = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingLegSecurityDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		underlyingLegSecurityAltIDGrp = new FixUnderlyingLegSecurityAltIDGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) underlyingLegSecurityAltIDGrp[i] = new FixUnderlyingLegSecurityAltIDGrp();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasUnderlyingLegSymbol()) return true;
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
            	case FixTags.UNDERLYINGLEGSYMBOL_INT:		
            		hasUnderlyingLegSymbol = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGLEGSYMBOLSFX_INT:		
            		hasUnderlyingLegSymbolSfx = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGLEGSECURITYID_INT:		
            		hasUnderlyingLegSecurityID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGLEGSECURITYIDSOURCE_INT:		
            		hasUnderlyingLegSecurityIDSource = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGLEGCFICODE_INT:		
            		hasUnderlyingLegCFICode = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGLEGSECURITYTYPE_INT:		
            		hasUnderlyingLegSecurityType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGLEGSECURITYSUBTYPE_INT:		
            		hasUnderlyingLegSecuritySubType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGLEGMATURITYMONTHYEAR_INT:		
            		hasUnderlyingLegMaturityMonthYear = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGLEGMATURITYDATE_INT:		
            		hasUnderlyingLegMaturityDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGLEGMATURITYTIME_INT:		
            		hasUnderlyingLegMaturityTime = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGLEGSTRIKEPRICE_INT:		
            		hasUnderlyingLegStrikePrice = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGLEGOPTATTRIBUTE_INT:		
            		hasUnderlyingLegOptAttribute = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGLEGPUTORCALL_INT:		
            		hasUnderlyingLegPutOrCall = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGLEGSECURITYEXCHANGE_INT:		
            		hasUnderlyingLegSecurityExchange = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGLEGSECURITYDESC_INT:		
            		hasUnderlyingLegSecurityDesc = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NOUNDERLYINGLEGSECURITYALTID_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !underlyingLegSecurityAltIDGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = underlyingLegSecurityAltIDGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else { return tag; }
            }

            tag = FixUtils.getTag(buf, err);
            if (err.hasError()) return tag; // what to do now? 
            if (isKeyTag(tag)) return tag; // next in repeating group
        }		
        return tag;
    }		
	public boolean hasRequiredTags(FixValidationError err) {
		return true;
	}
	@Override
	public void clear() {
		// just set the length to header + trailer but still we set it...
		hasUnderlyingLegSymbol = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingLegSymbolSfx = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingLegSecurityID = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingLegSecurityIDSource = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingLegCFICode = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingLegSecurityType = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingLegSecuritySubType = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingLegMaturityMonthYear = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingLegMaturityDate = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingLegMaturityTime = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingLegStrikePrice = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingLegOptAttribute = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingLegPutOrCall = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingLegSecurityExchange = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingLegSecurityDesc = FixUtils.TAG_HAS_NO_VALUE;
		for (FixUnderlyingLegSecurityAltIDGrp fixUnderlyingLegSecurityAltIDGrp : underlyingLegSecurityAltIDGrp) fixUnderlyingLegSecurityAltIDGrp.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasUnderlyingLegSymbol()) {		
			out.put(FixTags.UNDERLYINGLEGSYMBOL);

			out.put((byte) '=');

			FixUtils.put(out,underlyingLegSymbol); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingLegSymbolSfx()) {		
			out.put(FixTags.UNDERLYINGLEGSYMBOLSFX);

			out.put((byte) '=');

			FixUtils.put(out,underlyingLegSymbolSfx); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingLegSecurityID()) {		
			out.put(FixTags.UNDERLYINGLEGSECURITYID);

			out.put((byte) '=');

			FixUtils.put(out,underlyingLegSecurityID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingLegSecurityIDSource()) {		
			out.put(FixTags.UNDERLYINGLEGSECURITYIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,underlyingLegSecurityIDSource); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingLegCFICode()) {		
			out.put(FixTags.UNDERLYINGLEGCFICODE);

			out.put((byte) '=');

			FixUtils.put(out,underlyingLegCFICode); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingLegSecurityType()) {		
			out.put(FixTags.UNDERLYINGLEGSECURITYTYPE);

			out.put((byte) '=');

			FixUtils.put(out,underlyingLegSecurityType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingLegSecuritySubType()) {		
			out.put(FixTags.UNDERLYINGLEGSECURITYSUBTYPE);

			out.put((byte) '=');

			FixUtils.put(out,underlyingLegSecuritySubType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingLegMaturityMonthYear()) {		
			out.put(FixTags.UNDERLYINGLEGMATURITYMONTHYEAR);

			out.put((byte) '=');

			FixUtils.put(out,underlyingLegMaturityMonthYear); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingLegMaturityDate()) {		
			out.put(FixTags.UNDERLYINGLEGMATURITYDATE);

			out.put((byte) '=');

			FixUtils.put(out,underlyingLegMaturityDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingLegMaturityTime()) {		
			out.put(FixTags.UNDERLYINGLEGMATURITYTIME);

			out.put((byte) '=');

			FixUtils.put(out,underlyingLegMaturityTime); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingLegStrikePrice()) {		
			out.put(FixTags.UNDERLYINGLEGSTRIKEPRICE);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingLegStrikePrice);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingLegOptAttribute()) {		
			out.put(FixTags.UNDERLYINGLEGOPTATTRIBUTE);

			out.put((byte) '=');

			FixUtils.put(out,underlyingLegOptAttribute); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingLegPutOrCall()) {		
			out.put(FixTags.UNDERLYINGLEGPUTORCALL);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingLegPutOrCall);
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingLegSecurityExchange()) {		
			out.put(FixTags.UNDERLYINGLEGSECURITYEXCHANGE);

			out.put((byte) '=');

			FixUtils.put(out,underlyingLegSecurityExchange); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingLegSecurityDesc()) {		
			out.put(FixTags.UNDERLYINGLEGSECURITYDESC);

			out.put((byte) '=');

			FixUtils.put(out,underlyingLegSecurityDesc); 		
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(underlyingLegSecurityAltIDGrp)>0) {
			out.put(FixTags.NOUNDERLYINGLEGSECURITYALTID);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(underlyingLegSecurityAltIDGrp));

			out.put(FixUtils.SOH);

		}
		for (FixUnderlyingLegSecurityAltIDGrp fixUnderlyingLegSecurityAltIDGrp : underlyingLegSecurityAltIDGrp) if (fixUnderlyingLegSecurityAltIDGrp.hasGroup()) fixUnderlyingLegSecurityAltIDGrp.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasUnderlyingLegSymbol()) {		
			FixUtils.put(out,underlyingLegSymbol); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingLegSymbolSfx()) {		
			FixUtils.put(out,underlyingLegSymbolSfx); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingLegSecurityID()) {		
			FixUtils.put(out,underlyingLegSecurityID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingLegSecurityIDSource()) {		
			FixUtils.put(out,underlyingLegSecurityIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingLegCFICode()) {		
			FixUtils.put(out,underlyingLegCFICode); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingLegSecurityType()) {		
			FixUtils.put(out,underlyingLegSecurityType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingLegSecuritySubType()) {		
			FixUtils.put(out,underlyingLegSecuritySubType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingLegMaturityMonthYear()) {		
			FixUtils.put(out,underlyingLegMaturityMonthYear); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingLegMaturityDate()) {		
			FixUtils.put(out,underlyingLegMaturityDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingLegMaturityTime()) {		
			FixUtils.put(out,underlyingLegMaturityTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingLegStrikePrice()) {		
			FixUtils.put(out, (long)underlyingLegStrikePrice);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingLegOptAttribute()) {		
			FixUtils.put(out,underlyingLegOptAttribute); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingLegPutOrCall()) {		
			FixUtils.put(out, (long)underlyingLegPutOrCall);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingLegSecurityExchange()) {		
			FixUtils.put(out,underlyingLegSecurityExchange); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingLegSecurityDesc()) {		
			FixUtils.put(out,underlyingLegSecurityDesc); 		
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixUnderlyingLegSecurityAltIDGrp fixUnderlyingLegSecurityAltIDGrp : underlyingLegSecurityAltIDGrp) fixUnderlyingLegSecurityAltIDGrp.printBuffer(out);
	}

	public byte[] getUnderlyingLegSymbol() { 		
		if ( hasUnderlyingLegSymbol()) {		
			if (hasUnderlyingLegSymbol == FixUtils.TAG_HAS_VALUE) {		
				return underlyingLegSymbol; 		
			} else {		
		
				buf.position(hasUnderlyingLegSymbol);		
		
			FixUtils.getTagStringValue(buf, underlyingLegSymbol, 0, underlyingLegSymbol.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingLegSymbol);		
					return null;		
				}		
			}		
			hasUnderlyingLegSymbol = FixUtils.TAG_HAS_VALUE;		
			return underlyingLegSymbol;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingLegSymbol() { return hasUnderlyingLegSymbol != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingLegSymbol(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingLegSymbol()) FixUtils.fillNul(underlyingLegSymbol);		
		FixUtils.copy(underlyingLegSymbol, src); 		
		hasUnderlyingLegSymbol = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingLegSymbol(String str) {		
		if (str == null ) return;
		if (hasUnderlyingLegSymbol()) FixUtils.fillNul(underlyingLegSymbol);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingLegSymbol, src); 		
		hasUnderlyingLegSymbol = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingLegSymbolSfx() { 		
		if ( hasUnderlyingLegSymbolSfx()) {		
			if (hasUnderlyingLegSymbolSfx == FixUtils.TAG_HAS_VALUE) {		
				return underlyingLegSymbolSfx; 		
			} else {		
		
				buf.position(hasUnderlyingLegSymbolSfx);		
		
			FixUtils.getTagStringValue(buf, underlyingLegSymbolSfx, 0, underlyingLegSymbolSfx.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingLegSymbolSfx);		
					return null;		
				}		
			}		
			hasUnderlyingLegSymbolSfx = FixUtils.TAG_HAS_VALUE;		
			return underlyingLegSymbolSfx;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingLegSymbolSfx() { return hasUnderlyingLegSymbolSfx != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingLegSymbolSfx(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingLegSymbolSfx()) FixUtils.fillNul(underlyingLegSymbolSfx);		
		FixUtils.copy(underlyingLegSymbolSfx, src); 		
		hasUnderlyingLegSymbolSfx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingLegSymbolSfx(String str) {		
		if (str == null ) return;
		if (hasUnderlyingLegSymbolSfx()) FixUtils.fillNul(underlyingLegSymbolSfx);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingLegSymbolSfx, src); 		
		hasUnderlyingLegSymbolSfx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingLegSecurityID() { 		
		if ( hasUnderlyingLegSecurityID()) {		
			if (hasUnderlyingLegSecurityID == FixUtils.TAG_HAS_VALUE) {		
				return underlyingLegSecurityID; 		
			} else {		
		
				buf.position(hasUnderlyingLegSecurityID);		
		
			FixUtils.getTagStringValue(buf, underlyingLegSecurityID, 0, underlyingLegSecurityID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingLegSecurityID);		
					return null;		
				}		
			}		
			hasUnderlyingLegSecurityID = FixUtils.TAG_HAS_VALUE;		
			return underlyingLegSecurityID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingLegSecurityID() { return hasUnderlyingLegSecurityID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingLegSecurityID(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingLegSecurityID()) FixUtils.fillNul(underlyingLegSecurityID);		
		FixUtils.copy(underlyingLegSecurityID, src); 		
		hasUnderlyingLegSecurityID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingLegSecurityID(String str) {		
		if (str == null ) return;
		if (hasUnderlyingLegSecurityID()) FixUtils.fillNul(underlyingLegSecurityID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingLegSecurityID, src); 		
		hasUnderlyingLegSecurityID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingLegSecurityIDSource() { 		
		if ( hasUnderlyingLegSecurityIDSource()) {		
			if (hasUnderlyingLegSecurityIDSource == FixUtils.TAG_HAS_VALUE) {		
				return underlyingLegSecurityIDSource; 		
			} else {		
		
				buf.position(hasUnderlyingLegSecurityIDSource);		
		
			FixUtils.getTagStringValue(buf, underlyingLegSecurityIDSource, 0, underlyingLegSecurityIDSource.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingLegSecurityIDSource);		
					return null;		
				}		
			}		
			hasUnderlyingLegSecurityIDSource = FixUtils.TAG_HAS_VALUE;		
			return underlyingLegSecurityIDSource;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingLegSecurityIDSource() { return hasUnderlyingLegSecurityIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingLegSecurityIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingLegSecurityIDSource()) FixUtils.fillNul(underlyingLegSecurityIDSource);		
		FixUtils.copy(underlyingLegSecurityIDSource, src); 		
		hasUnderlyingLegSecurityIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingLegSecurityIDSource(String str) {		
		if (str == null ) return;
		if (hasUnderlyingLegSecurityIDSource()) FixUtils.fillNul(underlyingLegSecurityIDSource);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingLegSecurityIDSource, src); 		
		hasUnderlyingLegSecurityIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingLegCFICode() { 		
		if ( hasUnderlyingLegCFICode()) {		
			if (hasUnderlyingLegCFICode == FixUtils.TAG_HAS_VALUE) {		
				return underlyingLegCFICode; 		
			} else {		
		
				buf.position(hasUnderlyingLegCFICode);		
		
			FixUtils.getTagStringValue(buf, underlyingLegCFICode, 0, underlyingLegCFICode.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingLegCFICode);		
					return null;		
				}		
			}		
			hasUnderlyingLegCFICode = FixUtils.TAG_HAS_VALUE;		
			return underlyingLegCFICode;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingLegCFICode() { return hasUnderlyingLegCFICode != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingLegCFICode(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingLegCFICode()) FixUtils.fillNul(underlyingLegCFICode);		
		FixUtils.copy(underlyingLegCFICode, src); 		
		hasUnderlyingLegCFICode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingLegCFICode(String str) {		
		if (str == null ) return;
		if (hasUnderlyingLegCFICode()) FixUtils.fillNul(underlyingLegCFICode);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingLegCFICode, src); 		
		hasUnderlyingLegCFICode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingLegSecurityType() { 		
		if ( hasUnderlyingLegSecurityType()) {		
			if (hasUnderlyingLegSecurityType == FixUtils.TAG_HAS_VALUE) {		
				return underlyingLegSecurityType; 		
			} else {		
		
				buf.position(hasUnderlyingLegSecurityType);		
		
			FixUtils.getTagStringValue(buf, underlyingLegSecurityType, 0, underlyingLegSecurityType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingLegSecurityType);		
					return null;		
				}		
			}		
			hasUnderlyingLegSecurityType = FixUtils.TAG_HAS_VALUE;		
			return underlyingLegSecurityType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingLegSecurityType() { return hasUnderlyingLegSecurityType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingLegSecurityType(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingLegSecurityType()) FixUtils.fillNul(underlyingLegSecurityType);		
		FixUtils.copy(underlyingLegSecurityType, src); 		
		hasUnderlyingLegSecurityType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingLegSecurityType(String str) {		
		if (str == null ) return;
		if (hasUnderlyingLegSecurityType()) FixUtils.fillNul(underlyingLegSecurityType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingLegSecurityType, src); 		
		hasUnderlyingLegSecurityType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingLegSecuritySubType() { 		
		if ( hasUnderlyingLegSecuritySubType()) {		
			if (hasUnderlyingLegSecuritySubType == FixUtils.TAG_HAS_VALUE) {		
				return underlyingLegSecuritySubType; 		
			} else {		
		
				buf.position(hasUnderlyingLegSecuritySubType);		
		
			FixUtils.getTagStringValue(buf, underlyingLegSecuritySubType, 0, underlyingLegSecuritySubType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingLegSecuritySubType);		
					return null;		
				}		
			}		
			hasUnderlyingLegSecuritySubType = FixUtils.TAG_HAS_VALUE;		
			return underlyingLegSecuritySubType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingLegSecuritySubType() { return hasUnderlyingLegSecuritySubType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingLegSecuritySubType(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingLegSecuritySubType()) FixUtils.fillNul(underlyingLegSecuritySubType);		
		FixUtils.copy(underlyingLegSecuritySubType, src); 		
		hasUnderlyingLegSecuritySubType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingLegSecuritySubType(String str) {		
		if (str == null ) return;
		if (hasUnderlyingLegSecuritySubType()) FixUtils.fillNul(underlyingLegSecuritySubType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingLegSecuritySubType, src); 		
		hasUnderlyingLegSecuritySubType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingLegMaturityMonthYear() { 		
		if ( hasUnderlyingLegMaturityMonthYear()) {		
			if (hasUnderlyingLegMaturityMonthYear == FixUtils.TAG_HAS_VALUE) {		
				return underlyingLegMaturityMonthYear; 		
			} else {		
		
				buf.position(hasUnderlyingLegMaturityMonthYear);		
		
			FixUtils.getTagStringValue(buf, underlyingLegMaturityMonthYear, 0, underlyingLegMaturityMonthYear.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingLegMaturityMonthYear);		
					return null;		
				}		
			}		
			hasUnderlyingLegMaturityMonthYear = FixUtils.TAG_HAS_VALUE;		
			return underlyingLegMaturityMonthYear;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingLegMaturityMonthYear() { return hasUnderlyingLegMaturityMonthYear != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingLegMaturityMonthYear(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingLegMaturityMonthYear()) FixUtils.fillNul(underlyingLegMaturityMonthYear);		
		FixUtils.copy(underlyingLegMaturityMonthYear, src); 		
		hasUnderlyingLegMaturityMonthYear = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingLegMaturityMonthYear(String str) {		
		if (str == null ) return;
		if (hasUnderlyingLegMaturityMonthYear()) FixUtils.fillNul(underlyingLegMaturityMonthYear);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingLegMaturityMonthYear, src); 		
		hasUnderlyingLegMaturityMonthYear = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingLegMaturityDate() { 		
		if ( hasUnderlyingLegMaturityDate()) {		
			if (hasUnderlyingLegMaturityDate == FixUtils.TAG_HAS_VALUE) {		
				return underlyingLegMaturityDate; 		
			} else {		
		
				buf.position(hasUnderlyingLegMaturityDate);		
		
			FixUtils.getTagStringValue(buf, underlyingLegMaturityDate, 0, underlyingLegMaturityDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingLegMaturityDate);		
					return null;		
				}		
			}		
			hasUnderlyingLegMaturityDate = FixUtils.TAG_HAS_VALUE;		
			return underlyingLegMaturityDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingLegMaturityDate() { return hasUnderlyingLegMaturityDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingLegMaturityDate(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingLegMaturityDate()) FixUtils.fillNul(underlyingLegMaturityDate);		
		FixUtils.copy(underlyingLegMaturityDate, src); 		
		hasUnderlyingLegMaturityDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingLegMaturityDate(String str) {		
		if (str == null ) return;
		if (hasUnderlyingLegMaturityDate()) FixUtils.fillNul(underlyingLegMaturityDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingLegMaturityDate, src); 		
		hasUnderlyingLegMaturityDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingLegMaturityTime() { 		
		if ( hasUnderlyingLegMaturityTime()) {		
			if (hasUnderlyingLegMaturityTime == FixUtils.TAG_HAS_VALUE) {		
				return underlyingLegMaturityTime; 		
			} else {		
		
				buf.position(hasUnderlyingLegMaturityTime);		
		
			FixUtils.getTagStringValue(buf, underlyingLegMaturityTime, 0, underlyingLegMaturityTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingLegMaturityTime);		
					return null;		
				}		
			}		
			hasUnderlyingLegMaturityTime = FixUtils.TAG_HAS_VALUE;		
			return underlyingLegMaturityTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingLegMaturityTime() { return hasUnderlyingLegMaturityTime != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingLegMaturityTime(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingLegMaturityTime()) FixUtils.fillNul(underlyingLegMaturityTime);		
		FixUtils.copy(underlyingLegMaturityTime, src); 		
		hasUnderlyingLegMaturityTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingLegMaturityTime(String str) {		
		if (str == null ) return;
		if (hasUnderlyingLegMaturityTime()) FixUtils.fillNul(underlyingLegMaturityTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingLegMaturityTime, src); 		
		hasUnderlyingLegMaturityTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingLegStrikePrice() { 		
		if ( hasUnderlyingLegStrikePrice()) {		
			if (hasUnderlyingLegStrikePrice == FixUtils.TAG_HAS_VALUE) {		
				return underlyingLegStrikePrice; 		
			} else {		
		
				buf.position(hasUnderlyingLegStrikePrice);		
		
			underlyingLegStrikePrice = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingLegStrikePrice);		
					return 0;		
				}		
			}		
			hasUnderlyingLegStrikePrice = FixUtils.TAG_HAS_VALUE;		
			return underlyingLegStrikePrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingLegStrikePrice() { return hasUnderlyingLegStrikePrice != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingLegStrikePrice(long src) {		
		underlyingLegStrikePrice = src;
		hasUnderlyingLegStrikePrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingLegStrikePrice(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingLegStrikePrice()) underlyingLegStrikePrice = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingLegStrikePrice = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingLegStrikePrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingLegStrikePrice(String str) {		
		if (str == null ) return;
		if (hasUnderlyingLegStrikePrice()) underlyingLegStrikePrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingLegStrikePrice = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingLegStrikePrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getUnderlyingLegOptAttribute() { 		
		if ( hasUnderlyingLegOptAttribute()) {		
			if (hasUnderlyingLegOptAttribute == FixUtils.TAG_HAS_VALUE) {		
				return underlyingLegOptAttribute; 		
			} else {		
		
				buf.position(hasUnderlyingLegOptAttribute);		
		
			underlyingLegOptAttribute = FixUtils.getTagCharValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingLegOptAttribute);		
					return (byte)'0';		
				}		
			}		
			hasUnderlyingLegOptAttribute = FixUtils.TAG_HAS_VALUE;		
			return underlyingLegOptAttribute;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasUnderlyingLegOptAttribute() { return hasUnderlyingLegOptAttribute != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingLegOptAttribute(byte src) {		
		underlyingLegOptAttribute = src;
		hasUnderlyingLegOptAttribute = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingLegOptAttribute(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingLegOptAttribute()) underlyingLegOptAttribute = (byte)' ';		
		underlyingLegOptAttribute = src[0];		
		hasUnderlyingLegOptAttribute = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingLegOptAttribute(String str) {		
		if (str == null ) return;
		if (hasUnderlyingLegOptAttribute()) underlyingLegOptAttribute = (byte)' ';		
		byte[] src = str.getBytes(); 		
		underlyingLegOptAttribute = src[0];		
		hasUnderlyingLegOptAttribute = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingLegPutOrCall() { 		
		if ( hasUnderlyingLegPutOrCall()) {		
			if (hasUnderlyingLegPutOrCall == FixUtils.TAG_HAS_VALUE) {		
				return underlyingLegPutOrCall; 		
			} else {		
		
				buf.position(hasUnderlyingLegPutOrCall);		
		
			underlyingLegPutOrCall = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingLegPutOrCall);		
					return 0;		
				}		
			}		
			hasUnderlyingLegPutOrCall = FixUtils.TAG_HAS_VALUE;		
			return underlyingLegPutOrCall;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingLegPutOrCall() { return hasUnderlyingLegPutOrCall != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingLegPutOrCall(long src) {		
		underlyingLegPutOrCall = src;
		hasUnderlyingLegPutOrCall = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingLegPutOrCall(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingLegPutOrCall()) underlyingLegPutOrCall = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingLegPutOrCall = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingLegPutOrCall = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingLegPutOrCall(String str) {		
		if (str == null ) return;
		if (hasUnderlyingLegPutOrCall()) underlyingLegPutOrCall = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingLegPutOrCall = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingLegPutOrCall = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingLegSecurityExchange() { 		
		if ( hasUnderlyingLegSecurityExchange()) {		
			if (hasUnderlyingLegSecurityExchange == FixUtils.TAG_HAS_VALUE) {		
				return underlyingLegSecurityExchange; 		
			} else {		
		
				buf.position(hasUnderlyingLegSecurityExchange);		
		
			FixUtils.getTagStringValue(buf, underlyingLegSecurityExchange, 0, underlyingLegSecurityExchange.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingLegSecurityExchange);		
					return null;		
				}		
			}		
			hasUnderlyingLegSecurityExchange = FixUtils.TAG_HAS_VALUE;		
			return underlyingLegSecurityExchange;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingLegSecurityExchange() { return hasUnderlyingLegSecurityExchange != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingLegSecurityExchange(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingLegSecurityExchange()) FixUtils.fillNul(underlyingLegSecurityExchange);		
		FixUtils.copy(underlyingLegSecurityExchange, src); 		
		hasUnderlyingLegSecurityExchange = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingLegSecurityExchange(String str) {		
		if (str == null ) return;
		if (hasUnderlyingLegSecurityExchange()) FixUtils.fillNul(underlyingLegSecurityExchange);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingLegSecurityExchange, src); 		
		hasUnderlyingLegSecurityExchange = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getUnderlyingLegSecurityDesc() { 		
		if ( hasUnderlyingLegSecurityDesc()) {		
			if (hasUnderlyingLegSecurityDesc == FixUtils.TAG_HAS_VALUE) {		
				return underlyingLegSecurityDesc; 		
			} else {		
		
				buf.position(hasUnderlyingLegSecurityDesc);		
		
			FixUtils.getTagStringValue(buf, underlyingLegSecurityDesc, 0, underlyingLegSecurityDesc.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingLegSecurityDesc);		
					return null;		
				}		
			}		
			hasUnderlyingLegSecurityDesc = FixUtils.TAG_HAS_VALUE;		
			return underlyingLegSecurityDesc;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingLegSecurityDesc() { return hasUnderlyingLegSecurityDesc != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingLegSecurityDesc(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingLegSecurityDesc()) FixUtils.fillNul(underlyingLegSecurityDesc);		
		FixUtils.copy(underlyingLegSecurityDesc, src); 		
		hasUnderlyingLegSecurityDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingLegSecurityDesc(String str) {		
		if (str == null ) return;
		if (hasUnderlyingLegSecurityDesc()) FixUtils.fillNul(underlyingLegSecurityDesc);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingLegSecurityDesc, src); 		
		hasUnderlyingLegSecurityDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasUnderlyingLegSymbol()) s += "UnderlyingLegSymbol(1330)= " + new String( FixUtils.trim(getUnderlyingLegSymbol()) ) + "\n" ; 
		if (hasUnderlyingLegSymbolSfx()) s += "UnderlyingLegSymbolSfx(1331)= " + new String( FixUtils.trim(getUnderlyingLegSymbolSfx()) ) + "\n" ; 
		if (hasUnderlyingLegSecurityID()) s += "UnderlyingLegSecurityID(1332)= " + new String( FixUtils.trim(getUnderlyingLegSecurityID()) ) + "\n" ; 
		if (hasUnderlyingLegSecurityIDSource()) s += "UnderlyingLegSecurityIDSource(1333)= " + new String( FixUtils.trim(getUnderlyingLegSecurityIDSource()) ) + "\n" ; 
		if (hasUnderlyingLegCFICode()) s += "UnderlyingLegCFICode(1344)= " + new String( FixUtils.trim(getUnderlyingLegCFICode()) ) + "\n" ; 
		if (hasUnderlyingLegSecurityType()) s += "UnderlyingLegSecurityType(1337)= " + new String( FixUtils.trim(getUnderlyingLegSecurityType()) ) + "\n" ; 
		if (hasUnderlyingLegSecuritySubType()) s += "UnderlyingLegSecuritySubType(1338)= " + new String( FixUtils.trim(getUnderlyingLegSecuritySubType()) ) + "\n" ; 
		if (hasUnderlyingLegMaturityMonthYear()) s += "UnderlyingLegMaturityMonthYear(1339)= " + new String( FixUtils.trim(getUnderlyingLegMaturityMonthYear()) ) + "\n" ; 
		if (hasUnderlyingLegMaturityDate()) s += "UnderlyingLegMaturityDate(1345)= " + new String( FixUtils.trim(getUnderlyingLegMaturityDate()) ) + "\n" ; 
		if (hasUnderlyingLegMaturityTime()) s += "UnderlyingLegMaturityTime(1405)= " + new String( FixUtils.trim(getUnderlyingLegMaturityTime()) ) + "\n" ; 
		if (hasUnderlyingLegStrikePrice()) s += "UnderlyingLegStrikePrice(1340)= " + getUnderlyingLegStrikePrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasUnderlyingLegOptAttribute()) s += "UnderlyingLegOptAttribute(1391)= " + getUnderlyingLegOptAttribute() + "\n" ; 
		if (hasUnderlyingLegPutOrCall()) s += "UnderlyingLegPutOrCall(1343)= " + getUnderlyingLegPutOrCall() + "\n" ; 
		if (hasUnderlyingLegSecurityExchange()) s += "UnderlyingLegSecurityExchange(1341)= " + new String( FixUtils.trim(getUnderlyingLegSecurityExchange()) ) + "\n" ; 
		if (hasUnderlyingLegSecurityDesc()) s += "UnderlyingLegSecurityDesc(1392)= " + new String( FixUtils.trim(getUnderlyingLegSecurityDesc()) ) + "\n" ; 

		for (FixUnderlyingLegSecurityAltIDGrp fixUnderlyingLegSecurityAltIDGrp : underlyingLegSecurityAltIDGrp) fixUnderlyingLegSecurityAltIDGrp.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixUnderlyingLegInstrument)) return false;

		FixUnderlyingLegInstrument msg = (FixUnderlyingLegInstrument) o;

		for (int i = 0; i < underlyingLegSecurityAltIDGrp.length; i++)
			if (!underlyingLegSecurityAltIDGrp[i].equals(msg.underlyingLegSecurityAltIDGrp[i])) return false;
		if ((hasUnderlyingLegSymbol() && !msg.hasUnderlyingLegSymbol()) || (!hasUnderlyingLegSymbol() && msg.hasUnderlyingLegSymbol())) return false;
		if (!(!hasUnderlyingLegSymbol() && !msg.hasUnderlyingLegSymbol()) && !FixUtils.equals(getUnderlyingLegSymbol(), msg.getUnderlyingLegSymbol())) return false;
		if ((hasUnderlyingLegSymbolSfx() && !msg.hasUnderlyingLegSymbolSfx()) || (!hasUnderlyingLegSymbolSfx() && msg.hasUnderlyingLegSymbolSfx())) return false;
		if (!(!hasUnderlyingLegSymbolSfx() && !msg.hasUnderlyingLegSymbolSfx()) && !FixUtils.equals(getUnderlyingLegSymbolSfx(), msg.getUnderlyingLegSymbolSfx())) return false;
		if ((hasUnderlyingLegSecurityID() && !msg.hasUnderlyingLegSecurityID()) || (!hasUnderlyingLegSecurityID() && msg.hasUnderlyingLegSecurityID())) return false;
		if (!(!hasUnderlyingLegSecurityID() && !msg.hasUnderlyingLegSecurityID()) && !FixUtils.equals(getUnderlyingLegSecurityID(), msg.getUnderlyingLegSecurityID())) return false;
		if ((hasUnderlyingLegSecurityIDSource() && !msg.hasUnderlyingLegSecurityIDSource()) || (!hasUnderlyingLegSecurityIDSource() && msg.hasUnderlyingLegSecurityIDSource())) return false;
		if (!(!hasUnderlyingLegSecurityIDSource() && !msg.hasUnderlyingLegSecurityIDSource()) && !FixUtils.equals(getUnderlyingLegSecurityIDSource(), msg.getUnderlyingLegSecurityIDSource())) return false;
		if ((hasUnderlyingLegCFICode() && !msg.hasUnderlyingLegCFICode()) || (!hasUnderlyingLegCFICode() && msg.hasUnderlyingLegCFICode())) return false;
		if (!(!hasUnderlyingLegCFICode() && !msg.hasUnderlyingLegCFICode()) && !FixUtils.equals(getUnderlyingLegCFICode(), msg.getUnderlyingLegCFICode())) return false;
		if ((hasUnderlyingLegSecurityType() && !msg.hasUnderlyingLegSecurityType()) || (!hasUnderlyingLegSecurityType() && msg.hasUnderlyingLegSecurityType())) return false;
		if (!(!hasUnderlyingLegSecurityType() && !msg.hasUnderlyingLegSecurityType()) && !FixUtils.equals(getUnderlyingLegSecurityType(), msg.getUnderlyingLegSecurityType())) return false;
		if ((hasUnderlyingLegSecuritySubType() && !msg.hasUnderlyingLegSecuritySubType()) || (!hasUnderlyingLegSecuritySubType() && msg.hasUnderlyingLegSecuritySubType())) return false;
		if (!(!hasUnderlyingLegSecuritySubType() && !msg.hasUnderlyingLegSecuritySubType()) && !FixUtils.equals(getUnderlyingLegSecuritySubType(), msg.getUnderlyingLegSecuritySubType())) return false;
		if ((hasUnderlyingLegMaturityMonthYear() && !msg.hasUnderlyingLegMaturityMonthYear()) || (!hasUnderlyingLegMaturityMonthYear() && msg.hasUnderlyingLegMaturityMonthYear())) return false;
		if (!(!hasUnderlyingLegMaturityMonthYear() && !msg.hasUnderlyingLegMaturityMonthYear()) && !FixUtils.equals(getUnderlyingLegMaturityMonthYear(), msg.getUnderlyingLegMaturityMonthYear())) return false;
		if ((hasUnderlyingLegMaturityDate() && !msg.hasUnderlyingLegMaturityDate()) || (!hasUnderlyingLegMaturityDate() && msg.hasUnderlyingLegMaturityDate())) return false;
		if ((hasUnderlyingLegMaturityTime() && !msg.hasUnderlyingLegMaturityTime()) || (!hasUnderlyingLegMaturityTime() && msg.hasUnderlyingLegMaturityTime())) return false;
		if ((hasUnderlyingLegStrikePrice() && !msg.hasUnderlyingLegStrikePrice()) || (!hasUnderlyingLegStrikePrice() && msg.hasUnderlyingLegStrikePrice())) return false;
		if (!(!hasUnderlyingLegStrikePrice() && !msg.hasUnderlyingLegStrikePrice()) && !(getUnderlyingLegStrikePrice()==msg.getUnderlyingLegStrikePrice())) return false;
		if ((hasUnderlyingLegOptAttribute() && !msg.hasUnderlyingLegOptAttribute()) || (!hasUnderlyingLegOptAttribute() && msg.hasUnderlyingLegOptAttribute())) return false;
		if (!(!hasUnderlyingLegOptAttribute() && !msg.hasUnderlyingLegOptAttribute()) && !(getUnderlyingLegOptAttribute()==msg.getUnderlyingLegOptAttribute())) return false;
		if ((hasUnderlyingLegPutOrCall() && !msg.hasUnderlyingLegPutOrCall()) || (!hasUnderlyingLegPutOrCall() && msg.hasUnderlyingLegPutOrCall())) return false;
		if (!(!hasUnderlyingLegPutOrCall() && !msg.hasUnderlyingLegPutOrCall()) && !(getUnderlyingLegPutOrCall()==msg.getUnderlyingLegPutOrCall())) return false;
		if ((hasUnderlyingLegSecurityExchange() && !msg.hasUnderlyingLegSecurityExchange()) || (!hasUnderlyingLegSecurityExchange() && msg.hasUnderlyingLegSecurityExchange())) return false;
		if (!(!hasUnderlyingLegSecurityExchange() && !msg.hasUnderlyingLegSecurityExchange()) && !FixUtils.equals(getUnderlyingLegSecurityExchange(), msg.getUnderlyingLegSecurityExchange())) return false;
		if ((hasUnderlyingLegSecurityDesc() && !msg.hasUnderlyingLegSecurityDesc()) || (!hasUnderlyingLegSecurityDesc() && msg.hasUnderlyingLegSecurityDesc())) return false;
		if (!(!hasUnderlyingLegSecurityDesc() && !msg.hasUnderlyingLegSecurityDesc()) && !FixUtils.equals(getUnderlyingLegSecurityDesc(), msg.getUnderlyingLegSecurityDesc())) return false;
		return true;
	}
	public FixUnderlyingLegInstrument clone ( FixUnderlyingLegInstrument out ) {
		if ( hasUnderlyingLegSymbol())
			out.setUnderlyingLegSymbol(getUnderlyingLegSymbol());
		if ( hasUnderlyingLegSymbolSfx())
			out.setUnderlyingLegSymbolSfx(getUnderlyingLegSymbolSfx());
		if ( hasUnderlyingLegSecurityID())
			out.setUnderlyingLegSecurityID(getUnderlyingLegSecurityID());
		if ( hasUnderlyingLegSecurityIDSource())
			out.setUnderlyingLegSecurityIDSource(getUnderlyingLegSecurityIDSource());
		if ( hasUnderlyingLegCFICode())
			out.setUnderlyingLegCFICode(getUnderlyingLegCFICode());
		if ( hasUnderlyingLegSecurityType())
			out.setUnderlyingLegSecurityType(getUnderlyingLegSecurityType());
		if ( hasUnderlyingLegSecuritySubType())
			out.setUnderlyingLegSecuritySubType(getUnderlyingLegSecuritySubType());
		if ( hasUnderlyingLegMaturityMonthYear())
			out.setUnderlyingLegMaturityMonthYear(getUnderlyingLegMaturityMonthYear());
		if ( hasUnderlyingLegMaturityDate())
			out.setUnderlyingLegMaturityDate(getUnderlyingLegMaturityDate());
		if ( hasUnderlyingLegMaturityTime())
			out.setUnderlyingLegMaturityTime(getUnderlyingLegMaturityTime());
		if ( hasUnderlyingLegStrikePrice())
			out.setUnderlyingLegStrikePrice(getUnderlyingLegStrikePrice());
		if ( hasUnderlyingLegOptAttribute())
			out.setUnderlyingLegOptAttribute(getUnderlyingLegOptAttribute());
		if ( hasUnderlyingLegPutOrCall())
			out.setUnderlyingLegPutOrCall(getUnderlyingLegPutOrCall());
		if ( hasUnderlyingLegSecurityExchange())
			out.setUnderlyingLegSecurityExchange(getUnderlyingLegSecurityExchange());
		if ( hasUnderlyingLegSecurityDesc())
			out.setUnderlyingLegSecurityDesc(getUnderlyingLegSecurityDesc());
		int count = 0;
		count = 0;
		for (FixUnderlyingLegSecurityAltIDGrp fixUnderlyingLegSecurityAltIDGrp : underlyingLegSecurityAltIDGrp) {
			if (!fixUnderlyingLegSecurityAltIDGrp.hasGroup()) continue;
			out.underlyingLegSecurityAltIDGrp[count] = fixUnderlyingLegSecurityAltIDGrp.clone( out.underlyingLegSecurityAltIDGrp[count] );
			count++;
		}
		return out;
	}

}
