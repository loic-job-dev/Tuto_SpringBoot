package fr.campus.loic.service;

import fr.campus.loic.interfaces.HeartbeatSensor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomHeartbeat implements HeartbeatSensor {

    private final Random RANDOM = new Random();

    @Override
    public int getHeartbeat() {
        return RANDOM.nextInt(40, 230);
    }
}
