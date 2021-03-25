package metier;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Adherent
{
	@Id @GeneratedValue ( strategy =GenerationType.AUTO)
	private int idA;
	@Column
	private String nom;
	@Column
	private String prenom;
	@Column
	private Date dateNaiss;
	
	@ManyToMany 
	private Set<Sport> sport = new HashSet<>();//association
	
	//CONSTRUCTEURS
	
	public Adherent(String nom, String prenom, Date dateNaiss, Sport sport) {
		setNom(nom);
		setPrenom(prenom);
		setDateNaiss(dateNaiss);
		//setSport(sport);
	}
	public Adherent(String nom, String prenom, Date dateNaiss)
	{
		this( nom, prenom,  dateNaiss , null);
	}
	public Adherent(){	}

	//REDEFINITION DE toString()
	public String toString()
	{
		
		/*return   "[Adherent idA :"+ idA + " nom :" +nom+ " prenom :" +prenom+ " dateNaiss :" + dateNaiss +
					"   sport :" + sport +"]" ;*/
		return   "[Adherent idA :"+ idA + " nom :" +nom+ " prenom :" +prenom+ " dateNaiss :" + dateNaiss +
				"   sport :"; //+ ((sport==null)? "null":"[entite]")+"]" ;

	}
/*	public String toString()
	{
		String sortie="";
		sortie= sortie + idA + " nom :<" +nom+ "> prenom :<" +prenom+ "> dateNaiss :" + dateNaiss +
					"   sport :" + ((sport==null)? "null": sport.getLibelle());
		if( sport!=null)
			sortie= sortie + "  entraineur :" + ((sport.getEntraineur()==null)? "null" : sport.getEntraineur().getNom());
		return sortie;
	}*/
	
	//"  entraineur :" + ((entraineur==null)? "null" : entraineur.getNom());

	//GETTEURs SETTEURs
	public int getIdA() {
		return idA;
	}
	private void setIdA(int idA) {
		this.idA = idA;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nomA) {
		this.nom = nomA;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenomA) {
		this.prenom = prenomA;
	}
	public Date getDateNaiss() {
		return dateNaiss;
	}
	public void setDateNaiss(Date dateNaissA) {
		this.dateNaiss = dateNaissA;
	}

	public void setSport(Sport sport) {
		this.sport = (Set<Sport>) sport;
	}

	public Sport getSport() {
		return (Sport) sport;
	}
	
	public static void main(String[] args) throws ParseException {
		System.out.println("\nLISTE DES Adherents :");
		System.out.println("-----------------------");
		System.out.println(new Adherent("Bichon","Simone", new SimpleDateFormat("dd/mm/yyyy").parse("04/03/1981")));
		System.out.println(	new Adherent("Abicol","Nicole",new SimpleDateFormat("dd/mm/yyyy").parse("15/12/1951")));
		System.out.println(	new Adherent("Dupuis","Gary",new SimpleDateFormat("dd/mm/yyyy").parse("17/10/2000")));
	}
}
