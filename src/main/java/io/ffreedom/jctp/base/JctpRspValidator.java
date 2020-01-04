package io.ffreedom.jctp.base;

import ctp.thostapi.CThostFtdcRspInfoField;
import io.mercury.common.util.StringUtil;

public final class JctpRspValidator {

	public static final void validateRspInfo(String spiMethodName, CThostFtdcRspInfoField RspInfo) {
		if (RspInfo != null && RspInfo.getErrorID() != 0)
			throw new JctpRspException(spiMethodName, RspInfo.getErrorID(),
					StringUtil.conversionGbkToUtf8(RspInfo.getErrorMsg()));
	}

}
