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
 *************************************************************************/


public class MasterControl {
	

	/**
	 * Modèle de données relatif au jeu Mastermind.
	 */
	private DonneesMastermind donneesMastermind;

	/**
	 * Constructeur de la classe MasterControler. 
	 */
	public MastermindControler(ModeleDonneesMastermind modelMastermind) {
		this.donneesMastermind = modelMastermind;
	}

	
	
	/* *************************************************************************************************
	 * 
	 ***************************METHODE RELATIVE AU MODE CHALLENGER*************************************
	 * 
	 **************************************************************************************************/
	
	
	/**
	 * Méthode relative au mode Challenger qui permet de transférer la combinaison secrète de l'ordinateur au modèle.
	 * @param propositionSecrete Combinaison secrète de l'ordinateur en mode challenger.
	 */
	public void setProposiSecreteCpuChallenger(String proposiSecrete) {
		this.donneesMastermind.setProposiSecreteCpuChallenger(proposiSecrete);
	}

	/**
	 * Méthode relative au mode Challenger qui permet de transférer la proposition du joueur au modèle.
	 * @param propositionJoueur Proposition du joueur en mode challenger.
	 */
	public void setProposiManChallenger(String propositionJoueur) {
		this.donneesMastermind.setProposiManChallenger(propositionJoueur);
	}

	
	
	/* *************************************************************************************************
	 * 
	 ***************************METHODE RELATIVE AU MODE DEFENSEUR**************************************
	 * 
	 **************************************************************************************************/

	
	/**
	 * Méthode relative au mode Défenseur qui permet de transférer la combinaison secrète du joueur au modèle.
	 * @param propositionSecrete Combinaison secrète du joueur en mode défenseur.
	 */
	public void setProposiSecreteManDefenseur(String proposiSecrete) {
		this.donneesMastermind.setProposiSecreteManDefenseur(proposiSecrete);
	}

	/**
	 * Méthode relative au mode Défenseur qui permet de transférer la réponse du joueur au modèle.
	 * @param reponseJoueur Réponse du joueur en mode défenseur.
	 */
	public void setReponseManDefenseur(String reponseJoueur) {
		this.donneesMastermind.setReponseManDefenseur(reponseJoueur);
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
	public void setProposiSecreteCpuDuel(String propositionSecrete) {
		this.donneesMastermind.setProposiSecreteCpueDuel(propositionSecrete);
	}

	/**
	 * Méthode relative au mode Duel qui permet de transférer la combinaison secrète du joueur au modèle.
	 * @param propositionSecrete Combinaison secrète du joueur en mode duel.
	 */
	public void setProposiSecreteManDuel(String propositionSecrete) {
		this.donneesMastermind.setPropositionManDuel(propositionSecrete);
	}

	/**
	 * Méthode relative au mode Duel qui permet de transférer la proposition du joueur au modèle.
	 * @param propositionJoueur Proposition du joueur en mode duel.
	 */
	public void setProposiManDuel(String propositionJoueur) {
		this.donneesMastermind.setProposiManDuel(propositionJoueur);
	}

	/**
	 * Méthode relative au mode Duel qui permet de transférer la réponse du joueur au modèle.
	 * @param reponseJoueur Réponse du joueur en mode duel.
	 */
	public void setReponseManDuel(String reponseJoueur) {
		this.donneesMastermind.setReponseManDuel(reponseJoueur);
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
		this.donneesMastermind.setModeJeu(modeJeu);
	}

	/**
	 * Méthode commune à tous les modes de jeu qui permet de transférer le nombre d'essais au modèle.
	 * @param nbEssais Nombre d'essais.
	 */
	public void setNbrEssais(int nbrEssais) {
		this.donneesMastermind.setNbrEssais(nbrEssais);
	}

	/**
	 * Méthode commune à tous les modes de jeu qui permet de transférer le nombre de cases au modèle.
	 * @param nbreCases - Nombre de cases 
	 */
	public void setNbreCases(int nbreCases) {
		this.donneesMastermind.setNbreCases(nbreCases);
	}

	/**
	 * Méthode commune à tous les modes de jeu qui permet de transférer le nombre de couleurs utilisables au modèle.
	 * @param nbrCouleurs - Nombre de couleurs utilisables 
	 */
	public void setNbrCouleur(int nbrCouleurs) {
		this.donneesMastermind.setNbrCouleur(nbrCouleurs);
	}

	/**
	 * Méthode commune à tous les modes de jeu qui permet de transférer le choix du joueur en fin de partie au modèle.
	 * @param choixFinPartie Choix du joueur en fin de partie.
	 */
	public void setChoixFinPartie(String choixFinPartie) {
		this.donneesMastermind.setChoixFinDePartie(choixFinPartie);
	}
}