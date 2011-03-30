package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixInstrumentParties extends FixGroup {
	private short hasInstrumentPartyID;
	byte[] instrumentPartyID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasInstrumentPartyIDSource;
	byte instrumentPartyIDSource = (byte)' ';		
	private short hasInstrumentPartyRole;
	long instrumentPartyRole = 0;		
		public FixInstrumentPtysSubGrp[] instrumentPtysSubGrp;
	
	public FixInstrumentParties() {
		this(false);
	}

	public FixInstrumentParties(boolean isRequired) {
		super(FixTags.INSTRUMENTPARTYID_INT);

		this.isRequired = isRequired;
		
		hasInstrumentPartyID = FixUtils.TAG_HAS_NO_VALUE;		
		instrumentPartyID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasInstrumentPartyIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasInstrumentPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		instrumentPtysSubGrp = new FixInstrumentPtysSubGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) instrumentPtysSubGrp[i] = new FixInstrumentPtysSubGrp();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasInstrumentPartyID()) return true;
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
            	case FixTags.INSTRUMENTPARTYID_INT:		
            		hasInstrumentPartyID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.INSTRUMENTPARTYIDSOURCE_INT:		
            		hasInstrumentPartyIDSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.INSTRUMENTPARTYROLE_INT:		
            		hasInstrumentPartyRole = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NOINSTRUMENTPARTYSUBIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !instrumentPtysSubGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = instrumentPtysSubGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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
		hasInstrumentPartyID = FixUtils.TAG_HAS_NO_VALUE;
		hasInstrumentPartyIDSource = FixUtils.TAG_HAS_NO_VALUE;
		hasInstrumentPartyRole = FixUtils.TAG_HAS_NO_VALUE;
		for (FixInstrumentPtysSubGrp fixInstrumentPtysSubGrp : instrumentPtysSubGrp) fixInstrumentPtysSubGrp.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasInstrumentPartyID()) {		
			out.put(FixTags.INSTRUMENTPARTYID);

			out.put((byte) '=');

			FixUtils.put(out,instrumentPartyID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasInstrumentPartyIDSource()) {		
			out.put(FixTags.INSTRUMENTPARTYIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,instrumentPartyIDSource); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasInstrumentPartyRole()) {		
			out.put(FixTags.INSTRUMENTPARTYROLE);

			out.put((byte) '=');

			FixUtils.put(out, (long)instrumentPartyRole);
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(instrumentPtysSubGrp)>0) {
			out.put(FixTags.NOINSTRUMENTPARTYSUBIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(instrumentPtysSubGrp));

			out.put(FixUtils.SOH);

		}
		for (FixInstrumentPtysSubGrp fixInstrumentPtysSubGrp : instrumentPtysSubGrp) if (fixInstrumentPtysSubGrp.hasGroup()) fixInstrumentPtysSubGrp.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasInstrumentPartyID()) {		
			FixUtils.put(out,instrumentPartyID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasInstrumentPartyIDSource()) {		
			FixUtils.put(out,instrumentPartyIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasInstrumentPartyRole()) {		
			FixUtils.put(out, (long)instrumentPartyRole);
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixInstrumentPtysSubGrp fixInstrumentPtysSubGrp : instrumentPtysSubGrp) fixInstrumentPtysSubGrp.printBuffer(out);
	}

	public byte[] getInstrumentPartyID() { 		
		if ( hasInstrumentPartyID()) {		
			if (hasInstrumentPartyID == FixUtils.TAG_HAS_VALUE) {		
				return instrumentPartyID; 		
			} else {		
		
				buf.position(hasInstrumentPartyID);		
		
			FixMessage.getTagStringValue(buf, instrumentPartyID, 0, instrumentPartyID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasInstrumentPartyID);		
					return null;		
				}		
			}		
			hasInstrumentPartyID = FixUtils.TAG_HAS_VALUE;		
			return instrumentPartyID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasInstrumentPartyID() { return hasInstrumentPartyID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setInstrumentPartyID(byte[] src) {		
		if (src == null ) return;
		if (hasInstrumentPartyID()) FixUtils.fillSpace(instrumentPartyID);		
		FixUtils.copy(instrumentPartyID, src); 		
		hasInstrumentPartyID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setInstrumentPartyID(String str) {		
		if (str == null ) return;
		if (hasInstrumentPartyID()) FixUtils.fillSpace(instrumentPartyID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(instrumentPartyID, src); 		
		hasInstrumentPartyID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getInstrumentPartyIDSource() { 		
		if ( hasInstrumentPartyIDSource()) {		
			if (hasInstrumentPartyIDSource == FixUtils.TAG_HAS_VALUE) {		
				return instrumentPartyIDSource; 		
			} else {		
		
				buf.position(hasInstrumentPartyIDSource);		
		
			instrumentPartyIDSource = FixMessage.getTagCharValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasInstrumentPartyIDSource);		
					return (byte)'0';		
				}		
			}		
			hasInstrumentPartyIDSource = FixUtils.TAG_HAS_VALUE;		
			return instrumentPartyIDSource;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasInstrumentPartyIDSource() { return hasInstrumentPartyIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setInstrumentPartyIDSource(byte src) {		
		instrumentPartyIDSource = src;
		hasInstrumentPartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setInstrumentPartyIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasInstrumentPartyIDSource()) instrumentPartyIDSource = (byte)' ';		
		instrumentPartyIDSource = src[0];		
		hasInstrumentPartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setInstrumentPartyIDSource(String str) {		
		if (str == null ) return;
		if (hasInstrumentPartyIDSource()) instrumentPartyIDSource = (byte)' ';		
		byte[] src = str.getBytes(); 		
		instrumentPartyIDSource = src[0];		
		hasInstrumentPartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getInstrumentPartyRole() { 		
		if ( hasInstrumentPartyRole()) {		
			if (hasInstrumentPartyRole == FixUtils.TAG_HAS_VALUE) {		
				return instrumentPartyRole; 		
			} else {		
		
				buf.position(hasInstrumentPartyRole);		
		
			instrumentPartyRole = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasInstrumentPartyRole);		
					return 0;		
				}		
			}		
			hasInstrumentPartyRole = FixUtils.TAG_HAS_VALUE;		
			return instrumentPartyRole;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasInstrumentPartyRole() { return hasInstrumentPartyRole != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setInstrumentPartyRole(long src) {		
		instrumentPartyRole = src;
		hasInstrumentPartyRole = FixUtils.TAG_HAS_VALUE;		
	}

	public void setInstrumentPartyRole(byte[] src) {		
		if (src == null ) return;
		if (hasInstrumentPartyRole()) instrumentPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		instrumentPartyRole = FixUtils.longValueOf(src, 0, src.length);
		hasInstrumentPartyRole = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setInstrumentPartyRole(String str) {		
		if (str == null ) return;
		if (hasInstrumentPartyRole()) instrumentPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		instrumentPartyRole = FixUtils.longValueOf(src, 0, src.length);
		hasInstrumentPartyRole = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasInstrumentPartyID()) s += "InstrumentPartyID(1019)= " + new String( FixUtils.trim(getInstrumentPartyID()) ) + "\n" ; 
		if (hasInstrumentPartyIDSource()) s += "InstrumentPartyIDSource(1050)= " + getInstrumentPartyIDSource() + "\n" ; 
		if (hasInstrumentPartyRole()) s += "InstrumentPartyRole(1051)= " + getInstrumentPartyRole() + "\n" ; 

		for (FixInstrumentPtysSubGrp fixInstrumentPtysSubGrp : instrumentPtysSubGrp) fixInstrumentPtysSubGrp.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixInstrumentParties)) return false;

		FixInstrumentParties msg = (FixInstrumentParties) o;

		for (FixInstrumentPtysSubGrp fixInstrumentPtysSubGrp : instrumentPtysSubGrp)
			if (!fixInstrumentPtysSubGrp.equals(msg.instrumentPtysSubGrp)) return false;
		if ((hasInstrumentPartyID() && !msg.hasInstrumentPartyID()) || (!hasInstrumentPartyID() && msg.hasInstrumentPartyID())) return false;
		if (!(!hasInstrumentPartyID() && !msg.hasInstrumentPartyID()) && !FixUtils.equals(getInstrumentPartyID(), msg.getInstrumentPartyID())) return false;
		if ((hasInstrumentPartyIDSource() && !msg.hasInstrumentPartyIDSource()) || (!hasInstrumentPartyIDSource() && msg.hasInstrumentPartyIDSource())) return false;
		if (!(!hasInstrumentPartyIDSource() && !msg.hasInstrumentPartyIDSource()) && !(getInstrumentPartyIDSource()==msg.getInstrumentPartyIDSource())) return false;
		if ((hasInstrumentPartyRole() && !msg.hasInstrumentPartyRole()) || (!hasInstrumentPartyRole() && msg.hasInstrumentPartyRole())) return false;
		if (!(!hasInstrumentPartyRole() && !msg.hasInstrumentPartyRole()) && !(getInstrumentPartyRole()==msg.getInstrumentPartyRole())) return false;
		return true;
	}
	public FixInstrumentParties clone ( FixInstrumentParties out ) {
		if ( hasInstrumentPartyID())
			out.setInstrumentPartyID(getInstrumentPartyID());
		if ( hasInstrumentPartyIDSource())
			out.setInstrumentPartyIDSource(getInstrumentPartyIDSource());
		if ( hasInstrumentPartyRole())
			out.setInstrumentPartyRole(getInstrumentPartyRole());
		int count = 0;
		count = 0;
		for (FixInstrumentPtysSubGrp fixInstrumentPtysSubGrp : instrumentPtysSubGrp) {
			if (!fixInstrumentPtysSubGrp.hasGroup()) continue;
			out.instrumentPtysSubGrp[count] = fixInstrumentPtysSubGrp.clone( out.instrumentPtysSubGrp[count] );
			count++;
		}
		return out;
	}

}
