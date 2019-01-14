package dn;

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
		System.out.println("\n" + "Chaque joueur selectionne encore un domino parmi ceux ci :" + "\n");
		Domino.showSorted();
		chooseOneDomino(2);
		
		System.out.println("Main de " + j1 + " :");
		List<Domino> hand1 = getPlayer(j1).hand;
		getPlayer(j1).showHand(hand1);
		
		System.out.println("Main de " + j2 + " :");
		List<Domino> hand2 = getPlayer(j2).hand;
		getPlayer(j1).showHand(hand2);
		
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
	}
	
	public static void chooseOneDomino(int n) {
		
		switch (n) {
			case(2):
				j1 = FirstTurn.map.get(1); //Joueur en 1e position
				j2 = FirstTurn.map.get(2); //Joueur en 2e position
				System.out.println(j1 + ",vous etes le premier a choisir");
				getPlayer(j1).hand.add(chooseDomino());
				Domino.showSorted();
				System.out.println(j2 + ",a votre tour de choisir");
				getPlayer(j2).hand.add(chooseDomino());
				
				break;
			case(3):
				j1 = FirstTurn.map.get(1); //Joueur en 1e position
				j2 = FirstTurn.map.get(2); //Joueur en 2e position
				j3 = FirstTurn.map.get(3); //Joueur en 3e position
				System.out.println(j1 + ",vous etes le premier a choisir");
				getPlayer(j1).hand.add(chooseDomino());
				Domino.showSorted();
				System.out.println(j2 + ",a votre tour de choisir");
				getPlayer(j2).hand.add(chooseDomino());
				Domino.showSorted();
				System.out.println(j3 + ",a votre tour de choisir");
				getPlayer(j3).hand.add(chooseDomino());
				Domino.showSorted();
				break;
			case (4):
				j1 = FirstTurn.map.get(1); //Joueur en 1e position
				j2 = FirstTurn.map.get(2); //Joueur en 2e position
				j3 = FirstTurn.map.get(3); //Joueur en 3e position
				j4 = FirstTurn.map.get(4); //Joueur en 4e position
				System.out.println(j1 + ",vous etes le premier a choisir");
				getPlayer(j1).hand.add(chooseDomino());
				Domino.showSorted();
				System.out.println(j2 + ",a votre tour de choisir");
				getPlayer(j2).hand.add(chooseDomino());
				Domino.showSorted();
				System.out.println(j3 + ",a votre tour de choisir");
				getPlayer(j3).hand.add(chooseDomino());
				Domino.showSorted();
				System.out.println(j4 + ",a votre tour de choisir");
				getPlayer(j4).hand.add(chooseDomino());
				Domino.showSorted();
				break;
		}
	}
	
	public static Domino chooseDomino() {
		System.out.println("Quel domino choisissez vous (1-" + Domino.sortedDominosDrawed.size() + ")" );
		Domino domino = new Domino();
		try {
			Scanner scan = new Scanner(System.in);
			int choix = scan.nextInt();
			domino = Domino.sortedDominosDrawed.get(choix-1);
			Domino.sortedDominosDrawed.remove(choix-1);
		} catch (InputMismatchException e) {
			System.out.println("Type d'entrée incorrect, veuillez reesayer");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Le nombre que vous avez entré est incorrect, veuillez reesayer ");
			chooseDomino();
		}
		return domino;
		
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
