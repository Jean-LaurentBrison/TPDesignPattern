package eu.telecomnancy.stateSensor;

import java.util.Random;

public class StateSensorOn implements State{
	
	double value;
	
	public StateSensorOn() {
		this.value = 12;
	}
	@Override
	public boolean getStatus() {
		return true;
	}

	@Override
	public void update() {
		value = (new Random()).nextDouble() * 100;		
	}

	@Override
	public double getValue(){
		return value;
	}
	
}