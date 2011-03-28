package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixDiscretionInstructions extends FixGroup {
	private short hasDiscretionInst;
	byte discretionInst = (byte)' ';		
	private short hasDiscretionOffsetValue;
	long discretionOffsetValue = 0;		
	private short hasDiscretionMoveType;
	long discretionMoveType = 0;		
	private short hasDiscretionOffsetType;
	long discretionOffsetType = 0;		
	private short hasDiscretionLimitType;
	long discretionLimitType = 0;		
	private short hasDiscretionRoundDirection;
	long discretionRoundDirection = 0;		
	private short hasDiscretionScope;
	long discretionScope = 0;		
	
	public FixDiscretionInstructions() {
		super(FixTags.DISCRETIONINST_INT);

		
		hasDiscretionInst = FixUtils.TAG_HAS_NO_VALUE;		
		hasDiscretionOffsetValue = FixUtils.TAG_HAS_NO_VALUE;		
		hasDiscretionMoveType = FixUtils.TAG_HAS_NO_VALUE;		
		hasDiscretionOffsetType = FixUtils.TAG_HAS_NO_VALUE;		
		hasDiscretionLimitType = FixUtils.TAG_HAS_NO_VALUE;		
		hasDiscretionRoundDirection = FixUtils.TAG_HAS_NO_VALUE;		
		hasDiscretionScope = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasDiscretionInst()) return true;
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
            	case FixTags.DISCRETIONINST_INT:		
            		hasDiscretionInst = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DISCRETIONOFFSETVALUE_INT:		
            		hasDiscretionOffsetValue = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DISCRETIONMOVETYPE_INT:		
            		hasDiscretionMoveType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DISCRETIONOFFSETTYPE_INT:		
            		hasDiscretionOffsetType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DISCRETIONLIMITTYPE_INT:		
            		hasDiscretionLimitType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DISCRETIONROUNDDIRECTION_INT:		
            		hasDiscretionRoundDirection = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DISCRETIONSCOPE_INT:		
            		hasDiscretionScope = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
            		return tag;

            }

            tag = FixMessage.getTag(buf, err);
            if (err.hasError()) return tag; // what to do now? 
        }		
        return tag;
    }		
	@Override
	public void clear() {
		// just set the length to header + trailer but still we set it...
		hasDiscretionInst = FixUtils.TAG_HAS_NO_VALUE;
		hasDiscretionOffsetValue = FixUtils.TAG_HAS_NO_VALUE;
		hasDiscretionMoveType = FixUtils.TAG_HAS_NO_VALUE;
		hasDiscretionOffsetType = FixUtils.TAG_HAS_NO_VALUE;
		hasDiscretionLimitType = FixUtils.TAG_HAS_NO_VALUE;
		hasDiscretionRoundDirection = FixUtils.TAG_HAS_NO_VALUE;
		hasDiscretionScope = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasDiscretionInst()) {		
			out.put(FixTags.DISCRETIONINST);

			out.put((byte) '=');

			FixUtils.put(out,discretionInst); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDiscretionOffsetValue()) {		
			out.put(FixTags.DISCRETIONOFFSETVALUE);

			out.put((byte) '=');

			FixUtils.put(out, (long)discretionOffsetValue);
		
			out.put(FixUtils.SOH);

            }

		if (hasDiscretionMoveType()) {		
			out.put(FixTags.DISCRETIONMOVETYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)discretionMoveType);
		
			out.put(FixUtils.SOH);

            }

		if (hasDiscretionOffsetType()) {		
			out.put(FixTags.DISCRETIONOFFSETTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)discretionOffsetType);
		
			out.put(FixUtils.SOH);

            }

		if (hasDiscretionLimitType()) {		
			out.put(FixTags.DISCRETIONLIMITTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)discretionLimitType);
		
			out.put(FixUtils.SOH);

            }

		if (hasDiscretionRoundDirection()) {		
			out.put(FixTags.DISCRETIONROUNDDIRECTION);

			out.put((byte) '=');

			FixUtils.put(out, (long)discretionRoundDirection);
		
			out.put(FixUtils.SOH);

            }

		if (hasDiscretionScope()) {		
			out.put(FixTags.DISCRETIONSCOPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)discretionScope);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasDiscretionInst()) {		
			FixUtils.put(out,discretionInst); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDiscretionOffsetValue()) {		
			FixUtils.put(out, (long)discretionOffsetValue);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDiscretionMoveType()) {		
			FixUtils.put(out, (long)discretionMoveType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDiscretionOffsetType()) {		
			FixUtils.put(out, (long)discretionOffsetType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDiscretionLimitType()) {		
			FixUtils.put(out, (long)discretionLimitType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDiscretionRoundDirection()) {		
			FixUtils.put(out, (long)discretionRoundDirection);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDiscretionScope()) {		
			FixUtils.put(out, (long)discretionScope);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte getDiscretionInst() { 		
		if ( hasDiscretionInst()) {		
			if (hasDiscretionInst == FixUtils.TAG_HAS_VALUE) {		
				return discretionInst; 		
			} else {		
		
				buf.position(hasDiscretionInst);		
		
			discretionInst = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (discretionInst != (byte)'3') && (discretionInst != (byte)'2') && (discretionInst != (byte)'1') && (discretionInst != (byte)'0') && (discretionInst != (byte)'7') && (discretionInst != (byte)'6') && (discretionInst != (byte)'5') && (discretionInst != (byte)'4') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 388);		
				if (err.hasError()) {		
					buf.position(hasDiscretionInst);		
					return (byte)'0';		
				}		
			}		
			hasDiscretionInst = FixUtils.TAG_HAS_VALUE;		
			return discretionInst;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasDiscretionInst() { return hasDiscretionInst != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDiscretionInst(byte src) {		
		discretionInst = src;
		hasDiscretionInst = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDiscretionInst(byte[] src) {		
		if (src == null ) return;
		if (hasDiscretionInst()) discretionInst = (byte)' ';		
		discretionInst = src[0];		
		hasDiscretionInst = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDiscretionInst(String str) {		
		if (str == null ) return;
		if (hasDiscretionInst()) discretionInst = (byte)' ';		
		byte[] src = str.getBytes(); 		
		discretionInst = src[0];		
		hasDiscretionInst = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDiscretionOffsetValue() { 		
		if ( hasDiscretionOffsetValue()) {		
			if (hasDiscretionOffsetValue == FixUtils.TAG_HAS_VALUE) {		
				return discretionOffsetValue; 		
			} else {		
		
				buf.position(hasDiscretionOffsetValue);		
		
			discretionOffsetValue = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDiscretionOffsetValue);		
					return 0;		
				}		
			}		
			hasDiscretionOffsetValue = FixUtils.TAG_HAS_VALUE;		
			return discretionOffsetValue;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDiscretionOffsetValue() { return hasDiscretionOffsetValue != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDiscretionOffsetValue(long src) {		
		discretionOffsetValue = src;
		hasDiscretionOffsetValue = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDiscretionOffsetValue(byte[] src) {		
		if (src == null ) return;
		if (hasDiscretionOffsetValue()) discretionOffsetValue = FixUtils.TAG_HAS_NO_VALUE;		
		discretionOffsetValue = FixUtils.longValueOf(src, 0, src.length);
		hasDiscretionOffsetValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDiscretionOffsetValue(String str) {		
		if (str == null ) return;
		if (hasDiscretionOffsetValue()) discretionOffsetValue = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		discretionOffsetValue = FixUtils.longValueOf(src, 0, src.length);
		hasDiscretionOffsetValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDiscretionMoveType() { 		
		if ( hasDiscretionMoveType()) {		
			if (hasDiscretionMoveType == FixUtils.TAG_HAS_VALUE) {		
				return discretionMoveType; 		
			} else {		
		
				buf.position(hasDiscretionMoveType);		
		
			discretionMoveType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDiscretionMoveType);		
					return 0;		
				}		
			}		
			hasDiscretionMoveType = FixUtils.TAG_HAS_VALUE;		
			return discretionMoveType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDiscretionMoveType() { return hasDiscretionMoveType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDiscretionMoveType(long src) {		
		discretionMoveType = src;
		hasDiscretionMoveType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDiscretionMoveType(byte[] src) {		
		if (src == null ) return;
		if (hasDiscretionMoveType()) discretionMoveType = FixUtils.TAG_HAS_NO_VALUE;		
		discretionMoveType = FixUtils.longValueOf(src, 0, src.length);
		hasDiscretionMoveType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDiscretionMoveType(String str) {		
		if (str == null ) return;
		if (hasDiscretionMoveType()) discretionMoveType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		discretionMoveType = FixUtils.longValueOf(src, 0, src.length);
		hasDiscretionMoveType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDiscretionOffsetType() { 		
		if ( hasDiscretionOffsetType()) {		
			if (hasDiscretionOffsetType == FixUtils.TAG_HAS_VALUE) {		
				return discretionOffsetType; 		
			} else {		
		
				buf.position(hasDiscretionOffsetType);		
		
			discretionOffsetType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDiscretionOffsetType);		
					return 0;		
				}		
			}		
			hasDiscretionOffsetType = FixUtils.TAG_HAS_VALUE;		
			return discretionOffsetType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDiscretionOffsetType() { return hasDiscretionOffsetType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDiscretionOffsetType(long src) {		
		discretionOffsetType = src;
		hasDiscretionOffsetType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDiscretionOffsetType(byte[] src) {		
		if (src == null ) return;
		if (hasDiscretionOffsetType()) discretionOffsetType = FixUtils.TAG_HAS_NO_VALUE;		
		discretionOffsetType = FixUtils.longValueOf(src, 0, src.length);
		hasDiscretionOffsetType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDiscretionOffsetType(String str) {		
		if (str == null ) return;
		if (hasDiscretionOffsetType()) discretionOffsetType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		discretionOffsetType = FixUtils.longValueOf(src, 0, src.length);
		hasDiscretionOffsetType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDiscretionLimitType() { 		
		if ( hasDiscretionLimitType()) {		
			if (hasDiscretionLimitType == FixUtils.TAG_HAS_VALUE) {		
				return discretionLimitType; 		
			} else {		
		
				buf.position(hasDiscretionLimitType);		
		
			discretionLimitType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDiscretionLimitType);		
					return 0;		
				}		
			}		
			hasDiscretionLimitType = FixUtils.TAG_HAS_VALUE;		
			return discretionLimitType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDiscretionLimitType() { return hasDiscretionLimitType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDiscretionLimitType(long src) {		
		discretionLimitType = src;
		hasDiscretionLimitType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDiscretionLimitType(byte[] src) {		
		if (src == null ) return;
		if (hasDiscretionLimitType()) discretionLimitType = FixUtils.TAG_HAS_NO_VALUE;		
		discretionLimitType = FixUtils.longValueOf(src, 0, src.length);
		hasDiscretionLimitType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDiscretionLimitType(String str) {		
		if (str == null ) return;
		if (hasDiscretionLimitType()) discretionLimitType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		discretionLimitType = FixUtils.longValueOf(src, 0, src.length);
		hasDiscretionLimitType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDiscretionRoundDirection() { 		
		if ( hasDiscretionRoundDirection()) {		
			if (hasDiscretionRoundDirection == FixUtils.TAG_HAS_VALUE) {		
				return discretionRoundDirection; 		
			} else {		
		
				buf.position(hasDiscretionRoundDirection);		
		
			discretionRoundDirection = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDiscretionRoundDirection);		
					return 0;		
				}		
			}		
			hasDiscretionRoundDirection = FixUtils.TAG_HAS_VALUE;		
			return discretionRoundDirection;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDiscretionRoundDirection() { return hasDiscretionRoundDirection != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDiscretionRoundDirection(long src) {		
		discretionRoundDirection = src;
		hasDiscretionRoundDirection = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDiscretionRoundDirection(byte[] src) {		
		if (src == null ) return;
		if (hasDiscretionRoundDirection()) discretionRoundDirection = FixUtils.TAG_HAS_NO_VALUE;		
		discretionRoundDirection = FixUtils.longValueOf(src, 0, src.length);
		hasDiscretionRoundDirection = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDiscretionRoundDirection(String str) {		
		if (str == null ) return;
		if (hasDiscretionRoundDirection()) discretionRoundDirection = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		discretionRoundDirection = FixUtils.longValueOf(src, 0, src.length);
		hasDiscretionRoundDirection = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDiscretionScope() { 		
		if ( hasDiscretionScope()) {		
			if (hasDiscretionScope == FixUtils.TAG_HAS_VALUE) {		
				return discretionScope; 		
			} else {		
		
				buf.position(hasDiscretionScope);		
		
			discretionScope = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDiscretionScope);		
					return 0;		
				}		
			}		
			hasDiscretionScope = FixUtils.TAG_HAS_VALUE;		
			return discretionScope;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDiscretionScope() { return hasDiscretionScope != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDiscretionScope(long src) {		
		discretionScope = src;
		hasDiscretionScope = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDiscretionScope(byte[] src) {		
		if (src == null ) return;
		if (hasDiscretionScope()) discretionScope = FixUtils.TAG_HAS_NO_VALUE;		
		discretionScope = FixUtils.longValueOf(src, 0, src.length);
		hasDiscretionScope = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDiscretionScope(String str) {		
		if (str == null ) return;
		if (hasDiscretionScope()) discretionScope = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		discretionScope = FixUtils.longValueOf(src, 0, src.length);
		hasDiscretionScope = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasDiscretionInst()) s += "DiscretionInst(388)= " + getDiscretionInst() + "\n" ; 
		if (hasDiscretionOffsetValue()) s += "DiscretionOffsetValue(389)= " + getDiscretionOffsetValue() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasDiscretionMoveType()) s += "DiscretionMoveType(841)= " + getDiscretionMoveType() + "\n" ; 
		if (hasDiscretionOffsetType()) s += "DiscretionOffsetType(842)= " + getDiscretionOffsetType() + "\n" ; 
		if (hasDiscretionLimitType()) s += "DiscretionLimitType(843)= " + getDiscretionLimitType() + "\n" ; 
		if (hasDiscretionRoundDirection()) s += "DiscretionRoundDirection(844)= " + getDiscretionRoundDirection() + "\n" ; 
		if (hasDiscretionScope()) s += "DiscretionScope(846)= " + getDiscretionScope() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixDiscretionInstructions)) return false;

		FixDiscretionInstructions msg = (FixDiscretionInstructions) o;

		if ((hasDiscretionInst() && !msg.hasDiscretionInst()) || (!hasDiscretionInst() && msg.hasDiscretionInst())) return false;
		if (!(!hasDiscretionInst() && !msg.hasDiscretionInst()) && !(getDiscretionInst()==msg.getDiscretionInst())) return false;
		if ((hasDiscretionOffsetValue() && !msg.hasDiscretionOffsetValue()) || (!hasDiscretionOffsetValue() && msg.hasDiscretionOffsetValue())) return false;
		if (!(!hasDiscretionOffsetValue() && !msg.hasDiscretionOffsetValue()) && !(getDiscretionOffsetValue()==msg.getDiscretionOffsetValue())) return false;
		if ((hasDiscretionMoveType() && !msg.hasDiscretionMoveType()) || (!hasDiscretionMoveType() && msg.hasDiscretionMoveType())) return false;
		if (!(!hasDiscretionMoveType() && !msg.hasDiscretionMoveType()) && !(getDiscretionMoveType()==msg.getDiscretionMoveType())) return false;
		if ((hasDiscretionOffsetType() && !msg.hasDiscretionOffsetType()) || (!hasDiscretionOffsetType() && msg.hasDiscretionOffsetType())) return false;
		if (!(!hasDiscretionOffsetType() && !msg.hasDiscretionOffsetType()) && !(getDiscretionOffsetType()==msg.getDiscretionOffsetType())) return false;
		if ((hasDiscretionLimitType() && !msg.hasDiscretionLimitType()) || (!hasDiscretionLimitType() && msg.hasDiscretionLimitType())) return false;
		if (!(!hasDiscretionLimitType() && !msg.hasDiscretionLimitType()) && !(getDiscretionLimitType()==msg.getDiscretionLimitType())) return false;
		if ((hasDiscretionRoundDirection() && !msg.hasDiscretionRoundDirection()) || (!hasDiscretionRoundDirection() && msg.hasDiscretionRoundDirection())) return false;
		if (!(!hasDiscretionRoundDirection() && !msg.hasDiscretionRoundDirection()) && !(getDiscretionRoundDirection()==msg.getDiscretionRoundDirection())) return false;
		if ((hasDiscretionScope() && !msg.hasDiscretionScope()) || (!hasDiscretionScope() && msg.hasDiscretionScope())) return false;
		if (!(!hasDiscretionScope() && !msg.hasDiscretionScope()) && !(getDiscretionScope()==msg.getDiscretionScope())) return false;
		return true;
	}
	public FixDiscretionInstructions clone ( FixDiscretionInstructions out ) {
		if ( hasDiscretionInst())
			out.setDiscretionInst(getDiscretionInst());
		if ( hasDiscretionOffsetValue())
			out.setDiscretionOffsetValue(getDiscretionOffsetValue());
		if ( hasDiscretionMoveType())
			out.setDiscretionMoveType(getDiscretionMoveType());
		if ( hasDiscretionOffsetType())
			out.setDiscretionOffsetType(getDiscretionOffsetType());
		if ( hasDiscretionLimitType())
			out.setDiscretionLimitType(getDiscretionLimitType());
		if ( hasDiscretionRoundDirection())
			out.setDiscretionRoundDirection(getDiscretionRoundDirection());
		if ( hasDiscretionScope())
			out.setDiscretionScope(getDiscretionScope());
		return out;
	}

}
