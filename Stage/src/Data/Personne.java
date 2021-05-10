package Data;

public class Personne {
	
	//attribue du type "personne"
	private String ID;
	private String NOM;
	private String prenom;
	private int date_fin;
	private String statut;
	private String bibliotheque;
	private String structure_3e;
	private String structure_4e;
	private String service;
	private String num_carte;
	
	//constructeur du type "personne"
	public Personne(String ID, String NOM, String prenom, int date_fin, String statut, String bibliotheque, String structure_3e, String structure_4e, String service, String num_carte) {
		
		this.ID = ID;
		this.NOM = NOM;
		this.prenom = prenom;
		this.date_fin = date_fin;
		this.statut = statut;
		this.bibliotheque = bibliotheque;
		this.structure_3e = structure_3e;
		this.structure_4e = structure_4e;
		this.service = service;
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
	
	public int getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(int date_naissance) {
		this.date_fin = date_naissance;
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
	
	public String getStructure_3e() {
		return structure_3e;
	}
	public void setStructure_3e(String structure_3e) {
		this.structure_3e = structure_3e;
	}
	
	public String getStructure_4e() {
		return structure_4e;
	}
	public void setStructure_4e(String structure_4e) {
		this.structure_4e = structure_4e;
	}
	
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	
	public String getNum_carte() {
		return num_carte;
	}
	public void setNum_carte(String num_carte) {
		this.num_carte = num_carte;
	}
	
	//affichage des "personne"
		public String toString() {
			return " ID = " + ID + "\n NOM = " + NOM + "\n Prénom = " + prenom + "\n Date de naissance = " + date_fin + "\n statut = " + statut + "\n Bibliothèque = " + bibliotheque + "\n Structure_de_3e_niveau = " + structure_3e + "\n Structure_de_4e_niveau = " + structure_4e + "service = " + service + "\n Numéro de carte = " + num_carte + "";
		}
	

}
