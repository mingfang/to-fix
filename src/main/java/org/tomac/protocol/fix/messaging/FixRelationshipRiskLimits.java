package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixRelationshipRiskLimits extends FixGroup {
	private short hasRelationshipRiskLimitType;
	long relationshipRiskLimitType = 0;		
	private short hasRelationshipRiskLimitAmount;
	long relationshipRiskLimitAmount = 0;		
	private short hasRelationshipRiskLimitCurrency;
	byte[] relationshipRiskLimitCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasRelationshipRiskLimitPlatform;
	byte[] relationshipRiskLimitPlatform = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		public FixRelationshipRiskInstrumentScope[] relationshipRiskInstrumentScope;
		public FixRelationshipRiskWarningLevels[] relationshipRiskWarningLevels;
	
	public FixRelationshipRiskLimits() {
		this(false);
	}

	public FixRelationshipRiskLimits(boolean isRequired) {
		super(FixTags.RELATIONSHIPRISKLIMITTYPE_INT);

		this.isRequired = isRequired;
		
		hasRelationshipRiskLimitType = FixUtils.TAG_HAS_NO_VALUE;		
		hasRelationshipRiskLimitAmount = FixUtils.TAG_HAS_NO_VALUE;		
		hasRelationshipRiskLimitCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		relationshipRiskLimitCurrency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasRelationshipRiskLimitPlatform = FixUtils.TAG_HAS_NO_VALUE;		
		relationshipRiskLimitPlatform = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		relationshipRiskInstrumentScope = new FixRelationshipRiskInstrumentScope[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) relationshipRiskInstrumentScope[i] = new FixRelationshipRiskInstrumentScope();
		relationshipRiskWarningLevels = new FixRelationshipRiskWarningLevels[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) relationshipRiskWarningLevels[i] = new FixRelationshipRiskWarningLevels();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasRelationshipRiskLimitType()) return true;
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
            	case FixTags.RELATIONSHIPRISKLIMITTYPE_INT:		
            		hasRelationshipRiskLimitType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATIONSHIPRISKLIMITAMOUNT_INT:		
            		hasRelationshipRiskLimitAmount = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATIONSHIPRISKLIMITCURRENCY_INT:		
            		hasRelationshipRiskLimitCurrency = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATIONSHIPRISKLIMITPLATFORM_INT:		
            		hasRelationshipRiskLimitPlatform = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NORELATIONSHIPRISKINSTRUMENTS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !relationshipRiskInstrumentScope[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = relationshipRiskInstrumentScope[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NORELATIONSHIPRISKWARNINGLEVELS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !relationshipRiskWarningLevels[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = relationshipRiskWarningLevels[count].setBuffer( repeatingGroupTag, buf, err);	
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
		hasRelationshipRiskLimitType = FixUtils.TAG_HAS_NO_VALUE;
		hasRelationshipRiskLimitAmount = FixUtils.TAG_HAS_NO_VALUE;
		hasRelationshipRiskLimitCurrency = FixUtils.TAG_HAS_NO_VALUE;
		hasRelationshipRiskLimitPlatform = FixUtils.TAG_HAS_NO_VALUE;
		for (FixRelationshipRiskInstrumentScope fixRelationshipRiskInstrumentScope : relationshipRiskInstrumentScope) fixRelationshipRiskInstrumentScope.clear();
		for (FixRelationshipRiskWarningLevels fixRelationshipRiskWarningLevels : relationshipRiskWarningLevels) fixRelationshipRiskWarningLevels.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasRelationshipRiskLimitType()) {		
			out.put(FixTags.RELATIONSHIPRISKLIMITTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)relationshipRiskLimitType);
		
			out.put(FixUtils.SOH);

            }

		if (hasRelationshipRiskLimitAmount()) {		
			out.put(FixTags.RELATIONSHIPRISKLIMITAMOUNT);

			out.put((byte) '=');

			FixUtils.put(out, (long)relationshipRiskLimitAmount);
		
			out.put(FixUtils.SOH);

            }

		if (hasRelationshipRiskLimitCurrency()) {		
			out.put(FixTags.RELATIONSHIPRISKLIMITCURRENCY);

			out.put((byte) '=');

			FixUtils.put(out,relationshipRiskLimitCurrency); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRelationshipRiskLimitPlatform()) {		
			out.put(FixTags.RELATIONSHIPRISKLIMITPLATFORM);

			out.put((byte) '=');

			FixUtils.put(out,relationshipRiskLimitPlatform); 		
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(relationshipRiskInstrumentScope)>0) {
			out.put(FixTags.NORELATIONSHIPRISKINSTRUMENTS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(relationshipRiskInstrumentScope));

			out.put(FixUtils.SOH);

		}
		for (FixRelationshipRiskInstrumentScope fixRelationshipRiskInstrumentScope : relationshipRiskInstrumentScope) if (fixRelationshipRiskInstrumentScope.hasGroup()) fixRelationshipRiskInstrumentScope.encode(out);
		if (FixUtils.getNoInGroup(relationshipRiskWarningLevels)>0) {
			out.put(FixTags.NORELATIONSHIPRISKWARNINGLEVELS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(relationshipRiskWarningLevels));

			out.put(FixUtils.SOH);

		}
		for (FixRelationshipRiskWarningLevels fixRelationshipRiskWarningLevels : relationshipRiskWarningLevels) if (fixRelationshipRiskWarningLevels.hasGroup()) fixRelationshipRiskWarningLevels.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasRelationshipRiskLimitType()) {		
			FixUtils.put(out, (long)relationshipRiskLimitType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelationshipRiskLimitAmount()) {		
			FixUtils.put(out, (long)relationshipRiskLimitAmount);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelationshipRiskLimitCurrency()) {		
			FixUtils.put(out,relationshipRiskLimitCurrency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelationshipRiskLimitPlatform()) {		
			FixUtils.put(out,relationshipRiskLimitPlatform); 		
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixRelationshipRiskInstrumentScope fixRelationshipRiskInstrumentScope : relationshipRiskInstrumentScope) fixRelationshipRiskInstrumentScope.printBuffer(out);
		for (FixRelationshipRiskWarningLevels fixRelationshipRiskWarningLevels : relationshipRiskWarningLevels) fixRelationshipRiskWarningLevels.printBuffer(out);
	}

	public long getRelationshipRiskLimitType() { 		
		if ( hasRelationshipRiskLimitType()) {		
			if (hasRelationshipRiskLimitType == FixUtils.TAG_HAS_VALUE) {		
				return relationshipRiskLimitType; 		
			} else {		
		
				buf.position(hasRelationshipRiskLimitType);		
		
			relationshipRiskLimitType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRelationshipRiskLimitType);		
					return 0;		
				}		
			}		
			hasRelationshipRiskLimitType = FixUtils.TAG_HAS_VALUE;		
			return relationshipRiskLimitType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRelationshipRiskLimitType() { return hasRelationshipRiskLimitType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelationshipRiskLimitType(long src) {		
		relationshipRiskLimitType = src;
		hasRelationshipRiskLimitType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRelationshipRiskLimitType(byte[] src) {		
		if (src == null ) return;
		if (hasRelationshipRiskLimitType()) relationshipRiskLimitType = FixUtils.TAG_HAS_NO_VALUE;		
		relationshipRiskLimitType = FixUtils.longValueOf(src, 0, src.length);
		hasRelationshipRiskLimitType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelationshipRiskLimitType(String str) {		
		if (str == null ) return;
		if (hasRelationshipRiskLimitType()) relationshipRiskLimitType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		relationshipRiskLimitType = FixUtils.longValueOf(src, 0, src.length);
		hasRelationshipRiskLimitType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getRelationshipRiskLimitAmount() { 		
		if ( hasRelationshipRiskLimitAmount()) {		
			if (hasRelationshipRiskLimitAmount == FixUtils.TAG_HAS_VALUE) {		
				return relationshipRiskLimitAmount; 		
			} else {		
		
				buf.position(hasRelationshipRiskLimitAmount);		
		
			relationshipRiskLimitAmount = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRelationshipRiskLimitAmount);		
					return 0;		
				}		
			}		
			hasRelationshipRiskLimitAmount = FixUtils.TAG_HAS_VALUE;		
			return relationshipRiskLimitAmount;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRelationshipRiskLimitAmount() { return hasRelationshipRiskLimitAmount != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelationshipRiskLimitAmount(long src) {		
		relationshipRiskLimitAmount = src;
		hasRelationshipRiskLimitAmount = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRelationshipRiskLimitAmount(byte[] src) {		
		if (src == null ) return;
		if (hasRelationshipRiskLimitAmount()) relationshipRiskLimitAmount = FixUtils.TAG_HAS_NO_VALUE;		
		relationshipRiskLimitAmount = FixUtils.longValueOf(src, 0, src.length);
		hasRelationshipRiskLimitAmount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelationshipRiskLimitAmount(String str) {		
		if (str == null ) return;
		if (hasRelationshipRiskLimitAmount()) relationshipRiskLimitAmount = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		relationshipRiskLimitAmount = FixUtils.longValueOf(src, 0, src.length);
		hasRelationshipRiskLimitAmount = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRelationshipRiskLimitCurrency() { 		
		if ( hasRelationshipRiskLimitCurrency()) {		
			if (hasRelationshipRiskLimitCurrency == FixUtils.TAG_HAS_VALUE) {		
				return relationshipRiskLimitCurrency; 		
			} else {		
		
				buf.position(hasRelationshipRiskLimitCurrency);		
		
			FixMessage.getTagStringValue(buf, relationshipRiskLimitCurrency, 0, relationshipRiskLimitCurrency.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRelationshipRiskLimitCurrency);		
					return null;		
				}		
			}		
			hasRelationshipRiskLimitCurrency = FixUtils.TAG_HAS_VALUE;		
			return relationshipRiskLimitCurrency;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRelationshipRiskLimitCurrency() { return hasRelationshipRiskLimitCurrency != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelationshipRiskLimitCurrency(byte[] src) {		
		if (src == null ) return;
		if (hasRelationshipRiskLimitCurrency()) FixUtils.fillSpace(relationshipRiskLimitCurrency);		
		FixUtils.copy(relationshipRiskLimitCurrency, src); 		
		hasRelationshipRiskLimitCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelationshipRiskLimitCurrency(String str) {		
		if (str == null ) return;
		if (hasRelationshipRiskLimitCurrency()) FixUtils.fillSpace(relationshipRiskLimitCurrency);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(relationshipRiskLimitCurrency, src); 		
		hasRelationshipRiskLimitCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRelationshipRiskLimitPlatform() { 		
		if ( hasRelationshipRiskLimitPlatform()) {		
			if (hasRelationshipRiskLimitPlatform == FixUtils.TAG_HAS_VALUE) {		
				return relationshipRiskLimitPlatform; 		
			} else {		
		
				buf.position(hasRelationshipRiskLimitPlatform);		
		
			FixMessage.getTagStringValue(buf, relationshipRiskLimitPlatform, 0, relationshipRiskLimitPlatform.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRelationshipRiskLimitPlatform);		
					return null;		
				}		
			}		
			hasRelationshipRiskLimitPlatform = FixUtils.TAG_HAS_VALUE;		
			return relationshipRiskLimitPlatform;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRelationshipRiskLimitPlatform() { return hasRelationshipRiskLimitPlatform != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelationshipRiskLimitPlatform(byte[] src) {		
		if (src == null ) return;
		if (hasRelationshipRiskLimitPlatform()) FixUtils.fillSpace(relationshipRiskLimitPlatform);		
		FixUtils.copy(relationshipRiskLimitPlatform, src); 		
		hasRelationshipRiskLimitPlatform = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelationshipRiskLimitPlatform(String str) {		
		if (str == null ) return;
		if (hasRelationshipRiskLimitPlatform()) FixUtils.fillSpace(relationshipRiskLimitPlatform);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(relationshipRiskLimitPlatform, src); 		
		hasRelationshipRiskLimitPlatform = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasRelationshipRiskLimitType()) s += "RelationshipRiskLimitType(1583)= " + getRelationshipRiskLimitType() + "\n" ; 
		if (hasRelationshipRiskLimitAmount()) s += "RelationshipRiskLimitAmount(1584)= " + getRelationshipRiskLimitAmount() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasRelationshipRiskLimitCurrency()) s += "RelationshipRiskLimitCurrency(1585)= " + new String( FixUtils.trim(getRelationshipRiskLimitCurrency()) ) + "\n" ; 
		if (hasRelationshipRiskLimitPlatform()) s += "RelationshipRiskLimitPlatform(1586)= " + new String( FixUtils.trim(getRelationshipRiskLimitPlatform()) ) + "\n" ; 

		for (FixRelationshipRiskInstrumentScope fixRelationshipRiskInstrumentScope : relationshipRiskInstrumentScope) fixRelationshipRiskInstrumentScope.toString();
		for (FixRelationshipRiskWarningLevels fixRelationshipRiskWarningLevels : relationshipRiskWarningLevels) fixRelationshipRiskWarningLevels.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixRelationshipRiskLimits)) return false;

		FixRelationshipRiskLimits msg = (FixRelationshipRiskLimits) o;

		for (FixRelationshipRiskInstrumentScope fixRelationshipRiskInstrumentScope : relationshipRiskInstrumentScope)
			if (!fixRelationshipRiskInstrumentScope.equals(msg.relationshipRiskInstrumentScope)) return false;
		for (FixRelationshipRiskWarningLevels fixRelationshipRiskWarningLevels : relationshipRiskWarningLevels)
			if (!fixRelationshipRiskWarningLevels.equals(msg.relationshipRiskWarningLevels)) return false;
		if ((hasRelationshipRiskLimitType() && !msg.hasRelationshipRiskLimitType()) || (!hasRelationshipRiskLimitType() && msg.hasRelationshipRiskLimitType())) return false;
		if (!(!hasRelationshipRiskLimitType() && !msg.hasRelationshipRiskLimitType()) && !(getRelationshipRiskLimitType()==msg.getRelationshipRiskLimitType())) return false;
		if ((hasRelationshipRiskLimitAmount() && !msg.hasRelationshipRiskLimitAmount()) || (!hasRelationshipRiskLimitAmount() && msg.hasRelationshipRiskLimitAmount())) return false;
		if (!(!hasRelationshipRiskLimitAmount() && !msg.hasRelationshipRiskLimitAmount()) && !(getRelationshipRiskLimitAmount()==msg.getRelationshipRiskLimitAmount())) return false;
		if ((hasRelationshipRiskLimitCurrency() && !msg.hasRelationshipRiskLimitCurrency()) || (!hasRelationshipRiskLimitCurrency() && msg.hasRelationshipRiskLimitCurrency())) return false;
		if (!(!hasRelationshipRiskLimitCurrency() && !msg.hasRelationshipRiskLimitCurrency()) && !FixUtils.equals(getRelationshipRiskLimitCurrency(), msg.getRelationshipRiskLimitCurrency())) return false;
		if ((hasRelationshipRiskLimitPlatform() && !msg.hasRelationshipRiskLimitPlatform()) || (!hasRelationshipRiskLimitPlatform() && msg.hasRelationshipRiskLimitPlatform())) return false;
		if (!(!hasRelationshipRiskLimitPlatform() && !msg.hasRelationshipRiskLimitPlatform()) && !FixUtils.equals(getRelationshipRiskLimitPlatform(), msg.getRelationshipRiskLimitPlatform())) return false;
		return true;
	}
	public FixRelationshipRiskLimits clone ( FixRelationshipRiskLimits out ) {
		if ( hasRelationshipRiskLimitType())
			out.setRelationshipRiskLimitType(getRelationshipRiskLimitType());
		if ( hasRelationshipRiskLimitAmount())
			out.setRelationshipRiskLimitAmount(getRelationshipRiskLimitAmount());
		if ( hasRelationshipRiskLimitCurrency())
			out.setRelationshipRiskLimitCurrency(getRelationshipRiskLimitCurrency());
		if ( hasRelationshipRiskLimitPlatform())
			out.setRelationshipRiskLimitPlatform(getRelationshipRiskLimitPlatform());
		int count = 0;
		count = 0;
		for (FixRelationshipRiskInstrumentScope fixRelationshipRiskInstrumentScope : relationshipRiskInstrumentScope) {
			if (!fixRelationshipRiskInstrumentScope.hasGroup()) continue;
			out.relationshipRiskInstrumentScope[count] = fixRelationshipRiskInstrumentScope.clone( out.relationshipRiskInstrumentScope[count] );
			count++;
		}
		count = 0;
		for (FixRelationshipRiskWarningLevels fixRelationshipRiskWarningLevels : relationshipRiskWarningLevels) {
			if (!fixRelationshipRiskWarningLevels.hasGroup()) continue;
			out.relationshipRiskWarningLevels[count] = fixRelationshipRiskWarningLevels.clone( out.relationshipRiskWarningLevels[count] );
			count++;
		}
		return out;
	}

}
