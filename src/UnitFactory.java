/**
 * Can make only one object for returning about units and unit types.
 * @author Chayanin Punjakunporn
 */
public class UnitFactory {
	/** Attribute */
	private static UnitFactory instance = null;

	/** Constructor */
	public UnitFactory() {
	}

	/** 
	 * Get single UnitFactory object.
	 * @return instance single object of UnitFactory
	 */
	public static UnitFactory getInstance() {
		if (instance == null) {
			instance = new UnitFactory();
		}
		return instance;
	}

	/**
	 * Get all unit types.
	 * @return all constant of UnitType
	 */
	public UnitType[] getUnitTypes() {
		return UnitType.values();
	}

	/**
	 * Get unit of UnitType utype 
	 * @param utype type of unit
	 * @return all units of type of utype
	 */
	public Unit[] getUnits(UnitType utype) {
		return utype.getUnits();
	}

}