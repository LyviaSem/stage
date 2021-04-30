package Traitement;

import java.util.ArrayList;

import Data.Personne;

public class ListPersonne {
	
	protected ArrayList<Personne>pr;
	
	//contructeur
	public ListPersonne() {
		pr = new ArrayList<Personne>();
	}
	
	//méthode qui ajoute des élément à l'ArrayList
	public void add(Personne personne) {
		pr.add(personne);
	}
	
	//méthode qui recherche un atome grace à son nom
	 public Personne recherchenom(String nom) { 
	    	for(int i = 0; i < pr.size(); i++) { 
	    		if(pr.get(i).getNom().equals(nom)) {
	    			return pr.get(i) ;
	    		}
	    	}
	    	return null;
	    }
	 
	
	//méthode qui affiche l'ArrayList
	public String toString() {
		String result = "";
		for (Personne personne : pr) {
			result += personne.toString() + "\n";
		}

		return result;
	}

}
