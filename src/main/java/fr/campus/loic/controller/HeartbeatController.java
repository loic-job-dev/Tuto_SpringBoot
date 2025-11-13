package fr.campus.loic.controller;

import fr.campus.loic.exceptions.SensorNotExists;
import fr.campus.loic.interfaces.HeartbeatSensor;
import fr.campus.loic.interfaces.SensorDevice;
import fr.campus.loic.model.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.noContent;

@RestController
public class HeartbeatController {

    @Autowired
    private HeartbeatSensor heartbeatSensor;

    @Autowired
    private SensorDevice sensorService;

    @GetMapping("/heartbeat")
    public int getHeartbeat(){
        return heartbeatSensor.getHeartbeat();
    }

    //Practising other methods
    @GetMapping("/sensors")
    public ResponseEntity<List<Sensor>> getSensors(){
        try {
            sensorService.getAllSensors();
            return new ResponseEntity<>(sensorService.getAllSensors(), HttpStatus.OK);
        } catch (SensorNotExists e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/sensors/{id}")
    public ResponseEntity<Sensor> getSensor(@PathVariable int id){
        try {
            sensorService.getSensorById(id);
        } catch (SensorNotExists e) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(sensorService.getSensorById(id), HttpStatus.OK);
    }

    @PostMapping("/sensors")
    public ResponseEntity<Sensor> addSensor(@RequestBody Sensor sensor){
        sensorService.addSensor(sensor);
        return new ResponseEntity<>(sensor, HttpStatus.CREATED);
    }

    @DeleteMapping("/sensors/{id}")
    public ResponseEntity<Void> deleteSensor(@PathVariable int id){
        try {
            sensorService.removeSensor(id);
            return ResponseEntity.noContent().build();
        } catch (SensorNotExists e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/sensors/{id}")
    public ResponseEntity<Sensor> updateSensor(@RequestBody Sensor sensor, @PathVariable int id){
        try {
            sensorService.modifySensor(id, sensor);
            return new ResponseEntity<>(sensorService.getSensorById(id), HttpStatus.OK);
        } catch (SensorNotExists e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
