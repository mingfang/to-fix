package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixTickRules extends FixGroup {
	private short hasStartTickPriceRange;
	long startTickPriceRange = 0;		
	private short hasEndTickPriceRange;
	long endTickPriceRange = 0;		
	private short hasTickIncrement;
	long tickIncrement = 0;		
	private short hasTickRuleType;
	long tickRuleType = 0;		
	
	public FixTickRules() {
		this(false);
	}

	public FixTickRules(boolean isRequired) {
		super(FixTags.STARTTICKPRICERANGE_INT);

		this.isRequired = isRequired;
		
		hasStartTickPriceRange = FixUtils.TAG_HAS_NO_VALUE;		
		hasEndTickPriceRange = FixUtils.TAG_HAS_NO_VALUE;		
		hasTickIncrement = FixUtils.TAG_HAS_NO_VALUE;		
		hasTickRuleType = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasStartTickPriceRange()) return true;
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
            	case FixTags.STARTTICKPRICERANGE_INT:		
            		hasStartTickPriceRange = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ENDTICKPRICERANGE_INT:		
            		hasEndTickPriceRange = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TICKINCREMENT_INT:		
            		hasTickIncrement = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.TICKRULETYPE_INT:		
            		hasTickRuleType = (short) buf.position();		
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
		hasStartTickPriceRange = FixUtils.TAG_HAS_NO_VALUE;
		hasEndTickPriceRange = FixUtils.TAG_HAS_NO_VALUE;
		hasTickIncrement = FixUtils.TAG_HAS_NO_VALUE;
		hasTickRuleType = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasStartTickPriceRange()) {		
			out.put(FixTags.STARTTICKPRICERANGE);

			out.put((byte) '=');

			FixUtils.put(out, (long)startTickPriceRange);
		
			out.put(FixUtils.SOH);

            }

		if (hasEndTickPriceRange()) {		
			out.put(FixTags.ENDTICKPRICERANGE);

			out.put((byte) '=');

			FixUtils.put(out, (long)endTickPriceRange);
		
			out.put(FixUtils.SOH);

            }

		if (hasTickIncrement()) {		
			out.put(FixTags.TICKINCREMENT);

			out.put((byte) '=');

			FixUtils.put(out, (long)tickIncrement);
		
			out.put(FixUtils.SOH);

            }

		if (hasTickRuleType()) {		
			out.put(FixTags.TICKRULETYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)tickRuleType);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasStartTickPriceRange()) {		
			FixUtils.put(out, (long)startTickPriceRange);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEndTickPriceRange()) {		
			FixUtils.put(out, (long)endTickPriceRange);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTickIncrement()) {		
			FixUtils.put(out, (long)tickIncrement);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTickRuleType()) {		
			FixUtils.put(out, (long)tickRuleType);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public long getStartTickPriceRange() { 		
		if ( hasStartTickPriceRange()) {		
			if (hasStartTickPriceRange == FixUtils.TAG_HAS_VALUE) {		
				return startTickPriceRange; 		
			} else {		
		
				buf.position(hasStartTickPriceRange);		
		
			startTickPriceRange = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasStartTickPriceRange);		
					return 0;		
				}		
			}		
			hasStartTickPriceRange = FixUtils.TAG_HAS_VALUE;		
			return startTickPriceRange;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasStartTickPriceRange() { return hasStartTickPriceRange != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setStartTickPriceRange(long src) {		
		startTickPriceRange = src;
		hasStartTickPriceRange = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStartTickPriceRange(byte[] src) {		
		if (src == null ) return;
		if (hasStartTickPriceRange()) startTickPriceRange = FixUtils.TAG_HAS_NO_VALUE;		
		startTickPriceRange = FixUtils.longValueOf(src, 0, src.length);
		hasStartTickPriceRange = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setStartTickPriceRange(String str) {		
		if (str == null ) return;
		if (hasStartTickPriceRange()) startTickPriceRange = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		startTickPriceRange = FixUtils.longValueOf(src, 0, src.length);
		hasStartTickPriceRange = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getEndTickPriceRange() { 		
		if ( hasEndTickPriceRange()) {		
			if (hasEndTickPriceRange == FixUtils.TAG_HAS_VALUE) {		
				return endTickPriceRange; 		
			} else {		
		
				buf.position(hasEndTickPriceRange);		
		
			endTickPriceRange = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasEndTickPriceRange);		
					return 0;		
				}		
			}		
			hasEndTickPriceRange = FixUtils.TAG_HAS_VALUE;		
			return endTickPriceRange;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEndTickPriceRange() { return hasEndTickPriceRange != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEndTickPriceRange(long src) {		
		endTickPriceRange = src;
		hasEndTickPriceRange = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEndTickPriceRange(byte[] src) {		
		if (src == null ) return;
		if (hasEndTickPriceRange()) endTickPriceRange = FixUtils.TAG_HAS_NO_VALUE;		
		endTickPriceRange = FixUtils.longValueOf(src, 0, src.length);
		hasEndTickPriceRange = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEndTickPriceRange(String str) {		
		if (str == null ) return;
		if (hasEndTickPriceRange()) endTickPriceRange = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		endTickPriceRange = FixUtils.longValueOf(src, 0, src.length);
		hasEndTickPriceRange = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getTickIncrement() { 		
		if ( hasTickIncrement()) {		
			if (hasTickIncrement == FixUtils.TAG_HAS_VALUE) {		
				return tickIncrement; 		
			} else {		
		
				buf.position(hasTickIncrement);		
		
			tickIncrement = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasTickIncrement);		
					return 0;		
				}		
			}		
			hasTickIncrement = FixUtils.TAG_HAS_VALUE;		
			return tickIncrement;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTickIncrement() { return hasTickIncrement != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTickIncrement(long src) {		
		tickIncrement = src;
		hasTickIncrement = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTickIncrement(byte[] src) {		
		if (src == null ) return;
		if (hasTickIncrement()) tickIncrement = FixUtils.TAG_HAS_NO_VALUE;		
		tickIncrement = FixUtils.longValueOf(src, 0, src.length);
		hasTickIncrement = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTickIncrement(String str) {		
		if (str == null ) return;
		if (hasTickIncrement()) tickIncrement = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		tickIncrement = FixUtils.longValueOf(src, 0, src.length);
		hasTickIncrement = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getTickRuleType() { 		
		if ( hasTickRuleType()) {		
			if (hasTickRuleType == FixUtils.TAG_HAS_VALUE) {		
				return tickRuleType; 		
			} else {		
		
				buf.position(hasTickRuleType);		
		
			tickRuleType = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasTickRuleType);		
					return 0;		
				}		
			}		
			hasTickRuleType = FixUtils.TAG_HAS_VALUE;		
			return tickRuleType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTickRuleType() { return hasTickRuleType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setTickRuleType(long src) {		
		tickRuleType = src;
		hasTickRuleType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTickRuleType(byte[] src) {		
		if (src == null ) return;
		if (hasTickRuleType()) tickRuleType = FixUtils.TAG_HAS_NO_VALUE;		
		tickRuleType = FixUtils.longValueOf(src, 0, src.length);
		hasTickRuleType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setTickRuleType(String str) {		
		if (str == null ) return;
		if (hasTickRuleType()) tickRuleType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		tickRuleType = FixUtils.longValueOf(src, 0, src.length);
		hasTickRuleType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasStartTickPriceRange()) s += "StartTickPriceRange(1206)= " + getStartTickPriceRange() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasEndTickPriceRange()) s += "EndTickPriceRange(1207)= " + getEndTickPriceRange() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasTickIncrement()) s += "TickIncrement(1208)= " + getTickIncrement() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasTickRuleType()) s += "TickRuleType(1209)= " + getTickRuleType() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixTickRules)) return false;

		FixTickRules msg = (FixTickRules) o;

		if ((hasStartTickPriceRange() && !msg.hasStartTickPriceRange()) || (!hasStartTickPriceRange() && msg.hasStartTickPriceRange())) return false;
		if (!(!hasStartTickPriceRange() && !msg.hasStartTickPriceRange()) && !(getStartTickPriceRange()==msg.getStartTickPriceRange())) return false;
		if ((hasEndTickPriceRange() && !msg.hasEndTickPriceRange()) || (!hasEndTickPriceRange() && msg.hasEndTickPriceRange())) return false;
		if (!(!hasEndTickPriceRange() && !msg.hasEndTickPriceRange()) && !(getEndTickPriceRange()==msg.getEndTickPriceRange())) return false;
		if ((hasTickIncrement() && !msg.hasTickIncrement()) || (!hasTickIncrement() && msg.hasTickIncrement())) return false;
		if (!(!hasTickIncrement() && !msg.hasTickIncrement()) && !(getTickIncrement()==msg.getTickIncrement())) return false;
		if ((hasTickRuleType() && !msg.hasTickRuleType()) || (!hasTickRuleType() && msg.hasTickRuleType())) return false;
		if (!(!hasTickRuleType() && !msg.hasTickRuleType()) && !(getTickRuleType()==msg.getTickRuleType())) return false;
		return true;
	}
	public FixTickRules clone ( FixTickRules out ) {
		if ( hasStartTickPriceRange())
			out.setStartTickPriceRange(getStartTickPriceRange());
		if ( hasEndTickPriceRange())
			out.setEndTickPriceRange(getEndTickPriceRange());
		if ( hasTickIncrement())
			out.setTickIncrement(getTickIncrement());
		if ( hasTickRuleType())
			out.setTickRuleType(getTickRuleType());
		return out;
	}

}
