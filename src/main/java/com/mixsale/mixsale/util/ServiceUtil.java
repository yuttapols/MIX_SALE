package com.mixsale.mixsale.util;

public class ServiceUtil {

	public static final Integer checkNullIsNumber(Integer value) throws Exception{
		
		if(null == value) {
			return 0;
		}else {
			return value;
		}
	}
	
}
