package fr.campus.loic.service;

import fr.campus.loic.exceptions.SensorNotExists;
import fr.campus.loic.interfaces.SensorDevice;
import fr.campus.loic.model.Sensor;
import fr.campus.loic.repository.SensorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService implements SensorDevice {

    private final SensorRepository sensorRepository;

    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public List<Sensor> getAllSensors() throws SensorNotExists {
        if (sensorRepository.getAllSensors().isEmpty()) {
            throw new SensorNotExists("No sensors found");
        }
        return sensorRepository.getAllSensors();
    }

    public Sensor getSensorById(int id) throws SensorNotExists {
        if (sensorRepository.getSensor(id) == null){
            throw new SensorNotExists("Sensor with id " + id + " does not exist");
        }
        return sensorRepository.getSensor(id);
    }

    public void addSensor(Sensor sensor) {
        sensorRepository.addSensor(sensor);
    }

    public void removeSensor(int id) throws SensorNotExists {
        if (sensorRepository.getSensor(id) == null){
            throw new SensorNotExists("Sensor with id " + id + " does not exist");
        }
        sensorRepository.removeSensor(id);
    }

    public void modifySensor(int id, Sensor sensor) throws SensorNotExists {
        if (sensorRepository.getSensor(id) == null){
            throw new SensorNotExists("Sensor with id " + id + " does not exist");
        }
        Sensor existing = getSensorById(id);
        existing.setName(sensor.getName());
        sensorRepository.addSensor(existing);
    }
}
