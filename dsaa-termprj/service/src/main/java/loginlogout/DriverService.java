package loginlogout;

import mapper.CarMapper;
import mapper.DriverMapper;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import util.PasswordUtil;
import util.MyBatisUtil;

public class DriverService {

    DriverMapper driverMapper;
    CarMapper carMapper;

    public DriverService() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        driverMapper = sqlSession.getMapper(DriverMapper.class);
        carMapper = sqlSession.getMapper(CarMapper.class);
    }

    public void registerDriver(String id, String name, String pwd, int drivingAge) {
        if(id == null || name == null || pwd == null || "".equals(id) || "".equals(name) ||"".equals(pwd)) {
            System.out.println("ID/姓名/密码/驾龄不能为空！");
        }
        long idLong = Long.parseLong(id);
        String pwdEncrypted = PasswordUtil.encryptPwd(pwd);
        try {
            driverMapper.register(idLong, name, pwdEncrypted, drivingAge);
            System.out.println("司机" + name + "先生/女生，您已注册成功！");
        }
        catch(PersistenceException e) {
            System.out.println("司机" + name + "先生/女生，您已经注册过了。");
        }
    }

    public void registerCar(String carId, String driverId) {
        if(carId == null || driverId == null) {
            System.out.println("车的ID和司机的ID不能为空！");
        }
        long idLong = Long.parseLong(driverId);
        try {
            carMapper.register(carId, idLong);
            System.out.println("已成功注册车牌号为" + carId + "的车辆！");
        }
        catch(PersistenceException e) {
            System.out.println("车牌号为" + carId + "的车辆已经被注册过了。");
        }
    }

    public void login(String id, String pwd) {
        if(id == null || pwd == null || "".equals(id) || "".equals(pwd)) {
            System.out.println("ID/密码不能为空！");
        }
        long idLong = Long.parseLong(id);
        String pwdEncrypted = PasswordUtil.encryptPwd(pwd);

        if(driverMapper.login(idLong, pwdEncrypted) == 0) {
            System.out.println("登录失败！可能的原因：\n1.账户或密码输入错误\n2.您的名下尚未注册、绑定车辆，无法接单。");
        }
        else {
            System.out.println("登录成功！");
        }
    }

}
