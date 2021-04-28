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
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Data.Personne;

public class POI extends ListPersonne{
	
	Condition c = new Condition();

	public void lecture(File file)  {
		
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
		int a = 0;
		
		try {
		
		FileInputStream inputstream = new FileInputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		row = sheet.getRow(0);


			for (java.util.Iterator<Cell> cellIt = row.cellIterator(); cellIt.hasNext();) {
				cell1 = (XSSFCell) cellIt.next();
			
				
				switch(cell1.getCellType()) {
			
				case STRING :
				
					if(c.nomprenom(cell1.getStringCellValue()) == true) {
						//System.out.println(cell.getStringCellValue());
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
					
				
					if( (c.statut(cell1.getStringCellValue()) == true ) && (c.maj(cell1.getStringCellValue()) == true) ) {
					
						clm_statut = cell1.getColumnIndex();
					
					}
				
	
					if( ( (c.biblio(cell1.getStringCellValue()) == true) && (c.maj(cell1.getStringCellValue()) == true) )  || (c.b(cell1.getStringCellValue()) == true) ) {
					
						clm_bibliotheque = cell1.getColumnIndex();
					}
					

					if( (c.poste(cell1.getStringCellValue()) == true) && (cell1.getColumnIndex() != clm_nom ) ) {
						clm_poste = cell1.getColumnIndex();
					}
					
				
			
					break;
				
				case NUMERIC :
				
					if(c.tailleN(cell1.getNumericCellValue()) == 6) {
						clm_ID = cell1.getColumnIndex();
					}
				
				
					if((c.tailleN(cell1.getNumericCellValue()) == 8) && (c.date_naissance(cell1.getNumericCellValue()) == true)) {
						clm_date = cell1.getColumnIndex();
					}
				
					break;
				}
			
			}
			
			
			if(clm_ID == -1) {
				
				do {
					row = sheet.getRow(a+1);
					for (java.util.Iterator<Cell> cellIt = row.cellIterator(); cellIt.hasNext();) {
					
						cell1 = (XSSFCell) cellIt.next();
						
						if(cell1.getCellType() == CellType.NUMERIC) {
							//System.out.println("cell "+cell1.getStringCellValue());
					
							if(c.tailleN(cell1.getNumericCellValue()) == 6) {
								clm_ID = cell1.getColumnIndex();
							}
						}
					}
					a++;
				}while(clm_ID == -1);
				
				
			}
			
			
			if(clm_nom == -1) {
				
				do {
					row = sheet.getRow(a+1);
					for (java.util.Iterator<Cell> cellIt = row.cellIterator(); cellIt.hasNext();) {
					
						cell1 = (XSSFCell) cellIt.next();
						
						if(cell1.getCellType() == CellType.STRING) {
							
							if(c.nomprenom(cell1.getStringCellValue()) == true) {
								//System.out.println(cell.getStringCellValue());
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
					a++;
				}while(clm_nom == -1);
				
			}
			
			
			
			if(clm_date == -1) {
				
				do {
					row = sheet.getRow(a+1);
					for (java.util.Iterator<Cell> cellIt = row.cellIterator(); cellIt.hasNext();) {
					
						cell1 = (XSSFCell) cellIt.next();
						
						if(cell1.getCellType() == CellType.NUMERIC) {
							//System.out.println("cell "+cell1.getStringCellValue());
					
							if((c.tailleN(cell1.getNumericCellValue()) == 8) && (c.date_naissance(cell1.getNumericCellValue()) == true)) {
								clm_date = cell1.getColumnIndex();
							}
						}
					}
					a++;
				}while(clm_date == -1);
				
			}
			
			
			if(clm_statut == -1) {
				
				do {
					row = sheet.getRow(a+1);
					for (java.util.Iterator<Cell> cellIt = row.cellIterator(); cellIt.hasNext();) {
					
						cell1 = (XSSFCell) cellIt.next();
						
						if(cell1.getCellType() == CellType.STRING) {
							
					
							if( (c.statut(cell1.getStringCellValue()) == true ) && (c.maj(cell1.getStringCellValue()) == true) ) {
								
								clm_statut = cell1.getColumnIndex();
							
							}
						}
					}
					a++;
				}while(clm_statut == -1);
			}
			
			
			if(clm_bibliotheque == -1) {
				
				do {
					row = sheet.getRow(a+1);
					for (java.util.Iterator<Cell> cellIt = row.cellIterator(); cellIt.hasNext();) {
					
						cell1 = (XSSFCell) cellIt.next();
						
						if(cell1.getCellType() == CellType.STRING) {
							
					
							if( ( (c.biblio(cell1.getStringCellValue()) == true) && (c.maj(cell1.getStringCellValue()) == true) )  || (c.b(cell1.getStringCellValue()) == true) ) {
					
								clm_bibliotheque = cell1.getColumnIndex();
							}
						}
					}
					a++;
				}while(clm_bibliotheque == -1);
				
				
			}
			
			
			if(clm_poste == -1) {
				
				do {
					row = sheet.getRow(a+1);
					for (java.util.Iterator<Cell> cellIt = row.cellIterator(); cellIt.hasNext();) {
					
						cell1 = (XSSFCell) cellIt.next();
						
						if(cell1.getCellType() == CellType.STRING) {
							
					
							if( (c.poste(cell1.getStringCellValue()) == true) && (cell1.getColumnIndex() != clm_nom ) ) {
								clm_poste = cell1.getColumnIndex();
							}
						}
					}
					a++;
				}while(clm_poste == -1);
				
				
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
				//cell.getColumnIndex();
				
						
						if(cell.getColumnIndex() == clm_nom) {
							//System.out.println(cell.getStringCellValue());
							String separateur, fields[];
							
							//System.out.println("cel 2 "+cell.getStringCellValue());
							separateur = ", ";
							fields = cell.getStringCellValue().split(separateur);
							//System.out.println("nom "+fields[0]);
							//System.out.println("prenom "+fields[1]);
							nom = fields[0];
							//System.out.println("taille"+fields.length) ;
							if(fields.length > 1) {
							prenom = fields[1];	
							}
						}
						
						if(cell.getColumnIndex() == clm_bibliotheque){
							bibliotheque = cell.getStringCellValue();
						}
													
						
						if(cell.getColumnIndex() == clm_ID){
							int i = (int) cell.getNumericCellValue();
							String chaine = String.valueOf(i);
							ID = chaine;
						}
						
						
						if(cell.getColumnIndex() == clm_statut){
							statut = cell.getStringCellValue();
						}
						
						
						if(cell.getColumnIndex() == clm_date){
							int i = (int) cell.getNumericCellValue();
							String chaine = String.valueOf(i);
							date = chaine;
						}
						
						if(cell.getColumnIndex() == clm_poste){
							poste = cell.getStringCellValue();
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
			
		}
		
	}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
public void ecrire(){
		
		XSSFWorkbook wb;
		XSSFSheet sheet;
		//System.out.println("ecritue");
		wb = new XSSFWorkbook();
		
		for(int k = 0; k < 1; k++) {
			sheet = wb.createSheet("ma feuille "+k);
			//System.out.println("ma feuille "+k);
			
			for(int j = 0; j < pr.size(); j++) {
				//System.out.println(" ICI ligne "+j);
				XSSFRow row = sheet.createRow(j);
	    
				for(int i = 0; i < 8; i++) {
					//System.out.println(" ICI cellule "+i);
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
	   // row.createCell((short)1).setCellValue(20);

		
		FileOutputStream fileout;
		DateFormat format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Calendar calendar = Calendar.getInstance();
		
		
		try {
			fileout = new FileOutputStream("personne" + format.format(calendar.getTime()) + ".xlsx");
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
