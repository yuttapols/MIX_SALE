package com.mixsale.util;

import java.math.BigDecimal;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utils {

	public static String periodFormat(String req) {
		String result = "";
		if (req.length() == 16) {
			result += req.substring(6, 8).concat("/");
			result += req.substring(4, 6).concat("/");
			result += req.substring(0, 4).concat(" - ");

			result += req.substring(14, 16).concat("/");
			result += req.substring(12, 14).concat("/");
			result += req.substring(8, 12);
		}
		return result;
	}

	public String formatAmount(BigDecimal req) {
		NumberFormat formatter = new DecimalFormat("#0,000.00");
		return formatter.format(req);
	}

	public static boolean check(String passwd, String dbEntry) {
		// Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		if (passwd == null || dbEntry == null || dbEntry.length() == 0)
			throw new IllegalArgumentException();
		String[] arr = dbEntry.split(":", 2);
		if (arr.length == 2) {
			// new format as {HASH}:{SALT}
			String cryptpass = arr[0];
			String salt = arr[1];
			String t = passwd + salt;

			return md5(t).equals(cryptpass);
		} else {
			// old format as {HASH} just like PHPbb and many other apps
			String cryptpass = dbEntry;

			return md5(passwd).equals(cryptpass);
		}
	}

	private static String md5(String data) {
		byte[] bdata = new byte[data.length()];
		int i;
		byte[] hash;

		for (i = 0; i < data.length(); i++)
			bdata[i] = (byte) (data.charAt(i) & 0xff);

		try {
			MessageDigest md5er = MessageDigest.getInstance("MD5");
			hash = md5er.digest(bdata);
		} catch (GeneralSecurityException e) {
			throw new RuntimeException(e);
		}

		StringBuffer r = new StringBuffer(32);
		for (i = 0; i < hash.length; i++) {
			String x = Integer.toHexString(hash[i] & 0xff);
			if (x.length() < 2)
				r.append("0");
			r.append(x);
		}
		return r.toString();
	}
}
