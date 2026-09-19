package org.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController {

    @FXML
    private Label label;

    public void setLabel (String label) {
        this.label.setText(label);
    } // end of label setter

    private String currentLabelContent = ""; // have to be initialized because it will appear as null and null2341 for example, empty string

    // WORKING FINE
    @FXML
    public void eventOnNumberButtons (ActionEvent event) {
        Button numberButtonSource =  (Button) event.getSource();
        currentLabelContent += numberButtonSource.getText();
        setLabel(currentLabelContent);
    } // end of number buttons method

    // WORKING FINE
    @FXML
    public void eventOnACButton () {
        currentLabelContent = "";
        setLabel("0");
    } // end of AC button method

    // WORKING FINE
    @FXML
    public void eventOnOperationButtons (ActionEvent event) {
        Button operationButtonSource = (Button) event.getSource();
        String currentOperation = operationButtonSource.getText();

        if (!currentLabelContent.isEmpty()) {

            char lastChar = currentLabelContent.charAt(currentLabelContent.length() - 1); // char method that get/look a specific char in a String

            if (lastChar == '+' ||
                lastChar == '-' ||
                lastChar == 'x' ||
                lastChar == '÷') {

                currentLabelContent = currentLabelContent.substring(0, currentLabelContent.length() - 1) + currentOperation; // substring get a specific part of a String

            } // end of second if body

            else if (lastChar == '%') {
                currentLabelContent += currentOperation;
            } // end of third if body

            else {
                currentLabelContent += currentOperation;
            } // end of else body
            setLabel(currentLabelContent);
        } // end of first if body
    } // end of operations buttons method

    // WORKING FINE
    @FXML
    public void eventOnDelButton () {
        if (currentLabelContent.length() <= 1) {
            currentLabelContent = "";
            setLabel("0");
        } // end of if body

        else {
            currentLabelContent = currentLabelContent.substring(0, currentLabelContent.length() - 1);
            setLabel(currentLabelContent);
        } // end of else body
    } // end of del button method

    @FXML
    public void eventOnPercentageButton (ActionEvent event) {
        Button percentageButtonSource = (Button) event.getSource();
        String percentageButtonContent = percentageButtonSource.getText();

        if (!currentLabelContent.isEmpty()) {

            char lastChar = currentLabelContent.charAt(currentLabelContent.length() - 1);
            char secondToLastChar = currentLabelContent.charAt(currentLabelContent.length() - 2);

            if (lastChar == '+' ||
                lastChar == '-' ||
                lastChar == 'x' ||
                lastChar == '÷') {

                if (secondToLastChar == '%') {
                    setLabel(currentLabelContent);
                } // end of fourth if body

                else {
                    currentLabelContent = currentLabelContent.substring(0, currentLabelContent.length() - 1) + percentageButtonContent;
                    setLabel(currentLabelContent);
                } // end of second else
            } // end of second if body

            else if (lastChar == '%') {
                currentLabelContent = currentLabelContent.substring(0, currentLabelContent.length() - 1) + percentageButtonContent;
                setLabel(currentLabelContent);
            } // end of third if body

            else {
                currentLabelContent += percentageButtonContent;
                setLabel(currentLabelContent);
            } // end of else body
        } // end of first if body
    } // end of percentage button method
} // end of class body