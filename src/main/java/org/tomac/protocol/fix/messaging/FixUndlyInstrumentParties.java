package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixUndlyInstrumentParties extends FixGroup {
	private short hasUnderlyingInstrumentPartyID;
	byte[] underlyingInstrumentPartyID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasUnderlyingInstrumentPartyIDSource;
	byte underlyingInstrumentPartyIDSource = (byte)' ';		
	private short hasUnderlyingInstrumentPartyRole;
	long underlyingInstrumentPartyRole = 0;		
		public FixUndlyInstrumentPtysSubGrp[] undlyInstrumentPtysSubGrp;
	
	public FixUndlyInstrumentParties() {
		this(false);
	}

	public FixUndlyInstrumentParties(boolean isRequired) {
		super(FixTags.UNDERLYINGINSTRUMENTPARTYID_INT);

		this.isRequired = isRequired;
		
		hasUnderlyingInstrumentPartyID = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingInstrumentPartyID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasUnderlyingInstrumentPartyIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasUnderlyingInstrumentPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		undlyInstrumentPtysSubGrp = new FixUndlyInstrumentPtysSubGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) undlyInstrumentPtysSubGrp[i] = new FixUndlyInstrumentPtysSubGrp();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasUnderlyingInstrumentPartyID()) return true;
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
            	case FixTags.UNDERLYINGINSTRUMENTPARTYID_INT:		
            		hasUnderlyingInstrumentPartyID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGINSTRUMENTPARTYIDSOURCE_INT:		
            		hasUnderlyingInstrumentPartyIDSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.UNDERLYINGINSTRUMENTPARTYROLE_INT:		
            		hasUnderlyingInstrumentPartyRole = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NOUNDLYINSTRUMENTPARTYSUBIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !undlyInstrumentPtysSubGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = undlyInstrumentPtysSubGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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
		hasUnderlyingInstrumentPartyID = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingInstrumentPartyIDSource = FixUtils.TAG_HAS_NO_VALUE;
		hasUnderlyingInstrumentPartyRole = FixUtils.TAG_HAS_NO_VALUE;
		for (FixUndlyInstrumentPtysSubGrp fixUndlyInstrumentPtysSubGrp : undlyInstrumentPtysSubGrp) fixUndlyInstrumentPtysSubGrp.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasUnderlyingInstrumentPartyID()) {		
			out.put(FixTags.UNDERLYINGINSTRUMENTPARTYID);

			out.put((byte) '=');

			FixUtils.put(out,underlyingInstrumentPartyID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingInstrumentPartyIDSource()) {		
			out.put(FixTags.UNDERLYINGINSTRUMENTPARTYIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,underlyingInstrumentPartyIDSource); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasUnderlyingInstrumentPartyRole()) {		
			out.put(FixTags.UNDERLYINGINSTRUMENTPARTYROLE);

			out.put((byte) '=');

			FixUtils.put(out, (long)underlyingInstrumentPartyRole);
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(undlyInstrumentPtysSubGrp)>0) {
			out.put(FixTags.NOUNDLYINSTRUMENTPARTYSUBIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(undlyInstrumentPtysSubGrp));

			out.put(FixUtils.SOH);

		}
		for (FixUndlyInstrumentPtysSubGrp fixUndlyInstrumentPtysSubGrp : undlyInstrumentPtysSubGrp) if (fixUndlyInstrumentPtysSubGrp.hasGroup()) fixUndlyInstrumentPtysSubGrp.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasUnderlyingInstrumentPartyID()) {		
			FixUtils.put(out,underlyingInstrumentPartyID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingInstrumentPartyIDSource()) {		
			FixUtils.put(out,underlyingInstrumentPartyIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasUnderlyingInstrumentPartyRole()) {		
			FixUtils.put(out, (long)underlyingInstrumentPartyRole);
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixUndlyInstrumentPtysSubGrp fixUndlyInstrumentPtysSubGrp : undlyInstrumentPtysSubGrp) fixUndlyInstrumentPtysSubGrp.printBuffer(out);
	}

	public byte[] getUnderlyingInstrumentPartyID() { 		
		if ( hasUnderlyingInstrumentPartyID()) {		
			if (hasUnderlyingInstrumentPartyID == FixUtils.TAG_HAS_VALUE) {		
				return underlyingInstrumentPartyID; 		
			} else {		
		
				buf.position(hasUnderlyingInstrumentPartyID);		
		
			FixMessage.getTagStringValue(buf, underlyingInstrumentPartyID, 0, underlyingInstrumentPartyID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingInstrumentPartyID);		
					return null;		
				}		
			}		
			hasUnderlyingInstrumentPartyID = FixUtils.TAG_HAS_VALUE;		
			return underlyingInstrumentPartyID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasUnderlyingInstrumentPartyID() { return hasUnderlyingInstrumentPartyID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingInstrumentPartyID(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingInstrumentPartyID()) FixUtils.fillSpace(underlyingInstrumentPartyID);		
		FixUtils.copy(underlyingInstrumentPartyID, src); 		
		hasUnderlyingInstrumentPartyID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingInstrumentPartyID(String str) {		
		if (str == null ) return;
		if (hasUnderlyingInstrumentPartyID()) FixUtils.fillSpace(underlyingInstrumentPartyID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(underlyingInstrumentPartyID, src); 		
		hasUnderlyingInstrumentPartyID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getUnderlyingInstrumentPartyIDSource() { 		
		if ( hasUnderlyingInstrumentPartyIDSource()) {		
			if (hasUnderlyingInstrumentPartyIDSource == FixUtils.TAG_HAS_VALUE) {		
				return underlyingInstrumentPartyIDSource; 		
			} else {		
		
				buf.position(hasUnderlyingInstrumentPartyIDSource);		
		
			underlyingInstrumentPartyIDSource = FixMessage.getTagCharValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingInstrumentPartyIDSource);		
					return (byte)'0';		
				}		
			}		
			hasUnderlyingInstrumentPartyIDSource = FixUtils.TAG_HAS_VALUE;		
			return underlyingInstrumentPartyIDSource;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasUnderlyingInstrumentPartyIDSource() { return hasUnderlyingInstrumentPartyIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingInstrumentPartyIDSource(byte src) {		
		underlyingInstrumentPartyIDSource = src;
		hasUnderlyingInstrumentPartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingInstrumentPartyIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingInstrumentPartyIDSource()) underlyingInstrumentPartyIDSource = (byte)' ';		
		underlyingInstrumentPartyIDSource = src[0];		
		hasUnderlyingInstrumentPartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingInstrumentPartyIDSource(String str) {		
		if (str == null ) return;
		if (hasUnderlyingInstrumentPartyIDSource()) underlyingInstrumentPartyIDSource = (byte)' ';		
		byte[] src = str.getBytes(); 		
		underlyingInstrumentPartyIDSource = src[0];		
		hasUnderlyingInstrumentPartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getUnderlyingInstrumentPartyRole() { 		
		if ( hasUnderlyingInstrumentPartyRole()) {		
			if (hasUnderlyingInstrumentPartyRole == FixUtils.TAG_HAS_VALUE) {		
				return underlyingInstrumentPartyRole; 		
			} else {		
		
				buf.position(hasUnderlyingInstrumentPartyRole);		
		
			underlyingInstrumentPartyRole = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasUnderlyingInstrumentPartyRole);		
					return 0;		
				}		
			}		
			hasUnderlyingInstrumentPartyRole = FixUtils.TAG_HAS_VALUE;		
			return underlyingInstrumentPartyRole;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasUnderlyingInstrumentPartyRole() { return hasUnderlyingInstrumentPartyRole != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setUnderlyingInstrumentPartyRole(long src) {		
		underlyingInstrumentPartyRole = src;
		hasUnderlyingInstrumentPartyRole = FixUtils.TAG_HAS_VALUE;		
	}

	public void setUnderlyingInstrumentPartyRole(byte[] src) {		
		if (src == null ) return;
		if (hasUnderlyingInstrumentPartyRole()) underlyingInstrumentPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingInstrumentPartyRole = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingInstrumentPartyRole = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setUnderlyingInstrumentPartyRole(String str) {		
		if (str == null ) return;
		if (hasUnderlyingInstrumentPartyRole()) underlyingInstrumentPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		underlyingInstrumentPartyRole = FixUtils.longValueOf(src, 0, src.length);
		hasUnderlyingInstrumentPartyRole = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasUnderlyingInstrumentPartyID()) s += "UnderlyingInstrumentPartyID(1059)= " + new String( FixUtils.trim(getUnderlyingInstrumentPartyID()) ) + "\n" ; 
		if (hasUnderlyingInstrumentPartyIDSource()) s += "UnderlyingInstrumentPartyIDSource(1060)= " + getUnderlyingInstrumentPartyIDSource() + "\n" ; 
		if (hasUnderlyingInstrumentPartyRole()) s += "UnderlyingInstrumentPartyRole(1061)= " + getUnderlyingInstrumentPartyRole() + "\n" ; 

		for (FixUndlyInstrumentPtysSubGrp fixUndlyInstrumentPtysSubGrp : undlyInstrumentPtysSubGrp) fixUndlyInstrumentPtysSubGrp.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixUndlyInstrumentParties)) return false;

		FixUndlyInstrumentParties msg = (FixUndlyInstrumentParties) o;

		for (int i = 0; i < undlyInstrumentPtysSubGrp.length; i++)
			if (!undlyInstrumentPtysSubGrp[i].equals(msg.undlyInstrumentPtysSubGrp[i])) return false;
		if ((hasUnderlyingInstrumentPartyID() && !msg.hasUnderlyingInstrumentPartyID()) || (!hasUnderlyingInstrumentPartyID() && msg.hasUnderlyingInstrumentPartyID())) return false;
		if (!(!hasUnderlyingInstrumentPartyID() && !msg.hasUnderlyingInstrumentPartyID()) && !FixUtils.equals(getUnderlyingInstrumentPartyID(), msg.getUnderlyingInstrumentPartyID())) return false;
		if ((hasUnderlyingInstrumentPartyIDSource() && !msg.hasUnderlyingInstrumentPartyIDSource()) || (!hasUnderlyingInstrumentPartyIDSource() && msg.hasUnderlyingInstrumentPartyIDSource())) return false;
		if (!(!hasUnderlyingInstrumentPartyIDSource() && !msg.hasUnderlyingInstrumentPartyIDSource()) && !(getUnderlyingInstrumentPartyIDSource()==msg.getUnderlyingInstrumentPartyIDSource())) return false;
		if ((hasUnderlyingInstrumentPartyRole() && !msg.hasUnderlyingInstrumentPartyRole()) || (!hasUnderlyingInstrumentPartyRole() && msg.hasUnderlyingInstrumentPartyRole())) return false;
		if (!(!hasUnderlyingInstrumentPartyRole() && !msg.hasUnderlyingInstrumentPartyRole()) && !(getUnderlyingInstrumentPartyRole()==msg.getUnderlyingInstrumentPartyRole())) return false;
		return true;
	}
	public FixUndlyInstrumentParties clone ( FixUndlyInstrumentParties out ) {
		if ( hasUnderlyingInstrumentPartyID())
			out.setUnderlyingInstrumentPartyID(getUnderlyingInstrumentPartyID());
		if ( hasUnderlyingInstrumentPartyIDSource())
			out.setUnderlyingInstrumentPartyIDSource(getUnderlyingInstrumentPartyIDSource());
		if ( hasUnderlyingInstrumentPartyRole())
			out.setUnderlyingInstrumentPartyRole(getUnderlyingInstrumentPartyRole());
		int count = 0;
		count = 0;
		for (FixUndlyInstrumentPtysSubGrp fixUndlyInstrumentPtysSubGrp : undlyInstrumentPtysSubGrp) {
			if (!fixUndlyInstrumentPtysSubGrp.hasGroup()) continue;
			out.undlyInstrumentPtysSubGrp[count] = fixUndlyInstrumentPtysSubGrp.clone( out.undlyInstrumentPtysSubGrp[count] );
			count++;
		}
		return out;
	}

}
