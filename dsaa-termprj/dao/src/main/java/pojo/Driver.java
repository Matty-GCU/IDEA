package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver {
    long id;
    String name;
    String pwd;
    int drivingAge;
    Car car;
}
