package me.eatnows.bookmanager.repository;

import me.eatnows.bookmanager.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void bookTest() {
        Book book = new Book();
        book.setName("JPA 초격자 패키지");
        book.setAuthor("지은이");

        bookRepository.save(book);

        System.out.println(bookRepository.findAll());
    }
}
