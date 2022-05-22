package effectivejava;

import java.math.BigInteger;
import java.util.Collections;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
//        Boolean aBoolean = Boolean.valueOf(true);
//        Boolean aBoolean1 = new Boolean(true);
//        Boolean aBoolean2 = new Boolean(false);
//        System.out.println(aBoolean.hashCode());
//        System.out.println(aBoolean1.hashCode());
//        System.out.println(aBoolean2.hashCode());
        BigInteger bigInteger = BigInteger.probablePrime(3, new Random(10));
        System.out.println(bigInteger);
    }
    
    public void m1(int a, String b) {}
    public void m1(String b, int a) {}
}
