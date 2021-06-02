package Test;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class FTPDownloadFile {

 public static void main(String[] args) {
  String serveur = "AdresseDuServeur";
  int port = 21;
  String username = "VotreNomUtilisateur";
  String password = "votreMotDePasse";

  FTPClient ftpClient = new FTPClient();
  try {

   ftpClient.connect(serveur, port);
   ftpClient.login(username, password );
   ftpClient.enterLocalPassiveMode();

   ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

   // Approche 1: téléchargement d'un fichier en utilisant InputStream
   File file = new File("plugins et styles.txt");

   String nomFichier = "plugins et styles.txt";
   InputStream inputStream = new FileInputStream(file);

   System.out.println("Début du téléchargement");
   //résultat du téléchargement
   boolean res = ftpClient.storeFile(nomFichier, inputStream);
   //fermer le flut de lecture
   inputStream.close();
   
   if (res==true) {
     System.out.println("Le fichier "+nomFichier+
                 " a été téléchargé avec succès");
   }

   // Approche 2: téléchargement d'un fichier en utilisant OutputStream
   String nomFichier2 = "Piste 2.mp3";
   String CheminFichierDistant = "/songs/"+nomFichier2;
   File fichierlocal = new File("C:/Piste 2.mp3");
            
   // lister le dossier ou se trouve le fichier et
   // puis le rechercher avec le nom pour obtenir
   // sa taille qui va etre utilisée pour calculer
   // le ratio du téléchargement
   FTPFile[] files1 = ftpClient.listFiles("/songs");
   long size = 0;
   for(int i = 0;i<files1.length;i++){
     if(files1[i].getName().equals(nomFichier2))
      //obtenir la taille du fichier
      size = files1[i].getSize();
   }
            
   OutputStream outputStream2 = new BufferedOutputStream(
                                new FileOutputStream(fichierlocal));
   InputStream inputStream2 = ftpClient.retrieveFileStream(
                                     CheminFichierDistant);
            
   byte[] bytesArray = new byte[4096];
   int bytesRead = -1;
   //tant qu'on a pas atteint la fin
   int transferé = 0;
   int pourcentage = 0;
   while ((bytesRead = inputStream2.read(bytesArray)) != -1) {
      //on écrit les octets dans l'emplacement précisé
   outputStream2.write(bytesArray, 0, bytesRead);
      transferé += bytesRead;
      pourcentage = (int) (transferé*100/size);
      System.out.println(pourcentage+"%");
   }
   //fermer les flux de lecture de d'écriture
   inputStream2.close();
   outputStream2.close();

   //résultat d
   res = ftpClient.completePendingCommand();
   if (res) {
     System.out.println("Le fichier "+nomFichier2+
                        " a été téléchargé avec succès");
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
