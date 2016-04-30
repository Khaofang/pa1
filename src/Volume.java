/**
 * Collecting all of volume unit. Value is in form of cubic meter unit.
 * @author Chayanin Punjakunaporn
 */
public enum Volume implements Unit {

	/** Constant */
	CUBIC_METER("Cubic Meter", 1.0),
	CUBIC_CENTIMETER("Cubic Centimeter", 1.0e-6),
	LITRE("Litre", 0.001),
	MILLILITRE("Millilitre", 1.0e-6),
	CUBIC_FOOT("Cubic Foot", 0.02832),
	CUBIC_INCH("Cubic Inch", 1.6387e-5);

	/** Attribute */
	public final String name;
	public final double value;

	/** Constructor */
	Volume(String name, double value) {
		this.name = name;
		this.value = value;
	}

	/**
	 * @return value of volume
	 */
	public double getValue() {
		return value;
	}

	/**
	 * @return name of volume
	 */
	public String toString() {
		return String.format("%s", name);
	}
}
