# READ ME

### 메모
로그인 하고 들어가면 당연히 principal 값이 있으니까 굳이 Integer userId는 적지 말것
img는 사진업로드 테스트 코드!!
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
     created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

create table category(
	 category_id INT primary KEY auto_increment,
     category_title VARCHAR(50) NOT NULL, 
	 user_id INT NOT null,
     created_at TIMESTAMP NOT NULL DEFAULT current_timestamp
);

create table post(
	 post_id INT primary KEY auto_increment,
	 post_title varchar(20) NOT null,
     post_content longtext NOT null,
     post_thumnail longtext,
     category_id INT NOT NULL, 
	 user_id INT NOT null,
	 updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE current_timestamp,
     created_at TIMESTAMP NOT NULL DEFAULT current_timestamp
);

 create table love(
	 love_id INT primary KEY auto_increment,
	 post_id INT NOT null,
	 user_id INT NOT null,
	 updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE current_timestamp,
     created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
     UNIQUE uk_loves (user_id,post_id)
);

create table img(
	 id INT primary KEY AUTO_INCREMENT,
	 title VARCHAR(100) NOT null,
	 imgName longtext NOT null,
	 content longtext NOT null,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
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
