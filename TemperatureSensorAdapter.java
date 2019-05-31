
/*					Author : Francois Mukaba
 * 					Course : Software Engineering
 * 					Spring 2019
 */
import sensor.TemperatureSensor;
import java.awt.Color;

public class TemperatureSensorAdapter implements SensorAdapter {
	TemperatureSensor t;

	public TemperatureSensorAdapter() {
		t = new TemperatureSensor();
	}

	@Override
	public String getReport() {
		return t.getTempReport();
	}

	@Override
	public double getValue() {
		return t.senseTemperature();
	}

	@Override
	public String getType() {
		return t.getSensorType();
	}

	@Override
	public Color getColor() {
		String str = this.getReport();

		if (str.equals("OK")) {
			return Color.GREEN;
		} else if (str.equals("CRITICAL")) {
			return Color.YELLOW;
		} else {
			return Color.RED;
		}
	}
}
