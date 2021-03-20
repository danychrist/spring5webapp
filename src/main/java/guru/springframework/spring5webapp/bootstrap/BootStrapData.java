package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Address;
import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author sop = new Author("Sop", "Nzenang");
        Book ddd = new Book("Domain Driven Design", "1234567");
        Address addressSOP = new Address("414 w 4th st","Wilmington", "DE", 19801);//address object
        Publisher SOPPublishing = new Publisher("SOPPublishing", addressSOP);

        sop.getBooks().add(ddd); //sop is the author of ddd book
        ddd.getAuthors().add(sop); //ddd book is authored by sop
        SOPPublishing.getBooks().add(ddd); //SOPPublishing published ddd book
        ddd.setPublisher(SOPPublishing); //ddd is published by SOPPublishing

        authorRepository.save(sop);//saved author object
        bookRepository.save(ddd); //saved book object
        publisherRepository.save(SOPPublishing);


        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "678540000");
        Address addressAB = new Address("716 Gateway ", "Hockessin", "DE", 19707);
        Publisher publisherAB = new Publisher("AB-Publishing", addressAB);

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(publisherAB);
        publisherAB.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisherAB);


        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of publisher(s): " + publisherRepository.count());
        System.out.println(SOPPublishing.getName() +" has published "+ SOPPublishing.getBooks().size() +" book(s)");
    }
}
