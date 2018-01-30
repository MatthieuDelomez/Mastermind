package com.sdz.admin;

import java.io.Serializable;
import java.awt.Component;
import java.io.*;


public class Score implements Serializable {
	
	private String essai;
	private int point, pointMarque;
	private int nbreCode;
	
	
	public Score() {
		
		essai = new String("....");
		point = 0;
		nbreCode = 0;
	}
	
	public Score(String essai, int point, int nbreCode) {
		
		this.essai = essai;
		this.point = point;
		this.nbreCode = nbreCode;
	}
	
	public int getPoint() {
		
		return point;
	}
	
	public void initPoint(int nbErreur) {
		
		switch(nbErreur) {
		
		case 0 : 
			
			this.point += 100;
			this.pointMarque =100;
			break;
			
        case 1:
			
			this.point += 90;
			this.pointMarque = 90;
			break;
			
		case 2:
			
			this.point += 85;
			this.pointMarque = 85;
			break;
			
		case 3:
			
			this.point += 80;
			this.pointMarque = 80;
			break;
			
		case 4:
			
			this.point += 75;
			this.pointMarque = 75;
			break;
			
		case 5: 
			
			this.point += 70;
			this.pointMarque = 70;
			break;
			
		case 6 : 
			
			this.point += 65;
			this.pointMarque = 65;
			break;
			
		case 7 : 
			
			this.point += 60;
			this.pointMarque = 60;
			break;
			
		case 8 : 
			
			this.point += 55;
			this.pointMarque = 55;
			break;
				
		case 9 : 
				
				this.point += 50;
				this.pointMarque = 50;
				break;
				
		case 10 : 
			
			this.point += 45;
			this.pointMarque = 45;
			break;
			
		case 11 : 
			
			this.point += 40;
			this.pointMarque = 40;
			break;
			
		case 12 : 
			
			this.point += 35;
			this.pointMarque = 35;
			break;
			
		case 13 : 
			
			this.point += 30;
			this.pointMarque = 30;
			break;
			
			
		case 14 : 
			
			this.point += 25;
			this.pointMarque = 25;
			break;
			
		case 15 : 
			
			this.point += 20;
			this.pointMarque = 20;
			break;
			
		case 16 : 
			
			this.point += 15;
			this.pointMarque = 15;
			break;
			
		case 17 : 
			
			this.point += 10;
			this.pointMarque = 10;
			break;
			
		default :

			
				this.point += 0;
		}
	}
	
	public String getNom() {
		
		return essai;
	}
	
	public void setNom(String essai) {
		
		this.essai = (essai != null) ? essai : "....";
		
	}

	public int setNombreCode(int nbre) {
		
		return this.nbreCode;
	}
	
	public int getNombreCode() {
		
		return this.nbreCode;
	}
	
	public String toString() {
		
		return " " + essai + " ! " + point + " pts "
				
                         + ((nbreCode > 1) ? "s" : "") + ")";
	}
	
	public int getPointMarque() {
		
		return pointMarque;
	}
	
	
	
	
}
