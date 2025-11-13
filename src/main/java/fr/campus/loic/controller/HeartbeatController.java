package fr.campus.loic.controller;

import fr.campus.loic.interfaces.HeartbeatSensor;
import fr.campus.loic.model.Sensor;
import fr.campus.loic.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HeartbeatController {

    @Autowired
    private HeartbeatSensor heartbeatSensor;

    @Autowired
    private SensorService sensorService;

    @GetMapping("/heartbeat")
    public int getHeartbeat(){
        return heartbeatSensor.getHeartbeat();
    }

    //Practising other methods
    @GetMapping("/sensors")
    public List<Sensor> getSensors(){
        return sensorService.getAllSensors();
    }

    @GetMapping("/sensors/{id}")
    public Sensor getSensor(@PathVariable int id){
        return sensorService.getSensorById(id);
    }

    @PostMapping("/sensors")
    public void addSensor(@RequestBody Sensor sensor){
        sensorService.addSensor(sensor);
    }

    @DeleteMapping("/sensors/{id}")
    public void deleteSensor(@PathVariable int id){
        sensorService.removeSensor(id);
    }

    @PutMapping("/sensors/{id}")
    public void updateSensor(@RequestBody String name, @PathVariable int id){
        sensorService.modifySensor(id, name);
    }
}
