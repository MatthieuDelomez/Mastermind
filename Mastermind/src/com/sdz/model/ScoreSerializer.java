package com.sdz.model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;


public class ScoreSerializer {

	// Initialiser ue liste de score avec les 10 meilleurs scores
	
	private Score[] listeScore = new Score [10];
	
	
	public ScoreSerializer() {
		
		try {
			
			File file = new File("file/score.scr");
			
			if(file.length() > 0) {
				
				ObjectInputStream ois = new ObjectInputStream(
						
						new BufferedInputStream(
								
								new FileInputStream(
										
										file)));
				
				listeScore = (Score[]) ois.readObject();
				ois.close();
			}
			
			// Config pour l'enregistrement du score
			
			else {
				
				System.out.println("On passe dans le else");
				
				for(int i = 0; i < 10; i++) {
			
					listeScore[i] = new Score();
				
				}
		}
		} catch (FileNotFoundException e) {
			
			JOptionPane.showConfirmDialog(null, "Erreur de chargement dans le fichier des scores :\n" + e.getCause()+"\n", "ERREUR", JOptionPane.ERROR_MESSAGE);
			
		} catch (IOException e) {
			
			JOptionPane.showConfirmDialog(null, "Erreur de chargement dans le fichier des scores :\n" + e.getCause()+"\n", "ERREUR", JOptionPane.ERROR_MESSAGE);

		} catch (ClassNotFoundException e) {
			
			JOptionPane.showConfirmDialog(null, "Erreur de chargement dans le fichier des scores :\n" + e.getCause()+"\n", "ERREUR", JOptionPane.ERROR_MESSAGE);
			
			
			
	}
}
	
	
	public boolean isAccpeted(Score score) {
		
		boolean bok = false;
		
		for( int i = 0; i < listeScore.length; i++) {
			
			Score scr = new Score();
			
			scr = listeScore[i];
			
			System.out.println("Score :" + scr.toString());
			
			if(score.getPoint() >= scr.getPoint()) {
				
				bok =true;
				listeScore[i] = score;
				score = scr;
			}

		}
		
		return bok;
	}
	
	
	public void serialize() {
		
		try {
			
			ObjectOutputStream oos = new ObjectOutputStream(
					
					new BufferedOutputStream(
							
							new FileOutputStream(
									
									new File("file/score.scr"))));
			
			oos.writeObject(listeScore);
			oos.close();
			
		}catch (FileNotFoundException e) {
			
			JOptionPane.showConfirmDialog(null, "Erreur de chargement dans le fichier des scores :\n" + e.getCause()+"\n", "ERREUR", JOptionPane.ERROR_MESSAGE);

		} catch (IOException e) {
			
			JOptionPane.showConfirmDialog(null, "Erreur de chargement dans le fichier des scores :\n" + e.getCause()+"\n", "ERREUR", JOptionPane.ERROR_MESSAGE);

		}
		}
	
	
	public Score[] getListeScore() {
		
		return this.listeScore;
	}
}