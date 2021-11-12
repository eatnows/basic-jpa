package me.eatnows.bookmanager.service;

import lombok.RequiredArgsConstructor;
import me.eatnows.bookmanager.domain.Author;
import me.eatnows.bookmanager.domain.Book;
import me.eatnows.bookmanager.repository.AuthorRepository;
import me.eatnows.bookmanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final EntityManager entityManager;

    // put이라는 method에 진입하는순간 bean 내부로 들어왔고, (put이라는 bean)
    // bean 내부에 다른 method를 호출하게 되면 그 method에 있는 @transactional은 효과가 없다.
//    public void put() {
//        this.putBookAndAuthor();
//    }

    // Transaction() : 트랜잭션이 끝나야 COMMIT
    // @Transactional(rollbackFor = Exception.class) :  rollbackOn에 해당 Exception 클래스를 포함. 즉 Exception(checked exception) 이 발생해도 rollback이 일어난다.
    // 스프링 컨테이너는 빈으로 진입할때 @Transactional 처리하도록 되어있다.
    // 빈 클래스 내부에서 외부를 호출할 때는 @Transactional 효과가 없다.
    @Transactional
    public void putBookAndAuthor() {
        Book book = new Book();
        book.setName("JPA 시작하기");

        bookRepository.save(book);

        Author author = new Author();
        author.setName("eatnows");

        authorRepository.save(author);

        // RuntimeException 과 같은 UncheckedException 은 Transaction내에서 발생할 경우 rollback이 이루어진다.
        throw new RuntimeException("오류가 나서 DB commit이 발생하지 않습니다.");
        // Exception 과 같은 CheckedException 은 Transaction내에서 발생할 경우 강제된 핸들링으로 인해 commit 된다.
//        throw new Exception("오류가 나서 DB commit이 발생하지 않습니다.");
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void get(Long id) {
        System.out.println(">>> " + bookRepository.findById(id));
        System.out.println(">>> " + bookRepository.findAll());

        entityManager.clear();

        System.out.println(">>> " + bookRepository.findById(id));
        System.out.println(">>> " + bookRepository.findAll());

        bookRepository.update();

        entityManager.clear();
//        Book book = bookRepository.findById(id).get();
//        book.setName("바뀔까?");
//        bookRepository.save(book);
    }
}
