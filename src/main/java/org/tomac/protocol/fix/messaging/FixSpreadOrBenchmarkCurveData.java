package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixSpreadOrBenchmarkCurveData extends FixGroup {
	private short hasSpread;
	long spread = 0;		
	private short hasBenchmarkCurveCurrency;
	byte[] benchmarkCurveCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasBenchmarkCurveName;
	byte[] benchmarkCurveName = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasBenchmarkCurvePoint;
	byte[] benchmarkCurvePoint = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasBenchmarkPrice;
	long benchmarkPrice = 0;		
	private short hasBenchmarkPriceType;
	long benchmarkPriceType = 0;		
	private short hasBenchmarkSecurityID;
	byte[] benchmarkSecurityID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasBenchmarkSecurityIDSource;
	byte[] benchmarkSecurityIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixSpreadOrBenchmarkCurveData() {
		this(false);
	}

	public FixSpreadOrBenchmarkCurveData(boolean isRequired) {
		super(FixTags.SPREAD_INT);

		this.isRequired = isRequired;
		
		hasSpread = FixUtils.TAG_HAS_NO_VALUE;		
		hasBenchmarkCurveCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		benchmarkCurveCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasBenchmarkCurveName = FixUtils.TAG_HAS_NO_VALUE;		
		benchmarkCurveName = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasBenchmarkCurvePoint = FixUtils.TAG_HAS_NO_VALUE;		
		benchmarkCurvePoint = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasBenchmarkPrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasBenchmarkPriceType = FixUtils.TAG_HAS_NO_VALUE;		
		hasBenchmarkSecurityID = FixUtils.TAG_HAS_NO_VALUE;		
		benchmarkSecurityID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasBenchmarkSecurityIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		benchmarkSecurityIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasSpread()) return true;
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
            	case FixTags.SPREAD_INT:		
            		hasSpread = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.BENCHMARKCURVECURRENCY_INT:		
            		hasBenchmarkCurveCurrency = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.BENCHMARKCURVENAME_INT:		
            		hasBenchmarkCurveName = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.BENCHMARKCURVEPOINT_INT:		
            		hasBenchmarkCurvePoint = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.BENCHMARKPRICE_INT:		
            		hasBenchmarkPrice = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.BENCHMARKPRICETYPE_INT:		
            		hasBenchmarkPriceType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.BENCHMARKSECURITYID_INT:		
            		hasBenchmarkSecurityID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.BENCHMARKSECURITYIDSOURCE_INT:		
            		hasBenchmarkSecurityIDSource = (short) buf.position();		
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
		hasSpread = FixUtils.TAG_HAS_NO_VALUE;
		hasBenchmarkCurveCurrency = FixUtils.TAG_HAS_NO_VALUE;
		hasBenchmarkCurveName = FixUtils.TAG_HAS_NO_VALUE;
		hasBenchmarkCurvePoint = FixUtils.TAG_HAS_NO_VALUE;
		hasBenchmarkPrice = FixUtils.TAG_HAS_NO_VALUE;
		hasBenchmarkPriceType = FixUtils.TAG_HAS_NO_VALUE;
		hasBenchmarkSecurityID = FixUtils.TAG_HAS_NO_VALUE;
		hasBenchmarkSecurityIDSource = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasSpread()) {		
			out.put(FixTags.SPREAD);

			out.put((byte) '=');

			FixUtils.put(out, (long)spread);
		
			out.put(FixUtils.SOH);

            }

		if (hasBenchmarkCurveCurrency()) {		
			out.put(FixTags.BENCHMARKCURVECURRENCY);

			out.put((byte) '=');

			FixUtils.put(out,benchmarkCurveCurrency); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasBenchmarkCurveName()) {		
			out.put(FixTags.BENCHMARKCURVENAME);

			out.put((byte) '=');

			FixUtils.put(out,benchmarkCurveName); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasBenchmarkCurvePoint()) {		
			out.put(FixTags.BENCHMARKCURVEPOINT);

			out.put((byte) '=');

			FixUtils.put(out,benchmarkCurvePoint); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasBenchmarkPrice()) {		
			out.put(FixTags.BENCHMARKPRICE);

			out.put((byte) '=');

			FixUtils.put(out, (long)benchmarkPrice);
		
			out.put(FixUtils.SOH);

            }

		if (hasBenchmarkPriceType()) {		
			out.put(FixTags.BENCHMARKPRICETYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)benchmarkPriceType);
		
			out.put(FixUtils.SOH);

            }

		if (hasBenchmarkSecurityID()) {		
			out.put(FixTags.BENCHMARKSECURITYID);

			out.put((byte) '=');

			FixUtils.put(out,benchmarkSecurityID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasBenchmarkSecurityIDSource()) {		
			out.put(FixTags.BENCHMARKSECURITYIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,benchmarkSecurityIDSource); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasSpread()) {		
			FixUtils.put(out, (long)spread);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBenchmarkCurveCurrency()) {		
			FixUtils.put(out,benchmarkCurveCurrency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBenchmarkCurveName()) {		
			FixUtils.put(out,benchmarkCurveName); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBenchmarkCurvePoint()) {		
			FixUtils.put(out,benchmarkCurvePoint); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBenchmarkPrice()) {		
			FixUtils.put(out, (long)benchmarkPrice);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBenchmarkPriceType()) {		
			FixUtils.put(out, (long)benchmarkPriceType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBenchmarkSecurityID()) {		
			FixUtils.put(out,benchmarkSecurityID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasBenchmarkSecurityIDSource()) {		
			FixUtils.put(out,benchmarkSecurityIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getSpread() { 		
		if ( hasSpread()) {		
			if (hasSpread == FixUtils.TAG_HAS_VALUE) {		
				return spread; 		
			} else {		
		
				buf.position(hasSpread);		
		
			spread = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasSpread);		
					return 0;		
				}		
			}		
			hasSpread = FixUtils.TAG_HAS_VALUE;		
			return spread;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSpread() { return hasSpread != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSpread(long src) {		
		spread = src;
		hasSpread = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSpread(byte[] src) {		
		if (src == null ) return;
		if (hasSpread()) spread = FixUtils.TAG_HAS_NO_VALUE;		
		spread = FixUtils.longValueOf(src, 0, src.length);
		hasSpread = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSpread(String str) {		
		if (str == null ) return;
		if (hasSpread()) spread = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		spread = FixUtils.longValueOf(src, 0, src.length);
		hasSpread = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getBenchmarkCurveCurrency() { 		
		if ( hasBenchmarkCurveCurrency()) {		
			if (hasBenchmarkCurveCurrency == FixUtils.TAG_HAS_VALUE) {		
				return benchmarkCurveCurrency; 		
			} else {		
		
				buf.position(hasBenchmarkCurveCurrency);		
		
			FixUtils.getTagStringValue(buf, benchmarkCurveCurrency, 0, benchmarkCurveCurrency.length, err);
		
				if (err.hasError()) {		
					buf.position(hasBenchmarkCurveCurrency);		
					return null;		
				}		
			}		
			hasBenchmarkCurveCurrency = FixUtils.TAG_HAS_VALUE;		
			return benchmarkCurveCurrency;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasBenchmarkCurveCurrency() { return hasBenchmarkCurveCurrency != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setBenchmarkCurveCurrency(byte[] src) {		
		if (src == null ) return;
		if (hasBenchmarkCurveCurrency()) FixUtils.fillNul(benchmarkCurveCurrency);		
		FixUtils.copy(benchmarkCurveCurrency, src); 		
		hasBenchmarkCurveCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setBenchmarkCurveCurrency(String str) {		
		if (str == null ) return;
		if (hasBenchmarkCurveCurrency()) FixUtils.fillNul(benchmarkCurveCurrency);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(benchmarkCurveCurrency, src); 		
		hasBenchmarkCurveCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getBenchmarkCurveName() { 		
		if ( hasBenchmarkCurveName()) {		
			if (hasBenchmarkCurveName == FixUtils.TAG_HAS_VALUE) {		
				return benchmarkCurveName; 		
			} else {		
		
				buf.position(hasBenchmarkCurveName);		
		
			FixUtils.getTagStringValue(buf, benchmarkCurveName, 0, benchmarkCurveName.length, err);
		
				if (err.hasError()) {		
					buf.position(hasBenchmarkCurveName);		
					return null;		
				}		
			}		
			hasBenchmarkCurveName = FixUtils.TAG_HAS_VALUE;		
			return benchmarkCurveName;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasBenchmarkCurveName() { return hasBenchmarkCurveName != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setBenchmarkCurveName(byte[] src) {		
		if (src == null ) return;
		if (hasBenchmarkCurveName()) FixUtils.fillNul(benchmarkCurveName);		
		FixUtils.copy(benchmarkCurveName, src); 		
		hasBenchmarkCurveName = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setBenchmarkCurveName(String str) {		
		if (str == null ) return;
		if (hasBenchmarkCurveName()) FixUtils.fillNul(benchmarkCurveName);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(benchmarkCurveName, src); 		
		hasBenchmarkCurveName = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getBenchmarkCurvePoint() { 		
		if ( hasBenchmarkCurvePoint()) {		
			if (hasBenchmarkCurvePoint == FixUtils.TAG_HAS_VALUE) {		
				return benchmarkCurvePoint; 		
			} else {		
		
				buf.position(hasBenchmarkCurvePoint);		
		
			FixUtils.getTagStringValue(buf, benchmarkCurvePoint, 0, benchmarkCurvePoint.length, err);
		
				if (err.hasError()) {		
					buf.position(hasBenchmarkCurvePoint);		
					return null;		
				}		
			}		
			hasBenchmarkCurvePoint = FixUtils.TAG_HAS_VALUE;		
			return benchmarkCurvePoint;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasBenchmarkCurvePoint() { return hasBenchmarkCurvePoint != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setBenchmarkCurvePoint(byte[] src) {		
		if (src == null ) return;
		if (hasBenchmarkCurvePoint()) FixUtils.fillNul(benchmarkCurvePoint);		
		FixUtils.copy(benchmarkCurvePoint, src); 		
		hasBenchmarkCurvePoint = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setBenchmarkCurvePoint(String str) {		
		if (str == null ) return;
		if (hasBenchmarkCurvePoint()) FixUtils.fillNul(benchmarkCurvePoint);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(benchmarkCurvePoint, src); 		
		hasBenchmarkCurvePoint = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getBenchmarkPrice() { 		
		if ( hasBenchmarkPrice()) {		
			if (hasBenchmarkPrice == FixUtils.TAG_HAS_VALUE) {		
				return benchmarkPrice; 		
			} else {		
		
				buf.position(hasBenchmarkPrice);		
		
			benchmarkPrice = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasBenchmarkPrice);		
					return 0;		
				}		
			}		
			hasBenchmarkPrice = FixUtils.TAG_HAS_VALUE;		
			return benchmarkPrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasBenchmarkPrice() { return hasBenchmarkPrice != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setBenchmarkPrice(long src) {		
		benchmarkPrice = src;
		hasBenchmarkPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBenchmarkPrice(byte[] src) {		
		if (src == null ) return;
		if (hasBenchmarkPrice()) benchmarkPrice = FixUtils.TAG_HAS_NO_VALUE;		
		benchmarkPrice = FixUtils.longValueOf(src, 0, src.length);
		hasBenchmarkPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setBenchmarkPrice(String str) {		
		if (str == null ) return;
		if (hasBenchmarkPrice()) benchmarkPrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		benchmarkPrice = FixUtils.longValueOf(src, 0, src.length);
		hasBenchmarkPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getBenchmarkPriceType() { 		
		if ( hasBenchmarkPriceType()) {		
			if (hasBenchmarkPriceType == FixUtils.TAG_HAS_VALUE) {		
				return benchmarkPriceType; 		
			} else {		
		
				buf.position(hasBenchmarkPriceType);		
		
			benchmarkPriceType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasBenchmarkPriceType);		
					return 0;		
				}		
			}		
			hasBenchmarkPriceType = FixUtils.TAG_HAS_VALUE;		
			return benchmarkPriceType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasBenchmarkPriceType() { return hasBenchmarkPriceType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setBenchmarkPriceType(long src) {		
		benchmarkPriceType = src;
		hasBenchmarkPriceType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setBenchmarkPriceType(byte[] src) {		
		if (src == null ) return;
		if (hasBenchmarkPriceType()) benchmarkPriceType = FixUtils.TAG_HAS_NO_VALUE;		
		benchmarkPriceType = FixUtils.longValueOf(src, 0, src.length);
		hasBenchmarkPriceType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setBenchmarkPriceType(String str) {		
		if (str == null ) return;
		if (hasBenchmarkPriceType()) benchmarkPriceType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		benchmarkPriceType = FixUtils.longValueOf(src, 0, src.length);
		hasBenchmarkPriceType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getBenchmarkSecurityID() { 		
		if ( hasBenchmarkSecurityID()) {		
			if (hasBenchmarkSecurityID == FixUtils.TAG_HAS_VALUE) {		
				return benchmarkSecurityID; 		
			} else {		
		
				buf.position(hasBenchmarkSecurityID);		
		
			FixUtils.getTagStringValue(buf, benchmarkSecurityID, 0, benchmarkSecurityID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasBenchmarkSecurityID);		
					return null;		
				}		
			}		
			hasBenchmarkSecurityID = FixUtils.TAG_HAS_VALUE;		
			return benchmarkSecurityID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasBenchmarkSecurityID() { return hasBenchmarkSecurityID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setBenchmarkSecurityID(byte[] src) {		
		if (src == null ) return;
		if (hasBenchmarkSecurityID()) FixUtils.fillNul(benchmarkSecurityID);		
		FixUtils.copy(benchmarkSecurityID, src); 		
		hasBenchmarkSecurityID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setBenchmarkSecurityID(String str) {		
		if (str == null ) return;
		if (hasBenchmarkSecurityID()) FixUtils.fillNul(benchmarkSecurityID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(benchmarkSecurityID, src); 		
		hasBenchmarkSecurityID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getBenchmarkSecurityIDSource() { 		
		if ( hasBenchmarkSecurityIDSource()) {		
			if (hasBenchmarkSecurityIDSource == FixUtils.TAG_HAS_VALUE) {		
				return benchmarkSecurityIDSource; 		
			} else {		
		
				buf.position(hasBenchmarkSecurityIDSource);		
		
			FixUtils.getTagStringValue(buf, benchmarkSecurityIDSource, 0, benchmarkSecurityIDSource.length, err);
		
				if (err.hasError()) {		
					buf.position(hasBenchmarkSecurityIDSource);		
					return null;		
				}		
			}		
			hasBenchmarkSecurityIDSource = FixUtils.TAG_HAS_VALUE;		
			return benchmarkSecurityIDSource;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasBenchmarkSecurityIDSource() { return hasBenchmarkSecurityIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setBenchmarkSecurityIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasBenchmarkSecurityIDSource()) FixUtils.fillNul(benchmarkSecurityIDSource);		
		FixUtils.copy(benchmarkSecurityIDSource, src); 		
		hasBenchmarkSecurityIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setBenchmarkSecurityIDSource(String str) {		
		if (str == null ) return;
		if (hasBenchmarkSecurityIDSource()) FixUtils.fillNul(benchmarkSecurityIDSource);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(benchmarkSecurityIDSource, src); 		
		hasBenchmarkSecurityIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasSpread()) s += "Spread(218)= " + getSpread() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasBenchmarkCurveCurrency()) s += "BenchmarkCurveCurrency(220)= " + new String( FixUtils.trim(getBenchmarkCurveCurrency()) ) + "\n" ; 
		if (hasBenchmarkCurveName()) s += "BenchmarkCurveName(221)= " + new String( FixUtils.trim(getBenchmarkCurveName()) ) + "\n" ; 
		if (hasBenchmarkCurvePoint()) s += "BenchmarkCurvePoint(222)= " + new String( FixUtils.trim(getBenchmarkCurvePoint()) ) + "\n" ; 
		if (hasBenchmarkPrice()) s += "BenchmarkPrice(662)= " + getBenchmarkPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasBenchmarkPriceType()) s += "BenchmarkPriceType(663)= " + getBenchmarkPriceType() + "\n" ; 
		if (hasBenchmarkSecurityID()) s += "BenchmarkSecurityID(699)= " + new String( FixUtils.trim(getBenchmarkSecurityID()) ) + "\n" ; 
		if (hasBenchmarkSecurityIDSource()) s += "BenchmarkSecurityIDSource(761)= " + new String( FixUtils.trim(getBenchmarkSecurityIDSource()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixSpreadOrBenchmarkCurveData)) return false;

		FixSpreadOrBenchmarkCurveData msg = (FixSpreadOrBenchmarkCurveData) o;

		if ((hasSpread() && !msg.hasSpread()) || (!hasSpread() && msg.hasSpread())) return false;
		if (!(!hasSpread() && !msg.hasSpread()) && !(getSpread()==msg.getSpread())) return false;
		if ((hasBenchmarkCurveCurrency() && !msg.hasBenchmarkCurveCurrency()) || (!hasBenchmarkCurveCurrency() && msg.hasBenchmarkCurveCurrency())) return false;
		if (!(!hasBenchmarkCurveCurrency() && !msg.hasBenchmarkCurveCurrency()) && !FixUtils.equals(getBenchmarkCurveCurrency(), msg.getBenchmarkCurveCurrency())) return false;
		if ((hasBenchmarkCurveName() && !msg.hasBenchmarkCurveName()) || (!hasBenchmarkCurveName() && msg.hasBenchmarkCurveName())) return false;
		if (!(!hasBenchmarkCurveName() && !msg.hasBenchmarkCurveName()) && !FixUtils.equals(getBenchmarkCurveName(), msg.getBenchmarkCurveName())) return false;
		if ((hasBenchmarkCurvePoint() && !msg.hasBenchmarkCurvePoint()) || (!hasBenchmarkCurvePoint() && msg.hasBenchmarkCurvePoint())) return false;
		if (!(!hasBenchmarkCurvePoint() && !msg.hasBenchmarkCurvePoint()) && !FixUtils.equals(getBenchmarkCurvePoint(), msg.getBenchmarkCurvePoint())) return false;
		if ((hasBenchmarkPrice() && !msg.hasBenchmarkPrice()) || (!hasBenchmarkPrice() && msg.hasBenchmarkPrice())) return false;
		if (!(!hasBenchmarkPrice() && !msg.hasBenchmarkPrice()) && !(getBenchmarkPrice()==msg.getBenchmarkPrice())) return false;
		if ((hasBenchmarkPriceType() && !msg.hasBenchmarkPriceType()) || (!hasBenchmarkPriceType() && msg.hasBenchmarkPriceType())) return false;
		if (!(!hasBenchmarkPriceType() && !msg.hasBenchmarkPriceType()) && !(getBenchmarkPriceType()==msg.getBenchmarkPriceType())) return false;
		if ((hasBenchmarkSecurityID() && !msg.hasBenchmarkSecurityID()) || (!hasBenchmarkSecurityID() && msg.hasBenchmarkSecurityID())) return false;
		if (!(!hasBenchmarkSecurityID() && !msg.hasBenchmarkSecurityID()) && !FixUtils.equals(getBenchmarkSecurityID(), msg.getBenchmarkSecurityID())) return false;
		if ((hasBenchmarkSecurityIDSource() && !msg.hasBenchmarkSecurityIDSource()) || (!hasBenchmarkSecurityIDSource() && msg.hasBenchmarkSecurityIDSource())) return false;
		if (!(!hasBenchmarkSecurityIDSource() && !msg.hasBenchmarkSecurityIDSource()) && !FixUtils.equals(getBenchmarkSecurityIDSource(), msg.getBenchmarkSecurityIDSource())) return false;
		return true;
	}
	public FixSpreadOrBenchmarkCurveData clone ( FixSpreadOrBenchmarkCurveData out ) {
		if ( hasSpread())
			out.setSpread(getSpread());
		if ( hasBenchmarkCurveCurrency())
			out.setBenchmarkCurveCurrency(getBenchmarkCurveCurrency());
		if ( hasBenchmarkCurveName())
			out.setBenchmarkCurveName(getBenchmarkCurveName());
		if ( hasBenchmarkCurvePoint())
			out.setBenchmarkCurvePoint(getBenchmarkCurvePoint());
		if ( hasBenchmarkPrice())
			out.setBenchmarkPrice(getBenchmarkPrice());
		if ( hasBenchmarkPriceType())
			out.setBenchmarkPriceType(getBenchmarkPriceType());
		if ( hasBenchmarkSecurityID())
			out.setBenchmarkSecurityID(getBenchmarkSecurityID());
		if ( hasBenchmarkSecurityIDSource())
			out.setBenchmarkSecurityIDSource(getBenchmarkSecurityIDSource());
		return out;
	}

}
