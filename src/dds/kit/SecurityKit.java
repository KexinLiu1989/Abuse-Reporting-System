package dds.kit;

import dds.config.Const;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityKit {

	/**
	 * 
	 * @param rawStr
	 * @return md5 encryption of rawStr
	 * @throws NoSuchAlgorithmException
	 */
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
	
	/**
	 * 
	 * @param rawStr
	 * @return
	 */
	public static String encryption(String rawStr){
		
		try {
			return getMD5(getMD5(Const.SALT_FOR_MD5)+getMD5(rawStr));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static void main(String[] args){
		System.out.println(SecurityKit.encryption("zhouhao"));
	}
	
}
