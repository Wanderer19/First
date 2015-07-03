package kontur;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

@Configuration
@Import(OtherAppConfig.class)
public class AppConfig {

    @Bean
    public HelloWorld2 helloWorld2(){
        return new HelloWorld2();
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    @Scope("prototype")
    public HelloWorld helloWorld(){
        HelloWorld obj = new HelloWorld();
        obj.setMessage("my message");
        obj.setChecker(new Checker());

        return obj;
    }


}
