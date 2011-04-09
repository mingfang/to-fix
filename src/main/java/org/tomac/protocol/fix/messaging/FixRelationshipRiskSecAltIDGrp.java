package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixRelationshipRiskSecAltIDGrp extends FixGroup {
	private short hasNoRelationshipRiskSecurityAltID;
	long noRelationshipRiskSecurityAltID = 0;		
	private short hasRelationshipRiskSecurityAltID;
	byte[] relationshipRiskSecurityAltID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRelationshipRiskSecurityAltIDSource;
	byte[] relationshipRiskSecurityAltIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixRelationshipRiskSecAltIDGrp() {
		this(false);
	}

	public FixRelationshipRiskSecAltIDGrp(boolean isRequired) {
		super(FixTags.NORELATIONSHIPRISKSECURITYALTID_INT);

		this.isRequired = isRequired;
		
		hasNoRelationshipRiskSecurityAltID = FixUtils.TAG_HAS_NO_VALUE;		
		hasRelationshipRiskSecurityAltID = FixUtils.TAG_HAS_NO_VALUE;		
		relationshipRiskSecurityAltID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRelationshipRiskSecurityAltIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		relationshipRiskSecurityAltIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasNoRelationshipRiskSecurityAltID()) return true;
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
            	case FixTags.NORELATIONSHIPRISKSECURITYALTID_INT:		
            		hasNoRelationshipRiskSecurityAltID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATIONSHIPRISKSECURITYALTID_INT:		
            		hasRelationshipRiskSecurityAltID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATIONSHIPRISKSECURITYALTIDSOURCE_INT:		
            		hasRelationshipRiskSecurityAltIDSource = (short) buf.position();		
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
		hasNoRelationshipRiskSecurityAltID = FixUtils.TAG_HAS_NO_VALUE;
		hasRelationshipRiskSecurityAltID = FixUtils.TAG_HAS_NO_VALUE;
		hasRelationshipRiskSecurityAltIDSource = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasNoRelationshipRiskSecurityAltID()) {		
			out.put(FixTags.NORELATIONSHIPRISKSECURITYALTID);

			out.put((byte) '=');

			FixUtils.put(out, (long)noRelationshipRiskSecurityAltID);
		
			out.put(FixUtils.SOH);

            }

		if (hasRelationshipRiskSecurityAltID()) {		
			out.put(FixTags.RELATIONSHIPRISKSECURITYALTID);

			out.put((byte) '=');

			FixUtils.put(out,relationshipRiskSecurityAltID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRelationshipRiskSecurityAltIDSource()) {		
			out.put(FixTags.RELATIONSHIPRISKSECURITYALTIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,relationshipRiskSecurityAltIDSource); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasNoRelationshipRiskSecurityAltID()) {		
			FixUtils.put(out, (long)noRelationshipRiskSecurityAltID);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelationshipRiskSecurityAltID()) {		
			FixUtils.put(out,relationshipRiskSecurityAltID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelationshipRiskSecurityAltIDSource()) {		
			FixUtils.put(out,relationshipRiskSecurityAltIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getNoRelationshipRiskSecurityAltID() { 		
		if ( hasNoRelationshipRiskSecurityAltID()) {		
			if (hasNoRelationshipRiskSecurityAltID == FixUtils.TAG_HAS_VALUE) {		
				return noRelationshipRiskSecurityAltID; 		
			} else {		
		
				buf.position(hasNoRelationshipRiskSecurityAltID);		
		
			noRelationshipRiskSecurityAltID = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasNoRelationshipRiskSecurityAltID);		
					return 0;		
				}		
			}		
			hasNoRelationshipRiskSecurityAltID = FixUtils.TAG_HAS_VALUE;		
			return noRelationshipRiskSecurityAltID;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasNoRelationshipRiskSecurityAltID() { return hasNoRelationshipRiskSecurityAltID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNoRelationshipRiskSecurityAltID(long src) {		
		noRelationshipRiskSecurityAltID = src;
		hasNoRelationshipRiskSecurityAltID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNoRelationshipRiskSecurityAltID(byte[] src) {		
		if (src == null ) return;
		if (hasNoRelationshipRiskSecurityAltID()) noRelationshipRiskSecurityAltID = FixUtils.TAG_HAS_NO_VALUE;		
		noRelationshipRiskSecurityAltID = FixUtils.longValueOf(src, 0, src.length);
		hasNoRelationshipRiskSecurityAltID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNoRelationshipRiskSecurityAltID(String str) {		
		if (str == null ) return;
		if (hasNoRelationshipRiskSecurityAltID()) noRelationshipRiskSecurityAltID = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		noRelationshipRiskSecurityAltID = FixUtils.longValueOf(src, 0, src.length);
		hasNoRelationshipRiskSecurityAltID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRelationshipRiskSecurityAltID() { 		
		if ( hasRelationshipRiskSecurityAltID()) {		
			if (hasRelationshipRiskSecurityAltID == FixUtils.TAG_HAS_VALUE) {		
				return relationshipRiskSecurityAltID; 		
			} else {		
		
				buf.position(hasRelationshipRiskSecurityAltID);		
		
			FixUtils.getTagStringValue(buf, relationshipRiskSecurityAltID, 0, relationshipRiskSecurityAltID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRelationshipRiskSecurityAltID);		
					return null;		
				}		
			}		
			hasRelationshipRiskSecurityAltID = FixUtils.TAG_HAS_VALUE;		
			return relationshipRiskSecurityAltID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRelationshipRiskSecurityAltID() { return hasRelationshipRiskSecurityAltID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelationshipRiskSecurityAltID(byte[] src) {		
		if (src == null ) return;
		if (hasRelationshipRiskSecurityAltID()) FixUtils.fillNul(relationshipRiskSecurityAltID);		
		FixUtils.copy(relationshipRiskSecurityAltID, src); 		
		hasRelationshipRiskSecurityAltID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelationshipRiskSecurityAltID(String str) {		
		if (str == null ) return;
		if (hasRelationshipRiskSecurityAltID()) FixUtils.fillNul(relationshipRiskSecurityAltID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(relationshipRiskSecurityAltID, src); 		
		hasRelationshipRiskSecurityAltID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRelationshipRiskSecurityAltIDSource() { 		
		if ( hasRelationshipRiskSecurityAltIDSource()) {		
			if (hasRelationshipRiskSecurityAltIDSource == FixUtils.TAG_HAS_VALUE) {		
				return relationshipRiskSecurityAltIDSource; 		
			} else {		
		
				buf.position(hasRelationshipRiskSecurityAltIDSource);		
		
			FixUtils.getTagStringValue(buf, relationshipRiskSecurityAltIDSource, 0, relationshipRiskSecurityAltIDSource.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRelationshipRiskSecurityAltIDSource);		
					return null;		
				}		
			}		
			hasRelationshipRiskSecurityAltIDSource = FixUtils.TAG_HAS_VALUE;		
			return relationshipRiskSecurityAltIDSource;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRelationshipRiskSecurityAltIDSource() { return hasRelationshipRiskSecurityAltIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelationshipRiskSecurityAltIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasRelationshipRiskSecurityAltIDSource()) FixUtils.fillNul(relationshipRiskSecurityAltIDSource);		
		FixUtils.copy(relationshipRiskSecurityAltIDSource, src); 		
		hasRelationshipRiskSecurityAltIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelationshipRiskSecurityAltIDSource(String str) {		
		if (str == null ) return;
		if (hasRelationshipRiskSecurityAltIDSource()) FixUtils.fillNul(relationshipRiskSecurityAltIDSource);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(relationshipRiskSecurityAltIDSource, src); 		
		hasRelationshipRiskSecurityAltIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasNoRelationshipRiskSecurityAltID()) s += "NoRelationshipRiskSecurityAltID(1593)= " + getNoRelationshipRiskSecurityAltID() + "\n" ; 
		if (hasRelationshipRiskSecurityAltID()) s += "RelationshipRiskSecurityAltID(1594)= " + new String( FixUtils.trim(getRelationshipRiskSecurityAltID()) ) + "\n" ; 
		if (hasRelationshipRiskSecurityAltIDSource()) s += "RelationshipRiskSecurityAltIDSource(1595)= " + new String( FixUtils.trim(getRelationshipRiskSecurityAltIDSource()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixRelationshipRiskSecAltIDGrp)) return false;

		FixRelationshipRiskSecAltIDGrp msg = (FixRelationshipRiskSecAltIDGrp) o;

		if ((hasNoRelationshipRiskSecurityAltID() && !msg.hasNoRelationshipRiskSecurityAltID()) || (!hasNoRelationshipRiskSecurityAltID() && msg.hasNoRelationshipRiskSecurityAltID())) return false;
		if (!(!hasNoRelationshipRiskSecurityAltID() && !msg.hasNoRelationshipRiskSecurityAltID()) && !(getNoRelationshipRiskSecurityAltID()==msg.getNoRelationshipRiskSecurityAltID())) return false;
		if ((hasRelationshipRiskSecurityAltID() && !msg.hasRelationshipRiskSecurityAltID()) || (!hasRelationshipRiskSecurityAltID() && msg.hasRelationshipRiskSecurityAltID())) return false;
		if (!(!hasRelationshipRiskSecurityAltID() && !msg.hasRelationshipRiskSecurityAltID()) && !FixUtils.equals(getRelationshipRiskSecurityAltID(), msg.getRelationshipRiskSecurityAltID())) return false;
		if ((hasRelationshipRiskSecurityAltIDSource() && !msg.hasRelationshipRiskSecurityAltIDSource()) || (!hasRelationshipRiskSecurityAltIDSource() && msg.hasRelationshipRiskSecurityAltIDSource())) return false;
		if (!(!hasRelationshipRiskSecurityAltIDSource() && !msg.hasRelationshipRiskSecurityAltIDSource()) && !FixUtils.equals(getRelationshipRiskSecurityAltIDSource(), msg.getRelationshipRiskSecurityAltIDSource())) return false;
		return true;
	}
	public FixRelationshipRiskSecAltIDGrp clone ( FixRelationshipRiskSecAltIDGrp out ) {
		if ( hasNoRelationshipRiskSecurityAltID())
			out.setNoRelationshipRiskSecurityAltID(getNoRelationshipRiskSecurityAltID());
		if ( hasRelationshipRiskSecurityAltID())
			out.setRelationshipRiskSecurityAltID(getRelationshipRiskSecurityAltID());
		if ( hasRelationshipRiskSecurityAltIDSource())
			out.setRelationshipRiskSecurityAltIDSource(getRelationshipRiskSecurityAltIDSource());
		return out;
	}

}
