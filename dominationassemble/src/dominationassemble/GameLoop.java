package dominationassemble;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GameLoop {
	
	static String j1;
	static String j2;
	static String j3;
	static String j4;
	
	/********************************************************
	 * On pioche le nombre de cartes necessaires
	 * Puis chaque joueur selectionne son domino ds l'ordre
	 * 
	 *******************************************************/
	public static void gameMode(int i) {
		while(!Domino.gamePack.isEmpty()) {
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
			
			System.out.println("Le paquet est vide");
		}
	}
	
	public static void twoPlayers() {
		System.out.println("Mode 2 joueurs");
		Domino.drawDomino(4);
		chooseOneDomino(2);
		
		System.out.println("Main de " + j1 + " :");
		List<Domino> hand1 = getPlayer(j1).hand;
		getPlayer(j1).showHand(hand1);
		
		System.out.println("Main de " + j2 + " :");
		List<Domino> hand2 = getPlayer(j2).hand;
		getPlayer(j1).showHand(hand2);
		
		Domino dominoj1 = getPlayer(j1).hand.get(0);
		Domino dominoj2 = getPlayer(j2).hand.get(0);
		
		if (getPlayer(j1).hand.size() < 2) {
			System.out.println("Pas de placement au premier tour");
		}
		else {
		System.out.println("On place les dominos");
		}
		
	}
	
	public static void threePlayers() {
		System.out.println("Mode 3 joueurs");
		Domino.drawDomino(3);
		chooseOneDomino(3);
		
		System.out.println("Main de " + j1 + " :");
		List<Domino> hand1 = getPlayer(j1).hand;
		getPlayer(j1).showHand(hand1);
		
		System.out.println("Main de " + j2 + " :");
		List<Domino> hand2 = getPlayer(j2).hand;
		getPlayer(j1).showHand(hand2);
		
		System.out.println("Main de " + j3 + " :");
		List<Domino> hand3 = getPlayer(j3).hand;
		getPlayer(j1).showHand(hand3);
		
		Domino dominoj1 = getPlayer(j1).hand.get(0);
		Domino dominoj2 = getPlayer(j2).hand.get(0);
		Domino dominoj3 = getPlayer(j3).hand.get(0);
		
		if (getPlayer(j1).hand.size() < 2) {
			System.out.println("Pas de placement au premier tour");
		}
		else {
		System.out.println("On place les dominos");
		}
	}
	
	public static void fourPlayers() {
		System.out.println("Mode 4 joueurs");	
		Domino.drawDomino(4);
		chooseOneDomino(4);
		

		System.out.println("Main de " + j1 + " :");
		List<Domino> hand1 = getPlayer(j1).hand;
		getPlayer(j1).showHand(hand1);
		
		System.out.println("Main de " + j2 + " :");
		List<Domino> hand2 = getPlayer(j2).hand;
		getPlayer(j1).showHand(hand2);
		
		System.out.println("Main de " + j3 + " :");
		List<Domino> hand3 = getPlayer(j3).hand;
		getPlayer(j1).showHand(hand3);
		
		System.out.println("Main de " + j4 + " :");
		List<Domino> hand4 = getPlayer(j4).hand;
		getPlayer(j1).showHand(hand4);
		
		Domino dominoj1 = getPlayer(j1).hand.get(0);
		Domino dominoj2 = getPlayer(j2).hand.get(0);
		Domino dominoj3 = getPlayer(j3).hand.get(0);
		Domino dominoj4 = getPlayer(j4).hand.get(0);
		
		if (getPlayer(j1).hand.size() < 2) {
			System.out.println("Pas de placement au premier tour");
		}
		else {
		System.out.println("On place les dominos");
		}
	}
	
	public static void chooseOneDomino(int n) {
		
		/*
		 * On utilise la HashMap du tour precedent pour avoir l'ordre de jeu
		 * Puis chaque joueur choisit un domino selon cet ordre 
		 * Pour cela on ajoute le domino a sa main
		 */
		
		switch (n) {
			case(2):
				j1 = FirstTurn.map.get(1); //Joueur en 1e position
				j2 = FirstTurn.map.get(2); //Joueur en 2e position
				FirstTurn.map.remove(1);
				FirstTurn.map.remove(2);
				
				System.out.println(j1 + ",vous etes le premier a choisir");
				getPlayer(j1).hand.add(chooseDomino(j1));
				
				Domino.showSorted();
				
				System.out.println(j2 + ",a votre tour de choisir");
				getPlayer(j2).hand.add(chooseDomino(j2));
				
				Domino.showSorted();
				
				System.out.println(j1 + ", encore a vous !");
				getPlayer(j1).hand.add(chooseDomino(j1));
				
				Domino.showSorted();
				
				System.out.println(j2 + ", encore a vous !");
				getPlayer(j2).hand.add(chooseDomino(j2));
				
				
				break;
			case(3):
				j1 = FirstTurn.map.get(1); //Joueur en 1e position
				j2 = FirstTurn.map.get(2); //Joueur en 2e position
				j3 = FirstTurn.map.get(3); //Joueur en 3e position
				FirstTurn.map.remove(1);
				FirstTurn.map.remove(2);
				FirstTurn.map.remove(3);
				
				System.out.println(j1 + ",vous etes le premier a choisir");
				getPlayer(j1).hand.add(chooseDomino(j1));
				
				Domino.showSorted();
				
				System.out.println(j2 + ",a votre tour de choisir");
				getPlayer(j2).hand.add(chooseDomino(j2));
				
				Domino.showSorted();
				
				System.out.println(j3 + ",a votre tour de choisir");
				getPlayer(j3).hand.add(chooseDomino(j3));
				
				Domino.showSorted();
				
				break;
			case (4):
				j1 = FirstTurn.map.get(1); //Joueur en 1e position
				j2 = FirstTurn.map.get(2); //Joueur en 2e position
				j3 = FirstTurn.map.get(3); //Joueur en 3e position
				j4 = FirstTurn.map.get(4); //Joueur en 4e position
				FirstTurn.map.remove(1);
				FirstTurn.map.remove(2);
				FirstTurn.map.remove(3);
				FirstTurn.map.remove(4);
				
				System.out.println(j1 + ",vous etes le premier a choisir");
				getPlayer(j1).hand.add(chooseDomino(j1));
				
				Domino.showSorted();
				
				System.out.println(j2 + ",a votre tour de choisir");
				getPlayer(j2).hand.add(chooseDomino(j2));
				
				Domino.showSorted();
				
				System.out.println(j3 + ",a votre tour de choisir");
				getPlayer(j3).hand.add(chooseDomino(j3));
				
				Domino.showSorted();
				
				System.out.println(j4 + ",a votre tour de choisir");
				getPlayer(j4).hand.add(chooseDomino(j4));
				
				Domino.showSorted();
				
				break;
		}
	}
	
	public static Domino chooseDomino(String player) {
		/*
		 * Cette methode permet de demander au joueur le domino qu'il shohaite prendre
		 * Elle renvoie ainsi le domino qui sera supprimé du paquet de dominos piochés 
		 * dans le but de l'ajouter a la main du joueur 
		 */
		System.out.println("Quel domino choisissez vous (1-" + Domino.sortedDominosDrawed.size() + ")" );
		Domino domino = new Domino();
		try {
			Scanner scan = new Scanner(System.in);
			int choix = scan.nextInt();
			domino = Domino.sortedDominosDrawed.get(choix-1);
			FirstTurn.map.put(getIndexOfDomino(domino), player);
			Domino.sortedDominosDrawed.remove(choix-1);
		} catch (InputMismatchException e) {
			System.out.println("Type d'entrée incorrect, veuillez reesayer");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Le nombre que vous avez entré est incorrect, veuillez reesayer ");
			chooseDomino(player);
		}
		return domino;
		
	}
	
	public static Player getPlayer(String pseudo) {
		/*
		 * Permet de renvoyer le joueur a partir de son pseudo
		 */
		Player player = new Player();
		int n = StartGame.players.size();
		for (int i = 0; i < n; i++) {
			if(StartGame.players.get(i).pseudo == pseudo) {
				player = StartGame.players.get(i);
			} else {
			}
		} return player;
	}
	
	public static int getIndexOfDomino(Domino domino) {
		int index = 0;
		int sizeInstance = Domino.instanceOfDominosDrawed.size();
		System.out.println(sizeInstance);
		for (int j = 0; j < sizeInstance; j++) {
			if(Domino.instanceOfDominosDrawed.get(j).value == domino.value) {
				index = j;
			}
		}
		index ++;
		System.out.println("Index = " + index);
		return index;
	}
}
