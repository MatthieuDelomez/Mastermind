package com.sdz.vue;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


/******************************MASTERMIND********************************/

/*************************************************************************
 * Classe qui s'inscrit donc dans la partie VUE du pattern MVC, boite de 
 * dialogue qui permet au joueur de relancer la partie ou retourner sur 
 * la page d'accueil.
 *
 * @author Matthieu Delomez
 * 
 *************************************************************************/


public class BoiteDialogueEndOfTheGame extends JDialog{
	
	/**
	 * Chois possible pour le joueur en fin de Game : 
	 *       . Relancer la partie.
	 *       . Retourner à la page d'accueil.
	 *       . Quitter l'application.
	 */
	
	private String choixFinPartie = ""; // Initialisation
	
	
	/**
	 * JRadioButton qui est égal à un choix.
	 */
	private JRadioButton Rejouer = new JRadioButton("Rejouer au même jeu"),
			
			RetourPageAccueil = new JRadioButton("Selectionner un autre mode de jeu"),
			
			QuitterAppli = new JRadioButton("Quitter l'application");
	
	
	/**
	 * Button Group qui regroupe les JRadioButton.
	 */
	private ButtonGroup regroupeChoix = new ButtonGroup();

	
	/**
	 * Label contenant Message informatif.
	 */
	private JLabel messageInfo = new JLabel("Vous avez le choix entre :");
	
	
	/**
	 * JPanel principal de la classe contenant les composants
	 * du message et aux choix en fin de game.
	 */
	private JPanel container = new JPanel();
	
	
	/**
	 * JPanel contenant le JBUtton de validation.
	 */
	private JPanel jpButton = new JPanel();
	
	
	/**
	 * JButton de validation.
	 */
	private JButton boutonOk = new JButton("OK");
	
	
	/* *************************************************************************************************
	 * 
	 ******************************************CONSTRUCTEUR*********************************************
	 * 
	 **************************************************************************************************/
	
	
	public BoiteDialogueEndOfTheGame(JFrame parent, String title, boolean modalite) {
		super(parent, title, modalite);
		this.setSize(200,180);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.initComponent();
		this.showDialog(true);
		
	}
	
	/**
	 * Méthode qui permet de créer l'interface de la boite de dialogue.
	 */
	private void initComponent() {
		
		regroupeChoix.add(Rejouer);
		regroupeChoix.add(RetourPageAccueil);
		regroupeChoix.add(QuitterAppli);
		
		Rejouer.setSelected(true);
		
		container.add(messageInfo);
		container.add(Rejouer);
		container.add(RetourPageAccueil);
		container.add(QuitterAppli);
		jpButton.add(boutonOk);
		
		
		this.getContentPane().add(container, BorderLayout.CENTER);
		this.getContentPane().add(container, BorderLayout.SOUTH);
		
		
		
		/**
		 * Définition des listeners.
		 */
		boutonOk.addActionListener(new ActionListener() {
			String strChoix = "";
			
			public void actionPerformed(ActionEvent event) {
				if(Rejouer.isSelected()) {
					strChoix = Rejouer.getText().trim();
				}
				
				else if(RetourPageAccueil.isSelected()) {
					strChoix = RetourPageAccueil.getText().trim();
				}
				
				else {
					strChoix = QuitterAppli.getText().trim();
				}
				
				setChoixFinPartie(strChoix);
				showDialog(false);
			}
		});
		
	}
	
	
	/**
	 * Rendre la boite de dialogue visible
	 */
	private void showDialog(boolean affichage) {
		this.setVisible(affichage);
	}
	
	
	/* *************************************************************************************************
	 * 
	 ******************************************MUTATEUR*********************************************
	 * 
	 **************************************************************************************************/
	
	
	/**
	 * 	Permet de modifier le choix effectué par le joueur à la fin de la partie.
	 */
	public void setChoixFinPartie(String choixFinPartie) {
		this.choixFinPartie = choixFinPartie;
	}
	
	
	/* *************************************************************************************************
	 * 
	 ******************************************ACCESSEUR*********************************************
	 * 
	 **************************************************************************************************/
	
	
	/**
	 * Permet de récupérer le choix du joueur en fin de partie.
	 */
	public String getChoixFinPartie() {
		return this.choixFinPartie;
	}

}
