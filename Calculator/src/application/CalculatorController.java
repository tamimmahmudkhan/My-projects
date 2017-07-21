package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class CalculatorController 
{
	@FXML
	private TextArea textArea;
	@FXML
	private Label lastResult;
	
	private String result;
	
	private String[] operatorArray = {"+","-","x","/"};
	//private List<String> operatorList = Arrays.asList("+","-","x","/");
	
	public void numberInput(ActionEvent event)
	{
		Button button = (Button)event.getSource();
		textArea.appendText(button.getText());
	}
	
	public void reset()
	{
		Calculator.reset();
		textArea.clear();
		lastResult.setText("");
	}
	
	public void displayResults()
	{
		if(result!="") {
			lastResult.setText(result);
		}
		calculateExpression();
		textArea.setText(Double.toString(Calculator.getResult()));
	}
	
	public void calculateExpression()
	{
		String expression = textArea.getText();
		for(String op : operatorArray) {
		if(expression.contains(op)) {
			int position = expression.indexOf(op);
			double num1 = Double.parseDouble(expression.substring(0, position));
			double num2 = Double.parseDouble(expression.substring(position+1));
			Calculator.setNum(num1, num2);
			switch(op)
			{
			case "+":
				Calculator.add();
				break;
			case "-":
				Calculator.subtract();
				break;
			case "x":
				Calculator.multiply();
				break;
			case "/":
				Calculator.divide();
				break;
			}
			result = "" + expression + " = " + Calculator.getResult();
		}
		}
	}
}
