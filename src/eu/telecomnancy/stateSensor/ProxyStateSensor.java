package eu.telecomnancy.stateSensor;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;

public class ProxyStateSensor implements ISensor{
	ArrayList<String> journal;
	GregorianCalendar date = new GregorianCalendar();
	ISensor s;
	
	public ProxyStateSensor(ISensor s){
		this.s = s;
		this.journal = new ArrayList<String>();
	}

	@Override
	public void on() {
		String sortie = "Date : "+date.getTime()+"\nMéthode : on()\nValeur de retour : void";
		journal.add(sortie);
		s.on();
		System.out.println(journal.get(journal.size()-1));
	}

	@Override
	public void off() {
		String sortie = "Date : "+date.getTime()+"\nMéthode : off()\nValeur de retour : void";
		journal.add(sortie);
		s.off();
		System.out.println(journal.get(journal.size()-1));		
	}

	@Override
	public boolean getStatus() {
		String sortie = "Date : "+date.getTime()+"\nMéthode : getStatus()\nValeur de retour : "+s.getStatus();
		journal.add(sortie);
		return s.getStatus();
	}

	@Override
	public void update() throws SensorNotActivatedException {
		String sortie = "Date : "+date.getTime()+"\nMéthode : update()\nValeur de retour : void";
		journal.add(sortie);
	}

	@Override
	public double getValue() throws SensorNotActivatedException {
		double value = s.getValue();
		String sortie = "Date : "+date.getTime()+"\nMéthode : getValue()\nValeur de retour : "+value;
		journal.add(sortie);
		return value;
	}
	
	public void ecrire(String path) throws IOException{
		FileWriter writer = null;
		writer = new FileWriter(path, true);
		for (String s : journal) {
			writer.write(s, 0, s.length());
		}
		if(writer != null){
		     writer.close();
		}
	}
}