package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Passager {
    long id;
    String name;
    String pwd;

    int x;
    int y;
    boolean isWaiting;
    int waitingSeconds;
}
