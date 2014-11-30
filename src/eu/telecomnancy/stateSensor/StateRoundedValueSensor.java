package eu.telecomnancy.stateSensor;

import java.text.DecimalFormat;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;

public class StateRoundedValueSensor extends SensorDecorator implements ISensor{

	int nbDecimals; 
	
	public StateRoundedValueSensor(ISensor sensor) {
		super(sensor);
		nbDecimals = 4;
	}

	@Override
	public double getValue() throws SensorNotActivatedException {
		DecimalFormat f = new DecimalFormat();
		f.setMaximumFractionDigits(nbDecimals);
		return Double.valueOf((f.format(sensor.getValue())).replaceAll(",", "\\."));
	}

	@Override
	public void on() {
		this.sensor.on();
	}

	@Override
	public void off() {
		this.sensor.off();
	}

	@Override
	public boolean getStatus() {
		return this.sensor.getStatus();
	}

	@Override
	public void update() throws SensorNotActivatedException {
		this.sensor.update();		
	}
}