package io.ffreedom.jctp.base;

import ctp.thostapi.CThostFtdcRspInfoField;
import io.ffreedom.common.utils.StringUtil;

public final class JctpRspValidator {

	public static final void validateRspInfo(String spiMethodName, CThostFtdcRspInfoField RspInfo) {
		if (RspInfo != null && RspInfo.getErrorID() != 0)
			throw new JctpRspException(spiMethodName, RspInfo.getErrorID(),
					StringUtil.gbkConversionToUtf8(RspInfo.getErrorMsg()));
	}

}
