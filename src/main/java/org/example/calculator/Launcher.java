package org.example.calculator;

import javafx.application.Application;

import java.util.Locale;

public class Launcher {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Application.launch(CalculatorApplication.class, args);
    } // end of main method
} // end of class body