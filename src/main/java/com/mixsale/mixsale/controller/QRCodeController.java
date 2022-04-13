package com.mixsale.mixsale.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mixsale.mixsale.service.QRCodeService;

@RestController
@RequestMapping("/api/qrcode")
public class QRCodeController {

	@Autowired
	QRCodeService genarateQRCodeService;

	@GetMapping("/genarate")
	public void genarate(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(name = "attrId") String attrId) throws Exception {
		genarateQRCodeService.genarateQRCode(request, response, attrId);
	}

}
