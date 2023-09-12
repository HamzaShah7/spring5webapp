package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repo.AuthorRepo;
import guru.springframework.spring5webapp.repo.BookRepo;
import guru.springframework.spring5webapp.repo.PublisherRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;
    private final PublisherRepo publisherRepo;

    public BootStrapData(AuthorRepo authorRepo, BookRepo bookRepo, PublisherRepo publisherRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher Ilmi = new Publisher("Ilmi","UrduBazaar","Lahore","Punjab","54000");
        publisherRepo.save(Ilmi);

        Author Khizar = new Author("Khizar","Ali");
        Book Money = new Book("How to earn money","123123");

        Khizar.getBooks().add(Money);
        Money.getAuthors().add(Khizar);
        Money.setPublisher(Ilmi);
        Ilmi.getBooks().add(Money);

        authorRepo.save(Khizar);
        bookRepo.save(Money);


        Author Ammad = new Author("Ammad","Asif");
        Book MentalCalm = new Book("Emotional Control","321321");

        Ammad.getBooks().add(Money);
        MentalCalm.getAuthors().add(Khizar);
        MentalCalm.setPublisher(Ilmi);
        Ilmi.getBooks().add(MentalCalm);

        authorRepo.save(Ammad);
        bookRepo.save(MentalCalm);
        publisherRepo.save(Ilmi);

        System.out.println("Started!!!");
        System.out.println("Number of Books: " + bookRepo.count());
        System.out.println("Publisher Number of books:" + Ilmi.getBooks().size());

    }
}
