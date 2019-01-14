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
		Domino.drawDomino(4);
		chooseOneDomino(2);
		System.out.println("\n" + "Chaque joueur selectionne encore un domino" + "\n");
		chooseOneDomino(2);
	}
	
	public static void threePlayers() {
		System.out.println("Mode 3 joueurs");
		Domino.drawDomino(3);
		chooseOneDomino(3);
	}
	
	public static void fourPlayers() {
		System.out.println("Mode 4 joueurs");	
		Domino.drawDomino(4);
		chooseOneDomino(4);
	}
	
	public static void chooseOneDomino(int n) {
		String j1;
		String j2;
		String j3;
		String j4;
		switch (n) {
			case(2):
				j1 = FirstTurn.map.get(1); //Joueur en 1e position
				j2 = FirstTurn.map.get(2); //Joueur en 2e position
				System.out.println(j1 + ",vous etes le premier a choisir");
				chooseDomino(getPlayer(j1));
				System.out.println(j2 + ",a votre tour de choisir");
				chooseDomino(getPlayer(j2));
				
				break;
			case(3):
				j1 = FirstTurn.map.get(1); //Joueur en 1e position
				j2 = FirstTurn.map.get(2); //Joueur en 2e position
				j3 = FirstTurn.map.get(3); //Joueur en 3e position
				System.out.println(j1 + ",vous etes le premier a choisir");
				chooseDomino(getPlayer(j1));
				System.out.println(j2 + ",a votre tour de choisir");
				chooseDomino(getPlayer(j2));
				System.out.println(j3 + ",a votre tour de choisir");
				getPlayer(j3);
				break;
			case (4):
				j1 = FirstTurn.map.get(1); //Joueur en 1e position
				j2 = FirstTurn.map.get(2); //Joueur en 2e position
				j3 = FirstTurn.map.get(3); //Joueur en 3e position
				j4 = FirstTurn.map.get(4); //Joueur en 4e position
				System.out.println(j1 + ",vous etes le premier a choisir");
				chooseDomino(getPlayer(j1));
				System.out.println(j2 + ",a votre tour de choisir");
				chooseDomino(getPlayer(j2));
				System.out.println(j3 + ",a votre tour de choisir");
				chooseDomino(getPlayer(j3));
				System.out.println(j4 + ",a votre tour de choisir");
				chooseDomino(getPlayer(j4));
				break;
		}
	}
	
	public static void chooseDomino(Player player) {
		
	}
	
	public static Player getPlayer(String pseudo) {
		Player player = new Player();
		int n = StartGame.players.size();
		for (int i = 0; i < n; i++) {
			if(StartGame.players.get(i).pseudo == pseudo) {
				player = StartGame.players.get(i);
			} else {
			}
		} return player;
	}
}
