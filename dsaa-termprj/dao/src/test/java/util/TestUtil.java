package util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 这个类是专门用来辅助mapper包的测试的。
 * 它其实就是service模块的ApplicationUtil类
 */
public class TestUtil {

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
