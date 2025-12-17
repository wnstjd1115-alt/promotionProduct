# Backend Migration & Query Tuning
(Spring Boot & Java 11+)

## 📌 프로젝트 개요
본 프로젝트는 **기존 레거시 백엔드 시스템을 Spring Boot 기반으로 이관**하고,  
이관 과정에서 발생하는 **쿼리 성능 이슈를 분석 및 튜닝**하는 것을 목표로 합니다.

Java 11 이상 환경에서
- 안정적인 아키텍처 구성
- JPA 기반 데이터 접근
- 성능 저하 쿼리 개선  
  을 중심으로 진행되었습니다.

---

## 🛠 기술 스택
- **Java**: 17+
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **H2 (Local 개발용)**
- **Gradle**
- **GitHub**

---



## ⚡ 쿼리 튜닝 포인트
- 불필요한 조회 제거
- JOIN 구조 개선
- 날짜 조건 기반 조회 최적화
- 필요 컬럼만 SELECT 하도록 개선
- N+1 문제 예방을 고려한 설계

### 예시: 프로모션 조회 쿼리
```sql
SELECT
    p.PROMOTION_CD,
    p.PROD_CD,
    pr.PROD_NM,
    p.PROMO_PRICE,
    p.START_DT,
    p.END_DT
FROM TB_PROMOTION p
JOIN TB_PRODUCT pr
  ON p.PROD_CD = pr.PROD_CD
WHERE pr.USE_YN = 'Y'
  AND p.START_DT <= CURRENT_TIMESTAMP
  AND p.END_DT >= CURRENT_TIMESTAMP;