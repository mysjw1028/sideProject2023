# READ ME

### 메모
member -> 사용자 테이블

## 4. 테이블 생성
```sql
  USE sideProject2023;

create table member(
	member_number int primary KEY auto_increment, -- 회원 고유번호
	member_id varchar(15) unique, -- 회원 아이디
	member_password varchar(20), -- 비밀번호
	member_tel VARCHAR(15), --전화번호
	member_jumin VARCHAR(20), -- 주민 앞자리 ex) 991010
	mamber_gender char(2),-- M(남자) --W(여자)
	member_nick_name VARCHAR(20), -- 사용자 닉네임 + 사용자 아이디
	member_post_code VARCHAR(10), -- 우편번호
	member_adress1 VARCHAR(50), --주소
	member_adress2 VARCHAR(50), --상세주소
	membet_state CHAR(2), -- Y(회원) N(탈퇴회원)
	create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, --등록일
	update_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, -- 수정일
	delete_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP -- 삭제일
);
create table question(
	question_id int primary KEY auto_increment,
	member_number INT, -- pk null 가능
	photo_member_number INT, -- pk null 가능
	question_state VARCHAR(20),-- Y(등록), N(삭제) E(답변완료)
	create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	update_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	delete_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

create table photo_member(
	photo_member_id int primary KEY AUTO_INCREMENT COMMENT '사업자 아이디',
	photo_member_password varchar(20) COMMENT '사업자 비밀번호',
	photo_member_tel VARCHAR(15) COMMENT '사업자 전화번호',
	photo_member_jumin VARCHAR(20) COMMENT '사업자 번호',
	photo_member_post_code VARCHAR(10) COMMENT '사업자 우편번호',
	photo_member_adress1 VARCHAR(50) COMMENT '사업자 주소',
	photo_member_adress2 VARCHAR(50) COMMENT '사업자 상세주소',
	photo_membet_state CHAR(2) COMMENT '사업자 상태', -- Y(회원) N(탈퇴회원) E(신규회원)
	create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '등록일',
	update_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
	delete_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '삭제일'
) COMMENT='사업자테이블';


COMMIT;


```
.
</br>
</br>
## 5. 더미데이터
</br>

```sql
INSERT INTO member( member_password, member_tel, member_jumin, mamber_gender, member_nick_name,
member_post_code, member_adress1, member_adress2, membet_state, CREATE_Date)
VALUE('1234', '010457845780', '0012451245785', 'W', 'test', '45850', '부산광역시 해운대구', '상세주소','N',NOW());

```
.
</br>
</br>
## 6. 결과
