package main;

import javafx.scene.input.*;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class SceneBDD {

	private Button btn = new Button();
	private TextField text = new TextField();
	private Scene scene;
	private TextArea area = new TextArea();

	public SceneBDD(Pane pane, double width, double height, Color color) {
		this.scene = new Scene(pane, width, height, color);
		this.scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		btn.setTranslateX(275);
		btn.setTranslateY(515);
		btn.setText("Envoyer");
		btn.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

			}
		});

		area.setPrefHeight(450);
		area.setPrefWidth(580);
		area.setEditable(false);
		area.setTranslateX(10);
		area.setTranslateY(10);

		text.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent key) {
				if (key.getCode() == KeyCode.ENTER) {
					area.appendText(text.getText());
					text.setText("");
				}

			}
		});

		text.setPrefSize(580, 10);
		text.setTranslateY(480);
		text.setTranslateX(10);

		pane.getChildren().setAll(text, btn, area);
	}

	public Scene getScene() {
		return this.scene;
	}
}
