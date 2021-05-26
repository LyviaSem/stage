package Traitement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Data.Personne;

public class POI extends ListPersonne{
	
	//instence de la class Condition
	Condition c = new Condition();

	//fonction qui lit un fichier excel donn�e et insert les informations voulu dans une ArrayList, elle prend le chemin du fichier en argument
	public void lecture1(File file)  {
		
		//initialisation 
		XSSFRow row = null;
		XSSFCell cell = null;
		XSSFCell cell1 = null;
		
		String ID;
		String nom;
		String prenom;
		int date;
		String statut;
		String bibliotheque;
		String niveau_3;
		String niveau_4;
		String service;
		String carte;
		
		int clm_ID = -1;
		int clm_nom = -1;
		int clm_date = -1;
		int clm_statut = -1;
		int clm_3 = -1;
		int clm_4 = -1;
		int clm_bibliotheque = -1;
		
		int cmp_row = 0;
		int totalLigne = 0;
		
		try {
		
			//initialisation
			FileInputStream inputstream = new FileInputStream(file);
		
			XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		
			XSSFSheet sheet = workbook.getSheetAt(0);
		
		
			for (java.util.Iterator<Row> rowIt = sheet.rowIterator(); rowIt.hasNext();) {
				row = (XSSFRow) rowIt.next();
				totalLigne++;
			}
			
			if(clm_ID == -1) {
			
				do {
					row = sheet.getRow(cmp_row+1);
					for (java.util.Iterator<Cell> cellIt = row.cellIterator(); cellIt.hasNext();) {
					
						cell1 = (XSSFCell) cellIt.next();
						
						if(cell1.getCellType() == CellType.NUMERIC) {
					
							if(c.tailleN(cell1.getNumericCellValue()) <= 3) {
								clm_ID = cell1.getColumnIndex();
							}
						}
					}
					cmp_row++;
						
				}while(clm_ID == -1 && cmp_row < totalLigne-1);
				
				cmp_row = 1;
			}
			
			
			if(clm_nom == -1) {
				
				do {
					row = sheet.getRow(cmp_row+1);
					for (java.util.Iterator<Cell> cellIt = row.cellIterator(); cellIt.hasNext();) {
					
						cell1 = (XSSFCell) cellIt.next();
						
						if(cell1.getCellType() == CellType.STRING) {
							
							if(c.nomprenom(cell1.getStringCellValue()) == true) {
								
								String separateur, fields[];
								int compteur = 0;
								for(int j = 0; j < cell1.getStringCellValue().length()-1; j++){
									char ch = cell1.getStringCellValue().charAt(j);
									if((Character.isUpperCase(ch)) && (Character.isUpperCase(cell1.getStringCellValue().charAt(j+1)))){
										compteur++;
									}
								}
								
								if(compteur >= 1) {
									clm_nom = cell1.getColumnIndex();
								}
							}
						}
					}
					cmp_row++;
				}while(clm_nom == -1 && cmp_row < totalLigne-1);
				
				cmp_row = 1;
			}
			
			
			
			if(clm_date == -1) {
				
				do {
					row = sheet.getRow(cmp_row+1);
					for (java.util.Iterator<Cell> cellIt = row.cellIterator(); cellIt.hasNext();) {
					
						cell1 = (XSSFCell) cellIt.next();
						
						if(cell1.getCellType() == CellType.NUMERIC) {
							
							
							if( (c.date_fin(cell1.getNumericCellValue()) == true) /*&& (c.caractere(cell1.getNumericCellValue()) == true)*/) {
								clm_date = cell1.getColumnIndex();
							}
						}
					}
					cmp_row++;
				}while(clm_date == -1 && cmp_row < totalLigne-1);
				
				cmp_row = 1;
				
			}
			
			
			if(clm_statut == -1) {
				
				do {
					row = sheet.getRow(cmp_row+1);
					for (java.util.Iterator<Cell> cellIt = row.cellIterator(); cellIt.hasNext();) {
					
						cell1 = (XSSFCell) cellIt.next();
						
						if(cell1.getCellType() == CellType.STRING) {
							
					
							if( (c.statut(cell1.getStringCellValue()) == true ) && (c.maj(cell1.getStringCellValue()) == true) && (c.tailleS((cell1.getStringCellValue())) > 4) ) {
								
								clm_statut = cell1.getColumnIndex();
							
							}
						}
					}
					cmp_row++;
				}while(clm_statut == -1 && cmp_row < totalLigne-1);
				
				cmp_row = 1;
			}
			
			
			if(clm_bibliotheque == -1) {
				
				do {
					row = sheet.getRow(cmp_row+1);
		
					for (java.util.Iterator<Cell> cellIt = row.cellIterator(); cellIt.hasNext();) {
					
						cell1 = (XSSFCell) cellIt.next();
						
						if(cell1.getCellType() == CellType.STRING) {
					
							if( ( (c.biblio(cell1.getStringCellValue()) == true) && (c.maj(cell1.getStringCellValue()) == true) )  || ( (c.tailleS(cell1.getStringCellValue()) == 3) && (c.maj(cell1.getStringCellValue()) == true) ) ) {
					
								clm_bibliotheque = cell1.getColumnIndex();
							}
						}
					}
					cmp_row++;
				}while(clm_bibliotheque == -1 && cmp_row < totalLigne-1);
				
				cmp_row = 1;
				
			}
			
			
			
			
			if(clm_3 == -1) {
				
				do {
					row = sheet.getRow(cmp_row+1);
					for (java.util.Iterator<Cell> cellIt = row.cellIterator(); cellIt.hasNext();) {
					
						cell1 = (XSSFCell) cellIt.next();
						
						if(cell1.getCellType() == CellType.STRING) {
							
							
							if( c.poste(cell1.getStringCellValue()) == true) {
								clm_3 = cell1.getColumnIndex();
					
							}
						}
					}
					cmp_row++;
				}while(clm_3 == -1 && cmp_row < totalLigne-1);
				
				cmp_row = 1;
				
			}
			
			
			if(clm_4 == -1) {
				
				do {
					row = sheet.getRow(cmp_row+1);
					for (java.util.Iterator<Cell> cellIt = row.cellIterator(); cellIt.hasNext();) {
					
						cell1 = (XSSFCell) cellIt.next();
						
						if(cell1.getCellType() == CellType.STRING) {
							
							if( ((c.niv_4(cell1.getStringCellValue()) == true) && (clm_3 == cell1.getColumnIndex()-1))){
								clm_4 = cell1.getColumnIndex();
							}
							else if(clm_3 != -1 && clm_3 == cell1.getColumnIndex()-1 && row.getCell(cell1.getColumnIndex()).getCellType() == CellType.STRING){
								clm_4 = clm_3+1;
							}
						}
					}
					cmp_row++;
				}while(clm_4 == -1 && cmp_row < totalLigne-1);
				
				cmp_row = 1;
				
			}
			
			
			
			row = null;
			for (java.util.Iterator<Row> rowIt = sheet.rowIterator(); rowIt.hasNext();) {
				row = (XSSFRow) rowIt.next();
			
				ID = null;
				nom = null;
				prenom = null;
				date = 0;
				statut = null;
				niveau_3 = null;
				niveau_4 = null;
				service = null;
				bibliotheque = null;
				carte = null;
			
				for (java.util.Iterator<Cell> cellIt = row.cellIterator(); cellIt.hasNext();) {
					cell = (XSSFCell) cellIt.next();
								
					if(cell.getColumnIndex() == clm_nom) {
							
						String separateur, fields[];
							
							
						separateur = ", ";
						fields = cell.getStringCellValue().toLowerCase().split(separateur);
							
						fields[0] = fields[0].replaceAll("�", "e");
						fields[0] = fields[0].replaceAll("�", "e");
						fields[0] = fields[0].replaceAll("�", "e");
						fields[0] = fields[0].replaceAll("�", "c");
						fields[0] = fields[0].replaceAll("�", "a");
						nom = fields[0];
						if(fields.length > 1) {
							fields[0] = fields[0].replaceAll("�", "e");
							fields[0] = fields[0].replaceAll("�", "e");
							fields[0] = fields[0].replaceAll("�", "e");
							fields[0] = fields[0].replaceAll("�", "c");
							fields[0] = fields[0].replaceAll("�", "a");
							fields[1] = fields[1].replaceAll("\\s", "");
							prenom = fields[1];	
						}
					}
						
						
					if(cell.getColumnIndex() == clm_bibliotheque){
							
						String str = cell.getStringCellValue().toLowerCase();
						str = str.replaceAll("�", "e");
						str = str.replaceAll("�", "e");
						str = str.replaceAll("�", "e");
						str = str.replaceAll("�", "c");
						str = str.replaceAll("�", "a");
						bibliotheque = str;
					}
													
						
					if(cell.getColumnIndex() == clm_ID){
						if(cell.getCellType() == CellType.STRING) {
							ID = null;
						}
						else {
							int i = (int) cell.getNumericCellValue();
							String chaine = String.valueOf(i);
							if(chaine.length() < 6) {
								int var = 6 - chaine.length()  ;
									
								for(int j = 0; j < var; j++) {
									chaine = "0"+chaine;
								}
							}
							ID = "ID"+chaine;
						}
					}
						
						
					if(cell.getColumnIndex() == clm_statut){
							
						String str = cell.getStringCellValue().toLowerCase();
						str = str.replaceAll("�", "e");
						str = str.replaceAll("�", "e");
						str = str.replaceAll("�", "e");
						str = str.replaceAll("�", "c");
						str = str.replaceAll("�", "a");
						statut = str;
					}
						

					if(cell.getColumnIndex() == clm_date){
						if(cell.getCellType() == CellType.STRING) {
							date = 0;
						}
						else {
							int i = (int) cell.getNumericCellValue();
							date = i;
						}
					}
						
						
					if(cell.getColumnIndex() == clm_3){
								
						String str = cell.getStringCellValue().toLowerCase();
						str = str.replaceAll("�", "e");
						str = str.replaceAll("�", "e");
						str = str.replaceAll("�", "e");
						str = str.replaceAll("�", "c");
						str = str.replaceAll("�", "a");
						niveau_3 = str;;
					}
						
						
					if(cell.getColumnIndex() == clm_4){
				
						String str = cell.getStringCellValue().toLowerCase();
						str = str.replaceAll("�", "e");
						str = str.replaceAll("�", "e");
						str = str.replaceAll("�", "e");
						str = str.replaceAll("�", "c");
						str = str.replaceAll("�", "a");
						niveau_4 = str;
					}		
				}
			
				if(ID == null) {
					ID = "";
				}
			
				if(nom == null) {
					nom = "";
				}
			
				if(prenom == null) {
					prenom = "";
				}
			
				if(date == 0) {
					date = 0;
				}
			
				if(statut == null) {
					statut = "";
				}
			
				if(bibliotheque == null) {
					bibliotheque = "";
				}
				
				if(niveau_3 == null) {
					niveau_3 = "";
				}
			
				if(niveau_4 == null) {
					niveau_4 = "";
				}
			
				if(service == null) {
					service = "";
				}
			
				if(carte == null) {
					carte = "";
				}
			
				Personne personne = new Personne(ID, nom, prenom, date, statut, bibliotheque, niveau_3, niveau_4, service, carte);
				add(personne);

			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	//fonction qui lit un fichier excel donn�e et insert les informations voulu dans une ArrayList, elle prend le chemin du fichier en argument
	public void lecture2(File file) {
		
		//initialisation
		XSSFRow row = null;
		XSSFCell cell = null;
		XSSFCell cell1 = null;
		
		int clm_nom = -1;
		int clm_prenom = -1;
		int clm_carte = -1;
		
		int cmp_row = 1;
		int totalLigne = 0;
		
		try {
		
		FileInputStream inputstream = new FileInputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		
		//on compte le nombre de ligne du fichier
		for (java.util.Iterator<Row> rowIt = sheet.rowIterator(); rowIt.hasNext();) {
			row = (XSSFRow) rowIt.next();
			totalLigne++;
		}		
			
		//on recherche la colone des nom et celle des pr�nom pour facilit� la comparaison avec les nom de l'arraylist
			if(clm_nom == -1) {
				
				do {
					//pour chaque ligne
					row = sheet.getRow(cmp_row);
					
					//pour chaque cellule
					for (java.util.Iterator<Cell> cellIt = row.cellIterator(); cellIt.hasNext();) {
					
						cell1 = (XSSFCell) cellIt.next();
						
							
						if(cell1.getCellType() == CellType.STRING &&  cellIt.hasNext() == true && row.getCell(cell1.getColumnIndex()+1).getCellType() == CellType.STRING ) {
								
							//on compare la cellule courante et la suivante a chaque nom et pr�nom contenu dans l'arraylist 
							for(int i = 1; i < pr.size(); i++) {
								if(  pr.get(i).getPrenom().equals(cell1.getStringCellValue().toLowerCase()) &&  pr.get(i).getNom().equals(row.getCell(cell1.getColumnIndex()+1).getStringCellValue().toLowerCase())) {	
									clm_prenom = cell1.getColumnIndex();
									clm_nom = cell1.getColumnIndex()+1;
								}
							}
						}
					}
					cmp_row++;
				}while(clm_nom == -1 && cmp_row < totalLigne-1);
				
				cmp_row = 1;
			}
			
			
			
			
			
			//on recherche la colone des num�ro de carte dans le fichier
			if(clm_carte == -1) {
				
				
				do {
					//pour chaque lignes
					row = sheet.getRow(cmp_row+1);
					
					//pour cghaque cellules
					for (java.util.Iterator<Cell> cellIt = row.cellIterator(); cellIt.hasNext();) {
					
						cell1 = (XSSFCell) cellIt.next();
						
						if(cell1.getCellType() == CellType.STRING) {
							if( (c.carte(cell1.getStringCellValue()) == true)  && (c.tailleS(cell1.getStringCellValue()) == 14)) {
								clm_carte = cell1.getColumnIndex();
							}
						}
					}
					cmp_row++;
					
				}while((clm_carte == -1) && (cmp_row < totalLigne-1));
				
				cmp_row = 1;
			}
			
			
			
			
			
		row = null;
		
		//on parcour toutes les lignes
		for (java.util.Iterator<Row> rowIt = sheet.rowIterator(); rowIt.hasNext();) {
			row = (XSSFRow) rowIt.next();
			
			//et toutes les cellules
			for (java.util.Iterator<Cell> cellIt = row.cellIterator(); cellIt.hasNext();) {
				cell = (XSSFCell) cellIt.next();
				
						
				if(cell.getCellType() == CellType.STRING && cell.getStringCellValue() != null && (clm_carte != -1 && clm_nom != -1 && clm_prenom != -1)) {
						for(int j = 0; j < pr.size(); j++) {
							
							if( (cell.getColumnIndex() == clm_carte) && (pr.get(j).getPrenom().equals(row.getCell(clm_prenom).getStringCellValue().toLowerCase())) && (pr.get(j).getNom().equals(row.getCell(clm_nom).getStringCellValue().toLowerCase())) ){
							
								if (c.tailleS(cell.getStringCellValue()) == 14){
									String c = cell.getStringCellValue();
									String sep;
									int a = 0;
									int b = 2;
									String chaine = "";
									
									for(int i = 0; i < c.length(); i += 2) {
										sep = c.substring(a,b);
										a += 2;
										b += 2;
								
										chaine = sep + chaine ;
									}
									pr.get(j).setNum_carte(chaine);
								}
								
								else {
									pr.get(j).setNum_carte(cell.getStringCellValue());
								}
							}
						}
					}	
				}
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	//fonction qui lit un fichier excel donn�e et insert les informations voulu dans une ArrayList, elle prend le chemin du fichier en argument
	public void lecture3(File file) {
		
		//initailisation 
		XSSFRow row = null;
		XSSFCell cell = null;
		XSSFCell cell1 = null;
	
		
		int clm_nom = -1;
		int clm_prenom = -1;
		int clm_service = -1;
		
		int cmp_row = 1;
		int cmp_sheet = 0;
		int totalLigne = 0;
		
		try {
		
		
		FileInputStream inputstream = new FileInputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		
		//on compte le nombre de ligne du fichier
		for (java.util.Iterator<Row> rowIt = sheet.rowIterator(); rowIt.hasNext();) {
			row = (XSSFRow) rowIt.next();
			totalLigne++;
		}
		
			
			//on recherche la colone des nom et celle des pr�nom pour facilit� la comparaison avec les nom de l'arraylist
			if(clm_nom == -1 && clm_prenom == -1) {
				
				do {
					//pour chaque ligne
					row = sheet.getRow(cmp_row);
					
					//pour chaque cellule
					for (java.util.Iterator<Cell> cellIt = row.cellIterator(); cellIt.hasNext();) {
					
						cell1 = (XSSFCell) cellIt.next();
						
						if(cell1.getCellType() == CellType.STRING && row.getCell(cell1.getColumnIndex()+1).getCellType() == CellType.STRING ) {
							
							//on compare la cellule courante et la suivante � chaque nom et pr�nom contenu dans l'arraylist 
							for(int i = 1; i < pr.size(); i++) {
								if(  pr.get(i).getNom().equals(cell1.getStringCellValue().toLowerCase()) &&  pr.get(i).getPrenom().equals(row.getCell(cell1.getColumnIndex()+1).getStringCellValue().toLowerCase())) {	
							
									clm_nom = cell1.getColumnIndex();
									clm_prenom = cell1.getColumnIndex()+1;
								}
							}
						}
					}
					cmp_row++;
				}while(clm_nom == -1 && cmp_row < totalLigne-2);
				cmp_row = 1;
			}
			
			
			
			//on recherche la colone des service dans le fichier
			if(clm_service == -1) {
				
				do {
					//pour chaque ligne
					row = sheet.getRow(cmp_row);
					
					//pour chaque cellule
					for (java.util.Iterator<Cell> cellIt = row.cellIterator(); cellIt.hasNext();) {
					
						cell1 = (XSSFCell) cellIt.next();
						
						if(cell1.getCellType() == CellType.STRING) {
							
							if( (c.service(cell1.getStringCellValue()) == true) && (c.tailleS(cell1.getStringCellValue()) <= 4)) {
								clm_service = cell1.getColumnIndex();
							}
						}
					}
					cmp_row++;
					
				}while((clm_service == -1) && (cmp_row < totalLigne-1));
				
				cmp_row = 1;
			}
			
			
			row = null;
			
			//on parcoure toute les feuilles
			for(java.util.Iterator<Sheet> sheetIt = workbook.sheetIterator(); sheetIt.hasNext();) {
				sheet = (XSSFSheet) sheetIt.next();
				
				//toute les lignes
				for (java.util.Iterator<Row> rowIt = sheet.rowIterator(); rowIt.hasNext();) {
					row = (XSSFRow) rowIt.next();
		
			
					//et toute les cellules
					for (java.util.Iterator<Cell> cellIt = row.cellIterator(); cellIt.hasNext();) {
						cell = (XSSFCell) cellIt.next();
				
						if((cell.getCellType() == CellType.STRING) && (cell.getStringCellValue() != null) && (clm_service != -1 && clm_nom != -1 && clm_prenom != -1) ) {
						
							//comparaison avec tout les �l�ments de l'arraylist
							for(int j = 0; j < pr.size(); j++) {
							
								//si les nom pr�nom du fichier corresponde au nom pr�nom de l'�lement de l'arraylist l'�l�ment est ajout�
								if( (cell.getColumnIndex() == clm_service) && (pr.get(j).getPrenom().equals(row.getCell(clm_prenom).getStringCellValue().toLowerCase())) && (pr.get(j).getNom().equals(row.getCell(clm_nom).getStringCellValue().toLowerCase())) ){
									pr.get(j).setService(cell.getStringCellValue());
								}	
							}
						}
					}
				}
			}
		}
		
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	//la fonction ecrire ecrit les donn�es stock� dans l'ArrayList dans un nouveau fichier excel 
	public void ecrire(){
		
		//initailisation
		XSSFWorkbook wb;
		XSSFSheet sheet;
		
		wb = new XSSFWorkbook();
		CellStyle cellStyle = wb.createCellStyle(); 
		cellStyle.setDataFormat((short)14);
		
		//on cr�e une feuille
		sheet = wb.createSheet("ma feuille "+1);
			
			
		for(int j = 0; j < pr.size(); j++) {
			
			//pour chaque �l�ment de l'ArrayList on cr�� une ligne  
			XSSFRow row = sheet.createRow(j);
			
	    
			//on remplie ensuite chaque celule avec un switch case
			for(int i = 0; i <= 9; i++) {
			
				XSSFCell cell = row.createCell((short)i);
				
				switch(i) {
				
				case 0 : 
					cell.setCellValue(pr.get(j).getID());
					break;
					
				case 1 :
					cell.setCellValue(pr.get(j).getNom().toLowerCase());
					break;

				case 2 : 
					cell.setCellValue(pr.get(j).getPrenom().toLowerCase());
					break;

				case 3 : 
					String chaine = Integer.toString(pr.get(j).getDate_fin());
					char ch = chaine.charAt(0);
					if(ch == '2' && chaine.charAt(1) == '0') {
						cell.setCellValue(pr.get(j).getDate_fin());
					}
					else {
						cell.setCellStyle(cellStyle); 
						cell.setCellValue(pr.get(j).getDate_fin());
					}
					break;

				case 4 : 
					cell.setCellValue(pr.get(j).getstatut().toLowerCase());
					break;

				case 5 : 
					cell.setCellValue(pr.get(j).getBibliotheque().toLowerCase());
					break;

				case 6 : 
					cell.setCellValue(pr.get(j).getStructure_3e().toLowerCase());
					break;

				case 7 : 
					cell.setCellValue(pr.get(j).getStructure_4e().toLowerCase());
					break;

				case 8 : 
					cell.setCellValue(pr.get(j).getService());
					break;

				case 9 : 
					cell.setCellValue(pr.get(j).getNum_carte());
					break;
				} 
			}
		}
		
		pr.clear();

		
		FileOutputStream fileout;
		DateFormat format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Calendar calendar = Calendar.getInstance();
		System.out.println("fin");
		
		
		try {
			fileout = new FileOutputStream("fichier_sortie/personne" + format.format(calendar.getTime()) + ".xlsx");
			wb.write(fileout);
			fileout.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
