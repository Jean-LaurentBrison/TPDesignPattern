package eu.telecomnancy.sensor;

import java.text.DecimalFormat;

public class Arrondi extends DecoratorSensor {

	int nbchiffres;
	
	public Arrondi(ISensor sensor) {
		super(sensor);
		nbchiffres = 7;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void on() {
		// TODO Auto-generated method stub
		sensor.on();
	}

	@Override
	public void off() {
		// TODO Auto-generated method stub
		sensor.off();
	}

	@Override
	public boolean getStatus() {
		// TODO Auto-generated method stub
		return sensor.getStatus();
	}

	@Override
	public void update() throws SensorNotActivatedException {
		// TODO Auto-generated method stub
		sensor.update();
	}

	@Override
	public double getValue() throws SensorNotActivatedException {
		// TODO Auto-generated method stub
		DecimalFormat f = new DecimalFormat();
		f.setMaximumFractionDigits(nbchiffres);
		return Double.valueOf((f.format(sensor.getValue())).replaceAll(",", "\\."));
	}

}
