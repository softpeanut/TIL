# AOP

### AOP(Aspect Oriented Programing)란?

##### 어플리케이션 전체에 걸쳐 사용되는 기능을 재사용하도록 지원하는 것이다.



![Spring AOP, Aspect 개념 특징, AOP 용어 정리](https://img1.daumcdn.net/thumb/R720x0.q80/?scode=mtistory2&fname=http%3A%2F%2Fcfile8.uf.tistory.com%2Fimage%2F99F4E5475C722F6C09722E)



> 핵심기능적인 관점으로 바라보았을 때는 공통된 요소가 없다.
>
> 하지만 **부가기능**적인 관점으로 바라보면 공통된 요소가 있다.
>
> 로깅, 보안, 트랜잭션이 공통적으로 들어간다.
>
> 어플리케이션 전체에 사용되던 공통 기능이 **하나의 장소**에서 관리하게 된다.
>
> 이로 인해, 다른 서비스 모듈은 본래의 목적에만 충실하면 된다.



## AOP 용어

- **Target** 

  > 부가기능을 부여할 대상

- **Aspect**

  > 핵심기능에 부가되어 의미를 갖는 모듈
  >
  > Advice와 PointCut을 함께 가지고 있다.

- **Advice**

  > 실제 부가기능을 담은 구현체
  >
  > Aspect가 '무엇'을 '언제'할지 정의

- **PointCut**

  > 부가기능이 적용될 대상을 선정하는 방법
  >
  > Advice를 적용할 JoinPoint를 선별하는 기능을 정의한 모듈

- **JoinPoint**

  > Advice가 적용될 수 있는 위치
  >
  > 무조건 메소드 단위

- **Proxy**

  > 타겟의 요청을 대신 받아주는 Wrapping 오브젝트
  >
  > 클라이언트의 호출을 가로채 Advice에 등록된 기능을 수행 후(전) 타겟 메소드를 호출

  ![img](https://t1.daumcdn.net/cfile/tistory/2715394658496A6101)

- **Introduction**

  > 타겟 클래스에 코드 변경없이 신규 메소드나 멤버변수를 추가하는 기능

- **Weaving**

  > 지정된 객체에 Aspect를 적용해서 새로운 프록시 전체를 생성하는 과정

