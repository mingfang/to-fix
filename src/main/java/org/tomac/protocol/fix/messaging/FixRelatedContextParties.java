package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixRelatedContextParties extends FixGroup {
	private short hasRelatedContextPartyID;
	byte[] relatedContextPartyID = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasRelatedContextPartyIDSource;
	byte relatedContextPartyIDSource = (byte)' ';		
	private short hasRelatedContextPartyRole;
	long relatedContextPartyRole = 0;		
		public FixRelatedContextPtysSubGrp[] relatedContextPtysSubGrp;
	
	public FixRelatedContextParties() {
		this(false);
	}

	public FixRelatedContextParties(boolean isRequired) {
		super(FixTags.RELATEDCONTEXTPARTYID_INT);

		this.isRequired = isRequired;
		
		hasRelatedContextPartyID = FixUtils.TAG_HAS_NO_VALUE;		
		relatedContextPartyID = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasRelatedContextPartyIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasRelatedContextPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		relatedContextPtysSubGrp = new FixRelatedContextPtysSubGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) relatedContextPtysSubGrp[i] = new FixRelatedContextPtysSubGrp();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasRelatedContextPartyID()) return true;
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
            	case FixTags.RELATEDCONTEXTPARTYID_INT:		
            		hasRelatedContextPartyID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATEDCONTEXTPARTYIDSOURCE_INT:		
            		hasRelatedContextPartyIDSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATEDCONTEXTPARTYROLE_INT:		
            		hasRelatedContextPartyRole = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NORELATEDCONTEXTPARTYSUBIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !relatedContextPtysSubGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = relatedContextPtysSubGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else { return tag; }
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
		hasRelatedContextPartyID = FixUtils.TAG_HAS_NO_VALUE;
		hasRelatedContextPartyIDSource = FixUtils.TAG_HAS_NO_VALUE;
		hasRelatedContextPartyRole = FixUtils.TAG_HAS_NO_VALUE;
		for (FixRelatedContextPtysSubGrp fixRelatedContextPtysSubGrp : relatedContextPtysSubGrp) fixRelatedContextPtysSubGrp.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasRelatedContextPartyID()) {		
			out.put(FixTags.RELATEDCONTEXTPARTYID);

			out.put((byte) '=');

			FixUtils.put(out,relatedContextPartyID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRelatedContextPartyIDSource()) {		
			out.put(FixTags.RELATEDCONTEXTPARTYIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,relatedContextPartyIDSource); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRelatedContextPartyRole()) {		
			out.put(FixTags.RELATEDCONTEXTPARTYROLE);

			out.put((byte) '=');

			FixUtils.put(out, (long)relatedContextPartyRole);
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(relatedContextPtysSubGrp)>0) {
			out.put(FixTags.NORELATEDCONTEXTPARTYSUBIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(relatedContextPtysSubGrp));

			out.put(FixUtils.SOH);

		}
		for (FixRelatedContextPtysSubGrp fixRelatedContextPtysSubGrp : relatedContextPtysSubGrp) if (fixRelatedContextPtysSubGrp.hasGroup()) fixRelatedContextPtysSubGrp.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasRelatedContextPartyID()) {		
			FixUtils.put(out,relatedContextPartyID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelatedContextPartyIDSource()) {		
			FixUtils.put(out,relatedContextPartyIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelatedContextPartyRole()) {		
			FixUtils.put(out, (long)relatedContextPartyRole);
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixRelatedContextPtysSubGrp fixRelatedContextPtysSubGrp : relatedContextPtysSubGrp) fixRelatedContextPtysSubGrp.printBuffer(out);
	}

	public byte[] getRelatedContextPartyID() { 		
		if ( hasRelatedContextPartyID()) {		
			if (hasRelatedContextPartyID == FixUtils.TAG_HAS_VALUE) {		
				return relatedContextPartyID; 		
			} else {		
		
				buf.position(hasRelatedContextPartyID);		
		
			FixMessage.getTagStringValue(buf, relatedContextPartyID, 0, relatedContextPartyID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRelatedContextPartyID);		
					return null;		
				}		
			}		
			hasRelatedContextPartyID = FixUtils.TAG_HAS_VALUE;		
			return relatedContextPartyID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRelatedContextPartyID() { return hasRelatedContextPartyID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelatedContextPartyID(byte[] src) {		
		if (src == null ) return;
		if (hasRelatedContextPartyID()) FixUtils.fillSpace(relatedContextPartyID);		
		FixUtils.copy(relatedContextPartyID, src); 		
		hasRelatedContextPartyID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelatedContextPartyID(String str) {		
		if (str == null ) return;
		if (hasRelatedContextPartyID()) FixUtils.fillSpace(relatedContextPartyID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(relatedContextPartyID, src); 		
		hasRelatedContextPartyID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getRelatedContextPartyIDSource() { 		
		if ( hasRelatedContextPartyIDSource()) {		
			if (hasRelatedContextPartyIDSource == FixUtils.TAG_HAS_VALUE) {		
				return relatedContextPartyIDSource; 		
			} else {		
		
				buf.position(hasRelatedContextPartyIDSource);		
		
			relatedContextPartyIDSource = FixMessage.getTagCharValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRelatedContextPartyIDSource);		
					return (byte)'0';		
				}		
			}		
			hasRelatedContextPartyIDSource = FixUtils.TAG_HAS_VALUE;		
			return relatedContextPartyIDSource;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasRelatedContextPartyIDSource() { return hasRelatedContextPartyIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelatedContextPartyIDSource(byte src) {		
		relatedContextPartyIDSource = src;
		hasRelatedContextPartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRelatedContextPartyIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasRelatedContextPartyIDSource()) relatedContextPartyIDSource = (byte)' ';		
		relatedContextPartyIDSource = src[0];		
		hasRelatedContextPartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelatedContextPartyIDSource(String str) {		
		if (str == null ) return;
		if (hasRelatedContextPartyIDSource()) relatedContextPartyIDSource = (byte)' ';		
		byte[] src = str.getBytes(); 		
		relatedContextPartyIDSource = src[0];		
		hasRelatedContextPartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getRelatedContextPartyRole() { 		
		if ( hasRelatedContextPartyRole()) {		
			if (hasRelatedContextPartyRole == FixUtils.TAG_HAS_VALUE) {		
				return relatedContextPartyRole; 		
			} else {		
		
				buf.position(hasRelatedContextPartyRole);		
		
			relatedContextPartyRole = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRelatedContextPartyRole);		
					return 0;		
				}		
			}		
			hasRelatedContextPartyRole = FixUtils.TAG_HAS_VALUE;		
			return relatedContextPartyRole;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRelatedContextPartyRole() { return hasRelatedContextPartyRole != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelatedContextPartyRole(long src) {		
		relatedContextPartyRole = src;
		hasRelatedContextPartyRole = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRelatedContextPartyRole(byte[] src) {		
		if (src == null ) return;
		if (hasRelatedContextPartyRole()) relatedContextPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		relatedContextPartyRole = FixUtils.longValueOf(src, 0, src.length);
		hasRelatedContextPartyRole = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelatedContextPartyRole(String str) {		
		if (str == null ) return;
		if (hasRelatedContextPartyRole()) relatedContextPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		relatedContextPartyRole = FixUtils.longValueOf(src, 0, src.length);
		hasRelatedContextPartyRole = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasRelatedContextPartyID()) s += "RelatedContextPartyID(1576)= " + new String( FixUtils.trim(getRelatedContextPartyID()) ) + "\n" ; 
		if (hasRelatedContextPartyIDSource()) s += "RelatedContextPartyIDSource(1577)= " + getRelatedContextPartyIDSource() + "\n" ; 
		if (hasRelatedContextPartyRole()) s += "RelatedContextPartyRole(1578)= " + getRelatedContextPartyRole() + "\n" ; 

		for (FixRelatedContextPtysSubGrp fixRelatedContextPtysSubGrp : relatedContextPtysSubGrp) fixRelatedContextPtysSubGrp.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixRelatedContextParties)) return false;

		FixRelatedContextParties msg = (FixRelatedContextParties) o;

		for (int i = 0; i < relatedContextPtysSubGrp.length; i++)
			if (!relatedContextPtysSubGrp[i].equals(msg.relatedContextPtysSubGrp[i])) return false;
		if ((hasRelatedContextPartyID() && !msg.hasRelatedContextPartyID()) || (!hasRelatedContextPartyID() && msg.hasRelatedContextPartyID())) return false;
		if (!(!hasRelatedContextPartyID() && !msg.hasRelatedContextPartyID()) && !FixUtils.equals(getRelatedContextPartyID(), msg.getRelatedContextPartyID())) return false;
		if ((hasRelatedContextPartyIDSource() && !msg.hasRelatedContextPartyIDSource()) || (!hasRelatedContextPartyIDSource() && msg.hasRelatedContextPartyIDSource())) return false;
		if (!(!hasRelatedContextPartyIDSource() && !msg.hasRelatedContextPartyIDSource()) && !(getRelatedContextPartyIDSource()==msg.getRelatedContextPartyIDSource())) return false;
		if ((hasRelatedContextPartyRole() && !msg.hasRelatedContextPartyRole()) || (!hasRelatedContextPartyRole() && msg.hasRelatedContextPartyRole())) return false;
		if (!(!hasRelatedContextPartyRole() && !msg.hasRelatedContextPartyRole()) && !(getRelatedContextPartyRole()==msg.getRelatedContextPartyRole())) return false;
		return true;
	}
	public FixRelatedContextParties clone ( FixRelatedContextParties out ) {
		if ( hasRelatedContextPartyID())
			out.setRelatedContextPartyID(getRelatedContextPartyID());
		if ( hasRelatedContextPartyIDSource())
			out.setRelatedContextPartyIDSource(getRelatedContextPartyIDSource());
		if ( hasRelatedContextPartyRole())
			out.setRelatedContextPartyRole(getRelatedContextPartyRole());
		int count = 0;
		count = 0;
		for (FixRelatedContextPtysSubGrp fixRelatedContextPtysSubGrp : relatedContextPtysSubGrp) {
			if (!fixRelatedContextPtysSubGrp.hasGroup()) continue;
			out.relatedContextPtysSubGrp[count] = fixRelatedContextPtysSubGrp.clone( out.relatedContextPtysSubGrp[count] );
			count++;
		}
		return out;
	}

}
