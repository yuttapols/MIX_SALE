package com.mixsale.mixsale.service.impl;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.mixsale.mixsale.dto.UserDTO;
import com.mixsale.mixsale.entity.QrCodeEntity;
import com.mixsale.mixsale.repository.QRCodeRepository;
import com.mixsale.mixsale.service.QRCodeService;

import java.util.Date;
import java.util.HashMap;

@Service
public class QRCodeServiceImpl implements QRCodeService{
	
	@Autowired
	QRCodeRepository qrCodeRepository;

	@Override
	public void genarateQRCode(HttpServletRequest request, HttpServletResponse response, String attrId) throws Exception {
		
		//data that we want to store in the QR code  
		String key = genarateKeyQRCode("01");
		
		String str= key;  
		//path where we want to get QR Code  
		String path = "D:\\QR_CODE\\QRCODE_" + key + ".png";  
		//Encoding charset to be used  
		String charset = "UTF-8";  
		Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();  
		//generates QR code with Low level(L) error correction capability  
		hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);  
		//invoking the user-defined method that creates the QR code  
		generateQRcode(str, path, charset, hashMap, 300, 300);
		
		
		// Save Data
		QrCodeEntity entity = new QrCodeEntity();
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		HttpSession session = request.getSession();
		UserDTO username = (UserDTO) session.getAttribute(attrId);
		
		entity.setQrcode(key);
		entity.setIsActive("1");
		entity.setCreateBy(null != username ? username.getUserName() : "system");
		entity.setCreateDate(timestamp);
		
		qrCodeRepository.saveAndFlush(entity);
		
	}
	
	public void generateQRcode(String data, String path, String charset, Map map, int h, int w) throws WriterException, IOException{    
		BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes(charset), charset), BarcodeFormat.QR_CODE, w, h);  
		MatrixToImageWriter.writeToFile(matrix, path.substring(path.lastIndexOf('.') + 1), new File(path));  
	
	}
	
	public String genarateKeyQRCode(String type) {
		
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int month = localDate.getMonthValue();
		int year = localDate.getYear();
		int day = localDate.getDayOfMonth();

		String suffix = "MIXSALE";
		String running = year +""+ String.format("%02d", month) +""+ String.format("%02d", day) ;
		String random = RandomStringUtils.randomAlphanumeric(10);
		
		String key = suffix + running + type + random;
		
		return key;
	}
	
	

}
