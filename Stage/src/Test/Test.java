package Test;

import java.io.File;

import Traitement.POI;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("fichier_entré/Classeur2.xlsx");
		//System.out.println("file "+file);
		POI poi = new POI();
		poi.lecture(file);
		poi.ecrire();
	}

}
