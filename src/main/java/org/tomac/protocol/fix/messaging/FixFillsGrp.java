package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixFillsGrp extends FixGroup {
	private short hasFillExecID;
	byte[] fillExecID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasFillPx;
	long fillPx = 0;		
	private short hasFillQty;
	long fillQty = 0;		
	private short hasFillLiquidityInd;
	long fillLiquidityInd = 0;		
		public FixNestedParties4[] nestedParties4;
	
	public FixFillsGrp() {
		this(false);
	}

	public FixFillsGrp(boolean isRequired) {
		super(FixTags.FILLEXECID_INT);

		this.isRequired = isRequired;
		
		hasFillExecID = FixUtils.TAG_HAS_NO_VALUE;		
		fillExecID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasFillPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasFillQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasFillLiquidityInd = FixUtils.TAG_HAS_NO_VALUE;		
		nestedParties4 = new FixNestedParties4[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) nestedParties4[i] = new FixNestedParties4();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasFillExecID()) return true;
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
            	case FixTags.FILLEXECID_INT:		
            		hasFillExecID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.FILLPX_INT:		
            		hasFillPx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.FILLQTY_INT:		
            		hasFillQty = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.FILLLIQUIDITYIND_INT:		
            		hasFillLiquidityInd = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NONESTED4PARTYIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !nestedParties4[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = nestedParties4[count].setBuffer( repeatingGroupTag, buf, err);	
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
		hasFillExecID = FixUtils.TAG_HAS_NO_VALUE;
		hasFillPx = FixUtils.TAG_HAS_NO_VALUE;
		hasFillQty = FixUtils.TAG_HAS_NO_VALUE;
		hasFillLiquidityInd = FixUtils.TAG_HAS_NO_VALUE;
		for (FixNestedParties4 fixNestedParties4 : nestedParties4) fixNestedParties4.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasFillExecID()) {		
			out.put(FixTags.FILLEXECID);

			out.put((byte) '=');

			FixUtils.put(out,fillExecID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasFillPx()) {		
			out.put(FixTags.FILLPX);

			out.put((byte) '=');

			FixUtils.put(out, (long)fillPx);
		
			out.put(FixUtils.SOH);

            }

		if (hasFillQty()) {		
			out.put(FixTags.FILLQTY);

			out.put((byte) '=');

			FixUtils.put(out, (long)fillQty);
		
			out.put(FixUtils.SOH);

            }

		if (hasFillLiquidityInd()) {		
			out.put(FixTags.FILLLIQUIDITYIND);

			out.put((byte) '=');

			FixUtils.put(out, (long)fillLiquidityInd);
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(nestedParties4)>0) {
			out.put(FixTags.NONESTED4PARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(nestedParties4));

			out.put(FixUtils.SOH);

		}
		for (FixNestedParties4 fixNestedParties4 : nestedParties4) if (fixNestedParties4.hasGroup()) fixNestedParties4.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasFillExecID()) {		
			FixUtils.put(out,fillExecID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasFillPx()) {		
			FixUtils.put(out, (long)fillPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasFillQty()) {		
			FixUtils.put(out, (long)fillQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasFillLiquidityInd()) {		
			FixUtils.put(out, (long)fillLiquidityInd);
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixNestedParties4 fixNestedParties4 : nestedParties4) fixNestedParties4.printBuffer(out);
	}

	public byte[] getFillExecID() { 		
		if ( hasFillExecID()) {		
			if (hasFillExecID == FixUtils.TAG_HAS_VALUE) {		
				return fillExecID; 		
			} else {		
		
				buf.position(hasFillExecID);		
		
			FixMessage.getTagStringValue(buf, fillExecID, 0, fillExecID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasFillExecID);		
					return null;		
				}		
			}		
			hasFillExecID = FixUtils.TAG_HAS_VALUE;		
			return fillExecID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasFillExecID() { return hasFillExecID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setFillExecID(byte[] src) {		
		if (src == null ) return;
		if (hasFillExecID()) FixUtils.fillNul(fillExecID);		
		FixUtils.copy(fillExecID, src); 		
		hasFillExecID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setFillExecID(String str) {		
		if (str == null ) return;
		if (hasFillExecID()) FixUtils.fillNul(fillExecID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(fillExecID, src); 		
		hasFillExecID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getFillPx() { 		
		if ( hasFillPx()) {		
			if (hasFillPx == FixUtils.TAG_HAS_VALUE) {		
				return fillPx; 		
			} else {		
		
				buf.position(hasFillPx);		
		
			fillPx = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasFillPx);		
					return 0;		
				}		
			}		
			hasFillPx = FixUtils.TAG_HAS_VALUE;		
			return fillPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasFillPx() { return hasFillPx != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setFillPx(long src) {		
		fillPx = src;
		hasFillPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setFillPx(byte[] src) {		
		if (src == null ) return;
		if (hasFillPx()) fillPx = FixUtils.TAG_HAS_NO_VALUE;		
		fillPx = FixUtils.longValueOf(src, 0, src.length);
		hasFillPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setFillPx(String str) {		
		if (str == null ) return;
		if (hasFillPx()) fillPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		fillPx = FixUtils.longValueOf(src, 0, src.length);
		hasFillPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getFillQty() { 		
		if ( hasFillQty()) {		
			if (hasFillQty == FixUtils.TAG_HAS_VALUE) {		
				return fillQty; 		
			} else {		
		
				buf.position(hasFillQty);		
		
			fillQty = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasFillQty);		
					return 0;		
				}		
			}		
			hasFillQty = FixUtils.TAG_HAS_VALUE;		
			return fillQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasFillQty() { return hasFillQty != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setFillQty(long src) {		
		fillQty = src;
		hasFillQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setFillQty(byte[] src) {		
		if (src == null ) return;
		if (hasFillQty()) fillQty = FixUtils.TAG_HAS_NO_VALUE;		
		fillQty = FixUtils.longValueOf(src, 0, src.length);
		hasFillQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setFillQty(String str) {		
		if (str == null ) return;
		if (hasFillQty()) fillQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		fillQty = FixUtils.longValueOf(src, 0, src.length);
		hasFillQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getFillLiquidityInd() { 		
		if ( hasFillLiquidityInd()) {		
			if (hasFillLiquidityInd == FixUtils.TAG_HAS_VALUE) {		
				return fillLiquidityInd; 		
			} else {		
		
				buf.position(hasFillLiquidityInd);		
		
			fillLiquidityInd = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasFillLiquidityInd);		
					return 0;		
				}		
			}		
			hasFillLiquidityInd = FixUtils.TAG_HAS_VALUE;		
			return fillLiquidityInd;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasFillLiquidityInd() { return hasFillLiquidityInd != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setFillLiquidityInd(long src) {		
		fillLiquidityInd = src;
		hasFillLiquidityInd = FixUtils.TAG_HAS_VALUE;		
	}

	public void setFillLiquidityInd(byte[] src) {		
		if (src == null ) return;
		if (hasFillLiquidityInd()) fillLiquidityInd = FixUtils.TAG_HAS_NO_VALUE;		
		fillLiquidityInd = FixUtils.longValueOf(src, 0, src.length);
		hasFillLiquidityInd = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setFillLiquidityInd(String str) {		
		if (str == null ) return;
		if (hasFillLiquidityInd()) fillLiquidityInd = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		fillLiquidityInd = FixUtils.longValueOf(src, 0, src.length);
		hasFillLiquidityInd = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasFillExecID()) s += "FillExecID(1363)= " + new String( FixUtils.trim(getFillExecID()) ) + "\n" ; 
		if (hasFillPx()) s += "FillPx(1364)= " + getFillPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasFillQty()) s += "FillQty(1365)= " + getFillQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasFillLiquidityInd()) s += "FillLiquidityInd(1443)= " + getFillLiquidityInd() + "\n" ; 

		for (FixNestedParties4 fixNestedParties4 : nestedParties4) fixNestedParties4.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixFillsGrp)) return false;

		FixFillsGrp msg = (FixFillsGrp) o;

		for (int i = 0; i < nestedParties4.length; i++)
			if (!nestedParties4[i].equals(msg.nestedParties4[i])) return false;
		if ((hasFillExecID() && !msg.hasFillExecID()) || (!hasFillExecID() && msg.hasFillExecID())) return false;
		if (!(!hasFillExecID() && !msg.hasFillExecID()) && !FixUtils.equals(getFillExecID(), msg.getFillExecID())) return false;
		if ((hasFillPx() && !msg.hasFillPx()) || (!hasFillPx() && msg.hasFillPx())) return false;
		if (!(!hasFillPx() && !msg.hasFillPx()) && !(getFillPx()==msg.getFillPx())) return false;
		if ((hasFillQty() && !msg.hasFillQty()) || (!hasFillQty() && msg.hasFillQty())) return false;
		if (!(!hasFillQty() && !msg.hasFillQty()) && !(getFillQty()==msg.getFillQty())) return false;
		if ((hasFillLiquidityInd() && !msg.hasFillLiquidityInd()) || (!hasFillLiquidityInd() && msg.hasFillLiquidityInd())) return false;
		if (!(!hasFillLiquidityInd() && !msg.hasFillLiquidityInd()) && !(getFillLiquidityInd()==msg.getFillLiquidityInd())) return false;
		return true;
	}
	public FixFillsGrp clone ( FixFillsGrp out ) {
		if ( hasFillExecID())
			out.setFillExecID(getFillExecID());
		if ( hasFillPx())
			out.setFillPx(getFillPx());
		if ( hasFillQty())
			out.setFillQty(getFillQty());
		if ( hasFillLiquidityInd())
			out.setFillLiquidityInd(getFillLiquidityInd());
		int count = 0;
		count = 0;
		for (FixNestedParties4 fixNestedParties4 : nestedParties4) {
			if (!fixNestedParties4.hasGroup()) continue;
			out.nestedParties4[count] = fixNestedParties4.clone( out.nestedParties4[count] );
			count++;
		}
		return out;
	}

}
