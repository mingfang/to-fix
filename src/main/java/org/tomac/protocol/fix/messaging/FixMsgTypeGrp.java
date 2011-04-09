package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixMsgTypeGrp extends FixGroup {
	private short hasRefMsgType;
	byte[] refMsgType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMsgDirection;
	byte msgDirection = (byte)' ';		
	private short hasRefApplVerID;
	byte[] refApplVerID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRefCstmApplVerID;
	byte[] refCstmApplVerID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRefApplExtID;
	long refApplExtID = 0;		
	private short hasDefaultVerIndicator;
		boolean defaultVerIndicator = false;		
	
	public FixMsgTypeGrp() {
		this(false);
	}

	public FixMsgTypeGrp(boolean isRequired) {
		super(FixTags.REFMSGTYPE_INT);

		this.isRequired = isRequired;
		
		hasRefMsgType = FixUtils.TAG_HAS_NO_VALUE;		
		refMsgType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMsgDirection = FixUtils.TAG_HAS_NO_VALUE;		
		hasRefApplVerID = FixUtils.TAG_HAS_NO_VALUE;		
		refApplVerID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRefCstmApplVerID = FixUtils.TAG_HAS_NO_VALUE;		
		refCstmApplVerID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRefApplExtID = FixUtils.TAG_HAS_NO_VALUE;		
		hasDefaultVerIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasRefMsgType()) return true;
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
            	case FixTags.REFMSGTYPE_INT:		
            		hasRefMsgType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.MSGDIRECTION_INT:		
            		hasMsgDirection = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.REFAPPLVERID_INT:		
            		hasRefApplVerID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.REFCSTMAPPLVERID_INT:		
            		hasRefCstmApplVerID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.REFAPPLEXTID_INT:		
            		hasRefApplExtID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.DEFAULTVERINDICATOR_INT:		
            		hasDefaultVerIndicator = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	default:
            		return tag;

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
		hasRefMsgType = FixUtils.TAG_HAS_NO_VALUE;
		hasMsgDirection = FixUtils.TAG_HAS_NO_VALUE;
		hasRefApplVerID = FixUtils.TAG_HAS_NO_VALUE;
		hasRefCstmApplVerID = FixUtils.TAG_HAS_NO_VALUE;
		hasRefApplExtID = FixUtils.TAG_HAS_NO_VALUE;
		hasDefaultVerIndicator = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasRefMsgType()) {		
			out.put(FixTags.REFMSGTYPE);

			out.put((byte) '=');

			FixUtils.put(out,refMsgType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasMsgDirection()) {		
			out.put(FixTags.MSGDIRECTION);

			out.put((byte) '=');

			FixUtils.put(out,msgDirection); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRefApplVerID()) {		
			out.put(FixTags.REFAPPLVERID);

			out.put((byte) '=');

			FixUtils.put(out,refApplVerID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRefCstmApplVerID()) {		
			out.put(FixTags.REFCSTMAPPLVERID);

			out.put((byte) '=');

			FixUtils.put(out,refCstmApplVerID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRefApplExtID()) {		
			out.put(FixTags.REFAPPLEXTID);

			out.put((byte) '=');

			FixUtils.put(out, (long)refApplExtID);
		
			out.put(FixUtils.SOH);

            }

		if (hasDefaultVerIndicator()) {		
			out.put(FixTags.DEFAULTVERINDICATOR);

			out.put((byte) '=');

			out.put(defaultVerIndicator?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasRefMsgType()) {		
			FixUtils.put(out,refMsgType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMsgDirection()) {		
			FixUtils.put(out,msgDirection); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRefApplVerID()) {		
			FixUtils.put(out,refApplVerID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRefCstmApplVerID()) {		
			FixUtils.put(out,refCstmApplVerID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRefApplExtID()) {		
			FixUtils.put(out, (long)refApplExtID);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDefaultVerIndicator()) {		
			out.put(defaultVerIndicator?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getRefMsgType() { 		
		if ( hasRefMsgType()) {		
			if (hasRefMsgType == FixUtils.TAG_HAS_VALUE) {		
				return refMsgType; 		
			} else {		
		
				buf.position(hasRefMsgType);		
		
			FixUtils.getTagStringValue(buf, refMsgType, 0, refMsgType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRefMsgType);		
					return null;		
				}		
			}		
			hasRefMsgType = FixUtils.TAG_HAS_VALUE;		
			return refMsgType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRefMsgType() { return hasRefMsgType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRefMsgType(byte[] src) {		
		if (src == null ) return;
		if (hasRefMsgType()) FixUtils.fillNul(refMsgType);		
		FixUtils.copy(refMsgType, src); 		
		hasRefMsgType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRefMsgType(String str) {		
		if (str == null ) return;
		if (hasRefMsgType()) FixUtils.fillNul(refMsgType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(refMsgType, src); 		
		hasRefMsgType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getMsgDirection() { 		
		if ( hasMsgDirection()) {		
			if (hasMsgDirection == FixUtils.TAG_HAS_VALUE) {		
				return msgDirection; 		
			} else {		
		
				buf.position(hasMsgDirection);		
		
			msgDirection = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (msgDirection != (byte)'S') && (msgDirection != (byte)'R') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 385);		
				if (err.hasError()) {		
					buf.position(hasMsgDirection);		
					return (byte)'0';		
				}		
			}		
			hasMsgDirection = FixUtils.TAG_HAS_VALUE;		
			return msgDirection;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasMsgDirection() { return hasMsgDirection != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMsgDirection(byte src) {		
		msgDirection = src;
		hasMsgDirection = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMsgDirection(byte[] src) {		
		if (src == null ) return;
		if (hasMsgDirection()) msgDirection = (byte)' ';		
		msgDirection = src[0];		
		hasMsgDirection = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMsgDirection(String str) {		
		if (str == null ) return;
		if (hasMsgDirection()) msgDirection = (byte)' ';		
		byte[] src = str.getBytes(); 		
		msgDirection = src[0];		
		hasMsgDirection = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRefApplVerID() { 		
		if ( hasRefApplVerID()) {		
			if (hasRefApplVerID == FixUtils.TAG_HAS_VALUE) {		
				return refApplVerID; 		
			} else {		
		
				buf.position(hasRefApplVerID);		
		
			FixUtils.getTagStringValue(buf, refApplVerID, 0, refApplVerID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRefApplVerID);		
					return null;		
				}		
			}		
			hasRefApplVerID = FixUtils.TAG_HAS_VALUE;		
			return refApplVerID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRefApplVerID() { return hasRefApplVerID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRefApplVerID(byte[] src) {		
		if (src == null ) return;
		if (hasRefApplVerID()) FixUtils.fillNul(refApplVerID);		
		FixUtils.copy(refApplVerID, src); 		
		hasRefApplVerID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRefApplVerID(String str) {		
		if (str == null ) return;
		if (hasRefApplVerID()) FixUtils.fillNul(refApplVerID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(refApplVerID, src); 		
		hasRefApplVerID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRefCstmApplVerID() { 		
		if ( hasRefCstmApplVerID()) {		
			if (hasRefCstmApplVerID == FixUtils.TAG_HAS_VALUE) {		
				return refCstmApplVerID; 		
			} else {		
		
				buf.position(hasRefCstmApplVerID);		
		
			FixUtils.getTagStringValue(buf, refCstmApplVerID, 0, refCstmApplVerID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRefCstmApplVerID);		
					return null;		
				}		
			}		
			hasRefCstmApplVerID = FixUtils.TAG_HAS_VALUE;		
			return refCstmApplVerID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRefCstmApplVerID() { return hasRefCstmApplVerID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRefCstmApplVerID(byte[] src) {		
		if (src == null ) return;
		if (hasRefCstmApplVerID()) FixUtils.fillNul(refCstmApplVerID);		
		FixUtils.copy(refCstmApplVerID, src); 		
		hasRefCstmApplVerID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRefCstmApplVerID(String str) {		
		if (str == null ) return;
		if (hasRefCstmApplVerID()) FixUtils.fillNul(refCstmApplVerID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(refCstmApplVerID, src); 		
		hasRefCstmApplVerID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getRefApplExtID() { 		
		if ( hasRefApplExtID()) {		
			if (hasRefApplExtID == FixUtils.TAG_HAS_VALUE) {		
				return refApplExtID; 		
			} else {		
		
				buf.position(hasRefApplExtID);		
		
			refApplExtID = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRefApplExtID);		
					return 0;		
				}		
			}		
			hasRefApplExtID = FixUtils.TAG_HAS_VALUE;		
			return refApplExtID;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRefApplExtID() { return hasRefApplExtID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRefApplExtID(long src) {		
		refApplExtID = src;
		hasRefApplExtID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRefApplExtID(byte[] src) {		
		if (src == null ) return;
		if (hasRefApplExtID()) refApplExtID = FixUtils.TAG_HAS_NO_VALUE;		
		refApplExtID = FixUtils.longValueOf(src, 0, src.length);
		hasRefApplExtID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRefApplExtID(String str) {		
		if (str == null ) return;
		if (hasRefApplExtID()) refApplExtID = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		refApplExtID = FixUtils.longValueOf(src, 0, src.length);
		hasRefApplExtID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public boolean getDefaultVerIndicator() { 		
		if ( hasDefaultVerIndicator()) {		
			if (hasDefaultVerIndicator == FixUtils.TAG_HAS_VALUE) {		
				return defaultVerIndicator; 		
			} else {		
		
				buf.position(hasDefaultVerIndicator);		
		
			defaultVerIndicator = FixUtils.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(hasDefaultVerIndicator);		
					return false;		
				}		
			}		
			hasDefaultVerIndicator = FixUtils.TAG_HAS_VALUE;		
			return defaultVerIndicator;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasDefaultVerIndicator() { return hasDefaultVerIndicator != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDefaultVerIndicator(boolean src) {		
		defaultVerIndicator = src;
		hasDefaultVerIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDefaultVerIndicator(byte[] src) {		
		if (src == null ) return;
		if (hasDefaultVerIndicator()) defaultVerIndicator = false;		
		defaultVerIndicator = src[0]==(byte)'Y'?true:false;		
		hasDefaultVerIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDefaultVerIndicator(String str) {		
		if (str == null ) return;
		if (hasDefaultVerIndicator()) defaultVerIndicator = false;		
		byte[] src = str.getBytes(); 		
		defaultVerIndicator = src[0]==(byte)'Y'?true:false;		
		hasDefaultVerIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasRefMsgType()) s += "RefMsgType(372)= " + new String( FixUtils.trim(getRefMsgType()) ) + "\n" ; 
		if (hasMsgDirection()) s += "MsgDirection(385)= " + getMsgDirection() + "\n" ; 
		if (hasRefApplVerID()) s += "RefApplVerID(1130)= " + new String( FixUtils.trim(getRefApplVerID()) ) + "\n" ; 
		if (hasRefCstmApplVerID()) s += "RefCstmApplVerID(1131)= " + new String( FixUtils.trim(getRefCstmApplVerID()) ) + "\n" ; 
		if (hasRefApplExtID()) s += "RefApplExtID(1406)= " + getRefApplExtID() + "\n" ; 
		if (hasDefaultVerIndicator()) s += "DefaultVerIndicator(1410)= " + getDefaultVerIndicator() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixMsgTypeGrp)) return false;

		FixMsgTypeGrp msg = (FixMsgTypeGrp) o;

		if ((hasRefMsgType() && !msg.hasRefMsgType()) || (!hasRefMsgType() && msg.hasRefMsgType())) return false;
		if (!(!hasRefMsgType() && !msg.hasRefMsgType()) && !FixUtils.equals(getRefMsgType(), msg.getRefMsgType())) return false;
		if ((hasMsgDirection() && !msg.hasMsgDirection()) || (!hasMsgDirection() && msg.hasMsgDirection())) return false;
		if (!(!hasMsgDirection() && !msg.hasMsgDirection()) && !(getMsgDirection()==msg.getMsgDirection())) return false;
		if ((hasRefApplVerID() && !msg.hasRefApplVerID()) || (!hasRefApplVerID() && msg.hasRefApplVerID())) return false;
		if (!(!hasRefApplVerID() && !msg.hasRefApplVerID()) && !FixUtils.equals(getRefApplVerID(), msg.getRefApplVerID())) return false;
		if ((hasRefCstmApplVerID() && !msg.hasRefCstmApplVerID()) || (!hasRefCstmApplVerID() && msg.hasRefCstmApplVerID())) return false;
		if (!(!hasRefCstmApplVerID() && !msg.hasRefCstmApplVerID()) && !FixUtils.equals(getRefCstmApplVerID(), msg.getRefCstmApplVerID())) return false;
		if ((hasRefApplExtID() && !msg.hasRefApplExtID()) || (!hasRefApplExtID() && msg.hasRefApplExtID())) return false;
		if (!(!hasRefApplExtID() && !msg.hasRefApplExtID()) && !(getRefApplExtID()==msg.getRefApplExtID())) return false;
		if ((hasDefaultVerIndicator() && !msg.hasDefaultVerIndicator()) || (!hasDefaultVerIndicator() && msg.hasDefaultVerIndicator())) return false;
		if (!(!hasDefaultVerIndicator() && !msg.hasDefaultVerIndicator()) && !(getDefaultVerIndicator()==msg.getDefaultVerIndicator())) return false;
		return true;
	}
	public FixMsgTypeGrp clone ( FixMsgTypeGrp out ) {
		if ( hasRefMsgType())
			out.setRefMsgType(getRefMsgType());
		if ( hasMsgDirection())
			out.setMsgDirection(getMsgDirection());
		if ( hasRefApplVerID())
			out.setRefApplVerID(getRefApplVerID());
		if ( hasRefCstmApplVerID())
			out.setRefCstmApplVerID(getRefCstmApplVerID());
		if ( hasRefApplExtID())
			out.setRefApplExtID(getRefApplExtID());
		if ( hasDefaultVerIndicator())
			out.setDefaultVerIndicator(getDefaultVerIndicator());
		return out;
	}

}
