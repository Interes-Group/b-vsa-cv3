package sk.stuba.fei.uim.vsa.cv2;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NamedNativeQueries({
        @NamedNativeQuery(name = Book.FIND_ALL, query = "select * from Book", resultClass = Book.class)
})
@NamedQueries({
        @NamedQuery(name = Book.FIND_BY_ID, query = "select b from Book b where b.id = :id"),
        @NamedQuery(name = Book.FIND_BY_TITLE, query = "select b from Book b where b.title = :title")
})
public class Book {
    public static final String FIND_ALL = "Book.findAll";
    public static final String FIND_BY_ID = "Book.findById";
    public static final String FIND_BY_TITLE = "Book.findByTitle";

    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    private String title;

    @Basic
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private double price;

    @Basic
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return title + " (" + price + "€)";
    }
}
