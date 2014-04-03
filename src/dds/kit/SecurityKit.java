package dds.kit;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityKit {

	public static String getMD5(String rawStr) throws NoSuchAlgorithmException{
		
		String original = rawStr;
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(original.getBytes());
		byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}
		return sb.toString();
	}
	
}
