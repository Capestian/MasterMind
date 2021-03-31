package application;

public enum TailleInterface {
	PETIT(30, 3, 18, 7, 3), MOYEN(40, 3, 34, 12, 9), GRAND(50, 3, 50, 17, 15);

	private TailleInterface(int tailleCouleur, int tailleEntreCouleur, int tailleCase, int tailleVerification, int tailleEntreLigne) {
		this.tailleCouleur = tailleCouleur;
		this.tailleEntreCouleur = tailleEntreCouleur;
		this.tailleCase = tailleCase;
		this.tailleVerification = tailleVerification;
		this.tailleEntreLigne = tailleEntreLigne;
	}
	private int tailleCouleur;
	private int tailleEntreCouleur;
	private int tailleCase;
	private int tailleVerification;
	private int tailleEntreLigne;
	
	public int getTailleCouleur() {
		return tailleCouleur;
	}
	public int getTailleEntreCouleur() {
		return tailleEntreCouleur;
	}
	public int getTailleCase() {
		return tailleCase;
	}
	public int getTailleVerification() {
		return tailleVerification;
	}
	public int getTailleEntreLigne() {
		return tailleEntreLigne;
	}
	
	
}
