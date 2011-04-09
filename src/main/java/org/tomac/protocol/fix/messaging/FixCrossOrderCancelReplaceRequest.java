package org.tomac.protocol.fix.messaging;

import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixValidationError;
import java.nio.ByteBuffer;
import org.tomac.protocol.fix.messaging.FixTags;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.FixUtils;
		
public class FixCrossOrderCancelReplaceRequest extends FixInMessage {
	private short hasOrderID;
	byte[] orderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCrossID;
	byte[] crossID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasOrigCrossID;
	byte[] origCrossID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasHostCrossID;
	byte[] hostCrossID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasCrossType;
	long crossType = 0;		
	private short hasCrossPrioritization;
	long crossPrioritization = 0;		
	private short hasSettlType;
	byte[] settlType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasSettlDate;
	byte[] settlDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasHandlInst;
	byte handlInst = (byte)' ';		
	private short hasExecInst;
	byte[] execInst = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasMinQty;
	long minQty = 0;		
	private short hasMatchIncrement;
	long matchIncrement = 0;		
	private short hasMaxPriceLevels;
	long maxPriceLevels = 0;		
	private short hasMaxFloor;
	long maxFloor = 0;		
	private short hasExDestination;
	byte[] exDestination = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasExDestinationIDSource;
	byte exDestinationIDSource = (byte)' ';		
	private short hasProcessCode;
	byte processCode = (byte)' ';		
	private short hasPrevClosePx;
	long prevClosePx = 0;		
	private short hasLocateReqd;
		boolean locateReqd = false;		
	private short hasTransactTime;
	byte[] transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasTransBkdTime;
	byte[] transBkdTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasOrdType;
	byte ordType = (byte)' ';		
	private short hasPriceType;
	long priceType = 0;		
	private short hasPrice;
	long price = 0;		
	private short hasPriceProtectionScope;
	byte priceProtectionScope = (byte)' ';		
	private short hasStopPx;
	long stopPx = 0;		
	private short hasCurrency;
	byte[] currency = new byte[FixUtils.CURRENCY_LENGTH];		
	private short hasComplianceID;
	byte[] complianceID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasIOIID;
	byte[] iOIID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasQuoteID;
	byte[] quoteID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasTimeInForce;
	byte timeInForce = (byte)' ';		
	private short hasEffectiveTime;
	byte[] effectiveTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasExpireDate;
	byte[] expireDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasExpireTime;
	byte[] expireTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
	private short hasGTBookingInst;
	long gTBookingInst = 0;		
	private short hasMaxShow;
	long maxShow = 0;		
	private short hasTargetStrategy;
	long targetStrategy = 0;		
	private short hasTargetStrategyParameters;
	byte[] targetStrategyParameters = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasParticipationRate;
	long participationRate = 0;		
	private short hasCancellationRights;
	byte cancellationRights = (byte)' ';		
	private short hasMoneyLaunderingStatus;
	byte moneyLaunderingStatus = (byte)' ';		
	private short hasRegistID;
	byte[] registID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	private short hasDesignation;
	byte[] designation = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
	public FixRootParties[] rootParties;
	public FixSideCrossOrdModGrp[] sideCrossOrdModGrp;
	public FixInstrument instrument;
	public FixUndInstrmtGrp[] undInstrmtGrp;
	public FixInstrmtLegGrp[] instrmtLegGrp;
	public FixDisplayInstruction displayInstruction;
	public FixTrdgSesGrp[] trdgSesGrp;
	public FixStipulations[] stipulations;
	public FixTriggeringInstruction triggeringInstruction;
	public FixSpreadOrBenchmarkCurveData spreadOrBenchmarkCurveData;
	public FixYieldData yieldData;
	public FixPegInstructions pegInstructions;
	public FixDiscretionInstructions discretionInstructions;
	public FixStrategyParametersGrp[] strategyParametersGrp;
	
	public FixCrossOrderCancelReplaceRequest() {
		super(FixMessageInfo.MessageTypes.CROSSORDERCANCELREPLACEREQUEST);


		hasOrderID = FixUtils.TAG_HAS_NO_VALUE;		
		orderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCrossID = FixUtils.TAG_HAS_NO_VALUE;		
		crossID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasOrigCrossID = FixUtils.TAG_HAS_NO_VALUE;		
		origCrossID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasHostCrossID = FixUtils.TAG_HAS_NO_VALUE;		
		hostCrossID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasCrossType = FixUtils.TAG_HAS_NO_VALUE;		
		hasCrossPrioritization = FixUtils.TAG_HAS_NO_VALUE;		
		hasSettlType = FixUtils.TAG_HAS_NO_VALUE;		
		settlType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasSettlDate = FixUtils.TAG_HAS_NO_VALUE;		
		settlDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasHandlInst = FixUtils.TAG_HAS_NO_VALUE;		
		hasExecInst = FixUtils.TAG_HAS_NO_VALUE;		
		execInst = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasMinQty = FixUtils.TAG_HAS_NO_VALUE;		
		hasMatchIncrement = FixUtils.TAG_HAS_NO_VALUE;		
		hasMaxPriceLevels = FixUtils.TAG_HAS_NO_VALUE;		
		hasMaxFloor = FixUtils.TAG_HAS_NO_VALUE;		
		hasExDestination = FixUtils.TAG_HAS_NO_VALUE;		
		exDestination = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasExDestinationIDSource = FixUtils.TAG_HAS_NO_VALUE;		
		hasProcessCode = FixUtils.TAG_HAS_NO_VALUE;		
		hasPrevClosePx = FixUtils.TAG_HAS_NO_VALUE;		
		hasLocateReqd = FixUtils.TAG_HAS_NO_VALUE;		
		hasTransactTime = FixUtils.TAG_HAS_NO_VALUE;		
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasTransBkdTime = FixUtils.TAG_HAS_NO_VALUE;		
		transBkdTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasOrdType = FixUtils.TAG_HAS_NO_VALUE;		
		hasPriceType = FixUtils.TAG_HAS_NO_VALUE;		
		hasPrice = FixUtils.TAG_HAS_NO_VALUE;		
		hasPriceProtectionScope = FixUtils.TAG_HAS_NO_VALUE;		
		hasStopPx = FixUtils.TAG_HAS_NO_VALUE;		
		hasCurrency = FixUtils.TAG_HAS_NO_VALUE;		
		currency = new byte[FixUtils.CURRENCY_LENGTH];		
		hasComplianceID = FixUtils.TAG_HAS_NO_VALUE;		
		complianceID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasIOIID = FixUtils.TAG_HAS_NO_VALUE;		
		iOIID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasQuoteID = FixUtils.TAG_HAS_NO_VALUE;		
		quoteID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasTimeInForce = FixUtils.TAG_HAS_NO_VALUE;		
		hasEffectiveTime = FixUtils.TAG_HAS_NO_VALUE;		
		effectiveTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasExpireDate = FixUtils.TAG_HAS_NO_VALUE;		
		expireDate = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasExpireTime = FixUtils.TAG_HAS_NO_VALUE;		
		expireTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];		
		hasGTBookingInst = FixUtils.TAG_HAS_NO_VALUE;		
		hasMaxShow = FixUtils.TAG_HAS_NO_VALUE;		
		hasTargetStrategy = FixUtils.TAG_HAS_NO_VALUE;		
		hasTargetStrategyParameters = FixUtils.TAG_HAS_NO_VALUE;		
		targetStrategyParameters = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasParticipationRate = FixUtils.TAG_HAS_NO_VALUE;		
		hasCancellationRights = FixUtils.TAG_HAS_NO_VALUE;		
		hasMoneyLaunderingStatus = FixUtils.TAG_HAS_NO_VALUE;		
		hasRegistID = FixUtils.TAG_HAS_NO_VALUE;		
		registID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		hasDesignation = FixUtils.TAG_HAS_NO_VALUE;		
		designation = new byte[FixUtils.FIX_MAX_STRING_LENGTH];		
		rootParties = new FixRootParties[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) rootParties[i] = new FixRootParties();
		sideCrossOrdModGrp = new FixSideCrossOrdModGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) sideCrossOrdModGrp[i] = new FixSideCrossOrdModGrp();
		instrument = new FixInstrument();
		undInstrmtGrp = new FixUndInstrmtGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) undInstrmtGrp[i] = new FixUndInstrmtGrp();
		instrmtLegGrp = new FixInstrmtLegGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) instrmtLegGrp[i] = new FixInstrmtLegGrp();
		displayInstruction = new FixDisplayInstruction();
		trdgSesGrp = new FixTrdgSesGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) trdgSesGrp[i] = new FixTrdgSesGrp();
		stipulations = new FixStipulations[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) stipulations[i] = new FixStipulations();
		triggeringInstruction = new FixTriggeringInstruction();
		spreadOrBenchmarkCurveData = new FixSpreadOrBenchmarkCurveData();
		yieldData = new FixYieldData();
		pegInstructions = new FixPegInstructions();
		discretionInstructions = new FixDiscretionInstructions();
		strategyParametersGrp = new FixStrategyParametersGrp[FixUtils.FIX_MAX_NOINGROUP];
		for (int i= 0; i<FixUtils.FIX_MAX_NOINGROUP; i++) strategyParametersGrp[i] = new FixStrategyParametersGrp();

	}

    public void setBuffer( ByteBuffer buf, FixValidationError err)		
    {		
				
		super.setBuffer(buf, err);
        if (err.hasError()) return;

        int tag = FixUtils.getTag(buf, err);
        if (err.hasError()) return;

        while ( buf.hasRemaining() ) {

            switch (tag) {		
            	case FixTags.ORDERID_INT:		
            		hasOrderID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.CROSSID_INT:		
            		hasCrossID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.ORIGCROSSID_INT:		
            		hasOrigCrossID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.HOSTCROSSID_INT:		
            		hasHostCrossID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.CROSSTYPE_INT:		
            		hasCrossType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.CROSSPRIORITIZATION_INT:		
            		hasCrossPrioritization = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SETTLTYPE_INT:		
            		hasSettlType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.SETTLDATE_INT:		
            		hasSettlDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.HANDLINST_INT:		
            		hasHandlInst = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.EXECINST_INT:		
            		hasExecInst = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MINQTY_INT:		
            		hasMinQty = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MATCHINCREMENT_INT:		
            		hasMatchIncrement = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MAXPRICELEVELS_INT:		
            		hasMaxPriceLevels = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MAXFLOOR_INT:		
            		hasMaxFloor = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.EXDESTINATION_INT:		
            		hasExDestination = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.EXDESTINATIONIDSOURCE_INT:		
            		hasExDestinationIDSource = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.PROCESSCODE_INT:		
            		hasProcessCode = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.PREVCLOSEPX_INT:		
            		hasPrevClosePx = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.LOCATEREQD_INT:		
            		hasLocateReqd = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRANSACTTIME_INT:		
            		hasTransactTime = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TRANSBKDTIME_INT:		
            		hasTransBkdTime = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.ORDTYPE_INT:		
            		hasOrdType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.PRICETYPE_INT:		
            		hasPriceType = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.PRICE_INT:		
            		hasPrice = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.PRICEPROTECTIONSCOPE_INT:		
            		hasPriceProtectionScope = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.STOPPX_INT:		
            		hasStopPx = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.CURRENCY_INT:		
            		hasCurrency = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.COMPLIANCEID_INT:		
            		hasComplianceID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.IOIID_INT:		
            		hasIOIID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.QUOTEID_INT:		
            		hasQuoteID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TIMEINFORCE_INT:		
            		hasTimeInForce = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.EFFECTIVETIME_INT:		
            		hasEffectiveTime = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.EXPIREDATE_INT:		
            		hasExpireDate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.EXPIRETIME_INT:		
            		hasExpireTime = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.GTBOOKINGINST_INT:		
            		hasGTBookingInst = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MAXSHOW_INT:		
            		hasMaxShow = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TARGETSTRATEGY_INT:		
            		hasTargetStrategy = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.TARGETSTRATEGYPARAMETERS_INT:		
            		hasTargetStrategyParameters = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.PARTICIPATIONRATE_INT:		
            		hasParticipationRate = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.CANCELLATIONRIGHTS_INT:		
            		hasCancellationRights = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.MONEYLAUNDERINGSTATUS_INT:		
            		hasMoneyLaunderingStatus = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.REGISTID_INT:		
            		hasRegistID = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	case FixTags.DESIGNATION_INT:		
            		hasDesignation = (short) buf.position();		
            		FixUtils.getNext(buf, err);		
                	break;
            	default:
        			if ( standardHeader.isKeyTag(tag)) {
        				tag = standardHeader.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( standardTrailer.isKeyTag(tag)) {
        				tag = standardTrailer.setBuffer( tag, buf, err);
        				FixUtils.unreadLastTag(tag, buf);
        				if (!err.hasError()) hasRequiredTags(err);
            			return; // always last, we are done now
        			} else if ( tag == FixTags.NOROOTPARTYIDS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !rootParties[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NOROOTPARTYIDS_INT);
        						return;
        					}
        					count++;
        					repeatingGroupTag = rootParties[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOSIDES_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !sideCrossOrdModGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NOSIDES_INT);
        						return;
        					}
        					count++;
        					repeatingGroupTag = sideCrossOrdModGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( instrument.isKeyTag(tag)) {
        				tag = instrument.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NOUNDERLYINGS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !undInstrmtGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NOUNDERLYINGS_INT);
        						return;
        					}
        					count++;
        					repeatingGroupTag = undInstrmtGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOLEGS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !instrmtLegGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NOLEGS_INT);
        						return;
        					}
        					count++;
        					repeatingGroupTag = instrmtLegGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( displayInstruction.isKeyTag(tag)) {
        				tag = displayInstruction.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NOTRADINGSESSIONS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !trdgSesGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NOTRADINGSESSIONS_INT);
        						return;
        					}
        					count++;
        					repeatingGroupTag = trdgSesGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( tag == FixTags.NOSTIPULATIONS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !stipulations[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NOSTIPULATIONS_INT);
        						return;
        					}
        					count++;
        					repeatingGroupTag = stipulations[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
        			} else if ( triggeringInstruction.isKeyTag(tag)) {
        				tag = triggeringInstruction.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( spreadOrBenchmarkCurveData.isKeyTag(tag)) {
        				tag = spreadOrBenchmarkCurveData.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( yieldData.isKeyTag(tag)) {
        				tag = yieldData.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( pegInstructions.isKeyTag(tag)) {
        				tag = pegInstructions.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( discretionInstructions.isKeyTag(tag)) {
        				tag = discretionInstructions.setBuffer( tag, buf, err);		
            			if (err.hasError()) break; 		
                		else continue;		
        			} else if ( tag == FixTags.NOSTRATEGYPARAMETERS_INT ) {
        				int count = 0;
        				int noInGroupNumber = FixUtils.getTagIntValue(buf, err);
        				if (err.hasError()) break;

        				int repeatingGroupTag = FixUtils.getTag(buf, err);
        				if (err.hasError()) break;
        				if (noInGroupNumber <= 0 || noInGroupNumber > FixUtils.FIX_MAX_NOINGROUP) { err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "no in group count exceeding max", tag);
        							return; }
        				while ( count < noInGroupNumber ) {
        					if ( !strategyParametersGrp[count].isKeyTag(repeatingGroupTag) ) {
        						err.setError((int)FixMessageInfo.SessionRejectReason.INCORRECT_NUMINGROUP_COUNT_FOR_REPEATING_GROUP, "Incorrect NumInGroup count for repeating group", FixTags.NOSTRATEGYPARAMETERS_INT);
        						return;
        					}
        					count++;
        					repeatingGroupTag = strategyParametersGrp[count].setBuffer( repeatingGroupTag, buf, err);	
        					if (err.hasError()) break; 		
        				}
        				if (err.hasError()) break;
                		else { tag = repeatingGroupTag; continue; }
            		} else {
 						FixUtils.getNext(buf, err);		
                		if (err.hasError()) break; 		
                		else if (FixUtils.validateOnlyDefinedTagsAllowed) {
                			err.setError((int)FixMessageInfo.SessionRejectReason.TAG_NOT_DEFINED_FOR_THIS_MESSAGE_TYPE, "Tag not defined for this message type", tag, FixMessageInfo.MessageTypes.CROSSORDERCANCELREPLACEREQUEST_INT);
                			break;
                		}
					}

			}

        		if (err.hasError()) return;

            	tag = FixUtils.getTag(buf, err);		
        		if (err.hasError()) break;

		}

	}		

	public boolean hasRequiredTags(FixValidationError err) {
		if (!hasCrossID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.CROSSID_INT, FixMessageInfo.MessageTypes.CROSSORDERCANCELREPLACEREQUEST_INT);
			return false;
		}
		if (!hasOrigCrossID()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.ORIGCROSSID_INT, FixMessageInfo.MessageTypes.CROSSORDERCANCELREPLACEREQUEST_INT);
			return false;
		}
		if (!hasCrossType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.CROSSTYPE_INT, FixMessageInfo.MessageTypes.CROSSORDERCANCELREPLACEREQUEST_INT);
			return false;
		}
		if (!hasCrossPrioritization()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.CROSSPRIORITIZATION_INT, FixMessageInfo.MessageTypes.CROSSORDERCANCELREPLACEREQUEST_INT);
			return false;
		}
		if (!hasTransactTime()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.TRANSACTTIME_INT, FixMessageInfo.MessageTypes.CROSSORDERCANCELREPLACEREQUEST_INT);
			return false;
		}
		if (!hasOrdType()) { 
			err.setError((int)FixMessageInfo.SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing", FixTags.ORDTYPE_INT, FixMessageInfo.MessageTypes.CROSSORDERCANCELREPLACEREQUEST_INT);
			return false;
		}
		for (int i = 0; i< FixUtils.FIX_MAX_NOINGROUP; i++) { if (sideCrossOrdModGrp[i].hasGroup()) sideCrossOrdModGrp[i].hasRequiredTags(err); if (err.hasError()) return false; }
		if (instrument.isRequired) instrument.hasRequiredTags(err); if (err.hasError()) return false;
		return true;
	}
	@Override		
	public void getAll() {		
		getOrderID();		
		getCrossID();		
		getOrigCrossID();		
		getHostCrossID();		
		getCrossType();		
		getCrossPrioritization();		
		getSettlType();		
		getSettlDate();		
		getHandlInst();		
		getExecInst();		
		getMinQty();		
		getMatchIncrement();		
		getMaxPriceLevels();		
		getMaxFloor();		
		getExDestination();		
		getExDestinationIDSource();		
		getProcessCode();		
		getPrevClosePx();		
		getLocateReqd();		
		getTransactTime();		
		getTransBkdTime();		
		getOrdType();		
		getPriceType();		
		getPrice();		
		getPriceProtectionScope();		
		getStopPx();		
		getCurrency();		
		getComplianceID();		
		getIOIID();		
		getQuoteID();		
		getTimeInForce();		
		getEffectiveTime();		
		getExpireDate();		
		getExpireTime();		
		getGTBookingInst();		
		getMaxShow();		
		getTargetStrategy();		
		getTargetStrategyParameters();		
		getParticipationRate();		
		getCancellationRights();		
		getMoneyLaunderingStatus();		
		getRegistID();		
		getDesignation();		
	}		
		
	@Override		
	public int encode(ByteBuffer out) {

		int startPos = out.position();
		super.standardHeader.setBodyLength(1000);

		// if this is the standardHeader for an out-bound message wee need to set default tags
		if (buf == null) {
			super.standardHeader.setBeginString(FixMessageInfo.BEGINSTRING_VALUE);
		}

		super.standardHeader.encode(out);
		if (hasOrderID()) {		
			out.put(FixTags.ORDERID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,orderID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCrossID()) {		
			out.put(FixTags.CROSSID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,crossID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOrigCrossID()) {		
			out.put(FixTags.ORIGCROSSID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,origCrossID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasHostCrossID()) {		
			out.put(FixTags.HOSTCROSSID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,hostCrossID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCrossType()) {		
			out.put(FixTags.CROSSTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)crossType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCrossPrioritization()) {		
			out.put(FixTags.CROSSPRIORITIZATION);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)crossPrioritization);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSettlType()) {		
			out.put(FixTags.SETTLTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,settlType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasSettlDate()) {		
			out.put(FixTags.SETTLDATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,settlDate); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasHandlInst()) {		
			out.put(FixTags.HANDLINST);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,handlInst); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasExecInst()) {		
			out.put(FixTags.EXECINST);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,execInst); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMinQty()) {		
			out.put(FixTags.MINQTY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)minQty);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMatchIncrement()) {		
			out.put(FixTags.MATCHINCREMENT);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)matchIncrement);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMaxPriceLevels()) {		
			out.put(FixTags.MAXPRICELEVELS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)maxPriceLevels);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMaxFloor()) {		
			out.put(FixTags.MAXFLOOR);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)maxFloor);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasExDestination()) {		
			out.put(FixTags.EXDESTINATION);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,exDestination); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasExDestinationIDSource()) {		
			out.put(FixTags.EXDESTINATIONIDSOURCE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,exDestinationIDSource); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasProcessCode()) {		
			out.put(FixTags.PROCESSCODE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,processCode); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPrevClosePx()) {		
			out.put(FixTags.PREVCLOSEPX);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)prevClosePx);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasLocateReqd()) {		
			out.put(FixTags.LOCATEREQD);		
		
			out.put((byte) '=');		
		
			out.put(locateReqd?(byte)'Y':(byte)'N' );
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTransactTime()) {		
			out.put(FixTags.TRANSACTTIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,transactTime); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTransBkdTime()) {		
			out.put(FixTags.TRANSBKDTIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,transBkdTime); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasOrdType()) {		
			out.put(FixTags.ORDTYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,ordType); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPriceType()) {		
			out.put(FixTags.PRICETYPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)priceType);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPrice()) {		
			out.put(FixTags.PRICE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)price);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasPriceProtectionScope()) {		
			out.put(FixTags.PRICEPROTECTIONSCOPE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,priceProtectionScope); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasStopPx()) {		
			out.put(FixTags.STOPPX);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)stopPx);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCurrency()) {		
			out.put(FixTags.CURRENCY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,currency); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasComplianceID()) {		
			out.put(FixTags.COMPLIANCEID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,complianceID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasIOIID()) {		
			out.put(FixTags.IOIID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,iOIID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasQuoteID()) {		
			out.put(FixTags.QUOTEID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,quoteID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTimeInForce()) {		
			out.put(FixTags.TIMEINFORCE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,timeInForce); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasEffectiveTime()) {		
			out.put(FixTags.EFFECTIVETIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,effectiveTime); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasExpireDate()) {		
			out.put(FixTags.EXPIREDATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,expireDate); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasExpireTime()) {		
			out.put(FixTags.EXPIRETIME);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,expireTime); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasGTBookingInst()) {		
			out.put(FixTags.GTBOOKINGINST);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)gTBookingInst);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMaxShow()) {		
			out.put(FixTags.MAXSHOW);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)maxShow);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTargetStrategy()) {		
			out.put(FixTags.TARGETSTRATEGY);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)targetStrategy);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasTargetStrategyParameters()) {		
			out.put(FixTags.TARGETSTRATEGYPARAMETERS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,targetStrategyParameters); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasParticipationRate()) {		
			out.put(FixTags.PARTICIPATIONRATE);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out, (long)participationRate);
		
			out.put(FixUtils.SOH);		
		}		
		if (hasCancellationRights()) {		
			out.put(FixTags.CANCELLATIONRIGHTS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,cancellationRights); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasMoneyLaunderingStatus()) {		
			out.put(FixTags.MONEYLAUNDERINGSTATUS);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,moneyLaunderingStatus); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasRegistID()) {		
			out.put(FixTags.REGISTID);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,registID); 		
		
			out.put(FixUtils.SOH);		
		}		
		if (hasDesignation()) {		
			out.put(FixTags.DESIGNATION);		
		
			out.put((byte) '=');		
		
			FixUtils.put(out,designation); 		
		
			out.put(FixUtils.SOH);		
		}		
		
		if (FixUtils.getNoInGroup(rootParties)>0) {
			out.put(FixTags.NOROOTPARTYIDS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(rootParties));

			out.put(FixUtils.SOH);

		}
		for (FixRootParties fixRootParties : rootParties) if (fixRootParties.hasGroup()) fixRootParties.encode(out);
		if (FixUtils.getNoInGroup(sideCrossOrdModGrp)>0) {
			out.put(FixTags.NOSIDES);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(sideCrossOrdModGrp));

			out.put(FixUtils.SOH);

		}
		for (FixSideCrossOrdModGrp fixSideCrossOrdModGrp : sideCrossOrdModGrp) if (fixSideCrossOrdModGrp.hasGroup()) fixSideCrossOrdModGrp.encode(out);
		instrument.encode(out);
		if (FixUtils.getNoInGroup(undInstrmtGrp)>0) {
			out.put(FixTags.NOUNDERLYINGS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(undInstrmtGrp));

			out.put(FixUtils.SOH);

		}
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) if (fixUndInstrmtGrp.hasGroup()) fixUndInstrmtGrp.encode(out);
		if (FixUtils.getNoInGroup(instrmtLegGrp)>0) {
			out.put(FixTags.NOLEGS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(instrmtLegGrp));

			out.put(FixUtils.SOH);

		}
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp) if (fixInstrmtLegGrp.hasGroup()) fixInstrmtLegGrp.encode(out);
		displayInstruction.encode(out);
		if (FixUtils.getNoInGroup(trdgSesGrp)>0) {
			out.put(FixTags.NOTRADINGSESSIONS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(trdgSesGrp));

			out.put(FixUtils.SOH);

		}
		for (FixTrdgSesGrp fixTrdgSesGrp : trdgSesGrp) if (fixTrdgSesGrp.hasGroup()) fixTrdgSesGrp.encode(out);
		if (FixUtils.getNoInGroup(stipulations)>0) {
			out.put(FixTags.NOSTIPULATIONS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(stipulations));

			out.put(FixUtils.SOH);

		}
		for (FixStipulations fixStipulations : stipulations) if (fixStipulations.hasGroup()) fixStipulations.encode(out);
		triggeringInstruction.encode(out);
		spreadOrBenchmarkCurveData.encode(out);
		yieldData.encode(out);
		pegInstructions.encode(out);
		discretionInstructions.encode(out);
		if (FixUtils.getNoInGroup(strategyParametersGrp)>0) {
			out.put(FixTags.NOSTRATEGYPARAMETERS);

			out.put((byte) '=' );

			FixUtils.put(out, FixUtils.getNoInGroup(strategyParametersGrp));

			out.put(FixUtils.SOH);

		}
		for (FixStrategyParametersGrp fixStrategyParametersGrp : strategyParametersGrp) if (fixStrategyParametersGrp.hasGroup()) fixStrategyParametersGrp.encode(out);
		
		// set body length

		int endPos = out.position();

		super.standardHeader.setBodyLength(endPos - FixUtils.FIX_MESSAGE_START);

		out.position(startPos + FixUtils.FIX_HEADER);

		if (super.standardHeader.getBodyLength()>999) {
			FixUtils.put(out, super.standardHeader.getBodyLength());
		} else if (super.standardHeader.getBodyLength()>99) {
			FixUtils.put(out, 0);
			FixUtils.put(out, super.standardHeader.getBodyLength());
		} else {
			FixUtils.put(out, 0);
			FixUtils.put(out, 0);
			FixUtils.put(out, super.standardHeader.getBodyLength());
		}
		final byte[] tmpCheckSum = new byte[FixTags.CHECKSUM_LENGTH];
		FixUtils.generateCheckSum(tmpCheckSum, out, startPos, endPos);
		super.standardTrailer.setCheckSum(tmpCheckSum);

		out.position(endPos);

		super.standardTrailer.encode(out);
		out.limit(out.position());
		out.flip();

		return (int) super.standardHeader.getBodyLength();

	}			
			
			
	@Override		
	public void printBuffer(ByteBuffer out) {		
		
		int startPos = out.position();		
					
		super.standardHeader.encode(out);		
		
		if (hasOrderID()) {		
			FixUtils.put(out,orderID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCrossID()) {		
			FixUtils.put(out,crossID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrigCrossID()) {		
			FixUtils.put(out,origCrossID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasHostCrossID()) {		
			FixUtils.put(out,hostCrossID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCrossType()) {		
			FixUtils.put(out, (long)crossType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCrossPrioritization()) {		
			FixUtils.put(out, (long)crossPrioritization);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlType()) {		
			FixUtils.put(out,settlType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasSettlDate()) {		
			FixUtils.put(out,settlDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasHandlInst()) {		
			FixUtils.put(out,handlInst); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExecInst()) {		
			FixUtils.put(out,execInst); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMinQty()) {		
			FixUtils.put(out, (long)minQty);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMatchIncrement()) {		
			FixUtils.put(out, (long)matchIncrement);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMaxPriceLevels()) {		
			FixUtils.put(out, (long)maxPriceLevels);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMaxFloor()) {		
			FixUtils.put(out, (long)maxFloor);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExDestination()) {		
			FixUtils.put(out,exDestination); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExDestinationIDSource()) {		
			FixUtils.put(out,exDestinationIDSource); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasProcessCode()) {		
			FixUtils.put(out,processCode); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPrevClosePx()) {		
			FixUtils.put(out, (long)prevClosePx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasLocateReqd()) {		
			out.put(locateReqd?(byte)'Y':(byte)'N' );
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTransactTime()) {		
			FixUtils.put(out,transactTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTransBkdTime()) {		
			FixUtils.put(out,transBkdTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasOrdType()) {		
			FixUtils.put(out,ordType); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPriceType()) {		
			FixUtils.put(out, (long)priceType);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPrice()) {		
			FixUtils.put(out, (long)price);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasPriceProtectionScope()) {		
			FixUtils.put(out,priceProtectionScope); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasStopPx()) {		
			FixUtils.put(out, (long)stopPx);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCurrency()) {		
			FixUtils.put(out,currency); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasComplianceID()) {		
			FixUtils.put(out,complianceID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasIOIID()) {		
			FixUtils.put(out,iOIID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasQuoteID()) {		
			FixUtils.put(out,quoteID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTimeInForce()) {		
			FixUtils.put(out,timeInForce); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasEffectiveTime()) {		
			FixUtils.put(out,effectiveTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExpireDate()) {		
			FixUtils.put(out,expireDate); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasExpireTime()) {		
			FixUtils.put(out,expireTime); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasGTBookingInst()) {		
			FixUtils.put(out, (long)gTBookingInst);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMaxShow()) {		
			FixUtils.put(out, (long)maxShow);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTargetStrategy()) {		
			FixUtils.put(out, (long)targetStrategy);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasTargetStrategyParameters()) {		
			FixUtils.put(out,targetStrategyParameters); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasParticipationRate()) {		
			FixUtils.put(out, (long)participationRate);
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasCancellationRights()) {		
			FixUtils.put(out,cancellationRights); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasMoneyLaunderingStatus()) {		
			FixUtils.put(out,moneyLaunderingStatus); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasRegistID()) {		
			FixUtils.put(out,registID); 		
		
	        out.put( (byte)' ' );		
		}		
		
		if (hasDesignation()) {		
			FixUtils.put(out,designation); 		
		
	        out.put( (byte)' ' );		
		}		
		
		super.standardTrailer.encode(out);		
		
		int endPos = out.position();		
		
		// set body length		
				
		super.standardHeader.setBodyLength( out.position() - startPos );		
				
		out.position(startPos + FixUtils.FIX_HEADER); 		
		
		FixUtils.put( out, super.standardHeader.getBodyLength() );		
		
		out.position(endPos);		
		
	}			
			
	public void crackOrderID() {		
		getOrderID();		
	}		
			
	public byte[] getOrderID() { 		
		if ( hasOrderID()) {		
			if (hasOrderID == FixUtils.TAG_HAS_VALUE) {		
				return orderID; 		
			} else {

				buf.position(hasOrderID);

			FixUtils.getTagStringValue(buf, orderID, 0, orderID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasOrderID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return orderID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOrderID() { return hasOrderID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOrderID(byte[] src) {		
		if (src == null ) return;
		if (hasOrderID()) FixUtils.fillNul(orderID);		
		FixUtils.copy(orderID, src); 		
		hasOrderID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrderID(String str) {		
		if (str == null ) return;
		if (hasOrderID()) FixUtils.fillNul(orderID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(orderID, src); 		
		hasOrderID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCrossID() {		
		getCrossID();		
	}		
			
	public byte[] getCrossID() { 		
		if ( hasCrossID()) {		
			if (hasCrossID == FixUtils.TAG_HAS_VALUE) {		
				return crossID; 		
			} else {

				buf.position(hasCrossID);

			FixUtils.getTagStringValue(buf, crossID, 0, crossID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasCrossID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return crossID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCrossID() { return hasCrossID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCrossID(byte[] src) {		
		if (src == null ) return;
		if (hasCrossID()) FixUtils.fillNul(crossID);		
		FixUtils.copy(crossID, src); 		
		hasCrossID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCrossID(String str) {		
		if (str == null ) return;
		if (hasCrossID()) FixUtils.fillNul(crossID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(crossID, src); 		
		hasCrossID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOrigCrossID() {		
		getOrigCrossID();		
	}		
			
	public byte[] getOrigCrossID() { 		
		if ( hasOrigCrossID()) {		
			if (hasOrigCrossID == FixUtils.TAG_HAS_VALUE) {		
				return origCrossID; 		
			} else {

				buf.position(hasOrigCrossID);

			FixUtils.getTagStringValue(buf, origCrossID, 0, origCrossID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasOrigCrossID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return origCrossID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasOrigCrossID() { return hasOrigCrossID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOrigCrossID(byte[] src) {		
		if (src == null ) return;
		if (hasOrigCrossID()) FixUtils.fillNul(origCrossID);		
		FixUtils.copy(origCrossID, src); 		
		hasOrigCrossID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrigCrossID(String str) {		
		if (str == null ) return;
		if (hasOrigCrossID()) FixUtils.fillNul(origCrossID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(origCrossID, src); 		
		hasOrigCrossID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackHostCrossID() {		
		getHostCrossID();		
	}		
			
	public byte[] getHostCrossID() { 		
		if ( hasHostCrossID()) {		
			if (hasHostCrossID == FixUtils.TAG_HAS_VALUE) {		
				return hostCrossID; 		
			} else {

				buf.position(hasHostCrossID);

			FixUtils.getTagStringValue(buf, hostCrossID, 0, hostCrossID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasHostCrossID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return hostCrossID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasHostCrossID() { return hasHostCrossID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setHostCrossID(byte[] src) {		
		if (src == null ) return;
		if (hasHostCrossID()) FixUtils.fillNul(hostCrossID);		
		FixUtils.copy(hostCrossID, src); 		
		hasHostCrossID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setHostCrossID(String str) {		
		if (str == null ) return;
		if (hasHostCrossID()) FixUtils.fillNul(hostCrossID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(hostCrossID, src); 		
		hasHostCrossID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCrossType() {		
		getCrossType();		
	}		
			
	public long getCrossType() { 		
		if ( hasCrossType()) {		
			if (hasCrossType == FixUtils.TAG_HAS_VALUE) {		
				return crossType; 		
			} else {

				buf.position(hasCrossType);

			crossType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasCrossType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return crossType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasCrossType() { return hasCrossType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCrossType(byte[] src) {		
		if (src == null ) return;
		if (hasCrossType()) crossType = FixUtils.TAG_HAS_NO_VALUE;		
		crossType = FixUtils.longValueOf(src, 0, src.length);
		hasCrossType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCrossType(long src) {		
		crossType = src;
		hasCrossType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCrossType(String str) {		
		if (str == null ) return;
		if (hasCrossType()) crossType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		crossType = FixUtils.longValueOf(src, 0, src.length);
		hasCrossType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCrossPrioritization() {		
		getCrossPrioritization();		
	}		
			
	public long getCrossPrioritization() { 		
		if ( hasCrossPrioritization()) {		
			if (hasCrossPrioritization == FixUtils.TAG_HAS_VALUE) {		
				return crossPrioritization; 		
			} else {

				buf.position(hasCrossPrioritization);

			crossPrioritization = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasCrossPrioritization = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return crossPrioritization;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasCrossPrioritization() { return hasCrossPrioritization != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCrossPrioritization(byte[] src) {		
		if (src == null ) return;
		if (hasCrossPrioritization()) crossPrioritization = FixUtils.TAG_HAS_NO_VALUE;		
		crossPrioritization = FixUtils.longValueOf(src, 0, src.length);
		hasCrossPrioritization = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCrossPrioritization(long src) {		
		crossPrioritization = src;
		hasCrossPrioritization = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCrossPrioritization(String str) {		
		if (str == null ) return;
		if (hasCrossPrioritization()) crossPrioritization = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		crossPrioritization = FixUtils.longValueOf(src, 0, src.length);
		hasCrossPrioritization = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSettlType() {		
		getSettlType();		
	}		
			
	public byte[] getSettlType() { 		
		if ( hasSettlType()) {		
			if (hasSettlType == FixUtils.TAG_HAS_VALUE) {		
				return settlType; 		
			} else {

				buf.position(hasSettlType);

			FixUtils.getTagStringValue(buf, settlType, 0, settlType.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSettlType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return settlType;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSettlType() { return hasSettlType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSettlType(byte[] src) {		
		if (src == null ) return;
		if (hasSettlType()) FixUtils.fillNul(settlType);		
		FixUtils.copy(settlType, src); 		
		hasSettlType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlType(String str) {		
		if (str == null ) return;
		if (hasSettlType()) FixUtils.fillNul(settlType);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlType, src); 		
		hasSettlType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackSettlDate() {		
		getSettlDate();		
	}		
			
	public byte[] getSettlDate() { 		
		if ( hasSettlDate()) {		
			if (hasSettlDate == FixUtils.TAG_HAS_VALUE) {		
				return settlDate; 		
			} else {

				buf.position(hasSettlDate);

			FixUtils.getTagStringValue(buf, settlDate, 0, settlDate.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasSettlDate = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return settlDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasSettlDate() { return hasSettlDate != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setSettlDate(byte[] src) {		
		if (src == null ) return;
		if (hasSettlDate()) FixUtils.fillNul(settlDate);		
		FixUtils.copy(settlDate, src); 		
		hasSettlDate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setSettlDate(String str) {		
		if (str == null ) return;
		if (hasSettlDate()) FixUtils.fillNul(settlDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(settlDate, src); 		
		hasSettlDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackHandlInst() {		
		getHandlInst();		
	}		
			
	public byte getHandlInst() { 		
		if ( hasHandlInst()) {		
			if (hasHandlInst == FixUtils.TAG_HAS_VALUE) {		
				return handlInst; 		
			} else {

				buf.position(hasHandlInst);

			handlInst = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (handlInst != (byte)'3') && (handlInst != (byte)'2') && (handlInst != (byte)'1') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 21);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasHandlInst = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return handlInst;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasHandlInst() { return hasHandlInst != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setHandlInst(byte[] src) {		
		if (src == null ) return;
		if (hasHandlInst()) handlInst = (byte)' ';		
		handlInst = src[0];		
		hasHandlInst = FixUtils.TAG_HAS_VALUE;		
	}

	public void setHandlInst(byte src) {		
		handlInst = src;
		hasHandlInst = FixUtils.TAG_HAS_VALUE;		
	}

	public void setHandlInst(String str) {		
		if (str == null ) return;
		if (hasHandlInst()) handlInst = (byte)' ';		
		byte[] src = str.getBytes(); 		
		handlInst = src[0];		
		hasHandlInst = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackExecInst() {		
		getExecInst();		
	}		
			
	public byte[] getExecInst() { 		
		if ( hasExecInst()) {		
			if (hasExecInst == FixUtils.TAG_HAS_VALUE) {		
				return execInst; 		
			} else {

				buf.position(hasExecInst);

			FixUtils.getTagStringValue(buf, execInst, 0, execInst.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasExecInst = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return execInst;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasExecInst() { return hasExecInst != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setExecInst(byte[] src) {		
		if (src == null ) return;
		if (hasExecInst()) FixUtils.fillNul(execInst);		
		FixUtils.copy(execInst, src); 		
		hasExecInst = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExecInst(String str) {		
		if (str == null ) return;
		if (hasExecInst()) FixUtils.fillNul(execInst);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(execInst, src); 		
		hasExecInst = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMinQty() {		
		getMinQty();		
	}		
			
	public long getMinQty() { 		
		if ( hasMinQty()) {		
			if (hasMinQty == FixUtils.TAG_HAS_VALUE) {		
				return minQty; 		
			} else {

				buf.position(hasMinQty);

			minQty = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasMinQty = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return minQty;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMinQty() { return hasMinQty != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMinQty(byte[] src) {		
		if (src == null ) return;
		if (hasMinQty()) minQty = FixUtils.TAG_HAS_NO_VALUE;		
		minQty = FixUtils.longValueOf(src, 0, src.length);
		hasMinQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMinQty(long src) {		
		minQty = src;
		hasMinQty = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMinQty(String str) {		
		if (str == null ) return;
		if (hasMinQty()) minQty = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		minQty = FixUtils.longValueOf(src, 0, src.length);
		hasMinQty = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMatchIncrement() {		
		getMatchIncrement();		
	}		
			
	public long getMatchIncrement() { 		
		if ( hasMatchIncrement()) {		
			if (hasMatchIncrement == FixUtils.TAG_HAS_VALUE) {		
				return matchIncrement; 		
			} else {

				buf.position(hasMatchIncrement);

			matchIncrement = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasMatchIncrement = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return matchIncrement;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMatchIncrement() { return hasMatchIncrement != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMatchIncrement(byte[] src) {		
		if (src == null ) return;
		if (hasMatchIncrement()) matchIncrement = FixUtils.TAG_HAS_NO_VALUE;		
		matchIncrement = FixUtils.longValueOf(src, 0, src.length);
		hasMatchIncrement = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMatchIncrement(long src) {		
		matchIncrement = src;
		hasMatchIncrement = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMatchIncrement(String str) {		
		if (str == null ) return;
		if (hasMatchIncrement()) matchIncrement = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		matchIncrement = FixUtils.longValueOf(src, 0, src.length);
		hasMatchIncrement = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMaxPriceLevels() {		
		getMaxPriceLevels();		
	}		
			
	public long getMaxPriceLevels() { 		
		if ( hasMaxPriceLevels()) {		
			if (hasMaxPriceLevels == FixUtils.TAG_HAS_VALUE) {		
				return maxPriceLevels; 		
			} else {

				buf.position(hasMaxPriceLevels);

			maxPriceLevels = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasMaxPriceLevels = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return maxPriceLevels;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMaxPriceLevels() { return hasMaxPriceLevels != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMaxPriceLevels(byte[] src) {		
		if (src == null ) return;
		if (hasMaxPriceLevels()) maxPriceLevels = FixUtils.TAG_HAS_NO_VALUE;		
		maxPriceLevels = FixUtils.longValueOf(src, 0, src.length);
		hasMaxPriceLevels = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMaxPriceLevels(long src) {		
		maxPriceLevels = src;
		hasMaxPriceLevels = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMaxPriceLevels(String str) {		
		if (str == null ) return;
		if (hasMaxPriceLevels()) maxPriceLevels = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		maxPriceLevels = FixUtils.longValueOf(src, 0, src.length);
		hasMaxPriceLevels = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMaxFloor() {		
		getMaxFloor();		
	}		
			
	public long getMaxFloor() { 		
		if ( hasMaxFloor()) {		
			if (hasMaxFloor == FixUtils.TAG_HAS_VALUE) {		
				return maxFloor; 		
			} else {

				buf.position(hasMaxFloor);

			maxFloor = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasMaxFloor = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return maxFloor;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMaxFloor() { return hasMaxFloor != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMaxFloor(byte[] src) {		
		if (src == null ) return;
		if (hasMaxFloor()) maxFloor = FixUtils.TAG_HAS_NO_VALUE;		
		maxFloor = FixUtils.longValueOf(src, 0, src.length);
		hasMaxFloor = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMaxFloor(long src) {		
		maxFloor = src;
		hasMaxFloor = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMaxFloor(String str) {		
		if (str == null ) return;
		if (hasMaxFloor()) maxFloor = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		maxFloor = FixUtils.longValueOf(src, 0, src.length);
		hasMaxFloor = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackExDestination() {		
		getExDestination();		
	}		
			
	public byte[] getExDestination() { 		
		if ( hasExDestination()) {		
			if (hasExDestination == FixUtils.TAG_HAS_VALUE) {		
				return exDestination; 		
			} else {

				buf.position(hasExDestination);

			FixUtils.getTagStringValue(buf, exDestination, 0, exDestination.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasExDestination = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return exDestination;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasExDestination() { return hasExDestination != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setExDestination(byte[] src) {		
		if (src == null ) return;
		if (hasExDestination()) FixUtils.fillNul(exDestination);		
		FixUtils.copy(exDestination, src); 		
		hasExDestination = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExDestination(String str) {		
		if (str == null ) return;
		if (hasExDestination()) FixUtils.fillNul(exDestination);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(exDestination, src); 		
		hasExDestination = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackExDestinationIDSource() {		
		getExDestinationIDSource();		
	}		
			
	public byte getExDestinationIDSource() { 		
		if ( hasExDestinationIDSource()) {		
			if (hasExDestinationIDSource == FixUtils.TAG_HAS_VALUE) {		
				return exDestinationIDSource; 		
			} else {

				buf.position(hasExDestinationIDSource);

			exDestinationIDSource = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (exDestinationIDSource != (byte)'D') && (exDestinationIDSource != (byte)'E') && (exDestinationIDSource != (byte)'G') && (exDestinationIDSource != (byte)'B') && (exDestinationIDSource != (byte)'C') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 1133);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasExDestinationIDSource = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return exDestinationIDSource;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasExDestinationIDSource() { return hasExDestinationIDSource != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setExDestinationIDSource(byte[] src) {		
		if (src == null ) return;
		if (hasExDestinationIDSource()) exDestinationIDSource = (byte)' ';		
		exDestinationIDSource = src[0];		
		hasExDestinationIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExDestinationIDSource(byte src) {		
		exDestinationIDSource = src;
		hasExDestinationIDSource = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExDestinationIDSource(String str) {		
		if (str == null ) return;
		if (hasExDestinationIDSource()) exDestinationIDSource = (byte)' ';		
		byte[] src = str.getBytes(); 		
		exDestinationIDSource = src[0];		
		hasExDestinationIDSource = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackProcessCode() {		
		getProcessCode();		
	}		
			
	public byte getProcessCode() { 		
		if ( hasProcessCode()) {		
			if (hasProcessCode == FixUtils.TAG_HAS_VALUE) {		
				return processCode; 		
			} else {

				buf.position(hasProcessCode);

			processCode = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (processCode != (byte)'3') && (processCode != (byte)'2') && (processCode != (byte)'1') && (processCode != (byte)'0') && (processCode != (byte)'6') && (processCode != (byte)'5') && (processCode != (byte)'4') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 81);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasProcessCode = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return processCode;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasProcessCode() { return hasProcessCode != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setProcessCode(byte[] src) {		
		if (src == null ) return;
		if (hasProcessCode()) processCode = (byte)' ';		
		processCode = src[0];		
		hasProcessCode = FixUtils.TAG_HAS_VALUE;		
	}

	public void setProcessCode(byte src) {		
		processCode = src;
		hasProcessCode = FixUtils.TAG_HAS_VALUE;		
	}

	public void setProcessCode(String str) {		
		if (str == null ) return;
		if (hasProcessCode()) processCode = (byte)' ';		
		byte[] src = str.getBytes(); 		
		processCode = src[0];		
		hasProcessCode = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackPrevClosePx() {		
		getPrevClosePx();		
	}		
			
	public long getPrevClosePx() { 		
		if ( hasPrevClosePx()) {		
			if (hasPrevClosePx == FixUtils.TAG_HAS_VALUE) {		
				return prevClosePx; 		
			} else {

				buf.position(hasPrevClosePx);

			prevClosePx = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasPrevClosePx = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return prevClosePx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPrevClosePx() { return hasPrevClosePx != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPrevClosePx(byte[] src) {		
		if (src == null ) return;
		if (hasPrevClosePx()) prevClosePx = FixUtils.TAG_HAS_NO_VALUE;		
		prevClosePx = FixUtils.longValueOf(src, 0, src.length);
		hasPrevClosePx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPrevClosePx(long src) {		
		prevClosePx = src;
		hasPrevClosePx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPrevClosePx(String str) {		
		if (str == null ) return;
		if (hasPrevClosePx()) prevClosePx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		prevClosePx = FixUtils.longValueOf(src, 0, src.length);
		hasPrevClosePx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackLocateReqd() {		
		getLocateReqd();		
	}		
			
	public boolean getLocateReqd() { 		
		if ( hasLocateReqd()) {		
			if (hasLocateReqd == FixUtils.TAG_HAS_VALUE) {		
				return locateReqd; 		
			} else {

				buf.position(hasLocateReqd);

			locateReqd = FixUtils.getTagCharValue(buf, err)=='Y'?true:false;
		
				if (err.hasError()) {		
					buf.position(0);		
					return false;		
				}		
			}		
			hasLocateReqd = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return locateReqd;		
		} else {		
			return false; 		
		}		
	}		
			
	public boolean hasLocateReqd() { return hasLocateReqd != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setLocateReqd(byte[] src) {		
		if (src == null ) return;
		if (hasLocateReqd()) locateReqd = false;		
		locateReqd = src[0]==(byte)'Y'?true:false;		
		hasLocateReqd = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLocateReqd(boolean src) {		
		locateReqd = src;
		hasLocateReqd = FixUtils.TAG_HAS_VALUE;		
	}

	public void setLocateReqd(String str) {		
		if (str == null ) return;
		if (hasLocateReqd()) locateReqd = false;		
		byte[] src = str.getBytes(); 		
		locateReqd = src[0]==(byte)'Y'?true:false;		
		hasLocateReqd = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTransactTime() {		
		getTransactTime();		
	}		
			
	public byte[] getTransactTime() { 		
		if ( hasTransactTime()) {		
			if (hasTransactTime == FixUtils.TAG_HAS_VALUE) {		
				return transactTime; 		
			} else {

				buf.position(hasTransactTime);

			FixUtils.getTagStringValue(buf, transactTime, 0, transactTime.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasTransactTime = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return transactTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTransactTime() { return hasTransactTime != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTransactTime(byte[] src) {		
		if (src == null ) return;
		if (hasTransactTime()) FixUtils.fillNul(transactTime);		
		FixUtils.copy(transactTime, src); 		
		hasTransactTime = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTransactTime(String str) {		
		if (str == null ) return;
		if (hasTransactTime()) FixUtils.fillNul(transactTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(transactTime, src); 		
		hasTransactTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTransBkdTime() {		
		getTransBkdTime();		
	}		
			
	public byte[] getTransBkdTime() { 		
		if ( hasTransBkdTime()) {		
			if (hasTransBkdTime == FixUtils.TAG_HAS_VALUE) {		
				return transBkdTime; 		
			} else {

				buf.position(hasTransBkdTime);

			FixUtils.getTagStringValue(buf, transBkdTime, 0, transBkdTime.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasTransBkdTime = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return transBkdTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTransBkdTime() { return hasTransBkdTime != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTransBkdTime(byte[] src) {		
		if (src == null ) return;
		if (hasTransBkdTime()) FixUtils.fillNul(transBkdTime);		
		FixUtils.copy(transBkdTime, src); 		
		hasTransBkdTime = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTransBkdTime(String str) {		
		if (str == null ) return;
		if (hasTransBkdTime()) FixUtils.fillNul(transBkdTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(transBkdTime, src); 		
		hasTransBkdTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackOrdType() {		
		getOrdType();		
	}		
			
	public byte getOrdType() { 		
		if ( hasOrdType()) {		
			if (hasOrdType == FixUtils.TAG_HAS_VALUE) {		
				return ordType; 		
			} else {

				buf.position(hasOrdType);

			ordType = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (ordType != (byte)'D') && (ordType != (byte)'E') && (ordType != (byte)'F') && (ordType != (byte)'G') && (ordType != (byte)'A') && (ordType != (byte)'B') && (ordType != (byte)'C') && (ordType != (byte)'L') && (ordType != (byte)'M') && (ordType != (byte)'H') && (ordType != (byte)'I') && (ordType != (byte)'J') && (ordType != (byte)'K') && (ordType != (byte)'3') && (ordType != (byte)'2') && (ordType != (byte)'1') && (ordType != (byte)'Q') && (ordType != (byte)'7') && (ordType != (byte)'P') && (ordType != (byte)'6') && (ordType != (byte)'5') && (ordType != (byte)'4') && (ordType != (byte)'9') && (ordType != (byte)'8') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 40);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasOrdType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return ordType;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasOrdType() { return hasOrdType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setOrdType(byte[] src) {		
		if (src == null ) return;
		if (hasOrdType()) ordType = (byte)' ';		
		ordType = src[0];		
		hasOrdType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrdType(byte src) {		
		ordType = src;
		hasOrdType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setOrdType(String str) {		
		if (str == null ) return;
		if (hasOrdType()) ordType = (byte)' ';		
		byte[] src = str.getBytes(); 		
		ordType = src[0];		
		hasOrdType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackPriceType() {		
		getPriceType();		
	}		
			
	public long getPriceType() { 		
		if ( hasPriceType()) {		
			if (hasPriceType == FixUtils.TAG_HAS_VALUE) {		
				return priceType; 		
			} else {

				buf.position(hasPriceType);

			priceType = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasPriceType = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return priceType;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPriceType() { return hasPriceType != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPriceType(byte[] src) {		
		if (src == null ) return;
		if (hasPriceType()) priceType = FixUtils.TAG_HAS_NO_VALUE;		
		priceType = FixUtils.longValueOf(src, 0, src.length);
		hasPriceType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPriceType(long src) {		
		priceType = src;
		hasPriceType = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPriceType(String str) {		
		if (str == null ) return;
		if (hasPriceType()) priceType = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		priceType = FixUtils.longValueOf(src, 0, src.length);
		hasPriceType = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackPrice() {		
		getPrice();		
	}		
			
	public long getPrice() { 		
		if ( hasPrice()) {		
			if (hasPrice == FixUtils.TAG_HAS_VALUE) {		
				return price; 		
			} else {

				buf.position(hasPrice);

			price = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasPrice = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return price;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasPrice() { return hasPrice != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPrice(byte[] src) {		
		if (src == null ) return;
		if (hasPrice()) price = FixUtils.TAG_HAS_NO_VALUE;		
		price = FixUtils.longValueOf(src, 0, src.length);
		hasPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPrice(long src) {		
		price = src;
		hasPrice = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPrice(String str) {		
		if (str == null ) return;
		if (hasPrice()) price = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		price = FixUtils.longValueOf(src, 0, src.length);
		hasPrice = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackPriceProtectionScope() {		
		getPriceProtectionScope();		
	}		
			
	public byte getPriceProtectionScope() { 		
		if ( hasPriceProtectionScope()) {		
			if (hasPriceProtectionScope == FixUtils.TAG_HAS_VALUE) {		
				return priceProtectionScope; 		
			} else {

				buf.position(hasPriceProtectionScope);

			priceProtectionScope = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (priceProtectionScope != (byte)'3') && (priceProtectionScope != (byte)'2') && (priceProtectionScope != (byte)'1') && (priceProtectionScope != (byte)'0') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 1092);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasPriceProtectionScope = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return priceProtectionScope;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasPriceProtectionScope() { return hasPriceProtectionScope != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setPriceProtectionScope(byte[] src) {		
		if (src == null ) return;
		if (hasPriceProtectionScope()) priceProtectionScope = (byte)' ';		
		priceProtectionScope = src[0];		
		hasPriceProtectionScope = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPriceProtectionScope(byte src) {		
		priceProtectionScope = src;
		hasPriceProtectionScope = FixUtils.TAG_HAS_VALUE;		
	}

	public void setPriceProtectionScope(String str) {		
		if (str == null ) return;
		if (hasPriceProtectionScope()) priceProtectionScope = (byte)' ';		
		byte[] src = str.getBytes(); 		
		priceProtectionScope = src[0];		
		hasPriceProtectionScope = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackStopPx() {		
		getStopPx();		
	}		
			
	public long getStopPx() { 		
		if ( hasStopPx()) {		
			if (hasStopPx == FixUtils.TAG_HAS_VALUE) {		
				return stopPx; 		
			} else {

				buf.position(hasStopPx);

			stopPx = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasStopPx = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return stopPx;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasStopPx() { return hasStopPx != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setStopPx(byte[] src) {		
		if (src == null ) return;
		if (hasStopPx()) stopPx = FixUtils.TAG_HAS_NO_VALUE;		
		stopPx = FixUtils.longValueOf(src, 0, src.length);
		hasStopPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStopPx(long src) {		
		stopPx = src;
		hasStopPx = FixUtils.TAG_HAS_VALUE;		
	}

	public void setStopPx(String str) {		
		if (str == null ) return;
		if (hasStopPx()) stopPx = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		stopPx = FixUtils.longValueOf(src, 0, src.length);
		hasStopPx = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCurrency() {		
		getCurrency();		
	}		
			
	public byte[] getCurrency() { 		
		if ( hasCurrency()) {		
			if (hasCurrency == FixUtils.TAG_HAS_VALUE) {		
				return currency; 		
			} else {

				buf.position(hasCurrency);

			FixUtils.getTagStringValue(buf, currency, 0, currency.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasCurrency = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return currency;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasCurrency() { return hasCurrency != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCurrency(byte[] src) {		
		if (src == null ) return;
		if (hasCurrency()) FixUtils.fillNul(currency);		
		FixUtils.copy(currency, src); 		
		hasCurrency = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCurrency(String str) {		
		if (str == null ) return;
		if (hasCurrency()) FixUtils.fillNul(currency);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(currency, src); 		
		hasCurrency = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackComplianceID() {		
		getComplianceID();		
	}		
			
	public byte[] getComplianceID() { 		
		if ( hasComplianceID()) {		
			if (hasComplianceID == FixUtils.TAG_HAS_VALUE) {		
				return complianceID; 		
			} else {

				buf.position(hasComplianceID);

			FixUtils.getTagStringValue(buf, complianceID, 0, complianceID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasComplianceID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return complianceID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasComplianceID() { return hasComplianceID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setComplianceID(byte[] src) {		
		if (src == null ) return;
		if (hasComplianceID()) FixUtils.fillNul(complianceID);		
		FixUtils.copy(complianceID, src); 		
		hasComplianceID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setComplianceID(String str) {		
		if (str == null ) return;
		if (hasComplianceID()) FixUtils.fillNul(complianceID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(complianceID, src); 		
		hasComplianceID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackIOIID() {		
		getIOIID();		
	}		
			
	public byte[] getIOIID() { 		
		if ( hasIOIID()) {		
			if (hasIOIID == FixUtils.TAG_HAS_VALUE) {		
				return iOIID; 		
			} else {

				buf.position(hasIOIID);

			FixUtils.getTagStringValue(buf, iOIID, 0, iOIID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasIOIID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return iOIID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasIOIID() { return hasIOIID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setIOIID(byte[] src) {		
		if (src == null ) return;
		if (hasIOIID()) FixUtils.fillNul(iOIID);		
		FixUtils.copy(iOIID, src); 		
		hasIOIID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setIOIID(String str) {		
		if (str == null ) return;
		if (hasIOIID()) FixUtils.fillNul(iOIID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(iOIID, src); 		
		hasIOIID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackQuoteID() {		
		getQuoteID();		
	}		
			
	public byte[] getQuoteID() { 		
		if ( hasQuoteID()) {		
			if (hasQuoteID == FixUtils.TAG_HAS_VALUE) {		
				return quoteID; 		
			} else {

				buf.position(hasQuoteID);

			FixUtils.getTagStringValue(buf, quoteID, 0, quoteID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasQuoteID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return quoteID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasQuoteID() { return hasQuoteID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setQuoteID(byte[] src) {		
		if (src == null ) return;
		if (hasQuoteID()) FixUtils.fillNul(quoteID);		
		FixUtils.copy(quoteID, src); 		
		hasQuoteID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setQuoteID(String str) {		
		if (str == null ) return;
		if (hasQuoteID()) FixUtils.fillNul(quoteID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(quoteID, src); 		
		hasQuoteID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTimeInForce() {		
		getTimeInForce();		
	}		
			
	public byte getTimeInForce() { 		
		if ( hasTimeInForce()) {		
			if (hasTimeInForce == FixUtils.TAG_HAS_VALUE) {		
				return timeInForce; 		
			} else {

				buf.position(hasTimeInForce);

			timeInForce = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (timeInForce != (byte)'3') && (timeInForce != (byte)'2') && (timeInForce != (byte)'1') && (timeInForce != (byte)'0') && (timeInForce != (byte)'7') && (timeInForce != (byte)'6') && (timeInForce != (byte)'5') && (timeInForce != (byte)'4') && (timeInForce != (byte)'9') && (timeInForce != (byte)'8') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 59);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasTimeInForce = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return timeInForce;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasTimeInForce() { return hasTimeInForce != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTimeInForce(byte[] src) {		
		if (src == null ) return;
		if (hasTimeInForce()) timeInForce = (byte)' ';		
		timeInForce = src[0];		
		hasTimeInForce = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTimeInForce(byte src) {		
		timeInForce = src;
		hasTimeInForce = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTimeInForce(String str) {		
		if (str == null ) return;
		if (hasTimeInForce()) timeInForce = (byte)' ';		
		byte[] src = str.getBytes(); 		
		timeInForce = src[0];		
		hasTimeInForce = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackEffectiveTime() {		
		getEffectiveTime();		
	}		
			
	public byte[] getEffectiveTime() { 		
		if ( hasEffectiveTime()) {		
			if (hasEffectiveTime == FixUtils.TAG_HAS_VALUE) {		
				return effectiveTime; 		
			} else {

				buf.position(hasEffectiveTime);

			FixUtils.getTagStringValue(buf, effectiveTime, 0, effectiveTime.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasEffectiveTime = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return effectiveTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasEffectiveTime() { return hasEffectiveTime != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setEffectiveTime(byte[] src) {		
		if (src == null ) return;
		if (hasEffectiveTime()) FixUtils.fillNul(effectiveTime);		
		FixUtils.copy(effectiveTime, src); 		
		hasEffectiveTime = FixUtils.TAG_HAS_VALUE;		
	}

	public void setEffectiveTime(String str) {		
		if (str == null ) return;
		if (hasEffectiveTime()) FixUtils.fillNul(effectiveTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(effectiveTime, src); 		
		hasEffectiveTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackExpireDate() {		
		getExpireDate();		
	}		
			
	public byte[] getExpireDate() { 		
		if ( hasExpireDate()) {		
			if (hasExpireDate == FixUtils.TAG_HAS_VALUE) {		
				return expireDate; 		
			} else {

				buf.position(hasExpireDate);

			FixUtils.getTagStringValue(buf, expireDate, 0, expireDate.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasExpireDate = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return expireDate;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasExpireDate() { return hasExpireDate != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setExpireDate(byte[] src) {		
		if (src == null ) return;
		if (hasExpireDate()) FixUtils.fillNul(expireDate);		
		FixUtils.copy(expireDate, src); 		
		hasExpireDate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExpireDate(String str) {		
		if (str == null ) return;
		if (hasExpireDate()) FixUtils.fillNul(expireDate);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(expireDate, src); 		
		hasExpireDate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackExpireTime() {		
		getExpireTime();		
	}		
			
	public byte[] getExpireTime() { 		
		if ( hasExpireTime()) {		
			if (hasExpireTime == FixUtils.TAG_HAS_VALUE) {		
				return expireTime; 		
			} else {

				buf.position(hasExpireTime);

			FixUtils.getTagStringValue(buf, expireTime, 0, expireTime.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasExpireTime = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return expireTime;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasExpireTime() { return hasExpireTime != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setExpireTime(byte[] src) {		
		if (src == null ) return;
		if (hasExpireTime()) FixUtils.fillNul(expireTime);		
		FixUtils.copy(expireTime, src); 		
		hasExpireTime = FixUtils.TAG_HAS_VALUE;		
	}

	public void setExpireTime(String str) {		
		if (str == null ) return;
		if (hasExpireTime()) FixUtils.fillNul(expireTime);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(expireTime, src); 		
		hasExpireTime = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackGTBookingInst() {		
		getGTBookingInst();		
	}		
			
	public long getGTBookingInst() { 		
		if ( hasGTBookingInst()) {		
			if (hasGTBookingInst == FixUtils.TAG_HAS_VALUE) {		
				return gTBookingInst; 		
			} else {

				buf.position(hasGTBookingInst);

			gTBookingInst = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasGTBookingInst = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return gTBookingInst;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasGTBookingInst() { return hasGTBookingInst != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setGTBookingInst(byte[] src) {		
		if (src == null ) return;
		if (hasGTBookingInst()) gTBookingInst = FixUtils.TAG_HAS_NO_VALUE;		
		gTBookingInst = FixUtils.longValueOf(src, 0, src.length);
		hasGTBookingInst = FixUtils.TAG_HAS_VALUE;		
	}

	public void setGTBookingInst(long src) {		
		gTBookingInst = src;
		hasGTBookingInst = FixUtils.TAG_HAS_VALUE;		
	}

	public void setGTBookingInst(String str) {		
		if (str == null ) return;
		if (hasGTBookingInst()) gTBookingInst = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		gTBookingInst = FixUtils.longValueOf(src, 0, src.length);
		hasGTBookingInst = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMaxShow() {		
		getMaxShow();		
	}		
			
	public long getMaxShow() { 		
		if ( hasMaxShow()) {		
			if (hasMaxShow == FixUtils.TAG_HAS_VALUE) {		
				return maxShow; 		
			} else {

				buf.position(hasMaxShow);

			maxShow = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasMaxShow = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return maxShow;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasMaxShow() { return hasMaxShow != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMaxShow(byte[] src) {		
		if (src == null ) return;
		if (hasMaxShow()) maxShow = FixUtils.TAG_HAS_NO_VALUE;		
		maxShow = FixUtils.longValueOf(src, 0, src.length);
		hasMaxShow = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMaxShow(long src) {		
		maxShow = src;
		hasMaxShow = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMaxShow(String str) {		
		if (str == null ) return;
		if (hasMaxShow()) maxShow = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		maxShow = FixUtils.longValueOf(src, 0, src.length);
		hasMaxShow = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTargetStrategy() {		
		getTargetStrategy();		
	}		
			
	public long getTargetStrategy() { 		
		if ( hasTargetStrategy()) {		
			if (hasTargetStrategy == FixUtils.TAG_HAS_VALUE) {		
				return targetStrategy; 		
			} else {

				buf.position(hasTargetStrategy);

			targetStrategy = FixUtils.getTagIntValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasTargetStrategy = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return targetStrategy;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasTargetStrategy() { return hasTargetStrategy != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTargetStrategy(byte[] src) {		
		if (src == null ) return;
		if (hasTargetStrategy()) targetStrategy = FixUtils.TAG_HAS_NO_VALUE;		
		targetStrategy = FixUtils.longValueOf(src, 0, src.length);
		hasTargetStrategy = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTargetStrategy(long src) {		
		targetStrategy = src;
		hasTargetStrategy = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTargetStrategy(String str) {		
		if (str == null ) return;
		if (hasTargetStrategy()) targetStrategy = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		targetStrategy = FixUtils.longValueOf(src, 0, src.length);
		hasTargetStrategy = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackTargetStrategyParameters() {		
		getTargetStrategyParameters();		
	}		
			
	public byte[] getTargetStrategyParameters() { 		
		if ( hasTargetStrategyParameters()) {		
			if (hasTargetStrategyParameters == FixUtils.TAG_HAS_VALUE) {		
				return targetStrategyParameters; 		
			} else {

				buf.position(hasTargetStrategyParameters);

			FixUtils.getTagStringValue(buf, targetStrategyParameters, 0, targetStrategyParameters.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasTargetStrategyParameters = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return targetStrategyParameters;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasTargetStrategyParameters() { return hasTargetStrategyParameters != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setTargetStrategyParameters(byte[] src) {		
		if (src == null ) return;
		if (hasTargetStrategyParameters()) FixUtils.fillNul(targetStrategyParameters);		
		FixUtils.copy(targetStrategyParameters, src); 		
		hasTargetStrategyParameters = FixUtils.TAG_HAS_VALUE;		
	}

	public void setTargetStrategyParameters(String str) {		
		if (str == null ) return;
		if (hasTargetStrategyParameters()) FixUtils.fillNul(targetStrategyParameters);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(targetStrategyParameters, src); 		
		hasTargetStrategyParameters = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackParticipationRate() {		
		getParticipationRate();		
	}		
			
	public long getParticipationRate() { 		
		if ( hasParticipationRate()) {		
			if (hasParticipationRate == FixUtils.TAG_HAS_VALUE) {		
				return participationRate; 		
			} else {

				buf.position(hasParticipationRate);

			participationRate = FixUtils.getTagFloatValue(buf, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return 0;		
				}		
			}		
			hasParticipationRate = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return participationRate;		
		} else {		
			return 0; 		
		}		
	}		
			
	public boolean hasParticipationRate() { return hasParticipationRate != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setParticipationRate(byte[] src) {		
		if (src == null ) return;
		if (hasParticipationRate()) participationRate = FixUtils.TAG_HAS_NO_VALUE;		
		participationRate = FixUtils.longValueOf(src, 0, src.length);
		hasParticipationRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setParticipationRate(long src) {		
		participationRate = src;
		hasParticipationRate = FixUtils.TAG_HAS_VALUE;		
	}

	public void setParticipationRate(String str) {		
		if (str == null ) return;
		if (hasParticipationRate()) participationRate = FixUtils.TAG_HAS_NO_VALUE;		
		byte[] src = str.getBytes(); 		
		participationRate = FixUtils.longValueOf(src, 0, src.length);
		hasParticipationRate = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackCancellationRights() {		
		getCancellationRights();		
	}		
			
	public byte getCancellationRights() { 		
		if ( hasCancellationRights()) {		
			if (hasCancellationRights == FixUtils.TAG_HAS_VALUE) {		
				return cancellationRights; 		
			} else {

				buf.position(hasCancellationRights);

			cancellationRights = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (cancellationRights != (byte)'M') && (cancellationRights != (byte)'N') && (cancellationRights != (byte)'O') && (cancellationRights != (byte)'Y') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 480);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasCancellationRights = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return cancellationRights;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasCancellationRights() { return hasCancellationRights != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setCancellationRights(byte[] src) {		
		if (src == null ) return;
		if (hasCancellationRights()) cancellationRights = (byte)' ';		
		cancellationRights = src[0];		
		hasCancellationRights = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCancellationRights(byte src) {		
		cancellationRights = src;
		hasCancellationRights = FixUtils.TAG_HAS_VALUE;		
	}

	public void setCancellationRights(String str) {		
		if (str == null ) return;
		if (hasCancellationRights()) cancellationRights = (byte)' ';		
		byte[] src = str.getBytes(); 		
		cancellationRights = src[0];		
		hasCancellationRights = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackMoneyLaunderingStatus() {		
		getMoneyLaunderingStatus();		
	}		
			
	public byte getMoneyLaunderingStatus() { 		
		if ( hasMoneyLaunderingStatus()) {		
			if (hasMoneyLaunderingStatus == FixUtils.TAG_HAS_VALUE) {		
				return moneyLaunderingStatus; 		
			} else {

				buf.position(hasMoneyLaunderingStatus);

			moneyLaunderingStatus = FixUtils.getTagCharValue(buf, err);
			if( !err.hasError() && (moneyLaunderingStatus != (byte)'3') && (moneyLaunderingStatus != (byte)'2') && (moneyLaunderingStatus != (byte)'1') && (moneyLaunderingStatus != (byte)'N') && (moneyLaunderingStatus != (byte)'Y') && true)
				err.setError((int)FixMessageInfo.SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG,
					"Tag msgType missing got " + 481);		
				if (err.hasError()) {		
					buf.position(0);		
					return (byte)'0';		
				}		
			}		
			hasMoneyLaunderingStatus = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return moneyLaunderingStatus;		
		} else {		
			return (byte)'0'; 		
		}		
	}		
			
	public boolean hasMoneyLaunderingStatus() { return hasMoneyLaunderingStatus != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setMoneyLaunderingStatus(byte[] src) {		
		if (src == null ) return;
		if (hasMoneyLaunderingStatus()) moneyLaunderingStatus = (byte)' ';		
		moneyLaunderingStatus = src[0];		
		hasMoneyLaunderingStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMoneyLaunderingStatus(byte src) {		
		moneyLaunderingStatus = src;
		hasMoneyLaunderingStatus = FixUtils.TAG_HAS_VALUE;		
	}

	public void setMoneyLaunderingStatus(String str) {		
		if (str == null ) return;
		if (hasMoneyLaunderingStatus()) moneyLaunderingStatus = (byte)' ';		
		byte[] src = str.getBytes(); 		
		moneyLaunderingStatus = src[0];		
		hasMoneyLaunderingStatus = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackRegistID() {		
		getRegistID();		
	}		
			
	public byte[] getRegistID() { 		
		if ( hasRegistID()) {		
			if (hasRegistID == FixUtils.TAG_HAS_VALUE) {		
				return registID; 		
			} else {

				buf.position(hasRegistID);

			FixUtils.getTagStringValue(buf, registID, 0, registID.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasRegistID = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return registID;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasRegistID() { return hasRegistID != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setRegistID(byte[] src) {		
		if (src == null ) return;
		if (hasRegistID()) FixUtils.fillNul(registID);		
		FixUtils.copy(registID, src); 		
		hasRegistID = FixUtils.TAG_HAS_VALUE;		
	}

	public void setRegistID(String str) {		
		if (str == null ) return;
		if (hasRegistID()) FixUtils.fillNul(registID);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(registID, src); 		
		hasRegistID = FixUtils.TAG_HAS_VALUE;		
	}		
			
	public void crackDesignation() {		
		getDesignation();		
	}		
			
	public byte[] getDesignation() { 		
		if ( hasDesignation()) {		
			if (hasDesignation == FixUtils.TAG_HAS_VALUE) {		
				return designation; 		
			} else {

				buf.position(hasDesignation);

			FixUtils.getTagStringValue(buf, designation, 0, designation.length, err);
		
				if (err.hasError()) {		
					buf.position(0);		
					return null;		
				}		
			}		
			hasDesignation = FixUtils.TAG_HAS_VALUE;		
			buf.position(0);		
			return designation;		
		} else {		
			return null; 		
		}		
	}		
			
	public boolean hasDesignation() { return hasDesignation != FixUtils.TAG_HAS_NO_VALUE; } 		

	public void setDesignation(byte[] src) {		
		if (src == null ) return;
		if (hasDesignation()) FixUtils.fillNul(designation);		
		FixUtils.copy(designation, src); 		
		hasDesignation = FixUtils.TAG_HAS_VALUE;		
	}

	public void setDesignation(String str) {		
		if (str == null ) return;
		if (hasDesignation()) FixUtils.fillNul(designation);		
		byte[] src = str.getBytes(); 		
		FixUtils.copy(designation, src); 		
		hasDesignation = FixUtils.TAG_HAS_VALUE;		
	}		
			
	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will burn in hell!
	**/
	@Override
	public String toString() {
		String s = "";
		try {
					if (standardHeader.hasBeginString()) s += "BeginString(8)= " + new String( FixUtils.trim(standardHeader.getBeginString()) ) + "\n" ; 
		if (standardHeader.hasBodyLength()) s += "BodyLength(9)= " + standardHeader.getBodyLength() + "\n" ; 
		if (standardHeader.hasMsgType()) s += "MsgType(35)= " + new String( FixUtils.trim(standardHeader.getMsgType()) ) + "\n" ; 
		if (standardHeader.hasApplVerID()) s += "ApplVerID(1128)= " + new String( FixUtils.trim(standardHeader.getApplVerID()) ) + "\n" ; 
		if (standardHeader.hasCstmApplVerID()) s += "CstmApplVerID(1129)= " + new String( FixUtils.trim(standardHeader.getCstmApplVerID()) ) + "\n" ; 
		if (standardHeader.hasApplExtID()) s += "ApplExtID(1156)= " + standardHeader.getApplExtID() + "\n" ; 
		if (standardHeader.hasSenderCompID()) s += "SenderCompID(49)= " + new String( FixUtils.trim(standardHeader.getSenderCompID()) ) + "\n" ; 
		if (standardHeader.hasTargetCompID()) s += "TargetCompID(56)= " + new String( FixUtils.trim(standardHeader.getTargetCompID()) ) + "\n" ; 
		if (standardHeader.hasOnBehalfOfCompID()) s += "OnBehalfOfCompID(115)= " + new String( FixUtils.trim(standardHeader.getOnBehalfOfCompID()) ) + "\n" ; 
		if (standardHeader.hasDeliverToCompID()) s += "DeliverToCompID(128)= " + new String( FixUtils.trim(standardHeader.getDeliverToCompID()) ) + "\n" ; 
		if (standardHeader.hasSecureDataLen()) s += "SecureDataLen(90)= " + standardHeader.getSecureDataLen() + "\n" ; 
		if (standardHeader.hasSecureData()) s += "SecureData(91)= " + new String( FixUtils.trim(standardHeader.getSecureData()) ) + "\n" ; 
		if (standardHeader.hasMsgSeqNum()) s += "MsgSeqNum(34)= " + standardHeader.getMsgSeqNum() + "\n" ; 
		if (standardHeader.hasSenderSubID()) s += "SenderSubID(50)= " + new String( FixUtils.trim(standardHeader.getSenderSubID()) ) + "\n" ; 
		if (standardHeader.hasSenderLocationID()) s += "SenderLocationID(142)= " + new String( FixUtils.trim(standardHeader.getSenderLocationID()) ) + "\n" ; 
		if (standardHeader.hasTargetSubID()) s += "TargetSubID(57)= " + new String( FixUtils.trim(standardHeader.getTargetSubID()) ) + "\n" ; 
		if (standardHeader.hasTargetLocationID()) s += "TargetLocationID(143)= " + new String( FixUtils.trim(standardHeader.getTargetLocationID()) ) + "\n" ; 
		if (standardHeader.hasOnBehalfOfSubID()) s += "OnBehalfOfSubID(116)= " + new String( FixUtils.trim(standardHeader.getOnBehalfOfSubID()) ) + "\n" ; 
		if (standardHeader.hasOnBehalfOfLocationID()) s += "OnBehalfOfLocationID(144)= " + new String( FixUtils.trim(standardHeader.getOnBehalfOfLocationID()) ) + "\n" ; 
		if (standardHeader.hasDeliverToSubID()) s += "DeliverToSubID(129)= " + new String( FixUtils.trim(standardHeader.getDeliverToSubID()) ) + "\n" ; 
		if (standardHeader.hasDeliverToLocationID()) s += "DeliverToLocationID(145)= " + new String( FixUtils.trim(standardHeader.getDeliverToLocationID()) ) + "\n" ; 
		if (standardHeader.hasPossDupFlag()) s += "PossDupFlag(43)= " + standardHeader.getPossDupFlag() + "\n" ; 
		if (standardHeader.hasPossResend()) s += "PossResend(97)= " + standardHeader.getPossResend() + "\n" ; 
		if (standardHeader.hasSendingTime()) s += "SendingTime(52)= " + new String( FixUtils.trim(standardHeader.getSendingTime()) ) + "\n" ; 
		if (standardHeader.hasOrigSendingTime()) s += "OrigSendingTime(122)= " + new String( FixUtils.trim(standardHeader.getOrigSendingTime()) ) + "\n" ; 
		if (standardHeader.hasXmlDataLen()) s += "XmlDataLen(212)= " + standardHeader.getXmlDataLen() + "\n" ; 
		if (standardHeader.hasXmlData()) s += "XmlData(213)= " + new String( FixUtils.trim(standardHeader.getXmlData()) ) + "\n" ; 
		if (standardHeader.hasMessageEncoding()) s += "MessageEncoding(347)= " + new String( FixUtils.trim(standardHeader.getMessageEncoding()) ) + "\n" ; 
		if (standardHeader.hasLastMsgSeqNumProcessed()) s += "LastMsgSeqNumProcessed(369)= " + standardHeader.getLastMsgSeqNumProcessed() + "\n" ; 

					if (hasOrderID()) s += "OrderID(37)= " + new String( FixUtils.trim(getOrderID()) ) + "\n" ; 
		if (hasCrossID()) s += "CrossID(548)= " + new String( FixUtils.trim(getCrossID()) ) + "\n" ; 
		if (hasOrigCrossID()) s += "OrigCrossID(551)= " + new String( FixUtils.trim(getOrigCrossID()) ) + "\n" ; 
		if (hasHostCrossID()) s += "HostCrossID(961)= " + new String( FixUtils.trim(getHostCrossID()) ) + "\n" ; 
		if (hasCrossType()) s += "CrossType(549)= " + getCrossType() + "\n" ; 
		if (hasCrossPrioritization()) s += "CrossPrioritization(550)= " + getCrossPrioritization() + "\n" ; 
		if (hasSettlType()) s += "SettlType(63)= " + new String( FixUtils.trim(getSettlType()) ) + "\n" ; 
		if (hasSettlDate()) s += "SettlDate(64)= " + new String( FixUtils.trim(getSettlDate()) ) + "\n" ; 
		if (hasHandlInst()) s += "HandlInst(21)= " + getHandlInst() + "\n" ; 
		if (hasExecInst()) s += "ExecInst(18)= " + new String( FixUtils.trim(getExecInst()) ) + "\n" ; 
		if (hasMinQty()) s += "MinQty(110)= " + getMinQty() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasMatchIncrement()) s += "MatchIncrement(1089)= " + getMatchIncrement() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasMaxPriceLevels()) s += "MaxPriceLevels(1090)= " + getMaxPriceLevels() + "\n" ; 
		if (hasMaxFloor()) s += "MaxFloor(111)= " + getMaxFloor() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasExDestination()) s += "ExDestination(100)= " + new String( FixUtils.trim(getExDestination()) ) + "\n" ; 
		if (hasExDestinationIDSource()) s += "ExDestinationIDSource(1133)= " + getExDestinationIDSource() + "\n" ; 
		if (hasProcessCode()) s += "ProcessCode(81)= " + getProcessCode() + "\n" ; 
		if (hasPrevClosePx()) s += "PrevClosePx(140)= " + getPrevClosePx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasLocateReqd()) s += "LocateReqd(114)= " + getLocateReqd() + "\n" ; 
		if (hasTransactTime()) s += "TransactTime(60)= " + new String( FixUtils.trim(getTransactTime()) ) + "\n" ; 
		if (hasTransBkdTime()) s += "TransBkdTime(483)= " + new String( FixUtils.trim(getTransBkdTime()) ) + "\n" ; 
		if (hasOrdType()) s += "OrdType(40)= " + getOrdType() + "\n" ; 
		if (hasPriceType()) s += "PriceType(423)= " + getPriceType() + "\n" ; 
		if (hasPrice()) s += "Price(44)= " + getPrice() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasPriceProtectionScope()) s += "PriceProtectionScope(1092)= " + getPriceProtectionScope() + "\n" ; 
		if (hasStopPx()) s += "StopPx(99)= " + getStopPx() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasCurrency()) s += "Currency(15)= " + new String( FixUtils.trim(getCurrency()) ) + "\n" ; 
		if (hasComplianceID()) s += "ComplianceID(376)= " + new String( FixUtils.trim(getComplianceID()) ) + "\n" ; 
		if (hasIOIID()) s += "IOIID(23)= " + new String( FixUtils.trim(getIOIID()) ) + "\n" ; 
		if (hasQuoteID()) s += "QuoteID(117)= " + new String( FixUtils.trim(getQuoteID()) ) + "\n" ; 
		if (hasTimeInForce()) s += "TimeInForce(59)= " + getTimeInForce() + "\n" ; 
		if (hasEffectiveTime()) s += "EffectiveTime(168)= " + new String( FixUtils.trim(getEffectiveTime()) ) + "\n" ; 
		if (hasExpireDate()) s += "ExpireDate(432)= " + new String( FixUtils.trim(getExpireDate()) ) + "\n" ; 
		if (hasExpireTime()) s += "ExpireTime(126)= " + new String( FixUtils.trim(getExpireTime()) ) + "\n" ; 
		if (hasGTBookingInst()) s += "GTBookingInst(427)= " + getGTBookingInst() + "\n" ; 
		if (hasMaxShow()) s += "MaxShow(210)= " + getMaxShow() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasTargetStrategy()) s += "TargetStrategy(847)= " + getTargetStrategy() + "\n" ; 
		if (hasTargetStrategyParameters()) s += "TargetStrategyParameters(848)= " + new String( FixUtils.trim(getTargetStrategyParameters()) ) + "\n" ; 
		if (hasParticipationRate()) s += "ParticipationRate(849)= " + getParticipationRate() / FixUtils.FIX_FLOAT_NUMBER_OF_DECIMALS + "\n" ; 
		if (hasCancellationRights()) s += "CancellationRights(480)= " + getCancellationRights() + "\n" ; 
		if (hasMoneyLaunderingStatus()) s += "MoneyLaunderingStatus(481)= " + getMoneyLaunderingStatus() + "\n" ; 
		if (hasRegistID()) s += "RegistID(513)= " + new String( FixUtils.trim(getRegistID()) ) + "\n" ; 
		if (hasDesignation()) s += "Designation(494)= " + new String( FixUtils.trim(getDesignation()) ) + "\n" ; 

					if (standardTrailer.hasSignatureLength()) s += "SignatureLength(93)= " + standardTrailer.getSignatureLength() + "\n" ; 
		if (standardTrailer.hasSignature()) s += "Signature(89)= " + new String( FixUtils.trim(standardTrailer.getSignature()) ) + "\n" ; 
		if (standardTrailer.hasCheckSum()) s += "CheckSum(10)= " + new String( FixUtils.trim(standardTrailer.getCheckSum()) ) + "\n" ; 

		} catch(Exception e) {  };
			return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixCrossOrderCancelReplaceRequest)) return false;

		FixCrossOrderCancelReplaceRequest msg = (FixCrossOrderCancelReplaceRequest) o;

		if (!standardHeader.equals(msg.standardHeader)) return false;

		if ((hasOrderID() && !msg.hasOrderID()) || (!hasOrderID() && msg.hasOrderID())) return false;
		if (!(!hasOrderID() && !msg.hasOrderID()) && !FixUtils.equals(getOrderID(), msg.getOrderID())) return false;
		if ((hasCrossID() && !msg.hasCrossID()) || (!hasCrossID() && msg.hasCrossID())) return false;
		if (!(!hasCrossID() && !msg.hasCrossID()) && !FixUtils.equals(getCrossID(), msg.getCrossID())) return false;
		if ((hasOrigCrossID() && !msg.hasOrigCrossID()) || (!hasOrigCrossID() && msg.hasOrigCrossID())) return false;
		if (!(!hasOrigCrossID() && !msg.hasOrigCrossID()) && !FixUtils.equals(getOrigCrossID(), msg.getOrigCrossID())) return false;
		if ((hasHostCrossID() && !msg.hasHostCrossID()) || (!hasHostCrossID() && msg.hasHostCrossID())) return false;
		if (!(!hasHostCrossID() && !msg.hasHostCrossID()) && !FixUtils.equals(getHostCrossID(), msg.getHostCrossID())) return false;
		if ((hasCrossType() && !msg.hasCrossType()) || (!hasCrossType() && msg.hasCrossType())) return false;
		if (!(!hasCrossType() && !msg.hasCrossType()) && !(getCrossType()==msg.getCrossType())) return false;
		if ((hasCrossPrioritization() && !msg.hasCrossPrioritization()) || (!hasCrossPrioritization() && msg.hasCrossPrioritization())) return false;
		if (!(!hasCrossPrioritization() && !msg.hasCrossPrioritization()) && !(getCrossPrioritization()==msg.getCrossPrioritization())) return false;
		if ((hasSettlType() && !msg.hasSettlType()) || (!hasSettlType() && msg.hasSettlType())) return false;
		if (!(!hasSettlType() && !msg.hasSettlType()) && !FixUtils.equals(getSettlType(), msg.getSettlType())) return false;
		if ((hasSettlDate() && !msg.hasSettlDate()) || (!hasSettlDate() && msg.hasSettlDate())) return false;
		if ((hasHandlInst() && !msg.hasHandlInst()) || (!hasHandlInst() && msg.hasHandlInst())) return false;
		if (!(!hasHandlInst() && !msg.hasHandlInst()) && !(getHandlInst()==msg.getHandlInst())) return false;
		if ((hasExecInst() && !msg.hasExecInst()) || (!hasExecInst() && msg.hasExecInst())) return false;
		if (!(!hasExecInst() && !msg.hasExecInst()) && !FixUtils.equals(getExecInst(), msg.getExecInst())) return false;
		if ((hasMinQty() && !msg.hasMinQty()) || (!hasMinQty() && msg.hasMinQty())) return false;
		if (!(!hasMinQty() && !msg.hasMinQty()) && !(getMinQty()==msg.getMinQty())) return false;
		if ((hasMatchIncrement() && !msg.hasMatchIncrement()) || (!hasMatchIncrement() && msg.hasMatchIncrement())) return false;
		if (!(!hasMatchIncrement() && !msg.hasMatchIncrement()) && !(getMatchIncrement()==msg.getMatchIncrement())) return false;
		if ((hasMaxPriceLevels() && !msg.hasMaxPriceLevels()) || (!hasMaxPriceLevels() && msg.hasMaxPriceLevels())) return false;
		if (!(!hasMaxPriceLevels() && !msg.hasMaxPriceLevels()) && !(getMaxPriceLevels()==msg.getMaxPriceLevels())) return false;
		if ((hasMaxFloor() && !msg.hasMaxFloor()) || (!hasMaxFloor() && msg.hasMaxFloor())) return false;
		if (!(!hasMaxFloor() && !msg.hasMaxFloor()) && !(getMaxFloor()==msg.getMaxFloor())) return false;
		if ((hasExDestination() && !msg.hasExDestination()) || (!hasExDestination() && msg.hasExDestination())) return false;
		if (!(!hasExDestination() && !msg.hasExDestination()) && !FixUtils.equals(getExDestination(), msg.getExDestination())) return false;
		if ((hasExDestinationIDSource() && !msg.hasExDestinationIDSource()) || (!hasExDestinationIDSource() && msg.hasExDestinationIDSource())) return false;
		if (!(!hasExDestinationIDSource() && !msg.hasExDestinationIDSource()) && !(getExDestinationIDSource()==msg.getExDestinationIDSource())) return false;
		if ((hasProcessCode() && !msg.hasProcessCode()) || (!hasProcessCode() && msg.hasProcessCode())) return false;
		if (!(!hasProcessCode() && !msg.hasProcessCode()) && !(getProcessCode()==msg.getProcessCode())) return false;
		if ((hasPrevClosePx() && !msg.hasPrevClosePx()) || (!hasPrevClosePx() && msg.hasPrevClosePx())) return false;
		if (!(!hasPrevClosePx() && !msg.hasPrevClosePx()) && !(getPrevClosePx()==msg.getPrevClosePx())) return false;
		if ((hasLocateReqd() && !msg.hasLocateReqd()) || (!hasLocateReqd() && msg.hasLocateReqd())) return false;
		if (!(!hasLocateReqd() && !msg.hasLocateReqd()) && !(getLocateReqd()==msg.getLocateReqd())) return false;
		if ((hasTransactTime() && !msg.hasTransactTime()) || (!hasTransactTime() && msg.hasTransactTime())) return false;
		if ((hasTransBkdTime() && !msg.hasTransBkdTime()) || (!hasTransBkdTime() && msg.hasTransBkdTime())) return false;
		if ((hasOrdType() && !msg.hasOrdType()) || (!hasOrdType() && msg.hasOrdType())) return false;
		if (!(!hasOrdType() && !msg.hasOrdType()) && !(getOrdType()==msg.getOrdType())) return false;
		if ((hasPriceType() && !msg.hasPriceType()) || (!hasPriceType() && msg.hasPriceType())) return false;
		if (!(!hasPriceType() && !msg.hasPriceType()) && !(getPriceType()==msg.getPriceType())) return false;
		if ((hasPrice() && !msg.hasPrice()) || (!hasPrice() && msg.hasPrice())) return false;
		if (!(!hasPrice() && !msg.hasPrice()) && !(getPrice()==msg.getPrice())) return false;
		if ((hasPriceProtectionScope() && !msg.hasPriceProtectionScope()) || (!hasPriceProtectionScope() && msg.hasPriceProtectionScope())) return false;
		if (!(!hasPriceProtectionScope() && !msg.hasPriceProtectionScope()) && !(getPriceProtectionScope()==msg.getPriceProtectionScope())) return false;
		if ((hasStopPx() && !msg.hasStopPx()) || (!hasStopPx() && msg.hasStopPx())) return false;
		if (!(!hasStopPx() && !msg.hasStopPx()) && !(getStopPx()==msg.getStopPx())) return false;
		if ((hasCurrency() && !msg.hasCurrency()) || (!hasCurrency() && msg.hasCurrency())) return false;
		if (!(!hasCurrency() && !msg.hasCurrency()) && !FixUtils.equals(getCurrency(), msg.getCurrency())) return false;
		if ((hasComplianceID() && !msg.hasComplianceID()) || (!hasComplianceID() && msg.hasComplianceID())) return false;
		if (!(!hasComplianceID() && !msg.hasComplianceID()) && !FixUtils.equals(getComplianceID(), msg.getComplianceID())) return false;
		if ((hasIOIID() && !msg.hasIOIID()) || (!hasIOIID() && msg.hasIOIID())) return false;
		if (!(!hasIOIID() && !msg.hasIOIID()) && !FixUtils.equals(getIOIID(), msg.getIOIID())) return false;
		if ((hasQuoteID() && !msg.hasQuoteID()) || (!hasQuoteID() && msg.hasQuoteID())) return false;
		if (!(!hasQuoteID() && !msg.hasQuoteID()) && !FixUtils.equals(getQuoteID(), msg.getQuoteID())) return false;
		if ((hasTimeInForce() && !msg.hasTimeInForce()) || (!hasTimeInForce() && msg.hasTimeInForce())) return false;
		if (!(!hasTimeInForce() && !msg.hasTimeInForce()) && !(getTimeInForce()==msg.getTimeInForce())) return false;
		if ((hasEffectiveTime() && !msg.hasEffectiveTime()) || (!hasEffectiveTime() && msg.hasEffectiveTime())) return false;
		if ((hasExpireDate() && !msg.hasExpireDate()) || (!hasExpireDate() && msg.hasExpireDate())) return false;
		if ((hasExpireTime() && !msg.hasExpireTime()) || (!hasExpireTime() && msg.hasExpireTime())) return false;
		if ((hasGTBookingInst() && !msg.hasGTBookingInst()) || (!hasGTBookingInst() && msg.hasGTBookingInst())) return false;
		if (!(!hasGTBookingInst() && !msg.hasGTBookingInst()) && !(getGTBookingInst()==msg.getGTBookingInst())) return false;
		if ((hasMaxShow() && !msg.hasMaxShow()) || (!hasMaxShow() && msg.hasMaxShow())) return false;
		if (!(!hasMaxShow() && !msg.hasMaxShow()) && !(getMaxShow()==msg.getMaxShow())) return false;
		if ((hasTargetStrategy() && !msg.hasTargetStrategy()) || (!hasTargetStrategy() && msg.hasTargetStrategy())) return false;
		if (!(!hasTargetStrategy() && !msg.hasTargetStrategy()) && !(getTargetStrategy()==msg.getTargetStrategy())) return false;
		if ((hasTargetStrategyParameters() && !msg.hasTargetStrategyParameters()) || (!hasTargetStrategyParameters() && msg.hasTargetStrategyParameters())) return false;
		if (!(!hasTargetStrategyParameters() && !msg.hasTargetStrategyParameters()) && !FixUtils.equals(getTargetStrategyParameters(), msg.getTargetStrategyParameters())) return false;
		if ((hasParticipationRate() && !msg.hasParticipationRate()) || (!hasParticipationRate() && msg.hasParticipationRate())) return false;
		if (!(!hasParticipationRate() && !msg.hasParticipationRate()) && !(getParticipationRate()==msg.getParticipationRate())) return false;
		if ((hasCancellationRights() && !msg.hasCancellationRights()) || (!hasCancellationRights() && msg.hasCancellationRights())) return false;
		if (!(!hasCancellationRights() && !msg.hasCancellationRights()) && !(getCancellationRights()==msg.getCancellationRights())) return false;
		if ((hasMoneyLaunderingStatus() && !msg.hasMoneyLaunderingStatus()) || (!hasMoneyLaunderingStatus() && msg.hasMoneyLaunderingStatus())) return false;
		if (!(!hasMoneyLaunderingStatus() && !msg.hasMoneyLaunderingStatus()) && !(getMoneyLaunderingStatus()==msg.getMoneyLaunderingStatus())) return false;
		if ((hasRegistID() && !msg.hasRegistID()) || (!hasRegistID() && msg.hasRegistID())) return false;
		if (!(!hasRegistID() && !msg.hasRegistID()) && !FixUtils.equals(getRegistID(), msg.getRegistID())) return false;
		if ((hasDesignation() && !msg.hasDesignation()) || (!hasDesignation() && msg.hasDesignation())) return false;
		if (!(!hasDesignation() && !msg.hasDesignation()) && !FixUtils.equals(getDesignation(), msg.getDesignation())) return false;
		return true;
	}
	@Override
	public FixCrossOrderCancelReplaceRequest clone () {
		FixCrossOrderCancelReplaceRequest out = new FixCrossOrderCancelReplaceRequest();

		standardHeader.clone(out.standardHeader);
		standardTrailer.clone(out.standardTrailer);
		return clone(out);
	}

	public FixCrossOrderCancelReplaceRequest clone ( FixCrossOrderCancelReplaceRequest out ) {
		if ( hasOrderID())
			out.setOrderID(getOrderID());
		if ( hasCrossID())
			out.setCrossID(getCrossID());
		if ( hasOrigCrossID())
			out.setOrigCrossID(getOrigCrossID());
		if ( hasHostCrossID())
			out.setHostCrossID(getHostCrossID());
		if ( hasCrossType())
			out.setCrossType(getCrossType());
		if ( hasCrossPrioritization())
			out.setCrossPrioritization(getCrossPrioritization());
		if ( hasSettlType())
			out.setSettlType(getSettlType());
		if ( hasSettlDate())
			out.setSettlDate(getSettlDate());
		if ( hasHandlInst())
			out.setHandlInst(getHandlInst());
		if ( hasExecInst())
			out.setExecInst(getExecInst());
		if ( hasMinQty())
			out.setMinQty(getMinQty());
		if ( hasMatchIncrement())
			out.setMatchIncrement(getMatchIncrement());
		if ( hasMaxPriceLevels())
			out.setMaxPriceLevels(getMaxPriceLevels());
		if ( hasMaxFloor())
			out.setMaxFloor(getMaxFloor());
		if ( hasExDestination())
			out.setExDestination(getExDestination());
		if ( hasExDestinationIDSource())
			out.setExDestinationIDSource(getExDestinationIDSource());
		if ( hasProcessCode())
			out.setProcessCode(getProcessCode());
		if ( hasPrevClosePx())
			out.setPrevClosePx(getPrevClosePx());
		if ( hasLocateReqd())
			out.setLocateReqd(getLocateReqd());
		if ( hasTransactTime())
			out.setTransactTime(getTransactTime());
		if ( hasTransBkdTime())
			out.setTransBkdTime(getTransBkdTime());
		if ( hasOrdType())
			out.setOrdType(getOrdType());
		if ( hasPriceType())
			out.setPriceType(getPriceType());
		if ( hasPrice())
			out.setPrice(getPrice());
		if ( hasPriceProtectionScope())
			out.setPriceProtectionScope(getPriceProtectionScope());
		if ( hasStopPx())
			out.setStopPx(getStopPx());
		if ( hasCurrency())
			out.setCurrency(getCurrency());
		if ( hasComplianceID())
			out.setComplianceID(getComplianceID());
		if ( hasIOIID())
			out.setIOIID(getIOIID());
		if ( hasQuoteID())
			out.setQuoteID(getQuoteID());
		if ( hasTimeInForce())
			out.setTimeInForce(getTimeInForce());
		if ( hasEffectiveTime())
			out.setEffectiveTime(getEffectiveTime());
		if ( hasExpireDate())
			out.setExpireDate(getExpireDate());
		if ( hasExpireTime())
			out.setExpireTime(getExpireTime());
		if ( hasGTBookingInst())
			out.setGTBookingInst(getGTBookingInst());
		if ( hasMaxShow())
			out.setMaxShow(getMaxShow());
		if ( hasTargetStrategy())
			out.setTargetStrategy(getTargetStrategy());
		if ( hasTargetStrategyParameters())
			out.setTargetStrategyParameters(getTargetStrategyParameters());
		if ( hasParticipationRate())
			out.setParticipationRate(getParticipationRate());
		if ( hasCancellationRights())
			out.setCancellationRights(getCancellationRights());
		if ( hasMoneyLaunderingStatus())
			out.setMoneyLaunderingStatus(getMoneyLaunderingStatus());
		if ( hasRegistID())
			out.setRegistID(getRegistID());
		if ( hasDesignation())
			out.setDesignation(getDesignation());
		int count = 0;
		count = 0;
		for (FixRootParties fixRootParties : rootParties) {
			if (!fixRootParties.hasGroup()) continue;
			out.rootParties[count] = fixRootParties.clone( out.rootParties[count] );
			count++;
		}
		count = 0;
		for (FixSideCrossOrdModGrp fixSideCrossOrdModGrp : sideCrossOrdModGrp) {
			if (!fixSideCrossOrdModGrp.hasGroup()) continue;
			out.sideCrossOrdModGrp[count] = fixSideCrossOrdModGrp.clone( out.sideCrossOrdModGrp[count] );
			count++;
		}
		if (instrument.hasGroup())
			out.instrument = instrument.clone( out.instrument);
		count = 0;
		for (FixUndInstrmtGrp fixUndInstrmtGrp : undInstrmtGrp) {
			if (!fixUndInstrmtGrp.hasGroup()) continue;
			out.undInstrmtGrp[count] = fixUndInstrmtGrp.clone( out.undInstrmtGrp[count] );
			count++;
		}
		count = 0;
		for (FixInstrmtLegGrp fixInstrmtLegGrp : instrmtLegGrp) {
			if (!fixInstrmtLegGrp.hasGroup()) continue;
			out.instrmtLegGrp[count] = fixInstrmtLegGrp.clone( out.instrmtLegGrp[count] );
			count++;
		}
		if (displayInstruction.hasGroup())
			out.displayInstruction = displayInstruction.clone( out.displayInstruction);
		count = 0;
		for (FixTrdgSesGrp fixTrdgSesGrp : trdgSesGrp) {
			if (!fixTrdgSesGrp.hasGroup()) continue;
			out.trdgSesGrp[count] = fixTrdgSesGrp.clone( out.trdgSesGrp[count] );
			count++;
		}
		count = 0;
		for (FixStipulations fixStipulations : stipulations) {
			if (!fixStipulations.hasGroup()) continue;
			out.stipulations[count] = fixStipulations.clone( out.stipulations[count] );
			count++;
		}
		if (triggeringInstruction.hasGroup())
			out.triggeringInstruction = triggeringInstruction.clone( out.triggeringInstruction);
		if (spreadOrBenchmarkCurveData.hasGroup())
			out.spreadOrBenchmarkCurveData = spreadOrBenchmarkCurveData.clone( out.spreadOrBenchmarkCurveData);
		if (yieldData.hasGroup())
			out.yieldData = yieldData.clone( out.yieldData);
		if (pegInstructions.hasGroup())
			out.pegInstructions = pegInstructions.clone( out.pegInstructions);
		if (discretionInstructions.hasGroup())
			out.discretionInstructions = discretionInstructions.clone( out.discretionInstructions);
		count = 0;
		for (FixStrategyParametersGrp fixStrategyParametersGrp : strategyParametersGrp) {
			if (!fixStrategyParametersGrp.hasGroup()) continue;
			out.strategyParametersGrp[count] = fixStrategyParametersGrp.clone( out.strategyParametersGrp[count] );
			count++;
		}
		return out;
	}

}
