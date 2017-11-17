package main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import managers.BufferManager;

public class App extends Application {


	public static void main(String[] args) {
		Application.launch(App.class, args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Mini SGBD");
		Pane pane = new Pane();
		SceneBDD scene = new SceneBDD(pane, 600, 550, Color.ALICEBLUE);
		primaryStage.setScene(scene.getScene());
		primaryStage.setResizable(false);
		primaryStage.show();
	}

}
