package me.eatnows.bookmanager.repository;

import me.eatnows.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

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

//        User user = userRepository.findById(1L).orElse(null);
//        System.out.println(user);

        // save and save flush
//        userRepository.saveAndFlush(new User("new eatnows", "neweatnows@email.comx"));
//        userRepository.flush();
//        userRepository.findAll().forEach(System.out::println);

        // count
//        long count = userRepository.count();
//        System.out.println(count);

        // exists
        // jpa에서는 내부적으로 count 쿼리가 실행됨
//        boolean exists = userRepository.existsById(1L);
//        System.out.println(exists);

        // delete
        // delete query를 하기 전에 해당 엔티티가 실제로 존재하는지 체크하기 때문에 select를 먼저 한다.
        // for loop를 통해 하나씩 delete query를 실행
//        userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));
//        userRepository.deleteById(1L);

//        userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(1L, 3L)));

        // deleteInBatch
        // or 연산을 사용하여 delete query를 한번만 실행
        // delete 쿼리 이전에 select 쿼리도 존재하지 않는다.
//        userRepository.deleteInBatch(userRepository.findAllById(Lists.newArrayList(1L, 3L)));

//        userRepository.deleteAllInBatch(userRepository.findAllById(Lists.newArrayList(1L, 3L)));
//        userRepository.findAll().forEach(System.out::println);

        // page
//        Page<User> users = userRepository.findAll(PageRequest.of(1, 3));
//        System.out.println("page : " + users);
//        System.out.println("totalElements : " + users.getTotalElements());
//        System.out.println("totalPages : " + users.getTotalPages());
//        System.out.println("numberOfElements : " + users.getNumberOfElements()); // 현재 가져온 레코드 수가 몇개인지
//        System.out.println("sort : " + users.getSort());
//        System.out.println("size : " + users.getSize());
//
//        users.getContent().forEach(System.out::println);

        // Query By Example (Query Matcher)
//        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withIgnorePaths("name") // 매칭하는데서 무시하겠다.
//                .withMatcher("email", endsWith()); // 확인하겠다. (email을 endsWith()로 매칭하겠다.)
//
//        Example<User> example = Example.of(new User("ma", "email.com"), matcher); // probe : 실제 entity는 아님. 가짜 entity라고 봐도된다.
//        userRepository.findAll(example).forEach(System.out::println);

        User user = new User();
        user.setEmail("email");

        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("email", contains()); // email은 컬럼 contains()는 %like%
        Example<User> example = Example.of(user, matcher);

        userRepository.findAll(example).forEach(System.out::println);
    }

}