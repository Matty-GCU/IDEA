package system;

import mapper.CarMapper;
import mapper.PassagerMapper;
import org.apache.ibatis.session.SqlSession;
import pojo.Car;
import pojo.Passager;
import util.MyBatisUtil;

import java.util.List;

public class ControllingSystem {

    SqlSession sqlSession;
    CarMapper carMapper;
    PassagerMapper passagerMapper;
    List<Car> cars;
    List<Passager> passagers;

    /**
     * 初始化系统
     */
    public ControllingSystem() {
        sqlSession = MyBatisUtil.getSqlSession();
        carMapper = sqlSession.getMapper(CarMapper.class);
        passagerMapper = sqlSession.getMapper(PassagerMapper.class);
        updateAllOnline();
    }

    /**
     * 检查数据库，确认是否有刚登录的乘客（要约车）或司机（要接单），如果有则更新系统数据。
     */
    public void updateAllOnline() {
        List<Car> currCars = carMapper.getAllOnline();
        List<Passager> currPassagers = passagerMapper.getAllOnline();
        //系统里没有乘客也没有车辆，说明系统刚刚初始化
        if(cars == null && passagers == null) {
            cars = currCars;
            passagers = currPassagers;
            for(Passager passager : currPassagers) {
                passager.start();
                System.out.println("【新增】乘客" + passager.getName() + "进入系统，正在自动匹配约车...乘客当前等车位置：" + passager.getDirection());
            }
            for(Car car : currCars) {
                car.start(100);
                System.out.println("【新增】车辆" + car.getCarId() + "进入系统，正在自动匹配接单...车辆当前位置：" + car.getDirectionAndSpeed());
            }
        }
        //系统里已有一定乘客和车辆，此时需要检查是否有新增的
        else {
            for(Passager newPassager : currPassagers) {
                boolean isNew = true;
                for(Passager oldPassager : passagers) {
                    if(oldPassager.getId() == newPassager.getId()) {
                        isNew = false;
                        break;
                    }
                }
                if(isNew) {
                    newPassager.start();
                    System.out.println("【新增】乘客" + newPassager.getName() + "进入系统，正在自动匹配约车...乘客当前等车位置：" + newPassager.getDirection());
                }
            }
            for(Car newCar : currCars) {
                boolean isNew = true;
                for(Car oldCar : cars) {
                    if(oldCar.getCarId().equals(newCar.getCarId())) {
                        isNew = false;
                        break;
                    }
                }
                if(isNew) {
                    newCar.start(100);
                    System.out.println("【新增】车辆" + newCar.getCarId() + "进入系统，正在自动匹配接单...车辆当前位置：" + newCar.getDirectionAndSpeed());
                }
            }
        }

    }

    /**
     * 模拟系统开始运行
     */
    public void play() {
        while(true) {
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            updateAllOnline();




            
            for(Passager passager : passagers) {
                System.out.print("乘客" + passager.getName() + (passager.isCalling() ? "正在约车..." : "【已经约到车了】。"));
                System.out.println("他当前的位置是" + passager.getDirection());
                int xP = passager.getX();
                int yP = passager.getY();
                if(passager.isCalling()) {
                    for(Car car : cars) {
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
                if(w != -1) {
                    if(w == 1) {
                        passager.setWaitingSeconds(12);
                        passager.setSearchRange(passager.getSearchRange() * 2);
                    }
                    else {
                        passager.setWaitingSeconds(w - 1);
                    }
                }
            }

            for(Car car : cars) {
                car.setNextState();
                StringBuffer str = new StringBuffer();
                str.append("车辆" + car.getCarId());
                if(car.getPassager() == null) {
                    str.append("正在等待接单...");
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
                str.append(car.getDirectionAndSpeed());
                str.append("，速度为");
                str.append(car.isHeadingForPassager() ? "1.44" : car.getSpeedPerSecond());
                str.append("单位每秒。");
                System.out.println(str);
            }
        }
    }

}
