package com.sdz.admin;

import java.io.File;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Random;

import javax.swing.JOptionPane;

public class Code {
	
	Random rad = new Random();
	
	private String code = "";
	private int secretCode = 0000 + (int)(Math.random() * ((0000 - 9999) + 1)); // Formule a vérifier
	private int [] tabInt;
	private int error = 0;
	private int nbreCoup = 0;
	
	public Code() {
		
		initCode();
	}
	
	public void initCode() {
		
		int i = (int) (Math.random() * 100000);
		while(i > 336529) {
			
			i/=2;
		}
		
	
			int chiffre; // Vérif
			this.code = "";
			this.secretCode = 0000 + (int)(Math.random() * ((0000 - 9999) + 1));
		
			/*
			
			while((carac = fnr.read()) != -1) {
				
				if(fnr.getLineNumber() == (i+1))
					
					break;
				
				else {
					
					if(fnr.getLineNumber() ==i) {
						
						this.code += (int)carac;
					}
				}
			}
			
			
		
			this.code = this.code.trim().toUpperCase();
			
			for(int j = 0; j < this.code.length(); j++) {
				
				this.secretCode += (this.code.charAt(j) !=
						
						'\'' && this.code.charAt(j) != '-') ? 
								
								"*" : this.code.charAt(j);
			
			
			fnr.close();
			
			*/
			
			
			this.nbreCoup =0;
			
			
			/*
			
        } catch (FileNotFoundException e) {
			
			JOptionPane.showMessageDialog(null, "Erreur de chargement depuis le fichier de mots !", "ERREUR", JOptionPane.ERROR_MESSAGE);

		} catch (IOException e) {
			
			JOptionPane.showMessageDialog(null, "Erreur de chargement depuis le fichier de mots !", "ERREUR", JOptionPane.ERROR_MESSAGE);

		} */
		
			
        this.tabInt = this.secretCode.toCharArray(); // équivalent en int ??
		this.error = 0;	
		
	}
	
	public int verifyCode(int c) {
		
		boolean bok = false;
		
		for(int i =0; i < this.code.length(); i++) {
			
			if(this.code.toUpperCase().indexOf(i) == c) { // IndexOf ou charat ??
				
				this.tabInt[i] = c;
				bok =true;
		}
		
		}
		
		
		++this.nbreCoup;
		this.secretCode = new String (this.tabInt); /// ???
		System.out.println("Code Secret = " + this.code);
		return( bok == true) ? 1 : -1;

		
	}
	
	public int verifyCode(int[] tc) {
		
		boolean bok = false;
		
		for(int c : tc) {
			
			for (int i = 0; i< this.code.length(); i++) {
				
				if(this.code.toUpperCase().indexOf(i) ==c) { // indexOf ou charat
				this.tabInt[i] = c;
				System.out.println("OK !");
                bok =true;
				
			}
		}
	}
	
	
	return(bok == true) ?1 : -1;
	
}

public boolean isFinished() {
	
	for(int c : this.tabInt) {
		
		if(c == '*')
			
			return false;
	}
	
	return true;
	
}

public String getCode() { // A voir si String ou int ??!
	
	return code; // Return String en Int ??
	
}

public int getSecretCode() {
	
	return secretCode;
}


public int getNombreErreur() {

return this.error;

}

public void setNombreErreur(int nbre) {
	
	this.error = nbre;
	
}

public int getNombreCoup() {
	
	return nbreCoup;


}
	}
