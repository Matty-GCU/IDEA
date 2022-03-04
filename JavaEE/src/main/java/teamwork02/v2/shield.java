package teamwork02.v2;

public class shield implements Component{

    @Override
    public void attack() {
        System.out.println("盾 攻击");
    }

    @Override
    public void defend() {
        System.out.println("盾 防守");
    }
}
