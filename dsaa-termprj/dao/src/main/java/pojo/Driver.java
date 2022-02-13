package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver {
    long id;
    String name;
    int drivingAge;

    int x;
    int y;
    int carSpeedPerSecond;
    boolean carIsFull;
}
