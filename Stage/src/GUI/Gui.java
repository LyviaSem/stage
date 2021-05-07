package GUI;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileView;
import javax.swing.plaf.basic.BasicButtonUI;

import Traitement.POI;

public class Gui extends JFrame{
	
	//intitialisation
	private JPanel panel = new JPanel();
	private JButton button;
	private JLabel label;
	private JFrame frame = new JFrame();
	//private boolean action = false;
	
	//instance de class
	POI poi = new POI();
	//Button bouton = new Button();
	
	//constructueur
	public Gui () {
		
		frame.setTitle("fichier");
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Gui.class.getResource("/Image/fichier.png")));
		
		button = new JButton("choisir un fichier");
		label = new JLabel("nouveau fichier créé");
		
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(250,150));
		panel.setBackground(Color.white);
		
		button.setBounds(50,50,150,30);
		button.setFont(new Font("Calibri", Font.PLAIN, 14));
		button.setBackground(new Color(0xFFA07A));
		button.setForeground(Color.BLACK);
		button.setBorder(new EmptyBorder(5,15,5,15));
		button.setUI(new Button());
		button.addActionListener(new filechooser());
		
		
		label.setBounds(65,90,150,30);
		label.setFont(new Font("Calibri", Font.PLAIN, 14));
		label.setForeground(Color.black);
		
		panel.add(button);
		//System.out.println(action);
		
		frame.setContentPane(panel);
		frame.setLocation(500,300);
		frame.pack();
		frame.setVisible(true);
	}
	
	//fonction du bouton 
	private class filechooser implements ActionListener {
		private JFileChooser fc = new JFileChooser();
		FileView view = new CustomFileView();		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			// TODO Auto-generated method stub
			
			Object source = e.getSource();
			fc.setBackground(Color.red);
			fc.setFileView(view);
			System.out.println("fc "+view);
			
			fc.setFileSelectionMode(fc.FILES_ONLY);

			FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel file", "xlsx");                                
			fc.addChoosableFileFilter(filter);
			
			int val = fc.showOpenDialog(panel);
			if(val == JFileChooser.APPROVE_OPTION) {
				
				File file = fc.getSelectedFile();
				poi.lecture(file);
				poi.ecrire();
				
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
	    	 System.out.println("oui ");
	        Icon icon = null;
	
	        if(isExcel(f)) {
	        	//System.out.println("IsExcel "+isExcel(f));
	         icon = ExcelIcon;  
	        // System.out.println("Icon "+icon);
	        }
	        
	        System.out.println("Icon "+icon);
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
