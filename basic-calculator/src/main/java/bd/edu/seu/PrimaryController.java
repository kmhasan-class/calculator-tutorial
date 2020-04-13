package bd.edu.seu;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PrimaryController {
    @FXML
    private TextField displayField;

    private double number1;
    private double number2;
    private Operator operator;

    public PrimaryController() {
        displayField = new TextField();
    }

    @FXML
    private void handleDigitAction(ActionEvent actionEvent) {
        Button eventSource = (Button) actionEvent.getSource();
        String digit = eventSource.getText();
        String oldText = displayField.getText();
        if (oldText.startsWith("0"))
            oldText = "";
        // TODO Note to self: move the dot related stuff into another method
        if (!digit.equals(".") || (digit.equals(".") && !oldText.contains("."))) {
            String newText = oldText + digit;
            displayField.setText(newText);
        }
    }

    private Operator getOperator(String symbol) {
        for (Operator operator : Operator.values())
            if (operator.getSymbol().equals(symbol))
                return operator;
        return null;
    }

    @FXML
    private void handleOperatorAction(ActionEvent actionEvent) {
        // Step 1: Get the number typed into the displayField and copy it to somewhere
        String numberAsString = displayField.getText();
        number1 = Double.parseDouble(numberAsString);

        // Step 2: Remember which operator it is
        Button eventSource = (Button) actionEvent.getSource();
        String symbol = eventSource.getText();
        operator = getOperator(symbol);

        // Step 3: Clear the displayField so that we can read the next number
        displayField.clear();

    }

    @FXML
    private void handleEqualAction() {
        double result = 0;

        // Step 1: Get the number typed into the displayField and copy it to somewhere
        String numberAsString = displayField.getText();
        number2 = Double.parseDouble(numberAsString);

        // Step 2: Add the two numbers and store the result in a variable
        result = operator.operate(number1, number2);

        // Step 3: Display the result into the displayField
        displayField.setText("" + result);
    }
}
