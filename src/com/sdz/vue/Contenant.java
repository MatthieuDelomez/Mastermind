package com.sdz.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;

public abstract class Contenant {
	
	protected JPanel panel;
	
	protected Font arial = new Font("Arial", Font.BOLD, 15);
	protected Font dialog = new Font("Dialog", Font.BOLD + Font.ITALIC,15);
	

	// Constructeur
	// Initialisation du Panel
	
	public Contenant(Dimension dim) {
		
		this.panel = new JPanel();
		this.panel.setPreferredSize(dim);
		this.panel.setBackground(Color.white);
	}
	
	// Définition des méthodes abstraites
	
	protected JPanel getPanel() {
		
		return this.panel;
		
		
	}
	
	protected abstract void initPanel();
}