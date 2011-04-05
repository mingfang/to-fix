package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixStrmAsgnReqInstrmtGrp extends FixGroup {
	private short hasSettlType;
	byte[] settlType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMDEntrySize;
	long mDEntrySize = 0;		
	private short hasMDStreamID;
	byte[] mDStreamID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		public FixInstrument instrument;
	
	public FixStrmAsgnReqInstrmtGrp() {
		this(false);
	}

	public FixStrmAsgnReqInstrmtGrp(boolean isRequired) {
		super(FixTags.SYMBOL_INT);

		this.isRequired = isRequired;
		
		hasSettlType = FixUtils.TAG_HAS_NO_VALUE;		
		settlType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMDEntrySize = FixUtils.TAG_HAS_NO_VALUE;		
		hasMDStreamID = FixUtils.TAG_HAS_NO_VALUE;		
		mDStreamID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		instrument = new FixInstrument();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (instrument.hasGroup()) return true;
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
            	case FixTags.SETTLTYPE_INT:		
            		hasSettlType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MDENTRYSIZE_INT:		
            		hasMDEntrySize = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.MDSTREAMID_INT:		
            		hasMDStreamID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( instrument.isKeyTag(tag)) {
        				tag = instrument.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
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
		hasSettlType = FixUtils.TAG_HAS_NO_VALUE;
		hasMDEntrySize = FixUtils.TAG_HAS_NO_VALUE;
		hasMDStreamID = FixUtils.TAG_HAS_NO_VALUE;
		instrument.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasSettlType()) {		
			out.put(FixTags.SETTLTYPE);

			out.put((byte) '=');

			FixUtils.put(out,settlType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasMDEntrySize()) {		
			out.put(FixTags.MDENTRYSIZE);

			out.put((byte) '=');

			FixUtils.put(out, (long)mDEntrySize);
		
			out.put(FixUtils.SOH);

            }

		if (hasMDStreamID()) {		
			out.put(FixTags.MDSTREAMID);

			out.put((byte) '=');

			FixUtils.put(out,mDStreamID); 		
		
			out.put(FixUtils.SOH);

            }

		instrument.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasSettlType()) {		
			FixUtils.put(out,settlType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMDEntrySize()) {		
			FixUtils.put(out, (long)mDEntrySize);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMDStreamID()) {		
			FixUtils.put(out,mDStreamID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		instrument.printBuffer(out);
	}

	public byte[] getSettlType() { 		
		if ( hasSettlType()) {		
			if (hasSettlType == FixUtils.TAG_HAS_VALUE) {		
				return settlType; 		
			} else {		
		
				buf.position(hasSettlType);		
		
			FixMessage.getTagStringValue(buf, settlType, 0, settlType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasSettlType);		
					return null;		
				}		
			}		
			hasSettlType = FixUtils.TAG_HAS_VALUE;		
			return settlType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSettlType() { return hasSettlType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSettlType(byte[] src) {		
		if (src == null ) return;
		if (hasSettlType()) FixUtils.fillNul(settlType);		
		FixUtils.copy(settlType, src); 		
		hasSettlType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSettlType(String str) {		
		if (str == null ) return;
		if (hasSettlType()) FixUtils.fillNul(settlType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlType, src); 		
		hasSettlType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getMDEntrySize() { 		
		if ( hasMDEntrySize()) {		
			if (hasMDEntrySize == FixUtils.TAG_HAS_VALUE) {		
				return mDEntrySize; 		
			} else {		
		
				buf.position(hasMDEntrySize);		
		
			mDEntrySize = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasMDEntrySize);		
					return 0;		
				}		
			}		
			hasMDEntrySize = FixUtils.TAG_HAS_VALUE;		
			return mDEntrySize;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMDEntrySize() { return hasMDEntrySize != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMDEntrySize(long src) {		
		mDEntrySize = src;
		hasMDEntrySize = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMDEntrySize(byte[] src) {		
		if (src == null ) return;
		if (hasMDEntrySize()) mDEntrySize = FixUtils.TAG_HAS_NO_VALUE;		
		mDEntrySize = FixUtils.longValueOf(src, 0, src.length);
		hasMDEntrySize = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMDEntrySize(String str) {		
		if (str == null ) return;
		if (hasMDEntrySize()) mDEntrySize = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		mDEntrySize = FixUtils.longValueOf(src, 0, src.length);
		hasMDEntrySize = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getMDStreamID() { 		
		if ( hasMDStreamID()) {		
			if (hasMDStreamID == FixUtils.TAG_HAS_VALUE) {		
				return mDStreamID; 		
			} else {		
		
				buf.position(hasMDStreamID);		
		
			FixMessage.getTagStringValue(buf, mDStreamID, 0, mDStreamID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasMDStreamID);		
					return null;		
				}		
			}		
			hasMDStreamID = FixUtils.TAG_HAS_VALUE;		
			return mDStreamID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasMDStreamID() { return hasMDStreamID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setMDStreamID(byte[] src) {		
		if (src == null ) return;
		if (hasMDStreamID()) FixUtils.fillNul(mDStreamID);		
		FixUtils.copy(mDStreamID, src); 		
		hasMDStreamID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setMDStreamID(String str) {		
		if (str == null ) return;
		if (hasMDStreamID()) FixUtils.fillNul(mDStreamID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(mDStreamID, src); 		
		hasMDStreamID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasSettlType()) s += "SettlType(63)= " + new String( FixUtils.trim(getSettlType()) ) + "\n" ; 
		if (hasMDEntrySize()) s += "MDEntrySize(271)= " + getMDEntrySize() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasMDStreamID()) s += "MDStreamID(1500)= " + new String( FixUtils.trim(getMDStreamID()) ) + "\n" ; 

		s += instrument.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixStrmAsgnReqInstrmtGrp)) return false;

		FixStrmAsgnReqInstrmtGrp msg = (FixStrmAsgnReqInstrmtGrp) o;

		if (!instrument.equals(msg.instrument)) return false;
		if ((hasSettlType() && !msg.hasSettlType()) || (!hasSettlType() && msg.hasSettlType())) return false;
		if (!(!hasSettlType() && !msg.hasSettlType()) && !FixUtils.equals(getSettlType(), msg.getSettlType())) return false;
		if ((hasMDEntrySize() && !msg.hasMDEntrySize()) || (!hasMDEntrySize() && msg.hasMDEntrySize())) return false;
		if (!(!hasMDEntrySize() && !msg.hasMDEntrySize()) && !(getMDEntrySize()==msg.getMDEntrySize())) return false;
		if ((hasMDStreamID() && !msg.hasMDStreamID()) || (!hasMDStreamID() && msg.hasMDStreamID())) return false;
		if (!(!hasMDStreamID() && !msg.hasMDStreamID()) && !FixUtils.equals(getMDStreamID(), msg.getMDStreamID())) return false;
		return true;
	}
	public FixStrmAsgnReqInstrmtGrp clone ( FixStrmAsgnReqInstrmtGrp out ) {
		if ( hasSettlType())
			out.setSettlType(getSettlType());
		if ( hasMDEntrySize())
			out.setMDEntrySize(getMDEntrySize());
		if ( hasMDStreamID())
			out.setMDStreamID(getMDStreamID());
		if (instrument.hasGroup())
			out.instrument = instrument.clone( out.instrument);
		return out;
	}

}
