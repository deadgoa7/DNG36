package dn;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SuppressWarnings("unused")
public class Domino {

	public int crown1;
	public int crown2;
	public String type1;
	public String type2;
	public int value;
	

	static List<Domino> initialPack = new ArrayList<Domino>(); 	//Paquet contenant tous les dominos possible
	static List<Domino> gamePack = new ArrayList<Domino>(); 	//Paquet contenant seulement les dominos utilisés pour la partie

	public Domino(int crown1, String type1, int crown2, String type2, int value) {
		// TODO Auto-generated constructor stub
	}
	

	public static void importFile(Path File){
		/**************************************************************************
		* On importe le fichier contenant les references des dominos (Fichier CSV)
		* 
		* 						Entrée : Chemin du fichier
		* 								Sortie : /
		*
		***************************************************************************/

		List<String> lines = null;  		//On crée une liste vide
		try {
		lines = Files.readAllLines(File); 	//Chaque indice de la liste lines = les elements de chaque ligne correspondante
		System.out.println("SUCCES");
		} catch (IOException e) { 
			System.out.println("Impossible de lire le fichier");
		} if (lines.size() < 2) {
			System.out.println("Il n'y a pas de dominos dans le fichier");
		}
		else {
			fileProcessing(lines);			//On appelle la fonction qui separe les données
		}
	}

	public static List<Domino> fileProcessing(List<String> lines){
		/************************************************************************
		* On separe les differentes données du fichier CSV pour en faire des    
		*             parametres qui serviront a créer les dominos              
		*                                                                       
		*						Entrée : Liste de String                        
		*					    Sortie : Liste de Domino                        
		*                                                                       
		*************************************************************************/	
		
		for (int i = 1; i< lines.size(); i++){	//On parcourt la liste de String
			String [] dominosParameters = lines.get(i).split(","); //Extraction des parametres (Nbe de couronnes, Type de terrain...)
			Domino domino = newDomino(dominosParameters);
			initialPack.add(domino);
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
		int crown1 = toInt(parameters[0]);	//Nb de couronnes partie gauche
		String type1 = parameters[1];		//Type de terrain partie gauche   
		int crown2 = toInt(parameters[2]);	//Nb de couronnes partie droite
		String type2 = parameters[3];		//Type de terrain partie droite
		int value = toInt(parameters[4]);	//Numero du domino

		return new Domino(crown1,type1,crown2,type2,value);
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

	

	static List<Integer> dominosDrawed = new ArrayList<Integer>();

	public static void drawDomino(){
		/*******************************************
		* On prend un domino au hasard de la pioche 
		*      Puis on l'affiche sur la table
		*
		*******************************************/
		int max = gamePack.size();
		int min = 1;
		int random = (int) (Math.random() * (max - min)); //Random prend une valeur entiere aléatoire entre min et max
		System.out.println("");
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
