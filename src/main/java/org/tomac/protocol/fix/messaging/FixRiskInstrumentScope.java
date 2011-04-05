package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixGroup;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.messaging.FixTags;
		
public class FixRiskInstrumentScope extends FixGroup {
	private short hasRiskInstrumentOperator;
	long riskInstrumentOperator = 0;		
	private short hasRiskSymbol;
	byte[] riskSymbol = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRiskSymbolSfx;
	byte[] riskSymbolSfx = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRiskSecurityID;
	byte[] riskSecurityID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRiskSecurityIDSource;
	byte[] riskSecurityIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRiskProduct;
	long riskProduct = 0;		
	private short hasRiskProductComplex;
	byte[] riskProductComplex = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRiskSecurityGroup;
	byte[] riskSecurityGroup = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRiskCFICode;
	byte[] riskCFICode = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRiskSecurityType;
	byte[] riskSecurityType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRiskSecuritySubType;
	byte[] riskSecuritySubType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRiskMaturityMonthYear;
	byte[] riskMaturityMonthYear = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRiskMaturityTime;
	byte[] riskMaturityTime = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRiskRestructuringType;
	byte[] riskRestructuringType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRiskSeniority;
	byte[] riskSeniority = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRiskPutOrCall;
	long riskPutOrCall = 0;		
	private short hasRiskFlexibleIndicator;
		boolean riskFlexibleIndicator = false;		
	private short hasRiskCouponRate;
	long riskCouponRate = 0;		
	private short hasRiskSecurityExchange;
	byte[] riskSecurityExchange = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRiskSecurityDesc;
	byte[] riskSecurityDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRiskEncodedSecurityDescLen;
	long riskEncodedSecurityDescLen = 0;		
	private short hasRiskEncodedSecurityDesc;
	byte[] riskEncodedSecurityDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRiskInstrumentSettlType;
	byte[] riskInstrumentSettlType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasRiskInstrumentMultiplier;
	long riskInstrumentMultiplier = 0;		
		public FixRiskSecAltIDGrp[] riskSecAltIDGrp;
	
	public FixRiskInstrumentScope() {
		this(false);
	}

	public FixRiskInstrumentScope(boolean isRequired) {
		super(FixTags.RISKINSTRUMENTOPERATOR_INT);

		this.isRequired = isRequired;
		
		hasRiskInstrumentOperator = FixUtils.TAG_HAS_NO_VALUE;		
		hasRiskSymbol = FixUtils.TAG_HAS_NO_VALUE;		
		riskSymbol = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRiskSymbolSfx = FixUtils.TAG_HAS_NO_VALUE;		
		riskSymbolSfx = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRiskSecurityID = FixUtils.TAG_HAS_NO_VALUE;		
		riskSecurityID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRiskSecurityIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		riskSecurityIDSource = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRiskProduct = FixUtils.TAG_HAS_NO_VALUE;		
		hasRiskProductComplex = FixUtils.TAG_HAS_NO_VALUE;		
		riskProductComplex = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRiskSecurityGroup = FixUtils.TAG_HAS_NO_VALUE;		
		riskSecurityGroup = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRiskCFICode = FixUtils.TAG_HAS_NO_VALUE;		
		riskCFICode = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRiskSecurityType = FixUtils.TAG_HAS_NO_VALUE;		
		riskSecurityType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRiskSecuritySubType = FixUtils.TAG_HAS_NO_VALUE;		
		riskSecuritySubType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRiskMaturityMonthYear = FixUtils.TAG_HAS_NO_VALUE;		
		riskMaturityMonthYear = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRiskMaturityTime = FixUtils.TAG_HAS_NO_VALUE;		
		riskMaturityTime = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRiskRestructuringType = FixUtils.TAG_HAS_NO_VALUE;		
		riskRestructuringType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRiskSeniority = FixUtils.TAG_HAS_NO_VALUE;		
		riskSeniority = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRiskPutOrCall = FixUtils.TAG_HAS_NO_VALUE;		
		hasRiskFlexibleIndicator = FixUtils.TAG_HAS_NO_VALUE;		
		hasRiskCouponRate = FixUtils.TAG_HAS_NO_VALUE;		
		hasRiskSecurityExchange = FixUtils.TAG_HAS_NO_VALUE;		
		riskSecurityExchange = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRiskSecurityDesc = FixUtils.TAG_HAS_NO_VALUE;		
		riskSecurityDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRiskEncodedSecurityDescLen = FixUtils.TAG_HAS_NO_VALUE;		
		hasRiskEncodedSecurityDesc = FixUtils.TAG_HAS_NO_VALUE;		
		riskEncodedSecurityDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRiskInstrumentSettlType = FixUtils.TAG_HAS_NO_VALUE;		
		riskInstrumentSettlType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasRiskInstrumentMultiplier = FixUtils.TAG_HAS_NO_VALUE;		
		riskSecAltIDGrp = new FixRiskSecAltIDGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) riskSecAltIDGrp[i] = new FixRiskSecAltIDGrp();
		
	}		
			

	@Override
	public boolean hasGroup() {
		if (hasRiskInstrumentOperator()) return true;
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
            	case FixTags.RISKINSTRUMENTOPERATOR_INT:		
            		hasRiskInstrumentOperator = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RISKSYMBOL_INT:		
            		hasRiskSymbol = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RISKSYMBOLSFX_INT:		
            		hasRiskSymbolSfx = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RISKSECURITYID_INT:		
            		hasRiskSecurityID = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RISKSECURITYIDSOURCE_INT:		
            		hasRiskSecurityIDSource = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RISKPRODUCT_INT:		
            		hasRiskProduct = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RISKPRODUCTCOMPLEX_INT:		
            		hasRiskProductComplex = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RISKSECURITYGROUP_INT:		
            		hasRiskSecurityGroup = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RISKCFICODE_INT:		
            		hasRiskCFICode = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RISKSECURITYTYPE_INT:		
            		hasRiskSecurityType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RISKSECURITYSUBTYPE_INT:		
            		hasRiskSecuritySubType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RISKMATURITYMONTHYEAR_INT:		
            		hasRiskMaturityMonthYear = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RISKMATURITYTIME_INT:		
            		hasRiskMaturityTime = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RISKRESTRUCTURINGTYPE_INT:		
            		hasRiskRestructuringType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RISKSENIORITY_INT:		
            		hasRiskSeniority = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RISKPUTORCALL_INT:		
            		hasRiskPutOrCall = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RISKFLEXIBLEINDICATOR_INT:		
            		hasRiskFlexibleIndicator = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RISKCOUPONRATE_INT:		
            		hasRiskCouponRate = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RISKSECURITYEXCHANGE_INT:		
            		hasRiskSecurityExchange = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RISKSECURITYDESC_INT:		
            		hasRiskSecurityDesc = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RISKENCODEDSECURITYDESCLEN_INT:		
            		hasRiskEncodedSecurityDescLen = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RISKENCODEDSECURITYDESC_INT:		
            		hasRiskEncodedSecurityDesc = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RISKINSTRUMENTSETTLTYPE_INT:		
            		hasRiskInstrumentSettlType = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	case FixTags.RISKINSTRUMENTMULTIPLIER_INT:		
            		hasRiskInstrumentMultiplier = (short) buf.position();		
            		FixMessage.getNext(buf, err);		
                	break; 		
            	default:
        			if ( tag == FixTags.NORISKSECURITYALTID_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixMessage.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixMessage.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return repeatingGroupTag; }
        				while ( count < noInGroupNumber ) {
        					if ( !riskSecAltIDGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.REPEATING_GROUP_FIELDS_OUT_OF_ORDER, "no in group tag missing", repeatingGroupTag);
        						return repeatingGroupTag;
        					}
        					count++;
        					repeatingGroupTag = riskSecAltIDGrp[count].setBuffer( repeatingGroupTag, buf, err);	
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
		hasRiskInstrumentOperator = FixUtils.TAG_HAS_NO_VALUE;
		hasRiskSymbol = FixUtils.TAG_HAS_NO_VALUE;
		hasRiskSymbolSfx = FixUtils.TAG_HAS_NO_VALUE;
		hasRiskSecurityID = FixUtils.TAG_HAS_NO_VALUE;
		hasRiskSecurityIDSource = FixUtils.TAG_HAS_NO_VALUE;
		hasRiskProduct = FixUtils.TAG_HAS_NO_VALUE;
		hasRiskProductComplex = FixUtils.TAG_HAS_NO_VALUE;
		hasRiskSecurityGroup = FixUtils.TAG_HAS_NO_VALUE;
		hasRiskCFICode = FixUtils.TAG_HAS_NO_VALUE;
		hasRiskSecurityType = FixUtils.TAG_HAS_NO_VALUE;
		hasRiskSecuritySubType = FixUtils.TAG_HAS_NO_VALUE;
		hasRiskMaturityMonthYear = FixUtils.TAG_HAS_NO_VALUE;
		hasRiskMaturityTime = FixUtils.TAG_HAS_NO_VALUE;
		hasRiskRestructuringType = FixUtils.TAG_HAS_NO_VALUE;
		hasRiskSeniority = FixUtils.TAG_HAS_NO_VALUE;
		hasRiskPutOrCall = FixUtils.TAG_HAS_NO_VALUE;
		hasRiskFlexibleIndicator = FixUtils.TAG_HAS_NO_VALUE;
		hasRiskCouponRate = FixUtils.TAG_HAS_NO_VALUE;
		hasRiskSecurityExchange = FixUtils.TAG_HAS_NO_VALUE;
		hasRiskSecurityDesc = FixUtils.TAG_HAS_NO_VALUE;
		hasRiskEncodedSecurityDescLen = FixUtils.TAG_HAS_NO_VALUE;
		hasRiskEncodedSecurityDesc = FixUtils.TAG_HAS_NO_VALUE;
		hasRiskInstrumentSettlType = FixUtils.TAG_HAS_NO_VALUE;
		hasRiskInstrumentMultiplier = FixUtils.TAG_HAS_NO_VALUE;
		for (FixRiskSecAltIDGrp fixRiskSecAltIDGrp : riskSecAltIDGrp) fixRiskSecAltIDGrp.clear();
	}

	@Override		
	public void encode(ByteBuffer out) {

		if (hasRiskInstrumentOperator()) {		
			out.put(FixTags.RISKINSTRUMENTOPERATOR);

			out.put((byte) '=');

			FixUtils.put(out, (long)riskInstrumentOperator);
		
			out.put(FixUtils.SOH);

            }

		if (hasRiskSymbol()) {		
			out.put(FixTags.RISKSYMBOL);

			out.put((byte) '=');

			FixUtils.put(out,riskSymbol); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRiskSymbolSfx()) {		
			out.put(FixTags.RISKSYMBOLSFX);

			out.put((byte) '=');

			FixUtils.put(out,riskSymbolSfx); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRiskSecurityID()) {		
			out.put(FixTags.RISKSECURITYID);

			out.put((byte) '=');

			FixUtils.put(out,riskSecurityID); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRiskSecurityIDSource()) {		
			out.put(FixTags.RISKSECURITYIDSOURCE);

			out.put((byte) '=');

			FixUtils.put(out,riskSecurityIDSource); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRiskProduct()) {		
			out.put(FixTags.RISKPRODUCT);

			out.put((byte) '=');

			FixUtils.put(out, (long)riskProduct);
		
			out.put(FixUtils.SOH);

            }

		if (hasRiskProductComplex()) {		
			out.put(FixTags.RISKPRODUCTCOMPLEX);

			out.put((byte) '=');

			FixUtils.put(out,riskProductComplex); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRiskSecurityGroup()) {		
			out.put(FixTags.RISKSECURITYGROUP);

			out.put((byte) '=');

			FixUtils.put(out,riskSecurityGroup); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRiskCFICode()) {		
			out.put(FixTags.RISKCFICODE);

			out.put((byte) '=');

			FixUtils.put(out,riskCFICode); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRiskSecurityType()) {		
			out.put(FixTags.RISKSECURITYTYPE);

			out.put((byte) '=');

			FixUtils.put(out,riskSecurityType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRiskSecuritySubType()) {		
			out.put(FixTags.RISKSECURITYSUBTYPE);

			out.put((byte) '=');

			FixUtils.put(out,riskSecuritySubType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRiskMaturityMonthYear()) {		
			out.put(FixTags.RISKMATURITYMONTHYEAR);

			out.put((byte) '=');

			FixUtils.put(out,riskMaturityMonthYear); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRiskMaturityTime()) {		
			out.put(FixTags.RISKMATURITYTIME);

			out.put((byte) '=');

			FixUtils.put(out,riskMaturityTime); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRiskRestructuringType()) {		
			out.put(FixTags.RISKRESTRUCTURINGTYPE);

			out.put((byte) '=');

			FixUtils.put(out,riskRestructuringType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRiskSeniority()) {		
			out.put(FixTags.RISKSENIORITY);

			out.put((byte) '=');

			FixUtils.put(out,riskSeniority); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRiskPutOrCall()) {		
			out.put(FixTags.RISKPUTORCALL);

			out.put((byte) '=');

			FixUtils.put(out, (long)riskPutOrCall);
		
			out.put(FixUtils.SOH);

            }

		if (hasRiskFlexibleIndicator()) {		
			out.put(FixTags.RISKFLEXIBLEINDICATOR);

			out.put((byte) '=');

			out.put(riskFlexibleIndicator?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);

            }

		if (hasRiskCouponRate()) {		
			out.put(FixTags.RISKCOUPONRATE);

			out.put((byte) '=');

			FixUtils.put(out, (long)riskCouponRate);
		
			out.put(FixUtils.SOH);

            }

		if (hasRiskSecurityExchange()) {		
			out.put(FixTags.RISKSECURITYEXCHANGE);

			out.put((byte) '=');

			FixUtils.put(out,riskSecurityExchange); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRiskSecurityDesc()) {		
			out.put(FixTags.RISKSECURITYDESC);

			out.put((byte) '=');

			FixUtils.put(out,riskSecurityDesc); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRiskEncodedSecurityDescLen()) {		
			out.put(FixTags.RISKENCODEDSECURITYDESCLEN);

			out.put((byte) '=');

			FixUtils.put(out, (long)riskEncodedSecurityDescLen);
		
			out.put(FixUtils.SOH);

            }

		if (hasRiskEncodedSecurityDesc()) {		
			out.put(FixTags.RISKENCODEDSECURITYDESC);

			out.put((byte) '=');

			FixUtils.put(out,riskEncodedSecurityDesc); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRiskInstrumentSettlType()) {		
			out.put(FixTags.RISKINSTRUMENTSETTLTYPE);

			out.put((byte) '=');

			FixUtils.put(out,riskInstrumentSettlType); 		
		
			out.put(FixUtils.SOH);

            }

		if (hasRiskInstrumentMultiplier()) {		
			out.put(FixTags.RISKINSTRUMENTMULTIPLIER);

			out.put((byte) '=');

			FixUtils.put(out, (long)riskInstrumentMultiplier);
		
			out.put(FixUtils.SOH);

            }

		if (FixUtils.getNoInGroup(riskSecAltIDGrp)>0) {
			out.put(FixTags.NORISKSECURITYALTID);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(riskSecAltIDGrp));

			out.put(FixUtils.SOH);

		}
		for (FixRiskSecAltIDGrp fixRiskSecAltIDGrp : riskSecAltIDGrp) if (fixRiskSecAltIDGrp.hasGroup()) fixRiskSecAltIDGrp.encode(out);
	}

			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		if (hasRiskInstrumentOperator()) {		
			FixUtils.put(out, (long)riskInstrumentOperator);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRiskSymbol()) {		
			FixUtils.put(out,riskSymbol); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRiskSymbolSfx()) {		
			FixUtils.put(out,riskSymbolSfx); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRiskSecurityID()) {		
			FixUtils.put(out,riskSecurityID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRiskSecurityIDSource()) {		
			FixUtils.put(out,riskSecurityIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRiskProduct()) {		
			FixUtils.put(out, (long)riskProduct);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRiskProductComplex()) {		
			FixUtils.put(out,riskProductComplex); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRiskSecurityGroup()) {		
			FixUtils.put(out,riskSecurityGroup); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRiskCFICode()) {		
			FixUtils.put(out,riskCFICode); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRiskSecurityType()) {		
			FixUtils.put(out,riskSecurityType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRiskSecuritySubType()) {		
			FixUtils.put(out,riskSecuritySubType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRiskMaturityMonthYear()) {		
			FixUtils.put(out,riskMaturityMonthYear); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRiskMaturityTime()) {		
			FixUtils.put(out,riskMaturityTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRiskRestructuringType()) {		
			FixUtils.put(out,riskRestructuringType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRiskSeniority()) {		
			FixUtils.put(out,riskSeniority); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRiskPutOrCall()) {		
			FixUtils.put(out, (long)riskPutOrCall);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRiskFlexibleIndicator()) {		
			out.put(riskFlexibleIndicator?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRiskCouponRate()) {		
			FixUtils.put(out, (long)riskCouponRate);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRiskSecurityExchange()) {		
			FixUtils.put(out,riskSecurityExchange); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRiskSecurityDesc()) {		
			FixUtils.put(out,riskSecurityDesc); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRiskEncodedSecurityDescLen()) {		
			FixUtils.put(out, (long)riskEncodedSecurityDescLen);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRiskEncodedSecurityDesc()) {		
			FixUtils.put(out,riskEncodedSecurityDesc); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRiskInstrumentSettlType()) {		
			FixUtils.put(out,riskInstrumentSettlType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRiskInstrumentMultiplier()) {		
			FixUtils.put(out, (long)riskInstrumentMultiplier);
		
	        out.put( (byte)' ' );		
		}		
		
		for (FixRiskSecAltIDGrp fixRiskSecAltIDGrp : riskSecAltIDGrp) fixRiskSecAltIDGrp.printBuffer(out);
	}

	public long getRiskInstrumentOperator() { 		
		if ( hasRiskInstrumentOperator()) {		
			if (hasRiskInstrumentOperator == FixUtils.TAG_HAS_VALUE) {		
				return riskInstrumentOperator; 		
			} else {		
		
				buf.position(hasRiskInstrumentOperator);		
		
			riskInstrumentOperator = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRiskInstrumentOperator);		
					return 0;		
				}		
			}		
			hasRiskInstrumentOperator = FixUtils.TAG_HAS_VALUE;		
			return riskInstrumentOperator;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRiskInstrumentOperator() { return hasRiskInstrumentOperator != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRiskInstrumentOperator(long src) {		
		riskInstrumentOperator = src;
		hasRiskInstrumentOperator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRiskInstrumentOperator(byte[] src) {		
		if (src == null ) return;
		if (hasRiskInstrumentOperator()) riskInstrumentOperator = FixUtils.TAG_HAS_NO_VALUE;		
		riskInstrumentOperator = FixUtils.longValueOf(src, 0, src.length);
		hasRiskInstrumentOperator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRiskInstrumentOperator(String str) {		
		if (str == null ) return;
		if (hasRiskInstrumentOperator()) riskInstrumentOperator = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		riskInstrumentOperator = FixUtils.longValueOf(src, 0, src.length);
		hasRiskInstrumentOperator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRiskSymbol() { 		
		if ( hasRiskSymbol()) {		
			if (hasRiskSymbol == FixUtils.TAG_HAS_VALUE) {		
				return riskSymbol; 		
			} else {		
		
				buf.position(hasRiskSymbol);		
		
			FixMessage.getTagStringValue(buf, riskSymbol, 0, riskSymbol.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRiskSymbol);		
					return null;		
				}		
			}		
			hasRiskSymbol = FixUtils.TAG_HAS_VALUE;		
			return riskSymbol;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRiskSymbol() { return hasRiskSymbol != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRiskSymbol(byte[] src) {		
		if (src == null ) return;
		if (hasRiskSymbol()) FixUtils.fillNul(riskSymbol);		
		FixUtils.copy(riskSymbol, src); 		
		hasRiskSymbol = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRiskSymbol(String str) {		
		if (str == null ) return;
		if (hasRiskSymbol()) FixUtils.fillNul(riskSymbol);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(riskSymbol, src); 		
		hasRiskSymbol = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRiskSymbolSfx() { 		
		if ( hasRiskSymbolSfx()) {		
			if (hasRiskSymbolSfx == FixUtils.TAG_HAS_VALUE) {		
				return riskSymbolSfx; 		
			} else {		
		
				buf.position(hasRiskSymbolSfx);		
		
			FixMessage.getTagStringValue(buf, riskSymbolSfx, 0, riskSymbolSfx.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRiskSymbolSfx);		
					return null;		
				}		
			}		
			hasRiskSymbolSfx = FixUtils.TAG_HAS_VALUE;		
			return riskSymbolSfx;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRiskSymbolSfx() { return hasRiskSymbolSfx != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRiskSymbolSfx(byte[] src) {		
		if (src == null ) return;
		if (hasRiskSymbolSfx()) FixUtils.fillNul(riskSymbolSfx);		
		FixUtils.copy(riskSymbolSfx, src); 		
		hasRiskSymbolSfx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRiskSymbolSfx(String str) {		
		if (str == null ) return;
		if (hasRiskSymbolSfx()) FixUtils.fillNul(riskSymbolSfx);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(riskSymbolSfx, src); 		
		hasRiskSymbolSfx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRiskSecurityID() { 		
		if ( hasRiskSecurityID()) {		
			if (hasRiskSecurityID == FixUtils.TAG_HAS_VALUE) {		
				return riskSecurityID; 		
			} else {		
		
				buf.position(hasRiskSecurityID);		
		
			FixMessage.getTagStringValue(buf, riskSecurityID, 0, riskSecurityID.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRiskSecurityID);		
					return null;		
				}		
			}		
			hasRiskSecurityID = FixUtils.TAG_HAS_VALUE;		
			return riskSecurityID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRiskSecurityID() { return hasRiskSecurityID != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRiskSecurityID(byte[] src) {		
		if (src == null ) return;
		if (hasRiskSecurityID()) FixUtils.fillNul(riskSecurityID);		
		FixUtils.copy(riskSecurityID, src); 		
		hasRiskSecurityID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRiskSecurityID(String str) {		
		if (str == null ) return;
		if (hasRiskSecurityID()) FixUtils.fillNul(riskSecurityID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(riskSecurityID, src); 		
		hasRiskSecurityID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRiskSecurityIDSource() { 		
		if ( hasRiskSecurityIDSource()) {		
			if (hasRiskSecurityIDSource == FixUtils.TAG_HAS_VALUE) {		
				return riskSecurityIDSource; 		
			} else {		
		
				buf.position(hasRiskSecurityIDSource);		
		
			FixMessage.getTagStringValue(buf, riskSecurityIDSource, 0, riskSecurityIDSource.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRiskSecurityIDSource);		
					return null;		
				}		
			}		
			hasRiskSecurityIDSource = FixUtils.TAG_HAS_VALUE;		
			return riskSecurityIDSource;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRiskSecurityIDSource() { return hasRiskSecurityIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRiskSecurityIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasRiskSecurityIDSource()) FixUtils.fillNul(riskSecurityIDSource);		
		FixUtils.copy(riskSecurityIDSource, src); 		
		hasRiskSecurityIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRiskSecurityIDSource(String str) {		
		if (str == null ) return;
		if (hasRiskSecurityIDSource()) FixUtils.fillNul(riskSecurityIDSource);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(riskSecurityIDSource, src); 		
		hasRiskSecurityIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getRiskProduct() { 		
		if ( hasRiskProduct()) {		
			if (hasRiskProduct == FixUtils.TAG_HAS_VALUE) {		
				return riskProduct; 		
			} else {		
		
				buf.position(hasRiskProduct);		
		
			riskProduct = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRiskProduct);		
					return 0;		
				}		
			}		
			hasRiskProduct = FixUtils.TAG_HAS_VALUE;		
			return riskProduct;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRiskProduct() { return hasRiskProduct != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRiskProduct(long src) {		
		riskProduct = src;
		hasRiskProduct = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRiskProduct(byte[] src) {		
		if (src == null ) return;
		if (hasRiskProduct()) riskProduct = FixUtils.TAG_HAS_NO_VALUE;		
		riskProduct = FixUtils.longValueOf(src, 0, src.length);
		hasRiskProduct = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRiskProduct(String str) {		
		if (str == null ) return;
		if (hasRiskProduct()) riskProduct = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		riskProduct = FixUtils.longValueOf(src, 0, src.length);
		hasRiskProduct = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRiskProductComplex() { 		
		if ( hasRiskProductComplex()) {		
			if (hasRiskProductComplex == FixUtils.TAG_HAS_VALUE) {		
				return riskProductComplex; 		
			} else {		
		
				buf.position(hasRiskProductComplex);		
		
			FixMessage.getTagStringValue(buf, riskProductComplex, 0, riskProductComplex.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRiskProductComplex);		
					return null;		
				}		
			}		
			hasRiskProductComplex = FixUtils.TAG_HAS_VALUE;		
			return riskProductComplex;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRiskProductComplex() { return hasRiskProductComplex != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRiskProductComplex(byte[] src) {		
		if (src == null ) return;
		if (hasRiskProductComplex()) FixUtils.fillNul(riskProductComplex);		
		FixUtils.copy(riskProductComplex, src); 		
		hasRiskProductComplex = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRiskProductComplex(String str) {		
		if (str == null ) return;
		if (hasRiskProductComplex()) FixUtils.fillNul(riskProductComplex);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(riskProductComplex, src); 		
		hasRiskProductComplex = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRiskSecurityGroup() { 		
		if ( hasRiskSecurityGroup()) {		
			if (hasRiskSecurityGroup == FixUtils.TAG_HAS_VALUE) {		
				return riskSecurityGroup; 		
			} else {		
		
				buf.position(hasRiskSecurityGroup);		
		
			FixMessage.getTagStringValue(buf, riskSecurityGroup, 0, riskSecurityGroup.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRiskSecurityGroup);		
					return null;		
				}		
			}		
			hasRiskSecurityGroup = FixUtils.TAG_HAS_VALUE;		
			return riskSecurityGroup;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRiskSecurityGroup() { return hasRiskSecurityGroup != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRiskSecurityGroup(byte[] src) {		
		if (src == null ) return;
		if (hasRiskSecurityGroup()) FixUtils.fillNul(riskSecurityGroup);		
		FixUtils.copy(riskSecurityGroup, src); 		
		hasRiskSecurityGroup = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRiskSecurityGroup(String str) {		
		if (str == null ) return;
		if (hasRiskSecurityGroup()) FixUtils.fillNul(riskSecurityGroup);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(riskSecurityGroup, src); 		
		hasRiskSecurityGroup = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRiskCFICode() { 		
		if ( hasRiskCFICode()) {		
			if (hasRiskCFICode == FixUtils.TAG_HAS_VALUE) {		
				return riskCFICode; 		
			} else {		
		
				buf.position(hasRiskCFICode);		
		
			FixMessage.getTagStringValue(buf, riskCFICode, 0, riskCFICode.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRiskCFICode);		
					return null;		
				}		
			}		
			hasRiskCFICode = FixUtils.TAG_HAS_VALUE;		
			return riskCFICode;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRiskCFICode() { return hasRiskCFICode != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRiskCFICode(byte[] src) {		
		if (src == null ) return;
		if (hasRiskCFICode()) FixUtils.fillNul(riskCFICode);		
		FixUtils.copy(riskCFICode, src); 		
		hasRiskCFICode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRiskCFICode(String str) {		
		if (str == null ) return;
		if (hasRiskCFICode()) FixUtils.fillNul(riskCFICode);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(riskCFICode, src); 		
		hasRiskCFICode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRiskSecurityType() { 		
		if ( hasRiskSecurityType()) {		
			if (hasRiskSecurityType == FixUtils.TAG_HAS_VALUE) {		
				return riskSecurityType; 		
			} else {		
		
				buf.position(hasRiskSecurityType);		
		
			FixMessage.getTagStringValue(buf, riskSecurityType, 0, riskSecurityType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRiskSecurityType);		
					return null;		
				}		
			}		
			hasRiskSecurityType = FixUtils.TAG_HAS_VALUE;		
			return riskSecurityType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRiskSecurityType() { return hasRiskSecurityType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRiskSecurityType(byte[] src) {		
		if (src == null ) return;
		if (hasRiskSecurityType()) FixUtils.fillNul(riskSecurityType);		
		FixUtils.copy(riskSecurityType, src); 		
		hasRiskSecurityType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRiskSecurityType(String str) {		
		if (str == null ) return;
		if (hasRiskSecurityType()) FixUtils.fillNul(riskSecurityType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(riskSecurityType, src); 		
		hasRiskSecurityType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRiskSecuritySubType() { 		
		if ( hasRiskSecuritySubType()) {		
			if (hasRiskSecuritySubType == FixUtils.TAG_HAS_VALUE) {		
				return riskSecuritySubType; 		
			} else {		
		
				buf.position(hasRiskSecuritySubType);		
		
			FixMessage.getTagStringValue(buf, riskSecuritySubType, 0, riskSecuritySubType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRiskSecuritySubType);		
					return null;		
				}		
			}		
			hasRiskSecuritySubType = FixUtils.TAG_HAS_VALUE;		
			return riskSecuritySubType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRiskSecuritySubType() { return hasRiskSecuritySubType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRiskSecuritySubType(byte[] src) {		
		if (src == null ) return;
		if (hasRiskSecuritySubType()) FixUtils.fillNul(riskSecuritySubType);		
		FixUtils.copy(riskSecuritySubType, src); 		
		hasRiskSecuritySubType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRiskSecuritySubType(String str) {		
		if (str == null ) return;
		if (hasRiskSecuritySubType()) FixUtils.fillNul(riskSecuritySubType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(riskSecuritySubType, src); 		
		hasRiskSecuritySubType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRiskMaturityMonthYear() { 		
		if ( hasRiskMaturityMonthYear()) {		
			if (hasRiskMaturityMonthYear == FixUtils.TAG_HAS_VALUE) {		
				return riskMaturityMonthYear; 		
			} else {		
		
				buf.position(hasRiskMaturityMonthYear);		
		
			FixMessage.getTagStringValue(buf, riskMaturityMonthYear, 0, riskMaturityMonthYear.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRiskMaturityMonthYear);		
					return null;		
				}		
			}		
			hasRiskMaturityMonthYear = FixUtils.TAG_HAS_VALUE;		
			return riskMaturityMonthYear;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRiskMaturityMonthYear() { return hasRiskMaturityMonthYear != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRiskMaturityMonthYear(byte[] src) {		
		if (src == null ) return;
		if (hasRiskMaturityMonthYear()) FixUtils.fillNul(riskMaturityMonthYear);		
		FixUtils.copy(riskMaturityMonthYear, src); 		
		hasRiskMaturityMonthYear = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRiskMaturityMonthYear(String str) {		
		if (str == null ) return;
		if (hasRiskMaturityMonthYear()) FixUtils.fillNul(riskMaturityMonthYear);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(riskMaturityMonthYear, src); 		
		hasRiskMaturityMonthYear = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRiskMaturityTime() { 		
		if ( hasRiskMaturityTime()) {		
			if (hasRiskMaturityTime == FixUtils.TAG_HAS_VALUE) {		
				return riskMaturityTime; 		
			} else {		
		
				buf.position(hasRiskMaturityTime);		
		
			FixMessage.getTagStringValue(buf, riskMaturityTime, 0, riskMaturityTime.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRiskMaturityTime);		
					return null;		
				}		
			}		
			hasRiskMaturityTime = FixUtils.TAG_HAS_VALUE;		
			return riskMaturityTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRiskMaturityTime() { return hasRiskMaturityTime != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRiskMaturityTime(byte[] src) {		
		if (src == null ) return;
		if (hasRiskMaturityTime()) FixUtils.fillNul(riskMaturityTime);		
		FixUtils.copy(riskMaturityTime, src); 		
		hasRiskMaturityTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRiskMaturityTime(String str) {		
		if (str == null ) return;
		if (hasRiskMaturityTime()) FixUtils.fillNul(riskMaturityTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(riskMaturityTime, src); 		
		hasRiskMaturityTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRiskRestructuringType() { 		
		if ( hasRiskRestructuringType()) {		
			if (hasRiskRestructuringType == FixUtils.TAG_HAS_VALUE) {		
				return riskRestructuringType; 		
			} else {		
		
				buf.position(hasRiskRestructuringType);		
		
			FixMessage.getTagStringValue(buf, riskRestructuringType, 0, riskRestructuringType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRiskRestructuringType);		
					return null;		
				}		
			}		
			hasRiskRestructuringType = FixUtils.TAG_HAS_VALUE;		
			return riskRestructuringType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRiskRestructuringType() { return hasRiskRestructuringType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRiskRestructuringType(byte[] src) {		
		if (src == null ) return;
		if (hasRiskRestructuringType()) FixUtils.fillNul(riskRestructuringType);		
		FixUtils.copy(riskRestructuringType, src); 		
		hasRiskRestructuringType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRiskRestructuringType(String str) {		
		if (str == null ) return;
		if (hasRiskRestructuringType()) FixUtils.fillNul(riskRestructuringType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(riskRestructuringType, src); 		
		hasRiskRestructuringType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRiskSeniority() { 		
		if ( hasRiskSeniority()) {		
			if (hasRiskSeniority == FixUtils.TAG_HAS_VALUE) {		
				return riskSeniority; 		
			} else {		
		
				buf.position(hasRiskSeniority);		
		
			FixMessage.getTagStringValue(buf, riskSeniority, 0, riskSeniority.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRiskSeniority);		
					return null;		
				}		
			}		
			hasRiskSeniority = FixUtils.TAG_HAS_VALUE;		
			return riskSeniority;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRiskSeniority() { return hasRiskSeniority != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRiskSeniority(byte[] src) {		
		if (src == null ) return;
		if (hasRiskSeniority()) FixUtils.fillNul(riskSeniority);		
		FixUtils.copy(riskSeniority, src); 		
		hasRiskSeniority = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRiskSeniority(String str) {		
		if (str == null ) return;
		if (hasRiskSeniority()) FixUtils.fillNul(riskSeniority);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(riskSeniority, src); 		
		hasRiskSeniority = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getRiskPutOrCall() { 		
		if ( hasRiskPutOrCall()) {		
			if (hasRiskPutOrCall == FixUtils.TAG_HAS_VALUE) {		
				return riskPutOrCall; 		
			} else {		
		
				buf.position(hasRiskPutOrCall);		
		
			riskPutOrCall = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRiskPutOrCall);		
					return 0;		
				}		
			}		
			hasRiskPutOrCall = FixUtils.TAG_HAS_VALUE;		
			return riskPutOrCall;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRiskPutOrCall() { return hasRiskPutOrCall != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRiskPutOrCall(long src) {		
		riskPutOrCall = src;
		hasRiskPutOrCall = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRiskPutOrCall(byte[] src) {		
		if (src == null ) return;
		if (hasRiskPutOrCall()) riskPutOrCall = FixUtils.TAG_HAS_NO_VALUE;		
		riskPutOrCall = FixUtils.longValueOf(src, 0, src.length);
		hasRiskPutOrCall = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRiskPutOrCall(String str) {		
		if (str == null ) return;
		if (hasRiskPutOrCall()) riskPutOrCall = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		riskPutOrCall = FixUtils.longValueOf(src, 0, src.length);
		hasRiskPutOrCall = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public boolean getRiskFlexibleIndicator() { 		
		if ( hasRiskFlexibleIndicator()) {		
			if (hasRiskFlexibleIndicator == FixUtils.TAG_HAS_VALUE) {		
				return riskFlexibleIndicator; 		
			} else {		
		
				buf.position(hasRiskFlexibleIndicator);		
		
			riskFlexibleIndicator = FixMessage.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(hasRiskFlexibleIndicator);		
					return false;		
				}		
			}		
			hasRiskFlexibleIndicator = FixUtils.TAG_HAS_VALUE;		
			return riskFlexibleIndicator;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasRiskFlexibleIndicator() { return hasRiskFlexibleIndicator != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRiskFlexibleIndicator(boolean src) {		
		riskFlexibleIndicator = src;
		hasRiskFlexibleIndicator = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRiskFlexibleIndicator(byte[] src) {		
		if (src == null ) return;
		if (hasRiskFlexibleIndicator()) riskFlexibleIndicator = false;		
		riskFlexibleIndicator = src[0]==(byte)'Y'?true:false;		
		hasRiskFlexibleIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRiskFlexibleIndicator(String str) {		
		if (str == null ) return;
		if (hasRiskFlexibleIndicator()) riskFlexibleIndicator = false;		
		byte[] src = str.getBytes(); 		
		riskFlexibleIndicator = src[0]==(byte)'Y'?true:false;		
		hasRiskFlexibleIndicator = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getRiskCouponRate() { 		
		if ( hasRiskCouponRate()) {		
			if (hasRiskCouponRate == FixUtils.TAG_HAS_VALUE) {		
				return riskCouponRate; 		
			} else {		
		
				buf.position(hasRiskCouponRate);		
		
			riskCouponRate = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRiskCouponRate);		
					return 0;		
				}		
			}		
			hasRiskCouponRate = FixUtils.TAG_HAS_VALUE;		
			return riskCouponRate;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRiskCouponRate() { return hasRiskCouponRate != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRiskCouponRate(long src) {		
		riskCouponRate = src;
		hasRiskCouponRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRiskCouponRate(byte[] src) {		
		if (src == null ) return;
		if (hasRiskCouponRate()) riskCouponRate = FixUtils.TAG_HAS_NO_VALUE;		
		riskCouponRate = FixUtils.longValueOf(src, 0, src.length);
		hasRiskCouponRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRiskCouponRate(String str) {		
		if (str == null ) return;
		if (hasRiskCouponRate()) riskCouponRate = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		riskCouponRate = FixUtils.longValueOf(src, 0, src.length);
		hasRiskCouponRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRiskSecurityExchange() { 		
		if ( hasRiskSecurityExchange()) {		
			if (hasRiskSecurityExchange == FixUtils.TAG_HAS_VALUE) {		
				return riskSecurityExchange; 		
			} else {		
		
				buf.position(hasRiskSecurityExchange);		
		
			FixMessage.getTagStringValue(buf, riskSecurityExchange, 0, riskSecurityExchange.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRiskSecurityExchange);		
					return null;		
				}		
			}		
			hasRiskSecurityExchange = FixUtils.TAG_HAS_VALUE;		
			return riskSecurityExchange;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRiskSecurityExchange() { return hasRiskSecurityExchange != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRiskSecurityExchange(byte[] src) {		
		if (src == null ) return;
		if (hasRiskSecurityExchange()) FixUtils.fillNul(riskSecurityExchange);		
		FixUtils.copy(riskSecurityExchange, src); 		
		hasRiskSecurityExchange = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRiskSecurityExchange(String str) {		
		if (str == null ) return;
		if (hasRiskSecurityExchange()) FixUtils.fillNul(riskSecurityExchange);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(riskSecurityExchange, src); 		
		hasRiskSecurityExchange = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRiskSecurityDesc() { 		
		if ( hasRiskSecurityDesc()) {		
			if (hasRiskSecurityDesc == FixUtils.TAG_HAS_VALUE) {		
				return riskSecurityDesc; 		
			} else {		
		
				buf.position(hasRiskSecurityDesc);		
		
			FixMessage.getTagStringValue(buf, riskSecurityDesc, 0, riskSecurityDesc.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRiskSecurityDesc);		
					return null;		
				}		
			}		
			hasRiskSecurityDesc = FixUtils.TAG_HAS_VALUE;		
			return riskSecurityDesc;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRiskSecurityDesc() { return hasRiskSecurityDesc != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRiskSecurityDesc(byte[] src) {		
		if (src == null ) return;
		if (hasRiskSecurityDesc()) FixUtils.fillNul(riskSecurityDesc);		
		FixUtils.copy(riskSecurityDesc, src); 		
		hasRiskSecurityDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRiskSecurityDesc(String str) {		
		if (str == null ) return;
		if (hasRiskSecurityDesc()) FixUtils.fillNul(riskSecurityDesc);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(riskSecurityDesc, src); 		
		hasRiskSecurityDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getRiskEncodedSecurityDescLen() { 		
		if ( hasRiskEncodedSecurityDescLen()) {		
			if (hasRiskEncodedSecurityDescLen == FixUtils.TAG_HAS_VALUE) {		
				return riskEncodedSecurityDescLen; 		
			} else {		
		
				buf.position(hasRiskEncodedSecurityDescLen);		
		
			riskEncodedSecurityDescLen = FixMessage.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRiskEncodedSecurityDescLen);		
					return 0;		
				}		
			}		
			hasRiskEncodedSecurityDescLen = FixUtils.TAG_HAS_VALUE;		
			return riskEncodedSecurityDescLen;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRiskEncodedSecurityDescLen() { return hasRiskEncodedSecurityDescLen != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRiskEncodedSecurityDescLen(long src) {		
		riskEncodedSecurityDescLen = src;
		hasRiskEncodedSecurityDescLen = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRiskEncodedSecurityDescLen(byte[] src) {		
		if (src == null ) return;
		if (hasRiskEncodedSecurityDescLen()) riskEncodedSecurityDescLen = FixUtils.TAG_HAS_NO_VALUE;		
		riskEncodedSecurityDescLen = FixUtils.longValueOf(src, 0, src.length);
		hasRiskEncodedSecurityDescLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRiskEncodedSecurityDescLen(String str) {		
		if (str == null ) return;
		if (hasRiskEncodedSecurityDescLen()) riskEncodedSecurityDescLen = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		riskEncodedSecurityDescLen = FixUtils.longValueOf(src, 0, src.length);
		hasRiskEncodedSecurityDescLen = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRiskEncodedSecurityDesc() { 		
		if ( hasRiskEncodedSecurityDesc()) {		
			if (hasRiskEncodedSecurityDesc == FixUtils.TAG_HAS_VALUE) {		
				return riskEncodedSecurityDesc; 		
			} else {		
		
				buf.position(hasRiskEncodedSecurityDesc);		
		
			FixMessage.getTagStringValue(buf, riskEncodedSecurityDesc, 0, riskEncodedSecurityDesc.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRiskEncodedSecurityDesc);		
					return null;		
				}		
			}		
			hasRiskEncodedSecurityDesc = FixUtils.TAG_HAS_VALUE;		
			return riskEncodedSecurityDesc;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRiskEncodedSecurityDesc() { return hasRiskEncodedSecurityDesc != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRiskEncodedSecurityDesc(byte[] src) {		
		if (src == null ) return;
		if (hasRiskEncodedSecurityDesc()) FixUtils.fillNul(riskEncodedSecurityDesc);		
		FixUtils.copy(riskEncodedSecurityDesc, src); 		
		hasRiskEncodedSecurityDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRiskEncodedSecurityDesc(String str) {		
		if (str == null ) return;
		if (hasRiskEncodedSecurityDesc()) FixUtils.fillNul(riskEncodedSecurityDesc);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(riskEncodedSecurityDesc, src); 		
		hasRiskEncodedSecurityDesc = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public byte[] getRiskInstrumentSettlType() { 		
		if ( hasRiskInstrumentSettlType()) {		
			if (hasRiskInstrumentSettlType == FixUtils.TAG_HAS_VALUE) {		
				return riskInstrumentSettlType; 		
			} else {		
		
				buf.position(hasRiskInstrumentSettlType);		
		
			FixMessage.getTagStringValue(buf, riskInstrumentSettlType, 0, riskInstrumentSettlType.length, err);
		
				if (err.hasError()) {		
					buf.position(hasRiskInstrumentSettlType);		
					return null;		
				}		
			}		
			hasRiskInstrumentSettlType = FixUtils.TAG_HAS_VALUE;		
			return riskInstrumentSettlType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRiskInstrumentSettlType() { return hasRiskInstrumentSettlType != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRiskInstrumentSettlType(byte[] src) {		
		if (src == null ) return;
		if (hasRiskInstrumentSettlType()) FixUtils.fillNul(riskInstrumentSettlType);		
		FixUtils.copy(riskInstrumentSettlType, src); 		
		hasRiskInstrumentSettlType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRiskInstrumentSettlType(String str) {		
		if (str == null ) return;
		if (hasRiskInstrumentSettlType()) FixUtils.fillNul(riskInstrumentSettlType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(riskInstrumentSettlType, src); 		
		hasRiskInstrumentSettlType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public long getRiskInstrumentMultiplier() { 		
		if ( hasRiskInstrumentMultiplier()) {		
			if (hasRiskInstrumentMultiplier == FixUtils.TAG_HAS_VALUE) {		
				return riskInstrumentMultiplier; 		
			} else {		
		
				buf.position(hasRiskInstrumentMultiplier);		
		
			riskInstrumentMultiplier = FixMessage.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(hasRiskInstrumentMultiplier);		
					return 0;		
				}		
			}		
			hasRiskInstrumentMultiplier = FixUtils.TAG_HAS_VALUE;		
			return riskInstrumentMultiplier;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasRiskInstrumentMultiplier() { return hasRiskInstrumentMultiplier != FixUtils.TAG_HAS_NO_VALUE; } 		
		
	public void setRiskInstrumentMultiplier(long src) {		
		riskInstrumentMultiplier = src;
		hasRiskInstrumentMultiplier = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRiskInstrumentMultiplier(byte[] src) {		
		if (src == null ) return;
		if (hasRiskInstrumentMultiplier()) riskInstrumentMultiplier = FixUtils.TAG_HAS_NO_VALUE;		
		riskInstrumentMultiplier = FixUtils.longValueOf(src, 0, src.length);
		hasRiskInstrumentMultiplier = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void setRiskInstrumentMultiplier(String str) {		
		if (str == null ) return;
		if (hasRiskInstrumentMultiplier()) riskInstrumentMultiplier = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		riskInstrumentMultiplier = FixUtils.longValueOf(src, 0, src.length);
		hasRiskInstrumentMultiplier = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
				if (hasRiskInstrumentOperator()) s += "RiskInstrumentOperator(1535)= " + getRiskInstrumentOperator() + "\n" ; 
		if (hasRiskSymbol()) s += "RiskSymbol(1536)= " + new String( FixUtils.trim(getRiskSymbol()) ) + "\n" ; 
		if (hasRiskSymbolSfx()) s += "RiskSymbolSfx(1537)= " + new String( FixUtils.trim(getRiskSymbolSfx()) ) + "\n" ; 
		if (hasRiskSecurityID()) s += "RiskSecurityID(1538)= " + new String( FixUtils.trim(getRiskSecurityID()) ) + "\n" ; 
		if (hasRiskSecurityIDSource()) s += "RiskSecurityIDSource(1539)= " + new String( FixUtils.trim(getRiskSecurityIDSource()) ) + "\n" ; 
		if (hasRiskProduct()) s += "RiskProduct(1543)= " + getRiskProduct() + "\n" ; 
		if (hasRiskProductComplex()) s += "RiskProductComplex(1544)= " + new String( FixUtils.trim(getRiskProductComplex()) ) + "\n" ; 
		if (hasRiskSecurityGroup()) s += "RiskSecurityGroup(1545)= " + new String( FixUtils.trim(getRiskSecurityGroup()) ) + "\n" ; 
		if (hasRiskCFICode()) s += "RiskCFICode(1546)= " + new String( FixUtils.trim(getRiskCFICode()) ) + "\n" ; 
		if (hasRiskSecurityType()) s += "RiskSecurityType(1547)= " + new String( FixUtils.trim(getRiskSecurityType()) ) + "\n" ; 
		if (hasRiskSecuritySubType()) s += "RiskSecuritySubType(1548)= " + new String( FixUtils.trim(getRiskSecuritySubType()) ) + "\n" ; 
		if (hasRiskMaturityMonthYear()) s += "RiskMaturityMonthYear(1549)= " + new String( FixUtils.trim(getRiskMaturityMonthYear()) ) + "\n" ; 
		if (hasRiskMaturityTime()) s += "RiskMaturityTime(1550)= " + new String( FixUtils.trim(getRiskMaturityTime()) ) + "\n" ; 
		if (hasRiskRestructuringType()) s += "RiskRestructuringType(1551)= " + new String( FixUtils.trim(getRiskRestructuringType()) ) + "\n" ; 
		if (hasRiskSeniority()) s += "RiskSeniority(1552)= " + new String( FixUtils.trim(getRiskSeniority()) ) + "\n" ; 
		if (hasRiskPutOrCall()) s += "RiskPutOrCall(1553)= " + getRiskPutOrCall() + "\n" ; 
		if (hasRiskFlexibleIndicator()) s += "RiskFlexibleIndicator(1554)= " + getRiskFlexibleIndicator() + "\n" ; 
		if (hasRiskCouponRate()) s += "RiskCouponRate(1555)= " + getRiskCouponRate() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasRiskSecurityExchange()) s += "RiskSecurityExchange(1616)= " + new String( FixUtils.trim(getRiskSecurityExchange()) ) + "\n" ; 
		if (hasRiskSecurityDesc()) s += "RiskSecurityDesc(1556)= " + new String( FixUtils.trim(getRiskSecurityDesc()) ) + "\n" ; 
		if (hasRiskEncodedSecurityDescLen()) s += "RiskEncodedSecurityDescLen(1620)= " + getRiskEncodedSecurityDescLen() + "\n" ; 
		if (hasRiskEncodedSecurityDesc()) s += "RiskEncodedSecurityDesc(1621)= " + new String( FixUtils.trim(getRiskEncodedSecurityDesc()) ) + "\n" ; 
		if (hasRiskInstrumentSettlType()) s += "RiskInstrumentSettlType(1557)= " + new String( FixUtils.trim(getRiskInstrumentSettlType()) ) + "\n" ; 
		if (hasRiskInstrumentMultiplier()) s += "RiskInstrumentMultiplier(1558)= " + getRiskInstrumentMultiplier() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 

		for (FixRiskSecAltIDGrp fixRiskSecAltIDGrp : riskSecAltIDGrp) fixRiskSecAltIDGrp.toString();
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixRiskInstrumentScope)) return false;

		FixRiskInstrumentScope msg = (FixRiskInstrumentScope) o;

		for (int i = 0; i < riskSecAltIDGrp.length; i++)
			if (!riskSecAltIDGrp[i].equals(msg.riskSecAltIDGrp[i])) return false;
		if ((hasRiskInstrumentOperator() && !msg.hasRiskInstrumentOperator()) || (!hasRiskInstrumentOperator() && msg.hasRiskInstrumentOperator())) return false;
		if (!(!hasRiskInstrumentOperator() && !msg.hasRiskInstrumentOperator()) && !(getRiskInstrumentOperator()==msg.getRiskInstrumentOperator())) return false;
		if ((hasRiskSymbol() && !msg.hasRiskSymbol()) || (!hasRiskSymbol() && msg.hasRiskSymbol())) return false;
		if (!(!hasRiskSymbol() && !msg.hasRiskSymbol()) && !FixUtils.equals(getRiskSymbol(), msg.getRiskSymbol())) return false;
		if ((hasRiskSymbolSfx() && !msg.hasRiskSymbolSfx()) || (!hasRiskSymbolSfx() && msg.hasRiskSymbolSfx())) return false;
		if (!(!hasRiskSymbolSfx() && !msg.hasRiskSymbolSfx()) && !FixUtils.equals(getRiskSymbolSfx(), msg.getRiskSymbolSfx())) return false;
		if ((hasRiskSecurityID() && !msg.hasRiskSecurityID()) || (!hasRiskSecurityID() && msg.hasRiskSecurityID())) return false;
		if (!(!hasRiskSecurityID() && !msg.hasRiskSecurityID()) && !FixUtils.equals(getRiskSecurityID(), msg.getRiskSecurityID())) return false;
		if ((hasRiskSecurityIDSource() && !msg.hasRiskSecurityIDSource()) || (!hasRiskSecurityIDSource() && msg.hasRiskSecurityIDSource())) return false;
		if (!(!hasRiskSecurityIDSource() && !msg.hasRiskSecurityIDSource()) && !FixUtils.equals(getRiskSecurityIDSource(), msg.getRiskSecurityIDSource())) return false;
		if ((hasRiskProduct() && !msg.hasRiskProduct()) || (!hasRiskProduct() && msg.hasRiskProduct())) return false;
		if (!(!hasRiskProduct() && !msg.hasRiskProduct()) && !(getRiskProduct()==msg.getRiskProduct())) return false;
		if ((hasRiskProductComplex() && !msg.hasRiskProductComplex()) || (!hasRiskProductComplex() && msg.hasRiskProductComplex())) return false;
		if (!(!hasRiskProductComplex() && !msg.hasRiskProductComplex()) && !FixUtils.equals(getRiskProductComplex(), msg.getRiskProductComplex())) return false;
		if ((hasRiskSecurityGroup() && !msg.hasRiskSecurityGroup()) || (!hasRiskSecurityGroup() && msg.hasRiskSecurityGroup())) return false;
		if (!(!hasRiskSecurityGroup() && !msg.hasRiskSecurityGroup()) && !FixUtils.equals(getRiskSecurityGroup(), msg.getRiskSecurityGroup())) return false;
		if ((hasRiskCFICode() && !msg.hasRiskCFICode()) || (!hasRiskCFICode() && msg.hasRiskCFICode())) return false;
		if (!(!hasRiskCFICode() && !msg.hasRiskCFICode()) && !FixUtils.equals(getRiskCFICode(), msg.getRiskCFICode())) return false;
		if ((hasRiskSecurityType() && !msg.hasRiskSecurityType()) || (!hasRiskSecurityType() && msg.hasRiskSecurityType())) return false;
		if (!(!hasRiskSecurityType() && !msg.hasRiskSecurityType()) && !FixUtils.equals(getRiskSecurityType(), msg.getRiskSecurityType())) return false;
		if ((hasRiskSecuritySubType() && !msg.hasRiskSecuritySubType()) || (!hasRiskSecuritySubType() && msg.hasRiskSecuritySubType())) return false;
		if (!(!hasRiskSecuritySubType() && !msg.hasRiskSecuritySubType()) && !FixUtils.equals(getRiskSecuritySubType(), msg.getRiskSecuritySubType())) return false;
		if ((hasRiskMaturityMonthYear() && !msg.hasRiskMaturityMonthYear()) || (!hasRiskMaturityMonthYear() && msg.hasRiskMaturityMonthYear())) return false;
		if (!(!hasRiskMaturityMonthYear() && !msg.hasRiskMaturityMonthYear()) && !FixUtils.equals(getRiskMaturityMonthYear(), msg.getRiskMaturityMonthYear())) return false;
		if ((hasRiskMaturityTime() && !msg.hasRiskMaturityTime()) || (!hasRiskMaturityTime() && msg.hasRiskMaturityTime())) return false;
		if ((hasRiskRestructuringType() && !msg.hasRiskRestructuringType()) || (!hasRiskRestructuringType() && msg.hasRiskRestructuringType())) return false;
		if (!(!hasRiskRestructuringType() && !msg.hasRiskRestructuringType()) && !FixUtils.equals(getRiskRestructuringType(), msg.getRiskRestructuringType())) return false;
		if ((hasRiskSeniority() && !msg.hasRiskSeniority()) || (!hasRiskSeniority() && msg.hasRiskSeniority())) return false;
		if (!(!hasRiskSeniority() && !msg.hasRiskSeniority()) && !FixUtils.equals(getRiskSeniority(), msg.getRiskSeniority())) return false;
		if ((hasRiskPutOrCall() && !msg.hasRiskPutOrCall()) || (!hasRiskPutOrCall() && msg.hasRiskPutOrCall())) return false;
		if (!(!hasRiskPutOrCall() && !msg.hasRiskPutOrCall()) && !(getRiskPutOrCall()==msg.getRiskPutOrCall())) return false;
		if ((hasRiskFlexibleIndicator() && !msg.hasRiskFlexibleIndicator()) || (!hasRiskFlexibleIndicator() && msg.hasRiskFlexibleIndicator())) return false;
		if (!(!hasRiskFlexibleIndicator() && !msg.hasRiskFlexibleIndicator()) && !(getRiskFlexibleIndicator()==msg.getRiskFlexibleIndicator())) return false;
		if ((hasRiskCouponRate() && !msg.hasRiskCouponRate()) || (!hasRiskCouponRate() && msg.hasRiskCouponRate())) return false;
		if (!(!hasRiskCouponRate() && !msg.hasRiskCouponRate()) && !(getRiskCouponRate()==msg.getRiskCouponRate())) return false;
		if ((hasRiskSecurityExchange() && !msg.hasRiskSecurityExchange()) || (!hasRiskSecurityExchange() && msg.hasRiskSecurityExchange())) return false;
		if (!(!hasRiskSecurityExchange() && !msg.hasRiskSecurityExchange()) && !FixUtils.equals(getRiskSecurityExchange(), msg.getRiskSecurityExchange())) return false;
		if ((hasRiskSecurityDesc() && !msg.hasRiskSecurityDesc()) || (!hasRiskSecurityDesc() && msg.hasRiskSecurityDesc())) return false;
		if (!(!hasRiskSecurityDesc() && !msg.hasRiskSecurityDesc()) && !FixUtils.equals(getRiskSecurityDesc(), msg.getRiskSecurityDesc())) return false;
		if ((hasRiskEncodedSecurityDescLen() && !msg.hasRiskEncodedSecurityDescLen()) || (!hasRiskEncodedSecurityDescLen() && msg.hasRiskEncodedSecurityDescLen())) return false;
		if (!(!hasRiskEncodedSecurityDescLen() && !msg.hasRiskEncodedSecurityDescLen()) && !(getRiskEncodedSecurityDescLen()==msg.getRiskEncodedSecurityDescLen())) return false;
		if ((hasRiskEncodedSecurityDesc() && !msg.hasRiskEncodedSecurityDesc()) || (!hasRiskEncodedSecurityDesc() && msg.hasRiskEncodedSecurityDesc())) return false;
		if (!(!hasRiskEncodedSecurityDesc() && !msg.hasRiskEncodedSecurityDesc()) && !FixUtils.equals(getRiskEncodedSecurityDesc(), msg.getRiskEncodedSecurityDesc())) return false;
		if ((hasRiskInstrumentSettlType() && !msg.hasRiskInstrumentSettlType()) || (!hasRiskInstrumentSettlType() && msg.hasRiskInstrumentSettlType())) return false;
		if (!(!hasRiskInstrumentSettlType() && !msg.hasRiskInstrumentSettlType()) && !FixUtils.equals(getRiskInstrumentSettlType(), msg.getRiskInstrumentSettlType())) return false;
		if ((hasRiskInstrumentMultiplier() && !msg.hasRiskInstrumentMultiplier()) || (!hasRiskInstrumentMultiplier() && msg.hasRiskInstrumentMultiplier())) return false;
		if (!(!hasRiskInstrumentMultiplier() && !msg.hasRiskInstrumentMultiplier()) && !(getRiskInstrumentMultiplier()==msg.getRiskInstrumentMultiplier())) return false;
		return true;
	}
	public FixRiskInstrumentScope clone ( FixRiskInstrumentScope out ) {
		if ( hasRiskInstrumentOperator())
			out.setRiskInstrumentOperator(getRiskInstrumentOperator());
		if ( hasRiskSymbol())
			out.setRiskSymbol(getRiskSymbol());
		if ( hasRiskSymbolSfx())
			out.setRiskSymbolSfx(getRiskSymbolSfx());
		if ( hasRiskSecurityID())
			out.setRiskSecurityID(getRiskSecurityID());
		if ( hasRiskSecurityIDSource())
			out.setRiskSecurityIDSource(getRiskSecurityIDSource());
		if ( hasRiskProduct())
			out.setRiskProduct(getRiskProduct());
		if ( hasRiskProductComplex())
			out.setRiskProductComplex(getRiskProductComplex());
		if ( hasRiskSecurityGroup())
			out.setRiskSecurityGroup(getRiskSecurityGroup());
		if ( hasRiskCFICode())
			out.setRiskCFICode(getRiskCFICode());
		if ( hasRiskSecurityType())
			out.setRiskSecurityType(getRiskSecurityType());
		if ( hasRiskSecuritySubType())
			out.setRiskSecuritySubType(getRiskSecuritySubType());
		if ( hasRiskMaturityMonthYear())
			out.setRiskMaturityMonthYear(getRiskMaturityMonthYear());
		if ( hasRiskMaturityTime())
			out.setRiskMaturityTime(getRiskMaturityTime());
		if ( hasRiskRestructuringType())
			out.setRiskRestructuringType(getRiskRestructuringType());
		if ( hasRiskSeniority())
			out.setRiskSeniority(getRiskSeniority());
		if ( hasRiskPutOrCall())
			out.setRiskPutOrCall(getRiskPutOrCall());
		if ( hasRiskFlexibleIndicator())
			out.setRiskFlexibleIndicator(getRiskFlexibleIndicator());
		if ( hasRiskCouponRate())
			out.setRiskCouponRate(getRiskCouponRate());
		if ( hasRiskSecurityExchange())
			out.setRiskSecurityExchange(getRiskSecurityExchange());
		if ( hasRiskSecurityDesc())
			out.setRiskSecurityDesc(getRiskSecurityDesc());
		if ( hasRiskEncodedSecurityDescLen())
			out.setRiskEncodedSecurityDescLen(getRiskEncodedSecurityDescLen());
		if ( hasRiskEncodedSecurityDesc())
			out.setRiskEncodedSecurityDesc(getRiskEncodedSecurityDesc());
		if ( hasRiskInstrumentSettlType())
			out.setRiskInstrumentSettlType(getRiskInstrumentSettlType());
		if ( hasRiskInstrumentMultiplier())
			out.setRiskInstrumentMultiplier(getRiskInstrumentMultiplier());
		int count = 0;
		count = 0;
		for (FixRiskSecAltIDGrp fixRiskSecAltIDGrp : riskSecAltIDGrp) {
			if (!fixRiskSecAltIDGrp.hasGroup()) continue;
			out.riskSecAltIDGrp[count] = fixRiskSecAltIDGrp.clone( out.riskSecAltIDGrp[count] );
			count++;
		}
		return out;
	}

}
