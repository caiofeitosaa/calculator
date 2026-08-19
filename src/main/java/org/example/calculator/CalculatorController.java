package org.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Locale;

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
            String multiplyString = String.format(Locale.US,"%.1f", multiply);
            setResult(multiplyString);
            currentNumber = getResult().getText();
        } else if (operation.equals("÷")){
            double divide = Double.parseDouble(firstNumber) / Double.parseDouble(secondNumber);
            String divideStringUpdated = String.format(Locale.US,"%.1f", divide);
            setResult(divideStringUpdated);
            currentNumber = getResult().getText();

            // OBSERVAR ESSA PORCENTAGEM PQ ELA QUEBRA O PROGRAMA UMA HORA
        } else if (operation.equals("%")){
            double percentage = Double.parseDouble(currentNumber);
            double percentageResult = percentage / 100;
            String percentageString = String.format(Locale.US,"%.2f", percentageResult);
            if (percentage <= 1 || percentageResult <= 1) {
                percentageString = String.format(Locale.US,"%.3f", percentageResult);
            }
            if (percentage <= 0.1 || percentageResult <= 0.1) {
                percentageString = String.format(Locale.US,"%.4f", percentageResult);
            }
            if (percentage <= 0.01 || percentageResult <= 0.01) {
                percentageString = String.format(Locale.US,"%.5f", percentageResult);
            }
            setResult(percentageString);
            currentNumber = getResult().getText();
        } else if (operation.equals("^")){
            double raisedNumber = Double.parseDouble(firstNumber);
            secondNumber = currentNumber;
            double raised = Double.parseDouble(secondNumber);
            double result = Math.pow(raisedNumber, raised);
            String raisedString = String.format(Locale.US,"%.1f", result);
            setResult(raisedString);
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

    @FXML
    public void eventOnPercentageButton(ActionEvent event) {
        String displayNumber = currentNumber +  "%";
        operation = "%";
        setResult(displayNumber);
    }

    @FXML
    public void eventOnRaisedButton(ActionEvent event) {
        operation = "^";
        firstNumber = currentNumber;
        currentNumber = "";
    }

    @FXML
    public void eventOnDotButton(ActionEvent event) {
        currentNumber = currentNumber + ".";
    }
}