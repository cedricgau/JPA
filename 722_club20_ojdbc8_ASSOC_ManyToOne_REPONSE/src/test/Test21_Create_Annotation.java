package test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import metier.Adherent;

public class Test21_Create_Annotation {

	public static void main(String[] args) throws ParseException {
		
		// METTRE LES DROITS POUR CLUB10 !!! GRANT CONNECT,RESOURCE,CREATE ......
		
		
		EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("club10");
            entityManager = entityManagerFactory.createEntityManager();
            
            System.out.println("\nLISTE DES Adherents :");
    		System.out.println("-----------------------");
    		Adherent a1 = new Adherent("Bichon","Simone", new SimpleDateFormat("dd/mm/yyyy").parse("04/03/1981"));
    		Adherent a2 =new Adherent("Abicol","Nicole",new SimpleDateFormat("dd/mm/yyyy").parse("15/12/1951"));
    		Adherent a3 =new Adherent("Dupuis","Gary",new SimpleDateFormat("dd/mm/yyyy").parse("17/10/2000"));
    		
    		EntityTransaction trans = entityManager.getTransaction();
            trans.begin();
            entityManager.persist(a1);
            entityManager.persist(a2);
            entityManager.persist(a3);
            trans.commit();
        
            System.out.println( "- Lecture de tous les Adherents -----------" );
            
            List<Adherent> Adherents = entityManager.createQuery( "from Adherent", Adherent.class )
                                   .getResultList();
            for (Adherent Adherent : Adherents) {
                System.out.println( Adherent );
            }
            
            System.out.println( "- Insertion d'un nouvel Adherent ----------" );
            
            EntityTransaction trans2 = entityManager.getTransaction();
            trans2.begin();
            
            Adherent newAdherent = new Adherent( "DBS", "Aston Martin", new SimpleDateFormat("dd/mm/yyyy").parse("17/11/2003" ));
            entityManager.persist( newAdherent );
    
            List<Adherent> results = entityManager.createQuery("from Adherent", Adherent.class).getResultList();
            for( Adherent Adherent : results) {
                System.out.println( Adherent );
            }
    
            System.out.println( "- Modification d'un Adherent --------------" );
        
            newAdherent.setPrenom("Bobby");
            entityManager.persist( newAdherent );
            
            results = entityManager.createQuery("from Adherent", Adherent.class).getResultList();
            for( Adherent Adherent : results) {
                System.out.println( Adherent );
            }
    
            System.out.println( "- Suppression d'un Adherent ---------------" );
            
            entityManager.remove( newAdherent );
            
            results = entityManager.createQuery("from Adherent", Adherent.class).getResultList();
            for( Adherent Adherent : results) {
                System.out.println( Adherent );
            }
                    
            trans2.commit();
        } finally {
            if ( entityManager != null ) entityManager.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }
    }



}
