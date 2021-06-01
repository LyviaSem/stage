package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicButtonUI;

import Traitement.POI;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class wind {

	//initialisation
	private JFrame frmFichier;
	JLabel lblNewLabel;
	JLabel lblNewLabel_1;
	JLabel lblNewLabel_2;
	JLabel lblNewLabel_3;
	JLabel lblNewLabel_6;
	JRadioButton rdbtnNewRadioButton;
	JRadioButton rdbtnNewRadioButton_1;
	JRadioButton rdbtnNewRadioButton_2;
	JRadioButton rdbtnNewRadioButton_3;
	JRadioButton rdbtnNewRadioButton_4;
	JRadioButton rdbtnNewRadioButton_5;
	JRadioButton rdbtnNewRadioButton_6;
	JRadioButton rdbtnNewRadioButton_7;
	JRadioButton rdbtnNewRadioButton_8;
	private File[] file = new File[3];
	int cmp = 0;
	POI poi = new POI();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wind window = new wind();
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
	public wind() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFichier = new JFrame();
		frmFichier.getContentPane().setBackground(Color.WHITE);
		frmFichier.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\lyvia.semaoune\\git\\stage\\Stage\\src\\Image\\fichier.png"));
		frmFichier.setTitle("Fichier");
		frmFichier.setBounds(100, 100, 813, 336);
		frmFichier.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmFichier.getContentPane().setLayout(springLayout);
		
		JButton btnNewButton = new JButton("S\u00E9lectionner un fichier");
		btnNewButton.setBackground(new Color(0xFAF0E6));
		
		//action du bouton
		btnNewButton.addMouseListener(new MouseAdapter() {
			
			//initialisation JFileChooser
			private JFileChooser fc = new JFileChooser();
			
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
					
				lblNewLabel_6.setText("");
				
				//ajout d'un filtre
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel file", "xlsx");                                
				fc.addChoosableFileFilter(filter);
					
				int val = fc.showOpenDialog(null);
				
				if(val == JFileChooser.APPROVE_OPTION) {
					fc.setMultiSelectionEnabled(true);
					//ajout des fichiers selectionne au tableau 
					if(fc.getSelectedFile() != null) {
						file[cmp] = fc.getSelectedFile();
						cmp += 1;
					}
				}
					
				else {
					System.out.println("erreur");
				}
					
				//ajout des noms des fichiers choisi a la JFrame
				if (file[0] != null && cmp == 1 && lblNewLabel.getText().length() < 13) {
						lblNewLabel.setText(lblNewLabel.getText() + file[0].getName());
				}
				if (file[1] != null && cmp == 2 && lblNewLabel_1.getText().length() < 13) {
						lblNewLabel_1.setText(lblNewLabel_1.getText() + file[1].getName());
				}
				if (file[2] != null && cmp == 3 && lblNewLabel_2.getText().length() < 13) {
						lblNewLabel_2.setText(lblNewLabel_2.getText() + file[2].getName());
				}
					
				//actualise la JFrame
				frmFichier.repaint();						
			}	
		});
		//localisation
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 10, SpringLayout.NORTH, frmFichier.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 20, SpringLayout.WEST, frmFichier.getContentPane());
		btnNewButton.setUI(new StyledButtonUI());
		//ajout du bouton a la JFrame 
		frmFichier.getContentPane().add(btnNewButton);
		
		lblNewLabel = new JLabel("Fichier 1 : ");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, btnNewButton);
		frmFichier.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Fichier 2 : ");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 20, SpringLayout.WEST, frmFichier.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -27, SpringLayout.NORTH, lblNewLabel_1);
		frmFichier.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Fichier 3 : ");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 161, SpringLayout.NORTH, frmFichier.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -31, SpringLayout.NORTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, btnNewButton);
		frmFichier.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Tout supprimer");
		btnNewButton_1.setBackground(new Color(0xFAF0E6));
		//action du boutton 
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//met a null le tableau
				file = null;
				file = new File[3];
				cmp = 0 ;
						
				//enleve les nom des fichier de la JFrame
				lblNewLabel.setText("fichier 1 : ");
				lblNewLabel_1.setText("fichier 2 : ");
				lblNewLabel_2.setText("fichier 3 : ");
						
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 10, SpringLayout.WEST, frmFichier.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -29, SpringLayout.SOUTH, frmFichier.getContentPane());
		btnNewButton_1.setUI(new StyledButtonUI());
		frmFichier.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Supprimer");
		btnNewButton_2.setBackground(new Color(0xFAF0E6));
		//action du boouton 
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
						
				//suprime le dernier fichier entré dans le tableau
				for(int i = 0; i <= 2; i++) {
					if (i+1 > 2 ||(file[i+1] == null && file[i] != null)) {
						file[i] = null;
					}
				}

				//eleve le nom du fichier supprimé de la JFrame
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
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_2, 0, SpringLayout.NORTH, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_2, 20, SpringLayout.EAST, btnNewButton_1);
		btnNewButton_2.setUI(new StyledButtonUI());
		frmFichier.getContentPane().add(btnNewButton_2);
		
		lblNewLabel_3 = new JLabel("Fichier AEOS");
		frmFichier.getContentPane().add(lblNewLabel_3);
		
		rdbtnNewRadioButton = new JRadioButton("Fichier 1");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton, 6, SpringLayout.SOUTH, lblNewLabel_3);
		springLayout.putConstraint(SpringLayout.EAST, rdbtnNewRadioButton, 0, SpringLayout.EAST, lblNewLabel_3);
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBackground(new Color(0xD2B48C));
		buttonGroup.add(rdbtnNewRadioButton);
		//action du radio bouton
		rdbtnNewRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//quand il est selectione il prend une couleur diferrente des autres radio bouton 
				if (buttonGroup.getSelection().getActionCommand() == "fichier 1") {
					rdbtnNewRadioButton.setBackground(new Color(0xD2B48C));
					rdbtnNewRadioButton_1.setBackground(new Color(0xF5DEB3));
					rdbtnNewRadioButton_2.setBackground(new Color(0xF5DEB3));
				}
			}
		});
		rdbtnNewRadioButton.setUI(new StyledButtonUI());
		rdbtnNewRadioButton.setActionCommand("fichier 1");
		frmFichier.getContentPane().add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Fichier 2");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton_1, 0, SpringLayout.NORTH, rdbtnNewRadioButton);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton_1, 27, SpringLayout.EAST, rdbtnNewRadioButton);
		rdbtnNewRadioButton_1.setBackground(new Color(0xF5DEB3));
		buttonGroup.add(rdbtnNewRadioButton_1);
		//action du radio bouton
		rdbtnNewRadioButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (buttonGroup.getSelection().getActionCommand() == "fichier 2") {
					rdbtnNewRadioButton_1.setBackground(new Color(0xD2B48C));
					rdbtnNewRadioButton.setBackground(new Color(0xF5DEB3));
					rdbtnNewRadioButton_2.setBackground(new Color(0xF5DEB3));
				}
			}
		});
		rdbtnNewRadioButton_1.setUI(new StyledButtonUI());
		rdbtnNewRadioButton_1.setActionCommand("fichier 2");
		frmFichier.getContentPane().add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton("Fichier 3");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton_2, 0, SpringLayout.NORTH, rdbtnNewRadioButton);
		rdbtnNewRadioButton_2.setBackground(new Color(0xF5DEB3));
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (buttonGroup.getSelection().getActionCommand() == "fichier 3") {
					rdbtnNewRadioButton_2.setBackground(new Color(0xD2B48C));
					rdbtnNewRadioButton.setBackground(new Color(0xF5DEB3));
					rdbtnNewRadioButton_1.setBackground(new Color(0xF5DEB3));
				}
			}
		});
		rdbtnNewRadioButton_2.setUI(new StyledButtonUI());
		rdbtnNewRadioButton_2.setActionCommand("fichier 3");
		frmFichier.getContentPane().add(rdbtnNewRadioButton_2);
		
		rdbtnNewRadioButton_3 = new JRadioButton("Fichier 1");
		springLayout.putConstraint(SpringLayout.EAST, rdbtnNewRadioButton_3, 0, SpringLayout.EAST, lblNewLabel_3);
		rdbtnNewRadioButton_3.setSelected(true);
		rdbtnNewRadioButton_3.setBackground(new Color(0xD2B48C));
		buttonGroup_1.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (buttonGroup_1.getSelection().getActionCommand() == "fichier 1") {
					rdbtnNewRadioButton_3.setBackground(new Color(0xD2B48C));
					rdbtnNewRadioButton_4.setBackground(new Color(0xF5DEB3));
					rdbtnNewRadioButton_5.setBackground(new Color(0xF5DEB3));
				}
			}
		});
		rdbtnNewRadioButton_3.setUI(new StyledButtonUI());
		rdbtnNewRadioButton_3.setActionCommand("fichier 1");
		frmFichier.getContentPane().add(rdbtnNewRadioButton_3);
		
		rdbtnNewRadioButton_4 = new JRadioButton("Fichier 2");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton_4, 0, SpringLayout.NORTH, rdbtnNewRadioButton_3);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton_4, 0, SpringLayout.WEST, rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_4.setBackground(new Color(0xF5DEB3));
		buttonGroup_1.add(rdbtnNewRadioButton_4);
		rdbtnNewRadioButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (buttonGroup_1.getSelection().getActionCommand() == "fichier 2") {
					rdbtnNewRadioButton_4.setBackground(new Color(0xD2B48C));
					rdbtnNewRadioButton_3.setBackground(new Color(0xF5DEB3));
					rdbtnNewRadioButton_5.setBackground(new Color(0xF5DEB3));
				}
			}
		});
		rdbtnNewRadioButton_4.setUI(new StyledButtonUI());
		rdbtnNewRadioButton_4.setActionCommand("fichier 2");
		frmFichier.getContentPane().add(rdbtnNewRadioButton_4);
		
		JLabel lblNewLabel_4 = new JLabel("Fichier Carte");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton_3, 6, SpringLayout.SOUTH, lblNewLabel_4);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel_4);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, -57, SpringLayout.NORTH, lblNewLabel_4);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_4, -331, SpringLayout.EAST, frmFichier.getContentPane());
		frmFichier.getContentPane().add(lblNewLabel_4);
		
		rdbtnNewRadioButton_5 = new JRadioButton("Fichier 3");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton_5, 48, SpringLayout.SOUTH, rdbtnNewRadioButton_2);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton_5, 28, SpringLayout.EAST, rdbtnNewRadioButton_4);
		springLayout.putConstraint(SpringLayout.EAST, rdbtnNewRadioButton_2, 0, SpringLayout.EAST, rdbtnNewRadioButton_5);
		rdbtnNewRadioButton_5.setBackground(new Color(0xF5DEB3));
		buttonGroup_1.add(rdbtnNewRadioButton_5);
		rdbtnNewRadioButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (buttonGroup_1.getSelection().getActionCommand() == "fichier 3") {
					rdbtnNewRadioButton_5.setBackground(new Color(0xD2B48C));
					rdbtnNewRadioButton_4.setBackground(new Color(0xF5DEB3));
					rdbtnNewRadioButton_3.setBackground(new Color(0xF5DEB3));
				}
			}
		});
		rdbtnNewRadioButton_5.setUI(new StyledButtonUI());
		rdbtnNewRadioButton_5.setActionCommand("fichier 3");
		frmFichier.getContentPane().add(rdbtnNewRadioButton_5);
		
		JLabel lblNewLabel_5 = new JLabel("Fichier Service");
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, -103, SpringLayout.SOUTH, frmFichier.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, -62, SpringLayout.NORTH, lblNewLabel_5);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_5, 0, SpringLayout.WEST, lblNewLabel_3);
		frmFichier.getContentPane().add(lblNewLabel_5);
		
		rdbtnNewRadioButton_6 = new JRadioButton("Fichier 1");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton_6, 8, SpringLayout.SOUTH, lblNewLabel_5);
		springLayout.putConstraint(SpringLayout.EAST, rdbtnNewRadioButton_6, 0, SpringLayout.EAST, lblNewLabel_3);
		rdbtnNewRadioButton_6.setSelected(true);
		rdbtnNewRadioButton_6.setBackground(new Color(0xD2B48C));
		buttonGroup_2.add(rdbtnNewRadioButton_6);
		rdbtnNewRadioButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (buttonGroup_2.getSelection().getActionCommand() == "fichier 1") {
					rdbtnNewRadioButton_6.setBackground(new Color(0xD2B48C));
					rdbtnNewRadioButton_7.setBackground(new Color(0xF5DEB3));
					rdbtnNewRadioButton_8.setBackground(new Color(0xF5DEB3));
				}
			}
		});
		rdbtnNewRadioButton_6.setUI(new StyledButtonUI());
		rdbtnNewRadioButton_6.setActionCommand("fichier 1");
		frmFichier.getContentPane().add(rdbtnNewRadioButton_6);
		
		rdbtnNewRadioButton_7 = new JRadioButton("Fichier 2");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton_7, 0, SpringLayout.NORTH, rdbtnNewRadioButton_6);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton_7, 0, SpringLayout.WEST, rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_7.setBackground(new Color(0xF5DEB3));
		buttonGroup_2.add(rdbtnNewRadioButton_7);
		rdbtnNewRadioButton_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (buttonGroup_2.getSelection().getActionCommand() == "fichier 2") {
					rdbtnNewRadioButton_7.setBackground(new Color(0xD2B48C));
					rdbtnNewRadioButton_6.setBackground(new Color(0xF5DEB3));
					rdbtnNewRadioButton_8.setBackground(new Color(0xF5DEB3));
				}
			}
		});
		rdbtnNewRadioButton_7.setUI(new StyledButtonUI());
		rdbtnNewRadioButton_7.setActionCommand("fichier 2");
		frmFichier.getContentPane().add(rdbtnNewRadioButton_7);

		rdbtnNewRadioButton_8 = new JRadioButton("Fichier 3");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton_8, 0, SpringLayout.NORTH, rdbtnNewRadioButton_6);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton_8, 0, SpringLayout.WEST, rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_8.setBackground(new Color(0xF5DEB3));
		buttonGroup_2.add(rdbtnNewRadioButton_8);
		rdbtnNewRadioButton_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (buttonGroup_2.getSelection().getActionCommand() == "fichier 3") {
					rdbtnNewRadioButton_8.setBackground(new Color(0xD2B48C));
					rdbtnNewRadioButton_7.setBackground(new Color(0xF5DEB3));
					rdbtnNewRadioButton_6.setBackground(new Color(0xF5DEB3));
				}
			}
		});
		rdbtnNewRadioButton_8.setUI(new StyledButtonUI());
		rdbtnNewRadioButton_8.setActionCommand("fichier 3");
		frmFichier.getContentPane().add(rdbtnNewRadioButton_8);
		
		JButton btnNewButton_3 = new JButton("Envoyer");
		btnNewButton_3.setBackground(new Color(0xFAF0E6));
		btnNewButton_3.addMouseListener(new MouseAdapter() {
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
					lblNewLabel_6.setText("fichier : " + poi.file +" a étécréé");
					frmFichier.repaint();
				}
				else {
					lblNewLabel_6.setForeground(Color.RED);
					lblNewLabel_6.setText("ERREUR");
				}
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_3, -10, SpringLayout.SOUTH, frmFichier.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_3, -37, SpringLayout.EAST, frmFichier.getContentPane());
		btnNewButton_3.setUI(new StyledButtonUI());
		frmFichier.getContentPane().add(btnNewButton_3);
		
		lblNewLabel_6 = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 4, SpringLayout.NORTH, btnNewButton_3);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_6, -81, SpringLayout.WEST, btnNewButton_3);
		frmFichier.getContentPane().add(lblNewLabel_6);
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
