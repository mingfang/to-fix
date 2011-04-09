package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixNewsRefGrp extends FixGroup {
	private short hasNewsRefID;
	byte[] newsRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasNewsRefType;
	long newsRefType = 0;		
	
	public FixNewsRefGrp() {
		this(false);
	}

	public FixNewsRefGrp(boolean isRequired) {
		super(FixTags.NEWSREFID_INT);

		this.isRequired = isRequired;
		
		hasNewsRefID = FixUtils.TAG_HAS_NO_VALUE;		
		newsRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasNewsRefType = FixUtils.TAG_HAS_NO_VALUE;		
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasNewsRefID()) return true;
		else return false;
	}


	/**
     * Parse FIX Group. The buffer is positioned at the value of the tag.
     */
    public int setBuffer( int tag, ByteBuffer buf, FixValidationError err)
    {

		super.err = err;
		super.setBuffer(buf, err);


        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.NEWSREFID_INT:		
            		hasNewsRefID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.NEWSREFTYPE_INT:		
            		hasNewsRefType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	default:
            		return tag;

            }

            tag = FixUtils.getTag(buf, err);
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
		hasNewsRefID = FixUtils.TAG_HAS_NO_VALUE;
		hasNewsRefType = FixUtils.TAG_HAS_NO_VALUE;
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasNewsRefID()) {		
			out.put(FixTags.NEWSREFID);

			out.put((byte) '=');

			FixUtils.put(out,newsRefID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasNewsRefType()) {		
			out.put(FixTags.NEWSREFTYPE);

			out.put((byte) '=');

			FixUtils.put(out, (long)newsRefType);
		
			out.put(FixUtils.SOH);

            }

	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasNewsRefID()) {		
			FixUtils.put(out,newsRefID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasNewsRefType()) {		
			FixUtils.put(out, (long)newsRefType);
		
	        out.put( (byte)' ' );		
		}		
		
	}

	public byte[] getNewsRefID() { 		
		if ( hasNewsRefID()) {		
			if (hasNewsRefID == FixUtils.TAG_HAS_VALUE) {		
				return newsRefID; 		
			} else {		
		
				buf.position(hasNewsRefID);		
		
			FixUtils.getTagStringValue(buf, newsRefID, 0, newsRefID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasNewsRefID);		
					return null;		
				}		
			}		
			hasNewsRefID = FixUtils.TAG_HAS_VALUE;		
			return newsRefID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasNewsRefID() { return hasNewsRefID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNewsRefID(byte[] src) {		
		if (src == null ) return;
		if (hasNewsRefID()) FixUtils.fillNul(newsRefID);		
		FixUtils.copy(newsRefID, src); 		
		hasNewsRefID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNewsRefID(String str) {		
		if (str == null ) return;
		if (hasNewsRefID()) FixUtils.fillNul(newsRefID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(newsRefID, src); 		
		hasNewsRefID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getNewsRefType() { 		
		if ( hasNewsRefType()) {		
			if (hasNewsRefType == FixUtils.TAG_HAS_VALUE) {		
				return newsRefType; 		
			} else {		
		
				buf.position(hasNewsRefType);		
		
			newsRefType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasNewsRefType);		
					return 0;		
				}		
			}		
			hasNewsRefType = FixUtils.TAG_HAS_VALUE;		
			return newsRefType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasNewsRefType() { return hasNewsRefType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setNewsRefType(long src) {		
		newsRefType = src;
		hasNewsRefType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setNewsRefType(byte[] src) {		
		if (src == null ) return;
		if (hasNewsRefType()) newsRefType = FixUtils.TAG_HAS_NO_VALUE;		
		newsRefType = FixUtils.longValueOf(src, 0, src.length);
		hasNewsRefType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setNewsRefType(String str) {		
		if (str == null ) return;
		if (hasNewsRefType()) newsRefType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		newsRefType = FixUtils.longValueOf(src, 0, src.length);
		hasNewsRefType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasNewsRefID()) s += "NewsRefID(1476)= " + new String( FixUtils.trim(getNewsRefID()) ) + "\n" ; 
		if (hasNewsRefType()) s += "NewsRefType(1477)= " + getNewsRefType() + "\n" ; 

			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixNewsRefGrp)) return false;

		FixNewsRefGrp msg = (FixNewsRefGrp) o;

		if ((hasNewsRefID() && !msg.hasNewsRefID()) || (!hasNewsRefID() && msg.hasNewsRefID())) return false;
		if (!(!hasNewsRefID() && !msg.hasNewsRefID()) && !FixUtils.equals(getNewsRefID(), msg.getNewsRefID())) return false;
		if ((hasNewsRefType() && !msg.hasNewsRefType()) || (!hasNewsRefType() && msg.hasNewsRefType())) return false;
		if (!(!hasNewsRefType() && !msg.hasNewsRefType()) && !(getNewsRefType()==msg.getNewsRefType())) return false;
		return true;
	}
	public FixNewsRefGrp clone ( FixNewsRefGrp out ) {
		if ( hasNewsRefID())
			out.setNewsRefID(getNewsRefID());
		if ( hasNewsRefType())
			out.setNewsRefType(getNewsRefType());
		return out;
	}

}
