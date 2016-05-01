/**
 * Collecting all of area unit. Value is in form of square meter unit.
 * 
 * @author Chayanin Punjakunaporn
 *
 */
public enum Area implements Unit {

	/** Constant */
	SQUARE_METER("Square Meter", 1.0), 
	SQUARE_KILOMETER("Square Kilometer", 1.0e+6), 
	SQUARE_CENTIMETER("Square Centimeter", 0.0001), 
	SQUARE_MILLIMETER("Square Millimeter", 1.0e-6),
	SQUARE_MILE("Square Mile", 2.59e+6),
	SQUARE_YARD("Square Yard", 0.8361),
	SQUARE_FOOT("Square Foot", 0.0929),
	SQUARE_INCH("Square Inch", 6.4516e-4),
	HECTARE("Hectare", 10000),	
	SQUARE_WA("Square Wa", 4.0),
	NGAN("Ngan", 400.0),
	RAI("Rai", 1600.0);

	/** Attribute */
	public final String name;
	public final double value;

	/** Constructor */
	Area(String name, double value) {
		this.name = name;
		this.value = value;
	}

	/**
	 * Get value of unit.
	 * @return value of area
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Get string of unit.
	 * @return name of area
	 */
	public String toString() {
		return String.format("%s", name);
	}
}
