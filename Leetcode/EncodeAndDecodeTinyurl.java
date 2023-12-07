// url: https://leetcode.com/problems/encode-and-decode-tinyurl/

public class Codec {

    Map<String, String> decMap;

    Codec() {
        decMap = new HashMap<>();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrl = decMap.size() + "";
        decMap.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return decMap.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
