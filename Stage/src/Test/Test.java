package Test;

import java.io.File;

import Traitement.POI;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("fichier_entré/Classeur6.xlsx");
		File file1 = new File("fichier_entré/carte.xlsx");
		File file2 = new File("fichier_entré/liste_evacuation.xlsx");
		//System.out.println("file "+file);
		POI poi = new POI();
		poi.lecture1(file);
		poi.lecture2(file1);
		poi.lecture3(file2);
		poi.ecrire();
	}

}
