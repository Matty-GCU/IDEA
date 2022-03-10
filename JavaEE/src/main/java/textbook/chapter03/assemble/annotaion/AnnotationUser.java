package textbook.chapter03.assemble.annotaion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("annotationUser")
public class AnnotationUser {

    @Value("Matty")
    private String name;

    @Override
    public String toString() {
        return "AnnotationUser{" +
                "name='" + name + '\'' +
                '}';
    }
}
