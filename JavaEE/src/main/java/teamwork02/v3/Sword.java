package teamwork02.v3;

public class Sword implements Component{

    //更改需求后增加的
    int count = 15;

    @Override
    public void sell() {
        System.out.println("出售 剑");
        //更改需求后增加的
        if(count == 0) {
            System.out.println("出售失败！");
        }
        else {
            System.out.println("出售成功！");
            count--;
        }
    }

    @Override
    public void buy() {
        System.out.println("购买 剑");
    }

    @Override
    public void attack() {
        System.out.println("剑 攻击");
    }

    @Override
    public void defend() {
        System.out.println("剑 防御");
    }}
