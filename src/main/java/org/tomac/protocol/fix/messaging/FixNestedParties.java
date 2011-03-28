package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixNestedParties extends FixGroup {
	private short hasNestedPartyID;
	byte[] nestedPartyID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasNestedPartyIDSource;
	byte nestedPartyIDSource = (byte)' ';		
	private short hasNestedPartyRole;
	long nestedPartyRole = 0;		
		FixNstdPtysSubGrp[] nstdPtysSubGrp;
	
	public FixNestedParties() {
		super(FixTags.NESTEDPARTYID_INT);

		
		hasNestedPartyID = FixUtils.TAG_HAS_NO_VALUE;		
		nestedPartyID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasNestedPartyIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasNestedPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		nstdPtysSubGrp = new FixNstdPtysSubGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) nstdPtysSubGrp[i] = new FixNstdPtysSubGrp();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasNestedPartyID()) return true;
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
            	case FixTags.NESTEDPARTYID_INT:		
            		hasNestedPartyID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.NESTEDPARTYIDSOURCE_INT:		
            		hasNestedPartyIDSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.NESTEDPARTYROLE_INT:		
            		hasNestedPartyRole = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NONESTEDPARTYSUBIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !nstdPtysSubGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = nstdPtysSubGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else { return tag; }
            }

            tag = FixMessage.getTag(buf, err);
            if (err.hasError()) return tag; // what to do now? 
        }		
        return tag;
    }		
	@Override
	public void clear() {
		// just set the length to header + trailer but still we set it...
		hasNestedPartyID = FixUtils.TAG_HAS_NO_VALUE;
		hasNestedPartyIDSource = FixUtils.TAG_HAS_NO_VALUE;
		hasNestedPartyRole = FixUtils.TAG_HAS_NO_VALUE;
		for (FixNstdPtysSubGrp fixNstdPtysSubGrp : nstdPtysSubGrp) fixNstdPtysSubGrp.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasNestedPartyID()) {		
			out.put(FixTags.NESTEDPARTYID);

			out.put((byte) '=');

			FixUtils.put(out,nestedPartyID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasNestedPartyIDSource()) {		
			out.put(FixTags.NESTEDPARTYIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,nestedPartyIDSource); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasNestedPartyRole()) {		
			out.put(FixTags.NESTEDPARTYROLE);

			out.put((byte) '=');

			FixUtils.put(out, (long)nestedPartyRole);
		
			out.put(FixUtils.SOH);

            }

		for (FixNstdPtysSubGrp fixNstdPtysSubGrp : nstdPtysSubGrp) fixNstdPtysSubGrp.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasNestedPartyID()) {		
			FixUtils.put(out,nestedPartyID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasNestedPartyIDSource()) {		
			FixUtils.put(out,nestedPartyIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasNestedPartyRole()) {		
			FixUtils.put(out, (long)nestedPartyRole);
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixNstdPtysSubGrp fixNstdPtysSubGrp : nstdPtysSubGrp) fixNstdPtysSubGrp.printBuffer(out);
	}

	public byte[] getNestedPartyID() { 		
		if ( hasNestedPartyID()) {		
			if (hasNestedPartyID == FixUtils.TAG_HAS_VALUE) {		
				return nestedPartyID; 		
			} else {		
		
				buf.position(hasNestedPartyID);		
		
			FixMessage.getTagStringValue(buf, nestedPartyID, 0, nestedPartyID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasNestedPartyID);		
					return null;		
				}		
			}		
			hasNestedPartyID = FixUtils.TAG_HAS_VALUE;		
			return nestedPartyID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasNestedPartyID() { return hasNestedPartyID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNestedPartyID(byte[] src) {		
		if (src == null ) return;
		if (hasNestedPartyID()) FixUtils.fillSpace(nestedPartyID);		
		FixUtils.copy(nestedPartyID, src); 		
		hasNestedPartyID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNestedPartyID(String str) {		
		if (str == null ) return;
		if (hasNestedPartyID()) FixUtils.fillSpace(nestedPartyID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(nestedPartyID, src); 		
		hasNestedPartyID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getNestedPartyIDSource() { 		
		if ( hasNestedPartyIDSource()) {		
			if (hasNestedPartyIDSource == FixUtils.TAG_HAS_VALUE) {		
				return nestedPartyIDSource; 		
			} else {		
		
				buf.position(hasNestedPartyIDSource);		
		
			nestedPartyIDSource = FixMessage.getTagCharValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasNestedPartyIDSource);		
					return (byte)'0';		
				}		
			}		
			hasNestedPartyIDSource = FixUtils.TAG_HAS_VALUE;		
			return nestedPartyIDSource;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasNestedPartyIDSource() { return hasNestedPartyIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNestedPartyIDSource(byte src) {		
		nestedPartyIDSource = src;
		hasNestedPartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNestedPartyIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasNestedPartyIDSource()) nestedPartyIDSource = (byte)' ';		
		nestedPartyIDSource = src[0];		
		hasNestedPartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNestedPartyIDSource(String str) {		
		if (str == null ) return;
		if (hasNestedPartyIDSource()) nestedPartyIDSource = (byte)' ';		
		byte[] src = str.getBytes(); 		
		nestedPartyIDSource = src[0];		
		hasNestedPartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getNestedPartyRole() { 		
		if ( hasNestedPartyRole()) {		
			if (hasNestedPartyRole == FixUtils.TAG_HAS_VALUE) {		
				return nestedPartyRole; 		
			} else {		
		
				buf.position(hasNestedPartyRole);		
		
			nestedPartyRole = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasNestedPartyRole);		
					return 0;		
				}		
			}		
			hasNestedPartyRole = FixUtils.TAG_HAS_VALUE;		
			return nestedPartyRole;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasNestedPartyRole() { return hasNestedPartyRole != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNestedPartyRole(long src) {		
		nestedPartyRole = src;
		hasNestedPartyRole = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNestedPartyRole(byte[] src) {		
		if (src == null ) return;
		if (hasNestedPartyRole()) nestedPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		nestedPartyRole = FixUtils.longValueOf(src, 0, src.length);
		hasNestedPartyRole = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNestedPartyRole(String str) {		
		if (str == null ) return;
		if (hasNestedPartyRole()) nestedPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		nestedPartyRole = FixUtils.longValueOf(src, 0, src.length);
		hasNestedPartyRole = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasNestedPartyID()) s += "NestedPartyID(524)= " + new String( FixUtils.trim(getNestedPartyID()) ) + "\n" ; 
		if (hasNestedPartyIDSource()) s += "NestedPartyIDSource(525)= " + getNestedPartyIDSource() + "\n" ; 
		if (hasNestedPartyRole()) s += "NestedPartyRole(538)= " + getNestedPartyRole() + "\n" ; 

		for (FixNstdPtysSubGrp fixNstdPtysSubGrp : nstdPtysSubGrp) fixNstdPtysSubGrp.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixNestedParties)) return false;

		FixNestedParties msg = (FixNestedParties) o;

		for (FixNstdPtysSubGrp fixNstdPtysSubGrp : nstdPtysSubGrp)
			if (!fixNstdPtysSubGrp.equals(msg.nstdPtysSubGrp)) return false;
		if ((hasNestedPartyID() && !msg.hasNestedPartyID()) || (!hasNestedPartyID() && msg.hasNestedPartyID())) return false;
		if (!(!hasNestedPartyID() && !msg.hasNestedPartyID()) && !FixUtils.equals(getNestedPartyID(), msg.getNestedPartyID())) return false;
		if ((hasNestedPartyIDSource() && !msg.hasNestedPartyIDSource()) || (!hasNestedPartyIDSource() && msg.hasNestedPartyIDSource())) return false;
		if (!(!hasNestedPartyIDSource() && !msg.hasNestedPartyIDSource()) && !(getNestedPartyIDSource()==msg.getNestedPartyIDSource())) return false;
		if ((hasNestedPartyRole() && !msg.hasNestedPartyRole()) || (!hasNestedPartyRole() && msg.hasNestedPartyRole())) return false;
		if (!(!hasNestedPartyRole() && !msg.hasNestedPartyRole()) && !(getNestedPartyRole()==msg.getNestedPartyRole())) return false;
		return true;
	}
	public FixNestedParties clone ( FixNestedParties out ) {
		if ( hasNestedPartyID())
			out.setNestedPartyID(getNestedPartyID());
		if ( hasNestedPartyIDSource())
			out.setNestedPartyIDSource(getNestedPartyIDSource());
		if ( hasNestedPartyRole())
			out.setNestedPartyRole(getNestedPartyRole());
		int count = 0;
		count = 0;
		for (FixNstdPtysSubGrp fixNstdPtysSubGrp : nstdPtysSubGrp) {
			if (!fixNstdPtysSubGrp.hasGroup()) continue;
			out.nstdPtysSubGrp[count] = fixNstdPtysSubGrp.clone( out.nstdPtysSubGrp[count] );
			count++;
		}
		return out;
	}

}
