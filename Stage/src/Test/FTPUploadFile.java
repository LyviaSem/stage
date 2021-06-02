package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class FTPUploadFile {

 public static void main(String[] args) {
  String serveur = "192.168.202.104";
  int port = 20;
  String user = "./lyvia.semaoune";
  String password = "m2Pàchanger";

  FTPClient ftpClient = new FTPClient();
  try {

   ftpClient.connect(serveur, port);
   ftpClient.login(user, password );
   ftpClient.enterLocalPassiveMode();

   ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

   // Approche 1: upload d'un fichier en utilisant InputStream
   File file = new File("C:\\Users\\lyvia.semaoune\\git\\stage\\Stage\\fichier_sortie\\personne2021_06_01_14_41_08");

   String chemin = "personne2021_06_01_14_41_08";
   InputStream inputStream = new FileInputStream(file);

   System.out.println("Début de l'upload");
   //résultat de l'upload
   boolean res = ftpClient.storeFile(chemin, inputStream);
   //fermet le flut de lecture
   inputStream.close();
   
   if (res==true) {
     System.out.println("Le fichier "+chemin+" a été transféré avec succès");
   }
  } catch (IOException e) {
	   System.out.println(e.getMessage());
	   e.printStackTrace();
	  } finally {
	   try {
	    if (ftpClient.isConnected()) {
	     //fermer la connexion FTP
	     ftpClient.logout();
	     ftpClient.disconnect();
	    }
	   } catch (IOException ex) {
	    ex.printStackTrace();
	   }
	  }
	 }
	}