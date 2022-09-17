package org.techpleiad.exploration.web;

import org.jboss.logging.Logger;
import org.techpleiad.exploration.domain.Book;
import org.techpleiad.exploration.repository.BookRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/books")
public class BookResource {

    @Inject
    private BookRepository bookRepository;

    @Inject
    private Logger logger;

    @GET
    public List<Book> getAllBooks() {
        logger.info("Returns all the books");
        return bookRepository.getAllBooks();
    }

    @GET
    @Path("/count")
    public int countAllBooks() {
        logger.info("Returns the number of books");
        return bookRepository.getAllBooks().size();
    }

    @GET
    @Path("{id}")
    public Optional<Book> getBook(@PathParam("id") int id) {
        logger.info("Returns book with id " + id);
        return bookRepository.getBook(id);
    }
}
