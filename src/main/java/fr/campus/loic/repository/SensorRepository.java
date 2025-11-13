package fr.campus.loic.repository;

import fr.campus.loic.model.Sensor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class SensorRepository {

    private final HashMap<Integer, Sensor> sensors = new HashMap<>();

    public List<Sensor> getAllSensors() {
        return new ArrayList<>(sensors.values());
    }

    public Sensor getSensor(int id) {
        return sensors.get(id);
    }

    public void addSensor(Sensor sensor) {
        sensors.put(sensor.getID(), sensor);
    }

    public void removeSensor(int id) {
        sensors.remove(id);
    }
}
