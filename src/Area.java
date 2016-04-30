/**
 * Collecting all of area unit. Value is in form of square meter unit.
 * 
 * @author Chayanin Punjakunaporn
 *
 */
public enum Area implements Unit {

	/** Constant */
	SQUARE_METER("Sq. Meter", 1.0), 
	SQUARE_KILOMETER("Sq. Kilometer", 1.0e+6), 
	SQUARE_CENTIMETER("Sq. Centimeter", 0.0001), 
	SQUARE_MILLIMETER("Sq. Millimeter", 1.0e-6),
	SQUARE_MILE("Sq. Mile", 2.59e+6),
	SQUARE_YARD("Sq. Yard", 0.8361),
	SQUARE_FOOT("Sq. Foot", 0.0929),
	SQUARE_INCH("Sq. Inch", 6.4516e-4),
	HECTARE("Hectare", 10000),	
	SQUARE_WA("Sq. Wa", 4.0),
	RAI("Rai", 1600);

	/** Attribute */
	public final String name;
	public final double value;

	/** Constructor */
	Area(String name, double value) {
		this.name = name;
		this.value = value;
	}

	/**
	 * @return value of length
	 */
	public double getValue() {
		return value;
	}

	/**
	 * @return name of length
	 */
	public String toString() {
		return String.format("%s", name);
	}
}
