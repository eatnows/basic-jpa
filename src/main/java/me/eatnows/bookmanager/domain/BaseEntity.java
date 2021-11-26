package me.eatnows.bookmanager.domain;

import lombok.Data;
import me.eatnows.bookmanager.domain.listener.Auditable;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass   // 해당 클래스의 필드를 상속받는 엔티티의 컬럼으로 포함시켜주겠다는 의미
@EntityListeners(value = AuditingEntityListener.class)
public class BaseEntity implements Auditable {

    @CreatedDate
    // 실무에서는 columnDefinition 옵션을 잘 사용하지 않음
    // columnDefinition 속성은 auto DDL을 할때 사용할 수 있는 추가적인 속성이다.
    // 해당 값이 없이 실행하면
    @Column(nullable = false, updatable = false, columnDefinition = "datetime(6) default now(6) comment '생성시간''")
    private LocalDateTime createdAt;

    // now(6)의 6은 자릿수를 의미한다. (초 단위 하위의 몇 자리까지 나타내느냐)
    //
    @LastModifiedDate
    @Column(nullable = false, columnDefinition = "datetime(6) default now(6) comment '수정시간'")
    private LocalDateTime updatedAt;
}
