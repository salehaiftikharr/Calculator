
public class ExpoOperator extends Operator{

	public ExpoOperator() {
		super(100);
	}
	
	public double evaluate(double a, double b) {
		return Math.pow(a, b);
	}
}
