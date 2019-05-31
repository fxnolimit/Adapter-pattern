
/*					Author : Francois Mukaba
 * 					Course : Software Engineering
 * 					Spring 2019
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.ArrayList;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicProgressBarUI;
import javafx.scene.control.ProgressBar;
import sensor.PressureSensor;

public class SensorApplication extends JFrame {

	public class BarUI extends BasicProgressBarUI {
		Rectangle rect = new Rectangle();
	}

	public SensorApplication() {
		setTitle("Sensor Tracker");
		setLayout(new GridLayout(3, 1));
		// create a panel for each sensor
		JPanel temperaturePnl = new JPanel();
		temperaturePnl.setBorder(new TitledBorder("Temperature"));
		add(temperaturePnl);

		JPanel radiationPnl = new JPanel();
		radiationPnl.setBorder(new TitledBorder("Radiation"));
		add(radiationPnl);

		JPanel pressurePnl = new JPanel();
		pressurePnl.setBorder(new TitledBorder("Pressure"));
		add(pressurePnl);

		setPreferredSize(new Dimension(600, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();

		SensorAdapter[] sensors = { new TemperatureSensorAdapter(), new PressureSensorAdapter(),
				new RadiationSensorAdapter() };

		for (SensorAdapter sensor : sensors) {
			int value = (int) sensor.getValue();

			JProgressBar pbar = new JProgressBar(0, 100);
			pbar.setUI(new BarUI());
			pbar.setPreferredSize(new Dimension(400, 50));
			pbar.setValue(value);
			pbar.setForeground(sensor.getColor());
			pbar.setOpaque(true);

			JLabel show = new JLabel(sensor.getReport() + ":" + value);

			// add the bar to appropriate panel
			if (sensor.getType().equals("Temperature Sensor")) {
				temperaturePnl.add(pbar);
				temperaturePnl.add(show);

			} else if (sensor.getType().equals("Pressure Sensor")) {
				pressurePnl.add(pbar);
				pressurePnl.add(show);
			} else {
				radiationPnl.add(pbar);
				radiationPnl.add(show);
			}
		}
	}

	public static void main(String[] args) {
		SensorApplication app = new SensorApplication();
	}
}