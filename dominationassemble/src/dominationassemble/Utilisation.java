/*
 * 
 * Les explications pour les fonctions utilisés dans cette classe sont expliqués dans la classe "Plateau"
 * 
 * 
 */

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

public class Utilisation extends JFrame {
	int nbPlayers = StartGame.nbJoueurs;

	private static final long serialVersionUID = 1L;

	public Utilisation(String title) {
		setTitle(title);
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);

		setJMenuBar(createMenuBar());

		add(new TwoPlayersUsePanel());
	}

	private JMenuBar createMenuBar() {

		JMenuBar menuBar = new JMenuBar();

		JMenu menu1 = new JMenu("Game");

		JMenuItem newgame = new JMenuItem("New Game");
		newgame.addActionListener(this::notavaible);
		menu1.add(newgame);

		JMenuItem playagainIA = new JMenuItem("Play again IA");
		playagainIA.addActionListener(this::notavaible);
		menu1.add(playagainIA);

		menu1.addSeparator();

		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(this::e1);
		menu1.add(exit);

		JMenu menu2 = new JMenu("Players");

		JMenuItem player1 = new JMenuItem(StartGame.players.get(0).pseudo);
		player1.addActionListener(this::playerone);
		menu2.add(player1);

		menu2.addSeparator();

		JMenuItem player2 = new JMenuItem(StartGame.players.get(1).pseudo);
		player2.addActionListener(this::notavaible2);
		menu2.add(player2);

		if (nbPlayers > 2) {
			menu2.addSeparator();

			JMenuItem player3 = new JMenuItem(StartGame.players.get(2).pseudo);
			player3.addActionListener(this::notavaible2);
			menu2.add(player3);
		}
		if (nbPlayers > 3) {
			menu2.addSeparator();

			JMenuItem player4 = new JMenuItem(StartGame.players.get(3).pseudo);
			player4.addActionListener(this::e2);
			menu2.add(player4);
		}

		JMenu menu3 = new JMenu("Options");

		JMenuItem volume = new JMenuItem("Volume...");
		menu3.add(volume);
		volume.addActionListener(this::notavaible);

		JMenuItem iaLevel = new JMenuItem("Select IA level...");
		iaLevel.addActionListener(this::notavaible);
		menu3.add(iaLevel);

		JMenuItem langage = new JMenuItem("Select Language...");
		langage.addActionListener(this::notavaible);
		menu3.add(langage);

		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);

		return menuBar;
	}

	private void e1(ActionEvent event) {
		this.dispose();

	}

	private void e2(ActionEvent event) {
		JOptionPane.showMessageDialog(this, "Error, this player doesn't play , please select another player");
	}

	private void notavaible2(ActionEvent event) {
		JOptionPane.showMessageDialog(this, "Please select " + StartGame.players.get(0).pseudo + " for start the game");
	}

	private void notavaible(ActionEvent event) {
		JOptionPane.showMessageDialog(this, "Tool still not avaible");
	}

	private void playerone(ActionEvent event) {
		this.dispose();
		new Plateau(StartGame.players.get(0).pseudo);

	}

	public class TwoPlayersUsePanel extends JPanel {

		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g) {
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, getWidth(), getHeight());

			Font font = new Font("Arial", Font.BOLD, 30);
			g.setFont(font);
			g.setColor(Color.BLACK);
			g.drawString("UTILISATION " + StartGame.nbJoueurs + " JOUEURS :", 156, 150);
			Font font1 = new Font("Arial", Font.BOLD, 18);
			g.setFont(font1);
			g.drawString("-Pour commencer la partie veuillez selectionner " + StartGame.players.get(0).pseudo
					+ " dans la catégorie 'Players'.", 30, 200);
			g.drawString("-Ensuite, dans la catégorie Actions , vous pouvez chosir un domino , placer votre roi,", 30,
					230);
			g.drawString("selectioner l'orientation du domino, placer le domino...", 100, 260);
			g.drawString("-Pour chaque action souhaité , une fenêtre secondaire va s'ouvrir pour sélectionner une", 30,
					290);
			g.drawString("proposition suivant le contexte. ", 100, 320);
			g.drawString("Il suffit de cliquer apres sur 'Confirm' pour confimer le choix.", 100, 350);
			g.drawString("-Pour changer de plateau correpondant à chaque joueur , il suffit juste de selectionner le",
					30, 380);
			g.drawString("joueur souhaité dans la catégorie 'Players'.", 100, 410);
			g.drawString("-Certains choix de la barre de menu ne sont pas encore disponible et", 30, 440);
			g.drawString("affichent un message d'erreur.", 100, 470);
			g.drawString("-Il est possible de quitter le jeu en allant dans 'Menu' et en cliquant sur 'Exit'.", 30,
					500);

			try {
				Image namegame = ImageIO.read(new File("resources/header.png"));
				g.drawImage(namegame, 176, 10, 400, 100, this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
