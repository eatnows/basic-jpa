package me.eatnows.bookmanager.repository;

import me.eatnows.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() {
//        List<User> users = userRepository.findAllById(Lists.newArrayList(1L, 3L, 5L));
//
//        users.forEach(System.out::println);

//        User user1 = new User("jack", "jack@email.com");
//        User user2 = new User("steve", "steve@email.com");
//
//        userRepository.saveAll(Lists.newArrayList(user1, user2));
//
//        List<User> users = userRepository.findAll();
//        users.forEach(System.out::println);

        // getOne은 lazy fetch를 지원하고 있다.
//        User user = userRepository.getOne(1L);
//
//        System.out.println(user);

        User user = userRepository.findById(1L).orElse(null);

        System.out.println(user);
    }
}