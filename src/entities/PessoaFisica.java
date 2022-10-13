package entities;

public class PessoaFisica extends Contribuinte {
	
	private double healthExpenditures;
	
	public PessoaFisica() {
	}

	public PessoaFisica(String name, Double anualIncome, double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}
	
	@Override
	public double tax() {
		double discountHealth = healthExpenditures * 0.50;
			if(getAnualIncome() > 20000.00) {
				return getAnualIncome() * 0.25 - discountHealth;
		}
			else {
				return getAnualIncome() * 0.15 - discountHealth;
			}
	}

}
