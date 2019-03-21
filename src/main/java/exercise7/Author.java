package exercise7;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    int id;
    @Column(name = "First_Name")
    private String fname;
    @Column(name = "Last_Name")
    private String lname;
    @Column(name = "Age")
    private int age;
    @Temporal(TemporalType.DATE)
    @Column(name = "Date_of_Birth")
    private Date dob;

    @OneToOne
    @JoinColumn(name = "Author_Book_Id")
    Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

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
