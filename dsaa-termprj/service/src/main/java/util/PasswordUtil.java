package util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {

    static MessageDigest messageDigest;

    /**
     * 使用SHA-256算法对密码进行安全的单向加密，避免明文存储密码。
     */
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
