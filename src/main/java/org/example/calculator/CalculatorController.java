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

            else {
                currentLabelContent += currentOperation;
            } // end of else body
            setLabel(currentLabelContent);
        } // end of first if body
    } // end of operations buttons method

    @FXML
    public void eventOnEqualButton () {

        if (!currentLabelContent.isEmpty()) {
            String expression = currentLabelContent;
            for (int i = 0; i < expression.length(); i++) {

            }
        } // end of if body
    } // end of equal button method
} // end of class body