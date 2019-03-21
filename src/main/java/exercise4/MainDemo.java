package exercise4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDemo {

    public static void main(String[] args) {
        AuthorDemo authorDemo = new AuthorDemo();
        authorDemo.setName("Rehman");

        BookDemo bookDemo = new BookDemo();
        bookDemo.setBookName("Java");

        authorDemo.setBookDemo(bookDemo);
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(authorDemo);
        session.save(bookDemo);
        session.getTransaction().commit();
        session.close();
    }

}
