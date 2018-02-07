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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sdz.model.*;
import com.sdz.control.*;
import com.sdz.vue.*;
import com.sdz.observation.Observable;
import com.sdz.observation.Observer;


 /*************************MASTERMIND******************************/

/** Classe Fenetre compos�e d'une barre de menu qui permet d'acc�der
 * aux fonctionnalit�s du jeux. Elle impl�mente l'interface Observer.
 * 
 * @ author Matthieu Delomez
 * @see Observer
 * 
 *******************************************************************/

public class Fenetre extends JFrame implements Observer {
	
	

	private static final long serialVersionUID = 1L;

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
	
	private JMenuItem modeChallengerItem = new JMenuItem("Mode Challenger"),
			
			modeDefenseur = new JMenuItem("Mode D�fenseur"),
			
			modeDuel = new JMenuItem("Mode Duel");
	
	
	private Dimension size;
	
	/**
	 * Image de la page d'accuei.
	 */
	private JLabel imageJeu = new JLabel(new ImageIcon("ressources/Mastermind.jpg"));
	
	
	/**
	 * Mod�le des donn�es correspondant au jeu Mastermind
	 * @see DonneeMaster
	 */
	private DonneeMaster donneeMaster;
	
	
	/**
	 * JPanel principal de la classe.
	 */
	private JPanel container = new JPanel();
	
	
	/**
	 * Objet li� au jeu correspondant.
	 * @see MasterChallenger
	 * @see MasterDefenseur
	 * @see MasterDuel
	 */
	private ModeChallenger modeChallenger;
	
//	private MasterDefenseur masterDefenseur;
	
//	private MasterDuel masterDuel;
	
	
	/**
	 * Boite de dialoge permettant de changer les param�tres du jeu.
	 * @see BoiteDialogueParametrage
	 */
	private BoiteDialogueParametrage parametrage;
	
	/**
	 * Flux d'entr�e qui va permettre de lire le fichier ressources/config.properties
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
	 * Param�tre du jeu.
	 */
	private int nbCase = 4, nbEssai = 10, nbCouleur = 6;
	
	/**
	 * Param�tre du mode d�veloppement
	 */
	private boolean modeDeveloppeurActive = false;
	
	private Observable model;

	
	
	/* *************************************************************************************************
	 * 
	 ******************************************CONSTRUCTEUR*********************************************
	 * 
	 **************************************************************************************************/
	
	/**
	 * Constructeur de la classe Fenetre.
	 * @param donneeMaster
	 * @param modeDeveloppeurActiveConsole, param�tre boolean indiquant si le mode developpeur est actif ou non.
	 * @see DonneeMaster
	 */
	
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
		LOGGER.trace("Initialisation des mod�les de donn�es");
		
		// On r�cup�re les donn�es enregistr�es dans le fichier config.properties
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
		
		this.initMenu();
		this.setVisible(true);
	}
		
		
		/**
		 * M�thode qui permet d'initialiser le menu de la fen�tre principale.	 
        */
		public void initMenu() {
			
			LOGGER.trace("Initalisation du menu");
			
			menu = new JMenuBar(); 
			fichier = new JMenu("fichier");
			fichier.setMnemonic('f');
			nouveau = new JMenuItem("nouveau");


			// D�finition des acc�l�rateurs
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
			
			
			// D�finition  des listeners.
			modeChallengerItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					container.removeAll();
					container.setBackground(Color.WHITE);
					container.revalidate();
					container.repaint();
					parametre.setEnabled(false);
					
					initModel();
				}
			});
			
			modeDefenseur.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					container.removeAll();
					container.setBackground(Color.WHITE);
					container.revalidate();
					container.repaint();
					parametre.setEnabled(false);
					
					initModel();
				}
			});
			
			modeDuel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					container.removeAll();
					container.setBackground(Color.WHITE);
					container.revalidate();
					container.repaint();
					parametre.setEnabled(false);
					
					initModel();
				}
			});
			
			parametre.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					parametrage = new BoiteDialogueParametrage(null,"Parm�tre des Jeux",true,
							
						nbEssai, nbCase, nbCouleur);
					
					nbEssai = parametrage.getNbrEssai();
					nbCase = parametrage.getNbrCase();
					nbCouleur = parametrage.getNbrCouleur();
					modeDeveloppeurActive = parametrage.getModeDeveloppeurActive();
					
					LOGGER.debug("Menu Param�tre - Nb essais :" + nbEssai);
					LOGGER.debug("Menu Param�tre - Nb cases :" + nbCase);
					LOGGER.debug("Menu Param�tre - Nb couleurs :" + nbCouleur);
					LOGGER.debug("Menu Param�tre - Etat du mode d�veloppeur  :" + modeDeveloppeurActive);

				}
			});
			
			
			regle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String instructionJeu = 
							
							"Le but de ce jeu est de d�couvrir la combinaison � x couleurs de l'adversaire (le d�fenseur)."
									+ "\nPour ce faire, l'attaquant fait une proposition. Le d�fenseur indique pour chaque proposition"
									+ "\nle nombre de couleurs de la proposition qui apparaissent � la bonne place (� l'aide de pions rouges)"
									+ "\net � la mauvaise place (� l'aide de pions blancs) dans la combinaison secr�te.Un mode duel o� "
									+ "\nattaquant et d�fenseur jouent tour � tour est �galement disponible."; 				
					JOptionPane.showMessageDialog(null, instructionJeu, "Instructions Mastermind", JOptionPane.INFORMATION_MESSAGE);
				
				}
			});
		
			quitter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LOGGER.trace("Fin de l'appli");
					System.exit(0);
				}
			});
			
		}
		

		/* *************************************************************************************************
		 * 
		 ********************************IMPLEMENTATION DU PATTERN OBSERVER*********************************
		 * 
		 **************************************************************************************************/
		
	/**
	 * Pattern Observer - M�thode non utilis�e dans la clase Fenetre.
	 */
		public void updateMaster(String reponse) {}
	 
		
	/**
	 * Pattern Observer - M�thode permettant de quitter l'appli.
	*/
	    public void quitterAppli() {
		LOGGER.trace("Find de l'appli");
		System.exit(0);
	}
	    
		
    /**
	* M�thode qui permet de r�initialiser les mod�les de donn�es relatifs aux jeux..
	*/
	    private void initModel() {
	    	this.model = new DonneeMaster();
	    	this.model.addObserver(this);
	    	LOGGER.trace("R�initialiser des mod�les de donn�es");
	    }
	    
		
	/**
    * Pattern Observer - M�thode pour revenir � la page d'accueil.
	*/
	    public void accueilObserver() {
	    	parametre.setEnabled(true);
	    	parametre.removeAll();
	    	container.setBackground(Color.WHITE);
	    	container.add(imageJeu);
	    	container.revalidate();
	    	
	    	container.repaint();
	    	LOGGER.trace("Retour � l'accueil");
	    	
	    }
	
		
	/**
	* Pattern Observer - M�thode non utilis�e dans la clase Fenetre.
    */
	    public void relancerPartie() {}}



	
	
