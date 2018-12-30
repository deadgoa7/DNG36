package dn;

import java.util.ArrayList;
import java.util.List;

public class Player{

	String pseudo;
	int score;
	String color;
	public List<Domino> hand = new ArrayList<Domino>();
	public int nbKings;
	
	
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


}