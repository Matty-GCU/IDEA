package xyz.wuhang;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DivisionOperationTest {

    DivisionOperation divisionOperation;

    @BeforeEach
    public void initTest() {
        divisionOperation = new DivisionOperation();
    }

    @Test
    @DisplayName("测试01")
    public void divisionTest01() {
        System.out.println("测试：6除以2。正常情况下会返回3。如果不是，测试就不通过");
        int result = divisionOperation.division(6, 2);
        Assertions.assertEquals(3, result);
        System.out.println("测试01通过！");
    }

    @Test
    @DisplayName("测试02")
    public void divisionTest02() {
        System.out.println("测试：5除以1。正常情况下会报ArithmeticException异常。如果不是，测试就不通过");
        Assertions.assertThrows(ArithmeticException.class, () ->
                divisionOperation.division(5, 0)
        );
        System.out.println("测试02通过！");
    }

    @ParameterizedTest
    @CsvSource({"2,1,2", "9,3,3", "3,5,0"})
    @DisplayName("测试03")
    public void divisionTest03(int a, int b, int expected) {
        System.out.println("测试：" + a + "除以" + b + "。正常情况下会返回" + expected + "。如果不是，测试就不通过");
        Assertions.assertEquals(expected, divisionOperation.division(a, b));
        System.out.println("测试通过！");
    }
}
