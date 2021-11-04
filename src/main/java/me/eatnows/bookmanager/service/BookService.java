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
    public void putBookAndAuthor() throws Exception {
        Book book = new Book();
        book.setName("JPA 시작하기");

        bookRepository.save(book);

        Author author = new Author();
        author.setName("eatnows");

        authorRepository.save(author);

        // RuntimeException 과 같은 UncheckedException 은 Transaction내에서 발생할 경우 rollback이 이루어진다.
//        throw new RuntimeException("오류가 나서 DB commit이 발생하지 않습니다.");
        // Exception 과 같은 CheckedException 은 Transaction내에서 발생할 경우 강제된 핸들링으로 인해 commit 된다.
        throw new Exception("오류가 나서 DB commit이 발생하지 않습니다.");
    }
}
