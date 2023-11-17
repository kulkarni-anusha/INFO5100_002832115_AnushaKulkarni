package com.example.exercise9;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Calculator extends Application {

    private StringBuilder currentInput = new StringBuilder();
    private String previousInput = "";
    private String operator = "";

    private Label display;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculator");

        // Use StackPane as the root
        StackPane root = new StackPane();
        root.setPadding(new Insets(20, 20, 20, 20));

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);

        display = new Label();
        display.setMinHeight(30);
        display.setMinWidth(170);
        display.setStyle("-fx-border-color: black;");
        GridPane.setConstraints(display, 0, 0, 4, 1);

        Button[] numberButtons = new Button[10];
        for (int i = 0; i < 10; i++) {
            final int digit = i;
            numberButtons[i] = new Button(String.valueOf(i));
            numberButtons[i].setMinSize(35, 35); // Set button size
            numberButtons[i].setOnAction(e -> handleNumberButton(String.valueOf(digit)));
        }

        Button addButton = createOperatorButton("+");
        addButton.setMinSize(35, 35); // Set add button size
        Button subtractButton = createOperatorButton("-");
        subtractButton.setMinSize(35, 35); // Set subtract button size
        Button multiplyButton = createOperatorButton("*");
        multiplyButton.setMinSize(35, 35); // Set multiply button size
        Button divideButton = createOperatorButton("/");
        divideButton.setMinSize(35, 35); // Set divide button size

        Button equalsButton = new Button("=");
        equalsButton.setStyle("-fx-background-color: #46923c;");
        equalsButton.setMinSize(35, 35); // Set equals button size
        equalsButton.setOnAction(e -> handleEqualsButton());

        Button clearButton = new Button("C");
        clearButton.setMinSize(35, 35); // Set clear button size
        clearButton.setStyle("-fx-background-color: #ec0b00;");
        clearButton.setOnAction(e -> handleClearButton());

        // Arrange buttons on the grid
        for (int i = 1; i <= 9; i++) {
            GridPane.setConstraints(numberButtons[i], (i - 1) % 3, (i - 1) / 3 + 1);
        }

        GridPane.setConstraints(numberButtons[0], 1, 4);
        GridPane.setConstraints(addButton, 3, 1);
        GridPane.setConstraints(subtractButton, 3, 2);
        GridPane.setConstraints(multiplyButton, 3, 3);
        GridPane.setConstraints(divideButton, 3, 4);
        GridPane.setConstraints(equalsButton, 2, 4);
        GridPane.setConstraints(clearButton, 0, 4);

        // Add buttons to the grid
        grid.getChildren().addAll(display);
        grid.getChildren().addAll(numberButtons);
        grid.getChildren().addAll(addButton, subtractButton, multiplyButton, divideButton);
        grid.getChildren().addAll(equalsButton, clearButton);

        // Add the grid to the StackPane
        root.getChildren().add(grid);

        Scene scene = new Scene(root, 200, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createOperatorButton(String text) {
        Button button = new Button(text);
        button.setOnAction(e -> handleOperatorButton(text));
        return button;
    }

    private void handleNumberButton(String number) {
        currentInput.append(number);
        display.setText(currentInput.toString());
    }

    private void handleOperatorButton(String op) {
        if (!currentInput.toString().isEmpty()) {
            operator = op;
            previousInput = currentInput.toString();
            currentInput.setLength(0);
            display.setText(operator);
        }
    }

    private void handleEqualsButton() {
        if (!currentInput.toString().isEmpty() && !operator.isEmpty()) {
            double operand1 = Double.parseDouble(previousInput);
            double operand2 = Double.parseDouble(currentInput.toString());
            double result = 0;

            switch (operator) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                    result = operand1 - operand2;
                    break;
                case "*":
                    result = operand1 * operand2;
                    break;
                case "/":
                    if (operand2 != 0) {
                        result = operand1 / operand2;
                    } else {
                        display.setText("Error");
                        return;
                    }
                    break;
            }

            display.setText(String.valueOf(result));
            currentInput.setLength(0);
            currentInput.append(result);
            operator = "";
        }
    }

    private void handleClearButton() {
        currentInput.setLength(0);
        previousInput = "";
        operator = "";
        display.setText("");
    }
}

