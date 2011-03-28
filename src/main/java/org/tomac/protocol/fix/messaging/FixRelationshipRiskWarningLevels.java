package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixRelationshipRiskWarningLevels extends FixGroup {
	private short hasRelationshipRiskWarningLevelPercent;
	long relationshipRiskWarningLevelPercent = 0;		
	private short hasRelationshipRiskWarningLevelName;
	byte[] relationshipRiskWarningLevelName = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixRelationshipRiskWarningLevels() {
		super(FixTags.RELATIONSHIPRISKWARNINGLEVELPERCENT_INT);

		
		hasRelationshipRiskWarningLevelPercent = FixUtils.TAG_HAS_NO_VALUE;		
		hasRelationshipRiskWarningLevelName = FixUtils.TAG_HAS_NO_VALUE;		
		relationshipRiskWarningLevelName = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasRelationshipRiskWarningLevelPercent()) return true;
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
            	case FixTags.RELATIONSHIPRISKWARNINGLEVELPERCENT_INT:		
            		hasRelationshipRiskWarningLevelPercent = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATIONSHIPRISKWARNINGLEVELNAME_INT:		
            		hasRelationshipRiskWarningLevelName = (short) buf.position();		
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
		hasRelationshipRiskWarningLevelPercent = FixUtils.TAG_HAS_NO_VALUE;
		hasRelationshipRiskWarningLevelName = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasRelationshipRiskWarningLevelPercent()) {		
			out.put(FixTags.RELATIONSHIPRISKWARNINGLEVELPERCENT);

			out.put((byte) '=');

			FixUtils.put(out, (long)relationshipRiskWarningLevelPercent);
		
			out.put(FixUtils.SOH);

            }

		if (hasRelationshipRiskWarningLevelName()) {		
			out.put(FixTags.RELATIONSHIPRISKWARNINGLEVELNAME);

			out.put((byte) '=');

			FixUtils.put(out,relationshipRiskWarningLevelName); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasRelationshipRiskWarningLevelPercent()) {		
			FixUtils.put(out, (long)relationshipRiskWarningLevelPercent);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelationshipRiskWarningLevelName()) {		
			FixUtils.put(out,relationshipRiskWarningLevelName); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getRelationshipRiskWarningLevelPercent() { 		
		if ( hasRelationshipRiskWarningLevelPercent()) {		
			if (hasRelationshipRiskWarningLevelPercent == FixUtils.TAG_HAS_VALUE) {		
				return relationshipRiskWarningLevelPercent; 		
			} else {		
		
				buf.position(hasRelationshipRiskWarningLevelPercent);		
		
			relationshipRiskWarningLevelPercent = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRelationshipRiskWarningLevelPercent);		
					return 0;		
				}		
			}		
			hasRelationshipRiskWarningLevelPercent = FixUtils.TAG_HAS_VALUE;		
			return relationshipRiskWarningLevelPercent;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRelationshipRiskWarningLevelPercent() { return hasRelationshipRiskWarningLevelPercent != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelationshipRiskWarningLevelPercent(long src) {		
		relationshipRiskWarningLevelPercent = src;
		hasRelationshipRiskWarningLevelPercent = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRelationshipRiskWarningLevelPercent(byte[] src) {		
		if (src == null ) return;
		if (hasRelationshipRiskWarningLevelPercent()) relationshipRiskWarningLevelPercent = FixUtils.TAG_HAS_NO_VALUE;		
		relationshipRiskWarningLevelPercent = FixUtils.longValueOf(src, 0, src.length);
		hasRelationshipRiskWarningLevelPercent = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelationshipRiskWarningLevelPercent(String str) {		
		if (str == null ) return;
		if (hasRelationshipRiskWarningLevelPercent()) relationshipRiskWarningLevelPercent = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		relationshipRiskWarningLevelPercent = FixUtils.longValueOf(src, 0, src.length);
		hasRelationshipRiskWarningLevelPercent = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRelationshipRiskWarningLevelName() { 		
		if ( hasRelationshipRiskWarningLevelName()) {		
			if (hasRelationshipRiskWarningLevelName == FixUtils.TAG_HAS_VALUE) {		
				return relationshipRiskWarningLevelName; 		
			} else {		
		
				buf.position(hasRelationshipRiskWarningLevelName);		
		
			FixMessage.getTagStringValue(buf, relationshipRiskWarningLevelName, 0, relationshipRiskWarningLevelName.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRelationshipRiskWarningLevelName);		
					return null;		
				}		
			}		
			hasRelationshipRiskWarningLevelName = FixUtils.TAG_HAS_VALUE;		
			return relationshipRiskWarningLevelName;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRelationshipRiskWarningLevelName() { return hasRelationshipRiskWarningLevelName != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelationshipRiskWarningLevelName(byte[] src) {		
		if (src == null ) return;
		if (hasRelationshipRiskWarningLevelName()) FixUtils.fillSpace(relationshipRiskWarningLevelName);		
		FixUtils.copy(relationshipRiskWarningLevelName, src); 		
		hasRelationshipRiskWarningLevelName = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelationshipRiskWarningLevelName(String str) {		
		if (str == null ) return;
		if (hasRelationshipRiskWarningLevelName()) FixUtils.fillSpace(relationshipRiskWarningLevelName);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(relationshipRiskWarningLevelName, src); 		
		hasRelationshipRiskWarningLevelName = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasRelationshipRiskWarningLevelPercent()) s += "RelationshipRiskWarningLevelPercent(1614)= " + getRelationshipRiskWarningLevelPercent() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasRelationshipRiskWarningLevelName()) s += "RelationshipRiskWarningLevelName(1615)= " + new String( FixUtils.trim(getRelationshipRiskWarningLevelName()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixRelationshipRiskWarningLevels)) return false;

		FixRelationshipRiskWarningLevels msg = (FixRelationshipRiskWarningLevels) o;

		if ((hasRelationshipRiskWarningLevelPercent() && !msg.hasRelationshipRiskWarningLevelPercent()) || (!hasRelationshipRiskWarningLevelPercent() && msg.hasRelationshipRiskWarningLevelPercent())) return false;
		if (!(!hasRelationshipRiskWarningLevelPercent() && !msg.hasRelationshipRiskWarningLevelPercent()) && !(getRelationshipRiskWarningLevelPercent()==msg.getRelationshipRiskWarningLevelPercent())) return false;
		if ((hasRelationshipRiskWarningLevelName() && !msg.hasRelationshipRiskWarningLevelName()) || (!hasRelationshipRiskWarningLevelName() && msg.hasRelationshipRiskWarningLevelName())) return false;
		if (!(!hasRelationshipRiskWarningLevelName() && !msg.hasRelationshipRiskWarningLevelName()) && !FixUtils.equals(getRelationshipRiskWarningLevelName(), msg.getRelationshipRiskWarningLevelName())) return false;
		return true;
	}
	public FixRelationshipRiskWarningLevels clone ( FixRelationshipRiskWarningLevels out ) {
		if ( hasRelationshipRiskWarningLevelPercent())
			out.setRelationshipRiskWarningLevelPercent(getRelationshipRiskWarningLevelPercent());
		if ( hasRelationshipRiskWarningLevelName())
			out.setRelationshipRiskWarningLevelName(getRelationshipRiskWarningLevelName());
		return out;
	}

}
