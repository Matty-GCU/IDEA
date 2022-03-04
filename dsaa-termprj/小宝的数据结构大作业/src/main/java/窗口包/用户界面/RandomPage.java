package 窗口包.用户界面;

import 对象包.*;

import 功能包.Function;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RandomPage extends JPanel implements ActionListener {
    Function function;
    JRadioButton rangeA,rangeB,rangeC;
    JRadioButton typeA,typeB,typeC,typeD;
    ButtonGroup group;
    Box boxH1,boxH2,boxH3,boxH4,boxV1;
    JScrollPane scroll;
    JButton random,reset,history;
    JTextArea area;
    Date data;
    SimpleDateFormat formatter;
    File file;
    FileReader reader;
    FileWriter writer;
    BufferedReader br;
    BufferedWriter bw;
    ArrayList<String> randoms;

    public RandomPage(){
        init();
        setSize(450,450);
        setVisible(true);
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public void init(){
        setFile();
        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        randoms = new ArrayList<>();
        addRandom();

        random = new JButton("点击随机");
        reset = new JButton("刷新");
        history = new JButton("历史记录");

        area = new JTextArea(14,35);

        rangeA = new JRadioButton("饭堂");
        rangeB = new JRadioButton("店铺");
        rangeC = new JRadioButton("菜品");
        group = new ButtonGroup();
        group.add(rangeA);
        group.add(rangeB);
        group.add(rangeC);

        typeA = new JRadioButton("咸");
        typeB = new JRadioButton("甜");
        typeC = new JRadioButton("酸");
        typeD = new JRadioButton("辣");

        scroll = new JScrollPane(area);

        boxH1 = Box.createHorizontalBox();
        boxH2 = Box.createHorizontalBox();
        boxH3 = Box.createHorizontalBox();
        boxH4 = Box.createHorizontalBox();
        boxV1 = Box.createVerticalBox();

        boxH1.add(new JLabel("随机范围："));
        boxH1.add(Box.createHorizontalStrut(10));
        boxH1.add(rangeA);
        boxH1.add(rangeB);
        boxH1.add(rangeC);

        boxH2.add(new JLabel("如果对菜品有口味限制，请输入："));
        boxH2.add(Box.createHorizontalStrut(10));
        boxH2.add(typeA);
        boxH2.add(typeB);
        boxH2.add(typeC);
        boxH2.add(typeD);

        boxH3.add(random);
        boxH3.add(Box.createHorizontalStrut(5));
        boxH3.add(reset);
        boxH3.add(Box.createHorizontalStrut(5));
        boxH3.add(history);

        boxH4.add(scroll);

        boxV1.add(boxH1);
        boxV1.add(Box.createVerticalStrut(10));
        boxV1.add(boxH2);
        boxV1.add(Box.createVerticalStrut(5));
        boxV1.add(new JLabel("注：可多选"));
        boxV1.add(Box.createVerticalStrut(10));
        boxV1.add(boxH3);
        boxV1.add(Box.createVerticalStrut(10));
        boxV1.add(boxH4);
        add(boxV1);

        random.addActionListener(this);
        reset.addActionListener(this);
        history.addActionListener(this);

        rangeA.addActionListener(this);
        rangeB.addActionListener(this);
        rangeC.addActionListener(this);

        typeA.addActionListener(this);
        typeB.addActionListener(this);
        typeC.addActionListener(this);
        typeD.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == random){
            String s = null;
            if(rangeA.isSelected() == true){
                data = new Date();
                Canteen canteen = function.randomCanteen();
                s = "   "+formatter.format(data)+"        "+canteen.getName()+"\n";
                randoms.add(s);
                area.append(s);
            }
            else if(rangeB.isSelected() == true){
                data = new Date();
                Store store = function.randomStore();
                s = "   "+formatter.format(data)+"        "+store.getName()+"\n";
                randoms.add(s);
                area.append(s);
            }
            else if(rangeC.isSelected() == true && typeA.isSelected() == false  && typeB.isSelected() == false && typeC.isSelected() == false && typeD.isSelected() == false){
                data = new Date();
                Dash dash = function.randomDash();
                s = "   "+formatter.format(data)+"        "+dash.getName()+"\n";
                randoms.add(s);
                area.append(s);
            }
            else if(rangeC.isSelected() == true && typeA.isSelected() == true && typeB.isSelected() == false && typeC.isSelected() == false && typeD.isSelected() == false){
                data = new Date();
                s = "   "+formatter.format(data)+"        "+function.randomByFlavor("咸")+"\n";
                randoms.add(s);
                area.append(s);
            }
            else if (rangeC.isSelected() == true && typeB.isSelected() == true && typeA.isSelected() == false && typeC.isSelected() == false && typeD.isSelected() == false){
                data = new Date();
                s = "   "+formatter.format(data)+"        "+function.randomByFlavor("甜")+"\n";
                randoms.add(s);
                area.append(s);
            }
            else if (rangeC.isSelected() == true && typeC.isSelected() == true && typeB.isSelected() == true && typeD.isSelected() == false  && typeA.isSelected() == false){
                data = new Date();
                s = "   "+formatter.format(data)+"        "+function.randomByFlavor("酸甜")+"\n";
                randoms.add(s);
                area.append(s);
            }
            else if (rangeC.isSelected() == true && typeC.isSelected() == true && typeA.isSelected() == false && typeB.isSelected() == false && typeD.isSelected() == false){
                data = new Date();
                s = "   "+formatter.format(data)+"        "+function.randomByFlavor("酸")+"\n";
                randoms.add(s);
                area.append(s);
            }
            else if (rangeC.isSelected() == true && typeD.isSelected() == true && typeA.isSelected() == false && typeC.isSelected() == false && typeB.isSelected() == false){
                data = new Date();
                s = "   "+formatter.format(data)+"        "+function.randomByFlavor("辣")+"\n";
                randoms.add(s);
                area.append(s);
            }
            else if (rangeC.isSelected() == true && typeC.isSelected() == true && typeD.isSelected() == true && typeA.isSelected() == false && typeB.isSelected() == false){
                data = new Date();
                s = "   "+formatter.format(data)+"        "+function.randomByFlavor("酸辣")+"\n";
                randoms.add(s);
                area.append(s);
            }
            else {
                data = new Date();
                area.setText("");
                s = "   "+formatter.format(data)+"        "+"对不起，没有你选择的菜品口味哦~"+"\n";
                randoms.add(s);
                area.append(s);
            }
            writeFile();
        }
        if(e.getSource() == reset){
            area.setText("");
        }
        if(e.getSource() == history){
            area.setText("");
            readFile();
        }
    }

    public void setFile(){
        file = new File("随机历史.txt");
        if(!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void readFile() {
        area.append("                    "+"随机历史记录"+"\n");
        String str = null;
        try{
            reader = new FileReader(file);
            br = new BufferedReader(reader);
            while((str = br.readLine())!=null){
                area.append(str+"\n");
            }
            br.close();
            reader.close();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public  void addRandom(){
        String str = null;
        try{
            reader = new FileReader(file);
            br = new BufferedReader(reader);
            while((str = br.readLine())!=null){
                randoms.add(str);
            }
            br.close();
            reader.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void writeFile(){
        String str = null;
        try{
            writer = new FileWriter(file);
            bw = new BufferedWriter(writer);
            for(int n = 0; n<randoms.size(); n++){
                str = randoms.get(n);
                bw.write(str);
                bw.newLine();
            }
            bw.close();
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
