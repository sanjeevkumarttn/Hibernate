package exercise9;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Author author1 = new Author();
        author1.setFname("Aman");
        author1.setLname("Choudhary");
        author1.setAge(34);
        author1.setDob(new Date());

        Author author2 = new Author();
        author2.setFname("Rajeev");
        author2.setLname("Verma");
        author2.setAge(45);
        author2.setDob(new Date());

        Book book1 = new Book();
        book1.setBookName("Computer Organization");

        Book book2 = new Book();
        book2.setBookName("Java Programming");

        author1.getBooks().add(book1);
        author1.getBooks().add(book2);

        book1.getAuthors().add(author1);
        book2.getAuthors().add(author1);

        author2.getBooks().add(book1);
        author2.getBooks().add(book2);

        book1.getAuthors().add(author2);
        book2.getAuthors().add(author2);


        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.persist(author1);
        session.persist(author2);
        session.getTransaction().commit();
        session.close();

    }
}
