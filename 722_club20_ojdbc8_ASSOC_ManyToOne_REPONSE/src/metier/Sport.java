package metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Sport
{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int idS;
	
	@Column
	private String libelle;
	
	@OneToOne @JoinColumn(nullable=true,unique=true)
	private Entraineur entraineur; //association
	
	//CONSTRUCTEURS
	
	public Sport(String libelle, Entraineur entraineur) {
		setLibelle(libelle);
		//setEntraineur(entraineur);
	}
	public Sport(String libelle){
		this(libelle, null);
	}
	public Sport(){}
	
//	public Entraineur getEntraineur() {
//		return entraineur;
//	}
//	public void setEntraineur(Entraineur entraineur) {
//		this.entraineur = entraineur;
//	}
	
	//REDEFINITION DE toString()
	public String toString()
	{
		//return "[Sport idS :" + idS + " libelle :" + libelle + "  entraineur :" + entraineur + "]";
		return "[Sport idS :" + idS + " libelle :" + libelle + "  entraineur :";// + ((entraineur==null)? "null" : "[Entité]") + " ]";
	}
/*	public String toString()
	{
		return "id :" + idS + " libelle :<" + libelle + ">  entraineur :" + ((entraineur==null)? "null" : entraineur.getNom());
	}*/
	
	
	// GETTEURs ET SETTEURs
	public int getIdS() {
		return idS;
	}
	private void setIdS(int idS) {
		this.idS = idS;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelleS) {
		this.libelle = libelleS;
	}

	
	public static void main(String[] args) {
		System.out.println("\nLISTE DES SPORTS :");
		System.out.println("-----------------------");
		System.out.println(new Sport("Equitation"));
		System.out.println(new Sport("Natation"));
		System.out.println(new Sport("Boxe"));
	}

}
