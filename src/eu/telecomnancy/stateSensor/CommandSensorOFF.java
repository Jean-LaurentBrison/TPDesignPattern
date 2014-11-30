package eu.telecomnancy.stateSensor;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;

public class CommandSensorOFF extends CommandSensor{

	public CommandSensorOFF(ISensor sensor) {
		super(sensor);
	}

	@Override
	public void execute(){
		sensor.off();
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