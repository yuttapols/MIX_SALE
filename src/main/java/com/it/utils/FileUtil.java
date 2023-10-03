package com.it.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.Date;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	public static String fileToNewFullPath(MultipartFile file) {

		String fullPath = "";
		try {
			
			String path = "";
			String fileName = DateUtil.dateToString2(new Date());
			String extension = FilenameUtils.getExtension(file.getOriginalFilename());
			fullPath = path + fileName + "." + extension;
			File convFile = new File(fullPath);
			file.transferTo(convFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fullPath;
	}

	public static String fileToBase64(String fullPath) {
		StringBuilder imgBase64 = new StringBuilder();
		File file = new File(fullPath);
		byte[] fileContent;
		try {
			fileContent = Files.readAllBytes(file.toPath());

			imgBase64.append("data:");
			imgBase64.append(FilenameUtils.getExtension(fullPath));
			imgBase64.append(";base64,");
			imgBase64.append(Base64.getEncoder().encodeToString(fileContent));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imgBase64.toString();
	}

}
