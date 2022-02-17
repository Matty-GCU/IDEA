package loginlogout;

import mapper.CarMapper;
import mapper.DriverMapper;
import mapper.ManagerMapper;
import mapper.PassagerMapper;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import pojo.Car;
import pojo.Driver;
import pojo.Passager;
import util.MyBatisUtil;
import util.PasswordUtil;

import java.util.List;

public class ManagerService {

    SqlSession sqlSession;
    ManagerMapper managerMapper;

    public ManagerService() {
        sqlSession = MyBatisUtil.getSqlSession();
        managerMapper = sqlSession.getMapper(ManagerMapper.class);
    }

    public boolean register(String id, String pwd) {
        if(id == null || pwd == null || "".equals(id) ||"".equals(pwd)) {
            System.out.println("管理员ID/密码不能为空！");
            return false;
        }
        String pwdEncrypted = PasswordUtil.encryptPwd(pwd);
        try {
            managerMapper.register(id, pwdEncrypted);
            System.out.println("管理员" + id + "已注册成功！");
            return true;
        }
        catch(PersistenceException e) {
            System.out.println("管理员" + id + "已经注册过了。");
            return false;
        }
    }

    public boolean login(String id, String pwd) {
        if(id == null || pwd == null || "".equals(id) || "".equals(pwd)) {
            System.out.println("管理员ID/密码不能为空！");
            return false;
        }
        String pwdEncrypted = PasswordUtil.encryptPwd(pwd);
        if(managerMapper.login(id, pwdEncrypted) == null) {
            System.out.println("账户或密码输入错误！");
            return false;
        }
        else {
            System.out.println("管理员登录成功！");
            return true;
        }
    }

    public void getAllRegistered() {
        System.out.println("以下是所有已注册的司机、车辆与乘客信息：");
        List<Passager> passagerList = sqlSession.getMapper(PassagerMapper.class).getAllRegistered();
        List<Driver> driverList = sqlSession.getMapper(DriverMapper.class).getAllRegistered();
        List<Car> carList = sqlSession.getMapper(CarMapper.class).getAllRegistered();
        for(Passager passager : passagerList) {
            System.out.println(passager);
        }
        for(Driver driver : driverList) {
            System.out.println(driver);
        }
        for(Car car : carList) {
            System.out.println(car);
        }
    }

}
