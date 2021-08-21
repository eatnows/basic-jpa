package me.eatnows.bookmanager.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void test() {
        User user = new User();
        user.setEmail("eatnows@email.com");
        user.setName("eatnows");

        User user1 = new User(null, "eatnows", "eatnows@email.com", LocalDateTime.now(), LocalDateTime.now());
        User user2 = new User("eatnows", "eatnows@email.com");

        System.out.println(">>> " + user);
    }

}