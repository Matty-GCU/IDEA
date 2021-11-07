package chapter04.recursion;

/**
 * @author Matty's PC
 */
public class NumberTower {

    int maxNum = -1;

    public NumberTower(int maxNum) {
        this.maxNum = maxNum;
    }

    public void print(int currentNum) {
        //终止条件
        if(currentNum < 1) {
            return;
        }
        //递归
        print(currentNum - 1);


        int whiteSpaceCount = (maxNum - currentNum) * 3;
        //whiteSpaceCount不能为0，否则 %0s 会报错。
        if(whiteSpaceCount != 0) {
            System.out.printf("%" + whiteSpaceCount + "s", "");
        }
        for(int i = 1; i <= currentNum; i++) {
            System.out.print(i + "  ");
        }
        for(int i = currentNum - 1; i >= 1; i--) {
            System.out.print(i + "  ");
        }
        if(whiteSpaceCount != 0) {
            System.out.printf("%" + whiteSpaceCount + "s\n", "");
        }
    }
}
