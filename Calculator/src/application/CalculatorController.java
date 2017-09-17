package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class CalculatorController implements Initializable
{
	// This class handles UI to Model interaction only. All available methods feed UI input to Expression.class
	@FXML
	private TextArea textArea;
	@FXML
	private Label lastResultDisplay;
	@FXML
	private Button equals;
	
	private Expression expression = new Expression();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		textArea.setFocusTraversable(true);
		textArea.requestFocus();
	}
	public void reset() //Resets calculator values;
	{
		Calculator.reset();
		textArea.clear();
		lastResultDisplay.setText("");
	}
	
	public void numberInput(Event event) //Handles all the input to the Calculator UI except the equals button.
	{
		if(event.getSource() instanceof Button) {
			Button button = (Button)event.getSource();
			textArea.appendText(button.getText());
			System.out.println("this ran");
			return;
		}else if(event.getEventType().equals(KeyEvent.KEY_TYPED)){
			KeyEvent key = (KeyEvent) event;
			key.consume();
			System.out.println("does this run?");
			if(expression.isNumeric(key.getCharacter())||expression.isOperator(key.getCharacter())) {
				textArea.appendText(key.getCharacter());
				return;
			}
		}else if(event.getEventType().equals(KeyEvent.KEY_PRESSED)) {
			KeyEvent key = (KeyEvent) event;
			System.out.println("wut?");
			if(key.getCode() == KeyCode.ENTER) {
				key.consume();
				displayResults();
				return;
			}
		}
	}

	public void displayResults() // Handles the equals button functionality
	{
		lastResultDisplay.setText(expression.getLastResult());
		expression.parse(textArea.getText());
		textArea.setText(expression.getCurrentResult());
	}


}
