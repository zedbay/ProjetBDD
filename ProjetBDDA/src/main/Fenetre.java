package main;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Fenetre extends JFrame{
	
	private JButton bouton = new JButton("		");
	private JPanel conteneur = new JPanel();
	private JTextField champ = new JTextField("		");
	
	
	Fenetre(){
		JFrame fenetre = new JFrame();
		setSize(800, 450);
		setTitle("Mini SGBD");
		setResizable(false);
		setLocationRelativeTo(null);
		champ.setPreferredSize(new Dimension(700,50));
		
		conteneur.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		conteneur.add(champ);
		conteneur.add(bouton);
		setContentPane(conteneur);
	}
}
