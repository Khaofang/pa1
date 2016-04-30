/**
 * Collecting all of unit types.
 * @author Chayanin Punjakunaporn
 */
public enum UnitType {
	
	/** Constant */
	Length("Length"),
	Area("Area"),
	Weight("Weight"),
	Volume("Volume");
	
	/** Attribute */
	private String type;
	
	/** Constructor */
	UnitType(String type) {
		this.type = type;
	}
	
	/**
	 * Get type name of this unit type.
	 * @return type name of unit type
	 */
	public String getType() {
		return type;
	}
}
