package teamwork02.v2;

public class sword implements Component {

    @Override
    public void attack() {
        System.out.println("剑 攻击");
    }

    @Override
    public void defend() {
        System.out.println("剑 防守");
    }
}
