package xyz.wuhang;

import org.junit.jupiter.api.*;

import java.util.LinkedList;

@DisplayName("我的第一个测试用例")
//假装它是用来测试XXX类的
public class XXXTest {

    @BeforeAll
    static void initAll() {
        System.out.println("在所有单元测试之前执行");
    }

    @BeforeEach
    void initEach() {
        System.out.println("在每个单元测试之前执行");
    }

    @Test
    @DisplayName("测试方法01")
    void firstTest() {
        System.out.println("正在执行测试方法01");
    }

    @Test
    //这里没有用@DisplayName注解，所以在测试结果(Test Results)中会直接展示方法名
    void SecondTest() {
        System.out.println("正在执行测试方法02");
    }

    @Test
    @Disabled
    @DisplayName("测试方法03")
    void skippedTest() {
        System.out.println("正在执行测试方法03（不会被执行）");
    }

    @AfterEach
    void tearDownEach() {
        System.out.println("在每个单元测试之后执行");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("在所有单元测试之后执行");
        new LinkedList().push();
    }
}