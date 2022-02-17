package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    String carId;
    long driverId;

    int x;
    int y;
    int speedPerSecond;

    int limit;
    boolean headingForPassager;
    Passager passager;

    public String getDirection() {
        StringBuffer str = new StringBuffer();
        str.append("(");
        str.append(x);
        str.append(", ");
        str.append(y);
        str.append(")");
        return str.toString();
    }

    /**
     * @param mapLimit 车辆活动范围（横纵坐标）为1~mapLimit
     */
    public void start(int mapLimit) {
        this.limit = mapLimit;
        Random random = new Random();
        setX(random.nextInt(100) + 1);
        setY(random.nextInt(100) + 1);
        setHeadingForPassager(false);
        setRandomSpeed();
    }

    public void setRandomSpeed() {
        setSpeedPerSecond(new Random().nextInt(20) + 1);
    }

    public void setNextState() {
        Random random = new Random();
        if(! headingForPassager) {
            int step = (int) Math.sqrt(speedPerSecond);
            if(x + step > limit) {
                x -= step;
            }
            else if(x - step < 0) {
                x += step;
            }
            else {
                if(random.nextInt(2) == 1) {
                    x += step;
                }
                else {
                    x -= step;
                }
            }
            if(passager != null) {
                passager.setX(x);
                passager.setY(y);
                if(random.nextInt(10) == 0) {
                    System.out.println("【乘客已下车】！");
                    passager.startAgain();
                    passager = null;
                }
            }
            setRandomSpeed();
        }
        else {
            int xStep = Integer.compare(passager.getX(), x);
            int yStep = Integer.compare(passager.getY(), y);
            if(xStep == 0 && yStep == 0) {
                System.out.println(carId + "【已接到乘客】！");
                headingForPassager = false;
            } else {
                x += xStep;
                y += yStep;
            }
        }
    }

}
