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
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Data.Personne;

public class POI extends ListPersonne{
	
	//instence de la class Condition
	Condition c = new Condition();

	//fonction qui lit un fichier excel donnée et insert les information voulu dans une ArrayList, elle prend le chemin du fichier en argument
	public void lecture(File file/*, File file2, File file3*/)  {
		
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
		int clm_service = -1;
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
		System.out.println(totalLigne);
		
		row = sheet.getRow(0);
		
			//boucle qui va parcourir toute les cellule de la 1ere ligne du fichier
			for (java.util.Iterator<Cell> cellIt = row.cellIterator(); cellIt.hasNext();) {
				cell1 = (XSSFCell) cellIt.next();
			
				
				System.out.println("type "+cell1.getCellType());
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
					

					if( ((c.poste(cell1.getStringCellValue()) == true) && (cell1.getColumnIndex() != clm_nom ) && (c.tailleS((cell1.getStringCellValue())) > 4)) || (cell1.getStringCellValue() == "Structure_de_3e_niveau")) {
						clm_3 = cell1.getColumnIndex();
						//System.out.println("clm poste "+clm_3);
					}
					
					if( (c.niv_4(cell1.getStringCellValue()) == true) && (clm_3 == cell1.getColumnIndex()-1)){
						clm_4 = cell1.getColumnIndex();
					}
					
					if( (c.service(cell1.getStringCellValue()) == true) && (c.tailleS(cell1.getStringCellValue()) < 4)) {
						//System.out.println("cel"+ cell1.getStringCellValue());
						clm_service = cell1.getColumnIndex();
					}
				
					//System.out.println("taille " +c.tailleS(cell1.getStringCellValue()));
					//System.out.println("cell " +cell1.getStringCellValue());
					if( (c.carte(cell1.getStringCellValue()) == true) && (c.tailleS(cell1.getStringCellValue()) == 14)) {
						
						clm_carte = cell1.getColumnIndex();
					}
					
					//System.out.println("date fin "+c.date_fin(cell1.getStringCellValue()));
				
			
					break;
				
				case NUMERIC :
					// System.out.println("cell N "+cell1.getNumericCellValue());
					if( (c.tailleN(cell1.getNumericCellValue()) <= 3) ) {
						clm_ID = cell1.getColumnIndex();
						//System.out.println("clm "+cell1.getColumnIndex());
					}
					
					if((c.date_fin(cell1.getNumericCellValue()) == true) /*&& (c.caractere(cell1.getNumericCellValue()) == true)*/) {
						clm_date = cell1.getColumnIndex();
					}
				
					break;
					
				case FORMULA :
					clm_carte = cell1.getColumnIndex();
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
					
					//System.out.println("cmp "+cmp_row);
					//System.out.println("ligne "+totalLigne);
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
							
							//System.out.println("cell  "+cell1.getStringCellValue());
							//System.out.println("date fin  "+c.date_fin(cell1.getStringCellValue()));
							//System.out.println("/  "+c.caractere(cell1.getStringCellValue()));
							
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
					//System.out.println("cmp "+cmp_row+1);
					for (java.util.Iterator<Cell> cellIt = row.cellIterator(); cellIt.hasNext();) {
					
						cell1 = (XSSFCell) cellIt.next();
						
						if(cell1.getCellType() == CellType.STRING) {
							//System.out.println("cell "+c.biblio(cell1.getStringCellValue()));
					
							if( ( (c.biblio(cell1.getStringCellValue()) == true) && (c.maj(cell1.getStringCellValue()) == true) )  || ( (c.tailleS(cell1.getStringCellValue()) == 3) && (c.maj(cell1.getStringCellValue()) == true) ) || (c.b(cell1.getStringCellValue()) == true) ) {
					
								clm_bibliotheque = cell1.getColumnIndex();
							}
						}
					}
					cmp_row++;
				}while(clm_bibliotheque == -1 && cmp_row < totalLigne-1);
				
				cmp_row = 1;
				
			}
			
			
			if(clm_carte == -1) {
				
				
				do {
					//System.out.println("oui");
					row = sheet.getRow(cmp_row+1);
					for (java.util.Iterator<Cell> cellIt = row.cellIterator(); cellIt.hasNext();) {
					
						cell1 = (XSSFCell) cellIt.next();
						
						if(cell1.getCellType() == CellType.STRING) {
							
							//System.out.println("taille " +c.tailleS(cell1.getStringCellValue()));
							//System.out.println("cell " +cell1.getStringCellValue());
							if( (c.carte(cell1.getStringCellValue()) == true)  && (c.tailleS(cell1.getStringCellValue()) == 14)) {
								clm_carte = cell1.getColumnIndex();
							}
						}
					}
					cmp_row++;
					
				}while((clm_carte == -1) && (cmp_row < totalLigne-1));
				
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
							
							if( (c.niv_4(cell1.getStringCellValue()) == true) && (clm_3 == cell1.getColumnIndex()-1)){
								clm_4 = cell1.getColumnIndex();
							}
						}
					}
					cmp_row++;
				}while(clm_4 == -1 && cmp_row < totalLigne-1);
				
				cmp_row = 1;
				
			}
			
			
			if(clm_service == -1) {
				
				
				do {
					//System.out.println("oui");
					row = sheet.getRow(cmp_row+1);
					for (java.util.Iterator<Cell> cellIt = row.cellIterator(); cellIt.hasNext();) {
					
						cell1 = (XSSFCell) cellIt.next();
						
						if(cell1.getCellType() == CellType.STRING) {
							
							//System.out.println("clm "+ cell1.getStringCellValue());
							//System.out.println("service "+ c.service(cell1.getStringCellValue()));
							//System.out.println("taille "+ c.tailleS(cell1.getStringCellValue()));
							if( (c.service(cell1.getStringCellValue()) == true) && (c.tailleS(cell1.getStringCellValue()) <= 4)) {
								//System.out.println("clm "+ cell1.getStringCellValue());
								clm_service = cell1.getColumnIndex();
							}
							//System.out.println("clm service "+clm_service);
						}
					}
					cmp_row++;
					
				}while((clm_carte == -1) && (cmp_row < totalLigne-1));
				
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
								//System.out.println("cellule "+ cell.getNumericCellValue());
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
							statut = cell.getStringCellValue();
							//System.out.println("clm statut"+ clm_statut);
						}
						
						
						//System.out.println("clm_date" + clm_date);
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
							niveau_3 = cell.getStringCellValue();
							//System.out.println("clm poste "+ clm_poste);
						}
						
						
						if(cell.getColumnIndex() == clm_4){
							niveau_4 = cell.getStringCellValue();
							//System.out.println("clm poste "+ clm_poste);
						}
						
						
						if(cell.getColumnIndex() == clm_service){
							service = cell.getStringCellValue();
							//System.out.println("clm poste "+ clm_poste);
						}
						
						
						//System.out.println("clm carte "+ clm_carte);
						if(cell.getColumnIndex() == clm_carte){
							
							
							if (c.tailleS(cell.getStringCellValue()) == 14){
								//System.out.println("carte" +cell.getStringCellValue());
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
								carte = chaine;
								//System.out.println("clm carte "+ clm_carte);
							}
							
							else {
								carte = cell.getStringCellValue();
							}
							
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
		CellStyle cellStyle = wb.createCellStyle(); 
		cellStyle.setDataFormat((short)14);
		
		for(int k = 0; k < 1; k++) {
			sheet = wb.createSheet("ma feuille "+k);
			
			
			for(int j = 0; j < pr.size(); j++) {
				
				XSSFRow row = sheet.createRow(j);
	    
				for(int i = 0; i < 10; i++) {
					
					XSSFCell cell = row.createCell((short)i);
					if(i == 0) {
						cell.setCellValue(pr.get(j).getID());
					}
					else if(i == 1) {
						cell.setCellValue(pr.get(j).getNom());
					}
					else if(i == 2) {
						cell.setCellValue(pr.get(j).getPrenom());
					}
					else if(i == 3) {
						
						String chaine = Integer.toString(pr.get(j).getDate_fin());
						char ch = chaine.charAt(0);
						if(ch == '2' && chaine.charAt(1) == '0') {
							cell.setCellValue(pr.get(j).getDate_fin());
						}
						else {
							cell.setCellStyle(cellStyle); 
							cell.setCellValue(pr.get(j).getDate_fin());
						}
					}
					else if(i == 4) {
						cell.setCellValue(pr.get(j).getstatut());
					}
					else if(i == 5) {
						cell.setCellValue(pr.get(j).getBibliotheque());
					}
					else if(i == 6) {
						cell.setCellValue(pr.get(j).getStructure_3e());
					}
					else if(i == 7) {
						cell.setCellValue(pr.get(j).getStructure_4e());
					}
					else if(i == 8) {
						cell.setCellValue(pr.get(j).getService());
					}
					else if(i == 9) {
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
