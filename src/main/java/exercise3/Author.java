package exercise3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Entity;
import javax.persistence.Id;

class Main {
    public static void main(String[] args) {
        Author author = new Author(1, "Renuka", "Anand", 34, "1984-11-23");
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //session.save(author);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}


@Entity
public class Author {

    @Id
    int id;
    private String fname;
    private String lname;
    private int age;
    private String dob;

    public Author(int id, String fname, String lname, int age, String dob) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", age=" + age +
                ", dob='" + dob + '\'' +
                '}';
    }

}





