package org.tomac.protocol.fix.messaging;

import java.nio.ByteBuffer;
import org.tomac.protocol.fix.FixValidationError;
import org.tomac.protocol.fix.messaging.FixMessageInfo;
import org.tomac.protocol.fix.FixMessage;
import org.tomac.protocol.fix.FixInMessage;
import org.tomac.protocol.fix.messaging.FixAcceptedCancelReplace;
import org.tomac.protocol.fix.messaging.FixAcceptedCancel;
import org.tomac.protocol.fix.messaging.FixApplicationReject;
import org.tomac.protocol.fix.messaging.FixBreakNotification;
import org.tomac.protocol.fix.messaging.FixBusinessReject;
import org.tomac.protocol.fix.messaging.FixCancelNotification;
import org.tomac.protocol.fix.messaging.FixEntryNotificationtoAllegedFirm;
import org.tomac.protocol.fix.messaging.FixExecutionReportFill;
import org.tomac.protocol.fix.messaging.FixExecutionRestatement;
import org.tomac.protocol.fix.messaging.FixLockedinNotification;
import org.tomac.protocol.fix.messaging.FixLockedinTradeBreak;
import org.tomac.protocol.fix.messaging.FixOrderAcknowledgement;
import org.tomac.protocol.fix.messaging.FixOrderReject;
import org.tomac.protocol.fix.messaging.FixPendingCancel;
import org.tomac.protocol.fix.messaging.FixTradeEntryNotificationtoEnteringFirm;
import org.tomac.protocol.fix.messaging.FixTradeReportCancel;
import org.tomac.protocol.fix.messaging.FixTradeReportEntry;
import org.tomac.protocol.fix.messaging.FixHeartbeat;
import org.tomac.protocol.fix.messaging.FixLogon;
import org.tomac.protocol.fix.messaging.FixLogout;
import org.tomac.protocol.fix.messaging.FixOrderSingle;
import org.tomac.protocol.fix.messaging.FixOrderCancelReject;
import org.tomac.protocol.fix.messaging.FixRejectedCancelReplace;
import org.tomac.protocol.fix.messaging.FixOrderCancelReplaceRequest;
import org.tomac.protocol.fix.messaging.FixOrderCancelRequest;
import org.tomac.protocol.fix.messaging.FixReject;
import org.tomac.protocol.fix.messaging.FixResendRequest;
import org.tomac.protocol.fix.messaging.FixSequenceReset;
import org.tomac.protocol.fix.messaging.FixTestRequest;

public class FixMessagePool<T extends FixMessage> {

	FixAcceptedCancelReplace[] poolFixAcceptedCancelReplace;
	boolean[] inUseFixAcceptedCancelReplace;
	FixAcceptedCancel[] poolFixAcceptedCancel;
	boolean[] inUseFixAcceptedCancel;
	FixApplicationReject[] poolFixApplicationReject;
	boolean[] inUseFixApplicationReject;
	FixBreakNotification[] poolFixBreakNotification;
	boolean[] inUseFixBreakNotification;
	FixBusinessReject[] poolFixBusinessReject;
	boolean[] inUseFixBusinessReject;
	FixCancelNotification[] poolFixCancelNotification;
	boolean[] inUseFixCancelNotification;
	FixEntryNotificationtoAllegedFirm[] poolFixEntryNotificationtoAllegedFirm;
	boolean[] inUseFixEntryNotificationtoAllegedFirm;
	FixExecutionReportFill[] poolFixExecutionReportFill;
	boolean[] inUseFixExecutionReportFill;
	FixExecutionRestatement[] poolFixExecutionRestatement;
	boolean[] inUseFixExecutionRestatement;
	FixLockedinNotification[] poolFixLockedinNotification;
	boolean[] inUseFixLockedinNotification;
	FixLockedinTradeBreak[] poolFixLockedinTradeBreak;
	boolean[] inUseFixLockedinTradeBreak;
	FixOrderAcknowledgement[] poolFixOrderAcknowledgement;
	boolean[] inUseFixOrderAcknowledgement;
	FixOrderReject[] poolFixOrderReject;
	boolean[] inUseFixOrderReject;
	FixPendingCancel[] poolFixPendingCancel;
	boolean[] inUseFixPendingCancel;
	FixTradeEntryNotificationtoEnteringFirm[] poolFixTradeEntryNotificationtoEnteringFirm;
	boolean[] inUseFixTradeEntryNotificationtoEnteringFirm;
	FixTradeReportCancel[] poolFixTradeReportCancel;
	boolean[] inUseFixTradeReportCancel;
	FixTradeReportEntry[] poolFixTradeReportEntry;
	boolean[] inUseFixTradeReportEntry;
	FixHeartbeat[] poolFixHeartbeat;
	boolean[] inUseFixHeartbeat;
	FixLogon[] poolFixLogon;
	boolean[] inUseFixLogon;
	FixLogout[] poolFixLogout;
	boolean[] inUseFixLogout;
	FixOrderSingle[] poolFixOrderSingle;
	boolean[] inUseFixOrderSingle;
	FixOrderCancelReject[] poolFixOrderCancelReject;
	boolean[] inUseFixOrderCancelReject;
	FixRejectedCancelReplace[] poolFixRejectedCancelReplace;
	boolean[] inUseFixRejectedCancelReplace;
	FixOrderCancelReplaceRequest[] poolFixOrderCancelReplaceRequest;
	boolean[] inUseFixOrderCancelReplaceRequest;
	FixOrderCancelRequest[] poolFixOrderCancelRequest;
	boolean[] inUseFixOrderCancelRequest;
	FixReject[] poolFixReject;
	boolean[] inUseFixReject;
	FixResendRequest[] poolFixResendRequest;
	boolean[] inUseFixResendRequest;
	FixSequenceReset[] poolFixSequenceReset;
	boolean[] inUseFixSequenceReset;
	FixTestRequest[] poolFixTestRequest;
	boolean[] inUseFixTestRequest;

	public FixMessagePool() {
		poolFixAcceptedCancelReplace = new FixAcceptedCancelReplace[1];
		inUseFixAcceptedCancelReplace = new boolean[1];

		for (int i = poolFixAcceptedCancelReplace.length - 1; i >= 0; i--) {
			poolFixAcceptedCancelReplace[i] = new FixAcceptedCancelReplace();
			inUseFixAcceptedCancelReplace[i] = false;
		}
		poolFixAcceptedCancel = new FixAcceptedCancel[1];
		inUseFixAcceptedCancel = new boolean[1];

		for (int i = poolFixAcceptedCancel.length - 1; i >= 0; i--) {
			poolFixAcceptedCancel[i] = new FixAcceptedCancel();
			inUseFixAcceptedCancel[i] = false;
		}
		poolFixApplicationReject = new FixApplicationReject[1];
		inUseFixApplicationReject = new boolean[1];

		for (int i = poolFixApplicationReject.length - 1; i >= 0; i--) {
			poolFixApplicationReject[i] = new FixApplicationReject();
			inUseFixApplicationReject[i] = false;
		}
		poolFixBreakNotification = new FixBreakNotification[1];
		inUseFixBreakNotification = new boolean[1];

		for (int i = poolFixBreakNotification.length - 1; i >= 0; i--) {
			poolFixBreakNotification[i] = new FixBreakNotification();
			inUseFixBreakNotification[i] = false;
		}
		poolFixBusinessReject = new FixBusinessReject[1];
		inUseFixBusinessReject = new boolean[1];

		for (int i = poolFixBusinessReject.length - 1; i >= 0; i--) {
			poolFixBusinessReject[i] = new FixBusinessReject();
			inUseFixBusinessReject[i] = false;
		}
		poolFixCancelNotification = new FixCancelNotification[1];
		inUseFixCancelNotification = new boolean[1];

		for (int i = poolFixCancelNotification.length - 1; i >= 0; i--) {
			poolFixCancelNotification[i] = new FixCancelNotification();
			inUseFixCancelNotification[i] = false;
		}
		poolFixEntryNotificationtoAllegedFirm = new FixEntryNotificationtoAllegedFirm[1];
		inUseFixEntryNotificationtoAllegedFirm = new boolean[1];

		for (int i = poolFixEntryNotificationtoAllegedFirm.length - 1; i >= 0; i--) {
			poolFixEntryNotificationtoAllegedFirm[i] = new FixEntryNotificationtoAllegedFirm();
			inUseFixEntryNotificationtoAllegedFirm[i] = false;
		}
		poolFixExecutionReportFill = new FixExecutionReportFill[1];
		inUseFixExecutionReportFill = new boolean[1];

		for (int i = poolFixExecutionReportFill.length - 1; i >= 0; i--) {
			poolFixExecutionReportFill[i] = new FixExecutionReportFill();
			inUseFixExecutionReportFill[i] = false;
		}
		poolFixExecutionRestatement = new FixExecutionRestatement[1];
		inUseFixExecutionRestatement = new boolean[1];

		for (int i = poolFixExecutionRestatement.length - 1; i >= 0; i--) {
			poolFixExecutionRestatement[i] = new FixExecutionRestatement();
			inUseFixExecutionRestatement[i] = false;
		}
		poolFixLockedinNotification = new FixLockedinNotification[1];
		inUseFixLockedinNotification = new boolean[1];

		for (int i = poolFixLockedinNotification.length - 1; i >= 0; i--) {
			poolFixLockedinNotification[i] = new FixLockedinNotification();
			inUseFixLockedinNotification[i] = false;
		}
		poolFixLockedinTradeBreak = new FixLockedinTradeBreak[1];
		inUseFixLockedinTradeBreak = new boolean[1];

		for (int i = poolFixLockedinTradeBreak.length - 1; i >= 0; i--) {
			poolFixLockedinTradeBreak[i] = new FixLockedinTradeBreak();
			inUseFixLockedinTradeBreak[i] = false;
		}
		poolFixOrderAcknowledgement = new FixOrderAcknowledgement[1];
		inUseFixOrderAcknowledgement = new boolean[1];

		for (int i = poolFixOrderAcknowledgement.length - 1; i >= 0; i--) {
			poolFixOrderAcknowledgement[i] = new FixOrderAcknowledgement();
			inUseFixOrderAcknowledgement[i] = false;
		}
		poolFixOrderReject = new FixOrderReject[1];
		inUseFixOrderReject = new boolean[1];

		for (int i = poolFixOrderReject.length - 1; i >= 0; i--) {
			poolFixOrderReject[i] = new FixOrderReject();
			inUseFixOrderReject[i] = false;
		}
		poolFixPendingCancel = new FixPendingCancel[1];
		inUseFixPendingCancel = new boolean[1];

		for (int i = poolFixPendingCancel.length - 1; i >= 0; i--) {
			poolFixPendingCancel[i] = new FixPendingCancel();
			inUseFixPendingCancel[i] = false;
		}
		poolFixTradeEntryNotificationtoEnteringFirm = new FixTradeEntryNotificationtoEnteringFirm[1];
		inUseFixTradeEntryNotificationtoEnteringFirm = new boolean[1];

		for (int i = poolFixTradeEntryNotificationtoEnteringFirm.length - 1; i >= 0; i--) {
			poolFixTradeEntryNotificationtoEnteringFirm[i] = new FixTradeEntryNotificationtoEnteringFirm();
			inUseFixTradeEntryNotificationtoEnteringFirm[i] = false;
		}
		poolFixTradeReportCancel = new FixTradeReportCancel[1];
		inUseFixTradeReportCancel = new boolean[1];

		for (int i = poolFixTradeReportCancel.length - 1; i >= 0; i--) {
			poolFixTradeReportCancel[i] = new FixTradeReportCancel();
			inUseFixTradeReportCancel[i] = false;
		}
		poolFixTradeReportEntry = new FixTradeReportEntry[1];
		inUseFixTradeReportEntry = new boolean[1];

		for (int i = poolFixTradeReportEntry.length - 1; i >= 0; i--) {
			poolFixTradeReportEntry[i] = new FixTradeReportEntry();
			inUseFixTradeReportEntry[i] = false;
		}
		poolFixHeartbeat = new FixHeartbeat[1];
		inUseFixHeartbeat = new boolean[1];

		for (int i = poolFixHeartbeat.length - 1; i >= 0; i--) {
			poolFixHeartbeat[i] = new FixHeartbeat();
			inUseFixHeartbeat[i] = false;
		}
		poolFixLogon = new FixLogon[1];
		inUseFixLogon = new boolean[1];

		for (int i = poolFixLogon.length - 1; i >= 0; i--) {
			poolFixLogon[i] = new FixLogon();
			inUseFixLogon[i] = false;
		}
		poolFixLogout = new FixLogout[1];
		inUseFixLogout = new boolean[1];

		for (int i = poolFixLogout.length - 1; i >= 0; i--) {
			poolFixLogout[i] = new FixLogout();
			inUseFixLogout[i] = false;
		}
		poolFixOrderSingle = new FixOrderSingle[1];
		inUseFixOrderSingle = new boolean[1];

		for (int i = poolFixOrderSingle.length - 1; i >= 0; i--) {
			poolFixOrderSingle[i] = new FixOrderSingle();
			inUseFixOrderSingle[i] = false;
		}
		poolFixOrderCancelReject = new FixOrderCancelReject[1];
		inUseFixOrderCancelReject = new boolean[1];

		for (int i = poolFixOrderCancelReject.length - 1; i >= 0; i--) {
			poolFixOrderCancelReject[i] = new FixOrderCancelReject();
			inUseFixOrderCancelReject[i] = false;
		}
		poolFixRejectedCancelReplace = new FixRejectedCancelReplace[1];
		inUseFixRejectedCancelReplace = new boolean[1];

		for (int i = poolFixRejectedCancelReplace.length - 1; i >= 0; i--) {
			poolFixRejectedCancelReplace[i] = new FixRejectedCancelReplace();
			inUseFixRejectedCancelReplace[i] = false;
		}
		poolFixOrderCancelReplaceRequest = new FixOrderCancelReplaceRequest[1];
		inUseFixOrderCancelReplaceRequest = new boolean[1];

		for (int i = poolFixOrderCancelReplaceRequest.length - 1; i >= 0; i--) {
			poolFixOrderCancelReplaceRequest[i] = new FixOrderCancelReplaceRequest();
			inUseFixOrderCancelReplaceRequest[i] = false;
		}
		poolFixOrderCancelRequest = new FixOrderCancelRequest[1];
		inUseFixOrderCancelRequest = new boolean[1];

		for (int i = poolFixOrderCancelRequest.length - 1; i >= 0; i--) {
			poolFixOrderCancelRequest[i] = new FixOrderCancelRequest();
			inUseFixOrderCancelRequest[i] = false;
		}
		poolFixReject = new FixReject[1];
		inUseFixReject = new boolean[1];

		for (int i = poolFixReject.length - 1; i >= 0; i--) {
			poolFixReject[i] = new FixReject();
			inUseFixReject[i] = false;
		}
		poolFixResendRequest = new FixResendRequest[1];
		inUseFixResendRequest = new boolean[1];

		for (int i = poolFixResendRequest.length - 1; i >= 0; i--) {
			poolFixResendRequest[i] = new FixResendRequest();
			inUseFixResendRequest[i] = false;
		}
		poolFixSequenceReset = new FixSequenceReset[1];
		inUseFixSequenceReset = new boolean[1];

		for (int i = poolFixSequenceReset.length - 1; i >= 0; i--) {
			poolFixSequenceReset[i] = new FixSequenceReset();
			inUseFixSequenceReset[i] = false;
		}
		poolFixTestRequest = new FixTestRequest[1];
		inUseFixTestRequest = new boolean[1];

		for (int i = poolFixTestRequest.length - 1; i >= 0; i--) {
			poolFixTestRequest[i] = new FixTestRequest();
			inUseFixTestRequest[i] = false;
		}
	}

	public T getFixMessage(ByteBuffer buf, FixValidationError err) {
		int msgType = FixInMessage.crackMsgType( buf ,err );

		// garbled message
		if (err.hasError()) return null;

		return getFixMessage(msgType, buf, err);
	}
	@SuppressWarnings("unchecked")
	private T getFixMessage(int msgType, ByteBuffer buf, FixValidationError err) {
		switch(msgType) {
		case FixMessageInfo.MessageTypes.ACCEPTEDCANCELREPLACE_INT:
			return (T) getFixAcceptedCancelReplace(buf, err);
		case FixMessageInfo.MessageTypes.ACCEPTEDCANCEL_INT:
			return (T) getFixAcceptedCancel(buf, err);
		case FixMessageInfo.MessageTypes.APPLICATIONREJECT_INT:
			return (T) getFixApplicationReject(buf, err);
		case FixMessageInfo.MessageTypes.BREAKNOTIFICATION_INT:
			return (T) getFixBreakNotification(buf, err);
		case FixMessageInfo.MessageTypes.BUSINESSREJECT_INT:
			return (T) getFixBusinessReject(buf, err);
		case FixMessageInfo.MessageTypes.CANCELNOTIFICATION_INT:
			return (T) getFixCancelNotification(buf, err);
		case FixMessageInfo.MessageTypes.ENTRYNOTIFICATIONTOALLEGEDFIRM_INT:
			return (T) getFixEntryNotificationtoAllegedFirm(buf, err);
		case FixMessageInfo.MessageTypes.EXECUTIONREPORTFILL_INT:
			return (T) getFixExecutionReportFill(buf, err);
		case FixMessageInfo.MessageTypes.EXECUTIONRESTATEMENT_INT:
			return (T) getFixExecutionRestatement(buf, err);
		case FixMessageInfo.MessageTypes.LOCKEDINNOTIFICATION_INT:
			return (T) getFixLockedinNotification(buf, err);
		case FixMessageInfo.MessageTypes.LOCKEDINTRADEBREAK_INT:
			return (T) getFixLockedinTradeBreak(buf, err);
		case FixMessageInfo.MessageTypes.ORDERACKNOWLEDGEMENT_INT:
			return (T) getFixOrderAcknowledgement(buf, err);
		case FixMessageInfo.MessageTypes.ORDERREJECT_INT:
			return (T) getFixOrderReject(buf, err);
		case FixMessageInfo.MessageTypes.PENDINGCANCEL_INT:
			return (T) getFixPendingCancel(buf, err);
		case FixMessageInfo.MessageTypes.TRADEENTRYNOTIFICATIONTOENTERINGFIRM_INT:
			return (T) getFixTradeEntryNotificationtoEnteringFirm(buf, err);
		case FixMessageInfo.MessageTypes.TRADEREPORTCANCEL_INT:
			return (T) getFixTradeReportCancel(buf, err);
		case FixMessageInfo.MessageTypes.TRADEREPORTENTRY_INT:
			return (T) getFixTradeReportEntry(buf, err);
		case FixMessageInfo.MessageTypes.HEARTBEAT_INT:
			return (T) getFixHeartbeat(buf, err);
		case FixMessageInfo.MessageTypes.LOGON_INT:
			return (T) getFixLogon(buf, err);
		case FixMessageInfo.MessageTypes.LOGOUT_INT:
			return (T) getFixLogout(buf, err);
		case FixMessageInfo.MessageTypes.ORDERSINGLE_INT:
			return (T) getFixOrderSingle(buf, err);
		case FixMessageInfo.MessageTypes.ORDERCANCELREJECT_INT:
			return (T) getFixOrderCancelReject(buf, err);
		case FixMessageInfo.MessageTypes.REJECTEDCANCELREPLACE_INT:
			return (T) getFixRejectedCancelReplace(buf, err);
		case FixMessageInfo.MessageTypes.ORDERCANCELREPLACEREQUEST_INT:
			return (T) getFixOrderCancelReplaceRequest(buf, err);
		case FixMessageInfo.MessageTypes.ORDERCANCELREQUEST_INT:
			return (T) getFixOrderCancelRequest(buf, err);
		case FixMessageInfo.MessageTypes.REJECT_INT:
			return (T) getFixReject(buf, err);
		case FixMessageInfo.MessageTypes.RESENDREQUEST_INT:
			return (T) getFixResendRequest(buf, err);
		case FixMessageInfo.MessageTypes.SEQUENCERESET_INT:
			return (T) getFixSequenceReset(buf, err);
		case FixMessageInfo.MessageTypes.TESTREQUEST_INT:
			return (T) getFixTestRequest(buf, err);
		default:
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public T getFixMessage(int msgType) {
		switch(msgType) {
		case FixMessageInfo.MessageTypes.ACCEPTEDCANCELREPLACE_INT:
			return (T) getFixAcceptedCancelReplace();
		case FixMessageInfo.MessageTypes.ACCEPTEDCANCEL_INT:
			return (T) getFixAcceptedCancel();
		case FixMessageInfo.MessageTypes.APPLICATIONREJECT_INT:
			return (T) getFixApplicationReject();
		case FixMessageInfo.MessageTypes.BREAKNOTIFICATION_INT:
			return (T) getFixBreakNotification();
		case FixMessageInfo.MessageTypes.BUSINESSREJECT_INT:
			return (T) getFixBusinessReject();
		case FixMessageInfo.MessageTypes.CANCELNOTIFICATION_INT:
			return (T) getFixCancelNotification();
		case FixMessageInfo.MessageTypes.ENTRYNOTIFICATIONTOALLEGEDFIRM_INT:
			return (T) getFixEntryNotificationtoAllegedFirm();
		case FixMessageInfo.MessageTypes.EXECUTIONREPORTFILL_INT:
			return (T) getFixExecutionReportFill();
		case FixMessageInfo.MessageTypes.EXECUTIONRESTATEMENT_INT:
			return (T) getFixExecutionRestatement();
		case FixMessageInfo.MessageTypes.LOCKEDINNOTIFICATION_INT:
			return (T) getFixLockedinNotification();
		case FixMessageInfo.MessageTypes.LOCKEDINTRADEBREAK_INT:
			return (T) getFixLockedinTradeBreak();
		case FixMessageInfo.MessageTypes.ORDERACKNOWLEDGEMENT_INT:
			return (T) getFixOrderAcknowledgement();
		case FixMessageInfo.MessageTypes.ORDERREJECT_INT:
			return (T) getFixOrderReject();
		case FixMessageInfo.MessageTypes.PENDINGCANCEL_INT:
			return (T) getFixPendingCancel();
		case FixMessageInfo.MessageTypes.TRADEENTRYNOTIFICATIONTOENTERINGFIRM_INT:
			return (T) getFixTradeEntryNotificationtoEnteringFirm();
		case FixMessageInfo.MessageTypes.TRADEREPORTCANCEL_INT:
			return (T) getFixTradeReportCancel();
		case FixMessageInfo.MessageTypes.TRADEREPORTENTRY_INT:
			return (T) getFixTradeReportEntry();
		case FixMessageInfo.MessageTypes.HEARTBEAT_INT:
			return (T) getFixHeartbeat();
		case FixMessageInfo.MessageTypes.LOGON_INT:
			return (T) getFixLogon();
		case FixMessageInfo.MessageTypes.LOGOUT_INT:
			return (T) getFixLogout();
		case FixMessageInfo.MessageTypes.ORDERSINGLE_INT:
			return (T) getFixOrderSingle();
		case FixMessageInfo.MessageTypes.ORDERCANCELREJECT_INT:
			return (T) getFixOrderCancelReject();
		case FixMessageInfo.MessageTypes.REJECTEDCANCELREPLACE_INT:
			return (T) getFixRejectedCancelReplace();
		case FixMessageInfo.MessageTypes.ORDERCANCELREPLACEREQUEST_INT:
			return (T) getFixOrderCancelReplaceRequest();
		case FixMessageInfo.MessageTypes.ORDERCANCELREQUEST_INT:
			return (T) getFixOrderCancelRequest();
		case FixMessageInfo.MessageTypes.REJECT_INT:
			return (T) getFixReject();
		case FixMessageInfo.MessageTypes.RESENDREQUEST_INT:
			return (T) getFixResendRequest();
		case FixMessageInfo.MessageTypes.SEQUENCERESET_INT:
			return (T) getFixSequenceReset();
		case FixMessageInfo.MessageTypes.TESTREQUEST_INT:
			return (T) getFixTestRequest();
		default:
			return null;
		}
	}

	public FixAcceptedCancelReplace getFixAcceptedCancelReplace(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixAcceptedCancelReplace.length - 1; i >= 0; i--)
			if (!inUseFixAcceptedCancelReplace[i]) {
				inUseFixAcceptedCancelReplace[i] = true;
				poolFixAcceptedCancelReplace[i].setBuffer(buf, err);
				return poolFixAcceptedCancelReplace[i];
			}

		boolean[] old_inUse = inUseFixAcceptedCancelReplace;
		inUseFixAcceptedCancelReplace = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixAcceptedCancelReplace, 0, old_inUse.length);

		FixAcceptedCancelReplace[] old_pool = poolFixAcceptedCancelReplace;
		poolFixAcceptedCancelReplace = new FixAcceptedCancelReplace[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixAcceptedCancelReplace, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixAcceptedCancelReplace.length; i++) {
			poolFixAcceptedCancelReplace[i] = new FixAcceptedCancelReplace();
			inUseFixAcceptedCancelReplace[i] = false;
		}

		inUseFixAcceptedCancelReplace[poolFixAcceptedCancelReplace.length - 1] = true;
		poolFixAcceptedCancelReplace[poolFixAcceptedCancelReplace.length - 1].setBuffer(buf, err);
		return poolFixAcceptedCancelReplace[poolFixAcceptedCancelReplace.length - 1];
	}

	public FixAcceptedCancel getFixAcceptedCancel(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixAcceptedCancel.length - 1; i >= 0; i--)
			if (!inUseFixAcceptedCancel[i]) {
				inUseFixAcceptedCancel[i] = true;
				poolFixAcceptedCancel[i].setBuffer(buf, err);
				return poolFixAcceptedCancel[i];
			}

		boolean[] old_inUse = inUseFixAcceptedCancel;
		inUseFixAcceptedCancel = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixAcceptedCancel, 0, old_inUse.length);

		FixAcceptedCancel[] old_pool = poolFixAcceptedCancel;
		poolFixAcceptedCancel = new FixAcceptedCancel[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixAcceptedCancel, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixAcceptedCancel.length; i++) {
			poolFixAcceptedCancel[i] = new FixAcceptedCancel();
			inUseFixAcceptedCancel[i] = false;
		}

		inUseFixAcceptedCancel[poolFixAcceptedCancel.length - 1] = true;
		poolFixAcceptedCancel[poolFixAcceptedCancel.length - 1].setBuffer(buf, err);
		return poolFixAcceptedCancel[poolFixAcceptedCancel.length - 1];
	}

	public FixApplicationReject getFixApplicationReject(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixApplicationReject.length - 1; i >= 0; i--)
			if (!inUseFixApplicationReject[i]) {
				inUseFixApplicationReject[i] = true;
				poolFixApplicationReject[i].setBuffer(buf, err);
				return poolFixApplicationReject[i];
			}

		boolean[] old_inUse = inUseFixApplicationReject;
		inUseFixApplicationReject = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixApplicationReject, 0, old_inUse.length);

		FixApplicationReject[] old_pool = poolFixApplicationReject;
		poolFixApplicationReject = new FixApplicationReject[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixApplicationReject, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixApplicationReject.length; i++) {
			poolFixApplicationReject[i] = new FixApplicationReject();
			inUseFixApplicationReject[i] = false;
		}

		inUseFixApplicationReject[poolFixApplicationReject.length - 1] = true;
		poolFixApplicationReject[poolFixApplicationReject.length - 1].setBuffer(buf, err);
		return poolFixApplicationReject[poolFixApplicationReject.length - 1];
	}

	public FixBreakNotification getFixBreakNotification(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixBreakNotification.length - 1; i >= 0; i--)
			if (!inUseFixBreakNotification[i]) {
				inUseFixBreakNotification[i] = true;
				poolFixBreakNotification[i].setBuffer(buf, err);
				return poolFixBreakNotification[i];
			}

		boolean[] old_inUse = inUseFixBreakNotification;
		inUseFixBreakNotification = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixBreakNotification, 0, old_inUse.length);

		FixBreakNotification[] old_pool = poolFixBreakNotification;
		poolFixBreakNotification = new FixBreakNotification[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixBreakNotification, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixBreakNotification.length; i++) {
			poolFixBreakNotification[i] = new FixBreakNotification();
			inUseFixBreakNotification[i] = false;
		}

		inUseFixBreakNotification[poolFixBreakNotification.length - 1] = true;
		poolFixBreakNotification[poolFixBreakNotification.length - 1].setBuffer(buf, err);
		return poolFixBreakNotification[poolFixBreakNotification.length - 1];
	}

	public FixBusinessReject getFixBusinessReject(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixBusinessReject.length - 1; i >= 0; i--)
			if (!inUseFixBusinessReject[i]) {
				inUseFixBusinessReject[i] = true;
				poolFixBusinessReject[i].setBuffer(buf, err);
				return poolFixBusinessReject[i];
			}

		boolean[] old_inUse = inUseFixBusinessReject;
		inUseFixBusinessReject = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixBusinessReject, 0, old_inUse.length);

		FixBusinessReject[] old_pool = poolFixBusinessReject;
		poolFixBusinessReject = new FixBusinessReject[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixBusinessReject, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixBusinessReject.length; i++) {
			poolFixBusinessReject[i] = new FixBusinessReject();
			inUseFixBusinessReject[i] = false;
		}

		inUseFixBusinessReject[poolFixBusinessReject.length - 1] = true;
		poolFixBusinessReject[poolFixBusinessReject.length - 1].setBuffer(buf, err);
		return poolFixBusinessReject[poolFixBusinessReject.length - 1];
	}

	public FixCancelNotification getFixCancelNotification(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixCancelNotification.length - 1; i >= 0; i--)
			if (!inUseFixCancelNotification[i]) {
				inUseFixCancelNotification[i] = true;
				poolFixCancelNotification[i].setBuffer(buf, err);
				return poolFixCancelNotification[i];
			}

		boolean[] old_inUse = inUseFixCancelNotification;
		inUseFixCancelNotification = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixCancelNotification, 0, old_inUse.length);

		FixCancelNotification[] old_pool = poolFixCancelNotification;
		poolFixCancelNotification = new FixCancelNotification[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixCancelNotification, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixCancelNotification.length; i++) {
			poolFixCancelNotification[i] = new FixCancelNotification();
			inUseFixCancelNotification[i] = false;
		}

		inUseFixCancelNotification[poolFixCancelNotification.length - 1] = true;
		poolFixCancelNotification[poolFixCancelNotification.length - 1].setBuffer(buf, err);
		return poolFixCancelNotification[poolFixCancelNotification.length - 1];
	}

	public FixEntryNotificationtoAllegedFirm getFixEntryNotificationtoAllegedFirm(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixEntryNotificationtoAllegedFirm.length - 1; i >= 0; i--)
			if (!inUseFixEntryNotificationtoAllegedFirm[i]) {
				inUseFixEntryNotificationtoAllegedFirm[i] = true;
				poolFixEntryNotificationtoAllegedFirm[i].setBuffer(buf, err);
				return poolFixEntryNotificationtoAllegedFirm[i];
			}

		boolean[] old_inUse = inUseFixEntryNotificationtoAllegedFirm;
		inUseFixEntryNotificationtoAllegedFirm = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixEntryNotificationtoAllegedFirm, 0, old_inUse.length);

		FixEntryNotificationtoAllegedFirm[] old_pool = poolFixEntryNotificationtoAllegedFirm;
		poolFixEntryNotificationtoAllegedFirm = new FixEntryNotificationtoAllegedFirm[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixEntryNotificationtoAllegedFirm, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixEntryNotificationtoAllegedFirm.length; i++) {
			poolFixEntryNotificationtoAllegedFirm[i] = new FixEntryNotificationtoAllegedFirm();
			inUseFixEntryNotificationtoAllegedFirm[i] = false;
		}

		inUseFixEntryNotificationtoAllegedFirm[poolFixEntryNotificationtoAllegedFirm.length - 1] = true;
		poolFixEntryNotificationtoAllegedFirm[poolFixEntryNotificationtoAllegedFirm.length - 1].setBuffer(buf, err);
		return poolFixEntryNotificationtoAllegedFirm[poolFixEntryNotificationtoAllegedFirm.length - 1];
	}

	public FixExecutionReportFill getFixExecutionReportFill(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixExecutionReportFill.length - 1; i >= 0; i--)
			if (!inUseFixExecutionReportFill[i]) {
				inUseFixExecutionReportFill[i] = true;
				poolFixExecutionReportFill[i].setBuffer(buf, err);
				return poolFixExecutionReportFill[i];
			}

		boolean[] old_inUse = inUseFixExecutionReportFill;
		inUseFixExecutionReportFill = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixExecutionReportFill, 0, old_inUse.length);

		FixExecutionReportFill[] old_pool = poolFixExecutionReportFill;
		poolFixExecutionReportFill = new FixExecutionReportFill[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixExecutionReportFill, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixExecutionReportFill.length; i++) {
			poolFixExecutionReportFill[i] = new FixExecutionReportFill();
			inUseFixExecutionReportFill[i] = false;
		}

		inUseFixExecutionReportFill[poolFixExecutionReportFill.length - 1] = true;
		poolFixExecutionReportFill[poolFixExecutionReportFill.length - 1].setBuffer(buf, err);
		return poolFixExecutionReportFill[poolFixExecutionReportFill.length - 1];
	}

	public FixExecutionRestatement getFixExecutionRestatement(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixExecutionRestatement.length - 1; i >= 0; i--)
			if (!inUseFixExecutionRestatement[i]) {
				inUseFixExecutionRestatement[i] = true;
				poolFixExecutionRestatement[i].setBuffer(buf, err);
				return poolFixExecutionRestatement[i];
			}

		boolean[] old_inUse = inUseFixExecutionRestatement;
		inUseFixExecutionRestatement = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixExecutionRestatement, 0, old_inUse.length);

		FixExecutionRestatement[] old_pool = poolFixExecutionRestatement;
		poolFixExecutionRestatement = new FixExecutionRestatement[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixExecutionRestatement, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixExecutionRestatement.length; i++) {
			poolFixExecutionRestatement[i] = new FixExecutionRestatement();
			inUseFixExecutionRestatement[i] = false;
		}

		inUseFixExecutionRestatement[poolFixExecutionRestatement.length - 1] = true;
		poolFixExecutionRestatement[poolFixExecutionRestatement.length - 1].setBuffer(buf, err);
		return poolFixExecutionRestatement[poolFixExecutionRestatement.length - 1];
	}

	public FixLockedinNotification getFixLockedinNotification(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixLockedinNotification.length - 1; i >= 0; i--)
			if (!inUseFixLockedinNotification[i]) {
				inUseFixLockedinNotification[i] = true;
				poolFixLockedinNotification[i].setBuffer(buf, err);
				return poolFixLockedinNotification[i];
			}

		boolean[] old_inUse = inUseFixLockedinNotification;
		inUseFixLockedinNotification = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixLockedinNotification, 0, old_inUse.length);

		FixLockedinNotification[] old_pool = poolFixLockedinNotification;
		poolFixLockedinNotification = new FixLockedinNotification[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixLockedinNotification, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixLockedinNotification.length; i++) {
			poolFixLockedinNotification[i] = new FixLockedinNotification();
			inUseFixLockedinNotification[i] = false;
		}

		inUseFixLockedinNotification[poolFixLockedinNotification.length - 1] = true;
		poolFixLockedinNotification[poolFixLockedinNotification.length - 1].setBuffer(buf, err);
		return poolFixLockedinNotification[poolFixLockedinNotification.length - 1];
	}

	public FixLockedinTradeBreak getFixLockedinTradeBreak(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixLockedinTradeBreak.length - 1; i >= 0; i--)
			if (!inUseFixLockedinTradeBreak[i]) {
				inUseFixLockedinTradeBreak[i] = true;
				poolFixLockedinTradeBreak[i].setBuffer(buf, err);
				return poolFixLockedinTradeBreak[i];
			}

		boolean[] old_inUse = inUseFixLockedinTradeBreak;
		inUseFixLockedinTradeBreak = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixLockedinTradeBreak, 0, old_inUse.length);

		FixLockedinTradeBreak[] old_pool = poolFixLockedinTradeBreak;
		poolFixLockedinTradeBreak = new FixLockedinTradeBreak[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixLockedinTradeBreak, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixLockedinTradeBreak.length; i++) {
			poolFixLockedinTradeBreak[i] = new FixLockedinTradeBreak();
			inUseFixLockedinTradeBreak[i] = false;
		}

		inUseFixLockedinTradeBreak[poolFixLockedinTradeBreak.length - 1] = true;
		poolFixLockedinTradeBreak[poolFixLockedinTradeBreak.length - 1].setBuffer(buf, err);
		return poolFixLockedinTradeBreak[poolFixLockedinTradeBreak.length - 1];
	}

	public FixOrderAcknowledgement getFixOrderAcknowledgement(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixOrderAcknowledgement.length - 1; i >= 0; i--)
			if (!inUseFixOrderAcknowledgement[i]) {
				inUseFixOrderAcknowledgement[i] = true;
				poolFixOrderAcknowledgement[i].setBuffer(buf, err);
				return poolFixOrderAcknowledgement[i];
			}

		boolean[] old_inUse = inUseFixOrderAcknowledgement;
		inUseFixOrderAcknowledgement = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixOrderAcknowledgement, 0, old_inUse.length);

		FixOrderAcknowledgement[] old_pool = poolFixOrderAcknowledgement;
		poolFixOrderAcknowledgement = new FixOrderAcknowledgement[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixOrderAcknowledgement, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixOrderAcknowledgement.length; i++) {
			poolFixOrderAcknowledgement[i] = new FixOrderAcknowledgement();
			inUseFixOrderAcknowledgement[i] = false;
		}

		inUseFixOrderAcknowledgement[poolFixOrderAcknowledgement.length - 1] = true;
		poolFixOrderAcknowledgement[poolFixOrderAcknowledgement.length - 1].setBuffer(buf, err);
		return poolFixOrderAcknowledgement[poolFixOrderAcknowledgement.length - 1];
	}

	public FixOrderReject getFixOrderReject(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixOrderReject.length - 1; i >= 0; i--)
			if (!inUseFixOrderReject[i]) {
				inUseFixOrderReject[i] = true;
				poolFixOrderReject[i].setBuffer(buf, err);
				return poolFixOrderReject[i];
			}

		boolean[] old_inUse = inUseFixOrderReject;
		inUseFixOrderReject = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixOrderReject, 0, old_inUse.length);

		FixOrderReject[] old_pool = poolFixOrderReject;
		poolFixOrderReject = new FixOrderReject[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixOrderReject, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixOrderReject.length; i++) {
			poolFixOrderReject[i] = new FixOrderReject();
			inUseFixOrderReject[i] = false;
		}

		inUseFixOrderReject[poolFixOrderReject.length - 1] = true;
		poolFixOrderReject[poolFixOrderReject.length - 1].setBuffer(buf, err);
		return poolFixOrderReject[poolFixOrderReject.length - 1];
	}

	public FixPendingCancel getFixPendingCancel(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixPendingCancel.length - 1; i >= 0; i--)
			if (!inUseFixPendingCancel[i]) {
				inUseFixPendingCancel[i] = true;
				poolFixPendingCancel[i].setBuffer(buf, err);
				return poolFixPendingCancel[i];
			}

		boolean[] old_inUse = inUseFixPendingCancel;
		inUseFixPendingCancel = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixPendingCancel, 0, old_inUse.length);

		FixPendingCancel[] old_pool = poolFixPendingCancel;
		poolFixPendingCancel = new FixPendingCancel[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixPendingCancel, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixPendingCancel.length; i++) {
			poolFixPendingCancel[i] = new FixPendingCancel();
			inUseFixPendingCancel[i] = false;
		}

		inUseFixPendingCancel[poolFixPendingCancel.length - 1] = true;
		poolFixPendingCancel[poolFixPendingCancel.length - 1].setBuffer(buf, err);
		return poolFixPendingCancel[poolFixPendingCancel.length - 1];
	}

	public FixTradeEntryNotificationtoEnteringFirm getFixTradeEntryNotificationtoEnteringFirm(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixTradeEntryNotificationtoEnteringFirm.length - 1; i >= 0; i--)
			if (!inUseFixTradeEntryNotificationtoEnteringFirm[i]) {
				inUseFixTradeEntryNotificationtoEnteringFirm[i] = true;
				poolFixTradeEntryNotificationtoEnteringFirm[i].setBuffer(buf, err);
				return poolFixTradeEntryNotificationtoEnteringFirm[i];
			}

		boolean[] old_inUse = inUseFixTradeEntryNotificationtoEnteringFirm;
		inUseFixTradeEntryNotificationtoEnteringFirm = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixTradeEntryNotificationtoEnteringFirm, 0, old_inUse.length);

		FixTradeEntryNotificationtoEnteringFirm[] old_pool = poolFixTradeEntryNotificationtoEnteringFirm;
		poolFixTradeEntryNotificationtoEnteringFirm = new FixTradeEntryNotificationtoEnteringFirm[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixTradeEntryNotificationtoEnteringFirm, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixTradeEntryNotificationtoEnteringFirm.length; i++) {
			poolFixTradeEntryNotificationtoEnteringFirm[i] = new FixTradeEntryNotificationtoEnteringFirm();
			inUseFixTradeEntryNotificationtoEnteringFirm[i] = false;
		}

		inUseFixTradeEntryNotificationtoEnteringFirm[poolFixTradeEntryNotificationtoEnteringFirm.length - 1] = true;
		poolFixTradeEntryNotificationtoEnteringFirm[poolFixTradeEntryNotificationtoEnteringFirm.length - 1].setBuffer(buf, err);
		return poolFixTradeEntryNotificationtoEnteringFirm[poolFixTradeEntryNotificationtoEnteringFirm.length - 1];
	}

	public FixTradeReportCancel getFixTradeReportCancel(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixTradeReportCancel.length - 1; i >= 0; i--)
			if (!inUseFixTradeReportCancel[i]) {
				inUseFixTradeReportCancel[i] = true;
				poolFixTradeReportCancel[i].setBuffer(buf, err);
				return poolFixTradeReportCancel[i];
			}

		boolean[] old_inUse = inUseFixTradeReportCancel;
		inUseFixTradeReportCancel = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixTradeReportCancel, 0, old_inUse.length);

		FixTradeReportCancel[] old_pool = poolFixTradeReportCancel;
		poolFixTradeReportCancel = new FixTradeReportCancel[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixTradeReportCancel, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixTradeReportCancel.length; i++) {
			poolFixTradeReportCancel[i] = new FixTradeReportCancel();
			inUseFixTradeReportCancel[i] = false;
		}

		inUseFixTradeReportCancel[poolFixTradeReportCancel.length - 1] = true;
		poolFixTradeReportCancel[poolFixTradeReportCancel.length - 1].setBuffer(buf, err);
		return poolFixTradeReportCancel[poolFixTradeReportCancel.length - 1];
	}

	public FixTradeReportEntry getFixTradeReportEntry(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixTradeReportEntry.length - 1; i >= 0; i--)
			if (!inUseFixTradeReportEntry[i]) {
				inUseFixTradeReportEntry[i] = true;
				poolFixTradeReportEntry[i].setBuffer(buf, err);
				return poolFixTradeReportEntry[i];
			}

		boolean[] old_inUse = inUseFixTradeReportEntry;
		inUseFixTradeReportEntry = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixTradeReportEntry, 0, old_inUse.length);

		FixTradeReportEntry[] old_pool = poolFixTradeReportEntry;
		poolFixTradeReportEntry = new FixTradeReportEntry[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixTradeReportEntry, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixTradeReportEntry.length; i++) {
			poolFixTradeReportEntry[i] = new FixTradeReportEntry();
			inUseFixTradeReportEntry[i] = false;
		}

		inUseFixTradeReportEntry[poolFixTradeReportEntry.length - 1] = true;
		poolFixTradeReportEntry[poolFixTradeReportEntry.length - 1].setBuffer(buf, err);
		return poolFixTradeReportEntry[poolFixTradeReportEntry.length - 1];
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

	public FixOrderSingle getFixOrderSingle(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixOrderSingle.length - 1; i >= 0; i--)
			if (!inUseFixOrderSingle[i]) {
				inUseFixOrderSingle[i] = true;
				poolFixOrderSingle[i].setBuffer(buf, err);
				return poolFixOrderSingle[i];
			}

		boolean[] old_inUse = inUseFixOrderSingle;
		inUseFixOrderSingle = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixOrderSingle, 0, old_inUse.length);

		FixOrderSingle[] old_pool = poolFixOrderSingle;
		poolFixOrderSingle = new FixOrderSingle[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixOrderSingle, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixOrderSingle.length; i++) {
			poolFixOrderSingle[i] = new FixOrderSingle();
			inUseFixOrderSingle[i] = false;
		}

		inUseFixOrderSingle[poolFixOrderSingle.length - 1] = true;
		poolFixOrderSingle[poolFixOrderSingle.length - 1].setBuffer(buf, err);
		return poolFixOrderSingle[poolFixOrderSingle.length - 1];
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

	public FixRejectedCancelReplace getFixRejectedCancelReplace(ByteBuffer buf, FixValidationError err) {
		for (int i = inUseFixRejectedCancelReplace.length - 1; i >= 0; i--)
			if (!inUseFixRejectedCancelReplace[i]) {
				inUseFixRejectedCancelReplace[i] = true;
				poolFixRejectedCancelReplace[i].setBuffer(buf, err);
				return poolFixRejectedCancelReplace[i];
			}

		boolean[] old_inUse = inUseFixRejectedCancelReplace;
		inUseFixRejectedCancelReplace = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixRejectedCancelReplace, 0, old_inUse.length);

		FixRejectedCancelReplace[] old_pool = poolFixRejectedCancelReplace;
		poolFixRejectedCancelReplace = new FixRejectedCancelReplace[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixRejectedCancelReplace, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixRejectedCancelReplace.length; i++) {
			poolFixRejectedCancelReplace[i] = new FixRejectedCancelReplace();
			inUseFixRejectedCancelReplace[i] = false;
		}

		inUseFixRejectedCancelReplace[poolFixRejectedCancelReplace.length - 1] = true;
		poolFixRejectedCancelReplace[poolFixRejectedCancelReplace.length - 1].setBuffer(buf, err);
		return poolFixRejectedCancelReplace[poolFixRejectedCancelReplace.length - 1];
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

	public FixAcceptedCancelReplace getFixAcceptedCancelReplace() {
		for (int i = inUseFixAcceptedCancelReplace.length - 1; i >= 0; i--)
			if (!inUseFixAcceptedCancelReplace[i]) {
				inUseFixAcceptedCancelReplace[i] = true;
				return poolFixAcceptedCancelReplace[i];
			}

		boolean[] old_inUse = inUseFixAcceptedCancelReplace;
		inUseFixAcceptedCancelReplace = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixAcceptedCancelReplace, 0, old_inUse.length);

		FixAcceptedCancelReplace[] old_pool = poolFixAcceptedCancelReplace;
		poolFixAcceptedCancelReplace = new FixAcceptedCancelReplace[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixAcceptedCancelReplace, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixAcceptedCancelReplace.length; i++) {
			poolFixAcceptedCancelReplace[i] = new FixAcceptedCancelReplace();
			inUseFixAcceptedCancelReplace[i] = false;
		}

		inUseFixAcceptedCancelReplace[poolFixAcceptedCancelReplace.length - 1] = true;
		return poolFixAcceptedCancelReplace[poolFixAcceptedCancelReplace.length - 1];
	}

	public FixAcceptedCancel getFixAcceptedCancel() {
		for (int i = inUseFixAcceptedCancel.length - 1; i >= 0; i--)
			if (!inUseFixAcceptedCancel[i]) {
				inUseFixAcceptedCancel[i] = true;
				return poolFixAcceptedCancel[i];
			}

		boolean[] old_inUse = inUseFixAcceptedCancel;
		inUseFixAcceptedCancel = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixAcceptedCancel, 0, old_inUse.length);

		FixAcceptedCancel[] old_pool = poolFixAcceptedCancel;
		poolFixAcceptedCancel = new FixAcceptedCancel[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixAcceptedCancel, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixAcceptedCancel.length; i++) {
			poolFixAcceptedCancel[i] = new FixAcceptedCancel();
			inUseFixAcceptedCancel[i] = false;
		}

		inUseFixAcceptedCancel[poolFixAcceptedCancel.length - 1] = true;
		return poolFixAcceptedCancel[poolFixAcceptedCancel.length - 1];
	}

	public FixApplicationReject getFixApplicationReject() {
		for (int i = inUseFixApplicationReject.length - 1; i >= 0; i--)
			if (!inUseFixApplicationReject[i]) {
				inUseFixApplicationReject[i] = true;
				return poolFixApplicationReject[i];
			}

		boolean[] old_inUse = inUseFixApplicationReject;
		inUseFixApplicationReject = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixApplicationReject, 0, old_inUse.length);

		FixApplicationReject[] old_pool = poolFixApplicationReject;
		poolFixApplicationReject = new FixApplicationReject[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixApplicationReject, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixApplicationReject.length; i++) {
			poolFixApplicationReject[i] = new FixApplicationReject();
			inUseFixApplicationReject[i] = false;
		}

		inUseFixApplicationReject[poolFixApplicationReject.length - 1] = true;
		return poolFixApplicationReject[poolFixApplicationReject.length - 1];
	}

	public FixBreakNotification getFixBreakNotification() {
		for (int i = inUseFixBreakNotification.length - 1; i >= 0; i--)
			if (!inUseFixBreakNotification[i]) {
				inUseFixBreakNotification[i] = true;
				return poolFixBreakNotification[i];
			}

		boolean[] old_inUse = inUseFixBreakNotification;
		inUseFixBreakNotification = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixBreakNotification, 0, old_inUse.length);

		FixBreakNotification[] old_pool = poolFixBreakNotification;
		poolFixBreakNotification = new FixBreakNotification[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixBreakNotification, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixBreakNotification.length; i++) {
			poolFixBreakNotification[i] = new FixBreakNotification();
			inUseFixBreakNotification[i] = false;
		}

		inUseFixBreakNotification[poolFixBreakNotification.length - 1] = true;
		return poolFixBreakNotification[poolFixBreakNotification.length - 1];
	}

	public FixBusinessReject getFixBusinessReject() {
		for (int i = inUseFixBusinessReject.length - 1; i >= 0; i--)
			if (!inUseFixBusinessReject[i]) {
				inUseFixBusinessReject[i] = true;
				return poolFixBusinessReject[i];
			}

		boolean[] old_inUse = inUseFixBusinessReject;
		inUseFixBusinessReject = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixBusinessReject, 0, old_inUse.length);

		FixBusinessReject[] old_pool = poolFixBusinessReject;
		poolFixBusinessReject = new FixBusinessReject[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixBusinessReject, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixBusinessReject.length; i++) {
			poolFixBusinessReject[i] = new FixBusinessReject();
			inUseFixBusinessReject[i] = false;
		}

		inUseFixBusinessReject[poolFixBusinessReject.length - 1] = true;
		return poolFixBusinessReject[poolFixBusinessReject.length - 1];
	}

	public FixCancelNotification getFixCancelNotification() {
		for (int i = inUseFixCancelNotification.length - 1; i >= 0; i--)
			if (!inUseFixCancelNotification[i]) {
				inUseFixCancelNotification[i] = true;
				return poolFixCancelNotification[i];
			}

		boolean[] old_inUse = inUseFixCancelNotification;
		inUseFixCancelNotification = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixCancelNotification, 0, old_inUse.length);

		FixCancelNotification[] old_pool = poolFixCancelNotification;
		poolFixCancelNotification = new FixCancelNotification[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixCancelNotification, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixCancelNotification.length; i++) {
			poolFixCancelNotification[i] = new FixCancelNotification();
			inUseFixCancelNotification[i] = false;
		}

		inUseFixCancelNotification[poolFixCancelNotification.length - 1] = true;
		return poolFixCancelNotification[poolFixCancelNotification.length - 1];
	}

	public FixEntryNotificationtoAllegedFirm getFixEntryNotificationtoAllegedFirm() {
		for (int i = inUseFixEntryNotificationtoAllegedFirm.length - 1; i >= 0; i--)
			if (!inUseFixEntryNotificationtoAllegedFirm[i]) {
				inUseFixEntryNotificationtoAllegedFirm[i] = true;
				return poolFixEntryNotificationtoAllegedFirm[i];
			}

		boolean[] old_inUse = inUseFixEntryNotificationtoAllegedFirm;
		inUseFixEntryNotificationtoAllegedFirm = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixEntryNotificationtoAllegedFirm, 0, old_inUse.length);

		FixEntryNotificationtoAllegedFirm[] old_pool = poolFixEntryNotificationtoAllegedFirm;
		poolFixEntryNotificationtoAllegedFirm = new FixEntryNotificationtoAllegedFirm[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixEntryNotificationtoAllegedFirm, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixEntryNotificationtoAllegedFirm.length; i++) {
			poolFixEntryNotificationtoAllegedFirm[i] = new FixEntryNotificationtoAllegedFirm();
			inUseFixEntryNotificationtoAllegedFirm[i] = false;
		}

		inUseFixEntryNotificationtoAllegedFirm[poolFixEntryNotificationtoAllegedFirm.length - 1] = true;
		return poolFixEntryNotificationtoAllegedFirm[poolFixEntryNotificationtoAllegedFirm.length - 1];
	}

	public FixExecutionReportFill getFixExecutionReportFill() {
		for (int i = inUseFixExecutionReportFill.length - 1; i >= 0; i--)
			if (!inUseFixExecutionReportFill[i]) {
				inUseFixExecutionReportFill[i] = true;
				return poolFixExecutionReportFill[i];
			}

		boolean[] old_inUse = inUseFixExecutionReportFill;
		inUseFixExecutionReportFill = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixExecutionReportFill, 0, old_inUse.length);

		FixExecutionReportFill[] old_pool = poolFixExecutionReportFill;
		poolFixExecutionReportFill = new FixExecutionReportFill[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixExecutionReportFill, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixExecutionReportFill.length; i++) {
			poolFixExecutionReportFill[i] = new FixExecutionReportFill();
			inUseFixExecutionReportFill[i] = false;
		}

		inUseFixExecutionReportFill[poolFixExecutionReportFill.length - 1] = true;
		return poolFixExecutionReportFill[poolFixExecutionReportFill.length - 1];
	}

	public FixExecutionRestatement getFixExecutionRestatement() {
		for (int i = inUseFixExecutionRestatement.length - 1; i >= 0; i--)
			if (!inUseFixExecutionRestatement[i]) {
				inUseFixExecutionRestatement[i] = true;
				return poolFixExecutionRestatement[i];
			}

		boolean[] old_inUse = inUseFixExecutionRestatement;
		inUseFixExecutionRestatement = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixExecutionRestatement, 0, old_inUse.length);

		FixExecutionRestatement[] old_pool = poolFixExecutionRestatement;
		poolFixExecutionRestatement = new FixExecutionRestatement[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixExecutionRestatement, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixExecutionRestatement.length; i++) {
			poolFixExecutionRestatement[i] = new FixExecutionRestatement();
			inUseFixExecutionRestatement[i] = false;
		}

		inUseFixExecutionRestatement[poolFixExecutionRestatement.length - 1] = true;
		return poolFixExecutionRestatement[poolFixExecutionRestatement.length - 1];
	}

	public FixLockedinNotification getFixLockedinNotification() {
		for (int i = inUseFixLockedinNotification.length - 1; i >= 0; i--)
			if (!inUseFixLockedinNotification[i]) {
				inUseFixLockedinNotification[i] = true;
				return poolFixLockedinNotification[i];
			}

		boolean[] old_inUse = inUseFixLockedinNotification;
		inUseFixLockedinNotification = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixLockedinNotification, 0, old_inUse.length);

		FixLockedinNotification[] old_pool = poolFixLockedinNotification;
		poolFixLockedinNotification = new FixLockedinNotification[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixLockedinNotification, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixLockedinNotification.length; i++) {
			poolFixLockedinNotification[i] = new FixLockedinNotification();
			inUseFixLockedinNotification[i] = false;
		}

		inUseFixLockedinNotification[poolFixLockedinNotification.length - 1] = true;
		return poolFixLockedinNotification[poolFixLockedinNotification.length - 1];
	}

	public FixLockedinTradeBreak getFixLockedinTradeBreak() {
		for (int i = inUseFixLockedinTradeBreak.length - 1; i >= 0; i--)
			if (!inUseFixLockedinTradeBreak[i]) {
				inUseFixLockedinTradeBreak[i] = true;
				return poolFixLockedinTradeBreak[i];
			}

		boolean[] old_inUse = inUseFixLockedinTradeBreak;
		inUseFixLockedinTradeBreak = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixLockedinTradeBreak, 0, old_inUse.length);

		FixLockedinTradeBreak[] old_pool = poolFixLockedinTradeBreak;
		poolFixLockedinTradeBreak = new FixLockedinTradeBreak[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixLockedinTradeBreak, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixLockedinTradeBreak.length; i++) {
			poolFixLockedinTradeBreak[i] = new FixLockedinTradeBreak();
			inUseFixLockedinTradeBreak[i] = false;
		}

		inUseFixLockedinTradeBreak[poolFixLockedinTradeBreak.length - 1] = true;
		return poolFixLockedinTradeBreak[poolFixLockedinTradeBreak.length - 1];
	}

	public FixOrderAcknowledgement getFixOrderAcknowledgement() {
		for (int i = inUseFixOrderAcknowledgement.length - 1; i >= 0; i--)
			if (!inUseFixOrderAcknowledgement[i]) {
				inUseFixOrderAcknowledgement[i] = true;
				return poolFixOrderAcknowledgement[i];
			}

		boolean[] old_inUse = inUseFixOrderAcknowledgement;
		inUseFixOrderAcknowledgement = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixOrderAcknowledgement, 0, old_inUse.length);

		FixOrderAcknowledgement[] old_pool = poolFixOrderAcknowledgement;
		poolFixOrderAcknowledgement = new FixOrderAcknowledgement[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixOrderAcknowledgement, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixOrderAcknowledgement.length; i++) {
			poolFixOrderAcknowledgement[i] = new FixOrderAcknowledgement();
			inUseFixOrderAcknowledgement[i] = false;
		}

		inUseFixOrderAcknowledgement[poolFixOrderAcknowledgement.length - 1] = true;
		return poolFixOrderAcknowledgement[poolFixOrderAcknowledgement.length - 1];
	}

	public FixOrderReject getFixOrderReject() {
		for (int i = inUseFixOrderReject.length - 1; i >= 0; i--)
			if (!inUseFixOrderReject[i]) {
				inUseFixOrderReject[i] = true;
				return poolFixOrderReject[i];
			}

		boolean[] old_inUse = inUseFixOrderReject;
		inUseFixOrderReject = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixOrderReject, 0, old_inUse.length);

		FixOrderReject[] old_pool = poolFixOrderReject;
		poolFixOrderReject = new FixOrderReject[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixOrderReject, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixOrderReject.length; i++) {
			poolFixOrderReject[i] = new FixOrderReject();
			inUseFixOrderReject[i] = false;
		}

		inUseFixOrderReject[poolFixOrderReject.length - 1] = true;
		return poolFixOrderReject[poolFixOrderReject.length - 1];
	}

	public FixPendingCancel getFixPendingCancel() {
		for (int i = inUseFixPendingCancel.length - 1; i >= 0; i--)
			if (!inUseFixPendingCancel[i]) {
				inUseFixPendingCancel[i] = true;
				return poolFixPendingCancel[i];
			}

		boolean[] old_inUse = inUseFixPendingCancel;
		inUseFixPendingCancel = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixPendingCancel, 0, old_inUse.length);

		FixPendingCancel[] old_pool = poolFixPendingCancel;
		poolFixPendingCancel = new FixPendingCancel[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixPendingCancel, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixPendingCancel.length; i++) {
			poolFixPendingCancel[i] = new FixPendingCancel();
			inUseFixPendingCancel[i] = false;
		}

		inUseFixPendingCancel[poolFixPendingCancel.length - 1] = true;
		return poolFixPendingCancel[poolFixPendingCancel.length - 1];
	}

	public FixTradeEntryNotificationtoEnteringFirm getFixTradeEntryNotificationtoEnteringFirm() {
		for (int i = inUseFixTradeEntryNotificationtoEnteringFirm.length - 1; i >= 0; i--)
			if (!inUseFixTradeEntryNotificationtoEnteringFirm[i]) {
				inUseFixTradeEntryNotificationtoEnteringFirm[i] = true;
				return poolFixTradeEntryNotificationtoEnteringFirm[i];
			}

		boolean[] old_inUse = inUseFixTradeEntryNotificationtoEnteringFirm;
		inUseFixTradeEntryNotificationtoEnteringFirm = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixTradeEntryNotificationtoEnteringFirm, 0, old_inUse.length);

		FixTradeEntryNotificationtoEnteringFirm[] old_pool = poolFixTradeEntryNotificationtoEnteringFirm;
		poolFixTradeEntryNotificationtoEnteringFirm = new FixTradeEntryNotificationtoEnteringFirm[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixTradeEntryNotificationtoEnteringFirm, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixTradeEntryNotificationtoEnteringFirm.length; i++) {
			poolFixTradeEntryNotificationtoEnteringFirm[i] = new FixTradeEntryNotificationtoEnteringFirm();
			inUseFixTradeEntryNotificationtoEnteringFirm[i] = false;
		}

		inUseFixTradeEntryNotificationtoEnteringFirm[poolFixTradeEntryNotificationtoEnteringFirm.length - 1] = true;
		return poolFixTradeEntryNotificationtoEnteringFirm[poolFixTradeEntryNotificationtoEnteringFirm.length - 1];
	}

	public FixTradeReportCancel getFixTradeReportCancel() {
		for (int i = inUseFixTradeReportCancel.length - 1; i >= 0; i--)
			if (!inUseFixTradeReportCancel[i]) {
				inUseFixTradeReportCancel[i] = true;
				return poolFixTradeReportCancel[i];
			}

		boolean[] old_inUse = inUseFixTradeReportCancel;
		inUseFixTradeReportCancel = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixTradeReportCancel, 0, old_inUse.length);

		FixTradeReportCancel[] old_pool = poolFixTradeReportCancel;
		poolFixTradeReportCancel = new FixTradeReportCancel[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixTradeReportCancel, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixTradeReportCancel.length; i++) {
			poolFixTradeReportCancel[i] = new FixTradeReportCancel();
			inUseFixTradeReportCancel[i] = false;
		}

		inUseFixTradeReportCancel[poolFixTradeReportCancel.length - 1] = true;
		return poolFixTradeReportCancel[poolFixTradeReportCancel.length - 1];
	}

	public FixTradeReportEntry getFixTradeReportEntry() {
		for (int i = inUseFixTradeReportEntry.length - 1; i >= 0; i--)
			if (!inUseFixTradeReportEntry[i]) {
				inUseFixTradeReportEntry[i] = true;
				return poolFixTradeReportEntry[i];
			}

		boolean[] old_inUse = inUseFixTradeReportEntry;
		inUseFixTradeReportEntry = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixTradeReportEntry, 0, old_inUse.length);

		FixTradeReportEntry[] old_pool = poolFixTradeReportEntry;
		poolFixTradeReportEntry = new FixTradeReportEntry[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixTradeReportEntry, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixTradeReportEntry.length; i++) {
			poolFixTradeReportEntry[i] = new FixTradeReportEntry();
			inUseFixTradeReportEntry[i] = false;
		}

		inUseFixTradeReportEntry[poolFixTradeReportEntry.length - 1] = true;
		return poolFixTradeReportEntry[poolFixTradeReportEntry.length - 1];
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

	public FixOrderSingle getFixOrderSingle() {
		for (int i = inUseFixOrderSingle.length - 1; i >= 0; i--)
			if (!inUseFixOrderSingle[i]) {
				inUseFixOrderSingle[i] = true;
				return poolFixOrderSingle[i];
			}

		boolean[] old_inUse = inUseFixOrderSingle;
		inUseFixOrderSingle = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixOrderSingle, 0, old_inUse.length);

		FixOrderSingle[] old_pool = poolFixOrderSingle;
		poolFixOrderSingle = new FixOrderSingle[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixOrderSingle, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixOrderSingle.length; i++) {
			poolFixOrderSingle[i] = new FixOrderSingle();
			inUseFixOrderSingle[i] = false;
		}

		inUseFixOrderSingle[poolFixOrderSingle.length - 1] = true;
		return poolFixOrderSingle[poolFixOrderSingle.length - 1];
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

	public FixRejectedCancelReplace getFixRejectedCancelReplace() {
		for (int i = inUseFixRejectedCancelReplace.length - 1; i >= 0; i--)
			if (!inUseFixRejectedCancelReplace[i]) {
				inUseFixRejectedCancelReplace[i] = true;
				return poolFixRejectedCancelReplace[i];
			}

		boolean[] old_inUse = inUseFixRejectedCancelReplace;
		inUseFixRejectedCancelReplace = new boolean[old_inUse.length + 10];
		System.arraycopy(old_inUse, 0, inUseFixRejectedCancelReplace, 0, old_inUse.length);

		FixRejectedCancelReplace[] old_pool = poolFixRejectedCancelReplace;
		poolFixRejectedCancelReplace = new FixRejectedCancelReplace[old_pool.length + 10];
		System.arraycopy(old_pool, 0, poolFixRejectedCancelReplace, 0, old_pool.length);

		for (int i = old_pool.length; i < poolFixRejectedCancelReplace.length; i++) {
			poolFixRejectedCancelReplace[i] = new FixRejectedCancelReplace();
			inUseFixRejectedCancelReplace[i] = false;
		}

		inUseFixRejectedCancelReplace[poolFixRejectedCancelReplace.length - 1] = true;
		return poolFixRejectedCancelReplace[poolFixRejectedCancelReplace.length - 1];
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

	public void returnFixMessage(T msg) {
		switch(msg.msgType) {
			case FixMessageInfo.MessageTypes.ACCEPTEDCANCELREPLACE_INT:
				returnFixAcceptedCancelReplace((FixAcceptedCancelReplace)msg);
				break;
			case FixMessageInfo.MessageTypes.ACCEPTEDCANCEL_INT:
				returnFixAcceptedCancel((FixAcceptedCancel)msg);
				break;
			case FixMessageInfo.MessageTypes.APPLICATIONREJECT_INT:
				returnFixApplicationReject((FixApplicationReject)msg);
				break;
			case FixMessageInfo.MessageTypes.BREAKNOTIFICATION_INT:
				returnFixBreakNotification((FixBreakNotification)msg);
				break;
			case FixMessageInfo.MessageTypes.BUSINESSREJECT_INT:
				returnFixBusinessReject((FixBusinessReject)msg);
				break;
			case FixMessageInfo.MessageTypes.CANCELNOTIFICATION_INT:
				returnFixCancelNotification((FixCancelNotification)msg);
				break;
			case FixMessageInfo.MessageTypes.ENTRYNOTIFICATIONTOALLEGEDFIRM_INT:
				returnFixEntryNotificationtoAllegedFirm((FixEntryNotificationtoAllegedFirm)msg);
				break;
			case FixMessageInfo.MessageTypes.EXECUTIONREPORTFILL_INT:
				returnFixExecutionReportFill((FixExecutionReportFill)msg);
				break;
			case FixMessageInfo.MessageTypes.EXECUTIONRESTATEMENT_INT:
				returnFixExecutionRestatement((FixExecutionRestatement)msg);
				break;
			case FixMessageInfo.MessageTypes.LOCKEDINNOTIFICATION_INT:
				returnFixLockedinNotification((FixLockedinNotification)msg);
				break;
			case FixMessageInfo.MessageTypes.LOCKEDINTRADEBREAK_INT:
				returnFixLockedinTradeBreak((FixLockedinTradeBreak)msg);
				break;
			case FixMessageInfo.MessageTypes.ORDERACKNOWLEDGEMENT_INT:
				returnFixOrderAcknowledgement((FixOrderAcknowledgement)msg);
				break;
			case FixMessageInfo.MessageTypes.ORDERREJECT_INT:
				returnFixOrderReject((FixOrderReject)msg);
				break;
			case FixMessageInfo.MessageTypes.PENDINGCANCEL_INT:
				returnFixPendingCancel((FixPendingCancel)msg);
				break;
			case FixMessageInfo.MessageTypes.TRADEENTRYNOTIFICATIONTOENTERINGFIRM_INT:
				returnFixTradeEntryNotificationtoEnteringFirm((FixTradeEntryNotificationtoEnteringFirm)msg);
				break;
			case FixMessageInfo.MessageTypes.TRADEREPORTCANCEL_INT:
				returnFixTradeReportCancel((FixTradeReportCancel)msg);
				break;
			case FixMessageInfo.MessageTypes.TRADEREPORTENTRY_INT:
				returnFixTradeReportEntry((FixTradeReportEntry)msg);
				break;
			case FixMessageInfo.MessageTypes.HEARTBEAT_INT:
				returnFixHeartbeat((FixHeartbeat)msg);
				break;
			case FixMessageInfo.MessageTypes.LOGON_INT:
				returnFixLogon((FixLogon)msg);
				break;
			case FixMessageInfo.MessageTypes.LOGOUT_INT:
				returnFixLogout((FixLogout)msg);
				break;
			case FixMessageInfo.MessageTypes.ORDERSINGLE_INT:
				returnFixOrderSingle((FixOrderSingle)msg);
				break;
			case FixMessageInfo.MessageTypes.ORDERCANCELREJECT_INT:
				returnFixOrderCancelReject((FixOrderCancelReject)msg);
				break;
			case FixMessageInfo.MessageTypes.REJECTEDCANCELREPLACE_INT:
				returnFixRejectedCancelReplace((FixRejectedCancelReplace)msg);
				break;
			case FixMessageInfo.MessageTypes.ORDERCANCELREPLACEREQUEST_INT:
				returnFixOrderCancelReplaceRequest((FixOrderCancelReplaceRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.ORDERCANCELREQUEST_INT:
				returnFixOrderCancelRequest((FixOrderCancelRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.REJECT_INT:
				returnFixReject((FixReject)msg);
				break;
			case FixMessageInfo.MessageTypes.RESENDREQUEST_INT:
				returnFixResendRequest((FixResendRequest)msg);
				break;
			case FixMessageInfo.MessageTypes.SEQUENCERESET_INT:
				returnFixSequenceReset((FixSequenceReset)msg);
				break;
			case FixMessageInfo.MessageTypes.TESTREQUEST_INT:
				returnFixTestRequest((FixTestRequest)msg);
				break;
			default:
				break;
		}

	}

	public void returnFixAcceptedCancelReplace(FixAcceptedCancelReplace msg) {

		for (int i = inUseFixAcceptedCancelReplace.length - 1; i >= 0; i--) {
			if (poolFixAcceptedCancelReplace[i] == msg) {
				inUseFixAcceptedCancelReplace[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixAcceptedCancel(FixAcceptedCancel msg) {

		for (int i = inUseFixAcceptedCancel.length - 1; i >= 0; i--) {
			if (poolFixAcceptedCancel[i] == msg) {
				inUseFixAcceptedCancel[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixApplicationReject(FixApplicationReject msg) {

		for (int i = inUseFixApplicationReject.length - 1; i >= 0; i--) {
			if (poolFixApplicationReject[i] == msg) {
				inUseFixApplicationReject[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixBreakNotification(FixBreakNotification msg) {

		for (int i = inUseFixBreakNotification.length - 1; i >= 0; i--) {
			if (poolFixBreakNotification[i] == msg) {
				inUseFixBreakNotification[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixBusinessReject(FixBusinessReject msg) {

		for (int i = inUseFixBusinessReject.length - 1; i >= 0; i--) {
			if (poolFixBusinessReject[i] == msg) {
				inUseFixBusinessReject[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixCancelNotification(FixCancelNotification msg) {

		for (int i = inUseFixCancelNotification.length - 1; i >= 0; i--) {
			if (poolFixCancelNotification[i] == msg) {
				inUseFixCancelNotification[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixEntryNotificationtoAllegedFirm(FixEntryNotificationtoAllegedFirm msg) {

		for (int i = inUseFixEntryNotificationtoAllegedFirm.length - 1; i >= 0; i--) {
			if (poolFixEntryNotificationtoAllegedFirm[i] == msg) {
				inUseFixEntryNotificationtoAllegedFirm[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixExecutionReportFill(FixExecutionReportFill msg) {

		for (int i = inUseFixExecutionReportFill.length - 1; i >= 0; i--) {
			if (poolFixExecutionReportFill[i] == msg) {
				inUseFixExecutionReportFill[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixExecutionRestatement(FixExecutionRestatement msg) {

		for (int i = inUseFixExecutionRestatement.length - 1; i >= 0; i--) {
			if (poolFixExecutionRestatement[i] == msg) {
				inUseFixExecutionRestatement[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixLockedinNotification(FixLockedinNotification msg) {

		for (int i = inUseFixLockedinNotification.length - 1; i >= 0; i--) {
			if (poolFixLockedinNotification[i] == msg) {
				inUseFixLockedinNotification[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixLockedinTradeBreak(FixLockedinTradeBreak msg) {

		for (int i = inUseFixLockedinTradeBreak.length - 1; i >= 0; i--) {
			if (poolFixLockedinTradeBreak[i] == msg) {
				inUseFixLockedinTradeBreak[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixOrderAcknowledgement(FixOrderAcknowledgement msg) {

		for (int i = inUseFixOrderAcknowledgement.length - 1; i >= 0; i--) {
			if (poolFixOrderAcknowledgement[i] == msg) {
				inUseFixOrderAcknowledgement[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixOrderReject(FixOrderReject msg) {

		for (int i = inUseFixOrderReject.length - 1; i >= 0; i--) {
			if (poolFixOrderReject[i] == msg) {
				inUseFixOrderReject[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixPendingCancel(FixPendingCancel msg) {

		for (int i = inUseFixPendingCancel.length - 1; i >= 0; i--) {
			if (poolFixPendingCancel[i] == msg) {
				inUseFixPendingCancel[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixTradeEntryNotificationtoEnteringFirm(FixTradeEntryNotificationtoEnteringFirm msg) {

		for (int i = inUseFixTradeEntryNotificationtoEnteringFirm.length - 1; i >= 0; i--) {
			if (poolFixTradeEntryNotificationtoEnteringFirm[i] == msg) {
				inUseFixTradeEntryNotificationtoEnteringFirm[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixTradeReportCancel(FixTradeReportCancel msg) {

		for (int i = inUseFixTradeReportCancel.length - 1; i >= 0; i--) {
			if (poolFixTradeReportCancel[i] == msg) {
				inUseFixTradeReportCancel[i] = false;
				msg.clear();
				return;
			}
		}
	}

	public void returnFixTradeReportEntry(FixTradeReportEntry msg) {

		for (int i = inUseFixTradeReportEntry.length - 1; i >= 0; i--) {
			if (poolFixTradeReportEntry[i] == msg) {
				inUseFixTradeReportEntry[i] = false;
				msg.clear();
				return;
			}
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

	public void returnFixLogon(FixLogon msg) {

		for (int i = inUseFixLogon.length - 1; i >= 0; i--) {
			if (poolFixLogon[i] == msg) {
				inUseFixLogon[i] = false;
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

	public void returnFixOrderSingle(FixOrderSingle msg) {

		for (int i = inUseFixOrderSingle.length - 1; i >= 0; i--) {
			if (poolFixOrderSingle[i] == msg) {
				inUseFixOrderSingle[i] = false;
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

	public void returnFixRejectedCancelReplace(FixRejectedCancelReplace msg) {

		for (int i = inUseFixRejectedCancelReplace.length - 1; i >= 0; i--) {
			if (poolFixRejectedCancelReplace[i] == msg) {
				inUseFixRejectedCancelReplace[i] = false;
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

	public void returnFixOrderCancelRequest(FixOrderCancelRequest msg) {

		for (int i = inUseFixOrderCancelRequest.length - 1; i >= 0; i--) {
			if (poolFixOrderCancelRequest[i] == msg) {
				inUseFixOrderCancelRequest[i] = false;
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

	public void returnFixResendRequest(FixResendRequest msg) {

		for (int i = inUseFixResendRequest.length - 1; i >= 0; i--) {
			if (poolFixResendRequest[i] == msg) {
				inUseFixResendRequest[i] = false;
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

	public void returnFixTestRequest(FixTestRequest msg) {

		for (int i = inUseFixTestRequest.length - 1; i >= 0; i--) {
			if (poolFixTestRequest[i] == msg) {
				inUseFixTestRequest[i] = false;
				msg.clear();
				return;
			}
		}
	}

}
