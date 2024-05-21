----

> Java 의 다양한 기능을 활용해보며 이것저것 개발 및 테스트 해보는 프로젝트입니다. 

- Java 21
- Gradle 8.5
  - `./gradlew wrapper --gradle-version=8.5`
- Spring Boot 3.2.0
- JUnit 5
- h2
  - `jdbc:h2:mem:testdb`
- JPA

----

> 문서화 방식
- gradle restdocs-api-spec 0.18.4

`./gradlew openapi3`




----


> 
> 개발 관련 문서도 일부 포함되어 있습니다.
> 

### 소프트웨어 개발 방법론

[DDD](./docs/ddd/readme.md)
- `Domain Driven Development`: 도메인 주도 개발

[TDD](./docs/tdd/readme.md)
- `Test Driven Development`: 테스트 주도 개발

BDD
- `Behavior Driven Development`: 행위 주도 개발
  - 테스트 코드를 작성할 때, 테스트 메소드의 이름을 테스트하고자 하는 기능에 대한 설명으로 작성하는 방법론

