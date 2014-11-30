package eu.telecomnancy.sensor;

import java.util.Random;

public class SensorOn implements State{
	
	double value;
	
	public SensorOn() {
		// TODO Auto-generated constructor stub
		value = 3;
	}
	
	
	@Override
	public boolean getStatus() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void update() throws SensorNotActivatedException {
		// TODO Auto-generated method stub
		value = (new Random()).nextDouble() * 100;
    }

	@Override
	public double getValue() throws SensorNotActivatedException {
		// TODO Auto-generated method stub
		return value;
	}

}
