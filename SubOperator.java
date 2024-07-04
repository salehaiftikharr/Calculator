
public class SubOperator extends Operator{

	public SubOperator() {
		super(60);
	}

	@Override
	public double evaluate(double a, double b) {
		return a - b;
	}

}
