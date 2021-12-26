package chapter01.io;

import java.util.*;
import java.io.*;

/**
 * 20210903Java高级上机实验
 * 将物流信息保存在文件中，再读取文件，将最新的物流信息排在最前面显示出来
 */
public class Exp1Demo {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Matty's PC\\Desktop\\Test.txt");

        FileOutputStream fileOut;
        ObjectOutputStream objectOut = null;
        try {
            file.createNewFile();
            fileOut = new FileOutputStream(file);
            objectOut = new ObjectOutputStream(fileOut);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        Exp1Logistics l1, l2, l3;
        l1 = new Exp1Logistics();
        l2 = new Exp1Logistics();
        l3 = new Exp1Logistics();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, 5 - 1, 20);
        l1.setCalendar(calendar);
        l1.setLocation("广州");
        l1.setPreStation("广州东站");
        l1.setNextStation("广州北");
        calendar = Calendar.getInstance();
        calendar.set(2021, 5 - 1, 25);
        l2.setCalendar(calendar);
        l2.setLocation("深圳");
        l2.setPreStation("深圳北站");
        l2.setNextStation("广州北站");
        calendar = Calendar.getInstance();
        calendar.set(2021, 6 - 1, 1);
        l3.setCalendar(calendar);
        l3.setLocation("汕头市");
        l3.setPreStation("潮阳站");
        l3.setNextStation("潮汕站");
        try {
            if(objectOut != null) {
                objectOut.writeObject(l2);
                objectOut.writeObject(l1);
                objectOut.writeObject(l3);
                objectOut.writeObject(null);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        LinkedList<Exp1Logistics> infos = new LinkedList<>();
        try {
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Exp1Logistics info = (Exp1Logistics) objectIn.readObject();
            while(info != null) {
                infos.add(info);
                info = (Exp1Logistics) objectIn.readObject();
            }
        }
        catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        Collections.sort(infos);
        //增强for循环底层其实是迭代器
        for(Exp1Logistics info: infos) {
            System.out.println(info.toString());
        }
    }

}

