package entities;

public class PhysicalPerson extends TaxPayer{

	private double healthSpending;
	
	public PhysicalPerson() {
		super();
	}

	public PhysicalPerson(String name, double annualIncome, double healthSpending) {
		super(name, annualIncome);
		this.healthSpending = healthSpending;
	}

	public double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(double healthSpending) {
		this.healthSpending = healthSpending;
	}
	
	@Override
	public double tax() {
		if (getAnnualIncome() < 20000.00) {
			return (getAnnualIncome() * 0.15) - (healthSpending * 0.50);
		}
		else {
			return (getAnnualIncome() * 0.25) - (healthSpending * 0.50);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getName() + ": ");
		sb.append("$ " + String.format("%.2f", tax()));
		return sb.toString();
	}
}
