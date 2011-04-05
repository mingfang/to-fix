package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixBidDescReqGrp extends FixGroup {
	private short hasBidDescriptorType;
	long bidDescriptorType = 0;		
	private short hasBidDescriptor;
	byte[] bidDescriptor = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSideValueInd;
	long sideValueInd = 0;		
	private short hasLiquidityValue;
	long liquidityValue = 0;		
	private short hasLiquidityNumSecurities;
	long liquidityNumSecurities = 0;		
	private short hasLiquidityPctLow;
	long liquidityPctLow = 0;		
	private short hasLiquidityPctHigh;
	long liquidityPctHigh = 0;		
	private short hasEFPTrackingError;
	long eFPTrackingError = 0;		
	private short hasFairValue;
	long fairValue = 0;		
	private short hasOutsideIndexPct;
	long outsideIndexPct = 0;		
	private short hasValueOfFutures;
	long valueOfFutures = 0;		
	
	public FixBidDescReqGrp() {
		this(false);
	}

	public FixBidDescReqGrp(boolean isRequired) {
		super(FixTags.BIDDESCRIPTORTYPE_INT);

		this.isRequired = isRequired;
		
		hasBidDescriptorType = FixUtils.TAG_HAS_NO_VALUE;		
		hasBidDescriptor = FixUtils.TAG_HAS_NO_VALUE;		
		bidDescriptor = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSideValueInd = FixUtils.TAG_HAS_NO_VALUE;		
		hasLiquidityValue = FixUtils.TAG_HAS_NO_VALUE;		
		hasLiquidityNumSecurities = FixUtils.TAG_HAS_NO_VALUE;		
		hasLiquidityPctLow = FixUtils.TAG_HAS_NO_VALUE;		
		hasLiquidityPctHigh = FixUtils.TAG_HAS_NO_VALUE;		
		hasEFPTrackingError = FixUtils.TAG_HAS_NO_VALUE;		
		hasFairValue = FixUtils.TAG_HAS_NO_VALUE;		
		hasOutsideIndexPct = FixUtils.TAG_HAS_NO_VALUE;		
		hasValueOfFutures = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasBidDescriptorType()) return true;
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
            	case FixTags.BIDDESCRIPTORTYPE_INT:		
            		hasBidDescriptorType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.BIDDESCRIPTOR_INT:		
            		hasBidDescriptor = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.SIDEVALUEIND_INT:		
            		hasSideValueInd = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LIQUIDITYVALUE_INT:		
            		hasLiquidityValue = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LIQUIDITYNUMSECURITIES_INT:		
            		hasLiquidityNumSecurities = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LIQUIDITYPCTLOW_INT:		
            		hasLiquidityPctLow = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LIQUIDITYPCTHIGH_INT:		
            		hasLiquidityPctHigh = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.EFPTRACKINGERROR_INT:		
            		hasEFPTrackingError = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.FAIRVALUE_INT:		
            		hasFairValue = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.OUTSIDEINDEXPCT_INT:		
            		hasOutsideIndexPct = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.VALUEOFFUTURES_INT:		
            		hasValueOfFutures = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
            		return tag;

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
		hasBidDescriptorType = FixUtils.TAG_HAS_NO_VALUE;
		hasBidDescriptor = FixUtils.TAG_HAS_NO_VALUE;
		hasSideValueInd = FixUtils.TAG_HAS_NO_VALUE;
		hasLiquidityValue = FixUtils.TAG_HAS_NO_VALUE;
		hasLiquidityNumSecurities = FixUtils.TAG_HAS_NO_VALUE;
		hasLiquidityPctLow = FixUtils.TAG_HAS_NO_VALUE;
		hasLiquidityPctHigh = FixUtils.TAG_HAS_NO_VALUE;
		hasEFPTrackingError = FixUtils.TAG_HAS_NO_VALUE;
		hasFairValue = FixUtils.TAG_HAS_NO_VALUE;
		hasOutsideIndexPct = FixUtils.TAG_HAS_NO_VALUE;
		hasValueOfFutures = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasBidDescriptorType()) {		
			out.put(FixTags.BIDDESCRIPTORTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)bidDescriptorType);
		
			out.put(FixUtils.SOH);

            }

		if (hasBidDescriptor()) {		
			out.put(FixTags.BIDDESCRIPTOR);

			out.put((byte) '=');

			FixUtils.put(out,bidDescriptor); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasSideValueInd()) {		
			out.put(FixTags.SIDEVALUEIND);

			out.put((byte) '=');

			FixUtils.put(out, (long)sideValueInd);
		
			out.put(FixUtils.SOH);

            }

		if (hasLiquidityValue()) {		
			out.put(FixTags.LIQUIDITYVALUE);

			out.put((byte) '=');

			FixUtils.put(out, (long)liquidityValue);
		
			out.put(FixUtils.SOH);

            }

		if (hasLiquidityNumSecurities()) {		
			out.put(FixTags.LIQUIDITYNUMSECURITIES);

			out.put((byte) '=');

			FixUtils.put(out, (long)liquidityNumSecurities);
		
			out.put(FixUtils.SOH);

            }

		if (hasLiquidityPctLow()) {		
			out.put(FixTags.LIQUIDITYPCTLOW);

			out.put((byte) '=');

			FixUtils.put(out, (long)liquidityPctLow);
		
			out.put(FixUtils.SOH);

            }

		if (hasLiquidityPctHigh()) {		
			out.put(FixTags.LIQUIDITYPCTHIGH);

			out.put((byte) '=');

			FixUtils.put(out, (long)liquidityPctHigh);
		
			out.put(FixUtils.SOH);

            }

		if (hasEFPTrackingError()) {		
			out.put(FixTags.EFPTRACKINGERROR);

			out.put((byte) '=');

			FixUtils.put(out, (long)eFPTrackingError);
		
			out.put(FixUtils.SOH);

            }

		if (hasFairValue()) {		
			out.put(FixTags.FAIRVALUE);

			out.put((byte) '=');

			FixUtils.put(out, (long)fairValue);
		
			out.put(FixUtils.SOH);

            }

		if (hasOutsideIndexPct()) {		
			out.put(FixTags.OUTSIDEINDEXPCT);

			out.put((byte) '=');

			FixUtils.put(out, (long)outsideIndexPct);
		
			out.put(FixUtils.SOH);

            }

		if (hasValueOfFutures()) {		
			out.put(FixTags.VALUEOFFUTURES);

			out.put((byte) '=');

			FixUtils.put(out, (long)valueOfFutures);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasBidDescriptorType()) {		
			FixUtils.put(out, (long)bidDescriptorType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBidDescriptor()) {		
			FixUtils.put(out,bidDescriptor); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSideValueInd()) {		
			FixUtils.put(out, (long)sideValueInd);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLiquidityValue()) {		
			FixUtils.put(out, (long)liquidityValue);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLiquidityNumSecurities()) {		
			FixUtils.put(out, (long)liquidityNumSecurities);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLiquidityPctLow()) {		
			FixUtils.put(out, (long)liquidityPctLow);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLiquidityPctHigh()) {		
			FixUtils.put(out, (long)liquidityPctHigh);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEFPTrackingError()) {		
			FixUtils.put(out, (long)eFPTrackingError);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasFairValue()) {		
			FixUtils.put(out, (long)fairValue);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOutsideIndexPct()) {		
			FixUtils.put(out, (long)outsideIndexPct);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasValueOfFutures()) {		
			FixUtils.put(out, (long)valueOfFutures);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getBidDescriptorType() { 		
		if ( hasBidDescriptorType()) {		
			if (hasBidDescriptorType == FixUtils.TAG_HAS_VALUE) {		
				return bidDescriptorType; 		
			} else {		
		
				buf.position(hasBidDescriptorType);		
		
			bidDescriptorType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasBidDescriptorType);		
					return 0;		
				}		
			}		
			hasBidDescriptorType = FixUtils.TAG_HAS_VALUE;		
			return bidDescriptorType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasBidDescriptorType() { return hasBidDescriptorType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setBidDescriptorType(long src) {		
		bidDescriptorType = src;
		hasBidDescriptorType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBidDescriptorType(byte[] src) {		
		if (src == null ) return;
		if (hasBidDescriptorType()) bidDescriptorType = FixUtils.TAG_HAS_NO_VALUE;		
		bidDescriptorType = FixUtils.longValueOf(src, 0, src.length);
		hasBidDescriptorType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setBidDescriptorType(String str) {		
		if (str == null ) return;
		if (hasBidDescriptorType()) bidDescriptorType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		bidDescriptorType = FixUtils.longValueOf(src, 0, src.length);
		hasBidDescriptorType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getBidDescriptor() { 		
		if ( hasBidDescriptor()) {		
			if (hasBidDescriptor == FixUtils.TAG_HAS_VALUE) {		
				return bidDescriptor; 		
			} else {		
		
				buf.position(hasBidDescriptor);		
		
			FixMessage.getTagStringValue(buf, bidDescriptor, 0, bidDescriptor.length, err);
		
				if (err.hasError()) {		
					buf.position(hasBidDescriptor);		
					return null;		
				}		
			}		
			hasBidDescriptor = FixUtils.TAG_HAS_VALUE;		
			return bidDescriptor;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasBidDescriptor() { return hasBidDescriptor != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setBidDescriptor(byte[] src) {		
		if (src == null ) return;
		if (hasBidDescriptor()) FixUtils.fillNul(bidDescriptor);		
		FixUtils.copy(bidDescriptor, src); 		
		hasBidDescriptor = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setBidDescriptor(String str) {		
		if (str == null ) return;
		if (hasBidDescriptor()) FixUtils.fillNul(bidDescriptor);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(bidDescriptor, src); 		
		hasBidDescriptor = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getSideValueInd() { 		
		if ( hasSideValueInd()) {		
			if (hasSideValueInd == FixUtils.TAG_HAS_VALUE) {		
				return sideValueInd; 		
			} else {		
		
				buf.position(hasSideValueInd);		
		
			sideValueInd = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasSideValueInd);		
					return 0;		
				}		
			}		
			hasSideValueInd = FixUtils.TAG_HAS_VALUE;		
			return sideValueInd;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSideValueInd() { return hasSideValueInd != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSideValueInd(long src) {		
		sideValueInd = src;
		hasSideValueInd = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSideValueInd(byte[] src) {		
		if (src == null ) return;
		if (hasSideValueInd()) sideValueInd = FixUtils.TAG_HAS_NO_VALUE;		
		sideValueInd = FixUtils.longValueOf(src, 0, src.length);
		hasSideValueInd = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSideValueInd(String str) {		
		if (str == null ) return;
		if (hasSideValueInd()) sideValueInd = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		sideValueInd = FixUtils.longValueOf(src, 0, src.length);
		hasSideValueInd = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLiquidityValue() { 		
		if ( hasLiquidityValue()) {		
			if (hasLiquidityValue == FixUtils.TAG_HAS_VALUE) {		
				return liquidityValue; 		
			} else {		
		
				buf.position(hasLiquidityValue);		
		
			liquidityValue = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLiquidityValue);		
					return 0;		
				}		
			}		
			hasLiquidityValue = FixUtils.TAG_HAS_VALUE;		
			return liquidityValue;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLiquidityValue() { return hasLiquidityValue != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLiquidityValue(long src) {		
		liquidityValue = src;
		hasLiquidityValue = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLiquidityValue(byte[] src) {		
		if (src == null ) return;
		if (hasLiquidityValue()) liquidityValue = FixUtils.TAG_HAS_NO_VALUE;		
		liquidityValue = FixUtils.longValueOf(src, 0, src.length);
		hasLiquidityValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLiquidityValue(String str) {		
		if (str == null ) return;
		if (hasLiquidityValue()) liquidityValue = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		liquidityValue = FixUtils.longValueOf(src, 0, src.length);
		hasLiquidityValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLiquidityNumSecurities() { 		
		if ( hasLiquidityNumSecurities()) {		
			if (hasLiquidityNumSecurities == FixUtils.TAG_HAS_VALUE) {		
				return liquidityNumSecurities; 		
			} else {		
		
				buf.position(hasLiquidityNumSecurities);		
		
			liquidityNumSecurities = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLiquidityNumSecurities);		
					return 0;		
				}		
			}		
			hasLiquidityNumSecurities = FixUtils.TAG_HAS_VALUE;		
			return liquidityNumSecurities;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLiquidityNumSecurities() { return hasLiquidityNumSecurities != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLiquidityNumSecurities(long src) {		
		liquidityNumSecurities = src;
		hasLiquidityNumSecurities = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLiquidityNumSecurities(byte[] src) {		
		if (src == null ) return;
		if (hasLiquidityNumSecurities()) liquidityNumSecurities = FixUtils.TAG_HAS_NO_VALUE;		
		liquidityNumSecurities = FixUtils.longValueOf(src, 0, src.length);
		hasLiquidityNumSecurities = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLiquidityNumSecurities(String str) {		
		if (str == null ) return;
		if (hasLiquidityNumSecurities()) liquidityNumSecurities = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		liquidityNumSecurities = FixUtils.longValueOf(src, 0, src.length);
		hasLiquidityNumSecurities = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLiquidityPctLow() { 		
		if ( hasLiquidityPctLow()) {		
			if (hasLiquidityPctLow == FixUtils.TAG_HAS_VALUE) {		
				return liquidityPctLow; 		
			} else {		
		
				buf.position(hasLiquidityPctLow);		
		
			liquidityPctLow = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLiquidityPctLow);		
					return 0;		
				}		
			}		
			hasLiquidityPctLow = FixUtils.TAG_HAS_VALUE;		
			return liquidityPctLow;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLiquidityPctLow() { return hasLiquidityPctLow != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLiquidityPctLow(long src) {		
		liquidityPctLow = src;
		hasLiquidityPctLow = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLiquidityPctLow(byte[] src) {		
		if (src == null ) return;
		if (hasLiquidityPctLow()) liquidityPctLow = FixUtils.TAG_HAS_NO_VALUE;		
		liquidityPctLow = FixUtils.longValueOf(src, 0, src.length);
		hasLiquidityPctLow = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLiquidityPctLow(String str) {		
		if (str == null ) return;
		if (hasLiquidityPctLow()) liquidityPctLow = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		liquidityPctLow = FixUtils.longValueOf(src, 0, src.length);
		hasLiquidityPctLow = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLiquidityPctHigh() { 		
		if ( hasLiquidityPctHigh()) {		
			if (hasLiquidityPctHigh == FixUtils.TAG_HAS_VALUE) {		
				return liquidityPctHigh; 		
			} else {		
		
				buf.position(hasLiquidityPctHigh);		
		
			liquidityPctHigh = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLiquidityPctHigh);		
					return 0;		
				}		
			}		
			hasLiquidityPctHigh = FixUtils.TAG_HAS_VALUE;		
			return liquidityPctHigh;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLiquidityPctHigh() { return hasLiquidityPctHigh != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLiquidityPctHigh(long src) {		
		liquidityPctHigh = src;
		hasLiquidityPctHigh = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLiquidityPctHigh(byte[] src) {		
		if (src == null ) return;
		if (hasLiquidityPctHigh()) liquidityPctHigh = FixUtils.TAG_HAS_NO_VALUE;		
		liquidityPctHigh = FixUtils.longValueOf(src, 0, src.length);
		hasLiquidityPctHigh = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLiquidityPctHigh(String str) {		
		if (str == null ) return;
		if (hasLiquidityPctHigh()) liquidityPctHigh = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		liquidityPctHigh = FixUtils.longValueOf(src, 0, src.length);
		hasLiquidityPctHigh = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getEFPTrackingError() { 		
		if ( hasEFPTrackingError()) {		
			if (hasEFPTrackingError == FixUtils.TAG_HAS_VALUE) {		
				return eFPTrackingError; 		
			} else {		
		
				buf.position(hasEFPTrackingError);		
		
			eFPTrackingError = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasEFPTrackingError);		
					return 0;		
				}		
			}		
			hasEFPTrackingError = FixUtils.TAG_HAS_VALUE;		
			return eFPTrackingError;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEFPTrackingError() { return hasEFPTrackingError != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEFPTrackingError(long src) {		
		eFPTrackingError = src;
		hasEFPTrackingError = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEFPTrackingError(byte[] src) {		
		if (src == null ) return;
		if (hasEFPTrackingError()) eFPTrackingError = FixUtils.TAG_HAS_NO_VALUE;		
		eFPTrackingError = FixUtils.longValueOf(src, 0, src.length);
		hasEFPTrackingError = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEFPTrackingError(String str) {		
		if (str == null ) return;
		if (hasEFPTrackingError()) eFPTrackingError = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		eFPTrackingError = FixUtils.longValueOf(src, 0, src.length);
		hasEFPTrackingError = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getFairValue() { 		
		if ( hasFairValue()) {		
			if (hasFairValue == FixUtils.TAG_HAS_VALUE) {		
				return fairValue; 		
			} else {		
		
				buf.position(hasFairValue);		
		
			fairValue = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasFairValue);		
					return 0;		
				}		
			}		
			hasFairValue = FixUtils.TAG_HAS_VALUE;		
			return fairValue;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasFairValue() { return hasFairValue != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setFairValue(long src) {		
		fairValue = src;
		hasFairValue = FixUtils.TAG_HAS_VALUE;		
	}

	public void setFairValue(byte[] src) {		
		if (src == null ) return;
		if (hasFairValue()) fairValue = FixUtils.TAG_HAS_NO_VALUE;		
		fairValue = FixUtils.longValueOf(src, 0, src.length);
		hasFairValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setFairValue(String str) {		
		if (str == null ) return;
		if (hasFairValue()) fairValue = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		fairValue = FixUtils.longValueOf(src, 0, src.length);
		hasFairValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getOutsideIndexPct() { 		
		if ( hasOutsideIndexPct()) {		
			if (hasOutsideIndexPct == FixUtils.TAG_HAS_VALUE) {		
				return outsideIndexPct; 		
			} else {		
		
				buf.position(hasOutsideIndexPct);		
		
			outsideIndexPct = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasOutsideIndexPct);		
					return 0;		
				}		
			}		
			hasOutsideIndexPct = FixUtils.TAG_HAS_VALUE;		
			return outsideIndexPct;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasOutsideIndexPct() { return hasOutsideIndexPct != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setOutsideIndexPct(long src) {		
		outsideIndexPct = src;
		hasOutsideIndexPct = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOutsideIndexPct(byte[] src) {		
		if (src == null ) return;
		if (hasOutsideIndexPct()) outsideIndexPct = FixUtils.TAG_HAS_NO_VALUE;		
		outsideIndexPct = FixUtils.longValueOf(src, 0, src.length);
		hasOutsideIndexPct = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setOutsideIndexPct(String str) {		
		if (str == null ) return;
		if (hasOutsideIndexPct()) outsideIndexPct = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		outsideIndexPct = FixUtils.longValueOf(src, 0, src.length);
		hasOutsideIndexPct = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getValueOfFutures() { 		
		if ( hasValueOfFutures()) {		
			if (hasValueOfFutures == FixUtils.TAG_HAS_VALUE) {		
				return valueOfFutures; 		
			} else {		
		
				buf.position(hasValueOfFutures);		
		
			valueOfFutures = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasValueOfFutures);		
					return 0;		
				}		
			}		
			hasValueOfFutures = FixUtils.TAG_HAS_VALUE;		
			return valueOfFutures;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasValueOfFutures() { return hasValueOfFutures != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setValueOfFutures(long src) {		
		valueOfFutures = src;
		hasValueOfFutures = FixUtils.TAG_HAS_VALUE;		
	}

	public void setValueOfFutures(byte[] src) {		
		if (src == null ) return;
		if (hasValueOfFutures()) valueOfFutures = FixUtils.TAG_HAS_NO_VALUE;		
		valueOfFutures = FixUtils.longValueOf(src, 0, src.length);
		hasValueOfFutures = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setValueOfFutures(String str) {		
		if (str == null ) return;
		if (hasValueOfFutures()) valueOfFutures = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		valueOfFutures = FixUtils.longValueOf(src, 0, src.length);
		hasValueOfFutures = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasBidDescriptorType()) s += "BidDescriptorType(399)= " + getBidDescriptorType() + "\n" ; 
		if (hasBidDescriptor()) s += "BidDescriptor(400)= " + new String( FixUtils.trim(getBidDescriptor()) ) + "\n" ; 
		if (hasSideValueInd()) s += "SideValueInd(401)= " + getSideValueInd() + "\n" ; 
		if (hasLiquidityValue()) s += "LiquidityValue(404)= " + getLiquidityValue() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLiquidityNumSecurities()) s += "LiquidityNumSecurities(441)= " + getLiquidityNumSecurities() + "\n" ; 
		if (hasLiquidityPctLow()) s += "LiquidityPctLow(402)= " + getLiquidityPctLow() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLiquidityPctHigh()) s += "LiquidityPctHigh(403)= " + getLiquidityPctHigh() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasEFPTrackingError()) s += "EFPTrackingError(405)= " + getEFPTrackingError() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasFairValue()) s += "FairValue(406)= " + getFairValue() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasOutsideIndexPct()) s += "OutsideIndexPct(407)= " + getOutsideIndexPct() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasValueOfFutures()) s += "ValueOfFutures(408)= " + getValueOfFutures() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixBidDescReqGrp)) return false;

		FixBidDescReqGrp msg = (FixBidDescReqGrp) o;

		if ((hasBidDescriptorType() && !msg.hasBidDescriptorType()) || (!hasBidDescriptorType() && msg.hasBidDescriptorType())) return false;
		if (!(!hasBidDescriptorType() && !msg.hasBidDescriptorType()) && !(getBidDescriptorType()==msg.getBidDescriptorType())) return false;
		if ((hasBidDescriptor() && !msg.hasBidDescriptor()) || (!hasBidDescriptor() && msg.hasBidDescriptor())) return false;
		if (!(!hasBidDescriptor() && !msg.hasBidDescriptor()) && !FixUtils.equals(getBidDescriptor(), msg.getBidDescriptor())) return false;
		if ((hasSideValueInd() && !msg.hasSideValueInd()) || (!hasSideValueInd() && msg.hasSideValueInd())) return false;
		if (!(!hasSideValueInd() && !msg.hasSideValueInd()) && !(getSideValueInd()==msg.getSideValueInd())) return false;
		if ((hasLiquidityValue() && !msg.hasLiquidityValue()) || (!hasLiquidityValue() && msg.hasLiquidityValue())) return false;
		if (!(!hasLiquidityValue() && !msg.hasLiquidityValue()) && !(getLiquidityValue()==msg.getLiquidityValue())) return false;
		if ((hasLiquidityNumSecurities() && !msg.hasLiquidityNumSecurities()) || (!hasLiquidityNumSecurities() && msg.hasLiquidityNumSecurities())) return false;
		if (!(!hasLiquidityNumSecurities() && !msg.hasLiquidityNumSecurities()) && !(getLiquidityNumSecurities()==msg.getLiquidityNumSecurities())) return false;
		if ((hasLiquidityPctLow() && !msg.hasLiquidityPctLow()) || (!hasLiquidityPctLow() && msg.hasLiquidityPctLow())) return false;
		if (!(!hasLiquidityPctLow() && !msg.hasLiquidityPctLow()) && !(getLiquidityPctLow()==msg.getLiquidityPctLow())) return false;
		if ((hasLiquidityPctHigh() && !msg.hasLiquidityPctHigh()) || (!hasLiquidityPctHigh() && msg.hasLiquidityPctHigh())) return false;
		if (!(!hasLiquidityPctHigh() && !msg.hasLiquidityPctHigh()) && !(getLiquidityPctHigh()==msg.getLiquidityPctHigh())) return false;
		if ((hasEFPTrackingError() && !msg.hasEFPTrackingError()) || (!hasEFPTrackingError() && msg.hasEFPTrackingError())) return false;
		if (!(!hasEFPTrackingError() && !msg.hasEFPTrackingError()) && !(getEFPTrackingError()==msg.getEFPTrackingError())) return false;
		if ((hasFairValue() && !msg.hasFairValue()) || (!hasFairValue() && msg.hasFairValue())) return false;
		if (!(!hasFairValue() && !msg.hasFairValue()) && !(getFairValue()==msg.getFairValue())) return false;
		if ((hasOutsideIndexPct() && !msg.hasOutsideIndexPct()) || (!hasOutsideIndexPct() && msg.hasOutsideIndexPct())) return false;
		if (!(!hasOutsideIndexPct() && !msg.hasOutsideIndexPct()) && !(getOutsideIndexPct()==msg.getOutsideIndexPct())) return false;
		if ((hasValueOfFutures() && !msg.hasValueOfFutures()) || (!hasValueOfFutures() && msg.hasValueOfFutures())) return false;
		if (!(!hasValueOfFutures() && !msg.hasValueOfFutures()) && !(getValueOfFutures()==msg.getValueOfFutures())) return false;
		return true;
	}
	public FixBidDescReqGrp clone ( FixBidDescReqGrp out ) {
		if ( hasBidDescriptorType())
			out.setBidDescriptorType(getBidDescriptorType());
		if ( hasBidDescriptor())
			out.setBidDescriptor(getBidDescriptor());
		if ( hasSideValueInd())
			out.setSideValueInd(getSideValueInd());
		if ( hasLiquidityValue())
			out.setLiquidityValue(getLiquidityValue());
		if ( hasLiquidityNumSecurities())
			out.setLiquidityNumSecurities(getLiquidityNumSecurities());
		if ( hasLiquidityPctLow())
			out.setLiquidityPctLow(getLiquidityPctLow());
		if ( hasLiquidityPctHigh())
			out.setLiquidityPctHigh(getLiquidityPctHigh());
		if ( hasEFPTrackingError())
			out.setEFPTrackingError(getEFPTrackingError());
		if ( hasFairValue())
			out.setFairValue(getFairValue());
		if ( hasOutsideIndexPct())
			out.setOutsideIndexPct(getOutsideIndexPct());
		if ( hasValueOfFutures())
			out.setValueOfFutures(getValueOfFutures());
		return out;
	}

}
