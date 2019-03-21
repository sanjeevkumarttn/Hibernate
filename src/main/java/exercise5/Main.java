package exercise5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Author author = new Author();
        author.setFname("Ankur");
        author.setLname("Kumar");
        author.setAge(23);
        author.setDob(new Date());

        Address address = new Address();
        address.setStreetNumber("Japanese Park");
        address.setLocation("Delhi");
        address.setState("Delhi");
        author.setAddress(address);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
