package shop;

public class Guitar extends Instrument {
	private Type type;
	private int serial;

	public Guitar(String company, int price,Type type) {
		super(company, price);
		this.type=type;
		this.serial=super.getSerial()-1;
	}
	public Type getType() {
		return type;
	}
	public int getSerial() {
		return serial;
	}
	
	@Override
	public String toString() {
		return "Guitar("+getType().toString()+") "+super.toString();
	}

}
