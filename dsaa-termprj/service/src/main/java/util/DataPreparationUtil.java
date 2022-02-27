package util;

import loginlogout.DriverService;
import loginlogout.ManagerService;
import loginlogout.PassagerService;

public class DataPreparationUtil {
    public static void prepareAllInfo() {
        ManagerService managerService = new ManagerService();
        managerService.register("root", "123456");
        PassagerService passagerService = new PassagerService();
        passagerService.register("13417141111", "Matty", "123456");
        passagerService.register("15876591111", "Swan", "whss");
        passagerService.login("13417141111", "123456");
        passagerService.login("15876591111", "whss");
        DriverService driverService = new DriverService();
        driverService.registerDriver("13692029409", "小王", "111111", 8);
        driverService.registerDriver("13415178252", "小明", "222222", 16);
        driverService.registerDriver("13417143272", "小吴", "333333", 3);
        driverService.registerDriver("15876597212", "小黄", "444444", 2);
        driverService.registerCar("粤A-123111", "13692029409");
        driverService.registerCar("粤B-123222", "13415178252");
        driverService.registerCar("粤C-123333", "13417143272");
        driverService.registerCar("粤D-123444", "15876597212");
        driverService.login("13692029409", "111111");
        driverService.login("13415178252", "222222");
        driverService.login("13417143272", "333333");
        driverService.login("15876597212", "444444");
    }
}
