## Persistence Context
framework에서 주로 container들이 관리하고 있는 내용들을 `context` 라고한다. `persistence context`는 `persistence`가 관리하고 있는 내용을 `persistence context`라고 볼 수 있다.


### Persistence (영속화)
사라지지 않고 지속적인 성질을 말한다.



#### ddl-auto
none : ddl-auto를 실행하지 않는다. <br>
create : 항상 새로 생성한다. `persistence context`를 띄울때 앞쪽에서 drop을 한다. 
create-drop : 생성하고 `persistence context`가 종료될때 자동으로 drop <br>
update : 실제 스키마와 엔티티 클래스를 비교해서 변경에 대한 부분만 반영한다. drop 하지 않음. <br>
validate : 단순 비교작업을 함. 엔티티 클래스와 실제 스키마가 다르면 오류를 발생한다. <br>


#### generate-ddl과 ddl-auto의 차이점
`generate-ddl`는 jpa의 하위속성이다. jpa는 인터페이스에 대한 정의이며 실제 구현체는 별도로 존재한다. 
`generate-ddl`은 구현체와 상관없이 자동화된 db를 사용할 수 있도록 설정하는 값이다.(범용적인 옵션)

스프링에서는 `ddl-auto`가 더 세밀한 설정이기 때문에 `ddl-auto`가 설정되어 있는 경우에는 `generate-ddl`옵션을 무시한다.

embeded db (h2)를 사용할 경우 `ddl-auto`옵션이 create-drop 으로 기본 작동한다.



#### 비영속상태 (transient 상태, new 상태)
영속성 컨텍스트가 해당 엔티티 객체를 관리하지 않는 상태 <br>
`@Transient` 는 해당 필드를 영속화에서 제외하겠다. 하나의 자바 오브젝트로 취급된다. 


#### 영속상태
해당 엔티티가 영속성 컨텍스트 관리하에 존재하는 상태 <br>

#### 준영속상태 (detached)
영속화되어있던 객체를 분리해서(detached) 영속성 컨텍스트 밖으로 꺼내는 것 


#### 삭제상태 (remove)
삭제를 하게되면 해당 엔티티는 더이상 사용할 수 없다.



## Transaction
### Unchecked Exception (RuntimeException)
Transaction내에서 UncheckedException이 발생할 경우 rollback이 이루어진다. (try-catch로 핸들링 하여도 기본적으로는 rollback을 수행한다.)

### Checked Exception (Exception)
Transaction내에서 CheckedException이 발생할 경우 강제된 핸들링으로 인해 commit이 이루어진다.


### Isolation
level이 높아질 수록 격리단계가 강력해지고, 데이터의 정합성을 보장해준다. 하지만 동시처리능력이 떨어지게 되고 
반대로 level이 낮아질 수록 동시처리능력은 향상되지만 일부 데이터의 정합성을 보장하지 못하는 경우가 발생할 수도 있다. 
#### Default
DB 기본 격리단계를 따라가는 것을 의미. (mysql의 경우 REPEATABLE_READ 단계)
#### READ_UNCOMMITTED (level 0)

#### READ_COMMITTED (level 1)

#### REPEATABLE_READ (level 2)
트랜잭션 내에 데이터가 변경되어도 스냅샷에 저장된 데이터를 계속 반환하여 트랜잭션 내에서 데이터가 변경되지 않는다.
팬텀리드 현상이 발생할 수 있다.
#### SERIALIZABLE (level 3)
commit이 일어나지 않은 트랜잭션이 존재하게 되면 락을 통해서 웨이팅을 하게 된다.
commit이 실행되어야만 추가적인 로직 진행을 하게 된다.