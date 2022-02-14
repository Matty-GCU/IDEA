package customer;

import mapper.PassagerMapper;
import org.apache.ibatis.exceptions.PersistenceException;
import util.ApplicationUtil;
import util.MyBatisUtil;

public class PassagerService {

    PassagerMapper passagerMapper;

    public PassagerService() {
        passagerMapper = MyBatisUtil.getSqlSession().getMapper(PassagerMapper.class);
    }

    public String register(String id, String name, String pwd) {
        if(id == null || name == null || pwd == null || "".equals(id) || "".equals(name) ||"".equals(pwd)) {
            return "ID/姓名/密码不能为空！";
        }
        long idLong = Long.parseLong(id);
        String pwdEncrypted = ApplicationUtil.encryptPwd(pwd);
        try {
            passagerMapper.register(idLong, name, pwdEncrypted);
            return name + "先生/女生，您已注册成功！\n欢迎登录网约车系统，进行自动匹配约车！";
        }
        catch(PersistenceException e) {
            return name + "先生/女生，您已经注册过了。\n欢迎登录网约车系统，进行自动匹配约车！";
        }
    }

    public String login(String id, String pwd) {
        if(id == null || pwd == null || "".equals(id) || "".equals(pwd)) {
            return "ID/密码不能为空！";
        }
        long idLong = Long.parseLong(id);
        String pwdEncrypted = ApplicationUtil.encryptPwd(pwd);
        pojo.Passager passager = passagerMapper.login(idLong, pwdEncrypted);
        if(passager == null) {
            return "登录失败！账户或密码输入错误！";
        }
        else {
            ApplicationUtil.setRandomLocation(passager);
            return passager.getName() + "先生/女士，您已成功登录！\n欢迎进入网约车系统，正在为您自动匹配【距离最近】、【司机驾龄最长】的车辆！" +
                    "\n您当前的位置是(" + passager.getX() + ", " + passager.getY() + ")";
        }
    }

}
