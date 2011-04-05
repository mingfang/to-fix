package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixMatchRules extends FixGroup {
	private short hasMatchAlgorithm;
	byte[] matchAlgorithm = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMatchType;
	byte[] matchType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixMatchRules() {
		this(false);
	}

	public FixMatchRules(boolean isRequired) {
		super(FixTags.MATCHALGORITHM_INT);

		this.isRequired = isRequired;
		
		hasMatchAlgorithm = FixUtils.TAG_HAS_NO_VALUE;		
		matchAlgorithm = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMatchType = FixUtils.TAG_HAS_NO_VALUE;		
		matchType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasMatchAlgorithm()) return true;
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
            	case FixTags.MATCHALGORITHM_INT:		
            		hasMatchAlgorithm = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MATCHTYPE_INT:		
            		hasMatchType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
            		return tag;

            }

            tag = FixMessage.getTag(buf, err);
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
		hasMatchAlgorithm = FixUtils.TAG_HAS_NO_VALUE;
		hasMatchType = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasMatchAlgorithm()) {		
			out.put(FixTags.MATCHALGORITHM);

			out.put((byte) '=');

			FixUtils.put(out,matchAlgorithm); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasMatchType()) {		
			out.put(FixTags.MATCHTYPE);

			out.put((byte) '=');

			FixUtils.put(out,matchType); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasMatchAlgorithm()) {		
			FixUtils.put(out,matchAlgorithm); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMatchType()) {		
			FixUtils.put(out,matchType); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getMatchAlgorithm() { 		
		if ( hasMatchAlgorithm()) {		
			if (hasMatchAlgorithm == FixUtils.TAG_HAS_VALUE) {		
				return matchAlgorithm; 		
			} else {		
		
				buf.position(hasMatchAlgorithm);		
		
			FixMessage.getTagStringValue(buf, matchAlgorithm, 0, matchAlgorithm.length, err);
		
				if (err.hasError()) {		
					buf.position(hasMatchAlgorithm);		
					return null;		
				}		
			}		
			hasMatchAlgorithm = FixUtils.TAG_HAS_VALUE;		
			return matchAlgorithm;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMatchAlgorithm() { return hasMatchAlgorithm != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMatchAlgorithm(byte[] src) {		
		if (src == null ) return;
		if (hasMatchAlgorithm()) FixUtils.fillNul(matchAlgorithm);		
		FixUtils.copy(matchAlgorithm, src); 		
		hasMatchAlgorithm = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMatchAlgorithm(String str) {		
		if (str == null ) return;
		if (hasMatchAlgorithm()) FixUtils.fillNul(matchAlgorithm);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(matchAlgorithm, src); 		
		hasMatchAlgorithm = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getMatchType() { 		
		if ( hasMatchType()) {		
			if (hasMatchType == FixUtils.TAG_HAS_VALUE) {		
				return matchType; 		
			} else {		
		
				buf.position(hasMatchType);		
		
			FixMessage.getTagStringValue(buf, matchType, 0, matchType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasMatchType);		
					return null;		
				}		
			}		
			hasMatchType = FixUtils.TAG_HAS_VALUE;		
			return matchType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMatchType() { return hasMatchType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMatchType(byte[] src) {		
		if (src == null ) return;
		if (hasMatchType()) FixUtils.fillNul(matchType);		
		FixUtils.copy(matchType, src); 		
		hasMatchType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMatchType(String str) {		
		if (str == null ) return;
		if (hasMatchType()) FixUtils.fillNul(matchType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(matchType, src); 		
		hasMatchType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasMatchAlgorithm()) s += "MatchAlgorithm(1142)= " + new String( FixUtils.trim(getMatchAlgorithm()) ) + "\n" ; 
		if (hasMatchType()) s += "MatchType(574)= " + new String( FixUtils.trim(getMatchType()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixMatchRules)) return false;

		FixMatchRules msg = (FixMatchRules) o;

		if ((hasMatchAlgorithm() && !msg.hasMatchAlgorithm()) || (!hasMatchAlgorithm() && msg.hasMatchAlgorithm())) return false;
		if (!(!hasMatchAlgorithm() && !msg.hasMatchAlgorithm()) && !FixUtils.equals(getMatchAlgorithm(), msg.getMatchAlgorithm())) return false;
		if ((hasMatchType() && !msg.hasMatchType()) || (!hasMatchType() && msg.hasMatchType())) return false;
		if (!(!hasMatchType() && !msg.hasMatchType()) && !FixUtils.equals(getMatchType(), msg.getMatchType())) return false;
		return true;
	}
	public FixMatchRules clone ( FixMatchRules out ) {
		if ( hasMatchAlgorithm())
			out.setMatchAlgorithm(getMatchAlgorithm());
		if ( hasMatchType())
			out.setMatchType(getMatchType());
		return out;
	}

}
