
package dominationassemble;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SelectDomino extends JFrame {

	private static final long serialVersionUID = 1L;
	public static String choice;

	private JPanel container = new JPanel();
	// (Domino.sortedDominosDrawed.get(2).type1+" +
	// "+Domino.sortedDominosDrawed.get(2).type2)
	private JRadioButton check1 = new JRadioButton("D1"); // crée un "boutton radio "de sélection portant le nom de
															// "Domino 1"
	private JRadioButton check2 = new JRadioButton("D2");
	private JRadioButton check3 = new JRadioButton("D3");
	private JRadioButton check4 = new JRadioButton("D4");
	private JButton confirm = new JButton("Confirm"); // crée un bouton classique portant le nom de "confirmer"

	public SelectDomino() {
		this.setTitle("Select ONE domino");
		this.setSize(500, 60);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		container.setBackground(Color.white); // définis le background comme étant blanc
		container.setLayout(new BorderLayout()); // permet de créer des boutons , textfield, ect.. pour la fenêtre

		JPanel top = new JPanel();

		confirm.addActionListener(this::econf); // associe le click du bouton à l'évènemnt econf
		check1.addActionListener(this::e1); // associe le choix du boution radio à l'évènemnt e1
		check2.addActionListener(this::e2);
		check3.addActionListener(this::e3);
		check4.addActionListener(this::e4);

		top.add(check1); // ajoute le radio bouton ayant la variable check1 au panel "top"
		top.add(check2);
		top.add(check3);
		top.add(check4);
		top.add(confirm); // " "boutton classique" "

		ButtonGroup group = new ButtonGroup(); // permet de grouper tout les boutons radio ci dessous pour ne laisser la
												// possibilité à
		group.add(check1); // l'utilisateur de choisir une seule et unique possibilité
		group.add(check2);
		group.add(check3);
		group.add(check4);

		container.add(top, BorderLayout.NORTH);

		this.setContentPane(container); // ajoute les élément du panel à la fenêtre
		this.setVisible(true);
	}

	private void e1(ActionEvent e) { // crée l'évènement e1
		/*
		 * System.out.println(((JCheckBox)e.getSource()).getText() + " - état : " +
		 * ((JCheckBox)e.getSource()).isSelected()); JOptionPane.showMessageDialog(this,
		 * "Vous avez selectionné le : "+((JRadioButton)e.getSource()).getText());
		 */

		choice = e.getActionCommand(); // associe la string "Domino 1" à la variable choice
	}

	private void e2(ActionEvent e) {
		choice = e.getActionCommand();
	}

	private void e3(ActionEvent e) {
		choice = e.getActionCommand();
	}

	private void e4(ActionEvent e) {
		choice = e.getActionCommand();
	}

	private void econf(ActionEvent e) { // evénement crée lorsque qu'on clique sur le bouton classique pour valiser
										// notre choix
		JOptionPane.showMessageDialog(this, "Vous avez selectionné le : " + choice);
		this.dispose();
		/*
		 * Comme on a associé la variable "choice" à chaque possibilité d'évènement , on
		 * peux afficher un message dans une fenêtre informative indiquant à
		 * l'utilisateur quel domino il a choisi (événement déclenché lorsque celui-ci
		 * appuie sur "confirm" qui est le bouton classique") suivant quel évènement à
		 * été appelé
		 */
	}

	public static String getChoice() {
		return choice;
	}

	public void setChoice(String pseudo) {
		this.choice = pseudo;
	}

}
