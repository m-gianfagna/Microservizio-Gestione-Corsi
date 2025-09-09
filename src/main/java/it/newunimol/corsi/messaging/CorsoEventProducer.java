package it.newunimol.corsi.messaging;

import it.newunimol.corsi.config.RabbitConfig;
import it.newunimol.corsi.dto.CorsoResponseDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class CorsoEventProducer {

    private final RabbitTemplate rabbitTemplate;

    public CorsoEventProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishCorsoCreated(CorsoResponseDTO corso) {
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE, "corso.created", corso);
    }

    public void publishCorsoDeleted(String corsoId) {
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE, "corso.deleted", corsoId);
    }
}

