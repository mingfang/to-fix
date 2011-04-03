package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixSecLstUpdRelSymGrp extends FixGroup {
	private short hasCurrency;
	byte[] currency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasListUpdateAction;
	byte listUpdateAction = (byte)' ';		
	private short hasText;
	byte[] text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasEncodedTextLen;
	long encodedTextLen = 0;		
	private short hasEncodedText;
	byte[] encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
	private short hasRelSymTransactTime;
	byte[] relSymTransactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		public FixInstrument instrument;
		public FixInstrumentExtension instrumentExtension;
		public FixFinancingDetails financingDetails;
		public FixSecLstUpdRelSymsLegGrp[] secLstUpdRelSymsLegGrp;
		public FixSpreadOrBenchmarkCurveData spreadOrBenchmarkCurveData;
		public FixUndInstrmtGrp[] undInstrmtGrp;
		public FixStipulations[] stipulations;
		public FixSecurityTradingRules securityTradingRules;
		public FixStrikeRules[] strikeRules;
		public FixYieldData yieldData;
	
	public FixSecLstUpdRelSymGrp() {
		this(false);
	}

	public FixSecLstUpdRelSymGrp(boolean isRequired) {
		super(FixTags.CURRENCY_INT);

		this.isRequired = isRequired;
		
		hasCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		currency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasListUpdateAction = FixUtils.TAG_HAS_NO_VALUE;		
		hasText = FixUtils.TAG_HAS_NO_VALUE;		
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;		
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];		
		hasRelSymTransactTime = FixUtils.TAG_HAS_NO_VALUE;		
		relSymTransactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		instrument = new FixInstrument();
		instrumentExtension = new FixInstrumentExtension();
		financingDetails = new FixFinancingDetails();
		secLstUpdRelSymsLegGrp = new FixSecLstUpdRelSymsLegGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) secLstUpdRelSymsLegGrp[i] = new FixSecLstUpdRelSymsLegGrp();
		spreadOrBenchmarkCurveData = new FixSpreadOrBenchmarkCurveData();
		undInstrmtGrp = new FixUndInstrmtGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) undInstrmtGrp[i] = new FixUndInstrmtGrp();
		stipulations = new FixStipulations[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) stipulations[i] = new FixStipulations();
		securityTradingRules = new FixSecurityTradingRules();
		strikeRules = new FixStrikeRules[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) strikeRules[i] = new FixStrikeRules();
		yieldData = new FixYieldData();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasCurrency()) return true;
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
            	case FixTags.LISTUPDATEACTION_INT:		
            		hasListUpdateAction = (short) buf.position();		
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
            	case FixTags.RELSYMTRANSACTTIME_INT:		
            		hasRelSymTransactTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( instrument.isKeyTag(tag)) {
        				tag = instrument.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( instrumentExtension.isKeyTag(tag)) {
        				tag = instrumentExtension.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( financingDetails.isKeyTag(tag)) {
        				tag = financingDetails.setBuffer( tag, buf, err);		
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
        					if ( !secLstUpdRelSymsLegGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = secLstUpdRelSymsLegGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( spreadOrBenchmarkCurveData.isKeyTag(tag)) {
        				tag = spreadOrBenchmarkCurveData.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NOUNDERLYINGS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !undInstrmtGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = undInstrmtGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOSTIPULATIONS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !stipulations[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = stipulations[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( securityTradingRules.isKeyTag(tag)) {
        				tag = securityTradingRules.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NOSTRIKERULES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !strikeRules[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = strikeRules[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( yieldData.isKeyTag(tag)) {
        				tag = yieldData.setBuffer( tag, buf, err);		
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
		hasCurrency = FixUtils.TAG_HAS_NO_VALUE;
		hasListUpdateAction = FixUtils.TAG_HAS_NO_VALUE;
		hasText = FixUtils.TAG_HAS_NO_VALUE;
		hasEncodedTextLen = FixUtils.TAG_HAS_NO_VALUE;
		hasEncodedText = FixUtils.TAG_HAS_NO_VALUE;
		hasRelSymTransactTime = FixUtils.TAG_HAS_NO_VALUE;
		instrument.clear();
		instrumentExtension.clear();
		financingDetails.clear();
		for (FixSecLstUpdRelSymsLegGrp fixSecLstUpdRelSymsLegGrp : secLstUpdRelSymsLegGrp) fixSecLstUpdRelSymsLegGrp.clear();
		spreadOrBenchmarkCurveData.clear();
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) fixUndInstrmtGrp.clear();
		for (FixStipulations fixStipulations : stipulations) fixStipulations.clear();
		securityTradingRules.clear();
		for (FixStrikeRules fixStrikeRules : strikeRules) fixStrikeRules.clear();
		yieldData.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasCurrency()) {		
			out.put(FixTags.CURRENCY);

			out.put((byte) '=');

			FixUtils.put(out,currency); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasListUpdateAction()) {		
			out.put(FixTags.LISTUPDATEACTION);

			out.put((byte) '=');

			FixUtils.put(out,listUpdateAction); 		
		
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

		if (hasRelSymTransactTime()) {		
			out.put(FixTags.RELSYMTRANSACTTIME);

			out.put((byte) '=');

			FixUtils.put(out,relSymTransactTime); 		
		
			out.put(FixUtils.SOH);

            }

		instrument.encode(out);
		instrumentExtension.encode(out);
		financingDetails.encode(out);
		if (FixUtils.getNoInGroup(secLstUpdRelSymsLegGrp)>0) {
			out.put(FixTags.NOLEGS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(secLstUpdRelSymsLegGrp));

			out.put(FixUtils.SOH);

		}
		for (FixSecLstUpdRelSymsLegGrp fixSecLstUpdRelSymsLegGrp : secLstUpdRelSymsLegGrp) if (fixSecLstUpdRelSymsLegGrp.hasGroup()) fixSecLstUpdRelSymsLegGrp.encode(out);
		spreadOrBenchmarkCurveData.encode(out);
		if (FixUtils.getNoInGroup(undInstrmtGrp)>0) {
			out.put(FixTags.NOUNDERLYINGS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(undInstrmtGrp));

			out.put(FixUtils.SOH);

		}
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) if (fixUndInstrmtGrp.hasGroup()) fixUndInstrmtGrp.encode(out);
		if (FixUtils.getNoInGroup(stipulations)>0) {
			out.put(FixTags.NOSTIPULATIONS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(stipulations));

			out.put(FixUtils.SOH);

		}
		for (FixStipulations fixStipulations : stipulations) if (fixStipulations.hasGroup()) fixStipulations.encode(out);
		securityTradingRules.encode(out);
		if (FixUtils.getNoInGroup(strikeRules)>0) {
			out.put(FixTags.NOSTRIKERULES);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(strikeRules));

			out.put(FixUtils.SOH);

		}
		for (FixStrikeRules fixStrikeRules : strikeRules) if (fixStrikeRules.hasGroup()) fixStrikeRules.encode(out);
		yieldData.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasCurrency()) {		
			FixUtils.put(out,currency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasListUpdateAction()) {		
			FixUtils.put(out,listUpdateAction); 		
		
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
		
		if (hasRelSymTransactTime()) {		
			FixUtils.put(out,relSymTransactTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		instrument.printBuffer(out);
		instrumentExtension.printBuffer(out);
		financingDetails.printBuffer(out);
		for (FixSecLstUpdRelSymsLegGrp fixSecLstUpdRelSymsLegGrp : secLstUpdRelSymsLegGrp) fixSecLstUpdRelSymsLegGrp.printBuffer(out);
		spreadOrBenchmarkCurveData.printBuffer(out);
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) fixUndInstrmtGrp.printBuffer(out);
		for (FixStipulations fixStipulations : stipulations) fixStipulations.printBuffer(out);
		securityTradingRules.printBuffer(out);
		for (FixStrikeRules fixStrikeRules : strikeRules) fixStrikeRules.printBuffer(out);
		yieldData.printBuffer(out);
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
			
	public byte getListUpdateAction() { 		
		if ( hasListUpdateAction()) {		
			if (hasListUpdateAction == FixUtils.TAG_HAS_VALUE) {		
				return listUpdateAction; 		
			} else {		
		
				buf.position(hasListUpdateAction);		
		
			listUpdateAction = FixMessage.getTagCharValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasListUpdateAction);		
					return (byte)'0';		
				}		
			}		
			hasListUpdateAction = FixUtils.TAG_HAS_VALUE;		
			return listUpdateAction;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasListUpdateAction() { return hasListUpdateAction != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setListUpdateAction(byte src) {		
		listUpdateAction = src;
		hasListUpdateAction = FixUtils.TAG_HAS_VALUE;		
	}

	public void setListUpdateAction(byte[] src) {		
		if (src == null ) return;
		if (hasListUpdateAction()) listUpdateAction = (byte)' ';		
		listUpdateAction = src[0];		
		hasListUpdateAction = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setListUpdateAction(String str) {		
		if (str == null ) return;
		if (hasListUpdateAction()) listUpdateAction = (byte)' ';		
		byte[] src = str.getBytes(); 		
		listUpdateAction = src[0];		
		hasListUpdateAction = FixUtils.TAG_HAS_VALUE;		
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
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasCurrency()) s += "Currency(15)= " + new String( FixUtils.trim(getCurrency()) ) + "\n" ; 
		if (hasListUpdateAction()) s += "ListUpdateAction(1324)= " + getListUpdateAction() + "\n" ; 
		if (hasText()) s += "Text(58)= " + new String( FixUtils.trim(getText()) ) + "\n" ; 
		if (hasEncodedTextLen()) s += "EncodedTextLen(354)= " + getEncodedTextLen() + "\n" ; 
		if (hasEncodedText()) s += "EncodedText(355)= " + new String( FixUtils.trim(getEncodedText()) ) + "\n" ; 
		if (hasRelSymTransactTime()) s += "RelSymTransactTime(1504)= " + new String( FixUtils.trim(getRelSymTransactTime()) ) + "\n" ; 

		s += instrument.toString();
		s += instrumentExtension.toString();
		s += financingDetails.toString();
		for (FixSecLstUpdRelSymsLegGrp fixSecLstUpdRelSymsLegGrp : secLstUpdRelSymsLegGrp) fixSecLstUpdRelSymsLegGrp.toString();
		s += spreadOrBenchmarkCurveData.toString();
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) fixUndInstrmtGrp.toString();
		for (FixStipulations fixStipulations : stipulations) fixStipulations.toString();
		s += securityTradingRules.toString();
		for (FixStrikeRules fixStrikeRules : strikeRules) fixStrikeRules.toString();
		s += yieldData.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixSecLstUpdRelSymGrp)) return false;

		FixSecLstUpdRelSymGrp msg = (FixSecLstUpdRelSymGrp) o;

		if (!instrument.equals(msg.instrument)) return false;
		if (!instrumentExtension.equals(msg.instrumentExtension)) return false;
		if (!financingDetails.equals(msg.financingDetails)) return false;
		for (int i = 0; i < secLstUpdRelSymsLegGrp.length; i++)
			if (!secLstUpdRelSymsLegGrp[i].equals(msg.secLstUpdRelSymsLegGrp[i])) return false;
		if (!spreadOrBenchmarkCurveData.equals(msg.spreadOrBenchmarkCurveData)) return false;
		for (int i = 0; i < undInstrmtGrp.length; i++)
			if (!undInstrmtGrp[i].equals(msg.undInstrmtGrp[i])) return false;
		for (int i = 0; i < stipulations.length; i++)
			if (!stipulations[i].equals(msg.stipulations[i])) return false;
		if (!securityTradingRules.equals(msg.securityTradingRules)) return false;
		for (int i = 0; i < strikeRules.length; i++)
			if (!strikeRules[i].equals(msg.strikeRules[i])) return false;
		if (!yieldData.equals(msg.yieldData)) return false;
		if ((hasCurrency() && !msg.hasCurrency()) || (!hasCurrency() && msg.hasCurrency())) return false;
		if (!(!hasCurrency() && !msg.hasCurrency()) && !FixUtils.equals(getCurrency(), msg.getCurrency())) return false;
		if ((hasListUpdateAction() && !msg.hasListUpdateAction()) || (!hasListUpdateAction() && msg.hasListUpdateAction())) return false;
		if (!(!hasListUpdateAction() && !msg.hasListUpdateAction()) && !(getListUpdateAction()==msg.getListUpdateAction())) return false;
		if ((hasText() && !msg.hasText()) || (!hasText() && msg.hasText())) return false;
		if (!(!hasText() && !msg.hasText()) && !FixUtils.equals(getText(), msg.getText())) return false;
		if ((hasEncodedTextLen() && !msg.hasEncodedTextLen()) || (!hasEncodedTextLen() && msg.hasEncodedTextLen())) return false;
		if (!(!hasEncodedTextLen() && !msg.hasEncodedTextLen()) && !(getEncodedTextLen()==msg.getEncodedTextLen())) return false;
		if ((hasEncodedText() && !msg.hasEncodedText()) || (!hasEncodedText() && msg.hasEncodedText())) return false;
		if (!(!hasEncodedText() && !msg.hasEncodedText()) && !FixUtils.equals(getEncodedText(), msg.getEncodedText())) return false;
		if ((hasRelSymTransactTime() && !msg.hasRelSymTransactTime()) || (!hasRelSymTransactTime() && msg.hasRelSymTransactTime())) return false;
		return true;
	}
	public FixSecLstUpdRelSymGrp clone ( FixSecLstUpdRelSymGrp out ) {
		if ( hasCurrency())
			out.setCurrency(getCurrency());
		if ( hasListUpdateAction())
			out.setListUpdateAction(getListUpdateAction());
		if ( hasText())
			out.setText(getText());
		if ( hasEncodedTextLen())
			out.setEncodedTextLen(getEncodedTextLen());
		if ( hasEncodedText())
			out.setEncodedText(getEncodedText());
		if ( hasRelSymTransactTime())
			out.setRelSymTransactTime(getRelSymTransactTime());
		if (instrument.hasGroup())
			out.instrument = instrument.clone( out.instrument);
		if (instrumentExtension.hasGroup())
			out.instrumentExtension = instrumentExtension.clone( out.instrumentExtension);
		if (financingDetails.hasGroup())
			out.financingDetails = financingDetails.clone( out.financingDetails);
		int count = 0;
		count = 0;
		for (FixSecLstUpdRelSymsLegGrp fixSecLstUpdRelSymsLegGrp : secLstUpdRelSymsLegGrp) {
			if (!fixSecLstUpdRelSymsLegGrp.hasGroup()) continue;
			out.secLstUpdRelSymsLegGrp[count] = fixSecLstUpdRelSymsLegGrp.clone( out.secLstUpdRelSymsLegGrp[count] );
			count++;
		}
		if (spreadOrBenchmarkCurveData.hasGroup())
			out.spreadOrBenchmarkCurveData = spreadOrBenchmarkCurveData.clone( out.spreadOrBenchmarkCurveData);
		count = 0;
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) {
			if (!fixUndInstrmtGrp.hasGroup()) continue;
			out.undInstrmtGrp[count] = fixUndInstrmtGrp.clone( out.undInstrmtGrp[count] );
			count++;
		}
		count = 0;
		for (FixStipulations fixStipulations : stipulations) {
			if (!fixStipulations.hasGroup()) continue;
			out.stipulations[count] = fixStipulations.clone( out.stipulations[count] );
			count++;
		}
		if (securityTradingRules.hasGroup())
			out.securityTradingRules = securityTradingRules.clone( out.securityTradingRules);
		count = 0;
		for (FixStrikeRules fixStrikeRules : strikeRules) {
			if (!fixStrikeRules.hasGroup()) continue;
			out.strikeRules[count] = fixStrikeRules.clone( out.strikeRules[count] );
			count++;
		}
		if (yieldData.hasGroup())
			out.yieldData = yieldData.clone( out.yieldData);
		return out;
	}

}
