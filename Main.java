import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		creationJoueurs();
	}
	public static void creationJoueurs() {
		
		System.out.println("Combien de joueurs ? (2-4)");
		int nbeJoueurs = 0;
		Scanner scan = new Scanner(System.in);
		try {
			nbeJoueurs = scan.nextInt();
		}
		catch (InputMismatchException e) {
			System.out.println("Vous n'avez pas rentré un nombre");
		}
		if (nbeJoueurs < 2 || nbeJoueurs >4 ) {
			System.out.println("Nbe de joueurs incorrect");
			creationJoueurs();
		}
		
		Joueur joueur1 = new Joueur();
		System.out.println("Nom du joueur 1 : ");
		joueur1.setNom(scan.nextLine());
		
		if (nbeJoueurs > 1) {
		
		Joueur joueur2 = new Joueur();
		System.out.println("Nom du joueur 2 : ");
		joueur2.setNom(scan.nextLine());
		}
		
		if (nbeJoueurs > 2) {
			
			Joueur joueur3 = new Joueur();
			System.out.println("Nom du joueur 3 : ");
			joueur3.setNom(scan.nextLine());
			
			if (nbeJoueurs > 3) {
				
				Joueur joueur4 = new Joueur();
				System.out.println("Nom du joueur 4 : ");
				joueur4.setNom(scan.nextLine());
			}
		}
	}
	
	

}
