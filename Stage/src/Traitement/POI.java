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
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Data.Personne;

public class POI extends ListPersonne{
	
	//instence de la class Condition
	Condition c = new Condition();

	//fonction qui lit un fichier excel donnée et insert les information voulu dans une ArrayList, elle prend le chemin du fichier en argument
	public void lecture(File file)  {
		
		//initialisation 
		XSSFRow row = null;
		XSSFCell cell = null;
		XSSFCell cell1 = null;
		
		String ID;
		String nom;
		String prenom;
		String date;
		String statut;
		String poste;
		String bibliotheque;
		String carte;
		
		int clm_ID = -1;
		int clm_nom = -1;
		int clm_date = -1;
		int clm_statut = -1;
		int clm_poste = -1;
		int clm_bibliotheque = -1;
		int clm_carte = -1;
		
		int cmp_row = 1;
		int totalLigne = 0;
		
		try {
		
		//initialisation
		FileInputStream inputstream = new FileInputStream(file);
		//System.out.println(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		
		for (java.util.Iterator<Row> rowIt = sheet.rowIterator(); rowIt.hasNext();) {
			row = (XSSFRow) rowIt.next();
			totalLigne++;
		}
		//System.out.println(totalLigne);
		
		row = sheet.getRow(1);
		
			//boucle qui va parcourir toute les cellule de la 1ere ligne du fichier
			for (java.util.Iterator<Cell> cellIt = row.cellIterator(); cellIt.hasNext();) {
				cell1 = (XSSFCell) cellIt.next();
			
				
				switch(cell1.getCellType()) {
			
				case STRING :
					// System.out.println("cell S "+cell1.getStringCellValue());
				
					if( (c.nomprenom(cell1.getStringCellValue()) == true) || (cell1.getStringCellValue() == "Nom") ) {
						
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
					
				
					if( (((c.statut(cell1.getStringCellValue()) == true ) && (c.maj(cell1.getStringCellValue()) == true)) || (cell1.getStringCellValue() == "Statue")) && (c.tailleS((cell1.getStringCellValue())) > 4) ) {
					
						clm_statut = cell1.getColumnIndex();
					
					}
				
	
					if( ( (c.biblio(cell1.getStringCellValue()) == true) && (c.maj(cell1.getStringCellValue()) == true) ) || ( (c.tailleS(cell1.getStringCellValue()) == 3) && (c.maj(cell1.getStringCellValue()) == true) ) || (c.b(cell1.getStringCellValue()) == true) || (cell1.getStringCellValue() == "Bibliothèque du lecteur") ) {
					
						clm_bibliotheque = cell1.getColumnIndex();
					}
					

					/*if( ((c.poste(cell1.getStringCellValue()) == true) && (cell1.getColumnIndex() != clm_nom ) && (c.tailleS((cell1.getStringCellValue())) > 4)) || (cell1.getStringCellValue() == "Structure_de_3e_niveau")) {
						clm_poste = cell1.getColumnIndex();
						System.out.println("clm poste "+clm_poste);
					}*/
					
					if( c.poste(cell1.getStringCellValue()) == true) {
						//clm_poste = cell1.getColumnIndex();
						//System.out.println("direction");
					}
					
					if(c.carte(cell1.getStringCellValue()) == true){
						
						clm_carte = cell1.getColumnIndex();
					}
				
			
					break;
				
				case NUMERIC :
					// System.out.println("cell N "+cell1.getNumericCellValue());
					if( (c.tailleN(cell1.getNumericCellValue()) <= 3) ) {
						clm_ID = cell1.getColumnIndex();
						//System.out.println("clm "+cell1.getColumnIndex());
					}
				
				
					if((c.tailleN(cell1.getNumericCellValue()) == 8) && (c.date_naissance(cell1.getNumericCellValue()) == true)) {
						clm_date = cell1.getColumnIndex();
					}
				
					break;
				}
			
		}
			
			
			if(clm_ID == -1) {
				
				do {
					row = sheet.getRow(cmp_row+1);
					for (java.util.Iterator<Cell> cellIt = row.cellIterator(); cellIt.hasNext();) {
					
						cell1 = (XSSFCell) cellIt.next();
						
						if(cell1.getCellType() == CellType.NUMERIC) {
							// System.out.println("cell "+cell1.getNumericCellValue());
					
							if(c.tailleN(cell1.getNumericCellValue()) <= 3) {
								clm_ID = cell1.getColumnIndex();
							}
						}
					}
					cmp_row++;
					
					
				}while(clm_ID == -1 && cmp_row < totalLigne-1);
				
				cmp_row = 1;
				 //System.out.println("clm "+clm_ID);
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
							//System.out.println("cell "+cell1.getStringCellValue());
					
							if((c.tailleN(cell1.getNumericCellValue()) == 8) && (c.date_naissance(cell1.getNumericCellValue()) == true)) {
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
					//System.out.println("cmp "+cmp_row+1);
					for (java.util.Iterator<Cell> cellIt = row.cellIterator(); cellIt.hasNext();) {
					
						cell1 = (XSSFCell) cellIt.next();
						
						if(cell1.getCellType() == CellType.STRING) {
							System.out.println("cell "+c.biblio(cell1.getStringCellValue()));
					
							if( ( (c.biblio(cell1.getStringCellValue()) == true) && (c.maj(cell1.getStringCellValue()) == true) )  || ( (c.tailleS(cell1.getStringCellValue()) == 3) && (c.maj(cell1.getStringCellValue()) == true) ) || (c.b(cell1.getStringCellValue()) == true) ) {
					
								clm_bibliotheque = cell1.getColumnIndex();
							}
						}
					}
					cmp_row++;
				}while(clm_bibliotheque == -1 && cmp_row < totalLigne-1);
				
				cmp_row = 1;
				
			}
			
			
			/*if(clm_carte == -1) {
				
				
				do {
					//System.out.println("oui");
					row = sheet.getRow(cmp_row+1);
					for (java.util.Iterator<Cell> cellIt = row.cellIterator(); cellIt.hasNext();) {
					
						cell1 = (XSSFCell) cellIt.next();
						
						if(cell1.getCellType() == CellType.FORMULA) {
							
							//System.out.println("cell boucle "+cell1.getCellFormula());
							if(c.carte(cell1.getCellFormula()) == true){
								
								clm_carte = cell1.getColumnIndex();
							}
						}
					}
					cmp_row++;
					
				}while((clm_carte == -1) && (cmp_row < totalLigne-1));
				
				cmp_row = 1;
			}*/
			
			
			if(clm_poste == -1) {
				
				do {
					row = sheet.getRow(cmp_row+1);
					for (java.util.Iterator<Cell> cellIt = row.cellIterator(); cellIt.hasNext();) {
					
						cell1 = (XSSFCell) cellIt.next();
						
						if(cell1.getCellType() == CellType.STRING) {
							
							
							if( c.poste(cell1.getStringCellValue()) == true) {
								clm_poste = cell1.getColumnIndex();
					
							}
						}
					}
					cmp_row++;
				}while(clm_poste == -1 && cmp_row < totalLigne-1);
				
				cmp_row = 1;
				
			}
			
			
		row = null;
		for (java.util.Iterator<Row> rowIt = sheet.rowIterator(); rowIt.hasNext();) {
			row = (XSSFRow) rowIt.next();
			
			ID = null;
			nom = null;
			prenom = null;
			date = null;
			statut = null;
			poste = null;
			bibliotheque = null;
			carte = null;
			
			for (java.util.Iterator<Cell> cellIt = row.cellIterator(); cellIt.hasNext();) {
				cell = (XSSFCell) cellIt.next();
				
				
						
						if(cell.getColumnIndex() == clm_nom) {
							
							String separateur, fields[];
							
							
							separateur = ", ";
							fields = cell.getStringCellValue().split(separateur);
							
							nom = fields[0];
							if(fields.length > 1) {
							prenom = fields[1];	
							}
						}
						
						
						if(cell.getColumnIndex() == clm_bibliotheque){
							bibliotheque = cell.getStringCellValue();
						}
													
						
						if(cell.getColumnIndex() == clm_ID){
							if(cell.getCellType() == CellType.STRING) {
								ID = null;
							}
							else {
								int i = (int) cell.getNumericCellValue();
								String chaine = String.valueOf(i);
								ID = chaine;
							}
						}
						
						
						if(cell.getColumnIndex() == clm_statut){
							statut = cell.getStringCellValue();
							//System.out.println("clm statut"+ clm_statut);
						}
						
						
						if(cell.getColumnIndex() == clm_date){
							if(cell.getCellType() == CellType.STRING) {
								date = null;
							}
							else {
								int i = (int) cell.getNumericCellValue();
								String chaine = String.valueOf(i);
								date = chaine;
							}
						}
						
						
						if(cell.getColumnIndex() == clm_poste){
							poste = cell.getStringCellValue();
							//System.out.println("clm poste "+ clm_poste);
						}
						
						
						//System.out.println("clm carte "+ clm_carte);
						/*if(cell.getColumnIndex() == clm_carte){
							carte = cell.getStringCellValue();*/
							//System.out.println("clm carte "+ clm_carte);
						//}
						
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
			
			if(date == null) {
				date = "";
			}
			
			if(statut == null) {
				statut = "";
			}
			
			if(bibliotheque == null) {
				bibliotheque = "";
			}
			
			if(poste == null) {
				poste = "";
			}
			
			if(carte == null) {
				carte = "";
			}
			
			Personne personne = new Personne(ID, nom, prenom, date, statut, bibliotheque, poste, carte);
			add(personne);
			//System.out.println(personne);
			//System.out.println("fin ");
			
			
		}
		
	}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//la fonction ecrire ecrit les données stocké dans l'ArrayList dans un nouveau fichier excel 
	public void ecrire(){
		
		XSSFWorkbook wb;
		XSSFSheet sheet;
		
		wb = new XSSFWorkbook();
		
		for(int k = 0; k < 1; k++) {
			sheet = wb.createSheet("ma feuille "+k);
			
			
			for(int j = 0; j < pr.size(); j++) {
				
				XSSFRow row = sheet.createRow(j);
	    
				for(int i = 0; i < 8; i++) {
					
					XSSFCell cell = row.createCell((short)i);
					if(i == 0) {
						cell.setCellValue("ID"+pr.get(j).getID());
					}
					else if(i == 1) {
						cell.setCellValue(pr.get(j).getNom());
					}
					else if(i == 2) {
						cell.setCellValue(pr.get(j).getPrenom());
					}
					else if(i == 3) {
						cell.setCellValue(pr.get(j).getDate_naissance());
					}
					else if(i == 4) {
						cell.setCellValue(pr.get(j).getstatut());
					}
					else if(i == 5) {
						cell.setCellValue(pr.get(j).getBibliotheque());
					}
					else if(i == 6) {
						cell.setCellValue(pr.get(j).getPoste());
					}
					else if(i == 7) {
						cell.setCellValue(pr.get(j).getNum_carte());
					}
				}
			}
		}
		System.out.println("taille pr "+pr.size());
	  

		
		FileOutputStream fileout;
		DateFormat format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Calendar calendar = Calendar.getInstance();
		
		
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
