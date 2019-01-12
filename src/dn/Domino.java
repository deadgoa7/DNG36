package dn;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Domino {

	public int crown1;
	public int crown2;
	public String type1;
	public String type2;
	public int value;
	
	static List<Domino> initialPack = new ArrayList<Domino>(); 	//Paquet contenant tous les dominos possible
	static List<Domino> gamePack = new ArrayList<Domino>(); 	//Paquet contenant seulement les dominos utilisés pour la partie



	public static List<Domino> importFile(String file){
		/**************************************************************************
		* On importe le fichier contenant les references des dominos (Fichier CSV)
		* 
		* 						Entrée : Chemin du fichier
		* 								Sortie : /
		*
		***************************************************************************/

		List<String> lines = new ArrayList<String>();
		Path pathFile = Paths.get(file);
		try {
			lines = Files.readAllLines(pathFile);
			for(int i = 1; i < lines.size(); i++) {
				String[] parameters = lines.get(i).split(",");
				Domino domino = newDomino(parameters);
				initialPack.add(domino);
			}
		} catch (IOException e) {
			System.out.println("ERROR");
		}
		return initialPack;	
	}

	public static Domino newDomino(String [] parameters){
		/*************************************************************************
		* On crée un nouveau Domino a partir des parametres extraits du CSV
		* 
		* 					Entrée : Tableau de parametres 
		*                           Sortie : Domino 
		*
		*************************************************************************/
		Domino domino = new Domino();
		domino.crown1 = toInt(parameters[0]); 	//Nb de couronnes partie gauche
		domino.type1 = parameters[1];						//Type de terrain partie gauche
		domino.crown2 = toInt(parameters[2]);	//Nb de couronnes partie droite
		domino.type2 = parameters[3];						//Type de terrain partie droite
		domino.value = toInt(parameters[4]);		//Numero du domino
		return domino;
	}

	public static int toInt(String s){
		/*****************************
		* Convertis un String en Int 
		*
		*       Entrée : String
		*       Sortie : Integer
		*
		*****************************/
		int i = 0;
		try {
			i = Integer.parseInt(s);
		}
		catch(NumberFormatException e) {
			System.out.println("Le format du string à convertir est incorrect :");
			System.out.println("Voici ce que vous avez essayé de convertir: " + s);
		}
		return i;
	}

	public static void putDominos(int n){
		/****************************************************************************
		* Permet de placer le nombre de dominos necessaire au jeu dans le paquet de 
		* jeu
		* 
		* 					  Entrée : Nbe de Dominos a placer
		* 			     On place les dominos dans la liste gamePack
		*
		******************************************************************************/
		int nbToPut = n;
		int nbLeft = initialPack.size();
		try {
			while(nbToPut>0){
				int rand = (int) (Math.random() * (nbLeft - 1)); //On prend un nbe aleatoire parmis les dominos restants
				gamePack.add(initialPack.get(rand));
				initialPack.remove(rand);
				nbToPut --;
				nbLeft --;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

								// Pioche de cartes //

	/*******************************************************************************
	*     On veut savoir le numero de touts les dominos qui ont été piochées 
	*         On veut egalement connaitre les dominos de chaque joueur 
	*       Enfin on veut afficher a chaque joueur le domino qu'il a tiré
	* Pioche <=> Supprimer un domino au hasard du paquet et le placer sur la table
	*
	*******************************************************************************/

	

	static List<Integer> nbDominosDrawed = new ArrayList<Integer>();
	static List<Domino> dominosDrawed = new ArrayList<Domino>();

	public static void drawDomino(int nb){
		/*******************************************
		* On prend un domino au hasard de la pioche 
		*      Puis on l'affiche sur la table
		*
		*******************************************/
		System.out.println("Pioche");
		for (int i = 0; i < nb; i++) {
			Random r = new Random();
			int random = r.nextInt(gamePack.size()) + 1; //Random prend une valeur entiere aléatoire entre 1 et max
			nbDominosDrawed.add(gamePack.get(random).value);
			dominosDrawed.add(gamePack.get(random));
			System.out.println(gamePack.get(random).getValue());
			gamePack.remove(random);
		}
	}
		
	public static void afficheDomino() {
		for (int i = 0; i < initialPack.size(); i++) {
			System.out.println(initialPack.get(i).value);
		}
	}
		
		

	
	// Getter 
	
	
	public int getCrown1() {
		return crown1;
	}

	public void setCrown1(int crown1) {
		this.crown1 = crown1;
	}

	public int getCrown2() {
		return crown2;
	}

	public void setCrown2(int crown2) {
		this.crown2 = crown2;
	}

	public String getType1() {
		return type1;
	}
	
	public int getValue() {
		return value;
	}
	
	//Setter 
	
	
/*
	
	public void setType1(String type1) {
		this.type1 = type1;
	}

	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
*/

}
