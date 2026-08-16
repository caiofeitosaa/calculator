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
    private String currentNumber = "";

    // OK
    @FXML
    public void eventOnNumberButtons(ActionEvent event) {
        Button sourceButton =  (Button) event.getSource();
        currentNumber += sourceButton.getText();
        setResult(currentNumber);
    }

    // OK
    @FXML
    public void eventOnOperationButtons(ActionEvent event) {
        Button sourceButton =  (Button) event.getSource();
        operation = sourceButton.getText();
        if (operation != null) {
            firstNumber = currentNumber;
            currentNumber = "";
        }
    }

    // OK
    @FXML
    public void eventOnEqualButton(ActionEvent event) {
        secondNumber = currentNumber;
        if (operation.equals("+")){
            double sum = Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber);
            String sumString = Double.toString(sum);
            setResult(sumString);
            currentNumber = getResult().getText();
        } else if (operation.equals("-")){
            double minus = Double.parseDouble(firstNumber) - Double.parseDouble(secondNumber);
            String minusString = Double.toString(minus);
            setResult(minusString);
            currentNumber = getResult().getText();
        } else if (operation.equals("x")){
            double multiply = Double.parseDouble(firstNumber) * Double.parseDouble(secondNumber);
            String multiplyString = Double.toString(multiply);
            setResult(multiplyString);
            currentNumber = getResult().getText();
        } else if (operation.equals("÷")){
            double divide = Double.parseDouble(firstNumber) / Double.parseDouble(secondNumber);
            String divideString = Double.toString(divide);
            setResult(divideString);
            currentNumber = getResult().getText();
        }
        operation = "";
    }
    // OK
    @FXML
    public void eventOnACButton(ActionEvent event) {
        setResult("0");
        currentNumber = "";
        firstNumber = "";
        secondNumber = "";
        operation = "";
    }

    // OK
    @FXML
    public void eventOnDelButton(ActionEvent event) {
        Button sourceButton =  (Button) event.getSource();
        String delButton =  sourceButton.getText();
        if (delButton.equals("Del")){
            currentNumber = currentNumber.substring(0, currentNumber.length()-1);
            setResult(currentNumber);
            if (currentNumber.isEmpty()){
                setResult("0");
            }
        }
    }

    // TEM QUE FAZER OS BOTÕES ELEVADO, PORCENTAGEM E VIRGULA
    // TRATAR NÚMEROS NEGATIVOS TAMBÉM
}