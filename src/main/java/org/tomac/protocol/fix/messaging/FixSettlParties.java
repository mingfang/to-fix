package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixSettlParties extends FixGroup {
	private short hasSettlPartyID;
	byte[] settlPartyID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSettlPartyIDSource;
	byte settlPartyIDSource = (byte)' ';		
	private short hasSettlPartyRole;
	long settlPartyRole = 0;		
		public FixSettlPtysSubGrp[] settlPtysSubGrp;
	
	public FixSettlParties() {
		this(false);
	}

	public FixSettlParties(boolean isRequired) {
		super(FixTags.SETTLPARTYID_INT);

		this.isRequired = isRequired;
		
		hasSettlPartyID = FixUtils.TAG_HAS_NO_VALUE;		
		settlPartyID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSettlPartyIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		settlPtysSubGrp = new FixSettlPtysSubGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) settlPtysSubGrp[i] = new FixSettlPtysSubGrp();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasSettlPartyID()) return true;
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
            	case FixTags.SETTLPARTYID_INT:		
            		hasSettlPartyID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SETTLPARTYIDSOURCE_INT:		
            		hasSettlPartyIDSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SETTLPARTYROLE_INT:		
            		hasSettlPartyRole = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NOSETTLPARTYSUBIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !settlPtysSubGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = settlPtysSubGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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
		hasSettlPartyID = FixUtils.TAG_HAS_NO_VALUE;
		hasSettlPartyIDSource = FixUtils.TAG_HAS_NO_VALUE;
		hasSettlPartyRole = FixUtils.TAG_HAS_NO_VALUE;
		for (FixSettlPtysSubGrp fixSettlPtysSubGrp : settlPtysSubGrp) fixSettlPtysSubGrp.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasSettlPartyID()) {		
			out.put(FixTags.SETTLPARTYID);

			out.put((byte) '=');

			FixUtils.put(out,settlPartyID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSettlPartyIDSource()) {		
			out.put(FixTags.SETTLPARTYIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,settlPartyIDSource); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSettlPartyRole()) {		
			out.put(FixTags.SETTLPARTYROLE);

			out.put((byte) '=');

			FixUtils.put(out, (long)settlPartyRole);
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(settlPtysSubGrp)>0) {
			out.put(FixTags.NOSETTLPARTYSUBIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(settlPtysSubGrp));

			out.put(FixUtils.SOH);

		}
		for (FixSettlPtysSubGrp fixSettlPtysSubGrp : settlPtysSubGrp) if (fixSettlPtysSubGrp.hasGroup()) fixSettlPtysSubGrp.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasSettlPartyID()) {		
			FixUtils.put(out,settlPartyID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlPartyIDSource()) {		
			FixUtils.put(out,settlPartyIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlPartyRole()) {		
			FixUtils.put(out, (long)settlPartyRole);
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixSettlPtysSubGrp fixSettlPtysSubGrp : settlPtysSubGrp) fixSettlPtysSubGrp.printBuffer(out);
	}

	public byte[] getSettlPartyID() { 		
		if ( hasSettlPartyID()) {		
			if (hasSettlPartyID == FixUtils.TAG_HAS_VALUE) {		
				return settlPartyID; 		
			} else {		
		
				buf.position(hasSettlPartyID);		
		
			FixMessage.getTagStringValue(buf, settlPartyID, 0, settlPartyID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSettlPartyID);		
					return null;		
				}		
			}		
			hasSettlPartyID = FixUtils.TAG_HAS_VALUE;		
			return settlPartyID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSettlPartyID() { return hasSettlPartyID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSettlPartyID(byte[] src) {		
		if (src == null ) return;
		if (hasSettlPartyID()) FixUtils.fillSpace(settlPartyID);		
		FixUtils.copy(settlPartyID, src); 		
		hasSettlPartyID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSettlPartyID(String str) {		
		if (str == null ) return;
		if (hasSettlPartyID()) FixUtils.fillSpace(settlPartyID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlPartyID, src); 		
		hasSettlPartyID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getSettlPartyIDSource() { 		
		if ( hasSettlPartyIDSource()) {		
			if (hasSettlPartyIDSource == FixUtils.TAG_HAS_VALUE) {		
				return settlPartyIDSource; 		
			} else {		
		
				buf.position(hasSettlPartyIDSource);		
		
			settlPartyIDSource = FixMessage.getTagCharValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasSettlPartyIDSource);		
					return (byte)'0';		
				}		
			}		
			hasSettlPartyIDSource = FixUtils.TAG_HAS_VALUE;		
			return settlPartyIDSource;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasSettlPartyIDSource() { return hasSettlPartyIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSettlPartyIDSource(byte src) {		
		settlPartyIDSource = src;
		hasSettlPartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlPartyIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasSettlPartyIDSource()) settlPartyIDSource = (byte)' ';		
		settlPartyIDSource = src[0];		
		hasSettlPartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSettlPartyIDSource(String str) {		
		if (str == null ) return;
		if (hasSettlPartyIDSource()) settlPartyIDSource = (byte)' ';		
		byte[] src = str.getBytes(); 		
		settlPartyIDSource = src[0];		
		hasSettlPartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getSettlPartyRole() { 		
		if ( hasSettlPartyRole()) {		
			if (hasSettlPartyRole == FixUtils.TAG_HAS_VALUE) {		
				return settlPartyRole; 		
			} else {		
		
				buf.position(hasSettlPartyRole);		
		
			settlPartyRole = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasSettlPartyRole);		
					return 0;		
				}		
			}		
			hasSettlPartyRole = FixUtils.TAG_HAS_VALUE;		
			return settlPartyRole;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSettlPartyRole() { return hasSettlPartyRole != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSettlPartyRole(long src) {		
		settlPartyRole = src;
		hasSettlPartyRole = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlPartyRole(byte[] src) {		
		if (src == null ) return;
		if (hasSettlPartyRole()) settlPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		settlPartyRole = FixUtils.longValueOf(src, 0, src.length);
		hasSettlPartyRole = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSettlPartyRole(String str) {		
		if (str == null ) return;
		if (hasSettlPartyRole()) settlPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		settlPartyRole = FixUtils.longValueOf(src, 0, src.length);
		hasSettlPartyRole = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasSettlPartyID()) s += "SettlPartyID(782)= " + new String( FixUtils.trim(getSettlPartyID()) ) + "\n" ; 
		if (hasSettlPartyIDSource()) s += "SettlPartyIDSource(783)= " + getSettlPartyIDSource() + "\n" ; 
		if (hasSettlPartyRole()) s += "SettlPartyRole(784)= " + getSettlPartyRole() + "\n" ; 

		for (FixSettlPtysSubGrp fixSettlPtysSubGrp : settlPtysSubGrp) fixSettlPtysSubGrp.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixSettlParties)) return false;

		FixSettlParties msg = (FixSettlParties) o;

		for (FixSettlPtysSubGrp fixSettlPtysSubGrp : settlPtysSubGrp)
			if (!fixSettlPtysSubGrp.equals(msg.settlPtysSubGrp)) return false;
		if ((hasSettlPartyID() && !msg.hasSettlPartyID()) || (!hasSettlPartyID() && msg.hasSettlPartyID())) return false;
		if (!(!hasSettlPartyID() && !msg.hasSettlPartyID()) && !FixUtils.equals(getSettlPartyID(), msg.getSettlPartyID())) return false;
		if ((hasSettlPartyIDSource() && !msg.hasSettlPartyIDSource()) || (!hasSettlPartyIDSource() && msg.hasSettlPartyIDSource())) return false;
		if (!(!hasSettlPartyIDSource() && !msg.hasSettlPartyIDSource()) && !(getSettlPartyIDSource()==msg.getSettlPartyIDSource())) return false;
		if ((hasSettlPartyRole() && !msg.hasSettlPartyRole()) || (!hasSettlPartyRole() && msg.hasSettlPartyRole())) return false;
		if (!(!hasSettlPartyRole() && !msg.hasSettlPartyRole()) && !(getSettlPartyRole()==msg.getSettlPartyRole())) return false;
		return true;
	}
	public FixSettlParties clone ( FixSettlParties out ) {
		if ( hasSettlPartyID())
			out.setSettlPartyID(getSettlPartyID());
		if ( hasSettlPartyIDSource())
			out.setSettlPartyIDSource(getSettlPartyIDSource());
		if ( hasSettlPartyRole())
			out.setSettlPartyRole(getSettlPartyRole());
		int count = 0;
		count = 0;
		for (FixSettlPtysSubGrp fixSettlPtysSubGrp : settlPtysSubGrp) {
			if (!fixSettlPtysSubGrp.hasGroup()) continue;
			out.settlPtysSubGrp[count] = fixSettlPtysSubGrp.clone( out.settlPtysSubGrp[count] );
			count++;
		}
		return out;
	}

}
