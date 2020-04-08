package bd.edu.seu;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PrimaryController {
    @FXML
    private TextField displayField;

    public PrimaryController() {
        displayField = new TextField();
    }

    @FXML
    private void handleDigitOperation(ActionEvent actionEvent) {
        Button eventSource = (Button) actionEvent.getSource();
        String digit = eventSource.getText();
        String oldText = displayField.getText();
        String newText = oldText + digit;
        displayField.setText(newText);
    }

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
        System.out.println("+");
    }
}
