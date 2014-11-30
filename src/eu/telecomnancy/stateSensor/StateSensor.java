package eu.telecomnancy.stateSensor;

import java.util.Observable;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;
import eu.telecomnancy.stateSensor.StateSensor;
import eu.telecomnancy.stateSensor.StateSensorOn;

public class StateSensor extends Observable implements ISensor {
    State state = new StateSensorOff();
    
    @Override
    public void on() {
        this.state = new StateSensorOn();
        setChanged();
        notifyObservers();
    }

    @Override
    public void off() {
        this.state = new StateSensorOff();
        setChanged();
        notifyObservers();
    }

    @Override
    public boolean getStatus() {
        return this.state.getStatus();
    }

    @Override
    public void update() throws SensorNotActivatedException{
        this.state.update();
        setChanged();
        notifyObservers();
    }

    @Override
    public double getValue() throws SensorNotActivatedException {
        return this.state.getValue();
    }

}
