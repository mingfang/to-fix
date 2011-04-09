package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixInstrumentExtension extends FixGroup {
	private short hasDeliveryForm;
	long deliveryForm = 0;		
	private short hasPctAtRisk;
	long pctAtRisk = 0;		
		public FixAttrbGrp[] attrbGrp;
	
	public FixInstrumentExtension() {
		this(false);
	}

	public FixInstrumentExtension(boolean isRequired) {
		super(FixTags.DELIVERYFORM_INT);

		this.isRequired = isRequired;
		
		hasDeliveryForm = FixUtils.TAG_HAS_NO_VALUE;		
		hasPctAtRisk = FixUtils.TAG_HAS_NO_VALUE;		
		attrbGrp = new FixAttrbGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) attrbGrp[i] = new FixAttrbGrp();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasDeliveryForm()) return true;
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
            	case FixTags.DELIVERYFORM_INT:		
            		hasDeliveryForm = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.PCTATRISK_INT:		
            		hasPctAtRisk = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NOINSTRATTRIB_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !attrbGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = attrbGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else { return tag; }
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
		hasDeliveryForm = FixUtils.TAG_HAS_NO_VALUE;
		hasPctAtRisk = FixUtils.TAG_HAS_NO_VALUE;
		for (FixAttrbGrp fixAttrbGrp : attrbGrp) fixAttrbGrp.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasDeliveryForm()) {		
			out.put(FixTags.DELIVERYFORM);

			out.put((byte) '=');

			FixUtils.put(out, (long)deliveryForm);
		
			out.put(FixUtils.SOH);

            }

		if (hasPctAtRisk()) {		
			out.put(FixTags.PCTATRISK);

			out.put((byte) '=');

			FixUtils.put(out, (long)pctAtRisk);
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(attrbGrp)>0) {
			out.put(FixTags.NOINSTRATTRIB);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(attrbGrp));

			out.put(FixUtils.SOH);

		}
		for (FixAttrbGrp fixAttrbGrp : attrbGrp) if (fixAttrbGrp.hasGroup()) fixAttrbGrp.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasDeliveryForm()) {		
			FixUtils.put(out, (long)deliveryForm);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPctAtRisk()) {		
			FixUtils.put(out, (long)pctAtRisk);
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixAttrbGrp fixAttrbGrp : attrbGrp) fixAttrbGrp.printBuffer(out);
	}

	public long getDeliveryForm() { 		
		if ( hasDeliveryForm()) {		
			if (hasDeliveryForm == FixUtils.TAG_HAS_VALUE) {		
				return deliveryForm; 		
			} else {		
		
				buf.position(hasDeliveryForm);		
		
			deliveryForm = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasDeliveryForm);		
					return 0;		
				}		
			}		
			hasDeliveryForm = FixUtils.TAG_HAS_VALUE;		
			return deliveryForm;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasDeliveryForm() { return hasDeliveryForm != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setDeliveryForm(long src) {		
		deliveryForm = src;
		hasDeliveryForm = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDeliveryForm(byte[] src) {		
		if (src == null ) return;
		if (hasDeliveryForm()) deliveryForm = FixUtils.TAG_HAS_NO_VALUE;		
		deliveryForm = FixUtils.longValueOf(src, 0, src.length);
		hasDeliveryForm = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setDeliveryForm(String str) {		
		if (str == null ) return;
		if (hasDeliveryForm()) deliveryForm = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		deliveryForm = FixUtils.longValueOf(src, 0, src.length);
		hasDeliveryForm = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getPctAtRisk() { 		
		if ( hasPctAtRisk()) {		
			if (hasPctAtRisk == FixUtils.TAG_HAS_VALUE) {		
				return pctAtRisk; 		
			} else {		
		
				buf.position(hasPctAtRisk);		
		
			pctAtRisk = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasPctAtRisk);		
					return 0;		
				}		
			}		
			hasPctAtRisk = FixUtils.TAG_HAS_VALUE;		
			return pctAtRisk;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPctAtRisk() { return hasPctAtRisk != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setPctAtRisk(long src) {		
		pctAtRisk = src;
		hasPctAtRisk = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPctAtRisk(byte[] src) {		
		if (src == null ) return;
		if (hasPctAtRisk()) pctAtRisk = FixUtils.TAG_HAS_NO_VALUE;		
		pctAtRisk = FixUtils.longValueOf(src, 0, src.length);
		hasPctAtRisk = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setPctAtRisk(String str) {		
		if (str == null ) return;
		if (hasPctAtRisk()) pctAtRisk = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		pctAtRisk = FixUtils.longValueOf(src, 0, src.length);
		hasPctAtRisk = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasDeliveryForm()) s += "DeliveryForm(668)= " + getDeliveryForm() + "\n" ; 
		if (hasPctAtRisk()) s += "PctAtRisk(869)= " + getPctAtRisk() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 

		for (FixAttrbGrp fixAttrbGrp : attrbGrp) fixAttrbGrp.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixInstrumentExtension)) return false;

		FixInstrumentExtension msg = (FixInstrumentExtension) o;

		for (int i = 0; i < attrbGrp.length; i++)
			if (!attrbGrp[i].equals(msg.attrbGrp[i])) return false;
		if ((hasDeliveryForm() && !msg.hasDeliveryForm()) || (!hasDeliveryForm() && msg.hasDeliveryForm())) return false;
		if (!(!hasDeliveryForm() && !msg.hasDeliveryForm()) && !(getDeliveryForm()==msg.getDeliveryForm())) return false;
		if ((hasPctAtRisk() && !msg.hasPctAtRisk()) || (!hasPctAtRisk() && msg.hasPctAtRisk())) return false;
		if (!(!hasPctAtRisk() && !msg.hasPctAtRisk()) && !(getPctAtRisk()==msg.getPctAtRisk())) return false;
		return true;
	}
	public FixInstrumentExtension clone ( FixInstrumentExtension out ) {
		if ( hasDeliveryForm())
			out.setDeliveryForm(getDeliveryForm());
		if ( hasPctAtRisk())
			out.setPctAtRisk(getPctAtRisk());
		int count = 0;
		count = 0;
		for (FixAttrbGrp fixAttrbGrp : attrbGrp) {
			if (!fixAttrbGrp.hasGroup()) continue;
			out.attrbGrp[count] = fixAttrbGrp.clone( out.attrbGrp[count] );
			count++;
		}
		return out;
	}

}
