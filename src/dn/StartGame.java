package dn;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StartGame {
	public static int nbJoueurs;

	public static void main(String[] args) {
		Path path = Paths.get("D:\\dominos.csv");
		Domino.importFile(path);
		Start();
		
	}
	
	public static void Start() {
		System.out.println("###### Bienvenue sur le jeu Domi'Nations ######");
		System.out.println("Combien de joueurs etes vous ? (2-4)");
		try {
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			nbJoueurs = scan.nextInt();
		} catch(InputMismatchException e) {
			System.out.println("Vous n'avez pas rentr� un nombre");
		}
		if (nbJoueurs == 2) {
			System.out.println("Vous etes donc 2 joueurs");
			Domino.putDominos(24);

			System.out.println("Chaque joueur aura 2 rois");

			Player player1 = new Player();
			player1.setColor("noir");
			playerSet(player1);
			player1.setNbKing(2);
			
			Player player2 = new Player();
			player2.setColor("blanc");
			playerSet(player2);
			player2.setNbKing(2);
		}
		else if (nbJoueurs == 3) {
			System.out.println("Vous etes donc 3 joueurs");
			Domino.putDominos(36);

			System.out.println("Chaque joueur aura 1 roi");

			Player player1 = new Player();
			player1.setColor("noir");
			playerSet(player1);
			player1.setNbKing(1);
			
			Player player2 = new Player();
			player2.setColor("blanc");
			playerSet(player2);
			player2.setNbKing(1);
			
			Player player3 = new Player();
			player3.setColor("violet");
			playerSet(player3);
			player3.setNbKing(1);
		}
		else if (nbJoueurs == 4) {
			System.out.println("Vous etes donc 4 joueurs");
			Domino.putDominos(48);

			System.out.println("Chaque joueur aura 1 roi");
			
			Player player1 = new Player();
			player1.setColor("noir");
			playerSet(player1);
			player1.setNbKing(1);
			
			Player player2 = new Player();
			player2.setColor("blanc");
			playerSet(player2);
			player2.setNbKing(1);
			
			Player player3 = new Player();
			player3.setColor("violet");
			playerSet(player3);
			player3.setNbKing(1);
			
			Player player4 = new Player();
			player4.setColor("orange");
			playerSet(player4);
			player4.setNbKing(1);
			
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
			System.out.println("Vous n'avez pas rentr� un pseudo");
		}
		
		player.setPseudo(pseudo);
		
		System.out.println(player.getPseudo() + ", votre couleur sera le " + player.getColor() + ".");
		
	}

}
