package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.messaging.FixMessageInfo;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.messaging.FixHeartbeat;
import org.tomac.protocol.fix.messaging.FixTestRequest;
import org.tomac.protocol.fix.messaging.FixResendRequest;
import org.tomac.protocol.fix.messaging.FixReject;
import org.tomac.protocol.fix.messaging.FixSequenceReset;
import org.tomac.protocol.fix.messaging.FixLogout;
import org.tomac.protocol.fix.messaging.FixIOI;
import org.tomac.protocol.fix.messaging.FixAdvertisement;
import org.tomac.protocol.fix.messaging.FixExecutionReport;
import org.tomac.protocol.fix.messaging.FixOrderCancelReject;
import org.tomac.protocol.fix.messaging.FixLogon;
import org.tomac.protocol.fix.messaging.FixNews;
import org.tomac.protocol.fix.messaging.FixEmail;
import org.tomac.protocol.fix.messaging.FixNewOrderSingle;
import org.tomac.protocol.fix.messaging.FixNewOrderList;
import org.tomac.protocol.fix.messaging.FixOrderCancelRequest;
import org.tomac.protocol.fix.messaging.FixOrderCancelReplaceRequest;
import org.tomac.protocol.fix.messaging.FixOrderStatusRequest;
import org.tomac.protocol.fix.messaging.FixAllocationInstruction;
import org.tomac.protocol.fix.messaging.FixListCancelRequest;
import org.tomac.protocol.fix.messaging.FixListExecute;
import org.tomac.protocol.fix.messaging.FixListStatusRequest;
import org.tomac.protocol.fix.messaging.FixListStatus;
import org.tomac.protocol.fix.messaging.FixAllocationInstructionAck;
import org.tomac.protocol.fix.messaging.FixDontKnowTradeDK;
import org.tomac.protocol.fix.messaging.FixQuoteRequest;
import org.tomac.protocol.fix.messaging.FixQuote;
import org.tomac.protocol.fix.messaging.FixSettlementInstructions;
import org.tomac.protocol.fix.messaging.FixMarketDataRequest;
import org.tomac.protocol.fix.messaging.FixMarketDataSnapshotFullRefresh;
import org.tomac.protocol.fix.messaging.FixMarketDataIncrementalRefresh;
import org.tomac.protocol.fix.messaging.FixMarketDataRequestReject;
import org.tomac.protocol.fix.messaging.FixQuoteCancel;
import org.tomac.protocol.fix.messaging.FixQuoteStatusRequest;
import org.tomac.protocol.fix.messaging.FixMassQuoteAcknowledgement;
import org.tomac.protocol.fix.messaging.FixSecurityDefinitionRequest;
import org.tomac.protocol.fix.messaging.FixSecurityDefinition;
import org.tomac.protocol.fix.messaging.FixSecurityStatusRequest;
import org.tomac.protocol.fix.messaging.FixSecurityStatus;
import org.tomac.protocol.fix.messaging.FixTradingSessionStatusRequest;
import org.tomac.protocol.fix.messaging.FixTradingSessionStatus;
import org.tomac.protocol.fix.messaging.FixMassQuote;
import org.tomac.protocol.fix.messaging.FixBusinessMessageReject;
import org.tomac.protocol.fix.messaging.FixBidRequest;
import org.tomac.protocol.fix.messaging.FixBidResponse;
import org.tomac.protocol.fix.messaging.FixListStrikePrice;
import org.tomac.protocol.fix.messaging.FixRegistrationInstructions;
import org.tomac.protocol.fix.messaging.FixRegistrationInstructionsResponse;
import org.tomac.protocol.fix.messaging.FixOrderMassCancelRequest;
import org.tomac.protocol.fix.messaging.FixOrderMassCancelReport;
import org.tomac.protocol.fix.messaging.FixNewOrderCross;
import org.tomac.protocol.fix.messaging.FixCrossOrderCancelReplaceRequest;
import org.tomac.protocol.fix.messaging.FixCrossOrderCancelRequest;
import org.tomac.protocol.fix.messaging.FixSecurityTypeRequest;
import org.tomac.protocol.fix.messaging.FixSecurityTypes;
import org.tomac.protocol.fix.messaging.FixSecurityListRequest;
import org.tomac.protocol.fix.messaging.FixSecurityList;
import org.tomac.protocol.fix.messaging.FixDerivativeSecurityListRequest;
import org.tomac.protocol.fix.messaging.FixDerivativeSecurityList;
import org.tomac.protocol.fix.messaging.FixNewOrderMultileg;
import org.tomac.protocol.fix.messaging.FixMultilegOrderCancelReplace;
import org.tomac.protocol.fix.messaging.FixTradeCaptureReportRequest;
import org.tomac.protocol.fix.messaging.FixTradeCaptureReport;
import org.tomac.protocol.fix.messaging.FixOrderMassStatusRequest;
import org.tomac.protocol.fix.messaging.FixQuoteRequestReject;
import org.tomac.protocol.fix.messaging.FixRFQRequest;
import org.tomac.protocol.fix.messaging.FixQuoteStatusReport;
import org.tomac.protocol.fix.messaging.FixQuoteResponse;
import org.tomac.protocol.fix.messaging.FixConfirmation;
import org.tomac.protocol.fix.messaging.FixPositionMaintenanceRequest;
import org.tomac.protocol.fix.messaging.FixPositionMaintenanceReport;
import org.tomac.protocol.fix.messaging.FixRequestForPositions;
import org.tomac.protocol.fix.messaging.FixRequestForPositionsAck;
import org.tomac.protocol.fix.messaging.FixPositionReport;
import org.tomac.protocol.fix.messaging.FixTradeCaptureReportRequestAck;
import org.tomac.protocol.fix.messaging.FixTradeCaptureReportAck;
import org.tomac.protocol.fix.messaging.FixAllocationReport;
import org.tomac.protocol.fix.messaging.FixAllocationReportAck;
import org.tomac.protocol.fix.messaging.FixConfirmation_Ack;
import org.tomac.protocol.fix.messaging.FixSettlementInstructionRequest;
import org.tomac.protocol.fix.messaging.FixAssignmentReport;
import org.tomac.protocol.fix.messaging.FixCollateralRequest;
import org.tomac.protocol.fix.messaging.FixCollateralAssignment;
import org.tomac.protocol.fix.messaging.FixCollateralResponse;
import org.tomac.protocol.fix.messaging.FixCollateralReport;
import org.tomac.protocol.fix.messaging.FixCollateralInquiry;
import org.tomac.protocol.fix.messaging.FixNetworkCounterpartySystemStatusRequest;
import org.tomac.protocol.fix.messaging.FixNetworkCounterpartySystemStatusResponse;
import org.tomac.protocol.fix.messaging.FixUserRequest;
import org.tomac.protocol.fix.messaging.FixUserResponse;
import org.tomac.protocol.fix.messaging.FixCollateralInquiryAck;
import org.tomac.protocol.fix.messaging.FixConfirmationRequest;
import org.tomac.protocol.fix.messaging.FixContraryIntentionReport;
import org.tomac.protocol.fix.messaging.FixSecurityDefinitionUpdateReport;
import org.tomac.protocol.fix.messaging.FixSecurityListUpdateReport;
import org.tomac.protocol.fix.messaging.FixAdjustedPositionReport;
import org.tomac.protocol.fix.messaging.FixAllocationInstructionAlert;
import org.tomac.protocol.fix.messaging.FixExecutionAcknowledgement;
import org.tomac.protocol.fix.messaging.FixTradingSessionList;
import org.tomac.protocol.fix.messaging.FixTradingSessionListRequest;
import org.tomac.protocol.fix.messaging.FixSettlementObligationReport;
import org.tomac.protocol.fix.messaging.FixDerivativeSecurityListUpdateReport;
import org.tomac.protocol.fix.messaging.FixTradingSessionListUpdateReport;
import org.tomac.protocol.fix.messaging.FixMarketDefinitionRequest;
import org.tomac.protocol.fix.messaging.FixMarketDefinition;
import org.tomac.protocol.fix.messaging.FixMarketDefinitionUpdateReport;
import org.tomac.protocol.fix.messaging.FixUserNotification;
import org.tomac.protocol.fix.messaging.FixOrderMassActionReport;
import org.tomac.protocol.fix.messaging.FixOrderMassActionRequest;
import org.tomac.protocol.fix.messaging.FixApplicationMessageRequest;
import org.tomac.protocol.fix.messaging.FixApplicationMessageRequestAck;
import org.tomac.protocol.fix.messaging.FixApplicationMessageReport;
import org.tomac.protocol.fix.messaging.FixStreamAssignmentRequest;
import org.tomac.protocol.fix.messaging.FixStreamAssignmentReport;
import org.tomac.protocol.fix.messaging.FixStreamAssignmentReportACK;
import org.tomac.protocol.fix.messaging.FixPartyDetailsListRequest;
import org.tomac.protocol.fix.messaging.FixPartyDetailsListReport;

public class FixMessagePool<T extends FixMessage> {

	FixHeartbeat[] poolFixHeartbeat;
	boolean[] inUseFixHeartbeat;
	FixTestRequest[] poolFixTestRequest;
	boolean[] inUseFixTestRequest;
	FixResendRequest[] poolFixResendRequest;
	boolean[] inUseFixResendRequest;
	FixReject[] poolFixReject;
	boolean[] inUseFixReject;
	FixSequenceReset[] poolFixSequenceReset;
	boolean[] inUseFixSequenceReset;
	FixLogout[] poolFixLogout;
	boolean[] inUseFixLogout;
	FixIOI[] poolFixIOI;
	boolean[] inUseFixIOI;
	FixAdvertisement[] poolFixAdvertisement;
	boolean[] inUseFixAdvertisement;
	FixExecutionReport[] poolFixExecutionReport;
	boolean[] inUseFixExecutionReport;
	FixOrderCancelReject[] poolFixOrderCancelReject;
	boolean[] inUseFixOrderCancelReject;
	FixLogon[] poolFixLogon;
	boolean[] inUseFixLogon;
	FixNews[] poolFixNews;
	boolean[] inUseFixNews;
	FixEmail[] poolFixEmail;
	boolean[] inUseFixEmail;
	FixNewOrderSingle[] poolFixNewOrderSingle;
	boolean[] inUseFixNewOrderSingle;
	FixNewOrderList[] poolFixNewOrderList;
	boolean[] inUseFixNewOrderList;
	FixOrderCancelRequest[] poolFixOrderCancelRequest;
	boolean[] inUseFixOrderCancelRequest;
	FixOrderCancelReplaceRequest[] poolFixOrderCancelReplaceRequest;
	boolean[] inUseFixOrderCancelReplaceRequest;
	FixOrderStatusRequest[] poolFixOrderStatusRequest;
	boolean[] inUseFixOrderStatusRequest;
	FixAllocationInstruction[] poolFixAllocationInstruction;
	boolean[] inUseFixAllocationInstruction;
	FixListCancelRequest[] poolFixListCancelRequest;
	boolean[] inUseFixListCancelRequest;
	FixListExecute[] poolFixListExecute;
	boolean[] inUseFixListExecute;
	FixListStatusRequest[] poolFixListStatusRequest;
	boolean[] inUseFixListStatusRequest;
	FixListStatus[] poolFixListStatus;
	boolean[] inUseFixListStatus;
	FixAllocationInstructionAck[] poolFixAllocationInstructionAck;
	boolean[] inUseFixAllocationInstructionAck;
	FixDontKnowTradeDK[] poolFixDontKnowTradeDK;
	boolean[] inUseFixDontKnowTradeDK;
	FixQuoteRequest[] poolFixQuoteRequest;
	boolean[] inUseFixQuoteRequest;
	FixQuote[] poolFixQuote;
	boolean[] inUseFixQuote;
	FixSettlementInstructions[] poolFixSettlementInstructions;
	boolean[] inUseFixSettlementInstructions;
	FixMarketDataRequest[] poolFixMarketDataRequest;
	boolean[] inUseFixMarketDataRequest;
	FixMarketDataSnapshotFullRefresh[] poolFixMarketDataSnapshotFullRefresh;
	boolean[] inUseFixMarketDataSnapshotFullRefresh;
	FixMarketDataIncrementalRefresh[] poolFixMarketDataIncrementalRefresh;
	boolean[] inUseFixMarketDataIncrementalRefresh;
	FixMarketDataRequestReject[] poolFixMarketDataRequestReject;
	boolean[] inUseFixMarketDataRequestReject;
	FixQuoteCancel[] poolFixQuoteCancel;
	boolean[] inUseFixQuoteCancel;
	FixQuoteStatusRequest[] poolFixQuoteStatusRequest;
	boolean[] inUseFixQuoteStatusRequest;
	FixMassQuoteAcknowledgement[] poolFixMassQuoteAcknowledgement;
	boolean[] inUseFixMassQuoteAcknowledgement;
	FixSecurityDefinitionRequest[] poolFixSecurityDefinitionRequest;
	boolean[] inUseFixSecurityDefinitionRequest;
	FixSecurityDefinition[] poolFixSecurityDefinition;
	boolean[] inUseFixSecurityDefinition;
	FixSecurityStatusRequest[] poolFixSecurityStatusRequest;
	boolean[] inUseFixSecurityStatusRequest;
	FixSecurityStatus[] poolFixSecurityStatus;
	boolean[] inUseFixSecurityStatus;
	FixTradingSessionStatusRequest[] poolFixTradingSessionStatusRequest;
	boolean[] inUseFixTradingSessionStatusRequest;
	FixTradingSessionStatus[] poolFixTradingSessionStatus;
	boolean[] inUseFixTradingSessionStatus;
	FixMassQuote[] poolFixMassQuote;
	boolean[] inUseFixMassQuote;
	FixBusinessMessageReject[] poolFixBusinessMessageReject;
	boolean[] inUseFixBusinessMessageReject;
	FixBidRequest[] poolFixBidRequest;
	boolean[] inUseFixBidRequest;
	FixBidResponse[] poolFixBidResponse;
	boolean[] inUseFixBidResponse;
	FixListStrikePrice[] poolFixListStrikePrice;
	boolean[] inUseFixListStrikePrice;
	FixRegistrationInstructions[] poolFixRegistrationInstructions;
	boolean[] inUseFixRegistrationInstructions;
	FixRegistrationInstructionsResponse[] poolFixRegistrationInstructionsResponse;
	boolean[] inUseFixRegistrationInstructionsResponse;
	FixOrderMassCancelRequest[] poolFixOrderMassCancelRequest;
	boolean[] inUseFixOrderMassCancelRequest;
	FixOrderMassCancelReport[] poolFixOrderMassCancelReport;
	boolean[] inUseFixOrderMassCancelReport;
	FixNewOrderCross[] poolFixNewOrderCross;
	boolean[] inUseFixNewOrderCross;
	FixCrossOrderCancelReplaceRequest[] poolFixCrossOrderCancelReplaceRequest;
	boolean[] inUseFixCrossOrderCancelReplaceRequest;
	FixCrossOrderCancelRequest[] poolFixCrossOrderCancelRequest;
	boolean[] inUseFixCrossOrderCancelRequest;
	FixSecurityTypeRequest[] poolFixSecurityTypeRequest;
	boolean[] inUseFixSecurityTypeRequest;
	FixSecurityTypes[] poolFixSecurityTypes;
	boolean[] inUseFixSecurityTypes;
	FixSecurityListRequest[] poolFixSecurityListRequest;
	boolean[] inUseFixSecurityListRequest;
	FixSecurityList[] poolFixSecurityList;
	boolean[] inUseFixSecurityList;
	FixDerivativeSecurityListRequest[] poolFixDerivativeSecurityListRequest;
	boolean[] inUseFixDerivativeSecurityListRequest;
	FixDerivativeSecurityList[] poolFixDerivativeSecurityList;
	boolean[] inUseFixDerivativeSecurityList;
	FixNewOrderMultileg[] poolFixNewOrderMultileg;
	boolean[] inUseFixNewOrderMultileg;
	FixMultilegOrderCancelReplace[] poolFixMultilegOrderCancelReplace;
	boolean[] inUseFixMultilegOrderCancelReplace;
	FixTradeCaptureReportRequest[] poolFixTradeCaptureReportRequest;
	boolean[] inUseFixTradeCaptureReportRequest;
	FixTradeCaptureReport[] poolFixTradeCaptureReport;
	boolean[] inUseFixTradeCaptureReport;
	FixOrderMassStatusRequest[] poolFixOrderMassStatusRequest;
	boolean[] inUseFixOrderMassStatusRequest;
	FixQuoteRequestReject[] poolFixQuoteRequestReject;
	boolean[] inUseFixQuoteRequestReject;
	FixRFQRequest[] poolFixRFQRequest;
	boolean[] inUseFixRFQRequest;
	FixQuoteStatusReport[] poolFixQuoteStatusReport;
	boolean[] inUseFixQuoteStatusReport;
	FixQuoteResponse[] poolFixQuoteResponse;
	boolean[] inUseFixQuoteResponse;
	FixConfirmation[] poolFixConfirmation;
	boolean[] inUseFixConfirmation;
	FixPositionMaintenanceRequest[] poolFixPositionMaintenanceRequest;
	boolean[] inUseFixPositionMaintenanceRequest;
	FixPositionMaintenanceReport[] poolFixPositionMaintenanceReport;
	boolean[] inUseFixPositionMaintenanceReport;
	FixRequestForPositions[] poolFixRequestForPositions;
	boolean[] inUseFixRequestForPositions;
	FixRequestForPositionsAck[] poolFixRequestForPositionsAck;
	boolean[] inUseFixRequestForPositionsAck;
	FixPositionReport[] poolFixPositionReport;
	boolean[] inUseFixPositionReport;
	FixTradeCaptureReportRequestAck[] poolFixTradeCaptureReportRequestAck;
	boolean[] inUseFixTradeCaptureReportRequestAck;
	FixTradeCaptureReportAck[] poolFixTradeCaptureReportAck;
	boolean[] inUseFixTradeCaptureReportAck;
	FixAllocationReport[] poolFixAllocationReport;
	boolean[] inUseFixAllocationReport;
	FixAllocationReportAck[] poolFixAllocationReportAck;
	boolean[] inUseFixAllocationReportAck;
	FixConfirmation_Ack[] poolFixConfirmation_Ack;
	boolean[] inUseFixConfirmation_Ack;
	FixSettlementInstructionRequest[] poolFixSettlementInstructionRequest;
	boolean[] inUseFixSettlementInstructionRequest;
	FixAssignmentReport[] poolFixAssignmentReport;
	boolean[] inUseFixAssignmentReport;
	FixCollateralRequest[] poolFixCollateralRequest;
	boolean[] inUseFixCollateralRequest;
	FixCollateralAssignment[] poolFixCollateralAssignment;
	boolean[] inUseFixCollateralAssignment;
	FixCollateralResponse[] poolFixCollateralResponse;
	boolean[] inUseFixCollateralResponse;
	FixCollateralReport[] poolFixCollateralReport;
	boolean[] inUseFixCollateralReport;
	FixCollateralInquiry[] poolFixCollateralInquiry;
	boolean[] inUseFixCollateralInquiry;
	FixNetworkCounterpartySystemStatusRequest[] poolFixNetworkCounterpartySystemStatusRequest;
	boolean[] inUseFixNetworkCounterpartySystemStatusRequest;
	FixNetworkCounterpartySystemStatusResponse[] poolFixNetworkCounterpartySystemStatusResponse;
	boolean[] inUseFixNetworkCounterpartySystemStatusResponse;
	FixUserRequest[] poolFixUserRequest;
	boolean[] inUseFixUserRequest;
	FixUserResponse[] poolFixUserResponse;
	boolean[] inUseFixUserResponse;
	FixCollateralInquiryAck[] poolFixCollateralInquiryAck;
	boolean[] inUseFixCollateralInquiryAck;
	FixConfirmationRequest[] poolFixConfirmationRequest;
	boolean[] inUseFixConfirmationRequest;
	FixContraryIntentionReport[] poolFixContraryIntentionReport;
	boolean[] inUseFixContraryIntentionReport;
	FixSecurityDefinitionUpdateReport[] poolFixSecurityDefinitionUpdateReport;
	boolean[] inUseFixSecurityDefinitionUpdateReport;
	FixSecurityListUpdateReport[] poolFixSecurityListUpdateReport;
	boolean[] inUseFixSecurityListUpdateReport;
	FixAdjustedPositionReport[] poolFixAdjustedPositionReport;
	boolean[] inUseFixAdjustedPositionReport;
	FixAllocationInstructionAlert[] poolFixAllocationInstructionAlert;
	boolean[] inUseFixAllocationInstructionAlert;
	FixExecutionAcknowledgement[] poolFixExecutionAcknowledgement;
	boolean[] inUseFixExecutionAcknowledgement;
	FixTradingSessionList[] poolFixTradingSessionList;
	boolean[] inUseFixTradingSessionList;
	FixTradingSessionListRequest[] poolFixTradingSessionListRequest;
	boolean[] inUseFixTradingSessionListRequest;
	FixSettlementObligationReport[] poolFixSettlementObligationReport;
	boolean[] inUseFixSettlementObligationReport;
	FixDerivativeSecurityListUpdateReport[] poolFixDerivativeSecurityListUpdateReport;
	boolean[] inUseFixDerivativeSecurityListUpdateReport;
	FixTradingSessionListUpdateReport[] poolFixTradingSessionListUpdateReport;
	boolean[] inUseFixTradingSessionListUpdateReport;
	FixMarketDefinitionRequest[] poolFixMarketDefinitionRequest;
	boolean[] inUseFixMarketDefinitionRequest;
	FixMarketDefinition[] poolFixMarketDefinition;
	boolean[] inUseFixMarketDefinition;
	FixMarketDefinitionUpdateReport[] poolFixMarketDefinitionUpdateReport;
	boolean[] inUseFixMarketDefinitionUpdateReport;
	FixUserNotification[] poolFixUserNotification;
	boolean[] inUseFixUserNotification;
	FixOrderMassActionReport[] poolFixOrderMassActionReport;
	boolean[] inUseFixOrderMassActionReport;
	FixOrderMassActionRequest[] poolFixOrderMassActionRequest;
	boolean[] inUseFixOrderMassActionRequest;
	FixApplicationMessageRequest[] poolFixApplicationMessageRequest;
	boolean[] inUseFixApplicationMessageRequest;
	FixApplicationMessageRequestAck[] poolFixApplicationMessageRequestAck;
	boolean[] inUseFixApplicationMessageRequestAck;
	FixApplicationMessageReport[] poolFixApplicationMessageReport;
	boolean[] inUseFixApplicationMessageReport;
	FixStreamAssignmentRequest[] poolFixStreamAssignmentRequest;
	boolean[] inUseFixStreamAssignmentRequest;
	FixStreamAssignmentReport[] poolFixStreamAssignmentReport;
	boolean[] inUseFixStreamAssignmentReport;
	FixStreamAssignmentReportACK[] poolFixStreamAssignmentReportACK;
	boolean[] inUseFixStreamAssignmentReportACK;
	FixPartyDetailsListRequest[] poolFixPartyDetailsListRequest;
	boolean[] inUseFixPartyDetailsListRequest;
	FixPartyDetailsListReport[] poolFixPartyDetailsListReport;
	boolean[] inUseFixPartyDetailsListReport;

	public FixMessagePool() {
		poolFixHeartbeat = new FixHeartbeat[1];
		inUseFixHeartbeat = new boolean[1];

		for (int i = poolFixHeartbeat.length - 1; i >= 0; i--) {
			poolFixHeartbeat[i] = new FixHeartbeat();
			inUseFixHeartbeat[i] = false;
		}
		poolFixTestRequest = new FixTestRequest[1];
		inUseFixTestRequest = new boolean[1];

		for (int i = poolFixTestRequest.length - 1; i >= 0; i--) {
			poolFixTestRequest[i] = new FixTestRequest();
			inUseFixTestRequest[i] = false;
		}
		poolFixResendRequest = new FixResendRequest[1];
		inUseFixResendRequest = new boolean[1];

		for (int i = poolFixResendRequest.length - 1; i >= 0; i--) {
			poolFixResendRequest[i] = new FixResendRequest();
			inUseFixResendRequest[i] = false;
		}
		poolFixReject = new FixReject[1];
		inUseFixReject = new boolean[1];

		for (int i = poolFixReject.length - 1; i >= 0; i--) {
			poolFixReject[i] = new FixReject();
			inUseFixReject[i] = false;
		}
		poolFixSequenceReset = new FixSequenceReset[1];
		inUseFixSequenceReset = new boolean[1];

		for (int i = poolFixSequenceReset.length - 1; i >= 0; i--) {
			poolFixSequenceReset[i] = new FixSequenceReset();
			inUseFixSequenceReset[i] = false;
		}
		poolFixLogout = new FixLogout[1];
		inUseFixLogout = new boolean[1];

		for (int i = poolFixLogout.length - 1; i >= 0; i--) {
			poolFixLogout[i] = new FixLogout();
			inUseFixLogout[i] = false;
		}
		poolFixIOI = new FixIOI[1];
		inUseFixIOI = new boolean[1];

		for (int i = poolFixIOI.length - 1; i >= 0; i--) {
			poolFixIOI[i] = new FixIOI();
			inUseFixIOI[i] = false;
		}
		poolFixAdvertisement = new FixAdvertisement[1];
		inUseFixAdvertisement = new boolean[1];

		for (int i = poolFixAdvertisement.length - 1; i >= 0; i--) {
			poolFixAdvertisement[i] = new FixAdvertisement();
			inUseFixAdvertisement[i] = false;
		}
		poolFixExecutionReport = new FixExecutionReport[1];
		inUseFixExecutionReport = new boolean[1];

		for (int i = poolFixExecutionReport.length - 1; i >= 0; i--) {
			poolFixExecutionReport[i] = new FixExecutionReport();
			inUseFixExecutionReport[i] = false;
		}
		poolFixOrderCancelReject = new FixOrderCancelReject[1];
		inUseFixOrderCancelReject = new boolean[1];

		for (int i = poolFixOrderCancelReject.length - 1; i >= 0; i--) {
			poolFixOrderCancelReject[i] = new FixOrderCancelReject();
			inUseFixOrderCancelReject[i] = false;
		}
		poolFixLogon = new FixLogon[1];
		inUseFixLogon = new boolean[1];

		for (int i = poolFixLogon.length - 1; i >= 0; i--) {
			poolFixLogon[i] = new FixLogon();
			inUseFixLogon[i] = false;
		}
		poolFixNews = new FixNews[1];
		inUseFixNews = new boolean[1];

		for (int i = poolFixNews.length - 1; i >= 0; i--) {
			poolFixNews[i] = new FixNews();
			inUseFixNews[i] = false;
		}
		poolFixEmail = new FixEmail[1];
		inUseFixEmail = new boolean[1];

		for (int i = poolFixEmail.length - 1; i >= 0; i--) {
			poolFixEmail[i] = new FixEmail();
			inUseFixEmail[i] = false;
		}
		poolFixNewOrderSingle = new FixNewOrderSingle[1];
		inUseFixNewOrderSingle = new boolean[1];

		for (int i = poolFixNewOrderSingle.length - 1; i >= 0; i--) {
			poolFixNewOrderSingle[i] = new FixNewOrderSingle();
			inUseFixNewOrderSingle[i] = false;
		}
		poolFixNewOrderList = new FixNewOrderList[1];
		inUseFixNewOrderList = new boolean[1];

		for (int i = poolFixNewOrderList.length - 1; i >= 0; i--) {
			poolFixNewOrderList[i] = new FixNewOrderList();
			inUseFixNewOrderList[i] = false;
		}
		poolFixOrderCancelRequest = new FixOrderCancelRequest[1];
		inUseFixOrderCancelRequest = new boolean[1];

		for (int i = poolFixOrderCancelRequest.length - 1; i >= 0; i--) {
			poolFixOrderCancelRequest[i] = new FixOrderCancelRequest();
			inUseFixOrderCancelRequest[i] = false;
		}
		poolFixOrderCancelReplaceRequest = new FixOrderCancelReplaceRequest[1];
		inUseFixOrderCancelReplaceRequest = new boolean[1];

		for (int i = poolFixOrderCancelReplaceRequest.length - 1; i >= 0; i--) {
			poolFixOrderCancelReplaceRequest[i] = new FixOrderCancelReplaceRequest();
			inUseFixOrderCancelReplaceRequest[i] = false;
		}
		poolFixOrderStatusRequest = new FixOrderStatusRequest[1];
		inUseFixOrderStatusRequest = new boolean[1];

		for (int i = poolFixOrderStatusRequest.length - 1; i >= 0; i--) {
			poolFixOrderStatusRequest[i] = new FixOrderStatusRequest();
			inUseFixOrderStatusRequest[i] = false;
		}
		poolFixAllocationInstruction = new FixAllocationInstruction[1];
		inUseFixAllocationInstruction = new boolean[1];

		for (int i = poolFixAllocationInstruction.length - 1; i >= 0; i--) {
			poolFixAllocationInstruction[i] = new FixAllocationInstruction();
			inUseFixAllocationInstruction[i] = false;
		}
		poolFixListCancelRequest = new FixListCancelRequest[1];
		inUseFixListCancelRequest = new boolean[1];

		for (int i = poolFixListCancelRequest.length - 1; i >= 0; i--) {
			poolFixListCancelRequest[i] = new FixListCancelRequest();
			inUseFixListCancelRequest[i] = false;
		}
		poolFixListExecute = new FixListExecute[1];
		inUseFixListExecute = new boolean[1];

		for (int i = poolFixListExecute.length - 1; i >= 0; i--) {
			poolFixListExecute[i] = new FixListExecute();
			inUseFixListExecute[i] = false;
		}
		poolFixListStatusRequest = new FixListStatusRequest[1];
		inUseFixListStatusRequest = new boolean[1];

		for (int i = poolFixListStatusRequest.length - 1; i >= 0; i--) {
			poolFixListStatusRequest[i] = new FixListStatusRequest();
			inUseFixListStatusRequest[i] = false;
		}
		poolFixListStatus = new FixListStatus[1];
		inUseFixListStatus = new boolean[1];

		for (int i = poolFixListStatus.length - 1; i >= 0; i--) {
			poolFixListStatus[i] = new FixListStatus();
			inUseFixListStatus[i] = false;
		}
		poolFixAllocationInstructionAck = new FixAllocationInstructionAck[1];
		inUseFixAllocationInstructionAck = new boolean[1];

		for (int i = poolFixAllocationInstructionAck.length - 1; i >= 0; i--) {
			poolFixAllocationInstructionAck[i] = new FixAllocationInstructionAck();
			inUseFixAllocationInstructionAck[i] = false;
		}
		poolFixDontKnowTradeDK = new FixDontKnowTradeDK[1];
		inUseFixDontKnowTradeDK = new boolean[1];

		for (int i = poolFixDontKnowTradeDK.length - 1; i >= 0; i--) {
			poolFixDontKnowTradeDK[i] = new FixDontKnowTradeDK();
			inUseFixDontKnowTradeDK[i] = false;
		}
		poolFixQuoteRequest = new FixQuoteRequest[1];
		inUseFixQuoteRequest = new boolean[1];

		for (int i = poolFixQuoteRequest.length - 1; i >= 0; i--) {
			poolFixQuoteRequest[i] = new FixQuoteRequest();
			inUseFixQuoteRequest[i] = false;
		}
		poolFixQuote = new FixQuote[1];
		inUseFixQuote = new boolean[1];

		for (int i = poolFixQuote.length - 1; i >= 0; i--) {
			poolFixQuote[i] = new FixQuote();
			inUseFixQuote[i] = false;
		}
		poolFixSettlementInstructions = new FixSettlementInstructions[1];
		inUseFixSettlementInstructions = new boolean[1];

		for (int i = poolFixSettlementInstructions.length - 1; i >= 0; i--) {
			poolFixSettlementInstructions[i] = new FixSettlementInstructions();
			inUseFixSettlementInstructions[i] = false;
		}
		poolFixMarketDataRequest = new FixMarketDataRequest[1];
		inUseFixMarketDataRequest = new boolean[1];

		for (int i = poolFixMarketDataRequest.length - 1; i >= 0; i--) {
			poolFixMarketDataRequest[i] = new FixMarketDataRequest();
			inUseFixMarketDataRequest[i] = false;
		}
		poolFixMarketDataSnapshotFullRefresh = new FixMarketDataSnapshotFullRefresh[1];
		inUseFixMarketDataSnapshotFullRefresh = new boolean[1];

		for (int i = poolFixMarketDataSnapshotFullRefresh.length - 1; i >= 0; i--) {
			poolFixMarketDataSnapshotFullRefresh[i] = new FixMarketDataSnapshotFullRefresh();
			inUseFixMarketDataSnapshotFullRefresh[i] = false;
		}
		poolFixMarketDataIncrementalRefresh = new FixMarketDataIncrementalRefresh[1];
		inUseFixMarketDataIncrementalRefresh = new boolean[1];

		for (int i = poolFixMarketDataIncrementalRefresh.length - 1; i >= 0; i--) {
			poolFixMarketDataIncrementalRefresh[i] = new FixMarketDataIncrementalRefresh();
			inUseFixMarketDataIncrementalRefresh[i] = false;
		}
		poolFixMarketDataRequestReject = new FixMarketDataRequestReject[1];
		inUseFixMarketDataRequestReject = new boolean[1];

		for (int i = poolFixMarketDataRequestReject.length - 1; i >= 0; i--) {
			poolFixMarketDataRequestReject[i] = new FixMarketDataRequestReject();
			inUseFixMarketDataRequestReject[i] = false;
		}
		poolFixQuoteCancel = new FixQuoteCancel[1];
		inUseFixQuoteCancel = new boolean[1];

		for (int i = poolFixQuoteCancel.length - 1; i >= 0; i--) {
			poolFixQuoteCancel[i] = new FixQuoteCancel();
			inUseFixQuoteCancel[i] = false;
		}
		poolFixQuoteStatusRequest = new FixQuoteStatusRequest[1];
		inUseFixQuoteStatusRequest = new boolean[1];

		for (int i = poolFixQuoteStatusRequest.length - 1; i >= 0; i--) {
			poolFixQuoteStatusRequest[i] = new FixQuoteStatusRequest();
			inUseFixQuoteStatusRequest[i] = false;
		}
		poolFixMassQuoteAcknowledgement = new FixMassQuoteAcknowledgement[1];
		inUseFixMassQuoteAcknowledgement = new boolean[1];

		for (int i = poolFixMassQuoteAcknowledgement.length - 1; i >= 0; i--) {
			poolFixMassQuoteAcknowledgement[i] = new FixMassQuoteAcknowledgement();
			inUseFixMassQuoteAcknowledgement[i] = false;
		}
		poolFixSecurityDefinitionRequest = new FixSecurityDefinitionRequest[1];
		inUseFixSecurityDefinitionRequest = new boolean[1];

		for (int i = poolFixSecurityDefinitionRequest.length - 1; i >= 0; i--) {
			poolFixSecurityDefinitionRequest[i] = new FixSecurityDefinitionRequest();
			inUseFixSecurityDefinitionRequest[i] = false;
		}
		poolFixSecurityDefinition = new FixSecurityDefinition[1];
		inUseFixSecurityDefinition = new boolean[1];

		for (int i = poolFixSecurityDefinition.length - 1; i >= 0; i--) {
			poolFixSecurityDefinition[i] = new FixSecurityDefinition();
			inUseFixSecurityDefinition[i] = false;
		}
		poolFixSecurityStatusRequest = new FixSecurityStatusRequest[1];
		inUseFixSecurityStatusRequest = new boolean[1];

		for (int i = poolFixSecurityStatusRequest.length - 1; i >= 0; i--) {
			poolFixSecurityStatusRequest[i] = new FixSecurityStatusRequest();
			inUseFixSecurityStatusRequest[i] = false;
		}
		poolFixSecurityStatus = new FixSecurityStatus[1];
		inUseFixSecurityStatus = new boolean[1];

		for (int i = poolFixSecurityStatus.length - 1; i >= 0; i--) {
			poolFixSecurityStatus[i] = new FixSecurityStatus();
			inUseFixSecurityStatus[i] = false;
		}
		poolFixTradingSessionStatusRequest = new FixTradingSessionStatusRequest[1];
		inUseFixTradingSessionStatusRequest = new boolean[1];

		for (int i = poolFixTradingSessionStatusRequest.length - 1; i >= 0; i--) {
			poolFixTradingSessionStatusRequest[i] = new FixTradingSessionStatusRequest();
			inUseFixTradingSessionStatusRequest[i] = false;
		}
		poolFixTradingSessionStatus = new FixTradingSessionStatus[1];
		inUseFixTradingSessionStatus = new boolean[1];

		for (int i = poolFixTradingSessionStatus.length - 1; i >= 0; i--) {
			poolFixTradingSessionStatus[i] = new FixTradingSessionStatus();
			inUseFixTradingSessionStatus[i] = false;
		}
		poolFixMassQuote = new FixMassQuote[1];
		inUseFixMassQuote = new boolean[1];

		for (int i = poolFixMassQuote.length - 1; i >= 0; i--) {
			poolFixMassQuote[i] = new FixMassQuote();
			inUseFixMassQuote[i] = false;
		}
		poolFixBusinessMessageReject = new FixBusinessMessageReject[1];
		inUseFixBusinessMessageReject = new boolean[1];

		for (int i = poolFixBusinessMessageReject.length - 1; i >= 0; i--) {
			poolFixBusinessMessageReject[i] = new FixBusinessMessageReject();
			inUseFixBusinessMessageReject[i] = false;
		}
		poolFixBidRequest = new FixBidRequest[1];
		inUseFixBidRequest = new boolean[1];

		for (int i = poolFixBidRequest.length - 1; i >= 0; i--) {
			poolFixBidRequest[i] = new FixBidRequest();
			inUseFixBidRequest[i] = false;
		}
		poolFixBidResponse = new FixBidResponse[1];
		inUseFixBidResponse = new boolean[1];

		for (int i = poolFixBidResponse.length - 1; i >= 0; i--) {
			poolFixBidResponse[i] = new FixBidResponse();
			inUseFixBidResponse[i] = false;
		}
		poolFixListStrikePrice = new FixListStrikePrice[1];
		inUseFixListStrikePrice = new boolean[1];

		for (int i = poolFixListStrikePrice.length - 1; i >= 0; i--) {
			poolFixListStrikePrice[i] = new FixListStrikePrice();
			inUseFixListStrikePrice[i] = false;
		}
		poolFixRegistrationInstructions = new FixRegistrationInstructions[1];
		inUseFixRegistrationInstructions = new boolean[1];

		for (int i = poolFixRegistrationInstructions.length - 1; i >= 0; i--) {
			poolFixRegistrationInstructions[i] = new FixRegistrationInstructions();
			inUseFixRegistrationInstructions[i] = false;
		}
		poolFixRegistrationInstructionsResponse = new FixRegistrationInstructionsResponse[1];
		inUseFixRegistrationInstructionsResponse = new boolean[1];

		for (int i = poolFixRegistrationInstructionsResponse.length - 1; i >= 0; i--) {
			poolFixRegistrationInstructionsResponse[i] = new FixRegistrationInstructionsResponse();
			inUseFixRegistrationInstructionsResponse[i] = false;
		}
		poolFixOrderMassCancelRequest = new FixOrderMassCancelRequest[1];
		inUseFixOrderMassCancelRequest = new boolean[1];

		for (int i = poolFixOrderMassCancelRequest.length - 1; i >= 0; i--) {
			poolFixOrderMassCancelRequest[i] = new FixOrderMassCancelRequest();
			inUseFixOrderMassCancelRequest[i] = false;
		}
		poolFixOrderMassCancelReport = new FixOrderMassCancelReport[1];
		inUseFixOrderMassCancelReport = new boolean[1];

		for (int i = poolFixOrderMassCancelReport.length - 1; i >= 0; i--) {
			poolFixOrderMassCancelReport[i] = new FixOrderMassCancelReport();
			inUseFixOrderMassCancelReport[i] = false;
		}
		poolFixNewOrderCross = new FixNewOrderCross[1];
		inUseFixNewOrderCross = new boolean[1];

		for (int i = poolFixNewOrderCross.length - 1; i >= 0; i--) {
			poolFixNewOrderCross[i] = new FixNewOrderCross();
			inUseFixNewOrderCross[i] = false;
		}
		poolFixCrossOrderCancelReplaceRequest = new FixCrossOrderCancelReplaceRequest[1];
		inUseFixCrossOrderCancelReplaceRequest = new boolean[1];

		for (int i = poolFixCrossOrderCancelReplaceRequest.length - 1; i >= 0; i--) {
			poolFixCrossOrderCancelReplaceRequest[i] = new FixCrossOrderCancelReplaceRequest();
			inUseFixCrossOrderCancelReplaceRequest[i] = false;
		}
		poolFixCrossOrderCancelRequest = new FixCrossOrderCancelRequest[1];
		inUseFixCrossOrderCancelRequest = new boolean[1];

		for (int i = poolFixCrossOrderCancelRequest.length - 1; i >= 0; i--) {
			poolFixCrossOrderCancelRequest[i] = new FixCrossOrderCancelRequest();
			inUseFixCrossOrderCancelRequest[i] = false;
		}
		poolFixSecurityTypeRequest = new FixSecurityTypeRequest[1];
		inUseFixSecurityTypeRequest = new boolean[1];

		for (int i = poolFixSecurityTypeRequest.length - 1; i >= 0; i--) {
			poolFixSecurityTypeRequest[i] = new FixSecurityTypeRequest();
			inUseFixSecurityTypeRequest[i] = false;
		}
		poolFixSecurityTypes = new FixSecurityTypes[1];
		inUseFixSecurityTypes = new boolean[1];

		for (int i = poolFixSecurityTypes.length - 1; i >= 0; i--) {
			poolFixSecurityTypes[i] = new FixSecurityTypes();
			inUseFixSecurityTypes[i] = false;
		}
		poolFixSecurityListRequest = new FixSecurityListRequest[1];
		inUseFixSecurityListRequest = new boolean[1];

		for (int i = poolFixSecurityListRequest.length - 1; i >= 0; i--) {
			poolFixSecurityListRequest[i] = new FixSecurityListRequest();
			inUseFixSecurityListRequest[i] = false;
		}
		poolFixSecurityList = new FixSecurityList[1];
		inUseFixSecurityList = new boolean[1];

		for (int i = poolFixSecurityList.length - 1; i >= 0; i--) {
			poolFixSecurityList[i] = new FixSecurityList();
			inUseFixSecurityList[i] = false;
		}
		poolFixDerivativeSecurityListRequest = new FixDerivativeSecurityListRequest[1];
		inUseFixDerivativeSecurityListRequest = new boolean[1];

		for (int i = poolFixDerivativeSecurityListRequest.length - 1; i >= 0; i--) {
			poolFixDerivativeSecurityListRequest[i] = new FixDerivativeSecurityListRequest();
			inUseFixDerivativeSecurityListRequest[i] = false;
		}
		poolFixDerivativeSecurityList = new FixDerivativeSecurityList[1];
		inUseFixDerivativeSecurityList = new boolean[1];

		for (int i = poolFixDerivativeSecurityList.length - 1; i >= 0; i--) {
			poolFixDerivativeSecurityList[i] = new FixDerivativeSecurityList();
			inUseFixDerivativeSecurityList[i] = false;
		}
		poolFixNewOrderMultileg = new FixNewOrderMultileg[1];
		inUseFixNewOrderMultileg = new boolean[1];

		for (int i = poolFixNewOrderMultileg.length - 1; i >= 0; i--) {
			poolFixNewOrderMultileg[i] = new FixNewOrderMultileg();
			inUseFixNewOrderMultileg[i] = false;
		}
		poolFixMultilegOrderCancelReplace = new FixMultilegOrderCancelReplace[1];
		inUseFixMultilegOrderCancelReplace = new boolean[1];

		for (int i = poolFixMultilegOrderCancelReplace.length - 1; i >= 0; i--) {
			poolFixMultilegOrderCancelReplace[i] = new FixMultilegOrderCancelReplace();
			inUseFixMultilegOrderCancelReplace[i] = false;
		}
		poolFixTradeCaptureReportRequest = new FixTradeCaptureReportRequest[1];
		inUseFixTradeCaptureReportRequest = new boolean[1];

		for (int i = poolFixTradeCaptureReportRequest.length - 1; i >= 0; i--) {
			poolFixTradeCaptureReportRequest[i] = new FixTradeCaptureReportRequest();
			inUseFixTradeCaptureReportRequest[i] = false;
		}
		poolFixTradeCaptureReport = new FixTradeCaptureReport[1];
		inUseFixTradeCaptureReport = new boolean[1];

		for (int i = poolFixTradeCaptureReport.length - 1; i >= 0; i--) {
			poolFixTradeCaptureReport[i] = new FixTradeCaptureReport();
			inUseFixTradeCaptureReport[i] = false;
		}
		poolFixOrderMassStatusRequest = new FixOrderMassStatusRequest[1];
		inUseFixOrderMassStatusRequest = new boolean[1];

		for (int i = poolFixOrderMassStatusRequest.length - 1; i >= 0; i--) {
			poolFixOrderMassStatusRequest[i] = new FixOrderMassStatusRequest();
			inUseFixOrderMassStatusRequest[i] = false;
		}
		poolFixQuoteRequestReject = new FixQuoteRequestReject[1];
		inUseFixQuoteRequestReject = new boolean[1];

		for (int i = poolFixQuoteRequestReject.length - 1; i >= 0; i--) {
			poolFixQuoteRequestReject[i] = new FixQuoteRequestReject();
			inUseFixQuoteRequestReject[i] = false;
		}
		poolFixRFQRequest = new FixRFQRequest[1];
		inUseFixRFQRequest = new boolean[1];

		for (int i = poolFixRFQRequest.length - 1; i >= 0; i--) {
			poolFixRFQRequest[i] = new FixRFQRequest();
			inUseFixRFQRequest[i] = false;
		}
		poolFixQuoteStatusReport = new FixQuoteStatusReport[1];
		inUseFixQuoteStatusReport = new boolean[1];

		for (int i = poolFixQuoteStatusReport.length - 1; i >= 0; i--) {
			poolFixQuoteStatusReport[i] = new FixQuoteStatusReport();
			inUseFixQuoteStatusReport[i] = false;
		}
		poolFixQuoteResponse = new FixQuoteResponse[1];
		inUseFixQuoteResponse = new boolean[1];

		for (int i = poolFixQuoteResponse.length - 1; i >= 0; i--) {
			poolFixQuoteResponse[i] = new FixQuoteResponse();
			inUseFixQuoteResponse[i] = false;
		}
		poolFixConfirmation = new FixConfirmation[1];
		inUseFixConfirmation = new boolean[1];

		for (int i = poolFixConfirmation.length - 1; i >= 0; i--) {
			poolFixConfirmation[i] = new FixConfirmation();
			inUseFixConfirmation[i] = false;
		}
		poolFixPositionMaintenanceRequest = new FixPositionMaintenanceRequest[1];
		inUseFixPositionMaintenanceRequest = new boolean[1];

		for (int i = poolFixPositionMaintenanceRequest.length - 1; i >= 0; i--) {
			poolFixPositionMaintenanceRequest[i] = new FixPositionMaintenanceRequest();
			inUseFixPositionMaintenanceRequest[i] = false;
		}
		poolFixPositionMaintenanceReport = new FixPositionMaintenanceReport[1];
		inUseFixPositionMaintenanceReport = new boolean[1];

		for (int i = poolFixPositionMaintenanceReport.length - 1; i >= 0; i--) {
			poolFixPositionMaintenanceReport[i] = new FixPositionMaintenanceReport();
			inUseFixPositionMaintenanceReport[i] = false;
		}
		poolFixRequestForPositions = new FixRequestForPositions[1];
		inUseFixRequestForPositions = new boolean[1];

		for (int i = poolFixRequestForPositions.length - 1; i >= 0; i--) {
			poolFixRequestForPositions[i] = new FixRequestForPositions();
			inUseFixRequestForPositions[i] = false;
		}
		poolFixRequestForPositionsAck = new FixRequestForPositionsAck[1];
		inUseFixRequestForPositionsAck = new boolean[1];

		for (int i = poolFixRequestForPositionsAck.length - 1; i >= 0; i--) {
			poolFixRequestForPositionsAck[i] = new FixRequestForPositionsAck();
			inUseFixRequestForPositionsAck[i] = false;
		}
		poolFixPositionReport = new FixPositionReport[1];
		inUseFixPositionReport = new boolean[1];

		for (int i = poolFixPositionReport.length - 1; i >= 0; i--) {
			poolFixPositionReport[i] = new FixPositionReport();
			inUseFixPositionReport[i] = false;
		}
		poolFixTradeCaptureReportRequestAck = new FixTradeCaptureReportRequestAck[1];
		inUseFixTradeCaptureReportRequestAck = new boolean[1];

		for (int i = poolFixTradeCaptureReportRequestAck.length - 1; i >= 0; i--) {
			poolFixTradeCaptureReportRequestAck[i] = new FixTradeCaptureReportRequestAck();
			inUseFixTradeCaptureReportRequestAck[i] = false;
		}
		poolFixTradeCaptureReportAck = new FixTradeCaptureReportAck[1];
		inUseFixTradeCaptureReportAck = new boolean[1];

		for (int i = poolFixTradeCaptureReportAck.length - 1; i >= 0; i--) {
			poolFixTradeCaptureReportAck[i] = new FixTradeCaptureReportAck();
			inUseFixTradeCaptureReportAck[i] = false;
		}
		poolFixAllocationReport = new FixAllocationReport[1];
		inUseFixAllocationReport = new boolean[1];

		for (int i = poolFixAllocationReport.length - 1; i >= 0; i--) {
			poolFixAllocationReport[i] = new FixAllocationReport();
			inUseFixAllocationReport[i] = false;
		}
		poolFixAllocationReportAck = new FixAllocationReportAck[1];
		inUseFixAllocationReportAck = new boolean[1];

		for (int i = poolFixAllocationReportAck.length - 1; i >= 0; i--) {
			poolFixAllocationReportAck[i] = new FixAllocationReportAck();
			inUseFixAllocationReportAck[i] = false;
		}
		poolFixConfirmation_Ack = new FixConfirmation_Ack[1];
		inUseFixConfirmation_Ack = new boolean[1];

		for (int i = poolFixConfirmation_Ack.length - 1; i >= 0; i--) {
			poolFixConfirmation_Ack[i] = new FixConfirmation_Ack();
			inUseFixConfirmation_Ack[i] = false;
		}
		poolFixSettlementInstructionRequest = new FixSettlementInstructionRequest[1];
		inUseFixSettlementInstructionRequest = new boolean[1];

		for (int i = poolFixSettlementInstructionRequest.length - 1; i >= 0; i--) {
			poolFixSettlementInstructionRequest[i] = new FixSettlementInstructionRequest();
			inUseFixSettlementInstructionRequest[i] = false;
		}
		poolFixAssignmentReport = new FixAssignmentReport[1];
		inUseFixAssignmentReport = new boolean[1];

		for (int i = poolFixAssignmentReport.length - 1; i >= 0; i--) {
			poolFixAssignmentReport[i] = new FixAssignmentReport();
			inUseFixAssignmentReport[i] = false;
		}
		poolFixCollateralRequest = new FixCollateralRequest[1];
		inUseFixCollateralRequest = new boolean[1];

		for (int i = poolFixCollateralRequest.length - 1; i >= 0; i--) {
			poolFixCollateralRequest[i] = new FixCollateralRequest();
			inUseFixCollateralRequest[i] = false;
		}
		poolFixCollateralAssignment = new FixCollateralAssignment[1];
		inUseFixCollateralAssignment = new boolean[1];

		for (int i = poolFixCollateralAssignment.length - 1; i >= 0; i--) {
			poolFixCollateralAssignment[i] = new FixCollateralAssignment();
			inUseFixCollateralAssignment[i] = false;
		}
		poolFixCollateralResponse = new FixCollateralResponse[1];
		inUseFixCollateralResponse = new boolean[1];

		for (int i = poolFixCollateralResponse.length - 1; i >= 0; i--) {
			poolFixCollateralResponse[i] = new FixCollateralResponse();
			inUseFixCollateralResponse[i] = false;
		}
		poolFixCollateralReport = new FixCollateralReport[1];
		inUseFixCollateralReport = new boolean[1];

		for (int i = poolFixCollateralReport.length - 1; i >= 0; i--) {
			poolFixCollateralReport[i] = new FixCollateralReport();
			inUseFixCollateralReport[i] = false;
		}
		poolFixCollateralInquiry = new FixCollateralInquiry[1];
		inUseFixCollateralInquiry = new boolean[1];

		for (int i = poolFixCollateralInquiry.length - 1; i >= 0; i--) {
			poolFixCollateralInquiry[i] = new FixCollateralInquiry();
			inUseFixCollateralInquiry[i] = false;
		}
		poolFixNetworkCounterpartySystemStatusRequest = new FixNetworkCounterpartySystemStatusRequest[1];
		inUseFixNetworkCounterpartySystemStatusRequest = new boolean[1];

		for (int i = poolFixNetworkCounterpartySystemStatusRequest.length - 1; i >= 0; i--) {
			poolFixNetworkCounterpartySystemStatusRequest[i] = new FixNetworkCounterpartySystemStatusRequest();
			inUseFixNetworkCounterpartySystemStatusRequest[i] = false;
		}
		poolFixNetworkCounterpartySystemStatusResponse = new FixNetworkCounterpartySystemStatusResponse[1];
		inUseFixNetworkCounterpartySystemStatusResponse = new boolean[1];

		for (int i = poolFixNetworkCounterpartySystemStatusResponse.length - 1; i >= 0; i--) {
			poolFixNetworkCounterpartySystemStatusResponse[i] = new FixNetworkCounterpartySystemStatusResponse();
			inUseFixNetworkCounterpartySystemStatusResponse[i] = false;
		}
		poolFixUserRequest = new FixUserRequest[1];
		inUseFixUserRequest = new boolean[1];

		for (int i = poolFixUserRequest.length - 1; i >= 0; i--) {
			poolFixUserRequest[i] = new FixUserRequest();
			inUseFixUserRequest[i] = false;
		}
		poolFixUserResponse = new FixUserResponse[1];
		inUseFixUserResponse = new boolean[1];

		for (int i = poolFixUserResponse.length - 1; i >= 0; i--) {
			poolFixUserResponse[i] = new FixUserResponse();
			inUseFixUserResponse[i] = false;
		}
		poolFixCollateralInquiryAck = new FixCollateralInquiryAck[1];
		inUseFixCollateralInquiryAck = new boolean[1];

		for (int i = poolFixCollateralInquiryAck.length - 1; i >= 0; i--) {
			poolFixCollateralInquiryAck[i] = new FixCollateralInquiryAck();
			inUseFixCollateralInquiryAck[i] = false;
		}
		poolFixConfirmationRequest = new FixConfirmationRequest[1];
		inUseFixConfirmationRequest = new boolean[1];

		for (int i = poolFixConfirmationRequest.length - 1; i >= 0; i--) {
			poolFixConfirmationRequest[i] = new FixConfirmationRequest();
			inUseFixConfirmationRequest[i] = false;
		}
		poolFixContraryIntentionReport = new FixContraryIntentionReport[1];
		inUseFixContraryIntentionReport = new boolean[1];

		for (int i = poolFixContraryIntentionReport.length - 1; i >= 0; i--) {
			poolFixContraryIntentionReport[i] = new FixContraryIntentionReport();
			inUseFixContraryIntentionReport[i] = false;
		}
		poolFixSecurityDefinitionUpdateReport = new FixSecurityDefinitionUpdateReport[1];
		inUseFixSecurityDefinitionUpdateReport = new boolean[1];

		for (int i = poolFixSecurityDefinitionUpdateReport.length - 1; i >= 0; i--) {
			poolFixSecurityDefinitionUpdateReport[i] = new FixSecurityDefinitionUpdateReport();
			inUseFixSecurityDefinitionUpdateReport[i] = false;
		}
		poolFixSecurityListUpdateReport = new FixSecurityListUpdateReport[1];
		inUseFixSecurityListUpdateReport = new boolean[1];

		for (int i = poolFixSecurityListUpdateReport.length - 1; i >= 0; i--) {
			poolFixSecurityListUpdateReport[i] = new FixSecurityListUpdateReport();
			inUseFixSecurityListUpdateReport[i] = false;
		}
		poolFixAdjustedPositionReport = new FixAdjustedPositionReport[1];
		inUseFixAdjustedPositionReport = new boolean[1];

		for (int i = poolFixAdjustedPositionReport.length - 1; i >= 0; i--) {
			poolFixAdjustedPositionReport[i] = new FixAdjustedPositionReport();
			inUseFixAdjustedPositionReport[i] = false;
		}
		poolFixAllocationInstructionAlert = new FixAllocationInstructionAlert[1];
		inUseFixAllocationInstructionAlert = new boolean[1];

		for (int i = poolFixAllocationInstructionAlert.length - 1; i >= 0; i--) {
			poolFixAllocationInstructionAlert[i] = new FixAllocationInstructionAlert();
			inUseFixAllocationInstructionAlert[i] = false;
		}
		poolFixExecutionAcknowledgement = new FixExecutionAcknowledgement[1];
		inUseFixExecutionAcknowledgement = new boolean[1];

		for (int i = poolFixExecutionAcknowledgement.length - 1; i >= 0; i--) {
			poolFixExecutionAcknowledgement[i] = new FixExecutionAcknowledgement();
			inUseFixExecutionAcknowledgement[i] = false;
		}
		poolFixTradingSessionList = new FixTradingSessionList[1];
		inUseFixTradingSessionList = new boolean[1];

		for (int i = poolFixTradingSessionList.length - 1; i >= 0; i--) {
			poolFixTradingSessionList[i] = new FixTradingSessionList();
			inUseFixTradingSessionList[i] = false;
		}
		poolFixTradingSessionListRequest = new FixTradingSessionListRequest[1];
		inUseFixTradingSessionListRequest = new boolean[1];

		for (int i = poolFixTradingSessionListRequest.length - 1; i >= 0; i--) {
			poolFixTradingSessionListRequest[i] = new FixTradingSessionListRequest();
			inUseFixTradingSessionListRequest[i] = false;
		}
		poolFixSettlementObligationReport = new FixSettlementObligationReport[1];
		inUseFixSettlementObligationReport = new boolean[1];

		for (int i = poolFixSettlementObligationReport.length - 1; i >= 0; i--) {
			poolFixSettlementObligationReport[i] = new FixSettlementObligationReport();
			inUseFixSettlementObligationReport[i] = false;
		}
		poolFixDerivativeSecurityListUpdateReport = new FixDerivativeSecurityListUpdateReport[1];
		inUseFixDerivativeSecurityListUpdateReport = new boolean[1];

		for (int i = poolFixDerivativeSecurityListUpdateReport.length - 1; i >= 0; i--) {
			poolFixDerivativeSecurityListUpdateReport[i] = new FixDerivativeSecurityListUpdateReport();
			inUseFixDerivativeSecurityListUpdateReport[i] = false;
		}
		poolFixTradingSessionListUpdateReport = new FixTradingSessionListUpdateReport[1];
		inUseFixTradingSessionListUpdateReport = new boolean[1];

		for (int i = poolFixTradingSessionListUpdateReport.length - 1; i >= 0; i--) {
			poolFixTradingSessionListUpdateReport[i] = new FixTradingSessionListUpdateReport();
			inUseFixTradingSessionListUpdateReport[i] = false;
		}
		poolFixMarketDefinitionRequest = new FixMarketDefinitionRequest[1];
		inUseFixMarketDefinitionRequest = new boolean[1];

		for (int i = poolFixMarketDefinitionRequest.length - 1; i >= 0; i--) {
			poolFixMarketDefinitionRequest[i] = new FixMarketDefinitionRequest();
			inUseFixMarketDefinitionRequest[i] = false;
		}
		poolFixMarketDefinition = new FixMarketDefinition[1];
		inUseFixMarketDefinition = new boolean[1];

		for (int i = poolFixMarketDefinition.length - 1; i >= 0; i--) {
			poolFixMarketDefinition[i] = new FixMarketDefinition();
			inUseFixMarketDefinition[i] = false;
		}
		poolFixMarketDefinitionUpdateReport = new FixMarketDefinitionUpdateReport[1];
		inUseFixMarketDefinitionUpdateReport = new boolean[1];

		for (int i = poolFixMarketDefinitionUpdateReport.length - 1; i >= 0; i--) {
			poolFixMarketDefinitionUpdateReport[i] = new FixMarketDefinitionUpdateReport();
			inUseFixMarketDefinitionUpdateReport[i] = false;
		}
		poolFixUserNotification = new FixUserNotification[1];
		inUseFixUserNotification = new boolean[1];

		for (int i = poolFixUserNotification.length - 1; i >= 0; i--) {
			poolFixUserNotification[i] = new FixUserNotification();
			inUseFixUserNotification[i] = false;
		}
		poolFixOrderMassActionReport = new FixOrderMassActionReport[1];
		inUseFixOrderMassActionReport = new boolean[1];

		for (int i = poolFixOrderMassActionReport.length - 1; i >= 0; i--) {
			poolFixOrderMassActionReport[i] = new FixOrderMassActionReport();
			inUseFixOrderMassActionReport[i] = false;
		}
		poolFixOrderMassActionRequest = new FixOrderMassActionRequest[1];
		inUseFixOrderMassActionRequest = new boolean[1];

		for (int i = poolFixOrderMassActionRequest.length - 1; i >= 0; i--) {
			poolFixOrderMassActionRequest[i] = new FixOrderMassActionRequest();
			inUseFixOrderMassActionRequest[i] = false;
		}
		poolFixApplicationMessageRequest = new FixApplicationMessageRequest[1];
		inUseFixApplicationMessageRequest = new boolean[1];

		for (int i = poolFixApplicationMessageRequest.length - 1; i >= 0; i--) {
			poolFixApplicationMessageRequest[i] = new FixApplicationMessageRequest();
			inUseFixApplicationMessageRequest[i] = false;
		}
		poolFixApplicationMessageRequestAck = new FixApplicationMessageRequestAck[1];
		inUseFixApplicationMessageRequestAck = new boolean[1];

		for (int i = poolFixApplicationMessageRequestAck.length - 1; i >= 0; i--) {
			poolFixApplicationMessageRequestAck[i] = new FixApplicationMessageRequestAck();
			inUseFixApplicationMessageRequestAck[i] = false;
		}
		poolFixApplicationMessageReport = new FixApplicationMessageReport[1];
		inUseFixApplicationMessageReport = new boolean[1];

		for (int i = poolFixApplicationMessageReport.length - 1; i >= 0; i--) {
			poolFixApplicationMessageReport[i] = new FixApplicationMessageReport();
			inUseFixApplicationMessageReport[i] = false;
		}
		poolFixStreamAssignmentRequest = new FixStreamAssignmentRequest[1];
		inUseFixStreamAssignmentRequest = new boolean[1];

		for (int i = poolFixStreamAssignmentRequest.length - 1; i >= 0; i--) {
			poolFixStreamAssignmentRequest[i] = new FixStreamAssignmentRequest();
			inUseFixStreamAssignmentRequest[i] = false;
		}
		poolFixStreamAssignmentReport = new FixStreamAssignmentReport[1];
		inUseFixStreamAssignmentReport = new boolean[1];

		for (int i = poolFixStreamAssignmentReport.length - 1; i >= 0; i--) {
			poolFixStreamAssignmentReport[i] = new FixStreamAssignmentReport();
			inUseFixStreamAssignmentReport[i] = false;
		}
		poolFixStreamAssignmentReportACK = new FixStreamAssignmentReportACK[1];
		inUseFixStreamAssignmentReportACK = new boolean[1];

		for (int i = poolFixStreamAssignmentReportACK.length - 1; i >= 0; i--) {
			poolFixStreamAssignmentReportACK[i] = new FixStreamAssignmentReportACK();
			inUseFixStreamAssignmentReportACK[i] = false;
		}
		poolFixPartyDetailsListRequest = new FixPartyDetailsListRequest[1];
		inUseFixPartyDetailsListRequest = new boolean[1];

		for (int i = poolFixPartyDetailsListRequest.length - 1; i >= 0; i--) {
			poolFixPartyDetailsListRequest[i] = new FixPartyDetailsListRequest();
			inUseFixPartyDetailsListRequest[i] = false;
		}
		poolFixPartyDetailsListReport = new FixPartyDetailsListReport[1];
		inUseFixPartyDetailsListReport = new boolean[1];

		for (int i = poolFixPartyDetailsListReport.length - 1; i >= 0; i--) {
			poolFixPartyDetailsListReport[i] = new FixPartyDetailsListReport();
			inUseFixPartyDetailsListReport[i] = false;
		}
	}

	public T getFixMessage(ByteBuffer buf, FixValidationError err) {
		int pos = buf.position();
		int msgType = FixUtils.crackMsgType( buf ,err );

		// garbled message
		if (err.hasError()) return null;

		buf.position(pos);

		return getFixMessage(msgType, buf, err);
	}
	@SuppressWarnings("unchecked")
	private T getFixMessage(int msgType, ByteBuffer buf, FixValidationError err) {
		switch(msgType) {
		case FixMessageInfo.MessageTypes.HEARTBEAT_INT:
			return (T) getFixHeartbeat(buf, err);
		case FixMessageInfo.MessageTypes.TESTREQUEST_INT:
			return (T) getFixTestRequest(buf, err);
		case FixMessageInfo.MessageTypes.RESENDREQUEST_INT:
			return (T) getFixResendRequest(buf, err);
		case FixMessageInfo.MessageTypes.REJECT_INT:
			return (T) getFixReject(buf, err);
		case FixMessageInfo.MessageTypes.SEQUENCERESET_INT:
			return (T) getFixSequenceReset(buf, err);
		case FixMessageInfo.MessageTypes.LOGOUT_INT:
			return (T) getFixLogout(buf, err);
		case FixMessageInfo.MessageTypes.IOI_INT:
			return (T) getFixIOI(buf, err);
		case FixMessageInfo.MessageTypes.ADVERTISEMENT_INT:
			return (T) getFixAdvertisement(buf, err);
		case FixMessageInfo.MessageTypes.EXECUTIONREPORT_INT:
			return (T) getFixExecutionReport(buf, err);
		case FixMessageInfo.MessageTypes.ORDERCANCELREJECT_INT:
			return (T) getFixOrderCancelReject(buf, err);
		case FixMessageInfo.MessageTypes.LOGON_INT:
			return (T) getFixLogon(buf, err);
		case FixMessageInfo.MessageTypes.NEWS_INT:
			return (T) getFixNews(buf, err);
		case FixMessageInfo.MessageTypes.EMAIL_INT:
			return (T) getFixEmail(buf, err);
		case FixMessageInfo.MessageTypes.NEWORDERSINGLE_INT:
			return (T) getFixNewOrderSingle(buf, err);
		case FixMessageInfo.MessageTypes.NEWORDERLIST_INT:
			return (T) getFixNewOrderList(buf, err);
		case FixMessageInfo.MessageTypes.ORDERCANCELREQUEST_INT:
			return (T) getFixOrderCancelRequest(buf, err);
		case FixMessageInfo.MessageTypes.ORDERCANCELREPLACEREQUEST_INT:
			return (T) getFixOrderCancelReplaceRequest(buf, err);
		case FixMessageInfo.MessageTypes.ORDERSTATUSREQUEST_INT:
			return (T) getFixOrderStatusRequest(buf, err);
		case FixMessageInfo.MessageTypes.ALLOCATIONINSTRUCTION_INT:
			return (T) getFixAllocationInstruction(buf, err);
		case FixMessageInfo.MessageTypes.LISTCANCELREQUEST_INT:
			return (T) getFixListCancelRequest(buf, err);
		case FixMessageInfo.MessageTypes.LISTEXECUTE_INT:
			return (T) getFixListExecute(buf, err);
		case FixMessageInfo.MessageTypes.LISTSTATUSREQUEST_INT:
			return (T) getFixListStatusRequest(buf, err);
		case FixMessageInfo.MessageTypes.LISTSTATUS_INT:
			return (T) getFixListStatus(buf, err);
		case FixMessageInfo.MessageTypes.ALLOCATIONINSTRUCTIONACK_INT:
			return (T) getFixAllocationInstructionAck(buf, err);
		case FixMessageInfo.MessageTypes.DONTKNOWTRADEDK_INT:
			return (T) getFixDontKnowTradeDK(buf, err);
		case FixMessageInfo.MessageTypes.QUOTEREQUEST_INT:
			return (T) getFixQuoteRequest(buf, err);
		case FixMessageInfo.MessageTypes.QUOTE_INT:
			return (T) getFixQuote(buf, err);
		case FixMessageInfo.MessageTypes.SETTLEMENTINSTRUCTIONS_INT:
			return (T) getFixSettlementInstructions(buf, err);
		case FixMessageInfo.MessageTypes.MARKETDATAREQUEST_INT:
			return (T) getFixMarketDataRequest(buf, err);
		case FixMessageInfo.MessageTypes.MARKETDATASNAPSHOTFULLREFRESH_INT:
			return (T) getFixMarketDataSnapshotFullRefresh(buf, err);
		case FixMessageInfo.MessageTypes.MARKETDATAINCREMENTALREFRESH_INT:
			return (T) getFixMarketDataIncrementalRefresh(buf, err);
		case FixMessageInfo.MessageTypes.MARKETDATAREQUESTREJECT_INT:
			return (T) getFixMarketDataRequestReject(buf, err);
		case FixMessageInfo.MessageTypes.QUOTECANCEL_INT:
			return (T) getFixQuoteCancel(buf, err);
		case FixMessageInfo.MessageTypes.QUOTESTATUSREQUEST_INT:
			return (T) getFixQuoteStatusRequest(buf, err);
		case FixMessageInfo.MessageTypes.MASSQUOTEACKNOWLEDGEMENT_INT:
			return (T) getFixMassQuoteAcknowledgement(buf, err);
		case FixMessageInfo.MessageTypes.SECURITYDEFINITIONREQUEST_INT:
			return (T) getFixSecurityDefinitionRequest(buf, err);
		case FixMessageInfo.MessageTypes.SECURITYDEFINITION_INT:
			return (T) getFixSecurityDefinition(buf, err);
		case FixMessageInfo.MessageTypes.SECURITYSTATUSREQUEST_INT:
			return (T) getFixSecurityStatusRequest(buf, err);
		case FixMessageInfo.MessageTypes.SECURITYSTATUS_INT:
			return (T) getFixSecurityStatus(buf, err);
		case FixMessageInfo.MessageTypes.TRADINGSESSIONSTATUSREQUEST_INT:
			return (T) getFixTradingSessionStatusRequest(buf, err);
		case FixMessageInfo.MessageTypes.TRADINGSESSIONSTATUS_INT:
			return (T) getFixTradingSessionStatus(buf, err);
		case FixMessageInfo.MessageTypes.MASSQUOTE_INT:
			return (T) getFixMassQuote(buf, err);
		case FixMessageInfo.MessageTypes.BUSINESSMESSAGEREJECT_INT:
			return (T) getFixBusinessMessageReject(buf, err);
		case FixMessageInfo.MessageTypes.BIDREQUEST_INT:
			return (T) getFixBidRequest(buf, err);
		case FixMessageInfo.MessageTypes.BIDRESPONSE_INT:
			return (T) getFixBidResponse(buf, err);
		case FixMessageInfo.MessageTypes.LISTSTRIKEPRICE_INT:
			return (T) getFixListStrikePrice(buf, err);
		case FixMessageInfo.MessageTypes.REGISTRATIONINSTRUCTIONS_INT:
			return (T) getFixRegistrationInstructions(buf, err);
		case FixMessageInfo.MessageTypes.REGISTRATIONINSTRUCTIONSRESPONSE_INT:
			return (T) getFixRegistrationInstructionsResponse(buf, err);
		case FixMessageInfo.MessageTypes.ORDERMASSCANCELREQUEST_INT:
			return (T) getFixOrderMassCancelRequest(buf, err);
		case FixMessageInfo.MessageTypes.ORDERMASSCANCELREPORT_INT:
			return (T) getFixOrderMassCancelReport(buf, err);
		case FixMessageInfo.MessageTypes.NEWORDERCROSS_INT:
			return (T) getFixNewOrderCross(buf, err);
		case FixMessageInfo.MessageTypes.CROSSORDERCANCELREPLACEREQUEST_INT:
			return (T) getFixCrossOrderCancelReplaceRequest(buf, err);
		case FixMessageInfo.MessageTypes.CROSSORDERCANCELREQUEST_INT:
			return (T) getFixCrossOrderCancelRequest(buf, err);
		case FixMessageInfo.MessageTypes.SECURITYTYPEREQUEST_INT:
			return (T) getFixSecurityTypeRequest(buf, err);
		case FixMessageInfo.MessageTypes.SECURITYTYPES_INT:
			return (T) getFixSecurityTypes(buf, err);
		case FixMessageInfo.MessageTypes.SECURITYLISTREQUEST_INT:
			return (T) getFixSecurityListRequest(buf, err);
		case FixMessageInfo.MessageTypes.SECURITYLIST_INT:
			return (T) getFixSecurityList(buf, err);
		case FixMessageInfo.MessageTypes.DERIVATIVESECURITYLISTREQUEST_INT:
			return (T) getFixDerivativeSecurityListRequest(buf, err);
		case FixMessageInfo.MessageTypes.DERIVATIVESECURITYLIST_INT:
			return (T) getFixDerivativeSecurityList(buf, err);
		case FixMessageInfo.MessageTypes.NEWORDERMULTILEG_INT:
			return (T) getFixNewOrderMultileg(buf, err);
		case FixMessageInfo.MessageTypes.MULTILEGORDERCANCELREPLACE_INT:
			return (T) getFixMultilegOrderCancelReplace(buf, err);
		case FixMessageInfo.MessageTypes.TRADECAPTUREREPORTREQUEST_INT:
			return (T) getFixTradeCaptureReportRequest(buf, err);
		case FixMessageInfo.MessageTypes.TRADECAPTUREREPORT_INT:
			return (T) getFixTradeCaptureReport(buf, err);
		case FixMessageInfo.MessageTypes.ORDERMASSSTATUSREQUEST_INT:
			return (T) getFixOrderMassStatusRequest(buf, err);
		case FixMessageInfo.MessageTypes.QUOTEREQUESTREJECT_INT:
			return (T) getFixQuoteRequestReject(buf, err);
		case FixMessageInfo.MessageTypes.RFQREQUEST_INT:
			return (T) getFixRFQRequest(buf, err);
		case FixMessageInfo.MessageTypes.QUOTESTATUSREPORT_INT:
			return (T) getFixQuoteStatusReport(buf, err);
		case FixMessageInfo.MessageTypes.QUOTERESPONSE_INT:
			return (T) getFixQuoteResponse(buf, err);
		case FixMessageInfo.MessageTypes.CONFIRMATION_INT:
			return (T) getFixConfirmation(buf, err);
		case FixMessageInfo.MessageTypes.POSITIONMAINTENANCEREQUEST_INT:
			return (T) getFixPositionMaintenanceRequest(buf, err);
		case FixMessageInfo.MessageTypes.POSITIONMAINTENANCEREPORT_INT:
			return (T) getFixPositionMaintenanceReport(buf, err);
		case FixMessageInfo.MessageTypes.REQUESTFORPOSITIONS_INT:
			return (T) getFixRequestForPositions(buf, err);
		case FixMessageInfo.MessageTypes.REQUESTFORPOSITIONSACK_INT:
			return (T) getFixRequestForPositionsAck(buf, err);
		case FixMessageInfo.MessageTypes.POSITIONREPORT_INT:
			return (T) getFixPositionReport(buf, err);
		case FixMessageInfo.MessageTypes.TRADECAPTUREREPORTREQUESTACK_INT:
			return (T) getFixTradeCaptureReportRequestAck(buf, err);
		case FixMessageInfo.MessageTypes.TRADECAPTUREREPORTACK_INT:
			return (T) getFixTradeCaptureReportAck(buf, err);
		case FixMessageInfo.MessageTypes.ALLOCATIONREPORT_INT:
			return (T) getFixAllocationReport(buf, err);
		case FixMessageInfo.MessageTypes.ALLOCATIONREPORTACK_INT:
			return (T) getFixAllocationReportAck(buf, err);
		case FixMessageInfo.MessageTypes.CONFIRMATION_ACK_INT:
			return (T) getFixConfirmation_Ack(buf, err);
		case FixMessageInfo.MessageTypes.SETTLEMENTINSTRUCTIONREQUEST_INT:
			return (T) getFixSettlementInstructionRequest(buf, err);
		case FixMessageInfo.MessageTypes.ASSIGNMENTREPORT_INT:
			return (T) getFixAssignmentReport(buf, err);
		case FixMessageInfo.MessageTypes.COLLATERALREQUEST_INT:
			return (T) getFixCollateralRequest(buf, err);
		case FixMessageInfo.MessageTypes.COLLATERALASSIGNMENT_INT:
			return (T) getFixCollateralAssignment(buf, err);
		case FixMessageInfo.MessageTypes.COLLATERALRESPONSE_INT:
			return (T) getFixCollateralResponse(buf, err);
		case FixMessageInfo.MessageTypes.COLLATERALREPORT_INT:
			return (T) getFixCollateralReport(buf, err);
		case FixMessageInfo.MessageTypes.COLLATERALINQUIRY_INT:
			return (T) getFixCollateralInquiry(buf, err);
		case FixMessageInfo.MessageTypes.NETWORKCOUNTERPARTYSYSTEMSTATUSREQUEST_INT:
			return (T) getFixNetworkCounterpartySystemStatusRequest(buf, err);
		case FixMessageInfo.MessageTypes.NETWORKCOUNTERPARTYSYSTEMSTATUSRESPONSE_INT:
			return (T) getFixNetworkCounterpartySystemStatusResponse(buf, err);
		case FixMessageInfo.MessageTypes.USERREQUEST_INT:
			return (T) getFixUserRequest(buf, err);
		case FixMessageInfo.MessageTypes.USERRESPONSE_INT:
			return (T) getFixUserResponse(buf, err);
		case FixMessageInfo.MessageTypes.COLLATERALINQUIRYACK_INT:
			return (T) getFixCollateralInquiryAck(buf, err);
		case FixMessageInfo.MessageTypes.CONFIRMATIONREQUEST_INT:
			return (T) getFixConfirmationRequest(buf, err);
		case FixMessageInfo.MessageTypes.CONTRARYINTENTIONREPORT_INT:
			return (T) getFixContraryIntentionReport(buf, err);
		case FixMessageInfo.MessageTypes.SECURITYDEFINITIONUPDATEREPORT_INT:
			return (T) getFixSecurityDefinitionUpdateReport(buf, err);
		case FixMessageInfo.MessageTypes.SECURITYLISTUPDATEREPORT_INT:
			return (T) getFixSecurityListUpdateReport(buf, err);
		case FixMessageInfo.MessageTypes.ADJUSTEDPOSITIONREPORT_INT:
			return (T) getFixAdjustedPositionReport(buf, err);
		case FixMessageInfo.MessageTypes.ALLOCATIONINSTRUCTIONALERT_INT:
			return (T) getFixAllocationInstructionAlert(buf, err);
		case FixMessageInfo.MessageTypes.EXECUTIONACKNOWLEDGEMENT_INT:
			return (T) getFixExecutionAcknowledgement(buf, err);
		case FixMessageInfo.MessageTypes.TRADINGSESSIONLIST_INT:
			return (T) getFixTradingSessionList(buf, err);
		case FixMessageInfo.MessageTypes.TRADINGSESSIONLISTREQUEST_INT:
			return (T) getFixTradingSessionListRequest(buf, err);
		case FixMessageInfo.MessageTypes.SETTLEMENTOBLIGATIONREPORT_INT:
			return (T) getFixSettlementObligationReport(buf, err);
		case FixMessageInfo.MessageTypes.DERIVATIVESECURITYLISTUPDATEREPORT_INT:
			return (T) getFixDerivativeSecurityListUpdateReport(buf, err);
		case FixMessageInfo.MessageTypes.TRADINGSESSIONLISTUPDATEREPORT_INT:
			return (T) getFixTradingSessionListUpdateReport(buf, err);
		case FixMessageInfo.MessageTypes.MARKETDEFINITIONREQUEST_INT:
			return (T) getFixMarketDefinitionRequest(buf, err);
		case FixMessageInfo.MessageTypes.MARKETDEFINITION_INT:
			return (T) getFixMarketDefinition(buf, err);
		case FixMessageInfo.MessageTypes.MARKETDEFINITIONUPDATEREPORT_INT:
			return (T) getFixMarketDefinitionUpdateReport(buf, err);
		case FixMessageInfo.MessageTypes.USERNOTIFICATION_INT:
			return (T) getFixUserNotification(buf, err);
		case FixMessageInfo.MessageTypes.ORDERMASSACTIONREPORT_INT:
			return (T) getFixOrderMassActionReport(buf, err);
		case FixMessageInfo.MessageTypes.ORDERMASSACTIONREQUEST_INT:
			return (T) getFixOrderMassActionRequest(buf, err);
		case FixMessageInfo.MessageTypes.APPLICATIONMESSAGEREQUEST_INT:
			return (T) getFixApplicationMessageRequest(buf, err);
		case FixMessageInfo.MessageTypes.APPLICATIONMESSAGEREQUESTACK_INT:
			return (T) getFixApplicationMessageRequestAck(buf, err);
		case FixMessageInfo.MessageTypes.APPLICATIONMESSAGEREPORT_INT:
			return (T) getFixApplicationMessageReport(buf, err);
		case FixMessageInfo.MessageTypes.STREAMASSIGNMENTREQUEST_INT:
			return (T) getFixStreamAssignmentRequest(buf, err);
		case FixMessageInfo.MessageTypes.STREAMASSIGNMENTREPORT_INT:
			return (T) getFixStreamAssignmentReport(buf, err);
		case FixMessageInfo.MessageTypes.STREAMASSIGNMENTREPORTACK_INT:
			return (T) getFixStreamAssignmentReportACK(buf, err);
		case FixMessageInfo.MessageTypes.PARTYDETAILSLISTREQUEST_INT:
			return (T) getFixPartyDetailsListRequest(buf, err);
		case FixMessageInfo.MessageTypes.PARTYDETAILSLISTREPORT_INT:
			return (T) getFixPartyDetailsListReport(buf, err);
		default:
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public T getFixMessage(int msgType) {
		switch(msgType) {
		case FixMessageInfo.MessageTypes.HEARTBEAT_INT:
			return (T) getFixHeartbeat();
		case FixMessageInfo.MessageTypes.TESTREQUEST_INT:
			return (T) getFixTestRequest();
		case FixMessageInfo.MessageTypes.RESENDREQUEST_INT:
			return (T) getFixResendRequest();
		case FixMessageInfo.MessageTypes.REJECT_INT:
			return (T) getFixReject();
		case FixMessageInfo.MessageTypes.SEQUENCERESET_INT:
			return (T) getFixSequenceReset();
		case FixMessageInfo.MessageTypes.LOGOUT_INT:
			return (T) getFixLogout();
		case FixMessageInfo.MessageTypes.IOI_INT:
			return (T) getFixIOI();
		case FixMessageInfo.MessageTypes.ADVERTISEMENT_INT:
			return (T) getFixAdvertisement();
		case FixMessageInfo.MessageTypes.EXECUTIONREPORT_INT:
			return (T) getFixExecutionReport();
		case FixMessageInfo.MessageTypes.ORDERCANCELREJECT_INT:
			return (T) getFixOrderCancelReject();
		case FixMessageInfo.MessageTypes.LOGON_INT:
			return (T) getFixLogon();
		case FixMessageInfo.MessageTypes.NEWS_INT:
			return (T) getFixNews();
		case FixMessageInfo.MessageTypes.EMAIL_INT:
			return (T) getFixEmail();
		case FixMessageInfo.MessageTypes.NEWORDERSINGLE_INT:
			return (T) getFixNewOrderSingle();
		case FixMessageInfo.MessageTypes.NEWORDERLIST_INT:
			return (T) getFixNewOrderList();
		case FixMessageInfo.MessageTypes.ORDERCANCELREQUEST_INT:
			return (T) getFixOrderCancelRequest();
		case FixMessageInfo.MessageTypes.ORDERCANCELREPLACEREQUEST_INT:
			return (T) getFixOrderCancelReplaceRequest();
		case FixMessageInfo.MessageTypes.ORDERSTATUSREQUEST_INT:
			return (T) getFixOrderStatusRequest();
		case FixMessageInfo.MessageTypes.ALLOCATIONINSTRUCTION_INT:
			return (T) getFixAllocationInstruction();
		case FixMessageInfo.MessageTypes.LISTCANCELREQUEST_INT:
			return (T) getFixListCancelRequest();
		case FixMessageInfo.MessageTypes.LISTEXECUTE_INT:
			return (T) getFixListExecute();
		case FixMessageInfo.MessageTypes.LISTSTATUSREQUEST_INT:
			return (T) getFixListStatusRequest();
		case FixMessageInfo.MessageTypes.LISTSTATUS_INT:
			return (T) getFixListStatus();
		case FixMessageInfo.MessageTypes.ALLOCATIONINSTRUCTIONACK_INT:
			return (T) getFixAllocationInstructionAck();
		case FixMessageInfo.MessageTypes.DONTKNOWTRADEDK_INT:
			return (T) getFixDontKnowTradeDK();
		case FixMessageInfo.MessageTypes.QUOTEREQUEST_INT:
			return (T) getFixQuoteRequest();
		case FixMessageInfo.MessageTypes.QUOTE_INT:
			return (T) getFixQuote();
		case FixMessageInfo.MessageTypes.SETTLEMENTINSTRUCTIONS_INT:
			return (T) getFixSettlementInstructions();
		case FixMessageInfo.MessageTypes.MARKETDATAREQUEST_INT:
			return (T) getFixMarketDataRequest();
		case FixMessageInfo.MessageTypes.MARKETDATASNAPSHOTFULLREFRESH_INT:
			return (T) getFixMarketDataSnapshotFullRefresh();
		case FixMessageInfo.MessageTypes.MARKETDATAINCREMENTALREFRESH_INT:
			return (T) getFixMarketDataIncrementalRefresh();
		case FixMessageInfo.MessageTypes.MARKETDATAREQUESTREJECT_INT:
			return (T) getFixMarketDataRequestReject();
		case FixMessageInfo.MessageTypes.QUOTECANCEL_INT:
			return (T) getFixQuoteCancel();
		case FixMessageInfo.MessageTypes.QUOTESTATUSREQUEST_INT:
			return (T) getFixQuoteStatusRequest();
		case FixMessageInfo.MessageTypes.MASSQUOTEACKNOWLEDGEMENT_INT:
			return (T) getFixMassQuoteAcknowledgement();
		case FixMessageInfo.MessageTypes.SECURITYDEFINITIONREQUEST_INT:
			return (T) getFixSecurityDefinitionRequest();
		case FixMessageInfo.MessageTypes.SECURITYDEFINITION_INT:
			return (T) getFixSecurityDefinition();
		case FixMessageInfo.MessageTypes.SECURITYSTATUSREQUEST_INT:
			return (T) getFixSecurityStatusRequest();
		case FixMessageInfo.MessageTypes.SECURITYSTATUS_INT:
			return (T) getFixSecurityStatus();
		case FixMessageInfo.MessageTypes.TRADINGSESSIONSTATUSREQUEST_INT:
			return (T) getFixTradingSessionStatusRequest();
		case FixMessageInfo.MessageTypes.TRADINGSESSIONSTATUS_INT:
			return (T) getFixTradingSessionStatus();
		case FixMessageInfo.MessageTypes.MASSQUOTE_INT:
			return (T) getFixMassQuote();
		case FixMessageInfo.MessageTypes.BUSINESSMESSAGEREJECT_INT:
			return (T) getFixBusinessMessageReject();
		case FixMessageInfo.MessageTypes.BIDREQUEST_INT:
			return (T) getFixBidRequest();
		case FixMessageInfo.MessageTypes.BIDRESPONSE_INT:
			return (T) getFixBidResponse();
		case FixMessageInfo.MessageTypes.LISTSTRIKEPRICE_INT:
			return (T) getFixListStrikePrice();
		case FixMessageInfo.MessageTypes.REGISTRATIONINSTRUCTIONS_INT:
			return (T) getFixRegistrationInstructions();
		case FixMessageInfo.MessageTypes.REGISTRATIONINSTRUCTIONSRESPONSE_INT:
			return (T) getFixRegistrationInstructionsResponse();
		case FixMessageInfo.MessageTypes.ORDERMASSCANCELREQUEST_INT:
			return (T) getFixOrderMassCancelRequest();
		case FixMessageInfo.MessageTypes.ORDERMASSCANCELREPORT_INT:
			return (T) getFixOrderMassCancelReport();
		case FixMessageInfo.MessageTypes.NEWORDERCROSS_INT:
			return (T) getFixNewOrderCross();
		case FixMessageInfo.MessageTypes.CROSSORDERCANCELREPLACEREQUEST_INT:
			return (T) getFixCrossOrderCancelReplaceRequest();
		case FixMessageInfo.MessageTypes.CROSSORDERCANCELREQUEST_INT:
			return (T) getFixCrossOrderCancelRequest();
		case FixMessageInfo.MessageTypes.SECURITYTYPEREQUEST_INT:
			return (T) getFixSecurityTypeRequest();
		case FixMessageInfo.MessageTypes.SECURITYTYPES_INT:
			return (T) getFixSecurityTypes();
		case FixMessageInfo.MessageTypes.SECURITYLISTREQUEST_INT:
			return (T) getFixSecurityListRequest();
		case FixMessageInfo.MessageTypes.SECURITYLIST_INT:
			return (T) getFixSecurityList();
		case FixMessageInfo.MessageTypes.DERIVATIVESECURITYLISTREQUEST_INT:
			return (T) getFixDerivativeSecurityListRequest();
		case FixMessageInfo.MessageTypes.DERIVATIVESECURITYLIST_INT:
			return (T) getFixDerivativeSecurityList();
		case FixMessageInfo.MessageTypes.NEWORDERMULTILEG_INT:
			return (T) getFixNewOrderMultileg();
		case FixMessageInfo.MessageTypes.MULTILEGORDERCANCELREPLACE_INT:
			return (T) getFixMultilegOrderCancelReplace();
		case FixMessageInfo.MessageTypes.TRADECAPTUREREPORTREQUEST_INT:
			return (T) getFixTradeCaptureReportRequest();
		case FixMessageInfo.MessageTypes.TRADECAPTUREREPORT_INT:
			return (T) getFixTradeCaptureReport();
		case FixMessageInfo.MessageTypes.ORDERMASSSTATUSREQUEST_INT:
			return (T) getFixOrderMassStatusRequest();
		case FixMessageInfo.MessageTypes.QUOTEREQUESTREJECT_INT:
			return (T) getFixQuoteRequestReject();
		case FixMessageInfo.MessageTypes.RFQREQUEST_INT:
			return (T) getFixRFQRequest();
		case FixMessageInfo.MessageTypes.QUOTESTATUSREPORT_INT:
			return (T) getFixQuoteStatusReport();
		case FixMessageInfo.MessageTypes.QUOTERESPONSE_INT:
			return (T) getFixQuoteResponse();
		case FixMessageInfo.MessageTypes.CONFIRMATION_INT:
			return (T) getFixConfirmation();
		case FixMessageInfo.MessageTypes.POSITIONMAINTENANCEREQUEST_INT:
			return (T) getFixPositionMaintenanceRequest();
		case FixMessageInfo.MessageTypes.POSITIONMAINTENANCEREPORT_INT:
			return (T) getFixPositionMaintenanceReport();
		case FixMessageInfo.MessageTypes.REQUESTFORPOSITIONS_INT:
			return (T) getFixRequestForPositions();
		case FixMessageInfo.MessageTypes.REQUESTFORPOSITIONSACK_INT:
			return (T) getFixRequestForPositionsAck();
		case FixMessageInfo.MessageTypes.POSITIONREPORT_INT:
			return (T) getFixPositionReport();
		case FixMessageInfo.MessageTypes.TRADECAPTUREREPORTREQUESTACK_INT:
			return (T) getFixTradeCaptureReportRequestAck();
		case FixMessageInfo.MessageTypes.TRADECAPTUREREPORTACK_INT:
			return (T) getFixTradeCaptureReportAck();
		case FixMessageInfo.MessageTypes.ALLOCATIONREPORT_INT:
			return (T) getFixAllocationReport();
		case FixMessageInfo.MessageTypes.ALLOCATIONREPORTACK_INT:
			return (T) getFixAllocationReportAck();
		case FixMessageInfo.MessageTypes.CONFIRMATION_ACK_INT:
			return (T) getFixConfirmation_Ack();
		case FixMessageInfo.MessageTypes.SETTLEMENTINSTRUCTIONREQUEST_INT:
			return (T) getFixSettlementInstructionRequest();
		case FixMessageInfo.MessageTypes.ASSIGNMENTREPORT_INT:
			return (T) getFixAssignmentReport();
		case FixMessageInfo.MessageTypes.COLLATERALREQUEST_INT:
			return (T) getFixCollateralRequest();
		case FixMessageInfo.MessageTypes.COLLATERALASSIGNMENT_INT:
			return (T) getFixCollateralAssignment();
		case FixMessageInfo.MessageTypes.COLLATERALRESPONSE_INT:
			return (T) getFixCollateralResponse();
		case FixMessageInfo.MessageTypes.COLLATERALREPORT_INT:
			return (T) getFixCollateralReport();
		case FixMessageInfo.MessageTypes.COLLATERALINQUIRY_INT:
			return (T) getFixCollateralInquiry();
		case FixMessageInfo.MessageTypes.NETWORKCOUNTERPARTYSYSTEMSTATUSREQUEST_INT:
			return (T) getFixNetworkCounterpartySystemStatusRequest();
		case FixMessageInfo.MessageTypes.NETWORKCOUNTERPARTYSYSTEMSTATUSRESPONSE_INT:
			return (T) getFixNetworkCounterpartySystemStatusResponse();
		case FixMessageInfo.MessageTypes.USERREQUEST_INT:
			return (T) getFixUserRequest();
		case FixMessageInfo.MessageTypes.USERRESPONSE_INT:
			return (T) getFixUserResponse();
		case FixMessageInfo.MessageTypes.COLLATERALINQUIRYACK_INT:
			return (T) getFixCollateralInquiryAck();
		case FixMessageInfo.MessageTypes.CONFIRMATIONREQUEST_INT:
			return (T) getFixConfirmationRequest();
		case FixMessageInfo.MessageTypes.CONTRARYINTENTIONREPORT_INT:
			return (T) getFixContraryIntentionReport();
		case FixMessageInfo.MessageTypes.SECURITYDEFINITIONUPDATEREPORT_INT:
			return (T) getFixSecurityDefinitionUpdateReport();
		case FixMessageInfo.MessageTypes.SECURITYLISTUPDATEREPORT_INT:
			return (T) getFixSecurityListUpdateReport();
		case FixMessageInfo.MessageTypes.ADJUSTEDPOSITIONREPORT_INT:
			return (T) getFixAdjustedPositionReport();
		case FixMessageInfo.MessageTypes.ALLOCATIONINSTRUCTIONALERT_INT:
			return (T) getFixAllocationInstructionAlert();
		case FixMessageInfo.MessageTypes.EXECUTIONACKNOWLEDGEMENT_INT:
			return (T) getFixExecutionAcknowledgement();
		case FixMessageInfo.MessageTypes.TRADINGSESSIONLIST_INT:
			return (T) getFixTradingSessionList();
		case FixMessageInfo.MessageTypes.TRADINGSESSIONLISTREQUEST_INT:
			return (T) getFixTradingSessionListRequest();
		case FixMessageInfo.MessageTypes.SETTLEMENTOBLIGATIONREPORT_INT:
			return (T) getFixSettlementObligationReport();
		case FixMessageInfo.MessageTypes.DERIVATIVESECURITYLISTUPDATEREPORT_INT:
			return (T) getFixDerivativeSecurityListUpdateReport();
		case FixMessageInfo.MessageTypes.TRADINGSESSIONLISTUPDATEREPORT_INT:
			return (T) getFixTradingSessionListUpdateReport();
		case FixMessageInfo.MessageTypes.MARKETDEFINITIONREQUEST_INT:
			return (T) getFixMarketDefinitionRequest();
		case FixMessageInfo.MessageTypes.MARKETDEFINITION_INT:
			return (T) getFixMarketDefinition();
		case FixMessageInfo.MessageTypes.MARKETDEFINITIONUPDATEREPORT_INT:
			return (T) getFixMarketDefinitionUpdateReport();
		case FixMessageInfo.MessageTypes.USERNOTIFICATION_INT:
			return (T) getFixUserNotification();
		case FixMessageInfo.MessageTypes.ORDERMASSACTIONREPORT_INT:
			return (T) getFixOrderMassActionReport();
		case FixMessageInfo.MessageTypes.ORDERMASSACTIONREQUEST_INT:
			return (T) getFixOrderMassActionRequest();
		case FixMessageInfo.MessageTypes.APPLICATIONMESSAGEREQUEST_INT:
			return (T) getFixApplicationMessageRequest();
		case FixMessageInfo.MessageTypes.APPLICATIONMESSAGEREQUESTACK_INT:
			return (T) getFixApplicationMessageRequestAck();
		case FixMessageInfo.MessageTypes.APPLICATIONMESSAGEREPORT_INT:
			return (T) getFixApplicationMessageReport();
		case FixMessageInfo.MessageTypes.STREAMASSIGNMENTREQUEST_INT:
			return (T) getFixStreamAssignmentRequest();
		case FixMessageInfo.MessageTypes.STREAMASSIGNMENTREPORT_INT:
			return (T) getFixStreamAssignmentReport();
		case FixMessageInfo.MessageTypes.STREAMASSIGNMENTREPORTACK_INT:
			return (T) getFixStreamAssignmentReportACK();
		case FixMessageInfo.MessageTypes.PARTYDETAILSLISTREQUEST_INT:
			return (T) getFixPartyDetailsListRequest();
		case FixMessageInfo.MessageTypes.PARTYDETAILSLISTREPORT_INT:
			return (T) getFixPartyDetailsListReport();
		default:
			return null;
		}
	}

	public FixHeartbeat getFixHeartbeat(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixHeartbeat.length - 1; i >= 0; i--)
			if (!inUseFixHeartbeat[i]) {
				inUseFixHeartbeat[i] = true;
				poolFixHeartbeat[i].setBuffer(buf, err);
				return poolFixHeartbeat[i];
			}

		boolean[] old_inUse = inUseFixHeartbeat;
		inUseFixHeartbeat = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixHeartbeat, 0, old_inUse.length);

		FixHeartbeat[] old_pool = poolFixHeartbeat;
		poolFixHeartbeat = new FixHeartbeat[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixHeartbeat, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixHeartbeat.length; i++) {
			poolFixHeartbeat[i] = new FixHeartbeat();
			inUseFixHeartbeat[i] = false;
		}

		inUseFixHeartbeat[poolFixHeartbeat.length - 1] = true;
		poolFixHeartbeat[poolFixHeartbeat.length - 1].setBuffer(buf, err);
		return poolFixHeartbeat[poolFixHeartbeat.length - 1];
	}

	public FixTestRequest getFixTestRequest(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixTestRequest.length - 1; i >= 0; i--)
			if (!inUseFixTestRequest[i]) {
				inUseFixTestRequest[i] = true;
				poolFixTestRequest[i].setBuffer(buf, err);
				return poolFixTestRequest[i];
			}

		boolean[] old_inUse = inUseFixTestRequest;
		inUseFixTestRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixTestRequest, 0, old_inUse.length);

		FixTestRequest[] old_pool = poolFixTestRequest;
		poolFixTestRequest = new FixTestRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixTestRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixTestRequest.length; i++) {
			poolFixTestRequest[i] = new FixTestRequest();
			inUseFixTestRequest[i] = false;
		}

		inUseFixTestRequest[poolFixTestRequest.length - 1] = true;
		poolFixTestRequest[poolFixTestRequest.length - 1].setBuffer(buf, err);
		return poolFixTestRequest[poolFixTestRequest.length - 1];
	}

	public FixResendRequest getFixResendRequest(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixResendRequest.length - 1; i >= 0; i--)
			if (!inUseFixResendRequest[i]) {
				inUseFixResendRequest[i] = true;
				poolFixResendRequest[i].setBuffer(buf, err);
				return poolFixResendRequest[i];
			}

		boolean[] old_inUse = inUseFixResendRequest;
		inUseFixResendRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixResendRequest, 0, old_inUse.length);

		FixResendRequest[] old_pool = poolFixResendRequest;
		poolFixResendRequest = new FixResendRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixResendRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixResendRequest.length; i++) {
			poolFixResendRequest[i] = new FixResendRequest();
			inUseFixResendRequest[i] = false;
		}

		inUseFixResendRequest[poolFixResendRequest.length - 1] = true;
		poolFixResendRequest[poolFixResendRequest.length - 1].setBuffer(buf, err);
		return poolFixResendRequest[poolFixResendRequest.length - 1];
	}

	public FixReject getFixReject(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixReject.length - 1; i >= 0; i--)
			if (!inUseFixReject[i]) {
				inUseFixReject[i] = true;
				poolFixReject[i].setBuffer(buf, err);
				return poolFixReject[i];
			}

		boolean[] old_inUse = inUseFixReject;
		inUseFixReject = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixReject, 0, old_inUse.length);

		FixReject[] old_pool = poolFixReject;
		poolFixReject = new FixReject[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixReject, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixReject.length; i++) {
			poolFixReject[i] = new FixReject();
			inUseFixReject[i] = false;
		}

		inUseFixReject[poolFixReject.length - 1] = true;
		poolFixReject[poolFixReject.length - 1].setBuffer(buf, err);
		return poolFixReject[poolFixReject.length - 1];
	}

	public FixSequenceReset getFixSequenceReset(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixSequenceReset.length - 1; i >= 0; i--)
			if (!inUseFixSequenceReset[i]) {
				inUseFixSequenceReset[i] = true;
				poolFixSequenceReset[i].setBuffer(buf, err);
				return poolFixSequenceReset[i];
			}

		boolean[] old_inUse = inUseFixSequenceReset;
		inUseFixSequenceReset = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixSequenceReset, 0, old_inUse.length);

		FixSequenceReset[] old_pool = poolFixSequenceReset;
		poolFixSequenceReset = new FixSequenceReset[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixSequenceReset, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixSequenceReset.length; i++) {
			poolFixSequenceReset[i] = new FixSequenceReset();
			inUseFixSequenceReset[i] = false;
		}

		inUseFixSequenceReset[poolFixSequenceReset.length - 1] = true;
		poolFixSequenceReset[poolFixSequenceReset.length - 1].setBuffer(buf, err);
		return poolFixSequenceReset[poolFixSequenceReset.length - 1];
	}

	public FixLogout getFixLogout(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixLogout.length - 1; i >= 0; i--)
			if (!inUseFixLogout[i]) {
				inUseFixLogout[i] = true;
				poolFixLogout[i].setBuffer(buf, err);
				return poolFixLogout[i];
			}

		boolean[] old_inUse = inUseFixLogout;
		inUseFixLogout = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixLogout, 0, old_inUse.length);

		FixLogout[] old_pool = poolFixLogout;
		poolFixLogout = new FixLogout[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixLogout, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixLogout.length; i++) {
			poolFixLogout[i] = new FixLogout();
			inUseFixLogout[i] = false;
		}

		inUseFixLogout[poolFixLogout.length - 1] = true;
		poolFixLogout[poolFixLogout.length - 1].setBuffer(buf, err);
		return poolFixLogout[poolFixLogout.length - 1];
	}

	public FixIOI getFixIOI(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixIOI.length - 1; i >= 0; i--)
			if (!inUseFixIOI[i]) {
				inUseFixIOI[i] = true;
				poolFixIOI[i].setBuffer(buf, err);
				return poolFixIOI[i];
			}

		boolean[] old_inUse = inUseFixIOI;
		inUseFixIOI = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixIOI, 0, old_inUse.length);

		FixIOI[] old_pool = poolFixIOI;
		poolFixIOI = new FixIOI[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixIOI, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixIOI.length; i++) {
			poolFixIOI[i] = new FixIOI();
			inUseFixIOI[i] = false;
		}

		inUseFixIOI[poolFixIOI.length - 1] = true;
		poolFixIOI[poolFixIOI.length - 1].setBuffer(buf, err);
		return poolFixIOI[poolFixIOI.length - 1];
	}

	public FixAdvertisement getFixAdvertisement(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixAdvertisement.length - 1; i >= 0; i--)
			if (!inUseFixAdvertisement[i]) {
				inUseFixAdvertisement[i] = true;
				poolFixAdvertisement[i].setBuffer(buf, err);
				return poolFixAdvertisement[i];
			}

		boolean[] old_inUse = inUseFixAdvertisement;
		inUseFixAdvertisement = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixAdvertisement, 0, old_inUse.length);

		FixAdvertisement[] old_pool = poolFixAdvertisement;
		poolFixAdvertisement = new FixAdvertisement[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixAdvertisement, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixAdvertisement.length; i++) {
			poolFixAdvertisement[i] = new FixAdvertisement();
			inUseFixAdvertisement[i] = false;
		}

		inUseFixAdvertisement[poolFixAdvertisement.length - 1] = true;
		poolFixAdvertisement[poolFixAdvertisement.length - 1].setBuffer(buf, err);
		return poolFixAdvertisement[poolFixAdvertisement.length - 1];
	}

	public FixExecutionReport getFixExecutionReport(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixExecutionReport.length - 1; i >= 0; i--)
			if (!inUseFixExecutionReport[i]) {
				inUseFixExecutionReport[i] = true;
				poolFixExecutionReport[i].setBuffer(buf, err);
				return poolFixExecutionReport[i];
			}

		boolean[] old_inUse = inUseFixExecutionReport;
		inUseFixExecutionReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixExecutionReport, 0, old_inUse.length);

		FixExecutionReport[] old_pool = poolFixExecutionReport;
		poolFixExecutionReport = new FixExecutionReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixExecutionReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixExecutionReport.length; i++) {
			poolFixExecutionReport[i] = new FixExecutionReport();
			inUseFixExecutionReport[i] = false;
		}

		inUseFixExecutionReport[poolFixExecutionReport.length - 1] = true;
		poolFixExecutionReport[poolFixExecutionReport.length - 1].setBuffer(buf, err);
		return poolFixExecutionReport[poolFixExecutionReport.length - 1];
	}

	public FixOrderCancelReject getFixOrderCancelReject(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixOrderCancelReject.length - 1; i >= 0; i--)
			if (!inUseFixOrderCancelReject[i]) {
				inUseFixOrderCancelReject[i] = true;
				poolFixOrderCancelReject[i].setBuffer(buf, err);
				return poolFixOrderCancelReject[i];
			}

		boolean[] old_inUse = inUseFixOrderCancelReject;
		inUseFixOrderCancelReject = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixOrderCancelReject, 0, old_inUse.length);

		FixOrderCancelReject[] old_pool = poolFixOrderCancelReject;
		poolFixOrderCancelReject = new FixOrderCancelReject[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixOrderCancelReject, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixOrderCancelReject.length; i++) {
			poolFixOrderCancelReject[i] = new FixOrderCancelReject();
			inUseFixOrderCancelReject[i] = false;
		}

		inUseFixOrderCancelReject[poolFixOrderCancelReject.length - 1] = true;
		poolFixOrderCancelReject[poolFixOrderCancelReject.length - 1].setBuffer(buf, err);
		return poolFixOrderCancelReject[poolFixOrderCancelReject.length - 1];
	}

	public FixLogon getFixLogon(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixLogon.length - 1; i >= 0; i--)
			if (!inUseFixLogon[i]) {
				inUseFixLogon[i] = true;
				poolFixLogon[i].setBuffer(buf, err);
				return poolFixLogon[i];
			}

		boolean[] old_inUse = inUseFixLogon;
		inUseFixLogon = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixLogon, 0, old_inUse.length);

		FixLogon[] old_pool = poolFixLogon;
		poolFixLogon = new FixLogon[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixLogon, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixLogon.length; i++) {
			poolFixLogon[i] = new FixLogon();
			inUseFixLogon[i] = false;
		}

		inUseFixLogon[poolFixLogon.length - 1] = true;
		poolFixLogon[poolFixLogon.length - 1].setBuffer(buf, err);
		return poolFixLogon[poolFixLogon.length - 1];
	}

	public FixNews getFixNews(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixNews.length - 1; i >= 0; i--)
			if (!inUseFixNews[i]) {
				inUseFixNews[i] = true;
				poolFixNews[i].setBuffer(buf, err);
				return poolFixNews[i];
			}

		boolean[] old_inUse = inUseFixNews;
		inUseFixNews = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixNews, 0, old_inUse.length);

		FixNews[] old_pool = poolFixNews;
		poolFixNews = new FixNews[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixNews, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixNews.length; i++) {
			poolFixNews[i] = new FixNews();
			inUseFixNews[i] = false;
		}

		inUseFixNews[poolFixNews.length - 1] = true;
		poolFixNews[poolFixNews.length - 1].setBuffer(buf, err);
		return poolFixNews[poolFixNews.length - 1];
	}

	public FixEmail getFixEmail(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixEmail.length - 1; i >= 0; i--)
			if (!inUseFixEmail[i]) {
				inUseFixEmail[i] = true;
				poolFixEmail[i].setBuffer(buf, err);
				return poolFixEmail[i];
			}

		boolean[] old_inUse = inUseFixEmail;
		inUseFixEmail = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixEmail, 0, old_inUse.length);

		FixEmail[] old_pool = poolFixEmail;
		poolFixEmail = new FixEmail[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixEmail, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixEmail.length; i++) {
			poolFixEmail[i] = new FixEmail();
			inUseFixEmail[i] = false;
		}

		inUseFixEmail[poolFixEmail.length - 1] = true;
		poolFixEmail[poolFixEmail.length - 1].setBuffer(buf, err);
		return poolFixEmail[poolFixEmail.length - 1];
	}

	public FixNewOrderSingle getFixNewOrderSingle(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixNewOrderSingle.length - 1; i >= 0; i--)
			if (!inUseFixNewOrderSingle[i]) {
				inUseFixNewOrderSingle[i] = true;
				poolFixNewOrderSingle[i].setBuffer(buf, err);
				return poolFixNewOrderSingle[i];
			}

		boolean[] old_inUse = inUseFixNewOrderSingle;
		inUseFixNewOrderSingle = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixNewOrderSingle, 0, old_inUse.length);

		FixNewOrderSingle[] old_pool = poolFixNewOrderSingle;
		poolFixNewOrderSingle = new FixNewOrderSingle[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixNewOrderSingle, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixNewOrderSingle.length; i++) {
			poolFixNewOrderSingle[i] = new FixNewOrderSingle();
			inUseFixNewOrderSingle[i] = false;
		}

		inUseFixNewOrderSingle[poolFixNewOrderSingle.length - 1] = true;
		poolFixNewOrderSingle[poolFixNewOrderSingle.length - 1].setBuffer(buf, err);
		return poolFixNewOrderSingle[poolFixNewOrderSingle.length - 1];
	}

	public FixNewOrderList getFixNewOrderList(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixNewOrderList.length - 1; i >= 0; i--)
			if (!inUseFixNewOrderList[i]) {
				inUseFixNewOrderList[i] = true;
				poolFixNewOrderList[i].setBuffer(buf, err);
				return poolFixNewOrderList[i];
			}

		boolean[] old_inUse = inUseFixNewOrderList;
		inUseFixNewOrderList = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixNewOrderList, 0, old_inUse.length);

		FixNewOrderList[] old_pool = poolFixNewOrderList;
		poolFixNewOrderList = new FixNewOrderList[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixNewOrderList, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixNewOrderList.length; i++) {
			poolFixNewOrderList[i] = new FixNewOrderList();
			inUseFixNewOrderList[i] = false;
		}

		inUseFixNewOrderList[poolFixNewOrderList.length - 1] = true;
		poolFixNewOrderList[poolFixNewOrderList.length - 1].setBuffer(buf, err);
		return poolFixNewOrderList[poolFixNewOrderList.length - 1];
	}

	public FixOrderCancelRequest getFixOrderCancelRequest(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixOrderCancelRequest.length - 1; i >= 0; i--)
			if (!inUseFixOrderCancelRequest[i]) {
				inUseFixOrderCancelRequest[i] = true;
				poolFixOrderCancelRequest[i].setBuffer(buf, err);
				return poolFixOrderCancelRequest[i];
			}

		boolean[] old_inUse = inUseFixOrderCancelRequest;
		inUseFixOrderCancelRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixOrderCancelRequest, 0, old_inUse.length);

		FixOrderCancelRequest[] old_pool = poolFixOrderCancelRequest;
		poolFixOrderCancelRequest = new FixOrderCancelRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixOrderCancelRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixOrderCancelRequest.length; i++) {
			poolFixOrderCancelRequest[i] = new FixOrderCancelRequest();
			inUseFixOrderCancelRequest[i] = false;
		}

		inUseFixOrderCancelRequest[poolFixOrderCancelRequest.length - 1] = true;
		poolFixOrderCancelRequest[poolFixOrderCancelRequest.length - 1].setBuffer(buf, err);
		return poolFixOrderCancelRequest[poolFixOrderCancelRequest.length - 1];
	}

	public FixOrderCancelReplaceRequest getFixOrderCancelReplaceRequest(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixOrderCancelReplaceRequest.length - 1; i >= 0; i--)
			if (!inUseFixOrderCancelReplaceRequest[i]) {
				inUseFixOrderCancelReplaceRequest[i] = true;
				poolFixOrderCancelReplaceRequest[i].setBuffer(buf, err);
				return poolFixOrderCancelReplaceRequest[i];
			}

		boolean[] old_inUse = inUseFixOrderCancelReplaceRequest;
		inUseFixOrderCancelReplaceRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixOrderCancelReplaceRequest, 0, old_inUse.length);

		FixOrderCancelReplaceRequest[] old_pool = poolFixOrderCancelReplaceRequest;
		poolFixOrderCancelReplaceRequest = new FixOrderCancelReplaceRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixOrderCancelReplaceRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixOrderCancelReplaceRequest.length; i++) {
			poolFixOrderCancelReplaceRequest[i] = new FixOrderCancelReplaceRequest();
			inUseFixOrderCancelReplaceRequest[i] = false;
		}

		inUseFixOrderCancelReplaceRequest[poolFixOrderCancelReplaceRequest.length - 1] = true;
		poolFixOrderCancelReplaceRequest[poolFixOrderCancelReplaceRequest.length - 1].setBuffer(buf, err);
		return poolFixOrderCancelReplaceRequest[poolFixOrderCancelReplaceRequest.length - 1];
	}

	public FixOrderStatusRequest getFixOrderStatusRequest(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixOrderStatusRequest.length - 1; i >= 0; i--)
			if (!inUseFixOrderStatusRequest[i]) {
				inUseFixOrderStatusRequest[i] = true;
				poolFixOrderStatusRequest[i].setBuffer(buf, err);
				return poolFixOrderStatusRequest[i];
			}

		boolean[] old_inUse = inUseFixOrderStatusRequest;
		inUseFixOrderStatusRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixOrderStatusRequest, 0, old_inUse.length);

		FixOrderStatusRequest[] old_pool = poolFixOrderStatusRequest;
		poolFixOrderStatusRequest = new FixOrderStatusRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixOrderStatusRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixOrderStatusRequest.length; i++) {
			poolFixOrderStatusRequest[i] = new FixOrderStatusRequest();
			inUseFixOrderStatusRequest[i] = false;
		}

		inUseFixOrderStatusRequest[poolFixOrderStatusRequest.length - 1] = true;
		poolFixOrderStatusRequest[poolFixOrderStatusRequest.length - 1].setBuffer(buf, err);
		return poolFixOrderStatusRequest[poolFixOrderStatusRequest.length - 1];
	}

	public FixAllocationInstruction getFixAllocationInstruction(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixAllocationInstruction.length - 1; i >= 0; i--)
			if (!inUseFixAllocationInstruction[i]) {
				inUseFixAllocationInstruction[i] = true;
				poolFixAllocationInstruction[i].setBuffer(buf, err);
				return poolFixAllocationInstruction[i];
			}

		boolean[] old_inUse = inUseFixAllocationInstruction;
		inUseFixAllocationInstruction = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixAllocationInstruction, 0, old_inUse.length);

		FixAllocationInstruction[] old_pool = poolFixAllocationInstruction;
		poolFixAllocationInstruction = new FixAllocationInstruction[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixAllocationInstruction, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixAllocationInstruction.length; i++) {
			poolFixAllocationInstruction[i] = new FixAllocationInstruction();
			inUseFixAllocationInstruction[i] = false;
		}

		inUseFixAllocationInstruction[poolFixAllocationInstruction.length - 1] = true;
		poolFixAllocationInstruction[poolFixAllocationInstruction.length - 1].setBuffer(buf, err);
		return poolFixAllocationInstruction[poolFixAllocationInstruction.length - 1];
	}

	public FixListCancelRequest getFixListCancelRequest(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixListCancelRequest.length - 1; i >= 0; i--)
			if (!inUseFixListCancelRequest[i]) {
				inUseFixListCancelRequest[i] = true;
				poolFixListCancelRequest[i].setBuffer(buf, err);
				return poolFixListCancelRequest[i];
			}

		boolean[] old_inUse = inUseFixListCancelRequest;
		inUseFixListCancelRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixListCancelRequest, 0, old_inUse.length);

		FixListCancelRequest[] old_pool = poolFixListCancelRequest;
		poolFixListCancelRequest = new FixListCancelRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixListCancelRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixListCancelRequest.length; i++) {
			poolFixListCancelRequest[i] = new FixListCancelRequest();
			inUseFixListCancelRequest[i] = false;
		}

		inUseFixListCancelRequest[poolFixListCancelRequest.length - 1] = true;
		poolFixListCancelRequest[poolFixListCancelRequest.length - 1].setBuffer(buf, err);
		return poolFixListCancelRequest[poolFixListCancelRequest.length - 1];
	}

	public FixListExecute getFixListExecute(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixListExecute.length - 1; i >= 0; i--)
			if (!inUseFixListExecute[i]) {
				inUseFixListExecute[i] = true;
				poolFixListExecute[i].setBuffer(buf, err);
				return poolFixListExecute[i];
			}

		boolean[] old_inUse = inUseFixListExecute;
		inUseFixListExecute = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixListExecute, 0, old_inUse.length);

		FixListExecute[] old_pool = poolFixListExecute;
		poolFixListExecute = new FixListExecute[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixListExecute, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixListExecute.length; i++) {
			poolFixListExecute[i] = new FixListExecute();
			inUseFixListExecute[i] = false;
		}

		inUseFixListExecute[poolFixListExecute.length - 1] = true;
		poolFixListExecute[poolFixListExecute.length - 1].setBuffer(buf, err);
		return poolFixListExecute[poolFixListExecute.length - 1];
	}

	public FixListStatusRequest getFixListStatusRequest(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixListStatusRequest.length - 1; i >= 0; i--)
			if (!inUseFixListStatusRequest[i]) {
				inUseFixListStatusRequest[i] = true;
				poolFixListStatusRequest[i].setBuffer(buf, err);
				return poolFixListStatusRequest[i];
			}

		boolean[] old_inUse = inUseFixListStatusRequest;
		inUseFixListStatusRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixListStatusRequest, 0, old_inUse.length);

		FixListStatusRequest[] old_pool = poolFixListStatusRequest;
		poolFixListStatusRequest = new FixListStatusRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixListStatusRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixListStatusRequest.length; i++) {
			poolFixListStatusRequest[i] = new FixListStatusRequest();
			inUseFixListStatusRequest[i] = false;
		}

		inUseFixListStatusRequest[poolFixListStatusRequest.length - 1] = true;
		poolFixListStatusRequest[poolFixListStatusRequest.length - 1].setBuffer(buf, err);
		return poolFixListStatusRequest[poolFixListStatusRequest.length - 1];
	}

	public FixListStatus getFixListStatus(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixListStatus.length - 1; i >= 0; i--)
			if (!inUseFixListStatus[i]) {
				inUseFixListStatus[i] = true;
				poolFixListStatus[i].setBuffer(buf, err);
				return poolFixListStatus[i];
			}

		boolean[] old_inUse = inUseFixListStatus;
		inUseFixListStatus = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixListStatus, 0, old_inUse.length);

		FixListStatus[] old_pool = poolFixListStatus;
		poolFixListStatus = new FixListStatus[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixListStatus, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixListStatus.length; i++) {
			poolFixListStatus[i] = new FixListStatus();
			inUseFixListStatus[i] = false;
		}

		inUseFixListStatus[poolFixListStatus.length - 1] = true;
		poolFixListStatus[poolFixListStatus.length - 1].setBuffer(buf, err);
		return poolFixListStatus[poolFixListStatus.length - 1];
	}

	public FixAllocationInstructionAck getFixAllocationInstructionAck(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixAllocationInstructionAck.length - 1; i >= 0; i--)
			if (!inUseFixAllocationInstructionAck[i]) {
				inUseFixAllocationInstructionAck[i] = true;
				poolFixAllocationInstructionAck[i].setBuffer(buf, err);
				return poolFixAllocationInstructionAck[i];
			}

		boolean[] old_inUse = inUseFixAllocationInstructionAck;
		inUseFixAllocationInstructionAck = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixAllocationInstructionAck, 0, old_inUse.length);

		FixAllocationInstructionAck[] old_pool = poolFixAllocationInstructionAck;
		poolFixAllocationInstructionAck = new FixAllocationInstructionAck[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixAllocationInstructionAck, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixAllocationInstructionAck.length; i++) {
			poolFixAllocationInstructionAck[i] = new FixAllocationInstructionAck();
			inUseFixAllocationInstructionAck[i] = false;
		}

		inUseFixAllocationInstructionAck[poolFixAllocationInstructionAck.length - 1] = true;
		poolFixAllocationInstructionAck[poolFixAllocationInstructionAck.length - 1].setBuffer(buf, err);
		return poolFixAllocationInstructionAck[poolFixAllocationInstructionAck.length - 1];
	}

	public FixDontKnowTradeDK getFixDontKnowTradeDK(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixDontKnowTradeDK.length - 1; i >= 0; i--)
			if (!inUseFixDontKnowTradeDK[i]) {
				inUseFixDontKnowTradeDK[i] = true;
				poolFixDontKnowTradeDK[i].setBuffer(buf, err);
				return poolFixDontKnowTradeDK[i];
			}

		boolean[] old_inUse = inUseFixDontKnowTradeDK;
		inUseFixDontKnowTradeDK = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixDontKnowTradeDK, 0, old_inUse.length);

		FixDontKnowTradeDK[] old_pool = poolFixDontKnowTradeDK;
		poolFixDontKnowTradeDK = new FixDontKnowTradeDK[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixDontKnowTradeDK, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixDontKnowTradeDK.length; i++) {
			poolFixDontKnowTradeDK[i] = new FixDontKnowTradeDK();
			inUseFixDontKnowTradeDK[i] = false;
		}

		inUseFixDontKnowTradeDK[poolFixDontKnowTradeDK.length - 1] = true;
		poolFixDontKnowTradeDK[poolFixDontKnowTradeDK.length - 1].setBuffer(buf, err);
		return poolFixDontKnowTradeDK[poolFixDontKnowTradeDK.length - 1];
	}

	public FixQuoteRequest getFixQuoteRequest(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixQuoteRequest.length - 1; i >= 0; i--)
			if (!inUseFixQuoteRequest[i]) {
				inUseFixQuoteRequest[i] = true;
				poolFixQuoteRequest[i].setBuffer(buf, err);
				return poolFixQuoteRequest[i];
			}

		boolean[] old_inUse = inUseFixQuoteRequest;
		inUseFixQuoteRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixQuoteRequest, 0, old_inUse.length);

		FixQuoteRequest[] old_pool = poolFixQuoteRequest;
		poolFixQuoteRequest = new FixQuoteRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixQuoteRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixQuoteRequest.length; i++) {
			poolFixQuoteRequest[i] = new FixQuoteRequest();
			inUseFixQuoteRequest[i] = false;
		}

		inUseFixQuoteRequest[poolFixQuoteRequest.length - 1] = true;
		poolFixQuoteRequest[poolFixQuoteRequest.length - 1].setBuffer(buf, err);
		return poolFixQuoteRequest[poolFixQuoteRequest.length - 1];
	}

	public FixQuote getFixQuote(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixQuote.length - 1; i >= 0; i--)
			if (!inUseFixQuote[i]) {
				inUseFixQuote[i] = true;
				poolFixQuote[i].setBuffer(buf, err);
				return poolFixQuote[i];
			}

		boolean[] old_inUse = inUseFixQuote;
		inUseFixQuote = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixQuote, 0, old_inUse.length);

		FixQuote[] old_pool = poolFixQuote;
		poolFixQuote = new FixQuote[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixQuote, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixQuote.length; i++) {
			poolFixQuote[i] = new FixQuote();
			inUseFixQuote[i] = false;
		}

		inUseFixQuote[poolFixQuote.length - 1] = true;
		poolFixQuote[poolFixQuote.length - 1].setBuffer(buf, err);
		return poolFixQuote[poolFixQuote.length - 1];
	}

	public FixSettlementInstructions getFixSettlementInstructions(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixSettlementInstructions.length - 1; i >= 0; i--)
			if (!inUseFixSettlementInstructions[i]) {
				inUseFixSettlementInstructions[i] = true;
				poolFixSettlementInstructions[i].setBuffer(buf, err);
				return poolFixSettlementInstructions[i];
			}

		boolean[] old_inUse = inUseFixSettlementInstructions;
		inUseFixSettlementInstructions = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixSettlementInstructions, 0, old_inUse.length);

		FixSettlementInstructions[] old_pool = poolFixSettlementInstructions;
		poolFixSettlementInstructions = new FixSettlementInstructions[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixSettlementInstructions, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixSettlementInstructions.length; i++) {
			poolFixSettlementInstructions[i] = new FixSettlementInstructions();
			inUseFixSettlementInstructions[i] = false;
		}

		inUseFixSettlementInstructions[poolFixSettlementInstructions.length - 1] = true;
		poolFixSettlementInstructions[poolFixSettlementInstructions.length - 1].setBuffer(buf, err);
		return poolFixSettlementInstructions[poolFixSettlementInstructions.length - 1];
	}

	public FixMarketDataRequest getFixMarketDataRequest(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixMarketDataRequest.length - 1; i >= 0; i--)
			if (!inUseFixMarketDataRequest[i]) {
				inUseFixMarketDataRequest[i] = true;
				poolFixMarketDataRequest[i].setBuffer(buf, err);
				return poolFixMarketDataRequest[i];
			}

		boolean[] old_inUse = inUseFixMarketDataRequest;
		inUseFixMarketDataRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixMarketDataRequest, 0, old_inUse.length);

		FixMarketDataRequest[] old_pool = poolFixMarketDataRequest;
		poolFixMarketDataRequest = new FixMarketDataRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixMarketDataRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixMarketDataRequest.length; i++) {
			poolFixMarketDataRequest[i] = new FixMarketDataRequest();
			inUseFixMarketDataRequest[i] = false;
		}

		inUseFixMarketDataRequest[poolFixMarketDataRequest.length - 1] = true;
		poolFixMarketDataRequest[poolFixMarketDataRequest.length - 1].setBuffer(buf, err);
		return poolFixMarketDataRequest[poolFixMarketDataRequest.length - 1];
	}

	public FixMarketDataSnapshotFullRefresh getFixMarketDataSnapshotFullRefresh(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixMarketDataSnapshotFullRefresh.length - 1; i >= 0; i--)
			if (!inUseFixMarketDataSnapshotFullRefresh[i]) {
				inUseFixMarketDataSnapshotFullRefresh[i] = true;
				poolFixMarketDataSnapshotFullRefresh[i].setBuffer(buf, err);
				return poolFixMarketDataSnapshotFullRefresh[i];
			}

		boolean[] old_inUse = inUseFixMarketDataSnapshotFullRefresh;
		inUseFixMarketDataSnapshotFullRefresh = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixMarketDataSnapshotFullRefresh, 0, old_inUse.length);

		FixMarketDataSnapshotFullRefresh[] old_pool = poolFixMarketDataSnapshotFullRefresh;
		poolFixMarketDataSnapshotFullRefresh = new FixMarketDataSnapshotFullRefresh[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixMarketDataSnapshotFullRefresh, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixMarketDataSnapshotFullRefresh.length; i++) {
			poolFixMarketDataSnapshotFullRefresh[i] = new FixMarketDataSnapshotFullRefresh();
			inUseFixMarketDataSnapshotFullRefresh[i] = false;
		}

		inUseFixMarketDataSnapshotFullRefresh[poolFixMarketDataSnapshotFullRefresh.length - 1] = true;
		poolFixMarketDataSnapshotFullRefresh[poolFixMarketDataSnapshotFullRefresh.length - 1].setBuffer(buf, err);
		return poolFixMarketDataSnapshotFullRefresh[poolFixMarketDataSnapshotFullRefresh.length - 1];
	}

	public FixMarketDataIncrementalRefresh getFixMarketDataIncrementalRefresh(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixMarketDataIncrementalRefresh.length - 1; i >= 0; i--)
			if (!inUseFixMarketDataIncrementalRefresh[i]) {
				inUseFixMarketDataIncrementalRefresh[i] = true;
				poolFixMarketDataIncrementalRefresh[i].setBuffer(buf, err);
				return poolFixMarketDataIncrementalRefresh[i];
			}

		boolean[] old_inUse = inUseFixMarketDataIncrementalRefresh;
		inUseFixMarketDataIncrementalRefresh = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixMarketDataIncrementalRefresh, 0, old_inUse.length);

		FixMarketDataIncrementalRefresh[] old_pool = poolFixMarketDataIncrementalRefresh;
		poolFixMarketDataIncrementalRefresh = new FixMarketDataIncrementalRefresh[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixMarketDataIncrementalRefresh, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixMarketDataIncrementalRefresh.length; i++) {
			poolFixMarketDataIncrementalRefresh[i] = new FixMarketDataIncrementalRefresh();
			inUseFixMarketDataIncrementalRefresh[i] = false;
		}

		inUseFixMarketDataIncrementalRefresh[poolFixMarketDataIncrementalRefresh.length - 1] = true;
		poolFixMarketDataIncrementalRefresh[poolFixMarketDataIncrementalRefresh.length - 1].setBuffer(buf, err);
		return poolFixMarketDataIncrementalRefresh[poolFixMarketDataIncrementalRefresh.length - 1];
	}

	public FixMarketDataRequestReject getFixMarketDataRequestReject(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixMarketDataRequestReject.length - 1; i >= 0; i--)
			if (!inUseFixMarketDataRequestReject[i]) {
				inUseFixMarketDataRequestReject[i] = true;
				poolFixMarketDataRequestReject[i].setBuffer(buf, err);
				return poolFixMarketDataRequestReject[i];
			}

		boolean[] old_inUse = inUseFixMarketDataRequestReject;
		inUseFixMarketDataRequestReject = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixMarketDataRequestReject, 0, old_inUse.length);

		FixMarketDataRequestReject[] old_pool = poolFixMarketDataRequestReject;
		poolFixMarketDataRequestReject = new FixMarketDataRequestReject[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixMarketDataRequestReject, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixMarketDataRequestReject.length; i++) {
			poolFixMarketDataRequestReject[i] = new FixMarketDataRequestReject();
			inUseFixMarketDataRequestReject[i] = false;
		}

		inUseFixMarketDataRequestReject[poolFixMarketDataRequestReject.length - 1] = true;
		poolFixMarketDataRequestReject[poolFixMarketDataRequestReject.length - 1].setBuffer(buf, err);
		return poolFixMarketDataRequestReject[poolFixMarketDataRequestReject.length - 1];
	}

	public FixQuoteCancel getFixQuoteCancel(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixQuoteCancel.length - 1; i >= 0; i--)
			if (!inUseFixQuoteCancel[i]) {
				inUseFixQuoteCancel[i] = true;
				poolFixQuoteCancel[i].setBuffer(buf, err);
				return poolFixQuoteCancel[i];
			}

		boolean[] old_inUse = inUseFixQuoteCancel;
		inUseFixQuoteCancel = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixQuoteCancel, 0, old_inUse.length);

		FixQuoteCancel[] old_pool = poolFixQuoteCancel;
		poolFixQuoteCancel = new FixQuoteCancel[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixQuoteCancel, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixQuoteCancel.length; i++) {
			poolFixQuoteCancel[i] = new FixQuoteCancel();
			inUseFixQuoteCancel[i] = false;
		}

		inUseFixQuoteCancel[poolFixQuoteCancel.length - 1] = true;
		poolFixQuoteCancel[poolFixQuoteCancel.length - 1].setBuffer(buf, err);
		return poolFixQuoteCancel[poolFixQuoteCancel.length - 1];
	}

	public FixQuoteStatusRequest getFixQuoteStatusRequest(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixQuoteStatusRequest.length - 1; i >= 0; i--)
			if (!inUseFixQuoteStatusRequest[i]) {
				inUseFixQuoteStatusRequest[i] = true;
				poolFixQuoteStatusRequest[i].setBuffer(buf, err);
				return poolFixQuoteStatusRequest[i];
			}

		boolean[] old_inUse = inUseFixQuoteStatusRequest;
		inUseFixQuoteStatusRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixQuoteStatusRequest, 0, old_inUse.length);

		FixQuoteStatusRequest[] old_pool = poolFixQuoteStatusRequest;
		poolFixQuoteStatusRequest = new FixQuoteStatusRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixQuoteStatusRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixQuoteStatusRequest.length; i++) {
			poolFixQuoteStatusRequest[i] = new FixQuoteStatusRequest();
			inUseFixQuoteStatusRequest[i] = false;
		}

		inUseFixQuoteStatusRequest[poolFixQuoteStatusRequest.length - 1] = true;
		poolFixQuoteStatusRequest[poolFixQuoteStatusRequest.length - 1].setBuffer(buf, err);
		return poolFixQuoteStatusRequest[poolFixQuoteStatusRequest.length - 1];
	}

	public FixMassQuoteAcknowledgement getFixMassQuoteAcknowledgement(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixMassQuoteAcknowledgement.length - 1; i >= 0; i--)
			if (!inUseFixMassQuoteAcknowledgement[i]) {
				inUseFixMassQuoteAcknowledgement[i] = true;
				poolFixMassQuoteAcknowledgement[i].setBuffer(buf, err);
				return poolFixMassQuoteAcknowledgement[i];
			}

		boolean[] old_inUse = inUseFixMassQuoteAcknowledgement;
		inUseFixMassQuoteAcknowledgement = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixMassQuoteAcknowledgement, 0, old_inUse.length);

		FixMassQuoteAcknowledgement[] old_pool = poolFixMassQuoteAcknowledgement;
		poolFixMassQuoteAcknowledgement = new FixMassQuoteAcknowledgement[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixMassQuoteAcknowledgement, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixMassQuoteAcknowledgement.length; i++) {
			poolFixMassQuoteAcknowledgement[i] = new FixMassQuoteAcknowledgement();
			inUseFixMassQuoteAcknowledgement[i] = false;
		}

		inUseFixMassQuoteAcknowledgement[poolFixMassQuoteAcknowledgement.length - 1] = true;
		poolFixMassQuoteAcknowledgement[poolFixMassQuoteAcknowledgement.length - 1].setBuffer(buf, err);
		return poolFixMassQuoteAcknowledgement[poolFixMassQuoteAcknowledgement.length - 1];
	}

	public FixSecurityDefinitionRequest getFixSecurityDefinitionRequest(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixSecurityDefinitionRequest.length - 1; i >= 0; i--)
			if (!inUseFixSecurityDefinitionRequest[i]) {
				inUseFixSecurityDefinitionRequest[i] = true;
				poolFixSecurityDefinitionRequest[i].setBuffer(buf, err);
				return poolFixSecurityDefinitionRequest[i];
			}

		boolean[] old_inUse = inUseFixSecurityDefinitionRequest;
		inUseFixSecurityDefinitionRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixSecurityDefinitionRequest, 0, old_inUse.length);

		FixSecurityDefinitionRequest[] old_pool = poolFixSecurityDefinitionRequest;
		poolFixSecurityDefinitionRequest = new FixSecurityDefinitionRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixSecurityDefinitionRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixSecurityDefinitionRequest.length; i++) {
			poolFixSecurityDefinitionRequest[i] = new FixSecurityDefinitionRequest();
			inUseFixSecurityDefinitionRequest[i] = false;
		}

		inUseFixSecurityDefinitionRequest[poolFixSecurityDefinitionRequest.length - 1] = true;
		poolFixSecurityDefinitionRequest[poolFixSecurityDefinitionRequest.length - 1].setBuffer(buf, err);
		return poolFixSecurityDefinitionRequest[poolFixSecurityDefinitionRequest.length - 1];
	}

	public FixSecurityDefinition getFixSecurityDefinition(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixSecurityDefinition.length - 1; i >= 0; i--)
			if (!inUseFixSecurityDefinition[i]) {
				inUseFixSecurityDefinition[i] = true;
				poolFixSecurityDefinition[i].setBuffer(buf, err);
				return poolFixSecurityDefinition[i];
			}

		boolean[] old_inUse = inUseFixSecurityDefinition;
		inUseFixSecurityDefinition = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixSecurityDefinition, 0, old_inUse.length);

		FixSecurityDefinition[] old_pool = poolFixSecurityDefinition;
		poolFixSecurityDefinition = new FixSecurityDefinition[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixSecurityDefinition, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixSecurityDefinition.length; i++) {
			poolFixSecurityDefinition[i] = new FixSecurityDefinition();
			inUseFixSecurityDefinition[i] = false;
		}

		inUseFixSecurityDefinition[poolFixSecurityDefinition.length - 1] = true;
		poolFixSecurityDefinition[poolFixSecurityDefinition.length - 1].setBuffer(buf, err);
		return poolFixSecurityDefinition[poolFixSecurityDefinition.length - 1];
	}

	public FixSecurityStatusRequest getFixSecurityStatusRequest(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixSecurityStatusRequest.length - 1; i >= 0; i--)
			if (!inUseFixSecurityStatusRequest[i]) {
				inUseFixSecurityStatusRequest[i] = true;
				poolFixSecurityStatusRequest[i].setBuffer(buf, err);
				return poolFixSecurityStatusRequest[i];
			}

		boolean[] old_inUse = inUseFixSecurityStatusRequest;
		inUseFixSecurityStatusRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixSecurityStatusRequest, 0, old_inUse.length);

		FixSecurityStatusRequest[] old_pool = poolFixSecurityStatusRequest;
		poolFixSecurityStatusRequest = new FixSecurityStatusRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixSecurityStatusRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixSecurityStatusRequest.length; i++) {
			poolFixSecurityStatusRequest[i] = new FixSecurityStatusRequest();
			inUseFixSecurityStatusRequest[i] = false;
		}

		inUseFixSecurityStatusRequest[poolFixSecurityStatusRequest.length - 1] = true;
		poolFixSecurityStatusRequest[poolFixSecurityStatusRequest.length - 1].setBuffer(buf, err);
		return poolFixSecurityStatusRequest[poolFixSecurityStatusRequest.length - 1];
	}

	public FixSecurityStatus getFixSecurityStatus(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixSecurityStatus.length - 1; i >= 0; i--)
			if (!inUseFixSecurityStatus[i]) {
				inUseFixSecurityStatus[i] = true;
				poolFixSecurityStatus[i].setBuffer(buf, err);
				return poolFixSecurityStatus[i];
			}

		boolean[] old_inUse = inUseFixSecurityStatus;
		inUseFixSecurityStatus = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixSecurityStatus, 0, old_inUse.length);

		FixSecurityStatus[] old_pool = poolFixSecurityStatus;
		poolFixSecurityStatus = new FixSecurityStatus[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixSecurityStatus, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixSecurityStatus.length; i++) {
			poolFixSecurityStatus[i] = new FixSecurityStatus();
			inUseFixSecurityStatus[i] = false;
		}

		inUseFixSecurityStatus[poolFixSecurityStatus.length - 1] = true;
		poolFixSecurityStatus[poolFixSecurityStatus.length - 1].setBuffer(buf, err);
		return poolFixSecurityStatus[poolFixSecurityStatus.length - 1];
	}

	public FixTradingSessionStatusRequest getFixTradingSessionStatusRequest(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixTradingSessionStatusRequest.length - 1; i >= 0; i--)
			if (!inUseFixTradingSessionStatusRequest[i]) {
				inUseFixTradingSessionStatusRequest[i] = true;
				poolFixTradingSessionStatusRequest[i].setBuffer(buf, err);
				return poolFixTradingSessionStatusRequest[i];
			}

		boolean[] old_inUse = inUseFixTradingSessionStatusRequest;
		inUseFixTradingSessionStatusRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixTradingSessionStatusRequest, 0, old_inUse.length);

		FixTradingSessionStatusRequest[] old_pool = poolFixTradingSessionStatusRequest;
		poolFixTradingSessionStatusRequest = new FixTradingSessionStatusRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixTradingSessionStatusRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixTradingSessionStatusRequest.length; i++) {
			poolFixTradingSessionStatusRequest[i] = new FixTradingSessionStatusRequest();
			inUseFixTradingSessionStatusRequest[i] = false;
		}

		inUseFixTradingSessionStatusRequest[poolFixTradingSessionStatusRequest.length - 1] = true;
		poolFixTradingSessionStatusRequest[poolFixTradingSessionStatusRequest.length - 1].setBuffer(buf, err);
		return poolFixTradingSessionStatusRequest[poolFixTradingSessionStatusRequest.length - 1];
	}

	public FixTradingSessionStatus getFixTradingSessionStatus(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixTradingSessionStatus.length - 1; i >= 0; i--)
			if (!inUseFixTradingSessionStatus[i]) {
				inUseFixTradingSessionStatus[i] = true;
				poolFixTradingSessionStatus[i].setBuffer(buf, err);
				return poolFixTradingSessionStatus[i];
			}

		boolean[] old_inUse = inUseFixTradingSessionStatus;
		inUseFixTradingSessionStatus = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixTradingSessionStatus, 0, old_inUse.length);

		FixTradingSessionStatus[] old_pool = poolFixTradingSessionStatus;
		poolFixTradingSessionStatus = new FixTradingSessionStatus[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixTradingSessionStatus, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixTradingSessionStatus.length; i++) {
			poolFixTradingSessionStatus[i] = new FixTradingSessionStatus();
			inUseFixTradingSessionStatus[i] = false;
		}

		inUseFixTradingSessionStatus[poolFixTradingSessionStatus.length - 1] = true;
		poolFixTradingSessionStatus[poolFixTradingSessionStatus.length - 1].setBuffer(buf, err);
		return poolFixTradingSessionStatus[poolFixTradingSessionStatus.length - 1];
	}

	public FixMassQuote getFixMassQuote(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixMassQuote.length - 1; i >= 0; i--)
			if (!inUseFixMassQuote[i]) {
				inUseFixMassQuote[i] = true;
				poolFixMassQuote[i].setBuffer(buf, err);
				return poolFixMassQuote[i];
			}

		boolean[] old_inUse = inUseFixMassQuote;
		inUseFixMassQuote = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixMassQuote, 0, old_inUse.length);

		FixMassQuote[] old_pool = poolFixMassQuote;
		poolFixMassQuote = new FixMassQuote[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixMassQuote, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixMassQuote.length; i++) {
			poolFixMassQuote[i] = new FixMassQuote();
			inUseFixMassQuote[i] = false;
		}

		inUseFixMassQuote[poolFixMassQuote.length - 1] = true;
		poolFixMassQuote[poolFixMassQuote.length - 1].setBuffer(buf, err);
		return poolFixMassQuote[poolFixMassQuote.length - 1];
	}

	public FixBusinessMessageReject getFixBusinessMessageReject(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixBusinessMessageReject.length - 1; i >= 0; i--)
			if (!inUseFixBusinessMessageReject[i]) {
				inUseFixBusinessMessageReject[i] = true;
				poolFixBusinessMessageReject[i].setBuffer(buf, err);
				return poolFixBusinessMessageReject[i];
			}

		boolean[] old_inUse = inUseFixBusinessMessageReject;
		inUseFixBusinessMessageReject = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixBusinessMessageReject, 0, old_inUse.length);

		FixBusinessMessageReject[] old_pool = poolFixBusinessMessageReject;
		poolFixBusinessMessageReject = new FixBusinessMessageReject[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixBusinessMessageReject, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixBusinessMessageReject.length; i++) {
			poolFixBusinessMessageReject[i] = new FixBusinessMessageReject();
			inUseFixBusinessMessageReject[i] = false;
		}

		inUseFixBusinessMessageReject[poolFixBusinessMessageReject.length - 1] = true;
		poolFixBusinessMessageReject[poolFixBusinessMessageReject.length - 1].setBuffer(buf, err);
		return poolFixBusinessMessageReject[poolFixBusinessMessageReject.length - 1];
	}

	public FixBidRequest getFixBidRequest(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixBidRequest.length - 1; i >= 0; i--)
			if (!inUseFixBidRequest[i]) {
				inUseFixBidRequest[i] = true;
				poolFixBidRequest[i].setBuffer(buf, err);
				return poolFixBidRequest[i];
			}

		boolean[] old_inUse = inUseFixBidRequest;
		inUseFixBidRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixBidRequest, 0, old_inUse.length);

		FixBidRequest[] old_pool = poolFixBidRequest;
		poolFixBidRequest = new FixBidRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixBidRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixBidRequest.length; i++) {
			poolFixBidRequest[i] = new FixBidRequest();
			inUseFixBidRequest[i] = false;
		}

		inUseFixBidRequest[poolFixBidRequest.length - 1] = true;
		poolFixBidRequest[poolFixBidRequest.length - 1].setBuffer(buf, err);
		return poolFixBidRequest[poolFixBidRequest.length - 1];
	}

	public FixBidResponse getFixBidResponse(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixBidResponse.length - 1; i >= 0; i--)
			if (!inUseFixBidResponse[i]) {
				inUseFixBidResponse[i] = true;
				poolFixBidResponse[i].setBuffer(buf, err);
				return poolFixBidResponse[i];
			}

		boolean[] old_inUse = inUseFixBidResponse;
		inUseFixBidResponse = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixBidResponse, 0, old_inUse.length);

		FixBidResponse[] old_pool = poolFixBidResponse;
		poolFixBidResponse = new FixBidResponse[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixBidResponse, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixBidResponse.length; i++) {
			poolFixBidResponse[i] = new FixBidResponse();
			inUseFixBidResponse[i] = false;
		}

		inUseFixBidResponse[poolFixBidResponse.length - 1] = true;
		poolFixBidResponse[poolFixBidResponse.length - 1].setBuffer(buf, err);
		return poolFixBidResponse[poolFixBidResponse.length - 1];
	}

	public FixListStrikePrice getFixListStrikePrice(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixListStrikePrice.length - 1; i >= 0; i--)
			if (!inUseFixListStrikePrice[i]) {
				inUseFixListStrikePrice[i] = true;
				poolFixListStrikePrice[i].setBuffer(buf, err);
				return poolFixListStrikePrice[i];
			}

		boolean[] old_inUse = inUseFixListStrikePrice;
		inUseFixListStrikePrice = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixListStrikePrice, 0, old_inUse.length);

		FixListStrikePrice[] old_pool = poolFixListStrikePrice;
		poolFixListStrikePrice = new FixListStrikePrice[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixListStrikePrice, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixListStrikePrice.length; i++) {
			poolFixListStrikePrice[i] = new FixListStrikePrice();
			inUseFixListStrikePrice[i] = false;
		}

		inUseFixListStrikePrice[poolFixListStrikePrice.length - 1] = true;
		poolFixListStrikePrice[poolFixListStrikePrice.length - 1].setBuffer(buf, err);
		return poolFixListStrikePrice[poolFixListStrikePrice.length - 1];
	}

	public FixRegistrationInstructions getFixRegistrationInstructions(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixRegistrationInstructions.length - 1; i >= 0; i--)
			if (!inUseFixRegistrationInstructions[i]) {
				inUseFixRegistrationInstructions[i] = true;
				poolFixRegistrationInstructions[i].setBuffer(buf, err);
				return poolFixRegistrationInstructions[i];
			}

		boolean[] old_inUse = inUseFixRegistrationInstructions;
		inUseFixRegistrationInstructions = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixRegistrationInstructions, 0, old_inUse.length);

		FixRegistrationInstructions[] old_pool = poolFixRegistrationInstructions;
		poolFixRegistrationInstructions = new FixRegistrationInstructions[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixRegistrationInstructions, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixRegistrationInstructions.length; i++) {
			poolFixRegistrationInstructions[i] = new FixRegistrationInstructions();
			inUseFixRegistrationInstructions[i] = false;
		}

		inUseFixRegistrationInstructions[poolFixRegistrationInstructions.length - 1] = true;
		poolFixRegistrationInstructions[poolFixRegistrationInstructions.length - 1].setBuffer(buf, err);
		return poolFixRegistrationInstructions[poolFixRegistrationInstructions.length - 1];
	}

	public FixRegistrationInstructionsResponse getFixRegistrationInstructionsResponse(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixRegistrationInstructionsResponse.length - 1; i >= 0; i--)
			if (!inUseFixRegistrationInstructionsResponse[i]) {
				inUseFixRegistrationInstructionsResponse[i] = true;
				poolFixRegistrationInstructionsResponse[i].setBuffer(buf, err);
				return poolFixRegistrationInstructionsResponse[i];
			}

		boolean[] old_inUse = inUseFixRegistrationInstructionsResponse;
		inUseFixRegistrationInstructionsResponse = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixRegistrationInstructionsResponse, 0, old_inUse.length);

		FixRegistrationInstructionsResponse[] old_pool = poolFixRegistrationInstructionsResponse;
		poolFixRegistrationInstructionsResponse = new FixRegistrationInstructionsResponse[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixRegistrationInstructionsResponse, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixRegistrationInstructionsResponse.length; i++) {
			poolFixRegistrationInstructionsResponse[i] = new FixRegistrationInstructionsResponse();
			inUseFixRegistrationInstructionsResponse[i] = false;
		}

		inUseFixRegistrationInstructionsResponse[poolFixRegistrationInstructionsResponse.length - 1] = true;
		poolFixRegistrationInstructionsResponse[poolFixRegistrationInstructionsResponse.length - 1].setBuffer(buf, err);
		return poolFixRegistrationInstructionsResponse[poolFixRegistrationInstructionsResponse.length - 1];
	}

	public FixOrderMassCancelRequest getFixOrderMassCancelRequest(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixOrderMassCancelRequest.length - 1; i >= 0; i--)
			if (!inUseFixOrderMassCancelRequest[i]) {
				inUseFixOrderMassCancelRequest[i] = true;
				poolFixOrderMassCancelRequest[i].setBuffer(buf, err);
				return poolFixOrderMassCancelRequest[i];
			}

		boolean[] old_inUse = inUseFixOrderMassCancelRequest;
		inUseFixOrderMassCancelRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixOrderMassCancelRequest, 0, old_inUse.length);

		FixOrderMassCancelRequest[] old_pool = poolFixOrderMassCancelRequest;
		poolFixOrderMassCancelRequest = new FixOrderMassCancelRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixOrderMassCancelRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixOrderMassCancelRequest.length; i++) {
			poolFixOrderMassCancelRequest[i] = new FixOrderMassCancelRequest();
			inUseFixOrderMassCancelRequest[i] = false;
		}

		inUseFixOrderMassCancelRequest[poolFixOrderMassCancelRequest.length - 1] = true;
		poolFixOrderMassCancelRequest[poolFixOrderMassCancelRequest.length - 1].setBuffer(buf, err);
		return poolFixOrderMassCancelRequest[poolFixOrderMassCancelRequest.length - 1];
	}

	public FixOrderMassCancelReport getFixOrderMassCancelReport(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixOrderMassCancelReport.length - 1; i >= 0; i--)
			if (!inUseFixOrderMassCancelReport[i]) {
				inUseFixOrderMassCancelReport[i] = true;
				poolFixOrderMassCancelReport[i].setBuffer(buf, err);
				return poolFixOrderMassCancelReport[i];
			}

		boolean[] old_inUse = inUseFixOrderMassCancelReport;
		inUseFixOrderMassCancelReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixOrderMassCancelReport, 0, old_inUse.length);

		FixOrderMassCancelReport[] old_pool = poolFixOrderMassCancelReport;
		poolFixOrderMassCancelReport = new FixOrderMassCancelReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixOrderMassCancelReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixOrderMassCancelReport.length; i++) {
			poolFixOrderMassCancelReport[i] = new FixOrderMassCancelReport();
			inUseFixOrderMassCancelReport[i] = false;
		}

		inUseFixOrderMassCancelReport[poolFixOrderMassCancelReport.length - 1] = true;
		poolFixOrderMassCancelReport[poolFixOrderMassCancelReport.length - 1].setBuffer(buf, err);
		return poolFixOrderMassCancelReport[poolFixOrderMassCancelReport.length - 1];
	}

	public FixNewOrderCross getFixNewOrderCross(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixNewOrderCross.length - 1; i >= 0; i--)
			if (!inUseFixNewOrderCross[i]) {
				inUseFixNewOrderCross[i] = true;
				poolFixNewOrderCross[i].setBuffer(buf, err);
				return poolFixNewOrderCross[i];
			}

		boolean[] old_inUse = inUseFixNewOrderCross;
		inUseFixNewOrderCross = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixNewOrderCross, 0, old_inUse.length);

		FixNewOrderCross[] old_pool = poolFixNewOrderCross;
		poolFixNewOrderCross = new FixNewOrderCross[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixNewOrderCross, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixNewOrderCross.length; i++) {
			poolFixNewOrderCross[i] = new FixNewOrderCross();
			inUseFixNewOrderCross[i] = false;
		}

		inUseFixNewOrderCross[poolFixNewOrderCross.length - 1] = true;
		poolFixNewOrderCross[poolFixNewOrderCross.length - 1].setBuffer(buf, err);
		return poolFixNewOrderCross[poolFixNewOrderCross.length - 1];
	}

	public FixCrossOrderCancelReplaceRequest getFixCrossOrderCancelReplaceRequest(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixCrossOrderCancelReplaceRequest.length - 1; i >= 0; i--)
			if (!inUseFixCrossOrderCancelReplaceRequest[i]) {
				inUseFixCrossOrderCancelReplaceRequest[i] = true;
				poolFixCrossOrderCancelReplaceRequest[i].setBuffer(buf, err);
				return poolFixCrossOrderCancelReplaceRequest[i];
			}

		boolean[] old_inUse = inUseFixCrossOrderCancelReplaceRequest;
		inUseFixCrossOrderCancelReplaceRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixCrossOrderCancelReplaceRequest, 0, old_inUse.length);

		FixCrossOrderCancelReplaceRequest[] old_pool = poolFixCrossOrderCancelReplaceRequest;
		poolFixCrossOrderCancelReplaceRequest = new FixCrossOrderCancelReplaceRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixCrossOrderCancelReplaceRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixCrossOrderCancelReplaceRequest.length; i++) {
			poolFixCrossOrderCancelReplaceRequest[i] = new FixCrossOrderCancelReplaceRequest();
			inUseFixCrossOrderCancelReplaceRequest[i] = false;
		}

		inUseFixCrossOrderCancelReplaceRequest[poolFixCrossOrderCancelReplaceRequest.length - 1] = true;
		poolFixCrossOrderCancelReplaceRequest[poolFixCrossOrderCancelReplaceRequest.length - 1].setBuffer(buf, err);
		return poolFixCrossOrderCancelReplaceRequest[poolFixCrossOrderCancelReplaceRequest.length - 1];
	}

	public FixCrossOrderCancelRequest getFixCrossOrderCancelRequest(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixCrossOrderCancelRequest.length - 1; i >= 0; i--)
			if (!inUseFixCrossOrderCancelRequest[i]) {
				inUseFixCrossOrderCancelRequest[i] = true;
				poolFixCrossOrderCancelRequest[i].setBuffer(buf, err);
				return poolFixCrossOrderCancelRequest[i];
			}

		boolean[] old_inUse = inUseFixCrossOrderCancelRequest;
		inUseFixCrossOrderCancelRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixCrossOrderCancelRequest, 0, old_inUse.length);

		FixCrossOrderCancelRequest[] old_pool = poolFixCrossOrderCancelRequest;
		poolFixCrossOrderCancelRequest = new FixCrossOrderCancelRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixCrossOrderCancelRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixCrossOrderCancelRequest.length; i++) {
			poolFixCrossOrderCancelRequest[i] = new FixCrossOrderCancelRequest();
			inUseFixCrossOrderCancelRequest[i] = false;
		}

		inUseFixCrossOrderCancelRequest[poolFixCrossOrderCancelRequest.length - 1] = true;
		poolFixCrossOrderCancelRequest[poolFixCrossOrderCancelRequest.length - 1].setBuffer(buf, err);
		return poolFixCrossOrderCancelRequest[poolFixCrossOrderCancelRequest.length - 1];
	}

	public FixSecurityTypeRequest getFixSecurityTypeRequest(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixSecurityTypeRequest.length - 1; i >= 0; i--)
			if (!inUseFixSecurityTypeRequest[i]) {
				inUseFixSecurityTypeRequest[i] = true;
				poolFixSecurityTypeRequest[i].setBuffer(buf, err);
				return poolFixSecurityTypeRequest[i];
			}

		boolean[] old_inUse = inUseFixSecurityTypeRequest;
		inUseFixSecurityTypeRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixSecurityTypeRequest, 0, old_inUse.length);

		FixSecurityTypeRequest[] old_pool = poolFixSecurityTypeRequest;
		poolFixSecurityTypeRequest = new FixSecurityTypeRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixSecurityTypeRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixSecurityTypeRequest.length; i++) {
			poolFixSecurityTypeRequest[i] = new FixSecurityTypeRequest();
			inUseFixSecurityTypeRequest[i] = false;
		}

		inUseFixSecurityTypeRequest[poolFixSecurityTypeRequest.length - 1] = true;
		poolFixSecurityTypeRequest[poolFixSecurityTypeRequest.length - 1].setBuffer(buf, err);
		return poolFixSecurityTypeRequest[poolFixSecurityTypeRequest.length - 1];
	}

	public FixSecurityTypes getFixSecurityTypes(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixSecurityTypes.length - 1; i >= 0; i--)
			if (!inUseFixSecurityTypes[i]) {
				inUseFixSecurityTypes[i] = true;
				poolFixSecurityTypes[i].setBuffer(buf, err);
				return poolFixSecurityTypes[i];
			}

		boolean[] old_inUse = inUseFixSecurityTypes;
		inUseFixSecurityTypes = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixSecurityTypes, 0, old_inUse.length);

		FixSecurityTypes[] old_pool = poolFixSecurityTypes;
		poolFixSecurityTypes = new FixSecurityTypes[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixSecurityTypes, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixSecurityTypes.length; i++) {
			poolFixSecurityTypes[i] = new FixSecurityTypes();
			inUseFixSecurityTypes[i] = false;
		}

		inUseFixSecurityTypes[poolFixSecurityTypes.length - 1] = true;
		poolFixSecurityTypes[poolFixSecurityTypes.length - 1].setBuffer(buf, err);
		return poolFixSecurityTypes[poolFixSecurityTypes.length - 1];
	}

	public FixSecurityListRequest getFixSecurityListRequest(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixSecurityListRequest.length - 1; i >= 0; i--)
			if (!inUseFixSecurityListRequest[i]) {
				inUseFixSecurityListRequest[i] = true;
				poolFixSecurityListRequest[i].setBuffer(buf, err);
				return poolFixSecurityListRequest[i];
			}

		boolean[] old_inUse = inUseFixSecurityListRequest;
		inUseFixSecurityListRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixSecurityListRequest, 0, old_inUse.length);

		FixSecurityListRequest[] old_pool = poolFixSecurityListRequest;
		poolFixSecurityListRequest = new FixSecurityListRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixSecurityListRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixSecurityListRequest.length; i++) {
			poolFixSecurityListRequest[i] = new FixSecurityListRequest();
			inUseFixSecurityListRequest[i] = false;
		}

		inUseFixSecurityListRequest[poolFixSecurityListRequest.length - 1] = true;
		poolFixSecurityListRequest[poolFixSecurityListRequest.length - 1].setBuffer(buf, err);
		return poolFixSecurityListRequest[poolFixSecurityListRequest.length - 1];
	}

	public FixSecurityList getFixSecurityList(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixSecurityList.length - 1; i >= 0; i--)
			if (!inUseFixSecurityList[i]) {
				inUseFixSecurityList[i] = true;
				poolFixSecurityList[i].setBuffer(buf, err);
				return poolFixSecurityList[i];
			}

		boolean[] old_inUse = inUseFixSecurityList;
		inUseFixSecurityList = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixSecurityList, 0, old_inUse.length);

		FixSecurityList[] old_pool = poolFixSecurityList;
		poolFixSecurityList = new FixSecurityList[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixSecurityList, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixSecurityList.length; i++) {
			poolFixSecurityList[i] = new FixSecurityList();
			inUseFixSecurityList[i] = false;
		}

		inUseFixSecurityList[poolFixSecurityList.length - 1] = true;
		poolFixSecurityList[poolFixSecurityList.length - 1].setBuffer(buf, err);
		return poolFixSecurityList[poolFixSecurityList.length - 1];
	}

	public FixDerivativeSecurityListRequest getFixDerivativeSecurityListRequest(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixDerivativeSecurityListRequest.length - 1; i >= 0; i--)
			if (!inUseFixDerivativeSecurityListRequest[i]) {
				inUseFixDerivativeSecurityListRequest[i] = true;
				poolFixDerivativeSecurityListRequest[i].setBuffer(buf, err);
				return poolFixDerivativeSecurityListRequest[i];
			}

		boolean[] old_inUse = inUseFixDerivativeSecurityListRequest;
		inUseFixDerivativeSecurityListRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixDerivativeSecurityListRequest, 0, old_inUse.length);

		FixDerivativeSecurityListRequest[] old_pool = poolFixDerivativeSecurityListRequest;
		poolFixDerivativeSecurityListRequest = new FixDerivativeSecurityListRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixDerivativeSecurityListRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixDerivativeSecurityListRequest.length; i++) {
			poolFixDerivativeSecurityListRequest[i] = new FixDerivativeSecurityListRequest();
			inUseFixDerivativeSecurityListRequest[i] = false;
		}

		inUseFixDerivativeSecurityListRequest[poolFixDerivativeSecurityListRequest.length - 1] = true;
		poolFixDerivativeSecurityListRequest[poolFixDerivativeSecurityListRequest.length - 1].setBuffer(buf, err);
		return poolFixDerivativeSecurityListRequest[poolFixDerivativeSecurityListRequest.length - 1];
	}

	public FixDerivativeSecurityList getFixDerivativeSecurityList(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixDerivativeSecurityList.length - 1; i >= 0; i--)
			if (!inUseFixDerivativeSecurityList[i]) {
				inUseFixDerivativeSecurityList[i] = true;
				poolFixDerivativeSecurityList[i].setBuffer(buf, err);
				return poolFixDerivativeSecurityList[i];
			}

		boolean[] old_inUse = inUseFixDerivativeSecurityList;
		inUseFixDerivativeSecurityList = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixDerivativeSecurityList, 0, old_inUse.length);

		FixDerivativeSecurityList[] old_pool = poolFixDerivativeSecurityList;
		poolFixDerivativeSecurityList = new FixDerivativeSecurityList[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixDerivativeSecurityList, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixDerivativeSecurityList.length; i++) {
			poolFixDerivativeSecurityList[i] = new FixDerivativeSecurityList();
			inUseFixDerivativeSecurityList[i] = false;
		}

		inUseFixDerivativeSecurityList[poolFixDerivativeSecurityList.length - 1] = true;
		poolFixDerivativeSecurityList[poolFixDerivativeSecurityList.length - 1].setBuffer(buf, err);
		return poolFixDerivativeSecurityList[poolFixDerivativeSecurityList.length - 1];
	}

	public FixNewOrderMultileg getFixNewOrderMultileg(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixNewOrderMultileg.length - 1; i >= 0; i--)
			if (!inUseFixNewOrderMultileg[i]) {
				inUseFixNewOrderMultileg[i] = true;
				poolFixNewOrderMultileg[i].setBuffer(buf, err);
				return poolFixNewOrderMultileg[i];
			}

		boolean[] old_inUse = inUseFixNewOrderMultileg;
		inUseFixNewOrderMultileg = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixNewOrderMultileg, 0, old_inUse.length);

		FixNewOrderMultileg[] old_pool = poolFixNewOrderMultileg;
		poolFixNewOrderMultileg = new FixNewOrderMultileg[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixNewOrderMultileg, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixNewOrderMultileg.length; i++) {
			poolFixNewOrderMultileg[i] = new FixNewOrderMultileg();
			inUseFixNewOrderMultileg[i] = false;
		}

		inUseFixNewOrderMultileg[poolFixNewOrderMultileg.length - 1] = true;
		poolFixNewOrderMultileg[poolFixNewOrderMultileg.length - 1].setBuffer(buf, err);
		return poolFixNewOrderMultileg[poolFixNewOrderMultileg.length - 1];
	}

	public FixMultilegOrderCancelReplace getFixMultilegOrderCancelReplace(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixMultilegOrderCancelReplace.length - 1; i >= 0; i--)
			if (!inUseFixMultilegOrderCancelReplace[i]) {
				inUseFixMultilegOrderCancelReplace[i] = true;
				poolFixMultilegOrderCancelReplace[i].setBuffer(buf, err);
				return poolFixMultilegOrderCancelReplace[i];
			}

		boolean[] old_inUse = inUseFixMultilegOrderCancelReplace;
		inUseFixMultilegOrderCancelReplace = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixMultilegOrderCancelReplace, 0, old_inUse.length);

		FixMultilegOrderCancelReplace[] old_pool = poolFixMultilegOrderCancelReplace;
		poolFixMultilegOrderCancelReplace = new FixMultilegOrderCancelReplace[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixMultilegOrderCancelReplace, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixMultilegOrderCancelReplace.length; i++) {
			poolFixMultilegOrderCancelReplace[i] = new FixMultilegOrderCancelReplace();
			inUseFixMultilegOrderCancelReplace[i] = false;
		}

		inUseFixMultilegOrderCancelReplace[poolFixMultilegOrderCancelReplace.length - 1] = true;
		poolFixMultilegOrderCancelReplace[poolFixMultilegOrderCancelReplace.length - 1].setBuffer(buf, err);
		return poolFixMultilegOrderCancelReplace[poolFixMultilegOrderCancelReplace.length - 1];
	}

	public FixTradeCaptureReportRequest getFixTradeCaptureReportRequest(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixTradeCaptureReportRequest.length - 1; i >= 0; i--)
			if (!inUseFixTradeCaptureReportRequest[i]) {
				inUseFixTradeCaptureReportRequest[i] = true;
				poolFixTradeCaptureReportRequest[i].setBuffer(buf, err);
				return poolFixTradeCaptureReportRequest[i];
			}

		boolean[] old_inUse = inUseFixTradeCaptureReportRequest;
		inUseFixTradeCaptureReportRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixTradeCaptureReportRequest, 0, old_inUse.length);

		FixTradeCaptureReportRequest[] old_pool = poolFixTradeCaptureReportRequest;
		poolFixTradeCaptureReportRequest = new FixTradeCaptureReportRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixTradeCaptureReportRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixTradeCaptureReportRequest.length; i++) {
			poolFixTradeCaptureReportRequest[i] = new FixTradeCaptureReportRequest();
			inUseFixTradeCaptureReportRequest[i] = false;
		}

		inUseFixTradeCaptureReportRequest[poolFixTradeCaptureReportRequest.length - 1] = true;
		poolFixTradeCaptureReportRequest[poolFixTradeCaptureReportRequest.length - 1].setBuffer(buf, err);
		return poolFixTradeCaptureReportRequest[poolFixTradeCaptureReportRequest.length - 1];
	}

	public FixTradeCaptureReport getFixTradeCaptureReport(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixTradeCaptureReport.length - 1; i >= 0; i--)
			if (!inUseFixTradeCaptureReport[i]) {
				inUseFixTradeCaptureReport[i] = true;
				poolFixTradeCaptureReport[i].setBuffer(buf, err);
				return poolFixTradeCaptureReport[i];
			}

		boolean[] old_inUse = inUseFixTradeCaptureReport;
		inUseFixTradeCaptureReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixTradeCaptureReport, 0, old_inUse.length);

		FixTradeCaptureReport[] old_pool = poolFixTradeCaptureReport;
		poolFixTradeCaptureReport = new FixTradeCaptureReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixTradeCaptureReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixTradeCaptureReport.length; i++) {
			poolFixTradeCaptureReport[i] = new FixTradeCaptureReport();
			inUseFixTradeCaptureReport[i] = false;
		}

		inUseFixTradeCaptureReport[poolFixTradeCaptureReport.length - 1] = true;
		poolFixTradeCaptureReport[poolFixTradeCaptureReport.length - 1].setBuffer(buf, err);
		return poolFixTradeCaptureReport[poolFixTradeCaptureReport.length - 1];
	}

	public FixOrderMassStatusRequest getFixOrderMassStatusRequest(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixOrderMassStatusRequest.length - 1; i >= 0; i--)
			if (!inUseFixOrderMassStatusRequest[i]) {
				inUseFixOrderMassStatusRequest[i] = true;
				poolFixOrderMassStatusRequest[i].setBuffer(buf, err);
				return poolFixOrderMassStatusRequest[i];
			}

		boolean[] old_inUse = inUseFixOrderMassStatusRequest;
		inUseFixOrderMassStatusRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixOrderMassStatusRequest, 0, old_inUse.length);

		FixOrderMassStatusRequest[] old_pool = poolFixOrderMassStatusRequest;
		poolFixOrderMassStatusRequest = new FixOrderMassStatusRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixOrderMassStatusRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixOrderMassStatusRequest.length; i++) {
			poolFixOrderMassStatusRequest[i] = new FixOrderMassStatusRequest();
			inUseFixOrderMassStatusRequest[i] = false;
		}

		inUseFixOrderMassStatusRequest[poolFixOrderMassStatusRequest.length - 1] = true;
		poolFixOrderMassStatusRequest[poolFixOrderMassStatusRequest.length - 1].setBuffer(buf, err);
		return poolFixOrderMassStatusRequest[poolFixOrderMassStatusRequest.length - 1];
	}

	public FixQuoteRequestReject getFixQuoteRequestReject(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixQuoteRequestReject.length - 1; i >= 0; i--)
			if (!inUseFixQuoteRequestReject[i]) {
				inUseFixQuoteRequestReject[i] = true;
				poolFixQuoteRequestReject[i].setBuffer(buf, err);
				return poolFixQuoteRequestReject[i];
			}

		boolean[] old_inUse = inUseFixQuoteRequestReject;
		inUseFixQuoteRequestReject = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixQuoteRequestReject, 0, old_inUse.length);

		FixQuoteRequestReject[] old_pool = poolFixQuoteRequestReject;
		poolFixQuoteRequestReject = new FixQuoteRequestReject[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixQuoteRequestReject, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixQuoteRequestReject.length; i++) {
			poolFixQuoteRequestReject[i] = new FixQuoteRequestReject();
			inUseFixQuoteRequestReject[i] = false;
		}

		inUseFixQuoteRequestReject[poolFixQuoteRequestReject.length - 1] = true;
		poolFixQuoteRequestReject[poolFixQuoteRequestReject.length - 1].setBuffer(buf, err);
		return poolFixQuoteRequestReject[poolFixQuoteRequestReject.length - 1];
	}

	public FixRFQRequest getFixRFQRequest(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixRFQRequest.length - 1; i >= 0; i--)
			if (!inUseFixRFQRequest[i]) {
				inUseFixRFQRequest[i] = true;
				poolFixRFQRequest[i].setBuffer(buf, err);
				return poolFixRFQRequest[i];
			}

		boolean[] old_inUse = inUseFixRFQRequest;
		inUseFixRFQRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixRFQRequest, 0, old_inUse.length);

		FixRFQRequest[] old_pool = poolFixRFQRequest;
		poolFixRFQRequest = new FixRFQRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixRFQRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixRFQRequest.length; i++) {
			poolFixRFQRequest[i] = new FixRFQRequest();
			inUseFixRFQRequest[i] = false;
		}

		inUseFixRFQRequest[poolFixRFQRequest.length - 1] = true;
		poolFixRFQRequest[poolFixRFQRequest.length - 1].setBuffer(buf, err);
		return poolFixRFQRequest[poolFixRFQRequest.length - 1];
	}

	public FixQuoteStatusReport getFixQuoteStatusReport(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixQuoteStatusReport.length - 1; i >= 0; i--)
			if (!inUseFixQuoteStatusReport[i]) {
				inUseFixQuoteStatusReport[i] = true;
				poolFixQuoteStatusReport[i].setBuffer(buf, err);
				return poolFixQuoteStatusReport[i];
			}

		boolean[] old_inUse = inUseFixQuoteStatusReport;
		inUseFixQuoteStatusReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixQuoteStatusReport, 0, old_inUse.length);

		FixQuoteStatusReport[] old_pool = poolFixQuoteStatusReport;
		poolFixQuoteStatusReport = new FixQuoteStatusReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixQuoteStatusReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixQuoteStatusReport.length; i++) {
			poolFixQuoteStatusReport[i] = new FixQuoteStatusReport();
			inUseFixQuoteStatusReport[i] = false;
		}

		inUseFixQuoteStatusReport[poolFixQuoteStatusReport.length - 1] = true;
		poolFixQuoteStatusReport[poolFixQuoteStatusReport.length - 1].setBuffer(buf, err);
		return poolFixQuoteStatusReport[poolFixQuoteStatusReport.length - 1];
	}

	public FixQuoteResponse getFixQuoteResponse(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixQuoteResponse.length - 1; i >= 0; i--)
			if (!inUseFixQuoteResponse[i]) {
				inUseFixQuoteResponse[i] = true;
				poolFixQuoteResponse[i].setBuffer(buf, err);
				return poolFixQuoteResponse[i];
			}

		boolean[] old_inUse = inUseFixQuoteResponse;
		inUseFixQuoteResponse = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixQuoteResponse, 0, old_inUse.length);

		FixQuoteResponse[] old_pool = poolFixQuoteResponse;
		poolFixQuoteResponse = new FixQuoteResponse[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixQuoteResponse, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixQuoteResponse.length; i++) {
			poolFixQuoteResponse[i] = new FixQuoteResponse();
			inUseFixQuoteResponse[i] = false;
		}

		inUseFixQuoteResponse[poolFixQuoteResponse.length - 1] = true;
		poolFixQuoteResponse[poolFixQuoteResponse.length - 1].setBuffer(buf, err);
		return poolFixQuoteResponse[poolFixQuoteResponse.length - 1];
	}

	public FixConfirmation getFixConfirmation(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixConfirmation.length - 1; i >= 0; i--)
			if (!inUseFixConfirmation[i]) {
				inUseFixConfirmation[i] = true;
				poolFixConfirmation[i].setBuffer(buf, err);
				return poolFixConfirmation[i];
			}

		boolean[] old_inUse = inUseFixConfirmation;
		inUseFixConfirmation = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixConfirmation, 0, old_inUse.length);

		FixConfirmation[] old_pool = poolFixConfirmation;
		poolFixConfirmation = new FixConfirmation[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixConfirmation, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixConfirmation.length; i++) {
			poolFixConfirmation[i] = new FixConfirmation();
			inUseFixConfirmation[i] = false;
		}

		inUseFixConfirmation[poolFixConfirmation.length - 1] = true;
		poolFixConfirmation[poolFixConfirmation.length - 1].setBuffer(buf, err);
		return poolFixConfirmation[poolFixConfirmation.length - 1];
	}

	public FixPositionMaintenanceRequest getFixPositionMaintenanceRequest(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixPositionMaintenanceRequest.length - 1; i >= 0; i--)
			if (!inUseFixPositionMaintenanceRequest[i]) {
				inUseFixPositionMaintenanceRequest[i] = true;
				poolFixPositionMaintenanceRequest[i].setBuffer(buf, err);
				return poolFixPositionMaintenanceRequest[i];
			}

		boolean[] old_inUse = inUseFixPositionMaintenanceRequest;
		inUseFixPositionMaintenanceRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixPositionMaintenanceRequest, 0, old_inUse.length);

		FixPositionMaintenanceRequest[] old_pool = poolFixPositionMaintenanceRequest;
		poolFixPositionMaintenanceRequest = new FixPositionMaintenanceRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixPositionMaintenanceRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixPositionMaintenanceRequest.length; i++) {
			poolFixPositionMaintenanceRequest[i] = new FixPositionMaintenanceRequest();
			inUseFixPositionMaintenanceRequest[i] = false;
		}

		inUseFixPositionMaintenanceRequest[poolFixPositionMaintenanceRequest.length - 1] = true;
		poolFixPositionMaintenanceRequest[poolFixPositionMaintenanceRequest.length - 1].setBuffer(buf, err);
		return poolFixPositionMaintenanceRequest[poolFixPositionMaintenanceRequest.length - 1];
	}

	public FixPositionMaintenanceReport getFixPositionMaintenanceReport(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixPositionMaintenanceReport.length - 1; i >= 0; i--)
			if (!inUseFixPositionMaintenanceReport[i]) {
				inUseFixPositionMaintenanceReport[i] = true;
				poolFixPositionMaintenanceReport[i].setBuffer(buf, err);
				return poolFixPositionMaintenanceReport[i];
			}

		boolean[] old_inUse = inUseFixPositionMaintenanceReport;
		inUseFixPositionMaintenanceReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixPositionMaintenanceReport, 0, old_inUse.length);

		FixPositionMaintenanceReport[] old_pool = poolFixPositionMaintenanceReport;
		poolFixPositionMaintenanceReport = new FixPositionMaintenanceReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixPositionMaintenanceReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixPositionMaintenanceReport.length; i++) {
			poolFixPositionMaintenanceReport[i] = new FixPositionMaintenanceReport();
			inUseFixPositionMaintenanceReport[i] = false;
		}

		inUseFixPositionMaintenanceReport[poolFixPositionMaintenanceReport.length - 1] = true;
		poolFixPositionMaintenanceReport[poolFixPositionMaintenanceReport.length - 1].setBuffer(buf, err);
		return poolFixPositionMaintenanceReport[poolFixPositionMaintenanceReport.length - 1];
	}

	public FixRequestForPositions getFixRequestForPositions(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixRequestForPositions.length - 1; i >= 0; i--)
			if (!inUseFixRequestForPositions[i]) {
				inUseFixRequestForPositions[i] = true;
				poolFixRequestForPositions[i].setBuffer(buf, err);
				return poolFixRequestForPositions[i];
			}

		boolean[] old_inUse = inUseFixRequestForPositions;
		inUseFixRequestForPositions = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixRequestForPositions, 0, old_inUse.length);

		FixRequestForPositions[] old_pool = poolFixRequestForPositions;
		poolFixRequestForPositions = new FixRequestForPositions[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixRequestForPositions, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixRequestForPositions.length; i++) {
			poolFixRequestForPositions[i] = new FixRequestForPositions();
			inUseFixRequestForPositions[i] = false;
		}

		inUseFixRequestForPositions[poolFixRequestForPositions.length - 1] = true;
		poolFixRequestForPositions[poolFixRequestForPositions.length - 1].setBuffer(buf, err);
		return poolFixRequestForPositions[poolFixRequestForPositions.length - 1];
	}

	public FixRequestForPositionsAck getFixRequestForPositionsAck(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixRequestForPositionsAck.length - 1; i >= 0; i--)
			if (!inUseFixRequestForPositionsAck[i]) {
				inUseFixRequestForPositionsAck[i] = true;
				poolFixRequestForPositionsAck[i].setBuffer(buf, err);
				return poolFixRequestForPositionsAck[i];
			}

		boolean[] old_inUse = inUseFixRequestForPositionsAck;
		inUseFixRequestForPositionsAck = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixRequestForPositionsAck, 0, old_inUse.length);

		FixRequestForPositionsAck[] old_pool = poolFixRequestForPositionsAck;
		poolFixRequestForPositionsAck = new FixRequestForPositionsAck[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixRequestForPositionsAck, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixRequestForPositionsAck.length; i++) {
			poolFixRequestForPositionsAck[i] = new FixRequestForPositionsAck();
			inUseFixRequestForPositionsAck[i] = false;
		}

		inUseFixRequestForPositionsAck[poolFixRequestForPositionsAck.length - 1] = true;
		poolFixRequestForPositionsAck[poolFixRequestForPositionsAck.length - 1].setBuffer(buf, err);
		return poolFixRequestForPositionsAck[poolFixRequestForPositionsAck.length - 1];
	}

	public FixPositionReport getFixPositionReport(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixPositionReport.length - 1; i >= 0; i--)
			if (!inUseFixPositionReport[i]) {
				inUseFixPositionReport[i] = true;
				poolFixPositionReport[i].setBuffer(buf, err);
				return poolFixPositionReport[i];
			}

		boolean[] old_inUse = inUseFixPositionReport;
		inUseFixPositionReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixPositionReport, 0, old_inUse.length);

		FixPositionReport[] old_pool = poolFixPositionReport;
		poolFixPositionReport = new FixPositionReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixPositionReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixPositionReport.length; i++) {
			poolFixPositionReport[i] = new FixPositionReport();
			inUseFixPositionReport[i] = false;
		}

		inUseFixPositionReport[poolFixPositionReport.length - 1] = true;
		poolFixPositionReport[poolFixPositionReport.length - 1].setBuffer(buf, err);
		return poolFixPositionReport[poolFixPositionReport.length - 1];
	}

	public FixTradeCaptureReportRequestAck getFixTradeCaptureReportRequestAck(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixTradeCaptureReportRequestAck.length - 1; i >= 0; i--)
			if (!inUseFixTradeCaptureReportRequestAck[i]) {
				inUseFixTradeCaptureReportRequestAck[i] = true;
				poolFixTradeCaptureReportRequestAck[i].setBuffer(buf, err);
				return poolFixTradeCaptureReportRequestAck[i];
			}

		boolean[] old_inUse = inUseFixTradeCaptureReportRequestAck;
		inUseFixTradeCaptureReportRequestAck = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixTradeCaptureReportRequestAck, 0, old_inUse.length);

		FixTradeCaptureReportRequestAck[] old_pool = poolFixTradeCaptureReportRequestAck;
		poolFixTradeCaptureReportRequestAck = new FixTradeCaptureReportRequestAck[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixTradeCaptureReportRequestAck, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixTradeCaptureReportRequestAck.length; i++) {
			poolFixTradeCaptureReportRequestAck[i] = new FixTradeCaptureReportRequestAck();
			inUseFixTradeCaptureReportRequestAck[i] = false;
		}

		inUseFixTradeCaptureReportRequestAck[poolFixTradeCaptureReportRequestAck.length - 1] = true;
		poolFixTradeCaptureReportRequestAck[poolFixTradeCaptureReportRequestAck.length - 1].setBuffer(buf, err);
		return poolFixTradeCaptureReportRequestAck[poolFixTradeCaptureReportRequestAck.length - 1];
	}

	public FixTradeCaptureReportAck getFixTradeCaptureReportAck(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixTradeCaptureReportAck.length - 1; i >= 0; i--)
			if (!inUseFixTradeCaptureReportAck[i]) {
				inUseFixTradeCaptureReportAck[i] = true;
				poolFixTradeCaptureReportAck[i].setBuffer(buf, err);
				return poolFixTradeCaptureReportAck[i];
			}

		boolean[] old_inUse = inUseFixTradeCaptureReportAck;
		inUseFixTradeCaptureReportAck = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixTradeCaptureReportAck, 0, old_inUse.length);

		FixTradeCaptureReportAck[] old_pool = poolFixTradeCaptureReportAck;
		poolFixTradeCaptureReportAck = new FixTradeCaptureReportAck[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixTradeCaptureReportAck, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixTradeCaptureReportAck.length; i++) {
			poolFixTradeCaptureReportAck[i] = new FixTradeCaptureReportAck();
			inUseFixTradeCaptureReportAck[i] = false;
		}

		inUseFixTradeCaptureReportAck[poolFixTradeCaptureReportAck.length - 1] = true;
		poolFixTradeCaptureReportAck[poolFixTradeCaptureReportAck.length - 1].setBuffer(buf, err);
		return poolFixTradeCaptureReportAck[poolFixTradeCaptureReportAck.length - 1];
	}

	public FixAllocationReport getFixAllocationReport(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixAllocationReport.length - 1; i >= 0; i--)
			if (!inUseFixAllocationReport[i]) {
				inUseFixAllocationReport[i] = true;
				poolFixAllocationReport[i].setBuffer(buf, err);
				return poolFixAllocationReport[i];
			}

		boolean[] old_inUse = inUseFixAllocationReport;
		inUseFixAllocationReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixAllocationReport, 0, old_inUse.length);

		FixAllocationReport[] old_pool = poolFixAllocationReport;
		poolFixAllocationReport = new FixAllocationReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixAllocationReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixAllocationReport.length; i++) {
			poolFixAllocationReport[i] = new FixAllocationReport();
			inUseFixAllocationReport[i] = false;
		}

		inUseFixAllocationReport[poolFixAllocationReport.length - 1] = true;
		poolFixAllocationReport[poolFixAllocationReport.length - 1].setBuffer(buf, err);
		return poolFixAllocationReport[poolFixAllocationReport.length - 1];
	}

	public FixAllocationReportAck getFixAllocationReportAck(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixAllocationReportAck.length - 1; i >= 0; i--)
			if (!inUseFixAllocationReportAck[i]) {
				inUseFixAllocationReportAck[i] = true;
				poolFixAllocationReportAck[i].setBuffer(buf, err);
				return poolFixAllocationReportAck[i];
			}

		boolean[] old_inUse = inUseFixAllocationReportAck;
		inUseFixAllocationReportAck = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixAllocationReportAck, 0, old_inUse.length);

		FixAllocationReportAck[] old_pool = poolFixAllocationReportAck;
		poolFixAllocationReportAck = new FixAllocationReportAck[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixAllocationReportAck, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixAllocationReportAck.length; i++) {
			poolFixAllocationReportAck[i] = new FixAllocationReportAck();
			inUseFixAllocationReportAck[i] = false;
		}

		inUseFixAllocationReportAck[poolFixAllocationReportAck.length - 1] = true;
		poolFixAllocationReportAck[poolFixAllocationReportAck.length - 1].setBuffer(buf, err);
		return poolFixAllocationReportAck[poolFixAllocationReportAck.length - 1];
	}

	public FixConfirmation_Ack getFixConfirmation_Ack(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixConfirmation_Ack.length - 1; i >= 0; i--)
			if (!inUseFixConfirmation_Ack[i]) {
				inUseFixConfirmation_Ack[i] = true;
				poolFixConfirmation_Ack[i].setBuffer(buf, err);
				return poolFixConfirmation_Ack[i];
			}

		boolean[] old_inUse = inUseFixConfirmation_Ack;
		inUseFixConfirmation_Ack = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixConfirmation_Ack, 0, old_inUse.length);

		FixConfirmation_Ack[] old_pool = poolFixConfirmation_Ack;
		poolFixConfirmation_Ack = new FixConfirmation_Ack[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixConfirmation_Ack, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixConfirmation_Ack.length; i++) {
			poolFixConfirmation_Ack[i] = new FixConfirmation_Ack();
			inUseFixConfirmation_Ack[i] = false;
		}

		inUseFixConfirmation_Ack[poolFixConfirmation_Ack.length - 1] = true;
		poolFixConfirmation_Ack[poolFixConfirmation_Ack.length - 1].setBuffer(buf, err);
		return poolFixConfirmation_Ack[poolFixConfirmation_Ack.length - 1];
	}

	public FixSettlementInstructionRequest getFixSettlementInstructionRequest(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixSettlementInstructionRequest.length - 1; i >= 0; i--)
			if (!inUseFixSettlementInstructionRequest[i]) {
				inUseFixSettlementInstructionRequest[i] = true;
				poolFixSettlementInstructionRequest[i].setBuffer(buf, err);
				return poolFixSettlementInstructionRequest[i];
			}

		boolean[] old_inUse = inUseFixSettlementInstructionRequest;
		inUseFixSettlementInstructionRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixSettlementInstructionRequest, 0, old_inUse.length);

		FixSettlementInstructionRequest[] old_pool = poolFixSettlementInstructionRequest;
		poolFixSettlementInstructionRequest = new FixSettlementInstructionRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixSettlementInstructionRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixSettlementInstructionRequest.length; i++) {
			poolFixSettlementInstructionRequest[i] = new FixSettlementInstructionRequest();
			inUseFixSettlementInstructionRequest[i] = false;
		}

		inUseFixSettlementInstructionRequest[poolFixSettlementInstructionRequest.length - 1] = true;
		poolFixSettlementInstructionRequest[poolFixSettlementInstructionRequest.length - 1].setBuffer(buf, err);
		return poolFixSettlementInstructionRequest[poolFixSettlementInstructionRequest.length - 1];
	}

	public FixAssignmentReport getFixAssignmentReport(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixAssignmentReport.length - 1; i >= 0; i--)
			if (!inUseFixAssignmentReport[i]) {
				inUseFixAssignmentReport[i] = true;
				poolFixAssignmentReport[i].setBuffer(buf, err);
				return poolFixAssignmentReport[i];
			}

		boolean[] old_inUse = inUseFixAssignmentReport;
		inUseFixAssignmentReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixAssignmentReport, 0, old_inUse.length);

		FixAssignmentReport[] old_pool = poolFixAssignmentReport;
		poolFixAssignmentReport = new FixAssignmentReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixAssignmentReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixAssignmentReport.length; i++) {
			poolFixAssignmentReport[i] = new FixAssignmentReport();
			inUseFixAssignmentReport[i] = false;
		}

		inUseFixAssignmentReport[poolFixAssignmentReport.length - 1] = true;
		poolFixAssignmentReport[poolFixAssignmentReport.length - 1].setBuffer(buf, err);
		return poolFixAssignmentReport[poolFixAssignmentReport.length - 1];
	}

	public FixCollateralRequest getFixCollateralRequest(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixCollateralRequest.length - 1; i >= 0; i--)
			if (!inUseFixCollateralRequest[i]) {
				inUseFixCollateralRequest[i] = true;
				poolFixCollateralRequest[i].setBuffer(buf, err);
				return poolFixCollateralRequest[i];
			}

		boolean[] old_inUse = inUseFixCollateralRequest;
		inUseFixCollateralRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixCollateralRequest, 0, old_inUse.length);

		FixCollateralRequest[] old_pool = poolFixCollateralRequest;
		poolFixCollateralRequest = new FixCollateralRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixCollateralRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixCollateralRequest.length; i++) {
			poolFixCollateralRequest[i] = new FixCollateralRequest();
			inUseFixCollateralRequest[i] = false;
		}

		inUseFixCollateralRequest[poolFixCollateralRequest.length - 1] = true;
		poolFixCollateralRequest[poolFixCollateralRequest.length - 1].setBuffer(buf, err);
		return poolFixCollateralRequest[poolFixCollateralRequest.length - 1];
	}

	public FixCollateralAssignment getFixCollateralAssignment(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixCollateralAssignment.length - 1; i >= 0; i--)
			if (!inUseFixCollateralAssignment[i]) {
				inUseFixCollateralAssignment[i] = true;
				poolFixCollateralAssignment[i].setBuffer(buf, err);
				return poolFixCollateralAssignment[i];
			}

		boolean[] old_inUse = inUseFixCollateralAssignment;
		inUseFixCollateralAssignment = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixCollateralAssignment, 0, old_inUse.length);

		FixCollateralAssignment[] old_pool = poolFixCollateralAssignment;
		poolFixCollateralAssignment = new FixCollateralAssignment[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixCollateralAssignment, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixCollateralAssignment.length; i++) {
			poolFixCollateralAssignment[i] = new FixCollateralAssignment();
			inUseFixCollateralAssignment[i] = false;
		}

		inUseFixCollateralAssignment[poolFixCollateralAssignment.length - 1] = true;
		poolFixCollateralAssignment[poolFixCollateralAssignment.length - 1].setBuffer(buf, err);
		return poolFixCollateralAssignment[poolFixCollateralAssignment.length - 1];
	}

	public FixCollateralResponse getFixCollateralResponse(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixCollateralResponse.length - 1; i >= 0; i--)
			if (!inUseFixCollateralResponse[i]) {
				inUseFixCollateralResponse[i] = true;
				poolFixCollateralResponse[i].setBuffer(buf, err);
				return poolFixCollateralResponse[i];
			}

		boolean[] old_inUse = inUseFixCollateralResponse;
		inUseFixCollateralResponse = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixCollateralResponse, 0, old_inUse.length);

		FixCollateralResponse[] old_pool = poolFixCollateralResponse;
		poolFixCollateralResponse = new FixCollateralResponse[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixCollateralResponse, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixCollateralResponse.length; i++) {
			poolFixCollateralResponse[i] = new FixCollateralResponse();
			inUseFixCollateralResponse[i] = false;
		}

		inUseFixCollateralResponse[poolFixCollateralResponse.length - 1] = true;
		poolFixCollateralResponse[poolFixCollateralResponse.length - 1].setBuffer(buf, err);
		return poolFixCollateralResponse[poolFixCollateralResponse.length - 1];
	}

	public FixCollateralReport getFixCollateralReport(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixCollateralReport.length - 1; i >= 0; i--)
			if (!inUseFixCollateralReport[i]) {
				inUseFixCollateralReport[i] = true;
				poolFixCollateralReport[i].setBuffer(buf, err);
				return poolFixCollateralReport[i];
			}

		boolean[] old_inUse = inUseFixCollateralReport;
		inUseFixCollateralReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixCollateralReport, 0, old_inUse.length);

		FixCollateralReport[] old_pool = poolFixCollateralReport;
		poolFixCollateralReport = new FixCollateralReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixCollateralReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixCollateralReport.length; i++) {
			poolFixCollateralReport[i] = new FixCollateralReport();
			inUseFixCollateralReport[i] = false;
		}

		inUseFixCollateralReport[poolFixCollateralReport.length - 1] = true;
		poolFixCollateralReport[poolFixCollateralReport.length - 1].setBuffer(buf, err);
		return poolFixCollateralReport[poolFixCollateralReport.length - 1];
	}

	public FixCollateralInquiry getFixCollateralInquiry(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixCollateralInquiry.length - 1; i >= 0; i--)
			if (!inUseFixCollateralInquiry[i]) {
				inUseFixCollateralInquiry[i] = true;
				poolFixCollateralInquiry[i].setBuffer(buf, err);
				return poolFixCollateralInquiry[i];
			}

		boolean[] old_inUse = inUseFixCollateralInquiry;
		inUseFixCollateralInquiry = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixCollateralInquiry, 0, old_inUse.length);

		FixCollateralInquiry[] old_pool = poolFixCollateralInquiry;
		poolFixCollateralInquiry = new FixCollateralInquiry[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixCollateralInquiry, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixCollateralInquiry.length; i++) {
			poolFixCollateralInquiry[i] = new FixCollateralInquiry();
			inUseFixCollateralInquiry[i] = false;
		}

		inUseFixCollateralInquiry[poolFixCollateralInquiry.length - 1] = true;
		poolFixCollateralInquiry[poolFixCollateralInquiry.length - 1].setBuffer(buf, err);
		return poolFixCollateralInquiry[poolFixCollateralInquiry.length - 1];
	}

	public FixNetworkCounterpartySystemStatusRequest getFixNetworkCounterpartySystemStatusRequest(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixNetworkCounterpartySystemStatusRequest.length - 1; i >= 0; i--)
			if (!inUseFixNetworkCounterpartySystemStatusRequest[i]) {
				inUseFixNetworkCounterpartySystemStatusRequest[i] = true;
				poolFixNetworkCounterpartySystemStatusRequest[i].setBuffer(buf, err);
				return poolFixNetworkCounterpartySystemStatusRequest[i];
			}

		boolean[] old_inUse = inUseFixNetworkCounterpartySystemStatusRequest;
		inUseFixNetworkCounterpartySystemStatusRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixNetworkCounterpartySystemStatusRequest, 0, old_inUse.length);

		FixNetworkCounterpartySystemStatusRequest[] old_pool = poolFixNetworkCounterpartySystemStatusRequest;
		poolFixNetworkCounterpartySystemStatusRequest = new FixNetworkCounterpartySystemStatusRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixNetworkCounterpartySystemStatusRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixNetworkCounterpartySystemStatusRequest.length; i++) {
			poolFixNetworkCounterpartySystemStatusRequest[i] = new FixNetworkCounterpartySystemStatusRequest();
			inUseFixNetworkCounterpartySystemStatusRequest[i] = false;
		}

		inUseFixNetworkCounterpartySystemStatusRequest[poolFixNetworkCounterpartySystemStatusRequest.length - 1] = true;
		poolFixNetworkCounterpartySystemStatusRequest[poolFixNetworkCounterpartySystemStatusRequest.length - 1].setBuffer(buf, err);
		return poolFixNetworkCounterpartySystemStatusRequest[poolFixNetworkCounterpartySystemStatusRequest.length - 1];
	}

	public FixNetworkCounterpartySystemStatusResponse getFixNetworkCounterpartySystemStatusResponse(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixNetworkCounterpartySystemStatusResponse.length - 1; i >= 0; i--)
			if (!inUseFixNetworkCounterpartySystemStatusResponse[i]) {
				inUseFixNetworkCounterpartySystemStatusResponse[i] = true;
				poolFixNetworkCounterpartySystemStatusResponse[i].setBuffer(buf, err);
				return poolFixNetworkCounterpartySystemStatusResponse[i];
			}

		boolean[] old_inUse = inUseFixNetworkCounterpartySystemStatusResponse;
		inUseFixNetworkCounterpartySystemStatusResponse = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixNetworkCounterpartySystemStatusResponse, 0, old_inUse.length);

		FixNetworkCounterpartySystemStatusResponse[] old_pool = poolFixNetworkCounterpartySystemStatusResponse;
		poolFixNetworkCounterpartySystemStatusResponse = new FixNetworkCounterpartySystemStatusResponse[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixNetworkCounterpartySystemStatusResponse, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixNetworkCounterpartySystemStatusResponse.length; i++) {
			poolFixNetworkCounterpartySystemStatusResponse[i] = new FixNetworkCounterpartySystemStatusResponse();
			inUseFixNetworkCounterpartySystemStatusResponse[i] = false;
		}

		inUseFixNetworkCounterpartySystemStatusResponse[poolFixNetworkCounterpartySystemStatusResponse.length - 1] = true;
		poolFixNetworkCounterpartySystemStatusResponse[poolFixNetworkCounterpartySystemStatusResponse.length - 1].setBuffer(buf, err);
		return poolFixNetworkCounterpartySystemStatusResponse[poolFixNetworkCounterpartySystemStatusResponse.length - 1];
	}

	public FixUserRequest getFixUserRequest(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixUserRequest.length - 1; i >= 0; i--)
			if (!inUseFixUserRequest[i]) {
				inUseFixUserRequest[i] = true;
				poolFixUserRequest[i].setBuffer(buf, err);
				return poolFixUserRequest[i];
			}

		boolean[] old_inUse = inUseFixUserRequest;
		inUseFixUserRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixUserRequest, 0, old_inUse.length);

		FixUserRequest[] old_pool = poolFixUserRequest;
		poolFixUserRequest = new FixUserRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixUserRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixUserRequest.length; i++) {
			poolFixUserRequest[i] = new FixUserRequest();
			inUseFixUserRequest[i] = false;
		}

		inUseFixUserRequest[poolFixUserRequest.length - 1] = true;
		poolFixUserRequest[poolFixUserRequest.length - 1].setBuffer(buf, err);
		return poolFixUserRequest[poolFixUserRequest.length - 1];
	}

	public FixUserResponse getFixUserResponse(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixUserResponse.length - 1; i >= 0; i--)
			if (!inUseFixUserResponse[i]) {
				inUseFixUserResponse[i] = true;
				poolFixUserResponse[i].setBuffer(buf, err);
				return poolFixUserResponse[i];
			}

		boolean[] old_inUse = inUseFixUserResponse;
		inUseFixUserResponse = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixUserResponse, 0, old_inUse.length);

		FixUserResponse[] old_pool = poolFixUserResponse;
		poolFixUserResponse = new FixUserResponse[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixUserResponse, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixUserResponse.length; i++) {
			poolFixUserResponse[i] = new FixUserResponse();
			inUseFixUserResponse[i] = false;
		}

		inUseFixUserResponse[poolFixUserResponse.length - 1] = true;
		poolFixUserResponse[poolFixUserResponse.length - 1].setBuffer(buf, err);
		return poolFixUserResponse[poolFixUserResponse.length - 1];
	}

	public FixCollateralInquiryAck getFixCollateralInquiryAck(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixCollateralInquiryAck.length - 1; i >= 0; i--)
			if (!inUseFixCollateralInquiryAck[i]) {
				inUseFixCollateralInquiryAck[i] = true;
				poolFixCollateralInquiryAck[i].setBuffer(buf, err);
				return poolFixCollateralInquiryAck[i];
			}

		boolean[] old_inUse = inUseFixCollateralInquiryAck;
		inUseFixCollateralInquiryAck = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixCollateralInquiryAck, 0, old_inUse.length);

		FixCollateralInquiryAck[] old_pool = poolFixCollateralInquiryAck;
		poolFixCollateralInquiryAck = new FixCollateralInquiryAck[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixCollateralInquiryAck, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixCollateralInquiryAck.length; i++) {
			poolFixCollateralInquiryAck[i] = new FixCollateralInquiryAck();
			inUseFixCollateralInquiryAck[i] = false;
		}

		inUseFixCollateralInquiryAck[poolFixCollateralInquiryAck.length - 1] = true;
		poolFixCollateralInquiryAck[poolFixCollateralInquiryAck.length - 1].setBuffer(buf, err);
		return poolFixCollateralInquiryAck[poolFixCollateralInquiryAck.length - 1];
	}

	public FixConfirmationRequest getFixConfirmationRequest(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixConfirmationRequest.length - 1; i >= 0; i--)
			if (!inUseFixConfirmationRequest[i]) {
				inUseFixConfirmationRequest[i] = true;
				poolFixConfirmationRequest[i].setBuffer(buf, err);
				return poolFixConfirmationRequest[i];
			}

		boolean[] old_inUse = inUseFixConfirmationRequest;
		inUseFixConfirmationRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixConfirmationRequest, 0, old_inUse.length);

		FixConfirmationRequest[] old_pool = poolFixConfirmationRequest;
		poolFixConfirmationRequest = new FixConfirmationRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixConfirmationRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixConfirmationRequest.length; i++) {
			poolFixConfirmationRequest[i] = new FixConfirmationRequest();
			inUseFixConfirmationRequest[i] = false;
		}

		inUseFixConfirmationRequest[poolFixConfirmationRequest.length - 1] = true;
		poolFixConfirmationRequest[poolFixConfirmationRequest.length - 1].setBuffer(buf, err);
		return poolFixConfirmationRequest[poolFixConfirmationRequest.length - 1];
	}

	public FixContraryIntentionReport getFixContraryIntentionReport(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixContraryIntentionReport.length - 1; i >= 0; i--)
			if (!inUseFixContraryIntentionReport[i]) {
				inUseFixContraryIntentionReport[i] = true;
				poolFixContraryIntentionReport[i].setBuffer(buf, err);
				return poolFixContraryIntentionReport[i];
			}

		boolean[] old_inUse = inUseFixContraryIntentionReport;
		inUseFixContraryIntentionReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixContraryIntentionReport, 0, old_inUse.length);

		FixContraryIntentionReport[] old_pool = poolFixContraryIntentionReport;
		poolFixContraryIntentionReport = new FixContraryIntentionReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixContraryIntentionReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixContraryIntentionReport.length; i++) {
			poolFixContraryIntentionReport[i] = new FixContraryIntentionReport();
			inUseFixContraryIntentionReport[i] = false;
		}

		inUseFixContraryIntentionReport[poolFixContraryIntentionReport.length - 1] = true;
		poolFixContraryIntentionReport[poolFixContraryIntentionReport.length - 1].setBuffer(buf, err);
		return poolFixContraryIntentionReport[poolFixContraryIntentionReport.length - 1];
	}

	public FixSecurityDefinitionUpdateReport getFixSecurityDefinitionUpdateReport(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixSecurityDefinitionUpdateReport.length - 1; i >= 0; i--)
			if (!inUseFixSecurityDefinitionUpdateReport[i]) {
				inUseFixSecurityDefinitionUpdateReport[i] = true;
				poolFixSecurityDefinitionUpdateReport[i].setBuffer(buf, err);
				return poolFixSecurityDefinitionUpdateReport[i];
			}

		boolean[] old_inUse = inUseFixSecurityDefinitionUpdateReport;
		inUseFixSecurityDefinitionUpdateReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixSecurityDefinitionUpdateReport, 0, old_inUse.length);

		FixSecurityDefinitionUpdateReport[] old_pool = poolFixSecurityDefinitionUpdateReport;
		poolFixSecurityDefinitionUpdateReport = new FixSecurityDefinitionUpdateReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixSecurityDefinitionUpdateReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixSecurityDefinitionUpdateReport.length; i++) {
			poolFixSecurityDefinitionUpdateReport[i] = new FixSecurityDefinitionUpdateReport();
			inUseFixSecurityDefinitionUpdateReport[i] = false;
		}

		inUseFixSecurityDefinitionUpdateReport[poolFixSecurityDefinitionUpdateReport.length - 1] = true;
		poolFixSecurityDefinitionUpdateReport[poolFixSecurityDefinitionUpdateReport.length - 1].setBuffer(buf, err);
		return poolFixSecurityDefinitionUpdateReport[poolFixSecurityDefinitionUpdateReport.length - 1];
	}

	public FixSecurityListUpdateReport getFixSecurityListUpdateReport(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixSecurityListUpdateReport.length - 1; i >= 0; i--)
			if (!inUseFixSecurityListUpdateReport[i]) {
				inUseFixSecurityListUpdateReport[i] = true;
				poolFixSecurityListUpdateReport[i].setBuffer(buf, err);
				return poolFixSecurityListUpdateReport[i];
			}

		boolean[] old_inUse = inUseFixSecurityListUpdateReport;
		inUseFixSecurityListUpdateReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixSecurityListUpdateReport, 0, old_inUse.length);

		FixSecurityListUpdateReport[] old_pool = poolFixSecurityListUpdateReport;
		poolFixSecurityListUpdateReport = new FixSecurityListUpdateReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixSecurityListUpdateReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixSecurityListUpdateReport.length; i++) {
			poolFixSecurityListUpdateReport[i] = new FixSecurityListUpdateReport();
			inUseFixSecurityListUpdateReport[i] = false;
		}

		inUseFixSecurityListUpdateReport[poolFixSecurityListUpdateReport.length - 1] = true;
		poolFixSecurityListUpdateReport[poolFixSecurityListUpdateReport.length - 1].setBuffer(buf, err);
		return poolFixSecurityListUpdateReport[poolFixSecurityListUpdateReport.length - 1];
	}

	public FixAdjustedPositionReport getFixAdjustedPositionReport(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixAdjustedPositionReport.length - 1; i >= 0; i--)
			if (!inUseFixAdjustedPositionReport[i]) {
				inUseFixAdjustedPositionReport[i] = true;
				poolFixAdjustedPositionReport[i].setBuffer(buf, err);
				return poolFixAdjustedPositionReport[i];
			}

		boolean[] old_inUse = inUseFixAdjustedPositionReport;
		inUseFixAdjustedPositionReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixAdjustedPositionReport, 0, old_inUse.length);

		FixAdjustedPositionReport[] old_pool = poolFixAdjustedPositionReport;
		poolFixAdjustedPositionReport = new FixAdjustedPositionReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixAdjustedPositionReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixAdjustedPositionReport.length; i++) {
			poolFixAdjustedPositionReport[i] = new FixAdjustedPositionReport();
			inUseFixAdjustedPositionReport[i] = false;
		}

		inUseFixAdjustedPositionReport[poolFixAdjustedPositionReport.length - 1] = true;
		poolFixAdjustedPositionReport[poolFixAdjustedPositionReport.length - 1].setBuffer(buf, err);
		return poolFixAdjustedPositionReport[poolFixAdjustedPositionReport.length - 1];
	}

	public FixAllocationInstructionAlert getFixAllocationInstructionAlert(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixAllocationInstructionAlert.length - 1; i >= 0; i--)
			if (!inUseFixAllocationInstructionAlert[i]) {
				inUseFixAllocationInstructionAlert[i] = true;
				poolFixAllocationInstructionAlert[i].setBuffer(buf, err);
				return poolFixAllocationInstructionAlert[i];
			}

		boolean[] old_inUse = inUseFixAllocationInstructionAlert;
		inUseFixAllocationInstructionAlert = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixAllocationInstructionAlert, 0, old_inUse.length);

		FixAllocationInstructionAlert[] old_pool = poolFixAllocationInstructionAlert;
		poolFixAllocationInstructionAlert = new FixAllocationInstructionAlert[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixAllocationInstructionAlert, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixAllocationInstructionAlert.length; i++) {
			poolFixAllocationInstructionAlert[i] = new FixAllocationInstructionAlert();
			inUseFixAllocationInstructionAlert[i] = false;
		}

		inUseFixAllocationInstructionAlert[poolFixAllocationInstructionAlert.length - 1] = true;
		poolFixAllocationInstructionAlert[poolFixAllocationInstructionAlert.length - 1].setBuffer(buf, err);
		return poolFixAllocationInstructionAlert[poolFixAllocationInstructionAlert.length - 1];
	}

	public FixExecutionAcknowledgement getFixExecutionAcknowledgement(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixExecutionAcknowledgement.length - 1; i >= 0; i--)
			if (!inUseFixExecutionAcknowledgement[i]) {
				inUseFixExecutionAcknowledgement[i] = true;
				poolFixExecutionAcknowledgement[i].setBuffer(buf, err);
				return poolFixExecutionAcknowledgement[i];
			}

		boolean[] old_inUse = inUseFixExecutionAcknowledgement;
		inUseFixExecutionAcknowledgement = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixExecutionAcknowledgement, 0, old_inUse.length);

		FixExecutionAcknowledgement[] old_pool = poolFixExecutionAcknowledgement;
		poolFixExecutionAcknowledgement = new FixExecutionAcknowledgement[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixExecutionAcknowledgement, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixExecutionAcknowledgement.length; i++) {
			poolFixExecutionAcknowledgement[i] = new FixExecutionAcknowledgement();
			inUseFixExecutionAcknowledgement[i] = false;
		}

		inUseFixExecutionAcknowledgement[poolFixExecutionAcknowledgement.length - 1] = true;
		poolFixExecutionAcknowledgement[poolFixExecutionAcknowledgement.length - 1].setBuffer(buf, err);
		return poolFixExecutionAcknowledgement[poolFixExecutionAcknowledgement.length - 1];
	}

	public FixTradingSessionList getFixTradingSessionList(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixTradingSessionList.length - 1; i >= 0; i--)
			if (!inUseFixTradingSessionList[i]) {
				inUseFixTradingSessionList[i] = true;
				poolFixTradingSessionList[i].setBuffer(buf, err);
				return poolFixTradingSessionList[i];
			}

		boolean[] old_inUse = inUseFixTradingSessionList;
		inUseFixTradingSessionList = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixTradingSessionList, 0, old_inUse.length);

		FixTradingSessionList[] old_pool = poolFixTradingSessionList;
		poolFixTradingSessionList = new FixTradingSessionList[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixTradingSessionList, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixTradingSessionList.length; i++) {
			poolFixTradingSessionList[i] = new FixTradingSessionList();
			inUseFixTradingSessionList[i] = false;
		}

		inUseFixTradingSessionList[poolFixTradingSessionList.length - 1] = true;
		poolFixTradingSessionList[poolFixTradingSessionList.length - 1].setBuffer(buf, err);
		return poolFixTradingSessionList[poolFixTradingSessionList.length - 1];
	}

	public FixTradingSessionListRequest getFixTradingSessionListRequest(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixTradingSessionListRequest.length - 1; i >= 0; i--)
			if (!inUseFixTradingSessionListRequest[i]) {
				inUseFixTradingSessionListRequest[i] = true;
				poolFixTradingSessionListRequest[i].setBuffer(buf, err);
				return poolFixTradingSessionListRequest[i];
			}

		boolean[] old_inUse = inUseFixTradingSessionListRequest;
		inUseFixTradingSessionListRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixTradingSessionListRequest, 0, old_inUse.length);

		FixTradingSessionListRequest[] old_pool = poolFixTradingSessionListRequest;
		poolFixTradingSessionListRequest = new FixTradingSessionListRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixTradingSessionListRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixTradingSessionListRequest.length; i++) {
			poolFixTradingSessionListRequest[i] = new FixTradingSessionListRequest();
			inUseFixTradingSessionListRequest[i] = false;
		}

		inUseFixTradingSessionListRequest[poolFixTradingSessionListRequest.length - 1] = true;
		poolFixTradingSessionListRequest[poolFixTradingSessionListRequest.length - 1].setBuffer(buf, err);
		return poolFixTradingSessionListRequest[poolFixTradingSessionListRequest.length - 1];
	}

	public FixSettlementObligationReport getFixSettlementObligationReport(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixSettlementObligationReport.length - 1; i >= 0; i--)
			if (!inUseFixSettlementObligationReport[i]) {
				inUseFixSettlementObligationReport[i] = true;
				poolFixSettlementObligationReport[i].setBuffer(buf, err);
				return poolFixSettlementObligationReport[i];
			}

		boolean[] old_inUse = inUseFixSettlementObligationReport;
		inUseFixSettlementObligationReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixSettlementObligationReport, 0, old_inUse.length);

		FixSettlementObligationReport[] old_pool = poolFixSettlementObligationReport;
		poolFixSettlementObligationReport = new FixSettlementObligationReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixSettlementObligationReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixSettlementObligationReport.length; i++) {
			poolFixSettlementObligationReport[i] = new FixSettlementObligationReport();
			inUseFixSettlementObligationReport[i] = false;
		}

		inUseFixSettlementObligationReport[poolFixSettlementObligationReport.length - 1] = true;
		poolFixSettlementObligationReport[poolFixSettlementObligationReport.length - 1].setBuffer(buf, err);
		return poolFixSettlementObligationReport[poolFixSettlementObligationReport.length - 1];
	}

	public FixDerivativeSecurityListUpdateReport getFixDerivativeSecurityListUpdateReport(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixDerivativeSecurityListUpdateReport.length - 1; i >= 0; i--)
			if (!inUseFixDerivativeSecurityListUpdateReport[i]) {
				inUseFixDerivativeSecurityListUpdateReport[i] = true;
				poolFixDerivativeSecurityListUpdateReport[i].setBuffer(buf, err);
				return poolFixDerivativeSecurityListUpdateReport[i];
			}

		boolean[] old_inUse = inUseFixDerivativeSecurityListUpdateReport;
		inUseFixDerivativeSecurityListUpdateReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixDerivativeSecurityListUpdateReport, 0, old_inUse.length);

		FixDerivativeSecurityListUpdateReport[] old_pool = poolFixDerivativeSecurityListUpdateReport;
		poolFixDerivativeSecurityListUpdateReport = new FixDerivativeSecurityListUpdateReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixDerivativeSecurityListUpdateReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixDerivativeSecurityListUpdateReport.length; i++) {
			poolFixDerivativeSecurityListUpdateReport[i] = new FixDerivativeSecurityListUpdateReport();
			inUseFixDerivativeSecurityListUpdateReport[i] = false;
		}

		inUseFixDerivativeSecurityListUpdateReport[poolFixDerivativeSecurityListUpdateReport.length - 1] = true;
		poolFixDerivativeSecurityListUpdateReport[poolFixDerivativeSecurityListUpdateReport.length - 1].setBuffer(buf, err);
		return poolFixDerivativeSecurityListUpdateReport[poolFixDerivativeSecurityListUpdateReport.length - 1];
	}

	public FixTradingSessionListUpdateReport getFixTradingSessionListUpdateReport(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixTradingSessionListUpdateReport.length - 1; i >= 0; i--)
			if (!inUseFixTradingSessionListUpdateReport[i]) {
				inUseFixTradingSessionListUpdateReport[i] = true;
				poolFixTradingSessionListUpdateReport[i].setBuffer(buf, err);
				return poolFixTradingSessionListUpdateReport[i];
			}

		boolean[] old_inUse = inUseFixTradingSessionListUpdateReport;
		inUseFixTradingSessionListUpdateReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixTradingSessionListUpdateReport, 0, old_inUse.length);

		FixTradingSessionListUpdateReport[] old_pool = poolFixTradingSessionListUpdateReport;
		poolFixTradingSessionListUpdateReport = new FixTradingSessionListUpdateReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixTradingSessionListUpdateReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixTradingSessionListUpdateReport.length; i++) {
			poolFixTradingSessionListUpdateReport[i] = new FixTradingSessionListUpdateReport();
			inUseFixTradingSessionListUpdateReport[i] = false;
		}

		inUseFixTradingSessionListUpdateReport[poolFixTradingSessionListUpdateReport.length - 1] = true;
		poolFixTradingSessionListUpdateReport[poolFixTradingSessionListUpdateReport.length - 1].setBuffer(buf, err);
		return poolFixTradingSessionListUpdateReport[poolFixTradingSessionListUpdateReport.length - 1];
	}

	public FixMarketDefinitionRequest getFixMarketDefinitionRequest(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixMarketDefinitionRequest.length - 1; i >= 0; i--)
			if (!inUseFixMarketDefinitionRequest[i]) {
				inUseFixMarketDefinitionRequest[i] = true;
				poolFixMarketDefinitionRequest[i].setBuffer(buf, err);
				return poolFixMarketDefinitionRequest[i];
			}

		boolean[] old_inUse = inUseFixMarketDefinitionRequest;
		inUseFixMarketDefinitionRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixMarketDefinitionRequest, 0, old_inUse.length);

		FixMarketDefinitionRequest[] old_pool = poolFixMarketDefinitionRequest;
		poolFixMarketDefinitionRequest = new FixMarketDefinitionRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixMarketDefinitionRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixMarketDefinitionRequest.length; i++) {
			poolFixMarketDefinitionRequest[i] = new FixMarketDefinitionRequest();
			inUseFixMarketDefinitionRequest[i] = false;
		}

		inUseFixMarketDefinitionRequest[poolFixMarketDefinitionRequest.length - 1] = true;
		poolFixMarketDefinitionRequest[poolFixMarketDefinitionRequest.length - 1].setBuffer(buf, err);
		return poolFixMarketDefinitionRequest[poolFixMarketDefinitionRequest.length - 1];
	}

	public FixMarketDefinition getFixMarketDefinition(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixMarketDefinition.length - 1; i >= 0; i--)
			if (!inUseFixMarketDefinition[i]) {
				inUseFixMarketDefinition[i] = true;
				poolFixMarketDefinition[i].setBuffer(buf, err);
				return poolFixMarketDefinition[i];
			}

		boolean[] old_inUse = inUseFixMarketDefinition;
		inUseFixMarketDefinition = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixMarketDefinition, 0, old_inUse.length);

		FixMarketDefinition[] old_pool = poolFixMarketDefinition;
		poolFixMarketDefinition = new FixMarketDefinition[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixMarketDefinition, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixMarketDefinition.length; i++) {
			poolFixMarketDefinition[i] = new FixMarketDefinition();
			inUseFixMarketDefinition[i] = false;
		}

		inUseFixMarketDefinition[poolFixMarketDefinition.length - 1] = true;
		poolFixMarketDefinition[poolFixMarketDefinition.length - 1].setBuffer(buf, err);
		return poolFixMarketDefinition[poolFixMarketDefinition.length - 1];
	}

	public FixMarketDefinitionUpdateReport getFixMarketDefinitionUpdateReport(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixMarketDefinitionUpdateReport.length - 1; i >= 0; i--)
			if (!inUseFixMarketDefinitionUpdateReport[i]) {
				inUseFixMarketDefinitionUpdateReport[i] = true;
				poolFixMarketDefinitionUpdateReport[i].setBuffer(buf, err);
				return poolFixMarketDefinitionUpdateReport[i];
			}

		boolean[] old_inUse = inUseFixMarketDefinitionUpdateReport;
		inUseFixMarketDefinitionUpdateReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixMarketDefinitionUpdateReport, 0, old_inUse.length);

		FixMarketDefinitionUpdateReport[] old_pool = poolFixMarketDefinitionUpdateReport;
		poolFixMarketDefinitionUpdateReport = new FixMarketDefinitionUpdateReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixMarketDefinitionUpdateReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixMarketDefinitionUpdateReport.length; i++) {
			poolFixMarketDefinitionUpdateReport[i] = new FixMarketDefinitionUpdateReport();
			inUseFixMarketDefinitionUpdateReport[i] = false;
		}

		inUseFixMarketDefinitionUpdateReport[poolFixMarketDefinitionUpdateReport.length - 1] = true;
		poolFixMarketDefinitionUpdateReport[poolFixMarketDefinitionUpdateReport.length - 1].setBuffer(buf, err);
		return poolFixMarketDefinitionUpdateReport[poolFixMarketDefinitionUpdateReport.length - 1];
	}

	public FixUserNotification getFixUserNotification(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixUserNotification.length - 1; i >= 0; i--)
			if (!inUseFixUserNotification[i]) {
				inUseFixUserNotification[i] = true;
				poolFixUserNotification[i].setBuffer(buf, err);
				return poolFixUserNotification[i];
			}

		boolean[] old_inUse = inUseFixUserNotification;
		inUseFixUserNotification = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixUserNotification, 0, old_inUse.length);

		FixUserNotification[] old_pool = poolFixUserNotification;
		poolFixUserNotification = new FixUserNotification[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixUserNotification, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixUserNotification.length; i++) {
			poolFixUserNotification[i] = new FixUserNotification();
			inUseFixUserNotification[i] = false;
		}

		inUseFixUserNotification[poolFixUserNotification.length - 1] = true;
		poolFixUserNotification[poolFixUserNotification.length - 1].setBuffer(buf, err);
		return poolFixUserNotification[poolFixUserNotification.length - 1];
	}

	public FixOrderMassActionReport getFixOrderMassActionReport(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixOrderMassActionReport.length - 1; i >= 0; i--)
			if (!inUseFixOrderMassActionReport[i]) {
				inUseFixOrderMassActionReport[i] = true;
				poolFixOrderMassActionReport[i].setBuffer(buf, err);
				return poolFixOrderMassActionReport[i];
			}

		boolean[] old_inUse = inUseFixOrderMassActionReport;
		inUseFixOrderMassActionReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixOrderMassActionReport, 0, old_inUse.length);

		FixOrderMassActionReport[] old_pool = poolFixOrderMassActionReport;
		poolFixOrderMassActionReport = new FixOrderMassActionReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixOrderMassActionReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixOrderMassActionReport.length; i++) {
			poolFixOrderMassActionReport[i] = new FixOrderMassActionReport();
			inUseFixOrderMassActionReport[i] = false;
		}

		inUseFixOrderMassActionReport[poolFixOrderMassActionReport.length - 1] = true;
		poolFixOrderMassActionReport[poolFixOrderMassActionReport.length - 1].setBuffer(buf, err);
		return poolFixOrderMassActionReport[poolFixOrderMassActionReport.length - 1];
	}

	public FixOrderMassActionRequest getFixOrderMassActionRequest(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixOrderMassActionRequest.length - 1; i >= 0; i--)
			if (!inUseFixOrderMassActionRequest[i]) {
				inUseFixOrderMassActionRequest[i] = true;
				poolFixOrderMassActionRequest[i].setBuffer(buf, err);
				return poolFixOrderMassActionRequest[i];
			}

		boolean[] old_inUse = inUseFixOrderMassActionRequest;
		inUseFixOrderMassActionRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixOrderMassActionRequest, 0, old_inUse.length);

		FixOrderMassActionRequest[] old_pool = poolFixOrderMassActionRequest;
		poolFixOrderMassActionRequest = new FixOrderMassActionRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixOrderMassActionRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixOrderMassActionRequest.length; i++) {
			poolFixOrderMassActionRequest[i] = new FixOrderMassActionRequest();
			inUseFixOrderMassActionRequest[i] = false;
		}

		inUseFixOrderMassActionRequest[poolFixOrderMassActionRequest.length - 1] = true;
		poolFixOrderMassActionRequest[poolFixOrderMassActionRequest.length - 1].setBuffer(buf, err);
		return poolFixOrderMassActionRequest[poolFixOrderMassActionRequest.length - 1];
	}

	public FixApplicationMessageRequest getFixApplicationMessageRequest(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixApplicationMessageRequest.length - 1; i >= 0; i--)
			if (!inUseFixApplicationMessageRequest[i]) {
				inUseFixApplicationMessageRequest[i] = true;
				poolFixApplicationMessageRequest[i].setBuffer(buf, err);
				return poolFixApplicationMessageRequest[i];
			}

		boolean[] old_inUse = inUseFixApplicationMessageRequest;
		inUseFixApplicationMessageRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixApplicationMessageRequest, 0, old_inUse.length);

		FixApplicationMessageRequest[] old_pool = poolFixApplicationMessageRequest;
		poolFixApplicationMessageRequest = new FixApplicationMessageRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixApplicationMessageRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixApplicationMessageRequest.length; i++) {
			poolFixApplicationMessageRequest[i] = new FixApplicationMessageRequest();
			inUseFixApplicationMessageRequest[i] = false;
		}

		inUseFixApplicationMessageRequest[poolFixApplicationMessageRequest.length - 1] = true;
		poolFixApplicationMessageRequest[poolFixApplicationMessageRequest.length - 1].setBuffer(buf, err);
		return poolFixApplicationMessageRequest[poolFixApplicationMessageRequest.length - 1];
	}

	public FixApplicationMessageRequestAck getFixApplicationMessageRequestAck(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixApplicationMessageRequestAck.length - 1; i >= 0; i--)
			if (!inUseFixApplicationMessageRequestAck[i]) {
				inUseFixApplicationMessageRequestAck[i] = true;
				poolFixApplicationMessageRequestAck[i].setBuffer(buf, err);
				return poolFixApplicationMessageRequestAck[i];
			}

		boolean[] old_inUse = inUseFixApplicationMessageRequestAck;
		inUseFixApplicationMessageRequestAck = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixApplicationMessageRequestAck, 0, old_inUse.length);

		FixApplicationMessageRequestAck[] old_pool = poolFixApplicationMessageRequestAck;
		poolFixApplicationMessageRequestAck = new FixApplicationMessageRequestAck[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixApplicationMessageRequestAck, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixApplicationMessageRequestAck.length; i++) {
			poolFixApplicationMessageRequestAck[i] = new FixApplicationMessageRequestAck();
			inUseFixApplicationMessageRequestAck[i] = false;
		}

		inUseFixApplicationMessageRequestAck[poolFixApplicationMessageRequestAck.length - 1] = true;
		poolFixApplicationMessageRequestAck[poolFixApplicationMessageRequestAck.length - 1].setBuffer(buf, err);
		return poolFixApplicationMessageRequestAck[poolFixApplicationMessageRequestAck.length - 1];
	}

	public FixApplicationMessageReport getFixApplicationMessageReport(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixApplicationMessageReport.length - 1; i >= 0; i--)
			if (!inUseFixApplicationMessageReport[i]) {
				inUseFixApplicationMessageReport[i] = true;
				poolFixApplicationMessageReport[i].setBuffer(buf, err);
				return poolFixApplicationMessageReport[i];
			}

		boolean[] old_inUse = inUseFixApplicationMessageReport;
		inUseFixApplicationMessageReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixApplicationMessageReport, 0, old_inUse.length);

		FixApplicationMessageReport[] old_pool = poolFixApplicationMessageReport;
		poolFixApplicationMessageReport = new FixApplicationMessageReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixApplicationMessageReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixApplicationMessageReport.length; i++) {
			poolFixApplicationMessageReport[i] = new FixApplicationMessageReport();
			inUseFixApplicationMessageReport[i] = false;
		}

		inUseFixApplicationMessageReport[poolFixApplicationMessageReport.length - 1] = true;
		poolFixApplicationMessageReport[poolFixApplicationMessageReport.length - 1].setBuffer(buf, err);
		return poolFixApplicationMessageReport[poolFixApplicationMessageReport.length - 1];
	}

	public FixStreamAssignmentRequest getFixStreamAssignmentRequest(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixStreamAssignmentRequest.length - 1; i >= 0; i--)
			if (!inUseFixStreamAssignmentRequest[i]) {
				inUseFixStreamAssignmentRequest[i] = true;
				poolFixStreamAssignmentRequest[i].setBuffer(buf, err);
				return poolFixStreamAssignmentRequest[i];
			}

		boolean[] old_inUse = inUseFixStreamAssignmentRequest;
		inUseFixStreamAssignmentRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixStreamAssignmentRequest, 0, old_inUse.length);

		FixStreamAssignmentRequest[] old_pool = poolFixStreamAssignmentRequest;
		poolFixStreamAssignmentRequest = new FixStreamAssignmentRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixStreamAssignmentRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixStreamAssignmentRequest.length; i++) {
			poolFixStreamAssignmentRequest[i] = new FixStreamAssignmentRequest();
			inUseFixStreamAssignmentRequest[i] = false;
		}

		inUseFixStreamAssignmentRequest[poolFixStreamAssignmentRequest.length - 1] = true;
		poolFixStreamAssignmentRequest[poolFixStreamAssignmentRequest.length - 1].setBuffer(buf, err);
		return poolFixStreamAssignmentRequest[poolFixStreamAssignmentRequest.length - 1];
	}

	public FixStreamAssignmentReport getFixStreamAssignmentReport(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixStreamAssignmentReport.length - 1; i >= 0; i--)
			if (!inUseFixStreamAssignmentReport[i]) {
				inUseFixStreamAssignmentReport[i] = true;
				poolFixStreamAssignmentReport[i].setBuffer(buf, err);
				return poolFixStreamAssignmentReport[i];
			}

		boolean[] old_inUse = inUseFixStreamAssignmentReport;
		inUseFixStreamAssignmentReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixStreamAssignmentReport, 0, old_inUse.length);

		FixStreamAssignmentReport[] old_pool = poolFixStreamAssignmentReport;
		poolFixStreamAssignmentReport = new FixStreamAssignmentReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixStreamAssignmentReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixStreamAssignmentReport.length; i++) {
			poolFixStreamAssignmentReport[i] = new FixStreamAssignmentReport();
			inUseFixStreamAssignmentReport[i] = false;
		}

		inUseFixStreamAssignmentReport[poolFixStreamAssignmentReport.length - 1] = true;
		poolFixStreamAssignmentReport[poolFixStreamAssignmentReport.length - 1].setBuffer(buf, err);
		return poolFixStreamAssignmentReport[poolFixStreamAssignmentReport.length - 1];
	}

	public FixStreamAssignmentReportACK getFixStreamAssignmentReportACK(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixStreamAssignmentReportACK.length - 1; i >= 0; i--)
			if (!inUseFixStreamAssignmentReportACK[i]) {
				inUseFixStreamAssignmentReportACK[i] = true;
				poolFixStreamAssignmentReportACK[i].setBuffer(buf, err);
				return poolFixStreamAssignmentReportACK[i];
			}

		boolean[] old_inUse = inUseFixStreamAssignmentReportACK;
		inUseFixStreamAssignmentReportACK = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixStreamAssignmentReportACK, 0, old_inUse.length);

		FixStreamAssignmentReportACK[] old_pool = poolFixStreamAssignmentReportACK;
		poolFixStreamAssignmentReportACK = new FixStreamAssignmentReportACK[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixStreamAssignmentReportACK, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixStreamAssignmentReportACK.length; i++) {
			poolFixStreamAssignmentReportACK[i] = new FixStreamAssignmentReportACK();
			inUseFixStreamAssignmentReportACK[i] = false;
		}

		inUseFixStreamAssignmentReportACK[poolFixStreamAssignmentReportACK.length - 1] = true;
		poolFixStreamAssignmentReportACK[poolFixStreamAssignmentReportACK.length - 1].setBuffer(buf, err);
		return poolFixStreamAssignmentReportACK[poolFixStreamAssignmentReportACK.length - 1];
	}

	public FixPartyDetailsListRequest getFixPartyDetailsListRequest(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixPartyDetailsListRequest.length - 1; i >= 0; i--)
			if (!inUseFixPartyDetailsListRequest[i]) {
				inUseFixPartyDetailsListRequest[i] = true;
				poolFixPartyDetailsListRequest[i].setBuffer(buf, err);
				return poolFixPartyDetailsListRequest[i];
			}

		boolean[] old_inUse = inUseFixPartyDetailsListRequest;
		inUseFixPartyDetailsListRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixPartyDetailsListRequest, 0, old_inUse.length);

		FixPartyDetailsListRequest[] old_pool = poolFixPartyDetailsListRequest;
		poolFixPartyDetailsListRequest = new FixPartyDetailsListRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixPartyDetailsListRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixPartyDetailsListRequest.length; i++) {
			poolFixPartyDetailsListRequest[i] = new FixPartyDetailsListRequest();
			inUseFixPartyDetailsListRequest[i] = false;
		}

		inUseFixPartyDetailsListRequest[poolFixPartyDetailsListRequest.length - 1] = true;
		poolFixPartyDetailsListRequest[poolFixPartyDetailsListRequest.length - 1].setBuffer(buf, err);
		return poolFixPartyDetailsListRequest[poolFixPartyDetailsListRequest.length - 1];
	}

	public FixPartyDetailsListReport getFixPartyDetailsListReport(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixPartyDetailsListReport.length - 1; i >= 0; i--)
			if (!inUseFixPartyDetailsListReport[i]) {
				inUseFixPartyDetailsListReport[i] = true;
				poolFixPartyDetailsListReport[i].setBuffer(buf, err);
				return poolFixPartyDetailsListReport[i];
			}

		boolean[] old_inUse = inUseFixPartyDetailsListReport;
		inUseFixPartyDetailsListReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixPartyDetailsListReport, 0, old_inUse.length);

		FixPartyDetailsListReport[] old_pool = poolFixPartyDetailsListReport;
		poolFixPartyDetailsListReport = new FixPartyDetailsListReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixPartyDetailsListReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixPartyDetailsListReport.length; i++) {
			poolFixPartyDetailsListReport[i] = new FixPartyDetailsListReport();
			inUseFixPartyDetailsListReport[i] = false;
		}

		inUseFixPartyDetailsListReport[poolFixPartyDetailsListReport.length - 1] = true;
		poolFixPartyDetailsListReport[poolFixPartyDetailsListReport.length - 1].setBuffer(buf, err);
		return poolFixPartyDetailsListReport[poolFixPartyDetailsListReport.length - 1];
	}

	public FixHeartbeat getFixHeartbeat() {
		for (int i = inUseFixHeartbeat.length - 1; i >= 0; i--)
			if (!inUseFixHeartbeat[i]) {
				inUseFixHeartbeat[i] = true;
				return poolFixHeartbeat[i];
			}

		boolean[] old_inUse = inUseFixHeartbeat;
		inUseFixHeartbeat = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixHeartbeat, 0, old_inUse.length);

		FixHeartbeat[] old_pool = poolFixHeartbeat;
		poolFixHeartbeat = new FixHeartbeat[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixHeartbeat, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixHeartbeat.length; i++) {
			poolFixHeartbeat[i] = new FixHeartbeat();
			inUseFixHeartbeat[i] = false;
		}

		inUseFixHeartbeat[poolFixHeartbeat.length - 1] = true;
		return poolFixHeartbeat[poolFixHeartbeat.length - 1];
	}

	public FixTestRequest getFixTestRequest() {
		for (int i = inUseFixTestRequest.length - 1; i >= 0; i--)
			if (!inUseFixTestRequest[i]) {
				inUseFixTestRequest[i] = true;
				return poolFixTestRequest[i];
			}

		boolean[] old_inUse = inUseFixTestRequest;
		inUseFixTestRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixTestRequest, 0, old_inUse.length);

		FixTestRequest[] old_pool = poolFixTestRequest;
		poolFixTestRequest = new FixTestRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixTestRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixTestRequest.length; i++) {
			poolFixTestRequest[i] = new FixTestRequest();
			inUseFixTestRequest[i] = false;
		}

		inUseFixTestRequest[poolFixTestRequest.length - 1] = true;
		return poolFixTestRequest[poolFixTestRequest.length - 1];
	}

	public FixResendRequest getFixResendRequest() {
		for (int i = inUseFixResendRequest.length - 1; i >= 0; i--)
			if (!inUseFixResendRequest[i]) {
				inUseFixResendRequest[i] = true;
				return poolFixResendRequest[i];
			}

		boolean[] old_inUse = inUseFixResendRequest;
		inUseFixResendRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixResendRequest, 0, old_inUse.length);

		FixResendRequest[] old_pool = poolFixResendRequest;
		poolFixResendRequest = new FixResendRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixResendRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixResendRequest.length; i++) {
			poolFixResendRequest[i] = new FixResendRequest();
			inUseFixResendRequest[i] = false;
		}

		inUseFixResendRequest[poolFixResendRequest.length - 1] = true;
		return poolFixResendRequest[poolFixResendRequest.length - 1];
	}

	public FixReject getFixReject() {
		for (int i = inUseFixReject.length - 1; i >= 0; i--)
			if (!inUseFixReject[i]) {
				inUseFixReject[i] = true;
				return poolFixReject[i];
			}

		boolean[] old_inUse = inUseFixReject;
		inUseFixReject = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixReject, 0, old_inUse.length);

		FixReject[] old_pool = poolFixReject;
		poolFixReject = new FixReject[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixReject, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixReject.length; i++) {
			poolFixReject[i] = new FixReject();
			inUseFixReject[i] = false;
		}

		inUseFixReject[poolFixReject.length - 1] = true;
		return poolFixReject[poolFixReject.length - 1];
	}

	public FixSequenceReset getFixSequenceReset() {
		for (int i = inUseFixSequenceReset.length - 1; i >= 0; i--)
			if (!inUseFixSequenceReset[i]) {
				inUseFixSequenceReset[i] = true;
				return poolFixSequenceReset[i];
			}

		boolean[] old_inUse = inUseFixSequenceReset;
		inUseFixSequenceReset = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixSequenceReset, 0, old_inUse.length);

		FixSequenceReset[] old_pool = poolFixSequenceReset;
		poolFixSequenceReset = new FixSequenceReset[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixSequenceReset, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixSequenceReset.length; i++) {
			poolFixSequenceReset[i] = new FixSequenceReset();
			inUseFixSequenceReset[i] = false;
		}

		inUseFixSequenceReset[poolFixSequenceReset.length - 1] = true;
		return poolFixSequenceReset[poolFixSequenceReset.length - 1];
	}

	public FixLogout getFixLogout() {
		for (int i = inUseFixLogout.length - 1; i >= 0; i--)
			if (!inUseFixLogout[i]) {
				inUseFixLogout[i] = true;
				return poolFixLogout[i];
			}

		boolean[] old_inUse = inUseFixLogout;
		inUseFixLogout = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixLogout, 0, old_inUse.length);

		FixLogout[] old_pool = poolFixLogout;
		poolFixLogout = new FixLogout[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixLogout, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixLogout.length; i++) {
			poolFixLogout[i] = new FixLogout();
			inUseFixLogout[i] = false;
		}

		inUseFixLogout[poolFixLogout.length - 1] = true;
		return poolFixLogout[poolFixLogout.length - 1];
	}

	public FixIOI getFixIOI() {
		for (int i = inUseFixIOI.length - 1; i >= 0; i--)
			if (!inUseFixIOI[i]) {
				inUseFixIOI[i] = true;
				return poolFixIOI[i];
			}

		boolean[] old_inUse = inUseFixIOI;
		inUseFixIOI = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixIOI, 0, old_inUse.length);

		FixIOI[] old_pool = poolFixIOI;
		poolFixIOI = new FixIOI[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixIOI, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixIOI.length; i++) {
			poolFixIOI[i] = new FixIOI();
			inUseFixIOI[i] = false;
		}

		inUseFixIOI[poolFixIOI.length - 1] = true;
		return poolFixIOI[poolFixIOI.length - 1];
	}

	public FixAdvertisement getFixAdvertisement() {
		for (int i = inUseFixAdvertisement.length - 1; i >= 0; i--)
			if (!inUseFixAdvertisement[i]) {
				inUseFixAdvertisement[i] = true;
				return poolFixAdvertisement[i];
			}

		boolean[] old_inUse = inUseFixAdvertisement;
		inUseFixAdvertisement = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixAdvertisement, 0, old_inUse.length);

		FixAdvertisement[] old_pool = poolFixAdvertisement;
		poolFixAdvertisement = new FixAdvertisement[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixAdvertisement, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixAdvertisement.length; i++) {
			poolFixAdvertisement[i] = new FixAdvertisement();
			inUseFixAdvertisement[i] = false;
		}

		inUseFixAdvertisement[poolFixAdvertisement.length - 1] = true;
		return poolFixAdvertisement[poolFixAdvertisement.length - 1];
	}

	public FixExecutionReport getFixExecutionReport() {
		for (int i = inUseFixExecutionReport.length - 1; i >= 0; i--)
			if (!inUseFixExecutionReport[i]) {
				inUseFixExecutionReport[i] = true;
				return poolFixExecutionReport[i];
			}

		boolean[] old_inUse = inUseFixExecutionReport;
		inUseFixExecutionReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixExecutionReport, 0, old_inUse.length);

		FixExecutionReport[] old_pool = poolFixExecutionReport;
		poolFixExecutionReport = new FixExecutionReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixExecutionReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixExecutionReport.length; i++) {
			poolFixExecutionReport[i] = new FixExecutionReport();
			inUseFixExecutionReport[i] = false;
		}

		inUseFixExecutionReport[poolFixExecutionReport.length - 1] = true;
		return poolFixExecutionReport[poolFixExecutionReport.length - 1];
	}

	public FixOrderCancelReject getFixOrderCancelReject() {
		for (int i = inUseFixOrderCancelReject.length - 1; i >= 0; i--)
			if (!inUseFixOrderCancelReject[i]) {
				inUseFixOrderCancelReject[i] = true;
				return poolFixOrderCancelReject[i];
			}

		boolean[] old_inUse = inUseFixOrderCancelReject;
		inUseFixOrderCancelReject = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixOrderCancelReject, 0, old_inUse.length);

		FixOrderCancelReject[] old_pool = poolFixOrderCancelReject;
		poolFixOrderCancelReject = new FixOrderCancelReject[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixOrderCancelReject, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixOrderCancelReject.length; i++) {
			poolFixOrderCancelReject[i] = new FixOrderCancelReject();
			inUseFixOrderCancelReject[i] = false;
		}

		inUseFixOrderCancelReject[poolFixOrderCancelReject.length - 1] = true;
		return poolFixOrderCancelReject[poolFixOrderCancelReject.length - 1];
	}

	public FixLogon getFixLogon() {
		for (int i = inUseFixLogon.length - 1; i >= 0; i--)
			if (!inUseFixLogon[i]) {
				inUseFixLogon[i] = true;
				return poolFixLogon[i];
			}

		boolean[] old_inUse = inUseFixLogon;
		inUseFixLogon = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixLogon, 0, old_inUse.length);

		FixLogon[] old_pool = poolFixLogon;
		poolFixLogon = new FixLogon[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixLogon, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixLogon.length; i++) {
			poolFixLogon[i] = new FixLogon();
			inUseFixLogon[i] = false;
		}

		inUseFixLogon[poolFixLogon.length - 1] = true;
		return poolFixLogon[poolFixLogon.length - 1];
	}

	public FixNews getFixNews() {
		for (int i = inUseFixNews.length - 1; i >= 0; i--)
			if (!inUseFixNews[i]) {
				inUseFixNews[i] = true;
				return poolFixNews[i];
			}

		boolean[] old_inUse = inUseFixNews;
		inUseFixNews = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixNews, 0, old_inUse.length);

		FixNews[] old_pool = poolFixNews;
		poolFixNews = new FixNews[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixNews, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixNews.length; i++) {
			poolFixNews[i] = new FixNews();
			inUseFixNews[i] = false;
		}

		inUseFixNews[poolFixNews.length - 1] = true;
		return poolFixNews[poolFixNews.length - 1];
	}

	public FixEmail getFixEmail() {
		for (int i = inUseFixEmail.length - 1; i >= 0; i--)
			if (!inUseFixEmail[i]) {
				inUseFixEmail[i] = true;
				return poolFixEmail[i];
			}

		boolean[] old_inUse = inUseFixEmail;
		inUseFixEmail = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixEmail, 0, old_inUse.length);

		FixEmail[] old_pool = poolFixEmail;
		poolFixEmail = new FixEmail[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixEmail, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixEmail.length; i++) {
			poolFixEmail[i] = new FixEmail();
			inUseFixEmail[i] = false;
		}

		inUseFixEmail[poolFixEmail.length - 1] = true;
		return poolFixEmail[poolFixEmail.length - 1];
	}

	public FixNewOrderSingle getFixNewOrderSingle() {
		for (int i = inUseFixNewOrderSingle.length - 1; i >= 0; i--)
			if (!inUseFixNewOrderSingle[i]) {
				inUseFixNewOrderSingle[i] = true;
				return poolFixNewOrderSingle[i];
			}

		boolean[] old_inUse = inUseFixNewOrderSingle;
		inUseFixNewOrderSingle = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixNewOrderSingle, 0, old_inUse.length);

		FixNewOrderSingle[] old_pool = poolFixNewOrderSingle;
		poolFixNewOrderSingle = new FixNewOrderSingle[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixNewOrderSingle, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixNewOrderSingle.length; i++) {
			poolFixNewOrderSingle[i] = new FixNewOrderSingle();
			inUseFixNewOrderSingle[i] = false;
		}

		inUseFixNewOrderSingle[poolFixNewOrderSingle.length - 1] = true;
		return poolFixNewOrderSingle[poolFixNewOrderSingle.length - 1];
	}

	public FixNewOrderList getFixNewOrderList() {
		for (int i = inUseFixNewOrderList.length - 1; i >= 0; i--)
			if (!inUseFixNewOrderList[i]) {
				inUseFixNewOrderList[i] = true;
				return poolFixNewOrderList[i];
			}

		boolean[] old_inUse = inUseFixNewOrderList;
		inUseFixNewOrderList = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixNewOrderList, 0, old_inUse.length);

		FixNewOrderList[] old_pool = poolFixNewOrderList;
		poolFixNewOrderList = new FixNewOrderList[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixNewOrderList, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixNewOrderList.length; i++) {
			poolFixNewOrderList[i] = new FixNewOrderList();
			inUseFixNewOrderList[i] = false;
		}

		inUseFixNewOrderList[poolFixNewOrderList.length - 1] = true;
		return poolFixNewOrderList[poolFixNewOrderList.length - 1];
	}

	public FixOrderCancelRequest getFixOrderCancelRequest() {
		for (int i = inUseFixOrderCancelRequest.length - 1; i >= 0; i--)
			if (!inUseFixOrderCancelRequest[i]) {
				inUseFixOrderCancelRequest[i] = true;
				return poolFixOrderCancelRequest[i];
			}

		boolean[] old_inUse = inUseFixOrderCancelRequest;
		inUseFixOrderCancelRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixOrderCancelRequest, 0, old_inUse.length);

		FixOrderCancelRequest[] old_pool = poolFixOrderCancelRequest;
		poolFixOrderCancelRequest = new FixOrderCancelRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixOrderCancelRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixOrderCancelRequest.length; i++) {
			poolFixOrderCancelRequest[i] = new FixOrderCancelRequest();
			inUseFixOrderCancelRequest[i] = false;
		}

		inUseFixOrderCancelRequest[poolFixOrderCancelRequest.length - 1] = true;
		return poolFixOrderCancelRequest[poolFixOrderCancelRequest.length - 1];
	}

	public FixOrderCancelReplaceRequest getFixOrderCancelReplaceRequest() {
		for (int i = inUseFixOrderCancelReplaceRequest.length - 1; i >= 0; i--)
			if (!inUseFixOrderCancelReplaceRequest[i]) {
				inUseFixOrderCancelReplaceRequest[i] = true;
				return poolFixOrderCancelReplaceRequest[i];
			}

		boolean[] old_inUse = inUseFixOrderCancelReplaceRequest;
		inUseFixOrderCancelReplaceRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixOrderCancelReplaceRequest, 0, old_inUse.length);

		FixOrderCancelReplaceRequest[] old_pool = poolFixOrderCancelReplaceRequest;
		poolFixOrderCancelReplaceRequest = new FixOrderCancelReplaceRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixOrderCancelReplaceRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixOrderCancelReplaceRequest.length; i++) {
			poolFixOrderCancelReplaceRequest[i] = new FixOrderCancelReplaceRequest();
			inUseFixOrderCancelReplaceRequest[i] = false;
		}

		inUseFixOrderCancelReplaceRequest[poolFixOrderCancelReplaceRequest.length - 1] = true;
		return poolFixOrderCancelReplaceRequest[poolFixOrderCancelReplaceRequest.length - 1];
	}

	public FixOrderStatusRequest getFixOrderStatusRequest() {
		for (int i = inUseFixOrderStatusRequest.length - 1; i >= 0; i--)
			if (!inUseFixOrderStatusRequest[i]) {
				inUseFixOrderStatusRequest[i] = true;
				return poolFixOrderStatusRequest[i];
			}

		boolean[] old_inUse = inUseFixOrderStatusRequest;
		inUseFixOrderStatusRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixOrderStatusRequest, 0, old_inUse.length);

		FixOrderStatusRequest[] old_pool = poolFixOrderStatusRequest;
		poolFixOrderStatusRequest = new FixOrderStatusRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixOrderStatusRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixOrderStatusRequest.length; i++) {
			poolFixOrderStatusRequest[i] = new FixOrderStatusRequest();
			inUseFixOrderStatusRequest[i] = false;
		}

		inUseFixOrderStatusRequest[poolFixOrderStatusRequest.length - 1] = true;
		return poolFixOrderStatusRequest[poolFixOrderStatusRequest.length - 1];
	}

	public FixAllocationInstruction getFixAllocationInstruction() {
		for (int i = inUseFixAllocationInstruction.length - 1; i >= 0; i--)
			if (!inUseFixAllocationInstruction[i]) {
				inUseFixAllocationInstruction[i] = true;
				return poolFixAllocationInstruction[i];
			}

		boolean[] old_inUse = inUseFixAllocationInstruction;
		inUseFixAllocationInstruction = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixAllocationInstruction, 0, old_inUse.length);

		FixAllocationInstruction[] old_pool = poolFixAllocationInstruction;
		poolFixAllocationInstruction = new FixAllocationInstruction[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixAllocationInstruction, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixAllocationInstruction.length; i++) {
			poolFixAllocationInstruction[i] = new FixAllocationInstruction();
			inUseFixAllocationInstruction[i] = false;
		}

		inUseFixAllocationInstruction[poolFixAllocationInstruction.length - 1] = true;
		return poolFixAllocationInstruction[poolFixAllocationInstruction.length - 1];
	}

	public FixListCancelRequest getFixListCancelRequest() {
		for (int i = inUseFixListCancelRequest.length - 1; i >= 0; i--)
			if (!inUseFixListCancelRequest[i]) {
				inUseFixListCancelRequest[i] = true;
				return poolFixListCancelRequest[i];
			}

		boolean[] old_inUse = inUseFixListCancelRequest;
		inUseFixListCancelRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixListCancelRequest, 0, old_inUse.length);

		FixListCancelRequest[] old_pool = poolFixListCancelRequest;
		poolFixListCancelRequest = new FixListCancelRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixListCancelRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixListCancelRequest.length; i++) {
			poolFixListCancelRequest[i] = new FixListCancelRequest();
			inUseFixListCancelRequest[i] = false;
		}

		inUseFixListCancelRequest[poolFixListCancelRequest.length - 1] = true;
		return poolFixListCancelRequest[poolFixListCancelRequest.length - 1];
	}

	public FixListExecute getFixListExecute() {
		for (int i = inUseFixListExecute.length - 1; i >= 0; i--)
			if (!inUseFixListExecute[i]) {
				inUseFixListExecute[i] = true;
				return poolFixListExecute[i];
			}

		boolean[] old_inUse = inUseFixListExecute;
		inUseFixListExecute = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixListExecute, 0, old_inUse.length);

		FixListExecute[] old_pool = poolFixListExecute;
		poolFixListExecute = new FixListExecute[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixListExecute, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixListExecute.length; i++) {
			poolFixListExecute[i] = new FixListExecute();
			inUseFixListExecute[i] = false;
		}

		inUseFixListExecute[poolFixListExecute.length - 1] = true;
		return poolFixListExecute[poolFixListExecute.length - 1];
	}

	public FixListStatusRequest getFixListStatusRequest() {
		for (int i = inUseFixListStatusRequest.length - 1; i >= 0; i--)
			if (!inUseFixListStatusRequest[i]) {
				inUseFixListStatusRequest[i] = true;
				return poolFixListStatusRequest[i];
			}

		boolean[] old_inUse = inUseFixListStatusRequest;
		inUseFixListStatusRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixListStatusRequest, 0, old_inUse.length);

		FixListStatusRequest[] old_pool = poolFixListStatusRequest;
		poolFixListStatusRequest = new FixListStatusRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixListStatusRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixListStatusRequest.length; i++) {
			poolFixListStatusRequest[i] = new FixListStatusRequest();
			inUseFixListStatusRequest[i] = false;
		}

		inUseFixListStatusRequest[poolFixListStatusRequest.length - 1] = true;
		return poolFixListStatusRequest[poolFixListStatusRequest.length - 1];
	}

	public FixListStatus getFixListStatus() {
		for (int i = inUseFixListStatus.length - 1; i >= 0; i--)
			if (!inUseFixListStatus[i]) {
				inUseFixListStatus[i] = true;
				return poolFixListStatus[i];
			}

		boolean[] old_inUse = inUseFixListStatus;
		inUseFixListStatus = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixListStatus, 0, old_inUse.length);

		FixListStatus[] old_pool = poolFixListStatus;
		poolFixListStatus = new FixListStatus[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixListStatus, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixListStatus.length; i++) {
			poolFixListStatus[i] = new FixListStatus();
			inUseFixListStatus[i] = false;
		}

		inUseFixListStatus[poolFixListStatus.length - 1] = true;
		return poolFixListStatus[poolFixListStatus.length - 1];
	}

	public FixAllocationInstructionAck getFixAllocationInstructionAck() {
		for (int i = inUseFixAllocationInstructionAck.length - 1; i >= 0; i--)
			if (!inUseFixAllocationInstructionAck[i]) {
				inUseFixAllocationInstructionAck[i] = true;
				return poolFixAllocationInstructionAck[i];
			}

		boolean[] old_inUse = inUseFixAllocationInstructionAck;
		inUseFixAllocationInstructionAck = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixAllocationInstructionAck, 0, old_inUse.length);

		FixAllocationInstructionAck[] old_pool = poolFixAllocationInstructionAck;
		poolFixAllocationInstructionAck = new FixAllocationInstructionAck[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixAllocationInstructionAck, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixAllocationInstructionAck.length; i++) {
			poolFixAllocationInstructionAck[i] = new FixAllocationInstructionAck();
			inUseFixAllocationInstructionAck[i] = false;
		}

		inUseFixAllocationInstructionAck[poolFixAllocationInstructionAck.length - 1] = true;
		return poolFixAllocationInstructionAck[poolFixAllocationInstructionAck.length - 1];
	}

	public FixDontKnowTradeDK getFixDontKnowTradeDK() {
		for (int i = inUseFixDontKnowTradeDK.length - 1; i >= 0; i--)
			if (!inUseFixDontKnowTradeDK[i]) {
				inUseFixDontKnowTradeDK[i] = true;
				return poolFixDontKnowTradeDK[i];
			}

		boolean[] old_inUse = inUseFixDontKnowTradeDK;
		inUseFixDontKnowTradeDK = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixDontKnowTradeDK, 0, old_inUse.length);

		FixDontKnowTradeDK[] old_pool = poolFixDontKnowTradeDK;
		poolFixDontKnowTradeDK = new FixDontKnowTradeDK[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixDontKnowTradeDK, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixDontKnowTradeDK.length; i++) {
			poolFixDontKnowTradeDK[i] = new FixDontKnowTradeDK();
			inUseFixDontKnowTradeDK[i] = false;
		}

		inUseFixDontKnowTradeDK[poolFixDontKnowTradeDK.length - 1] = true;
		return poolFixDontKnowTradeDK[poolFixDontKnowTradeDK.length - 1];
	}

	public FixQuoteRequest getFixQuoteRequest() {
		for (int i = inUseFixQuoteRequest.length - 1; i >= 0; i--)
			if (!inUseFixQuoteRequest[i]) {
				inUseFixQuoteRequest[i] = true;
				return poolFixQuoteRequest[i];
			}

		boolean[] old_inUse = inUseFixQuoteRequest;
		inUseFixQuoteRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixQuoteRequest, 0, old_inUse.length);

		FixQuoteRequest[] old_pool = poolFixQuoteRequest;
		poolFixQuoteRequest = new FixQuoteRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixQuoteRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixQuoteRequest.length; i++) {
			poolFixQuoteRequest[i] = new FixQuoteRequest();
			inUseFixQuoteRequest[i] = false;
		}

		inUseFixQuoteRequest[poolFixQuoteRequest.length - 1] = true;
		return poolFixQuoteRequest[poolFixQuoteRequest.length - 1];
	}

	public FixQuote getFixQuote() {
		for (int i = inUseFixQuote.length - 1; i >= 0; i--)
			if (!inUseFixQuote[i]) {
				inUseFixQuote[i] = true;
				return poolFixQuote[i];
			}

		boolean[] old_inUse = inUseFixQuote;
		inUseFixQuote = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixQuote, 0, old_inUse.length);

		FixQuote[] old_pool = poolFixQuote;
		poolFixQuote = new FixQuote[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixQuote, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixQuote.length; i++) {
			poolFixQuote[i] = new FixQuote();
			inUseFixQuote[i] = false;
		}

		inUseFixQuote[poolFixQuote.length - 1] = true;
		return poolFixQuote[poolFixQuote.length - 1];
	}

	public FixSettlementInstructions getFixSettlementInstructions() {
		for (int i = inUseFixSettlementInstructions.length - 1; i >= 0; i--)
			if (!inUseFixSettlementInstructions[i]) {
				inUseFixSettlementInstructions[i] = true;
				return poolFixSettlementInstructions[i];
			}

		boolean[] old_inUse = inUseFixSettlementInstructions;
		inUseFixSettlementInstructions = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixSettlementInstructions, 0, old_inUse.length);

		FixSettlementInstructions[] old_pool = poolFixSettlementInstructions;
		poolFixSettlementInstructions = new FixSettlementInstructions[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixSettlementInstructions, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixSettlementInstructions.length; i++) {
			poolFixSettlementInstructions[i] = new FixSettlementInstructions();
			inUseFixSettlementInstructions[i] = false;
		}

		inUseFixSettlementInstructions[poolFixSettlementInstructions.length - 1] = true;
		return poolFixSettlementInstructions[poolFixSettlementInstructions.length - 1];
	}

	public FixMarketDataRequest getFixMarketDataRequest() {
		for (int i = inUseFixMarketDataRequest.length - 1; i >= 0; i--)
			if (!inUseFixMarketDataRequest[i]) {
				inUseFixMarketDataRequest[i] = true;
				return poolFixMarketDataRequest[i];
			}

		boolean[] old_inUse = inUseFixMarketDataRequest;
		inUseFixMarketDataRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixMarketDataRequest, 0, old_inUse.length);

		FixMarketDataRequest[] old_pool = poolFixMarketDataRequest;
		poolFixMarketDataRequest = new FixMarketDataRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixMarketDataRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixMarketDataRequest.length; i++) {
			poolFixMarketDataRequest[i] = new FixMarketDataRequest();
			inUseFixMarketDataRequest[i] = false;
		}

		inUseFixMarketDataRequest[poolFixMarketDataRequest.length - 1] = true;
		return poolFixMarketDataRequest[poolFixMarketDataRequest.length - 1];
	}

	public FixMarketDataSnapshotFullRefresh getFixMarketDataSnapshotFullRefresh() {
		for (int i = inUseFixMarketDataSnapshotFullRefresh.length - 1; i >= 0; i--)
			if (!inUseFixMarketDataSnapshotFullRefresh[i]) {
				inUseFixMarketDataSnapshotFullRefresh[i] = true;
				return poolFixMarketDataSnapshotFullRefresh[i];
			}

		boolean[] old_inUse = inUseFixMarketDataSnapshotFullRefresh;
		inUseFixMarketDataSnapshotFullRefresh = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixMarketDataSnapshotFullRefresh, 0, old_inUse.length);

		FixMarketDataSnapshotFullRefresh[] old_pool = poolFixMarketDataSnapshotFullRefresh;
		poolFixMarketDataSnapshotFullRefresh = new FixMarketDataSnapshotFullRefresh[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixMarketDataSnapshotFullRefresh, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixMarketDataSnapshotFullRefresh.length; i++) {
			poolFixMarketDataSnapshotFullRefresh[i] = new FixMarketDataSnapshotFullRefresh();
			inUseFixMarketDataSnapshotFullRefresh[i] = false;
		}

		inUseFixMarketDataSnapshotFullRefresh[poolFixMarketDataSnapshotFullRefresh.length - 1] = true;
		return poolFixMarketDataSnapshotFullRefresh[poolFixMarketDataSnapshotFullRefresh.length - 1];
	}

	public FixMarketDataIncrementalRefresh getFixMarketDataIncrementalRefresh() {
		for (int i = inUseFixMarketDataIncrementalRefresh.length - 1; i >= 0; i--)
			if (!inUseFixMarketDataIncrementalRefresh[i]) {
				inUseFixMarketDataIncrementalRefresh[i] = true;
				return poolFixMarketDataIncrementalRefresh[i];
			}

		boolean[] old_inUse = inUseFixMarketDataIncrementalRefresh;
		inUseFixMarketDataIncrementalRefresh = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixMarketDataIncrementalRefresh, 0, old_inUse.length);

		FixMarketDataIncrementalRefresh[] old_pool = poolFixMarketDataIncrementalRefresh;
		poolFixMarketDataIncrementalRefresh = new FixMarketDataIncrementalRefresh[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixMarketDataIncrementalRefresh, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixMarketDataIncrementalRefresh.length; i++) {
			poolFixMarketDataIncrementalRefresh[i] = new FixMarketDataIncrementalRefresh();
			inUseFixMarketDataIncrementalRefresh[i] = false;
		}

		inUseFixMarketDataIncrementalRefresh[poolFixMarketDataIncrementalRefresh.length - 1] = true;
		return poolFixMarketDataIncrementalRefresh[poolFixMarketDataIncrementalRefresh.length - 1];
	}

	public FixMarketDataRequestReject getFixMarketDataRequestReject() {
		for (int i = inUseFixMarketDataRequestReject.length - 1; i >= 0; i--)
			if (!inUseFixMarketDataRequestReject[i]) {
				inUseFixMarketDataRequestReject[i] = true;
				return poolFixMarketDataRequestReject[i];
			}

		boolean[] old_inUse = inUseFixMarketDataRequestReject;
		inUseFixMarketDataRequestReject = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixMarketDataRequestReject, 0, old_inUse.length);

		FixMarketDataRequestReject[] old_pool = poolFixMarketDataRequestReject;
		poolFixMarketDataRequestReject = new FixMarketDataRequestReject[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixMarketDataRequestReject, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixMarketDataRequestReject.length; i++) {
			poolFixMarketDataRequestReject[i] = new FixMarketDataRequestReject();
			inUseFixMarketDataRequestReject[i] = false;
		}

		inUseFixMarketDataRequestReject[poolFixMarketDataRequestReject.length - 1] = true;
		return poolFixMarketDataRequestReject[poolFixMarketDataRequestReject.length - 1];
	}

	public FixQuoteCancel getFixQuoteCancel() {
		for (int i = inUseFixQuoteCancel.length - 1; i >= 0; i--)
			if (!inUseFixQuoteCancel[i]) {
				inUseFixQuoteCancel[i] = true;
				return poolFixQuoteCancel[i];
			}

		boolean[] old_inUse = inUseFixQuoteCancel;
		inUseFixQuoteCancel = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixQuoteCancel, 0, old_inUse.length);

		FixQuoteCancel[] old_pool = poolFixQuoteCancel;
		poolFixQuoteCancel = new FixQuoteCancel[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixQuoteCancel, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixQuoteCancel.length; i++) {
			poolFixQuoteCancel[i] = new FixQuoteCancel();
			inUseFixQuoteCancel[i] = false;
		}

		inUseFixQuoteCancel[poolFixQuoteCancel.length - 1] = true;
		return poolFixQuoteCancel[poolFixQuoteCancel.length - 1];
	}

	public FixQuoteStatusRequest getFixQuoteStatusRequest() {
		for (int i = inUseFixQuoteStatusRequest.length - 1; i >= 0; i--)
			if (!inUseFixQuoteStatusRequest[i]) {
				inUseFixQuoteStatusRequest[i] = true;
				return poolFixQuoteStatusRequest[i];
			}

		boolean[] old_inUse = inUseFixQuoteStatusRequest;
		inUseFixQuoteStatusRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixQuoteStatusRequest, 0, old_inUse.length);

		FixQuoteStatusRequest[] old_pool = poolFixQuoteStatusRequest;
		poolFixQuoteStatusRequest = new FixQuoteStatusRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixQuoteStatusRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixQuoteStatusRequest.length; i++) {
			poolFixQuoteStatusRequest[i] = new FixQuoteStatusRequest();
			inUseFixQuoteStatusRequest[i] = false;
		}

		inUseFixQuoteStatusRequest[poolFixQuoteStatusRequest.length - 1] = true;
		return poolFixQuoteStatusRequest[poolFixQuoteStatusRequest.length - 1];
	}

	public FixMassQuoteAcknowledgement getFixMassQuoteAcknowledgement() {
		for (int i = inUseFixMassQuoteAcknowledgement.length - 1; i >= 0; i--)
			if (!inUseFixMassQuoteAcknowledgement[i]) {
				inUseFixMassQuoteAcknowledgement[i] = true;
				return poolFixMassQuoteAcknowledgement[i];
			}

		boolean[] old_inUse = inUseFixMassQuoteAcknowledgement;
		inUseFixMassQuoteAcknowledgement = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixMassQuoteAcknowledgement, 0, old_inUse.length);

		FixMassQuoteAcknowledgement[] old_pool = poolFixMassQuoteAcknowledgement;
		poolFixMassQuoteAcknowledgement = new FixMassQuoteAcknowledgement[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixMassQuoteAcknowledgement, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixMassQuoteAcknowledgement.length; i++) {
			poolFixMassQuoteAcknowledgement[i] = new FixMassQuoteAcknowledgement();
			inUseFixMassQuoteAcknowledgement[i] = false;
		}

		inUseFixMassQuoteAcknowledgement[poolFixMassQuoteAcknowledgement.length - 1] = true;
		return poolFixMassQuoteAcknowledgement[poolFixMassQuoteAcknowledgement.length - 1];
	}

	public FixSecurityDefinitionRequest getFixSecurityDefinitionRequest() {
		for (int i = inUseFixSecurityDefinitionRequest.length - 1; i >= 0; i--)
			if (!inUseFixSecurityDefinitionRequest[i]) {
				inUseFixSecurityDefinitionRequest[i] = true;
				return poolFixSecurityDefinitionRequest[i];
			}

		boolean[] old_inUse = inUseFixSecurityDefinitionRequest;
		inUseFixSecurityDefinitionRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixSecurityDefinitionRequest, 0, old_inUse.length);

		FixSecurityDefinitionRequest[] old_pool = poolFixSecurityDefinitionRequest;
		poolFixSecurityDefinitionRequest = new FixSecurityDefinitionRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixSecurityDefinitionRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixSecurityDefinitionRequest.length; i++) {
			poolFixSecurityDefinitionRequest[i] = new FixSecurityDefinitionRequest();
			inUseFixSecurityDefinitionRequest[i] = false;
		}

		inUseFixSecurityDefinitionRequest[poolFixSecurityDefinitionRequest.length - 1] = true;
		return poolFixSecurityDefinitionRequest[poolFixSecurityDefinitionRequest.length - 1];
	}

	public FixSecurityDefinition getFixSecurityDefinition() {
		for (int i = inUseFixSecurityDefinition.length - 1; i >= 0; i--)
			if (!inUseFixSecurityDefinition[i]) {
				inUseFixSecurityDefinition[i] = true;
				return poolFixSecurityDefinition[i];
			}

		boolean[] old_inUse = inUseFixSecurityDefinition;
		inUseFixSecurityDefinition = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixSecurityDefinition, 0, old_inUse.length);

		FixSecurityDefinition[] old_pool = poolFixSecurityDefinition;
		poolFixSecurityDefinition = new FixSecurityDefinition[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixSecurityDefinition, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixSecurityDefinition.length; i++) {
			poolFixSecurityDefinition[i] = new FixSecurityDefinition();
			inUseFixSecurityDefinition[i] = false;
		}

		inUseFixSecurityDefinition[poolFixSecurityDefinition.length - 1] = true;
		return poolFixSecurityDefinition[poolFixSecurityDefinition.length - 1];
	}

	public FixSecurityStatusRequest getFixSecurityStatusRequest() {
		for (int i = inUseFixSecurityStatusRequest.length - 1; i >= 0; i--)
			if (!inUseFixSecurityStatusRequest[i]) {
				inUseFixSecurityStatusRequest[i] = true;
				return poolFixSecurityStatusRequest[i];
			}

		boolean[] old_inUse = inUseFixSecurityStatusRequest;
		inUseFixSecurityStatusRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixSecurityStatusRequest, 0, old_inUse.length);

		FixSecurityStatusRequest[] old_pool = poolFixSecurityStatusRequest;
		poolFixSecurityStatusRequest = new FixSecurityStatusRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixSecurityStatusRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixSecurityStatusRequest.length; i++) {
			poolFixSecurityStatusRequest[i] = new FixSecurityStatusRequest();
			inUseFixSecurityStatusRequest[i] = false;
		}

		inUseFixSecurityStatusRequest[poolFixSecurityStatusRequest.length - 1] = true;
		return poolFixSecurityStatusRequest[poolFixSecurityStatusRequest.length - 1];
	}

	public FixSecurityStatus getFixSecurityStatus() {
		for (int i = inUseFixSecurityStatus.length - 1; i >= 0; i--)
			if (!inUseFixSecurityStatus[i]) {
				inUseFixSecurityStatus[i] = true;
				return poolFixSecurityStatus[i];
			}

		boolean[] old_inUse = inUseFixSecurityStatus;
		inUseFixSecurityStatus = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixSecurityStatus, 0, old_inUse.length);

		FixSecurityStatus[] old_pool = poolFixSecurityStatus;
		poolFixSecurityStatus = new FixSecurityStatus[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixSecurityStatus, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixSecurityStatus.length; i++) {
			poolFixSecurityStatus[i] = new FixSecurityStatus();
			inUseFixSecurityStatus[i] = false;
		}

		inUseFixSecurityStatus[poolFixSecurityStatus.length - 1] = true;
		return poolFixSecurityStatus[poolFixSecurityStatus.length - 1];
	}

	public FixTradingSessionStatusRequest getFixTradingSessionStatusRequest() {
		for (int i = inUseFixTradingSessionStatusRequest.length - 1; i >= 0; i--)
			if (!inUseFixTradingSessionStatusRequest[i]) {
				inUseFixTradingSessionStatusRequest[i] = true;
				return poolFixTradingSessionStatusRequest[i];
			}

		boolean[] old_inUse = inUseFixTradingSessionStatusRequest;
		inUseFixTradingSessionStatusRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixTradingSessionStatusRequest, 0, old_inUse.length);

		FixTradingSessionStatusRequest[] old_pool = poolFixTradingSessionStatusRequest;
		poolFixTradingSessionStatusRequest = new FixTradingSessionStatusRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixTradingSessionStatusRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixTradingSessionStatusRequest.length; i++) {
			poolFixTradingSessionStatusRequest[i] = new FixTradingSessionStatusRequest();
			inUseFixTradingSessionStatusRequest[i] = false;
		}

		inUseFixTradingSessionStatusRequest[poolFixTradingSessionStatusRequest.length - 1] = true;
		return poolFixTradingSessionStatusRequest[poolFixTradingSessionStatusRequest.length - 1];
	}

	public FixTradingSessionStatus getFixTradingSessionStatus() {
		for (int i = inUseFixTradingSessionStatus.length - 1; i >= 0; i--)
			if (!inUseFixTradingSessionStatus[i]) {
				inUseFixTradingSessionStatus[i] = true;
				return poolFixTradingSessionStatus[i];
			}

		boolean[] old_inUse = inUseFixTradingSessionStatus;
		inUseFixTradingSessionStatus = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixTradingSessionStatus, 0, old_inUse.length);

		FixTradingSessionStatus[] old_pool = poolFixTradingSessionStatus;
		poolFixTradingSessionStatus = new FixTradingSessionStatus[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixTradingSessionStatus, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixTradingSessionStatus.length; i++) {
			poolFixTradingSessionStatus[i] = new FixTradingSessionStatus();
			inUseFixTradingSessionStatus[i] = false;
		}

		inUseFixTradingSessionStatus[poolFixTradingSessionStatus.length - 1] = true;
		return poolFixTradingSessionStatus[poolFixTradingSessionStatus.length - 1];
	}

	public FixMassQuote getFixMassQuote() {
		for (int i = inUseFixMassQuote.length - 1; i >= 0; i--)
			if (!inUseFixMassQuote[i]) {
				inUseFixMassQuote[i] = true;
				return poolFixMassQuote[i];
			}

		boolean[] old_inUse = inUseFixMassQuote;
		inUseFixMassQuote = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixMassQuote, 0, old_inUse.length);

		FixMassQuote[] old_pool = poolFixMassQuote;
		poolFixMassQuote = new FixMassQuote[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixMassQuote, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixMassQuote.length; i++) {
			poolFixMassQuote[i] = new FixMassQuote();
			inUseFixMassQuote[i] = false;
		}

		inUseFixMassQuote[poolFixMassQuote.length - 1] = true;
		return poolFixMassQuote[poolFixMassQuote.length - 1];
	}

	public FixBusinessMessageReject getFixBusinessMessageReject() {
		for (int i = inUseFixBusinessMessageReject.length - 1; i >= 0; i--)
			if (!inUseFixBusinessMessageReject[i]) {
				inUseFixBusinessMessageReject[i] = true;
				return poolFixBusinessMessageReject[i];
			}

		boolean[] old_inUse = inUseFixBusinessMessageReject;
		inUseFixBusinessMessageReject = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixBusinessMessageReject, 0, old_inUse.length);

		FixBusinessMessageReject[] old_pool = poolFixBusinessMessageReject;
		poolFixBusinessMessageReject = new FixBusinessMessageReject[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixBusinessMessageReject, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixBusinessMessageReject.length; i++) {
			poolFixBusinessMessageReject[i] = new FixBusinessMessageReject();
			inUseFixBusinessMessageReject[i] = false;
		}

		inUseFixBusinessMessageReject[poolFixBusinessMessageReject.length - 1] = true;
		return poolFixBusinessMessageReject[poolFixBusinessMessageReject.length - 1];
	}

	public FixBidRequest getFixBidRequest() {
		for (int i = inUseFixBidRequest.length - 1; i >= 0; i--)
			if (!inUseFixBidRequest[i]) {
				inUseFixBidRequest[i] = true;
				return poolFixBidRequest[i];
			}

		boolean[] old_inUse = inUseFixBidRequest;
		inUseFixBidRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixBidRequest, 0, old_inUse.length);

		FixBidRequest[] old_pool = poolFixBidRequest;
		poolFixBidRequest = new FixBidRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixBidRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixBidRequest.length; i++) {
			poolFixBidRequest[i] = new FixBidRequest();
			inUseFixBidRequest[i] = false;
		}

		inUseFixBidRequest[poolFixBidRequest.length - 1] = true;
		return poolFixBidRequest[poolFixBidRequest.length - 1];
	}

	public FixBidResponse getFixBidResponse() {
		for (int i = inUseFixBidResponse.length - 1; i >= 0; i--)
			if (!inUseFixBidResponse[i]) {
				inUseFixBidResponse[i] = true;
				return poolFixBidResponse[i];
			}

		boolean[] old_inUse = inUseFixBidResponse;
		inUseFixBidResponse = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixBidResponse, 0, old_inUse.length);

		FixBidResponse[] old_pool = poolFixBidResponse;
		poolFixBidResponse = new FixBidResponse[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixBidResponse, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixBidResponse.length; i++) {
			poolFixBidResponse[i] = new FixBidResponse();
			inUseFixBidResponse[i] = false;
		}

		inUseFixBidResponse[poolFixBidResponse.length - 1] = true;
		return poolFixBidResponse[poolFixBidResponse.length - 1];
	}

	public FixListStrikePrice getFixListStrikePrice() {
		for (int i = inUseFixListStrikePrice.length - 1; i >= 0; i--)
			if (!inUseFixListStrikePrice[i]) {
				inUseFixListStrikePrice[i] = true;
				return poolFixListStrikePrice[i];
			}

		boolean[] old_inUse = inUseFixListStrikePrice;
		inUseFixListStrikePrice = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixListStrikePrice, 0, old_inUse.length);

		FixListStrikePrice[] old_pool = poolFixListStrikePrice;
		poolFixListStrikePrice = new FixListStrikePrice[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixListStrikePrice, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixListStrikePrice.length; i++) {
			poolFixListStrikePrice[i] = new FixListStrikePrice();
			inUseFixListStrikePrice[i] = false;
		}

		inUseFixListStrikePrice[poolFixListStrikePrice.length - 1] = true;
		return poolFixListStrikePrice[poolFixListStrikePrice.length - 1];
	}

	public FixRegistrationInstructions getFixRegistrationInstructions() {
		for (int i = inUseFixRegistrationInstructions.length - 1; i >= 0; i--)
			if (!inUseFixRegistrationInstructions[i]) {
				inUseFixRegistrationInstructions[i] = true;
				return poolFixRegistrationInstructions[i];
			}

		boolean[] old_inUse = inUseFixRegistrationInstructions;
		inUseFixRegistrationInstructions = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixRegistrationInstructions, 0, old_inUse.length);

		FixRegistrationInstructions[] old_pool = poolFixRegistrationInstructions;
		poolFixRegistrationInstructions = new FixRegistrationInstructions[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixRegistrationInstructions, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixRegistrationInstructions.length; i++) {
			poolFixRegistrationInstructions[i] = new FixRegistrationInstructions();
			inUseFixRegistrationInstructions[i] = false;
		}

		inUseFixRegistrationInstructions[poolFixRegistrationInstructions.length - 1] = true;
		return poolFixRegistrationInstructions[poolFixRegistrationInstructions.length - 1];
	}

	public FixRegistrationInstructionsResponse getFixRegistrationInstructionsResponse() {
		for (int i = inUseFixRegistrationInstructionsResponse.length - 1; i >= 0; i--)
			if (!inUseFixRegistrationInstructionsResponse[i]) {
				inUseFixRegistrationInstructionsResponse[i] = true;
				return poolFixRegistrationInstructionsResponse[i];
			}

		boolean[] old_inUse = inUseFixRegistrationInstructionsResponse;
		inUseFixRegistrationInstructionsResponse = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixRegistrationInstructionsResponse, 0, old_inUse.length);

		FixRegistrationInstructionsResponse[] old_pool = poolFixRegistrationInstructionsResponse;
		poolFixRegistrationInstructionsResponse = new FixRegistrationInstructionsResponse[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixRegistrationInstructionsResponse, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixRegistrationInstructionsResponse.length; i++) {
			poolFixRegistrationInstructionsResponse[i] = new FixRegistrationInstructionsResponse();
			inUseFixRegistrationInstructionsResponse[i] = false;
		}

		inUseFixRegistrationInstructionsResponse[poolFixRegistrationInstructionsResponse.length - 1] = true;
		return poolFixRegistrationInstructionsResponse[poolFixRegistrationInstructionsResponse.length - 1];
	}

	public FixOrderMassCancelRequest getFixOrderMassCancelRequest() {
		for (int i = inUseFixOrderMassCancelRequest.length - 1; i >= 0; i--)
			if (!inUseFixOrderMassCancelRequest[i]) {
				inUseFixOrderMassCancelRequest[i] = true;
				return poolFixOrderMassCancelRequest[i];
			}

		boolean[] old_inUse = inUseFixOrderMassCancelRequest;
		inUseFixOrderMassCancelRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixOrderMassCancelRequest, 0, old_inUse.length);

		FixOrderMassCancelRequest[] old_pool = poolFixOrderMassCancelRequest;
		poolFixOrderMassCancelRequest = new FixOrderMassCancelRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixOrderMassCancelRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixOrderMassCancelRequest.length; i++) {
			poolFixOrderMassCancelRequest[i] = new FixOrderMassCancelRequest();
			inUseFixOrderMassCancelRequest[i] = false;
		}

		inUseFixOrderMassCancelRequest[poolFixOrderMassCancelRequest.length - 1] = true;
		return poolFixOrderMassCancelRequest[poolFixOrderMassCancelRequest.length - 1];
	}

	public FixOrderMassCancelReport getFixOrderMassCancelReport() {
		for (int i = inUseFixOrderMassCancelReport.length - 1; i >= 0; i--)
			if (!inUseFixOrderMassCancelReport[i]) {
				inUseFixOrderMassCancelReport[i] = true;
				return poolFixOrderMassCancelReport[i];
			}

		boolean[] old_inUse = inUseFixOrderMassCancelReport;
		inUseFixOrderMassCancelReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixOrderMassCancelReport, 0, old_inUse.length);

		FixOrderMassCancelReport[] old_pool = poolFixOrderMassCancelReport;
		poolFixOrderMassCancelReport = new FixOrderMassCancelReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixOrderMassCancelReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixOrderMassCancelReport.length; i++) {
			poolFixOrderMassCancelReport[i] = new FixOrderMassCancelReport();
			inUseFixOrderMassCancelReport[i] = false;
		}

		inUseFixOrderMassCancelReport[poolFixOrderMassCancelReport.length - 1] = true;
		return poolFixOrderMassCancelReport[poolFixOrderMassCancelReport.length - 1];
	}

	public FixNewOrderCross getFixNewOrderCross() {
		for (int i = inUseFixNewOrderCross.length - 1; i >= 0; i--)
			if (!inUseFixNewOrderCross[i]) {
				inUseFixNewOrderCross[i] = true;
				return poolFixNewOrderCross[i];
			}

		boolean[] old_inUse = inUseFixNewOrderCross;
		inUseFixNewOrderCross = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixNewOrderCross, 0, old_inUse.length);

		FixNewOrderCross[] old_pool = poolFixNewOrderCross;
		poolFixNewOrderCross = new FixNewOrderCross[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixNewOrderCross, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixNewOrderCross.length; i++) {
			poolFixNewOrderCross[i] = new FixNewOrderCross();
			inUseFixNewOrderCross[i] = false;
		}

		inUseFixNewOrderCross[poolFixNewOrderCross.length - 1] = true;
		return poolFixNewOrderCross[poolFixNewOrderCross.length - 1];
	}

	public FixCrossOrderCancelReplaceRequest getFixCrossOrderCancelReplaceRequest() {
		for (int i = inUseFixCrossOrderCancelReplaceRequest.length - 1; i >= 0; i--)
			if (!inUseFixCrossOrderCancelReplaceRequest[i]) {
				inUseFixCrossOrderCancelReplaceRequest[i] = true;
				return poolFixCrossOrderCancelReplaceRequest[i];
			}

		boolean[] old_inUse = inUseFixCrossOrderCancelReplaceRequest;
		inUseFixCrossOrderCancelReplaceRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixCrossOrderCancelReplaceRequest, 0, old_inUse.length);

		FixCrossOrderCancelReplaceRequest[] old_pool = poolFixCrossOrderCancelReplaceRequest;
		poolFixCrossOrderCancelReplaceRequest = new FixCrossOrderCancelReplaceRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixCrossOrderCancelReplaceRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixCrossOrderCancelReplaceRequest.length; i++) {
			poolFixCrossOrderCancelReplaceRequest[i] = new FixCrossOrderCancelReplaceRequest();
			inUseFixCrossOrderCancelReplaceRequest[i] = false;
		}

		inUseFixCrossOrderCancelReplaceRequest[poolFixCrossOrderCancelReplaceRequest.length - 1] = true;
		return poolFixCrossOrderCancelReplaceRequest[poolFixCrossOrderCancelReplaceRequest.length - 1];
	}

	public FixCrossOrderCancelRequest getFixCrossOrderCancelRequest() {
		for (int i = inUseFixCrossOrderCancelRequest.length - 1; i >= 0; i--)
			if (!inUseFixCrossOrderCancelRequest[i]) {
				inUseFixCrossOrderCancelRequest[i] = true;
				return poolFixCrossOrderCancelRequest[i];
			}

		boolean[] old_inUse = inUseFixCrossOrderCancelRequest;
		inUseFixCrossOrderCancelRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixCrossOrderCancelRequest, 0, old_inUse.length);

		FixCrossOrderCancelRequest[] old_pool = poolFixCrossOrderCancelRequest;
		poolFixCrossOrderCancelRequest = new FixCrossOrderCancelRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixCrossOrderCancelRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixCrossOrderCancelRequest.length; i++) {
			poolFixCrossOrderCancelRequest[i] = new FixCrossOrderCancelRequest();
			inUseFixCrossOrderCancelRequest[i] = false;
		}

		inUseFixCrossOrderCancelRequest[poolFixCrossOrderCancelRequest.length - 1] = true;
		return poolFixCrossOrderCancelRequest[poolFixCrossOrderCancelRequest.length - 1];
	}

	public FixSecurityTypeRequest getFixSecurityTypeRequest() {
		for (int i = inUseFixSecurityTypeRequest.length - 1; i >= 0; i--)
			if (!inUseFixSecurityTypeRequest[i]) {
				inUseFixSecurityTypeRequest[i] = true;
				return poolFixSecurityTypeRequest[i];
			}

		boolean[] old_inUse = inUseFixSecurityTypeRequest;
		inUseFixSecurityTypeRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixSecurityTypeRequest, 0, old_inUse.length);

		FixSecurityTypeRequest[] old_pool = poolFixSecurityTypeRequest;
		poolFixSecurityTypeRequest = new FixSecurityTypeRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixSecurityTypeRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixSecurityTypeRequest.length; i++) {
			poolFixSecurityTypeRequest[i] = new FixSecurityTypeRequest();
			inUseFixSecurityTypeRequest[i] = false;
		}

		inUseFixSecurityTypeRequest[poolFixSecurityTypeRequest.length - 1] = true;
		return poolFixSecurityTypeRequest[poolFixSecurityTypeRequest.length - 1];
	}

	public FixSecurityTypes getFixSecurityTypes() {
		for (int i = inUseFixSecurityTypes.length - 1; i >= 0; i--)
			if (!inUseFixSecurityTypes[i]) {
				inUseFixSecurityTypes[i] = true;
				return poolFixSecurityTypes[i];
			}

		boolean[] old_inUse = inUseFixSecurityTypes;
		inUseFixSecurityTypes = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixSecurityTypes, 0, old_inUse.length);

		FixSecurityTypes[] old_pool = poolFixSecurityTypes;
		poolFixSecurityTypes = new FixSecurityTypes[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixSecurityTypes, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixSecurityTypes.length; i++) {
			poolFixSecurityTypes[i] = new FixSecurityTypes();
			inUseFixSecurityTypes[i] = false;
		}

		inUseFixSecurityTypes[poolFixSecurityTypes.length - 1] = true;
		return poolFixSecurityTypes[poolFixSecurityTypes.length - 1];
	}

	public FixSecurityListRequest getFixSecurityListRequest() {
		for (int i = inUseFixSecurityListRequest.length - 1; i >= 0; i--)
			if (!inUseFixSecurityListRequest[i]) {
				inUseFixSecurityListRequest[i] = true;
				return poolFixSecurityListRequest[i];
			}

		boolean[] old_inUse = inUseFixSecurityListRequest;
		inUseFixSecurityListRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixSecurityListRequest, 0, old_inUse.length);

		FixSecurityListRequest[] old_pool = poolFixSecurityListRequest;
		poolFixSecurityListRequest = new FixSecurityListRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixSecurityListRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixSecurityListRequest.length; i++) {
			poolFixSecurityListRequest[i] = new FixSecurityListRequest();
			inUseFixSecurityListRequest[i] = false;
		}

		inUseFixSecurityListRequest[poolFixSecurityListRequest.length - 1] = true;
		return poolFixSecurityListRequest[poolFixSecurityListRequest.length - 1];
	}

	public FixSecurityList getFixSecurityList() {
		for (int i = inUseFixSecurityList.length - 1; i >= 0; i--)
			if (!inUseFixSecurityList[i]) {
				inUseFixSecurityList[i] = true;
				return poolFixSecurityList[i];
			}

		boolean[] old_inUse = inUseFixSecurityList;
		inUseFixSecurityList = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixSecurityList, 0, old_inUse.length);

		FixSecurityList[] old_pool = poolFixSecurityList;
		poolFixSecurityList = new FixSecurityList[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixSecurityList, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixSecurityList.length; i++) {
			poolFixSecurityList[i] = new FixSecurityList();
			inUseFixSecurityList[i] = false;
		}

		inUseFixSecurityList[poolFixSecurityList.length - 1] = true;
		return poolFixSecurityList[poolFixSecurityList.length - 1];
	}

	public FixDerivativeSecurityListRequest getFixDerivativeSecurityListRequest() {
		for (int i = inUseFixDerivativeSecurityListRequest.length - 1; i >= 0; i--)
			if (!inUseFixDerivativeSecurityListRequest[i]) {
				inUseFixDerivativeSecurityListRequest[i] = true;
				return poolFixDerivativeSecurityListRequest[i];
			}

		boolean[] old_inUse = inUseFixDerivativeSecurityListRequest;
		inUseFixDerivativeSecurityListRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixDerivativeSecurityListRequest, 0, old_inUse.length);

		FixDerivativeSecurityListRequest[] old_pool = poolFixDerivativeSecurityListRequest;
		poolFixDerivativeSecurityListRequest = new FixDerivativeSecurityListRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixDerivativeSecurityListRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixDerivativeSecurityListRequest.length; i++) {
			poolFixDerivativeSecurityListRequest[i] = new FixDerivativeSecurityListRequest();
			inUseFixDerivativeSecurityListRequest[i] = false;
		}

		inUseFixDerivativeSecurityListRequest[poolFixDerivativeSecurityListRequest.length - 1] = true;
		return poolFixDerivativeSecurityListRequest[poolFixDerivativeSecurityListRequest.length - 1];
	}

	public FixDerivativeSecurityList getFixDerivativeSecurityList() {
		for (int i = inUseFixDerivativeSecurityList.length - 1; i >= 0; i--)
			if (!inUseFixDerivativeSecurityList[i]) {
				inUseFixDerivativeSecurityList[i] = true;
				return poolFixDerivativeSecurityList[i];
			}

		boolean[] old_inUse = inUseFixDerivativeSecurityList;
		inUseFixDerivativeSecurityList = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixDerivativeSecurityList, 0, old_inUse.length);

		FixDerivativeSecurityList[] old_pool = poolFixDerivativeSecurityList;
		poolFixDerivativeSecurityList = new FixDerivativeSecurityList[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixDerivativeSecurityList, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixDerivativeSecurityList.length; i++) {
			poolFixDerivativeSecurityList[i] = new FixDerivativeSecurityList();
			inUseFixDerivativeSecurityList[i] = false;
		}

		inUseFixDerivativeSecurityList[poolFixDerivativeSecurityList.length - 1] = true;
		return poolFixDerivativeSecurityList[poolFixDerivativeSecurityList.length - 1];
	}

	public FixNewOrderMultileg getFixNewOrderMultileg() {
		for (int i = inUseFixNewOrderMultileg.length - 1; i >= 0; i--)
			if (!inUseFixNewOrderMultileg[i]) {
				inUseFixNewOrderMultileg[i] = true;
				return poolFixNewOrderMultileg[i];
			}

		boolean[] old_inUse = inUseFixNewOrderMultileg;
		inUseFixNewOrderMultileg = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixNewOrderMultileg, 0, old_inUse.length);

		FixNewOrderMultileg[] old_pool = poolFixNewOrderMultileg;
		poolFixNewOrderMultileg = new FixNewOrderMultileg[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixNewOrderMultileg, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixNewOrderMultileg.length; i++) {
			poolFixNewOrderMultileg[i] = new FixNewOrderMultileg();
			inUseFixNewOrderMultileg[i] = false;
		}

		inUseFixNewOrderMultileg[poolFixNewOrderMultileg.length - 1] = true;
		return poolFixNewOrderMultileg[poolFixNewOrderMultileg.length - 1];
	}

	public FixMultilegOrderCancelReplace getFixMultilegOrderCancelReplace() {
		for (int i = inUseFixMultilegOrderCancelReplace.length - 1; i >= 0; i--)
			if (!inUseFixMultilegOrderCancelReplace[i]) {
				inUseFixMultilegOrderCancelReplace[i] = true;
				return poolFixMultilegOrderCancelReplace[i];
			}

		boolean[] old_inUse = inUseFixMultilegOrderCancelReplace;
		inUseFixMultilegOrderCancelReplace = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixMultilegOrderCancelReplace, 0, old_inUse.length);

		FixMultilegOrderCancelReplace[] old_pool = poolFixMultilegOrderCancelReplace;
		poolFixMultilegOrderCancelReplace = new FixMultilegOrderCancelReplace[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixMultilegOrderCancelReplace, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixMultilegOrderCancelReplace.length; i++) {
			poolFixMultilegOrderCancelReplace[i] = new FixMultilegOrderCancelReplace();
			inUseFixMultilegOrderCancelReplace[i] = false;
		}

		inUseFixMultilegOrderCancelReplace[poolFixMultilegOrderCancelReplace.length - 1] = true;
		return poolFixMultilegOrderCancelReplace[poolFixMultilegOrderCancelReplace.length - 1];
	}

	public FixTradeCaptureReportRequest getFixTradeCaptureReportRequest() {
		for (int i = inUseFixTradeCaptureReportRequest.length - 1; i >= 0; i--)
			if (!inUseFixTradeCaptureReportRequest[i]) {
				inUseFixTradeCaptureReportRequest[i] = true;
				return poolFixTradeCaptureReportRequest[i];
			}

		boolean[] old_inUse = inUseFixTradeCaptureReportRequest;
		inUseFixTradeCaptureReportRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixTradeCaptureReportRequest, 0, old_inUse.length);

		FixTradeCaptureReportRequest[] old_pool = poolFixTradeCaptureReportRequest;
		poolFixTradeCaptureReportRequest = new FixTradeCaptureReportRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixTradeCaptureReportRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixTradeCaptureReportRequest.length; i++) {
			poolFixTradeCaptureReportRequest[i] = new FixTradeCaptureReportRequest();
			inUseFixTradeCaptureReportRequest[i] = false;
		}

		inUseFixTradeCaptureReportRequest[poolFixTradeCaptureReportRequest.length - 1] = true;
		return poolFixTradeCaptureReportRequest[poolFixTradeCaptureReportRequest.length - 1];
	}

	public FixTradeCaptureReport getFixTradeCaptureReport() {
		for (int i = inUseFixTradeCaptureReport.length - 1; i >= 0; i--)
			if (!inUseFixTradeCaptureReport[i]) {
				inUseFixTradeCaptureReport[i] = true;
				return poolFixTradeCaptureReport[i];
			}

		boolean[] old_inUse = inUseFixTradeCaptureReport;
		inUseFixTradeCaptureReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixTradeCaptureReport, 0, old_inUse.length);

		FixTradeCaptureReport[] old_pool = poolFixTradeCaptureReport;
		poolFixTradeCaptureReport = new FixTradeCaptureReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixTradeCaptureReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixTradeCaptureReport.length; i++) {
			poolFixTradeCaptureReport[i] = new FixTradeCaptureReport();
			inUseFixTradeCaptureReport[i] = false;
		}

		inUseFixTradeCaptureReport[poolFixTradeCaptureReport.length - 1] = true;
		return poolFixTradeCaptureReport[poolFixTradeCaptureReport.length - 1];
	}

	public FixOrderMassStatusRequest getFixOrderMassStatusRequest() {
		for (int i = inUseFixOrderMassStatusRequest.length - 1; i >= 0; i--)
			if (!inUseFixOrderMassStatusRequest[i]) {
				inUseFixOrderMassStatusRequest[i] = true;
				return poolFixOrderMassStatusRequest[i];
			}

		boolean[] old_inUse = inUseFixOrderMassStatusRequest;
		inUseFixOrderMassStatusRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixOrderMassStatusRequest, 0, old_inUse.length);

		FixOrderMassStatusRequest[] old_pool = poolFixOrderMassStatusRequest;
		poolFixOrderMassStatusRequest = new FixOrderMassStatusRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixOrderMassStatusRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixOrderMassStatusRequest.length; i++) {
			poolFixOrderMassStatusRequest[i] = new FixOrderMassStatusRequest();
			inUseFixOrderMassStatusRequest[i] = false;
		}

		inUseFixOrderMassStatusRequest[poolFixOrderMassStatusRequest.length - 1] = true;
		return poolFixOrderMassStatusRequest[poolFixOrderMassStatusRequest.length - 1];
	}

	public FixQuoteRequestReject getFixQuoteRequestReject() {
		for (int i = inUseFixQuoteRequestReject.length - 1; i >= 0; i--)
			if (!inUseFixQuoteRequestReject[i]) {
				inUseFixQuoteRequestReject[i] = true;
				return poolFixQuoteRequestReject[i];
			}

		boolean[] old_inUse = inUseFixQuoteRequestReject;
		inUseFixQuoteRequestReject = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixQuoteRequestReject, 0, old_inUse.length);

		FixQuoteRequestReject[] old_pool = poolFixQuoteRequestReject;
		poolFixQuoteRequestReject = new FixQuoteRequestReject[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixQuoteRequestReject, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixQuoteRequestReject.length; i++) {
			poolFixQuoteRequestReject[i] = new FixQuoteRequestReject();
			inUseFixQuoteRequestReject[i] = false;
		}

		inUseFixQuoteRequestReject[poolFixQuoteRequestReject.length - 1] = true;
		return poolFixQuoteRequestReject[poolFixQuoteRequestReject.length - 1];
	}

	public FixRFQRequest getFixRFQRequest() {
		for (int i = inUseFixRFQRequest.length - 1; i >= 0; i--)
			if (!inUseFixRFQRequest[i]) {
				inUseFixRFQRequest[i] = true;
				return poolFixRFQRequest[i];
			}

		boolean[] old_inUse = inUseFixRFQRequest;
		inUseFixRFQRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixRFQRequest, 0, old_inUse.length);

		FixRFQRequest[] old_pool = poolFixRFQRequest;
		poolFixRFQRequest = new FixRFQRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixRFQRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixRFQRequest.length; i++) {
			poolFixRFQRequest[i] = new FixRFQRequest();
			inUseFixRFQRequest[i] = false;
		}

		inUseFixRFQRequest[poolFixRFQRequest.length - 1] = true;
		return poolFixRFQRequest[poolFixRFQRequest.length - 1];
	}

	public FixQuoteStatusReport getFixQuoteStatusReport() {
		for (int i = inUseFixQuoteStatusReport.length - 1; i >= 0; i--)
			if (!inUseFixQuoteStatusReport[i]) {
				inUseFixQuoteStatusReport[i] = true;
				return poolFixQuoteStatusReport[i];
			}

		boolean[] old_inUse = inUseFixQuoteStatusReport;
		inUseFixQuoteStatusReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixQuoteStatusReport, 0, old_inUse.length);

		FixQuoteStatusReport[] old_pool = poolFixQuoteStatusReport;
		poolFixQuoteStatusReport = new FixQuoteStatusReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixQuoteStatusReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixQuoteStatusReport.length; i++) {
			poolFixQuoteStatusReport[i] = new FixQuoteStatusReport();
			inUseFixQuoteStatusReport[i] = false;
		}

		inUseFixQuoteStatusReport[poolFixQuoteStatusReport.length - 1] = true;
		return poolFixQuoteStatusReport[poolFixQuoteStatusReport.length - 1];
	}

	public FixQuoteResponse getFixQuoteResponse() {
		for (int i = inUseFixQuoteResponse.length - 1; i >= 0; i--)
			if (!inUseFixQuoteResponse[i]) {
				inUseFixQuoteResponse[i] = true;
				return poolFixQuoteResponse[i];
			}

		boolean[] old_inUse = inUseFixQuoteResponse;
		inUseFixQuoteResponse = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixQuoteResponse, 0, old_inUse.length);

		FixQuoteResponse[] old_pool = poolFixQuoteResponse;
		poolFixQuoteResponse = new FixQuoteResponse[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixQuoteResponse, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixQuoteResponse.length; i++) {
			poolFixQuoteResponse[i] = new FixQuoteResponse();
			inUseFixQuoteResponse[i] = false;
		}

		inUseFixQuoteResponse[poolFixQuoteResponse.length - 1] = true;
		return poolFixQuoteResponse[poolFixQuoteResponse.length - 1];
	}

	public FixConfirmation getFixConfirmation() {
		for (int i = inUseFixConfirmation.length - 1; i >= 0; i--)
			if (!inUseFixConfirmation[i]) {
				inUseFixConfirmation[i] = true;
				return poolFixConfirmation[i];
			}

		boolean[] old_inUse = inUseFixConfirmation;
		inUseFixConfirmation = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixConfirmation, 0, old_inUse.length);

		FixConfirmation[] old_pool = poolFixConfirmation;
		poolFixConfirmation = new FixConfirmation[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixConfirmation, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixConfirmation.length; i++) {
			poolFixConfirmation[i] = new FixConfirmation();
			inUseFixConfirmation[i] = false;
		}

		inUseFixConfirmation[poolFixConfirmation.length - 1] = true;
		return poolFixConfirmation[poolFixConfirmation.length - 1];
	}

	public FixPositionMaintenanceRequest getFixPositionMaintenanceRequest() {
		for (int i = inUseFixPositionMaintenanceRequest.length - 1; i >= 0; i--)
			if (!inUseFixPositionMaintenanceRequest[i]) {
				inUseFixPositionMaintenanceRequest[i] = true;
				return poolFixPositionMaintenanceRequest[i];
			}

		boolean[] old_inUse = inUseFixPositionMaintenanceRequest;
		inUseFixPositionMaintenanceRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixPositionMaintenanceRequest, 0, old_inUse.length);

		FixPositionMaintenanceRequest[] old_pool = poolFixPositionMaintenanceRequest;
		poolFixPositionMaintenanceRequest = new FixPositionMaintenanceRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixPositionMaintenanceRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixPositionMaintenanceRequest.length; i++) {
			poolFixPositionMaintenanceRequest[i] = new FixPositionMaintenanceRequest();
			inUseFixPositionMaintenanceRequest[i] = false;
		}

		inUseFixPositionMaintenanceRequest[poolFixPositionMaintenanceRequest.length - 1] = true;
		return poolFixPositionMaintenanceRequest[poolFixPositionMaintenanceRequest.length - 1];
	}

	public FixPositionMaintenanceReport getFixPositionMaintenanceReport() {
		for (int i = inUseFixPositionMaintenanceReport.length - 1; i >= 0; i--)
			if (!inUseFixPositionMaintenanceReport[i]) {
				inUseFixPositionMaintenanceReport[i] = true;
				return poolFixPositionMaintenanceReport[i];
			}

		boolean[] old_inUse = inUseFixPositionMaintenanceReport;
		inUseFixPositionMaintenanceReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixPositionMaintenanceReport, 0, old_inUse.length);

		FixPositionMaintenanceReport[] old_pool = poolFixPositionMaintenanceReport;
		poolFixPositionMaintenanceReport = new FixPositionMaintenanceReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixPositionMaintenanceReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixPositionMaintenanceReport.length; i++) {
			poolFixPositionMaintenanceReport[i] = new FixPositionMaintenanceReport();
			inUseFixPositionMaintenanceReport[i] = false;
		}

		inUseFixPositionMaintenanceReport[poolFixPositionMaintenanceReport.length - 1] = true;
		return poolFixPositionMaintenanceReport[poolFixPositionMaintenanceReport.length - 1];
	}

	public FixRequestForPositions getFixRequestForPositions() {
		for (int i = inUseFixRequestForPositions.length - 1; i >= 0; i--)
			if (!inUseFixRequestForPositions[i]) {
				inUseFixRequestForPositions[i] = true;
				return poolFixRequestForPositions[i];
			}

		boolean[] old_inUse = inUseFixRequestForPositions;
		inUseFixRequestForPositions = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixRequestForPositions, 0, old_inUse.length);

		FixRequestForPositions[] old_pool = poolFixRequestForPositions;
		poolFixRequestForPositions = new FixRequestForPositions[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixRequestForPositions, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixRequestForPositions.length; i++) {
			poolFixRequestForPositions[i] = new FixRequestForPositions();
			inUseFixRequestForPositions[i] = false;
		}

		inUseFixRequestForPositions[poolFixRequestForPositions.length - 1] = true;
		return poolFixRequestForPositions[poolFixRequestForPositions.length - 1];
	}

	public FixRequestForPositionsAck getFixRequestForPositionsAck() {
		for (int i = inUseFixRequestForPositionsAck.length - 1; i >= 0; i--)
			if (!inUseFixRequestForPositionsAck[i]) {
				inUseFixRequestForPositionsAck[i] = true;
				return poolFixRequestForPositionsAck[i];
			}

		boolean[] old_inUse = inUseFixRequestForPositionsAck;
		inUseFixRequestForPositionsAck = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixRequestForPositionsAck, 0, old_inUse.length);

		FixRequestForPositionsAck[] old_pool = poolFixRequestForPositionsAck;
		poolFixRequestForPositionsAck = new FixRequestForPositionsAck[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixRequestForPositionsAck, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixRequestForPositionsAck.length; i++) {
			poolFixRequestForPositionsAck[i] = new FixRequestForPositionsAck();
			inUseFixRequestForPositionsAck[i] = false;
		}

		inUseFixRequestForPositionsAck[poolFixRequestForPositionsAck.length - 1] = true;
		return poolFixRequestForPositionsAck[poolFixRequestForPositionsAck.length - 1];
	}

	public FixPositionReport getFixPositionReport() {
		for (int i = inUseFixPositionReport.length - 1; i >= 0; i--)
			if (!inUseFixPositionReport[i]) {
				inUseFixPositionReport[i] = true;
				return poolFixPositionReport[i];
			}

		boolean[] old_inUse = inUseFixPositionReport;
		inUseFixPositionReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixPositionReport, 0, old_inUse.length);

		FixPositionReport[] old_pool = poolFixPositionReport;
		poolFixPositionReport = new FixPositionReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixPositionReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixPositionReport.length; i++) {
			poolFixPositionReport[i] = new FixPositionReport();
			inUseFixPositionReport[i] = false;
		}

		inUseFixPositionReport[poolFixPositionReport.length - 1] = true;
		return poolFixPositionReport[poolFixPositionReport.length - 1];
	}

	public FixTradeCaptureReportRequestAck getFixTradeCaptureReportRequestAck() {
		for (int i = inUseFixTradeCaptureReportRequestAck.length - 1; i >= 0; i--)
			if (!inUseFixTradeCaptureReportRequestAck[i]) {
				inUseFixTradeCaptureReportRequestAck[i] = true;
				return poolFixTradeCaptureReportRequestAck[i];
			}

		boolean[] old_inUse = inUseFixTradeCaptureReportRequestAck;
		inUseFixTradeCaptureReportRequestAck = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixTradeCaptureReportRequestAck, 0, old_inUse.length);

		FixTradeCaptureReportRequestAck[] old_pool = poolFixTradeCaptureReportRequestAck;
		poolFixTradeCaptureReportRequestAck = new FixTradeCaptureReportRequestAck[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixTradeCaptureReportRequestAck, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixTradeCaptureReportRequestAck.length; i++) {
			poolFixTradeCaptureReportRequestAck[i] = new FixTradeCaptureReportRequestAck();
			inUseFixTradeCaptureReportRequestAck[i] = false;
		}

		inUseFixTradeCaptureReportRequestAck[poolFixTradeCaptureReportRequestAck.length - 1] = true;
		return poolFixTradeCaptureReportRequestAck[poolFixTradeCaptureReportRequestAck.length - 1];
	}

	public FixTradeCaptureReportAck getFixTradeCaptureReportAck() {
		for (int i = inUseFixTradeCaptureReportAck.length - 1; i >= 0; i--)
			if (!inUseFixTradeCaptureReportAck[i]) {
				inUseFixTradeCaptureReportAck[i] = true;
				return poolFixTradeCaptureReportAck[i];
			}

		boolean[] old_inUse = inUseFixTradeCaptureReportAck;
		inUseFixTradeCaptureReportAck = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixTradeCaptureReportAck, 0, old_inUse.length);

		FixTradeCaptureReportAck[] old_pool = poolFixTradeCaptureReportAck;
		poolFixTradeCaptureReportAck = new FixTradeCaptureReportAck[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixTradeCaptureReportAck, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixTradeCaptureReportAck.length; i++) {
			poolFixTradeCaptureReportAck[i] = new FixTradeCaptureReportAck();
			inUseFixTradeCaptureReportAck[i] = false;
		}

		inUseFixTradeCaptureReportAck[poolFixTradeCaptureReportAck.length - 1] = true;
		return poolFixTradeCaptureReportAck[poolFixTradeCaptureReportAck.length - 1];
	}

	public FixAllocationReport getFixAllocationReport() {
		for (int i = inUseFixAllocationReport.length - 1; i >= 0; i--)
			if (!inUseFixAllocationReport[i]) {
				inUseFixAllocationReport[i] = true;
				return poolFixAllocationReport[i];
			}

		boolean[] old_inUse = inUseFixAllocationReport;
		inUseFixAllocationReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixAllocationReport, 0, old_inUse.length);

		FixAllocationReport[] old_pool = poolFixAllocationReport;
		poolFixAllocationReport = new FixAllocationReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixAllocationReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixAllocationReport.length; i++) {
			poolFixAllocationReport[i] = new FixAllocationReport();
			inUseFixAllocationReport[i] = false;
		}

		inUseFixAllocationReport[poolFixAllocationReport.length - 1] = true;
		return poolFixAllocationReport[poolFixAllocationReport.length - 1];
	}

	public FixAllocationReportAck getFixAllocationReportAck() {
		for (int i = inUseFixAllocationReportAck.length - 1; i >= 0; i--)
			if (!inUseFixAllocationReportAck[i]) {
				inUseFixAllocationReportAck[i] = true;
				return poolFixAllocationReportAck[i];
			}

		boolean[] old_inUse = inUseFixAllocationReportAck;
		inUseFixAllocationReportAck = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixAllocationReportAck, 0, old_inUse.length);

		FixAllocationReportAck[] old_pool = poolFixAllocationReportAck;
		poolFixAllocationReportAck = new FixAllocationReportAck[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixAllocationReportAck, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixAllocationReportAck.length; i++) {
			poolFixAllocationReportAck[i] = new FixAllocationReportAck();
			inUseFixAllocationReportAck[i] = false;
		}

		inUseFixAllocationReportAck[poolFixAllocationReportAck.length - 1] = true;
		return poolFixAllocationReportAck[poolFixAllocationReportAck.length - 1];
	}

	public FixConfirmation_Ack getFixConfirmation_Ack() {
		for (int i = inUseFixConfirmation_Ack.length - 1; i >= 0; i--)
			if (!inUseFixConfirmation_Ack[i]) {
				inUseFixConfirmation_Ack[i] = true;
				return poolFixConfirmation_Ack[i];
			}

		boolean[] old_inUse = inUseFixConfirmation_Ack;
		inUseFixConfirmation_Ack = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixConfirmation_Ack, 0, old_inUse.length);

		FixConfirmation_Ack[] old_pool = poolFixConfirmation_Ack;
		poolFixConfirmation_Ack = new FixConfirmation_Ack[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixConfirmation_Ack, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixConfirmation_Ack.length; i++) {
			poolFixConfirmation_Ack[i] = new FixConfirmation_Ack();
			inUseFixConfirmation_Ack[i] = false;
		}

		inUseFixConfirmation_Ack[poolFixConfirmation_Ack.length - 1] = true;
		return poolFixConfirmation_Ack[poolFixConfirmation_Ack.length - 1];
	}

	public FixSettlementInstructionRequest getFixSettlementInstructionRequest() {
		for (int i = inUseFixSettlementInstructionRequest.length - 1; i >= 0; i--)
			if (!inUseFixSettlementInstructionRequest[i]) {
				inUseFixSettlementInstructionRequest[i] = true;
				return poolFixSettlementInstructionRequest[i];
			}

		boolean[] old_inUse = inUseFixSettlementInstructionRequest;
		inUseFixSettlementInstructionRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixSettlementInstructionRequest, 0, old_inUse.length);

		FixSettlementInstructionRequest[] old_pool = poolFixSettlementInstructionRequest;
		poolFixSettlementInstructionRequest = new FixSettlementInstructionRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixSettlementInstructionRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixSettlementInstructionRequest.length; i++) {
			poolFixSettlementInstructionRequest[i] = new FixSettlementInstructionRequest();
			inUseFixSettlementInstructionRequest[i] = false;
		}

		inUseFixSettlementInstructionRequest[poolFixSettlementInstructionRequest.length - 1] = true;
		return poolFixSettlementInstructionRequest[poolFixSettlementInstructionRequest.length - 1];
	}

	public FixAssignmentReport getFixAssignmentReport() {
		for (int i = inUseFixAssignmentReport.length - 1; i >= 0; i--)
			if (!inUseFixAssignmentReport[i]) {
				inUseFixAssignmentReport[i] = true;
				return poolFixAssignmentReport[i];
			}

		boolean[] old_inUse = inUseFixAssignmentReport;
		inUseFixAssignmentReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixAssignmentReport, 0, old_inUse.length);

		FixAssignmentReport[] old_pool = poolFixAssignmentReport;
		poolFixAssignmentReport = new FixAssignmentReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixAssignmentReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixAssignmentReport.length; i++) {
			poolFixAssignmentReport[i] = new FixAssignmentReport();
			inUseFixAssignmentReport[i] = false;
		}

		inUseFixAssignmentReport[poolFixAssignmentReport.length - 1] = true;
		return poolFixAssignmentReport[poolFixAssignmentReport.length - 1];
	}

	public FixCollateralRequest getFixCollateralRequest() {
		for (int i = inUseFixCollateralRequest.length - 1; i >= 0; i--)
			if (!inUseFixCollateralRequest[i]) {
				inUseFixCollateralRequest[i] = true;
				return poolFixCollateralRequest[i];
			}

		boolean[] old_inUse = inUseFixCollateralRequest;
		inUseFixCollateralRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixCollateralRequest, 0, old_inUse.length);

		FixCollateralRequest[] old_pool = poolFixCollateralRequest;
		poolFixCollateralRequest = new FixCollateralRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixCollateralRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixCollateralRequest.length; i++) {
			poolFixCollateralRequest[i] = new FixCollateralRequest();
			inUseFixCollateralRequest[i] = false;
		}

		inUseFixCollateralRequest[poolFixCollateralRequest.length - 1] = true;
		return poolFixCollateralRequest[poolFixCollateralRequest.length - 1];
	}

	public FixCollateralAssignment getFixCollateralAssignment() {
		for (int i = inUseFixCollateralAssignment.length - 1; i >= 0; i--)
			if (!inUseFixCollateralAssignment[i]) {
				inUseFixCollateralAssignment[i] = true;
				return poolFixCollateralAssignment[i];
			}

		boolean[] old_inUse = inUseFixCollateralAssignment;
		inUseFixCollateralAssignment = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixCollateralAssignment, 0, old_inUse.length);

		FixCollateralAssignment[] old_pool = poolFixCollateralAssignment;
		poolFixCollateralAssignment = new FixCollateralAssignment[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixCollateralAssignment, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixCollateralAssignment.length; i++) {
			poolFixCollateralAssignment[i] = new FixCollateralAssignment();
			inUseFixCollateralAssignment[i] = false;
		}

		inUseFixCollateralAssignment[poolFixCollateralAssignment.length - 1] = true;
		return poolFixCollateralAssignment[poolFixCollateralAssignment.length - 1];
	}

	public FixCollateralResponse getFixCollateralResponse() {
		for (int i = inUseFixCollateralResponse.length - 1; i >= 0; i--)
			if (!inUseFixCollateralResponse[i]) {
				inUseFixCollateralResponse[i] = true;
				return poolFixCollateralResponse[i];
			}

		boolean[] old_inUse = inUseFixCollateralResponse;
		inUseFixCollateralResponse = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixCollateralResponse, 0, old_inUse.length);

		FixCollateralResponse[] old_pool = poolFixCollateralResponse;
		poolFixCollateralResponse = new FixCollateralResponse[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixCollateralResponse, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixCollateralResponse.length; i++) {
			poolFixCollateralResponse[i] = new FixCollateralResponse();
			inUseFixCollateralResponse[i] = false;
		}

		inUseFixCollateralResponse[poolFixCollateralResponse.length - 1] = true;
		return poolFixCollateralResponse[poolFixCollateralResponse.length - 1];
	}

	public FixCollateralReport getFixCollateralReport() {
		for (int i = inUseFixCollateralReport.length - 1; i >= 0; i--)
			if (!inUseFixCollateralReport[i]) {
				inUseFixCollateralReport[i] = true;
				return poolFixCollateralReport[i];
			}

		boolean[] old_inUse = inUseFixCollateralReport;
		inUseFixCollateralReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixCollateralReport, 0, old_inUse.length);

		FixCollateralReport[] old_pool = poolFixCollateralReport;
		poolFixCollateralReport = new FixCollateralReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixCollateralReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixCollateralReport.length; i++) {
			poolFixCollateralReport[i] = new FixCollateralReport();
			inUseFixCollateralReport[i] = false;
		}

		inUseFixCollateralReport[poolFixCollateralReport.length - 1] = true;
		return poolFixCollateralReport[poolFixCollateralReport.length - 1];
	}

	public FixCollateralInquiry getFixCollateralInquiry() {
		for (int i = inUseFixCollateralInquiry.length - 1; i >= 0; i--)
			if (!inUseFixCollateralInquiry[i]) {
				inUseFixCollateralInquiry[i] = true;
				return poolFixCollateralInquiry[i];
			}

		boolean[] old_inUse = inUseFixCollateralInquiry;
		inUseFixCollateralInquiry = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixCollateralInquiry, 0, old_inUse.length);

		FixCollateralInquiry[] old_pool = poolFixCollateralInquiry;
		poolFixCollateralInquiry = new FixCollateralInquiry[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixCollateralInquiry, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixCollateralInquiry.length; i++) {
			poolFixCollateralInquiry[i] = new FixCollateralInquiry();
			inUseFixCollateralInquiry[i] = false;
		}

		inUseFixCollateralInquiry[poolFixCollateralInquiry.length - 1] = true;
		return poolFixCollateralInquiry[poolFixCollateralInquiry.length - 1];
	}

	public FixNetworkCounterpartySystemStatusRequest getFixNetworkCounterpartySystemStatusRequest() {
		for (int i = inUseFixNetworkCounterpartySystemStatusRequest.length - 1; i >= 0; i--)
			if (!inUseFixNetworkCounterpartySystemStatusRequest[i]) {
				inUseFixNetworkCounterpartySystemStatusRequest[i] = true;
				return poolFixNetworkCounterpartySystemStatusRequest[i];
			}

		boolean[] old_inUse = inUseFixNetworkCounterpartySystemStatusRequest;
		inUseFixNetworkCounterpartySystemStatusRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixNetworkCounterpartySystemStatusRequest, 0, old_inUse.length);

		FixNetworkCounterpartySystemStatusRequest[] old_pool = poolFixNetworkCounterpartySystemStatusRequest;
		poolFixNetworkCounterpartySystemStatusRequest = new FixNetworkCounterpartySystemStatusRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixNetworkCounterpartySystemStatusRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixNetworkCounterpartySystemStatusRequest.length; i++) {
			poolFixNetworkCounterpartySystemStatusRequest[i] = new FixNetworkCounterpartySystemStatusRequest();
			inUseFixNetworkCounterpartySystemStatusRequest[i] = false;
		}

		inUseFixNetworkCounterpartySystemStatusRequest[poolFixNetworkCounterpartySystemStatusRequest.length - 1] = true;
		return poolFixNetworkCounterpartySystemStatusRequest[poolFixNetworkCounterpartySystemStatusRequest.length - 1];
	}

	public FixNetworkCounterpartySystemStatusResponse getFixNetworkCounterpartySystemStatusResponse() {
		for (int i = inUseFixNetworkCounterpartySystemStatusResponse.length - 1; i >= 0; i--)
			if (!inUseFixNetworkCounterpartySystemStatusResponse[i]) {
				inUseFixNetworkCounterpartySystemStatusResponse[i] = true;
				return poolFixNetworkCounterpartySystemStatusResponse[i];
			}

		boolean[] old_inUse = inUseFixNetworkCounterpartySystemStatusResponse;
		inUseFixNetworkCounterpartySystemStatusResponse = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixNetworkCounterpartySystemStatusResponse, 0, old_inUse.length);

		FixNetworkCounterpartySystemStatusResponse[] old_pool = poolFixNetworkCounterpartySystemStatusResponse;
		poolFixNetworkCounterpartySystemStatusResponse = new FixNetworkCounterpartySystemStatusResponse[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixNetworkCounterpartySystemStatusResponse, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixNetworkCounterpartySystemStatusResponse.length; i++) {
			poolFixNetworkCounterpartySystemStatusResponse[i] = new FixNetworkCounterpartySystemStatusResponse();
			inUseFixNetworkCounterpartySystemStatusResponse[i] = false;
		}

		inUseFixNetworkCounterpartySystemStatusResponse[poolFixNetworkCounterpartySystemStatusResponse.length - 1] = true;
		return poolFixNetworkCounterpartySystemStatusResponse[poolFixNetworkCounterpartySystemStatusResponse.length - 1];
	}

	public FixUserRequest getFixUserRequest() {
		for (int i = inUseFixUserRequest.length - 1; i >= 0; i--)
			if (!inUseFixUserRequest[i]) {
				inUseFixUserRequest[i] = true;
				return poolFixUserRequest[i];
			}

		boolean[] old_inUse = inUseFixUserRequest;
		inUseFixUserRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixUserRequest, 0, old_inUse.length);

		FixUserRequest[] old_pool = poolFixUserRequest;
		poolFixUserRequest = new FixUserRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixUserRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixUserRequest.length; i++) {
			poolFixUserRequest[i] = new FixUserRequest();
			inUseFixUserRequest[i] = false;
		}

		inUseFixUserRequest[poolFixUserRequest.length - 1] = true;
		return poolFixUserRequest[poolFixUserRequest.length - 1];
	}

	public FixUserResponse getFixUserResponse() {
		for (int i = inUseFixUserResponse.length - 1; i >= 0; i--)
			if (!inUseFixUserResponse[i]) {
				inUseFixUserResponse[i] = true;
				return poolFixUserResponse[i];
			}

		boolean[] old_inUse = inUseFixUserResponse;
		inUseFixUserResponse = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixUserResponse, 0, old_inUse.length);

		FixUserResponse[] old_pool = poolFixUserResponse;
		poolFixUserResponse = new FixUserResponse[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixUserResponse, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixUserResponse.length; i++) {
			poolFixUserResponse[i] = new FixUserResponse();
			inUseFixUserResponse[i] = false;
		}

		inUseFixUserResponse[poolFixUserResponse.length - 1] = true;
		return poolFixUserResponse[poolFixUserResponse.length - 1];
	}

	public FixCollateralInquiryAck getFixCollateralInquiryAck() {
		for (int i = inUseFixCollateralInquiryAck.length - 1; i >= 0; i--)
			if (!inUseFixCollateralInquiryAck[i]) {
				inUseFixCollateralInquiryAck[i] = true;
				return poolFixCollateralInquiryAck[i];
			}

		boolean[] old_inUse = inUseFixCollateralInquiryAck;
		inUseFixCollateralInquiryAck = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixCollateralInquiryAck, 0, old_inUse.length);

		FixCollateralInquiryAck[] old_pool = poolFixCollateralInquiryAck;
		poolFixCollateralInquiryAck = new FixCollateralInquiryAck[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixCollateralInquiryAck, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixCollateralInquiryAck.length; i++) {
			poolFixCollateralInquiryAck[i] = new FixCollateralInquiryAck();
			inUseFixCollateralInquiryAck[i] = false;
		}

		inUseFixCollateralInquiryAck[poolFixCollateralInquiryAck.length - 1] = true;
		return poolFixCollateralInquiryAck[poolFixCollateralInquiryAck.length - 1];
	}

	public FixConfirmationRequest getFixConfirmationRequest() {
		for (int i = inUseFixConfirmationRequest.length - 1; i >= 0; i--)
			if (!inUseFixConfirmationRequest[i]) {
				inUseFixConfirmationRequest[i] = true;
				return poolFixConfirmationRequest[i];
			}

		boolean[] old_inUse = inUseFixConfirmationRequest;
		inUseFixConfirmationRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixConfirmationRequest, 0, old_inUse.length);

		FixConfirmationRequest[] old_pool = poolFixConfirmationRequest;
		poolFixConfirmationRequest = new FixConfirmationRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixConfirmationRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixConfirmationRequest.length; i++) {
			poolFixConfirmationRequest[i] = new FixConfirmationRequest();
			inUseFixConfirmationRequest[i] = false;
		}

		inUseFixConfirmationRequest[poolFixConfirmationRequest.length - 1] = true;
		return poolFixConfirmationRequest[poolFixConfirmationRequest.length - 1];
	}

	public FixContraryIntentionReport getFixContraryIntentionReport() {
		for (int i = inUseFixContraryIntentionReport.length - 1; i >= 0; i--)
			if (!inUseFixContraryIntentionReport[i]) {
				inUseFixContraryIntentionReport[i] = true;
				return poolFixContraryIntentionReport[i];
			}

		boolean[] old_inUse = inUseFixContraryIntentionReport;
		inUseFixContraryIntentionReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixContraryIntentionReport, 0, old_inUse.length);

		FixContraryIntentionReport[] old_pool = poolFixContraryIntentionReport;
		poolFixContraryIntentionReport = new FixContraryIntentionReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixContraryIntentionReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixContraryIntentionReport.length; i++) {
			poolFixContraryIntentionReport[i] = new FixContraryIntentionReport();
			inUseFixContraryIntentionReport[i] = false;
		}

		inUseFixContraryIntentionReport[poolFixContraryIntentionReport.length - 1] = true;
		return poolFixContraryIntentionReport[poolFixContraryIntentionReport.length - 1];
	}

	public FixSecurityDefinitionUpdateReport getFixSecurityDefinitionUpdateReport() {
		for (int i = inUseFixSecurityDefinitionUpdateReport.length - 1; i >= 0; i--)
			if (!inUseFixSecurityDefinitionUpdateReport[i]) {
				inUseFixSecurityDefinitionUpdateReport[i] = true;
				return poolFixSecurityDefinitionUpdateReport[i];
			}

		boolean[] old_inUse = inUseFixSecurityDefinitionUpdateReport;
		inUseFixSecurityDefinitionUpdateReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixSecurityDefinitionUpdateReport, 0, old_inUse.length);

		FixSecurityDefinitionUpdateReport[] old_pool = poolFixSecurityDefinitionUpdateReport;
		poolFixSecurityDefinitionUpdateReport = new FixSecurityDefinitionUpdateReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixSecurityDefinitionUpdateReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixSecurityDefinitionUpdateReport.length; i++) {
			poolFixSecurityDefinitionUpdateReport[i] = new FixSecurityDefinitionUpdateReport();
			inUseFixSecurityDefinitionUpdateReport[i] = false;
		}

		inUseFixSecurityDefinitionUpdateReport[poolFixSecurityDefinitionUpdateReport.length - 1] = true;
		return poolFixSecurityDefinitionUpdateReport[poolFixSecurityDefinitionUpdateReport.length - 1];
	}

	public FixSecurityListUpdateReport getFixSecurityListUpdateReport() {
		for (int i = inUseFixSecurityListUpdateReport.length - 1; i >= 0; i--)
			if (!inUseFixSecurityListUpdateReport[i]) {
				inUseFixSecurityListUpdateReport[i] = true;
				return poolFixSecurityListUpdateReport[i];
			}

		boolean[] old_inUse = inUseFixSecurityListUpdateReport;
		inUseFixSecurityListUpdateReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixSecurityListUpdateReport, 0, old_inUse.length);

		FixSecurityListUpdateReport[] old_pool = poolFixSecurityListUpdateReport;
		poolFixSecurityListUpdateReport = new FixSecurityListUpdateReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixSecurityListUpdateReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixSecurityListUpdateReport.length; i++) {
			poolFixSecurityListUpdateReport[i] = new FixSecurityListUpdateReport();
			inUseFixSecurityListUpdateReport[i] = false;
		}

		inUseFixSecurityListUpdateReport[poolFixSecurityListUpdateReport.length - 1] = true;
		return poolFixSecurityListUpdateReport[poolFixSecurityListUpdateReport.length - 1];
	}

	public FixAdjustedPositionReport getFixAdjustedPositionReport() {
		for (int i = inUseFixAdjustedPositionReport.length - 1; i >= 0; i--)
			if (!inUseFixAdjustedPositionReport[i]) {
				inUseFixAdjustedPositionReport[i] = true;
				return poolFixAdjustedPositionReport[i];
			}

		boolean[] old_inUse = inUseFixAdjustedPositionReport;
		inUseFixAdjustedPositionReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixAdjustedPositionReport, 0, old_inUse.length);

		FixAdjustedPositionReport[] old_pool = poolFixAdjustedPositionReport;
		poolFixAdjustedPositionReport = new FixAdjustedPositionReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixAdjustedPositionReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixAdjustedPositionReport.length; i++) {
			poolFixAdjustedPositionReport[i] = new FixAdjustedPositionReport();
			inUseFixAdjustedPositionReport[i] = false;
		}

		inUseFixAdjustedPositionReport[poolFixAdjustedPositionReport.length - 1] = true;
		return poolFixAdjustedPositionReport[poolFixAdjustedPositionReport.length - 1];
	}

	public FixAllocationInstructionAlert getFixAllocationInstructionAlert() {
		for (int i = inUseFixAllocationInstructionAlert.length - 1; i >= 0; i--)
			if (!inUseFixAllocationInstructionAlert[i]) {
				inUseFixAllocationInstructionAlert[i] = true;
				return poolFixAllocationInstructionAlert[i];
			}

		boolean[] old_inUse = inUseFixAllocationInstructionAlert;
		inUseFixAllocationInstructionAlert = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixAllocationInstructionAlert, 0, old_inUse.length);

		FixAllocationInstructionAlert[] old_pool = poolFixAllocationInstructionAlert;
		poolFixAllocationInstructionAlert = new FixAllocationInstructionAlert[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixAllocationInstructionAlert, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixAllocationInstructionAlert.length; i++) {
			poolFixAllocationInstructionAlert[i] = new FixAllocationInstructionAlert();
			inUseFixAllocationInstructionAlert[i] = false;
		}

		inUseFixAllocationInstructionAlert[poolFixAllocationInstructionAlert.length - 1] = true;
		return poolFixAllocationInstructionAlert[poolFixAllocationInstructionAlert.length - 1];
	}

	public FixExecutionAcknowledgement getFixExecutionAcknowledgement() {
		for (int i = inUseFixExecutionAcknowledgement.length - 1; i >= 0; i--)
			if (!inUseFixExecutionAcknowledgement[i]) {
				inUseFixExecutionAcknowledgement[i] = true;
				return poolFixExecutionAcknowledgement[i];
			}

		boolean[] old_inUse = inUseFixExecutionAcknowledgement;
		inUseFixExecutionAcknowledgement = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixExecutionAcknowledgement, 0, old_inUse.length);

		FixExecutionAcknowledgement[] old_pool = poolFixExecutionAcknowledgement;
		poolFixExecutionAcknowledgement = new FixExecutionAcknowledgement[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixExecutionAcknowledgement, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixExecutionAcknowledgement.length; i++) {
			poolFixExecutionAcknowledgement[i] = new FixExecutionAcknowledgement();
			inUseFixExecutionAcknowledgement[i] = false;
		}

		inUseFixExecutionAcknowledgement[poolFixExecutionAcknowledgement.length - 1] = true;
		return poolFixExecutionAcknowledgement[poolFixExecutionAcknowledgement.length - 1];
	}

	public FixTradingSessionList getFixTradingSessionList() {
		for (int i = inUseFixTradingSessionList.length - 1; i >= 0; i--)
			if (!inUseFixTradingSessionList[i]) {
				inUseFixTradingSessionList[i] = true;
				return poolFixTradingSessionList[i];
			}

		boolean[] old_inUse = inUseFixTradingSessionList;
		inUseFixTradingSessionList = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixTradingSessionList, 0, old_inUse.length);

		FixTradingSessionList[] old_pool = poolFixTradingSessionList;
		poolFixTradingSessionList = new FixTradingSessionList[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixTradingSessionList, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixTradingSessionList.length; i++) {
			poolFixTradingSessionList[i] = new FixTradingSessionList();
			inUseFixTradingSessionList[i] = false;
		}

		inUseFixTradingSessionList[poolFixTradingSessionList.length - 1] = true;
		return poolFixTradingSessionList[poolFixTradingSessionList.length - 1];
	}

	public FixTradingSessionListRequest getFixTradingSessionListRequest() {
		for (int i = inUseFixTradingSessionListRequest.length - 1; i >= 0; i--)
			if (!inUseFixTradingSessionListRequest[i]) {
				inUseFixTradingSessionListRequest[i] = true;
				return poolFixTradingSessionListRequest[i];
			}

		boolean[] old_inUse = inUseFixTradingSessionListRequest;
		inUseFixTradingSessionListRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixTradingSessionListRequest, 0, old_inUse.length);

		FixTradingSessionListRequest[] old_pool = poolFixTradingSessionListRequest;
		poolFixTradingSessionListRequest = new FixTradingSessionListRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixTradingSessionListRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixTradingSessionListRequest.length; i++) {
			poolFixTradingSessionListRequest[i] = new FixTradingSessionListRequest();
			inUseFixTradingSessionListRequest[i] = false;
		}

		inUseFixTradingSessionListRequest[poolFixTradingSessionListRequest.length - 1] = true;
		return poolFixTradingSessionListRequest[poolFixTradingSessionListRequest.length - 1];
	}

	public FixSettlementObligationReport getFixSettlementObligationReport() {
		for (int i = inUseFixSettlementObligationReport.length - 1; i >= 0; i--)
			if (!inUseFixSettlementObligationReport[i]) {
				inUseFixSettlementObligationReport[i] = true;
				return poolFixSettlementObligationReport[i];
			}

		boolean[] old_inUse = inUseFixSettlementObligationReport;
		inUseFixSettlementObligationReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixSettlementObligationReport, 0, old_inUse.length);

		FixSettlementObligationReport[] old_pool = poolFixSettlementObligationReport;
		poolFixSettlementObligationReport = new FixSettlementObligationReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixSettlementObligationReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixSettlementObligationReport.length; i++) {
			poolFixSettlementObligationReport[i] = new FixSettlementObligationReport();
			inUseFixSettlementObligationReport[i] = false;
		}

		inUseFixSettlementObligationReport[poolFixSettlementObligationReport.length - 1] = true;
		return poolFixSettlementObligationReport[poolFixSettlementObligationReport.length - 1];
	}

	public FixDerivativeSecurityListUpdateReport getFixDerivativeSecurityListUpdateReport() {
		for (int i = inUseFixDerivativeSecurityListUpdateReport.length - 1; i >= 0; i--)
			if (!inUseFixDerivativeSecurityListUpdateReport[i]) {
				inUseFixDerivativeSecurityListUpdateReport[i] = true;
				return poolFixDerivativeSecurityListUpdateReport[i];
			}

		boolean[] old_inUse = inUseFixDerivativeSecurityListUpdateReport;
		inUseFixDerivativeSecurityListUpdateReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixDerivativeSecurityListUpdateReport, 0, old_inUse.length);

		FixDerivativeSecurityListUpdateReport[] old_pool = poolFixDerivativeSecurityListUpdateReport;
		poolFixDerivativeSecurityListUpdateReport = new FixDerivativeSecurityListUpdateReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixDerivativeSecurityListUpdateReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixDerivativeSecurityListUpdateReport.length; i++) {
			poolFixDerivativeSecurityListUpdateReport[i] = new FixDerivativeSecurityListUpdateReport();
			inUseFixDerivativeSecurityListUpdateReport[i] = false;
		}

		inUseFixDerivativeSecurityListUpdateReport[poolFixDerivativeSecurityListUpdateReport.length - 1] = true;
		return poolFixDerivativeSecurityListUpdateReport[poolFixDerivativeSecurityListUpdateReport.length - 1];
	}

	public FixTradingSessionListUpdateReport getFixTradingSessionListUpdateReport() {
		for (int i = inUseFixTradingSessionListUpdateReport.length - 1; i >= 0; i--)
			if (!inUseFixTradingSessionListUpdateReport[i]) {
				inUseFixTradingSessionListUpdateReport[i] = true;
				return poolFixTradingSessionListUpdateReport[i];
			}

		boolean[] old_inUse = inUseFixTradingSessionListUpdateReport;
		inUseFixTradingSessionListUpdateReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixTradingSessionListUpdateReport, 0, old_inUse.length);

		FixTradingSessionListUpdateReport[] old_pool = poolFixTradingSessionListUpdateReport;
		poolFixTradingSessionListUpdateReport = new FixTradingSessionListUpdateReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixTradingSessionListUpdateReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixTradingSessionListUpdateReport.length; i++) {
			poolFixTradingSessionListUpdateReport[i] = new FixTradingSessionListUpdateReport();
			inUseFixTradingSessionListUpdateReport[i] = false;
		}

		inUseFixTradingSessionListUpdateReport[poolFixTradingSessionListUpdateReport.length - 1] = true;
		return poolFixTradingSessionListUpdateReport[poolFixTradingSessionListUpdateReport.length - 1];
	}

	public FixMarketDefinitionRequest getFixMarketDefinitionRequest() {
		for (int i = inUseFixMarketDefinitionRequest.length - 1; i >= 0; i--)
			if (!inUseFixMarketDefinitionRequest[i]) {
				inUseFixMarketDefinitionRequest[i] = true;
				return poolFixMarketDefinitionRequest[i];
			}

		boolean[] old_inUse = inUseFixMarketDefinitionRequest;
		inUseFixMarketDefinitionRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixMarketDefinitionRequest, 0, old_inUse.length);

		FixMarketDefinitionRequest[] old_pool = poolFixMarketDefinitionRequest;
		poolFixMarketDefinitionRequest = new FixMarketDefinitionRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixMarketDefinitionRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixMarketDefinitionRequest.length; i++) {
			poolFixMarketDefinitionRequest[i] = new FixMarketDefinitionRequest();
			inUseFixMarketDefinitionRequest[i] = false;
		}

		inUseFixMarketDefinitionRequest[poolFixMarketDefinitionRequest.length - 1] = true;
		return poolFixMarketDefinitionRequest[poolFixMarketDefinitionRequest.length - 1];
	}

	public FixMarketDefinition getFixMarketDefinition() {
		for (int i = inUseFixMarketDefinition.length - 1; i >= 0; i--)
			if (!inUseFixMarketDefinition[i]) {
				inUseFixMarketDefinition[i] = true;
				return poolFixMarketDefinition[i];
			}

		boolean[] old_inUse = inUseFixMarketDefinition;
		inUseFixMarketDefinition = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixMarketDefinition, 0, old_inUse.length);

		FixMarketDefinition[] old_pool = poolFixMarketDefinition;
		poolFixMarketDefinition = new FixMarketDefinition[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixMarketDefinition, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixMarketDefinition.length; i++) {
			poolFixMarketDefinition[i] = new FixMarketDefinition();
			inUseFixMarketDefinition[i] = false;
		}

		inUseFixMarketDefinition[poolFixMarketDefinition.length - 1] = true;
		return poolFixMarketDefinition[poolFixMarketDefinition.length - 1];
	}

	public FixMarketDefinitionUpdateReport getFixMarketDefinitionUpdateReport() {
		for (int i = inUseFixMarketDefinitionUpdateReport.length - 1; i >= 0; i--)
			if (!inUseFixMarketDefinitionUpdateReport[i]) {
				inUseFixMarketDefinitionUpdateReport[i] = true;
				return poolFixMarketDefinitionUpdateReport[i];
			}

		boolean[] old_inUse = inUseFixMarketDefinitionUpdateReport;
		inUseFixMarketDefinitionUpdateReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixMarketDefinitionUpdateReport, 0, old_inUse.length);

		FixMarketDefinitionUpdateReport[] old_pool = poolFixMarketDefinitionUpdateReport;
		poolFixMarketDefinitionUpdateReport = new FixMarketDefinitionUpdateReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixMarketDefinitionUpdateReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixMarketDefinitionUpdateReport.length; i++) {
			poolFixMarketDefinitionUpdateReport[i] = new FixMarketDefinitionUpdateReport();
			inUseFixMarketDefinitionUpdateReport[i] = false;
		}

		inUseFixMarketDefinitionUpdateReport[poolFixMarketDefinitionUpdateReport.length - 1] = true;
		return poolFixMarketDefinitionUpdateReport[poolFixMarketDefinitionUpdateReport.length - 1];
	}

	public FixUserNotification getFixUserNotification() {
		for (int i = inUseFixUserNotification.length - 1; i >= 0; i--)
			if (!inUseFixUserNotification[i]) {
				inUseFixUserNotification[i] = true;
				return poolFixUserNotification[i];
			}

		boolean[] old_inUse = inUseFixUserNotification;
		inUseFixUserNotification = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixUserNotification, 0, old_inUse.length);

		FixUserNotification[] old_pool = poolFixUserNotification;
		poolFixUserNotification = new FixUserNotification[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixUserNotification, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixUserNotification.length; i++) {
			poolFixUserNotification[i] = new FixUserNotification();
			inUseFixUserNotification[i] = false;
		}

		inUseFixUserNotification[poolFixUserNotification.length - 1] = true;
		return poolFixUserNotification[poolFixUserNotification.length - 1];
	}

	public FixOrderMassActionReport getFixOrderMassActionReport() {
		for (int i = inUseFixOrderMassActionReport.length - 1; i >= 0; i--)
			if (!inUseFixOrderMassActionReport[i]) {
				inUseFixOrderMassActionReport[i] = true;
				return poolFixOrderMassActionReport[i];
			}

		boolean[] old_inUse = inUseFixOrderMassActionReport;
		inUseFixOrderMassActionReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixOrderMassActionReport, 0, old_inUse.length);

		FixOrderMassActionReport[] old_pool = poolFixOrderMassActionReport;
		poolFixOrderMassActionReport = new FixOrderMassActionReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixOrderMassActionReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixOrderMassActionReport.length; i++) {
			poolFixOrderMassActionReport[i] = new FixOrderMassActionReport();
			inUseFixOrderMassActionReport[i] = false;
		}

		inUseFixOrderMassActionReport[poolFixOrderMassActionReport.length - 1] = true;
		return poolFixOrderMassActionReport[poolFixOrderMassActionReport.length - 1];
	}

	public FixOrderMassActionRequest getFixOrderMassActionRequest() {
		for (int i = inUseFixOrderMassActionRequest.length - 1; i >= 0; i--)
			if (!inUseFixOrderMassActionRequest[i]) {
				inUseFixOrderMassActionRequest[i] = true;
				return poolFixOrderMassActionRequest[i];
			}

		boolean[] old_inUse = inUseFixOrderMassActionRequest;
		inUseFixOrderMassActionRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixOrderMassActionRequest, 0, old_inUse.length);

		FixOrderMassActionRequest[] old_pool = poolFixOrderMassActionRequest;
		poolFixOrderMassActionRequest = new FixOrderMassActionRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixOrderMassActionRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixOrderMassActionRequest.length; i++) {
			poolFixOrderMassActionRequest[i] = new FixOrderMassActionRequest();
			inUseFixOrderMassActionRequest[i] = false;
		}

		inUseFixOrderMassActionRequest[poolFixOrderMassActionRequest.length - 1] = true;
		return poolFixOrderMassActionRequest[poolFixOrderMassActionRequest.length - 1];
	}

	public FixApplicationMessageRequest getFixApplicationMessageRequest() {
		for (int i = inUseFixApplicationMessageRequest.length - 1; i >= 0; i--)
			if (!inUseFixApplicationMessageRequest[i]) {
				inUseFixApplicationMessageRequest[i] = true;
				return poolFixApplicationMessageRequest[i];
			}

		boolean[] old_inUse = inUseFixApplicationMessageRequest;
		inUseFixApplicationMessageRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixApplicationMessageRequest, 0, old_inUse.length);

		FixApplicationMessageRequest[] old_pool = poolFixApplicationMessageRequest;
		poolFixApplicationMessageRequest = new FixApplicationMessageRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixApplicationMessageRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixApplicationMessageRequest.length; i++) {
			poolFixApplicationMessageRequest[i] = new FixApplicationMessageRequest();
			inUseFixApplicationMessageRequest[i] = false;
		}

		inUseFixApplicationMessageRequest[poolFixApplicationMessageRequest.length - 1] = true;
		return poolFixApplicationMessageRequest[poolFixApplicationMessageRequest.length - 1];
	}

	public FixApplicationMessageRequestAck getFixApplicationMessageRequestAck() {
		for (int i = inUseFixApplicationMessageRequestAck.length - 1; i >= 0; i--)
			if (!inUseFixApplicationMessageRequestAck[i]) {
				inUseFixApplicationMessageRequestAck[i] = true;
				return poolFixApplicationMessageRequestAck[i];
			}

		boolean[] old_inUse = inUseFixApplicationMessageRequestAck;
		inUseFixApplicationMessageRequestAck = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixApplicationMessageRequestAck, 0, old_inUse.length);

		FixApplicationMessageRequestAck[] old_pool = poolFixApplicationMessageRequestAck;
		poolFixApplicationMessageRequestAck = new FixApplicationMessageRequestAck[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixApplicationMessageRequestAck, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixApplicationMessageRequestAck.length; i++) {
			poolFixApplicationMessageRequestAck[i] = new FixApplicationMessageRequestAck();
			inUseFixApplicationMessageRequestAck[i] = false;
		}

		inUseFixApplicationMessageRequestAck[poolFixApplicationMessageRequestAck.length - 1] = true;
		return poolFixApplicationMessageRequestAck[poolFixApplicationMessageRequestAck.length - 1];
	}

	public FixApplicationMessageReport getFixApplicationMessageReport() {
		for (int i = inUseFixApplicationMessageReport.length - 1; i >= 0; i--)
			if (!inUseFixApplicationMessageReport[i]) {
				inUseFixApplicationMessageReport[i] = true;
				return poolFixApplicationMessageReport[i];
			}

		boolean[] old_inUse = inUseFixApplicationMessageReport;
		inUseFixApplicationMessageReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixApplicationMessageReport, 0, old_inUse.length);

		FixApplicationMessageReport[] old_pool = poolFixApplicationMessageReport;
		poolFixApplicationMessageReport = new FixApplicationMessageReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixApplicationMessageReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixApplicationMessageReport.length; i++) {
			poolFixApplicationMessageReport[i] = new FixApplicationMessageReport();
			inUseFixApplicationMessageReport[i] = false;
		}

		inUseFixApplicationMessageReport[poolFixApplicationMessageReport.length - 1] = true;
		return poolFixApplicationMessageReport[poolFixApplicationMessageReport.length - 1];
	}

	public FixStreamAssignmentRequest getFixStreamAssignmentRequest() {
		for (int i = inUseFixStreamAssignmentRequest.length - 1; i >= 0; i--)
			if (!inUseFixStreamAssignmentRequest[i]) {
				inUseFixStreamAssignmentRequest[i] = true;
				return poolFixStreamAssignmentRequest[i];
			}

		boolean[] old_inUse = inUseFixStreamAssignmentRequest;
		inUseFixStreamAssignmentRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixStreamAssignmentRequest, 0, old_inUse.length);

		FixStreamAssignmentRequest[] old_pool = poolFixStreamAssignmentRequest;
		poolFixStreamAssignmentRequest = new FixStreamAssignmentRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixStreamAssignmentRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixStreamAssignmentRequest.length; i++) {
			poolFixStreamAssignmentRequest[i] = new FixStreamAssignmentRequest();
			inUseFixStreamAssignmentRequest[i] = false;
		}

		inUseFixStreamAssignmentRequest[poolFixStreamAssignmentRequest.length - 1] = true;
		return poolFixStreamAssignmentRequest[poolFixStreamAssignmentRequest.length - 1];
	}

	public FixStreamAssignmentReport getFixStreamAssignmentReport() {
		for (int i = inUseFixStreamAssignmentReport.length - 1; i >= 0; i--)
			if (!inUseFixStreamAssignmentReport[i]) {
				inUseFixStreamAssignmentReport[i] = true;
				return poolFixStreamAssignmentReport[i];
			}

		boolean[] old_inUse = inUseFixStreamAssignmentReport;
		inUseFixStreamAssignmentReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixStreamAssignmentReport, 0, old_inUse.length);

		FixStreamAssignmentReport[] old_pool = poolFixStreamAssignmentReport;
		poolFixStreamAssignmentReport = new FixStreamAssignmentReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixStreamAssignmentReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixStreamAssignmentReport.length; i++) {
			poolFixStreamAssignmentReport[i] = new FixStreamAssignmentReport();
			inUseFixStreamAssignmentReport[i] = false;
		}

		inUseFixStreamAssignmentReport[poolFixStreamAssignmentReport.length - 1] = true;
		return poolFixStreamAssignmentReport[poolFixStreamAssignmentReport.length - 1];
	}

	public FixStreamAssignmentReportACK getFixStreamAssignmentReportACK() {
		for (int i = inUseFixStreamAssignmentReportACK.length - 1; i >= 0; i--)
			if (!inUseFixStreamAssignmentReportACK[i]) {
				inUseFixStreamAssignmentReportACK[i] = true;
				return poolFixStreamAssignmentReportACK[i];
			}

		boolean[] old_inUse = inUseFixStreamAssignmentReportACK;
		inUseFixStreamAssignmentReportACK = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixStreamAssignmentReportACK, 0, old_inUse.length);

		FixStreamAssignmentReportACK[] old_pool = poolFixStreamAssignmentReportACK;
		poolFixStreamAssignmentReportACK = new FixStreamAssignmentReportACK[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixStreamAssignmentReportACK, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixStreamAssignmentReportACK.length; i++) {
			poolFixStreamAssignmentReportACK[i] = new FixStreamAssignmentReportACK();
			inUseFixStreamAssignmentReportACK[i] = false;
		}

		inUseFixStreamAssignmentReportACK[poolFixStreamAssignmentReportACK.length - 1] = true;
		return poolFixStreamAssignmentReportACK[poolFixStreamAssignmentReportACK.length - 1];
	}

	public FixPartyDetailsListRequest getFixPartyDetailsListRequest() {
		for (int i = inUseFixPartyDetailsListRequest.length - 1; i >= 0; i--)
			if (!inUseFixPartyDetailsListRequest[i]) {
				inUseFixPartyDetailsListRequest[i] = true;
				return poolFixPartyDetailsListRequest[i];
			}

		boolean[] old_inUse = inUseFixPartyDetailsListRequest;
		inUseFixPartyDetailsListRequest = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixPartyDetailsListRequest, 0, old_inUse.length);

		FixPartyDetailsListRequest[] old_pool = poolFixPartyDetailsListRequest;
		poolFixPartyDetailsListRequest = new FixPartyDetailsListRequest[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixPartyDetailsListRequest, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixPartyDetailsListRequest.length; i++) {
			poolFixPartyDetailsListRequest[i] = new FixPartyDetailsListRequest();
			inUseFixPartyDetailsListRequest[i] = false;
		}

		inUseFixPartyDetailsListRequest[poolFixPartyDetailsListRequest.length - 1] = true;
		return poolFixPartyDetailsListRequest[poolFixPartyDetailsListRequest.length - 1];
	}

	public FixPartyDetailsListReport getFixPartyDetailsListReport() {
		for (int i = inUseFixPartyDetailsListReport.length - 1; i >= 0; i--)
			if (!inUseFixPartyDetailsListReport[i]) {
				inUseFixPartyDetailsListReport[i] = true;
				return poolFixPartyDetailsListReport[i];
			}

		boolean[] old_inUse = inUseFixPartyDetailsListReport;
		inUseFixPartyDetailsListReport = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixPartyDetailsListReport, 0, old_inUse.length);

		FixPartyDetailsListReport[] old_pool = poolFixPartyDetailsListReport;
		poolFixPartyDetailsListReport = new FixPartyDetailsListReport[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixPartyDetailsListReport, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixPartyDetailsListReport.length; i++) {
			poolFixPartyDetailsListReport[i] = new FixPartyDetailsListReport();
			inUseFixPartyDetailsListReport[i] = false;
		}

		inUseFixPartyDetailsListReport[poolFixPartyDetailsListReport.length - 1] = true;
		return poolFixPartyDetailsListReport[poolFixPartyDetailsListReport.length - 1];
	}

	public void returnFixMessage(T msg) {
		switch(msg.msgType) {
			case FixMessageInfo.MessageTypes.HEARTBEAT_INT:
				returnFixHeartbeat((FixHeartbeat)msg);
				break;
			case FixMessageInfo.MessageTypes.TESTREQUEST_INT:
				returnFixTestRequest((FixTestRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.RESENDREQUEST_INT:
				returnFixResendRequest((FixResendRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.REJECT_INT:
				returnFixReject((FixReject)msg);
				break;
			case FixMessageInfo.MessageTypes.SEQUENCERESET_INT:
				returnFixSequenceReset((FixSequenceReset)msg);
				break;
			case FixMessageInfo.MessageTypes.LOGOUT_INT:
				returnFixLogout((FixLogout)msg);
				break;
			case FixMessageInfo.MessageTypes.IOI_INT:
				returnFixIOI((FixIOI)msg);
				break;
			case FixMessageInfo.MessageTypes.ADVERTISEMENT_INT:
				returnFixAdvertisement((FixAdvertisement)msg);
				break;
			case FixMessageInfo.MessageTypes.EXECUTIONREPORT_INT:
				returnFixExecutionReport((FixExecutionReport)msg);
				break;
			case FixMessageInfo.MessageTypes.ORDERCANCELREJECT_INT:
				returnFixOrderCancelReject((FixOrderCancelReject)msg);
				break;
			case FixMessageInfo.MessageTypes.LOGON_INT:
				returnFixLogon((FixLogon)msg);
				break;
			case FixMessageInfo.MessageTypes.NEWS_INT:
				returnFixNews((FixNews)msg);
				break;
			case FixMessageInfo.MessageTypes.EMAIL_INT:
				returnFixEmail((FixEmail)msg);
				break;
			case FixMessageInfo.MessageTypes.NEWORDERSINGLE_INT:
				returnFixNewOrderSingle((FixNewOrderSingle)msg);
				break;
			case FixMessageInfo.MessageTypes.NEWORDERLIST_INT:
				returnFixNewOrderList((FixNewOrderList)msg);
				break;
			case FixMessageInfo.MessageTypes.ORDERCANCELREQUEST_INT:
				returnFixOrderCancelRequest((FixOrderCancelRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.ORDERCANCELREPLACEREQUEST_INT:
				returnFixOrderCancelReplaceRequest((FixOrderCancelReplaceRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.ORDERSTATUSREQUEST_INT:
				returnFixOrderStatusRequest((FixOrderStatusRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.ALLOCATIONINSTRUCTION_INT:
				returnFixAllocationInstruction((FixAllocationInstruction)msg);
				break;
			case FixMessageInfo.MessageTypes.LISTCANCELREQUEST_INT:
				returnFixListCancelRequest((FixListCancelRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.LISTEXECUTE_INT:
				returnFixListExecute((FixListExecute)msg);
				break;
			case FixMessageInfo.MessageTypes.LISTSTATUSREQUEST_INT:
				returnFixListStatusRequest((FixListStatusRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.LISTSTATUS_INT:
				returnFixListStatus((FixListStatus)msg);
				break;
			case FixMessageInfo.MessageTypes.ALLOCATIONINSTRUCTIONACK_INT:
				returnFixAllocationInstructionAck((FixAllocationInstructionAck)msg);
				break;
			case FixMessageInfo.MessageTypes.DONTKNOWTRADEDK_INT:
				returnFixDontKnowTradeDK((FixDontKnowTradeDK)msg);
				break;
			case FixMessageInfo.MessageTypes.QUOTEREQUEST_INT:
				returnFixQuoteRequest((FixQuoteRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.QUOTE_INT:
				returnFixQuote((FixQuote)msg);
				break;
			case FixMessageInfo.MessageTypes.SETTLEMENTINSTRUCTIONS_INT:
				returnFixSettlementInstructions((FixSettlementInstructions)msg);
				break;
			case FixMessageInfo.MessageTypes.MARKETDATAREQUEST_INT:
				returnFixMarketDataRequest((FixMarketDataRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.MARKETDATASNAPSHOTFULLREFRESH_INT:
				returnFixMarketDataSnapshotFullRefresh((FixMarketDataSnapshotFullRefresh)msg);
				break;
			case FixMessageInfo.MessageTypes.MARKETDATAINCREMENTALREFRESH_INT:
				returnFixMarketDataIncrementalRefresh((FixMarketDataIncrementalRefresh)msg);
				break;
			case FixMessageInfo.MessageTypes.MARKETDATAREQUESTREJECT_INT:
				returnFixMarketDataRequestReject((FixMarketDataRequestReject)msg);
				break;
			case FixMessageInfo.MessageTypes.QUOTECANCEL_INT:
				returnFixQuoteCancel((FixQuoteCancel)msg);
				break;
			case FixMessageInfo.MessageTypes.QUOTESTATUSREQUEST_INT:
				returnFixQuoteStatusRequest((FixQuoteStatusRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.MASSQUOTEACKNOWLEDGEMENT_INT:
				returnFixMassQuoteAcknowledgement((FixMassQuoteAcknowledgement)msg);
				break;
			case FixMessageInfo.MessageTypes.SECURITYDEFINITIONREQUEST_INT:
				returnFixSecurityDefinitionRequest((FixSecurityDefinitionRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.SECURITYDEFINITION_INT:
				returnFixSecurityDefinition((FixSecurityDefinition)msg);
				break;
			case FixMessageInfo.MessageTypes.SECURITYSTATUSREQUEST_INT:
				returnFixSecurityStatusRequest((FixSecurityStatusRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.SECURITYSTATUS_INT:
				returnFixSecurityStatus((FixSecurityStatus)msg);
				break;
			case FixMessageInfo.MessageTypes.TRADINGSESSIONSTATUSREQUEST_INT:
				returnFixTradingSessionStatusRequest((FixTradingSessionStatusRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.TRADINGSESSIONSTATUS_INT:
				returnFixTradingSessionStatus((FixTradingSessionStatus)msg);
				break;
			case FixMessageInfo.MessageTypes.MASSQUOTE_INT:
				returnFixMassQuote((FixMassQuote)msg);
				break;
			case FixMessageInfo.MessageTypes.BUSINESSMESSAGEREJECT_INT:
				returnFixBusinessMessageReject((FixBusinessMessageReject)msg);
				break;
			case FixMessageInfo.MessageTypes.BIDREQUEST_INT:
				returnFixBidRequest((FixBidRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.BIDRESPONSE_INT:
				returnFixBidResponse((FixBidResponse)msg);
				break;
			case FixMessageInfo.MessageTypes.LISTSTRIKEPRICE_INT:
				returnFixListStrikePrice((FixListStrikePrice)msg);
				break;
			case FixMessageInfo.MessageTypes.REGISTRATIONINSTRUCTIONS_INT:
				returnFixRegistrationInstructions((FixRegistrationInstructions)msg);
				break;
			case FixMessageInfo.MessageTypes.REGISTRATIONINSTRUCTIONSRESPONSE_INT:
				returnFixRegistrationInstructionsResponse((FixRegistrationInstructionsResponse)msg);
				break;
			case FixMessageInfo.MessageTypes.ORDERMASSCANCELREQUEST_INT:
				returnFixOrderMassCancelRequest((FixOrderMassCancelRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.ORDERMASSCANCELREPORT_INT:
				returnFixOrderMassCancelReport((FixOrderMassCancelReport)msg);
				break;
			case FixMessageInfo.MessageTypes.NEWORDERCROSS_INT:
				returnFixNewOrderCross((FixNewOrderCross)msg);
				break;
			case FixMessageInfo.MessageTypes.CROSSORDERCANCELREPLACEREQUEST_INT:
				returnFixCrossOrderCancelReplaceRequest((FixCrossOrderCancelReplaceRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.CROSSORDERCANCELREQUEST_INT:
				returnFixCrossOrderCancelRequest((FixCrossOrderCancelRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.SECURITYTYPEREQUEST_INT:
				returnFixSecurityTypeRequest((FixSecurityTypeRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.SECURITYTYPES_INT:
				returnFixSecurityTypes((FixSecurityTypes)msg);
				break;
			case FixMessageInfo.MessageTypes.SECURITYLISTREQUEST_INT:
				returnFixSecurityListRequest((FixSecurityListRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.SECURITYLIST_INT:
				returnFixSecurityList((FixSecurityList)msg);
				break;
			case FixMessageInfo.MessageTypes.DERIVATIVESECURITYLISTREQUEST_INT:
				returnFixDerivativeSecurityListRequest((FixDerivativeSecurityListRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.DERIVATIVESECURITYLIST_INT:
				returnFixDerivativeSecurityList((FixDerivativeSecurityList)msg);
				break;
			case FixMessageInfo.MessageTypes.NEWORDERMULTILEG_INT:
				returnFixNewOrderMultileg((FixNewOrderMultileg)msg);
				break;
			case FixMessageInfo.MessageTypes.MULTILEGORDERCANCELREPLACE_INT:
				returnFixMultilegOrderCancelReplace((FixMultilegOrderCancelReplace)msg);
				break;
			case FixMessageInfo.MessageTypes.TRADECAPTUREREPORTREQUEST_INT:
				returnFixTradeCaptureReportRequest((FixTradeCaptureReportRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.TRADECAPTUREREPORT_INT:
				returnFixTradeCaptureReport((FixTradeCaptureReport)msg);
				break;
			case FixMessageInfo.MessageTypes.ORDERMASSSTATUSREQUEST_INT:
				returnFixOrderMassStatusRequest((FixOrderMassStatusRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.QUOTEREQUESTREJECT_INT:
				returnFixQuoteRequestReject((FixQuoteRequestReject)msg);
				break;
			case FixMessageInfo.MessageTypes.RFQREQUEST_INT:
				returnFixRFQRequest((FixRFQRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.QUOTESTATUSREPORT_INT:
				returnFixQuoteStatusReport((FixQuoteStatusReport)msg);
				break;
			case FixMessageInfo.MessageTypes.QUOTERESPONSE_INT:
				returnFixQuoteResponse((FixQuoteResponse)msg);
				break;
			case FixMessageInfo.MessageTypes.CONFIRMATION_INT:
				returnFixConfirmation((FixConfirmation)msg);
				break;
			case FixMessageInfo.MessageTypes.POSITIONMAINTENANCEREQUEST_INT:
				returnFixPositionMaintenanceRequest((FixPositionMaintenanceRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.POSITIONMAINTENANCEREPORT_INT:
				returnFixPositionMaintenanceReport((FixPositionMaintenanceReport)msg);
				break;
			case FixMessageInfo.MessageTypes.REQUESTFORPOSITIONS_INT:
				returnFixRequestForPositions((FixRequestForPositions)msg);
				break;
			case FixMessageInfo.MessageTypes.REQUESTFORPOSITIONSACK_INT:
				returnFixRequestForPositionsAck((FixRequestForPositionsAck)msg);
				break;
			case FixMessageInfo.MessageTypes.POSITIONREPORT_INT:
				returnFixPositionReport((FixPositionReport)msg);
				break;
			case FixMessageInfo.MessageTypes.TRADECAPTUREREPORTREQUESTACK_INT:
				returnFixTradeCaptureReportRequestAck((FixTradeCaptureReportRequestAck)msg);
				break;
			case FixMessageInfo.MessageTypes.TRADECAPTUREREPORTACK_INT:
				returnFixTradeCaptureReportAck((FixTradeCaptureReportAck)msg);
				break;
			case FixMessageInfo.MessageTypes.ALLOCATIONREPORT_INT:
				returnFixAllocationReport((FixAllocationReport)msg);
				break;
			case FixMessageInfo.MessageTypes.ALLOCATIONREPORTACK_INT:
				returnFixAllocationReportAck((FixAllocationReportAck)msg);
				break;
			case FixMessageInfo.MessageTypes.CONFIRMATION_ACK_INT:
				returnFixConfirmation_Ack((FixConfirmation_Ack)msg);
				break;
			case FixMessageInfo.MessageTypes.SETTLEMENTINSTRUCTIONREQUEST_INT:
				returnFixSettlementInstructionRequest((FixSettlementInstructionRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.ASSIGNMENTREPORT_INT:
				returnFixAssignmentReport((FixAssignmentReport)msg);
				break;
			case FixMessageInfo.MessageTypes.COLLATERALREQUEST_INT:
				returnFixCollateralRequest((FixCollateralRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.COLLATERALASSIGNMENT_INT:
				returnFixCollateralAssignment((FixCollateralAssignment)msg);
				break;
			case FixMessageInfo.MessageTypes.COLLATERALRESPONSE_INT:
				returnFixCollateralResponse((FixCollateralResponse)msg);
				break;
			case FixMessageInfo.MessageTypes.COLLATERALREPORT_INT:
				returnFixCollateralReport((FixCollateralReport)msg);
				break;
			case FixMessageInfo.MessageTypes.COLLATERALINQUIRY_INT:
				returnFixCollateralInquiry((FixCollateralInquiry)msg);
				break;
			case FixMessageInfo.MessageTypes.NETWORKCOUNTERPARTYSYSTEMSTATUSREQUEST_INT:
				returnFixNetworkCounterpartySystemStatusRequest((FixNetworkCounterpartySystemStatusRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.NETWORKCOUNTERPARTYSYSTEMSTATUSRESPONSE_INT:
				returnFixNetworkCounterpartySystemStatusResponse((FixNetworkCounterpartySystemStatusResponse)msg);
				break;
			case FixMessageInfo.MessageTypes.USERREQUEST_INT:
				returnFixUserRequest((FixUserRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.USERRESPONSE_INT:
				returnFixUserResponse((FixUserResponse)msg);
				break;
			case FixMessageInfo.MessageTypes.COLLATERALINQUIRYACK_INT:
				returnFixCollateralInquiryAck((FixCollateralInquiryAck)msg);
				break;
			case FixMessageInfo.MessageTypes.CONFIRMATIONREQUEST_INT:
				returnFixConfirmationRequest((FixConfirmationRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.CONTRARYINTENTIONREPORT_INT:
				returnFixContraryIntentionReport((FixContraryIntentionReport)msg);
				break;
			case FixMessageInfo.MessageTypes.SECURITYDEFINITIONUPDATEREPORT_INT:
				returnFixSecurityDefinitionUpdateReport((FixSecurityDefinitionUpdateReport)msg);
				break;
			case FixMessageInfo.MessageTypes.SECURITYLISTUPDATEREPORT_INT:
				returnFixSecurityListUpdateReport((FixSecurityListUpdateReport)msg);
				break;
			case FixMessageInfo.MessageTypes.ADJUSTEDPOSITIONREPORT_INT:
				returnFixAdjustedPositionReport((FixAdjustedPositionReport)msg);
				break;
			case FixMessageInfo.MessageTypes.ALLOCATIONINSTRUCTIONALERT_INT:
				returnFixAllocationInstructionAlert((FixAllocationInstructionAlert)msg);
				break;
			case FixMessageInfo.MessageTypes.EXECUTIONACKNOWLEDGEMENT_INT:
				returnFixExecutionAcknowledgement((FixExecutionAcknowledgement)msg);
				break;
			case FixMessageInfo.MessageTypes.TRADINGSESSIONLIST_INT:
				returnFixTradingSessionList((FixTradingSessionList)msg);
				break;
			case FixMessageInfo.MessageTypes.TRADINGSESSIONLISTREQUEST_INT:
				returnFixTradingSessionListRequest((FixTradingSessionListRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.SETTLEMENTOBLIGATIONREPORT_INT:
				returnFixSettlementObligationReport((FixSettlementObligationReport)msg);
				break;
			case FixMessageInfo.MessageTypes.DERIVATIVESECURITYLISTUPDATEREPORT_INT:
				returnFixDerivativeSecurityListUpdateReport((FixDerivativeSecurityListUpdateReport)msg);
				break;
			case FixMessageInfo.MessageTypes.TRADINGSESSIONLISTUPDATEREPORT_INT:
				returnFixTradingSessionListUpdateReport((FixTradingSessionListUpdateReport)msg);
				break;
			case FixMessageInfo.MessageTypes.MARKETDEFINITIONREQUEST_INT:
				returnFixMarketDefinitionRequest((FixMarketDefinitionRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.MARKETDEFINITION_INT:
				returnFixMarketDefinition((FixMarketDefinition)msg);
				break;
			case FixMessageInfo.MessageTypes.MARKETDEFINITIONUPDATEREPORT_INT:
				returnFixMarketDefinitionUpdateReport((FixMarketDefinitionUpdateReport)msg);
				break;
			case FixMessageInfo.MessageTypes.USERNOTIFICATION_INT:
				returnFixUserNotification((FixUserNotification)msg);
				break;
			case FixMessageInfo.MessageTypes.ORDERMASSACTIONREPORT_INT:
				returnFixOrderMassActionReport((FixOrderMassActionReport)msg);
				break;
			case FixMessageInfo.MessageTypes.ORDERMASSACTIONREQUEST_INT:
				returnFixOrderMassActionRequest((FixOrderMassActionRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.APPLICATIONMESSAGEREQUEST_INT:
				returnFixApplicationMessageRequest((FixApplicationMessageRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.APPLICATIONMESSAGEREQUESTACK_INT:
				returnFixApplicationMessageRequestAck((FixApplicationMessageRequestAck)msg);
				break;
			case FixMessageInfo.MessageTypes.APPLICATIONMESSAGEREPORT_INT:
				returnFixApplicationMessageReport((FixApplicationMessageReport)msg);
				break;
			case FixMessageInfo.MessageTypes.STREAMASSIGNMENTREQUEST_INT:
				returnFixStreamAssignmentRequest((FixStreamAssignmentRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.STREAMASSIGNMENTREPORT_INT:
				returnFixStreamAssignmentReport((FixStreamAssignmentReport)msg);
				break;
			case FixMessageInfo.MessageTypes.STREAMASSIGNMENTREPORTACK_INT:
				returnFixStreamAssignmentReportACK((FixStreamAssignmentReportACK)msg);
				break;
			case FixMessageInfo.MessageTypes.PARTYDETAILSLISTREQUEST_INT:
				returnFixPartyDetailsListRequest((FixPartyDetailsListRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.PARTYDETAILSLISTREPORT_INT:
				returnFixPartyDetailsListReport((FixPartyDetailsListReport)msg);
				break;
			default:
				break;
		}

	}

	public void returnFixHeartbeat(FixHeartbeat msg) {

		for (int i = inUseFixHeartbeat.length - 1; i >= 0; i--) {
			if (poolFixHeartbeat[i] == msg) {
				inUseFixHeartbeat[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixTestRequest(FixTestRequest msg) {

		for (int i = inUseFixTestRequest.length - 1; i >= 0; i--) {
			if (poolFixTestRequest[i] == msg) {
				inUseFixTestRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixResendRequest(FixResendRequest msg) {

		for (int i = inUseFixResendRequest.length - 1; i >= 0; i--) {
			if (poolFixResendRequest[i] == msg) {
				inUseFixResendRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixReject(FixReject msg) {

		for (int i = inUseFixReject.length - 1; i >= 0; i--) {
			if (poolFixReject[i] == msg) {
				inUseFixReject[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixSequenceReset(FixSequenceReset msg) {

		for (int i = inUseFixSequenceReset.length - 1; i >= 0; i--) {
			if (poolFixSequenceReset[i] == msg) {
				inUseFixSequenceReset[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixLogout(FixLogout msg) {

		for (int i = inUseFixLogout.length - 1; i >= 0; i--) {
			if (poolFixLogout[i] == msg) {
				inUseFixLogout[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixIOI(FixIOI msg) {

		for (int i = inUseFixIOI.length - 1; i >= 0; i--) {
			if (poolFixIOI[i] == msg) {
				inUseFixIOI[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixAdvertisement(FixAdvertisement msg) {

		for (int i = inUseFixAdvertisement.length - 1; i >= 0; i--) {
			if (poolFixAdvertisement[i] == msg) {
				inUseFixAdvertisement[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixExecutionReport(FixExecutionReport msg) {

		for (int i = inUseFixExecutionReport.length - 1; i >= 0; i--) {
			if (poolFixExecutionReport[i] == msg) {
				inUseFixExecutionReport[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixOrderCancelReject(FixOrderCancelReject msg) {

		for (int i = inUseFixOrderCancelReject.length - 1; i >= 0; i--) {
			if (poolFixOrderCancelReject[i] == msg) {
				inUseFixOrderCancelReject[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixLogon(FixLogon msg) {

		for (int i = inUseFixLogon.length - 1; i >= 0; i--) {
			if (poolFixLogon[i] == msg) {
				inUseFixLogon[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixNews(FixNews msg) {

		for (int i = inUseFixNews.length - 1; i >= 0; i--) {
			if (poolFixNews[i] == msg) {
				inUseFixNews[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixEmail(FixEmail msg) {

		for (int i = inUseFixEmail.length - 1; i >= 0; i--) {
			if (poolFixEmail[i] == msg) {
				inUseFixEmail[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixNewOrderSingle(FixNewOrderSingle msg) {

		for (int i = inUseFixNewOrderSingle.length - 1; i >= 0; i--) {
			if (poolFixNewOrderSingle[i] == msg) {
				inUseFixNewOrderSingle[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixNewOrderList(FixNewOrderList msg) {

		for (int i = inUseFixNewOrderList.length - 1; i >= 0; i--) {
			if (poolFixNewOrderList[i] == msg) {
				inUseFixNewOrderList[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixOrderCancelRequest(FixOrderCancelRequest msg) {

		for (int i = inUseFixOrderCancelRequest.length - 1; i >= 0; i--) {
			if (poolFixOrderCancelRequest[i] == msg) {
				inUseFixOrderCancelRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixOrderCancelReplaceRequest(FixOrderCancelReplaceRequest msg) {

		for (int i = inUseFixOrderCancelReplaceRequest.length - 1; i >= 0; i--) {
			if (poolFixOrderCancelReplaceRequest[i] == msg) {
				inUseFixOrderCancelReplaceRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixOrderStatusRequest(FixOrderStatusRequest msg) {

		for (int i = inUseFixOrderStatusRequest.length - 1; i >= 0; i--) {
			if (poolFixOrderStatusRequest[i] == msg) {
				inUseFixOrderStatusRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixAllocationInstruction(FixAllocationInstruction msg) {

		for (int i = inUseFixAllocationInstruction.length - 1; i >= 0; i--) {
			if (poolFixAllocationInstruction[i] == msg) {
				inUseFixAllocationInstruction[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixListCancelRequest(FixListCancelRequest msg) {

		for (int i = inUseFixListCancelRequest.length - 1; i >= 0; i--) {
			if (poolFixListCancelRequest[i] == msg) {
				inUseFixListCancelRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixListExecute(FixListExecute msg) {

		for (int i = inUseFixListExecute.length - 1; i >= 0; i--) {
			if (poolFixListExecute[i] == msg) {
				inUseFixListExecute[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixListStatusRequest(FixListStatusRequest msg) {

		for (int i = inUseFixListStatusRequest.length - 1; i >= 0; i--) {
			if (poolFixListStatusRequest[i] == msg) {
				inUseFixListStatusRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixListStatus(FixListStatus msg) {

		for (int i = inUseFixListStatus.length - 1; i >= 0; i--) {
			if (poolFixListStatus[i] == msg) {
				inUseFixListStatus[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixAllocationInstructionAck(FixAllocationInstructionAck msg) {

		for (int i = inUseFixAllocationInstructionAck.length - 1; i >= 0; i--) {
			if (poolFixAllocationInstructionAck[i] == msg) {
				inUseFixAllocationInstructionAck[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixDontKnowTradeDK(FixDontKnowTradeDK msg) {

		for (int i = inUseFixDontKnowTradeDK.length - 1; i >= 0; i--) {
			if (poolFixDontKnowTradeDK[i] == msg) {
				inUseFixDontKnowTradeDK[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixQuoteRequest(FixQuoteRequest msg) {

		for (int i = inUseFixQuoteRequest.length - 1; i >= 0; i--) {
			if (poolFixQuoteRequest[i] == msg) {
				inUseFixQuoteRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixQuote(FixQuote msg) {

		for (int i = inUseFixQuote.length - 1; i >= 0; i--) {
			if (poolFixQuote[i] == msg) {
				inUseFixQuote[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixSettlementInstructions(FixSettlementInstructions msg) {

		for (int i = inUseFixSettlementInstructions.length - 1; i >= 0; i--) {
			if (poolFixSettlementInstructions[i] == msg) {
				inUseFixSettlementInstructions[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixMarketDataRequest(FixMarketDataRequest msg) {

		for (int i = inUseFixMarketDataRequest.length - 1; i >= 0; i--) {
			if (poolFixMarketDataRequest[i] == msg) {
				inUseFixMarketDataRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixMarketDataSnapshotFullRefresh(FixMarketDataSnapshotFullRefresh msg) {

		for (int i = inUseFixMarketDataSnapshotFullRefresh.length - 1; i >= 0; i--) {
			if (poolFixMarketDataSnapshotFullRefresh[i] == msg) {
				inUseFixMarketDataSnapshotFullRefresh[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixMarketDataIncrementalRefresh(FixMarketDataIncrementalRefresh msg) {

		for (int i = inUseFixMarketDataIncrementalRefresh.length - 1; i >= 0; i--) {
			if (poolFixMarketDataIncrementalRefresh[i] == msg) {
				inUseFixMarketDataIncrementalRefresh[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixMarketDataRequestReject(FixMarketDataRequestReject msg) {

		for (int i = inUseFixMarketDataRequestReject.length - 1; i >= 0; i--) {
			if (poolFixMarketDataRequestReject[i] == msg) {
				inUseFixMarketDataRequestReject[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixQuoteCancel(FixQuoteCancel msg) {

		for (int i = inUseFixQuoteCancel.length - 1; i >= 0; i--) {
			if (poolFixQuoteCancel[i] == msg) {
				inUseFixQuoteCancel[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixQuoteStatusRequest(FixQuoteStatusRequest msg) {

		for (int i = inUseFixQuoteStatusRequest.length - 1; i >= 0; i--) {
			if (poolFixQuoteStatusRequest[i] == msg) {
				inUseFixQuoteStatusRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixMassQuoteAcknowledgement(FixMassQuoteAcknowledgement msg) {

		for (int i = inUseFixMassQuoteAcknowledgement.length - 1; i >= 0; i--) {
			if (poolFixMassQuoteAcknowledgement[i] == msg) {
				inUseFixMassQuoteAcknowledgement[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixSecurityDefinitionRequest(FixSecurityDefinitionRequest msg) {

		for (int i = inUseFixSecurityDefinitionRequest.length - 1; i >= 0; i--) {
			if (poolFixSecurityDefinitionRequest[i] == msg) {
				inUseFixSecurityDefinitionRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixSecurityDefinition(FixSecurityDefinition msg) {

		for (int i = inUseFixSecurityDefinition.length - 1; i >= 0; i--) {
			if (poolFixSecurityDefinition[i] == msg) {
				inUseFixSecurityDefinition[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixSecurityStatusRequest(FixSecurityStatusRequest msg) {

		for (int i = inUseFixSecurityStatusRequest.length - 1; i >= 0; i--) {
			if (poolFixSecurityStatusRequest[i] == msg) {
				inUseFixSecurityStatusRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixSecurityStatus(FixSecurityStatus msg) {

		for (int i = inUseFixSecurityStatus.length - 1; i >= 0; i--) {
			if (poolFixSecurityStatus[i] == msg) {
				inUseFixSecurityStatus[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixTradingSessionStatusRequest(FixTradingSessionStatusRequest msg) {

		for (int i = inUseFixTradingSessionStatusRequest.length - 1; i >= 0; i--) {
			if (poolFixTradingSessionStatusRequest[i] == msg) {
				inUseFixTradingSessionStatusRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixTradingSessionStatus(FixTradingSessionStatus msg) {

		for (int i = inUseFixTradingSessionStatus.length - 1; i >= 0; i--) {
			if (poolFixTradingSessionStatus[i] == msg) {
				inUseFixTradingSessionStatus[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixMassQuote(FixMassQuote msg) {

		for (int i = inUseFixMassQuote.length - 1; i >= 0; i--) {
			if (poolFixMassQuote[i] == msg) {
				inUseFixMassQuote[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixBusinessMessageReject(FixBusinessMessageReject msg) {

		for (int i = inUseFixBusinessMessageReject.length - 1; i >= 0; i--) {
			if (poolFixBusinessMessageReject[i] == msg) {
				inUseFixBusinessMessageReject[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixBidRequest(FixBidRequest msg) {

		for (int i = inUseFixBidRequest.length - 1; i >= 0; i--) {
			if (poolFixBidRequest[i] == msg) {
				inUseFixBidRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixBidResponse(FixBidResponse msg) {

		for (int i = inUseFixBidResponse.length - 1; i >= 0; i--) {
			if (poolFixBidResponse[i] == msg) {
				inUseFixBidResponse[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixListStrikePrice(FixListStrikePrice msg) {

		for (int i = inUseFixListStrikePrice.length - 1; i >= 0; i--) {
			if (poolFixListStrikePrice[i] == msg) {
				inUseFixListStrikePrice[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixRegistrationInstructions(FixRegistrationInstructions msg) {

		for (int i = inUseFixRegistrationInstructions.length - 1; i >= 0; i--) {
			if (poolFixRegistrationInstructions[i] == msg) {
				inUseFixRegistrationInstructions[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixRegistrationInstructionsResponse(FixRegistrationInstructionsResponse msg) {

		for (int i = inUseFixRegistrationInstructionsResponse.length - 1; i >= 0; i--) {
			if (poolFixRegistrationInstructionsResponse[i] == msg) {
				inUseFixRegistrationInstructionsResponse[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixOrderMassCancelRequest(FixOrderMassCancelRequest msg) {

		for (int i = inUseFixOrderMassCancelRequest.length - 1; i >= 0; i--) {
			if (poolFixOrderMassCancelRequest[i] == msg) {
				inUseFixOrderMassCancelRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixOrderMassCancelReport(FixOrderMassCancelReport msg) {

		for (int i = inUseFixOrderMassCancelReport.length - 1; i >= 0; i--) {
			if (poolFixOrderMassCancelReport[i] == msg) {
				inUseFixOrderMassCancelReport[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixNewOrderCross(FixNewOrderCross msg) {

		for (int i = inUseFixNewOrderCross.length - 1; i >= 0; i--) {
			if (poolFixNewOrderCross[i] == msg) {
				inUseFixNewOrderCross[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixCrossOrderCancelReplaceRequest(FixCrossOrderCancelReplaceRequest msg) {

		for (int i = inUseFixCrossOrderCancelReplaceRequest.length - 1; i >= 0; i--) {
			if (poolFixCrossOrderCancelReplaceRequest[i] == msg) {
				inUseFixCrossOrderCancelReplaceRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixCrossOrderCancelRequest(FixCrossOrderCancelRequest msg) {

		for (int i = inUseFixCrossOrderCancelRequest.length - 1; i >= 0; i--) {
			if (poolFixCrossOrderCancelRequest[i] == msg) {
				inUseFixCrossOrderCancelRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixSecurityTypeRequest(FixSecurityTypeRequest msg) {

		for (int i = inUseFixSecurityTypeRequest.length - 1; i >= 0; i--) {
			if (poolFixSecurityTypeRequest[i] == msg) {
				inUseFixSecurityTypeRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixSecurityTypes(FixSecurityTypes msg) {

		for (int i = inUseFixSecurityTypes.length - 1; i >= 0; i--) {
			if (poolFixSecurityTypes[i] == msg) {
				inUseFixSecurityTypes[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixSecurityListRequest(FixSecurityListRequest msg) {

		for (int i = inUseFixSecurityListRequest.length - 1; i >= 0; i--) {
			if (poolFixSecurityListRequest[i] == msg) {
				inUseFixSecurityListRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixSecurityList(FixSecurityList msg) {

		for (int i = inUseFixSecurityList.length - 1; i >= 0; i--) {
			if (poolFixSecurityList[i] == msg) {
				inUseFixSecurityList[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixDerivativeSecurityListRequest(FixDerivativeSecurityListRequest msg) {

		for (int i = inUseFixDerivativeSecurityListRequest.length - 1; i >= 0; i--) {
			if (poolFixDerivativeSecurityListRequest[i] == msg) {
				inUseFixDerivativeSecurityListRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixDerivativeSecurityList(FixDerivativeSecurityList msg) {

		for (int i = inUseFixDerivativeSecurityList.length - 1; i >= 0; i--) {
			if (poolFixDerivativeSecurityList[i] == msg) {
				inUseFixDerivativeSecurityList[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixNewOrderMultileg(FixNewOrderMultileg msg) {

		for (int i = inUseFixNewOrderMultileg.length - 1; i >= 0; i--) {
			if (poolFixNewOrderMultileg[i] == msg) {
				inUseFixNewOrderMultileg[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixMultilegOrderCancelReplace(FixMultilegOrderCancelReplace msg) {

		for (int i = inUseFixMultilegOrderCancelReplace.length - 1; i >= 0; i--) {
			if (poolFixMultilegOrderCancelReplace[i] == msg) {
				inUseFixMultilegOrderCancelReplace[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixTradeCaptureReportRequest(FixTradeCaptureReportRequest msg) {

		for (int i = inUseFixTradeCaptureReportRequest.length - 1; i >= 0; i--) {
			if (poolFixTradeCaptureReportRequest[i] == msg) {
				inUseFixTradeCaptureReportRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixTradeCaptureReport(FixTradeCaptureReport msg) {

		for (int i = inUseFixTradeCaptureReport.length - 1; i >= 0; i--) {
			if (poolFixTradeCaptureReport[i] == msg) {
				inUseFixTradeCaptureReport[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixOrderMassStatusRequest(FixOrderMassStatusRequest msg) {

		for (int i = inUseFixOrderMassStatusRequest.length - 1; i >= 0; i--) {
			if (poolFixOrderMassStatusRequest[i] == msg) {
				inUseFixOrderMassStatusRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixQuoteRequestReject(FixQuoteRequestReject msg) {

		for (int i = inUseFixQuoteRequestReject.length - 1; i >= 0; i--) {
			if (poolFixQuoteRequestReject[i] == msg) {
				inUseFixQuoteRequestReject[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixRFQRequest(FixRFQRequest msg) {

		for (int i = inUseFixRFQRequest.length - 1; i >= 0; i--) {
			if (poolFixRFQRequest[i] == msg) {
				inUseFixRFQRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixQuoteStatusReport(FixQuoteStatusReport msg) {

		for (int i = inUseFixQuoteStatusReport.length - 1; i >= 0; i--) {
			if (poolFixQuoteStatusReport[i] == msg) {
				inUseFixQuoteStatusReport[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixQuoteResponse(FixQuoteResponse msg) {

		for (int i = inUseFixQuoteResponse.length - 1; i >= 0; i--) {
			if (poolFixQuoteResponse[i] == msg) {
				inUseFixQuoteResponse[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixConfirmation(FixConfirmation msg) {

		for (int i = inUseFixConfirmation.length - 1; i >= 0; i--) {
			if (poolFixConfirmation[i] == msg) {
				inUseFixConfirmation[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixPositionMaintenanceRequest(FixPositionMaintenanceRequest msg) {

		for (int i = inUseFixPositionMaintenanceRequest.length - 1; i >= 0; i--) {
			if (poolFixPositionMaintenanceRequest[i] == msg) {
				inUseFixPositionMaintenanceRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixPositionMaintenanceReport(FixPositionMaintenanceReport msg) {

		for (int i = inUseFixPositionMaintenanceReport.length - 1; i >= 0; i--) {
			if (poolFixPositionMaintenanceReport[i] == msg) {
				inUseFixPositionMaintenanceReport[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixRequestForPositions(FixRequestForPositions msg) {

		for (int i = inUseFixRequestForPositions.length - 1; i >= 0; i--) {
			if (poolFixRequestForPositions[i] == msg) {
				inUseFixRequestForPositions[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixRequestForPositionsAck(FixRequestForPositionsAck msg) {

		for (int i = inUseFixRequestForPositionsAck.length - 1; i >= 0; i--) {
			if (poolFixRequestForPositionsAck[i] == msg) {
				inUseFixRequestForPositionsAck[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixPositionReport(FixPositionReport msg) {

		for (int i = inUseFixPositionReport.length - 1; i >= 0; i--) {
			if (poolFixPositionReport[i] == msg) {
				inUseFixPositionReport[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixTradeCaptureReportRequestAck(FixTradeCaptureReportRequestAck msg) {

		for (int i = inUseFixTradeCaptureReportRequestAck.length - 1; i >= 0; i--) {
			if (poolFixTradeCaptureReportRequestAck[i] == msg) {
				inUseFixTradeCaptureReportRequestAck[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixTradeCaptureReportAck(FixTradeCaptureReportAck msg) {

		for (int i = inUseFixTradeCaptureReportAck.length - 1; i >= 0; i--) {
			if (poolFixTradeCaptureReportAck[i] == msg) {
				inUseFixTradeCaptureReportAck[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixAllocationReport(FixAllocationReport msg) {

		for (int i = inUseFixAllocationReport.length - 1; i >= 0; i--) {
			if (poolFixAllocationReport[i] == msg) {
				inUseFixAllocationReport[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixAllocationReportAck(FixAllocationReportAck msg) {

		for (int i = inUseFixAllocationReportAck.length - 1; i >= 0; i--) {
			if (poolFixAllocationReportAck[i] == msg) {
				inUseFixAllocationReportAck[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixConfirmation_Ack(FixConfirmation_Ack msg) {

		for (int i = inUseFixConfirmation_Ack.length - 1; i >= 0; i--) {
			if (poolFixConfirmation_Ack[i] == msg) {
				inUseFixConfirmation_Ack[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixSettlementInstructionRequest(FixSettlementInstructionRequest msg) {

		for (int i = inUseFixSettlementInstructionRequest.length - 1; i >= 0; i--) {
			if (poolFixSettlementInstructionRequest[i] == msg) {
				inUseFixSettlementInstructionRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixAssignmentReport(FixAssignmentReport msg) {

		for (int i = inUseFixAssignmentReport.length - 1; i >= 0; i--) {
			if (poolFixAssignmentReport[i] == msg) {
				inUseFixAssignmentReport[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixCollateralRequest(FixCollateralRequest msg) {

		for (int i = inUseFixCollateralRequest.length - 1; i >= 0; i--) {
			if (poolFixCollateralRequest[i] == msg) {
				inUseFixCollateralRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixCollateralAssignment(FixCollateralAssignment msg) {

		for (int i = inUseFixCollateralAssignment.length - 1; i >= 0; i--) {
			if (poolFixCollateralAssignment[i] == msg) {
				inUseFixCollateralAssignment[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixCollateralResponse(FixCollateralResponse msg) {

		for (int i = inUseFixCollateralResponse.length - 1; i >= 0; i--) {
			if (poolFixCollateralResponse[i] == msg) {
				inUseFixCollateralResponse[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixCollateralReport(FixCollateralReport msg) {

		for (int i = inUseFixCollateralReport.length - 1; i >= 0; i--) {
			if (poolFixCollateralReport[i] == msg) {
				inUseFixCollateralReport[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixCollateralInquiry(FixCollateralInquiry msg) {

		for (int i = inUseFixCollateralInquiry.length - 1; i >= 0; i--) {
			if (poolFixCollateralInquiry[i] == msg) {
				inUseFixCollateralInquiry[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixNetworkCounterpartySystemStatusRequest(FixNetworkCounterpartySystemStatusRequest msg) {

		for (int i = inUseFixNetworkCounterpartySystemStatusRequest.length - 1; i >= 0; i--) {
			if (poolFixNetworkCounterpartySystemStatusRequest[i] == msg) {
				inUseFixNetworkCounterpartySystemStatusRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixNetworkCounterpartySystemStatusResponse(FixNetworkCounterpartySystemStatusResponse msg) {

		for (int i = inUseFixNetworkCounterpartySystemStatusResponse.length - 1; i >= 0; i--) {
			if (poolFixNetworkCounterpartySystemStatusResponse[i] == msg) {
				inUseFixNetworkCounterpartySystemStatusResponse[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixUserRequest(FixUserRequest msg) {

		for (int i = inUseFixUserRequest.length - 1; i >= 0; i--) {
			if (poolFixUserRequest[i] == msg) {
				inUseFixUserRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixUserResponse(FixUserResponse msg) {

		for (int i = inUseFixUserResponse.length - 1; i >= 0; i--) {
			if (poolFixUserResponse[i] == msg) {
				inUseFixUserResponse[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixCollateralInquiryAck(FixCollateralInquiryAck msg) {

		for (int i = inUseFixCollateralInquiryAck.length - 1; i >= 0; i--) {
			if (poolFixCollateralInquiryAck[i] == msg) {
				inUseFixCollateralInquiryAck[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixConfirmationRequest(FixConfirmationRequest msg) {

		for (int i = inUseFixConfirmationRequest.length - 1; i >= 0; i--) {
			if (poolFixConfirmationRequest[i] == msg) {
				inUseFixConfirmationRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixContraryIntentionReport(FixContraryIntentionReport msg) {

		for (int i = inUseFixContraryIntentionReport.length - 1; i >= 0; i--) {
			if (poolFixContraryIntentionReport[i] == msg) {
				inUseFixContraryIntentionReport[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixSecurityDefinitionUpdateReport(FixSecurityDefinitionUpdateReport msg) {

		for (int i = inUseFixSecurityDefinitionUpdateReport.length - 1; i >= 0; i--) {
			if (poolFixSecurityDefinitionUpdateReport[i] == msg) {
				inUseFixSecurityDefinitionUpdateReport[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixSecurityListUpdateReport(FixSecurityListUpdateReport msg) {

		for (int i = inUseFixSecurityListUpdateReport.length - 1; i >= 0; i--) {
			if (poolFixSecurityListUpdateReport[i] == msg) {
				inUseFixSecurityListUpdateReport[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixAdjustedPositionReport(FixAdjustedPositionReport msg) {

		for (int i = inUseFixAdjustedPositionReport.length - 1; i >= 0; i--) {
			if (poolFixAdjustedPositionReport[i] == msg) {
				inUseFixAdjustedPositionReport[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixAllocationInstructionAlert(FixAllocationInstructionAlert msg) {

		for (int i = inUseFixAllocationInstructionAlert.length - 1; i >= 0; i--) {
			if (poolFixAllocationInstructionAlert[i] == msg) {
				inUseFixAllocationInstructionAlert[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixExecutionAcknowledgement(FixExecutionAcknowledgement msg) {

		for (int i = inUseFixExecutionAcknowledgement.length - 1; i >= 0; i--) {
			if (poolFixExecutionAcknowledgement[i] == msg) {
				inUseFixExecutionAcknowledgement[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixTradingSessionList(FixTradingSessionList msg) {

		for (int i = inUseFixTradingSessionList.length - 1; i >= 0; i--) {
			if (poolFixTradingSessionList[i] == msg) {
				inUseFixTradingSessionList[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixTradingSessionListRequest(FixTradingSessionListRequest msg) {

		for (int i = inUseFixTradingSessionListRequest.length - 1; i >= 0; i--) {
			if (poolFixTradingSessionListRequest[i] == msg) {
				inUseFixTradingSessionListRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixSettlementObligationReport(FixSettlementObligationReport msg) {

		for (int i = inUseFixSettlementObligationReport.length - 1; i >= 0; i--) {
			if (poolFixSettlementObligationReport[i] == msg) {
				inUseFixSettlementObligationReport[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixDerivativeSecurityListUpdateReport(FixDerivativeSecurityListUpdateReport msg) {

		for (int i = inUseFixDerivativeSecurityListUpdateReport.length - 1; i >= 0; i--) {
			if (poolFixDerivativeSecurityListUpdateReport[i] == msg) {
				inUseFixDerivativeSecurityListUpdateReport[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixTradingSessionListUpdateReport(FixTradingSessionListUpdateReport msg) {

		for (int i = inUseFixTradingSessionListUpdateReport.length - 1; i >= 0; i--) {
			if (poolFixTradingSessionListUpdateReport[i] == msg) {
				inUseFixTradingSessionListUpdateReport[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixMarketDefinitionRequest(FixMarketDefinitionRequest msg) {

		for (int i = inUseFixMarketDefinitionRequest.length - 1; i >= 0; i--) {
			if (poolFixMarketDefinitionRequest[i] == msg) {
				inUseFixMarketDefinitionRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixMarketDefinition(FixMarketDefinition msg) {

		for (int i = inUseFixMarketDefinition.length - 1; i >= 0; i--) {
			if (poolFixMarketDefinition[i] == msg) {
				inUseFixMarketDefinition[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixMarketDefinitionUpdateReport(FixMarketDefinitionUpdateReport msg) {

		for (int i = inUseFixMarketDefinitionUpdateReport.length - 1; i >= 0; i--) {
			if (poolFixMarketDefinitionUpdateReport[i] == msg) {
				inUseFixMarketDefinitionUpdateReport[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixUserNotification(FixUserNotification msg) {

		for (int i = inUseFixUserNotification.length - 1; i >= 0; i--) {
			if (poolFixUserNotification[i] == msg) {
				inUseFixUserNotification[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixOrderMassActionReport(FixOrderMassActionReport msg) {

		for (int i = inUseFixOrderMassActionReport.length - 1; i >= 0; i--) {
			if (poolFixOrderMassActionReport[i] == msg) {
				inUseFixOrderMassActionReport[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixOrderMassActionRequest(FixOrderMassActionRequest msg) {

		for (int i = inUseFixOrderMassActionRequest.length - 1; i >= 0; i--) {
			if (poolFixOrderMassActionRequest[i] == msg) {
				inUseFixOrderMassActionRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixApplicationMessageRequest(FixApplicationMessageRequest msg) {

		for (int i = inUseFixApplicationMessageRequest.length - 1; i >= 0; i--) {
			if (poolFixApplicationMessageRequest[i] == msg) {
				inUseFixApplicationMessageRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixApplicationMessageRequestAck(FixApplicationMessageRequestAck msg) {

		for (int i = inUseFixApplicationMessageRequestAck.length - 1; i >= 0; i--) {
			if (poolFixApplicationMessageRequestAck[i] == msg) {
				inUseFixApplicationMessageRequestAck[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixApplicationMessageReport(FixApplicationMessageReport msg) {

		for (int i = inUseFixApplicationMessageReport.length - 1; i >= 0; i--) {
			if (poolFixApplicationMessageReport[i] == msg) {
				inUseFixApplicationMessageReport[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixStreamAssignmentRequest(FixStreamAssignmentRequest msg) {

		for (int i = inUseFixStreamAssignmentRequest.length - 1; i >= 0; i--) {
			if (poolFixStreamAssignmentRequest[i] == msg) {
				inUseFixStreamAssignmentRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixStreamAssignmentReport(FixStreamAssignmentReport msg) {

		for (int i = inUseFixStreamAssignmentReport.length - 1; i >= 0; i--) {
			if (poolFixStreamAssignmentReport[i] == msg) {
				inUseFixStreamAssignmentReport[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixStreamAssignmentReportACK(FixStreamAssignmentReportACK msg) {

		for (int i = inUseFixStreamAssignmentReportACK.length - 1; i >= 0; i--) {
			if (poolFixStreamAssignmentReportACK[i] == msg) {
				inUseFixStreamAssignmentReportACK[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixPartyDetailsListRequest(FixPartyDetailsListRequest msg) {

		for (int i = inUseFixPartyDetailsListRequest.length - 1; i >= 0; i--) {
			if (poolFixPartyDetailsListRequest[i] == msg) {
				inUseFixPartyDetailsListRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixPartyDetailsListReport(FixPartyDetailsListReport msg) {

		for (int i = inUseFixPartyDetailsListReport.length - 1; i >= 0; i--) {
			if (poolFixPartyDetailsListReport[i] == msg) {
				inUseFixPartyDetailsListReport[i] = false;
				msg.clear();
				return;
			}
		}
	}

}
