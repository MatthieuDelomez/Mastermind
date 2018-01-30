package com.sdz.affichage;

import com.sdz.admin.Model;
import com.sdz.observation.Observable;

public class Main {

	public static void main(String[] args) {
		
		Observable model = new Model();
		Fenetre fen = new Fenetre(model);
		fen.setVisible(true);


	}

}
