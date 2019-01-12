package dn;

public class GameLoop {
	/********************************************************
	 * On pioche le nombre de cartes necessaires
	 * Puis chaque joueur selectionne son domino ds l'ordre
	 * 
	 *******************************************************/
	public static void gameMode(int i) {
		if (i == 2) {
			twoPlayers();	
		}
		else if (i == 3) {
			threePlayers();	
		}
		else if (i == 4) {
			fourPlayers();	
		}
		else {
			System.out.println("ERREUR");
		}
	}
	
	public static void twoPlayers() {
		System.out.println("Mode 2 joueurs");
		
		String j1 = FirstTurn.map.get(1); //Joueur en 1e position
		String j2 = FirstTurn.map.get(2); //Joueur en 2e position
		
		Domino.drawDomino(4);
	}
	
	public static void threePlayers() {
		System.out.println("Mode 3 joueurs");
		
		String j1 = FirstTurn.map.get(1); //Joueur en 1e position
		String j2 = FirstTurn.map.get(2); //Joueur en 2e position
		String j3 = FirstTurn.map.get(3); //Joueur en 3e position
		
		Domino.drawDomino(3);
	}
	
	public static void fourPlayers() {
		System.out.println("Mode 4 joueurs");
		
		String j1 = FirstTurn.map.get(1); //Joueur en 1e position
		String j2 = FirstTurn.map.get(2); //Joueur en 2e position
		String j3 = FirstTurn.map.get(3); //Joueur en 3e position
		String j4 = FirstTurn.map.get(4); //Joueur en 4e position
		
		Domino.drawDomino(4);
	}
}
