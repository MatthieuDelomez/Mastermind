package com.sdz.affichage;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;

// Classe fille héritant des propri de la classe Contenant

public class PageAccueil extends Contenant {
	
	public PageAccueil(Dimension dim) {
		
		super(dim); // Appel de la Méthode dans le constructeur
		           // de la classe Contenant
		
		initPanel();
	}
	
	// Initialisation du Panel de la page d'accueil
	
	public void initPanel() {
		
		JLabel titre = new JLabel("Bienvenue dans le jeu du MasterMind\n\n");
		titre.setHorizontalAlignment(JLabel.CENTER);
		titre.setFont(arial);
		this.panel.add(titre, BorderLayout.NORTH);
		
		JTextArea textePresentation = new JTextArea("Vous aurez le choix entre : \n\n" +
				
				". Mode challenger : Est de trouver la combinaison choisit par l'ordinateur\n" +
				
				". Mode défenseur : Etablir votre combinaison afin que l'ordinateur tente de déchiffrer votre combinaison\n" +
				
				". Mode duel : Jouer dans un duel sans merci chacun votre tour\n\n\n" +
				
				"...............................................Bonne chance..........................................");
	
	
		textePresentation.setFont(arial);
		textePresentation.setEditable(false);
		textePresentation.setBackground(Color.white);
		
		this.panel.add(textePresentation, BorderLayout.CENTER);
		
		
	}

}
