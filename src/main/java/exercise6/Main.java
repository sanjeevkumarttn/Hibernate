package exercise6;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Author author1 = new Author();
        author1.setFname("Ankur");
        author1.setLname("Kumar");
        author1.setAge(23);
        author1.setDob(new Date());
        author1.getSubjects().add("Mathematics");
        author1.getSubjects().add("chemistry");

        Author author2 = new Author();
        author2.setFname("Rehman");
        author2.setLname("Ansari");
        author2.setAge(33);
        author2.setDob(new Date());
        author2.getSubjects().add("History");
        author2.getSubjects().add("Compuer Organization");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(author1);
        session.save(author2);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
