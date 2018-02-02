package com.sdz.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;


import com.sdz.model.*;
import com.sdz.control.*;
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
	private JMenu parametre = null;

	private JMenuItem nouveau = null;
	private JMenuItem score = null;
	private JMenuItem quitter = null;
	private JMenuItem reglage = null;
	
	private JMenuItem apropos2 = null;
	private JMenuItem regle  =null;
	
	private JMenuItem modeChallenger = new JMenuItem("Mode Challenger"),
			
			modeDefenseur = new JMenuItem("Mode Défenseur"),
			
			modeDuel = new JMenuItem("Mode Duel");
	
	
	private Dimension size;
	
	/**
	 * Image de la page d'accuei.
	 */
	private JLabel imageJeu = new JLabel(new ImageIcon("ressources/Mastermind.jpg"));
	
	
	/**
	 * Modèle des données correspondant au jeu Mastermind
	 */
	private DonneeMaster donneeMaster;
	
	
	/**
	 * JPanel principal de la classe.
	 */
	private JPanel container = new JPanel();
	
	
	/**
	 * Objet lié au jeu correspondant.
	 */
	private MasterChallenger masterChallenger;
	
	private MasterDefenseur masterDefenseur;
	
	private MasterDuel masterDuel;
	
	
	/**
	 * Boite de dialoge permettant de changer les paramètres du jeu.
	 */
	private BoiteDialogueParametrage parametrage;
	
	/**
	 * Flux d'entrée qui va permettre de lire le fichier ressources/config.properties
	 */
	private InputStream input;
	
	/**
	 * Flux de sortie qui va permettre de charger le fichier ressources/config.properties
	 */
	private Properties prop;
	
	
	/**
	 * Variable permettant la gestion des logs d'erreurs.
	 */
	private static final Logger LOGGER = LogManager.getLogger(); // A recharger
	
	/**
	 * Paramètre du jeu.
	 */
	private int nbCase = 4, nbEssai = 10, nbCouleur = 6;
	
	/**
	 * Paramètre du mode développement
	 */
	private boolean modeDeveloppeurActive = false;
	
	private Observable model;

	
	
	/* *************************************************************************************************
	 * 
	 ******************************************CONSTRUCTEUR*********************************************
	 * 
	 **************************************************************************************************/
	
	
	public Fenetre(DonneeMaster donneeMaster, boolean modeDeveloppeurActiveConsole) {
		
		LOGGER.trace("Instanciation de la fenetre principale");
		this.setTitle("Mastermind");
		this.setSize(1000, 740);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setIconImage(new ImageIcon("ressoures/MastermindFormatIcon.png").getImage());
		imageJeu.setPreferredSize(new Dimension(1000,740));
		
		container.setPreferredSize(new Dimension(600,637));
		container.add(imageJeu);
		container.setBackground(Color.white);
		this.setContentPane(container);
		
		this.model = model;
		this.model.addObserver(this);
		this.modeDeveloppeurActive = modeDeveloppeurActiveConsole;
		LOGGER.trace("Initialisation des modèles de données");
		
		// On récupère les données enregistrées dans le fichier config.properties
		prop = new Properties();
		input = null;
		
		
		try {
			
			input = new FileInputStream("ressources/config.properties");
			prop.load(input);
			
			nbEssai = Integer.valueOf(prop.getProperty("param.nbEssaisActifMastermind"));
			nbCase = Integer.valueOf(prop.getProperty("param.nbCaseActifMastermind"));
			nbCouleur = Integer.valueOf(prop.getProperty("param.nbCouleurActifMastermind"));

			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if(input!=null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}	
			}
		}
	
		
		/**
		 * Méthode qui permet d'initialiser le menu de la fenêtre principale.	 
        */
		public void initMenu() {
			
			LOGGER.trace("Initalisation du menu");
			
			menu = new JMenuBar(); 
			fichier = new JMenu("fichier");
			fichier.setMnemonic('f');
			nouveau = new JMenuItem("nouveau");


			// Définition des accélérateurs
			quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK));
			parametre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK));
			

			// Construction du menu
			modeJeux.add(modeChallenger);
			modeJeux.add(modeDefenseur);
			modeJeux.add(modeDuel);
			
			fichier.add(nouveau);
			fichier.add(score);
			fichier.addSeparator();
			fichier.add(quitter);
			parametre.add(reglage);
			
			apropos.add(regle);		
			apropos.add(apropos2);			

			menu.add(fichier);
			menu.add(parametre);
			menu.add(modeJeux);
			menu.add(apropos);

			this.setJMenuBar(menu);
			
		
	
/*
		
		
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

		
	


	*/
	
	
	
		}
}