package paneBuilder;

import application.Ecran;
import javafx.scene.Parent;

public enum PaneFactory {
INSTANCE;
	
	public Parent getWindow(Ecran ecran) {
		switch(ecran) {
		default:
		case CHOIX :
//			return new MainPaneBuilder(new OrderListPaneBuilder().build(), new OrderDetailPaneBuilder().build()).getRootPane();
			return new ChoixPaneBuilder().build();
		case JEU :
			return new JeuPaneBuilder().build();
		}
	}
}
