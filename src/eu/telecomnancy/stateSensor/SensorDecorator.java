package eu.telecomnancy.stateSensor;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;

public abstract class SensorDecorator implements ISensor{
		
	ISensor sensor;
	
	public SensorDecorator(ISensor sensor){
		this.sensor = sensor;
	}
	
	public abstract double getValue() throws SensorNotActivatedException;
}
