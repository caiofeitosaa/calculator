package org.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController {
    @FXML
    private Button del;
    @FXML
    private Button plus;
    @FXML
    private Button minus;
    @FXML
    private Button multiply;
    @FXML
    private Button divide;
    @FXML
    private Label result;
    @FXML
    private Button clearButton;
    @FXML
    private Button percentage;
    @FXML
    private Button equal;
    @FXML
    private Button dot;
    @FXML
    private Button raised;
    @FXML
    private Button one;
    @FXML
    private Button two;
    @FXML
    private Button three;
    @FXML
    private Button four;
    @FXML
    private Button five;
    @FXML
    private Button six;
    @FXML
    private Button seven;
    @FXML
    private Button eight;
    @FXML
    private Button nine;
    @FXML
    private Button zero;

    public Label getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result.setText(result);
    }

    private String firstNumber;
    private String secondNumber;
    private String operation;

    @FXML
    public void eventOnNumberButtons(ActionEvent event) {
        Button sourceButton =  (Button) event.getSource();
        String number = sourceButton.getText();
        setResult(number);
        if (firstNumber == null && secondNumber == null) {
            firstNumber = number;
        } else if (secondNumber == null && firstNumber.equals(number)) {
            secondNumber = number;
        }
    }
    // AJEITAR ESSA FUNÇÃO AQUI
    @FXML
    public void eventOnOperationButtons(ActionEvent event) {
        Button sourceButton =  (Button) event.getSource();
        String operation = sourceButton.getText();
        if (operation.equals(plus.getText())) {
            double firstNumberDouble = Double.parseDouble(firstNumber);
            double secondNumberDouble = Double.parseDouble(secondNumber);
            double operationResult = firstNumberDouble + secondNumberDouble;
            String operationResultString = Double.toString(operationResult);
            setResult(operationResultString);
        }
    }
}