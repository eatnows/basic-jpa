package me.eatnows.bookmanager.service;

import me.eatnows.bookmanager.domain.User;
import me.eatnows.bookmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
public class UserService {

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void put() {
        User user = new User();
        user.setName("newUser");
        user.setEmail("newUser@email.com");

//        userRepository.save(user);

        entityManager.persist(user);
//        entityManager.detach(user); // detached 했기 때문에 아래 이름변경은 변경감지 되지 않는다.

        user.setName("newUserAfterPersist");
        entityManager.merge(user); // 준영속상태이더라도 merge하게되면 반영된다.

//        entityManager.flush();
//        entityManager.clear();  // 메서드를 통해 준영속상태로 변경하게 되면 반드시 clear() 호출하기 전에 flush()를 호출하여 변경내역을 모두 반영하는것을 권장한다.

//        entityManager.remove(user);

        User user1 = userRepository.findById(1L).get();
        entityManager.remove(user1);

//        user1.setName("eatnowwwwwwwwws");
//        entityManager.merge(user1);
    }
}
