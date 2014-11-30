package eu.telecomnancy.sensor;

public class Farenheit extends DecoratorSensor {

	
	
	public Farenheit(ISensor sensor) {
		super(sensor);
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
		return sensor.getValue()*1.8 + 32;
	}

}
