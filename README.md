# READ ME

## 1. View 생성</span>
메인페이지 mainForm </br>
개인정보 수정페이지 updateForm </br>
비밀번호 수정페이지 passwordResetForm </br>
로그인페이지 loginForm </br>
회원가입페이지 joinForm </br>
비밀번호확인페이지 checkPasswordForm </br>
게시글 작성페이지 writeForm </br>
게시글 수정페이지 updateForm </br>
게시글 목록페이지 listForm </br>
게시글 상세페이지 detailForm </br>
게시글 상단 post-header </br>
메인 상단 main-header </br>
메인 하단 footer </br>
카테고리 관리페이지 writeForm </br>
카테고리별 게시글 목록페이지 listForm 

.
</br>
</br>
## 2. 기능

계정관리 기능 (완)

카테고리별 CRUD (완)

사이드바 (완)

계정정보 수정 (완)

게시글 CRUD (완)

로그인 (완)

회원가입 (완)

로그아웃 (완)
</br>
</br>
.
## 3. 고급 기능

블로그 구독기능

게시글 좋아요 기능

카테고리별 카운트 표시 기능

게시글, 프로필 이미지 업로드 기능

메인 페이지, 블로그 게시글 페이징 기능

라이브리 시티 활용한 댓글 기능

검색바 - 제목별, 제목+내용, 작성자 검색기능

블로그 방문 횟수 표시 기능

웹소켓으로 구독한 블로그 게시글 등록시 알림기능

유효성 검사

Security 활용하여 이메일로 비밀번호 변경 기능

Redis 로그인 기능

Junit 테스트

AWS 배포

RestController - 2차 변환 후 Flutter 연결
</br>
</br>
.
## 4. 테이블 생성

```sql
USE blogdb;


create table user(
    user_id int primary KEY auto_increment,
    username VARCHAR(20) NOT NULL UNIQUE,
	password varchar(20) NOT NULL,
    nick_name varchar(20) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    created_at TIMESTAMP NOT NULL DEFAULT current_timestamp
);

create table category(
	category_id INT primary KEY auto_increment,
    category_title VARCHAR(50) NOT NULL, 
	user_id INT NOT null,
    created_at TIMESTAMP NOT NULL DEFAULT current_timestamp
);




```
.
</br>
</br>
## 5. 더미데이터
</br>

```sql
INSERT INTO user(username, password,email,nick_name,created_at) 
VALUES('ssar','1234','ssar@nate.com','ssar',NOW());
INSERT INTO user(username, password,email,nick_name,created_at) 
VALUES('cos','1234','cos@nate.com','cos',NOW());
INSERT INTO user(username, password,email,nick_name,created_at) 
VALUES('hong','1234','hong@nate.com','hong',NOW());

INSERT INTO category(category_title, user_id, created_at) 
VALUES('1번 타이틀 더미 데이터',1,NOW());
INSERT INTO category(category_title, user_id, created_at) 
VALUES('2번 타이틀 더미 데이터',1,NOW());
INSERT INTO category(category_title, user_id, created_at) 
VALUES('3번 타이틀 더미 데이터',1,NOW());


```
.
</br>
</br>
## 6. 결과
