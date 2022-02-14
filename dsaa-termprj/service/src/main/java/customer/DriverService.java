package customer;

import mapper.CarMapper;
import mapper.DriverMapper;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import pojo.Car;
import pojo.Driver;
import util.ApplicationUtil;
import util.MyBatisUtil;

public class DriverService {

    DriverMapper driverMapper;
    CarMapper carMapper;

    public DriverService() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        driverMapper = sqlSession.getMapper(DriverMapper.class);
        carMapper = sqlSession.getMapper(CarMapper.class);
    }

    public String register(String id, String name, String pwd, int drivingAge) {
        if(id == null || name == null || pwd == null || "".equals(id) || "".equals(name) ||"".equals(pwd)) {
            return "ID/姓名/密码/驾龄不能为空！";
        }
        long idLong = Long.parseLong(id);
        String pwdEncrypted = ApplicationUtil.encryptPwd(pwd);
        try {
            driverMapper.register(idLong, name, pwdEncrypted, drivingAge);
            return name + "先生/女生，您已注册成功！\n欢迎登录网约车系统，进行自动匹配接单！";
        }
        catch(PersistenceException e) {
            return name + "先生/女生，您已经注册过了。\n欢迎登录网约车系统，进行自动匹配接单！";
        }
    }

    public String login(String id, String pwd) {
        if(id == null || pwd == null || "".equals(id) || "".equals(pwd)) {
            return "ID/密码不能为空！";
        }
        long idLong = Long.parseLong(id);
        String pwdEncrypted = ApplicationUtil.encryptPwd(pwd);
        Driver driver = driverMapper.login(idLong, pwdEncrypted);
        if(driver == null) {
            return "登录失败！可能的原因：\n1.账户或密码输入错误\n2.您的名下尚未注册、绑定车辆，无法接单。";
        }
        else {
            Car car = driver.getCar();
            ApplicationUtil.setRandomLocation(car);
            return driver.getName() + "司机（车牌号" + car.getCarId() + "），您已成功登录！\n欢迎进入网约车系统，正在为您自动匹配接单！" +
                    "\n您当前的位置是(" + car.getX() + ", " + car.getY() + ")";
        }
    }

    public String carRegister(String carId, String driverId) {
        if(carId == null || driverId == null) {
            return "车的ID和司机的ID不能为空！";
        }
        long idLong = Long.parseLong(driverId);
        try {
            carMapper.register(carId, idLong);
            return "已成功注册车牌号为" + carId + "的车辆！";
        }
        catch(PersistenceException e) {
            return "车牌号为" + carId + "的车辆已经被注册过了。";
        }
    }
}
