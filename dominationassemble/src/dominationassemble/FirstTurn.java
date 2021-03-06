package dominationassemble;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;



public class FirstTurn extends StartGame {
	static int nbPlayers;
	static Map<Integer, String> map = new HashMap<>();
	
	/************************************************
	 * On pioche les rois de façon aleatoire 
	 * de façon a determiner l'ordre de jeu
	 * 
	 * Puis on lance la Game Loop
	 ************************************************/
	public static void firstTurn(ArrayList<String> players, int i) {
		
		nbPlayers = players.size();
		drawKings(players, i);
		GameLoop.gameMode(nbPlayers);
	}
	public static void drawKings(ArrayList<String> players, int i) {
		/*
		 * On tire les joueurs de façon aleatoire pour avoir l'ordre de jeu 
		 * du premier tour
		 * 
		 * Entrée : Liste des pseudos des joueurs 
		 */
		if(players.size() < 2 || players.size() > 4) {
			System.out.println("Nbe de joueurs invalide !");
		}
		else if(players.size() == 2) {
			Random r = new Random();
			int n = r.nextInt(2);
			String pseudo = players.get(n);
			System.out.println(pseudo + " sera le " + i + "e a jouer");
			map.put(i, pseudo);
			players.remove(n);
			String pseudo2 = players.get(0);
			i +=1;
			System.out.println(pseudo2 + " sera le " + i + "e a jouer");
			map.put(i, pseudo2);
		}
		else if(players.size() == 3) {
			Random r = new Random();
			int n = r.nextInt(3);
			String pseudo = players.get(n);
			System.out.println(pseudo + " sera le " + i + "e a jouer");
			map.put(i, pseudo);
			players.remove(n);
			drawKings(players, i+1);
		}
		else if(players.size() == 4) {
			Random r = new Random();
			int n = r.nextInt(4);
			String pseudo = players.get(n);
			System.out.println(pseudo + " sera le " + i +"e a jouer");
			map.put(i, pseudo);
			players.remove(n);
			drawKings(players, i+1);
		}
	}

}
