package me.eatnows.bookmanager.service;

import lombok.RequiredArgsConstructor;
import me.eatnows.bookmanager.domain.Author;
import me.eatnows.bookmanager.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void putAuthor() {
        Author author = new Author();
        author.setName("eatnows");

        authorRepository.save(author);
    }
}
