package me.eatnows.bookmanager.domain;

import lombok.*;
import me.eatnows.bookmanager.domain.listener.Auditable;
import me.eatnows.bookmanager.domain.listener.MyEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@ToString(callSuper = true)
@Builder
@Entity(name = "USER")
@Table(name = "USER")
@EntityListeners(value = {MyEntityListener.class})
//@Table(name = "USER", indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
// index나 constratraint를 jPA에서 설정했다고해서 실제 db에서는 존재하지 않는 index를 활용한 쿼리등 사용할 수 없다.
public class User extends BaseEntity implements Auditable {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @Transient // 영속성 처리에서 제외가 되기때문에 DB 데이터에 반영되지 않고 해당 객체와 생명주기를 같이 하는 값이 된다.
    // db에 반영하지 않고 사용하고 싶은 object 속성의 데이터
    private String testData;

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Address> address;

//    @PrePersist
//    public void prePersist() {
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    public void preUpdate() {
//        this.updatedAt = LocalDateTime.now();
//    }
}
