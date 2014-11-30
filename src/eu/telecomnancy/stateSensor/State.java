package eu.telecomnancy.stateSensor;

import eu.telecomnancy.sensor.SensorNotActivatedException;

public interface State {
	 /**
     * Get the status (enabled/disabled) of the sensor.
     *
     * @return the current sensor's status.
     */
    public boolean getStatus();

    /**
     * Tell the sensor to acquire a new value.
     *
     * @throws SensorNotActivatedException if the sensor is not activated.
     */
    public void update() throws SensorNotActivatedException;

    /**
     * Get the latest value recorded by the sensor.
     *
     * @return the last recorded value.
     * @throws SensorNotActivatedException if the sensor is not activated.
     */
    public double getValue() throws SensorNotActivatedException;

}