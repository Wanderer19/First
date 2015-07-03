package kontur;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Map;

public class Program {



    public static void main(String[] args){
        Logger log = LoggerFactory.getLogger(Program.class);
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("Beans.xml");
        HelloWorld obj2 = context.getBean(HelloWorld.class);
        obj2.check();

        Map<String, Integer> dict = obj2.getFrequencyDictionary();
        log.info("Going to create HelloWord Obj!!!!");
        log.debug("my message");
        for (Map.Entry<String, Integer> pair : dict.entrySet()){
            System.out.println(pair.getKey() + " : "+ pair.getValue());
        }
        context.registerShutdownHook();


        AnnotationConfigApplicationContext context1 = new AnnotationConfigApplicationContext();

        context1.register(AppConfig.class);

        context1.refresh();

        HelloWorld helloWorld = context1.getBean(HelloWorld.class);

        System.out.println(helloWorld.getMessage());
        helloWorld.check();


        Checker checker = context1.getBean(Checker.class);

        System.out.println(checker.getId());

        context1.registerShutdownHook();

    }
}
