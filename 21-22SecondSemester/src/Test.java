public class Test {
    public static void main(String[] args) {
        System.out.println(Test.bitCount(18));
    }
    static int bitCount(int val){
        int count = 0;
        while(val > 0) {
            val = val & (val - 1);
            count ++;
        }
    
        return count;
    }
}
