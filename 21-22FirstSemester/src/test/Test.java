package test;

/**
 * @author Matty's PC
 */
public class Test {
    public static void main(String[] args) {
        int n = 16;
        int sum = 1;
        int count = 0;
        for(int i = 0; sum < n; i++) {
            sum += i;
            count++;
        }
        System.out.println(count);
    }
}
