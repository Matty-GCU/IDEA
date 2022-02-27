package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordUtilTest {

    @Test
    void encryptPwd() {
        String oriStr = PasswordUtil.encryptPwd("123456");;
        for(int i = 0; i < 10; i++) {
            String str = PasswordUtil.encryptPwd("123456");
            Assertions.assertEquals(oriStr, str);
        }
    }
}