
public abstract class Operator {
	
	//data members
	private int precedence;
	
	//constructor
	public Operator(int precedence) {
		this.precedence = precedence;
	}
	
	//methods
	public int getPrecedence() {
		return precedence;
	}
	
	public abstract double evaluate(double a, double b);
}
