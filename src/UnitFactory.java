
public class UnitFactory {
	private static UnitFactory instance = null;

	protected UnitFactory() {
	}

	public static UnitFactory getInstance() {
		if (instance == null) {
			instance = new UnitFactory();
		}
		return instance;
	}

	public UnitType[] getUnitTypes() {
		return UnitType.values();
	}

	public Unit[] getUnits(UnitType utype) {
		if(utype == UnitType.Length) return Length.values();
		else if(utype == UnitType.Area) return Area.values();
		else if(utype == UnitType.Weight) return Weight.values(); 
		return null;
	}

}