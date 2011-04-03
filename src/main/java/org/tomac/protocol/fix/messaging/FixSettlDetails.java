package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixSettlDetails extends FixGroup {
	private short hasSettlObligSource;
	byte settlObligSource = (byte)' ';		
		public FixSettlParties[] settlParties;
	
	public FixSettlDetails() {
		this(false);
	}

	public FixSettlDetails(boolean isRequired) {
		super(FixTags.SETTLOBLIGSOURCE_INT);

		this.isRequired = isRequired;
		
		hasSettlObligSource = FixUtils.TAG_HAS_NO_VALUE;		
		settlParties = new FixSettlParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) settlParties[i] = new FixSettlParties();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasSettlObligSource()) return true;
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
            	case FixTags.SETTLOBLIGSOURCE_INT:		
            		hasSettlObligSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NOSETTLPARTYIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !settlParties[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = settlParties[count].setBuffer( repeatingGroupTag, buf, err);	
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
		hasSettlObligSource = FixUtils.TAG_HAS_NO_VALUE;
		for (FixSettlParties fixSettlParties : settlParties) fixSettlParties.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasSettlObligSource()) {		
			out.put(FixTags.SETTLOBLIGSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,settlObligSource); 		
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(settlParties)>0) {
			out.put(FixTags.NOSETTLPARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(settlParties));

			out.put(FixUtils.SOH);

		}
		for (FixSettlParties fixSettlParties : settlParties) if (fixSettlParties.hasGroup()) fixSettlParties.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasSettlObligSource()) {		
			FixUtils.put(out,settlObligSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixSettlParties fixSettlParties : settlParties) fixSettlParties.printBuffer(out);
	}

	public byte getSettlObligSource() { 		
		if ( hasSettlObligSource()) {		
			if (hasSettlObligSource == FixUtils.TAG_HAS_VALUE) {		
				return settlObligSource; 		
			} else {		
		
				buf.position(hasSettlObligSource);		
		
			settlObligSource = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (settlObligSource != (byte)'3') && (settlObligSource != (byte)'2') && (settlObligSource != (byte)'1') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 1164);		
				if (err.hasError()) {		
					buf.position(hasSettlObligSource);		
					return (byte)'0';		
				}		
			}		
			hasSettlObligSource = FixUtils.TAG_HAS_VALUE;		
			return settlObligSource;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasSettlObligSource() { return hasSettlObligSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSettlObligSource(byte src) {		
		settlObligSource = src;
		hasSettlObligSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlObligSource(byte[] src) {		
		if (src == null ) return;
		if (hasSettlObligSource()) settlObligSource = (byte)' ';		
		settlObligSource = src[0];		
		hasSettlObligSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSettlObligSource(String str) {		
		if (str == null ) return;
		if (hasSettlObligSource()) settlObligSource = (byte)' ';		
		byte[] src = str.getBytes(); 		
		settlObligSource = src[0];		
		hasSettlObligSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasSettlObligSource()) s += "SettlObligSource(1164)= " + getSettlObligSource() + "\n" ; 

		for (FixSettlParties fixSettlParties : settlParties) fixSettlParties.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixSettlDetails)) return false;

		FixSettlDetails msg = (FixSettlDetails) o;

		for (int i = 0; i < settlParties.length; i++)
			if (!settlParties[i].equals(msg.settlParties[i])) return false;
		if ((hasSettlObligSource() && !msg.hasSettlObligSource()) || (!hasSettlObligSource() && msg.hasSettlObligSource())) return false;
		if (!(!hasSettlObligSource() && !msg.hasSettlObligSource()) && !(getSettlObligSource()==msg.getSettlObligSource())) return false;
		return true;
	}
	public FixSettlDetails clone ( FixSettlDetails out ) {
		if ( hasSettlObligSource())
			out.setSettlObligSource(getSettlObligSource());
		int count = 0;
		count = 0;
		for (FixSettlParties fixSettlParties : settlParties) {
			if (!fixSettlParties.hasGroup()) continue;
			out.settlParties[count] = fixSettlParties.clone( out.settlParties[count] );
			count++;
		}
		return out;
	}

}
