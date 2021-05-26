package GUI;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicButtonUI;

import Traitement.POI;

import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComponent;


public class Window {
	
	//initialisation
	private JFrame frmFichier;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	JLabel lblNewLabel;
	JLabel lblNewLabel_1;
	JLabel lblNewLabel_2;
	JLabel lblNewLabel_6;
	private File[] file = new File[3];
	int cmp = 0;
	POI poi = new POI();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frmFichier.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//declaration JFrame
		frmFichier = new JFrame();
		frmFichier.getContentPane().setBackground(Color.WHITE);
		frmFichier.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\lyvia.semaoune\\git\\stage\\Stage\\src\\Image\\fichier.png"));
		frmFichier.setTitle("Fichier");
		frmFichier.setBounds(100, 100, 791, 352);
		frmFichier.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmFichier.getContentPane().setLayout(springLayout);
		
		//declaration JButton
		JButton btnNewButton = new JButton("Selectioner un fichier");
		btnNewButton.setBackground(new Color(0xFAF0E6));
		//action du bouton 
		btnNewButton.addMouseListener(new MouseAdapter() {
			
			private JFileChooser fc = new JFileChooser();
			
			public void mouseClicked(MouseEvent e) {
					
					lblNewLabel_6.setText("");
					// TODO Auto-generated method stub
					
					FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel file", "xlsx");                                
					fc.addChoosableFileFilter(filter);
					
					int val = fc.showOpenDialog(null);
					
				
					if(val == JFileChooser.APPROVE_OPTION) {
						fc.setMultiSelectionEnabled(true);
						if(fc.getSelectedFile() != null) {
							file[cmp] = fc.getSelectedFile();
							cmp += 1;
						}
					}
					
					else {
						System.out.println("erreur");
					}
					
					if (file[0] != null && cmp == 1) {
						if(lblNewLabel.getText().length() < 13) {
							lblNewLabel.setText(lblNewLabel.getText() + file[0].getName());
						}
					}
					if (file[1] != null && cmp == 2) {
						if(lblNewLabel_1.getText().length() < 13) {
							lblNewLabel_1.setText(lblNewLabel_1.getText() + file[1].getName());
						}
					}
					if (file[2] != null && cmp == 3) {
						if(lblNewLabel_2.getText().length() < 13) {
							lblNewLabel_2.setText(lblNewLabel_2.getText() + file[2].getName());
						}
					}
					
					 frmFichier.repaint();					
					
			}	
			
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 28, SpringLayout.NORTH, frmFichier.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 10, SpringLayout.WEST, frmFichier.getContentPane());
		btnNewButton.setUI(new StyledButtonUI());
		//ajout du bouton a la JFrame
		frmFichier.getContentPane().add(btnNewButton);
		
		//declaration JLabel
		lblNewLabel_1 = new JLabel("Fichier 2 : ");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, btnNewButton);
		//ajout du label a la JFrame
		frmFichier.getContentPane().add(lblNewLabel_1);
		
		//declaration JLabel
		lblNewLabel_2 = new JLabel("Fichier 3 : ");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, btnNewButton);
		//ajout du label a la JFrame
		frmFichier.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fichier AEOS :");
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_3, -312, SpringLayout.EAST, frmFichier.getContentPane());
		//ajout du label a la JFrame
		frmFichier.getContentPane().add(lblNewLabel_3);
		
		//declaration JLabel
		JLabel lblNewLabel_4 = new JLabel("Fichier Carte :");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_4, -380, SpringLayout.EAST, frmFichier.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_4, -296, SpringLayout.EAST, frmFichier.getContentPane());
		//ajout du label a la JFrame
		frmFichier.getContentPane().add(lblNewLabel_4);
		
		//declaration JLabel
		JLabel lblNewLabel_5 = new JLabel("Fichier Service :");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_5, 310, SpringLayout.EAST, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, -129, SpringLayout.SOUTH, frmFichier.getContentPane());
		//ajout du label a la JFrame
		frmFichier.getContentPane().add(lblNewLabel_5);
		
		//declaration JRadioButton
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Fichier 1");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 20, SpringLayout.SOUTH, rdbtnNewRadioButton);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton, 55, SpringLayout.NORTH, frmFichier.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, -6, SpringLayout.NORTH, rdbtnNewRadioButton);
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setActionCommand("fichier 1");;
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		buttonGroup.add(rdbtnNewRadioButton);
		frmFichier.getContentPane().add(rdbtnNewRadioButton);
		
		//declaration JRadioButton
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Fichier 2");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton_1, 51, SpringLayout.NORTH, frmFichier.getContentPane());
		rdbtnNewRadioButton_1.setBackground(Color.WHITE);
		rdbtnNewRadioButton_1.setActionCommand("fichier 2");;
		springLayout.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton_1, 44, SpringLayout.EAST, rdbtnNewRadioButton);
		buttonGroup.add(rdbtnNewRadioButton_1);
		//ajout du radio bouton a la JFrame
		frmFichier.getContentPane().add(rdbtnNewRadioButton_1);
		
		//declaration JRadioButton
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Fichier 3 ");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton_2, 51, SpringLayout.NORTH, frmFichier.getContentPane());
		rdbtnNewRadioButton_2.setBackground(Color.WHITE);
		rdbtnNewRadioButton_2.setActionCommand("fichier 3");;
		springLayout.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton_2, 46, SpringLayout.EAST, rdbtnNewRadioButton_1);
		buttonGroup.add(rdbtnNewRadioButton_2);
		//ajout du radio bouton a la JFrame
		frmFichier.getContentPane().add(rdbtnNewRadioButton_2);
		
		//declaration JRadioButton
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Fichier 1");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton_3, 6, SpringLayout.SOUTH, lblNewLabel_4);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 4, SpringLayout.NORTH, rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setSelected(true);
		rdbtnNewRadioButton_3.setBackground(Color.WHITE);
		rdbtnNewRadioButton_3.setActionCommand("fichier 1");;
		springLayout.putConstraint(SpringLayout.EAST, rdbtnNewRadioButton, 0, SpringLayout.EAST, rdbtnNewRadioButton_3);
		buttonGroup_1.add(rdbtnNewRadioButton_3);
		springLayout.putConstraint(SpringLayout.EAST, rdbtnNewRadioButton_3, -353, SpringLayout.EAST, frmFichier.getContentPane());
		//ajout du radio bouton a la JFrame
		frmFichier.getContentPane().add(rdbtnNewRadioButton_3);
		
		//declaration JRadioButton
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Fichier 2");
		rdbtnNewRadioButton_4.setBackground(Color.WHITE);
		rdbtnNewRadioButton_4.setActionCommand("fichier 2");;
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton_4, 0, SpringLayout.NORTH, rdbtnNewRadioButton_3);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton_4, 0, SpringLayout.WEST, rdbtnNewRadioButton_1);
		buttonGroup_1.add(rdbtnNewRadioButton_4);
		//ajout du radio bouton a la JFrame
		frmFichier.getContentPane().add(rdbtnNewRadioButton_4);
		
		//declaration JRadioButton
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Fichier 3 ");
		rdbtnNewRadioButton_5.setBackground(Color.WHITE);
		rdbtnNewRadioButton_5.setActionCommand("fichier 3");;
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton_5, 0, SpringLayout.NORTH, rdbtnNewRadioButton_3);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton_5, 0, SpringLayout.WEST, rdbtnNewRadioButton_2);
		buttonGroup_1.add(rdbtnNewRadioButton_5);
		//ajout du radio bouton a la JFrame
		frmFichier.getContentPane().add(rdbtnNewRadioButton_5);
		
		//declaration JRadioButton
		JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("Fichier 1 ");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton_6, 6, SpringLayout.SOUTH, lblNewLabel_5);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton_6, 0, SpringLayout.WEST, rdbtnNewRadioButton);
		rdbtnNewRadioButton_6.setSelected(true);
		rdbtnNewRadioButton_6.setActionCommand("fichier 1");;
		rdbtnNewRadioButton_6.setBackground(Color.WHITE);
		buttonGroup_2.add(rdbtnNewRadioButton_6);
		//ajout du radio bouton a la JFrame
		frmFichier.getContentPane().add(rdbtnNewRadioButton_6);
		
		//declaration JRadioButton
		JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("Fichier 2 ");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton_7, 0, SpringLayout.NORTH, rdbtnNewRadioButton_6);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton_7, 0, SpringLayout.WEST, rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_7.setBackground(Color.WHITE);
		rdbtnNewRadioButton_7.setActionCommand("fichier 2");;
		buttonGroup_2.add(rdbtnNewRadioButton_7);
		//ajout du radio bouton a la JFrame
		frmFichier.getContentPane().add(rdbtnNewRadioButton_7);
		
		//declaration JRadioButton
		JRadioButton rdbtnNewRadioButton_8 = new JRadioButton("Fichier 3");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton_8, 0, SpringLayout.NORTH, rdbtnNewRadioButton_6);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton_8, 0, SpringLayout.WEST, rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_8.setBackground(Color.white);
		rdbtnNewRadioButton_8.setActionCommand("fichier 3");;
		buttonGroup_2.add(rdbtnNewRadioButton_8);
		//ajout du radio bouton a la JFrame
		frmFichier.getContentPane().add(rdbtnNewRadioButton_8);
		
		//declaration JButton
		JButton btnNewButton_1 = new JButton("Envoyer");
		btnNewButton_1.setBackground(new Color(0xFAF0E6));
		//action du JButton
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if((file[0] != null && file[1] != null && file[2] != null) && (buttonGroup.getSelection().getActionCommand() != buttonGroup_1.getSelection().getActionCommand() && buttonGroup.getSelection().getActionCommand() != buttonGroup_2.getSelection().getActionCommand() && buttonGroup_1.getSelection().getActionCommand() != buttonGroup_2.getSelection().getActionCommand())) {
					switch (buttonGroup.getSelection().getActionCommand()) {
					case "fichier 1":
						poi.lecture1(file[0]);
						break;
					case "fichier 2":
						poi.lecture1(file[1]);
						break;
					case "fichier 3":
						poi.lecture1(file[2]);
						break;
					}
				
					switch (buttonGroup_1.getSelection().getActionCommand()) {
					case "fichier 1":
						poi.lecture2(file[0]);
						break;
					case "fichier 2":
						poi.lecture2(file[1]);
						break;
					case "fichier 3":
						poi.lecture2(file[2]);
						break;
					}
				
					switch (buttonGroup_2.getSelection().getActionCommand()) {
					case "fichier 1":
						poi.lecture3(file[0]);
						break;
					case "fichier 2":
						poi.lecture3(file[1]);
						break;
					case "fichier 3":
						poi.lecture3(file[2]);
						break;
					}
				poi.ecrire();
				file = null;
				file = new File[3];
				cmp = 0 ;
				
				lblNewLabel.setText("fichier 1 : ");
				lblNewLabel_1.setText("fichier 2 : ");
				lblNewLabel_2.setText("fichier 3 : ");
				
				
				lblNewLabel_6.setForeground(Color.BLUE);
				lblNewLabel_6.setText("nouveau fichier créé");
				frmFichier.repaint();
				}
				else {
					lblNewLabel_6.setForeground(Color.RED);
					lblNewLabel_6.setText("ERREUR");
				}
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -10, SpringLayout.SOUTH, frmFichier.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, -43, SpringLayout.EAST, frmFichier.getContentPane());
		btnNewButton_1.setUI(new StyledButtonUI());
		//ajout du JButton a la JFrame
		frmFichier.getContentPane().add(btnNewButton_1);
		
		//declaration JLabel
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBackground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_6, 0, SpringLayout.SOUTH, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_6, -66, SpringLayout.WEST, btnNewButton_1);
		//ajout du label a la JFrame
		frmFichier.getContentPane().add(lblNewLabel_6);
		
		JButton btnNewButton_2 = new JButton("Tout supprimer");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_2, 198, SpringLayout.NORTH, frmFichier.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -24, SpringLayout.NORTH, btnNewButton_2);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				file = null;
				file = new File[3];
				cmp = 0 ;
				
				lblNewLabel.setText("fichier 1 : ");
				lblNewLabel_1.setText("fichier 2 : ");
				lblNewLabel_2.setText("fichier 3 : ");
				
			}
		});
		btnNewButton_2.setBackground(new Color(0xFAF0E6));
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_2, 10, SpringLayout.WEST, frmFichier.getContentPane());
		btnNewButton_2.setUI(new StyledButtonUI());
		frmFichier.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("supprimer");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				for(int i = 0; i <= 2; i++) {
					if (i+1 > 2 ||(file[i+1] == null && file[i] != null)) {
						file[i] = null;
					}
				}

				switch (cmp) {
						
					case 1 :
						lblNewLabel.setText("fichier 1 : ");
						break;
						
					case 2 : 
						lblNewLabel_1.setText("fichier 2 : ");
						break;
							
					case 3 : 
						lblNewLabel_2.setText("fichier 3 : ");
						break;
					}
					cmp = cmp - 1;
			}
		});
		btnNewButton_3.setBackground(new Color(0xFAF0E6));
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_3, 32, SpringLayout.EAST, btnNewButton_2);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_3, 0, SpringLayout.SOUTH, btnNewButton_2);
		btnNewButton_3.setUI(new StyledButtonUI());
		frmFichier.getContentPane().add(btnNewButton_3);
		
		lblNewLabel = new JLabel("Fichier 1 : ");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, btnNewButton);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -23, SpringLayout.NORTH, lblNewLabel_1);
		frmFichier.getContentPane().add(lblNewLabel);
	}
	
	class StyledButtonUI extends BasicButtonUI {

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
}
