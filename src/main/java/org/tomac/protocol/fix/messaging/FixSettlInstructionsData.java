package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixSettlInstructionsData extends FixGroup {
	private short hasSettlDeliveryType;
	long settlDeliveryType = 0;		
	private short hasStandInstDbType;
	long standInstDbType = 0;		
	private short hasStandInstDbName;
	byte[] standInstDbName = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasStandInstDbID;
	byte[] standInstDbID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		public FixDlvyInstGrp[] dlvyInstGrp;
	
	public FixSettlInstructionsData() {
		this(false);
	}

	public FixSettlInstructionsData(boolean isRequired) {
		super(FixTags.SETTLDELIVERYTYPE_INT);

		this.isRequired = isRequired;
		
		hasSettlDeliveryType = FixUtils.TAG_HAS_NO_VALUE;		
		hasStandInstDbType = FixUtils.TAG_HAS_NO_VALUE;		
		hasStandInstDbName = FixUtils.TAG_HAS_NO_VALUE;		
		standInstDbName = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasStandInstDbID = FixUtils.TAG_HAS_NO_VALUE;		
		standInstDbID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		dlvyInstGrp = new FixDlvyInstGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) dlvyInstGrp[i] = new FixDlvyInstGrp();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasSettlDeliveryType()) return true;
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
            	case FixTags.SETTLDELIVERYTYPE_INT:		
            		hasSettlDeliveryType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.STANDINSTDBTYPE_INT:		
            		hasStandInstDbType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.STANDINSTDBNAME_INT:		
            		hasStandInstDbName = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.STANDINSTDBID_INT:		
            		hasStandInstDbID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NODLVYINST_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !dlvyInstGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = dlvyInstGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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
		hasSettlDeliveryType = FixUtils.TAG_HAS_NO_VALUE;
		hasStandInstDbType = FixUtils.TAG_HAS_NO_VALUE;
		hasStandInstDbName = FixUtils.TAG_HAS_NO_VALUE;
		hasStandInstDbID = FixUtils.TAG_HAS_NO_VALUE;
		for (FixDlvyInstGrp fixDlvyInstGrp : dlvyInstGrp) fixDlvyInstGrp.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasSettlDeliveryType()) {		
			out.put(FixTags.SETTLDELIVERYTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)settlDeliveryType);
		
			out.put(FixUtils.SOH);

            }

		if (hasStandInstDbType()) {		
			out.put(FixTags.STANDINSTDBTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)standInstDbType);
		
			out.put(FixUtils.SOH);

            }

		if (hasStandInstDbName()) {		
			out.put(FixTags.STANDINSTDBNAME);

			out.put((byte) '=');

			FixUtils.put(out,standInstDbName); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasStandInstDbID()) {		
			out.put(FixTags.STANDINSTDBID);

			out.put((byte) '=');

			FixUtils.put(out,standInstDbID); 		
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(dlvyInstGrp)>0) {
			out.put(FixTags.NODLVYINST);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(dlvyInstGrp));

			out.put(FixUtils.SOH);

		}
		for (FixDlvyInstGrp fixDlvyInstGrp : dlvyInstGrp) if (fixDlvyInstGrp.hasGroup()) fixDlvyInstGrp.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasSettlDeliveryType()) {		
			FixUtils.put(out, (long)settlDeliveryType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasStandInstDbType()) {		
			FixUtils.put(out, (long)standInstDbType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasStandInstDbName()) {		
			FixUtils.put(out,standInstDbName); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasStandInstDbID()) {		
			FixUtils.put(out,standInstDbID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixDlvyInstGrp fixDlvyInstGrp : dlvyInstGrp) fixDlvyInstGrp.printBuffer(out);
	}

	public long getSettlDeliveryType() { 		
		if ( hasSettlDeliveryType()) {		
			if (hasSettlDeliveryType == FixUtils.TAG_HAS_VALUE) {		
				return settlDeliveryType; 		
			} else {		
		
				buf.position(hasSettlDeliveryType);		
		
			settlDeliveryType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasSettlDeliveryType);		
					return 0;		
				}		
			}		
			hasSettlDeliveryType = FixUtils.TAG_HAS_VALUE;		
			return settlDeliveryType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSettlDeliveryType() { return hasSettlDeliveryType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSettlDeliveryType(long src) {		
		settlDeliveryType = src;
		hasSettlDeliveryType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlDeliveryType(byte[] src) {		
		if (src == null ) return;
		if (hasSettlDeliveryType()) settlDeliveryType = FixUtils.TAG_HAS_NO_VALUE;		
		settlDeliveryType = FixUtils.longValueOf(src, 0, src.length);
		hasSettlDeliveryType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSettlDeliveryType(String str) {		
		if (str == null ) return;
		if (hasSettlDeliveryType()) settlDeliveryType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		settlDeliveryType = FixUtils.longValueOf(src, 0, src.length);
		hasSettlDeliveryType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getStandInstDbType() { 		
		if ( hasStandInstDbType()) {		
			if (hasStandInstDbType == FixUtils.TAG_HAS_VALUE) {		
				return standInstDbType; 		
			} else {		
		
				buf.position(hasStandInstDbType);		
		
			standInstDbType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasStandInstDbType);		
					return 0;		
				}		
			}		
			hasStandInstDbType = FixUtils.TAG_HAS_VALUE;		
			return standInstDbType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasStandInstDbType() { return hasStandInstDbType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setStandInstDbType(long src) {		
		standInstDbType = src;
		hasStandInstDbType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStandInstDbType(byte[] src) {		
		if (src == null ) return;
		if (hasStandInstDbType()) standInstDbType = FixUtils.TAG_HAS_NO_VALUE;		
		standInstDbType = FixUtils.longValueOf(src, 0, src.length);
		hasStandInstDbType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setStandInstDbType(String str) {		
		if (str == null ) return;
		if (hasStandInstDbType()) standInstDbType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		standInstDbType = FixUtils.longValueOf(src, 0, src.length);
		hasStandInstDbType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getStandInstDbName() { 		
		if ( hasStandInstDbName()) {		
			if (hasStandInstDbName == FixUtils.TAG_HAS_VALUE) {		
				return standInstDbName; 		
			} else {		
		
				buf.position(hasStandInstDbName);		
		
			FixMessage.getTagStringValue(buf, standInstDbName, 0, standInstDbName.length, err);
		
				if (err.hasError()) {		
					buf.position(hasStandInstDbName);		
					return null;		
				}		
			}		
			hasStandInstDbName = FixUtils.TAG_HAS_VALUE;		
			return standInstDbName;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasStandInstDbName() { return hasStandInstDbName != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setStandInstDbName(byte[] src) {		
		if (src == null ) return;
		if (hasStandInstDbName()) FixUtils.fillSpace(standInstDbName);		
		FixUtils.copy(standInstDbName, src); 		
		hasStandInstDbName = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setStandInstDbName(String str) {		
		if (str == null ) return;
		if (hasStandInstDbName()) FixUtils.fillSpace(standInstDbName);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(standInstDbName, src); 		
		hasStandInstDbName = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getStandInstDbID() { 		
		if ( hasStandInstDbID()) {		
			if (hasStandInstDbID == FixUtils.TAG_HAS_VALUE) {		
				return standInstDbID; 		
			} else {		
		
				buf.position(hasStandInstDbID);		
		
			FixMessage.getTagStringValue(buf, standInstDbID, 0, standInstDbID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasStandInstDbID);		
					return null;		
				}		
			}		
			hasStandInstDbID = FixUtils.TAG_HAS_VALUE;		
			return standInstDbID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasStandInstDbID() { return hasStandInstDbID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setStandInstDbID(byte[] src) {		
		if (src == null ) return;
		if (hasStandInstDbID()) FixUtils.fillSpace(standInstDbID);		
		FixUtils.copy(standInstDbID, src); 		
		hasStandInstDbID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setStandInstDbID(String str) {		
		if (str == null ) return;
		if (hasStandInstDbID()) FixUtils.fillSpace(standInstDbID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(standInstDbID, src); 		
		hasStandInstDbID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasSettlDeliveryType()) s += "SettlDeliveryType(172)= " + getSettlDeliveryType() + "\n" ; 
		if (hasStandInstDbType()) s += "StandInstDbType(169)= " + getStandInstDbType() + "\n" ; 
		if (hasStandInstDbName()) s += "StandInstDbName(170)= " + new String( FixUtils.trim(getStandInstDbName()) ) + "\n" ; 
		if (hasStandInstDbID()) s += "StandInstDbID(171)= " + new String( FixUtils.trim(getStandInstDbID()) ) + "\n" ; 

		for (FixDlvyInstGrp fixDlvyInstGrp : dlvyInstGrp) fixDlvyInstGrp.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixSettlInstructionsData)) return false;

		FixSettlInstructionsData msg = (FixSettlInstructionsData) o;

		for (FixDlvyInstGrp fixDlvyInstGrp : dlvyInstGrp)
			if (!fixDlvyInstGrp.equals(msg.dlvyInstGrp)) return false;
		if ((hasSettlDeliveryType() && !msg.hasSettlDeliveryType()) || (!hasSettlDeliveryType() && msg.hasSettlDeliveryType())) return false;
		if (!(!hasSettlDeliveryType() && !msg.hasSettlDeliveryType()) && !(getSettlDeliveryType()==msg.getSettlDeliveryType())) return false;
		if ((hasStandInstDbType() && !msg.hasStandInstDbType()) || (!hasStandInstDbType() && msg.hasStandInstDbType())) return false;
		if (!(!hasStandInstDbType() && !msg.hasStandInstDbType()) && !(getStandInstDbType()==msg.getStandInstDbType())) return false;
		if ((hasStandInstDbName() && !msg.hasStandInstDbName()) || (!hasStandInstDbName() && msg.hasStandInstDbName())) return false;
		if (!(!hasStandInstDbName() && !msg.hasStandInstDbName()) && !FixUtils.equals(getStandInstDbName(), msg.getStandInstDbName())) return false;
		if ((hasStandInstDbID() && !msg.hasStandInstDbID()) || (!hasStandInstDbID() && msg.hasStandInstDbID())) return false;
		if (!(!hasStandInstDbID() && !msg.hasStandInstDbID()) && !FixUtils.equals(getStandInstDbID(), msg.getStandInstDbID())) return false;
		return true;
	}
	public FixSettlInstructionsData clone ( FixSettlInstructionsData out ) {
		if ( hasSettlDeliveryType())
			out.setSettlDeliveryType(getSettlDeliveryType());
		if ( hasStandInstDbType())
			out.setStandInstDbType(getStandInstDbType());
		if ( hasStandInstDbName())
			out.setStandInstDbName(getStandInstDbName());
		if ( hasStandInstDbID())
			out.setStandInstDbID(getStandInstDbID());
		int count = 0;
		count = 0;
		for (FixDlvyInstGrp fixDlvyInstGrp : dlvyInstGrp) {
			if (!fixDlvyInstGrp.hasGroup()) continue;
			out.dlvyInstGrp[count] = fixDlvyInstGrp.clone( out.dlvyInstGrp[count] );
			count++;
		}
		return out;
	}

}
