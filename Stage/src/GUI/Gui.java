package GUI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileView;
import javax.swing.plaf.basic.BasicButtonUI;

import Traitement.POI;


public class Gui extends JFrame{
	
	//intitialisation
	private JPanel panel = new JPanel();
	private JPanel panel1 = new JPanel();
	private JButton button;
	private JLabel label;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JFrame frame = new JFrame();
	private JRadioButton rbutton;
	private JRadioButton rbutton1;
	private JRadioButton rbutton2;
	private JRadioButton rbutton3;
	private JRadioButton rbutton4;
	private JRadioButton rbutton5;
	private JRadioButton rbutton6;
	private JRadioButton rbutton7;
	private JRadioButton rbutton8;
	//private boolean action = false;
	
	//instance de class
	POI poi = new POI();
	//Button bouton = new Button();
	
	//constructueur
	public Gui () {
		
		frame.setTitle("fichier");
		frame.setBackground(Color.white);
		Container contentpane = getContentPane();
		//frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Gui.class.getResource("/Image/fichier.png")));
		
		button = new JButton("choisir un fichier");
		label = new JLabel("nouveau fichier créé");
		label1 = new JLabel("AEOS : ");
		label2 = new JLabel("Carte : ");
		label3 = new JLabel("Poste : ");
		label4 = new JLabel("Fichier 1 : ");
		label5 = new JLabel("Fichier 2 : ");
		label6 = new JLabel("Fichier 3 : ");
		rbutton = new JRadioButton("fichier 1");
		rbutton1 = new JRadioButton("fichier 2");
		rbutton2 = new JRadioButton("fichier 3");
		rbutton3 = new JRadioButton("fichier 1");
		rbutton4 = new JRadioButton("fichier 2");
		rbutton5 = new JRadioButton("fichier 3");
		rbutton6 = new JRadioButton("fichier 1");
		rbutton7 = new JRadioButton("fichier 2");
		rbutton8 = new JRadioButton("fichier 3");
		
		contentpane.setLayout(new BorderLayout());
		//panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		//panel.setPreferredSize(new Dimension(250,150));
		//panel.setBackground(Color.white);
		
		panel1.setLayout(new GridLayout(3,4));
		//panel1.setPreferredSize(new Dimension(250,150));
		//panel1.setBackground(Color.white);
		
		//button.setBounds(50,50,150,30);
		button.setFont(new Font("Calibri", Font.PLAIN, 14));
		button.setBackground(new Color(0xFFA07A));
		button.setForeground(Color.BLACK);
		button.setBorder(new EmptyBorder(5,15,5,15));
		button.setUI(new Button());
		button.addActionListener(new filechooser());
		
		//rbutton.setBounds(150,150,30,30);
		rbutton.setFont(new Font("Calibri", Font.PLAIN, 14));
		//rbutton.setBackground(new Color(0xFFA07A));
		rbutton.setForeground(Color.BLACK);
		rbutton.setBorder(new EmptyBorder(5,15,5,15));
		
		//rbutton1.setBounds(180,150,30,30);
		rbutton1.setFont(new Font("Calibri", Font.PLAIN, 14));
		//rbutton1.setBackground(new Color(0xFFA07A));
		rbutton1.setForeground(Color.BLACK);
		rbutton1.setBorder(new EmptyBorder(5,15,5,15));
		
		//rbutton2.setBounds(210,150,300,30);
		rbutton2.setFont(new Font("Calibri", Font.PLAIN, 14));
		//rbutton2.setBackground(new Color(0xFFA07A));
		rbutton2.setForeground(Color.BLACK);
		rbutton2.setBorder(new EmptyBorder(5,15,5,15));
		
		
		label.setBounds(65,90,150,30);
		label.setFont(new Font("Calibri", Font.PLAIN, 14));
		label.setForeground(Color.black);
		
		label1.setBounds(0,0,150,30);
		label1.setFont(new Font("Calibri", Font.PLAIN, 14));
		label1.setForeground(Color.black);
		
		label2.setBounds(65,90,150,30);
		label2.setFont(new Font("Calibri", Font.PLAIN, 14));
		label2.setForeground(Color.black);
		
		label3.setBounds(65,90,150,30);
		label3.setFont(new Font("Calibri", Font.PLAIN, 14));
		label3.setForeground(Color.black);
		
		panel.add(button);
		panel.add(label4);
		panel.add(label5);
		panel.add(label6);
		panel1.add(label1);
		panel1.add(rbutton);
		panel1.add(rbutton1);
		panel1.add(rbutton2);
		panel1.add(label2);
		panel1.add(rbutton3);
		panel1.add(rbutton4);
		panel1.add(rbutton5);
		panel1.add(label3);
		panel1.add(rbutton6);
		panel1.add(rbutton7);
		panel1.add(rbutton8);
		
		contentpane.add(BorderLayout.WEST, panel);
		contentpane.add(BorderLayout.EAST, panel1);
		//System.out.println(action);
		
		frame.setContentPane(contentpane);
		//frame.add(panel1);
		frame.setLocation(500,300);
		frame.setPreferredSize(new Dimension(1000,1000));
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//fonction du bouton 
	private class filechooser implements ActionListener {
		private JFileChooser fc = new JFileChooser();
		FileView view = new CustomFileView();		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			// TODO Auto-generated method stub
			
			Object source = e.getSource();
			//fc.setBackground(Color.red);
			//fc.setFileView(view);
			//System.out.println("fc "+view);
			
			//fc.setFileSelectionMode(fc.FILES_ONLY);

			FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel file", "xlsx");                                
			fc.addChoosableFileFilter(filter);
			
			fc.setMultiSelectionEnabled(true);
			int val = fc.showOpenDialog(null);
			if(val == JFileChooser.APPROVE_OPTION) {
				
				File[] file = fc.getSelectedFiles();
				
				for(int i = 0; i < file.length; i++) {
					System.out.println(file[i]);
				}
				//poi.lecture(file);
				//poi.ecrire();
				
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
			
			
			if(source == button) {
				
				panel.add(label);
				frame.repaint();
			}
			
		}
		
	}
	
	private class Button extends BasicButtonUI {
		
		 @Override
		    public void installUI (JComponent c) {
		        super.installUI(c);
		        AbstractButton button = (AbstractButton) c;
		        button.setOpaque(false);
		        button.setBorder(new EmptyBorder(5, 15, 5, 15));
		    }

		    @Override
		    public void paint (Graphics g, JComponent c) {
		        AbstractButton b = (AbstractButton) c;
		        paintBackground(g, b, b.getModel().isPressed() ? 2 : 0);
		        super.paint(g, c);
		    }

		    private void paintBackground (Graphics g, JComponent c, int yOffset) {
		        Dimension size = c.getSize();
		        Graphics2D g2 = (Graphics2D) g;
		        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		        g.setColor(c.getBackground().darker());
		        g.fillRoundRect(0, yOffset, size.width, size.height - yOffset, 10, 10);
		        g.setColor(c.getBackground());
		        g.fillRoundRect(0, yOffset, size.width, size.height + yOffset - 5, 10, 10);
		    }
	}
	
	
	private class CustomFileView extends FileView {
	    private Icon ExcelIcon = new ImageIcon("image/xlsx.png");
	 
	    public String getName(File f) {
	        return null;
	    }
	 
	    public String getDescription(File f) {
	        return null;
	    }
	 
	    public String getTypeDescription(File f) {
	        return null;
	    }
	 
	    public Icon getIcon(File f) {
	    	// System.out.println("oui ");
	        Icon icon = null;
	
	        if(isExcel(f)) {
	        	//System.out.println("IsExcel "+isExcel(f));
	         icon = ExcelIcon;  
	        // System.out.println("Icon "+icon);
	        }
	        
	       // System.out.println("Icon "+icon);
	        return icon;
	    }
	    
	    private boolean isExcel(File f) {
	        String suffix = getSuffix(f);
	       // System.out.println("suffix"+suffix);
	        boolean isExcel = false;
	 
	        if (suffix != null) {
	            isExcel = suffix.equals("xlsx");
	            //System.out.println("isExcel "+isExcel);
	        }
	        return isExcel;
	    }
	 
	    private String getSuffix(File file) {
	        String filestr = file.getPath(), suffix = null;
	        int i = filestr.lastIndexOf('.');
	 
	        if (i > 0 && i < filestr.length()) {
	            suffix = filestr.substring(i + 1).toLowerCase();
	        }
	        return suffix;
	    }
	    
	}
	
	
	

}
