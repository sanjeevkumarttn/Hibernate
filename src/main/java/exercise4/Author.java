package exercise4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;
import java.util.Date;

@Entity
class Author {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "Id")
    int id;
    @Column(name = "First_Name")
    private String fname;
    @Column(name = "Last_Name")
    //@Transient
    private String lname;
    @Column(name = "Age")
    private int age;
    @Temporal(TemporalType.DATE)
    @Column(name = "Date_of_Birth")
    private Date dob;

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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}

class Main {
    public static void main(String[] args) {

        Author author = new Author();
        author.setFname("Ankur");
        author.setLname("Kumar");
        author.setAge(23);
        author.setDob(new Date());

        Author author1 = new Author();
        author1.setFname("Rehman");
        author1.setLname("Ahmad");
        author1.setAge(29);
        author1.setDob(new Date());

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(author);
        session.save(author1);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}


