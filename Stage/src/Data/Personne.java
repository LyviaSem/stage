package Data;

public class Personne {
	
	//attribue du type "personne"
	private String ID;
	private String NOM;
	private String prenom;
	private String date_naissance;
	private String statut;
	private String bibliotheque;
	private String poste;
	private String num_carte;
	
	//constructeur du type "personne"
	public Personne(String ID, String NOM, String prenom, String date_naissance, String statut, String bibliotheque, String poste, String num_carte) {
		
		this.ID = ID;
		this.NOM = NOM;
		this.prenom = prenom;
		this.date_naissance = date_naissance;
		this.statut = statut;
		this.bibliotheque = bibliotheque;
		this.poste = poste;
		this.num_carte = num_carte;
		
	}
	
	//geteur et seteur
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	
	public String getNom() {
		return NOM ;
	}
	public void setNOM(String NOM) {
		this.NOM = NOM ;
	}
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}
	
	public String getstatut() {
		return statut;
	}
	public void setstatut(String statut) {
		this.statut = statut;
	}
	
	public String getBibliotheque() {
		return bibliotheque;
	}
	public void setBibliotheque(String bibliotheque) {
		this.bibliotheque = bibliotheque;
	}
	
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	
	public String getNum_carte() {
		return num_carte;
	}
	public void setNum_carte(String num_carte) {
		this.num_carte = num_carte;
	}
	
	//affichage des "personne"
		public String toString() {
			return " ID = " + ID + "\n NOM = " + NOM + "\n Prénom = " + prenom + "\n Date de naissance = " + date_naissance + "\n statut = " + statut + "\n Bibliothèque = " + bibliotheque + "\n Poste = " + poste + "\n Numéro de carte = " + num_carte + "";
		}
	

}
