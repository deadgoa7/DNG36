package dominationassemble;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class LaunchPanel extends JPanel{ //classe de paramètre graphique qui peut etre utulisé commme template pour nimporte 
										 //quelle fenêtre qui l'appelle 
	
	
	private static final long serialVersionUID = 1L;
		
	public void paintComponent(Graphics g) { //creation d'une classe graphique
		g.setColor(new Color(120,0,0)); //couleur background
		g.fillRect(0, 0, getWidth(), getHeight()); //crée un rectangle plein de la taille des dimensions de la fenêtre
		
		Font  font = new Font("Verdana",Font.BOLD,30); //défini les paramêtres Font de la variable font
		g.setFont(font); //applique la variable font en tant que Font 
		g.setColor(Color.BLACK); //selectionne la couleur BLACK qui sera appliqué aux nouveux éléments graphiques jusqu'à modification
		g.drawString("DOMI'NATION", 295, 40); //écrit le texte DOMI'NATION situé spécifiquement dans la page de la fenêtre 
		}
}
	 
