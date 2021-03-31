package model;

import javafx.scene.paint.Color;

public class Ligne {
	private Couleur[] couleurs;
	private int nbPresent, nbExact;

	public Ligne(int longueurCombinaison) {
		couleurs = new Couleur[longueurCombinaison];
		nbExact = 0;
		nbPresent = 0;
	}
	
	public void verifierLigne(Couleur[] solution) {
		nbExact = 0;
		nbPresent = 0;
		for(int i=0; i<couleurs.length; i++) {
			if(couleurs[i].getCouleur() == solution[i].getCouleur()) {
				nbExact++;
			}
			for(int k=0; k<solution.length; k++) {
				if(i!=k && couleurs[i].getCouleur() == solution[k].getCouleur()) {
					nbPresent++;
				}
			}
		}
	}
	
	public static Ligne genererCode(int longueurCombinaison, int nbCouleur) {
		Ligne ligne = new Ligne(longueurCombinaison);
		for(int i = 0; i < longueurCombinaison; i++) {
			ligne.couleurs[i] = Couleur.values()[(int)(Math.random()*nbCouleur)];
		}
		return ligne;
	}
	
	public boolean estCaseVide(int indice) {
		return couleurs[indice] == null;
	}
	
	public Color getCouleur(int indice) {
		if(indice >= 0 && indice < couleurs.length)
			return couleurs[indice].getCouleur();
		return null;
	}
	
	public void setCouleur(int indice, Couleur couleur) {
		if(indice >= 0 && indice < couleurs.length)
			couleurs[indice] = couleur;
	}
	
	public int getExact() {
		return nbExact;
	}
	
	public int getPresent() {
		return nbPresent;
	}
	
	public void dessiner() {
		
	}
}
