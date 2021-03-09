package sk.stuba.fei.uim.vsa.cv2;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        // CV2 code:
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager manager = managerFactory.createEntityManager();

        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        Book silmarillion = new Book("Silmarillion", 16.15);
        // transient
        manager.persist(silmarillion);
        // persistent
        manager.persist(new Book("Hobit", 7.95));
        manager.persist(new Book("Hobit", 14.95));
        manager.persist(new Book("Pán prsteňov I. - Spoločenstvo prsteňa", 8.79));

        Book book = new Book("Pan prstenov", 10);
        book.setId(10L);
        Book book2 = manager.merge(book);
        transaction.commit();

        transaction.begin();
        book.setId(5L);
        book.setPrice(20);
        book2 = manager.merge(book);


        transaction.commit();

        TypedQuery<Book> namedQuery = manager.createNamedQuery(Book.FIND_ALL, Book.class);
        List<Book> books = namedQuery.getResultList();
        for (Book book1 : books) {
            System.out.println(book1);
        }

    }
}
