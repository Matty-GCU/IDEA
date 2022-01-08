package chapter15;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Test {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String str = "123456789";
        System.out.println(MD5Test.generateCode(str));
    }

    public static String generateCode(String srcStr) throws NoSuchAlgorithmException {
        /**
         * This MessageDigest class provides applications the functionality of a message digest algorithm, such as SHA-1 or SHA-256.
         * Message digests are secure one-way hash functions that take arbitrary-sized data and output a fixed-length hash value.
         */
        //通常被翻译成 信息摘要
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] srcBytes = srcStr.getBytes();
        md5.update(srcBytes);
        byte[] resultBytes = md5.digest();
        return new String(resultBytes);
    }
}
