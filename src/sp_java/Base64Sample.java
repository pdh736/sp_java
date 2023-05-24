package sp_java;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class Base64Sample {
	static String Base64Encoding(String src) throws UnsupportedEncodingException {
		Encoder encoder = Base64.getEncoder();
		String encodedStr = encoder.encodeToString(src.getBytes("UTF-8"));
		
		return encodedStr;
	}
	static String Base64Decoding(String src) throws UnsupportedEncodingException {
		Decoder decoder = Base64.getDecoder();
		byte[] decodedBytes = decoder.decode(src);
		String decodedString = new String(decodedBytes, "UTF-8");
		return decodedString;
	}
}
