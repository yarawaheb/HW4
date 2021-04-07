package shop;

public class Piano extends Instrument{
	private int octaves;
	private int serial;
	public Piano(String company, int price, int octaves) {
		super(company, price);
		this.octaves=octaves;
		this.serial=super.getSerial()-1;
	}
	
	public int getOctaves() {
		return octaves;
	}
	public int getSerial() {
		return serial;
	}
	
	@Override
	public String toString() {
		return "Piano("+getOctaves()+" octaves) "+super.toString();
	}
	}
