package application;

import java.util.*;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.*;

public class JeuManuel {
	@SuppressWarnings("unused")
	private int tailleCode;
	private int nbCouleur;
	@SuppressWarnings("unused")
	private int idSelection;
	List<Ligne> lignes;
	Ligne code;
	
	public JeuManuel(int tailleCode, int nbCouleur) {
		super();
		this.tailleCode = tailleCode;
		if(nbCouleur > Couleur.values().length)
			nbCouleur = Couleur.values().length;
		this.nbCouleur = nbCouleur;
		this.idSelection = -1;
		lignes = new ArrayList<>();
		code = Ligne.genererCode(tailleCode, nbCouleur);
	}
	
	public void afficher(Stage stage) {
		TailleInterface taille = TailleInterface.MOYEN;
		
		BorderPane root = new BorderPane();
		root.setStyle("-fx-background-color: #EEE8AA;");
		
		
		HBox couleurs = new HBox(10);
		for(Couleur couleur : Couleur.values()) {
			if(couleur.ordinal() < nbCouleur) { // A cause du setOnMouseClicked, on doit utiliser le for each (pas de for i = 0)
				Rectangle rectangle = new Rectangle(taille.getTailleCouleur(), taille.getTailleCouleur(), couleur.getCouleur());
				rectangle.setStroke(Color.BLACK);
				rectangle.setStrokeWidth(1);
				couleurs.getChildren().add(rectangle);
				rectangle.setOnMouseClicked((e) -> {
					idSelection = couleur.ordinal();
				});
			}
		}
		couleurs.setStyle("-fx-background-color: #D8BFD8;");
		couleurs.setAlignment(Pos.CENTER);
		couleurs.setPadding(new Insets(15));
		root.setTop(couleurs);
		
		VBox code = new VBox();
		code.setMinWidth(120);
		code.setStyle("-fx-background-color: #CD5C5C;");
		code.setAlignment(Pos.CENTER);
		Rectangle cache = new Rectangle(60, 200, Color.SADDLEBROWN);
		cache.setStroke(Color.BLACK);
		cache.setStrokeWidth(2);
		code.getChildren().add(cache);
		root.setRight(code);
		
		Button boutonVerifier = new Button("Vérifier");
		boutonVerifier.setMinWidth(100);
		Button boutonRetour = new Button("Retour");
		boutonRetour.setMinWidth(100);
		boutonRetour.setOnAction((e) -> {
			return;
		});
		BorderPane boutons = new BorderPane();
		boutons.setLeft(boutonRetour);
		boutons.setCenter(boutonVerifier);
		boutons.setStyle("-fx-background-color: #7FFFD4;");
		boutons.setPadding(new Insets(15));
		root.setBottom(boutons);

		@SuppressWarnings("unused")
		GridPane propositions = new GridPane();
		
		
		@SuppressWarnings("unused")
		GridPane resultats = new GridPane();
		
		
		VBox plateau = new VBox();
		plateau.setAlignment(Pos.CENTER_LEFT);
		plateau.setStyle("-fx-background-color: #ADD8E6;");
		
		root.setCenter(plateau);
		
		Scene scene = new Scene(root, 800, 400);
		stage.setScene(scene);
		stage.show();
	}

}
