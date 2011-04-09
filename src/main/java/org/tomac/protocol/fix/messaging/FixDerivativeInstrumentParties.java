package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixDerivativeInstrumentParties extends FixGroup {
	private short hasDerivativeInstrumentPartyID;
	byte[] derivativeInstrumentPartyID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDerivativeInstrumentPartyIDSource;
	byte[] derivativeInstrumentPartyIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDerivativeInstrumentPartyRole;
	long derivativeInstrumentPartyRole = 0;		
		public FixDerivativeInstrumentPartySubIDsGrp[] derivativeInstrumentPartySubIDsGrp;
	
	public FixDerivativeInstrumentParties() {
		this(false);
	}

	public FixDerivativeInstrumentParties(boolean isRequired) {
		super(FixTags.DERIVATIVEINSTRUMENTPARTYID_INT);

		this.isRequired = isRequired;
		
		hasDerivativeInstrumentPartyID = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeInstrumentPartyID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDerivativeInstrumentPartyIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeInstrumentPartyIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDerivativeInstrumentPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeInstrumentPartySubIDsGrp = new FixDerivativeInstrumentPartySubIDsGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) derivativeInstrumentPartySubIDsGrp[i] = new FixDerivativeInstrumentPartySubIDsGrp();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasDerivativeInstrumentPartyID()) return true;
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
            	case FixTags.DERIVATIVEINSTRUMENTPARTYID_INT:		
            		hasDerivativeInstrumentPartyID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEINSTRUMENTPARTYIDSOURCE_INT:		
            		hasDerivativeInstrumentPartyIDSource = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.DERIVATIVEINSTRUMENTPARTYROLE_INT:		
            		hasDerivativeInstrumentPartyRole = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NODERIVATIVEINSTRUMENTPARTYSUBIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !derivativeInstrumentPartySubIDsGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NODERIVATIVEINSTRUMENTPARTYSUBIDS_INT);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = derivativeInstrumentPartySubIDsGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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
		hasDerivativeInstrumentPartyID = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeInstrumentPartyIDSource = FixUtils.TAG_HAS_NO_VALUE;
		hasDerivativeInstrumentPartyRole = FixUtils.TAG_HAS_NO_VALUE;
		for (FixDerivativeInstrumentPartySubIDsGrp fixDerivativeInstrumentPartySubIDsGrp : derivativeInstrumentPartySubIDsGrp) fixDerivativeInstrumentPartySubIDsGrp.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasDerivativeInstrumentPartyID()) {		
			out.put(FixTags.DERIVATIVEINSTRUMENTPARTYID);

			out.put((byte) '=');

			FixUtils.put(out,derivativeInstrumentPartyID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeInstrumentPartyIDSource()) {		
			out.put(FixTags.DERIVATIVEINSTRUMENTPARTYIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,derivativeInstrumentPartyIDSource); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDerivativeInstrumentPartyRole()) {		
			out.put(FixTags.DERIVATIVEINSTRUMENTPARTYROLE);

			out.put((byte) '=');

			FixUtils.put(out, (long)derivativeInstrumentPartyRole);
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(derivativeInstrumentPartySubIDsGrp)>0) {
			out.put(FixTags.NODERIVATIVEINSTRUMENTPARTYSUBIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(derivativeInstrumentPartySubIDsGrp));

			out.put(FixUtils.SOH);

		}
		for (FixDerivativeInstrumentPartySubIDsGrp fixDerivativeInstrumentPartySubIDsGrp : derivativeInstrumentPartySubIDsGrp) if (fixDerivativeInstrumentPartySubIDsGrp.hasGroup()) fixDerivativeInstrumentPartySubIDsGrp.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasDerivativeInstrumentPartyID()) {		
			FixUtils.put(out,derivativeInstrumentPartyID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeInstrumentPartyIDSource()) {		
			FixUtils.put(out,derivativeInstrumentPartyIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDerivativeInstrumentPartyRole()) {		
			FixUtils.put(out, (long)derivativeInstrumentPartyRole);
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixDerivativeInstrumentPartySubIDsGrp fixDerivativeInstrumentPartySubIDsGrp : derivativeInstrumentPartySubIDsGrp) fixDerivativeInstrumentPartySubIDsGrp.printBuffer(out);
	}

	public byte[] getDerivativeInstrumentPartyID() { 		
		if ( hasDerivativeInstrumentPartyID()) {		
			if (hasDerivativeInstrumentPartyID == FixUtils.TAG_HAS_VALUE) {		
				return derivativeInstrumentPartyID; 		
			} else {		
		
				buf.position(hasDerivativeInstrumentPartyID);		
		
			FixUtils.getTagStringValue(buf, derivativeInstrumentPartyID, 0, derivativeInstrumentPartyID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeInstrumentPartyID);		
					return null;		
				}		
			}		
			hasDerivativeInstrumentPartyID = FixUtils.TAG_HAS_VALUE;		
			return derivativeInstrumentPartyID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeInstrumentPartyID() { return hasDerivativeInstrumentPartyID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeInstrumentPartyID(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeInstrumentPartyID()) FixUtils.fillNul(derivativeInstrumentPartyID);		
		FixUtils.copy(derivativeInstrumentPartyID, src); 		
		hasDerivativeInstrumentPartyID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeInstrumentPartyID(String str) {		
		if (str == null ) return;
		if (hasDerivativeInstrumentPartyID()) FixUtils.fillNul(derivativeInstrumentPartyID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeInstrumentPartyID, src); 		
		hasDerivativeInstrumentPartyID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getDerivativeInstrumentPartyIDSource() { 		
		if ( hasDerivativeInstrumentPartyIDSource()) {		
			if (hasDerivativeInstrumentPartyIDSource == FixUtils.TAG_HAS_VALUE) {		
				return derivativeInstrumentPartyIDSource; 		
			} else {		
		
				buf.position(hasDerivativeInstrumentPartyIDSource);		
		
			FixUtils.getTagStringValue(buf, derivativeInstrumentPartyIDSource, 0, derivativeInstrumentPartyIDSource.length, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeInstrumentPartyIDSource);		
					return null;		
				}		
			}		
			hasDerivativeInstrumentPartyIDSource = FixUtils.TAG_HAS_VALUE;		
			return derivativeInstrumentPartyIDSource;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDerivativeInstrumentPartyIDSource() { return hasDerivativeInstrumentPartyIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeInstrumentPartyIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeInstrumentPartyIDSource()) FixUtils.fillNul(derivativeInstrumentPartyIDSource);		
		FixUtils.copy(derivativeInstrumentPartyIDSource, src); 		
		hasDerivativeInstrumentPartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeInstrumentPartyIDSource(String str) {		
		if (str == null ) return;
		if (hasDerivativeInstrumentPartyIDSource()) FixUtils.fillNul(derivativeInstrumentPartyIDSource);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(derivativeInstrumentPartyIDSource, src); 		
		hasDerivativeInstrumentPartyIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDerivativeInstrumentPartyRole() { 		
		if ( hasDerivativeInstrumentPartyRole()) {		
			if (hasDerivativeInstrumentPartyRole == FixUtils.TAG_HAS_VALUE) {		
				return derivativeInstrumentPartyRole; 		
			} else {		
		
				buf.position(hasDerivativeInstrumentPartyRole);		
		
			derivativeInstrumentPartyRole = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDerivativeInstrumentPartyRole);		
					return 0;		
				}		
			}		
			hasDerivativeInstrumentPartyRole = FixUtils.TAG_HAS_VALUE;		
			return derivativeInstrumentPartyRole;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDerivativeInstrumentPartyRole() { return hasDerivativeInstrumentPartyRole != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDerivativeInstrumentPartyRole(long src) {		
		derivativeInstrumentPartyRole = src;
		hasDerivativeInstrumentPartyRole = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDerivativeInstrumentPartyRole(byte[] src) {		
		if (src == null ) return;
		if (hasDerivativeInstrumentPartyRole()) derivativeInstrumentPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		derivativeInstrumentPartyRole = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeInstrumentPartyRole = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDerivativeInstrumentPartyRole(String str) {		
		if (str == null ) return;
		if (hasDerivativeInstrumentPartyRole()) derivativeInstrumentPartyRole = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		derivativeInstrumentPartyRole = FixUtils.longValueOf(src, 0, src.length);
		hasDerivativeInstrumentPartyRole = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasDerivativeInstrumentPartyID()) s += "DerivativeInstrumentPartyID(1293)= " + new String( FixUtils.trim(getDerivativeInstrumentPartyID()) ) + "\n" ; 
		if (hasDerivativeInstrumentPartyIDSource()) s += "DerivativeInstrumentPartyIDSource(1294)= " + new String( FixUtils.trim(getDerivativeInstrumentPartyIDSource()) ) + "\n" ; 
		if (hasDerivativeInstrumentPartyRole()) s += "DerivativeInstrumentPartyRole(1295)= " + getDerivativeInstrumentPartyRole() + "\n" ; 

		for (FixDerivativeInstrumentPartySubIDsGrp fixDerivativeInstrumentPartySubIDsGrp : derivativeInstrumentPartySubIDsGrp) fixDerivativeInstrumentPartySubIDsGrp.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixDerivativeInstrumentParties)) return false;

		FixDerivativeInstrumentParties msg = (FixDerivativeInstrumentParties) o;

		for (int i = 0; i < derivativeInstrumentPartySubIDsGrp.length; i++)
			if (!derivativeInstrumentPartySubIDsGrp[i].equals(msg.derivativeInstrumentPartySubIDsGrp[i])) return false;
		if ((hasDerivativeInstrumentPartyID() && !msg.hasDerivativeInstrumentPartyID()) || (!hasDerivativeInstrumentPartyID() && msg.hasDerivativeInstrumentPartyID())) return false;
		if (!(!hasDerivativeInstrumentPartyID() && !msg.hasDerivativeInstrumentPartyID()) && !FixUtils.equals(getDerivativeInstrumentPartyID(), msg.getDerivativeInstrumentPartyID())) return false;
		if ((hasDerivativeInstrumentPartyIDSource() && !msg.hasDerivativeInstrumentPartyIDSource()) || (!hasDerivativeInstrumentPartyIDSource() && msg.hasDerivativeInstrumentPartyIDSource())) return false;
		if (!(!hasDerivativeInstrumentPartyIDSource() && !msg.hasDerivativeInstrumentPartyIDSource()) && !FixUtils.equals(getDerivativeInstrumentPartyIDSource(), msg.getDerivativeInstrumentPartyIDSource())) return false;
		if ((hasDerivativeInstrumentPartyRole() && !msg.hasDerivativeInstrumentPartyRole()) || (!hasDerivativeInstrumentPartyRole() && msg.hasDerivativeInstrumentPartyRole())) return false;
		if (!(!hasDerivativeInstrumentPartyRole() && !msg.hasDerivativeInstrumentPartyRole()) && !(getDerivativeInstrumentPartyRole()==msg.getDerivativeInstrumentPartyRole())) return false;
		return true;
	}
	public FixDerivativeInstrumentParties clone ( FixDerivativeInstrumentParties out ) {
		if ( hasDerivativeInstrumentPartyID())
			out.setDerivativeInstrumentPartyID(getDerivativeInstrumentPartyID());
		if ( hasDerivativeInstrumentPartyIDSource())
			out.setDerivativeInstrumentPartyIDSource(getDerivativeInstrumentPartyIDSource());
		if ( hasDerivativeInstrumentPartyRole())
			out.setDerivativeInstrumentPartyRole(getDerivativeInstrumentPartyRole());
		int count = 0;
		count = 0;
		for (FixDerivativeInstrumentPartySubIDsGrp fixDerivativeInstrumentPartySubIDsGrp : derivativeInstrumentPartySubIDsGrp) {
			if (!fixDerivativeInstrumentPartySubIDsGrp.hasGroup()) continue;
			out.derivativeInstrumentPartySubIDsGrp[count] = fixDerivativeInstrumentPartySubIDsGrp.clone( out.derivativeInstrumentPartySubIDsGrp[count] );
			count++;
		}
		return out;
	}

}
