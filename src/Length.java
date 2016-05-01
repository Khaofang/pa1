/**
 * Collecting all of length unit. Value is in form of meter unit.
 * @author Chayanin Punjakunaporn
 */
public enum Length implements Unit {

	/** Constant */
	METER("Meter", 1.0), 
	KILOMETER("Kilometer", 1000.0),
	CENTIMETER("Centimeter", 0.01),
	MILLIMETER("Millimeter", 0.001),
	MICROMETER("Micrometer", 1.0e-6),
	NANOMETER("Nanometer", 1.0e-9),
	MILE("Mile", 1609.344),
	YARD("Yard", 0.9144),
	FOOT("Foot", 0.3048),
	INCH("Inch", 0.0254),   
	MICRON("Micron", 1.0e-6), 
	WA("Wa", 2.0);

	/** Attribute */
	public final String name;
	public final double value;

	/** Constructor */
	Length(String name, double value) {
		this.name = name;
		this.value = value;
	}

	/**
	 * Get value of unit.
	 * @return value of length
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Get string of unit.
	 * @return name of length
	 */
	public String toString() {
		return String.format("%s", name);
	}
}