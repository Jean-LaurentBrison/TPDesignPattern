package eu.telecomnancy.stateSensor;

import eu.telecomnancy.sensor.SensorNotActivatedException;

public class StateSensorOff implements State{

	public StateSensorOff() {
	}
	
	@Override
	public boolean getStatus() {
		return false;
	}

	@Override
	public void update() throws SensorNotActivatedException{
		throw new SensorNotActivatedException("Sensor must be activated before acquiring new values.");	
	}

	@Override
	public double getValue() throws SensorNotActivatedException{
		throw new SensorNotActivatedException("Sensor must be activated to get its value.");
	}

}