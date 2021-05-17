package Test;

import java.io.File;

import javax.swing.JFileChooser;

public class JfileChooser {
	
	 public static void main(String[] argv) {
		 JFileChooser choix = new JFileChooser();

		    choix.setMultiSelectionEnabled(true) ;

		    int retour = choix.showOpenDialog(null);

		    System.out.println(retour);
		    System.out.println(JFileChooser.APPROVE_OPTION);
		    
		    if(retour == JFileChooser.APPROVE_OPTION) {

		       // des fichiers ont été choisis ( sortie par OK)

		       File [] fs = choix.getSelectedFiles();

		       for( int i = 0; i < fs.length; ++i) {

		    	   System.out.println( fs[i].getName());        // nom du fichier

		                                      // choisi

		             fs[i].getAbsolutePath(); // chemin absolu du

		                                      // fichier choisi

		 

		    }
		    }
	 }

}
