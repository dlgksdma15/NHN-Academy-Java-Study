package com.example.circle;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    private Canvas canvas;

    private CircleManager manager;

    @FXML
    public void initialize() {
        manager = new CircleManager(5);
        manager.addCircle(new SimpleCircle(100, 100, 30, Color.BLUE));
        manager.addCircle(new SimpleCircle(150, 150, 30, Color.GREEN));

        GraphicsContext gc = canvas.getGraphicsContext2D();
        manager.drawAll(gc);
        manager.checkCollisions();
        manager.drawAll(gc);
    }

}