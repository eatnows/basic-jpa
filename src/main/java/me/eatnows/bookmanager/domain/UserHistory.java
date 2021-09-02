package me.eatnows.bookmanager.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import me.eatnows.bookmanager.domain.listener.Auditable;
import me.eatnows.bookmanager.domain.listener.MyEntityListener;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true) // 상속받은 정보를 처리되지 않는다고 @Data에서 warning이 발생해 해결해주기 위해 추가
@EqualsAndHashCode(callSuper = true)
//@EntityListeners(value = {AuditingEntityListener.class})
public class UserHistory extends BaseEntity implements Auditable {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;

    private String name;

    private String email;

//    @CreatedDate
//    private LocalDateTime createdAt;
//
//    @LastModifiedDate
//    private LocalDateTime updatedAt;
}
