package test;

public class Test {
    public static void main(String[] args) {
        int a = 1;
        int max = Integer.MAX_VALUE;
        long start = System.currentTimeMillis();
        for(int i = 0; i < max; i++) {
            for(int j = 0; j < max; j++) {
                while(a > 0) {
                    a <<= 1;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
