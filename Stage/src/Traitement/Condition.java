package Traitement;

public class Condition {
	
	//fonction qui determine et renvoie la taille du contenue d'une cellule numérique
	public int tailleN(double d) {
		
		int i = (int) d;
		String chaine = String.valueOf(i);
	
		return chaine.length();
	}
	
	//fonction qui determine et renvoie la taille du contenue d'une cellule qui contien une chaine de caractère
	public int tailleS(String s) {		
		return s.length();
	}

	//fonction qui vérifie si tout les caractère d'une chaine donné son en majuscule
	public boolean maj(String s) {
	
		int compteur=0;
			String result0 = s.replaceAll("-","");
			String result = result0.replaceAll("\\s+","");
			
		for(int i = 0; i<s.length(); i++){
			char ch = s.charAt(i);
			if(Character.isUpperCase(ch)){
				compteur++;
			}
		}
			
		if(compteur == result.length()) {
			return true;
		}
	
		return false;
	}

	//cette fonction vérifie si la cellule courente contien le nom et prenom d'une personne
	public boolean nomprenom(String s) {
	
		for(int i = 0; i < s.length(); i++){
			char ch = s.charAt(i);
			
			//si il y a une vigule suivi d'un espace alors la cellule contient bien un nom et un prénom
			if((ch == ',') && (s.charAt(i+1) == ' ')){
				return true;
			}
		}
	
		return false;
	}
	
	//cette fonction vérifie si la cellule courente contien le statut d'une personne
	public boolean statut(String s) {
		
		int compteur = 0;
		for(int i = 0; i < s.length(); i++){
			char ch = s.charAt(i);
			
			//compte le nombre d'espace
			if(ch == ' ') {
				compteur ++;
			}
			
			//si un tiret et présent ou si il y a plus de 2 espace (donc plus de 3 mots) ce n'est pas un statut
			if((ch == '-') || compteur > 3){
				return false;
			}
		}
		
		return true;
	}

	//cette fonction vérifie si la cellule courente contien les bibliothèques
	public boolean biblio(String s) {
	
		for(int i = 0; i< s.length()-1; i++){
			char ch = s.charAt(i);
			if((ch == ' ') && (s.charAt(i+1) == '-')){
				return true;
			}
		}
	
		return false;
	}
	
	//cette fonction vérifie si la cellule courente contien les bibliothèques
	public boolean date_naissance(double d) {
	
		int in = (int) d;
		String chaine = String.valueOf(in);
		for(int i = 0; i<2; i++){
			char ch = chaine.charAt(i);
			
			//une année de naissance peut commencé par 19 ou 20 si ce n'est pas le cas de la cellule courante ce n'est pas une date de naissance
			if(((ch == '1') &&  (chaine.charAt(i+1) == '9')) || ((ch == '2') &&  (chaine.charAt(i+1) == '0'))){
				return true;
			}
		}
		return false;
	}
	
	//les bibliothèquessont soit composé de 3 lettre ou commence par le mot bibliotheque cette fonction vérifie si la chaine de caractère commence par le mot bibliothèque 
	public boolean b(String s) {
	
		String separator = " ", fields[];
	
		fields = s.split(separator);
		
		if(fields[0].toString() == "Bibliothèque"){
			
			return false;
		}
		return false;	
	}

	//cette fonction vérifie si la cellule courante contien le poste d'une personne
	public boolean poste(String s) {
		
		if(s.length() > 0) {
			char ch = s.charAt(0);
		
			//on elimine les chaine de caractère qui contienne une virgule (cellule des nom et prénom) et celle qui contienne des tiret (cellule des bibliothèque)
			if((ch == 'D') && (s.charAt(1) == 'i')){
			//System.out.println("ch "+ch);
			//System.out.println("ch1 "+s.charAt(1));
				return true;
			}
		}

		return false;
	}
	
	public boolean carte(String s) {
		
		
		for(int i = s.length()-1; i > 3; i--){
			
			char ch = s.charAt(i);
			
			
			//si il y a une vigule suivi d'un espace alors la cellule contient bien un nom et un prénom
			if((ch == '0') && (s.charAt(i-1) == '8') && (s.charAt(i-2) == 'C') && (s.charAt(i-3) == '5')){
				return true;
			}
		}
		
		return false;
	}
	
	public boolean service(String s) {
		
		if(s.length() > 0) {
			char ch = s.charAt(0);
		
			//on elimine les chaine de caractère qui contienne une virgule (cellule des nom et prénom) et celle qui contienne des tiret (cellule des bibliothèque)
			if( ((ch == 'P') && (s.charAt(1) == 'M')) || ( (ch == 'P') && (s.charAt(1) == 'O') ) ){
			//System.out.println("ch "+ch);
			//System.out.println("ch1 "+s.charAt(1));
				return true;
			}
		}
		
		return false;
	}

	public boolean strcarte(String s) {
		
		if(s.length() > 0) {
			char ch = s.charAt(0);
		
			//on elimine les chaine de caractère qui contienne une virgule (cellule des nom et prénom) et celle qui contienne des tiret (cellule des bibliothèque)
			if( ((ch == 'N') && (s.charAt(1) == 'u') && (s.charAt(2) == 'm') ) ){
			//System.out.println("ch "+ch);
			//System.out.println("ch1 "+s.charAt(1));
				return true;
			}
		}
		return false;
	}
	
}

