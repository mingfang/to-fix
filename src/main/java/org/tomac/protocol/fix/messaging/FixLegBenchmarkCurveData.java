package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixLegBenchmarkCurveData extends FixGroup {
	private short hasLegBenchmarkCurveCurrency;
	byte[] legBenchmarkCurveCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasLegBenchmarkCurveName;
	byte[] legBenchmarkCurveName = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegBenchmarkCurvePoint;
	byte[] legBenchmarkCurvePoint = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasLegBenchmarkPrice;
	long legBenchmarkPrice = 0;		
	private short hasLegBenchmarkPriceType;
	long legBenchmarkPriceType = 0;		
	
	public FixLegBenchmarkCurveData() {
		this(false);
	}

	public FixLegBenchmarkCurveData(boolean isRequired) {
		super(FixTags.LEGBENCHMARKCURVECURRENCY_INT);

		this.isRequired = isRequired;
		
		hasLegBenchmarkCurveCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		legBenchmarkCurveCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasLegBenchmarkCurveName = FixUtils.TAG_HAS_NO_VALUE;		
		legBenchmarkCurveName = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegBenchmarkCurvePoint = FixUtils.TAG_HAS_NO_VALUE;		
		legBenchmarkCurvePoint = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasLegBenchmarkPrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasLegBenchmarkPriceType = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasLegBenchmarkCurveCurrency()) return true;
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
            	case FixTags.LEGBENCHMARKCURVECURRENCY_INT:		
            		hasLegBenchmarkCurveCurrency = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGBENCHMARKCURVENAME_INT:		
            		hasLegBenchmarkCurveName = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGBENCHMARKCURVEPOINT_INT:		
            		hasLegBenchmarkCurvePoint = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGBENCHMARKPRICE_INT:		
            		hasLegBenchmarkPrice = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.LEGBENCHMARKPRICETYPE_INT:		
            		hasLegBenchmarkPriceType = (short) buf.position();		
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
		hasLegBenchmarkCurveCurrency = FixUtils.TAG_HAS_NO_VALUE;
		hasLegBenchmarkCurveName = FixUtils.TAG_HAS_NO_VALUE;
		hasLegBenchmarkCurvePoint = FixUtils.TAG_HAS_NO_VALUE;
		hasLegBenchmarkPrice = FixUtils.TAG_HAS_NO_VALUE;
		hasLegBenchmarkPriceType = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasLegBenchmarkCurveCurrency()) {		
			out.put(FixTags.LEGBENCHMARKCURVECURRENCY);

			out.put((byte) '=');

			FixUtils.put(out,legBenchmarkCurveCurrency); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegBenchmarkCurveName()) {		
			out.put(FixTags.LEGBENCHMARKCURVENAME);

			out.put((byte) '=');

			FixUtils.put(out,legBenchmarkCurveName); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegBenchmarkCurvePoint()) {		
			out.put(FixTags.LEGBENCHMARKCURVEPOINT);

			out.put((byte) '=');

			FixUtils.put(out,legBenchmarkCurvePoint); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasLegBenchmarkPrice()) {		
			out.put(FixTags.LEGBENCHMARKPRICE);

			out.put((byte) '=');

			FixUtils.put(out, (long)legBenchmarkPrice);
		
			out.put(FixUtils.SOH);

            }

		if (hasLegBenchmarkPriceType()) {		
			out.put(FixTags.LEGBENCHMARKPRICETYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)legBenchmarkPriceType);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasLegBenchmarkCurveCurrency()) {		
			FixUtils.put(out,legBenchmarkCurveCurrency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegBenchmarkCurveName()) {		
			FixUtils.put(out,legBenchmarkCurveName); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegBenchmarkCurvePoint()) {		
			FixUtils.put(out,legBenchmarkCurvePoint); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegBenchmarkPrice()) {		
			FixUtils.put(out, (long)legBenchmarkPrice);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLegBenchmarkPriceType()) {		
			FixUtils.put(out, (long)legBenchmarkPriceType);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getLegBenchmarkCurveCurrency() { 		
		if ( hasLegBenchmarkCurveCurrency()) {		
			if (hasLegBenchmarkCurveCurrency == FixUtils.TAG_HAS_VALUE) {		
				return legBenchmarkCurveCurrency; 		
			} else {		
		
				buf.position(hasLegBenchmarkCurveCurrency);		
		
			FixMessage.getTagStringValue(buf, legBenchmarkCurveCurrency, 0, legBenchmarkCurveCurrency.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegBenchmarkCurveCurrency);		
					return null;		
				}		
			}		
			hasLegBenchmarkCurveCurrency = FixUtils.TAG_HAS_VALUE;		
			return legBenchmarkCurveCurrency;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegBenchmarkCurveCurrency() { return hasLegBenchmarkCurveCurrency != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegBenchmarkCurveCurrency(byte[] src) {		
		if (src == null ) return;
		if (hasLegBenchmarkCurveCurrency()) FixUtils.fillSpace(legBenchmarkCurveCurrency);		
		FixUtils.copy(legBenchmarkCurveCurrency, src); 		
		hasLegBenchmarkCurveCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegBenchmarkCurveCurrency(String str) {		
		if (str == null ) return;
		if (hasLegBenchmarkCurveCurrency()) FixUtils.fillSpace(legBenchmarkCurveCurrency);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legBenchmarkCurveCurrency, src); 		
		hasLegBenchmarkCurveCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegBenchmarkCurveName() { 		
		if ( hasLegBenchmarkCurveName()) {		
			if (hasLegBenchmarkCurveName == FixUtils.TAG_HAS_VALUE) {		
				return legBenchmarkCurveName; 		
			} else {		
		
				buf.position(hasLegBenchmarkCurveName);		
		
			FixMessage.getTagStringValue(buf, legBenchmarkCurveName, 0, legBenchmarkCurveName.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegBenchmarkCurveName);		
					return null;		
				}		
			}		
			hasLegBenchmarkCurveName = FixUtils.TAG_HAS_VALUE;		
			return legBenchmarkCurveName;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegBenchmarkCurveName() { return hasLegBenchmarkCurveName != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegBenchmarkCurveName(byte[] src) {		
		if (src == null ) return;
		if (hasLegBenchmarkCurveName()) FixUtils.fillSpace(legBenchmarkCurveName);		
		FixUtils.copy(legBenchmarkCurveName, src); 		
		hasLegBenchmarkCurveName = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegBenchmarkCurveName(String str) {		
		if (str == null ) return;
		if (hasLegBenchmarkCurveName()) FixUtils.fillSpace(legBenchmarkCurveName);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legBenchmarkCurveName, src); 		
		hasLegBenchmarkCurveName = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getLegBenchmarkCurvePoint() { 		
		if ( hasLegBenchmarkCurvePoint()) {		
			if (hasLegBenchmarkCurvePoint == FixUtils.TAG_HAS_VALUE) {		
				return legBenchmarkCurvePoint; 		
			} else {		
		
				buf.position(hasLegBenchmarkCurvePoint);		
		
			FixMessage.getTagStringValue(buf, legBenchmarkCurvePoint, 0, legBenchmarkCurvePoint.length, err);
		
				if (err.hasError()) {		
					buf.position(hasLegBenchmarkCurvePoint);		
					return null;		
				}		
			}		
			hasLegBenchmarkCurvePoint = FixUtils.TAG_HAS_VALUE;		
			return legBenchmarkCurvePoint;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasLegBenchmarkCurvePoint() { return hasLegBenchmarkCurvePoint != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegBenchmarkCurvePoint(byte[] src) {		
		if (src == null ) return;
		if (hasLegBenchmarkCurvePoint()) FixUtils.fillSpace(legBenchmarkCurvePoint);		
		FixUtils.copy(legBenchmarkCurvePoint, src); 		
		hasLegBenchmarkCurvePoint = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegBenchmarkCurvePoint(String str) {		
		if (str == null ) return;
		if (hasLegBenchmarkCurvePoint()) FixUtils.fillSpace(legBenchmarkCurvePoint);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(legBenchmarkCurvePoint, src); 		
		hasLegBenchmarkCurvePoint = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegBenchmarkPrice() { 		
		if ( hasLegBenchmarkPrice()) {		
			if (hasLegBenchmarkPrice == FixUtils.TAG_HAS_VALUE) {		
				return legBenchmarkPrice; 		
			} else {		
		
				buf.position(hasLegBenchmarkPrice);		
		
			legBenchmarkPrice = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegBenchmarkPrice);		
					return 0;		
				}		
			}		
			hasLegBenchmarkPrice = FixUtils.TAG_HAS_VALUE;		
			return legBenchmarkPrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegBenchmarkPrice() { return hasLegBenchmarkPrice != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegBenchmarkPrice(long src) {		
		legBenchmarkPrice = src;
		hasLegBenchmarkPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegBenchmarkPrice(byte[] src) {		
		if (src == null ) return;
		if (hasLegBenchmarkPrice()) legBenchmarkPrice = FixUtils.TAG_HAS_NO_VALUE;		
		legBenchmarkPrice = FixUtils.longValueOf(src, 0, src.length);
		hasLegBenchmarkPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegBenchmarkPrice(String str) {		
		if (str == null ) return;
		if (hasLegBenchmarkPrice()) legBenchmarkPrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legBenchmarkPrice = FixUtils.longValueOf(src, 0, src.length);
		hasLegBenchmarkPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getLegBenchmarkPriceType() { 		
		if ( hasLegBenchmarkPriceType()) {		
			if (hasLegBenchmarkPriceType == FixUtils.TAG_HAS_VALUE) {		
				return legBenchmarkPriceType; 		
			} else {		
		
				buf.position(hasLegBenchmarkPriceType);		
		
			legBenchmarkPriceType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasLegBenchmarkPriceType);		
					return 0;		
				}		
			}		
			hasLegBenchmarkPriceType = FixUtils.TAG_HAS_VALUE;		
			return legBenchmarkPriceType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasLegBenchmarkPriceType() { return hasLegBenchmarkPriceType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setLegBenchmarkPriceType(long src) {		
		legBenchmarkPriceType = src;
		hasLegBenchmarkPriceType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLegBenchmarkPriceType(byte[] src) {		
		if (src == null ) return;
		if (hasLegBenchmarkPriceType()) legBenchmarkPriceType = FixUtils.TAG_HAS_NO_VALUE;		
		legBenchmarkPriceType = FixUtils.longValueOf(src, 0, src.length);
		hasLegBenchmarkPriceType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setLegBenchmarkPriceType(String str) {		
		if (str == null ) return;
		if (hasLegBenchmarkPriceType()) legBenchmarkPriceType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		legBenchmarkPriceType = FixUtils.longValueOf(src, 0, src.length);
		hasLegBenchmarkPriceType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasLegBenchmarkCurveCurrency()) s += "LegBenchmarkCurveCurrency(676)= " + new String( FixUtils.trim(getLegBenchmarkCurveCurrency()) ) + "\n" ; 
		if (hasLegBenchmarkCurveName()) s += "LegBenchmarkCurveName(677)= " + new String( FixUtils.trim(getLegBenchmarkCurveName()) ) + "\n" ; 
		if (hasLegBenchmarkCurvePoint()) s += "LegBenchmarkCurvePoint(678)= " + new String( FixUtils.trim(getLegBenchmarkCurvePoint()) ) + "\n" ; 
		if (hasLegBenchmarkPrice()) s += "LegBenchmarkPrice(679)= " + getLegBenchmarkPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLegBenchmarkPriceType()) s += "LegBenchmarkPriceType(680)= " + getLegBenchmarkPriceType() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixLegBenchmarkCurveData)) return false;

		FixLegBenchmarkCurveData msg = (FixLegBenchmarkCurveData) o;

		if ((hasLegBenchmarkCurveCurrency() && !msg.hasLegBenchmarkCurveCurrency()) || (!hasLegBenchmarkCurveCurrency() && msg.hasLegBenchmarkCurveCurrency())) return false;
		if (!(!hasLegBenchmarkCurveCurrency() && !msg.hasLegBenchmarkCurveCurrency()) && !FixUtils.equals(getLegBenchmarkCurveCurrency(), msg.getLegBenchmarkCurveCurrency())) return false;
		if ((hasLegBenchmarkCurveName() && !msg.hasLegBenchmarkCurveName()) || (!hasLegBenchmarkCurveName() && msg.hasLegBenchmarkCurveName())) return false;
		if (!(!hasLegBenchmarkCurveName() && !msg.hasLegBenchmarkCurveName()) && !FixUtils.equals(getLegBenchmarkCurveName(), msg.getLegBenchmarkCurveName())) return false;
		if ((hasLegBenchmarkCurvePoint() && !msg.hasLegBenchmarkCurvePoint()) || (!hasLegBenchmarkCurvePoint() && msg.hasLegBenchmarkCurvePoint())) return false;
		if (!(!hasLegBenchmarkCurvePoint() && !msg.hasLegBenchmarkCurvePoint()) && !FixUtils.equals(getLegBenchmarkCurvePoint(), msg.getLegBenchmarkCurvePoint())) return false;
		if ((hasLegBenchmarkPrice() && !msg.hasLegBenchmarkPrice()) || (!hasLegBenchmarkPrice() && msg.hasLegBenchmarkPrice())) return false;
		if (!(!hasLegBenchmarkPrice() && !msg.hasLegBenchmarkPrice()) && !(getLegBenchmarkPrice()==msg.getLegBenchmarkPrice())) return false;
		if ((hasLegBenchmarkPriceType() && !msg.hasLegBenchmarkPriceType()) || (!hasLegBenchmarkPriceType() && msg.hasLegBenchmarkPriceType())) return false;
		if (!(!hasLegBenchmarkPriceType() && !msg.hasLegBenchmarkPriceType()) && !(getLegBenchmarkPriceType()==msg.getLegBenchmarkPriceType())) return false;
		return true;
	}
	public FixLegBenchmarkCurveData clone ( FixLegBenchmarkCurveData out ) {
		if ( hasLegBenchmarkCurveCurrency())
			out.setLegBenchmarkCurveCurrency(getLegBenchmarkCurveCurrency());
		if ( hasLegBenchmarkCurveName())
			out.setLegBenchmarkCurveName(getLegBenchmarkCurveName());
		if ( hasLegBenchmarkCurvePoint())
			out.setLegBenchmarkCurvePoint(getLegBenchmarkCurvePoint());
		if ( hasLegBenchmarkPrice())
			out.setLegBenchmarkPrice(getLegBenchmarkPrice());
		if ( hasLegBenchmarkPriceType())
			out.setLegBenchmarkPriceType(getLegBenchmarkPriceType());
		return out;
	}

}
