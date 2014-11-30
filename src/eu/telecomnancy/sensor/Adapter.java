package eu.telecomnancy.sensor;

public class Adapter implements ISensor {

	
	LegacyTemperatureSensor legacy;
	
public Adapter(LegacyTemperatureSensor legacyTemperatureSensor){
	this.legacy = new LegacyTemperatureSensor();
	}
	
	
	@Override
	public void on() {
		// TODO Auto-generated method stub
		if (legacy.getStatus() == false) {
			legacy.onOff(); 
		}
	}

	@Override
	public void off() {
		// TODO Auto-generated method stub
		if (legacy.getStatus() == true) {
			legacy.onOff();
		}
	}

	@Override
	public boolean getStatus() {
		// TODO Auto-generated method stub
		return legacy.getStatus();
	}

	@Override
	public void update() throws SensorNotActivatedException {
		// TODO Auto-generated method stub
		 legacy.getTemperature();
	}

	@Override
	public double getValue() throws SensorNotActivatedException {
		// TODO Auto-generated method stub
		return legacy.getTemperature();
	}

}
