package kontur;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class HelloWorld implements InitializingBean, DisposableBean{
    private final Logger log = LoggerFactory.getLogger(HelloWorld.class);

    private String message;
    private Checker checker;
    private Map<String, Integer> frequencyDictionary;

    @Bean
    public HelloWorld helloWorld(){
        return new HelloWorld();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void afterPropertiesSet() throws Exception {

    }

    public void check(){
        checker.check();
        System.out.println(checker.getId());
        log.info("!!!");
    }

    public void init(){
        System.out.println("Init");
        this.message = "init";
    }

    public void destroy() throws Exception {
        System.out.println("Destroyed");
    }

    public Checker getChecker() {
        return checker;
    }

    @Required
    public void setChecker(Checker checker) {
        this.checker = checker;
    }

    public Map<String, Integer> getFrequencyDictionary() {
        return frequencyDictionary;
    }

    public void setFrequencyDictionary(Map<String, Integer> frequencyDictionary) {
        this.frequencyDictionary = frequencyDictionary;
    }
}
