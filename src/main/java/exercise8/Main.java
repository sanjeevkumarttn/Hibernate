package exercise8;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Author author = new Author();
        author.setFname("Anjali");
        author.setLname("Sharma");
        author.setAge(35);
        author.setDob(new Date());

        Book book1 = new Book();
        book1.setBookName("Data Structure");
        book1.setAuthor(author);

        Book book2 = new Book();
        book2.setBookName("Data Warehouse");
        book2.setAuthor(author);

        author.getBooks().add(book1);
        author.getBooks().add(book2);

        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.persist(author);
        //session.persist(book1);
        //session.persist(book2);
        session.getTransaction().commit();
        session.close();

    }
}
