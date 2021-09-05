package me.eatnows.bookmanager.repository;

import me.eatnows.bookmanager.domain.Book;
import me.eatnows.bookmanager.domain.BookReviewInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookReviewInfoRepositoryTest {

    @Autowired
    private BookReviewInfoRepository bookReviewInfoRepository;
    @Autowired
    private BookRepository bookRepository;

    @Test
    void crudTest() {
        BookReviewInfo bookReviewInfo = new BookReviewInfo();
//        bookReviewInfo.setBookId(1L);
        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(2);

        bookReviewInfoRepository.save(bookReviewInfo);

        System.out.println(">>> " + bookReviewInfoRepository.findAll());
    }

    @Test
    void crudTest2() {
        givenBookReviewInfo();

        Book result = bookReviewInfoRepository
                .findById(1L)
                .orElseThrow(RuntimeException::new)
                .getBook();
//                .getBookId()


        System.out.println(">>> " + result);

        BookReviewInfo result2 = bookRepository
                .findById(1L)
                .orElseThrow(RuntimeException::new)
                .getBookReviewInfo();

        System.out.println(">>> " + result2);
    }

    private Book givenBook() {
        Book book = new Book();
        book.setName("JPA 스터디");
        book.setAuthorId(1L);
//        book.setPublisherId(1L);

        return bookRepository.save(book);
    }

    private void givenBookReviewInfo() {
        BookReviewInfo bookReviewInfo = new BookReviewInfo();
//        bookReviewInfo.setBookId(1L);
        bookReviewInfo.setBook(givenBook());
        bookReviewInfo.setAverageReviewScore(4.5F);
        bookReviewInfo.setReviewCount(2);

        bookReviewInfoRepository.save(bookReviewInfo);

        System.out.println(">>> " + bookReviewInfoRepository.findAll());
    }
}