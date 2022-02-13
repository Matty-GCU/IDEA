package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationUtilTest {

    @Test
    void encryptPwd() {
        String s = ApplicationUtil.encryptPwd("123456");
        for(int i = 0; i < 10; i++) {
            Assertions.assertTrue(ApplicationUtil.encryptPwd("123456").equals(s));
            s = ApplicationUtil.encryptPwd("123456");
        }
    }
}