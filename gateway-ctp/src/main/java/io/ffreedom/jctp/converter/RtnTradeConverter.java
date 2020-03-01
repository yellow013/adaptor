package io.ffreedom.jctp.converter;

import java.util.function.Function;

import ctp.thostapi.CThostFtdcTradeField;
import io.ffreedom.jctp.bean.rsp.RtnTrade;

public class RtnTradeConverter implements Function<CThostFtdcTradeField, RtnTrade> {

	@Override
	public RtnTrade apply(CThostFtdcTradeField from) {
		return new RtnTrade().setBrokerID(from.getBrokerID()).setInvestorID(from.getInvestorID())
				.setInstrumentID(from.getInstrumentID()).setOrderRef(from.getOrderRef()).setUserID(from.getUserID())
				.setExchangeID(from.getExchangeID()).setTradeID(from.getTradeID()).setDirection(from.getDirection())
				.setOrderSysID(from.getOrderSysID()).setParticipantID(from.getParticipantID())
				.setClientID(from.getClientID()).setTradingRole(from.getTradingRole())
				.setExchangeInstID(from.getExchangeInstID()).setOffsetFlag(from.getOffsetFlag())
				.setHedgeFlag(from.getHedgeFlag()).setPrice(from.getPrice()).setVolume(from.getVolume())
				.setTradeDate(from.getTradeDate()).setTradeTime(from.getTradeTime()).setTradeType(from.getTradeType())
				.setPriceSource(from.getPriceSource()).setTraderID(from.getTraderID())
				.setOrderLocalID(from.getOrderLocalID()).setClearingPartID(from.getClearingPartID())
				.setBusinessUnit(from.getBusinessUnit()).setSequenceNo(from.getSequenceNo())
				.setTradingDay(from.getTradingDay()).setSettlementID(from.getSettlementID())
				.setBrokerOrderSeq(from.getBrokerOrderSeq()).setTradeSource(from.getTradeSource())
				.setInvestUnitID(from.getInvestUnitID());
	}

}
