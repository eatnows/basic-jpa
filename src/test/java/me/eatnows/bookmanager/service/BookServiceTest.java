package me.eatnows.bookmanager.service;

import me.eatnows.bookmanager.domain.Book;
import me.eatnows.bookmanager.repository.AuthorRepository;
import me.eatnows.bookmanager.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceTest {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void transactionTest() {
//        try {
//            bookService.putBookAndAuthor();
//        } catch (RuntimeException e) {
//            System.out.println(">>> " + e.getMessage());
//        }
        try {
//            bookService.put();
            bookService.putBookAndAuthor();
        } catch (RuntimeException e) {
            System.out.println(">>> " + e.getMessage());
        }

        System.out.println("book : " + bookRepository.findAll());
        System.out.println("authors : " + authorRepository.findAll());

    }

    @Test
    void isolationTest() {
        Book book = new Book();
        book.setName("JPA 강의");

        bookRepository.save(book);

        bookService.get(1L);

        System.out.println(">>> " + bookRepository.findAll());
    }

}