package com.mixsale.mixsale.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface GenarateQRCodeService {

	public void genarateQRCode(HttpServletRequest request, HttpServletResponse response, String attrId) throws Exception;
}
