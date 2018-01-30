package com.sdz.affichage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sdz.admin.Score;

public class ScoringPanel extends Contenant {
	
	//private int[] policeSize = {25, 24, 23,22,21,20,19,18,17,16};
	private Dimension dimension;
	private Score[] list;
	
	
	public ScoringPanel(Dimension dim, Score[] list) {
		
		super(dim);
		this.list = list;
		initPanel();
	}
	
	protected void initPanel() {
		
		JPanel leftContent = new JPanel();
		JPanel rightContent = new JPanel();
		
		this.dimension = new Dimension(36,530);
		rightContent.setPreferredSize(this.dimension);
		rightContent.setBackground(Color.white);
		
		this.dimension = new Dimension(500, 530);
		leftContent.setBackground(Color.white);
		
		/*
		
		for(int i = 0; i < this.list.length; i++); {
			
			JLabel lab = new JLabel(this.list[i].toString());
			lab.setFont(new Font("Arial", Font.BOLD, policeSize[i]));
			lab.setPreferredSize(new Dimension(440,40));
			leftContent.add(lab);
		}
		*/
		
		
		this.panel.add(leftContent, BorderLayout.CENTER);
		this.panel.add(rightContent, BorderLayout.WEST);
		System.out.println("Page des scores OK !");

		
	}

}
