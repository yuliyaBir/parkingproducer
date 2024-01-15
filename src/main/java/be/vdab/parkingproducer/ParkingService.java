package be.vdab.parkingproducer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
class ParkingService {
    private record ParkingMessage(LocalDateTime moment, int vrijePlaatsen){}
    private final KafkaTemplate<String, ParkingMessage> kafkaTemplate;

    ParkingService(KafkaTemplate<String, ParkingMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    void updateVrijePlaatsen(String naam, int vrijePlaatsen){
        kafkaTemplate.send("parkings", naam, new ParkingMessage(LocalDateTime.now(), vrijePlaatsen));
    }
}
