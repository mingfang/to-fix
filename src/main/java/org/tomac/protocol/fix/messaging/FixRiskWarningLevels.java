package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixRiskWarningLevels extends FixGroup {
	private short hasRiskWarningLevelPercent;
	long riskWarningLevelPercent = 0;		
	private short hasRiskWarningLevelName;
	byte[] riskWarningLevelName = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixRiskWarningLevels() {
		this(false);
	}

	public FixRiskWarningLevels(boolean isRequired) {
		super(FixTags.RISKWARNINGLEVELPERCENT_INT);

		this.isRequired = isRequired;
		
		hasRiskWarningLevelPercent = FixUtils.TAG_HAS_NO_VALUE;		
		hasRiskWarningLevelName = FixUtils.TAG_HAS_NO_VALUE;		
		riskWarningLevelName = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasRiskWarningLevelPercent()) return true;
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
            	case FixTags.RISKWARNINGLEVELPERCENT_INT:		
            		hasRiskWarningLevelPercent = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.RISKWARNINGLEVELNAME_INT:		
            		hasRiskWarningLevelName = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	default:
            		return tag;

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
		hasRiskWarningLevelPercent = FixUtils.TAG_HAS_NO_VALUE;
		hasRiskWarningLevelName = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasRiskWarningLevelPercent()) {		
			out.put(FixTags.RISKWARNINGLEVELPERCENT);

			out.put((byte) '=');

			FixUtils.put(out, (long)riskWarningLevelPercent);
		
			out.put(FixUtils.SOH);

            }

		if (hasRiskWarningLevelName()) {		
			out.put(FixTags.RISKWARNINGLEVELNAME);

			out.put((byte) '=');

			FixUtils.put(out,riskWarningLevelName); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasRiskWarningLevelPercent()) {		
			FixUtils.put(out, (long)riskWarningLevelPercent);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRiskWarningLevelName()) {		
			FixUtils.put(out,riskWarningLevelName); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getRiskWarningLevelPercent() { 		
		if ( hasRiskWarningLevelPercent()) {		
			if (hasRiskWarningLevelPercent == FixUtils.TAG_HAS_VALUE) {		
				return riskWarningLevelPercent; 		
			} else {		
		
				buf.position(hasRiskWarningLevelPercent);		
		
			riskWarningLevelPercent = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRiskWarningLevelPercent);		
					return 0;		
				}		
			}		
			hasRiskWarningLevelPercent = FixUtils.TAG_HAS_VALUE;		
			return riskWarningLevelPercent;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRiskWarningLevelPercent() { return hasRiskWarningLevelPercent != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRiskWarningLevelPercent(long src) {		
		riskWarningLevelPercent = src;
		hasRiskWarningLevelPercent = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRiskWarningLevelPercent(byte[] src) {		
		if (src == null ) return;
		if (hasRiskWarningLevelPercent()) riskWarningLevelPercent = FixUtils.TAG_HAS_NO_VALUE;		
		riskWarningLevelPercent = FixUtils.longValueOf(src, 0, src.length);
		hasRiskWarningLevelPercent = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRiskWarningLevelPercent(String str) {		
		if (str == null ) return;
		if (hasRiskWarningLevelPercent()) riskWarningLevelPercent = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		riskWarningLevelPercent = FixUtils.longValueOf(src, 0, src.length);
		hasRiskWarningLevelPercent = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRiskWarningLevelName() { 		
		if ( hasRiskWarningLevelName()) {		
			if (hasRiskWarningLevelName == FixUtils.TAG_HAS_VALUE) {		
				return riskWarningLevelName; 		
			} else {		
		
				buf.position(hasRiskWarningLevelName);		
		
			FixUtils.getTagStringValue(buf, riskWarningLevelName, 0, riskWarningLevelName.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRiskWarningLevelName);		
					return null;		
				}		
			}		
			hasRiskWarningLevelName = FixUtils.TAG_HAS_VALUE;		
			return riskWarningLevelName;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRiskWarningLevelName() { return hasRiskWarningLevelName != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRiskWarningLevelName(byte[] src) {		
		if (src == null ) return;
		if (hasRiskWarningLevelName()) FixUtils.fillNul(riskWarningLevelName);		
		FixUtils.copy(riskWarningLevelName, src); 		
		hasRiskWarningLevelName = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRiskWarningLevelName(String str) {		
		if (str == null ) return;
		if (hasRiskWarningLevelName()) FixUtils.fillNul(riskWarningLevelName);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(riskWarningLevelName, src); 		
		hasRiskWarningLevelName = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasRiskWarningLevelPercent()) s += "RiskWarningLevelPercent(1560)= " + getRiskWarningLevelPercent() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasRiskWarningLevelName()) s += "RiskWarningLevelName(1561)= " + new String( FixUtils.trim(getRiskWarningLevelName()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixRiskWarningLevels)) return false;

		FixRiskWarningLevels msg = (FixRiskWarningLevels) o;

		if ((hasRiskWarningLevelPercent() && !msg.hasRiskWarningLevelPercent()) || (!hasRiskWarningLevelPercent() && msg.hasRiskWarningLevelPercent())) return false;
		if (!(!hasRiskWarningLevelPercent() && !msg.hasRiskWarningLevelPercent()) && !(getRiskWarningLevelPercent()==msg.getRiskWarningLevelPercent())) return false;
		if ((hasRiskWarningLevelName() && !msg.hasRiskWarningLevelName()) || (!hasRiskWarningLevelName() && msg.hasRiskWarningLevelName())) return false;
		if (!(!hasRiskWarningLevelName() && !msg.hasRiskWarningLevelName()) && !FixUtils.equals(getRiskWarningLevelName(), msg.getRiskWarningLevelName())) return false;
		return true;
	}
	public FixRiskWarningLevels clone ( FixRiskWarningLevels out ) {
		if ( hasRiskWarningLevelPercent())
			out.setRiskWarningLevelPercent(getRiskWarningLevelPercent());
		if ( hasRiskWarningLevelName())
			out.setRiskWarningLevelName(getRiskWarningLevelName());
		return out;
	}

}
