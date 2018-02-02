package com.sdz.vue;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/******************************MASTERMIND********************************/

/*************************************************************************
 * Classe relative la boite de dialogue qui permet d'avoir accès aux param
 *du Mastermind tels que le nombre d'essais, le nombre de cases et le nbr
 *de couleurs utilisables pour le Mastermind.
 *
 * @author Matthieu Delomez
 * 
 *************************************************************************/


public class BoiteDialogueParametrage extends JDialog {
	
	
	/**
	 * JPanel principal de la classe.
	 */
	private JPanel container = new JPanel();
	
	
	/**
	 * JPanel qui contient les composants des paramètres du jeu.
	 */
	private JPanel containerMaster = new JPanel();
	
	
	/**
	 * JPanel contenant les JButton de validation ou de delete.
	 */
	private JPanel containerButton = new JPanel();
	
	
	/**
	 * JLabel informatif.
	 */
	private JLabel nbrEssai = new JLabel("Nombre d'essais :"),
	
	               nbrCase = new JLabel("Nombre de cases :"),
	               
	               nbrCouleur = new JLabel("Nombre de couleurs :");
	
	/**
	 * JComboBox contenant une plage de valeurs pour un paramètre donné.
	 */
	private JComboBox nbrEssaiCombo = new JComboBox(), 
			
			          nbrCaseCombo = new JComboBox(),
			          
			          nbrCouleurCombo = new JComboBox();
	
	/**
	 * JButon de validation.
	 */
	private JButton boutonOk = new JButton("OK");
	
	
	/**
	 * JButton d'annulation.
	 */
	private JButton Annuler = new JButton("Annuler");
	
	
	/**
	 * Objet permettant de charger le fichier ressources/config.properties
	 * et de pouvoir enregistrer dans le fichier.
	 */
	private Properties prop;
	
	
	/**
	 * Flux d'entrée permettant de lire le fichier ressources/config.properties.
	 */
	private InputStream input;
	
	

	/**
	 * Flux de sortie permettant d'écrire dans le fichier ressources/config.properties.
	 */
	private OutputStream output;
	
	
	/**
	 * Variable de type String, qui permet de pouvoir manipuler le fichier
	 * ressources/config.properties
	 */
	private String [] tab_nbrEssai, tab_nbrCase, tab_nbrCouleur;

}
