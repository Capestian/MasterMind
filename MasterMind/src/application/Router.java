package application;

import javafx.scene.Scene;
import javafx.stage.Stage;
import paneBuilder.PaneFactory;

public enum Router {
	INSTANCE;
	
	private Stage stage;
	
	public void navigate(Ecran ecran) {
		stage.setScene(new Scene(PaneFactory.INSTANCE.getWindow(ecran), 600, 400));
		stage.show();
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
}
