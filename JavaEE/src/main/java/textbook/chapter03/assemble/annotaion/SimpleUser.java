package textbook.chapter03.assemble.annotaion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("annotationUser")
public class SimpleUser {

    @Value("Matty")
    private String name;

    @Override
    public String toString() {
        return "SimpleUser{" +
                "name='" + name + '\'' +
                '}';
    }
}
