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
				        "\nVous avez [?] coups pour trouver le code cach�.\n" +
				        "Si vous r�ussissez, on recommence !\n" +
						"Plus vous trouvez de codes, plus votre score augmente. Alors, � vous de jouer !\n" +
						"\n\nBut du jeu :"
						+ "\nd�couvrir la combinaison � x chiffres/couleurs de l'adversaire (le d�fenseur).\n" +
						"\nPour ce faire, l'attaquant fait une proposition." +
						"\nLe d�fenseur indique pour chaque proposition le nombre de chiffre/couleur\n" +
						"de la proposition qui apparaissent � la bonne place et � la mauvaise place dans la combinaison secr�te.\n\n\n" +
						"L'attaquant doit deviner la combinaison secr�te en un nombre limit� d'essais.\n" +
						
						"Proposition : 4278 -> R�ponse : 1 pr�sent, 1 bien plac�\n" + 
						"Proposition : 6274 -> R�ponse : 2 bien plac�s");
				
				accueil.setFont(arial);
				accueil.setEditable(false);
				
	}

}
