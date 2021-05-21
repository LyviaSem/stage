package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import Traitement.POI;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.Color;

public class Window {

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
		
		frmFichier = new JFrame();
		frmFichier.getContentPane().setBackground(Color.WHITE);
		frmFichier.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\lyvia.semaoune\\git\\stage\\Stage\\src\\Image\\fichier.png"));
		frmFichier.setTitle("Fichier");
		frmFichier.setBounds(100, 100, 791, 352);
		frmFichier.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frmFichier.getContentPane().setLayout(springLayout);
		
		JButton btnNewButton = new JButton("Selectioner un fichier");
		btnNewButton.addMouseListener(new MouseAdapter() {
			
			private JFileChooser fc = new JFileChooser();
			
			public void mouseClicked(MouseEvent e) {
					
					lblNewLabel_6.setText("");
					// TODO Auto-generated method stub
					//Object source = e.getSource();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel file", "xlsx");                                
					fc.addChoosableFileFilter(filter);
					
					//fc.setMultiSelectionEnabled(true);
					int val = fc.showOpenDialog(null);
					
					for(int i = 0; i < file.length; i++) {
						System.out.println(file[i]);
					}
					
				
					if(val == JFileChooser.APPROVE_OPTION) {
						fc.setMultiSelectionEnabled(true);
						file[cmp] = fc.getSelectedFile();
					}
					
					else {
						System.out.println("erreur");
					}
					
					cmp += 1;
					
					if (file[0] != null && cmp == 1) {
						lblNewLabel.setText(lblNewLabel.getText() + file[0].getName());
					}
					if (file[1] != null && cmp == 2) {
						lblNewLabel_1.setText(lblNewLabel_1.getText() + file[1].getName());
					}
					if (file[2] != null && cmp == 3) {
						lblNewLabel_2.setText(lblNewLabel_2.getText() + file[2].getName());
					}
					
					 frmFichier.repaint();					
					
			}	
			
		});
		
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 28, SpringLayout.NORTH, frmFichier.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 10, SpringLayout.WEST, frmFichier.getContentPane());
		frmFichier.getContentPane().add(btnNewButton);
		
		lblNewLabel = new JLabel("Fichier 1 : ");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 26, SpringLayout.SOUTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, btnNewButton);
		frmFichier.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Fichier 2 : ");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 29, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, btnNewButton);
		frmFichier.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Fichier 3 : ");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 30, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, btnNewButton);
		frmFichier.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fichier AEOS :");
		frmFichier.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Fichier Carte :");
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_3, 0, SpringLayout.EAST, lblNewLabel_4);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 0, SpringLayout.NORTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_4, 335, SpringLayout.EAST, lblNewLabel_1);
		frmFichier.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Fichier Service :");
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_5, 0, SpringLayout.EAST, lblNewLabel_3);
		frmFichier.getContentPane().add(lblNewLabel_5);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Fichier 1");
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, -6, SpringLayout.NORTH, rdbtnNewRadioButton);
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setActionCommand("fichier 1");;
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton, 0, SpringLayout.NORTH, lblNewLabel);
		buttonGroup.add(rdbtnNewRadioButton);
		frmFichier.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Fichier 2");
		rdbtnNewRadioButton_1.setBackground(Color.WHITE);
		rdbtnNewRadioButton_1.setActionCommand("fichier 2");;
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton_1, -4, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton_1, 44, SpringLayout.EAST, rdbtnNewRadioButton);
		buttonGroup.add(rdbtnNewRadioButton_1);
		frmFichier.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Fichier 3 ");
		rdbtnNewRadioButton_2.setBackground(Color.WHITE);
		rdbtnNewRadioButton_2.setActionCommand("fichier 3");;
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton_2, -4, SpringLayout.NORTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton_2, 46, SpringLayout.EAST, rdbtnNewRadioButton_1);
		buttonGroup.add(rdbtnNewRadioButton_2);
		frmFichier.getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Fichier 1");
		rdbtnNewRadioButton_3.setSelected(true);
		rdbtnNewRadioButton_3.setBackground(Color.WHITE);
		rdbtnNewRadioButton_3.setActionCommand("fichier 1");;
		springLayout.putConstraint(SpringLayout.EAST, rdbtnNewRadioButton, 0, SpringLayout.EAST, rdbtnNewRadioButton_3);
		buttonGroup_1.add(rdbtnNewRadioButton_3);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton_3, 6, SpringLayout.SOUTH, lblNewLabel_4);
		springLayout.putConstraint(SpringLayout.EAST, rdbtnNewRadioButton_3, -353, SpringLayout.EAST, frmFichier.getContentPane());
		frmFichier.getContentPane().add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Fichier 2");
		rdbtnNewRadioButton_4.setBackground(Color.WHITE);
		rdbtnNewRadioButton_4.setActionCommand("fichier 2");;
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton_4, 0, SpringLayout.NORTH, rdbtnNewRadioButton_3);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton_4, 0, SpringLayout.WEST, rdbtnNewRadioButton_1);
		buttonGroup_1.add(rdbtnNewRadioButton_4);
		frmFichier.getContentPane().add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Fichier 3 ");
		rdbtnNewRadioButton_5.setBackground(Color.WHITE);
		rdbtnNewRadioButton_5.setActionCommand("fichier 3");;
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton_5, 0, SpringLayout.NORTH, rdbtnNewRadioButton_3);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton_5, 0, SpringLayout.WEST, rdbtnNewRadioButton_2);
		buttonGroup_1.add(rdbtnNewRadioButton_5);
		frmFichier.getContentPane().add(rdbtnNewRadioButton_5);
		
		JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("Fichier 1 ");
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, -10, SpringLayout.NORTH, rdbtnNewRadioButton_6);
		rdbtnNewRadioButton_6.setSelected(true);
		rdbtnNewRadioButton_6.setActionCommand("fichier 1");;
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton_6, 212, SpringLayout.NORTH, frmFichier.getContentPane());
		rdbtnNewRadioButton_6.setBackground(Color.WHITE);
		buttonGroup_2.add(rdbtnNewRadioButton_6);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton_6, 0, SpringLayout.WEST, rdbtnNewRadioButton_3);
		frmFichier.getContentPane().add(rdbtnNewRadioButton_6);
		
		JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("Fichier 2 ");
		rdbtnNewRadioButton_7.setBackground(Color.WHITE);
		rdbtnNewRadioButton_7.setActionCommand("fichier 2");;
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton_7, 0, SpringLayout.NORTH, rdbtnNewRadioButton_6);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton_7, 0, SpringLayout.WEST, rdbtnNewRadioButton_1);
		buttonGroup_2.add(rdbtnNewRadioButton_7);
		frmFichier.getContentPane().add(rdbtnNewRadioButton_7);
		
		JRadioButton rdbtnNewRadioButton_8 = new JRadioButton("Fichier 3");
		rdbtnNewRadioButton_8.setBackground(Color.WHITE);
		rdbtnNewRadioButton_8.setActionCommand("fichier 3");;
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnNewRadioButton_8, 0, SpringLayout.NORTH, rdbtnNewRadioButton_6);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnNewRadioButton_8, 0, SpringLayout.WEST, rdbtnNewRadioButton_2);
		buttonGroup_2.add(rdbtnNewRadioButton_8);
		frmFichier.getContentPane().add(rdbtnNewRadioButton_8);
		
		JButton btnNewButton_1 = new JButton("Envoyer");
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
				for(int i = 0; i < file.length; i++) {
					System.out.println(file[i]);
				}
				
				
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
		frmFichier.getContentPane().add(btnNewButton_1);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBackground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_6, 0, SpringLayout.SOUTH, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_6, -66, SpringLayout.WEST, btnNewButton_1);
		frmFichier.getContentPane().add(lblNewLabel_6);
	}
	
}
