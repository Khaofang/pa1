/**
 * Collecting all of time unit. Value is in form of second unit.
 * @author Chayanin Punjakunaporn
 */
public enum Time implements Unit {
	
	SECOND("Second", 1.0),
	MINUTE("Minute", 60.0),
	HOUR("Hour", 3600.0),
	MILLISECOND("Millisecond", 0.001),
	NANOSECOND("Nanosecond", 1.0e-9),
	DAY("Day", HOUR.value*24.0),
	WEEK("Week", DAY.value*7.0),
	MONTH("Month", DAY.value*30.0),
	YEAR("Year", DAY.value*365.0),
	DECADE("Decade", YEAR.value*10.0),
	CENTURY("Century", YEAR.value*100.0);
	
	
	/** Attribute */
	public final String name;
	public final double value;

	/** Constructor */
	Time(String name, double value) {
		this.name = name;
		this.value = value;
	}

	/**
	 * @return value of time
	 */
	public double getValue() {
		return value;
	}

	/**
	 * @return name of time
	 */
	public String toString() {
		return String.format("%s", name);
	}
	

}
