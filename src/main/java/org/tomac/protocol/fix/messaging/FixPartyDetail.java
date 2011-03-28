package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixPartyDetail extends FixGroup {
	private short hasPartyID;
	byte[] partyID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasPartyIDSource;
	byte partyIDSource = (byte)' ';		
	private short hasPartyRole;
	long partyRole = 0;		
		FixPtysSubGrp[] ptysSubGrp;
		FixPartyAltIDs[] partyAltIDs;
		FixContextParties[] contextParties;
		FixRiskLimits[] riskLimits;
	
	public FixPartyDetail() {
		super(FixTags.PARTYID_INT);

		
		hasPartyID = FixUtils.TAG_HAS_NO_VALUE;		
		partyID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasPartyIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		ptysSubGrp = new FixPtysSubGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) ptysSubGrp[i] = new FixPtysSubGrp();
		partyAltIDs = new FixPartyAltIDs[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) partyAltIDs[i] = new FixPartyAltIDs();
		contextParties = new FixContextParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) contextParties[i] = new FixContextParties();
		riskLimits = new FixRiskLimits[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) riskLimits[i] = new FixRiskLimits();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasPartyID()) return true;
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
            	case FixTags.PARTYID_INT:		
            		hasPartyID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.PARTYIDSOURCE_INT:		
            		hasPartyIDSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.PARTYROLE_INT:		
            		hasPartyRole = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NOPARTYSUBIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !ptysSubGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = ptysSubGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOPARTYALTIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !partyAltIDs[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = partyAltIDs[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOCONTEXTPARTYIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !contextParties[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = contextParties[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NORISKLIMITS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !riskLimits[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = riskLimits[count].setBuffer( repeatingGroupTag, buf, err);	
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
		hasPartyID = FixUtils.TAG_HAS_NO_VALUE;
		hasPartyIDSource = FixUtils.TAG_HAS_NO_VALUE;
		hasPartyRole = FixUtils.TAG_HAS_NO_VALUE;
		for (FixPtysSubGrp fixPtysSubGrp : ptysSubGrp) fixPtysSubGrp.clear();
		for (FixPartyAltIDs fixPartyAltIDs : partyAltIDs) fixPartyAltIDs.clear();
		for (FixContextParties fixContextParties : contextParties) fixContextParties.clear();
		for (FixRiskLimits fixRiskLimits : riskLimits) fixRiskLimits.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasPartyID()) {		
			out.put(FixTags.PARTYID);

			out.put((byte) '=');

			FixUtils.put(out,partyID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasPartyIDSource()) {		
			out.put(FixTags.PARTYIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,partyIDSource); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasPartyRole()) {		
			out.put(FixTags.PARTYROLE);

			out.put((byte) '=');

			FixUtils.put(out, (long)partyRole);
		
			out.put(FixUtils.SOH);

            }

		for (FixPtysSubGrp fixPtysSubGrp : ptysSubGrp) fixPtysSubGrp.encode(out);
		for (FixPartyAltIDs fixPartyAltIDs : partyAltIDs) fixPartyAltIDs.encode(out);
		for (FixContextParties fixContextParties : contextParties) fixContextParties.encode(out);
		for (FixRiskLimits fixRiskLimits : riskLimits) fixRiskLimits.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasPartyID()) {		
			FixUtils.put(out,partyID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPartyIDSource()) {		
			FixUtils.put(out,partyIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPartyRole()) {		
			FixUtils.put(out, (long)partyRole);
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixPtysSubGrp fixPtysSubGrp : ptysSubGrp) fixPtysSubGrp.printBuffer(out);
		for (FixPartyAltIDs fixPartyAltIDs : partyAltIDs) fixPartyAltIDs.printBuffer(out);
		for (FixContextParties fixContextParties : contextParties) fixContextParties.printBuffer(out);
		for (FixRiskLimits fixRiskLimits : riskLimits) fixRiskLimits.printBuffer(out);
	}

	public byte[] getPartyID() { 		
		if ( hasPartyID()) {		
			if (hasPartyID == FixUtils.TAG_HAS_VALUE) {		
				return partyID; 		
			} else {		
		
				buf.position(hasPartyID);		
		
			FixMessage.getTagStringValue(buf, partyID, 0, partyID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasPartyID);		
					return null;		
				}		
			}		
			hasPartyID = FixUtils.TAG_HAS_VALUE;		
			return partyID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasPartyID() { return hasPartyID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPartyID(byte[] src) {		
		if (src == null ) return;
		if (hasPartyID()) FixUtils.fillSpace(partyID);		
		FixUtils.copy(partyID, src); 		
		hasPartyID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPartyID(String str) {		
		if (str == null ) return;
		if (hasPartyID()) FixUtils.fillSpace(partyID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(partyID, src); 		
		hasPartyID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getPartyIDSource() { 		
		if ( hasPartyIDSource()) {		
			if (hasPartyIDSource == FixUtils.TAG_HAS_VALUE) {		
				return partyIDSource; 		
			} else {		
		
				buf.position(hasPartyIDSource);		
		
			partyIDSource = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (partyIDSource != (byte)'D') && (partyIDSource != (byte)'E') && (partyIDSource != (byte)'F') && (partyIDSource != (byte)'G') && (partyIDSource != (byte)'A') && (partyIDSource != (byte)'B') && (partyIDSource != (byte)'C') && (partyIDSource != (byte)'H') && (partyIDSource != (byte)'I') && (partyIDSource != (byte)'3') && (partyIDSource != (byte)'2') && (partyIDSource != (byte)'1') && (partyIDSource != (byte)'7') && (partyIDSource != (byte)'6') && (partyIDSource != (byte)'5') && (partyIDSource != (byte)'4') && (partyIDSource != (byte)'9') && (partyIDSource != (byte)'8') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 447);		
				if (err.hasError()) {		
					buf.position(hasPartyIDSource);		
					return (byte)'0';		
				}		
			}		
			hasPartyIDSource = FixUtils.TAG_HAS_VALUE;		
			return partyIDSource;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasPartyIDSource() { return hasPartyIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPartyIDSource(byte src) {		
		partyIDSource = src;
		hasPartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPartyIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasPartyIDSource()) partyIDSource = (byte)' ';		
		partyIDSource = src[0];		
		hasPartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPartyIDSource(String str) {		
		if (str == null ) return;
		if (hasPartyIDSource()) partyIDSource = (byte)' ';		
		byte[] src = str.getBytes(); 		
		partyIDSource = src[0];		
		hasPartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getPartyRole() { 		
		if ( hasPartyRole()) {		
			if (hasPartyRole == FixUtils.TAG_HAS_VALUE) {		
				return partyRole; 		
			} else {		
		
				buf.position(hasPartyRole);		
		
			partyRole = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasPartyRole);		
					return 0;		
				}		
			}		
			hasPartyRole = FixUtils.TAG_HAS_VALUE;		
			return partyRole;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPartyRole() { return hasPartyRole != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPartyRole(long src) {		
		partyRole = src;
		hasPartyRole = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPartyRole(byte[] src) {		
		if (src == null ) return;
		if (hasPartyRole()) partyRole = FixUtils.TAG_HAS_NO_VALUE;		
		partyRole = FixUtils.longValueOf(src, 0, src.length);
		hasPartyRole = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPartyRole(String str) {		
		if (str == null ) return;
		if (hasPartyRole()) partyRole = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		partyRole = FixUtils.longValueOf(src, 0, src.length);
		hasPartyRole = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasPartyID()) s += "PartyID(448)= " + new String( FixUtils.trim(getPartyID()) ) + "\n" ; 
		if (hasPartyIDSource()) s += "PartyIDSource(447)= " + getPartyIDSource() + "\n" ; 
		if (hasPartyRole()) s += "PartyRole(452)= " + getPartyRole() + "\n" ; 

		for (FixPtysSubGrp fixPtysSubGrp : ptysSubGrp) fixPtysSubGrp.toString();
		for (FixPartyAltIDs fixPartyAltIDs : partyAltIDs) fixPartyAltIDs.toString();
		for (FixContextParties fixContextParties : contextParties) fixContextParties.toString();
		for (FixRiskLimits fixRiskLimits : riskLimits) fixRiskLimits.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixPartyDetail)) return false;

		FixPartyDetail msg = (FixPartyDetail) o;

		for (FixPtysSubGrp fixPtysSubGrp : ptysSubGrp)
			if (!fixPtysSubGrp.equals(msg.ptysSubGrp)) return false;
		for (FixPartyAltIDs fixPartyAltIDs : partyAltIDs)
			if (!fixPartyAltIDs.equals(msg.partyAltIDs)) return false;
		for (FixContextParties fixContextParties : contextParties)
			if (!fixContextParties.equals(msg.contextParties)) return false;
		for (FixRiskLimits fixRiskLimits : riskLimits)
			if (!fixRiskLimits.equals(msg.riskLimits)) return false;
		if ((hasPartyID() && !msg.hasPartyID()) || (!hasPartyID() && msg.hasPartyID())) return false;
		if (!(!hasPartyID() && !msg.hasPartyID()) && !FixUtils.equals(getPartyID(), msg.getPartyID())) return false;
		if ((hasPartyIDSource() && !msg.hasPartyIDSource()) || (!hasPartyIDSource() && msg.hasPartyIDSource())) return false;
		if (!(!hasPartyIDSource() && !msg.hasPartyIDSource()) && !(getPartyIDSource()==msg.getPartyIDSource())) return false;
		if ((hasPartyRole() && !msg.hasPartyRole()) || (!hasPartyRole() && msg.hasPartyRole())) return false;
		if (!(!hasPartyRole() && !msg.hasPartyRole()) && !(getPartyRole()==msg.getPartyRole())) return false;
		return true;
	}
	public FixPartyDetail clone ( FixPartyDetail out ) {
		if ( hasPartyID())
			out.setPartyID(getPartyID());
		if ( hasPartyIDSource())
			out.setPartyIDSource(getPartyIDSource());
		if ( hasPartyRole())
			out.setPartyRole(getPartyRole());
		int count = 0;
		count = 0;
		for (FixPtysSubGrp fixPtysSubGrp : ptysSubGrp) {
			if (!fixPtysSubGrp.hasGroup()) continue;
			out.ptysSubGrp[count] = fixPtysSubGrp.clone( out.ptysSubGrp[count] );
			count++;
		}
		count = 0;
		for (FixPartyAltIDs fixPartyAltIDs : partyAltIDs) {
			if (!fixPartyAltIDs.hasGroup()) continue;
			out.partyAltIDs[count] = fixPartyAltIDs.clone( out.partyAltIDs[count] );
			count++;
		}
		count = 0;
		for (FixContextParties fixContextParties : contextParties) {
			if (!fixContextParties.hasGroup()) continue;
			out.contextParties[count] = fixContextParties.clone( out.contextParties[count] );
			count++;
		}
		count = 0;
		for (FixRiskLimits fixRiskLimits : riskLimits) {
			if (!fixRiskLimits.hasGroup()) continue;
			out.riskLimits[count] = fixRiskLimits.clone( out.riskLimits[count] );
			count++;
		}
		return out;
	}

}
