package dominationassemble;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LaunchMenu extends JFrame{

	private static final long serialVersionUID = 1L;  
	
	public LaunchMenu() {
		setTitle("Domi'Nation");  //nom de la fenêtre 
		setSize(800, 600);		//taille de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //paramètre par défaut pour arreter le programme , ici si on ferme la fenetre
		setResizable(true);	//possibilité d'agrandir la fenêtre
		setLocationRelativeTo(null); 	//centrer la fenêtre au milieu de l'écran
		setVisible(true);
		
		
		JLabel nbofplayers = new JLabel("Number of players :"); //JLabel : écrit un label défini
		getContentPane().add(nbofplayers); //ajoute le label à la page de la fenêtre
		nbofplayers.setFont(new Font("verdana",1,12));	//gère la police,taille d'une font
		nbofplayers.setBounds(345,30,200,100); //position et taille du label
		
		JButton twoplayersbutton = new JButton("2 Players"); //JButton : crée un bouton nomé "2 Players"
		twoplayersbutton.setFont(new Font("verdana",1,12));
		getContentPane().add(twoplayersbutton);
		twoplayersbutton.setBounds(200, 120, 100, 50);
		twoplayersbutton.addActionListener(this::e1); //appelle l'événement e1 si le bouton est actionné
		
		JButton treeplayersbutton = new JButton("3 Players");
		treeplayersbutton.setFont(new Font("verdana",1,12));
		getContentPane().add(treeplayersbutton);
		treeplayersbutton.setBounds(350, 120, 100, 50);
		treeplayersbutton.addActionListener(this::e2);
		
		
		JButton fourplayersbutton = new JButton("4 Players");
		fourplayersbutton.setFont(new Font("verdana",1,12));
		getContentPane().add(fourplayersbutton);
		fourplayersbutton.setBounds(500, 120, 100, 50);
		fourplayersbutton.addActionListener(this::e3);
		


		add(new LaunchPanel()); //crée la template "LanchPanel" pour la fenetre actuelle, la template est consitué d'éléments 
							    //graphiques comme la couleur de la page , des formes , du texte...
	}
		
	private void e1(ActionEvent event) { //création de l'événement e1 qui se déclenchera si celui-ci est appelé 
		this.dispose(); //ferme la fenêtre actuelle
		new Utilisation("Use for two players"); //lance la classe "Utilisation" dans une nouvelle fenêtre
	
	}
	private void e2(ActionEvent event) {
		this.dispose();
		new Utilisation("Use for tree players");
	
	}
	private void e3(ActionEvent event) {
		this.dispose();
		new Utilisation("Use for four players");

	}
	
		
	
	

}
