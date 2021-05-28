package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AppliManuelle extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("MasterMind");
		stage.getIcons().add(new Image("mars.png"));
		Router.INSTANCE.setStage(stage);
		Router.INSTANCE.navigate(Ecran.CHOIX);
		JeuManuel jeu = new JeuManuel(4, 8);
		jeu.afficher(stage);
		
//		Button btn1=new Button("Say, Hello World");
//		btn1.setOnAction(new EventHandler<ActionEvent>() {  
//			@Override
//			public void handle(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				System.out.println("hello world");
//			}
//		});
//        StackPane root=new StackPane();  
//        root.getChildren().add(btn1);
//        Scene scene=new Scene(root);
//        stage.setScene(scene);  
//        stage.setTitle("First JavaFX Application");  
//        stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}
