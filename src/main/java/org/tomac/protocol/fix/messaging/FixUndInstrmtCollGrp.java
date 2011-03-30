package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixUndInstrmtCollGrp extends FixGroup {
	private short hasCollAction;
	long collAction = 0;		
		public FixUnderlyingInstrument underlyingInstrument;
	
	public FixUndInstrmtCollGrp() {
		this(false);
	}

	public FixUndInstrmtCollGrp(boolean isRequired) {
		super(FixTags.UNDERLYINGSYMBOL_INT);

		this.isRequired = isRequired;
		
		hasCollAction = FixUtils.TAG_HAS_NO_VALUE;		
		underlyingInstrument = new FixUnderlyingInstrument();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (underlyingInstrument.hasGroup()) return true;
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
            	case FixTags.COLLACTION_INT:		
            		hasCollAction = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( underlyingInstrument.isKeyTag(tag)) {
        				tag = underlyingInstrument.setBuffer( tag, buf, err);		
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
		hasCollAction = FixUtils.TAG_HAS_NO_VALUE;
		underlyingInstrument.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasCollAction()) {		
			out.put(FixTags.COLLACTION);

			out.put((byte) '=');

			FixUtils.put(out, (long)collAction);
		
			out.put(FixUtils.SOH);

            }

		underlyingInstrument.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasCollAction()) {		
			FixUtils.put(out, (long)collAction);
		
	        out.put( (byte)' ' );		
		}		
		
		underlyingInstrument.printBuffer(out);
	}

	public long getCollAction() { 		
		if ( hasCollAction()) {		
			if (hasCollAction == FixUtils.TAG_HAS_VALUE) {		
				return collAction; 		
			} else {		
		
				buf.position(hasCollAction);		
		
			collAction = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasCollAction);		
					return 0;		
				}		
			}		
			hasCollAction = FixUtils.TAG_HAS_VALUE;		
			return collAction;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasCollAction() { return hasCollAction != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setCollAction(long src) {		
		collAction = src;
		hasCollAction = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCollAction(byte[] src) {		
		if (src == null ) return;
		if (hasCollAction()) collAction = FixUtils.TAG_HAS_NO_VALUE;		
		collAction = FixUtils.longValueOf(src, 0, src.length);
		hasCollAction = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setCollAction(String str) {		
		if (str == null ) return;
		if (hasCollAction()) collAction = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		collAction = FixUtils.longValueOf(src, 0, src.length);
		hasCollAction = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasCollAction()) s += "CollAction(944)= " + getCollAction() + "\n" ; 

		s += underlyingInstrument.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixUndInstrmtCollGrp)) return false;

		FixUndInstrmtCollGrp msg = (FixUndInstrmtCollGrp) o;

		if (!underlyingInstrument.equals(msg.underlyingInstrument)) return false;
		if ((hasCollAction() && !msg.hasCollAction()) || (!hasCollAction() && msg.hasCollAction())) return false;
		if (!(!hasCollAction() && !msg.hasCollAction()) && !(getCollAction()==msg.getCollAction())) return false;
		return true;
	}
	public FixUndInstrmtCollGrp clone ( FixUndInstrmtCollGrp out ) {
		if ( hasCollAction())
			out.setCollAction(getCollAction());
		if (underlyingInstrument.hasGroup())
			out.underlyingInstrument = underlyingInstrument.clone( out.underlyingInstrument);
		return out;
	}

}
