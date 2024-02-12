package cgg.springboot.restapi.restapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cgg.springboot.restapi.restapi.entities.Book;
import cgg.springboot.restapi.restapi.services.BookService;

@RestController
public class BookController {

    @Autowired
    private BookService bs;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {

        List<Book> books = bs.getBooks();
        if (books.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        } else {
            return ResponseEntity.of(Optional.of(books));

        }

    }

    @GetMapping("/books/{bookid}")
    public ResponseEntity<Book> getBookById(@PathVariable("bookid") int id) {
        Optional<Book> book = null;
        book = bs.getBook(id);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        } else {

            return ResponseEntity.of(book);

        }

    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book b) {
        Book book = null;
        try {

            this.bs.addBook(b);
            return ResponseEntity.status(HttpStatus.CREATED).body(book);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PutMapping("/books/{bookid}")
    public ResponseEntity<Book> updateBook(@RequestBody Book b, @PathVariable("bookid") int id) {
        try {
            boolean updateBook = bs.updateBook(b, id);
            if (updateBook == true) {

                return ResponseEntity.ok().body(b);
            } else {

                throw new Exception();
            }
            // return ResponseEntity.ok().body(b);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @DeleteMapping("/books/{bookid}")
    public ResponseEntity<Boolean> deleteBook(@PathVariable("bookid") int id) {

        boolean deleteBook = bs.deleteBook(id);

        if (deleteBook == true) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @DeleteMapping("/books")
    public void deleteAll() {

        bs.deleteAll();

    }

}
