package eu.telecomnancy.sensor;

public abstract class DecoratorSensor implements ISensor{
	
	ISensor sensor;
	
	public DecoratorSensor(ISensor sensor){
		this.sensor = sensor;	
	}
	
	public abstract double getValue() throws SensorNotActivatedException;
	
}


