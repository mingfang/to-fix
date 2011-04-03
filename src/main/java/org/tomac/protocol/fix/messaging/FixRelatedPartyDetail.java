package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixRelatedPartyDetail extends FixGroup {
	private short hasRelatedPartyID;
	byte[] relatedPartyID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRelatedPartyIDSource;
	byte relatedPartyIDSource = (byte)' ';		
	private short hasRelatedPartyRole;
	long relatedPartyRole = 0;		
		public FixRelatedPtysSubGrp[] relatedPtysSubGrp;
		public FixRelatedPartyAltIDs[] relatedPartyAltIDs;
		public FixRelatedContextParties[] relatedContextParties;
		public FixRelationshipRiskLimits[] relationshipRiskLimits;
	
	public FixRelatedPartyDetail() {
		this(false);
	}

	public FixRelatedPartyDetail(boolean isRequired) {
		super(FixTags.RELATEDPARTYID_INT);

		this.isRequired = isRequired;
		
		hasRelatedPartyID = FixUtils.TAG_HAS_NO_VALUE;		
		relatedPartyID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRelatedPartyIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasRelatedPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		relatedPtysSubGrp = new FixRelatedPtysSubGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) relatedPtysSubGrp[i] = new FixRelatedPtysSubGrp();
		relatedPartyAltIDs = new FixRelatedPartyAltIDs[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) relatedPartyAltIDs[i] = new FixRelatedPartyAltIDs();
		relatedContextParties = new FixRelatedContextParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) relatedContextParties[i] = new FixRelatedContextParties();
		relationshipRiskLimits = new FixRelationshipRiskLimits[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) relationshipRiskLimits[i] = new FixRelationshipRiskLimits();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasRelatedPartyID()) return true;
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
            	case FixTags.RELATEDPARTYID_INT:		
            		hasRelatedPartyID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATEDPARTYIDSOURCE_INT:		
            		hasRelatedPartyIDSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATEDPARTYROLE_INT:		
            		hasRelatedPartyRole = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NORELATEDPARTYSUBIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !relatedPtysSubGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = relatedPtysSubGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NORELATEDPARTYALTIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !relatedPartyAltIDs[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = relatedPartyAltIDs[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NORELATEDCONTEXTPARTYIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !relatedContextParties[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = relatedContextParties[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NORELATIONSHIPRISKLIMITS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !relationshipRiskLimits[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = relationshipRiskLimits[count].setBuffer( repeatingGroupTag, buf, err);	
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
		hasRelatedPartyID = FixUtils.TAG_HAS_NO_VALUE;
		hasRelatedPartyIDSource = FixUtils.TAG_HAS_NO_VALUE;
		hasRelatedPartyRole = FixUtils.TAG_HAS_NO_VALUE;
		for (FixRelatedPtysSubGrp fixRelatedPtysSubGrp : relatedPtysSubGrp) fixRelatedPtysSubGrp.clear();
		for (FixRelatedPartyAltIDs fixRelatedPartyAltIDs : relatedPartyAltIDs) fixRelatedPartyAltIDs.clear();
		for (FixRelatedContextParties fixRelatedContextParties : relatedContextParties) fixRelatedContextParties.clear();
		for (FixRelationshipRiskLimits fixRelationshipRiskLimits : relationshipRiskLimits) fixRelationshipRiskLimits.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasRelatedPartyID()) {		
			out.put(FixTags.RELATEDPARTYID);

			out.put((byte) '=');

			FixUtils.put(out,relatedPartyID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRelatedPartyIDSource()) {		
			out.put(FixTags.RELATEDPARTYIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,relatedPartyIDSource); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRelatedPartyRole()) {		
			out.put(FixTags.RELATEDPARTYROLE);

			out.put((byte) '=');

			FixUtils.put(out, (long)relatedPartyRole);
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(relatedPtysSubGrp)>0) {
			out.put(FixTags.NORELATEDPARTYSUBIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(relatedPtysSubGrp));

			out.put(FixUtils.SOH);

		}
		for (FixRelatedPtysSubGrp fixRelatedPtysSubGrp : relatedPtysSubGrp) if (fixRelatedPtysSubGrp.hasGroup()) fixRelatedPtysSubGrp.encode(out);
		if (FixUtils.getNoInGroup(relatedPartyAltIDs)>0) {
			out.put(FixTags.NORELATEDPARTYALTIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(relatedPartyAltIDs));

			out.put(FixUtils.SOH);

		}
		for (FixRelatedPartyAltIDs fixRelatedPartyAltIDs : relatedPartyAltIDs) if (fixRelatedPartyAltIDs.hasGroup()) fixRelatedPartyAltIDs.encode(out);
		if (FixUtils.getNoInGroup(relatedContextParties)>0) {
			out.put(FixTags.NORELATEDCONTEXTPARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(relatedContextParties));

			out.put(FixUtils.SOH);

		}
		for (FixRelatedContextParties fixRelatedContextParties : relatedContextParties) if (fixRelatedContextParties.hasGroup()) fixRelatedContextParties.encode(out);
		if (FixUtils.getNoInGroup(relationshipRiskLimits)>0) {
			out.put(FixTags.NORELATIONSHIPRISKLIMITS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(relationshipRiskLimits));

			out.put(FixUtils.SOH);

		}
		for (FixRelationshipRiskLimits fixRelationshipRiskLimits : relationshipRiskLimits) if (fixRelationshipRiskLimits.hasGroup()) fixRelationshipRiskLimits.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasRelatedPartyID()) {		
			FixUtils.put(out,relatedPartyID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelatedPartyIDSource()) {		
			FixUtils.put(out,relatedPartyIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelatedPartyRole()) {		
			FixUtils.put(out, (long)relatedPartyRole);
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixRelatedPtysSubGrp fixRelatedPtysSubGrp : relatedPtysSubGrp) fixRelatedPtysSubGrp.printBuffer(out);
		for (FixRelatedPartyAltIDs fixRelatedPartyAltIDs : relatedPartyAltIDs) fixRelatedPartyAltIDs.printBuffer(out);
		for (FixRelatedContextParties fixRelatedContextParties : relatedContextParties) fixRelatedContextParties.printBuffer(out);
		for (FixRelationshipRiskLimits fixRelationshipRiskLimits : relationshipRiskLimits) fixRelationshipRiskLimits.printBuffer(out);
	}

	public byte[] getRelatedPartyID() { 		
		if ( hasRelatedPartyID()) {		
			if (hasRelatedPartyID == FixUtils.TAG_HAS_VALUE) {		
				return relatedPartyID; 		
			} else {		
		
				buf.position(hasRelatedPartyID);		
		
			FixMessage.getTagStringValue(buf, relatedPartyID, 0, relatedPartyID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRelatedPartyID);		
					return null;		
				}		
			}		
			hasRelatedPartyID = FixUtils.TAG_HAS_VALUE;		
			return relatedPartyID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRelatedPartyID() { return hasRelatedPartyID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelatedPartyID(byte[] src) {		
		if (src == null ) return;
		if (hasRelatedPartyID()) FixUtils.fillSpace(relatedPartyID);		
		FixUtils.copy(relatedPartyID, src); 		
		hasRelatedPartyID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelatedPartyID(String str) {		
		if (str == null ) return;
		if (hasRelatedPartyID()) FixUtils.fillSpace(relatedPartyID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(relatedPartyID, src); 		
		hasRelatedPartyID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getRelatedPartyIDSource() { 		
		if ( hasRelatedPartyIDSource()) {		
			if (hasRelatedPartyIDSource == FixUtils.TAG_HAS_VALUE) {		
				return relatedPartyIDSource; 		
			} else {		
		
				buf.position(hasRelatedPartyIDSource);		
		
			relatedPartyIDSource = FixMessage.getTagCharValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRelatedPartyIDSource);		
					return (byte)'0';		
				}		
			}		
			hasRelatedPartyIDSource = FixUtils.TAG_HAS_VALUE;		
			return relatedPartyIDSource;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasRelatedPartyIDSource() { return hasRelatedPartyIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelatedPartyIDSource(byte src) {		
		relatedPartyIDSource = src;
		hasRelatedPartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRelatedPartyIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasRelatedPartyIDSource()) relatedPartyIDSource = (byte)' ';		
		relatedPartyIDSource = src[0];		
		hasRelatedPartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelatedPartyIDSource(String str) {		
		if (str == null ) return;
		if (hasRelatedPartyIDSource()) relatedPartyIDSource = (byte)' ';		
		byte[] src = str.getBytes(); 		
		relatedPartyIDSource = src[0];		
		hasRelatedPartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getRelatedPartyRole() { 		
		if ( hasRelatedPartyRole()) {		
			if (hasRelatedPartyRole == FixUtils.TAG_HAS_VALUE) {		
				return relatedPartyRole; 		
			} else {		
		
				buf.position(hasRelatedPartyRole);		
		
			relatedPartyRole = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRelatedPartyRole);		
					return 0;		
				}		
			}		
			hasRelatedPartyRole = FixUtils.TAG_HAS_VALUE;		
			return relatedPartyRole;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRelatedPartyRole() { return hasRelatedPartyRole != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelatedPartyRole(long src) {		
		relatedPartyRole = src;
		hasRelatedPartyRole = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRelatedPartyRole(byte[] src) {		
		if (src == null ) return;
		if (hasRelatedPartyRole()) relatedPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		relatedPartyRole = FixUtils.longValueOf(src, 0, src.length);
		hasRelatedPartyRole = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelatedPartyRole(String str) {		
		if (str == null ) return;
		if (hasRelatedPartyRole()) relatedPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		relatedPartyRole = FixUtils.longValueOf(src, 0, src.length);
		hasRelatedPartyRole = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasRelatedPartyID()) s += "RelatedPartyID(1563)= " + new String( FixUtils.trim(getRelatedPartyID()) ) + "\n" ; 
		if (hasRelatedPartyIDSource()) s += "RelatedPartyIDSource(1564)= " + getRelatedPartyIDSource() + "\n" ; 
		if (hasRelatedPartyRole()) s += "RelatedPartyRole(1565)= " + getRelatedPartyRole() + "\n" ; 

		for (FixRelatedPtysSubGrp fixRelatedPtysSubGrp : relatedPtysSubGrp) fixRelatedPtysSubGrp.toString();
		for (FixRelatedPartyAltIDs fixRelatedPartyAltIDs : relatedPartyAltIDs) fixRelatedPartyAltIDs.toString();
		for (FixRelatedContextParties fixRelatedContextParties : relatedContextParties) fixRelatedContextParties.toString();
		for (FixRelationshipRiskLimits fixRelationshipRiskLimits : relationshipRiskLimits) fixRelationshipRiskLimits.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixRelatedPartyDetail)) return false;

		FixRelatedPartyDetail msg = (FixRelatedPartyDetail) o;

		for (int i = 0; i < relatedPtysSubGrp.length; i++)
			if (!relatedPtysSubGrp[i].equals(msg.relatedPtysSubGrp[i])) return false;
		for (int i = 0; i < relatedPartyAltIDs.length; i++)
			if (!relatedPartyAltIDs[i].equals(msg.relatedPartyAltIDs[i])) return false;
		for (int i = 0; i < relatedContextParties.length; i++)
			if (!relatedContextParties[i].equals(msg.relatedContextParties[i])) return false;
		for (int i = 0; i < relationshipRiskLimits.length; i++)
			if (!relationshipRiskLimits[i].equals(msg.relationshipRiskLimits[i])) return false;
		if ((hasRelatedPartyID() && !msg.hasRelatedPartyID()) || (!hasRelatedPartyID() && msg.hasRelatedPartyID())) return false;
		if (!(!hasRelatedPartyID() && !msg.hasRelatedPartyID()) && !FixUtils.equals(getRelatedPartyID(), msg.getRelatedPartyID())) return false;
		if ((hasRelatedPartyIDSource() && !msg.hasRelatedPartyIDSource()) || (!hasRelatedPartyIDSource() && msg.hasRelatedPartyIDSource())) return false;
		if (!(!hasRelatedPartyIDSource() && !msg.hasRelatedPartyIDSource()) && !(getRelatedPartyIDSource()==msg.getRelatedPartyIDSource())) return false;
		if ((hasRelatedPartyRole() && !msg.hasRelatedPartyRole()) || (!hasRelatedPartyRole() && msg.hasRelatedPartyRole())) return false;
		if (!(!hasRelatedPartyRole() && !msg.hasRelatedPartyRole()) && !(getRelatedPartyRole()==msg.getRelatedPartyRole())) return false;
		return true;
	}
	public FixRelatedPartyDetail clone ( FixRelatedPartyDetail out ) {
		if ( hasRelatedPartyID())
			out.setRelatedPartyID(getRelatedPartyID());
		if ( hasRelatedPartyIDSource())
			out.setRelatedPartyIDSource(getRelatedPartyIDSource());
		if ( hasRelatedPartyRole())
			out.setRelatedPartyRole(getRelatedPartyRole());
		int count = 0;
		count = 0;
		for (FixRelatedPtysSubGrp fixRelatedPtysSubGrp : relatedPtysSubGrp) {
			if (!fixRelatedPtysSubGrp.hasGroup()) continue;
			out.relatedPtysSubGrp[count] = fixRelatedPtysSubGrp.clone( out.relatedPtysSubGrp[count] );
			count++;
		}
		count = 0;
		for (FixRelatedPartyAltIDs fixRelatedPartyAltIDs : relatedPartyAltIDs) {
			if (!fixRelatedPartyAltIDs.hasGroup()) continue;
			out.relatedPartyAltIDs[count] = fixRelatedPartyAltIDs.clone( out.relatedPartyAltIDs[count] );
			count++;
		}
		count = 0;
		for (FixRelatedContextParties fixRelatedContextParties : relatedContextParties) {
			if (!fixRelatedContextParties.hasGroup()) continue;
			out.relatedContextParties[count] = fixRelatedContextParties.clone( out.relatedContextParties[count] );
			count++;
		}
		count = 0;
		for (FixRelationshipRiskLimits fixRelationshipRiskLimits : relationshipRiskLimits) {
			if (!fixRelationshipRiskLimits.hasGroup()) continue;
			out.relationshipRiskLimits[count] = fixRelationshipRiskLimits.clone( out.relationshipRiskLimits[count] );
			count++;
		}
		return out;
	}

}
