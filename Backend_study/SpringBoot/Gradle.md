# Gradle에 대해 알아보자

### Gradle이란?

###### : 자바에서 이용하는 build tool(빌드 도구)이다. 

###### 빌드란 컴파일, 테스트, 배포, 문서화 등의 작업을 포함하는 절차를 의미한다. 

###### 이러한 빌드의 모든 과정을 자동으로 처리할 수 있도록 도와주는 것이 build tool이다.

######  

## build.gradle

gradle에서 빌드 작업에 필요한 기본 설정, 동작 등을 정의하는 파일이다.



#### Plugins

plugins 블록 안에 필요한 plugin을 지정해준다. (예 : jar 파일 생성)

이런 plugin들은 필요한 과정들을 task로 포함하고 있다.



#### repositories

저장소 정보를 관리하는 프로퍼티이다. 로컬 환경이나 네트워크에 라이브러리를 공개하고 그 주소를 저장소로 등록하면 저장소에 있는 라이브러리를 gradle이 취득하여 이용할 수 있다. 



#### dependencies

의존성에 관한 설정을 관리하는 프로퍼티이다. 필요한 라이브러리 등의 정보를 기술하면 그 라이브러리를 참조할 수 있다. 

'group:name:version'

> implementation - 컴파일 할 때
>
> testimplementation - 테스트를 컴파일 할 때
>
> conpileOnly - 컴파일시에만
>
> runtimeOnly - 런타임시에만



