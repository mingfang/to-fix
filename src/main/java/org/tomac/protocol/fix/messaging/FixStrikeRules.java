package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixStrikeRules extends FixGroup {
	private short hasStrikeRuleID;
	byte[] strikeRuleID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasStartStrikePxRange;
	long startStrikePxRange = 0;		
	private short hasEndStrikePxRange;
	long endStrikePxRange = 0;		
	private short hasStrikeIncrement;
	long strikeIncrement = 0;		
	private short hasStrikeExerciseStyle;
	long strikeExerciseStyle = 0;		
		FixMaturityRules[] maturityRules;
	
	public FixStrikeRules() {
		super(FixTags.STRIKERULEID_INT);

		
		hasStrikeRuleID = FixUtils.TAG_HAS_NO_VALUE;		
		strikeRuleID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasStartStrikePxRange = FixUtils.TAG_HAS_NO_VALUE;		
		hasEndStrikePxRange = FixUtils.TAG_HAS_NO_VALUE;		
		hasStrikeIncrement = FixUtils.TAG_HAS_NO_VALUE;		
		hasStrikeExerciseStyle = FixUtils.TAG_HAS_NO_VALUE;		
		maturityRules = new FixMaturityRules[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) maturityRules[i] = new FixMaturityRules();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasStrikeRuleID()) return true;
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
            	case FixTags.STRIKERULEID_INT:		
            		hasStrikeRuleID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.STARTSTRIKEPXRANGE_INT:		
            		hasStartStrikePxRange = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.ENDSTRIKEPXRANGE_INT:		
            		hasEndStrikePxRange = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.STRIKEINCREMENT_INT:		
            		hasStrikeIncrement = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.STRIKEEXERCISESTYLE_INT:		
            		hasStrikeExerciseStyle = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NOMATURITYRULES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !maturityRules[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = maturityRules[count].setBuffer( repeatingGroupTag, buf, err);	
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
		hasStrikeRuleID = FixUtils.TAG_HAS_NO_VALUE;
		hasStartStrikePxRange = FixUtils.TAG_HAS_NO_VALUE;
		hasEndStrikePxRange = FixUtils.TAG_HAS_NO_VALUE;
		hasStrikeIncrement = FixUtils.TAG_HAS_NO_VALUE;
		hasStrikeExerciseStyle = FixUtils.TAG_HAS_NO_VALUE;
		for (FixMaturityRules fixMaturityRules : maturityRules) fixMaturityRules.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasStrikeRuleID()) {		
			out.put(FixTags.STRIKERULEID);

			out.put((byte) '=');

			FixUtils.put(out,strikeRuleID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasStartStrikePxRange()) {		
			out.put(FixTags.STARTSTRIKEPXRANGE);

			out.put((byte) '=');

			FixUtils.put(out, (long)startStrikePxRange);
		
			out.put(FixUtils.SOH);

            }

		if (hasEndStrikePxRange()) {		
			out.put(FixTags.ENDSTRIKEPXRANGE);

			out.put((byte) '=');

			FixUtils.put(out, (long)endStrikePxRange);
		
			out.put(FixUtils.SOH);

            }

		if (hasStrikeIncrement()) {		
			out.put(FixTags.STRIKEINCREMENT);

			out.put((byte) '=');

			FixUtils.put(out, (long)strikeIncrement);
		
			out.put(FixUtils.SOH);

            }

		if (hasStrikeExerciseStyle()) {		
			out.put(FixTags.STRIKEEXERCISESTYLE);

			out.put((byte) '=');

			FixUtils.put(out, (long)strikeExerciseStyle);
		
			out.put(FixUtils.SOH);

            }

		for (FixMaturityRules fixMaturityRules : maturityRules) fixMaturityRules.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasStrikeRuleID()) {		
			FixUtils.put(out,strikeRuleID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasStartStrikePxRange()) {		
			FixUtils.put(out, (long)startStrikePxRange);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEndStrikePxRange()) {		
			FixUtils.put(out, (long)endStrikePxRange);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasStrikeIncrement()) {		
			FixUtils.put(out, (long)strikeIncrement);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasStrikeExerciseStyle()) {		
			FixUtils.put(out, (long)strikeExerciseStyle);
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixMaturityRules fixMaturityRules : maturityRules) fixMaturityRules.printBuffer(out);
	}

	public byte[] getStrikeRuleID() { 		
		if ( hasStrikeRuleID()) {		
			if (hasStrikeRuleID == FixUtils.TAG_HAS_VALUE) {		
				return strikeRuleID; 		
			} else {		
		
				buf.position(hasStrikeRuleID);		
		
			FixMessage.getTagStringValue(buf, strikeRuleID, 0, strikeRuleID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasStrikeRuleID);		
					return null;		
				}		
			}		
			hasStrikeRuleID = FixUtils.TAG_HAS_VALUE;		
			return strikeRuleID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasStrikeRuleID() { return hasStrikeRuleID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setStrikeRuleID(byte[] src) {		
		if (src == null ) return;
		if (hasStrikeRuleID()) FixUtils.fillSpace(strikeRuleID);		
		FixUtils.copy(strikeRuleID, src); 		
		hasStrikeRuleID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setStrikeRuleID(String str) {		
		if (str == null ) return;
		if (hasStrikeRuleID()) FixUtils.fillSpace(strikeRuleID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(strikeRuleID, src); 		
		hasStrikeRuleID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getStartStrikePxRange() { 		
		if ( hasStartStrikePxRange()) {		
			if (hasStartStrikePxRange == FixUtils.TAG_HAS_VALUE) {		
				return startStrikePxRange; 		
			} else {		
		
				buf.position(hasStartStrikePxRange);		
		
			startStrikePxRange = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasStartStrikePxRange);		
					return 0;		
				}		
			}		
			hasStartStrikePxRange = FixUtils.TAG_HAS_VALUE;		
			return startStrikePxRange;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasStartStrikePxRange() { return hasStartStrikePxRange != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setStartStrikePxRange(long src) {		
		startStrikePxRange = src;
		hasStartStrikePxRange = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStartStrikePxRange(byte[] src) {		
		if (src == null ) return;
		if (hasStartStrikePxRange()) startStrikePxRange = FixUtils.TAG_HAS_NO_VALUE;		
		startStrikePxRange = FixUtils.longValueOf(src, 0, src.length);
		hasStartStrikePxRange = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setStartStrikePxRange(String str) {		
		if (str == null ) return;
		if (hasStartStrikePxRange()) startStrikePxRange = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		startStrikePxRange = FixUtils.longValueOf(src, 0, src.length);
		hasStartStrikePxRange = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getEndStrikePxRange() { 		
		if ( hasEndStrikePxRange()) {		
			if (hasEndStrikePxRange == FixUtils.TAG_HAS_VALUE) {		
				return endStrikePxRange; 		
			} else {		
		
				buf.position(hasEndStrikePxRange);		
		
			endStrikePxRange = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasEndStrikePxRange);		
					return 0;		
				}		
			}		
			hasEndStrikePxRange = FixUtils.TAG_HAS_VALUE;		
			return endStrikePxRange;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasEndStrikePxRange() { return hasEndStrikePxRange != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setEndStrikePxRange(long src) {		
		endStrikePxRange = src;
		hasEndStrikePxRange = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEndStrikePxRange(byte[] src) {		
		if (src == null ) return;
		if (hasEndStrikePxRange()) endStrikePxRange = FixUtils.TAG_HAS_NO_VALUE;		
		endStrikePxRange = FixUtils.longValueOf(src, 0, src.length);
		hasEndStrikePxRange = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setEndStrikePxRange(String str) {		
		if (str == null ) return;
		if (hasEndStrikePxRange()) endStrikePxRange = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		endStrikePxRange = FixUtils.longValueOf(src, 0, src.length);
		hasEndStrikePxRange = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getStrikeIncrement() { 		
		if ( hasStrikeIncrement()) {		
			if (hasStrikeIncrement == FixUtils.TAG_HAS_VALUE) {		
				return strikeIncrement; 		
			} else {		
		
				buf.position(hasStrikeIncrement);		
		
			strikeIncrement = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasStrikeIncrement);		
					return 0;		
				}		
			}		
			hasStrikeIncrement = FixUtils.TAG_HAS_VALUE;		
			return strikeIncrement;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasStrikeIncrement() { return hasStrikeIncrement != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setStrikeIncrement(long src) {		
		strikeIncrement = src;
		hasStrikeIncrement = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStrikeIncrement(byte[] src) {		
		if (src == null ) return;
		if (hasStrikeIncrement()) strikeIncrement = FixUtils.TAG_HAS_NO_VALUE;		
		strikeIncrement = FixUtils.longValueOf(src, 0, src.length);
		hasStrikeIncrement = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setStrikeIncrement(String str) {		
		if (str == null ) return;
		if (hasStrikeIncrement()) strikeIncrement = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		strikeIncrement = FixUtils.longValueOf(src, 0, src.length);
		hasStrikeIncrement = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getStrikeExerciseStyle() { 		
		if ( hasStrikeExerciseStyle()) {		
			if (hasStrikeExerciseStyle == FixUtils.TAG_HAS_VALUE) {		
				return strikeExerciseStyle; 		
			} else {		
		
				buf.position(hasStrikeExerciseStyle);		
		
			strikeExerciseStyle = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasStrikeExerciseStyle);		
					return 0;		
				}		
			}		
			hasStrikeExerciseStyle = FixUtils.TAG_HAS_VALUE;		
			return strikeExerciseStyle;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasStrikeExerciseStyle() { return hasStrikeExerciseStyle != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setStrikeExerciseStyle(long src) {		
		strikeExerciseStyle = src;
		hasStrikeExerciseStyle = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStrikeExerciseStyle(byte[] src) {		
		if (src == null ) return;
		if (hasStrikeExerciseStyle()) strikeExerciseStyle = FixUtils.TAG_HAS_NO_VALUE;		
		strikeExerciseStyle = FixUtils.longValueOf(src, 0, src.length);
		hasStrikeExerciseStyle = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setStrikeExerciseStyle(String str) {		
		if (str == null ) return;
		if (hasStrikeExerciseStyle()) strikeExerciseStyle = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		strikeExerciseStyle = FixUtils.longValueOf(src, 0, src.length);
		hasStrikeExerciseStyle = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasStrikeRuleID()) s += "StrikeRuleID(1223)= " + new String( FixUtils.trim(getStrikeRuleID()) ) + "\n" ; 
		if (hasStartStrikePxRange()) s += "StartStrikePxRange(1202)= " + getStartStrikePxRange() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasEndStrikePxRange()) s += "EndStrikePxRange(1203)= " + getEndStrikePxRange() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasStrikeIncrement()) s += "StrikeIncrement(1204)= " + getStrikeIncrement() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasStrikeExerciseStyle()) s += "StrikeExerciseStyle(1304)= " + getStrikeExerciseStyle() + "\n" ; 

		for (FixMaturityRules fixMaturityRules : maturityRules) fixMaturityRules.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixStrikeRules)) return false;

		FixStrikeRules msg = (FixStrikeRules) o;

		for (FixMaturityRules fixMaturityRules : maturityRules)
			if (!fixMaturityRules.equals(msg.maturityRules)) return false;
		if ((hasStrikeRuleID() && !msg.hasStrikeRuleID()) || (!hasStrikeRuleID() && msg.hasStrikeRuleID())) return false;
		if (!(!hasStrikeRuleID() && !msg.hasStrikeRuleID()) && !FixUtils.equals(getStrikeRuleID(), msg.getStrikeRuleID())) return false;
		if ((hasStartStrikePxRange() && !msg.hasStartStrikePxRange()) || (!hasStartStrikePxRange() && msg.hasStartStrikePxRange())) return false;
		if (!(!hasStartStrikePxRange() && !msg.hasStartStrikePxRange()) && !(getStartStrikePxRange()==msg.getStartStrikePxRange())) return false;
		if ((hasEndStrikePxRange() && !msg.hasEndStrikePxRange()) || (!hasEndStrikePxRange() && msg.hasEndStrikePxRange())) return false;
		if (!(!hasEndStrikePxRange() && !msg.hasEndStrikePxRange()) && !(getEndStrikePxRange()==msg.getEndStrikePxRange())) return false;
		if ((hasStrikeIncrement() && !msg.hasStrikeIncrement()) || (!hasStrikeIncrement() && msg.hasStrikeIncrement())) return false;
		if (!(!hasStrikeIncrement() && !msg.hasStrikeIncrement()) && !(getStrikeIncrement()==msg.getStrikeIncrement())) return false;
		if ((hasStrikeExerciseStyle() && !msg.hasStrikeExerciseStyle()) || (!hasStrikeExerciseStyle() && msg.hasStrikeExerciseStyle())) return false;
		if (!(!hasStrikeExerciseStyle() && !msg.hasStrikeExerciseStyle()) && !(getStrikeExerciseStyle()==msg.getStrikeExerciseStyle())) return false;
		return true;
	}
	public FixStrikeRules clone ( FixStrikeRules out ) {
		if ( hasStrikeRuleID())
			out.setStrikeRuleID(getStrikeRuleID());
		if ( hasStartStrikePxRange())
			out.setStartStrikePxRange(getStartStrikePxRange());
		if ( hasEndStrikePxRange())
			out.setEndStrikePxRange(getEndStrikePxRange());
		if ( hasStrikeIncrement())
			out.setStrikeIncrement(getStrikeIncrement());
		if ( hasStrikeExerciseStyle())
			out.setStrikeExerciseStyle(getStrikeExerciseStyle());
		int count = 0;
		count = 0;
		for (FixMaturityRules fixMaturityRules : maturityRules) {
			if (!fixMaturityRules.hasGroup()) continue;
			out.maturityRules[count] = fixMaturityRules.clone( out.maturityRules[count] );
			count++;
		}
		return out;
	}

}
