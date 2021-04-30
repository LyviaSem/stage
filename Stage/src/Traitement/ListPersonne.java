package Traitement;

import java.util.ArrayList;

import Data.Personne;

public class ListPersonne {
	
	protected ArrayList<Personne>pr;
	
	//contructeur
	public ListPersonne() {
		pr = new ArrayList<Personne>();
	}
	
	//m�thode qui ajoute des �l�ment � l'ArrayList
	public void add(Personne personne) {
		pr.add(personne);
	}
	
	//m�thode qui recherche un atome grace � son nom
	 public Personne recherchenom(String nom) { 
	    	for(int i = 0; i < pr.size(); i++) { 
	    		if(pr.get(i).getNom().equals(nom)) {
	    			return pr.get(i) ;
	    		}
	    	}
	    	return null;
	    }
	 
	
	//m�thode qui affiche l'ArrayList
	public String toString() {
		String result = "";
		for (Personne personne : pr) {
			result += personne.toString() + "\n";
		}

		return result;
	}

}
