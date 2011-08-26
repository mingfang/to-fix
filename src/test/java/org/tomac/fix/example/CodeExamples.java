/**
 * Copyright (c) 2011 Sebastian Tomac (tomac.org)
 * Licensed under LGPL licenses.
 * You may obtain a copy of the License at http://www.gnu.org/copyleft/lgpl.html
 **/
package org.tomac.fix.example;


import static org.junit.Assert.fail;

import java.nio.ByteBuffer;

import org.junit.Test;
import org.tomac.protocol.fix.FixGarbledException;
import org.tomac.protocol.fix.FixSessionException;
import org.tomac.protocol.fix.messaging.fix50sp2.*;

/**
 * @author seto
 *
 */
public class CodeExamples {

	@Test
	public void simpleCodeExample() {
		ByteBuffer buf = ByteBuffer.wrap(new String("8=FIXT.1.1\u00019=82\u000135=A\u000149=TOC\u000156=TOMAC\u000134=1\u000150=TOC\u000157=S\u000152=20110211-05:40:09.425\u000198=0\u0001108=30\u00011137=9\u000110=102\u0001").getBytes());
		// In-bound message from raw fix message byte buffer
		
		try {
			// Get the message type 
			FixMessage.crackMsgType(buf);
			// based on message type pares the message
			FixLogon logon = new FixLogon();

			// decode the message
			logon.setBuffer(buf);
			logon.getAll();

			// get field values
			long bodyLength = logon.bodyLength;
			// ...
		} catch (FixGarbledException e) {
			e.printStackTrace();
			fail(e.getMessage());
		} catch (FixSessionException e) {
			// catch FixSessionException and.. check for SessionRejectReason errors
			fail(e.getMessage());
		}

	}
	
	@Test 
	public void SetAndGetTags() {
		// out bound message
		FixLogon logon = new FixLogon();
		// populate the fields
		logon.heartBtInt = 10;
		// get field values
		long heartBtInt = logon.heartBtInt;

	}
	
	@Test
	public void ProperExampleMessageListener() {
		// create a listener, parser and error holder for in-bound FIX messages
		MyFixMessageListener listener = new MyFixMessageListener();
		FixMessageParser parser = new FixMessageParser();
		
		ByteBuffer buf = ByteBuffer.wrap(new String("8=FIXT.1.1\u00019=82\u000135=A\u000149=TOC\u000156=TOMAC\u000134=1\u000150=TOC\u000157=S\u000152=20110211-05:40:09.425\u000198=0\u0001108=30\u00011137=9\u000110=102\u0001").getBytes());
		// the buf ByteBuffer contains the raw fix message
		try {
			parser.parse(buf, listener);
		} catch (FixSessionException e) {
			fail(e.getMessage());
		} catch (FixGarbledException e) {
			fail(e.getMessage());
		}
		
	}
	
	public class MyFixMessageListener implements FixMessageListener { 
		
		@Override
	    public void onFixLogon( FixLogon msg ) { 
			//handle the FIX logon message
			long heartBtInt = msg.heartBtInt;
			//...
			// and when done the message is returned to the pool. If (only if!) you need to keep it you have to clone it.
			// FixLogon logon = msg.clone();
		}

		@Override
		public void onUnknownMessageType(FixMessage msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixHeartbeat(FixHeartbeat msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixTestRequest(FixTestRequest msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixResendRequest(FixResendRequest msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixReject(FixReject msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixSequenceReset(FixSequenceReset msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixLogout(FixLogout msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixIOI(FixIOI msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixAdvertisement(FixAdvertisement msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixExecutionReport(FixExecutionReport msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixOrderCancelReject(FixOrderCancelReject msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixNews(FixNews msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixEmail(FixEmail msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixNewOrderSingle(FixNewOrderSingle msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixNewOrderList(FixNewOrderList msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixOrderCancelRequest(FixOrderCancelRequest msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixOrderCancelReplaceRequest(
				FixOrderCancelReplaceRequest msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixOrderStatusRequest(FixOrderStatusRequest msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixAllocationInstruction(FixAllocationInstruction msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixListCancelRequest(FixListCancelRequest msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixListExecute(FixListExecute msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixListStatusRequest(FixListStatusRequest msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixListStatus(FixListStatus msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixAllocationInstructionAck(
				FixAllocationInstructionAck msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixDontKnowTradeDK(FixDontKnowTradeDK msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixQuoteRequest(FixQuoteRequest msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixQuote(FixQuote msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixSettlementInstructions(FixSettlementInstructions msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixMarketDataRequest(FixMarketDataRequest msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixMarketDataSnapshotFullRefresh(
				FixMarketDataSnapshotFullRefresh msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixMarketDataIncrementalRefresh(
				FixMarketDataIncrementalRefresh msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixMarketDataRequestReject(FixMarketDataRequestReject msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixQuoteCancel(FixQuoteCancel msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixQuoteStatusRequest(FixQuoteStatusRequest msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixMassQuoteAcknowledgement(
				FixMassQuoteAcknowledgement msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixSecurityDefinitionRequest(
				FixSecurityDefinitionRequest msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixSecurityDefinition(FixSecurityDefinition msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixSecurityStatusRequest(FixSecurityStatusRequest msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixSecurityStatus(FixSecurityStatus msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixTradingSessionStatusRequest(
				FixTradingSessionStatusRequest msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixTradingSessionStatus(FixTradingSessionStatus msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixMassQuote(FixMassQuote msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixBusinessMessageReject(FixBusinessMessageReject msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixBidRequest(FixBidRequest msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixBidResponse(FixBidResponse msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixListStrikePrice(FixListStrikePrice msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixRegistrationInstructions(
				FixRegistrationInstructions msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixRegistrationInstructionsResponse(
				FixRegistrationInstructionsResponse msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixOrderMassCancelRequest(FixOrderMassCancelRequest msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixOrderMassCancelReport(FixOrderMassCancelReport msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixNewOrderCross(FixNewOrderCross msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixCrossOrderCancelReplaceRequest(
				FixCrossOrderCancelReplaceRequest msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixCrossOrderCancelRequest(FixCrossOrderCancelRequest msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixSecurityTypeRequest(FixSecurityTypeRequest msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixSecurityTypes(FixSecurityTypes msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixSecurityListRequest(FixSecurityListRequest msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixSecurityList(FixSecurityList msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixDerivativeSecurityListRequest(
				FixDerivativeSecurityListRequest msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixDerivativeSecurityList(FixDerivativeSecurityList msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixNewOrderMultileg(FixNewOrderMultileg msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixMultilegOrderCancelReplace(
				FixMultilegOrderCancelReplace msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixTradeCaptureReportRequest(
				FixTradeCaptureReportRequest msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixTradeCaptureReport(FixTradeCaptureReport msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixOrderMassStatusRequest(FixOrderMassStatusRequest msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixQuoteRequestReject(FixQuoteRequestReject msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixRFQRequest(FixRFQRequest msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixQuoteStatusReport(FixQuoteStatusReport msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixQuoteResponse(FixQuoteResponse msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixConfirmation(FixConfirmation msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixPositionMaintenanceRequest(
				FixPositionMaintenanceRequest msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixPositionMaintenanceReport(
				FixPositionMaintenanceReport msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixRequestForPositions(FixRequestForPositions msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixRequestForPositionsAck(FixRequestForPositionsAck msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixPositionReport(FixPositionReport msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixTradeCaptureReportRequestAck(
				FixTradeCaptureReportRequestAck msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixTradeCaptureReportAck(FixTradeCaptureReportAck msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixAllocationReport(FixAllocationReport msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixAllocationReportAck(FixAllocationReportAck msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixConfirmation_Ack(FixConfirmation_Ack msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixSettlementInstructionRequest(
				FixSettlementInstructionRequest msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixAssignmentReport(FixAssignmentReport msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixCollateralRequest(FixCollateralRequest msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixCollateralAssignment(FixCollateralAssignment msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixCollateralResponse(FixCollateralResponse msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixCollateralReport(FixCollateralReport msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixCollateralInquiry(FixCollateralInquiry msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixNetworkCounterpartySystemStatusRequest(
				FixNetworkCounterpartySystemStatusRequest msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixNetworkCounterpartySystemStatusResponse(
				FixNetworkCounterpartySystemStatusResponse msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixUserRequest(FixUserRequest msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixUserResponse(FixUserResponse msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixCollateralInquiryAck(FixCollateralInquiryAck msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixConfirmationRequest(FixConfirmationRequest msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixContraryIntentionReport(FixContraryIntentionReport msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixSecurityDefinitionUpdateReport(
				FixSecurityDefinitionUpdateReport msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixSecurityListUpdateReport(
				FixSecurityListUpdateReport msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixAdjustedPositionReport(FixAdjustedPositionReport msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixAllocationInstructionAlert(
				FixAllocationInstructionAlert msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixExecutionAcknowledgement(
				FixExecutionAcknowledgement msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixTradingSessionList(FixTradingSessionList msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixTradingSessionListRequest(
				FixTradingSessionListRequest msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixSettlementObligationReport(
				FixSettlementObligationReport msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixDerivativeSecurityListUpdateReport(
				FixDerivativeSecurityListUpdateReport msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixTradingSessionListUpdateReport(
				FixTradingSessionListUpdateReport msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixMarketDefinitionRequest(FixMarketDefinitionRequest msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixMarketDefinition(FixMarketDefinition msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixMarketDefinitionUpdateReport(
				FixMarketDefinitionUpdateReport msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixUserNotification(FixUserNotification msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixOrderMassActionReport(FixOrderMassActionReport msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixOrderMassActionRequest(FixOrderMassActionRequest msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixApplicationMessageRequest(
				FixApplicationMessageRequest msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixApplicationMessageRequestAck(
				FixApplicationMessageRequestAck msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixApplicationMessageReport(
				FixApplicationMessageReport msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixStreamAssignmentRequest(FixStreamAssignmentRequest msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixStreamAssignmentReport(FixStreamAssignmentReport msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixStreamAssignmentReportACK(
				FixStreamAssignmentReportACK msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixPartyDetailsListRequest(FixPartyDetailsListRequest msg) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFixPartyDetailsListReport(FixPartyDetailsListReport msg) {
			// TODO Auto-generated method stub
			
		}
	}
}
