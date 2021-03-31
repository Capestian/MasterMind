package paneBuilder;

import java.util.*;

import application.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.*;

public class JeuPaneBuilder implements PaneBuilder {
	private final static int tailleCode = 4;
	private final static int nbCouleur = 8;
	private final static TailleInterface taille = TailleInterface.MOYEN;
	
	private BorderPane root;
	private HBox couleursHBox;
	private VBox codeVBox;
	private Rectangle cache;
	private Button boutonVerifier;
	private Button boutonRetour;
	private BorderPane boutons;
	private GridPane essaisGridPane;
	
	private Ligne code;
	private List<Ligne> essais;
	
	private int ligneCourante = 0;
	private Rectangle rectangleSelectionne;
	private int nbCasesATraiter = 0;
	private Rectangle[] casesATraiter = new Rectangle[tailleCode];

	@Override
	public Parent getRootPane() {
		return root;
	}

	@Override
	public void init() {
		
	}

	@Override
	public void buildContent() {
		root = new BorderPane();
		root.setStyle("-fx-background-color: #EEE8AA;");
		
		couleursHBox = new HBox();
		for(Couleur couleur : Couleur.values()) {
			if(couleur.ordinal() < nbCouleur) { // A cause du setOnMouseClicked, on doit utiliser le for each (pas de for i = 0)
				Rectangle rectangle = new Rectangle(30, 30, couleur.getCouleur());
				rectangle.setStroke(Color.BLACK);
				rectangle.setStrokeWidth(1);
				HBox.setMargin(rectangle, new Insets(2, 6, 2, 6));
				couleursHBox.getChildren().add(rectangle);
				rectangle.setOnMouseClicked((e) -> {
					if(nbCasesATraiter < tailleCode) {
						casesATraiter[nbCasesATraiter++].setFill(rectangle.getFill());
					}
					else {
						if(rectangle == rectangleSelectionne) {			// Click sur déjà sélectionné
							mincirRectangle(rectangle);
						}
						else {											// Click sur un non sélectionné
							if(rectangleSelectionne != null) {			// alors qu'un autre est sélectionné
								mincirRectangle(rectangleSelectionne);
							}
							grossirRectangle(rectangle);
						}
					}
					
//					idSelection = couleur.ordinal();
				});
			}
		}
		couleursHBox.setStyle("-fx-background-color: #D8BFD8;");
		couleursHBox.setAlignment(Pos.CENTER);
		couleursHBox.setPadding(new Insets(15));
		root.setTop(couleursHBox);
		
		codeVBox = new VBox();
		codeVBox.setMinWidth(120);
		codeVBox.setStyle("-fx-background-color: #CD5C5C;");
		codeVBox.setAlignment(Pos.CENTER);
		cache = new Rectangle(60, 200, Color.SADDLEBROWN);
		cache.setStroke(Color.BLACK);
		cache.setStrokeWidth(2);
		codeVBox.getChildren().add(cache);
		root.setRight(codeVBox);
		
		boutonVerifier = new Button("Vérifier");
		boutonVerifier.setPrefWidth(100);
		boutonRetour = new Button("Retour");
		boutonRetour.setPrefWidth(100);
		boutons = new BorderPane();
		boutons.setCenter(boutonVerifier);
		boutons.setLeft(boutonRetour);
		boutons.setStyle("-fx-background-color: #7FFFD4;");
		boutons.setPadding(new Insets(15));
		root.setBottom(boutons);
		
		essaisGridPane = new GridPane();
		essaisGridPane.setAlignment(Pos.CENTER_LEFT);
		essaisGridPane.setStyle("-fx-background-color: #ADD8E6;");
		nextLine();
		
		root.setCenter(essaisGridPane);
		
//		sceneTitle = new Text("Bienvenue");
//		sceneTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
//		grid.add(sceneTitle, 0, 0, 2, 1);
//		sceneTitle.setFill(Color.LIGHTBLUE);
//		background = new Background(new BackgroundFill(Color.DARKRED/*PALEGOLDENROD*/, CornerRadii.EMPTY, null));
//		grid.setBackground(background);
//		grid.setPrefSize(600, 400);
		
		
	}

	@Override
	public void addListeners() {
		boutonRetour.setOnAction((e) -> {
			navigate(Ecran.CHOIX);
		});
		boutonVerifier.setOnAction(e -> verifier());
	}

	private void verifier() {
		nextLine();
		
//		String username = usernameTextField.getText();
//		String password = passwordField.getText();
//		try {
//			userService.authenticate(username, password);
//			navigate(Ecran.MAIN);
//		} catch (EShopException e) {
//			messageLabel.setText("Echec de l'authentification");
//			
//			Alert alert = new Alert(AlertType.ERROR);
//			alert.setTitle("Authentification");
//			alert.setContentText("Echec de l'authentification");
//			alert.show();
//		}
	}
	
	public void nextLine() {
		ligneCourante++;
		for(int i=0; i<tailleCode; i++) {
			Rectangle rectangle = new Rectangle(30, 30, Color.WHITE);
			rectangle.setStroke(Color.BLACK);
			rectangle.setStrokeWidth(1);
			GridPane.setMargin(rectangle, new Insets(2, 6, 2, 6));
			essaisGridPane.add(rectangle, ligneCourante, i);
			casesATraiter[i] = rectangle;
			rectangle.setOnMouseClicked(e -> {
				if(rectangleSelectionne != null) {
					rectangle.setFill(rectangleSelectionne.getFill());
				}
			});
		}
		nbCasesATraiter = 0;
	}
	
	public void grossirRectangle(Rectangle rectangle) {
		HBox.setMargin(rectangle, new Insets(0, 4, 0, 4));
		rectangle.setStrokeWidth(5);
		rectangleSelectionne = rectangle;
	}
	
	public void mincirRectangle(Rectangle rectangle) {
		HBox.setMargin(rectangle, new Insets(2, 6, 2, 6));
		rectangle.setStrokeWidth(1);
		rectangleSelectionne = null;
	}
}
