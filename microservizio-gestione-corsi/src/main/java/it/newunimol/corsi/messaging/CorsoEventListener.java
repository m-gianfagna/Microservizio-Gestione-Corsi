package it.newunimol.corsi.messaging;

import it.newunimol.corsi.dto.CorsoResponseDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CorsoEventListener {

    @RabbitListener(queues = "corsi.queue")
    public void onCorsoCreated(CorsoResponseDTO corso) {
        System.out.println("Evento ricevuto: " + corso.getNome() + "(ID: " + corso.getId() + ")");
    }
}

