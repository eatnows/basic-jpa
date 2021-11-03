package me.eatnows.bookmanager.service;

import lombok.RequiredArgsConstructor;
import me.eatnows.bookmanager.domain.Author;
import me.eatnows.bookmanager.domain.Book;
import me.eatnows.bookmanager.repository.AuthorRepository;
import me.eatnows.bookmanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    // 트랜잭션이 끝나야 COMMIT
    @Transactional
    public void putBookAndAuthor() {
        Book book = new Book();
        book.setName("JPA 시작하기");

        bookRepository.save(book);

        Author author = new Author();
        author.setName("eatnows");

        authorRepository.save(author);
    }
}
