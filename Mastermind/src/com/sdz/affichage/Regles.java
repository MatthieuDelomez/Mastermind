package com.sdz.affichage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class Regles extends Contenant {
	
	public Regles(Dimension dim) {
		
		super(dim);
		initPanel();
	}
	
	
	public void initPanel() {
		/*
		JLabel titre = new JLabel();
		titre.setFont(arial);
		titre.setText("Mastermind");
		titre.setHorizontalAlignment(JLabel.CENTER);
		
		this.panel.add(titre, BorderLayout.CENTER);
		*/
		
		JTextArea accueil = new JTextArea();
		accueil.setBackground(Color.white);
		this.panel.add(accueil, BorderLayout.SOUTH);


		accueil.setText(
				
				        "Mastermind\n\n " +
				        "\nVous avez [?] coups pour trouver le code caché.\n" +
				        "Si vous réussissez, on recommence !\n" +
						"Plus vous trouvez de codes, plus votre score augmente. Alors, à vous de jouer !\n" +
						"\n\nBut du jeu :"
						+ "\ndécouvrir la combinaison à x chiffres/couleurs de l'adversaire (le défenseur).\n" +
						"\nPour ce faire, l'attaquant fait une proposition." +
						"\nLe défenseur indique pour chaque proposition le nombre de chiffre/couleur\n" +
						"de la proposition qui apparaissent à la bonne place et à la mauvaise place dans la combinaison secrète.\n\n\n" +
						"L'attaquant doit deviner la combinaison secrète en un nombre limité d'essais.\n" +
						
						"Proposition : 4278 -> Réponse : 1 présent, 1 bien placé\n" + 
						"Proposition : 6274 -> Réponse : 2 bien placés");
				
				accueil.setFont(arial);
				accueil.setEditable(false);
				
	}

}
