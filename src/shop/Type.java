package shop;

public enum Type {
	ACOUSTIC, ELECTRIC, CLASSICAL;
	
	@Override
	public String toString() {
		if (this == ACOUSTIC)
			return "Acoustic";
		if (this == ELECTRIC)
			return "Electric";
		else return "Classical";
	}
}
