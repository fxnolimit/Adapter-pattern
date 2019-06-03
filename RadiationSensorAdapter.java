
/*					Author : Francois Mukaba
 * 					Course : Software Engineering
 * 					Spring 2019
 */
import sensor.RadiationSensor;
import java.awt.Color;

public class RadiationSensorAdapter implements SensorAdapter {
	RadiationSensor r;

	public RadiationSensorAdapter() {
		r = new RadiationSensor();
	}

	@Override
	public String getReport() {
		return r.getStatusInfo();
	}

	@Override
	public double getValue() {
		return r.getRadiationValue();
	}

	@Override
	public String getType() {
		return r.getName();
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
