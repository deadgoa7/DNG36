package dn;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StartGame {
	public static int nbJoueurs;
	static ArrayList<String> joueurs = new ArrayList<String>();
	public static ArrayList<Player> players = new ArrayList<Player>();

	public static void main(String[] args) {
		
		Domino.importFile("D:\\dominos.csv");
		//SemiDomino.createSemiDomino("L", 7);
		Start();
		FirstTurn.firstTurn(joueurs, 1);
		
		
	}
	
	public static void Start() {
		System.out.println("###### Bienvenue sur le jeu Domi'Nations ######");
		System.out.println("Combien de joueurs etes vous ? (2-4)");
		try {
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			nbJoueurs = scan.nextInt();
		} catch(InputMismatchException e) {
			System.out.println("Vous n'avez pas rentré un nombre");
		}
		if (nbJoueurs == 2) {
			System.out.println("Vous etes donc 2 joueurs");
			Domino.putDominos(24);

			System.out.println("Chaque joueur aura 2 rois");

			Player player1 = new Player();
			player1.setColor("noir");
			playerSet(player1);
			player1.setNbKing(2);
			joueurs.add(player1.getPseudo());
			players.add(player1);
			
			Player player2 = new Player();
			player2.setColor("blanc");
			playerSet(player2);
			player2.setNbKing(2);
			joueurs.add(player2.getPseudo());
			players.add(player2);
				
		}
		else if (nbJoueurs == 3) {
			System.out.println("Vous etes donc 3 joueurs");
			Domino.putDominos(36);

			System.out.println("Chaque joueur aura 1 roi");

			Player player1 = new Player();
			player1.setColor("noir");
			playerSet(player1);
			player1.setNbKing(1);
			joueurs.add(player1.getPseudo());
			players.add(player1);
			
			Player player2 = new Player();
			player2.setColor("blanc");
			playerSet(player2);
			player2.setNbKing(1);
			joueurs.add(player2.getPseudo());
			players.add(player2);
			
			Player player3 = new Player();
			player3.setColor("violet");
			playerSet(player3);
			player3.setNbKing(1);
			joueurs.add(player3.getPseudo());
			players.add(player3);	
			
		}
		else if (nbJoueurs == 4) {
			System.out.println("Vous etes donc 4 joueurs");
			Domino.putDominos(48);

			System.out.println("Chaque joueur aura 1 roi");
			
			Player player1 = new Player();
			player1.setColor("noir");
			playerSet(player1);
			player1.setNbKing(1);
			joueurs.add(player1.getPseudo());
			players.add(player1);
			
			Player player2 = new Player();
			player2.setColor("blanc");
			playerSet(player2);
			player2.setNbKing(1);
			joueurs.add(player2.getPseudo());
			players.add(player2);
			
			Player player3 = new Player();
			player3.setColor("violet");
			playerSet(player3);
			player3.setNbKing(1);
			joueurs.add(player3.getPseudo());
			players.add(player3);
			
			Player player4 = new Player();
			player4.setColor("orange");
			playerSet(player4);
			player4.setNbKing(1);
			joueurs.add(player4.getPseudo());
			players.add(player4);
			
		}
		else {
			System.out.println("Votre nombre n'est pas compris entre 2 et 4, veuillez reesayer");
			Start();
		}	
	}
	
	public static void playerSet(Player player) {
		String pseudo = "";
		System.out.println("Choisissez un pseudo");
		try {
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			pseudo = scan.nextLine();
		}catch (InputMismatchException e) {
			System.out.println("Vous n'avez pas rentré un pseudo");
		}
		if (joueurs.contains(pseudo)) {
			System.out.println("Le nom du joueur existe deja, veuillez reesayer !");
			playerSet(player);
		}
		else {
			player.setPseudo(pseudo);
			System.out.println(player.getPseudo() + ", votre couleur sera le " + player.getColor() + ".");
		}
	}

}
