package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixPartyAltIDs extends FixGroup {
	private short hasPartyAltID;
	byte[] partyAltID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasPartyAltIDSource;
	byte partyAltIDSource = (byte)' ';		
		FixAltPtysSubGrp[] altPtysSubGrp;
	
	public FixPartyAltIDs() {
		super(FixTags.PARTYALTID_INT);

		
		hasPartyAltID = FixUtils.TAG_HAS_NO_VALUE;		
		partyAltID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasPartyAltIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		altPtysSubGrp = new FixAltPtysSubGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) altPtysSubGrp[i] = new FixAltPtysSubGrp();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasPartyAltID()) return true;
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
            	case FixTags.PARTYALTID_INT:		
            		hasPartyAltID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.PARTYALTIDSOURCE_INT:		
            		hasPartyAltIDSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NOPARTYALTSUBIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !altPtysSubGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = altPtysSubGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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
		hasPartyAltID = FixUtils.TAG_HAS_NO_VALUE;
		hasPartyAltIDSource = FixUtils.TAG_HAS_NO_VALUE;
		for (FixAltPtysSubGrp fixAltPtysSubGrp : altPtysSubGrp) fixAltPtysSubGrp.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasPartyAltID()) {		
			out.put(FixTags.PARTYALTID);

			out.put((byte) '=');

			FixUtils.put(out,partyAltID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasPartyAltIDSource()) {		
			out.put(FixTags.PARTYALTIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,partyAltIDSource); 		
		
			out.put(FixUtils.SOH);

            }

		for (FixAltPtysSubGrp fixAltPtysSubGrp : altPtysSubGrp) fixAltPtysSubGrp.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasPartyAltID()) {		
			FixUtils.put(out,partyAltID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPartyAltIDSource()) {		
			FixUtils.put(out,partyAltIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixAltPtysSubGrp fixAltPtysSubGrp : altPtysSubGrp) fixAltPtysSubGrp.printBuffer(out);
	}

	public byte[] getPartyAltID() { 		
		if ( hasPartyAltID()) {		
			if (hasPartyAltID == FixUtils.TAG_HAS_VALUE) {		
				return partyAltID; 		
			} else {		
		
				buf.position(hasPartyAltID);		
		
			FixMessage.getTagStringValue(buf, partyAltID, 0, partyAltID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasPartyAltID);		
					return null;		
				}		
			}		
			hasPartyAltID = FixUtils.TAG_HAS_VALUE;		
			return partyAltID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasPartyAltID() { return hasPartyAltID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPartyAltID(byte[] src) {		
		if (src == null ) return;
		if (hasPartyAltID()) FixUtils.fillSpace(partyAltID);		
		FixUtils.copy(partyAltID, src); 		
		hasPartyAltID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPartyAltID(String str) {		
		if (str == null ) return;
		if (hasPartyAltID()) FixUtils.fillSpace(partyAltID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(partyAltID, src); 		
		hasPartyAltID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getPartyAltIDSource() { 		
		if ( hasPartyAltIDSource()) {		
			if (hasPartyAltIDSource == FixUtils.TAG_HAS_VALUE) {		
				return partyAltIDSource; 		
			} else {		
		
				buf.position(hasPartyAltIDSource);		
		
			partyAltIDSource = FixMessage.getTagCharValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasPartyAltIDSource);		
					return (byte)'0';		
				}		
			}		
			hasPartyAltIDSource = FixUtils.TAG_HAS_VALUE;		
			return partyAltIDSource;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasPartyAltIDSource() { return hasPartyAltIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPartyAltIDSource(byte src) {		
		partyAltIDSource = src;
		hasPartyAltIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPartyAltIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasPartyAltIDSource()) partyAltIDSource = (byte)' ';		
		partyAltIDSource = src[0];		
		hasPartyAltIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPartyAltIDSource(String str) {		
		if (str == null ) return;
		if (hasPartyAltIDSource()) partyAltIDSource = (byte)' ';		
		byte[] src = str.getBytes(); 		
		partyAltIDSource = src[0];		
		hasPartyAltIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasPartyAltID()) s += "PartyAltID(1517)= " + new String( FixUtils.trim(getPartyAltID()) ) + "\n" ; 
		if (hasPartyAltIDSource()) s += "PartyAltIDSource(1518)= " + getPartyAltIDSource() + "\n" ; 

		for (FixAltPtysSubGrp fixAltPtysSubGrp : altPtysSubGrp) fixAltPtysSubGrp.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixPartyAltIDs)) return false;

		FixPartyAltIDs msg = (FixPartyAltIDs) o;

		for (FixAltPtysSubGrp fixAltPtysSubGrp : altPtysSubGrp)
			if (!fixAltPtysSubGrp.equals(msg.altPtysSubGrp)) return false;
		if ((hasPartyAltID() && !msg.hasPartyAltID()) || (!hasPartyAltID() && msg.hasPartyAltID())) return false;
		if (!(!hasPartyAltID() && !msg.hasPartyAltID()) && !FixUtils.equals(getPartyAltID(), msg.getPartyAltID())) return false;
		if ((hasPartyAltIDSource() && !msg.hasPartyAltIDSource()) || (!hasPartyAltIDSource() && msg.hasPartyAltIDSource())) return false;
		if (!(!hasPartyAltIDSource() && !msg.hasPartyAltIDSource()) && !(getPartyAltIDSource()==msg.getPartyAltIDSource())) return false;
		return true;
	}
	public FixPartyAltIDs clone ( FixPartyAltIDs out ) {
		if ( hasPartyAltID())
			out.setPartyAltID(getPartyAltID());
		if ( hasPartyAltIDSource())
			out.setPartyAltIDSource(getPartyAltIDSource());
		int count = 0;
		count = 0;
		for (FixAltPtysSubGrp fixAltPtysSubGrp : altPtysSubGrp) {
			if (!fixAltPtysSubGrp.hasGroup()) continue;
			out.altPtysSubGrp[count] = fixAltPtysSubGrp.clone( out.altPtysSubGrp[count] );
			count++;
		}
		return out;
	}

}
