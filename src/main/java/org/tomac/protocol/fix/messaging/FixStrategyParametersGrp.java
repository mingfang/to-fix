package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixStrategyParametersGrp extends FixGroup {
	private short hasStrategyParameterName;
	byte[] strategyParameterName = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasStrategyParameterType;
	long strategyParameterType = 0;		
	private short hasStrategyParameterValue;
	byte[] strategyParameterValue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	
	public FixStrategyParametersGrp() {
		this(false);
	}

	public FixStrategyParametersGrp(boolean isRequired) {
		super(FixTags.STRATEGYPARAMETERNAME_INT);

		this.isRequired = isRequired;
		
		hasStrategyParameterName = FixUtils.TAG_HAS_NO_VALUE;		
		strategyParameterName = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasStrategyParameterType = FixUtils.TAG_HAS_NO_VALUE;		
		hasStrategyParameterValue = FixUtils.TAG_HAS_NO_VALUE;		
		strategyParameterValue = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasStrategyParameterName()) return true;
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
            	case FixTags.STRATEGYPARAMETERNAME_INT:		
            		hasStrategyParameterName = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.STRATEGYPARAMETERTYPE_INT:		
            		hasStrategyParameterType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.STRATEGYPARAMETERVALUE_INT:		
            		hasStrategyParameterValue = (short) buf.position();		
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
		hasStrategyParameterName = FixUtils.TAG_HAS_NO_VALUE;
		hasStrategyParameterType = FixUtils.TAG_HAS_NO_VALUE;
		hasStrategyParameterValue = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasStrategyParameterName()) {		
			out.put(FixTags.STRATEGYPARAMETERNAME);

			out.put((byte) '=');

			FixUtils.put(out,strategyParameterName); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasStrategyParameterType()) {		
			out.put(FixTags.STRATEGYPARAMETERTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)strategyParameterType);
		
			out.put(FixUtils.SOH);

            }

		if (hasStrategyParameterValue()) {		
			out.put(FixTags.STRATEGYPARAMETERVALUE);

			out.put((byte) '=');

			FixUtils.put(out,strategyParameterValue); 		
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasStrategyParameterName()) {		
			FixUtils.put(out,strategyParameterName); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasStrategyParameterType()) {		
			FixUtils.put(out, (long)strategyParameterType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasStrategyParameterValue()) {		
			FixUtils.put(out,strategyParameterValue); 		
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getStrategyParameterName() { 		
		if ( hasStrategyParameterName()) {		
			if (hasStrategyParameterName == FixUtils.TAG_HAS_VALUE) {		
				return strategyParameterName; 		
			} else {		
		
				buf.position(hasStrategyParameterName);		
		
			FixMessage.getTagStringValue(buf, strategyParameterName, 0, strategyParameterName.length, err);
		
				if (err.hasError()) {		
					buf.position(hasStrategyParameterName);		
					return null;		
				}		
			}		
			hasStrategyParameterName = FixUtils.TAG_HAS_VALUE;		
			return strategyParameterName;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasStrategyParameterName() { return hasStrategyParameterName != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setStrategyParameterName(byte[] src) {		
		if (src == null ) return;
		if (hasStrategyParameterName()) FixUtils.fillSpace(strategyParameterName);		
		FixUtils.copy(strategyParameterName, src); 		
		hasStrategyParameterName = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setStrategyParameterName(String str) {		
		if (str == null ) return;
		if (hasStrategyParameterName()) FixUtils.fillSpace(strategyParameterName);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(strategyParameterName, src); 		
		hasStrategyParameterName = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getStrategyParameterType() { 		
		if ( hasStrategyParameterType()) {		
			if (hasStrategyParameterType == FixUtils.TAG_HAS_VALUE) {		
				return strategyParameterType; 		
			} else {		
		
				buf.position(hasStrategyParameterType);		
		
			strategyParameterType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasStrategyParameterType);		
					return 0;		
				}		
			}		
			hasStrategyParameterType = FixUtils.TAG_HAS_VALUE;		
			return strategyParameterType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasStrategyParameterType() { return hasStrategyParameterType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setStrategyParameterType(long src) {		
		strategyParameterType = src;
		hasStrategyParameterType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStrategyParameterType(byte[] src) {		
		if (src == null ) return;
		if (hasStrategyParameterType()) strategyParameterType = FixUtils.TAG_HAS_NO_VALUE;		
		strategyParameterType = FixUtils.longValueOf(src, 0, src.length);
		hasStrategyParameterType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setStrategyParameterType(String str) {		
		if (str == null ) return;
		if (hasStrategyParameterType()) strategyParameterType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		strategyParameterType = FixUtils.longValueOf(src, 0, src.length);
		hasStrategyParameterType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getStrategyParameterValue() { 		
		if ( hasStrategyParameterValue()) {		
			if (hasStrategyParameterValue == FixUtils.TAG_HAS_VALUE) {		
				return strategyParameterValue; 		
			} else {		
		
				buf.position(hasStrategyParameterValue);		
		
			FixMessage.getTagStringValue(buf, strategyParameterValue, 0, strategyParameterValue.length, err);
		
				if (err.hasError()) {		
					buf.position(hasStrategyParameterValue);		
					return null;		
				}		
			}		
			hasStrategyParameterValue = FixUtils.TAG_HAS_VALUE;		
			return strategyParameterValue;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasStrategyParameterValue() { return hasStrategyParameterValue != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setStrategyParameterValue(byte[] src) {		
		if (src == null ) return;
		if (hasStrategyParameterValue()) FixUtils.fillSpace(strategyParameterValue);		
		FixUtils.copy(strategyParameterValue, src); 		
		hasStrategyParameterValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setStrategyParameterValue(String str) {		
		if (str == null ) return;
		if (hasStrategyParameterValue()) FixUtils.fillSpace(strategyParameterValue);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(strategyParameterValue, src); 		
		hasStrategyParameterValue = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasStrategyParameterName()) s += "StrategyParameterName(958)= " + new String( FixUtils.trim(getStrategyParameterName()) ) + "\n" ; 
		if (hasStrategyParameterType()) s += "StrategyParameterType(959)= " + getStrategyParameterType() + "\n" ; 
		if (hasStrategyParameterValue()) s += "StrategyParameterValue(960)= " + new String( FixUtils.trim(getStrategyParameterValue()) ) + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixStrategyParametersGrp)) return false;

		FixStrategyParametersGrp msg = (FixStrategyParametersGrp) o;

		if ((hasStrategyParameterName() && !msg.hasStrategyParameterName()) || (!hasStrategyParameterName() && msg.hasStrategyParameterName())) return false;
		if (!(!hasStrategyParameterName() && !msg.hasStrategyParameterName()) && !FixUtils.equals(getStrategyParameterName(), msg.getStrategyParameterName())) return false;
		if ((hasStrategyParameterType() && !msg.hasStrategyParameterType()) || (!hasStrategyParameterType() && msg.hasStrategyParameterType())) return false;
		if (!(!hasStrategyParameterType() && !msg.hasStrategyParameterType()) && !(getStrategyParameterType()==msg.getStrategyParameterType())) return false;
		if ((hasStrategyParameterValue() && !msg.hasStrategyParameterValue()) || (!hasStrategyParameterValue() && msg.hasStrategyParameterValue())) return false;
		if (!(!hasStrategyParameterValue() && !msg.hasStrategyParameterValue()) && !FixUtils.equals(getStrategyParameterValue(), msg.getStrategyParameterValue())) return false;
		return true;
	}
	public FixStrategyParametersGrp clone ( FixStrategyParametersGrp out ) {
		if ( hasStrategyParameterName())
			out.setStrategyParameterName(getStrategyParameterName());
		if ( hasStrategyParameterType())
			out.setStrategyParameterType(getStrategyParameterType());
		if ( hasStrategyParameterValue())
			out.setStrategyParameterValue(getStrategyParameterValue());
		return out;
	}

}
