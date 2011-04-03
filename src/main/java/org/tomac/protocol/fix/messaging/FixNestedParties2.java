package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixNestedParties2 extends FixGroup {
	private short hasNested2PartyID;
	byte[] nested2PartyID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasNested2PartyIDSource;
	byte nested2PartyIDSource = (byte)' ';		
	private short hasNested2PartyRole;
	long nested2PartyRole = 0;		
		public FixNstdPtys2SubGrp[] nstdPtys2SubGrp;
	
	public FixNestedParties2() {
		this(false);
	}

	public FixNestedParties2(boolean isRequired) {
		super(FixTags.NESTED2PARTYID_INT);

		this.isRequired = isRequired;
		
		hasNested2PartyID = FixUtils.TAG_HAS_NO_VALUE;		
		nested2PartyID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasNested2PartyIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasNested2PartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		nstdPtys2SubGrp = new FixNstdPtys2SubGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) nstdPtys2SubGrp[i] = new FixNstdPtys2SubGrp();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasNested2PartyID()) return true;
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
            	case FixTags.NESTED2PARTYID_INT:		
            		hasNested2PartyID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.NESTED2PARTYIDSOURCE_INT:		
            		hasNested2PartyIDSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.NESTED2PARTYROLE_INT:		
            		hasNested2PartyRole = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NONESTED2PARTYSUBIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !nstdPtys2SubGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = nstdPtys2SubGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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
		hasNested2PartyID = FixUtils.TAG_HAS_NO_VALUE;
		hasNested2PartyIDSource = FixUtils.TAG_HAS_NO_VALUE;
		hasNested2PartyRole = FixUtils.TAG_HAS_NO_VALUE;
		for (FixNstdPtys2SubGrp fixNstdPtys2SubGrp : nstdPtys2SubGrp) fixNstdPtys2SubGrp.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasNested2PartyID()) {		
			out.put(FixTags.NESTED2PARTYID);

			out.put((byte) '=');

			FixUtils.put(out,nested2PartyID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasNested2PartyIDSource()) {		
			out.put(FixTags.NESTED2PARTYIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,nested2PartyIDSource); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasNested2PartyRole()) {		
			out.put(FixTags.NESTED2PARTYROLE);

			out.put((byte) '=');

			FixUtils.put(out, (long)nested2PartyRole);
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(nstdPtys2SubGrp)>0) {
			out.put(FixTags.NONESTED2PARTYSUBIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(nstdPtys2SubGrp));

			out.put(FixUtils.SOH);

		}
		for (FixNstdPtys2SubGrp fixNstdPtys2SubGrp : nstdPtys2SubGrp) if (fixNstdPtys2SubGrp.hasGroup()) fixNstdPtys2SubGrp.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasNested2PartyID()) {		
			FixUtils.put(out,nested2PartyID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasNested2PartyIDSource()) {		
			FixUtils.put(out,nested2PartyIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasNested2PartyRole()) {		
			FixUtils.put(out, (long)nested2PartyRole);
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixNstdPtys2SubGrp fixNstdPtys2SubGrp : nstdPtys2SubGrp) fixNstdPtys2SubGrp.printBuffer(out);
	}

	public byte[] getNested2PartyID() { 		
		if ( hasNested2PartyID()) {		
			if (hasNested2PartyID == FixUtils.TAG_HAS_VALUE) {		
				return nested2PartyID; 		
			} else {		
		
				buf.position(hasNested2PartyID);		
		
			FixMessage.getTagStringValue(buf, nested2PartyID, 0, nested2PartyID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasNested2PartyID);		
					return null;		
				}		
			}		
			hasNested2PartyID = FixUtils.TAG_HAS_VALUE;		
			return nested2PartyID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasNested2PartyID() { return hasNested2PartyID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNested2PartyID(byte[] src) {		
		if (src == null ) return;
		if (hasNested2PartyID()) FixUtils.fillSpace(nested2PartyID);		
		FixUtils.copy(nested2PartyID, src); 		
		hasNested2PartyID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNested2PartyID(String str) {		
		if (str == null ) return;
		if (hasNested2PartyID()) FixUtils.fillSpace(nested2PartyID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(nested2PartyID, src); 		
		hasNested2PartyID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getNested2PartyIDSource() { 		
		if ( hasNested2PartyIDSource()) {		
			if (hasNested2PartyIDSource == FixUtils.TAG_HAS_VALUE) {		
				return nested2PartyIDSource; 		
			} else {		
		
				buf.position(hasNested2PartyIDSource);		
		
			nested2PartyIDSource = FixMessage.getTagCharValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasNested2PartyIDSource);		
					return (byte)'0';		
				}		
			}		
			hasNested2PartyIDSource = FixUtils.TAG_HAS_VALUE;		
			return nested2PartyIDSource;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasNested2PartyIDSource() { return hasNested2PartyIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNested2PartyIDSource(byte src) {		
		nested2PartyIDSource = src;
		hasNested2PartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNested2PartyIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasNested2PartyIDSource()) nested2PartyIDSource = (byte)' ';		
		nested2PartyIDSource = src[0];		
		hasNested2PartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNested2PartyIDSource(String str) {		
		if (str == null ) return;
		if (hasNested2PartyIDSource()) nested2PartyIDSource = (byte)' ';		
		byte[] src = str.getBytes(); 		
		nested2PartyIDSource = src[0];		
		hasNested2PartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getNested2PartyRole() { 		
		if ( hasNested2PartyRole()) {		
			if (hasNested2PartyRole == FixUtils.TAG_HAS_VALUE) {		
				return nested2PartyRole; 		
			} else {		
		
				buf.position(hasNested2PartyRole);		
		
			nested2PartyRole = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasNested2PartyRole);		
					return 0;		
				}		
			}		
			hasNested2PartyRole = FixUtils.TAG_HAS_VALUE;		
			return nested2PartyRole;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasNested2PartyRole() { return hasNested2PartyRole != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNested2PartyRole(long src) {		
		nested2PartyRole = src;
		hasNested2PartyRole = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNested2PartyRole(byte[] src) {		
		if (src == null ) return;
		if (hasNested2PartyRole()) nested2PartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		nested2PartyRole = FixUtils.longValueOf(src, 0, src.length);
		hasNested2PartyRole = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNested2PartyRole(String str) {		
		if (str == null ) return;
		if (hasNested2PartyRole()) nested2PartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		nested2PartyRole = FixUtils.longValueOf(src, 0, src.length);
		hasNested2PartyRole = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasNested2PartyID()) s += "Nested2PartyID(757)= " + new String( FixUtils.trim(getNested2PartyID()) ) + "\n" ; 
		if (hasNested2PartyIDSource()) s += "Nested2PartyIDSource(758)= " + getNested2PartyIDSource() + "\n" ; 
		if (hasNested2PartyRole()) s += "Nested2PartyRole(759)= " + getNested2PartyRole() + "\n" ; 

		for (FixNstdPtys2SubGrp fixNstdPtys2SubGrp : nstdPtys2SubGrp) fixNstdPtys2SubGrp.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixNestedParties2)) return false;

		FixNestedParties2 msg = (FixNestedParties2) o;

		for (int i = 0; i < nstdPtys2SubGrp.length; i++)
			if (!nstdPtys2SubGrp[i].equals(msg.nstdPtys2SubGrp[i])) return false;
		if ((hasNested2PartyID() && !msg.hasNested2PartyID()) || (!hasNested2PartyID() && msg.hasNested2PartyID())) return false;
		if (!(!hasNested2PartyID() && !msg.hasNested2PartyID()) && !FixUtils.equals(getNested2PartyID(), msg.getNested2PartyID())) return false;
		if ((hasNested2PartyIDSource() && !msg.hasNested2PartyIDSource()) || (!hasNested2PartyIDSource() && msg.hasNested2PartyIDSource())) return false;
		if (!(!hasNested2PartyIDSource() && !msg.hasNested2PartyIDSource()) && !(getNested2PartyIDSource()==msg.getNested2PartyIDSource())) return false;
		if ((hasNested2PartyRole() && !msg.hasNested2PartyRole()) || (!hasNested2PartyRole() && msg.hasNested2PartyRole())) return false;
		if (!(!hasNested2PartyRole() && !msg.hasNested2PartyRole()) && !(getNested2PartyRole()==msg.getNested2PartyRole())) return false;
		return true;
	}
	public FixNestedParties2 clone ( FixNestedParties2 out ) {
		if ( hasNested2PartyID())
			out.setNested2PartyID(getNested2PartyID());
		if ( hasNested2PartyIDSource())
			out.setNested2PartyIDSource(getNested2PartyIDSource());
		if ( hasNested2PartyRole())
			out.setNested2PartyRole(getNested2PartyRole());
		int count = 0;
		count = 0;
		for (FixNstdPtys2SubGrp fixNstdPtys2SubGrp : nstdPtys2SubGrp) {
			if (!fixNstdPtys2SubGrp.hasGroup()) continue;
			out.nstdPtys2SubGrp[count] = fixNstdPtys2SubGrp.clone( out.nstdPtys2SubGrp[count] );
			count++;
		}
		return out;
	}

}
