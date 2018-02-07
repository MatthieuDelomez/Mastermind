package com.sdz.control;

import com.sdz.model.*;
import com.sdz.vue.*;
import com.sdz.control.*;


/******************************MASTERMIND********************************/

/*************************************************************************
 * 
 * Pattern MVC - Classe permettant de controler et transf�rer
 * les donn�es saisies par l'utilisateur associ�s au jeu Mastermind.
 * 
 * @author Delomez Matthieu
 *************************************************************************/


public class MasterControl {
	

	/**
	 * Mod�le de donn�es relatif au jeu Mastermind.
	 * @see DonneeMaster
	 */
	private DonneeMaster modelMaster;

	/**
	 * Constructeur de la classe MasterControler. 
	 * 
	 * @param modelMaster Mod�le de donn�es relatif au jeu.
	 */
	public MasterControl(DonneeMaster modelMaster) {
		this.modelMaster = modelMaster;
	}

	
	
	/* *************************************************************************************************
	 * 
	 ***************************METHODE RELATIVE AU MODE CHALLENGER*************************************
	 * 
	 **************************************************************************************************/
	
	
	/**
	 * M�thode relative au mode Challenger qui permet de transf�rer la combinaison secr�te de l'ordinateur au mod�le.
	 * 
	 * @param propositionSecrete Combinaison secr�te de l'ordinateur en mode challenger.
	 */
	public void setProposiSecreteCpuChallenger(String proposiSecrete) {
		this.modelMaster.setProposiSecreteCpuChallenger(proposiSecrete);
	}

	/**
	 * M�thode relative au mode Challenger qui permet de transf�rer la proposition du joueur au mod�le.
	 * 
	 * @param propositionJoueur Proposition du joueur en mode challenger.
	 */
	public void setProposiManChallenger(String propositionJoueur) {
		this.modelMaster.setProposiManChallenger(propositionJoueur);
	}

	
	
	/* *************************************************************************************************
	 * 
	 ***************************METHODE RELATIVE AU MODE DEFENSEUR**************************************
	 * 
	 **************************************************************************************************/

	
	/**
	 * M�thode relative au mode D�fenseur qui permet de transf�rer la combinaison secr�te du joueur au mod�le.
	 * 
	 * @param propositionSecrete Combinaison secr�te du joueur en mode d�fenseur.
	 */
	public void setProposiSecreteManDefenseur(String proposiSecrete) {
		this.modelMaster.setProposiSecreteManDefenseur(proposiSecrete);
	}

	/**
	 * M�thode relative au mode D�fenseur qui permet de transf�rer la r�ponse du joueur au mod�le.
	 * 
	 * @param reponseJoueur R�ponse du joueur en mode d�fenseur.
	 */
	public void setReponseManDefenseur(String reponseJoueur) {
		this.modelMaster.setReponseManDefenseur(reponseJoueur);
	}
	

	/* *************************************************************************************************
	 * 
	 *********************************METHODE RELATIVE AU MODE DUEL*************************************
	 * 
	 **************************************************************************************************/
	

	/**
	 * M�thode relative au mode Duel qui permet de transf�rer la combinaison secr�te de l'ordinateur au mod�le.
	 * @param propositionSecrete Combinaison secr�te de l'ordinateur en mode duel.
	 */
	public void setProposiSecreteCpuDuel(String propositionSecrete) {
		this.modelMaster.setProposiSecreteCpuDuel(propositionSecrete);
	}

	/**
	 * M�thode relative au mode Duel qui permet de transf�rer la combinaison secr�te du joueur au mod�le.
	 * @param propositionSecrete Combinaison secr�te du joueur en mode duel.
	 */
	public void setProposiSecreteManDuel(String propositionSecrete) {
		this.modelMaster.setProposiManDuel(propositionSecrete);
	}

	/**
	 * M�thode relative au mode Duel qui permet de transf�rer la proposition du joueur au mod�le.
	 * @param propositionJoueur Proposition du joueur en mode duel.
	 */
	public void setProposiManDuel(String propositionJoueur) {
		this.modelMaster.setProposiManDuel(propositionJoueur);
	}

	/**
	 * M�thode relative au mode Duel qui permet de transf�rer la r�ponse du joueur au mod�le.
	 * @param reponseJoueur R�ponse du joueur en mode duel.
	 */
	public void setReponseManDuel(String reponseJoueur) {
		this.modelMaster.setReponseManDuel(reponseJoueur);
	}

	
	/* *************************************************************************************************
	 * 
	 **********************************METHODE RELATIVE A TOUT MODE*************************************
	 * 
	 **************************************************************************************************/

	
	/**
	 * M�thode commune � tous les modes de jeu qui permet de transf�rer le mode de jeu au mod�le.
	 * @param modeJeu - Challenger = 0, Defenseur = 1, Duel = 2.
	 */
	public void setModeJeu(int modeJeu) {
		this.modelMaster.setModeJeu(modeJeu);
	}

	/**
	 * M�thode commune � tous les modes de jeu qui permet de transf�rer le nombre d'essais au mod�le.
	 * @param nbEssais Nombre d'essais.
	 */
	public void setNbEssai(int nbEssai) {
		this.modelMaster.setNbEssai(nbEssai);
	}

	/**
	 * M�thode commune � tous les modes de jeu qui permet de transf�rer le nombre de cases au mod�le.
	 * @param nbreCases - Nombre de cases 
	 */
	public void setNbCase(int nbCase) {
		this.modelMaster.setNbCase(nbCase);
	}

	/**
	 * M�thode commune � tous les modes de jeu qui permet de transf�rer le nombre de couleurs utilisables au mod�le.
	 * @param nbrCouleurs - Nombre de couleurs utilisables 
	 */
	public void setNbCouleur(int nbCouleur) {
		this.modelMaster.setNbCouleur(nbCouleur);
	}

	/**
	 * M�thode commune � tous les modes de jeu qui permet de transf�rer le choix du joueur en fin de partie au mod�le.
	 * @param choixFinPartie Choix du joueur en fin de partie.
	 */
	public void setChoixFinPartie(String choixFinPartie) {
		this.modelMaster.setChoixFinPartie(choixFinPartie);
	}
}