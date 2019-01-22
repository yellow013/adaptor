package io.ffreedom.jctp.gateway;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import io.ffreedom.jctp.jni.td.jctptraderapiv6v3v11x64Constants;

/**
 * @author sun0x00@gmail.com
 */
public class CtpConstant {
	public static Map<String,Character> priceTypeMap = new HashMap<>();
	public static Map<Character,String> priceTypeMapReverse = new HashMap<>();
	
	public static Map<String,Character> directionMap = new HashMap<>();
	public static Map<Character,String> directionMapReverse = new HashMap<>();
	
	public static Map<String,Character> offsetMap = new HashMap<>();
	public static Map<Character,String> offsetMapReverse = new HashMap<>();
	
	public static Map<String,String> exchangeMap = new HashMap<>();
	public static Map<String,String> exchangeMapReverse = new HashMap<>();
	

	public static Map<String,Character> posiDirectionMap = new HashMap<>();
	public static Map<Character,String> posiDirectionMapReverse = new HashMap<>();
	
	public static Map<String,Character> productClassMap = new HashMap<>();
	public static Map<Character,String> productClassMapReverse = new HashMap<>();
	

	public static Map<String,Character> statusMap = new HashMap<>();
	public static Map<Character,String> statusMapReverse = new HashMap<>();
	
	static final int FromMd = 0;

	static final int FromTd = 1;
	
	static {
		
		// 价格类型映射
		priceTypeMap.put(Constant.PRICETYPE_LIMITPRICE, jctptraderapiv6v3v11x64Constants.THOST_FTDC_OPT_LimitPrice);
		priceTypeMap.put(Constant.PRICETYPE_MARKETPRICE, jctptraderapiv6v3v11x64Constants.THOST_FTDC_OPT_AnyPrice);
		priceTypeMapReverse = priceTypeMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
		
		// 方向类型映射
		directionMap.put(Constant.DIRECTION_LONG, jctptraderapiv6v3v11x64Constants.THOST_FTDC_D_Buy);
		directionMap.put(Constant.DIRECTION_SHORT, jctptraderapiv6v3v11x64Constants.THOST_FTDC_D_Sell);
		directionMapReverse = directionMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
		
		// 开平类型映射
		offsetMap.put(Constant.OFFSET_OPEN, jctptraderapiv6v3v11x64Constants.THOST_FTDC_OF_Open);
		offsetMap.put(Constant.OFFSET_CLOSE, jctptraderapiv6v3v11x64Constants.THOST_FTDC_OF_Close);
		offsetMap.put(Constant.OFFSET_CLOSETODAY, jctptraderapiv6v3v11x64Constants.THOST_FTDC_OF_CloseToday);
		offsetMap.put(Constant.OFFSET_CLOSEYESTERDAY, jctptraderapiv6v3v11x64Constants.THOST_FTDC_OF_CloseYesterday);
		offsetMapReverse = offsetMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
		
		// 交易所映射
		exchangeMap.put(Constant.EXCHANGE_CFFEX, "CFFEX");
		exchangeMap.put(Constant.EXCHANGE_SHFE, "SHFE");
		exchangeMap.put(Constant.EXCHANGE_CZCE, "CZCE");
		exchangeMap.put(Constant.EXCHANGE_DCE, "DCE");
		exchangeMap.put(Constant.EXCHANGE_SSE, "SSE");
		exchangeMap.put(Constant.EXCHANGE_SZSE, "SZSE");
		exchangeMap.put(Constant.EXCHANGE_INE, "INE");
		exchangeMap.put(Constant.EXCHANGE_UNKNOWN, "");
		exchangeMapReverse = exchangeMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
		
		//持仓类型映射
		posiDirectionMap.put(Constant.DIRECTION_NET, jctptraderapiv6v3v11x64Constants.THOST_FTDC_PD_Net);
		posiDirectionMap.put(Constant.DIRECTION_LONG, jctptraderapiv6v3v11x64Constants.THOST_FTDC_PD_Long);
		posiDirectionMap.put(Constant.DIRECTION_SHORT, jctptraderapiv6v3v11x64Constants.THOST_FTDC_PD_Short);
		posiDirectionMapReverse = posiDirectionMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
		

		// 产品类型映射
		productClassMap.put(Constant.PRODUCT_FUTURES, jctptraderapiv6v3v11x64Constants.THOST_FTDC_PC_Futures);
		productClassMap.put(Constant.PRODUCT_OPTION, jctptraderapiv6v3v11x64Constants.THOST_FTDC_PC_Options);
		productClassMap.put(Constant.PRODUCT_COMBINATION, jctptraderapiv6v3v11x64Constants.THOST_FTDC_PC_Combination);
		productClassMapReverse = productClassMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
//		v6.3.11不支持个股期权
//		productClassMapReverse.put(jctptraderapiv6v3v11x64Constants.THOST_FTDC_PC_ETFOption, RtConstant.PRODUCT_OPTION);
//		productClassMapReverse.put(jctptraderapiv6v3v11x64Constants.THOST_FTDC_PC_S, RtConstant.PRODUCT_EQUITY);
		
		// 委托状态映射
		statusMap.put(Constant.STATUS_ALLTRADED, jctptraderapiv6v3v11x64Constants.THOST_FTDC_OST_AllTraded);
		statusMap.put(Constant.STATUS_PARTTRADED, jctptraderapiv6v3v11x64Constants.THOST_FTDC_OST_PartTradedQueueing);
		statusMap.put(Constant.STATUS_NOTTRADED, jctptraderapiv6v3v11x64Constants.THOST_FTDC_OST_NoTradeQueueing);
		statusMap.put(Constant.STATUS_CANCELLED, jctptraderapiv6v3v11x64Constants.THOST_FTDC_OST_Canceled);
		statusMap.put(Constant.STATUS_UNKNOWN, jctptraderapiv6v3v11x64Constants.THOST_FTDC_OST_Unknown);
		statusMapReverse = statusMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
		
		
		
	}
}
