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
        System.out.println("测试：6除以2。正常情况下会返回3");
        int result = divisionOperation.division(6, 2);
        Assertions.assertEquals(3, result);
    }

    @Test
    @DisplayName("测试02")
    public void divisionTest02() {
        System.out.println("测试：5除以1。正常情况下会报ArithmeticException异常");
        ArithmeticException arithmeticException = Assertions.assertThrows(ArithmeticException.class, () ->
                divisionOperation.division(5, 0)
        );
        Assertions.assertEquals("/ by zero", arithmeticException.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"2,1,1", "9,3,3", "3,5,0"})
    @DisplayName("测试03")
    public void divisionTest03(int a, int b, int expected) {
        System.out.println("测试：" + a + "除以" + b + "。正常情况下会返回" + expected);
    }
}
