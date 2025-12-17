DROP TABLE IF  EXISTS TB_PROMOTION;
DROP TABLE IF  EXISTS TB_PRODUCT;

CREATE TABLE TB_PRODUCT (
                            PROD_CD   VARCHAR(10) PRIMARY KEY,   -- 상품 코드 (P001 ~)
                            PROD_NM   VARCHAR(200) NOT NULL,      -- 상품명
                            USE_YN    CHAR(1) NOT NULL             -- 사용 여부 (Y/N)
);


CREATE TABLE TB_PROMOTION (
                              PROMOTION_CD  VARCHAR(10) PRIMARY KEY,   -- 프로모션 코드 (PR001 ~)
                              PROD_CD       VARCHAR(10) NOT NULL,      -- 상품 코드
                              PROMO_PRICE   VARCHAR(20),               -- 프로모션 가격
                              START_DT       TIMESTAMP NOT NULL,         -- 시작일
                              END_DT        TIMESTAMP NOT NULL,         -- 종료일
                              CONSTRAINT FK_PROMOTION_PRODUCT
                                  FOREIGN KEY (PROD_CD)
                                      REFERENCES TB_PRODUCT (PROD_CD)
);