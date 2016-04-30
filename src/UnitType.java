
public enum UnitType {
	
	Length("Length"),
	Area("Area"),
	Weight("Weight");
	
	private String type;
	
	UnitType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
}
