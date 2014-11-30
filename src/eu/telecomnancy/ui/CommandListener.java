package eu.telecomnancy.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.stateSensor.CommandFAHRENHEIT;
import eu.telecomnancy.stateSensor.CommandQUITTER;
import eu.telecomnancy.stateSensor.CommandROUNDED;
import eu.telecomnancy.stateSensor.CommandSensorOFF;
import eu.telecomnancy.stateSensor.CommandSensorON;
import eu.telecomnancy.stateSensor.CommandSensorUPDATE;

public class CommandListener implements ActionListener {

	ISensor sensor;
	String  classe;
	public CommandListener(ISensor sensor, String classe){
		this.sensor = sensor;
		this.classe = classe;
		System.out.println("commandeListener");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(classe){
		case "CommandQUITTER":
			new CommandQUITTER(sensor).execute();
			break;
		case "CommandFAHRENHEIT":
			new CommandFAHRENHEIT(sensor).execute();
			break;
		case "CommandROUNDED":
			new CommandROUNDED(sensor).execute();
			break;
		default:
			System.out.println("Erreur commande!!");
		}
	}

}