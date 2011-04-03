package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixContextParties extends FixGroup {
	private short hasContextPartyID;
	byte[] contextPartyID = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasContextPartyIDSource;
	byte contextPartyIDSource = (byte)' ';		
	private short hasContextPartyRole;
	long contextPartyRole = 0;		
		public FixContextPtysSubGrp[] contextPtysSubGrp;
	
	public FixContextParties() {
		this(false);
	}

	public FixContextParties(boolean isRequired) {
		super(FixTags.CONTEXTPARTYID_INT);

		this.isRequired = isRequired;
		
		hasContextPartyID = FixUtils.TAG_HAS_NO_VALUE;		
		contextPartyID = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasContextPartyIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasContextPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		contextPtysSubGrp = new FixContextPtysSubGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) contextPtysSubGrp[i] = new FixContextPtysSubGrp();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasContextPartyID()) return true;
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
            	case FixTags.CONTEXTPARTYID_INT:		
            		hasContextPartyID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.CONTEXTPARTYIDSOURCE_INT:		
            		hasContextPartyIDSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.CONTEXTPARTYROLE_INT:		
            		hasContextPartyRole = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NOCONTEXTPARTYSUBIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !contextPtysSubGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = contextPtysSubGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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
		hasContextPartyID = FixUtils.TAG_HAS_NO_VALUE;
		hasContextPartyIDSource = FixUtils.TAG_HAS_NO_VALUE;
		hasContextPartyRole = FixUtils.TAG_HAS_NO_VALUE;
		for (FixContextPtysSubGrp fixContextPtysSubGrp : contextPtysSubGrp) fixContextPtysSubGrp.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasContextPartyID()) {		
			out.put(FixTags.CONTEXTPARTYID);

			out.put((byte) '=');

			FixUtils.put(out,contextPartyID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasContextPartyIDSource()) {		
			out.put(FixTags.CONTEXTPARTYIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,contextPartyIDSource); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasContextPartyRole()) {		
			out.put(FixTags.CONTEXTPARTYROLE);

			out.put((byte) '=');

			FixUtils.put(out, (long)contextPartyRole);
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(contextPtysSubGrp)>0) {
			out.put(FixTags.NOCONTEXTPARTYSUBIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(contextPtysSubGrp));

			out.put(FixUtils.SOH);

		}
		for (FixContextPtysSubGrp fixContextPtysSubGrp : contextPtysSubGrp) if (fixContextPtysSubGrp.hasGroup()) fixContextPtysSubGrp.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasContextPartyID()) {		
			FixUtils.put(out,contextPartyID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasContextPartyIDSource()) {		
			FixUtils.put(out,contextPartyIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasContextPartyRole()) {		
			FixUtils.put(out, (long)contextPartyRole);
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixContextPtysSubGrp fixContextPtysSubGrp : contextPtysSubGrp) fixContextPtysSubGrp.printBuffer(out);
	}

	public byte[] getContextPartyID() { 		
		if ( hasContextPartyID()) {		
			if (hasContextPartyID == FixUtils.TAG_HAS_VALUE) {		
				return contextPartyID; 		
			} else {		
		
				buf.position(hasContextPartyID);		
		
			FixMessage.getTagStringValue(buf, contextPartyID, 0, contextPartyID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasContextPartyID);		
					return null;		
				}		
			}		
			hasContextPartyID = FixUtils.TAG_HAS_VALUE;		
			return contextPartyID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasContextPartyID() { return hasContextPartyID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setContextPartyID(byte[] src) {		
		if (src == null ) return;
		if (hasContextPartyID()) FixUtils.fillSpace(contextPartyID);		
		FixUtils.copy(contextPartyID, src); 		
		hasContextPartyID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setContextPartyID(String str) {		
		if (str == null ) return;
		if (hasContextPartyID()) FixUtils.fillSpace(contextPartyID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(contextPartyID, src); 		
		hasContextPartyID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getContextPartyIDSource() { 		
		if ( hasContextPartyIDSource()) {		
			if (hasContextPartyIDSource == FixUtils.TAG_HAS_VALUE) {		
				return contextPartyIDSource; 		
			} else {		
		
				buf.position(hasContextPartyIDSource);		
		
			contextPartyIDSource = FixMessage.getTagCharValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasContextPartyIDSource);		
					return (byte)'0';		
				}		
			}		
			hasContextPartyIDSource = FixUtils.TAG_HAS_VALUE;		
			return contextPartyIDSource;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasContextPartyIDSource() { return hasContextPartyIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setContextPartyIDSource(byte src) {		
		contextPartyIDSource = src;
		hasContextPartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setContextPartyIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasContextPartyIDSource()) contextPartyIDSource = (byte)' ';		
		contextPartyIDSource = src[0];		
		hasContextPartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setContextPartyIDSource(String str) {		
		if (str == null ) return;
		if (hasContextPartyIDSource()) contextPartyIDSource = (byte)' ';		
		byte[] src = str.getBytes(); 		
		contextPartyIDSource = src[0];		
		hasContextPartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getContextPartyRole() { 		
		if ( hasContextPartyRole()) {		
			if (hasContextPartyRole == FixUtils.TAG_HAS_VALUE) {		
				return contextPartyRole; 		
			} else {		
		
				buf.position(hasContextPartyRole);		
		
			contextPartyRole = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasContextPartyRole);		
					return 0;		
				}		
			}		
			hasContextPartyRole = FixUtils.TAG_HAS_VALUE;		
			return contextPartyRole;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasContextPartyRole() { return hasContextPartyRole != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setContextPartyRole(long src) {		
		contextPartyRole = src;
		hasContextPartyRole = FixUtils.TAG_HAS_VALUE;		
	}

	public void setContextPartyRole(byte[] src) {		
		if (src == null ) return;
		if (hasContextPartyRole()) contextPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		contextPartyRole = FixUtils.longValueOf(src, 0, src.length);
		hasContextPartyRole = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setContextPartyRole(String str) {		
		if (str == null ) return;
		if (hasContextPartyRole()) contextPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		contextPartyRole = FixUtils.longValueOf(src, 0, src.length);
		hasContextPartyRole = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasContextPartyID()) s += "ContextPartyID(1523)= " + new String( FixUtils.trim(getContextPartyID()) ) + "\n" ; 
		if (hasContextPartyIDSource()) s += "ContextPartyIDSource(1524)= " + getContextPartyIDSource() + "\n" ; 
		if (hasContextPartyRole()) s += "ContextPartyRole(1525)= " + getContextPartyRole() + "\n" ; 

		for (FixContextPtysSubGrp fixContextPtysSubGrp : contextPtysSubGrp) fixContextPtysSubGrp.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixContextParties)) return false;

		FixContextParties msg = (FixContextParties) o;

		for (int i = 0; i < contextPtysSubGrp.length; i++)
			if (!contextPtysSubGrp[i].equals(msg.contextPtysSubGrp[i])) return false;
		if ((hasContextPartyID() && !msg.hasContextPartyID()) || (!hasContextPartyID() && msg.hasContextPartyID())) return false;
		if (!(!hasContextPartyID() && !msg.hasContextPartyID()) && !FixUtils.equals(getContextPartyID(), msg.getContextPartyID())) return false;
		if ((hasContextPartyIDSource() && !msg.hasContextPartyIDSource()) || (!hasContextPartyIDSource() && msg.hasContextPartyIDSource())) return false;
		if (!(!hasContextPartyIDSource() && !msg.hasContextPartyIDSource()) && !(getContextPartyIDSource()==msg.getContextPartyIDSource())) return false;
		if ((hasContextPartyRole() && !msg.hasContextPartyRole()) || (!hasContextPartyRole() && msg.hasContextPartyRole())) return false;
		if (!(!hasContextPartyRole() && !msg.hasContextPartyRole()) && !(getContextPartyRole()==msg.getContextPartyRole())) return false;
		return true;
	}
	public FixContextParties clone ( FixContextParties out ) {
		if ( hasContextPartyID())
			out.setContextPartyID(getContextPartyID());
		if ( hasContextPartyIDSource())
			out.setContextPartyIDSource(getContextPartyIDSource());
		if ( hasContextPartyRole())
			out.setContextPartyRole(getContextPartyRole());
		int count = 0;
		count = 0;
		for (FixContextPtysSubGrp fixContextPtysSubGrp : contextPtysSubGrp) {
			if (!fixContextPtysSubGrp.hasGroup()) continue;
			out.contextPtysSubGrp[count] = fixContextPtysSubGrp.clone( out.contextPtysSubGrp[count] );
			count++;
		}
		return out;
	}

}
