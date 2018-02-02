package com.sdz.vue;

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

import com.sdz.model.Model;
import com.sdz.model.Score;
import com.sdz.observation.Observable;
import com.sdz.observation.Observer;


 /*************************MASTERMIND******************************/

/** Classe Fenetre composée d'une barre de menu qui permet d'accéder
 * aux fonctionnalités du jeux. Elle implémente l'interface Observer.
 * 
 * @ author Matthieu Delomez
 * @see Observateur
 * 
 *******************************************************************/

public class Fenetre extends JFrame implements Observer {
	
	
	/**
	 * Barre du menu
	 * Fichier = nouveau + score + quitter.
	 * A propos = Regles + Credit.
	 * 
	 */
	private JMenuBar menu = null;
	
	private JMenu fichier = null;
	private JMenu apropos = null;
	private JMenu modeJeux = null;

	private JMenuItem nouveau = null;
	private JMenuItem score = null;
	private JMenuItem quitter = null;
	
	private JMenuItem apropos2 = null;
	private JMenuItem regle  =null;
	
	private JMenuItem modeChallenger = new JMenuItem("Mode Challenger"),
			
			modeDefenseur = new JMenuItem("Mode Défenseur"),
			
			modeDuel = new JMenuItem("Mode Duel");
	
	
	private Dimension size;
	
	
	/**
	 * Modèle des données correspondant au jeu Mastermind
	 */
	private ModeleDonneeMaster modelMaster;
	
	
	/**
	 * JPanel principal de la classe.
	 */
	private JPanel conteneur = new JPanel();
	
	
	/**
	 * Objet lié au jeu correspondant.
	 */
	private MasterChallenger masterChallenger;
	
	private MasterDefenseur masterDefenseur;
	
	private MasterDuel masterDuel;
	
	
	/**
	 * Boite de dialoge permettant de changer les paramètres du jeu.
	 */
	private DialogueParametre parametrage;
	
	
	/**
	 * Variable permettant la gestion des logs d'erreurs.
	 */
	private static final Logger LOGGER = LogManager.getLogger();
	
	
	
	// Liste des chiffres pris en compte pour le code secret
	private int [] chiffreTab = {'1','2','3','4','5','6','7',
			
			'8','9','0'};
	
	private Observable model;

	
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