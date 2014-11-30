package eu.telecomnancy.stateSensor;

import eu.telecomnancy.sensor.ISensor;

public abstract class CommandSensor implements ISensor{
	
	protected ISensor sensor;
	
	public CommandSensor(ISensor sensor){
		this.sensor = sensor;
	}
	
	public abstract void execute();
}