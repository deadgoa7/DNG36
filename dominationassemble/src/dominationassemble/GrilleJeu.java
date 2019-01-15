package dominationassemble;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GrilleJeu extends JFrame {
	private static final long serialVersionUID = 1L;  

	private JPanel contentPane;

	
	

	
	public GrilleJeu(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);
		
		
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 6, 578, 456);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(9, 9, 0, 0));
		
		
		
		
		JButton btnNewButton_1 = new JButton(SelectDomino.getChoice());
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.addActionListener(this::color);
		panel_1.add(btnNewButton_1);
		JButton btnNewButton_2 = new JButton();
		panel_1.add(btnNewButton_2);
		JButton btnNewButton_3 = new JButton();
		panel_1.add(btnNewButton_3);
		JButton btnNewButton_4 = new JButton();
		panel_1.add(btnNewButton_4);
		JButton btnNewButton_5 = new JButton();
		panel_1.add(btnNewButton_5);
		JButton btnNewButton_6 = new JButton();
		panel_1.add(btnNewButton_6);
		JButton btnNewButton_7 = new JButton();
		panel_1.add(btnNewButton_7);
		JButton btnNewButton_8 = new JButton();
		panel_1.add(btnNewButton_8);
		JButton btnNewButton_9 = new JButton();
		panel_1.add(btnNewButton_9);
		JButton btnNewButton_10 = new JButton();
		panel_1.add(btnNewButton_10);
		JButton btnNewButton_11 = new JButton();
		panel_1.add(btnNewButton_11);
		JButton btnNewButton_12 = new JButton();
		panel_1.add(btnNewButton_12);
		JButton btnNewButton_13 = new JButton();
		panel_1.add(btnNewButton_13);
		JButton btnNewButton_14 = new JButton();
		panel_1.add(btnNewButton_14);
		JButton btnNewButton_15 = new JButton();
		panel_1.add(btnNewButton_15);
		JButton btnNewButton_16 = new JButton();
		panel_1.add(btnNewButton_16);
		JButton btnNewButton_17 = new JButton();
		panel_1.add(btnNewButton_17);
		JButton btnNewButton_18 = new JButton();
		panel_1.add(btnNewButton_18);
		JButton btnNewButton_19 = new JButton();
		panel_1.add(btnNewButton_19);
		JButton btnNewButton_20 = new JButton();
		panel_1.add(btnNewButton_20);
		JButton btnNewButton_21 = new JButton();
		panel_1.add(btnNewButton_21);
		JButton btnNewButton_22 = new JButton();
		panel_1.add(btnNewButton_22);
		JButton btnNewButton_23 = new JButton();
		panel_1.add(btnNewButton_23);
		JButton btnNewButton_24 = new JButton();
		panel_1.add(btnNewButton_24);
		JButton btnNewButton_25 = new JButton();
		panel_1.add(btnNewButton_25);
		JButton btnNewButton_26 = new JButton();
		panel_1.add(btnNewButton_26);
		JButton btnNewButton_27 = new JButton();
		panel_1.add(btnNewButton_27);
		JButton btnNewButton_28 = new JButton();
		panel_1.add(btnNewButton_28);
		JButton btnNewButton_29 = new JButton();
		panel_1.add(btnNewButton_29);
		JButton btnNewButton_30 = new JButton();
		panel_1.add(btnNewButton_30);
		JButton btnNewButton_31 = new JButton();
		panel_1.add(btnNewButton_31);
		JButton btnNewButton_32 = new JButton();
		panel_1.add(btnNewButton_32);
		JButton btnNewButton_33 = new JButton();
		panel_1.add(btnNewButton_33);
		JButton btnNewButton_34 = new JButton();
		panel_1.add(btnNewButton_34);
		JButton btnNewButton_35 = new JButton();
		panel_1.add(btnNewButton_35);
		JButton btnNewButton_36 = new JButton();
		panel_1.add(btnNewButton_36);
		JButton btnNewButton_37 = new JButton();
		panel_1.add(btnNewButton_37);
		JButton btnNewButton_38 = new JButton();
		panel_1.add(btnNewButton_38);
		JButton btnNewButton_39 = new JButton();
		panel_1.add(btnNewButton_39);
		JButton btnNewButton_40 = new JButton();
		panel_1.add(btnNewButton_40);
		JButton btnNewButton_41 = new JButton(title);
		panel_1.add(btnNewButton_41); 
		btnNewButton_41.setForeground(Color.RED);// <---- centre du plateau
		JButton btnNewButton_42 = new JButton();
		panel_1.add(btnNewButton_42);
		JButton btnNewButton_43 = new JButton();
		panel_1.add(btnNewButton_43);
		JButton btnNewButton_44 = new JButton();
		panel_1.add(btnNewButton_44);
		JButton btnNewButton_45 = new JButton();
		panel_1.add(btnNewButton_45);
		JButton btnNewButton_46 = new JButton();
		panel_1.add(btnNewButton_46);
		JButton btnNewButton_47 = new JButton();
		panel_1.add(btnNewButton_47);
		JButton btnNewButton_48 = new JButton();
		panel_1.add(btnNewButton_48);
		JButton btnNewButton_49 = new JButton();
		panel_1.add(btnNewButton_49);
		JButton btnNewButton_50 = new JButton();
		panel_1.add(btnNewButton_50);
		JButton btnNewButton_51 = new JButton();
		panel_1.add(btnNewButton_51);
		JButton btnNewButton_52 = new JButton();
		panel_1.add(btnNewButton_52);
		JButton btnNewButton_53 = new JButton();
		panel_1.add(btnNewButton_53);
		JButton btnNewButton_54 = new JButton();
		panel_1.add(btnNewButton_54);
		JButton btnNewButton_55 = new JButton();
		panel_1.add(btnNewButton_55);
		JButton btnNewButton_56 = new JButton();
		panel_1.add(btnNewButton_56);
		JButton btnNewButton_57 = new JButton();
		panel_1.add(btnNewButton_57);
		JButton btnNewButton_58 = new JButton();
		panel_1.add(btnNewButton_58);
		JButton btnNewButton_59 = new JButton();
		panel_1.add(btnNewButton_59);
		JButton btnNewButton_60 = new JButton();
		panel_1.add(btnNewButton_60);
		JButton btnNewButton_61 = new JButton();
		panel_1.add(btnNewButton_61);
		JButton btnNewButton_62 = new JButton();
		panel_1.add(btnNewButton_62);
		JButton btnNewButton_63 = new JButton();
		panel_1.add(btnNewButton_63);
		JButton btnNewButton_64 = new JButton();
		panel_1.add(btnNewButton_64);
		JButton btnNewButton_65 = new JButton();
		panel_1.add(btnNewButton_65);
		JButton btnNewButton_66 = new JButton();
		panel_1.add(btnNewButton_66);
		JButton btnNewButton_67 = new JButton();
		panel_1.add(btnNewButton_67);
		JButton btnNewButton_68 = new JButton();
		panel_1.add(btnNewButton_68);
		JButton btnNewButton_69 = new JButton();
		panel_1.add(btnNewButton_69);
		JButton btnNewButton_70 = new JButton();
		panel_1.add(btnNewButton_70);
		JButton btnNewButton_71 = new JButton();
		panel_1.add(btnNewButton_71);
		JButton btnNewButton_72 = new JButton();
		panel_1.add(btnNewButton_72);
		JButton btnNewButton_73 = new JButton();
		panel_1.add(btnNewButton_73);
		JButton btnNewButton_74 = new JButton();
		panel_1.add(btnNewButton_74);
		JButton btnNewButton_75 = new JButton();
		panel_1.add(btnNewButton_75);
		JButton btnNewButton_76 = new JButton();
		panel_1.add(btnNewButton_76);
		JButton btnNewButton_77 = new JButton();
		panel_1.add(btnNewButton_77);
		JButton btnNewButton_78 = new JButton();
		panel_1.add(btnNewButton_78);
		JButton btnNewButton_79 = new JButton();
		panel_1.add(btnNewButton_79);
		JButton btnNewButton_80 = new JButton();
		panel_1.add(btnNewButton_80);
		JButton btnNewButton_81 = new JButton();
		panel_1.add(btnNewButton_81);
		
		
		
		
		
		

		
	}

	private void color(ActionEvent event) {
		//btnNewButton_1.setBackground(Color.red);
		//new ColorCellEditor(); 
		this.dispose();
		
		

	}
	}

