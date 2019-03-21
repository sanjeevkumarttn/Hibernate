package exercise2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateAuthor {

    public static void main(String[] args) {

        Author author1 = new Author(2,"Rohan","Verma",48,"1970-11-23");
        Author author2 = new Author(3,"Sohan","Sharma",42,"1976-11-23");
        Author author3 = new Author(4,"Mohan","Choudhary",52,"1966-11-23");
        Author author4 = new Author(5,"Aman","Kumar",34,"1988-11-23");


        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(author1);
        session.save(author2);
        session.save(author3);
        session.save(author4);
        session.getTransaction().commit();
        session.close();
    }
}
