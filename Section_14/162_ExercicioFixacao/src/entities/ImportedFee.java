package entities;

public class ImportedFee extends Product{

	private double customsFee;
	
	public ImportedFee() {
		super();
	}

	public ImportedFee(String name, double price, double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(double customsFee) {
		this.customsFee = customsFee;
	}
	
	@Override
	public String priceTag() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getName() + " ");
		sb.append("$ " + String.format("%.2f", totalPrice()));
		sb.append(" (Customs fee: $ " + String.format("%.2f", customsFee) + ")");
		return sb.toString();
	}
	
	public double totalPrice() {
		double sum = super.getPrice() + customsFee;
		return sum;
	}
}
