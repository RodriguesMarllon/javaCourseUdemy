package entities;

public class OutsourceEmployee extends Employee{
	
	private double additionalCharge;

	public OutsourceEmployee() {
		super();
	}
	
	public OutsourceEmployee(String name, Integer hours, Double valuePerHour, double additionalCharge) {
		super(name, hours, valuePerHour);
		this.additionalCharge = additionalCharge;
	}

	public double getAdditionlaCharge() {
		return additionalCharge;
	}

	public void setAdditionlaCharge(double additionlaCharge) {
		this.additionalCharge = additionlaCharge;
	}
	
	@Override
	public double payment() {
		return super.payment() + additionalCharge * 1.1;
	}
}
