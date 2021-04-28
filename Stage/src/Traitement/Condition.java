package Traitement;

public class Condition {
	
	public int tailleN(double d) {
		int i = (int) d;
		String chaine = String.valueOf(i);
		//System.out.println("chaine " +chaine);
	
		return chaine.length();
	}
	

	public int tailleS(String s) {		
		return s.length();
	}

	
	public boolean maj(String s) {
	
		int compteur=0;
			String result0 = s.replaceAll("-","");
			String result = result0.replaceAll("\\s+","");
			//System.out.println("result "+result);
		for(int i = 0; i<s.length(); i++){
			char ch = s.charAt(i);
			if(Character.isUpperCase(ch)){
				compteur++;
			}
		}
			//System.out.println("compteur "+compteur);
			//System.out.println("taille "+s.length());
		if(compteur == result.length()) {
			return true;
		}
	
		return false;
	}


	public boolean nomprenom(String s) {
	
		//System.out.println(s.length());
		for(int i = 0; i < s.length(); i++){
			char ch = s.charAt(i);
			//System.out.println("ch "+ch);
			if((ch == ',') && (s.charAt(i+1) == ' ')){
				return true;
			}
		}
	
		return false;
	}
	
	
	public boolean statut(String s) {
		
		int compteur = 0;
		for(int i = 0; i < s.length(); i++){
			char ch = s.charAt(i);
			if(ch == ' ') {
				compteur ++;
			}
			//System.out.println("compteur "+compteur);
			if((ch == '-') || compteur > 3){
				return false;
			}
		}
		
		return true;
	}

	
	public boolean biblio(String s) {
	
		for(int i = 0; i< s.length(); i++){
			char ch = s.charAt(i);
			if((ch == ' ') && (s.charAt(i+1) == '-')){
				return true;
			}
		}
	
		return false;
	}
	

	public boolean date_naissance(double d) {
	
		int in = (int) d;
		String chaine = String.valueOf(in);
		for(int i = 0; i<2; i++){
			char ch = chaine.charAt(i);
			if(((ch == '1') &&  (chaine.charAt(i+1) == '9')) || ((ch == '2') &&  (chaine.charAt(i+1) == '0'))){
				return true;
			}
		}
		return false;
	}
	

	public boolean b(String s) {
	
		String separator = " ", fields[];
	
		fields = s.split(separator);
		//System.out.println(fields[0].toString());
		if(fields[0].toString() == "Bibliothèque"){
			//System.out.println("true");
			return false;
		}
		return false;	
	}

	
	public boolean poste(String s) {
		
		for(int i = 0; i < s.length(); i++){
			
			char ch = s.charAt(i);
			System.out.println("ch "+ch);
			if((ch == ',') || (ch == '-')){
				
				return false;
			}
			
		}
		 
	
		return true;
	}
	
	
	public boolean separateur(String s) {
		
		//System.out.println(s.length());
		for(int i = 0; i < s.length(); i++){
			char ch = s.charAt(i);
			//System.out.println("ch "+ch);
			if((ch == ',') || (ch == '-')){
				return false;
			}
		}
		
		/*System.out.println(s.length());
		for(int i = 0; i < s.length(); i++){
			char ch = s.charAt(i);
			System.out.println("ch "+ch);
			if((ch == ',') || (ch == '-')){
				return false;
			}
			else {
				return true;
			}
		}*/
		return true;
	}
	
	
}
