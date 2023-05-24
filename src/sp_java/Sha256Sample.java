package sp_java;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha256Sample {
	static String Sha256(String input) throws NoSuchAlgorithmException  {
		MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
		byte[] result = mDigest.digest(input.getBytes());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < result.length; i ++) {
			sb.append(Integer.toString( (result[i] & 0xFF)+0x100, 16).substring(1));
		}
		
		return sb.toString();
	}

}
