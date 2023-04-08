

-- CREATE MEMBER TABLE
CREATE TABLE member
(
	 userid varchar(10) PRIMARY KEY,
	 passwd varchar(10) NOT NULL,
	 username varchar(10) NOT NULL,
	 post varchar(6) NOT NULL,
	 addr1 varchar(500) NOT NULL,
	 addr2 varchar(500) NOT NULL,
	 phone1 varchar(3) NOT NULL,
	 phone2 varchar(4) NOT NULL,
	 phone3 varchar(4) NOT NULL,
	 email1 varchar(20) NOT NULL,
	 email2 varchar(20) NOT NULL
);

-- CREATE GOODS(상품) TABLE
CREATE TABLE goods
(
	gCode varchar(20) PRIMARY KEY,
	gCategory varchar(20) NOT NULL,
 	gName varchar(50) NOT NULL,
 	gContent varchar(4000) NOT NULL,
 	gPrice int(6) NOT NULL,
 	gImage varchar(20) NOT NULL 
);

-- INSERT GOODS DATAshop
INSERT INTO goods VALUES ('T1',	'top', '앨리스 데님 탑',	'빈티지한 느낌의 데님 프릴 슬리브스 탑', '12100', 'top1');
INSERT INTO goods VALUES ('T2',	'top', '슬리브 러플 블라우스',	'여성스러운 러플과 리본끈 디테일이 사랑스러운 룩', '12100', 'top2');
INSERT INTO goods VALUES ('T3',	'top', '안야 러블리 도트 튜닉',	'귀엽고 걸리쉬한 도트 패턴의 튜닉', '12800', 'top3');
INSERT INTO goods VALUES ('T4',	'top', '니키타 펀칭 니트 탑',	'베이직한 디자인에 펀칭으로 디테일을 준 니트탑', '8800', 'top4');
INSERT INTO goods VALUES ('T5',	'top', '펀칭 스트라이프 레이어드 탑',	'펀칭과 스트라이프 패턴의 시스루 레이어드 탑', '11800', 'top5');
INSERT INTO goods VALUES ('T6',	'top', '클로에 슬리프 러플 크롭 탑',	'러블리한 디자인의 소매 프릴 포인트', '9800', 'top6');
INSERT INTO goods VALUES ('T7',	'top', '올리비아 언발란스 니트 탑',	'가볍고 내츄럴한 니트 소재의 브이넥 니트 탑', '9800', 'top7');
INSERT INTO goods VALUES ('T8',	'top', '백 리본 블록 체크 블라우스',	'귀여운 프릴 디자인의 블록 체크 블라우스', '12800', 'top8');
INSERT INTO goods VALUES ('T9',	'top', '백 레이스 리본 니들 워크 니트',	'뒷 면 리본 자수로 여성스러워요~~', '29800', 'top9');
INSERT INTO goods VALUES ('T10',	'top', '홀 포켓 보이 프렌드 셔츠',	'루즈한 핏으로 편안하게 입기 좋아요', '27800', 'top10');
INSERT INTO goods VALUES ('T11',	'top', '프린지 레이스 레이어드 블라우스',	'어느 옷이든 매치하면 페미닌룩 완성', '26800', 'top11');
INSERT INTO goods VALUES ('T12',	'top', '레이스 엣지 트렌더 블라우스',	'카라와 숄더라인에 레이스 디자인으로 포인트를 준 쉬폰 블라우스', '26800', 'top12');
INSERT INTO goods VALUES ('D1',	'dress', '인디안 무드 엔틱 니들 드레스',	'더블 태슬 끈과 풍성한 퍼프 슬리브 원피스', '37800', 'dress1');
INSERT INTO goods VALUES ('D2',	'dress', '소피아 벨트 니트 드레스',	'모던하면서 페미닌한 디자인의 니트 원피스', '36800', 'dress2');
INSERT INTO goods VALUES ('D3',	'dress', '스타키아 스타일 플레어 데님 드레스',	'플레어 라인으로 귀엽게 퍼지는 스타일의 데님 원피스', '34800', 'dress3');
INSERT INTO goods VALUES ('D4',	'dress', '엘레강스 골드 버튼 드레스',	'골드 버튼 장식이 포인트인 플레어 미디 드레스', '33800', 'dress4'); COMMIT;
INSERT INTO goods VALUES ('D5',	'dress', '블랙 리본 레이스 드레스',	'러블리한 소매 프릴이 돋보여요!!', '24800', 'dress5');
INSERT INTO goods VALUES ('D6',	'dress', '메쉬 트위스트 롱 드레스',	'스페셜한 원피스!', '24800', 'dress6');
INSERT INTO goods VALUES ('D7',	'dress', '폼폼 블라우스 체크 드레스',	'귀여운 폼폼이 장식의 블라우스와 체크 원피스', '23800', 'dress7');
INSERT INTO goods VALUES ('D8',	'dress', '페미닌 플렛 벨트 드레스',	'가오리핏으로 더욱 여성스러워 보이는 원피스', '23800', 'dress8');
INSERT INTO goods VALUES ('D9',	'dress', '러블리 레이스 리본 세트',	'여성스러운 디자인의 세트 상품', '20800', 'dress9');
INSERT INTO goods VALUES ('D10',	'dress', '벨 슬리브 스트라이프 세트',	'사랑스러운 무드의 피나포어 원피스 세트', '20400', 'dress10');
INSERT INTO goods VALUES ('D11',	'dress', '엘리자베스 버스티아 드레스 세트',	'골지 소재의 원피스에 데님 뷔스티에 세트', '19800', 'dress11');
INSERT INTO goods VALUES ('D12',	'dress', '퓨어 스트라이프 플레어 드레스',	'청순하면서 여성스러운 스타일의 스트라이프 원피스', '19800', 'dress12');
INSERT INTO goods VALUES ('O1',	'outer', '더블 버튼 블레이져',	'고급스러운 느낌의 보카이 블레이져 자켓', '52800', 'outer1');
INSERT INTO goods VALUES ('O2',	'outer', '히든 버튼 베이직 울코트',	'부드러운 소재의 베이직 스타일 울코트', '52800', 'outer2');
INSERT INTO goods VALUES ('O3',	'outer', '린넨 트렌치 자켓',	'클래식한 핏의 트렌치 자켓', '51800', 'outer3');
INSERT INTO goods VALUES ('O4',	'outer', '타미 베이직 자켓',	'모던한 스타일에 베이직한 라인의 자켓', '48800', 'outer4'); COMMIT;
INSERT INTO goods VALUES ('O5',	'outer', '파스텔 톤 오버 핏 코트',	'부드러운 소재와 파스텔톤의 투버튼 코트', '45800', 'outer5');
INSERT INTO goods VALUES ('O6',	'outer', '티디 원 버튼 롱 블레이져',	'화사한 컬러감이 돋보이는 모던하고 심플한 디자인', '41800', 'outer6');
INSERT INTO goods VALUES ('O7',	'outer', '트렌치 무드 하프 자켓',	'클래식한 트렌치 무드의 하프 자켓', '39800', 'outer7');
INSERT INTO goods VALUES ('O8',	'outer', '고져스 트렌치 코트',	'고급스러운 컬러감과 디자인의 트렌치 코트', '39800', 'outer8'); COMMIT;
INSERT INTO goods VALUES ('O9',	'outer', '에밀리 루즈 핏 자켓',	'오버 사이즈의 루즈핏 점퍼', '31800', 'outer9');
INSERT INTO goods VALUES ('O10',	'outer', '미키 마우스 소프트 베이직 코튼 가디건',	'미키자수가 새겨져 있는 루즈핏 가디건', '30800', 'outer10');
INSERT INTO goods VALUES ('O11',	'outer', '스테이크 스킨 지포 라이더 자켓',	'엣지있는 뱀피무늬의 라이더 자켓', '29800', 'outer11');
INSERT INTO goods VALUES ('O12',	'outer', '탑 건 롱 항공 점퍼',	'레터링자수와 패치가 트렌디한 롱 항공점퍼', '29800', 'outer12'); COMMIT;
INSERT INTO goods VALUES ('B1',	'bottom', '제나 레이스 스커트',	'페미닌한 레이스 자수가 멋스러운 스커트', '9800', 'bottom1');
INSERT INTO goods VALUES ('B2',	'bottom', '레이스 프린지 스커트',	'시크하면서 트렌디한 무드의 레이스 스커트', '9800', 'bottom2');
INSERT INTO goods VALUES ('B3',	'bottom', '벨라 와이드 팬츠',	'신축성 있는 소재의 와이드 핏 팬츠', '9800', 'bottom3');
INSERT INTO goods VALUES ('B4',	'bottom', '사브리나 H라인 스커트',	'심플한 디자인에 H라인 미니 스커트', '9800', 'bottom4');
INSERT INTO goods VALUES ('B5',	'bottom', '베일리 롱 스커트',	'데일리로 입기 좋은 베이직 디자인 롱 스커트', '9800', 'bottom5');
INSERT INTO goods VALUES ('B6',	'bottom', '컴포터블 미니 플레어 스커트',	'속바지 안감이 붙어있는 베이직한 스타일의 플레어 스커트', '9800', 'bottom7');
INSERT INTO goods VALUES ('B7',	'bottom', '페일 컬러 후드 트레이닝 세트',	'간편하게 입기 좋은 트레이닝 세트', '9800', 'bottom7');
INSERT INTO goods VALUES ('B8',	'bottom', '멜리사 패턴 미디 스커트',	'상큼한 패턴이 돋보이는 미디 플레어 스커트', '10800', 'bottom8');
INSERT INTO goods VALUES ('B9',	'bottom', '베키 플리츠 미니 스커트',	'귀엽고 사랑스러운 라인에 플리츠 미니 스커트', '11800', 'bottom9');
INSERT INTO goods VALUES ('B10',	'bottom', '아만다 핀턱 플레어 스커트',	'자연스러운 주름이 매력적인 플레어 스커트', '11800', 'bottom10');
INSERT INTO goods VALUES ('B11',	'bottom', '플리츠 스커트 레깅스',	'페미닌한 무드의 플리츠 주름 레깅스', '11800', 'bottom11');
INSERT INTO goods VALUES ('B12',	'bottom', '레이스 미디 스커트',	'여성스러운 레이스 미디 스커트', '11800', 'bottom12');
COMMIT;

-- CREATE CART TABLE
CREATE TABLE cart
(
	 num int(6) PRIMARY KEY,
	 userid varchar(10),
	 gCode varchar(20) NOT NULL,
	 gName varchar(50) NOT NULL,
	 gPrice int(6) NOT NULL,
	 gSize CHAR(1) NOT NULL,
	 gColor varchar(10) NOT NULL,
	 gAmount int(2) NOT NULL,
	 gImage varchar(20) NOT NULL
); 

-- ADD CONSTRAINT FK CART_USERID_FK
ALTER TABLE cart
	ADD CONSTRAINT cart_userid_fk
	FOREIGN KEY(userid) REFERENCES member(userid)
	ON DELETE CASCADE;

-- ADD CONSTRAINT FK CART_GCODE_FK
ALTER TABLE cart
	ADD CONSTRAINT cart_gCode_fk
	FOREIGN KEY(gCode) REFERENCES goods(gCode)
ON DELETE CASCADE;

-- CREATE SEQUENCE CART_SEQ
CREATE SEQUENCE cart_seq;

 
-- CREATE ORDERINFO TABLE
CREATE TABLE orderInfo
(
	 num int(6) PRIMARY KEY,
	 userid varchar(10),
	 gCode varchar(20) NOT NULL,
	 gName varchar(50) NOT NULL,
	 gPrice int(6) NOT NULL,
	 gSize CHAR(1) NOT NULL,
	 gColor varchar(10) NOT NULL,
	 gAmount int(2) NOT NULL,
	 gImage varchar(20) NOT NULL,
	 orderName varchar(10) NOT NULL,
	 post varchar(5) NOT NULL,
	 addr1 varchar(500) NOT NULL,
	 addr2 varchar(500) NOT NULL,
	 phone varchar(13) NOT NULL,
	 payMethod varchar(20) NOT NULL,
	 orderDay DATE DEFAULT CURRENT_DATE
);

-- ADD CONSTRAINT ORDERINFO_USERID_FK
ALTER TABLE orderInfo 
	ADD CONSTRAINT orderInfo_userid_fk 
	FOREIGN KEY(userid)	REFERENCES member(userid) 
ON DELETE CASCADE;

-- ADD CONSTRAINT ORDERINFO_GCODE_FK
ALTER TABLE orderInfo 
	ADD CONSTRAINT orderInfo_gCode_fkshop
	FOREIGN KEY(gCode) REFERENCES goods(gCode)
ON DELETE CASCADE;

-- CREATE SEQUENCE ORDERINFO_SEQ
CREATE sequence orderInfo_seq;