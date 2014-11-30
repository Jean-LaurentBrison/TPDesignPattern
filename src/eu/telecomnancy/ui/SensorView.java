package eu.telecomnancy.ui;

import eu.telecomnancy.sensor.Arrondi;
import eu.telecomnancy.sensor.Farenheit;
import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.SensorState;
import eu.telecomnancy.sensor.SensorNotActivatedException;
import eu.telecomnancy.sensor.TemperatureSensor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class SensorView extends JPanel implements Observer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ISensor sensor;

	private JLabel value = new JLabel("N/A °C");
	private JButton on = new JButton("On");
	private JButton off = new JButton("Off");
	private JButton update = new JButton("Acquire");
	JMenuBar menu = new JMenuBar();

	
	public SensorView(ISensor c) {
		this.sensor = c;
		this.setLayout(new BorderLayout());
		value.setHorizontalAlignment(SwingConstants.CENTER);
		Font sensorValueFont = new Font("Sans Serif", Font.BOLD, 18);
		value.setFont(sensorValueFont);
		JMenu options;
		JMenuItem arrondi, farenheit;
		
		
		this.add(value, BorderLayout.CENTER);
		((SensorState) sensor).addObserver(this);


		arrondi= new JMenuItem ("Arrondi");
		farenheit = new JMenuItem ("Farenheit");
		options = new JMenu ("Options");
		options.add(arrondi);
		options.add(farenheit);
		menu.add(options);
		
		on.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sensor.on();
			}
		});

		off.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sensor.off();
			}
		});

		arrondi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sensor = new Arrondi(sensor);
			}
		});

		farenheit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sensor = new Farenheit(sensor);
			}
		});

		update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					sensor.update();
				} catch (SensorNotActivatedException sensorNotActivatedException) {
					sensorNotActivatedException.printStackTrace();
				}
			}
		});

		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(1, 3));
		buttonsPanel.add(update);
		buttonsPanel.add(on);
		buttonsPanel.add(off);

		this.add(buttonsPanel, BorderLayout.SOUTH);
		this.add(menu, BorderLayout.NORTH);
	}



@Override
public void update(Observable arg0, Object arg1) {
	// TODO Auto-generated method stub
	try {
		value.setText(String.valueOf(sensor.getValue()));
	} catch (SensorNotActivatedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
