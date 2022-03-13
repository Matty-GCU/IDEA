package textbook.chapter03.assemble.annotation3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class TestConfig {

    @Bean
    @Primary    //若不加@Primary，getBean(Parrot.class);就会报错，因为"expected single matching bean but found 2"
    Parrot getAParrot() {
        return new Parrot("一只虎皮鹦鹉");
    }

    @Bean("a strange parrot")
//    @Bean(value = "a strange parrot")
//    @Bean(name = "a strange parrot")
    Parrot getAnotherParrot() {
        return new Parrot("一只奇奇怪怪的鹦鹉");
    }

    @Bean
    String getAString() {
        return "just a string";
    }

}
