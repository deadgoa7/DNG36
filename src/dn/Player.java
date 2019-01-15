package dn;

import java.util.ArrayList;
import java.util.List;

public class Player{

	String pseudo;
	public List<Domino> hand = new ArrayList<Domino>();
	int score;
	String color;
	public int nbKings;
	
	public static void showHand(List<Domino> hand) {
		int size = hand.size();
		for (int i = 0;i<size; i++) {
			Domino.showDomino(hand.get(i));
		}
	}
	
	
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setNbKing(int nbKings) {
		this.nbKings = nbKings;
	}
	
	public int getNbKing() {
		return nbKings;
	}
	
	public List<Domino> getHand(){
		return hand;
	}


}
