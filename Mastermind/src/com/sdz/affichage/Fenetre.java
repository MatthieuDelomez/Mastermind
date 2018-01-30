package com.sdz.affichage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import com.sdz.admin.Model;
import com.sdz.admin.Score;
import com.sdz.observation.Observable;
import com.sdz.observation.Observer;


// Implémentation de la Méthode observer

public class Fenetre extends JFrame implements Observer {
	
	
	// Déclaration des variables pour le Menu
	private JMenuBar menu = null;
	
	private JMenuItem nouveau = null;
	private JMenu fichier = null;
	private JMenuItem score = null;
	private JMenuItem quitter = null;
	private JMenu apropos = null;
	private JMenuItem apropos2 = null;
	private JMenuItem regle  =null;
	private Observable model;
	private Dimension size;
	
	private JPanel conteneur = new JPanel();
	
	
	// Liste des chiffres pris en compte pour le code secret
	private int [] chiffreTab = {'1','2','3','4','5','6','7',
			
			'8','9','0'};
	
	
	        // Constructeur
	public Fenetre(Observable obs) {
		
		// Parametre de l'interface
		this.setTitle("Mastermind");
		this.setSize(900, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		this.model = obs;
		this.model.addObserver(this);
		this.size = new Dimension(this.getWidth(), this.getHeight());
		
		
		// Initialisation du menu
		menu = new JMenuBar(); 
		
		fichier = new JMenu("fichier");
		fichier.setMnemonic('f');
		
		nouveau = new JMenuItem("nouveau");
		nouveau.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				
				InputEvent.CTRL_MASK));
		
		
		// On place une écoute sur le bouton 'nouveau'
		nouveau.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				conteneur.removeAll();
				Game gp = new Game(size, model);
				model.addObserver(gp);
				conteneur.add(gp.getPanel(), BorderLayout.CENTER);
				conteneur.revalidate();
				initModel();
			}
				
		});
		
		// On définit maintenant le bouton 'score'
		
		score = new JMenuItem("Score");
        score.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
                
				KeyEvent.CTRL_MASK));
        
        
        // On place un écouteur sur le bouton'score'
        score.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent arg0) {
        		
        		conteneur.removeAll();
				conteneur.add(new ScoringPanel(size, model.getScores()).getPanel(), BorderLayout.CENTER);
                conteneur.revalidate();
                model.reset();
        	}
        });
        
        
        // Definition du bouton'Quitter'
        
        quitter = new JMenuItem("quitter");
        quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
                
				KeyEvent.CTRL_MASK));
        
        quitter.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent arg0) {
        		
        		System.exit(0); // Sortie du programme
        	}
        });
        
        
        // Ajout des MenuiItem dans le JMenu
        
        fichier.add(nouveau);
        fichier.add(score);
        fichier.addSeparator();
        fichier.add(quitter);
        
        apropos = new JMenu("A propos");
        apropos.setMnemonic('O');
        
        // Ecouteur sur le bouton 'regle'
        
        regle = new JMenuItem("Regle du jeux");
        regle.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent arg0) {
        		
        		conteneur.removeAll();
        		conteneur.add(new Regles(size).getPanel(), BorderLayout.CENTER);
        		conteneur.revalidate();
        		model.reset();
        	}
        	
        	
        });
        
		
        // Au tour du bouton 'apropos2"
        
        apropos2 = new JMenuItem(" ? ");
        apropos2.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent arg0) {
        		
        		JOptionPane.showMessageDialog(null, 
        				
        				"Créateur : Delomez Matthieu\n"+
        				"Réaliser dans le cadre du TP3 OpenClassrooms",
        				
        				"Crédit : ", JOptionPane.NO_OPTION);
        		
        	}
        });
        
        
        // Ajout des JMenuItem dans le JMenu
        
        apropos.add(regle);
        apropos.add(apropos2);
        
        menu.add(fichier);
        menu.add(apropos);
        
        
        // Initialisation du conteneur
        
        this.conteneur.setPreferredSize(this.size);
        this.conteneur.setBackground(Color.white);
		this.conteneur.add(new PageAccueil(this.size).getPanel());
        this.setContentPane(this.conteneur);
        
        this.setJMenuBar(menu);
	}
	
	
	public void showsScore(Score[] list) {
		
		conteneur.removeAll();
		conteneur.add(new ScoringPanel(this.size, list).getPanel(), BorderLayout.CENTER);
		conteneur.revalidate();
		model.reset();
	}
	
	
   public void accueil() {
		
		System.out.println("Mise a jour de l'accueil");
		conteneur.removeAll();
		conteneur.add(new PageAccueil(size).getPanel(), BorderLayout.CENTER);
		conteneur.revalidate();
		model.reset();
		
	}
	
	// Initialisation du model
	
	private void initModel() {
		
		this.model = new Model();
		this.model.addObserver(this);
		
	}
	
	
	// Méthode Observable
	
	public void update(int code, int pts, int nbreCode) {}
	
	public void restart(int word) {}

		
	


	
	
	
	

}
