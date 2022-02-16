package util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ApplicationUtil {

    static MessageDigest messageDigest;

    public static String encryptPwd(String originalPwd) {
        if(messageDigest == null) {
            try {
                messageDigest = MessageDigest.getInstance("SHA-256");
            } catch(NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        messageDigest.update(originalPwd.getBytes(StandardCharsets.UTF_8));
        return new String(messageDigest.digest(), StandardCharsets.UTF_8);
    }

}
