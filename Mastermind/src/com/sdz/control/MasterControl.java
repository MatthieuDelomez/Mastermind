package com.sdz.control;

import com.sdz.model.*;

import com.sdz.vue.*;
import com.sdz.control.*;


/******************************MASTERMIND********************************/

/*************************************************************************
 * 
 * Pattern MVC - Classe permettant de controler et transférer
 * les données saisies par l'utilisateur associés au jeu Mastermind.
 * 
 * @author Delomez Matthieu
 *************************************************************************/


public class MasterControl {
	

	/**
	 * Modèle de données relatif au jeu Mastermind.
	 * @see DonneeMaster
	 */
	private DonneeMaster modelMaster;

	/**
	 * Constructeur de la classe MasterControler. 
	 * 
	 * @param modelMaster Modèle de données relatif au jeu.
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
	 * Méthode relative au mode Challenger qui permet de transférer la combinaison secrète de l'ordinateur au modèle.
	 * 
	 * @param propositionSecrete Combinaison secrète de l'ordinateur en mode challenger.
	 */
	public void setPropoSecreteCpuChallenger(String propoSecreteCpuChallenger) {
		this.modelMaster.setPropoSecreteCpuChallenger(propoSecreteCpuChallenger);
	}

	/**
	 * Méthode relative au mode Challenger qui permet de transférer la proposition du joueur au modèle.
	 * 
	 * @param propositionJoueur Proposition du joueur en mode challenger.
	 */
	public void setPropoManChallenger(String propoManChallenger) {
		this.modelMaster.setPropoManChallenger(propoManChallenger);
	}

	
	
	/* *************************************************************************************************
	 * 
	 ***************************METHODE RELATIVE AU MODE DEFENSEUR**************************************
	 * 
	 **************************************************************************************************/

	
	/**
	 * Méthode relative au mode Défenseur qui permet de transférer la combinaison secrète du joueur au modèle.
	 * 
	 * @param propositionSecrete Combinaison secrète du joueur en mode défenseur.
	 */
	public void setPropoSecreteManDefenseur(String propoSecreteManDefenseur) {
		this.modelMaster.setPropoSecreteManDefenseur(propoSecreteManDefenseur);
	}

	/**
	 * Méthode relative au mode Défenseur qui permet de transférer la réponse du joueur au modèle.
	 * 
	 * @param reponseJoueur Réponse du joueur en mode défenseur.
	 */
	public void setReponseManDefenseur(String reponseManDefenseur) {
		this.modelMaster.setReponseManDefenseur(reponseManDefenseur);
	}
	

	/* *************************************************************************************************
	 * 
	 *********************************METHODE RELATIVE AU MODE DUEL*************************************
	 * 
	 **************************************************************************************************/
	

	/**
	 * Méthode relative au mode Duel qui permet de transférer la combinaison secrète de l'ordinateur au modèle.
	 * @param propositionSecrete Combinaison secrète de l'ordinateur en mode duel.
	 */
	public void setPropoSecreteCpuDuel(String propoSecreteCpuDuel) {
		this.modelMaster.setPropoSecreteCpuDuel(propoSecreteCpuDuel);
	}

	/**
	 * Méthode relative au mode Duel qui permet de transférer la combinaison secrète du joueur au modèle.
	 * @param propositionSecrete Combinaison secrète du joueur en mode duel.
	 */
	public void setPropoSecreteManDuel(String propoSecreteManDuel) {
		this.modelMaster.setPropoManDuel(propoSecreteManDuel);
	}

	/**
	 * Méthode relative au mode Duel qui permet de transférer la proposition du joueur au modèle.
	 * @param propositionJoueur Proposition du joueur en mode duel.
	 */
	public void setPropoManDuel(String propoManDuel) {
		this.modelMaster.setPropoManDuel(propoManDuel);
	}

	/**
	 * Méthode relative au mode Duel qui permet de transférer la réponse du joueur au modèle.
	 * @param reponseJoueur Réponse du joueur en mode duel.
	 */
	public void setReponseManDuel(String reponseManDuel) {
		this.modelMaster.setReponseManDuel(reponseManDuel);
	}

	
	/* *************************************************************************************************
	 * 
	 **********************************METHODE RELATIVE A TOUT MODE*************************************
	 * 
	 **************************************************************************************************/

	
	/**
	 * Méthode commune à tous les modes de jeu qui permet de transférer le mode de jeu au modèle.
	 * @param modeJeu - Challenger = 0, Defenseur = 1, Duel = 2.
	 */
	public void setModeJeu(int modeJeu) {
		this.modelMaster.setModeJeu(modeJeu);
	}

	/**
	 * Méthode commune à tous les modes de jeu qui permet de transférer le nombre d'essais au modèle.
	 * @param nbEssais Nombre d'essais.
	 */
	public void setNbEssai(int nbEssai) {
		this.modelMaster.setNbEssai(nbEssai);
	}

	/**
	 * Méthode commune à tous les modes de jeu qui permet de transférer le nombre de cases au modèle.
	 * @param nbreCases - Nombre de cases 
	 */
	public void setNbCase(int nbCase) {
		this.modelMaster.setNbCase(nbCase);
	}

	/**
	 * Méthode commune à tous les modes de jeu qui permet de transférer le nombre de couleurs utilisables au modèle.
	 * @param nbrCouleurs - Nombre de couleurs utilisables 
	 */
	public void setNbCouleur(int nbCouleur) {
		this.modelMaster.setNbCouleur(nbCouleur);
	}

	/**
	 * Méthode commune à tous les modes de jeu qui permet de transférer le choix du joueur en fin de partie au modèle.
	 * @param choixFinPartie Choix du joueur en fin de partie.
	 */
	public void setChoixFinPartie(String choixFinPartie) {
		this.modelMaster.setChoixFinPartie(choixFinPartie);
	}
}