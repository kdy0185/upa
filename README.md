# URL Parsing API (upa)


## Description

**URL 파싱** 및 데이터 가공 **API**


## Environment

* Java : 11.0.13
* Spring : 5.3.16
* Spring Boot : 2.6.4
* Tomcat (Embedded) : 9.0.58
* Packaging : Jar
* Dependency : Gradle
* Execute Tool : IntelliJ 2021.3.2

> * External Library : Swagger 3.0.0


## Execution

* 실행 파일 : UpaApplication.java
* 기본 주소 : http://localhost:8080/api/dataParsing
* Swagger로 실행 : http://localhost:8080/swagger-ui/index.html


## Functions

**URL 및 조건 입력 시 그에 맞는 데이터 출력**
  * HTML 태그 제외 여부 선택 가능
  * 영어 + 숫자 출력 기능 적용
  * 오름차순 정렬 기능 적용
  * 교차 출력 기능 적용
  * 단위 묶음별 출력 기능 적용


## Test

* 파라미터 목록
  > * **`url`** : 파싱할 URL
  > * **`dataType`** : 노출 유형
  >   * `H` : Html 태그 제외
  >   * `T` : Text 전체
  > * **`unit`** : 출력 묶음 단위

* 입력은 JSON 형식으로 진행
```
// 입력 예시
{
    "url" : "http://google.com/",
    "dataType" : "H",
    "unit" : 20
}
```


## Author

* D.W Kang (kdy0185@gmail.com)
* https://github.com/kdy0185
