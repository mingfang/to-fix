package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixTriggeringInstruction extends FixGroup {
	private short hasTriggerType;
	byte triggerType = (byte)' ';		
	private short hasTriggerAction;
	byte triggerAction = (byte)' ';		
	private short hasTriggerPrice;
	long triggerPrice = 0;		
	private short hasTriggerSymbol;
	byte[] triggerSymbol = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTriggerSecurityID;
	byte[] triggerSecurityID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTriggerSecurityIDSource;
	byte[] triggerSecurityIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTriggerSecurityDesc;
	byte[] triggerSecurityDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTriggerPriceType;
	byte triggerPriceType = (byte)' ';		
	private short hasTriggerPriceTypeScope;
	byte triggerPriceTypeScope = (byte)' ';		
	private short hasTriggerPriceDirection;
	byte triggerPriceDirection = (byte)' ';		
	private short hasTriggerNewPrice;
	long triggerNewPrice = 0;		
	private short hasTriggerOrderType;
	byte triggerOrderType = (byte)' ';		
	private short hasTriggerNewQty;
	long triggerNewQty = 0;		
	private short hasTriggerTradingSessionID;
	byte[] triggerTradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTriggerTradingSessionSubID;
	byte[] triggerTradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixTriggeringInstruction() {
		this(false);
	}

	public FixTriggeringInstruction(boolean isRequired) {
		super(FixTags.TRIGGERTYPE_INT);

		this.isRequired = isRequired;
		
		hasTriggerType = FixUtils.TAG_HAS_NO_VALUE;		
		hasTriggerAction = FixUtils.TAG_HAS_NO_VALUE;		
		hasTriggerPrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasTriggerSymbol = FixUtils.TAG_HAS_NO_VALUE;		
		triggerSymbol = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTriggerSecurityID = FixUtils.TAG_HAS_NO_VALUE;		
		triggerSecurityID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTriggerSecurityIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		triggerSecurityIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTriggerSecurityDesc = FixUtils.TAG_HAS_NO_VALUE;		
		triggerSecurityDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTriggerPriceType = FixUtils.TAG_HAS_NO_VALUE;		
		hasTriggerPriceTypeScope = FixUtils.TAG_HAS_NO_VALUE;		
		hasTriggerPriceDirection = FixUtils.TAG_HAS_NO_VALUE;		
		hasTriggerNewPrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasTriggerOrderType = FixUtils.TAG_HAS_NO_VALUE;		
		hasTriggerNewQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasTriggerTradingSessionID = FixUtils.TAG_HAS_NO_VALUE;		
		triggerTradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTriggerTradingSessionSubID = FixUtils.TAG_HAS_NO_VALUE;		
		triggerTradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasTriggerType()) return true;
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
            	case FixTags.TRIGGERTYPE_INT:		
            		hasTriggerType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRIGGERACTION_INT:		
            		hasTriggerAction = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRIGGERPRICE_INT:		
            		hasTriggerPrice = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRIGGERSYMBOL_INT:		
            		hasTriggerSymbol = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRIGGERSECURITYID_INT:		
            		hasTriggerSecurityID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRIGGERSECURITYIDSOURCE_INT:		
            		hasTriggerSecurityIDSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRIGGERSECURITYDESC_INT:		
            		hasTriggerSecurityDesc = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRIGGERPRICETYPE_INT:		
            		hasTriggerPriceType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRIGGERPRICETYPESCOPE_INT:		
            		hasTriggerPriceTypeScope = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRIGGERPRICEDIRECTION_INT:		
            		hasTriggerPriceDirection = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRIGGERNEWPRICE_INT:		
            		hasTriggerNewPrice = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRIGGERORDERTYPE_INT:		
            		hasTriggerOrderType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRIGGERNEWQTY_INT:		
            		hasTriggerNewQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRIGGERTRADINGSESSIONID_INT:		
            		hasTriggerTradingSessionID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TRIGGERTRADINGSESSIONSUBID_INT:		
            		hasTriggerTradingSessionSubID = (short) buf.position();		
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
		hasTriggerType = FixUtils.TAG_HAS_NO_VALUE;
		hasTriggerAction = FixUtils.TAG_HAS_NO_VALUE;
		hasTriggerPrice = FixUtils.TAG_HAS_NO_VALUE;
		hasTriggerSymbol = FixUtils.TAG_HAS_NO_VALUE;
		hasTriggerSecurityID = FixUtils.TAG_HAS_NO_VALUE;
		hasTriggerSecurityIDSource = FixUtils.TAG_HAS_NO_VALUE;
		hasTriggerSecurityDesc = FixUtils.TAG_HAS_NO_VALUE;
		hasTriggerPriceType = FixUtils.TAG_HAS_NO_VALUE;
		hasTriggerPriceTypeScope = FixUtils.TAG_HAS_NO_VALUE;
		hasTriggerPriceDirection = FixUtils.TAG_HAS_NO_VALUE;
		hasTriggerNewPrice = FixUtils.TAG_HAS_NO_VALUE;
		hasTriggerOrderType = FixUtils.TAG_HAS_NO_VALUE;
		hasTriggerNewQty = FixUtils.TAG_HAS_NO_VALUE;
		hasTriggerTradingSessionID = FixUtils.TAG_HAS_NO_VALUE;
		hasTriggerTradingSessionSubID = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasTriggerType()) {		
			out.put(FixTags.TRIGGERTYPE);

			out.put((byte) '=');

			FixUtils.put(out,triggerType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTriggerAction()) {		
			out.put(FixTags.TRIGGERACTION);

			out.put((byte) '=');

			FixUtils.put(out,triggerAction); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTriggerPrice()) {		
			out.put(FixTags.TRIGGERPRICE);

			out.put((byte) '=');

			FixUtils.put(out, (long)triggerPrice);
		
			out.put(FixUtils.SOH);

            }

		if (hasTriggerSymbol()) {		
			out.put(FixTags.TRIGGERSYMBOL);

			out.put((byte) '=');

			FixUtils.put(out,triggerSymbol); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTriggerSecurityID()) {		
			out.put(FixTags.TRIGGERSECURITYID);

			out.put((byte) '=');

			FixUtils.put(out,triggerSecurityID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTriggerSecurityIDSource()) {		
			out.put(FixTags.TRIGGERSECURITYIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,triggerSecurityIDSource); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTriggerSecurityDesc()) {		
			out.put(FixTags.TRIGGERSECURITYDESC);

			out.put((byte) '=');

			FixUtils.put(out,triggerSecurityDesc); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTriggerPriceType()) {		
			out.put(FixTags.TRIGGERPRICETYPE);

			out.put((byte) '=');

			FixUtils.put(out,triggerPriceType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTriggerPriceTypeScope()) {		
			out.put(FixTags.TRIGGERPRICETYPESCOPE);

			out.put((byte) '=');

			FixUtils.put(out,triggerPriceTypeScope); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTriggerPriceDirection()) {		
			out.put(FixTags.TRIGGERPRICEDIRECTION);

			out.put((byte) '=');

			FixUtils.put(out,triggerPriceDirection); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTriggerNewPrice()) {		
			out.put(FixTags.TRIGGERNEWPRICE);

			out.put((byte) '=');

			FixUtils.put(out, (long)triggerNewPrice);
		
			out.put(FixUtils.SOH);

            }

		if (hasTriggerOrderType()) {		
			out.put(FixTags.TRIGGERORDERTYPE);

			out.put((byte) '=');

			FixUtils.put(out,triggerOrderType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTriggerNewQty()) {		
			out.put(FixTags.TRIGGERNEWQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)triggerNewQty);
		
			out.put(FixUtils.SOH);

            }

		if (hasTriggerTradingSessionID()) {		
			out.put(FixTags.TRIGGERTRADINGSESSIONID);

			out.put((byte) '=');

			FixUtils.put(out,triggerTradingSessionID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasTriggerTradingSessionSubID()) {		
			out.put(FixTags.TRIGGERTRADINGSESSIONSUBID);

			out.put((byte) '=');

			FixUtils.put(out,triggerTradingSessionSubID); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasTriggerType()) {		
			FixUtils.put(out,triggerType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTriggerAction()) {		
			FixUtils.put(out,triggerAction); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTriggerPrice()) {		
			FixUtils.put(out, (long)triggerPrice);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTriggerSymbol()) {		
			FixUtils.put(out,triggerSymbol); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTriggerSecurityID()) {		
			FixUtils.put(out,triggerSecurityID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTriggerSecurityIDSource()) {		
			FixUtils.put(out,triggerSecurityIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTriggerSecurityDesc()) {		
			FixUtils.put(out,triggerSecurityDesc); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTriggerPriceType()) {		
			FixUtils.put(out,triggerPriceType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTriggerPriceTypeScope()) {		
			FixUtils.put(out,triggerPriceTypeScope); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTriggerPriceDirection()) {		
			FixUtils.put(out,triggerPriceDirection); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTriggerNewPrice()) {		
			FixUtils.put(out, (long)triggerNewPrice);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTriggerOrderType()) {		
			FixUtils.put(out,triggerOrderType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTriggerNewQty()) {		
			FixUtils.put(out, (long)triggerNewQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTriggerTradingSessionID()) {		
			FixUtils.put(out,triggerTradingSessionID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTriggerTradingSessionSubID()) {		
			FixUtils.put(out,triggerTradingSessionSubID); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte getTriggerType() { 		
		if ( hasTriggerType()) {		
			if (hasTriggerType == FixUtils.TAG_HAS_VALUE) {		
				return triggerType; 		
			} else {		
		
				buf.position(hasTriggerType);		
		
			triggerType = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (triggerType != (byte)'3') && (triggerType != (byte)'2') && (triggerType != (byte)'1') && (triggerType != (byte)'4') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 1100);		
				if (err.hasError()) {		
					buf.position(hasTriggerType);		
					return (byte)'0';		
				}		
			}		
			hasTriggerType = FixUtils.TAG_HAS_VALUE;		
			return triggerType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasTriggerType() { return hasTriggerType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTriggerType(byte src) {		
		triggerType = src;
		hasTriggerType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTriggerType(byte[] src) {		
		if (src == null ) return;
		if (hasTriggerType()) triggerType = (byte)' ';		
		triggerType = src[0];		
		hasTriggerType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTriggerType(String str) {		
		if (str == null ) return;
		if (hasTriggerType()) triggerType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		triggerType = src[0];		
		hasTriggerType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getTriggerAction() { 		
		if ( hasTriggerAction()) {		
			if (hasTriggerAction == FixUtils.TAG_HAS_VALUE) {		
				return triggerAction; 		
			} else {		
		
				buf.position(hasTriggerAction);		
		
			triggerAction = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (triggerAction != (byte)'3') && (triggerAction != (byte)'2') && (triggerAction != (byte)'1') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 1101);		
				if (err.hasError()) {		
					buf.position(hasTriggerAction);		
					return (byte)'0';		
				}		
			}		
			hasTriggerAction = FixUtils.TAG_HAS_VALUE;		
			return triggerAction;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasTriggerAction() { return hasTriggerAction != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTriggerAction(byte src) {		
		triggerAction = src;
		hasTriggerAction = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTriggerAction(byte[] src) {		
		if (src == null ) return;
		if (hasTriggerAction()) triggerAction = (byte)' ';		
		triggerAction = src[0];		
		hasTriggerAction = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTriggerAction(String str) {		
		if (str == null ) return;
		if (hasTriggerAction()) triggerAction = (byte)' ';		
		byte[] src = str.getBytes(); 		
		triggerAction = src[0];		
		hasTriggerAction = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getTriggerPrice() { 		
		if ( hasTriggerPrice()) {		
			if (hasTriggerPrice == FixUtils.TAG_HAS_VALUE) {		
				return triggerPrice; 		
			} else {		
		
				buf.position(hasTriggerPrice);		
		
			triggerPrice = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasTriggerPrice);		
					return 0;		
				}		
			}		
			hasTriggerPrice = FixUtils.TAG_HAS_VALUE;		
			return triggerPrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTriggerPrice() { return hasTriggerPrice != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTriggerPrice(long src) {		
		triggerPrice = src;
		hasTriggerPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTriggerPrice(byte[] src) {		
		if (src == null ) return;
		if (hasTriggerPrice()) triggerPrice = FixUtils.TAG_HAS_NO_VALUE;		
		triggerPrice = FixUtils.longValueOf(src, 0, src.length);
		hasTriggerPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTriggerPrice(String str) {		
		if (str == null ) return;
		if (hasTriggerPrice()) triggerPrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		triggerPrice = FixUtils.longValueOf(src, 0, src.length);
		hasTriggerPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTriggerSymbol() { 		
		if ( hasTriggerSymbol()) {		
			if (hasTriggerSymbol == FixUtils.TAG_HAS_VALUE) {		
				return triggerSymbol; 		
			} else {		
		
				buf.position(hasTriggerSymbol);		
		
			FixMessage.getTagStringValue(buf, triggerSymbol, 0, triggerSymbol.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTriggerSymbol);		
					return null;		
				}		
			}		
			hasTriggerSymbol = FixUtils.TAG_HAS_VALUE;		
			return triggerSymbol;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTriggerSymbol() { return hasTriggerSymbol != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTriggerSymbol(byte[] src) {		
		if (src == null ) return;
		if (hasTriggerSymbol()) FixUtils.fillSpace(triggerSymbol);		
		FixUtils.copy(triggerSymbol, src); 		
		hasTriggerSymbol = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTriggerSymbol(String str) {		
		if (str == null ) return;
		if (hasTriggerSymbol()) FixUtils.fillSpace(triggerSymbol);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(triggerSymbol, src); 		
		hasTriggerSymbol = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTriggerSecurityID() { 		
		if ( hasTriggerSecurityID()) {		
			if (hasTriggerSecurityID == FixUtils.TAG_HAS_VALUE) {		
				return triggerSecurityID; 		
			} else {		
		
				buf.position(hasTriggerSecurityID);		
		
			FixMessage.getTagStringValue(buf, triggerSecurityID, 0, triggerSecurityID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTriggerSecurityID);		
					return null;		
				}		
			}		
			hasTriggerSecurityID = FixUtils.TAG_HAS_VALUE;		
			return triggerSecurityID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTriggerSecurityID() { return hasTriggerSecurityID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTriggerSecurityID(byte[] src) {		
		if (src == null ) return;
		if (hasTriggerSecurityID()) FixUtils.fillSpace(triggerSecurityID);		
		FixUtils.copy(triggerSecurityID, src); 		
		hasTriggerSecurityID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTriggerSecurityID(String str) {		
		if (str == null ) return;
		if (hasTriggerSecurityID()) FixUtils.fillSpace(triggerSecurityID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(triggerSecurityID, src); 		
		hasTriggerSecurityID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTriggerSecurityIDSource() { 		
		if ( hasTriggerSecurityIDSource()) {		
			if (hasTriggerSecurityIDSource == FixUtils.TAG_HAS_VALUE) {		
				return triggerSecurityIDSource; 		
			} else {		
		
				buf.position(hasTriggerSecurityIDSource);		
		
			FixMessage.getTagStringValue(buf, triggerSecurityIDSource, 0, triggerSecurityIDSource.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTriggerSecurityIDSource);		
					return null;		
				}		
			}		
			hasTriggerSecurityIDSource = FixUtils.TAG_HAS_VALUE;		
			return triggerSecurityIDSource;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTriggerSecurityIDSource() { return hasTriggerSecurityIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTriggerSecurityIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasTriggerSecurityIDSource()) FixUtils.fillSpace(triggerSecurityIDSource);		
		FixUtils.copy(triggerSecurityIDSource, src); 		
		hasTriggerSecurityIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTriggerSecurityIDSource(String str) {		
		if (str == null ) return;
		if (hasTriggerSecurityIDSource()) FixUtils.fillSpace(triggerSecurityIDSource);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(triggerSecurityIDSource, src); 		
		hasTriggerSecurityIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTriggerSecurityDesc() { 		
		if ( hasTriggerSecurityDesc()) {		
			if (hasTriggerSecurityDesc == FixUtils.TAG_HAS_VALUE) {		
				return triggerSecurityDesc; 		
			} else {		
		
				buf.position(hasTriggerSecurityDesc);		
		
			FixMessage.getTagStringValue(buf, triggerSecurityDesc, 0, triggerSecurityDesc.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTriggerSecurityDesc);		
					return null;		
				}		
			}		
			hasTriggerSecurityDesc = FixUtils.TAG_HAS_VALUE;		
			return triggerSecurityDesc;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTriggerSecurityDesc() { return hasTriggerSecurityDesc != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTriggerSecurityDesc(byte[] src) {		
		if (src == null ) return;
		if (hasTriggerSecurityDesc()) FixUtils.fillSpace(triggerSecurityDesc);		
		FixUtils.copy(triggerSecurityDesc, src); 		
		hasTriggerSecurityDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTriggerSecurityDesc(String str) {		
		if (str == null ) return;
		if (hasTriggerSecurityDesc()) FixUtils.fillSpace(triggerSecurityDesc);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(triggerSecurityDesc, src); 		
		hasTriggerSecurityDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getTriggerPriceType() { 		
		if ( hasTriggerPriceType()) {		
			if (hasTriggerPriceType == FixUtils.TAG_HAS_VALUE) {		
				return triggerPriceType; 		
			} else {		
		
				buf.position(hasTriggerPriceType);		
		
			triggerPriceType = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (triggerPriceType != (byte)'3') && (triggerPriceType != (byte)'2') && (triggerPriceType != (byte)'1') && (triggerPriceType != (byte)'6') && (triggerPriceType != (byte)'5') && (triggerPriceType != (byte)'4') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 1107);		
				if (err.hasError()) {		
					buf.position(hasTriggerPriceType);		
					return (byte)'0';		
				}		
			}		
			hasTriggerPriceType = FixUtils.TAG_HAS_VALUE;		
			return triggerPriceType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasTriggerPriceType() { return hasTriggerPriceType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTriggerPriceType(byte src) {		
		triggerPriceType = src;
		hasTriggerPriceType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTriggerPriceType(byte[] src) {		
		if (src == null ) return;
		if (hasTriggerPriceType()) triggerPriceType = (byte)' ';		
		triggerPriceType = src[0];		
		hasTriggerPriceType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTriggerPriceType(String str) {		
		if (str == null ) return;
		if (hasTriggerPriceType()) triggerPriceType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		triggerPriceType = src[0];		
		hasTriggerPriceType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getTriggerPriceTypeScope() { 		
		if ( hasTriggerPriceTypeScope()) {		
			if (hasTriggerPriceTypeScope == FixUtils.TAG_HAS_VALUE) {		
				return triggerPriceTypeScope; 		
			} else {		
		
				buf.position(hasTriggerPriceTypeScope);		
		
			triggerPriceTypeScope = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (triggerPriceTypeScope != (byte)'3') && (triggerPriceTypeScope != (byte)'2') && (triggerPriceTypeScope != (byte)'1') && (triggerPriceTypeScope != (byte)'0') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 1108);		
				if (err.hasError()) {		
					buf.position(hasTriggerPriceTypeScope);		
					return (byte)'0';		
				}		
			}		
			hasTriggerPriceTypeScope = FixUtils.TAG_HAS_VALUE;		
			return triggerPriceTypeScope;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasTriggerPriceTypeScope() { return hasTriggerPriceTypeScope != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTriggerPriceTypeScope(byte src) {		
		triggerPriceTypeScope = src;
		hasTriggerPriceTypeScope = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTriggerPriceTypeScope(byte[] src) {		
		if (src == null ) return;
		if (hasTriggerPriceTypeScope()) triggerPriceTypeScope = (byte)' ';		
		triggerPriceTypeScope = src[0];		
		hasTriggerPriceTypeScope = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTriggerPriceTypeScope(String str) {		
		if (str == null ) return;
		if (hasTriggerPriceTypeScope()) triggerPriceTypeScope = (byte)' ';		
		byte[] src = str.getBytes(); 		
		triggerPriceTypeScope = src[0];		
		hasTriggerPriceTypeScope = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getTriggerPriceDirection() { 		
		if ( hasTriggerPriceDirection()) {		
			if (hasTriggerPriceDirection == FixUtils.TAG_HAS_VALUE) {		
				return triggerPriceDirection; 		
			} else {		
		
				buf.position(hasTriggerPriceDirection);		
		
			triggerPriceDirection = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (triggerPriceDirection != (byte)'D') && (triggerPriceDirection != (byte)'U') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 1109);		
				if (err.hasError()) {		
					buf.position(hasTriggerPriceDirection);		
					return (byte)'0';		
				}		
			}		
			hasTriggerPriceDirection = FixUtils.TAG_HAS_VALUE;		
			return triggerPriceDirection;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasTriggerPriceDirection() { return hasTriggerPriceDirection != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTriggerPriceDirection(byte src) {		
		triggerPriceDirection = src;
		hasTriggerPriceDirection = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTriggerPriceDirection(byte[] src) {		
		if (src == null ) return;
		if (hasTriggerPriceDirection()) triggerPriceDirection = (byte)' ';		
		triggerPriceDirection = src[0];		
		hasTriggerPriceDirection = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTriggerPriceDirection(String str) {		
		if (str == null ) return;
		if (hasTriggerPriceDirection()) triggerPriceDirection = (byte)' ';		
		byte[] src = str.getBytes(); 		
		triggerPriceDirection = src[0];		
		hasTriggerPriceDirection = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getTriggerNewPrice() { 		
		if ( hasTriggerNewPrice()) {		
			if (hasTriggerNewPrice == FixUtils.TAG_HAS_VALUE) {		
				return triggerNewPrice; 		
			} else {		
		
				buf.position(hasTriggerNewPrice);		
		
			triggerNewPrice = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasTriggerNewPrice);		
					return 0;		
				}		
			}		
			hasTriggerNewPrice = FixUtils.TAG_HAS_VALUE;		
			return triggerNewPrice;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTriggerNewPrice() { return hasTriggerNewPrice != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTriggerNewPrice(long src) {		
		triggerNewPrice = src;
		hasTriggerNewPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTriggerNewPrice(byte[] src) {		
		if (src == null ) return;
		if (hasTriggerNewPrice()) triggerNewPrice = FixUtils.TAG_HAS_NO_VALUE;		
		triggerNewPrice = FixUtils.longValueOf(src, 0, src.length);
		hasTriggerNewPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTriggerNewPrice(String str) {		
		if (str == null ) return;
		if (hasTriggerNewPrice()) triggerNewPrice = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		triggerNewPrice = FixUtils.longValueOf(src, 0, src.length);
		hasTriggerNewPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getTriggerOrderType() { 		
		if ( hasTriggerOrderType()) {		
			if (hasTriggerOrderType == FixUtils.TAG_HAS_VALUE) {		
				return triggerOrderType; 		
			} else {		
		
				buf.position(hasTriggerOrderType);		
		
			triggerOrderType = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (triggerOrderType != (byte)'2') && (triggerOrderType != (byte)'1') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 1111);		
				if (err.hasError()) {		
					buf.position(hasTriggerOrderType);		
					return (byte)'0';		
				}		
			}		
			hasTriggerOrderType = FixUtils.TAG_HAS_VALUE;		
			return triggerOrderType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasTriggerOrderType() { return hasTriggerOrderType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTriggerOrderType(byte src) {		
		triggerOrderType = src;
		hasTriggerOrderType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTriggerOrderType(byte[] src) {		
		if (src == null ) return;
		if (hasTriggerOrderType()) triggerOrderType = (byte)' ';		
		triggerOrderType = src[0];		
		hasTriggerOrderType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTriggerOrderType(String str) {		
		if (str == null ) return;
		if (hasTriggerOrderType()) triggerOrderType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		triggerOrderType = src[0];		
		hasTriggerOrderType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getTriggerNewQty() { 		
		if ( hasTriggerNewQty()) {		
			if (hasTriggerNewQty == FixUtils.TAG_HAS_VALUE) {		
				return triggerNewQty; 		
			} else {		
		
				buf.position(hasTriggerNewQty);		
		
			triggerNewQty = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasTriggerNewQty);		
					return 0;		
				}		
			}		
			hasTriggerNewQty = FixUtils.TAG_HAS_VALUE;		
			return triggerNewQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTriggerNewQty() { return hasTriggerNewQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTriggerNewQty(long src) {		
		triggerNewQty = src;
		hasTriggerNewQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTriggerNewQty(byte[] src) {		
		if (src == null ) return;
		if (hasTriggerNewQty()) triggerNewQty = FixUtils.TAG_HAS_NO_VALUE;		
		triggerNewQty = FixUtils.longValueOf(src, 0, src.length);
		hasTriggerNewQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTriggerNewQty(String str) {		
		if (str == null ) return;
		if (hasTriggerNewQty()) triggerNewQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		triggerNewQty = FixUtils.longValueOf(src, 0, src.length);
		hasTriggerNewQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTriggerTradingSessionID() { 		
		if ( hasTriggerTradingSessionID()) {		
			if (hasTriggerTradingSessionID == FixUtils.TAG_HAS_VALUE) {		
				return triggerTradingSessionID; 		
			} else {		
		
				buf.position(hasTriggerTradingSessionID);		
		
			FixMessage.getTagStringValue(buf, triggerTradingSessionID, 0, triggerTradingSessionID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTriggerTradingSessionID);		
					return null;		
				}		
			}		
			hasTriggerTradingSessionID = FixUtils.TAG_HAS_VALUE;		
			return triggerTradingSessionID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTriggerTradingSessionID() { return hasTriggerTradingSessionID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTriggerTradingSessionID(byte[] src) {		
		if (src == null ) return;
		if (hasTriggerTradingSessionID()) FixUtils.fillSpace(triggerTradingSessionID);		
		FixUtils.copy(triggerTradingSessionID, src); 		
		hasTriggerTradingSessionID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTriggerTradingSessionID(String str) {		
		if (str == null ) return;
		if (hasTriggerTradingSessionID()) FixUtils.fillSpace(triggerTradingSessionID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(triggerTradingSessionID, src); 		
		hasTriggerTradingSessionID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getTriggerTradingSessionSubID() { 		
		if ( hasTriggerTradingSessionSubID()) {		
			if (hasTriggerTradingSessionSubID == FixUtils.TAG_HAS_VALUE) {		
				return triggerTradingSessionSubID; 		
			} else {		
		
				buf.position(hasTriggerTradingSessionSubID);		
		
			FixMessage.getTagStringValue(buf, triggerTradingSessionSubID, 0, triggerTradingSessionSubID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasTriggerTradingSessionSubID);		
					return null;		
				}		
			}		
			hasTriggerTradingSessionSubID = FixUtils.TAG_HAS_VALUE;		
			return triggerTradingSessionSubID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTriggerTradingSessionSubID() { return hasTriggerTradingSessionSubID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTriggerTradingSessionSubID(byte[] src) {		
		if (src == null ) return;
		if (hasTriggerTradingSessionSubID()) FixUtils.fillSpace(triggerTradingSessionSubID);		
		FixUtils.copy(triggerTradingSessionSubID, src); 		
		hasTriggerTradingSessionSubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTriggerTradingSessionSubID(String str) {		
		if (str == null ) return;
		if (hasTriggerTradingSessionSubID()) FixUtils.fillSpace(triggerTradingSessionSubID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(triggerTradingSessionSubID, src); 		
		hasTriggerTradingSessionSubID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasTriggerType()) s += "TriggerType(1100)= " + getTriggerType() + "\n" ; 
		if (hasTriggerAction()) s += "TriggerAction(1101)= " + getTriggerAction() + "\n" ; 
		if (hasTriggerPrice()) s += "TriggerPrice(1102)= " + getTriggerPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasTriggerSymbol()) s += "TriggerSymbol(1103)= " + new String( FixUtils.trim(getTriggerSymbol()) ) + "\n" ; 
		if (hasTriggerSecurityID()) s += "TriggerSecurityID(1104)= " + new String( FixUtils.trim(getTriggerSecurityID()) ) + "\n" ; 
		if (hasTriggerSecurityIDSource()) s += "TriggerSecurityIDSource(1105)= " + new String( FixUtils.trim(getTriggerSecurityIDSource()) ) + "\n" ; 
		if (hasTriggerSecurityDesc()) s += "TriggerSecurityDesc(1106)= " + new String( FixUtils.trim(getTriggerSecurityDesc()) ) + "\n" ; 
		if (hasTriggerPriceType()) s += "TriggerPriceType(1107)= " + getTriggerPriceType() + "\n" ; 
		if (hasTriggerPriceTypeScope()) s += "TriggerPriceTypeScope(1108)= " + getTriggerPriceTypeScope() + "\n" ; 
		if (hasTriggerPriceDirection()) s += "TriggerPriceDirection(1109)= " + getTriggerPriceDirection() + "\n" ; 
		if (hasTriggerNewPrice()) s += "TriggerNewPrice(1110)= " + getTriggerNewPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasTriggerOrderType()) s += "TriggerOrderType(1111)= " + getTriggerOrderType() + "\n" ; 
		if (hasTriggerNewQty()) s += "TriggerNewQty(1112)= " + getTriggerNewQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasTriggerTradingSessionID()) s += "TriggerTradingSessionID(1113)= " + new String( FixUtils.trim(getTriggerTradingSessionID()) ) + "\n" ; 
		if (hasTriggerTradingSessionSubID()) s += "TriggerTradingSessionSubID(1114)= " + new String( FixUtils.trim(getTriggerTradingSessionSubID()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixTriggeringInstruction)) return false;

		FixTriggeringInstruction msg = (FixTriggeringInstruction) o;

		if ((hasTriggerType() && !msg.hasTriggerType()) || (!hasTriggerType() && msg.hasTriggerType())) return false;
		if (!(!hasTriggerType() && !msg.hasTriggerType()) && !(getTriggerType()==msg.getTriggerType())) return false;
		if ((hasTriggerAction() && !msg.hasTriggerAction()) || (!hasTriggerAction() && msg.hasTriggerAction())) return false;
		if (!(!hasTriggerAction() && !msg.hasTriggerAction()) && !(getTriggerAction()==msg.getTriggerAction())) return false;
		if ((hasTriggerPrice() && !msg.hasTriggerPrice()) || (!hasTriggerPrice() && msg.hasTriggerPrice())) return false;
		if (!(!hasTriggerPrice() && !msg.hasTriggerPrice()) && !(getTriggerPrice()==msg.getTriggerPrice())) return false;
		if ((hasTriggerSymbol() && !msg.hasTriggerSymbol()) || (!hasTriggerSymbol() && msg.hasTriggerSymbol())) return false;
		if (!(!hasTriggerSymbol() && !msg.hasTriggerSymbol()) && !FixUtils.equals(getTriggerSymbol(), msg.getTriggerSymbol())) return false;
		if ((hasTriggerSecurityID() && !msg.hasTriggerSecurityID()) || (!hasTriggerSecurityID() && msg.hasTriggerSecurityID())) return false;
		if (!(!hasTriggerSecurityID() && !msg.hasTriggerSecurityID()) && !FixUtils.equals(getTriggerSecurityID(), msg.getTriggerSecurityID())) return false;
		if ((hasTriggerSecurityIDSource() && !msg.hasTriggerSecurityIDSource()) || (!hasTriggerSecurityIDSource() && msg.hasTriggerSecurityIDSource())) return false;
		if (!(!hasTriggerSecurityIDSource() && !msg.hasTriggerSecurityIDSource()) && !FixUtils.equals(getTriggerSecurityIDSource(), msg.getTriggerSecurityIDSource())) return false;
		if ((hasTriggerSecurityDesc() && !msg.hasTriggerSecurityDesc()) || (!hasTriggerSecurityDesc() && msg.hasTriggerSecurityDesc())) return false;
		if (!(!hasTriggerSecurityDesc() && !msg.hasTriggerSecurityDesc()) && !FixUtils.equals(getTriggerSecurityDesc(), msg.getTriggerSecurityDesc())) return false;
		if ((hasTriggerPriceType() && !msg.hasTriggerPriceType()) || (!hasTriggerPriceType() && msg.hasTriggerPriceType())) return false;
		if (!(!hasTriggerPriceType() && !msg.hasTriggerPriceType()) && !(getTriggerPriceType()==msg.getTriggerPriceType())) return false;
		if ((hasTriggerPriceTypeScope() && !msg.hasTriggerPriceTypeScope()) || (!hasTriggerPriceTypeScope() && msg.hasTriggerPriceTypeScope())) return false;
		if (!(!hasTriggerPriceTypeScope() && !msg.hasTriggerPriceTypeScope()) && !(getTriggerPriceTypeScope()==msg.getTriggerPriceTypeScope())) return false;
		if ((hasTriggerPriceDirection() && !msg.hasTriggerPriceDirection()) || (!hasTriggerPriceDirection() && msg.hasTriggerPriceDirection())) return false;
		if (!(!hasTriggerPriceDirection() && !msg.hasTriggerPriceDirection()) && !(getTriggerPriceDirection()==msg.getTriggerPriceDirection())) return false;
		if ((hasTriggerNewPrice() && !msg.hasTriggerNewPrice()) || (!hasTriggerNewPrice() && msg.hasTriggerNewPrice())) return false;
		if (!(!hasTriggerNewPrice() && !msg.hasTriggerNewPrice()) && !(getTriggerNewPrice()==msg.getTriggerNewPrice())) return false;
		if ((hasTriggerOrderType() && !msg.hasTriggerOrderType()) || (!hasTriggerOrderType() && msg.hasTriggerOrderType())) return false;
		if (!(!hasTriggerOrderType() && !msg.hasTriggerOrderType()) && !(getTriggerOrderType()==msg.getTriggerOrderType())) return false;
		if ((hasTriggerNewQty() && !msg.hasTriggerNewQty()) || (!hasTriggerNewQty() && msg.hasTriggerNewQty())) return false;
		if (!(!hasTriggerNewQty() && !msg.hasTriggerNewQty()) && !(getTriggerNewQty()==msg.getTriggerNewQty())) return false;
		if ((hasTriggerTradingSessionID() && !msg.hasTriggerTradingSessionID()) || (!hasTriggerTradingSessionID() && msg.hasTriggerTradingSessionID())) return false;
		if (!(!hasTriggerTradingSessionID() && !msg.hasTriggerTradingSessionID()) && !FixUtils.equals(getTriggerTradingSessionID(), msg.getTriggerTradingSessionID())) return false;
		if ((hasTriggerTradingSessionSubID() && !msg.hasTriggerTradingSessionSubID()) || (!hasTriggerTradingSessionSubID() && msg.hasTriggerTradingSessionSubID())) return false;
		if (!(!hasTriggerTradingSessionSubID() && !msg.hasTriggerTradingSessionSubID()) && !FixUtils.equals(getTriggerTradingSessionSubID(), msg.getTriggerTradingSessionSubID())) return false;
		return true;
	}
	public FixTriggeringInstruction clone ( FixTriggeringInstruction out ) {
		if ( hasTriggerType())
			out.setTriggerType(getTriggerType());
		if ( hasTriggerAction())
			out.setTriggerAction(getTriggerAction());
		if ( hasTriggerPrice())
			out.setTriggerPrice(getTriggerPrice());
		if ( hasTriggerSymbol())
			out.setTriggerSymbol(getTriggerSymbol());
		if ( hasTriggerSecurityID())
			out.setTriggerSecurityID(getTriggerSecurityID());
		if ( hasTriggerSecurityIDSource())
			out.setTriggerSecurityIDSource(getTriggerSecurityIDSource());
		if ( hasTriggerSecurityDesc())
			out.setTriggerSecurityDesc(getTriggerSecurityDesc());
		if ( hasTriggerPriceType())
			out.setTriggerPriceType(getTriggerPriceType());
		if ( hasTriggerPriceTypeScope())
			out.setTriggerPriceTypeScope(getTriggerPriceTypeScope());
		if ( hasTriggerPriceDirection())
			out.setTriggerPriceDirection(getTriggerPriceDirection());
		if ( hasTriggerNewPrice())
			out.setTriggerNewPrice(getTriggerNewPrice());
		if ( hasTriggerOrderType())
			out.setTriggerOrderType(getTriggerOrderType());
		if ( hasTriggerNewQty())
			out.setTriggerNewQty(getTriggerNewQty());
		if ( hasTriggerTradingSessionID())
			out.setTriggerTradingSessionID(getTriggerTradingSessionID());
		if ( hasTriggerTradingSessionSubID())
			out.setTriggerTradingSessionSubID(getTriggerTradingSessionSubID());
		return out;
	}

}
