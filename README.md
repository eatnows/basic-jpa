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



