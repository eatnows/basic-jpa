package me.eatnows.bookmanager.repository;

import me.eatnows.bookmanager.domain.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);

    Set<User> findUserByNameIs(String name);    // IS, equals 생략 가능하다. 코드의 가독성을 좋게 하기 위해 제공되는 느낌.
    Set<User> findUserByName(String name);
    Set<User> findUserByNameEquals(String name);

    User findByEmail(String email);

    User getByEmail(String email);

    User readByEmail(String email);

    User queryByEmail(String email);

    User searchByEmail(String email);

    User streamByEmail(String email);

    User findUserByEmail(String email);

    User findSomethingByEmail(String email);

    List<User> findFirst2ByName(String name);

    List<User> findTop2ByName(String name);

    List<User> findByEmailAndName(String email, String name);

    List<User> findByEmailOrName(String email, String name);

    List<User> findByCreatedAtAfter(LocalDateTime yesterday);

    List<User> findByIdAfter(Long id);

    List<User> findByCreatedAtGreaterThan(LocalDateTime yesterday); // 해당값보다 큰 것만

    List<User> findByCreatedAtGreaterThanEqual(LocalDateTime yesterday);

    List<User> findByCreatedAtBetween(LocalDateTime yesterday, LocalDateTime tomorrow);

    List<User> findByIdBetween(Long id1, Long id2); // 양 끝단의 값을 포함함

    List<User> findByIdGreaterThanEqualAndIdLessThanEqual(Long id1, Long id2); // findByIdBetween()을 풀어 쓴것과 같다.

    List<User> findByIdIsNotNull();

//    List<User> findByAddressIsNotEmpty(); // 컬렉션이 not empty인지

    List<User> findByNameIn(List<String> names);

    List<User> findByNameStartingWith(String name);

    List<User> findByNameEndingWith(String name);

    List<User> findByNameContains(String name);

    List<User> findByNameLike(String name);

    List<User> findTop1ByName(String name);

    List<User> findLast1ByName(String name);

    List<User> findTopByNameOrderByIdDesc(String name);

    List<User> findFirstByNameOrderByIdDescEmailAsc(String name);

    List<User> findFirstByName(String name, Sort sort);

}
