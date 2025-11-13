package fr.campus.loic.exceptions;

public class SensorNotExists extends RuntimeException {
    public SensorNotExists(String message) {
        super(message);
    }
}
