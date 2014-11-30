package eu.telecomnancy.stateSensor;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;

public class CommandSensorUPDATE extends CommandSensor{

	public CommandSensorUPDATE(ISensor sensor) {
		super(sensor);
	}

	@Override
	public void execute(){
		try {
			sensor.update();
		} catch (SensorNotActivatedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void on() {
		sensor.on();
	}

	@Override
	public void off() {
		sensor.off();
	}

	@Override
	public boolean getStatus() {
		return sensor.getStatus();
	}

	@Override
	public void update() throws SensorNotActivatedException {
		sensor.update();
	}

	@Override
	public double getValue() throws SensorNotActivatedException {
		return sensor.getValue();
	}

}