package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixRootParties extends FixGroup {
	private short hasRootPartyID;
	byte[] rootPartyID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRootPartyIDSource;
	byte rootPartyIDSource = (byte)' ';		
	private short hasRootPartyRole;
	long rootPartyRole = 0;		
		public FixRootSubParties[] rootSubParties;
	
	public FixRootParties() {
		this(false);
	}

	public FixRootParties(boolean isRequired) {
		super(FixTags.ROOTPARTYID_INT);

		this.isRequired = isRequired;
		
		hasRootPartyID = FixUtils.TAG_HAS_NO_VALUE;		
		rootPartyID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRootPartyIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasRootPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		rootSubParties = new FixRootSubParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) rootSubParties[i] = new FixRootSubParties();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasRootPartyID()) return true;
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
            	case FixTags.ROOTPARTYID_INT:		
            		hasRootPartyID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.ROOTPARTYIDSOURCE_INT:		
            		hasRootPartyIDSource = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.ROOTPARTYROLE_INT:		
            		hasRootPartyRole = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NOROOTPARTYSUBIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !rootSubParties[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = rootSubParties[count].setBuffer( repeatingGroupTag, buf, err);	
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
		hasRootPartyID = FixUtils.TAG_HAS_NO_VALUE;
		hasRootPartyIDSource = FixUtils.TAG_HAS_NO_VALUE;
		hasRootPartyRole = FixUtils.TAG_HAS_NO_VALUE;
		for (FixRootSubParties fixRootSubParties : rootSubParties) fixRootSubParties.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasRootPartyID()) {		
			out.put(FixTags.ROOTPARTYID);

			out.put((byte) '=');

			FixUtils.put(out,rootPartyID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRootPartyIDSource()) {		
			out.put(FixTags.ROOTPARTYIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,rootPartyIDSource); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRootPartyRole()) {		
			out.put(FixTags.ROOTPARTYROLE);

			out.put((byte) '=');

			FixUtils.put(out, (long)rootPartyRole);
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(rootSubParties)>0) {
			out.put(FixTags.NOROOTPARTYSUBIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(rootSubParties));

			out.put(FixUtils.SOH);

		}
		for (FixRootSubParties fixRootSubParties : rootSubParties) if (fixRootSubParties.hasGroup()) fixRootSubParties.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasRootPartyID()) {		
			FixUtils.put(out,rootPartyID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRootPartyIDSource()) {		
			FixUtils.put(out,rootPartyIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRootPartyRole()) {		
			FixUtils.put(out, (long)rootPartyRole);
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixRootSubParties fixRootSubParties : rootSubParties) fixRootSubParties.printBuffer(out);
	}

	public byte[] getRootPartyID() { 		
		if ( hasRootPartyID()) {		
			if (hasRootPartyID == FixUtils.TAG_HAS_VALUE) {		
				return rootPartyID; 		
			} else {		
		
				buf.position(hasRootPartyID);		
		
			FixUtils.getTagStringValue(buf, rootPartyID, 0, rootPartyID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRootPartyID);		
					return null;		
				}		
			}		
			hasRootPartyID = FixUtils.TAG_HAS_VALUE;		
			return rootPartyID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRootPartyID() { return hasRootPartyID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRootPartyID(byte[] src) {		
		if (src == null ) return;
		if (hasRootPartyID()) FixUtils.fillNul(rootPartyID);		
		FixUtils.copy(rootPartyID, src); 		
		hasRootPartyID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRootPartyID(String str) {		
		if (str == null ) return;
		if (hasRootPartyID()) FixUtils.fillNul(rootPartyID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(rootPartyID, src); 		
		hasRootPartyID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getRootPartyIDSource() { 		
		if ( hasRootPartyIDSource()) {		
			if (hasRootPartyIDSource == FixUtils.TAG_HAS_VALUE) {		
				return rootPartyIDSource; 		
			} else {		
		
				buf.position(hasRootPartyIDSource);		
		
			rootPartyIDSource = FixUtils.getTagCharValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRootPartyIDSource);		
					return (byte)'0';		
				}		
			}		
			hasRootPartyIDSource = FixUtils.TAG_HAS_VALUE;		
			return rootPartyIDSource;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasRootPartyIDSource() { return hasRootPartyIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRootPartyIDSource(byte src) {		
		rootPartyIDSource = src;
		hasRootPartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRootPartyIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasRootPartyIDSource()) rootPartyIDSource = (byte)' ';		
		rootPartyIDSource = src[0];		
		hasRootPartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRootPartyIDSource(String str) {		
		if (str == null ) return;
		if (hasRootPartyIDSource()) rootPartyIDSource = (byte)' ';		
		byte[] src = str.getBytes(); 		
		rootPartyIDSource = src[0];		
		hasRootPartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getRootPartyRole() { 		
		if ( hasRootPartyRole()) {		
			if (hasRootPartyRole == FixUtils.TAG_HAS_VALUE) {		
				return rootPartyRole; 		
			} else {		
		
				buf.position(hasRootPartyRole);		
		
			rootPartyRole = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRootPartyRole);		
					return 0;		
				}		
			}		
			hasRootPartyRole = FixUtils.TAG_HAS_VALUE;		
			return rootPartyRole;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRootPartyRole() { return hasRootPartyRole != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRootPartyRole(long src) {		
		rootPartyRole = src;
		hasRootPartyRole = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRootPartyRole(byte[] src) {		
		if (src == null ) return;
		if (hasRootPartyRole()) rootPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		rootPartyRole = FixUtils.longValueOf(src, 0, src.length);
		hasRootPartyRole = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRootPartyRole(String str) {		
		if (str == null ) return;
		if (hasRootPartyRole()) rootPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		rootPartyRole = FixUtils.longValueOf(src, 0, src.length);
		hasRootPartyRole = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasRootPartyID()) s += "RootPartyID(1117)= " + new String( FixUtils.trim(getRootPartyID()) ) + "\n" ; 
		if (hasRootPartyIDSource()) s += "RootPartyIDSource(1118)= " + getRootPartyIDSource() + "\n" ; 
		if (hasRootPartyRole()) s += "RootPartyRole(1119)= " + getRootPartyRole() + "\n" ; 

		for (FixRootSubParties fixRootSubParties : rootSubParties) fixRootSubParties.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixRootParties)) return false;

		FixRootParties msg = (FixRootParties) o;

		for (int i = 0; i < rootSubParties.length; i++)
			if (!rootSubParties[i].equals(msg.rootSubParties[i])) return false;
		if ((hasRootPartyID() && !msg.hasRootPartyID()) || (!hasRootPartyID() && msg.hasRootPartyID())) return false;
		if (!(!hasRootPartyID() && !msg.hasRootPartyID()) && !FixUtils.equals(getRootPartyID(), msg.getRootPartyID())) return false;
		if ((hasRootPartyIDSource() && !msg.hasRootPartyIDSource()) || (!hasRootPartyIDSource() && msg.hasRootPartyIDSource())) return false;
		if (!(!hasRootPartyIDSource() && !msg.hasRootPartyIDSource()) && !(getRootPartyIDSource()==msg.getRootPartyIDSource())) return false;
		if ((hasRootPartyRole() && !msg.hasRootPartyRole()) || (!hasRootPartyRole() && msg.hasRootPartyRole())) return false;
		if (!(!hasRootPartyRole() && !msg.hasRootPartyRole()) && !(getRootPartyRole()==msg.getRootPartyRole())) return false;
		return true;
	}
	public FixRootParties clone ( FixRootParties out ) {
		if ( hasRootPartyID())
			out.setRootPartyID(getRootPartyID());
		if ( hasRootPartyIDSource())
			out.setRootPartyIDSource(getRootPartyIDSource());
		if ( hasRootPartyRole())
			out.setRootPartyRole(getRootPartyRole());
		int count = 0;
		count = 0;
		for (FixRootSubParties fixRootSubParties : rootSubParties) {
			if (!fixRootSubParties.hasGroup()) continue;
			out.rootSubParties[count] = fixRootSubParties.clone( out.rootSubParties[count] );
			count++;
		}
		return out;
	}

}
