/**
 * Collecting all of unit types.
 * @author Chayanin Punjakunaporn
 */
public enum UnitType {
	
	/** Constant */
	LENGTH("Length", Length.values()),
	AREA("Area", Area.values()),
	WEIGHT("Weight", Weight.values()),
	VOLUME("Volume", Volume.values()),
	TIME("Time", Time.values());
	
	/** Attribute */
	private String type;
	private Unit[] unit;
	
	/** Constructor */
	UnitType(String type, Unit[] unit) {
		this.type = type;
		this.unit = unit;
	}
	
	/**
	 * Get type name of this unit type.
	 * @return type name of unit type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Get all of unit in that type.
	 * @return units in arrays.
	 */
	public Unit[] getUnits() {
		return unit;
	}
}
