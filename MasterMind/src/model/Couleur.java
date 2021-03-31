package model;

import javafx.scene.paint.Color;

public enum Couleur {
	COULAA(Color.rgb(0, 150, 180)),
	COULBB(Color.rgb(0, 250, 130)),
	COULCC(Color.rgb(250, 220, 5)),
	COULDD(Color.rgb(140, 20, 70)),
	COULEE(Color.rgb(200, 160, 250)),
	COULFF(Color.rgb(170, 250, 50)),
	COULGG(Color.rgb(230, 50, 200)),
	COULHH(Color.rgb(30, 240, 250)),
	COULII(Color.rgb(160, 50, 200)),
	COULJJ(Color.rgb(250, 160, 240)),
	COULKK(Color.rgb(40, 180, 90)),
	COULLL(Color.rgb(220, 10, 60)),
	COULMM(Color.rgb(252, 142, 10)),
	COULNN(Color.rgb(0, 190, 200));
	
	private Color couleur;
	
	private Couleur(Color couleur) {
		this.couleur = couleur;
	}

	public Color getCouleur() {
		return couleur;
	}
}
