package power.calculatepower;

public class CalculatePower {
	int number;
	int exponant;
	
	public CalculatePower() {	}
	
	public CalculatePower(int num, int exp) {
		number = num;
		exponant = exp;
	}
	
	public void printPowerOfNumber() {
		System.out.println(number + " raise to the Power " + exponant + " = " +      Math.pow(number, exponant));
	}
	

}
