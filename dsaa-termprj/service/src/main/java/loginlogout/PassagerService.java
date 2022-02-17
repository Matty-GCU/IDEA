package loginlogout;

import mapper.PassagerMapper;
import org.apache.ibatis.exceptions.PersistenceException;
import util.PasswordUtil;
import util.MyBatisUtil;

public class PassagerService {

    PassagerMapper passagerMapper;

    public PassagerService() {
        passagerMapper = MyBatisUtil.getSqlSession().getMapper(PassagerMapper.class);
    }

    public boolean register(String id, String name, String pwd) {
        if(id == null || name == null || pwd == null || "".equals(id) || "".equals(name) ||"".equals(pwd)) {
            System.out.println("乘客ID/姓名/密码不能为空！");
            return false;
        }
        long idLong = Long.parseLong(id);
        String pwdEncrypted = PasswordUtil.encryptPwd(pwd);
        try {
            passagerMapper.register(idLong, name, pwdEncrypted);
            System.out.println("乘客" + name + "先生/女生，您已注册成功！");
            return true;
        }
        catch(PersistenceException e) {
            System.out.println("乘客" + name + "先生/女生，您已经注册过了。");
            return false;
        }
    }

    public boolean login(String id, String pwd) {
        if(id == null || pwd == null || "".equals(id) || "".equals(pwd)) {
            System.out.println("乘客ID/密码不能为空！");
            return false;
        }
        long idLong = Long.parseLong(id);
        String pwdEncrypted = PasswordUtil.encryptPwd(pwd);
        if(passagerMapper.login(idLong, pwdEncrypted) == 0) {
            System.out.println("乘客登录失败！账户或密码输入错误！");
            return false;
        }
        else {
            System.out.println("乘客登录成功！");
            return true;
        }
    }

}
