package exercise4;

import javax.persistence.*;

@Entity
public class AuthorDemo {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;

    @OneToOne
    @JoinColumn(name = "author_book")
    BookDemo bookDemo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BookDemo getBookDemo() {
        return bookDemo;
    }

    public void setBookDemo(BookDemo bookDemo) {
        this.bookDemo = bookDemo;
    }
}
