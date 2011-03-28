package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixDlvyInstGrp extends FixGroup {
	private short hasSettlInstSource;
	byte settlInstSource = (byte)' ';		
	private short hasDlvyInstType;
	byte dlvyInstType = (byte)' ';		
		FixSettlParties[] settlParties;
	
	public FixDlvyInstGrp() {
		super(FixTags.SETTLINSTSOURCE_INT);

		
		hasSettlInstSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasDlvyInstType = FixUtils.TAG_HAS_NO_VALUE;		
		settlParties = new FixSettlParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) settlParties[i] = new FixSettlParties();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasSettlInstSource()) return true;
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
            	case FixTags.SETTLINSTSOURCE_INT:		
            		hasSettlInstSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.DLVYINSTTYPE_INT:		
            		hasDlvyInstType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NOSETTLPARTYIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag); break; }
        				while ( count < noInGroupNumber ) {
        					if ( !settlParties[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "no in group tag missing", tag);
        						break;
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
        }		
        return tag;
    }		
	@Override
	public void clear() {
		// just set the length to header + trailer but still we set it...
		hasSettlInstSource = FixUtils.TAG_HAS_NO_VALUE;
		hasDlvyInstType = FixUtils.TAG_HAS_NO_VALUE;
		for (FixSettlParties fixSettlParties : settlParties) fixSettlParties.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasSettlInstSource()) {		
			out.put(FixTags.SETTLINSTSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,settlInstSource); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasDlvyInstType()) {		
			out.put(FixTags.DLVYINSTTYPE);

			out.put((byte) '=');

			FixUtils.put(out,dlvyInstType); 		
		
			out.put(FixUtils.SOH);

            }

		for (FixSettlParties fixSettlParties : settlParties) fixSettlParties.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasSettlInstSource()) {		
			FixUtils.put(out,settlInstSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDlvyInstType()) {		
			FixUtils.put(out,dlvyInstType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixSettlParties fixSettlParties : settlParties) fixSettlParties.printBuffer(out);
	}

	public byte getSettlInstSource() { 		
		if ( hasSettlInstSource()) {		
			if (hasSettlInstSource == FixUtils.TAG_HAS_VALUE) {		
				return settlInstSource; 		
			} else {		
		
				buf.position(hasSettlInstSource);		
		
			settlInstSource = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (settlInstSource != (byte)'3') && (settlInstSource != (byte)'2') && (settlInstSource != (byte)'1') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 165);		
				if (err.hasError()) {		
					buf.position(hasSettlInstSource);		
					return (byte)'0';		
				}		
			}		
			hasSettlInstSource = FixUtils.TAG_HAS_VALUE;		
			return settlInstSource;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasSettlInstSource() { return hasSettlInstSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setSettlInstSource(byte src) {		
		settlInstSource = src;
		hasSettlInstSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlInstSource(byte[] src) {		
		if (src == null ) return;
		if (hasSettlInstSource()) settlInstSource = (byte)' ';		
		settlInstSource = src[0];		
		hasSettlInstSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setSettlInstSource(String str) {		
		if (str == null ) return;
		if (hasSettlInstSource()) settlInstSource = (byte)' ';		
		byte[] src = str.getBytes(); 		
		settlInstSource = src[0];		
		hasSettlInstSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte getDlvyInstType() { 		
		if ( hasDlvyInstType()) {		
			if (hasDlvyInstType == FixUtils.TAG_HAS_VALUE) {		
				return dlvyInstType; 		
			} else {		
		
				buf.position(hasDlvyInstType);		
		
			dlvyInstType = FixMessage.getTagCharValue(buf, err);
			if( !err.hasError() && (dlvyInstType != (byte)'S') && (dlvyInstType != (byte)'C') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 787);		
				if (err.hasError()) {		
					buf.position(hasDlvyInstType);		
					return (byte)'0';		
				}		
			}		
			hasDlvyInstType = FixUtils.TAG_HAS_VALUE;		
			return dlvyInstType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasDlvyInstType() { return hasDlvyInstType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDlvyInstType(byte src) {		
		dlvyInstType = src;
		hasDlvyInstType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDlvyInstType(byte[] src) {		
		if (src == null ) return;
		if (hasDlvyInstType()) dlvyInstType = (byte)' ';		
		dlvyInstType = src[0];		
		hasDlvyInstType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDlvyInstType(String str) {		
		if (str == null ) return;
		if (hasDlvyInstType()) dlvyInstType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		dlvyInstType = src[0];		
		hasDlvyInstType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasSettlInstSource()) s += "SettlInstSource(165)= " + getSettlInstSource() + "\n" ; 
		if (hasDlvyInstType()) s += "DlvyInstType(787)= " + getDlvyInstType() + "\n" ; 

		for (FixSettlParties fixSettlParties : settlParties) fixSettlParties.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixDlvyInstGrp)) return false;

		FixDlvyInstGrp msg = (FixDlvyInstGrp) o;

		for (FixSettlParties fixSettlParties : settlParties)
			if (!fixSettlParties.equals(msg.settlParties)) return false;
		if ((hasSettlInstSource() && !msg.hasSettlInstSource()) || (!hasSettlInstSource() && msg.hasSettlInstSource())) return false;
		if (!(!hasSettlInstSource() && !msg.hasSettlInstSource()) && !(getSettlInstSource()==msg.getSettlInstSource())) return false;
		if ((hasDlvyInstType() && !msg.hasDlvyInstType()) || (!hasDlvyInstType() && msg.hasDlvyInstType())) return false;
		if (!(!hasDlvyInstType() && !msg.hasDlvyInstType()) && !(getDlvyInstType()==msg.getDlvyInstType())) return false;
		return true;
	}
	public FixDlvyInstGrp clone ( FixDlvyInstGrp out ) {
		if ( hasSettlInstSource())
			out.setSettlInstSource(getSettlInstSource());
		if ( hasDlvyInstType())
			out.setDlvyInstType(getDlvyInstType());
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
