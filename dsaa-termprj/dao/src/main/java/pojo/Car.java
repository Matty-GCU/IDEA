package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    String carId;
    long driverId;

    int x;
    int y;
    int speedPerSecond;
    boolean isFull;
}
