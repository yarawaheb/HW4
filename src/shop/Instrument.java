package shop;

public abstract class Instrument {
	private String company;
	private int price;
	private static int serial=0;
	
	public Instrument(String company, int price) {
		super();
		this.company = company;
		this.price = price;
		this.serial ++;
	}

	public String getCompany() {
		return company;
	}

	public int getPrice() {
		return price;
	}
	public int getSerial() {
		return serial;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	

	@Override
	public String toString() {
		return getCompany()+"("+getSerial()+"), price = "+getPrice();
	}

	
}
