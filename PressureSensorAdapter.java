
/*					Author : Francois Mukaba
 * 					Course : Software Engineering
 * 					Spring 2019
 */
import sensor.PressureSensor;
import java.awt.Color;

public class PressureSensorAdapter implements SensorAdapter {
	private PressureSensor p;

	public PressureSensorAdapter() {
		p = new PressureSensor();
	}

	@Override
	public String getReport() {
		return p.getReport();
	}

	@Override
	public double getValue() {
		return p.readValue();
	}

	@Override
	public String getType() {
		return p.getSensorName();
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
