package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixComplexEventDates extends FixGroup {
	private short hasComplexEventStartDate;
	byte[] complexEventStartDate = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasComplexEventEndDate;
	byte[] complexEventEndDate = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		FixComplexEventTimes[] complexEventTimes;
	
	public FixComplexEventDates() {
		super(FixTags.COMPLEXEVENTSTARTDATE_INT);

		
		hasComplexEventStartDate = FixUtils.TAG_HAS_NO_VALUE;		
		complexEventStartDate = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasComplexEventEndDate = FixUtils.TAG_HAS_NO_VALUE;		
		complexEventEndDate = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		complexEventTimes = new FixComplexEventTimes[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) complexEventTimes[i] = new FixComplexEventTimes();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasComplexEventStartDate()) return true;
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
            	case FixTags.COMPLEXEVENTSTARTDATE_INT:		
            		hasComplexEventStartDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.COMPLEXEVENTENDDATE_INT:		
            		hasComplexEventEndDate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NOCOMPLEXEVENTTIMES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !complexEventTimes[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
        					}
        					count++;
        					repeatingGroupTag = complexEventTimes[count].setBuffer( repeatingGroupTag, buf, err);	
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
		hasComplexEventStartDate = FixUtils.TAG_HAS_NO_VALUE;
		hasComplexEventEndDate = FixUtils.TAG_HAS_NO_VALUE;
		for (FixComplexEventTimes fixComplexEventTimes : complexEventTimes) fixComplexEventTimes.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasComplexEventStartDate()) {		
			out.put(FixTags.COMPLEXEVENTSTARTDATE);

			out.put((byte) '=');

			FixUtils.put(out,complexEventStartDate); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasComplexEventEndDate()) {		
			out.put(FixTags.COMPLEXEVENTENDDATE);

			out.put((byte) '=');

			FixUtils.put(out,complexEventEndDate); 		
		
			out.put(FixUtils.SOH);

            }

		for (FixComplexEventTimes fixComplexEventTimes : complexEventTimes) fixComplexEventTimes.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasComplexEventStartDate()) {		
			FixUtils.put(out,complexEventStartDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasComplexEventEndDate()) {		
			FixUtils.put(out,complexEventEndDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixComplexEventTimes fixComplexEventTimes : complexEventTimes) fixComplexEventTimes.printBuffer(out);
	}

	public byte[] getComplexEventStartDate() { 		
		if ( hasComplexEventStartDate()) {		
			if (hasComplexEventStartDate == FixUtils.TAG_HAS_VALUE) {		
				return complexEventStartDate; 		
			} else {		
		
				buf.position(hasComplexEventStartDate);		
		
			FixMessage.getTagStringValue(buf, complexEventStartDate, 0, complexEventStartDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasComplexEventStartDate);		
					return null;		
				}		
			}		
			hasComplexEventStartDate = FixUtils.TAG_HAS_VALUE;		
			return complexEventStartDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasComplexEventStartDate() { return hasComplexEventStartDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setComplexEventStartDate(byte[] src) {		
		if (src == null ) return;
		if (hasComplexEventStartDate()) FixUtils.fillSpace(complexEventStartDate);		
		FixUtils.copy(complexEventStartDate, src); 		
		hasComplexEventStartDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setComplexEventStartDate(String str) {		
		if (str == null ) return;
		if (hasComplexEventStartDate()) FixUtils.fillSpace(complexEventStartDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(complexEventStartDate, src); 		
		hasComplexEventStartDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getComplexEventEndDate() { 		
		if ( hasComplexEventEndDate()) {		
			if (hasComplexEventEndDate == FixUtils.TAG_HAS_VALUE) {		
				return complexEventEndDate; 		
			} else {		
		
				buf.position(hasComplexEventEndDate);		
		
			FixMessage.getTagStringValue(buf, complexEventEndDate, 0, complexEventEndDate.length, err);
		
				if (err.hasError()) {		
					buf.position(hasComplexEventEndDate);		
					return null;		
				}		
			}		
			hasComplexEventEndDate = FixUtils.TAG_HAS_VALUE;		
			return complexEventEndDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasComplexEventEndDate() { return hasComplexEventEndDate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setComplexEventEndDate(byte[] src) {		
		if (src == null ) return;
		if (hasComplexEventEndDate()) FixUtils.fillSpace(complexEventEndDate);		
		FixUtils.copy(complexEventEndDate, src); 		
		hasComplexEventEndDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setComplexEventEndDate(String str) {		
		if (str == null ) return;
		if (hasComplexEventEndDate()) FixUtils.fillSpace(complexEventEndDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(complexEventEndDate, src); 		
		hasComplexEventEndDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasComplexEventStartDate()) s += "ComplexEventStartDate(1492)= " + new String( FixUtils.trim(getComplexEventStartDate()) ) + "\n" ; 
		if (hasComplexEventEndDate()) s += "ComplexEventEndDate(1493)= " + new String( FixUtils.trim(getComplexEventEndDate()) ) + "\n" ; 

		for (FixComplexEventTimes fixComplexEventTimes : complexEventTimes) fixComplexEventTimes.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixComplexEventDates)) return false;

		FixComplexEventDates msg = (FixComplexEventDates) o;

		for (FixComplexEventTimes fixComplexEventTimes : complexEventTimes)
			if (!fixComplexEventTimes.equals(msg.complexEventTimes)) return false;
		if ((hasComplexEventStartDate() && !msg.hasComplexEventStartDate()) || (!hasComplexEventStartDate() && msg.hasComplexEventStartDate())) return false;
		if (!(!hasComplexEventStartDate() && !msg.hasComplexEventStartDate()) ) return false;
		if ((hasComplexEventEndDate() && !msg.hasComplexEventEndDate()) || (!hasComplexEventEndDate() && msg.hasComplexEventEndDate())) return false;
		if (!(!hasComplexEventEndDate() && !msg.hasComplexEventEndDate()) ) return false;
		return true;
	}
	public FixComplexEventDates clone ( FixComplexEventDates out ) {
		if ( hasComplexEventStartDate())
			out.setComplexEventStartDate(getComplexEventStartDate());
		if ( hasComplexEventEndDate())
			out.setComplexEventEndDate(getComplexEventEndDate());
		int count = 0;
		count = 0;
		for (FixComplexEventTimes fixComplexEventTimes : complexEventTimes) {
			if (!fixComplexEventTimes.hasGroup()) continue;
			out.complexEventTimes[count] = fixComplexEventTimes.clone( out.complexEventTimes[count] );
			count++;
		}
		return out;
	}

}
