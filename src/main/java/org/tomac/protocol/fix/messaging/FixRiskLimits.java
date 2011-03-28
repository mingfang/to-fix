package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixRiskLimits extends FixGroup {
	private short hasRiskLimitType;
	long riskLimitType = 0;		
	private short hasRiskLimitAmount;
	long riskLimitAmount = 0;		
	private short hasRiskLimitCurrency;
	byte[] riskLimitCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasRiskLimitPlatform;
	byte[] riskLimitPlatform = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		FixRiskInstrumentScope[] riskInstrumentScope;
		FixRiskWarningLevels[] riskWarningLevels;
	
	public FixRiskLimits() {
		super(FixTags.RISKLIMITTYPE_INT);

		
		hasRiskLimitType = FixUtils.TAG_HAS_NO_VALUE;		
		hasRiskLimitAmount = FixUtils.TAG_HAS_NO_VALUE;		
		hasRiskLimitCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		riskLimitCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasRiskLimitPlatform = FixUtils.TAG_HAS_NO_VALUE;		
		riskLimitPlatform = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		riskInstrumentScope = new FixRiskInstrumentScope[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) riskInstrumentScope[i] = new FixRiskInstrumentScope();
		riskWarningLevels = new FixRiskWarningLevels[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) riskWarningLevels[i] = new FixRiskWarningLevels();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasRiskLimitType()) return true;
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
            	case FixTags.RISKLIMITTYPE_INT:		
            		hasRiskLimitType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RISKLIMITAMOUNT_INT:		
            		hasRiskLimitAmount = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RISKLIMITCURRENCY_INT:		
            		hasRiskLimitCurrency = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RISKLIMITPLATFORM_INT:		
            		hasRiskLimitPlatform = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NORISKINSTRUMENTS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !riskInstrumentScope[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = riskInstrumentScope[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NORISKWARNINGLEVELS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !riskWarningLevels[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = riskWarningLevels[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else { return tag; }
            }

            tag = FixMessage.getTag(buf, err);
            if (err.hasError()) return tag; // what to do now? 
        }		
        return tag;
    }		
	@Override
	public void clear() {
		// just set the length to header + trailer but still we set it...
		hasRiskLimitType = FixUtils.TAG_HAS_NO_VALUE;
		hasRiskLimitAmount = FixUtils.TAG_HAS_NO_VALUE;
		hasRiskLimitCurrency = FixUtils.TAG_HAS_NO_VALUE;
		hasRiskLimitPlatform = FixUtils.TAG_HAS_NO_VALUE;
		for (FixRiskInstrumentScope fixRiskInstrumentScope : riskInstrumentScope) fixRiskInstrumentScope.clear();
		for (FixRiskWarningLevels fixRiskWarningLevels : riskWarningLevels) fixRiskWarningLevels.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasRiskLimitType()) {		
			out.put(FixTags.RISKLIMITTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)riskLimitType);
		
			out.put(FixUtils.SOH);

            }

		if (hasRiskLimitAmount()) {		
			out.put(FixTags.RISKLIMITAMOUNT);

			out.put((byte) '=');

			FixUtils.put(out, (long)riskLimitAmount);
		
			out.put(FixUtils.SOH);

            }

		if (hasRiskLimitCurrency()) {		
			out.put(FixTags.RISKLIMITCURRENCY);

			out.put((byte) '=');

			FixUtils.put(out,riskLimitCurrency); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRiskLimitPlatform()) {		
			out.put(FixTags.RISKLIMITPLATFORM);

			out.put((byte) '=');

			FixUtils.put(out,riskLimitPlatform); 		
		
			out.put(FixUtils.SOH);

            }

		for (FixRiskInstrumentScope fixRiskInstrumentScope : riskInstrumentScope) fixRiskInstrumentScope.encode(out);
		for (FixRiskWarningLevels fixRiskWarningLevels : riskWarningLevels) fixRiskWarningLevels.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasRiskLimitType()) {		
			FixUtils.put(out, (long)riskLimitType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRiskLimitAmount()) {		
			FixUtils.put(out, (long)riskLimitAmount);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRiskLimitCurrency()) {		
			FixUtils.put(out,riskLimitCurrency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRiskLimitPlatform()) {		
			FixUtils.put(out,riskLimitPlatform); 		
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixRiskInstrumentScope fixRiskInstrumentScope : riskInstrumentScope) fixRiskInstrumentScope.printBuffer(out);
		for (FixRiskWarningLevels fixRiskWarningLevels : riskWarningLevels) fixRiskWarningLevels.printBuffer(out);
	}

	public long getRiskLimitType() { 		
		if ( hasRiskLimitType()) {		
			if (hasRiskLimitType == FixUtils.TAG_HAS_VALUE) {		
				return riskLimitType; 		
			} else {		
		
				buf.position(hasRiskLimitType);		
		
			riskLimitType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRiskLimitType);		
					return 0;		
				}		
			}		
			hasRiskLimitType = FixUtils.TAG_HAS_VALUE;		
			return riskLimitType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRiskLimitType() { return hasRiskLimitType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRiskLimitType(long src) {		
		riskLimitType = src;
		hasRiskLimitType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRiskLimitType(byte[] src) {		
		if (src == null ) return;
		if (hasRiskLimitType()) riskLimitType = FixUtils.TAG_HAS_NO_VALUE;		
		riskLimitType = FixUtils.longValueOf(src, 0, src.length);
		hasRiskLimitType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRiskLimitType(String str) {		
		if (str == null ) return;
		if (hasRiskLimitType()) riskLimitType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		riskLimitType = FixUtils.longValueOf(src, 0, src.length);
		hasRiskLimitType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getRiskLimitAmount() { 		
		if ( hasRiskLimitAmount()) {		
			if (hasRiskLimitAmount == FixUtils.TAG_HAS_VALUE) {		
				return riskLimitAmount; 		
			} else {		
		
				buf.position(hasRiskLimitAmount);		
		
			riskLimitAmount = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRiskLimitAmount);		
					return 0;		
				}		
			}		
			hasRiskLimitAmount = FixUtils.TAG_HAS_VALUE;		
			return riskLimitAmount;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRiskLimitAmount() { return hasRiskLimitAmount != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRiskLimitAmount(long src) {		
		riskLimitAmount = src;
		hasRiskLimitAmount = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRiskLimitAmount(byte[] src) {		
		if (src == null ) return;
		if (hasRiskLimitAmount()) riskLimitAmount = FixUtils.TAG_HAS_NO_VALUE;		
		riskLimitAmount = FixUtils.longValueOf(src, 0, src.length);
		hasRiskLimitAmount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRiskLimitAmount(String str) {		
		if (str == null ) return;
		if (hasRiskLimitAmount()) riskLimitAmount = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		riskLimitAmount = FixUtils.longValueOf(src, 0, src.length);
		hasRiskLimitAmount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRiskLimitCurrency() { 		
		if ( hasRiskLimitCurrency()) {		
			if (hasRiskLimitCurrency == FixUtils.TAG_HAS_VALUE) {		
				return riskLimitCurrency; 		
			} else {		
		
				buf.position(hasRiskLimitCurrency);		
		
			FixMessage.getTagStringValue(buf, riskLimitCurrency, 0, riskLimitCurrency.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRiskLimitCurrency);		
					return null;		
				}		
			}		
			hasRiskLimitCurrency = FixUtils.TAG_HAS_VALUE;		
			return riskLimitCurrency;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRiskLimitCurrency() { return hasRiskLimitCurrency != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRiskLimitCurrency(byte[] src) {		
		if (src == null ) return;
		if (hasRiskLimitCurrency()) FixUtils.fillSpace(riskLimitCurrency);		
		FixUtils.copy(riskLimitCurrency, src); 		
		hasRiskLimitCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRiskLimitCurrency(String str) {		
		if (str == null ) return;
		if (hasRiskLimitCurrency()) FixUtils.fillSpace(riskLimitCurrency);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(riskLimitCurrency, src); 		
		hasRiskLimitCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRiskLimitPlatform() { 		
		if ( hasRiskLimitPlatform()) {		
			if (hasRiskLimitPlatform == FixUtils.TAG_HAS_VALUE) {		
				return riskLimitPlatform; 		
			} else {		
		
				buf.position(hasRiskLimitPlatform);		
		
			FixMessage.getTagStringValue(buf, riskLimitPlatform, 0, riskLimitPlatform.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRiskLimitPlatform);		
					return null;		
				}		
			}		
			hasRiskLimitPlatform = FixUtils.TAG_HAS_VALUE;		
			return riskLimitPlatform;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRiskLimitPlatform() { return hasRiskLimitPlatform != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRiskLimitPlatform(byte[] src) {		
		if (src == null ) return;
		if (hasRiskLimitPlatform()) FixUtils.fillSpace(riskLimitPlatform);		
		FixUtils.copy(riskLimitPlatform, src); 		
		hasRiskLimitPlatform = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRiskLimitPlatform(String str) {		
		if (str == null ) return;
		if (hasRiskLimitPlatform()) FixUtils.fillSpace(riskLimitPlatform);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(riskLimitPlatform, src); 		
		hasRiskLimitPlatform = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasRiskLimitType()) s += "RiskLimitType(1530)= " + getRiskLimitType() + "\n" ; 
		if (hasRiskLimitAmount()) s += "RiskLimitAmount(1531)= " + getRiskLimitAmount() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasRiskLimitCurrency()) s += "RiskLimitCurrency(1532)= " + new String( FixUtils.trim(getRiskLimitCurrency()) ) + "\n" ; 
		if (hasRiskLimitPlatform()) s += "RiskLimitPlatform(1533)= " + new String( FixUtils.trim(getRiskLimitPlatform()) ) + "\n" ; 

		for (FixRiskInstrumentScope fixRiskInstrumentScope : riskInstrumentScope) fixRiskInstrumentScope.toString();
		for (FixRiskWarningLevels fixRiskWarningLevels : riskWarningLevels) fixRiskWarningLevels.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixRiskLimits)) return false;

		FixRiskLimits msg = (FixRiskLimits) o;

		for (FixRiskInstrumentScope fixRiskInstrumentScope : riskInstrumentScope)
			if (!fixRiskInstrumentScope.equals(msg.riskInstrumentScope)) return false;
		for (FixRiskWarningLevels fixRiskWarningLevels : riskWarningLevels)
			if (!fixRiskWarningLevels.equals(msg.riskWarningLevels)) return false;
		if ((hasRiskLimitType() && !msg.hasRiskLimitType()) || (!hasRiskLimitType() && msg.hasRiskLimitType())) return false;
		if (!(!hasRiskLimitType() && !msg.hasRiskLimitType()) && !(getRiskLimitType()==msg.getRiskLimitType())) return false;
		if ((hasRiskLimitAmount() && !msg.hasRiskLimitAmount()) || (!hasRiskLimitAmount() && msg.hasRiskLimitAmount())) return false;
		if (!(!hasRiskLimitAmount() && !msg.hasRiskLimitAmount()) && !(getRiskLimitAmount()==msg.getRiskLimitAmount())) return false;
		if ((hasRiskLimitCurrency() && !msg.hasRiskLimitCurrency()) || (!hasRiskLimitCurrency() && msg.hasRiskLimitCurrency())) return false;
		if (!(!hasRiskLimitCurrency() && !msg.hasRiskLimitCurrency()) && !FixUtils.equals(getRiskLimitCurrency(), msg.getRiskLimitCurrency())) return false;
		if ((hasRiskLimitPlatform() && !msg.hasRiskLimitPlatform()) || (!hasRiskLimitPlatform() && msg.hasRiskLimitPlatform())) return false;
		if (!(!hasRiskLimitPlatform() && !msg.hasRiskLimitPlatform()) && !FixUtils.equals(getRiskLimitPlatform(), msg.getRiskLimitPlatform())) return false;
		return true;
	}
	public FixRiskLimits clone ( FixRiskLimits out ) {
		if ( hasRiskLimitType())
			out.setRiskLimitType(getRiskLimitType());
		if ( hasRiskLimitAmount())
			out.setRiskLimitAmount(getRiskLimitAmount());
		if ( hasRiskLimitCurrency())
			out.setRiskLimitCurrency(getRiskLimitCurrency());
		if ( hasRiskLimitPlatform())
			out.setRiskLimitPlatform(getRiskLimitPlatform());
		int count = 0;
		count = 0;
		for (FixRiskInstrumentScope fixRiskInstrumentScope : riskInstrumentScope) {
			if (!fixRiskInstrumentScope.hasGroup()) continue;
			out.riskInstrumentScope[count] = fixRiskInstrumentScope.clone( out.riskInstrumentScope[count] );
			count++;
		}
		count = 0;
		for (FixRiskWarningLevels fixRiskWarningLevels : riskWarningLevels) {
			if (!fixRiskWarningLevels.hasGroup()) continue;
			out.riskWarningLevels[count] = fixRiskWarningLevels.clone( out.riskWarningLevels[count] );
			count++;
		}
		return out;
	}

}
