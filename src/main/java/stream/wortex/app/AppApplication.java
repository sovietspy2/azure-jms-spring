package stream.wortex.app;

import lombok.extern.slf4j.Slf4j;
import org.apache.qpid.jms.JmsQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.jms.Destination;
import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootApplication
@RestController
public class AppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    @Value("${QUEUE}")
    private String queue;

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostConstruct
    private void init() {
        jmsTemplate.setDefaultDestination(new JmsQueue(queue));
    }

    @PostMapping("/messages")
    public String postMessage(@RequestParam String message, Integer age) {
        log.info("Sending message");

        ComplexMessage message1 = new ComplexMessage();

        message1.setName(message);
        message1.setAge(age);
        message1.setDetails(List.of("123","346", "ads"));
        message1.setCreateDate(new Date());


    jmsTemplate.convertAndSend(message1);
        return message;
    }

}
