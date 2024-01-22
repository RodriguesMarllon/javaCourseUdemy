package entities;

public class LegalPerson extends TaxPayer{
	
	private int numberOfEmployees;
	
	public LegalPerson() {
		super();
	}

	public LegalPerson(String name, double annualIncome, int numberOfEmployees) {
		super(name, annualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}

	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}
	
	@Override
	public double tax() {
		if (numberOfEmployees > 10) {
			return getAnnualIncome() * 0.14;
		}
		else {
			return getAnnualIncome() * 0.16;
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
