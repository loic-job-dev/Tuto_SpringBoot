package fr.campus.loic.interfaces;

import fr.campus.loic.model.Sensor;
import fr.campus.loic.repository.SensorRepository;

import java.util.List;

public interface SensorDevice {

    public List<Sensor> getAllSensors();

    public Sensor getSensorById(int id);

    public void addSensor(Sensor sensor);

    public void removeSensor(int id);

    public void modifySensor(int id, Sensor sensor);
}
