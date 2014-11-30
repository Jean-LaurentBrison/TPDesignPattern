package eu.telecomnancy.sensor;

import java.util.Observable;


public class SensorState extends Observable implements ISensor{

	State state = new SensorOff();
	
	@Override
	public void on() {
		// TODO Auto-generated method stub
		state = new SensorOn();
		setChanged(); notifyObservers();
	}

	@Override
	public void off() {
		// TODO Auto-generated method stub
		state = new SensorOff();
		setChanged(); notifyObservers();
	}

	@Override
	public boolean getStatus() {
		// TODO Auto-generated method stub
		return state.getStatus();
	}

	@Override
	public void update() throws SensorNotActivatedException {
		// TODO Auto-generated method stub
		state.update();
		setChanged(); notifyObservers();
	}

	@Override
	public double getValue() throws SensorNotActivatedException {
		// TODO Auto-generated method stub
		return state.getValue();
	}

}
