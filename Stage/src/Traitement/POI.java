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
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Data.Personne;

public class POI extends ListPersonne{
	
	Condition c = new Condition();

	public void lecture()  {
		// TODO Auto-generated method stub
		
		XSSFRow row = null;
		XSSFCell cell= null;
		String ID;
		String nom;
		String prenom;
		String date;
		String statut;
		String poste;
		String bibliotheque;
		String carte;
		
		try {
		
		FileInputStream inputstream = new FileInputStream("src/test.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
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
				
				switch(cell.getCellType()) {
				
					case STRING :
						
						/*String a = NULL;
						if((a != cell.getStringCellValue())) {
								System.out.println(a);
								System.out.println(cell.getStringCellValue());
								statut = cell.getStringCellValue();
							}*/
													
					
						break;
						
					case NUMERIC :
						
						
						break;
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
