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
        if(currentNum < 1) {
            return;
        }
        if(currentNum == 1) {
            int whiteSpaceCount = (maxNum - currentNum) * 3;
                System.out.printf("%" + whiteSpaceCount + "s", "");
                System.out.print(currentNum);
                System.out.printf("%" + whiteSpaceCount + "s\n", "");
        }
        else {
            //TODO
            return;
        }
    }
}
