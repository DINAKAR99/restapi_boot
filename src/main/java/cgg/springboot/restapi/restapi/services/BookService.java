package cgg.springboot.restapi.restapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cgg.springboot.restapi.restapi.dao.BookRepo;
import cgg.springboot.restapi.restapi.entities.Book;

@Service
public class BookService {

    // private static List<Book> books = new ArrayList<>();
    @Autowired
    public BookRepo b1;

    public List<Book> getBooks() {

        List<Book> all = (List<Book>) b1.findAll();

        return all;

    }

    public Optional<Book> getBook(int id) {
        // Optional<Book> book = books.stream().filter(b -> b.getBookid() ==
        // id).findFirst();

        Optional<Book> byId = b1.findById(id);

        // Book book = first.get();
        return byId;
    }

    public Book addBook(Book b) {

        // books.add(b);

        b1.save(b);

        return b;

    }

    public boolean updateBook(Book bk, int id) {
        // Book book = books.stream().filter(s -> s.bookid == id).findFirst().get();

        boolean flag = false;

        Book book = b1.findById(id).get();

        if (book == null) {
            return flag;
        } else {

            book.setAuthor(bk.getAuthor());
            book.setTitle(bk.getTitle());
            b1.save(book);
            flag = true;
            return flag;
        }

    }

    public boolean deleteBook(int id) {

        // boolean removeIf = books.removeIf(s -> s.getBookid() == id);
        // return removeIf;

        b1.deleteById(id);

        return true;
    }

    public void deleteAll() {
        b1.deleteAll();
    }

}
