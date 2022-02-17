package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Passager {
    long id;
    String name;
    String pwd;

    int x;
    int y;
    boolean isCalling;
    int waitingSeconds;
    int searchRange;

    public String getDirection() {
        return "(" + x + ", " + y + ")";
    }

    public void start() {
        Random random = new Random();
        setX(random.nextInt(100) + 1);
        setY(random.nextInt(100) + 1);
        setCalling(true);
        setWaitingSeconds(12);
        setSearchRange(20);
    }

    public void startAgain() {
        start();
    }

}
