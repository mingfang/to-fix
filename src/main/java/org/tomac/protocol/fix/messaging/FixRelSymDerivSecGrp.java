package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixRelSymDerivSecGrp extends FixGroup {
	private short hasCurrency;
	byte[] currency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasCorporateAction;
	byte[] corporateAction = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRelSymTransactTime;
	byte[] relSymTransactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedTextLen;
	long encodedTextLen = 0;		
	private short hasEncodedText;
	byte[] encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		public FixInstrument instrument;
		public FixSecondaryPriceLimits secondaryPriceLimits;
		public FixInstrumentExtension instrumentExtension;
		public FixInstrmtLegGrp[] instrmtLegGrp;
	
	public FixRelSymDerivSecGrp() {
		this(false);
	}

	public FixRelSymDerivSecGrp(boolean isRequired) {
		super(FixTags.SYMBOL_INT);

		this.isRequired = isRequired;
		
		hasCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		currency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasCorporateAction = FixUtils.TAG_HAS_NO_VALUE;		
		corporateAction = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRelSymTransactTime = FixUtils.TAG_HAS_NO_VALUE;		
		relSymTransactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		instrument = new FixInstrument();
		secondaryPriceLimits = new FixSecondaryPriceLimits();
		instrumentExtension = new FixInstrumentExtension();
		instrmtLegGrp = new FixInstrmtLegGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) instrmtLegGrp[i] = new FixInstrmtLegGrp();
		
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
            	case FixTags.CURRENCY_INT:		
            		hasCurrency = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.CORPORATEACTION_INT:		
            		hasCorporateAction = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RELSYMTRANSACTTIME_INT:		
            		hasRelSymTransactTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TEXT_INT:		
            		hasText = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ENCODEDTEXTLEN_INT:		
            		hasEncodedTextLen = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ENCODEDTEXT_INT:		
            		hasEncodedText = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( instrument.isKeyTag(tag)) {
        				tag = instrument.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( secondaryPriceLimits.isKeyTag(tag)) {
        				tag = secondaryPriceLimits.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( instrumentExtension.isKeyTag(tag)) {
        				tag = instrumentExtension.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NOLEGS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !instrmtLegGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = instrmtLegGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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
		hasCurrency = FixUtils.TAG_HAS_NO_VALUE;
		hasCorporateAction = FixUtils.TAG_HAS_NO_VALUE;
		hasRelSymTransactTime = FixUtils.TAG_HAS_NO_VALUE;
		hasText = FixUtils.TAG_HAS_NO_VALUE;
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;
		instrument.clear();
		secondaryPriceLimits.clear();
		instrumentExtension.clear();
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp) fixInstrmtLegGrp.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasCurrency()) {		
			out.put(FixTags.CURRENCY);

			out.put((byte) '=');

			FixUtils.put(out,currency); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasCorporateAction()) {		
			out.put(FixTags.CORPORATEACTION);

			out.put((byte) '=');

			FixUtils.put(out,corporateAction); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRelSymTransactTime()) {		
			out.put(FixTags.RELSYMTRANSACTTIME);

			out.put((byte) '=');

			FixUtils.put(out,relSymTransactTime); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasText()) {		
			out.put(FixTags.TEXT);

			out.put((byte) '=');

			FixUtils.put(out,text); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasEncodedTextLen()) {		
			out.put(FixTags.ENCODEDTEXTLEN);

			out.put((byte) '=');

			FixUtils.put(out, (long)encodedTextLen);
		
			out.put(FixUtils.SOH);

            }

		if (hasEncodedText()) {		
			out.put(FixTags.ENCODEDTEXT);

			out.put((byte) '=');

			FixUtils.put(out,encodedText); 		
		
			out.put(FixUtils.SOH);

            }

		instrument.encode(out);
		secondaryPriceLimits.encode(out);
		instrumentExtension.encode(out);
		if (FixUtils.getNoInGroup(instrmtLegGrp)>0) {
			out.put(FixTags.NOLEGS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(instrmtLegGrp));

			out.put(FixUtils.SOH);

		}
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp) if (fixInstrmtLegGrp.hasGroup()) fixInstrmtLegGrp.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasCurrency()) {		
			FixUtils.put(out,currency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCorporateAction()) {		
			FixUtils.put(out,corporateAction); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelSymTransactTime()) {		
			FixUtils.put(out,relSymTransactTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasText()) {		
			FixUtils.put(out,text); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedTextLen()) {		
			FixUtils.put(out, (long)encodedTextLen);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEncodedText()) {		
			FixUtils.put(out,encodedText); 		
		
	        out.put( (byte)' ' );		
		}		
		
		instrument.printBuffer(out);
		secondaryPriceLimits.printBuffer(out);
		instrumentExtension.printBuffer(out);
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp) fixInstrmtLegGrp.printBuffer(out);
	}

	public byte[] getCurrency() { 		
		if ( hasCurrency()) {		
			if (hasCurrency == FixUtils.TAG_HAS_VALUE) {		
				return currency; 		
			} else {		
		
				buf.position(hasCurrency);		
		
			FixMessage.getTagStringValue(buf, currency, 0, currency.length, err);
		
				if (err.hasError()) {		
					buf.position(hasCurrency);		
					return null;		
				}		
			}		
			hasCurrency = FixUtils.TAG_HAS_VALUE;		
			return currency;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCurrency() { return hasCurrency != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCurrency(byte[] src) {		
		if (src == null ) return;
		if (hasCurrency()) FixUtils.fillSpace(currency);		
		FixUtils.copy(currency, src); 		
		hasCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCurrency(String str) {		
		if (str == null ) return;
		if (hasCurrency()) FixUtils.fillSpace(currency);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(currency, src); 		
		hasCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getCorporateAction() { 		
		if ( hasCorporateAction()) {		
			if (hasCorporateAction == FixUtils.TAG_HAS_VALUE) {		
				return corporateAction; 		
			} else {		
		
				buf.position(hasCorporateAction);		
		
			FixMessage.getTagStringValue(buf, corporateAction, 0, corporateAction.length, err);
		
				if (err.hasError()) {		
					buf.position(hasCorporateAction);		
					return null;		
				}		
			}		
			hasCorporateAction = FixUtils.TAG_HAS_VALUE;		
			return corporateAction;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCorporateAction() { return hasCorporateAction != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCorporateAction(byte[] src) {		
		if (src == null ) return;
		if (hasCorporateAction()) FixUtils.fillSpace(corporateAction);		
		FixUtils.copy(corporateAction, src); 		
		hasCorporateAction = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCorporateAction(String str) {		
		if (str == null ) return;
		if (hasCorporateAction()) FixUtils.fillSpace(corporateAction);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(corporateAction, src); 		
		hasCorporateAction = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRelSymTransactTime() { 		
		if ( hasRelSymTransactTime()) {		
			if (hasRelSymTransactTime == FixUtils.TAG_HAS_VALUE) {		
				return relSymTransactTime; 		
			} else {		
		
				buf.position(hasRelSymTransactTime);		
		
			FixMessage.getTagStringValue(buf, relSymTransactTime, 0, relSymTransactTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRelSymTransactTime);		
					return null;		
				}		
			}		
			hasRelSymTransactTime = FixUtils.TAG_HAS_VALUE;		
			return relSymTransactTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRelSymTransactTime() { return hasRelSymTransactTime != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelSymTransactTime(byte[] src) {		
		if (src == null ) return;
		if (hasRelSymTransactTime()) FixUtils.fillSpace(relSymTransactTime);		
		FixUtils.copy(relSymTransactTime, src); 		
		hasRelSymTransactTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelSymTransactTime(String str) {		
		if (str == null ) return;
		if (hasRelSymTransactTime()) FixUtils.fillSpace(relSymTransactTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(relSymTransactTime, src); 		
		hasRelSymTransactTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getText() { 		
		if ( hasText()) {		
			if (hasText == FixUtils.TAG_HAS_VALUE) {		
				return text; 		
			} else {		
		
				buf.position(hasText);		
		
			FixMessage.getTagStringValue(buf, text, 0, text.length, err);
		
				if (err.hasError()) {		
					buf.position(hasText);		
					return null;		
				}		
			}		
			hasText = FixUtils.TAG_HAS_VALUE;		
			return text;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasText() { return hasText != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setText(byte[] src) {		
		if (src == null ) return;
		if (hasText()) FixUtils.fillSpace(text);		
		FixUtils.copy(text, src); 		
		hasText = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setText(String str) {		
		if (str == null ) return;
		if (hasText()) FixUtils.fillSpace(text);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(text, src); 		
		hasText = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getEncodedTextLen() { 		
		if ( hasEncodedTextLen()) {		
			if (hasEncodedTextLen == FixUtils.TAG_HAS_VALUE) {		
				return encodedTextLen; 		
			} else {		
		
				buf.position(hasEncodedTextLen);		
		
			encodedTextLen = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasEncodedTextLen);		
					return 0;		
				}		
			}		
			hasEncodedTextLen = FixUtils.TAG_HAS_VALUE;		
			return encodedTextLen;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEncodedTextLen() { return hasEncodedTextLen != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEncodedTextLen(long src) {		
		encodedTextLen = src;
		hasEncodedTextLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEncodedTextLen(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedTextLen()) encodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		encodedTextLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedTextLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEncodedTextLen(String str) {		
		if (str == null ) return;
		if (hasEncodedTextLen()) encodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		encodedTextLen = FixUtils.longValueOf(src, 0, src.length);
		hasEncodedTextLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getEncodedText() { 		
		if ( hasEncodedText()) {		
			if (hasEncodedText == FixUtils.TAG_HAS_VALUE) {		
				return encodedText; 		
			} else {		
		
				buf.position(hasEncodedText);		
		
			FixMessage.getTagStringValue(buf, encodedText, 0, encodedText.length, err);
		
				if (err.hasError()) {		
					buf.position(hasEncodedText);		
					return null;		
				}		
			}		
			hasEncodedText = FixUtils.TAG_HAS_VALUE;		
			return encodedText;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasEncodedText() { return hasEncodedText != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEncodedText(byte[] src) {		
		if (src == null ) return;
		if (hasEncodedText()) FixUtils.fillSpace(encodedText);		
		FixUtils.copy(encodedText, src); 		
		hasEncodedText = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEncodedText(String str) {		
		if (str == null ) return;
		if (hasEncodedText()) FixUtils.fillSpace(encodedText);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(encodedText, src); 		
		hasEncodedText = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasCurrency()) s += "Currency(15)= " + new String( FixUtils.trim(getCurrency()) ) + "\n" ; 
		if (hasCorporateAction()) s += "CorporateAction(292)= " + new String( FixUtils.trim(getCorporateAction()) ) + "\n" ; 
		if (hasRelSymTransactTime()) s += "RelSymTransactTime(1504)= " + new String( FixUtils.trim(getRelSymTransactTime()) ) + "\n" ; 
		if (hasText()) s += "Text(58)= " + new String( FixUtils.trim(getText()) ) + "\n" ; 
		if (hasEncodedTextLen()) s += "EncodedTextLen(354)= " + getEncodedTextLen() + "\n" ; 
		if (hasEncodedText()) s += "EncodedText(355)= " + new String( FixUtils.trim(getEncodedText()) ) + "\n" ; 

		s += instrument.toString();
		s += secondaryPriceLimits.toString();
		s += instrumentExtension.toString();
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp) fixInstrmtLegGrp.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixRelSymDerivSecGrp)) return false;

		FixRelSymDerivSecGrp msg = (FixRelSymDerivSecGrp) o;

		if (!instrument.equals(msg.instrument)) return false;
		if (!secondaryPriceLimits.equals(msg.secondaryPriceLimits)) return false;
		if (!instrumentExtension.equals(msg.instrumentExtension)) return false;
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp)
			if (!fixInstrmtLegGrp.equals(msg.instrmtLegGrp)) return false;
		if ((hasCurrency() && !msg.hasCurrency()) || (!hasCurrency() && msg.hasCurrency())) return false;
		if (!(!hasCurrency() && !msg.hasCurrency()) && !FixUtils.equals(getCurrency(), msg.getCurrency())) return false;
		if ((hasCorporateAction() && !msg.hasCorporateAction()) || (!hasCorporateAction() && msg.hasCorporateAction())) return false;
		if (!(!hasCorporateAction() && !msg.hasCorporateAction()) && !FixUtils.equals(getCorporateAction(), msg.getCorporateAction())) return false;
		if ((hasRelSymTransactTime() && !msg.hasRelSymTransactTime()) || (!hasRelSymTransactTime() && msg.hasRelSymTransactTime())) return false;
		if (!(!hasRelSymTransactTime() && !msg.hasRelSymTransactTime()) ) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasEncodedTextLen() && !msg.hasEncodedTextLen()) || (!hasEncodedTextLen() && msg.hasEncodedTextLen())) return false;
		if (!(!hasEncodedTextLen() && !msg.hasEncodedTextLen()) && !(getEncodedTextLen()==msg.getEncodedTextLen())) return false;
		if ((hasEncodedText() && !msg.hasEncodedText()) || (!hasEncodedText() && msg.hasEncodedText())) return false;
		if (!(!hasEncodedText() && !msg.hasEncodedText()) && !FixUtils.equals(getEncodedText(), msg.getEncodedText())) return false;
		return true;
	}
	public FixRelSymDerivSecGrp clone ( FixRelSymDerivSecGrp out ) {
		if ( hasCurrency())
			out.setCurrency(getCurrency());
		if ( hasCorporateAction())
			out.setCorporateAction(getCorporateAction());
		if ( hasRelSymTransactTime())
			out.setRelSymTransactTime(getRelSymTransactTime());
		if ( hasText())
			out.setText(getText());
		if ( hasEncodedTextLen())
			out.setEncodedTextLen(getEncodedTextLen());
		if ( hasEncodedText())
			out.setEncodedText(getEncodedText());
		if (instrument.hasGroup())
			out.instrument = instrument.clone( out.instrument);
		if (secondaryPriceLimits.hasGroup())
			out.secondaryPriceLimits = secondaryPriceLimits.clone( out.secondaryPriceLimits);
		if (instrumentExtension.hasGroup())
			out.instrumentExtension = instrumentExtension.clone( out.instrumentExtension);
		int count = 0;
		count = 0;
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp) {
			if (!fixInstrmtLegGrp.hasGroup()) continue;
			out.instrmtLegGrp[count] = fixInstrmtLegGrp.clone( out.instrmtLegGrp[count] );
			count++;
		}
		return out;
	}

}
