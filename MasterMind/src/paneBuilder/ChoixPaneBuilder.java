package paneBuilder;

import application.Ecran;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ChoixPaneBuilder implements PaneBuilder {
	VBox root;
	private GridPane choix;
	private Label nbCouleurLabel;
	private Slider nbCouleurSlider;
	private Label tailleCodeLabel;
	private Slider tailleCodeSlider;
	private Button jouerButton;
	
	
	@Override
	public Parent getRootPane() {
		return root;
	}

	@Override
	public void buildContent() {
		root = new VBox();
		root.setSpacing(45.0);
		root.setAlignment(Pos.CENTER);
		
		choix = new GridPane();
		choix.setAlignment(Pos.CENTER);
//		choix.setStyle("-fx-background-color: #C0FFC0;");
		choix.setHgap(25.0);
		choix.setVgap(15.0);
		root.getChildren().add(choix);

		nbCouleurLabel = new Label("Nombre de couleur : ");
		choix.add(nbCouleurLabel, 0, 0);
		
		nbCouleurSlider = new Slider(4, 16, 8);
		nbCouleurSlider.setShowTickLabels(true);
		nbCouleurSlider.setSnapToTicks(true);
		nbCouleurSlider.setShowTickMarks(true);
		nbCouleurSlider.setMajorTickUnit(1);
		nbCouleurSlider.setMinorTickCount(0);
		nbCouleurSlider.setPrefWidth(240.0);
		choix.add(nbCouleurSlider, 1, 0);
		
		tailleCodeLabel = new Label("Taille du code : ");
		choix.add(tailleCodeLabel, 0, 1);
		
		tailleCodeSlider = new Slider(2, 8, 4);
		tailleCodeSlider.setShowTickLabels(true);
		tailleCodeSlider.setSnapToTicks(true);
		tailleCodeSlider.setShowTickMarks(true);
		tailleCodeSlider.setMajorTickUnit(1);
		tailleCodeSlider.setMinorTickCount(0);
		choix.add(tailleCodeSlider, 1, 1);
		
		jouerButton = new Button("Jouer");
		root.getChildren().add(jouerButton);
	}
	
	@Override
	public void addListeners() {
		jouerButton.setOnAction(e -> {
			navigate(Ecran.JEU);
		});
	}
}
