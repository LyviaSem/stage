package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Traitement.POI;

public class Gui extends JFrame{
	
	private JPanel panel = new JPanel();
	private JButton button;
	private JLabel label;
	//private boolean action = false;
	POI poi = new POI();
	
	public Gui () {
		
		this.setTitle("fichier");
		
		button = new JButton("choisir un fichier");
		label = new JLabel("votre nouveau fichier créé");
		
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(250,150));
		//panel.setBackground(Color.white);
		
		button.setBounds(50,50,150,30);
		button.addActionListener(new filechooser());
		button.setFont(new Font("Calibri", Font.PLAIN, 14));
		button.setBackground(new Color(0x008080));
		button.setForeground(Color.white);
		//button.setOpaque(false);
		button.setBorder(new EmptyBorder(5,15,5,15));
		button.addActionListener(new filechooser());
		
		
		label.setBounds(50,90,150,30);
		label.setFont(new Font("Calibri", Font.PLAIN, 14));
		label.setForeground(Color.black);
		
		panel.add(button);
		//System.out.println(action);
		
		this.setContentPane(panel);
		this.setLocation(400,300);
		this.pack();
		this.setVisible(true);
	}
	
	private class filechooser implements ActionListener {
		private JFileChooser fc = new JFileChooser();
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			//label = new JLabel("nouveau fichier créé");
			// TODO Auto-generated method stub
			int val = fc.showOpenDialog(panel);
			if(val == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				poi.lecture();
				//poi.ecrire(file);
				//action = true;
				//System.out.println(action);
				/*if(action == true) {
					panel.add(label);
				}
				/*button.setBounds(10,10,150,30);
				
				label.setForeground(Color.black);
				label.add(panel);*/
				
			}
			
			else {
				System.out.println("erreur");
			}
			
		}
		
	}

}
