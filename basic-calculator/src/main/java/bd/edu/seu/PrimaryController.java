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
    private String operation;

    public PrimaryController() {
        displayField = new TextField();
    }

    @FXML
    private void handleDigitOperation(ActionEvent actionEvent) {
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

//    @FXML
//    private void handleDotOperation(ActionEvent actionEvent) {
//        Button eventSource = (Button) actionEvent.getSource();
//        String digit = eventSource.getText();
//        String oldText = displayField.getText();
//        if (oldText.startsWith("0"))
//            oldText = "";
//        String newText = oldText + digit;
//        displayField.setText(newText);
//    }

    @FXML
    private void handleZeroOperation() {
        String oldText = displayField.getText();
        if (!oldText.startsWith("0")) {
            String newText = oldText + "0";
            displayField.setText(newText);
        }
    }

    @FXML
    private void handleAdditionOperation() {
        // Step 1: Get the number typed into the displayField and copy it to somewhere
        String numberAsString = displayField.getText();
        number1 = Double.parseDouble(numberAsString);

        // Step 2: Remember that it is an addition operation
        operation = "ADDITION";

        // Step 3: Clear the displayField so that we can read the next number
        displayField.clear();
    }

    @FXML
    private void handleSubtractionOperation() {
        // Step 1: Get the number typed into the displayField and copy it to somewhere
        String numberAsString = displayField.getText();
        number1 = Double.parseDouble(numberAsString);

        // Step 2: Remember that it is an addition operation
        operation = "SUBTRACTION";

        // Step 3: Clear the displayField so that we can read the next number
        displayField.clear();
    }

    @FXML
    private void handleDivisionOperation() {
        // Step 1: Get the number typed into the displayField and copy it to somewhere
        String numberAsString = displayField.getText();
        number1 = Double.parseDouble(numberAsString);

        // Step 2: Remember that it is an addition operation
        operation = "DIVISION";

        // Step 3: Clear the displayField so that we can read the next number
        displayField.clear();
    }

    @FXML
    private void handleEqualOperation() {
        double result = 0;

        // Step 1: Get the number typed into the displayField and copy it to somewhere
        String numberAsString = displayField.getText();
        number2 = Double.parseDouble(numberAsString);

        // Step 2: Add the two numbers and store the result in a variable
        switch (operation) {
            case "ADDITION":
                result = number1 + number2;
                break;

            case "SUBTRACTION":
                result = number1 - number2;
                break;

            case "DIVISION":
                result = number1 / number2;
                break;

            default:
                break;
        }

        // Step 3: Display the result into the displayField
        displayField.setText("" + result);
    }
}
