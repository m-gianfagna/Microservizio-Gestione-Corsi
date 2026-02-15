package it.newunimol.corsi.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CorsoEventListener {

    @RabbitListener(queues = "corsi.queue")
    public void onMessage(String msg) {
        System.out.println("Evento ricevuto: " + msg);
    }
}

