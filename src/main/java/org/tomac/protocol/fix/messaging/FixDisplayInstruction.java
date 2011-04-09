package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixDisplayInstruction extends FixGroup {
	private short hasDisplayQty;
	long displayQty = 0;		
	private short hasSecondaryDisplayQty;
	long secondaryDisplayQty = 0;		
	private short hasDisplayWhen;
	byte displayWhen = (byte)' ';		
	private short hasDisplayMethod;
	byte displayMethod = (byte)' ';		
	private short hasDisplayLowQty;
	long displayLowQty = 0;		
	private short hasDisplayHighQty;
	long displayHighQty = 0;		
	private short hasDisplayMinIncr;
	long displayMinIncr = 0;		
	private short hasRefreshQty;
	long refreshQty = 0;		
	
	public FixDisplayInstruction() {
		this(false);
	}

	public FixDisplayInstruction(boolean isRequired) {
		super(FixTags.DISPLAYQTY_INT);

		this.isRequired = isRequired;
		
		hasDisplayQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasSecondaryDisplayQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasDisplayWhen = FixUtils.TAG_HAS_NO_VALUE;		
		hasDisplayMethod = FixUtils.TAG_HAS_NO_VALUE;		
		hasDisplayLowQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasDisplayHighQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasDisplayMinIncr = FixUtils.TAG_HAS_NO_VALUE;		
		hasRefreshQty = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasDisplayQty()) return true;
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
            	case FixTags.DISPLAYQTY_INT:		
            		hasDisplayQty = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.SECONDARYDISPLAYQTY_INT:		
            		hasSecondaryDisplayQty = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.DISPLAYWHEN_INT:		
            		hasDisplayWhen = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.DISPLAYMETHOD_INT:		
            		hasDisplayMethod = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.DISPLAYLOWQTY_INT:		
            		hasDisplayLowQty = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.DISPLAYHIGHQTY_INT:		
            		hasDisplayHighQty = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.DISPLAYMININCR_INT:		
            		hasDisplayMinIncr = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.REFRESHQTY_INT:		
            		hasRefreshQty = (short) buf.position();		
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
		hasDisplayQty = FixUtils.TAG_HAS_NO_VALUE;
		hasSecondaryDisplayQty = FixUtils.TAG_HAS_NO_VALUE;
		hasDisplayWhen = FixUtils.TAG_HAS_NO_VALUE;
		hasDisplayMethod = FixUtils.TAG_HAS_NO_VALUE;
		hasDisplayLowQty = FixUtils.TAG_HAS_NO_VALUE;
		hasDisplayHighQty = FixUtils.TAG_HAS_NO_VALUE;
		hasDisplayMinIncr = FixUtils.TAG_HAS_NO_VALUE;
		hasRefreshQty = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasDisplayQty()) {		
			out.put(FixTags.DISPLAYQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)displayQty);
		
			out.put(FixUtils.SOH);

            }

		if (hasSecondaryDisplayQty()) {		
			out.put(FixTags.SECONDARYDISPLAYQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)secondaryDisplayQty);
		
			out.put(FixUtils.SOH);

            }

		if (hasDisplayWhen()) {		
			out.put(FixTags.DISPLAYWHEN);

			out.put((byte) '=');

			FixUtils.put(out,displayWhen); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDisplayMethod()) {		
			out.put(FixTags.DISPLAYMETHOD);

			out.put((byte) '=');

			FixUtils.put(out,displayMethod); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDisplayLowQty()) {		
			out.put(FixTags.DISPLAYLOWQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)displayLowQty);
		
			out.put(FixUtils.SOH);

            }

		if (hasDisplayHighQty()) {		
			out.put(FixTags.DISPLAYHIGHQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)displayHighQty);
		
			out.put(FixUtils.SOH);

            }

		if (hasDisplayMinIncr()) {		
			out.put(FixTags.DISPLAYMININCR);

			out.put((byte) '=');

			FixUtils.put(out, (long)displayMinIncr);
		
			out.put(FixUtils.SOH);

            }

		if (hasRefreshQty()) {		
			out.put(FixTags.REFRESHQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)refreshQty);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasDisplayQty()) {		
			FixUtils.put(out, (long)displayQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSecondaryDisplayQty()) {		
			FixUtils.put(out, (long)secondaryDisplayQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDisplayWhen()) {		
			FixUtils.put(out,displayWhen); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDisplayMethod()) {		
			FixUtils.put(out,displayMethod); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDisplayLowQty()) {		
			FixUtils.put(out, (long)displayLowQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDisplayHighQty()) {		
			FixUtils.put(out, (long)displayHighQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDisplayMinIncr()) {		
			FixUtils.put(out, (long)displayMinIncr);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRefreshQty()) {		
			FixUtils.put(out, (long)refreshQty);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getDisplayQty() { 		
		if ( hasDisplayQty()) {		
			if (hasDisplayQty == FixUtils.TAG_HAS_VALUE) {		
				return displayQty; 		
			} else {		
		
				buf.position(hasDisplayQty);		
		
			displayQty = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDisplayQty);		
					return 0;		
				}		
			}		
			hasDisplayQty = FixUtils.TAG_HAS_VALUE;		
			return displayQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDisplayQty() { return hasDisplayQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDisplayQty(long src) {		
		displayQty = src;
		hasDisplayQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDisplayQty(byte[] src) {		
		if (src == null ) return;
		if (hasDisplayQty()) displayQty = FixUtils.TAG_HAS_NO_VALUE;		
		displayQty = FixUtils.longValueOf(src, 0, src.length);
		hasDisplayQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDisplayQty(String str) {		
		if (str == null ) return;
		if (hasDisplayQty()) displayQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		displayQty = FixUtils.longValueOf(src, 0, src.length);
		hasDisplayQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getSecondaryDisplayQty() { 		
		if ( hasSecondaryDisplayQty()) {		
			if (hasSecondaryDisplayQty == FixUtils.TAG_HAS_VALUE) {		
				return secondaryDisplayQty; 		
			} else {		
		
				buf.position(hasSecondaryDisplayQty);		
		
			secondaryDisplayQty = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasSecondaryDisplayQty);		
					return 0;		
				}		
			}		
			hasSecondaryDisplayQty = FixUtils.TAG_HAS_VALUE;		
			return secondaryDisplayQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasSecondaryDisplayQty() { return hasSecondaryDisplayQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSecondaryDisplayQty(long src) {		
		secondaryDisplayQty = src;
		hasSecondaryDisplayQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSecondaryDisplayQty(byte[] src) {		
		if (src == null ) return;
		if (hasSecondaryDisplayQty()) secondaryDisplayQty = FixUtils.TAG_HAS_NO_VALUE;		
		secondaryDisplayQty = FixUtils.longValueOf(src, 0, src.length);
		hasSecondaryDisplayQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSecondaryDisplayQty(String str) {		
		if (str == null ) return;
		if (hasSecondaryDisplayQty()) secondaryDisplayQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		secondaryDisplayQty = FixUtils.longValueOf(src, 0, src.length);
		hasSecondaryDisplayQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getDisplayWhen() { 		
		if ( hasDisplayWhen()) {		
			if (hasDisplayWhen == FixUtils.TAG_HAS_VALUE) {		
				return displayWhen; 		
			} else {		
		
				buf.position(hasDisplayWhen);		
		
			displayWhen = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (displayWhen != (byte)'2') && (displayWhen != (byte)'1') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 1083);		
				if (err.hasError()) {		
					buf.position(hasDisplayWhen);		
					return (byte)'0';		
				}		
			}		
			hasDisplayWhen = FixUtils.TAG_HAS_VALUE;		
			return displayWhen;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasDisplayWhen() { return hasDisplayWhen != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDisplayWhen(byte src) {		
		displayWhen = src;
		hasDisplayWhen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDisplayWhen(byte[] src) {		
		if (src == null ) return;
		if (hasDisplayWhen()) displayWhen = (byte)' ';		
		displayWhen = src[0];		
		hasDisplayWhen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDisplayWhen(String str) {		
		if (str == null ) return;
		if (hasDisplayWhen()) displayWhen = (byte)' ';		
		byte[] src = str.getBytes(); 		
		displayWhen = src[0];		
		hasDisplayWhen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getDisplayMethod() { 		
		if ( hasDisplayMethod()) {		
			if (hasDisplayMethod == FixUtils.TAG_HAS_VALUE) {		
				return displayMethod; 		
			} else {		
		
				buf.position(hasDisplayMethod);		
		
			displayMethod = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (displayMethod != (byte)'3') && (displayMethod != (byte)'2') && (displayMethod != (byte)'1') && (displayMethod != (byte)'4') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 1084);		
				if (err.hasError()) {		
					buf.position(hasDisplayMethod);		
					return (byte)'0';		
				}		
			}		
			hasDisplayMethod = FixUtils.TAG_HAS_VALUE;		
			return displayMethod;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasDisplayMethod() { return hasDisplayMethod != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDisplayMethod(byte src) {		
		displayMethod = src;
		hasDisplayMethod = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDisplayMethod(byte[] src) {		
		if (src == null ) return;
		if (hasDisplayMethod()) displayMethod = (byte)' ';		
		displayMethod = src[0];		
		hasDisplayMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDisplayMethod(String str) {		
		if (str == null ) return;
		if (hasDisplayMethod()) displayMethod = (byte)' ';		
		byte[] src = str.getBytes(); 		
		displayMethod = src[0];		
		hasDisplayMethod = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDisplayLowQty() { 		
		if ( hasDisplayLowQty()) {		
			if (hasDisplayLowQty == FixUtils.TAG_HAS_VALUE) {		
				return displayLowQty; 		
			} else {		
		
				buf.position(hasDisplayLowQty);		
		
			displayLowQty = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDisplayLowQty);		
					return 0;		
				}		
			}		
			hasDisplayLowQty = FixUtils.TAG_HAS_VALUE;		
			return displayLowQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDisplayLowQty() { return hasDisplayLowQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDisplayLowQty(long src) {		
		displayLowQty = src;
		hasDisplayLowQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDisplayLowQty(byte[] src) {		
		if (src == null ) return;
		if (hasDisplayLowQty()) displayLowQty = FixUtils.TAG_HAS_NO_VALUE;		
		displayLowQty = FixUtils.longValueOf(src, 0, src.length);
		hasDisplayLowQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDisplayLowQty(String str) {		
		if (str == null ) return;
		if (hasDisplayLowQty()) displayLowQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		displayLowQty = FixUtils.longValueOf(src, 0, src.length);
		hasDisplayLowQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDisplayHighQty() { 		
		if ( hasDisplayHighQty()) {		
			if (hasDisplayHighQty == FixUtils.TAG_HAS_VALUE) {		
				return displayHighQty; 		
			} else {		
		
				buf.position(hasDisplayHighQty);		
		
			displayHighQty = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDisplayHighQty);		
					return 0;		
				}		
			}		
			hasDisplayHighQty = FixUtils.TAG_HAS_VALUE;		
			return displayHighQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDisplayHighQty() { return hasDisplayHighQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDisplayHighQty(long src) {		
		displayHighQty = src;
		hasDisplayHighQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDisplayHighQty(byte[] src) {		
		if (src == null ) return;
		if (hasDisplayHighQty()) displayHighQty = FixUtils.TAG_HAS_NO_VALUE;		
		displayHighQty = FixUtils.longValueOf(src, 0, src.length);
		hasDisplayHighQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDisplayHighQty(String str) {		
		if (str == null ) return;
		if (hasDisplayHighQty()) displayHighQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		displayHighQty = FixUtils.longValueOf(src, 0, src.length);
		hasDisplayHighQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getDisplayMinIncr() { 		
		if ( hasDisplayMinIncr()) {		
			if (hasDisplayMinIncr == FixUtils.TAG_HAS_VALUE) {		
				return displayMinIncr; 		
			} else {		
		
				buf.position(hasDisplayMinIncr);		
		
			displayMinIncr = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDisplayMinIncr);		
					return 0;		
				}		
			}		
			hasDisplayMinIncr = FixUtils.TAG_HAS_VALUE;		
			return displayMinIncr;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDisplayMinIncr() { return hasDisplayMinIncr != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDisplayMinIncr(long src) {		
		displayMinIncr = src;
		hasDisplayMinIncr = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDisplayMinIncr(byte[] src) {		
		if (src == null ) return;
		if (hasDisplayMinIncr()) displayMinIncr = FixUtils.TAG_HAS_NO_VALUE;		
		displayMinIncr = FixUtils.longValueOf(src, 0, src.length);
		hasDisplayMinIncr = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDisplayMinIncr(String str) {		
		if (str == null ) return;
		if (hasDisplayMinIncr()) displayMinIncr = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		displayMinIncr = FixUtils.longValueOf(src, 0, src.length);
		hasDisplayMinIncr = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getRefreshQty() { 		
		if ( hasRefreshQty()) {		
			if (hasRefreshQty == FixUtils.TAG_HAS_VALUE) {		
				return refreshQty; 		
			} else {		
		
				buf.position(hasRefreshQty);		
		
			refreshQty = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRefreshQty);		
					return 0;		
				}		
			}		
			hasRefreshQty = FixUtils.TAG_HAS_VALUE;		
			return refreshQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRefreshQty() { return hasRefreshQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRefreshQty(long src) {		
		refreshQty = src;
		hasRefreshQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRefreshQty(byte[] src) {		
		if (src == null ) return;
		if (hasRefreshQty()) refreshQty = FixUtils.TAG_HAS_NO_VALUE;		
		refreshQty = FixUtils.longValueOf(src, 0, src.length);
		hasRefreshQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRefreshQty(String str) {		
		if (str == null ) return;
		if (hasRefreshQty()) refreshQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		refreshQty = FixUtils.longValueOf(src, 0, src.length);
		hasRefreshQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasDisplayQty()) s += "DisplayQty(1138)= " + getDisplayQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasSecondaryDisplayQty()) s += "SecondaryDisplayQty(1082)= " + getSecondaryDisplayQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasDisplayWhen()) s += "DisplayWhen(1083)= " + getDisplayWhen() + "\n" ; 
		if (hasDisplayMethod()) s += "DisplayMethod(1084)= " + getDisplayMethod() + "\n" ; 
		if (hasDisplayLowQty()) s += "DisplayLowQty(1085)= " + getDisplayLowQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasDisplayHighQty()) s += "DisplayHighQty(1086)= " + getDisplayHighQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasDisplayMinIncr()) s += "DisplayMinIncr(1087)= " + getDisplayMinIncr() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasRefreshQty()) s += "RefreshQty(1088)= " + getRefreshQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixDisplayInstruction)) return false;

		FixDisplayInstruction msg = (FixDisplayInstruction) o;

		if ((hasDisplayQty() && !msg.hasDisplayQty()) || (!hasDisplayQty() && msg.hasDisplayQty())) return false;
		if (!(!hasDisplayQty() && !msg.hasDisplayQty()) && !(getDisplayQty()==msg.getDisplayQty())) return false;
		if ((hasSecondaryDisplayQty() && !msg.hasSecondaryDisplayQty()) || (!hasSecondaryDisplayQty() && msg.hasSecondaryDisplayQty())) return false;
		if (!(!hasSecondaryDisplayQty() && !msg.hasSecondaryDisplayQty()) && !(getSecondaryDisplayQty()==msg.getSecondaryDisplayQty())) return false;
		if ((hasDisplayWhen() && !msg.hasDisplayWhen()) || (!hasDisplayWhen() && msg.hasDisplayWhen())) return false;
		if (!(!hasDisplayWhen() && !msg.hasDisplayWhen()) && !(getDisplayWhen()==msg.getDisplayWhen())) return false;
		if ((hasDisplayMethod() && !msg.hasDisplayMethod()) || (!hasDisplayMethod() && msg.hasDisplayMethod())) return false;
		if (!(!hasDisplayMethod() && !msg.hasDisplayMethod()) && !(getDisplayMethod()==msg.getDisplayMethod())) return false;
		if ((hasDisplayLowQty() && !msg.hasDisplayLowQty()) || (!hasDisplayLowQty() && msg.hasDisplayLowQty())) return false;
		if (!(!hasDisplayLowQty() && !msg.hasDisplayLowQty()) && !(getDisplayLowQty()==msg.getDisplayLowQty())) return false;
		if ((hasDisplayHighQty() && !msg.hasDisplayHighQty()) || (!hasDisplayHighQty() && msg.hasDisplayHighQty())) return false;
		if (!(!hasDisplayHighQty() && !msg.hasDisplayHighQty()) && !(getDisplayHighQty()==msg.getDisplayHighQty())) return false;
		if ((hasDisplayMinIncr() && !msg.hasDisplayMinIncr()) || (!hasDisplayMinIncr() && msg.hasDisplayMinIncr())) return false;
		if (!(!hasDisplayMinIncr() && !msg.hasDisplayMinIncr()) && !(getDisplayMinIncr()==msg.getDisplayMinIncr())) return false;
		if ((hasRefreshQty() && !msg.hasRefreshQty()) || (!hasRefreshQty() && msg.hasRefreshQty())) return false;
		if (!(!hasRefreshQty() && !msg.hasRefreshQty()) && !(getRefreshQty()==msg.getRefreshQty())) return false;
		return true;
	}
	public FixDisplayInstruction clone ( FixDisplayInstruction out ) {
		if ( hasDisplayQty())
			out.setDisplayQty(getDisplayQty());
		if ( hasSecondaryDisplayQty())
			out.setSecondaryDisplayQty(getSecondaryDisplayQty());
		if ( hasDisplayWhen())
			out.setDisplayWhen(getDisplayWhen());
		if ( hasDisplayMethod())
			out.setDisplayMethod(getDisplayMethod());
		if ( hasDisplayLowQty())
			out.setDisplayLowQty(getDisplayLowQty());
		if ( hasDisplayHighQty())
			out.setDisplayHighQty(getDisplayHighQty());
		if ( hasDisplayMinIncr())
			out.setDisplayMinIncr(getDisplayMinIncr());
		if ( hasRefreshQty())
			out.setRefreshQty(getRefreshQty());
		return out;
	}

}
