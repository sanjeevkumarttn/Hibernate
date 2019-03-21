package exercise1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Author {

    @Id
    int id;
    private String fname;
    private String lname;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", age=" + age +
                '}';
    }

    void insert(){

        Author author = new Author();
        author.setId(1);
        author.setFname("Rohan");
        author.setLname("Verma");
        author.setAge(43);
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
        session.close();
    }

    void read(){

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Author author = session.get(Author.class,1);
        session.getTransaction().commit();
        session.close();
        System.out.println(author);
    }

    void update(){

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Author author = session.get(Author.class,1);
        author.setFname("Adhiraj");
        session.update(author);
        session.getTransaction().commit();
        session.close();

    }

    void delete(){

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Author author = session.get(Author.class,1);
        session.delete(author);
        session.getTransaction().commit();
        session.close();
        System.out.println("Deleted: "+author);
    }
}
