package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixPegInstructions extends FixGroup {
	private short hasPegOffsetValue;
	long pegOffsetValue = 0;		
	private short hasPegPriceType;
	long pegPriceType = 0;		
	private short hasPegMoveType;
	long pegMoveType = 0;		
	private short hasPegOffsetType;
	long pegOffsetType = 0;		
	private short hasPegLimitType;
	long pegLimitType = 0;		
	private short hasPegRoundDirection;
	long pegRoundDirection = 0;		
	private short hasPegScope;
	long pegScope = 0;		
	private short hasPegSecurityIDSource;
	byte[] pegSecurityIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasPegSecurityID;
	byte[] pegSecurityID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasPegSymbol;
	byte[] pegSymbol = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasPegSecurityDesc;
	byte[] pegSecurityDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixPegInstructions() {
		this(false);
	}

	public FixPegInstructions(boolean isRequired) {
		super(FixTags.PEGOFFSETVALUE_INT);

		this.isRequired = isRequired;
		
		hasPegOffsetValue = FixUtils.TAG_HAS_NO_VALUE;		
		hasPegPriceType = FixUtils.TAG_HAS_NO_VALUE;		
		hasPegMoveType = FixUtils.TAG_HAS_NO_VALUE;		
		hasPegOffsetType = FixUtils.TAG_HAS_NO_VALUE;		
		hasPegLimitType = FixUtils.TAG_HAS_NO_VALUE;		
		hasPegRoundDirection = FixUtils.TAG_HAS_NO_VALUE;		
		hasPegScope = FixUtils.TAG_HAS_NO_VALUE;		
		hasPegSecurityIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		pegSecurityIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasPegSecurityID = FixUtils.TAG_HAS_NO_VALUE;		
		pegSecurityID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasPegSymbol = FixUtils.TAG_HAS_NO_VALUE;		
		pegSymbol = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasPegSecurityDesc = FixUtils.TAG_HAS_NO_VALUE;		
		pegSecurityDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasPegOffsetValue()) return true;
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
            	case FixTags.PEGOFFSETVALUE_INT:		
            		hasPegOffsetValue = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.PEGPRICETYPE_INT:		
            		hasPegPriceType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.PEGMOVETYPE_INT:		
            		hasPegMoveType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.PEGOFFSETTYPE_INT:		
            		hasPegOffsetType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.PEGLIMITTYPE_INT:		
            		hasPegLimitType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.PEGROUNDDIRECTION_INT:		
            		hasPegRoundDirection = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.PEGSCOPE_INT:		
            		hasPegScope = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.PEGSECURITYIDSOURCE_INT:		
            		hasPegSecurityIDSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.PEGSECURITYID_INT:		
            		hasPegSecurityID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.PEGSYMBOL_INT:		
            		hasPegSymbol = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.PEGSECURITYDESC_INT:		
            		hasPegSecurityDesc = (short) buf.position();		
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
		hasPegOffsetValue = FixUtils.TAG_HAS_NO_VALUE;
		hasPegPriceType = FixUtils.TAG_HAS_NO_VALUE;
		hasPegMoveType = FixUtils.TAG_HAS_NO_VALUE;
		hasPegOffsetType = FixUtils.TAG_HAS_NO_VALUE;
		hasPegLimitType = FixUtils.TAG_HAS_NO_VALUE;
		hasPegRoundDirection = FixUtils.TAG_HAS_NO_VALUE;
		hasPegScope = FixUtils.TAG_HAS_NO_VALUE;
		hasPegSecurityIDSource = FixUtils.TAG_HAS_NO_VALUE;
		hasPegSecurityID = FixUtils.TAG_HAS_NO_VALUE;
		hasPegSymbol = FixUtils.TAG_HAS_NO_VALUE;
		hasPegSecurityDesc = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasPegOffsetValue()) {		
			out.put(FixTags.PEGOFFSETVALUE);

			out.put((byte) '=');

			FixUtils.put(out, (long)pegOffsetValue);
		
			out.put(FixUtils.SOH);

            }

		if (hasPegPriceType()) {		
			out.put(FixTags.PEGPRICETYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)pegPriceType);
		
			out.put(FixUtils.SOH);

            }

		if (hasPegMoveType()) {		
			out.put(FixTags.PEGMOVETYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)pegMoveType);
		
			out.put(FixUtils.SOH);

            }

		if (hasPegOffsetType()) {		
			out.put(FixTags.PEGOFFSETTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)pegOffsetType);
		
			out.put(FixUtils.SOH);

            }

		if (hasPegLimitType()) {		
			out.put(FixTags.PEGLIMITTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)pegLimitType);
		
			out.put(FixUtils.SOH);

            }

		if (hasPegRoundDirection()) {		
			out.put(FixTags.PEGROUNDDIRECTION);

			out.put((byte) '=');

			FixUtils.put(out, (long)pegRoundDirection);
		
			out.put(FixUtils.SOH);

            }

		if (hasPegScope()) {		
			out.put(FixTags.PEGSCOPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)pegScope);
		
			out.put(FixUtils.SOH);

            }

		if (hasPegSecurityIDSource()) {		
			out.put(FixTags.PEGSECURITYIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,pegSecurityIDSource); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasPegSecurityID()) {		
			out.put(FixTags.PEGSECURITYID);

			out.put((byte) '=');

			FixUtils.put(out,pegSecurityID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasPegSymbol()) {		
			out.put(FixTags.PEGSYMBOL);

			out.put((byte) '=');

			FixUtils.put(out,pegSymbol); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasPegSecurityDesc()) {		
			out.put(FixTags.PEGSECURITYDESC);

			out.put((byte) '=');

			FixUtils.put(out,pegSecurityDesc); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasPegOffsetValue()) {		
			FixUtils.put(out, (long)pegOffsetValue);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPegPriceType()) {		
			FixUtils.put(out, (long)pegPriceType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPegMoveType()) {		
			FixUtils.put(out, (long)pegMoveType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPegOffsetType()) {		
			FixUtils.put(out, (long)pegOffsetType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPegLimitType()) {		
			FixUtils.put(out, (long)pegLimitType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPegRoundDirection()) {		
			FixUtils.put(out, (long)pegRoundDirection);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPegScope()) {		
			FixUtils.put(out, (long)pegScope);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPegSecurityIDSource()) {		
			FixUtils.put(out,pegSecurityIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPegSecurityID()) {		
			FixUtils.put(out,pegSecurityID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPegSymbol()) {		
			FixUtils.put(out,pegSymbol); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPegSecurityDesc()) {		
			FixUtils.put(out,pegSecurityDesc); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getPegOffsetValue() { 		
		if ( hasPegOffsetValue()) {		
			if (hasPegOffsetValue == FixUtils.TAG_HAS_VALUE) {		
				return pegOffsetValue; 		
			} else {		
		
				buf.position(hasPegOffsetValue);		
		
			pegOffsetValue = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasPegOffsetValue);		
					return 0;		
				}		
			}		
			hasPegOffsetValue = FixUtils.TAG_HAS_VALUE;		
			return pegOffsetValue;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPegOffsetValue() { return hasPegOffsetValue != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPegOffsetValue(long src) {		
		pegOffsetValue = src;
		hasPegOffsetValue = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPegOffsetValue(byte[] src) {		
		if (src == null ) return;
		if (hasPegOffsetValue()) pegOffsetValue = FixUtils.TAG_HAS_NO_VALUE;		
		pegOffsetValue = FixUtils.longValueOf(src, 0, src.length);
		hasPegOffsetValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPegOffsetValue(String str) {		
		if (str == null ) return;
		if (hasPegOffsetValue()) pegOffsetValue = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		pegOffsetValue = FixUtils.longValueOf(src, 0, src.length);
		hasPegOffsetValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getPegPriceType() { 		
		if ( hasPegPriceType()) {		
			if (hasPegPriceType == FixUtils.TAG_HAS_VALUE) {		
				return pegPriceType; 		
			} else {		
		
				buf.position(hasPegPriceType);		
		
			pegPriceType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasPegPriceType);		
					return 0;		
				}		
			}		
			hasPegPriceType = FixUtils.TAG_HAS_VALUE;		
			return pegPriceType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPegPriceType() { return hasPegPriceType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPegPriceType(long src) {		
		pegPriceType = src;
		hasPegPriceType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPegPriceType(byte[] src) {		
		if (src == null ) return;
		if (hasPegPriceType()) pegPriceType = FixUtils.TAG_HAS_NO_VALUE;		
		pegPriceType = FixUtils.longValueOf(src, 0, src.length);
		hasPegPriceType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPegPriceType(String str) {		
		if (str == null ) return;
		if (hasPegPriceType()) pegPriceType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		pegPriceType = FixUtils.longValueOf(src, 0, src.length);
		hasPegPriceType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getPegMoveType() { 		
		if ( hasPegMoveType()) {		
			if (hasPegMoveType == FixUtils.TAG_HAS_VALUE) {		
				return pegMoveType; 		
			} else {		
		
				buf.position(hasPegMoveType);		
		
			pegMoveType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasPegMoveType);		
					return 0;		
				}		
			}		
			hasPegMoveType = FixUtils.TAG_HAS_VALUE;		
			return pegMoveType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPegMoveType() { return hasPegMoveType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPegMoveType(long src) {		
		pegMoveType = src;
		hasPegMoveType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPegMoveType(byte[] src) {		
		if (src == null ) return;
		if (hasPegMoveType()) pegMoveType = FixUtils.TAG_HAS_NO_VALUE;		
		pegMoveType = FixUtils.longValueOf(src, 0, src.length);
		hasPegMoveType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPegMoveType(String str) {		
		if (str == null ) return;
		if (hasPegMoveType()) pegMoveType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		pegMoveType = FixUtils.longValueOf(src, 0, src.length);
		hasPegMoveType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getPegOffsetType() { 		
		if ( hasPegOffsetType()) {		
			if (hasPegOffsetType == FixUtils.TAG_HAS_VALUE) {		
				return pegOffsetType; 		
			} else {		
		
				buf.position(hasPegOffsetType);		
		
			pegOffsetType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasPegOffsetType);		
					return 0;		
				}		
			}		
			hasPegOffsetType = FixUtils.TAG_HAS_VALUE;		
			return pegOffsetType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPegOffsetType() { return hasPegOffsetType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPegOffsetType(long src) {		
		pegOffsetType = src;
		hasPegOffsetType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPegOffsetType(byte[] src) {		
		if (src == null ) return;
		if (hasPegOffsetType()) pegOffsetType = FixUtils.TAG_HAS_NO_VALUE;		
		pegOffsetType = FixUtils.longValueOf(src, 0, src.length);
		hasPegOffsetType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPegOffsetType(String str) {		
		if (str == null ) return;
		if (hasPegOffsetType()) pegOffsetType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		pegOffsetType = FixUtils.longValueOf(src, 0, src.length);
		hasPegOffsetType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getPegLimitType() { 		
		if ( hasPegLimitType()) {		
			if (hasPegLimitType == FixUtils.TAG_HAS_VALUE) {		
				return pegLimitType; 		
			} else {		
		
				buf.position(hasPegLimitType);		
		
			pegLimitType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasPegLimitType);		
					return 0;		
				}		
			}		
			hasPegLimitType = FixUtils.TAG_HAS_VALUE;		
			return pegLimitType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPegLimitType() { return hasPegLimitType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPegLimitType(long src) {		
		pegLimitType = src;
		hasPegLimitType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPegLimitType(byte[] src) {		
		if (src == null ) return;
		if (hasPegLimitType()) pegLimitType = FixUtils.TAG_HAS_NO_VALUE;		
		pegLimitType = FixUtils.longValueOf(src, 0, src.length);
		hasPegLimitType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPegLimitType(String str) {		
		if (str == null ) return;
		if (hasPegLimitType()) pegLimitType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		pegLimitType = FixUtils.longValueOf(src, 0, src.length);
		hasPegLimitType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getPegRoundDirection() { 		
		if ( hasPegRoundDirection()) {		
			if (hasPegRoundDirection == FixUtils.TAG_HAS_VALUE) {		
				return pegRoundDirection; 		
			} else {		
		
				buf.position(hasPegRoundDirection);		
		
			pegRoundDirection = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasPegRoundDirection);		
					return 0;		
				}		
			}		
			hasPegRoundDirection = FixUtils.TAG_HAS_VALUE;		
			return pegRoundDirection;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPegRoundDirection() { return hasPegRoundDirection != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPegRoundDirection(long src) {		
		pegRoundDirection = src;
		hasPegRoundDirection = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPegRoundDirection(byte[] src) {		
		if (src == null ) return;
		if (hasPegRoundDirection()) pegRoundDirection = FixUtils.TAG_HAS_NO_VALUE;		
		pegRoundDirection = FixUtils.longValueOf(src, 0, src.length);
		hasPegRoundDirection = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPegRoundDirection(String str) {		
		if (str == null ) return;
		if (hasPegRoundDirection()) pegRoundDirection = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		pegRoundDirection = FixUtils.longValueOf(src, 0, src.length);
		hasPegRoundDirection = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getPegScope() { 		
		if ( hasPegScope()) {		
			if (hasPegScope == FixUtils.TAG_HAS_VALUE) {		
				return pegScope; 		
			} else {		
		
				buf.position(hasPegScope);		
		
			pegScope = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasPegScope);		
					return 0;		
				}		
			}		
			hasPegScope = FixUtils.TAG_HAS_VALUE;		
			return pegScope;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPegScope() { return hasPegScope != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPegScope(long src) {		
		pegScope = src;
		hasPegScope = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPegScope(byte[] src) {		
		if (src == null ) return;
		if (hasPegScope()) pegScope = FixUtils.TAG_HAS_NO_VALUE;		
		pegScope = FixUtils.longValueOf(src, 0, src.length);
		hasPegScope = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPegScope(String str) {		
		if (str == null ) return;
		if (hasPegScope()) pegScope = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		pegScope = FixUtils.longValueOf(src, 0, src.length);
		hasPegScope = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getPegSecurityIDSource() { 		
		if ( hasPegSecurityIDSource()) {		
			if (hasPegSecurityIDSource == FixUtils.TAG_HAS_VALUE) {		
				return pegSecurityIDSource; 		
			} else {		
		
				buf.position(hasPegSecurityIDSource);		
		
			FixMessage.getTagStringValue(buf, pegSecurityIDSource, 0, pegSecurityIDSource.length, err);
		
				if (err.hasError()) {		
					buf.position(hasPegSecurityIDSource);		
					return null;		
				}		
			}		
			hasPegSecurityIDSource = FixUtils.TAG_HAS_VALUE;		
			return pegSecurityIDSource;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasPegSecurityIDSource() { return hasPegSecurityIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPegSecurityIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasPegSecurityIDSource()) FixUtils.fillSpace(pegSecurityIDSource);		
		FixUtils.copy(pegSecurityIDSource, src); 		
		hasPegSecurityIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPegSecurityIDSource(String str) {		
		if (str == null ) return;
		if (hasPegSecurityIDSource()) FixUtils.fillSpace(pegSecurityIDSource);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(pegSecurityIDSource, src); 		
		hasPegSecurityIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getPegSecurityID() { 		
		if ( hasPegSecurityID()) {		
			if (hasPegSecurityID == FixUtils.TAG_HAS_VALUE) {		
				return pegSecurityID; 		
			} else {		
		
				buf.position(hasPegSecurityID);		
		
			FixMessage.getTagStringValue(buf, pegSecurityID, 0, pegSecurityID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasPegSecurityID);		
					return null;		
				}		
			}		
			hasPegSecurityID = FixUtils.TAG_HAS_VALUE;		
			return pegSecurityID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasPegSecurityID() { return hasPegSecurityID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPegSecurityID(byte[] src) {		
		if (src == null ) return;
		if (hasPegSecurityID()) FixUtils.fillSpace(pegSecurityID);		
		FixUtils.copy(pegSecurityID, src); 		
		hasPegSecurityID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPegSecurityID(String str) {		
		if (str == null ) return;
		if (hasPegSecurityID()) FixUtils.fillSpace(pegSecurityID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(pegSecurityID, src); 		
		hasPegSecurityID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getPegSymbol() { 		
		if ( hasPegSymbol()) {		
			if (hasPegSymbol == FixUtils.TAG_HAS_VALUE) {		
				return pegSymbol; 		
			} else {		
		
				buf.position(hasPegSymbol);		
		
			FixMessage.getTagStringValue(buf, pegSymbol, 0, pegSymbol.length, err);
		
				if (err.hasError()) {		
					buf.position(hasPegSymbol);		
					return null;		
				}		
			}		
			hasPegSymbol = FixUtils.TAG_HAS_VALUE;		
			return pegSymbol;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasPegSymbol() { return hasPegSymbol != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPegSymbol(byte[] src) {		
		if (src == null ) return;
		if (hasPegSymbol()) FixUtils.fillSpace(pegSymbol);		
		FixUtils.copy(pegSymbol, src); 		
		hasPegSymbol = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPegSymbol(String str) {		
		if (str == null ) return;
		if (hasPegSymbol()) FixUtils.fillSpace(pegSymbol);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(pegSymbol, src); 		
		hasPegSymbol = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getPegSecurityDesc() { 		
		if ( hasPegSecurityDesc()) {		
			if (hasPegSecurityDesc == FixUtils.TAG_HAS_VALUE) {		
				return pegSecurityDesc; 		
			} else {		
		
				buf.position(hasPegSecurityDesc);		
		
			FixMessage.getTagStringValue(buf, pegSecurityDesc, 0, pegSecurityDesc.length, err);
		
				if (err.hasError()) {		
					buf.position(hasPegSecurityDesc);		
					return null;		
				}		
			}		
			hasPegSecurityDesc = FixUtils.TAG_HAS_VALUE;		
			return pegSecurityDesc;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasPegSecurityDesc() { return hasPegSecurityDesc != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPegSecurityDesc(byte[] src) {		
		if (src == null ) return;
		if (hasPegSecurityDesc()) FixUtils.fillSpace(pegSecurityDesc);		
		FixUtils.copy(pegSecurityDesc, src); 		
		hasPegSecurityDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPegSecurityDesc(String str) {		
		if (str == null ) return;
		if (hasPegSecurityDesc()) FixUtils.fillSpace(pegSecurityDesc);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(pegSecurityDesc, src); 		
		hasPegSecurityDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasPegOffsetValue()) s += "PegOffsetValue(211)= " + getPegOffsetValue() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasPegPriceType()) s += "PegPriceType(1094)= " + getPegPriceType() + "\n" ; 
		if (hasPegMoveType()) s += "PegMoveType(835)= " + getPegMoveType() + "\n" ; 
		if (hasPegOffsetType()) s += "PegOffsetType(836)= " + getPegOffsetType() + "\n" ; 
		if (hasPegLimitType()) s += "PegLimitType(837)= " + getPegLimitType() + "\n" ; 
		if (hasPegRoundDirection()) s += "PegRoundDirection(838)= " + getPegRoundDirection() + "\n" ; 
		if (hasPegScope()) s += "PegScope(840)= " + getPegScope() + "\n" ; 
		if (hasPegSecurityIDSource()) s += "PegSecurityIDSource(1096)= " + new String( FixUtils.trim(getPegSecurityIDSource()) ) + "\n" ; 
		if (hasPegSecurityID()) s += "PegSecurityID(1097)= " + new String( FixUtils.trim(getPegSecurityID()) ) + "\n" ; 
		if (hasPegSymbol()) s += "PegSymbol(1098)= " + new String( FixUtils.trim(getPegSymbol()) ) + "\n" ; 
		if (hasPegSecurityDesc()) s += "PegSecurityDesc(1099)= " + new String( FixUtils.trim(getPegSecurityDesc()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixPegInstructions)) return false;

		FixPegInstructions msg = (FixPegInstructions) o;

		if ((hasPegOffsetValue() && !msg.hasPegOffsetValue()) || (!hasPegOffsetValue() && msg.hasPegOffsetValue())) return false;
		if (!(!hasPegOffsetValue() && !msg.hasPegOffsetValue()) && !(getPegOffsetValue()==msg.getPegOffsetValue())) return false;
		if ((hasPegPriceType() && !msg.hasPegPriceType()) || (!hasPegPriceType() && msg.hasPegPriceType())) return false;
		if (!(!hasPegPriceType() && !msg.hasPegPriceType()) && !(getPegPriceType()==msg.getPegPriceType())) return false;
		if ((hasPegMoveType() && !msg.hasPegMoveType()) || (!hasPegMoveType() && msg.hasPegMoveType())) return false;
		if (!(!hasPegMoveType() && !msg.hasPegMoveType()) && !(getPegMoveType()==msg.getPegMoveType())) return false;
		if ((hasPegOffsetType() && !msg.hasPegOffsetType()) || (!hasPegOffsetType() && msg.hasPegOffsetType())) return false;
		if (!(!hasPegOffsetType() && !msg.hasPegOffsetType()) && !(getPegOffsetType()==msg.getPegOffsetType())) return false;
		if ((hasPegLimitType() && !msg.hasPegLimitType()) || (!hasPegLimitType() && msg.hasPegLimitType())) return false;
		if (!(!hasPegLimitType() && !msg.hasPegLimitType()) && !(getPegLimitType()==msg.getPegLimitType())) return false;
		if ((hasPegRoundDirection() && !msg.hasPegRoundDirection()) || (!hasPegRoundDirection() && msg.hasPegRoundDirection())) return false;
		if (!(!hasPegRoundDirection() && !msg.hasPegRoundDirection()) && !(getPegRoundDirection()==msg.getPegRoundDirection())) return false;
		if ((hasPegScope() && !msg.hasPegScope()) || (!hasPegScope() && msg.hasPegScope())) return false;
		if (!(!hasPegScope() && !msg.hasPegScope()) && !(getPegScope()==msg.getPegScope())) return false;
		if ((hasPegSecurityIDSource() && !msg.hasPegSecurityIDSource()) || (!hasPegSecurityIDSource() && msg.hasPegSecurityIDSource())) return false;
		if (!(!hasPegSecurityIDSource() && !msg.hasPegSecurityIDSource()) && !FixUtils.equals(getPegSecurityIDSource(), msg.getPegSecurityIDSource())) return false;
		if ((hasPegSecurityID() && !msg.hasPegSecurityID()) || (!hasPegSecurityID() && msg.hasPegSecurityID())) return false;
		if (!(!hasPegSecurityID() && !msg.hasPegSecurityID()) && !FixUtils.equals(getPegSecurityID(), msg.getPegSecurityID())) return false;
		if ((hasPegSymbol() && !msg.hasPegSymbol()) || (!hasPegSymbol() && msg.hasPegSymbol())) return false;
		if (!(!hasPegSymbol() && !msg.hasPegSymbol()) && !FixUtils.equals(getPegSymbol(), msg.getPegSymbol())) return false;
		if ((hasPegSecurityDesc() && !msg.hasPegSecurityDesc()) || (!hasPegSecurityDesc() && msg.hasPegSecurityDesc())) return false;
		if (!(!hasPegSecurityDesc() && !msg.hasPegSecurityDesc()) && !FixUtils.equals(getPegSecurityDesc(), msg.getPegSecurityDesc())) return false;
		return true;
	}
	public FixPegInstructions clone ( FixPegInstructions out ) {
		if ( hasPegOffsetValue())
			out.setPegOffsetValue(getPegOffsetValue());
		if ( hasPegPriceType())
			out.setPegPriceType(getPegPriceType());
		if ( hasPegMoveType())
			out.setPegMoveType(getPegMoveType());
		if ( hasPegOffsetType())
			out.setPegOffsetType(getPegOffsetType());
		if ( hasPegLimitType())
			out.setPegLimitType(getPegLimitType());
		if ( hasPegRoundDirection())
			out.setPegRoundDirection(getPegRoundDirection());
		if ( hasPegScope())
			out.setPegScope(getPegScope());
		if ( hasPegSecurityIDSource())
			out.setPegSecurityIDSource(getPegSecurityIDSource());
		if ( hasPegSecurityID())
			out.setPegSecurityID(getPegSecurityID());
		if ( hasPegSymbol())
			out.setPegSymbol(getPegSymbol());
		if ( hasPegSecurityDesc())
			out.setPegSecurityDesc(getPegSecurityDesc());
		return out;
	}

}
