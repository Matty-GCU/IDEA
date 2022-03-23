package system;

import mapper.CarMapper;
import mapper.PassagerMapper;
import org.apache.ibatis.session.SqlSession;
import pojo.Car;
import pojo.Passager;
import util.MyBatisUtil;

import java.util.List;

public class BackgroudSystemNew {
    
    SqlSession sqlSession;
    CarMapper carMapper;
    PassagerMapper passagerMapper;
//    List<Car> cars;
//    List<Passager> passagers;
    SequentialList<Car> c;
    SequentialList<Passager> p;
    
    /**
     * 初始化系统
     */
    public BackgroudSystemNew() {
        System.out.println("正在初始化...");
        sqlSession = MyBatisUtil.getSqlSession();
        carMapper = sqlSession.getMapper(CarMapper.class);
        passagerMapper = sqlSession.getMapper(PassagerMapper.class);
        //
        c = new SequentialList<>(4);
        p = new SequentialList<>(2);
        //
        System.out.println("初始化成功。");
        System.out.println("===============================");
        System.out.println("欢迎进入网约车管理系统！");
    }
    
    /**
     * 检查数据库，确认是否有刚登录的乘客（要约车）或司机（要接单），如果有则更新系统数据。
     */
    public void updateAllOnline() {
        List<Car> currCars = carMapper.getAllOnline();
        List<Passager> currPassagers = passagerMapper.getAllOnline();
        //系统里没有乘客也没有车辆，说明系统刚刚初始化
        if(c == null && p == null) {
//            cars = currCars;
//            passagers = currPassagers;
            for(Passager passager : currPassagers) {
                //
                p.insert(passager);
                //
                passager.start();
                System.out.println("【新增】乘客" + passager.getName() + "进入系统，正在自动匹配约车...乘客当前等车位置：" + passager.getDirection());
            }
            for(Car car : currCars) {
                //
                c.insert(car);
                //
                car.start(100);
                System.out.println("【新增】车辆" + car.getCarId() + "进入系统，正在自动匹配接单...车辆当前位置：" + car.getDirection());
            }
        }
        //系统里已有一定乘客和车辆，此时需要检查是否有新增的
        else {
            for(Passager newPassager : currPassagers) {
                boolean isNew = true;
//                for(Passager oldPassager : p) {
//                    if(oldPassager.getId() == newPassager.getId()) {
//                        isNew = false;
//                        break;
//                    }
//                }
                for (int i = 0; i < p.size; i++) {
                    
                }
                
                
                
                if(isNew) {
                    newPassager.start();
                    System.out.println("【新增】乘客" + newPassager.getName() + "进入系统，正在自动匹配约车...乘客当前等车位置：" + newPassager.getDirection());
                }
            }
            for(Car newCar : currCars) {
                boolean isNew = true;
                for(Car oldCar : c) {
                    if(oldCar.getCarId().equals(newCar.getCarId())) {
                        isNew = false;
                        break;
                    }
                }
                if(isNew) {
                    newCar.start(100);
                    System.out.println("【新增】车辆" + newCar.getCarId() + "进入系统，正在自动匹配接单...车辆当前位置：" + newCar.getDirection());
                }
            }
        }
        
    }
    
    /**
     * 模拟系统开始运行
     */
    public void play() {
        System.out.println("===============================");
        System.out.println("进入网约车运营系统！");
        while(true) {
            System.out.println("================================================================================");
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            updateAllOnline();
            
            for(Passager passager : p) {
                System.out.print("乘客" + passager.getName() + (passager.isCalling() ? "正在约车..." : "【已经约到车了】。"));
                System.out.println("他当前的位置是" + passager.getDirection());
                int xP = passager.getX();
                int yP = passager.getY();
                if(passager.isCalling()) {
                    for(Car car : c) {
                        if(car.getPassager() == null) {
                            int xC = car.getX();
                            int yC = car.getY();
                            int limit = passager.getSearchRange();
                            if(Math.abs(xP - xC) < limit && Math.abs(yP - yC) < limit) {
                                car.setPassager(passager);
                                car.setHeadingForPassager(true);
                                passager.setCalling(false);
                                passager.setWaitingSeconds(-1);
                                break;
                            }
                        }
                    }
                }
                int w = passager.getWaitingSeconds();
                if(w == 1) {
                    passager.setWaitingSeconds(12);
                    passager.setSearchRange(passager.getSearchRange() * 2);
                }
                else {
                    passager.setWaitingSeconds(w - 1);
                }
            }
            
            for(Car car : c) {
                car.setNextState();
                StringBuffer str = new StringBuffer();
                str.append("车辆" + car.getCarId());
                if(car.getPassager() == null) {
                    str.append("正在接单...");
                }
                else {
                    str.append("【已接单】，");
                    if(car.isHeadingForPassager()) {
                        str.append("正在前往乘客所在地...");
                    }
                    else {
                        str.append("【正在载客】。");
                    }
                }
                str.append("它目前的位置是");
                str.append(car.getDirection());
                str.append("，速度为");
                str.append(car.isHeadingForPassager() ? "1~1.44" : car.getSpeedPerSecond());
                str.append("单位每秒。");
                System.out.println(str);
            }
        }
    }
    
}
