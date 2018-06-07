import static org.junit.Assert.*;

import model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class QueryTests{
    private static EntityManagerFactory sessionFactory;
    private static EntityManager em;
    @BeforeClass
    public static void setup(){
        sessionFactory = Persistence.createEntityManagerFactory("westbahnPU");
        em = sessionFactory.createEntityManager();

        /*
        em.getTransaction().begin();
        Bahnhof bahnhof1 = new Bahnhof ("bhf1", 10, 20, 30, false );
        Bahnhof bahnhof2 = new Bahnhof ("bhf2", 100 , 200 , 300 , true );
        Bahnhof bahnhof3 = new Bahnhof ("bhf3", 50, 10, 150 , false );

        Zahlung zahlung1 = new Kreditkarte ();
        Zahlung zahlung2 = new Kreditkarte ();

        Strecke strecke1 = new Strecke ( bahnhof1 , bahnhof2 , bahnhof3 );
        Strecke strecke2 = new Strecke ( bahnhof3 , bahnhof2 , bahnhof1 );

        Ticket ticket1 = new Einzelticket ( strecke1 , zahlung1 , null );
        Ticket ticket2 = new Zeitkarte ( strecke1 , zahlung1 , ZeitkartenTyp.MONATSKARTE );
        Ticket ticket3 = new Zeitkarte ( strecke2 , zahlung1 , ZeitkartenTyp.MONATSKARTE );

        Benutzer benutzer1 = new Benutzer ("v1", "n1", " v1n1@email.at", "p1", "+43123456789 ", 0L, ticket1 );
        Benutzer benutzer2 = new Benutzer ("v2", "n2", " v2n2@email.at", "p2", "+43123456789 ", 0L, ticket2 );

        Zug zug1 = new Zug ( new Date (118 , 2, 22, 12, 30) , 700 , 7, 0, bahnhof1 , bahnhof2 );

        Reservierung reservierung1 = new Reservierung(new Date (2018 , 3, 22,14, 10) , StatusInfo .ONTIME , zug1 , strecke2 , benutzer1 , zahlung2 );

        Reservierung reservierung2 = new Reservierung (new Date (2018 , 3, 22, 14, 10) , StatusInfo .ONTIME , zug1 , strecke2 , benutzer2 , zahlung2 );


        em.persist ( reservierung1 );
        em.persist ( reservierung2 );
        em.getTransaction().commit();
        */
    }
    @Before
    public void init(){
        em.getTransaction().begin();
        Bahnhof bahnhof1 = new Bahnhof ("bhf1", 10, 20, 30, false );
        Bahnhof bahnhof2 = new Bahnhof ("bhf2", 100 , 200 , 300 , true );
        Bahnhof bahnhof3 = new Bahnhof ("bhf3", 50, 10, 150 , false );

        Zahlung zahlung1 = new Kreditkarte ();
        Zahlung zahlung2 = new Kreditkarte ();

        Strecke strecke1 = new Strecke ( bahnhof1 , bahnhof2 , bahnhof3 );
        Strecke strecke2 = new Strecke ( bahnhof3 , bahnhof2 , bahnhof1 );

        Ticket ticket1 = new Einzelticket ( strecke1 , zahlung1 , null );
        Ticket ticket2 = new Zeitkarte ( strecke1 , zahlung1 , ZeitkartenTyp.MONATSKARTE );
        Ticket ticket3 = new Zeitkarte ( strecke2 , zahlung1 , ZeitkartenTyp.MONATSKARTE );

        Benutzer benutzer1 = new Benutzer ("v1", "n1", " v1n1@email.at", "p1", "+43123456789 ", 0L, ticket1 );
        Benutzer benutzer2 = new Benutzer ("v2", "n2", " v2n2@email.at", "p2", "+43123456789 ", 0L, ticket2 );

        Zug zug1 = new Zug ( new Date (118 , 2, 22, 12, 30) , 700 , 7, 0, bahnhof1 , bahnhof2 );

        Reservierung reservierung1 = new Reservierung(new Date (2018 , 3, 22,14, 10) , StatusInfo .ONTIME , zug1 , strecke2 , benutzer1 , zahlung2 );

        Reservierung reservierung2 = new Reservierung (new Date (2018 , 3, 22, 14, 10) , StatusInfo .ONTIME , zug1 , strecke2 , benutzer2 , zahlung2 );


        em.persist ( reservierung1 );
        em.persist ( reservierung2 );
        em.getTransaction().commit();
    }
    @After
    public void cleanUp(){
        em.getTransaction().begin();
        em.createQuery ("DELETE FROM Sonderangebot").executeUpdate();
        em.createQuery ("DELETE FROM Reservierung").executeUpdate();
        em.createQuery ("DELETE FROM Benutzer").executeUpdate();
        em.createQuery ("DELETE FROM Ticket").executeUpdate();
        em.createQuery ("DELETE FROM Einzelticket").executeUpdate();
        em.createQuery ("DELETE FROM Zeitkarte").executeUpdate();
        em.createQuery ("DELETE FROM Strecke").executeUpdate();
        em.createQuery ("DELETE FROM Zug").executeUpdate();
        em.createQuery ("DELETE FROM Bahnhof").executeUpdate();
        em.getTransaction().commit();
    }

    @Test
    public void testTest(){
        assertTrue(true);
    }
}
