package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixMaturityRules extends FixGroup {
	private short hasMaturityRuleID;
	byte[] maturityRuleID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMaturityMonthYearFormat;
	long maturityMonthYearFormat = 0;		
	private short hasMaturityMonthYearIncrementUnits;
	long maturityMonthYearIncrementUnits = 0;		
	private short hasStartMaturityMonthYear;
	byte[] startMaturityMonthYear = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasEndMaturityMonthYear;
	byte[] endMaturityMonthYear = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMaturityMonthYearIncrement;
	long maturityMonthYearIncrement = 0;		
	
	public FixMaturityRules() {
		super(FixTags.MATURITYRULEID_INT);

		
		hasMaturityRuleID = FixUtils.TAG_HAS_NO_VALUE;		
		maturityRuleID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMaturityMonthYearFormat = FixUtils.TAG_HAS_NO_VALUE;		
		hasMaturityMonthYearIncrementUnits = FixUtils.TAG_HAS_NO_VALUE;		
		hasStartMaturityMonthYear = FixUtils.TAG_HAS_NO_VALUE;		
		startMaturityMonthYear = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasEndMaturityMonthYear = FixUtils.TAG_HAS_NO_VALUE;		
		endMaturityMonthYear = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMaturityMonthYearIncrement = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasMaturityRuleID()) return true;
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
            	case FixTags.MATURITYRULEID_INT:		
            		hasMaturityRuleID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MATURITYMONTHYEARFORMAT_INT:		
            		hasMaturityMonthYearFormat = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MATURITYMONTHYEARINCREMENTUNITS_INT:		
            		hasMaturityMonthYearIncrementUnits = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.STARTMATURITYMONTHYEAR_INT:		
            		hasStartMaturityMonthYear = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ENDMATURITYMONTHYEAR_INT:		
            		hasEndMaturityMonthYear = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MATURITYMONTHYEARINCREMENT_INT:		
            		hasMaturityMonthYearIncrement = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
            		return tag;

            }

            tag = FixMessage.getTag(buf, err);
            if (err.hasError()) return tag; // what to do now? 
        }		
        return tag;
    }		
	@Override
	public void clear() {
		// just set the length to header + trailer but still we set it...
		hasMaturityRuleID = FixUtils.TAG_HAS_NO_VALUE;
		hasMaturityMonthYearFormat = FixUtils.TAG_HAS_NO_VALUE;
		hasMaturityMonthYearIncrementUnits = FixUtils.TAG_HAS_NO_VALUE;
		hasStartMaturityMonthYear = FixUtils.TAG_HAS_NO_VALUE;
		hasEndMaturityMonthYear = FixUtils.TAG_HAS_NO_VALUE;
		hasMaturityMonthYearIncrement = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasMaturityRuleID()) {		
			out.put(FixTags.MATURITYRULEID);

			out.put((byte) '=');

			FixUtils.put(out,maturityRuleID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasMaturityMonthYearFormat()) {		
			out.put(FixTags.MATURITYMONTHYEARFORMAT);

			out.put((byte) '=');

			FixUtils.put(out, (long)maturityMonthYearFormat);
		
			out.put(FixUtils.SOH);

            }

		if (hasMaturityMonthYearIncrementUnits()) {		
			out.put(FixTags.MATURITYMONTHYEARINCREMENTUNITS);

			out.put((byte) '=');

			FixUtils.put(out, (long)maturityMonthYearIncrementUnits);
		
			out.put(FixUtils.SOH);

            }

		if (hasStartMaturityMonthYear()) {		
			out.put(FixTags.STARTMATURITYMONTHYEAR);

			out.put((byte) '=');

			FixUtils.put(out,startMaturityMonthYear); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasEndMaturityMonthYear()) {		
			out.put(FixTags.ENDMATURITYMONTHYEAR);

			out.put((byte) '=');

			FixUtils.put(out,endMaturityMonthYear); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasMaturityMonthYearIncrement()) {		
			out.put(FixTags.MATURITYMONTHYEARINCREMENT);

			out.put((byte) '=');

			FixUtils.put(out, (long)maturityMonthYearIncrement);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasMaturityRuleID()) {		
			FixUtils.put(out,maturityRuleID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMaturityMonthYearFormat()) {		
			FixUtils.put(out, (long)maturityMonthYearFormat);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMaturityMonthYearIncrementUnits()) {		
			FixUtils.put(out, (long)maturityMonthYearIncrementUnits);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasStartMaturityMonthYear()) {		
			FixUtils.put(out,startMaturityMonthYear); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEndMaturityMonthYear()) {		
			FixUtils.put(out,endMaturityMonthYear); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMaturityMonthYearIncrement()) {		
			FixUtils.put(out, (long)maturityMonthYearIncrement);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getMaturityRuleID() { 		
		if ( hasMaturityRuleID()) {		
			if (hasMaturityRuleID == FixUtils.TAG_HAS_VALUE) {		
				return maturityRuleID; 		
			} else {		
		
				buf.position(hasMaturityRuleID);		
		
			FixMessage.getTagStringValue(buf, maturityRuleID, 0, maturityRuleID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasMaturityRuleID);		
					return null;		
				}		
			}		
			hasMaturityRuleID = FixUtils.TAG_HAS_VALUE;		
			return maturityRuleID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMaturityRuleID() { return hasMaturityRuleID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMaturityRuleID(byte[] src) {		
		if (src == null ) return;
		if (hasMaturityRuleID()) FixUtils.fillSpace(maturityRuleID);		
		FixUtils.copy(maturityRuleID, src); 		
		hasMaturityRuleID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMaturityRuleID(String str) {		
		if (str == null ) return;
		if (hasMaturityRuleID()) FixUtils.fillSpace(maturityRuleID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(maturityRuleID, src); 		
		hasMaturityRuleID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getMaturityMonthYearFormat() { 		
		if ( hasMaturityMonthYearFormat()) {		
			if (hasMaturityMonthYearFormat == FixUtils.TAG_HAS_VALUE) {		
				return maturityMonthYearFormat; 		
			} else {		
		
				buf.position(hasMaturityMonthYearFormat);		
		
			maturityMonthYearFormat = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMaturityMonthYearFormat);		
					return 0;		
				}		
			}		
			hasMaturityMonthYearFormat = FixUtils.TAG_HAS_VALUE;		
			return maturityMonthYearFormat;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMaturityMonthYearFormat() { return hasMaturityMonthYearFormat != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMaturityMonthYearFormat(long src) {		
		maturityMonthYearFormat = src;
		hasMaturityMonthYearFormat = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMaturityMonthYearFormat(byte[] src) {		
		if (src == null ) return;
		if (hasMaturityMonthYearFormat()) maturityMonthYearFormat = FixUtils.TAG_HAS_NO_VALUE;		
		maturityMonthYearFormat = FixUtils.longValueOf(src, 0, src.length);
		hasMaturityMonthYearFormat = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMaturityMonthYearFormat(String str) {		
		if (str == null ) return;
		if (hasMaturityMonthYearFormat()) maturityMonthYearFormat = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		maturityMonthYearFormat = FixUtils.longValueOf(src, 0, src.length);
		hasMaturityMonthYearFormat = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getMaturityMonthYearIncrementUnits() { 		
		if ( hasMaturityMonthYearIncrementUnits()) {		
			if (hasMaturityMonthYearIncrementUnits == FixUtils.TAG_HAS_VALUE) {		
				return maturityMonthYearIncrementUnits; 		
			} else {		
		
				buf.position(hasMaturityMonthYearIncrementUnits);		
		
			maturityMonthYearIncrementUnits = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMaturityMonthYearIncrementUnits);		
					return 0;		
				}		
			}		
			hasMaturityMonthYearIncrementUnits = FixUtils.TAG_HAS_VALUE;		
			return maturityMonthYearIncrementUnits;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMaturityMonthYearIncrementUnits() { return hasMaturityMonthYearIncrementUnits != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMaturityMonthYearIncrementUnits(long src) {		
		maturityMonthYearIncrementUnits = src;
		hasMaturityMonthYearIncrementUnits = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMaturityMonthYearIncrementUnits(byte[] src) {		
		if (src == null ) return;
		if (hasMaturityMonthYearIncrementUnits()) maturityMonthYearIncrementUnits = FixUtils.TAG_HAS_NO_VALUE;		
		maturityMonthYearIncrementUnits = FixUtils.longValueOf(src, 0, src.length);
		hasMaturityMonthYearIncrementUnits = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMaturityMonthYearIncrementUnits(String str) {		
		if (str == null ) return;
		if (hasMaturityMonthYearIncrementUnits()) maturityMonthYearIncrementUnits = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		maturityMonthYearIncrementUnits = FixUtils.longValueOf(src, 0, src.length);
		hasMaturityMonthYearIncrementUnits = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getStartMaturityMonthYear() { 		
		if ( hasStartMaturityMonthYear()) {		
			if (hasStartMaturityMonthYear == FixUtils.TAG_HAS_VALUE) {		
				return startMaturityMonthYear; 		
			} else {		
		
				buf.position(hasStartMaturityMonthYear);		
		
			FixMessage.getTagStringValue(buf, startMaturityMonthYear, 0, startMaturityMonthYear.length, err);
		
				if (err.hasError()) {		
					buf.position(hasStartMaturityMonthYear);		
					return null;		
				}		
			}		
			hasStartMaturityMonthYear = FixUtils.TAG_HAS_VALUE;		
			return startMaturityMonthYear;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasStartMaturityMonthYear() { return hasStartMaturityMonthYear != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setStartMaturityMonthYear(byte[] src) {		
		if (src == null ) return;
		if (hasStartMaturityMonthYear()) FixUtils.fillSpace(startMaturityMonthYear);		
		FixUtils.copy(startMaturityMonthYear, src); 		
		hasStartMaturityMonthYear = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setStartMaturityMonthYear(String str) {		
		if (str == null ) return;
		if (hasStartMaturityMonthYear()) FixUtils.fillSpace(startMaturityMonthYear);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(startMaturityMonthYear, src); 		
		hasStartMaturityMonthYear = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getEndMaturityMonthYear() { 		
		if ( hasEndMaturityMonthYear()) {		
			if (hasEndMaturityMonthYear == FixUtils.TAG_HAS_VALUE) {		
				return endMaturityMonthYear; 		
			} else {		
		
				buf.position(hasEndMaturityMonthYear);		
		
			FixMessage.getTagStringValue(buf, endMaturityMonthYear, 0, endMaturityMonthYear.length, err);
		
				if (err.hasError()) {		
					buf.position(hasEndMaturityMonthYear);		
					return null;		
				}		
			}		
			hasEndMaturityMonthYear = FixUtils.TAG_HAS_VALUE;		
			return endMaturityMonthYear;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasEndMaturityMonthYear() { return hasEndMaturityMonthYear != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEndMaturityMonthYear(byte[] src) {		
		if (src == null ) return;
		if (hasEndMaturityMonthYear()) FixUtils.fillSpace(endMaturityMonthYear);		
		FixUtils.copy(endMaturityMonthYear, src); 		
		hasEndMaturityMonthYear = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEndMaturityMonthYear(String str) {		
		if (str == null ) return;
		if (hasEndMaturityMonthYear()) FixUtils.fillSpace(endMaturityMonthYear);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(endMaturityMonthYear, src); 		
		hasEndMaturityMonthYear = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getMaturityMonthYearIncrement() { 		
		if ( hasMaturityMonthYearIncrement()) {		
			if (hasMaturityMonthYearIncrement == FixUtils.TAG_HAS_VALUE) {		
				return maturityMonthYearIncrement; 		
			} else {		
		
				buf.position(hasMaturityMonthYearIncrement);		
		
			maturityMonthYearIncrement = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMaturityMonthYearIncrement);		
					return 0;		
				}		
			}		
			hasMaturityMonthYearIncrement = FixUtils.TAG_HAS_VALUE;		
			return maturityMonthYearIncrement;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMaturityMonthYearIncrement() { return hasMaturityMonthYearIncrement != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMaturityMonthYearIncrement(long src) {		
		maturityMonthYearIncrement = src;
		hasMaturityMonthYearIncrement = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMaturityMonthYearIncrement(byte[] src) {		
		if (src == null ) return;
		if (hasMaturityMonthYearIncrement()) maturityMonthYearIncrement = FixUtils.TAG_HAS_NO_VALUE;		
		maturityMonthYearIncrement = FixUtils.longValueOf(src, 0, src.length);
		hasMaturityMonthYearIncrement = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMaturityMonthYearIncrement(String str) {		
		if (str == null ) return;
		if (hasMaturityMonthYearIncrement()) maturityMonthYearIncrement = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		maturityMonthYearIncrement = FixUtils.longValueOf(src, 0, src.length);
		hasMaturityMonthYearIncrement = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasMaturityRuleID()) s += "MaturityRuleID(1222)= " + new String( FixUtils.trim(getMaturityRuleID()) ) + "\n" ; 
		if (hasMaturityMonthYearFormat()) s += "MaturityMonthYearFormat(1303)= " + getMaturityMonthYearFormat() + "\n" ; 
		if (hasMaturityMonthYearIncrementUnits()) s += "MaturityMonthYearIncrementUnits(1302)= " + getMaturityMonthYearIncrementUnits() + "\n" ; 
		if (hasStartMaturityMonthYear()) s += "StartMaturityMonthYear(1241)= " + new String( FixUtils.trim(getStartMaturityMonthYear()) ) + "\n" ; 
		if (hasEndMaturityMonthYear()) s += "EndMaturityMonthYear(1226)= " + new String( FixUtils.trim(getEndMaturityMonthYear()) ) + "\n" ; 
		if (hasMaturityMonthYearIncrement()) s += "MaturityMonthYearIncrement(1229)= " + getMaturityMonthYearIncrement() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixMaturityRules)) return false;

		FixMaturityRules msg = (FixMaturityRules) o;

		if ((hasMaturityRuleID() && !msg.hasMaturityRuleID()) || (!hasMaturityRuleID() && msg.hasMaturityRuleID())) return false;
		if (!(!hasMaturityRuleID() && !msg.hasMaturityRuleID()) && !FixUtils.equals(getMaturityRuleID(), msg.getMaturityRuleID())) return false;
		if ((hasMaturityMonthYearFormat() && !msg.hasMaturityMonthYearFormat()) || (!hasMaturityMonthYearFormat() && msg.hasMaturityMonthYearFormat())) return false;
		if (!(!hasMaturityMonthYearFormat() && !msg.hasMaturityMonthYearFormat()) && !(getMaturityMonthYearFormat()==msg.getMaturityMonthYearFormat())) return false;
		if ((hasMaturityMonthYearIncrementUnits() && !msg.hasMaturityMonthYearIncrementUnits()) || (!hasMaturityMonthYearIncrementUnits() && msg.hasMaturityMonthYearIncrementUnits())) return false;
		if (!(!hasMaturityMonthYearIncrementUnits() && !msg.hasMaturityMonthYearIncrementUnits()) && !(getMaturityMonthYearIncrementUnits()==msg.getMaturityMonthYearIncrementUnits())) return false;
		if ((hasStartMaturityMonthYear() && !msg.hasStartMaturityMonthYear()) || (!hasStartMaturityMonthYear() && msg.hasStartMaturityMonthYear())) return false;
		if (!(!hasStartMaturityMonthYear() && !msg.hasStartMaturityMonthYear()) && !FixUtils.equals(getStartMaturityMonthYear(), msg.getStartMaturityMonthYear())) return false;
		if ((hasEndMaturityMonthYear() && !msg.hasEndMaturityMonthYear()) || (!hasEndMaturityMonthYear() && msg.hasEndMaturityMonthYear())) return false;
		if (!(!hasEndMaturityMonthYear() && !msg.hasEndMaturityMonthYear()) && !FixUtils.equals(getEndMaturityMonthYear(), msg.getEndMaturityMonthYear())) return false;
		if ((hasMaturityMonthYearIncrement() && !msg.hasMaturityMonthYearIncrement()) || (!hasMaturityMonthYearIncrement() && msg.hasMaturityMonthYearIncrement())) return false;
		if (!(!hasMaturityMonthYearIncrement() && !msg.hasMaturityMonthYearIncrement()) && !(getMaturityMonthYearIncrement()==msg.getMaturityMonthYearIncrement())) return false;
		return true;
	}
	public FixMaturityRules clone ( FixMaturityRules out ) {
		if ( hasMaturityRuleID())
			out.setMaturityRuleID(getMaturityRuleID());
		if ( hasMaturityMonthYearFormat())
			out.setMaturityMonthYearFormat(getMaturityMonthYearFormat());
		if ( hasMaturityMonthYearIncrementUnits())
			out.setMaturityMonthYearIncrementUnits(getMaturityMonthYearIncrementUnits());
		if ( hasStartMaturityMonthYear())
			out.setStartMaturityMonthYear(getStartMaturityMonthYear());
		if ( hasEndMaturityMonthYear())
			out.setEndMaturityMonthYear(getEndMaturityMonthYear());
		if ( hasMaturityMonthYearIncrement())
			out.setMaturityMonthYearIncrement(getMaturityMonthYearIncrement());
		return out;
	}

}
