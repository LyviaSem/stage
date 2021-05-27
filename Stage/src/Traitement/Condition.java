package Traitement;

public class Condition {
	
	//fonction qui determine et renvoie la taille du contenue d'une cellule num�rique
	public int tailleN(double d) {
		
		//on transforme la valeur double en valeur int
		int i = (int) d;
		//puis avec valueof il devien une chaine de carat�re 
		String chaine = String.valueOf(i);
	
		return chaine.length();
	}
	
	
	//fonction qui determine et renvoie la taille du contenue d'une cellule qui contien une chaine de caract�re
	public int tailleS(String s) {		
		return s.length();
	}

	
	//fonction qui v�rifie si tout les caract�re d'une chaine donn� son en majuscule
	public boolean maj(String s) {
	
		int compteur=0;
		
		//on garde que les lettre 
		String result0 = s.replaceAll("-","");
		String result = result0.replaceAll("\\s+","");
			
		//on compte le nombre de lettre en majuscule
		for(int i = 0; i < s.length(); i++){
			char ch = s.charAt(i);
			if(Character.isUpperCase(ch)){
				compteur++;
			}
		}
			
		//on compare le nombre trouver avec la taille de la chaine
		if(compteur == result.length()) {
			return true;
		}
	
		return false;
	}

	
	//cette fonction v�rifie si la cellule courente contien le nom et prenom d'une personne
	public boolean nomprenom(String s) {
	
		for(int i = 0; i < s.length(); i++){
			char ch = s.charAt(i);
			
			//si il y a une vigule suivi d'un espace alors la cellule contient bien un nom et un pr�nom
			if((ch == ',') && (s.charAt(i+1) == ' ')){
				return true;
			}
		}
	
		return false;
	}
	
	
	//cette fonction v�rifie si la cellule courente contien le statut d'une personne
	public boolean statut(String s) {
		
		int compteur = 0;
		for(int i = 0; i < s.length(); i++){
			char ch = s.charAt(i);
			
			//compte le nombre d'espace
			if(ch == ' ') {
				compteur ++;
			}
			
			//si un tiret et pr�sent ou si il y a plus de 2 espace (donc plus de 3 mots) ce n'est pas un statut
			if((ch == '-') || compteur > 3){
				return false;
			}
		}
		
		return true;
	}
	

	//cette fonction v�rifie si la cellule courente contien les biblioth�ques
	public boolean biblio(String s) {
	
		for(int i = 0; i < s.length()-1; i++){
			char ch = s.charAt(i);
			if((ch == ' ') && (s.charAt(i+1) == '-')){
				return true;
			}
		}
	
		return false;
	}
	
	
	//cette fonction v�rifie si la cellule courente contien les biblioth�ques
	public boolean date_fin(double d) {
	
		//on transforme la varible double en chaine de caract�re
		int in = (int) d;
		String chaine = String.valueOf(in);
		
		if(this.tailleS(chaine) > 2) {
			
			for(int i = 0; i < 2; i++){
				char ch = chaine.charAt(i);
			
				if( (ch == '4') &&  (chaine.charAt(i+1) == '4')){
					return true;
				}
			}
			
		}
		
		return false;
	}
	
	
	/*public boolean caractere(double d) {
		
		//System.out.println("chaine "+d);
		int in = (int) d;
		String chaine = String.valueOf(in);
		
		//System.out.println("chaine "+chaine);
		
		for(int i = 0; i < 2; i++){
			char ch = chaine.charAt(i);
			
			if( (ch == '/') ){
				return true;
			}
		}
		return false;
	}*/
	

	//cette fonction v�rifie si la cellule courante contien le poste d'une personne
	public boolean poste(String s) {
		
		if(s.length() > 14) {
			char ch = s.charAt(0);
			
			if(((ch == 'D') && (s.charAt(1) == 'i')) || ((ch == 'I') && (s.charAt(1) == 'n') && (s.charAt(13) == 'C') && (s.charAt(14) == 'i')) || ((ch == 'P') && (s.charAt(1) == '�')) ){
				System.out.println("ch "+ch);
				System.out.println("ch1 "+s.charAt(1));
				return true;
			}
		}

		return false;
	}
	
	
	//cette fonction v�rifie si la cellule courante contien le num�ro de carte d'une personne
	public boolean carte(String s) {
		
		
		for(int i = s.length()-1; i > 3; i--){
			
			char ch = s.charAt(i);
			
			
			//si la cellule commence avec cette combinaison de carrart�re alors elle contient bien les num�ros de carte
			if((ch == '0') && (s.charAt(i-1) == '8') && (s.charAt(i-2) == 'C') && (s.charAt(i-3) == '5')){
				return true;
			}
		}
		
		return false;
	}
	
	
	//cette fonction v�rifie si la cellule courante contien le service d'une personne
	public boolean service(String s) {
		
		if(s.length() > 1) {
			char ch = s.charAt(0);
		
			//si la cellule commence avec l'une de ces combinaison de carrart�re alors elle contient bien les services
			if( ((ch == 'P') && (s.charAt(1) == 'M')) || ( (ch == 'P') && (s.charAt(1) == 'O') ) ){
				return true;
			}
		}
		
		return false;
	}

	
	//cette fonction v�rifie si la cellule courante contien la structure de niveau 4 d'une personne
	public boolean niv_4(String s) {
		
		if(s.length() > 0) {
			char ch = s.charAt(0);
		
			
			if( ((ch == 'N') && (s.charAt(1) == 'U') && (s.charAt(2) == 'L')) || ((ch == 'I') && (s.charAt(1) == 'n'))){
				return true;
			}
		}
		
		return false;
	}
	
}



