package eu.telecomnancy.stateSensor;

import java.util.Observable;


import eu.telecomnancy.sensor.Adapter;
import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.LegacyTemperatureSensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;
import eu.telecomnancy.sensor.TemperatureSensor;

public class FactorySensor extends Observable implements ISensor{

	String type;
	ISensor sensor;
	
	public FactorySensor(String type) {
		this.type = type;
		
		switch (type) {
		case "StateSensor":
			sensor = new StateSensor();
			break;
		case "StateDecoratorSensor":
			sensor = new StateDecoratorSensor();
			break;
		case "ProxyStateSensor":
			sensor = new ProxyStateSensor(new TemperatureSensor());
			break;
		case "LegacyTemperatureSensor":
			sensor = new Adapter(new LegacyTemperatureSensor());
		}
	}

	@Override
	public void on() {
		sensor.on();
	}

	@Override
	public void off() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getStatus() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update() throws SensorNotActivatedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getValue() throws SensorNotActivatedException {
		// TODO Auto-generated method stub
		return 0;
	}
}