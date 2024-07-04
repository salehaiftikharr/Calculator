import java.util.Stack;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Calculator extends Application 
{
	// the calculator dimensions
	public static int CALC_WIDTH = 400;
	public static int CALC_HEIGHT = 300;

	// the calculator screen
	private TextField screen; 

	// stacks
	private Stack<Double> operandStack;
	private Stack<Operator> operatorStack;

	// instance variable
	Button[] buttons;

	// Multi-digit data member
	String multiDigits = "";

	@Override
	public void start(Stage primaryStage) 
	{
		// create the calculator screen
		screen = new TextField(); 
		operandStack = new Stack<Double>();
		operatorStack = new Stack<Operator>();

		String[] buttonLabels = {"1", "2", "3", "+", "-", "4", "5", "6", "*", "/", "7", "8", "9", "(", ")","0",".","=","^" ,"C", };
		buttons = new Button[buttonLabels.length];

		for(int i = 0 ; i < buttonLabels.length ; i++) {
			buttons[i] = new Button(buttonLabels[i]);
			buttons[i].setPrefWidth(80);
			buttons[i].setPrefHeight(75);
			ButtonHandler handler = new ButtonHandler();       
			buttons[i].setOnAction(handler);
		}

		// setup a grid panel for the keypad
		GridPane keypad = new GridPane();  
		keypad.setMinSize(CALC_WIDTH, CALC_HEIGHT); 
		keypad.setPadding(new Insets(10, 10, 10, 10));  
		keypad.setVgap(5); 
		keypad.setHgap(5);       
		keypad.setAlignment(Pos.CENTER); 

		// adding to the gridPane
		int index = 0;
		for(int i = 0; i <= 3; i++ ) {
			for(int j = 0; j <= 4; j++) {
				keypad.add(buttons[index], j, i);
				index++;
			}
		}

		// put screen and keypad together
		BorderPane gui = new BorderPane();
		gui.setTop(screen);
		gui.setCenter(keypad);

		// set up the scene
		Scene scene = new Scene(gui); 
		primaryStage.setTitle("Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	// Handler for processing the button clicks 
	private class ButtonHandler implements EventHandler<ActionEvent>
	{ 
		@Override 
		public void handle(ActionEvent e) 
		{	    		   
			// Numbers
			if (e.getSource() == buttons[0]) {

				String buttonText = buttons[0].getText(); 
				multiDigits += buttonText;
				screen.appendText(buttonText);
			}
			else if (e.getSource() == buttons[1]) {

				String buttonText = buttons[1].getText(); 
				multiDigits += buttonText;
				screen.appendText(buttonText);
			}
			else if (e.getSource() == buttons[2]) {

				String buttonText = buttons[2].getText(); 
				multiDigits += buttonText;
				screen.appendText(buttonText);
			}

			else if (e.getSource() == buttons[5]) {

				String buttonText = buttons[5].getText(); 
				multiDigits += buttonText;
				screen.appendText(buttonText);
			}
			else if (e.getSource() == buttons[6]) {

				String buttonText = buttons[6].getText(); 
				multiDigits += buttonText;
				screen.appendText(buttonText);
			}
			else if (e.getSource() == buttons[7]) {

				String buttonText = buttons[7].getText(); 
				multiDigits += buttonText;
				screen.appendText(buttonText);
			}

			else if (e.getSource() == buttons[10]) {

				String buttonText = buttons[10].getText(); 
				multiDigits += buttonText;
				screen.appendText(buttonText);
			}
			else if (e.getSource() == buttons[11]) {

				String buttonText = buttons[11].getText(); 
				multiDigits += buttonText;
				screen.appendText(buttonText);
			}
			else if (e.getSource() == buttons[12]) {

				String buttonText = buttons[12].getText(); 
				multiDigits += buttonText;
				screen.appendText(buttonText);
			}

			else if (e.getSource() == buttons[15]) {

				String buttonText = buttons[15].getText(); 
				multiDigits += buttonText;
				screen.appendText(buttonText);
			}
			
			else if(e.getSource() == buttons[16]) {
				
				String buttonText = buttons[16].getText();
				multiDigits += buttonText;
				screen.appendText(buttonText);
			}

			// Operators
			// add
			else if (e.getSource() == buttons[3]) {

				String buttonText = buttons[3].getText(); 
				Operator add = new AddOperator();
				evaluate(add); 
				screen.appendText(buttonText);
			}

			// subtract
			else if(e.getSource() == buttons[4]) {
				
				String buttonText = buttons[4].getText(); 
				Operator subtract = new SubOperator();
				evaluate(subtract); 
				screen.appendText(buttonText);
			}

			// multiply
			else if (e.getSource() == buttons[8]) {

				String buttonText = buttons[8].getText(); 
				Operator multiply = new MultiplyOperator();
				evaluate(multiply); 
				screen.appendText(buttonText);
			}

			// divide
			else if (e.getSource() == buttons[9]) {

				String buttonText = buttons[9].getText(); 
				Operator divide = new DivideOperator();
				evaluate(divide); 
				screen.appendText(buttonText);
			}

			// Open Parentheses (
			else if (e.getSource() == buttons[13]) {
				
				String buttonText = buttons[13].getText(); 
				screen.appendText(buttonText);
				Operator openParen = new OpenParen();
				operatorStack.push(openParen);

			}

			// Close Parentheses )   
			else if(e.getSource() == buttons[14]) {
				
				String buttonText = buttons[14].getText();         	   
				Operator closeParen = new CloseParen();
				evaluate(closeParen); 
				operatorStack.pop();
				operatorStack.pop();
				screen.appendText(buttonText);        	   
			}

			// exponentiate
			else if(e.getSource() == buttons[18]) {
				
				String buttonText = buttons[18].getText();
				Operator expo = new ExpoOperator();
				evaluate(expo);  
				screen.appendText(buttonText);
			}

			// equals
			else if(e.getSource() == buttons[17]) {
				
				String buttonText = buttons[17].getText();
				screen.appendText(buttonText);
				Operator equals = new EqualsOperator();
				evaluate(equals); 
				String finAnswer = operandStack.pop().toString();
				screen.appendText(finAnswer); 
			}

			// Clear - C
			else if(e.getSource() == buttons[19]) {
				
				operandStack.clear();
				operatorStack.clear();
				screen.clear();
			}
		} 
	}  

	// algorithm for operator
	public void evaluate(Operator currOp) {
		
		operandStack.push(Double.parseDouble(multiDigits));
		multiDigits = "";
		
		while(!operatorStack.isEmpty() && operatorStack.peek().getPrecedence() >= currOp.getPrecedence()) {
			
			Operator top = operatorStack.pop();
			Double secondNumber = operandStack.pop();
			Double firstNumber = operandStack.pop();
			Double eval = top.evaluate(firstNumber, secondNumber);
			operandStack.push(eval);	
		}
		operatorStack.push(currOp);
	}

	public static void main(String[] args) 
	{
		launch(args);
	}
}