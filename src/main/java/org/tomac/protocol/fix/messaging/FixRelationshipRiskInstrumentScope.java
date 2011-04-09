package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixRelationshipRiskInstrumentScope extends FixGroup {
	private short hasRelationshipRiskInstrumentOperator;
	long relationshipRiskInstrumentOperator = 0;		
	private short hasRelationshipRiskSymbol;
	byte[] relationshipRiskSymbol = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRelationshipRiskSymbolSfx;
	byte[] relationshipRiskSymbolSfx = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRelationshipRiskSecurityID;
	byte[] relationshipRiskSecurityID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRelationshipRiskSecurityIDSource;
	byte[] relationshipRiskSecurityIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRelationshipRiskProduct;
	long relationshipRiskProduct = 0;		
	private short hasRelationshipRiskProductComplex;
	byte[] relationshipRiskProductComplex = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRelationshipRiskSecurityGroup;
	byte[] relationshipRiskSecurityGroup = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRelationshipRiskCFICode;
	byte[] relationshipRiskCFICode = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRelationshipRiskSecurityType;
	byte[] relationshipRiskSecurityType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRelationshipRiskSecuritySubType;
	byte[] relationshipRiskSecuritySubType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRelationshipRiskMaturityMonthYear;
	byte[] relationshipRiskMaturityMonthYear = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRelationshipRiskMaturityTime;
	byte[] relationshipRiskMaturityTime = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRelationshipRiskRestructuringType;
	byte[] relationshipRiskRestructuringType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRelationshipRiskSeniority;
	byte[] relationshipRiskSeniority = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRelationshipRiskPutOrCall;
	long relationshipRiskPutOrCall = 0;		
	private short hasRelationshipRiskFlexibleIndicator;
		boolean relationshipRiskFlexibleIndicator = false;		
	private short hasRelationshipRiskCouponRate;
	long relationshipRiskCouponRate = 0;		
	private short hasRelationshipRiskSecurityExchange;
	byte[] relationshipRiskSecurityExchange = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRelationshipRiskSecurityDesc;
	byte[] relationshipRiskSecurityDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRelationshipRiskEncodedSecurityDescLen;
	long relationshipRiskEncodedSecurityDescLen = 0;		
	private short hasRelationshipRiskEncodedSecurityDesc;
	byte[] relationshipRiskEncodedSecurityDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRelationshipRiskInstrumentSettlType;
	byte[] relationshipRiskInstrumentSettlType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRelationshipRiskInstrumentMultiplier;
	long relationshipRiskInstrumentMultiplier = 0;		
		public FixRelationshipRiskSecAltIDGrp[] relationshipRiskSecAltIDGrp;
	
	public FixRelationshipRiskInstrumentScope() {
		this(false);
	}

	public FixRelationshipRiskInstrumentScope(boolean isRequired) {
		super(FixTags.RELATIONSHIPRISKINSTRUMENTOPERATOR_INT);

		this.isRequired = isRequired;
		
		hasRelationshipRiskInstrumentOperator = FixUtils.TAG_HAS_NO_VALUE;		
		hasRelationshipRiskSymbol = FixUtils.TAG_HAS_NO_VALUE;		
		relationshipRiskSymbol = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRelationshipRiskSymbolSfx = FixUtils.TAG_HAS_NO_VALUE;		
		relationshipRiskSymbolSfx = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRelationshipRiskSecurityID = FixUtils.TAG_HAS_NO_VALUE;		
		relationshipRiskSecurityID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRelationshipRiskSecurityIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		relationshipRiskSecurityIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRelationshipRiskProduct = FixUtils.TAG_HAS_NO_VALUE;		
		hasRelationshipRiskProductComplex = FixUtils.TAG_HAS_NO_VALUE;		
		relationshipRiskProductComplex = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRelationshipRiskSecurityGroup = FixUtils.TAG_HAS_NO_VALUE;		
		relationshipRiskSecurityGroup = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRelationshipRiskCFICode = FixUtils.TAG_HAS_NO_VALUE;		
		relationshipRiskCFICode = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRelationshipRiskSecurityType = FixUtils.TAG_HAS_NO_VALUE;		
		relationshipRiskSecurityType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRelationshipRiskSecuritySubType = FixUtils.TAG_HAS_NO_VALUE;		
		relationshipRiskSecuritySubType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRelationshipRiskMaturityMonthYear = FixUtils.TAG_HAS_NO_VALUE;		
		relationshipRiskMaturityMonthYear = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRelationshipRiskMaturityTime = FixUtils.TAG_HAS_NO_VALUE;		
		relationshipRiskMaturityTime = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRelationshipRiskRestructuringType = FixUtils.TAG_HAS_NO_VALUE;		
		relationshipRiskRestructuringType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRelationshipRiskSeniority = FixUtils.TAG_HAS_NO_VALUE;		
		relationshipRiskSeniority = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRelationshipRiskPutOrCall = FixUtils.TAG_HAS_NO_VALUE;		
		hasRelationshipRiskFlexibleIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasRelationshipRiskCouponRate = FixUtils.TAG_HAS_NO_VALUE;		
		hasRelationshipRiskSecurityExchange = FixUtils.TAG_HAS_NO_VALUE;		
		relationshipRiskSecurityExchange = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRelationshipRiskSecurityDesc = FixUtils.TAG_HAS_NO_VALUE;		
		relationshipRiskSecurityDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRelationshipRiskEncodedSecurityDescLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasRelationshipRiskEncodedSecurityDesc = FixUtils.TAG_HAS_NO_VALUE;		
		relationshipRiskEncodedSecurityDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRelationshipRiskInstrumentSettlType = FixUtils.TAG_HAS_NO_VALUE;		
		relationshipRiskInstrumentSettlType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRelationshipRiskInstrumentMultiplier = FixUtils.TAG_HAS_NO_VALUE;		
		relationshipRiskSecAltIDGrp = new FixRelationshipRiskSecAltIDGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) relationshipRiskSecAltIDGrp[i] = new FixRelationshipRiskSecAltIDGrp();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasRelationshipRiskInstrumentOperator()) return true;
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
            	case FixTags.RELATIONSHIPRISKINSTRUMENTOPERATOR_INT:		
            		hasRelationshipRiskInstrumentOperator = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATIONSHIPRISKSYMBOL_INT:		
            		hasRelationshipRiskSymbol = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATIONSHIPRISKSYMBOLSFX_INT:		
            		hasRelationshipRiskSymbolSfx = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATIONSHIPRISKSECURITYID_INT:		
            		hasRelationshipRiskSecurityID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATIONSHIPRISKSECURITYIDSOURCE_INT:		
            		hasRelationshipRiskSecurityIDSource = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATIONSHIPRISKPRODUCT_INT:		
            		hasRelationshipRiskProduct = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATIONSHIPRISKPRODUCTCOMPLEX_INT:		
            		hasRelationshipRiskProductComplex = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATIONSHIPRISKSECURITYGROUP_INT:		
            		hasRelationshipRiskSecurityGroup = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATIONSHIPRISKCFICODE_INT:		
            		hasRelationshipRiskCFICode = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATIONSHIPRISKSECURITYTYPE_INT:		
            		hasRelationshipRiskSecurityType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATIONSHIPRISKSECURITYSUBTYPE_INT:		
            		hasRelationshipRiskSecuritySubType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATIONSHIPRISKMATURITYMONTHYEAR_INT:		
            		hasRelationshipRiskMaturityMonthYear = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATIONSHIPRISKMATURITYTIME_INT:		
            		hasRelationshipRiskMaturityTime = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATIONSHIPRISKRESTRUCTURINGTYPE_INT:		
            		hasRelationshipRiskRestructuringType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATIONSHIPRISKSENIORITY_INT:		
            		hasRelationshipRiskSeniority = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATIONSHIPRISKPUTORCALL_INT:		
            		hasRelationshipRiskPutOrCall = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATIONSHIPRISKFLEXIBLEINDICATOR_INT:		
            		hasRelationshipRiskFlexibleIndicator = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATIONSHIPRISKCOUPONRATE_INT:		
            		hasRelationshipRiskCouponRate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATIONSHIPRISKSECURITYEXCHANGE_INT:		
            		hasRelationshipRiskSecurityExchange = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATIONSHIPRISKSECURITYDESC_INT:		
            		hasRelationshipRiskSecurityDesc = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATIONSHIPRISKENCODEDSECURITYDESCLEN_INT:		
            		hasRelationshipRiskEncodedSecurityDescLen = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATIONSHIPRISKENCODEDSECURITYDESC_INT:		
            		hasRelationshipRiskEncodedSecurityDesc = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATIONSHIPRISKINSTRUMENTSETTLTYPE_INT:		
            		hasRelationshipRiskInstrumentSettlType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	case FixTags.RELATIONSHIPRISKINSTRUMENTMULTIPLIER_INT:		
            		hasRelationshipRiskInstrumentMultiplier = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NORELATIONSHIPRISKSECURITYALTID_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !relationshipRiskSecAltIDGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NORELATIONSHIPRISKSECURITYALTID_INT);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = relationshipRiskSecAltIDGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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
		hasRelationshipRiskInstrumentOperator = FixUtils.TAG_HAS_NO_VALUE;
		hasRelationshipRiskSymbol = FixUtils.TAG_HAS_NO_VALUE;
		hasRelationshipRiskSymbolSfx = FixUtils.TAG_HAS_NO_VALUE;
		hasRelationshipRiskSecurityID = FixUtils.TAG_HAS_NO_VALUE;
		hasRelationshipRiskSecurityIDSource = FixUtils.TAG_HAS_NO_VALUE;
		hasRelationshipRiskProduct = FixUtils.TAG_HAS_NO_VALUE;
		hasRelationshipRiskProductComplex = FixUtils.TAG_HAS_NO_VALUE;
		hasRelationshipRiskSecurityGroup = FixUtils.TAG_HAS_NO_VALUE;
		hasRelationshipRiskCFICode = FixUtils.TAG_HAS_NO_VALUE;
		hasRelationshipRiskSecurityType = FixUtils.TAG_HAS_NO_VALUE;
		hasRelationshipRiskSecuritySubType = FixUtils.TAG_HAS_NO_VALUE;
		hasRelationshipRiskMaturityMonthYear = FixUtils.TAG_HAS_NO_VALUE;
		hasRelationshipRiskMaturityTime = FixUtils.TAG_HAS_NO_VALUE;
		hasRelationshipRiskRestructuringType = FixUtils.TAG_HAS_NO_VALUE;
		hasRelationshipRiskSeniority = FixUtils.TAG_HAS_NO_VALUE;
		hasRelationshipRiskPutOrCall = FixUtils.TAG_HAS_NO_VALUE;
		hasRelationshipRiskFlexibleIndicator = FixUtils.TAG_HAS_NO_VALUE;
		hasRelationshipRiskCouponRate = FixUtils.TAG_HAS_NO_VALUE;
		hasRelationshipRiskSecurityExchange = FixUtils.TAG_HAS_NO_VALUE;
		hasRelationshipRiskSecurityDesc = FixUtils.TAG_HAS_NO_VALUE;
		hasRelationshipRiskEncodedSecurityDescLen = FixUtils.TAG_HAS_NO_VALUE;
		hasRelationshipRiskEncodedSecurityDesc = FixUtils.TAG_HAS_NO_VALUE;
		hasRelationshipRiskInstrumentSettlType = FixUtils.TAG_HAS_NO_VALUE;
		hasRelationshipRiskInstrumentMultiplier = FixUtils.TAG_HAS_NO_VALUE;
		for (FixRelationshipRiskSecAltIDGrp fixRelationshipRiskSecAltIDGrp : relationshipRiskSecAltIDGrp) fixRelationshipRiskSecAltIDGrp.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasRelationshipRiskInstrumentOperator()) {		
			out.put(FixTags.RELATIONSHIPRISKINSTRUMENTOPERATOR);

			out.put((byte) '=');

			FixUtils.put(out, (long)relationshipRiskInstrumentOperator);
		
			out.put(FixUtils.SOH);

            }

		if (hasRelationshipRiskSymbol()) {		
			out.put(FixTags.RELATIONSHIPRISKSYMBOL);

			out.put((byte) '=');

			FixUtils.put(out,relationshipRiskSymbol); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRelationshipRiskSymbolSfx()) {		
			out.put(FixTags.RELATIONSHIPRISKSYMBOLSFX);

			out.put((byte) '=');

			FixUtils.put(out,relationshipRiskSymbolSfx); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRelationshipRiskSecurityID()) {		
			out.put(FixTags.RELATIONSHIPRISKSECURITYID);

			out.put((byte) '=');

			FixUtils.put(out,relationshipRiskSecurityID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRelationshipRiskSecurityIDSource()) {		
			out.put(FixTags.RELATIONSHIPRISKSECURITYIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,relationshipRiskSecurityIDSource); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRelationshipRiskProduct()) {		
			out.put(FixTags.RELATIONSHIPRISKPRODUCT);

			out.put((byte) '=');

			FixUtils.put(out, (long)relationshipRiskProduct);
		
			out.put(FixUtils.SOH);

            }

		if (hasRelationshipRiskProductComplex()) {		
			out.put(FixTags.RELATIONSHIPRISKPRODUCTCOMPLEX);

			out.put((byte) '=');

			FixUtils.put(out,relationshipRiskProductComplex); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRelationshipRiskSecurityGroup()) {		
			out.put(FixTags.RELATIONSHIPRISKSECURITYGROUP);

			out.put((byte) '=');

			FixUtils.put(out,relationshipRiskSecurityGroup); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRelationshipRiskCFICode()) {		
			out.put(FixTags.RELATIONSHIPRISKCFICODE);

			out.put((byte) '=');

			FixUtils.put(out,relationshipRiskCFICode); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRelationshipRiskSecurityType()) {		
			out.put(FixTags.RELATIONSHIPRISKSECURITYTYPE);

			out.put((byte) '=');

			FixUtils.put(out,relationshipRiskSecurityType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRelationshipRiskSecuritySubType()) {		
			out.put(FixTags.RELATIONSHIPRISKSECURITYSUBTYPE);

			out.put((byte) '=');

			FixUtils.put(out,relationshipRiskSecuritySubType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRelationshipRiskMaturityMonthYear()) {		
			out.put(FixTags.RELATIONSHIPRISKMATURITYMONTHYEAR);

			out.put((byte) '=');

			FixUtils.put(out,relationshipRiskMaturityMonthYear); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRelationshipRiskMaturityTime()) {		
			out.put(FixTags.RELATIONSHIPRISKMATURITYTIME);

			out.put((byte) '=');

			FixUtils.put(out,relationshipRiskMaturityTime); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRelationshipRiskRestructuringType()) {		
			out.put(FixTags.RELATIONSHIPRISKRESTRUCTURINGTYPE);

			out.put((byte) '=');

			FixUtils.put(out,relationshipRiskRestructuringType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRelationshipRiskSeniority()) {		
			out.put(FixTags.RELATIONSHIPRISKSENIORITY);

			out.put((byte) '=');

			FixUtils.put(out,relationshipRiskSeniority); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRelationshipRiskPutOrCall()) {		
			out.put(FixTags.RELATIONSHIPRISKPUTORCALL);

			out.put((byte) '=');

			FixUtils.put(out, (long)relationshipRiskPutOrCall);
		
			out.put(FixUtils.SOH);

            }

		if (hasRelationshipRiskFlexibleIndicator()) {		
			out.put(FixTags.RELATIONSHIPRISKFLEXIBLEINDICATOR);

			out.put((byte) '=');

			out.put(relationshipRiskFlexibleIndicator?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);

            }

		if (hasRelationshipRiskCouponRate()) {		
			out.put(FixTags.RELATIONSHIPRISKCOUPONRATE);

			out.put((byte) '=');

			FixUtils.put(out, (long)relationshipRiskCouponRate);
		
			out.put(FixUtils.SOH);

            }

		if (hasRelationshipRiskSecurityExchange()) {		
			out.put(FixTags.RELATIONSHIPRISKSECURITYEXCHANGE);

			out.put((byte) '=');

			FixUtils.put(out,relationshipRiskSecurityExchange); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRelationshipRiskSecurityDesc()) {		
			out.put(FixTags.RELATIONSHIPRISKSECURITYDESC);

			out.put((byte) '=');

			FixUtils.put(out,relationshipRiskSecurityDesc); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRelationshipRiskEncodedSecurityDescLen()) {		
			out.put(FixTags.RELATIONSHIPRISKENCODEDSECURITYDESCLEN);

			out.put((byte) '=');

			FixUtils.put(out, (long)relationshipRiskEncodedSecurityDescLen);
		
			out.put(FixUtils.SOH);

            }

		if (hasRelationshipRiskEncodedSecurityDesc()) {		
			out.put(FixTags.RELATIONSHIPRISKENCODEDSECURITYDESC);

			out.put((byte) '=');

			FixUtils.put(out,relationshipRiskEncodedSecurityDesc); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRelationshipRiskInstrumentSettlType()) {		
			out.put(FixTags.RELATIONSHIPRISKINSTRUMENTSETTLTYPE);

			out.put((byte) '=');

			FixUtils.put(out,relationshipRiskInstrumentSettlType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRelationshipRiskInstrumentMultiplier()) {		
			out.put(FixTags.RELATIONSHIPRISKINSTRUMENTMULTIPLIER);

			out.put((byte) '=');

			FixUtils.put(out, (long)relationshipRiskInstrumentMultiplier);
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(relationshipRiskSecAltIDGrp)>0) {
			out.put(FixTags.NORELATIONSHIPRISKSECURITYALTID);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(relationshipRiskSecAltIDGrp));

			out.put(FixUtils.SOH);

		}
		for (FixRelationshipRiskSecAltIDGrp fixRelationshipRiskSecAltIDGrp : relationshipRiskSecAltIDGrp) if (fixRelationshipRiskSecAltIDGrp.hasGroup()) fixRelationshipRiskSecAltIDGrp.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasRelationshipRiskInstrumentOperator()) {		
			FixUtils.put(out, (long)relationshipRiskInstrumentOperator);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelationshipRiskSymbol()) {		
			FixUtils.put(out,relationshipRiskSymbol); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelationshipRiskSymbolSfx()) {		
			FixUtils.put(out,relationshipRiskSymbolSfx); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelationshipRiskSecurityID()) {		
			FixUtils.put(out,relationshipRiskSecurityID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelationshipRiskSecurityIDSource()) {		
			FixUtils.put(out,relationshipRiskSecurityIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelationshipRiskProduct()) {		
			FixUtils.put(out, (long)relationshipRiskProduct);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelationshipRiskProductComplex()) {		
			FixUtils.put(out,relationshipRiskProductComplex); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelationshipRiskSecurityGroup()) {		
			FixUtils.put(out,relationshipRiskSecurityGroup); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelationshipRiskCFICode()) {		
			FixUtils.put(out,relationshipRiskCFICode); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelationshipRiskSecurityType()) {		
			FixUtils.put(out,relationshipRiskSecurityType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelationshipRiskSecuritySubType()) {		
			FixUtils.put(out,relationshipRiskSecuritySubType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelationshipRiskMaturityMonthYear()) {		
			FixUtils.put(out,relationshipRiskMaturityMonthYear); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelationshipRiskMaturityTime()) {		
			FixUtils.put(out,relationshipRiskMaturityTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelationshipRiskRestructuringType()) {		
			FixUtils.put(out,relationshipRiskRestructuringType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelationshipRiskSeniority()) {		
			FixUtils.put(out,relationshipRiskSeniority); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelationshipRiskPutOrCall()) {		
			FixUtils.put(out, (long)relationshipRiskPutOrCall);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelationshipRiskFlexibleIndicator()) {		
			out.put(relationshipRiskFlexibleIndicator?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelationshipRiskCouponRate()) {		
			FixUtils.put(out, (long)relationshipRiskCouponRate);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelationshipRiskSecurityExchange()) {		
			FixUtils.put(out,relationshipRiskSecurityExchange); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelationshipRiskSecurityDesc()) {		
			FixUtils.put(out,relationshipRiskSecurityDesc); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelationshipRiskEncodedSecurityDescLen()) {		
			FixUtils.put(out, (long)relationshipRiskEncodedSecurityDescLen);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelationshipRiskEncodedSecurityDesc()) {		
			FixUtils.put(out,relationshipRiskEncodedSecurityDesc); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelationshipRiskInstrumentSettlType()) {		
			FixUtils.put(out,relationshipRiskInstrumentSettlType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRelationshipRiskInstrumentMultiplier()) {		
			FixUtils.put(out, (long)relationshipRiskInstrumentMultiplier);
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixRelationshipRiskSecAltIDGrp fixRelationshipRiskSecAltIDGrp : relationshipRiskSecAltIDGrp) fixRelationshipRiskSecAltIDGrp.printBuffer(out);
	}

	public long getRelationshipRiskInstrumentOperator() { 		
		if ( hasRelationshipRiskInstrumentOperator()) {		
			if (hasRelationshipRiskInstrumentOperator == FixUtils.TAG_HAS_VALUE) {		
				return relationshipRiskInstrumentOperator; 		
			} else {		
		
				buf.position(hasRelationshipRiskInstrumentOperator);		
		
			relationshipRiskInstrumentOperator = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRelationshipRiskInstrumentOperator);		
					return 0;		
				}		
			}		
			hasRelationshipRiskInstrumentOperator = FixUtils.TAG_HAS_VALUE;		
			return relationshipRiskInstrumentOperator;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRelationshipRiskInstrumentOperator() { return hasRelationshipRiskInstrumentOperator != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelationshipRiskInstrumentOperator(long src) {		
		relationshipRiskInstrumentOperator = src;
		hasRelationshipRiskInstrumentOperator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRelationshipRiskInstrumentOperator(byte[] src) {		
		if (src == null ) return;
		if (hasRelationshipRiskInstrumentOperator()) relationshipRiskInstrumentOperator = FixUtils.TAG_HAS_NO_VALUE;		
		relationshipRiskInstrumentOperator = FixUtils.longValueOf(src, 0, src.length);
		hasRelationshipRiskInstrumentOperator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelationshipRiskInstrumentOperator(String str) {		
		if (str == null ) return;
		if (hasRelationshipRiskInstrumentOperator()) relationshipRiskInstrumentOperator = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		relationshipRiskInstrumentOperator = FixUtils.longValueOf(src, 0, src.length);
		hasRelationshipRiskInstrumentOperator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRelationshipRiskSymbol() { 		
		if ( hasRelationshipRiskSymbol()) {		
			if (hasRelationshipRiskSymbol == FixUtils.TAG_HAS_VALUE) {		
				return relationshipRiskSymbol; 		
			} else {		
		
				buf.position(hasRelationshipRiskSymbol);		
		
			FixUtils.getTagStringValue(buf, relationshipRiskSymbol, 0, relationshipRiskSymbol.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRelationshipRiskSymbol);		
					return null;		
				}		
			}		
			hasRelationshipRiskSymbol = FixUtils.TAG_HAS_VALUE;		
			return relationshipRiskSymbol;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRelationshipRiskSymbol() { return hasRelationshipRiskSymbol != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelationshipRiskSymbol(byte[] src) {		
		if (src == null ) return;
		if (hasRelationshipRiskSymbol()) FixUtils.fillNul(relationshipRiskSymbol);		
		FixUtils.copy(relationshipRiskSymbol, src); 		
		hasRelationshipRiskSymbol = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelationshipRiskSymbol(String str) {		
		if (str == null ) return;
		if (hasRelationshipRiskSymbol()) FixUtils.fillNul(relationshipRiskSymbol);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(relationshipRiskSymbol, src); 		
		hasRelationshipRiskSymbol = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRelationshipRiskSymbolSfx() { 		
		if ( hasRelationshipRiskSymbolSfx()) {		
			if (hasRelationshipRiskSymbolSfx == FixUtils.TAG_HAS_VALUE) {		
				return relationshipRiskSymbolSfx; 		
			} else {		
		
				buf.position(hasRelationshipRiskSymbolSfx);		
		
			FixUtils.getTagStringValue(buf, relationshipRiskSymbolSfx, 0, relationshipRiskSymbolSfx.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRelationshipRiskSymbolSfx);		
					return null;		
				}		
			}		
			hasRelationshipRiskSymbolSfx = FixUtils.TAG_HAS_VALUE;		
			return relationshipRiskSymbolSfx;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRelationshipRiskSymbolSfx() { return hasRelationshipRiskSymbolSfx != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelationshipRiskSymbolSfx(byte[] src) {		
		if (src == null ) return;
		if (hasRelationshipRiskSymbolSfx()) FixUtils.fillNul(relationshipRiskSymbolSfx);		
		FixUtils.copy(relationshipRiskSymbolSfx, src); 		
		hasRelationshipRiskSymbolSfx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelationshipRiskSymbolSfx(String str) {		
		if (str == null ) return;
		if (hasRelationshipRiskSymbolSfx()) FixUtils.fillNul(relationshipRiskSymbolSfx);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(relationshipRiskSymbolSfx, src); 		
		hasRelationshipRiskSymbolSfx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRelationshipRiskSecurityID() { 		
		if ( hasRelationshipRiskSecurityID()) {		
			if (hasRelationshipRiskSecurityID == FixUtils.TAG_HAS_VALUE) {		
				return relationshipRiskSecurityID; 		
			} else {		
		
				buf.position(hasRelationshipRiskSecurityID);		
		
			FixUtils.getTagStringValue(buf, relationshipRiskSecurityID, 0, relationshipRiskSecurityID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRelationshipRiskSecurityID);		
					return null;		
				}		
			}		
			hasRelationshipRiskSecurityID = FixUtils.TAG_HAS_VALUE;		
			return relationshipRiskSecurityID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRelationshipRiskSecurityID() { return hasRelationshipRiskSecurityID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelationshipRiskSecurityID(byte[] src) {		
		if (src == null ) return;
		if (hasRelationshipRiskSecurityID()) FixUtils.fillNul(relationshipRiskSecurityID);		
		FixUtils.copy(relationshipRiskSecurityID, src); 		
		hasRelationshipRiskSecurityID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelationshipRiskSecurityID(String str) {		
		if (str == null ) return;
		if (hasRelationshipRiskSecurityID()) FixUtils.fillNul(relationshipRiskSecurityID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(relationshipRiskSecurityID, src); 		
		hasRelationshipRiskSecurityID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRelationshipRiskSecurityIDSource() { 		
		if ( hasRelationshipRiskSecurityIDSource()) {		
			if (hasRelationshipRiskSecurityIDSource == FixUtils.TAG_HAS_VALUE) {		
				return relationshipRiskSecurityIDSource; 		
			} else {		
		
				buf.position(hasRelationshipRiskSecurityIDSource);		
		
			FixUtils.getTagStringValue(buf, relationshipRiskSecurityIDSource, 0, relationshipRiskSecurityIDSource.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRelationshipRiskSecurityIDSource);		
					return null;		
				}		
			}		
			hasRelationshipRiskSecurityIDSource = FixUtils.TAG_HAS_VALUE;		
			return relationshipRiskSecurityIDSource;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRelationshipRiskSecurityIDSource() { return hasRelationshipRiskSecurityIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelationshipRiskSecurityIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasRelationshipRiskSecurityIDSource()) FixUtils.fillNul(relationshipRiskSecurityIDSource);		
		FixUtils.copy(relationshipRiskSecurityIDSource, src); 		
		hasRelationshipRiskSecurityIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelationshipRiskSecurityIDSource(String str) {		
		if (str == null ) return;
		if (hasRelationshipRiskSecurityIDSource()) FixUtils.fillNul(relationshipRiskSecurityIDSource);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(relationshipRiskSecurityIDSource, src); 		
		hasRelationshipRiskSecurityIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getRelationshipRiskProduct() { 		
		if ( hasRelationshipRiskProduct()) {		
			if (hasRelationshipRiskProduct == FixUtils.TAG_HAS_VALUE) {		
				return relationshipRiskProduct; 		
			} else {		
		
				buf.position(hasRelationshipRiskProduct);		
		
			relationshipRiskProduct = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRelationshipRiskProduct);		
					return 0;		
				}		
			}		
			hasRelationshipRiskProduct = FixUtils.TAG_HAS_VALUE;		
			return relationshipRiskProduct;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRelationshipRiskProduct() { return hasRelationshipRiskProduct != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelationshipRiskProduct(long src) {		
		relationshipRiskProduct = src;
		hasRelationshipRiskProduct = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRelationshipRiskProduct(byte[] src) {		
		if (src == null ) return;
		if (hasRelationshipRiskProduct()) relationshipRiskProduct = FixUtils.TAG_HAS_NO_VALUE;		
		relationshipRiskProduct = FixUtils.longValueOf(src, 0, src.length);
		hasRelationshipRiskProduct = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelationshipRiskProduct(String str) {		
		if (str == null ) return;
		if (hasRelationshipRiskProduct()) relationshipRiskProduct = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		relationshipRiskProduct = FixUtils.longValueOf(src, 0, src.length);
		hasRelationshipRiskProduct = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRelationshipRiskProductComplex() { 		
		if ( hasRelationshipRiskProductComplex()) {		
			if (hasRelationshipRiskProductComplex == FixUtils.TAG_HAS_VALUE) {		
				return relationshipRiskProductComplex; 		
			} else {		
		
				buf.position(hasRelationshipRiskProductComplex);		
		
			FixUtils.getTagStringValue(buf, relationshipRiskProductComplex, 0, relationshipRiskProductComplex.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRelationshipRiskProductComplex);		
					return null;		
				}		
			}		
			hasRelationshipRiskProductComplex = FixUtils.TAG_HAS_VALUE;		
			return relationshipRiskProductComplex;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRelationshipRiskProductComplex() { return hasRelationshipRiskProductComplex != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelationshipRiskProductComplex(byte[] src) {		
		if (src == null ) return;
		if (hasRelationshipRiskProductComplex()) FixUtils.fillNul(relationshipRiskProductComplex);		
		FixUtils.copy(relationshipRiskProductComplex, src); 		
		hasRelationshipRiskProductComplex = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelationshipRiskProductComplex(String str) {		
		if (str == null ) return;
		if (hasRelationshipRiskProductComplex()) FixUtils.fillNul(relationshipRiskProductComplex);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(relationshipRiskProductComplex, src); 		
		hasRelationshipRiskProductComplex = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRelationshipRiskSecurityGroup() { 		
		if ( hasRelationshipRiskSecurityGroup()) {		
			if (hasRelationshipRiskSecurityGroup == FixUtils.TAG_HAS_VALUE) {		
				return relationshipRiskSecurityGroup; 		
			} else {		
		
				buf.position(hasRelationshipRiskSecurityGroup);		
		
			FixUtils.getTagStringValue(buf, relationshipRiskSecurityGroup, 0, relationshipRiskSecurityGroup.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRelationshipRiskSecurityGroup);		
					return null;		
				}		
			}		
			hasRelationshipRiskSecurityGroup = FixUtils.TAG_HAS_VALUE;		
			return relationshipRiskSecurityGroup;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRelationshipRiskSecurityGroup() { return hasRelationshipRiskSecurityGroup != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelationshipRiskSecurityGroup(byte[] src) {		
		if (src == null ) return;
		if (hasRelationshipRiskSecurityGroup()) FixUtils.fillNul(relationshipRiskSecurityGroup);		
		FixUtils.copy(relationshipRiskSecurityGroup, src); 		
		hasRelationshipRiskSecurityGroup = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelationshipRiskSecurityGroup(String str) {		
		if (str == null ) return;
		if (hasRelationshipRiskSecurityGroup()) FixUtils.fillNul(relationshipRiskSecurityGroup);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(relationshipRiskSecurityGroup, src); 		
		hasRelationshipRiskSecurityGroup = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRelationshipRiskCFICode() { 		
		if ( hasRelationshipRiskCFICode()) {		
			if (hasRelationshipRiskCFICode == FixUtils.TAG_HAS_VALUE) {		
				return relationshipRiskCFICode; 		
			} else {		
		
				buf.position(hasRelationshipRiskCFICode);		
		
			FixUtils.getTagStringValue(buf, relationshipRiskCFICode, 0, relationshipRiskCFICode.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRelationshipRiskCFICode);		
					return null;		
				}		
			}		
			hasRelationshipRiskCFICode = FixUtils.TAG_HAS_VALUE;		
			return relationshipRiskCFICode;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRelationshipRiskCFICode() { return hasRelationshipRiskCFICode != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelationshipRiskCFICode(byte[] src) {		
		if (src == null ) return;
		if (hasRelationshipRiskCFICode()) FixUtils.fillNul(relationshipRiskCFICode);		
		FixUtils.copy(relationshipRiskCFICode, src); 		
		hasRelationshipRiskCFICode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelationshipRiskCFICode(String str) {		
		if (str == null ) return;
		if (hasRelationshipRiskCFICode()) FixUtils.fillNul(relationshipRiskCFICode);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(relationshipRiskCFICode, src); 		
		hasRelationshipRiskCFICode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRelationshipRiskSecurityType() { 		
		if ( hasRelationshipRiskSecurityType()) {		
			if (hasRelationshipRiskSecurityType == FixUtils.TAG_HAS_VALUE) {		
				return relationshipRiskSecurityType; 		
			} else {		
		
				buf.position(hasRelationshipRiskSecurityType);		
		
			FixUtils.getTagStringValue(buf, relationshipRiskSecurityType, 0, relationshipRiskSecurityType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRelationshipRiskSecurityType);		
					return null;		
				}		
			}		
			hasRelationshipRiskSecurityType = FixUtils.TAG_HAS_VALUE;		
			return relationshipRiskSecurityType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRelationshipRiskSecurityType() { return hasRelationshipRiskSecurityType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelationshipRiskSecurityType(byte[] src) {		
		if (src == null ) return;
		if (hasRelationshipRiskSecurityType()) FixUtils.fillNul(relationshipRiskSecurityType);		
		FixUtils.copy(relationshipRiskSecurityType, src); 		
		hasRelationshipRiskSecurityType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelationshipRiskSecurityType(String str) {		
		if (str == null ) return;
		if (hasRelationshipRiskSecurityType()) FixUtils.fillNul(relationshipRiskSecurityType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(relationshipRiskSecurityType, src); 		
		hasRelationshipRiskSecurityType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRelationshipRiskSecuritySubType() { 		
		if ( hasRelationshipRiskSecuritySubType()) {		
			if (hasRelationshipRiskSecuritySubType == FixUtils.TAG_HAS_VALUE) {		
				return relationshipRiskSecuritySubType; 		
			} else {		
		
				buf.position(hasRelationshipRiskSecuritySubType);		
		
			FixUtils.getTagStringValue(buf, relationshipRiskSecuritySubType, 0, relationshipRiskSecuritySubType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRelationshipRiskSecuritySubType);		
					return null;		
				}		
			}		
			hasRelationshipRiskSecuritySubType = FixUtils.TAG_HAS_VALUE;		
			return relationshipRiskSecuritySubType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRelationshipRiskSecuritySubType() { return hasRelationshipRiskSecuritySubType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelationshipRiskSecuritySubType(byte[] src) {		
		if (src == null ) return;
		if (hasRelationshipRiskSecuritySubType()) FixUtils.fillNul(relationshipRiskSecuritySubType);		
		FixUtils.copy(relationshipRiskSecuritySubType, src); 		
		hasRelationshipRiskSecuritySubType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelationshipRiskSecuritySubType(String str) {		
		if (str == null ) return;
		if (hasRelationshipRiskSecuritySubType()) FixUtils.fillNul(relationshipRiskSecuritySubType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(relationshipRiskSecuritySubType, src); 		
		hasRelationshipRiskSecuritySubType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRelationshipRiskMaturityMonthYear() { 		
		if ( hasRelationshipRiskMaturityMonthYear()) {		
			if (hasRelationshipRiskMaturityMonthYear == FixUtils.TAG_HAS_VALUE) {		
				return relationshipRiskMaturityMonthYear; 		
			} else {		
		
				buf.position(hasRelationshipRiskMaturityMonthYear);		
		
			FixUtils.getTagStringValue(buf, relationshipRiskMaturityMonthYear, 0, relationshipRiskMaturityMonthYear.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRelationshipRiskMaturityMonthYear);		
					return null;		
				}		
			}		
			hasRelationshipRiskMaturityMonthYear = FixUtils.TAG_HAS_VALUE;		
			return relationshipRiskMaturityMonthYear;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRelationshipRiskMaturityMonthYear() { return hasRelationshipRiskMaturityMonthYear != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelationshipRiskMaturityMonthYear(byte[] src) {		
		if (src == null ) return;
		if (hasRelationshipRiskMaturityMonthYear()) FixUtils.fillNul(relationshipRiskMaturityMonthYear);		
		FixUtils.copy(relationshipRiskMaturityMonthYear, src); 		
		hasRelationshipRiskMaturityMonthYear = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelationshipRiskMaturityMonthYear(String str) {		
		if (str == null ) return;
		if (hasRelationshipRiskMaturityMonthYear()) FixUtils.fillNul(relationshipRiskMaturityMonthYear);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(relationshipRiskMaturityMonthYear, src); 		
		hasRelationshipRiskMaturityMonthYear = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRelationshipRiskMaturityTime() { 		
		if ( hasRelationshipRiskMaturityTime()) {		
			if (hasRelationshipRiskMaturityTime == FixUtils.TAG_HAS_VALUE) {		
				return relationshipRiskMaturityTime; 		
			} else {		
		
				buf.position(hasRelationshipRiskMaturityTime);		
		
			FixUtils.getTagStringValue(buf, relationshipRiskMaturityTime, 0, relationshipRiskMaturityTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRelationshipRiskMaturityTime);		
					return null;		
				}		
			}		
			hasRelationshipRiskMaturityTime = FixUtils.TAG_HAS_VALUE;		
			return relationshipRiskMaturityTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRelationshipRiskMaturityTime() { return hasRelationshipRiskMaturityTime != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelationshipRiskMaturityTime(byte[] src) {		
		if (src == null ) return;
		if (hasRelationshipRiskMaturityTime()) FixUtils.fillNul(relationshipRiskMaturityTime);		
		FixUtils.copy(relationshipRiskMaturityTime, src); 		
		hasRelationshipRiskMaturityTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelationshipRiskMaturityTime(String str) {		
		if (str == null ) return;
		if (hasRelationshipRiskMaturityTime()) FixUtils.fillNul(relationshipRiskMaturityTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(relationshipRiskMaturityTime, src); 		
		hasRelationshipRiskMaturityTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRelationshipRiskRestructuringType() { 		
		if ( hasRelationshipRiskRestructuringType()) {		
			if (hasRelationshipRiskRestructuringType == FixUtils.TAG_HAS_VALUE) {		
				return relationshipRiskRestructuringType; 		
			} else {		
		
				buf.position(hasRelationshipRiskRestructuringType);		
		
			FixUtils.getTagStringValue(buf, relationshipRiskRestructuringType, 0, relationshipRiskRestructuringType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRelationshipRiskRestructuringType);		
					return null;		
				}		
			}		
			hasRelationshipRiskRestructuringType = FixUtils.TAG_HAS_VALUE;		
			return relationshipRiskRestructuringType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRelationshipRiskRestructuringType() { return hasRelationshipRiskRestructuringType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelationshipRiskRestructuringType(byte[] src) {		
		if (src == null ) return;
		if (hasRelationshipRiskRestructuringType()) FixUtils.fillNul(relationshipRiskRestructuringType);		
		FixUtils.copy(relationshipRiskRestructuringType, src); 		
		hasRelationshipRiskRestructuringType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelationshipRiskRestructuringType(String str) {		
		if (str == null ) return;
		if (hasRelationshipRiskRestructuringType()) FixUtils.fillNul(relationshipRiskRestructuringType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(relationshipRiskRestructuringType, src); 		
		hasRelationshipRiskRestructuringType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRelationshipRiskSeniority() { 		
		if ( hasRelationshipRiskSeniority()) {		
			if (hasRelationshipRiskSeniority == FixUtils.TAG_HAS_VALUE) {		
				return relationshipRiskSeniority; 		
			} else {		
		
				buf.position(hasRelationshipRiskSeniority);		
		
			FixUtils.getTagStringValue(buf, relationshipRiskSeniority, 0, relationshipRiskSeniority.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRelationshipRiskSeniority);		
					return null;		
				}		
			}		
			hasRelationshipRiskSeniority = FixUtils.TAG_HAS_VALUE;		
			return relationshipRiskSeniority;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRelationshipRiskSeniority() { return hasRelationshipRiskSeniority != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelationshipRiskSeniority(byte[] src) {		
		if (src == null ) return;
		if (hasRelationshipRiskSeniority()) FixUtils.fillNul(relationshipRiskSeniority);		
		FixUtils.copy(relationshipRiskSeniority, src); 		
		hasRelationshipRiskSeniority = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelationshipRiskSeniority(String str) {		
		if (str == null ) return;
		if (hasRelationshipRiskSeniority()) FixUtils.fillNul(relationshipRiskSeniority);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(relationshipRiskSeniority, src); 		
		hasRelationshipRiskSeniority = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getRelationshipRiskPutOrCall() { 		
		if ( hasRelationshipRiskPutOrCall()) {		
			if (hasRelationshipRiskPutOrCall == FixUtils.TAG_HAS_VALUE) {		
				return relationshipRiskPutOrCall; 		
			} else {		
		
				buf.position(hasRelationshipRiskPutOrCall);		
		
			relationshipRiskPutOrCall = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRelationshipRiskPutOrCall);		
					return 0;		
				}		
			}		
			hasRelationshipRiskPutOrCall = FixUtils.TAG_HAS_VALUE;		
			return relationshipRiskPutOrCall;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRelationshipRiskPutOrCall() { return hasRelationshipRiskPutOrCall != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelationshipRiskPutOrCall(long src) {		
		relationshipRiskPutOrCall = src;
		hasRelationshipRiskPutOrCall = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRelationshipRiskPutOrCall(byte[] src) {		
		if (src == null ) return;
		if (hasRelationshipRiskPutOrCall()) relationshipRiskPutOrCall = FixUtils.TAG_HAS_NO_VALUE;		
		relationshipRiskPutOrCall = FixUtils.longValueOf(src, 0, src.length);
		hasRelationshipRiskPutOrCall = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelationshipRiskPutOrCall(String str) {		
		if (str == null ) return;
		if (hasRelationshipRiskPutOrCall()) relationshipRiskPutOrCall = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		relationshipRiskPutOrCall = FixUtils.longValueOf(src, 0, src.length);
		hasRelationshipRiskPutOrCall = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public boolean getRelationshipRiskFlexibleIndicator() { 		
		if ( hasRelationshipRiskFlexibleIndicator()) {		
			if (hasRelationshipRiskFlexibleIndicator == FixUtils.TAG_HAS_VALUE) {		
				return relationshipRiskFlexibleIndicator; 		
			} else {		
		
				buf.position(hasRelationshipRiskFlexibleIndicator);		
		
			relationshipRiskFlexibleIndicator = FixUtils.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(hasRelationshipRiskFlexibleIndicator);		
					return false;		
				}		
			}		
			hasRelationshipRiskFlexibleIndicator = FixUtils.TAG_HAS_VALUE;		
			return relationshipRiskFlexibleIndicator;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasRelationshipRiskFlexibleIndicator() { return hasRelationshipRiskFlexibleIndicator != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelationshipRiskFlexibleIndicator(boolean src) {		
		relationshipRiskFlexibleIndicator = src;
		hasRelationshipRiskFlexibleIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRelationshipRiskFlexibleIndicator(byte[] src) {		
		if (src == null ) return;
		if (hasRelationshipRiskFlexibleIndicator()) relationshipRiskFlexibleIndicator = false;		
		relationshipRiskFlexibleIndicator = src[0]==(byte)'Y'?true:false;		
		hasRelationshipRiskFlexibleIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelationshipRiskFlexibleIndicator(String str) {		
		if (str == null ) return;
		if (hasRelationshipRiskFlexibleIndicator()) relationshipRiskFlexibleIndicator = false;		
		byte[] src = str.getBytes(); 		
		relationshipRiskFlexibleIndicator = src[0]==(byte)'Y'?true:false;		
		hasRelationshipRiskFlexibleIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getRelationshipRiskCouponRate() { 		
		if ( hasRelationshipRiskCouponRate()) {		
			if (hasRelationshipRiskCouponRate == FixUtils.TAG_HAS_VALUE) {		
				return relationshipRiskCouponRate; 		
			} else {		
		
				buf.position(hasRelationshipRiskCouponRate);		
		
			relationshipRiskCouponRate = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRelationshipRiskCouponRate);		
					return 0;		
				}		
			}		
			hasRelationshipRiskCouponRate = FixUtils.TAG_HAS_VALUE;		
			return relationshipRiskCouponRate;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRelationshipRiskCouponRate() { return hasRelationshipRiskCouponRate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelationshipRiskCouponRate(long src) {		
		relationshipRiskCouponRate = src;
		hasRelationshipRiskCouponRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRelationshipRiskCouponRate(byte[] src) {		
		if (src == null ) return;
		if (hasRelationshipRiskCouponRate()) relationshipRiskCouponRate = FixUtils.TAG_HAS_NO_VALUE;		
		relationshipRiskCouponRate = FixUtils.longValueOf(src, 0, src.length);
		hasRelationshipRiskCouponRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelationshipRiskCouponRate(String str) {		
		if (str == null ) return;
		if (hasRelationshipRiskCouponRate()) relationshipRiskCouponRate = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		relationshipRiskCouponRate = FixUtils.longValueOf(src, 0, src.length);
		hasRelationshipRiskCouponRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRelationshipRiskSecurityExchange() { 		
		if ( hasRelationshipRiskSecurityExchange()) {		
			if (hasRelationshipRiskSecurityExchange == FixUtils.TAG_HAS_VALUE) {		
				return relationshipRiskSecurityExchange; 		
			} else {		
		
				buf.position(hasRelationshipRiskSecurityExchange);		
		
			FixUtils.getTagStringValue(buf, relationshipRiskSecurityExchange, 0, relationshipRiskSecurityExchange.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRelationshipRiskSecurityExchange);		
					return null;		
				}		
			}		
			hasRelationshipRiskSecurityExchange = FixUtils.TAG_HAS_VALUE;		
			return relationshipRiskSecurityExchange;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRelationshipRiskSecurityExchange() { return hasRelationshipRiskSecurityExchange != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelationshipRiskSecurityExchange(byte[] src) {		
		if (src == null ) return;
		if (hasRelationshipRiskSecurityExchange()) FixUtils.fillNul(relationshipRiskSecurityExchange);		
		FixUtils.copy(relationshipRiskSecurityExchange, src); 		
		hasRelationshipRiskSecurityExchange = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelationshipRiskSecurityExchange(String str) {		
		if (str == null ) return;
		if (hasRelationshipRiskSecurityExchange()) FixUtils.fillNul(relationshipRiskSecurityExchange);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(relationshipRiskSecurityExchange, src); 		
		hasRelationshipRiskSecurityExchange = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRelationshipRiskSecurityDesc() { 		
		if ( hasRelationshipRiskSecurityDesc()) {		
			if (hasRelationshipRiskSecurityDesc == FixUtils.TAG_HAS_VALUE) {		
				return relationshipRiskSecurityDesc; 		
			} else {		
		
				buf.position(hasRelationshipRiskSecurityDesc);		
		
			FixUtils.getTagStringValue(buf, relationshipRiskSecurityDesc, 0, relationshipRiskSecurityDesc.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRelationshipRiskSecurityDesc);		
					return null;		
				}		
			}		
			hasRelationshipRiskSecurityDesc = FixUtils.TAG_HAS_VALUE;		
			return relationshipRiskSecurityDesc;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRelationshipRiskSecurityDesc() { return hasRelationshipRiskSecurityDesc != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelationshipRiskSecurityDesc(byte[] src) {		
		if (src == null ) return;
		if (hasRelationshipRiskSecurityDesc()) FixUtils.fillNul(relationshipRiskSecurityDesc);		
		FixUtils.copy(relationshipRiskSecurityDesc, src); 		
		hasRelationshipRiskSecurityDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelationshipRiskSecurityDesc(String str) {		
		if (str == null ) return;
		if (hasRelationshipRiskSecurityDesc()) FixUtils.fillNul(relationshipRiskSecurityDesc);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(relationshipRiskSecurityDesc, src); 		
		hasRelationshipRiskSecurityDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getRelationshipRiskEncodedSecurityDescLen() { 		
		if ( hasRelationshipRiskEncodedSecurityDescLen()) {		
			if (hasRelationshipRiskEncodedSecurityDescLen == FixUtils.TAG_HAS_VALUE) {		
				return relationshipRiskEncodedSecurityDescLen; 		
			} else {		
		
				buf.position(hasRelationshipRiskEncodedSecurityDescLen);		
		
			relationshipRiskEncodedSecurityDescLen = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRelationshipRiskEncodedSecurityDescLen);		
					return 0;		
				}		
			}		
			hasRelationshipRiskEncodedSecurityDescLen = FixUtils.TAG_HAS_VALUE;		
			return relationshipRiskEncodedSecurityDescLen;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRelationshipRiskEncodedSecurityDescLen() { return hasRelationshipRiskEncodedSecurityDescLen != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelationshipRiskEncodedSecurityDescLen(long src) {		
		relationshipRiskEncodedSecurityDescLen = src;
		hasRelationshipRiskEncodedSecurityDescLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRelationshipRiskEncodedSecurityDescLen(byte[] src) {		
		if (src == null ) return;
		if (hasRelationshipRiskEncodedSecurityDescLen()) relationshipRiskEncodedSecurityDescLen = FixUtils.TAG_HAS_NO_VALUE;		
		relationshipRiskEncodedSecurityDescLen = FixUtils.longValueOf(src, 0, src.length);
		hasRelationshipRiskEncodedSecurityDescLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelationshipRiskEncodedSecurityDescLen(String str) {		
		if (str == null ) return;
		if (hasRelationshipRiskEncodedSecurityDescLen()) relationshipRiskEncodedSecurityDescLen = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		relationshipRiskEncodedSecurityDescLen = FixUtils.longValueOf(src, 0, src.length);
		hasRelationshipRiskEncodedSecurityDescLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRelationshipRiskEncodedSecurityDesc() { 		
		if ( hasRelationshipRiskEncodedSecurityDesc()) {		
			if (hasRelationshipRiskEncodedSecurityDesc == FixUtils.TAG_HAS_VALUE) {		
				return relationshipRiskEncodedSecurityDesc; 		
			} else {		
		
				buf.position(hasRelationshipRiskEncodedSecurityDesc);		
		
			FixUtils.getTagStringValue(buf, relationshipRiskEncodedSecurityDesc, 0, relationshipRiskEncodedSecurityDesc.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRelationshipRiskEncodedSecurityDesc);		
					return null;		
				}		
			}		
			hasRelationshipRiskEncodedSecurityDesc = FixUtils.TAG_HAS_VALUE;		
			return relationshipRiskEncodedSecurityDesc;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRelationshipRiskEncodedSecurityDesc() { return hasRelationshipRiskEncodedSecurityDesc != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelationshipRiskEncodedSecurityDesc(byte[] src) {		
		if (src == null ) return;
		if (hasRelationshipRiskEncodedSecurityDesc()) FixUtils.fillNul(relationshipRiskEncodedSecurityDesc);		
		FixUtils.copy(relationshipRiskEncodedSecurityDesc, src); 		
		hasRelationshipRiskEncodedSecurityDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelationshipRiskEncodedSecurityDesc(String str) {		
		if (str == null ) return;
		if (hasRelationshipRiskEncodedSecurityDesc()) FixUtils.fillNul(relationshipRiskEncodedSecurityDesc);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(relationshipRiskEncodedSecurityDesc, src); 		
		hasRelationshipRiskEncodedSecurityDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRelationshipRiskInstrumentSettlType() { 		
		if ( hasRelationshipRiskInstrumentSettlType()) {		
			if (hasRelationshipRiskInstrumentSettlType == FixUtils.TAG_HAS_VALUE) {		
				return relationshipRiskInstrumentSettlType; 		
			} else {		
		
				buf.position(hasRelationshipRiskInstrumentSettlType);		
		
			FixUtils.getTagStringValue(buf, relationshipRiskInstrumentSettlType, 0, relationshipRiskInstrumentSettlType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRelationshipRiskInstrumentSettlType);		
					return null;		
				}		
			}		
			hasRelationshipRiskInstrumentSettlType = FixUtils.TAG_HAS_VALUE;		
			return relationshipRiskInstrumentSettlType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRelationshipRiskInstrumentSettlType() { return hasRelationshipRiskInstrumentSettlType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelationshipRiskInstrumentSettlType(byte[] src) {		
		if (src == null ) return;
		if (hasRelationshipRiskInstrumentSettlType()) FixUtils.fillNul(relationshipRiskInstrumentSettlType);		
		FixUtils.copy(relationshipRiskInstrumentSettlType, src); 		
		hasRelationshipRiskInstrumentSettlType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelationshipRiskInstrumentSettlType(String str) {		
		if (str == null ) return;
		if (hasRelationshipRiskInstrumentSettlType()) FixUtils.fillNul(relationshipRiskInstrumentSettlType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(relationshipRiskInstrumentSettlType, src); 		
		hasRelationshipRiskInstrumentSettlType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getRelationshipRiskInstrumentMultiplier() { 		
		if ( hasRelationshipRiskInstrumentMultiplier()) {		
			if (hasRelationshipRiskInstrumentMultiplier == FixUtils.TAG_HAS_VALUE) {		
				return relationshipRiskInstrumentMultiplier; 		
			} else {		
		
				buf.position(hasRelationshipRiskInstrumentMultiplier);		
		
			relationshipRiskInstrumentMultiplier = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRelationshipRiskInstrumentMultiplier);		
					return 0;		
				}		
			}		
			hasRelationshipRiskInstrumentMultiplier = FixUtils.TAG_HAS_VALUE;		
			return relationshipRiskInstrumentMultiplier;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRelationshipRiskInstrumentMultiplier() { return hasRelationshipRiskInstrumentMultiplier != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRelationshipRiskInstrumentMultiplier(long src) {		
		relationshipRiskInstrumentMultiplier = src;
		hasRelationshipRiskInstrumentMultiplier = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRelationshipRiskInstrumentMultiplier(byte[] src) {		
		if (src == null ) return;
		if (hasRelationshipRiskInstrumentMultiplier()) relationshipRiskInstrumentMultiplier = FixUtils.TAG_HAS_NO_VALUE;		
		relationshipRiskInstrumentMultiplier = FixUtils.longValueOf(src, 0, src.length);
		hasRelationshipRiskInstrumentMultiplier = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRelationshipRiskInstrumentMultiplier(String str) {		
		if (str == null ) return;
		if (hasRelationshipRiskInstrumentMultiplier()) relationshipRiskInstrumentMultiplier = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		relationshipRiskInstrumentMultiplier = FixUtils.longValueOf(src, 0, src.length);
		hasRelationshipRiskInstrumentMultiplier = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasRelationshipRiskInstrumentOperator()) s += "RelationshipRiskInstrumentOperator(1588)= " + getRelationshipRiskInstrumentOperator() + "\n" ; 
		if (hasRelationshipRiskSymbol()) s += "RelationshipRiskSymbol(1589)= " + new String( FixUtils.trim(getRelationshipRiskSymbol()) ) + "\n" ; 
		if (hasRelationshipRiskSymbolSfx()) s += "RelationshipRiskSymbolSfx(1590)= " + new String( FixUtils.trim(getRelationshipRiskSymbolSfx()) ) + "\n" ; 
		if (hasRelationshipRiskSecurityID()) s += "RelationshipRiskSecurityID(1591)= " + new String( FixUtils.trim(getRelationshipRiskSecurityID()) ) + "\n" ; 
		if (hasRelationshipRiskSecurityIDSource()) s += "RelationshipRiskSecurityIDSource(1592)= " + new String( FixUtils.trim(getRelationshipRiskSecurityIDSource()) ) + "\n" ; 
		if (hasRelationshipRiskProduct()) s += "RelationshipRiskProduct(1596)= " + getRelationshipRiskProduct() + "\n" ; 
		if (hasRelationshipRiskProductComplex()) s += "RelationshipRiskProductComplex(1597)= " + new String( FixUtils.trim(getRelationshipRiskProductComplex()) ) + "\n" ; 
		if (hasRelationshipRiskSecurityGroup()) s += "RelationshipRiskSecurityGroup(1598)= " + new String( FixUtils.trim(getRelationshipRiskSecurityGroup()) ) + "\n" ; 
		if (hasRelationshipRiskCFICode()) s += "RelationshipRiskCFICode(1599)= " + new String( FixUtils.trim(getRelationshipRiskCFICode()) ) + "\n" ; 
		if (hasRelationshipRiskSecurityType()) s += "RelationshipRiskSecurityType(1600)= " + new String( FixUtils.trim(getRelationshipRiskSecurityType()) ) + "\n" ; 
		if (hasRelationshipRiskSecuritySubType()) s += "RelationshipRiskSecuritySubType(1601)= " + new String( FixUtils.trim(getRelationshipRiskSecuritySubType()) ) + "\n" ; 
		if (hasRelationshipRiskMaturityMonthYear()) s += "RelationshipRiskMaturityMonthYear(1602)= " + new String( FixUtils.trim(getRelationshipRiskMaturityMonthYear()) ) + "\n" ; 
		if (hasRelationshipRiskMaturityTime()) s += "RelationshipRiskMaturityTime(1603)= " + new String( FixUtils.trim(getRelationshipRiskMaturityTime()) ) + "\n" ; 
		if (hasRelationshipRiskRestructuringType()) s += "RelationshipRiskRestructuringType(1604)= " + new String( FixUtils.trim(getRelationshipRiskRestructuringType()) ) + "\n" ; 
		if (hasRelationshipRiskSeniority()) s += "RelationshipRiskSeniority(1605)= " + new String( FixUtils.trim(getRelationshipRiskSeniority()) ) + "\n" ; 
		if (hasRelationshipRiskPutOrCall()) s += "RelationshipRiskPutOrCall(1606)= " + getRelationshipRiskPutOrCall() + "\n" ; 
		if (hasRelationshipRiskFlexibleIndicator()) s += "RelationshipRiskFlexibleIndicator(1607)= " + getRelationshipRiskFlexibleIndicator() + "\n" ; 
		if (hasRelationshipRiskCouponRate()) s += "RelationshipRiskCouponRate(1608)= " + getRelationshipRiskCouponRate() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasRelationshipRiskSecurityExchange()) s += "RelationshipRiskSecurityExchange(1609)= " + new String( FixUtils.trim(getRelationshipRiskSecurityExchange()) ) + "\n" ; 
		if (hasRelationshipRiskSecurityDesc()) s += "RelationshipRiskSecurityDesc(1610)= " + new String( FixUtils.trim(getRelationshipRiskSecurityDesc()) ) + "\n" ; 
		if (hasRelationshipRiskEncodedSecurityDescLen()) s += "RelationshipRiskEncodedSecurityDescLen(1618)= " + getRelationshipRiskEncodedSecurityDescLen() + "\n" ; 
		if (hasRelationshipRiskEncodedSecurityDesc()) s += "RelationshipRiskEncodedSecurityDesc(1619)= " + new String( FixUtils.trim(getRelationshipRiskEncodedSecurityDesc()) ) + "\n" ; 
		if (hasRelationshipRiskInstrumentSettlType()) s += "RelationshipRiskInstrumentSettlType(1611)= " + new String( FixUtils.trim(getRelationshipRiskInstrumentSettlType()) ) + "\n" ; 
		if (hasRelationshipRiskInstrumentMultiplier()) s += "RelationshipRiskInstrumentMultiplier(1612)= " + getRelationshipRiskInstrumentMultiplier() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 

		for (FixRelationshipRiskSecAltIDGrp fixRelationshipRiskSecAltIDGrp : relationshipRiskSecAltIDGrp) fixRelationshipRiskSecAltIDGrp.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixRelationshipRiskInstrumentScope)) return false;

		FixRelationshipRiskInstrumentScope msg = (FixRelationshipRiskInstrumentScope) o;

		for (int i = 0; i < relationshipRiskSecAltIDGrp.length; i++)
			if (!relationshipRiskSecAltIDGrp[i].equals(msg.relationshipRiskSecAltIDGrp[i])) return false;
		if ((hasRelationshipRiskInstrumentOperator() && !msg.hasRelationshipRiskInstrumentOperator()) || (!hasRelationshipRiskInstrumentOperator() && msg.hasRelationshipRiskInstrumentOperator())) return false;
		if (!(!hasRelationshipRiskInstrumentOperator() && !msg.hasRelationshipRiskInstrumentOperator()) && !(getRelationshipRiskInstrumentOperator()==msg.getRelationshipRiskInstrumentOperator())) return false;
		if ((hasRelationshipRiskSymbol() && !msg.hasRelationshipRiskSymbol()) || (!hasRelationshipRiskSymbol() && msg.hasRelationshipRiskSymbol())) return false;
		if (!(!hasRelationshipRiskSymbol() && !msg.hasRelationshipRiskSymbol()) && !FixUtils.equals(getRelationshipRiskSymbol(), msg.getRelationshipRiskSymbol())) return false;
		if ((hasRelationshipRiskSymbolSfx() && !msg.hasRelationshipRiskSymbolSfx()) || (!hasRelationshipRiskSymbolSfx() && msg.hasRelationshipRiskSymbolSfx())) return false;
		if (!(!hasRelationshipRiskSymbolSfx() && !msg.hasRelationshipRiskSymbolSfx()) && !FixUtils.equals(getRelationshipRiskSymbolSfx(), msg.getRelationshipRiskSymbolSfx())) return false;
		if ((hasRelationshipRiskSecurityID() && !msg.hasRelationshipRiskSecurityID()) || (!hasRelationshipRiskSecurityID() && msg.hasRelationshipRiskSecurityID())) return false;
		if (!(!hasRelationshipRiskSecurityID() && !msg.hasRelationshipRiskSecurityID()) && !FixUtils.equals(getRelationshipRiskSecurityID(), msg.getRelationshipRiskSecurityID())) return false;
		if ((hasRelationshipRiskSecurityIDSource() && !msg.hasRelationshipRiskSecurityIDSource()) || (!hasRelationshipRiskSecurityIDSource() && msg.hasRelationshipRiskSecurityIDSource())) return false;
		if (!(!hasRelationshipRiskSecurityIDSource() && !msg.hasRelationshipRiskSecurityIDSource()) && !FixUtils.equals(getRelationshipRiskSecurityIDSource(), msg.getRelationshipRiskSecurityIDSource())) return false;
		if ((hasRelationshipRiskProduct() && !msg.hasRelationshipRiskProduct()) || (!hasRelationshipRiskProduct() && msg.hasRelationshipRiskProduct())) return false;
		if (!(!hasRelationshipRiskProduct() && !msg.hasRelationshipRiskProduct()) && !(getRelationshipRiskProduct()==msg.getRelationshipRiskProduct())) return false;
		if ((hasRelationshipRiskProductComplex() && !msg.hasRelationshipRiskProductComplex()) || (!hasRelationshipRiskProductComplex() && msg.hasRelationshipRiskProductComplex())) return false;
		if (!(!hasRelationshipRiskProductComplex() && !msg.hasRelationshipRiskProductComplex()) && !FixUtils.equals(getRelationshipRiskProductComplex(), msg.getRelationshipRiskProductComplex())) return false;
		if ((hasRelationshipRiskSecurityGroup() && !msg.hasRelationshipRiskSecurityGroup()) || (!hasRelationshipRiskSecurityGroup() && msg.hasRelationshipRiskSecurityGroup())) return false;
		if (!(!hasRelationshipRiskSecurityGroup() && !msg.hasRelationshipRiskSecurityGroup()) && !FixUtils.equals(getRelationshipRiskSecurityGroup(), msg.getRelationshipRiskSecurityGroup())) return false;
		if ((hasRelationshipRiskCFICode() && !msg.hasRelationshipRiskCFICode()) || (!hasRelationshipRiskCFICode() && msg.hasRelationshipRiskCFICode())) return false;
		if (!(!hasRelationshipRiskCFICode() && !msg.hasRelationshipRiskCFICode()) && !FixUtils.equals(getRelationshipRiskCFICode(), msg.getRelationshipRiskCFICode())) return false;
		if ((hasRelationshipRiskSecurityType() && !msg.hasRelationshipRiskSecurityType()) || (!hasRelationshipRiskSecurityType() && msg.hasRelationshipRiskSecurityType())) return false;
		if (!(!hasRelationshipRiskSecurityType() && !msg.hasRelationshipRiskSecurityType()) && !FixUtils.equals(getRelationshipRiskSecurityType(), msg.getRelationshipRiskSecurityType())) return false;
		if ((hasRelationshipRiskSecuritySubType() && !msg.hasRelationshipRiskSecuritySubType()) || (!hasRelationshipRiskSecuritySubType() && msg.hasRelationshipRiskSecuritySubType())) return false;
		if (!(!hasRelationshipRiskSecuritySubType() && !msg.hasRelationshipRiskSecuritySubType()) && !FixUtils.equals(getRelationshipRiskSecuritySubType(), msg.getRelationshipRiskSecuritySubType())) return false;
		if ((hasRelationshipRiskMaturityMonthYear() && !msg.hasRelationshipRiskMaturityMonthYear()) || (!hasRelationshipRiskMaturityMonthYear() && msg.hasRelationshipRiskMaturityMonthYear())) return false;
		if (!(!hasRelationshipRiskMaturityMonthYear() && !msg.hasRelationshipRiskMaturityMonthYear()) && !FixUtils.equals(getRelationshipRiskMaturityMonthYear(), msg.getRelationshipRiskMaturityMonthYear())) return false;
		if ((hasRelationshipRiskMaturityTime() && !msg.hasRelationshipRiskMaturityTime()) || (!hasRelationshipRiskMaturityTime() && msg.hasRelationshipRiskMaturityTime())) return false;
		if ((hasRelationshipRiskRestructuringType() && !msg.hasRelationshipRiskRestructuringType()) || (!hasRelationshipRiskRestructuringType() && msg.hasRelationshipRiskRestructuringType())) return false;
		if (!(!hasRelationshipRiskRestructuringType() && !msg.hasRelationshipRiskRestructuringType()) && !FixUtils.equals(getRelationshipRiskRestructuringType(), msg.getRelationshipRiskRestructuringType())) return false;
		if ((hasRelationshipRiskSeniority() && !msg.hasRelationshipRiskSeniority()) || (!hasRelationshipRiskSeniority() && msg.hasRelationshipRiskSeniority())) return false;
		if (!(!hasRelationshipRiskSeniority() && !msg.hasRelationshipRiskSeniority()) && !FixUtils.equals(getRelationshipRiskSeniority(), msg.getRelationshipRiskSeniority())) return false;
		if ((hasRelationshipRiskPutOrCall() && !msg.hasRelationshipRiskPutOrCall()) || (!hasRelationshipRiskPutOrCall() && msg.hasRelationshipRiskPutOrCall())) return false;
		if (!(!hasRelationshipRiskPutOrCall() && !msg.hasRelationshipRiskPutOrCall()) && !(getRelationshipRiskPutOrCall()==msg.getRelationshipRiskPutOrCall())) return false;
		if ((hasRelationshipRiskFlexibleIndicator() && !msg.hasRelationshipRiskFlexibleIndicator()) || (!hasRelationshipRiskFlexibleIndicator() && msg.hasRelationshipRiskFlexibleIndicator())) return false;
		if (!(!hasRelationshipRiskFlexibleIndicator() && !msg.hasRelationshipRiskFlexibleIndicator()) && !(getRelationshipRiskFlexibleIndicator()==msg.getRelationshipRiskFlexibleIndicator())) return false;
		if ((hasRelationshipRiskCouponRate() && !msg.hasRelationshipRiskCouponRate()) || (!hasRelationshipRiskCouponRate() && msg.hasRelationshipRiskCouponRate())) return false;
		if (!(!hasRelationshipRiskCouponRate() && !msg.hasRelationshipRiskCouponRate()) && !(getRelationshipRiskCouponRate()==msg.getRelationshipRiskCouponRate())) return false;
		if ((hasRelationshipRiskSecurityExchange() && !msg.hasRelationshipRiskSecurityExchange()) || (!hasRelationshipRiskSecurityExchange() && msg.hasRelationshipRiskSecurityExchange())) return false;
		if (!(!hasRelationshipRiskSecurityExchange() && !msg.hasRelationshipRiskSecurityExchange()) && !FixUtils.equals(getRelationshipRiskSecurityExchange(), msg.getRelationshipRiskSecurityExchange())) return false;
		if ((hasRelationshipRiskSecurityDesc() && !msg.hasRelationshipRiskSecurityDesc()) || (!hasRelationshipRiskSecurityDesc() && msg.hasRelationshipRiskSecurityDesc())) return false;
		if (!(!hasRelationshipRiskSecurityDesc() && !msg.hasRelationshipRiskSecurityDesc()) && !FixUtils.equals(getRelationshipRiskSecurityDesc(), msg.getRelationshipRiskSecurityDesc())) return false;
		if ((hasRelationshipRiskEncodedSecurityDescLen() && !msg.hasRelationshipRiskEncodedSecurityDescLen()) || (!hasRelationshipRiskEncodedSecurityDescLen() && msg.hasRelationshipRiskEncodedSecurityDescLen())) return false;
		if (!(!hasRelationshipRiskEncodedSecurityDescLen() && !msg.hasRelationshipRiskEncodedSecurityDescLen()) && !(getRelationshipRiskEncodedSecurityDescLen()==msg.getRelationshipRiskEncodedSecurityDescLen())) return false;
		if ((hasRelationshipRiskEncodedSecurityDesc() && !msg.hasRelationshipRiskEncodedSecurityDesc()) || (!hasRelationshipRiskEncodedSecurityDesc() && msg.hasRelationshipRiskEncodedSecurityDesc())) return false;
		if (!(!hasRelationshipRiskEncodedSecurityDesc() && !msg.hasRelationshipRiskEncodedSecurityDesc()) && !FixUtils.equals(getRelationshipRiskEncodedSecurityDesc(), msg.getRelationshipRiskEncodedSecurityDesc())) return false;
		if ((hasRelationshipRiskInstrumentSettlType() && !msg.hasRelationshipRiskInstrumentSettlType()) || (!hasRelationshipRiskInstrumentSettlType() && msg.hasRelationshipRiskInstrumentSettlType())) return false;
		if (!(!hasRelationshipRiskInstrumentSettlType() && !msg.hasRelationshipRiskInstrumentSettlType()) && !FixUtils.equals(getRelationshipRiskInstrumentSettlType(), msg.getRelationshipRiskInstrumentSettlType())) return false;
		if ((hasRelationshipRiskInstrumentMultiplier() && !msg.hasRelationshipRiskInstrumentMultiplier()) || (!hasRelationshipRiskInstrumentMultiplier() && msg.hasRelationshipRiskInstrumentMultiplier())) return false;
		if (!(!hasRelationshipRiskInstrumentMultiplier() && !msg.hasRelationshipRiskInstrumentMultiplier()) && !(getRelationshipRiskInstrumentMultiplier()==msg.getRelationshipRiskInstrumentMultiplier())) return false;
		return true;
	}
	public FixRelationshipRiskInstrumentScope clone ( FixRelationshipRiskInstrumentScope out ) {
		if ( hasRelationshipRiskInstrumentOperator())
			out.setRelationshipRiskInstrumentOperator(getRelationshipRiskInstrumentOperator());
		if ( hasRelationshipRiskSymbol())
			out.setRelationshipRiskSymbol(getRelationshipRiskSymbol());
		if ( hasRelationshipRiskSymbolSfx())
			out.setRelationshipRiskSymbolSfx(getRelationshipRiskSymbolSfx());
		if ( hasRelationshipRiskSecurityID())
			out.setRelationshipRiskSecurityID(getRelationshipRiskSecurityID());
		if ( hasRelationshipRiskSecurityIDSource())
			out.setRelationshipRiskSecurityIDSource(getRelationshipRiskSecurityIDSource());
		if ( hasRelationshipRiskProduct())
			out.setRelationshipRiskProduct(getRelationshipRiskProduct());
		if ( hasRelationshipRiskProductComplex())
			out.setRelationshipRiskProductComplex(getRelationshipRiskProductComplex());
		if ( hasRelationshipRiskSecurityGroup())
			out.setRelationshipRiskSecurityGroup(getRelationshipRiskSecurityGroup());
		if ( hasRelationshipRiskCFICode())
			out.setRelationshipRiskCFICode(getRelationshipRiskCFICode());
		if ( hasRelationshipRiskSecurityType())
			out.setRelationshipRiskSecurityType(getRelationshipRiskSecurityType());
		if ( hasRelationshipRiskSecuritySubType())
			out.setRelationshipRiskSecuritySubType(getRelationshipRiskSecuritySubType());
		if ( hasRelationshipRiskMaturityMonthYear())
			out.setRelationshipRiskMaturityMonthYear(getRelationshipRiskMaturityMonthYear());
		if ( hasRelationshipRiskMaturityTime())
			out.setRelationshipRiskMaturityTime(getRelationshipRiskMaturityTime());
		if ( hasRelationshipRiskRestructuringType())
			out.setRelationshipRiskRestructuringType(getRelationshipRiskRestructuringType());
		if ( hasRelationshipRiskSeniority())
			out.setRelationshipRiskSeniority(getRelationshipRiskSeniority());
		if ( hasRelationshipRiskPutOrCall())
			out.setRelationshipRiskPutOrCall(getRelationshipRiskPutOrCall());
		if ( hasRelationshipRiskFlexibleIndicator())
			out.setRelationshipRiskFlexibleIndicator(getRelationshipRiskFlexibleIndicator());
		if ( hasRelationshipRiskCouponRate())
			out.setRelationshipRiskCouponRate(getRelationshipRiskCouponRate());
		if ( hasRelationshipRiskSecurityExchange())
			out.setRelationshipRiskSecurityExchange(getRelationshipRiskSecurityExchange());
		if ( hasRelationshipRiskSecurityDesc())
			out.setRelationshipRiskSecurityDesc(getRelationshipRiskSecurityDesc());
		if ( hasRelationshipRiskEncodedSecurityDescLen())
			out.setRelationshipRiskEncodedSecurityDescLen(getRelationshipRiskEncodedSecurityDescLen());
		if ( hasRelationshipRiskEncodedSecurityDesc())
			out.setRelationshipRiskEncodedSecurityDesc(getRelationshipRiskEncodedSecurityDesc());
		if ( hasRelationshipRiskInstrumentSettlType())
			out.setRelationshipRiskInstrumentSettlType(getRelationshipRiskInstrumentSettlType());
		if ( hasRelationshipRiskInstrumentMultiplier())
			out.setRelationshipRiskInstrumentMultiplier(getRelationshipRiskInstrumentMultiplier());
		int count = 0;
		count = 0;
		for (FixRelationshipRiskSecAltIDGrp fixRelationshipRiskSecAltIDGrp : relationshipRiskSecAltIDGrp) {
			if (!fixRelationshipRiskSecAltIDGrp.hasGroup()) continue;
			out.relationshipRiskSecAltIDGrp[count] = fixRelationshipRiskSecAltIDGrp.clone( out.relationshipRiskSecAltIDGrp[count] );
			count++;
		}
		return out;
	}

}
