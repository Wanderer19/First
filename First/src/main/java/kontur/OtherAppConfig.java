package kontur;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OtherAppConfig {
    @Bean
    public Checker checker(){
        Checker checker = new Checker();
        checker.setId("5");
        return checker;
    }
}
