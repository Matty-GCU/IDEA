package util;

import pojo.Driver;
import pojo.Passager;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

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

    public static void setRandomLocation(Passager passager) {
        Random random = new Random();
        passager.setX(random.nextInt(100));
        passager.setY(random.nextInt(100));
    }

    public static void setRandomLocation(Driver driver) {
        Random random = new Random();
        driver.setX(random.nextInt(100));
        driver.setY(random.nextInt(100));
    }
}
