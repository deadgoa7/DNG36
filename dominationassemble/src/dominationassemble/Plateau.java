package dominationassemble;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Plateau extends JFrame {

	private static final long serialVersionUID = 1L;

	// boolean kingdom=false;
	String titlef;
	Player player;
	int nbPlayers = StartGame.nbJoueurs;
	// String face1= Domino.sortedDominosDrawed.get(2).type1;
	// String face2= Domino.sortedDominosDrawed.get(2).type2;

	public Plateau(String title) {
		titlef = title;
		setTitle(title);
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);

		setJMenuBar(createMenuBar()); // crée la barre de menu avec tous ses éléemnts délcarés à l'interieur de
										// celle-ci

		add(new PlateauPanel());

	}

	private JMenuBar createMenuBar() {

		JMenuBar menuBar = new JMenuBar(); // créationn de la barre de menu

		JMenu menu1 = new JMenu("Game"); // création du premier onglet

		JMenuItem newgame = new JMenuItem("New Game"); // création du premier item du premier onglet
		newgame.addActionListener(this::notavaible);
		menu1.add(newgame); // ajoute l'item crée au premier onglet

		JMenuItem playagainIA = new JMenuItem("Play again IA");
		playagainIA.addActionListener(this::notavaible);
		menu1.add(playagainIA);

		menu1.addSeparator();

		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(this::e1);
		menu1.add(exit);

		JMenuItem regle1 = new JMenuItem("Notice 2 players");
		regle1.addActionListener(this::evtregle1);
		menu1.add(regle1);

		JMenuItem regle2 = new JMenuItem("Notice 3 players");
		regle2.addActionListener(this::evtregle2);
		menu1.add(regle2);

		JMenuItem regle3 = new JMenuItem("Notice 4 players");
		regle3.addActionListener(this::evtregle3);
		menu1.add(regle3);

		JMenu menu2 = new JMenu("Players"); // création du deuxieme onglet

		JMenuItem player1 = new JMenuItem(StartGame.players.get(0).pseudo);
		player1.addActionListener(this::playern);
		menu2.add(player1);

		menu2.addSeparator();

		JMenuItem player2 = new JMenuItem(StartGame.players.get(1).pseudo);
		player2.addActionListener(this::playern);
		menu2.add(player2);

		if (nbPlayers > 2) {
			menu2.addSeparator();

			JMenuItem player3 = new JMenuItem(StartGame.players.get(2).pseudo);
			player3.addActionListener(this::playern);
			menu2.add(player3);
		}
		if (nbPlayers > 3) {
			menu2.addSeparator();

			JMenuItem player4 = new JMenuItem(StartGame.players.get(3).pseudo);
			player4.addActionListener(this::playern);
			menu2.add(player4);
		}

		/*
		 * StartGame.players.get(i).pseudo est utilisé pour pour retourner le nom du
		 * pseudo entré en début de partie, ainsi chaque item de l'onglet Players sera
		 * différent à chaque partie suivant les peusods entrés. Les deux conditions if
		 * utilisé quelques lignes au desus permettent j'ajouter un troisième item à
		 * l'onglet Players voire un quatrième si le nombre de joueur est de quatre.
		 * Ainsi , si il y a deux joueurs il y aura deux items : le nom des deux
		 * pseudos; si il y a trois joueurs il y aura alors trois items et si il y a
		 * quatre joueurs il y aura donc quatre items.
		 */

		JMenu menu3 = new JMenu("Options"); // troisème onglet

		JMenuItem volume = new JMenuItem("Volume...");
		menu3.add(volume);
		volume.addActionListener(this::notavaible);

		JMenuItem iaLevel = new JMenuItem("Select IA level...");
		iaLevel.addActionListener(this::notavaible);
		menu3.add(iaLevel);

		JMenuItem langage = new JMenuItem("Select Language...");
		langage.addActionListener(this::notavaible);
		menu3.add(langage);

		JMenu actionmenu = new JMenu("Actions"); //

		JMenuItem choosedom = new JMenuItem("Choose Domino");
		choosedom.addActionListener(this::selectdom);
		actionmenu.add(choosedom);

		JMenuItem placeking = new JMenuItem("Place Kingdom");
		// placeking.addActionListener(this::kingdom);
		actionmenu.add(placeking);

		JMenuItem grillep = new JMenuItem("Grille");
		grillep.addActionListener(this::grille);
		actionmenu.add(grillep);

		menuBar.add(actionmenu); // ajoute l'onglet actionmenu à la barre de menu
		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);

		return menuBar;
	}

	private void e1(ActionEvent event) { // ferme la fentre si on clique sur exit
		this.dispose();

	}

	private void playern(ActionEvent event) {

		if (event.getActionCommand() == getTitle()) {
			JOptionPane.showMessageDialog(this, "Error, this player is already selected, please select another player");
		} else {
			new Plateau(event.getActionCommand());
			this.dispose();
		}
		/*
		 * L'évènement précédent permet de swtich de plateau entre les joueurs en
		 * sélectionnant le pseudo d'un joueur dans l'onglet Players. Ce qui est
		 * intereesant c'est qu'on compare le nom de la fenêtre actuelle qui est en fait
		 * le nom du pseudo du joueur auquel appartient le plateau actuel; et si
		 * celui-ci est le même que le pseudo sur lequel on souhaite cliquer dans
		 * l'onglet Players, cela signifie donc qu'on est deja sur le plateau du joueur
		 * et que ça sert à rien de l'ouvrir, ce qui affiche alors un message d'erreur
		 */
	}

	private void notavaible(ActionEvent event) { // mesage d'erreur pour indiquer que la fonction n'est pas encore
													// disponible
		JOptionPane.showMessageDialog(this, "Tool still not avaible");
	}

	private void selectdom(ActionEvent event) {
		new SelectDomino(); // ouvre la calsse SelectDomino qui permet de slectionner un domino
	}

	private void evtregle1(ActionEvent event) { // ouvre la notice d'utilisation pour deux joueurs
		this.dispose();
		new Utilisation("Use for two players");

	}

	private void evtregle2(ActionEvent event) {
		this.dispose();
		new Utilisation("Use for tree players");

	}

	private void evtregle3(ActionEvent event) {
		this.dispose();
		new Utilisation("Use for four players");

	}

	private void grille(ActionEvent event) {

		new GrilleJeu(titlef);

	}

	// private void kingdom(ActionEvent event) {
	// kingdom=true;
	// this.dispose();
	// new PlateauPlayerTwo("beta");

	// }

	public class PlateauPanel extends JPanel {

		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g) {
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, getWidth(), getHeight());

			Font font = new Font("Arial", Font.BOLD, 30);
			g.setFont(font);

			g.setColor(Color.BLACK);
			g.drawString("Pioche :", 620, 40);
			// g.setColor(Color.GREEN);
			// g.drawString(Domino.sortedDominosDrawed.get(2).type1, 620, 250);
			// g.setColor(Color.RED);
			// g.drawString(Domino.sortedDominosDrawed.get(2).type2, 670, 250);

			try {
				Image Montagne = ImageIO.read(new File("resources/desert.png")); // on récupère les images des
																					// différents
				Image Champs = ImageIO.read(new File("resources/wheat.png")); // terrains du jeu
				Image Prairie = ImageIO.read(new File("resources/grass.png"));
				Image Mine = ImageIO.read(new File("resources/mines.png"));
				Image Foret = ImageIO.read(new File("resources/foret.png"));
				Image Mer = ImageIO.read(new File("resources/water.png"));
				Image castle = ImageIO.read(new File("resources/chateau.jpg"));
				Image plateauaPlayerOne = ImageIO.read(new File("resources/grillekingdomino.jpg"));

				g.drawImage(plateauaPlayerOne, 0, 0, 557, 557, this);

				// <<------- image colone de gauche

				g.drawImage(castle, 251, 251, 56, 56, this);
				g.drawImage(Mer, 193, 250, 56, 56, this); // dessine l'image de l'eau à la position 193,250 de taille 56
															// x 56
				g.drawImage(Prairie, 193, 308, 56, 56, this);

				g.drawImage(Montagne, 600, 70, 20, 20, this);
				g.drawImage(Mer, 620, 70, 20, 20, this);

				g.drawImage(Foret, 600, 110, 20, 20, this);
				g.drawImage(Mine, 620, 110, 20, 20, this);

				g.drawImage(Prairie, 600, 150, 20, 20, this);
				g.drawImage(Champs, 620, 150, 20, 20, this);

				g.drawImage(Mer, 600, 190, 20, 20, this);
				g.drawImage(Prairie, 620, 190, 20, 20, this);

				// <<<-------- image colonne dedroite

				g.drawImage(Prairie, 720, 70, 20, 20, this);
				g.drawImage(Prairie, 740, 70, 20, 20, this);

				g.drawImage(Montagne, 720, 110, 20, 20, this);

				g.drawImage(Champs, 740, 110, 20, 20, this);

				g.drawImage(Mer, 720, 150, 20, 20, this);

				g.drawImage(Mine, 740, 150, 20, 20, this);

				g.drawImage(Foret, 720, 190, 20, 20, this);

				g.drawImage(Mine, 740, 190, 20, 20, this);

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
