package hash_table;

import java.util.HashMap;
import java.util.Random;

public class EncodeTinyUrl {

	String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	HashMap<String, String> map = new HashMap<>();
	Random rand = new Random();

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		String key = "";
		while (map.containsKey(key)) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 6; i++) {
				sb.append(alphabet.charAt(rand.nextInt(62)));
			}
			key = sb.toString();
		}
		map.put(key, longUrl);
		return "http://tinyurl.com/" + key;
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		return map.get(shortUrl.replace("http://tinyurl.com/", ""));
	}

}
