package eu.telecomnancy.sensor;

public interface State {
	
	    
	    public boolean getStatus();
	    
	    public void update() throws SensorNotActivatedException;

	    public double getValue() throws SensorNotActivatedException;

}
