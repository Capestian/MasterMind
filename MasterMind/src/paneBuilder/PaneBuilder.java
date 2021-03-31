package paneBuilder;

import application.Ecran;
import application.Router;
import javafx.scene.Parent;

public interface PaneBuilder {
	
	default Parent build() {
		init();
		buildContent();
		addListeners();
		return getRootPane();
	}

	void buildContent();
	default void addListeners() {}
	default void init() {}
	Parent getRootPane();
	
	default public void navigate(Ecran ecran) {
		Router.INSTANCE.navigate(ecran);
	}
	
//	default void register() {
//		AppContext.INSTANCE.eventBus.register(this);
//	}
//	
//	default void post(Object event) {
//		AppContext.INSTANCE.eventBus.post(event);
//	}

}