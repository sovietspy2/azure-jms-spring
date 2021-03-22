package stream.wortex.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Receiver {

    @JmsListener(destination = "${QUEUE}", containerFactory = "jmsListenerContainerFactory")
    public void receiveMessage(ComplexMessage user) {
        log.info("Received message: {}", user.getName());
    }
}
