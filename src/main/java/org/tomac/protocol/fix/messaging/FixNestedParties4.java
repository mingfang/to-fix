package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixNestedParties4 extends FixGroup {
	private short hasNested4PartyID;
	byte[] nested4PartyID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasNested4PartyIDSource;
	byte nested4PartyIDSource = (byte)' ';		
	private short hasNested4PartyRole;
	long nested4PartyRole = 0;		
		public FixNstdPtys4SubGrp[] nstdPtys4SubGrp;
	
	public FixNestedParties4() {
		this(false);
	}

	public FixNestedParties4(boolean isRequired) {
		super(FixTags.NESTED4PARTYID_INT);

		this.isRequired = isRequired;
		
		hasNested4PartyID = FixUtils.TAG_HAS_NO_VALUE;		
		nested4PartyID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasNested4PartyIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasNested4PartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		nstdPtys4SubGrp = new FixNstdPtys4SubGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) nstdPtys4SubGrp[i] = new FixNstdPtys4SubGrp();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasNested4PartyID()) return true;
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
            	case FixTags.NESTED4PARTYID_INT:		
            		hasNested4PartyID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.NESTED4PARTYIDSOURCE_INT:		
            		hasNested4PartyIDSource = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.NESTED4PARTYROLE_INT:		
            		hasNested4PartyRole = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NONESTED4PARTYSUBIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !nstdPtys4SubGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NONESTED4PARTYSUBIDS_INT);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = nstdPtys4SubGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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
		hasNested4PartyID = FixUtils.TAG_HAS_NO_VALUE;
		hasNested4PartyIDSource = FixUtils.TAG_HAS_NO_VALUE;
		hasNested4PartyRole = FixUtils.TAG_HAS_NO_VALUE;
		for (FixNstdPtys4SubGrp fixNstdPtys4SubGrp : nstdPtys4SubGrp) fixNstdPtys4SubGrp.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasNested4PartyID()) {		
			out.put(FixTags.NESTED4PARTYID);

			out.put((byte) '=');

			FixUtils.put(out,nested4PartyID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasNested4PartyIDSource()) {		
			out.put(FixTags.NESTED4PARTYIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,nested4PartyIDSource); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasNested4PartyRole()) {		
			out.put(FixTags.NESTED4PARTYROLE);

			out.put((byte) '=');

			FixUtils.put(out, (long)nested4PartyRole);
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(nstdPtys4SubGrp)>0) {
			out.put(FixTags.NONESTED4PARTYSUBIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(nstdPtys4SubGrp));

			out.put(FixUtils.SOH);

		}
		for (FixNstdPtys4SubGrp fixNstdPtys4SubGrp : nstdPtys4SubGrp) if (fixNstdPtys4SubGrp.hasGroup()) fixNstdPtys4SubGrp.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasNested4PartyID()) {		
			FixUtils.put(out,nested4PartyID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasNested4PartyIDSource()) {		
			FixUtils.put(out,nested4PartyIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasNested4PartyRole()) {		
			FixUtils.put(out, (long)nested4PartyRole);
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixNstdPtys4SubGrp fixNstdPtys4SubGrp : nstdPtys4SubGrp) fixNstdPtys4SubGrp.printBuffer(out);
	}

	public byte[] getNested4PartyID() { 		
		if ( hasNested4PartyID()) {		
			if (hasNested4PartyID == FixUtils.TAG_HAS_VALUE) {		
				return nested4PartyID; 		
			} else {		
		
				buf.position(hasNested4PartyID);		
		
			FixUtils.getTagStringValue(buf, nested4PartyID, 0, nested4PartyID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasNested4PartyID);		
					return null;		
				}		
			}		
			hasNested4PartyID = FixUtils.TAG_HAS_VALUE;		
			return nested4PartyID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasNested4PartyID() { return hasNested4PartyID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNested4PartyID(byte[] src) {		
		if (src == null ) return;
		if (hasNested4PartyID()) FixUtils.fillNul(nested4PartyID);		
		FixUtils.copy(nested4PartyID, src); 		
		hasNested4PartyID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNested4PartyID(String str) {		
		if (str == null ) return;
		if (hasNested4PartyID()) FixUtils.fillNul(nested4PartyID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(nested4PartyID, src); 		
		hasNested4PartyID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getNested4PartyIDSource() { 		
		if ( hasNested4PartyIDSource()) {		
			if (hasNested4PartyIDSource == FixUtils.TAG_HAS_VALUE) {		
				return nested4PartyIDSource; 		
			} else {		
		
				buf.position(hasNested4PartyIDSource);		
		
			nested4PartyIDSource = FixUtils.getTagCharValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasNested4PartyIDSource);		
					return (byte)'0';		
				}		
			}		
			hasNested4PartyIDSource = FixUtils.TAG_HAS_VALUE;		
			return nested4PartyIDSource;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasNested4PartyIDSource() { return hasNested4PartyIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNested4PartyIDSource(byte src) {		
		nested4PartyIDSource = src;
		hasNested4PartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNested4PartyIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasNested4PartyIDSource()) nested4PartyIDSource = (byte)' ';		
		nested4PartyIDSource = src[0];		
		hasNested4PartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNested4PartyIDSource(String str) {		
		if (str == null ) return;
		if (hasNested4PartyIDSource()) nested4PartyIDSource = (byte)' ';		
		byte[] src = str.getBytes(); 		
		nested4PartyIDSource = src[0];		
		hasNested4PartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getNested4PartyRole() { 		
		if ( hasNested4PartyRole()) {		
			if (hasNested4PartyRole == FixUtils.TAG_HAS_VALUE) {		
				return nested4PartyRole; 		
			} else {		
		
				buf.position(hasNested4PartyRole);		
		
			nested4PartyRole = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasNested4PartyRole);		
					return 0;		
				}		
			}		
			hasNested4PartyRole = FixUtils.TAG_HAS_VALUE;		
			return nested4PartyRole;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasNested4PartyRole() { return hasNested4PartyRole != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNested4PartyRole(long src) {		
		nested4PartyRole = src;
		hasNested4PartyRole = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNested4PartyRole(byte[] src) {		
		if (src == null ) return;
		if (hasNested4PartyRole()) nested4PartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		nested4PartyRole = FixUtils.longValueOf(src, 0, src.length);
		hasNested4PartyRole = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNested4PartyRole(String str) {		
		if (str == null ) return;
		if (hasNested4PartyRole()) nested4PartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		nested4PartyRole = FixUtils.longValueOf(src, 0, src.length);
		hasNested4PartyRole = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasNested4PartyID()) s += "Nested4PartyID(1415)= " + new String( FixUtils.trim(getNested4PartyID()) ) + "\n" ; 
		if (hasNested4PartyIDSource()) s += "Nested4PartyIDSource(1416)= " + getNested4PartyIDSource() + "\n" ; 
		if (hasNested4PartyRole()) s += "Nested4PartyRole(1417)= " + getNested4PartyRole() + "\n" ; 

		for (FixNstdPtys4SubGrp fixNstdPtys4SubGrp : nstdPtys4SubGrp) fixNstdPtys4SubGrp.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixNestedParties4)) return false;

		FixNestedParties4 msg = (FixNestedParties4) o;

		for (int i = 0; i < nstdPtys4SubGrp.length; i++)
			if (!nstdPtys4SubGrp[i].equals(msg.nstdPtys4SubGrp[i])) return false;
		if ((hasNested4PartyID() && !msg.hasNested4PartyID()) || (!hasNested4PartyID() && msg.hasNested4PartyID())) return false;
		if (!(!hasNested4PartyID() && !msg.hasNested4PartyID()) && !FixUtils.equals(getNested4PartyID(), msg.getNested4PartyID())) return false;
		if ((hasNested4PartyIDSource() && !msg.hasNested4PartyIDSource()) || (!hasNested4PartyIDSource() && msg.hasNested4PartyIDSource())) return false;
		if (!(!hasNested4PartyIDSource() && !msg.hasNested4PartyIDSource()) && !(getNested4PartyIDSource()==msg.getNested4PartyIDSource())) return false;
		if ((hasNested4PartyRole() && !msg.hasNested4PartyRole()) || (!hasNested4PartyRole() && msg.hasNested4PartyRole())) return false;
		if (!(!hasNested4PartyRole() && !msg.hasNested4PartyRole()) && !(getNested4PartyRole()==msg.getNested4PartyRole())) return false;
		return true;
	}
	public FixNestedParties4 clone ( FixNestedParties4 out ) {
		if ( hasNested4PartyID())
			out.setNested4PartyID(getNested4PartyID());
		if ( hasNested4PartyIDSource())
			out.setNested4PartyIDSource(getNested4PartyIDSource());
		if ( hasNested4PartyRole())
			out.setNested4PartyRole(getNested4PartyRole());
		int count = 0;
		count = 0;
		for (FixNstdPtys4SubGrp fixNstdPtys4SubGrp : nstdPtys4SubGrp) {
			if (!fixNstdPtys4SubGrp.hasGroup()) continue;
			out.nstdPtys4SubGrp[count] = fixNstdPtys4SubGrp.clone( out.nstdPtys4SubGrp[count] );
			count++;
		}
		return out;
	}

}
