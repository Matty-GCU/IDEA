import loginlogout.DriverService;
import loginlogout.ManagerService;
import loginlogout.PassagerService;
import util.DataPreparationUtil;
import system.BackgroundSystemOld;

import java.util.Scanner;

public class ConsoleControllerNew {
    
    BackgroundSystemOld backGroundSystemOld;
    Scanner sc;
    
    public ConsoleControllerNew() {
        backGroundSystemOld = new BackgroundSystemOld();
        sc = new Scanner(System.in);
    }
    
    public void entry() {
        System.out.println("===============================");
        System.out.println("请输入数字，选择对应操作：\n0.录入预设的测试数据以供测试\n1.我是乘客，我要打车\n2.我是司机，我要接单\n3.我是管理员，我要管理系统的运行情况。");
        try {
            int i = sc.nextInt();
            if(i == 0) {
                DataPreparationUtil.prepareAllInfo();
                entry();
            }
            else if(i == 1) {
                openPassagerService();
            }
            else if(i == 2) {
                openDriverService();
            }
            else if(i == 3) {
                openManagerService();
            }
            else {
                System.out.println("无对应操作！");
                entry();
            }
        }
        catch(NumberFormatException e) {
            System.out.println("输入格式错误！");
            entry();
        }
    }
    
    public void openPassagerService() {
        PassagerService service = new PassagerService();
        System.out.println("===============================");
        System.out.println("您好乘客，请输入数字，选择对应操作：\n1.注册身份\n2.登录打车");
        try {
            int i = sc.nextInt();
            if(i == 1) {
                System.out.println("请输入手机号、用户名、密码进行注册：（中间用空格隔开）");
                if(service.register(sc.next(), sc.next(), sc.next())) {
                    entry2();
                }
                else {
                    openPassagerService();
                }
            }
            else if(i == 2) {
                System.out.println("请输入手机号、密码进行登录：（中间用空格隔开）");
                if(service.login(sc.next(), sc.next())) {
                    entry2();
                }
                else {
                    openPassagerService();
                }
            }
            else {
                System.out.println("无对应操作！");
                openPassagerService();
            }
        }
        catch(NumberFormatException e) {
            System.out.println("输入格式错误！");
            openPassagerService();
        }
    }
    
    void entry2() {
        System.out.println("是否进入实时约车/接单系统？请输入数字，选择对应操作\n1.是（开始【自动匹配】打车/接单）\n2.否（回到上一步）");
        int i = sc.nextInt();
        if(i == 1) {
            backGroundSystemOld.play();
        }
        else if(i == 2){
            entry();
        }
        else {
            entry();
        }
    }
    
    public void openDriverService() {
        DriverService service = new DriverService();
        System.out.println("===============================");
        System.out.println("您好司机，请输入数字，选择对应操作：\n1.注册身份\n2.注册车辆\n3.登录接单");
        try {
            int i = sc.nextInt();
            if(i == 1) {
                System.out.println("请输入手机号、用户名、密码、驾龄进行司机身份注册：（中间用空格隔开）");
                if(service.registerDriver(sc.next(), sc.next(), sc.next(), sc.nextInt())) {
                    entry2();
                }
                else {
                    openDriverService();
                }
            }
            else if(i == 2) {
                System.out.println("请输入车牌号、所属司机手机号进行车辆注册");
                if(service.registerCar(sc.next(), sc.next())) {
                    entry2();
                }
                else {
                    openDriverService();
                }
            }
            else if(i == 3) {
                System.out.println("请输入手机号、密码进行登录：（中间用空格隔开）");
                if(service.login(sc.next(), sc.next())) {
                    entry2();
                }
                else {
                    openDriverService();
                }
            }
            else {
                System.out.println("无对应操作！");
                openPassagerService();
            }
        }
        catch(NumberFormatException e) {
            System.out.println("输入格式错误！");
            openPassagerService();
        }
    }
    
    public void openManagerService() {
        ManagerService service = new ManagerService();
        System.out.println("===============================");
        System.out.println("您好管理员，请输入ID、密码进行登录：（中间用空格隔开）");
        if(service.login(sc.next(), sc.next())) {
            System.out.println("请输入数字，选择相应操作：\n1.打印所有已注册乘客、司机、车辆信息\n2.直接进入约车/接单系统查看运营情况\n3.回到上一步");
            try {
                int i = sc.nextInt();
                if(i == 1) {
                    service.getAllRegistered();
                    openManagerService();
                }
                else if(i == 2) {
                    backGroundSystemOld.play();
                }
            }
            catch(NumberFormatException e) {
                System.out.println("数字格式错误！");
            }
        }
        entry();
    }
}
