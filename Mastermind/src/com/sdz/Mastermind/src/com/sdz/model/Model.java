package com.sdz.model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.sdz.observation.Observable;
import com.sdz.observation.Observer;

public class Model implements Observable  {

	private Score score;
	private Code code;
	private ScoreSerializer scoreSerializer;
	private ArrayList<Observer> listObserver = 
			
			new ArrayList<Observer>();
	
	private int nombreCode = 0;
	
	
	public Model() {
		
		this.score = new Score();
		this.code = new Code();
		this.scoreSerializer = new ScoreSerializer();
	}
	
	public Score getScore() {
		
		return score;
	}
	
	public Code getCode() {
		
		return code;
	}
	
	public void assign(int c) {
		
		if(this.code.verifyCode(c) != -1) {
			
			if(this.code.isFinished()) {
				
				this.score.initPoint(this.code.getNombreErreur());
				this.score.setNombreCode(this.score.getNombreCode() +1);
				
				JOptionPane.showConfirmDialog(null, " Vous avez trouvé " + 
				
						this.code.getCode() + " en " + 
						
						this.code.getNombreCoup() + " coup" + 
						
						((this.code.getNombreCoup() > 1) ? "s" : "")
						
						+ ".\n" + "\tVous marquez donc" +
						
						this.score.getPointMarque() + "pts.\n" +
						
						"\tVotre total de point est de : " +
						
						this.score.getPoint() + " pts.",
						
						"Resulat",
						
						JOptionPane.INFORMATION_MESSAGE);
				
				this.code.initCode();
				this.code.setNombreErreur(0);
				this.nombreCode++;
				
				this.restartObserver();
				
			}
			
			    this.notifyObserver();
				
				
				
			}
		
		else {
			
			this.code.setNombreErreur(this.code.getNombreErreur() +1);
			
			this.notifyObserver();
			
			if(this.code.getNombreErreur() == 18) {
				
				JOptionPane.showConfirmDialog(null,  "Le code était : "
						
						+ this.code.getCode(),
						
						"Vous avez perdu" , JOptionPane.NO_OPTION);
				
				if( this.scoreSerializer.isAccpeted(this.score)) {
					
					String nom = "";
					
					nom = (String)JOptionPane.showInputDialog(null,
							
							"Entrez votre blase : ", "Félicitation, vous êtes dans le top 10",
							
							JOptionPane.QUESTION_MESSAGE);
					
					this.score.setNom(nom);
					this.scoreSerializer.serialize();
					this.scoreObserver();
							
				}
				
				else {
					
					JOptionPane.showMessageDialog(null, 
							
							"Désolé vous avez perdu !", "donc", 
							
							JOptionPane.NO_OPTION, null );
					
					this.accueilObserver();
				}
			}
			
			else {
				
				this.notifyObserver();
			}
		}
	}
	
	public void assign(int [] c) {
		
		if(this.code.verifyCode(c) != -1) {
			
			if(this.code.isFinished()) {
				
				this.score.initPoint(this.code.getNombreErreur());
				
				this.score.setNombreCode(this.score.getNombreCode() +1);
			
				JOptionPane.showConfirmDialog(null, 
						
						"Vous avez trouvé le mot" + this.code.getCode() +
						
						" en " +
						
						this.code.getNombreCoup() + " coup" +
						
						((this.code.getNombreCoup() >  1) ? "s" : "" ) +
						
						", avec" + this.code.getNombreErreur() +
						
						" erreur" + ((this.code.getNombreErreur() > 1) ? "s" :"") + ".\n" +
						
						"\tVous marquez donc " +
						
						this.score.getPointMarque() + "pts.\n" +
						
						"\tVous avez un total de" +
						
						this.score.getPoint() + "pts.",
						
						"Resultat",
						
						JOptionPane.INFORMATION_MESSAGE);
				
				this.code.initCode();
				this.code.setNombreErreur(0);
				this.nombreCode++;
				this.restartObserver();
			}
			
			else {
				
				this.notifyObserver();
			}}
			
			else {
				
				this.code.setNombreErreur(this.code.getNombreErreur() +1);
				this.notifyObserver();
				
				if(this.code.getNombreErreur() == 18) {
					
					JOptionPane.showMessageDialog(null, "Le mot était :\n\t"
							
							+ this.code.getCode(),
							
							"Vous avez perdu !", JOptionPane.NO_OPTION);
				
				if(this.scoreSerializer.isAccpeted(this.score)) {
					
					String nom = "";
					nom = (String) JOptionPane.showInputDialog(null,
							
							"Entrez votre pseudo :",
							
							"Félicitations",
							
							JOptionPane.QUESTION_MESSAGE);
					
					this.score.setNom(nom);
					this.scoreSerializer.serialize();
					this.scoreObserver();
				}
				
				else {
					
					JOptionPane.showConfirmDialog(null, "Désolé vous avez perdu\n"
							
							+ "\n\n\tVous n'avez malheuresement pas assez de point pour enregistrer votre score.\n "
							
							+ "Retentez votre chance !",
							
							"Vous avez perdu", JOptionPane.NO_OPTION);
					
					this.accueilObserver();
				}
				
				this.code.initCode();
				this.code.setNombreErreur(0);
				
				}
				
				else {
					
					this.notifyObserver();
				}
				
				
			}
		}
		
		public void reset() {
			
			this.code.initCode();
			this.code.setNombreErreur(0);
			this.nombreCode = 0;
			this.score = new Score();
			
		}
		
		public void addObserver(Observer obs) {
			
			this.listObserver.add(obs);
			this.notifyObserver();
		}
		
		
		public void deleteObserver() {
			
			this.listObserver = new ArrayList<Observer>();
		}
		
		public void notifyObserver() {
			
			for(Observer obs : this.listObserver)
				
				obs.update(this.code.getSecretCode(), this.score.getPoint(), this.nombreCode);
			
			
		}
		
		public void restartObserver() {
			
			for(Observer obs : this.listObserver)
				obs.restart(this.code.getSecretCode());
		}
		
		public void scoreObserver() {
			
			for(Observer obs : this.listObserver)
				obs.showsScore(this.scoreSerializer.getListeScore());
			
		}
		
		public void accueilObserver() {
			
			for(Observer obs : this.listObserver)
				obs.accueil();
		}
		
		public Score[] getScores() {
			
			return this.scoreSerializer.getListeScore();
		}
	}
