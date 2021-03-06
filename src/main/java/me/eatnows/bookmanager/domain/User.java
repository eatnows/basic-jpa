package me.eatnows.bookmanager.domain;

import lombok.*;
import me.eatnows.bookmanager.domain.listener.Auditable;
import me.eatnows.bookmanager.domain.listener.MyEntityListener;
import me.eatnows.bookmanager.domain.listener.UserEntityListener;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity(name = "USER")
@Table(name = "USER")
@EntityListeners(value = {UserEntityListener.class})
//@Table(name = "USER", indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
// index나 constratraint를 jPA에서 설정했다고해서 실제 db에서는 존재하지 않는 index를 활용한 쿼리등 사용할 수 없다.
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

//    @Transient // 영속성 처리에서 제외가 되기때문에 DB 데이터에 반영되지 않고 해당 객체와 생명주기를 같이 하는 값이 된다.
//    // db에 반영하지 않고 사용하고 싶은 object 속성의 데이터
//    private String testData;

    // nullPointerException이 발생할 수 있기 때문에 기본 생성자를 넣어주는 것이 좋다. JPA에서는 조회할때 기본적으로 생성이 되지만 값을 삽입할때 널포인터 이셉션이 발생할 수 있다.
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", insertable = false, updatable = false) // readOnly
    @ToString.Exclude
    private final List<UserHistory> userHistories = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private List<Review> reviews = new ArrayList<>();
}
