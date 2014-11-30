package eu.telecomnancy.stateSensor;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;

public class StateFahrenheitSensor extends SensorDecorator implements ISensor{

	
	public StateFahrenheitSensor(ISensor sensor) {
		super(sensor);
	}

	@Override
	public double getValue() throws SensorNotActivatedException {
		return sensor.getValue()*1.8+32;
	}

	@Override
	public void on() {
		this.sensor.on();
	}

	@Override
	public void off() {
		this.sensor.off();
	}

	@Override
	public boolean getStatus() {
		return this.sensor.getStatus();
	}

	@Override
	public void update() throws SensorNotActivatedException {
		this.sensor.update();
	}

}