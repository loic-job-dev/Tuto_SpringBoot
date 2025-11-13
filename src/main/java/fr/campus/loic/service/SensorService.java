package fr.campus.loic.service;

import fr.campus.loic.model.Sensor;
import fr.campus.loic.repository.SensorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {

    private final SensorRepository sensorRepository;

    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public List<Sensor> getAllSensors() {
        return sensorRepository.getAllSensors();
    }

    public Sensor getSensorById(int id) {
        return sensorRepository.getSensor(id);
    }

    public void addSensor(Sensor sensor) {
        sensorRepository.addSensor(sensor);
    }

    public void removeSensor(int id) {
        sensorRepository.removeSensor(id);
    }

    public void modifySensor(int id, String name) {
        Sensor existing = getSensorById(id);
        existing.setName(name);
        sensorRepository.addSensor(existing);
    }
}
