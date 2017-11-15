package main;

import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import managers.DiskManager;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class App extends Application {

	static DbDef instanceUniqueDbDef;

	public static void main(String[] args) {
		Application.launch(App.class, args);
		// init();
		System.out.println(instanceUniqueDbDef);
		finish();
	}

	// public static void init() {
	// instanceUniqueDbDef = new DbDef();
	// }

	/******
	 * @param commande
	 *            reçu de l'UI
	 * @return une relation
	 */
	public void creationRelation(String commande) {
		StringTokenizer commande1 = new StringTokenizer(commande);
		// test si le premier mot est "create"
		if (commande1.nextElement().equals(new StringTokenizer("create").nextElement())) {
			String nameRelation = (String) commande1.nextElement();
			int nbrColRelation = Integer.parseInt(commande1.nextElement().toString());
			ArrayList<String> typeColRelation = new ArrayList();
			while (commande1.hasMoreTokens()) {
				typeColRelation.add(commande1.nextToken().toString());
			}
			RelSchema r1 = new RelSchema(nameRelation, nbrColRelation, typeColRelation);
			RelDef rd1 = new RelDef(this.instanceUniqueDbDef.getCompteurRelation(), r1);
			this.instanceUniqueDbDef.ajoutRelDef(rd1);
			DiskManager.createFile(rd1.getFileId());
		} else {
			System.out.println("Erreur commande non reconnue");
		}
	}

	public static void finish() {
		System.out.println(DiskManager.createCatalog());
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
