package Test;

import java.io.File;

import Traitement.POI;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("fichier_entré/Classeur1.xlsx");
		File file1 = new File("fichier_entré/carte.xlsx");
		File file2 = new File("fichier_entré/liste_evacuation.xlsx");

		POI poi = new POI();
		poi.lectureAEOS(file);
		poi.lectureCarte(file1);
		poi.lectureService(file2);
		poi.ecrire();
	}

}
