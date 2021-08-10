# NOSQL이란?

### NOSQL(Not Only SQL) : 비관계형 데이터베이스

- ##### RDBMS는 관계형 데이터베이스

  

### 1. NOSQL을 사용하는 경우와 그 이유

> - 아주 많은 양의 데이터를 효율적으로 처리할 때
> - 데이터의 분산처리, 빠른 쓰기 및 데이터의 안정성이 필요할 때
> - 서버에 장애가 발생해도 데이터 유실이나 서비스 중지가 없는 형태의 구조



### 2. NOSQL의 종류

> - **key - value 스토리지 형** : Redis, Memcached, Cash
> - **문서형** : MongoDB, Couchbase, DocumentDB
> - **컬럼형** :  HBASE, Cassandra
> - **그래프형** : Neo4J, AgensGraph



### 3. CAP 정리란?

> **일관성, 가용성, 분할 내성 3가지 중 최대 2가지만 만족할 수 있다.**
>
> - 일관성(Consistency) - 모든 노드들이 동일 시간 동일 데이터를 사용자에게 보여줘야 하는 것
>
> - 가용성(Availability) - 특정 노드에 장애가 발생해도 성공적으로 서비스를 지속하는 것
>
> - 분할 내성(Partition tolerance) - 연결이 끊어져도 연속해서 동작하는 것
>
> ![img](https://blog.kakaocdn.net/dn/c4NR5K/btqCQo34VDW/YjDFMkDpe4SisQptfVYstK/img.png)



### 3-1. CAP 정리에 따른 DBMS 선택 전략

> 1. C + A (일반적인  DBMS)
>    - 특정 노드가 죽더라도 시스템은 정상적으로 동작
>    - 메시지 손실을 방지하는 강한 신뢰형
>    - 트랜잭션이 필요한 경우 필수적
> 2. C + P(HBASE, MongoDB)
>    - 모든 노드가 함께 퍼포먼스를 내야하는 성능형
> 3. A + P(Cassandra, CounchDB)
>    - 비동기화된 스토어 작업에 필수적
