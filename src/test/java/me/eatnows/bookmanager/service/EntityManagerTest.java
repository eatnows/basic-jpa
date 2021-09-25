package me.eatnows.bookmanager.service;

import me.eatnows.bookmanager.domain.User;
import me.eatnows.bookmanager.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
// transactional에서는 최대한 db 반영을 늦춘다. 영속성 컨텍스트에서 엔티티 매니저가 자체적으로 엔티티 상태를 머지하고 최종적으로 디비를 반영해야하는 내용에 대해서만 쿼리가 실행된다.
@Transactional
public class EntityManagerTest {

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @Test
    void entityManagerTest() {
        // 하이버네이트에서는 entitymanager를 session이라고 부른다.
        System.out.println(entityManager.createQuery("select u from USER u").getResultList());
    }

    @Test
    void cacheFindTest() {
        // 조회 시 영속성 컨텍스트내에 존재하는 entity cache에서 처리하기 떄문에 반복되는 쿼리는 두번 이상부터는 직접 디비를 조회하지 않는다.
        // (따로 설정하지 않았지만 영속성 컨텍스트내에서 엔티티에 대해서 캐시처리하는 것을 jpa 1차캐시 라고 한다)

        // 1차캐시는 Map 형식으로 만들어진다 key는 id , value는 해당 엔티티가 들어있다.
        // id로 조회하게 되면 영속성 컨텍스트 내에 존재하는 1차캐시내에 값이 존재하는지 찾는다. (있으면 반환, 없으면 디비 조회 -> 1차캐시 저장 -> 반환)
        System.out.println(userRepository.findById(1L).get());
        System.out.println(userRepository.findById(1L).get());
        System.out.println(userRepository.findByEmail("eatnows@email.com"));

        userRepository.deleteById(1L);    // transactional안에서는 롤백 트랜잭션이 실행되어 실제 db 쿼리가 날라가진 않는다.
    }

    @Test
    void cacheFindTest2() {
        User user = userRepository.findById(1L).get();
        user.setName("eatnowwwwwwwwwws");

        userRepository.save(user);

        System.out.println("-----------------------------");

        user.setEmail("eatnowwwwwwwwwwwwwws@email.com");

        userRepository.save(user);

//        userRepository.flush();

        System.out.println(">>>> 1 : " + userRepository.findById(1L).get());

        userRepository.flush();

        System.out.println(">>>> 2 : " + userRepository.findById(1L).get());
    }
}
