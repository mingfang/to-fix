package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixNestedParties3 extends FixGroup {
	private short hasNested3PartyID;
	byte[] nested3PartyID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasNested3PartyIDSource;
	byte nested3PartyIDSource = (byte)' ';		
	private short hasNested3PartyRole;
	long nested3PartyRole = 0;		
		public FixNstdPtys3SubGrp[] nstdPtys3SubGrp;
	
	public FixNestedParties3() {
		this(false);
	}

	public FixNestedParties3(boolean isRequired) {
		super(FixTags.NESTED3PARTYID_INT);

		this.isRequired = isRequired;
		
		hasNested3PartyID = FixUtils.TAG_HAS_NO_VALUE;		
		nested3PartyID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasNested3PartyIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasNested3PartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		nstdPtys3SubGrp = new FixNstdPtys3SubGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) nstdPtys3SubGrp[i] = new FixNstdPtys3SubGrp();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasNested3PartyID()) return true;
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
            	case FixTags.NESTED3PARTYID_INT:		
            		hasNested3PartyID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.NESTED3PARTYIDSOURCE_INT:		
            		hasNested3PartyIDSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.NESTED3PARTYROLE_INT:		
            		hasNested3PartyRole = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NONESTED3PARTYSUBIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !nstdPtys3SubGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = nstdPtys3SubGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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
		hasNested3PartyID = FixUtils.TAG_HAS_NO_VALUE;
		hasNested3PartyIDSource = FixUtils.TAG_HAS_NO_VALUE;
		hasNested3PartyRole = FixUtils.TAG_HAS_NO_VALUE;
		for (FixNstdPtys3SubGrp fixNstdPtys3SubGrp : nstdPtys3SubGrp) fixNstdPtys3SubGrp.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasNested3PartyID()) {		
			out.put(FixTags.NESTED3PARTYID);

			out.put((byte) '=');

			FixUtils.put(out,nested3PartyID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasNested3PartyIDSource()) {		
			out.put(FixTags.NESTED3PARTYIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,nested3PartyIDSource); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasNested3PartyRole()) {		
			out.put(FixTags.NESTED3PARTYROLE);

			out.put((byte) '=');

			FixUtils.put(out, (long)nested3PartyRole);
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(nstdPtys3SubGrp)>0) {
			out.put(FixTags.NONESTED3PARTYSUBIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(nstdPtys3SubGrp));

			out.put(FixUtils.SOH);

		}
		for (FixNstdPtys3SubGrp fixNstdPtys3SubGrp : nstdPtys3SubGrp) if (fixNstdPtys3SubGrp.hasGroup()) fixNstdPtys3SubGrp.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasNested3PartyID()) {		
			FixUtils.put(out,nested3PartyID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasNested3PartyIDSource()) {		
			FixUtils.put(out,nested3PartyIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasNested3PartyRole()) {		
			FixUtils.put(out, (long)nested3PartyRole);
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixNstdPtys3SubGrp fixNstdPtys3SubGrp : nstdPtys3SubGrp) fixNstdPtys3SubGrp.printBuffer(out);
	}

	public byte[] getNested3PartyID() { 		
		if ( hasNested3PartyID()) {		
			if (hasNested3PartyID == FixUtils.TAG_HAS_VALUE) {		
				return nested3PartyID; 		
			} else {		
		
				buf.position(hasNested3PartyID);		
		
			FixMessage.getTagStringValue(buf, nested3PartyID, 0, nested3PartyID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasNested3PartyID);		
					return null;		
				}		
			}		
			hasNested3PartyID = FixUtils.TAG_HAS_VALUE;		
			return nested3PartyID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasNested3PartyID() { return hasNested3PartyID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNested3PartyID(byte[] src) {		
		if (src == null ) return;
		if (hasNested3PartyID()) FixUtils.fillNul(nested3PartyID);		
		FixUtils.copy(nested3PartyID, src); 		
		hasNested3PartyID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNested3PartyID(String str) {		
		if (str == null ) return;
		if (hasNested3PartyID()) FixUtils.fillNul(nested3PartyID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(nested3PartyID, src); 		
		hasNested3PartyID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getNested3PartyIDSource() { 		
		if ( hasNested3PartyIDSource()) {		
			if (hasNested3PartyIDSource == FixUtils.TAG_HAS_VALUE) {		
				return nested3PartyIDSource; 		
			} else {		
		
				buf.position(hasNested3PartyIDSource);		
		
			nested3PartyIDSource = FixMessage.getTagCharValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasNested3PartyIDSource);		
					return (byte)'0';		
				}		
			}		
			hasNested3PartyIDSource = FixUtils.TAG_HAS_VALUE;		
			return nested3PartyIDSource;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasNested3PartyIDSource() { return hasNested3PartyIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNested3PartyIDSource(byte src) {		
		nested3PartyIDSource = src;
		hasNested3PartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNested3PartyIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasNested3PartyIDSource()) nested3PartyIDSource = (byte)' ';		
		nested3PartyIDSource = src[0];		
		hasNested3PartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNested3PartyIDSource(String str) {		
		if (str == null ) return;
		if (hasNested3PartyIDSource()) nested3PartyIDSource = (byte)' ';		
		byte[] src = str.getBytes(); 		
		nested3PartyIDSource = src[0];		
		hasNested3PartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getNested3PartyRole() { 		
		if ( hasNested3PartyRole()) {		
			if (hasNested3PartyRole == FixUtils.TAG_HAS_VALUE) {		
				return nested3PartyRole; 		
			} else {		
		
				buf.position(hasNested3PartyRole);		
		
			nested3PartyRole = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasNested3PartyRole);		
					return 0;		
				}		
			}		
			hasNested3PartyRole = FixUtils.TAG_HAS_VALUE;		
			return nested3PartyRole;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasNested3PartyRole() { return hasNested3PartyRole != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNested3PartyRole(long src) {		
		nested3PartyRole = src;
		hasNested3PartyRole = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNested3PartyRole(byte[] src) {		
		if (src == null ) return;
		if (hasNested3PartyRole()) nested3PartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		nested3PartyRole = FixUtils.longValueOf(src, 0, src.length);
		hasNested3PartyRole = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNested3PartyRole(String str) {		
		if (str == null ) return;
		if (hasNested3PartyRole()) nested3PartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		nested3PartyRole = FixUtils.longValueOf(src, 0, src.length);
		hasNested3PartyRole = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasNested3PartyID()) s += "Nested3PartyID(949)= " + new String( FixUtils.trim(getNested3PartyID()) ) + "\n" ; 
		if (hasNested3PartyIDSource()) s += "Nested3PartyIDSource(950)= " + getNested3PartyIDSource() + "\n" ; 
		if (hasNested3PartyRole()) s += "Nested3PartyRole(951)= " + getNested3PartyRole() + "\n" ; 

		for (FixNstdPtys3SubGrp fixNstdPtys3SubGrp : nstdPtys3SubGrp) fixNstdPtys3SubGrp.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixNestedParties3)) return false;

		FixNestedParties3 msg = (FixNestedParties3) o;

		for (int i = 0; i < nstdPtys3SubGrp.length; i++)
			if (!nstdPtys3SubGrp[i].equals(msg.nstdPtys3SubGrp[i])) return false;
		if ((hasNested3PartyID() && !msg.hasNested3PartyID()) || (!hasNested3PartyID() && msg.hasNested3PartyID())) return false;
		if (!(!hasNested3PartyID() && !msg.hasNested3PartyID()) && !FixUtils.equals(getNested3PartyID(), msg.getNested3PartyID())) return false;
		if ((hasNested3PartyIDSource() && !msg.hasNested3PartyIDSource()) || (!hasNested3PartyIDSource() && msg.hasNested3PartyIDSource())) return false;
		if (!(!hasNested3PartyIDSource() && !msg.hasNested3PartyIDSource()) && !(getNested3PartyIDSource()==msg.getNested3PartyIDSource())) return false;
		if ((hasNested3PartyRole() && !msg.hasNested3PartyRole()) || (!hasNested3PartyRole() && msg.hasNested3PartyRole())) return false;
		if (!(!hasNested3PartyRole() && !msg.hasNested3PartyRole()) && !(getNested3PartyRole()==msg.getNested3PartyRole())) return false;
		return true;
	}
	public FixNestedParties3 clone ( FixNestedParties3 out ) {
		if ( hasNested3PartyID())
			out.setNested3PartyID(getNested3PartyID());
		if ( hasNested3PartyIDSource())
			out.setNested3PartyIDSource(getNested3PartyIDSource());
		if ( hasNested3PartyRole())
			out.setNested3PartyRole(getNested3PartyRole());
		int count = 0;
		count = 0;
		for (FixNstdPtys3SubGrp fixNstdPtys3SubGrp : nstdPtys3SubGrp) {
			if (!fixNstdPtys3SubGrp.hasGroup()) continue;
			out.nstdPtys3SubGrp[count] = fixNstdPtys3SubGrp.clone( out.nstdPtys3SubGrp[count] );
			count++;
		}
		return out;
	}

}
