/**
 * Collecting all of weight unit.
 * Value is in form of kilogram unit.
 * @author Chayanin Punjakunaporn
 *
 */
public enum Weight implements Unit {
	
	/** Constant */
	KILOGRAM("Kilogram", 1.0),
	GRAM("Gram", 0.001),
	MILLIGRAM("Milligram", 1.0e-6),
	MICROGRAM("Microgram", 1.0e-9),
	TONNE("Tonne", 1000),
	POUND("Pound", 0.4536),
	OUNCE("Ounce", 0.028349),
	KEED("Keed", 0.1);
	
	/** Attribute */
	public final String name;
	public final double value;
	
	/** Constructor */
	Weight(String name, double value){
		this.name = name;
		this.value = value;
	}
	
	/**
	 * @return value of weight
	 */
	public double getValue(){
		return value;
	}
	
	/**
	 * @return name of weight
	 */
	public String toString(){
		return String.format("%s", name);
	}
}
