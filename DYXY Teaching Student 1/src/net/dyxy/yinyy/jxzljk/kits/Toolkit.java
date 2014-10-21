package net.dyxy.yinyy.jxzljk.kits;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Toolkit {
	public static String DesEncryptStr(String str){
		return str;
	}
	
	public static String DesDecryptStr(String str){
		return str;
	}

	public static String Md5(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}

			return buf.toString();

			// System.out.println("result: " + buf.toString());// 32位的加密
			//
			// System.out.println("result: " + buf.toString().substring(8,
			// 24));// 16位的加密

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();

			return null;
		}
	}

	public static String sectionFromInteger(int section) {
		String value = "";

		switch (section) {
		case 0:
			value = "1-2节";
			break;
		case 1:
			value = "3-4节";
			break;
		case 2:
			value = "5-6节";
			break;
		case 3:
			value = "7-8节";
			break;
		case 4:
			value = "9-10节";
			break;
		default:
			break;
		}

		return value;
	}
	
	public static String statusFromInteger(int status){
		String s = "";
		
		if((status&32)==32){
			s="消极";
		}else if((status&16)==16){
			s="事假";
		}else if((status&8)==8){
			s = "病假";
		}else if((status&4)==4){
			s="旷课";
		}else if((status&2)==2){
			s = "早退";
		}else if((status&1)==1){
			s="迟到";
		}
	
		return s;
	}
}