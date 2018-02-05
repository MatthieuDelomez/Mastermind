package com.sdz.vue;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sdz.model.Score;
import com.sdz.observation.Observable;
import com.sdz.observation.Observer;


public class Game extends Contenant implements Observer{
	
	private Dimension dimension = new Dimension();
	private int pts = 0;
	private JLabel nombreCode, code,
	
	score, // Ajout 'code'?
	codeSecret;
	
	private JButton bouton[];
//	private Controler controler;
	
	
	public Game(Dimension dim, Observable mod) {
		
		super(dim);
		initPanel();
	}
	
	
	protected void initPanel() {
		
		JPanel leftContent = new JPanel();
		JPanel rightContent = new JPanel();
		
		JPanel tete = new JPanel();
		this.nombreCode = new JLabel();
		this.score = new JLabel();
		
		this.dimension = new Dimension(400,530);
		rightContent.setPreferredSize(this.dimension);
		rightContent.setBackground(Color.white);
		
		leftContent.setPreferredSize(this.dimension);
		
		Dimension dim = new Dimension(410,200);
		tete.setPreferredSize(new Dimension(410,100));
		
		//this.nombreCode.setText("Nombre de codes trouvé : 0");
        this.nombreCode.setPreferredSize(new Dimension(300,20));
        this.nombreCode.setHorizontalAlignment(JLabel.CENTER);
        this.nombreCode.setFont(arial);
        
        tete.add(this.nombreCode, BorderLayout.NORTH);
        
        this.score.setText("Votre score est actuellement de 0 pts");
        this.score.setPreferredSize(new Dimension(300,20));
        this.score.setHorizontalAlignment(JLabel.CENTER);
        this.score.setFont(arial);
        tete.add(this.score, BorderLayout.SOUTH);
        tete.setBackground(Color.white);
        
        this.codeSecret = new JLabel("lol");
        this.codeSecret.setPreferredSize(new Dimension(400,60));
        this.codeSecret.setForeground(Color.blue);
        this.codeSecret.setFont(arial);
        this.codeSecret.setHorizontalAlignment(JLabel.CENTER);
        tete.add(this.codeSecret);
        
        
        JPanel body = new JPanel();
        body.setPreferredSize(dim);
        body.setBackground(Color.white);
        
        int chiffre[] = {'0','1','2','3','4','5','6','7','8','9'};
	
	    BoutonListener bl  = new BoutonListener() ;
	    
	    Dimension buttonDimension = new Dimension(50,30);
	    
	    this.bouton = new JButton[10];
	    int i = 0 ;
	    
    for(int c : chiffre) { // A vérifier !!
	    	
	    	this.bouton[i] = new JButton(String.valueOf(c).toUpperCase());
	        bouton[i].addActionListener(bl);
	        bouton[i].setPreferredSize(buttonDimension);
	        body.add(bouton[i]);
	        i++;
	    
	    }
	    
	    leftContent.add(tete, BorderLayout.NORTH);
	    leftContent.add(body, BorderLayout.CENTER);
	    leftContent.setBackground(Color.white);
	    
	    this.panel.add(leftContent);
	    this.panel.add(rightContent);
	    
	}
	
	public void restart(int word) {
		
		for(JButton bout : this.bouton)
			bout.setEnabled(true);
		
		this.codeSecret.setText(String.valueOf(word)); // A vérifier !!
	}
	
	public void accueil() {}
	
	public void update(int code, int pts, int nbreCode) {
		
		this.codeSecret.setText(String.valueOf(code)); // Idem a verif
		this.score.setText("Votre score actuel est de " +pts+((pts > 1) ? "s" : "") + ".") ;
	    this.codeSecret.setText("Nombre de combinaisons trouvées : " +nbreCode);
	
	}
	
	public void showsScore(Score[] list) {}
	
  class BoutonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			((JButton)e.getSource()).setEnabled(false);
			((JButton)e.getSource()).getText().charAt(0);  }} // A voir
		
	
	    
	
	}

	
	
