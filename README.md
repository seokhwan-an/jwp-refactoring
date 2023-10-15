# 키친포스

## 요구 사항
### Product
- [x] 상품을 생성할 수 있다.
- [x] 상품을 생성할 수 없다.
  - [x] 상품의 가격이 음수이면 상품을 생성할 수 없다.
- [x] 상품 전체를 조회할 수 있다.

### MenuGroup
- [x] 메뉴 그룹을 생성할 수 있다.
  - [x] 모든 메뉴 그룹을 조회할 수 있다.

### Menu
- [x] 메뉴를 생성할 수 있다.
- [x] 메뉴를 생성할 수 없다.
  - [x] 메뉴 가격이 음수이면 메뉴를 생성할 수 없다.
  - [x] 메뉴 그룹에 포함되어 있지 않는 메뉴를 생성할 수 없다.
  - [x] 메뉴 상품들의 가격 총합보다 메뉴 가격이 크면 메뉴는 생성할 수 없다.
- [x] 전체 메뉴를 조회할 수 있다.

### Order
- [x] 주문을 생성할 수 있다.
- [x] 주문을 생성할 수 없다.
  - [x] 주문 상품이 없으면 주문을 생성할 수 없다.
  - [x] 주문 상품의 개수와 주문 내역의 개수가 다르면 주문을 생성할 수 없다.
  - [x] 주문 테이블이 존재하지 않으면 주문을 생성할 수 없다.
  - [x] 주문 테이블이 비어있으면 주문을 생성할 수 없다.
- [x] 전체 주문을 조회할 수 있다.
- [x] 주문 상태를 변경할 수 있다.
- [x] 주문 상태를 변경할 수 없다.
  - [x] 주문이 존재하지 않으면 주문 상태를 변경할 수 없다.
  - [x] 주문 상태가 COMPLETION이면 주문 상태를 변경할 수 없다.

### Table
- [x] 주문 테이블을 생성할 수 있다.
- [x] 전체 주문 테이블을 조회할 수 있다.
- [x] 주문 테이블의 상태를 변경할 수 있다.
- [x] 주문 테이블의 상태를 변경할 수 없다.
  - [x] 주문 테이블이 존재하지 않으면 주문 테이블의 상태를 변경할 수 없다.
  - [x] 주문 테이블에 테이블 그룹이 존재하면 주문 테이블의 상태를 변경할 수 없다.
  - [x] 주문 테이블의 상태가 COOKIE이거나 MEAL인 경우 주문 테이블의 상태를 변경할 수 없다.
- [x] 주문 테이블의 손님 수를 변경할 수 있다.
- [x] 주문 테이블의 손님 수를 변경할 수 없다.
  - [x] 변경할 주문 테이블의 손님 수가 음수이면 손님 수를 변경할 수 없다.
  - [x] 주문 테이블이 존재하지 않는 경우 손님 수를 변경할 수 없다.
  - [x] 주문 테이블이 비어있으면 손님 수를 변경할 수 없다.

### TableGroup
- [x] 주문 테이블 그룹을 생성할 수 있다.
- [x] 주문 테이블 그룹을 생성할 수 없다.
  - [x] 주문 테이블 그룹의 테이블 개수가 1개 혹은 0개이면 주문 테이블 그룹을 생성할 수 없다.
  - [x] 주문 테이블 그룹내의 테이블 개수와 DB에 저장된 주문 테이블의 개수가 다르면 주문 테이블 그룹을 생성할 수 없다.
  - [x] 비어있지 않는 주문 테이블이거나 이미 테이블 그룹에 포함되어있다면 주문 테이블 그룹을 생성할 수 없다.
- [x] 주문 테이블 그룹에서 주문 테이블을 분리할 수 있다.
- [x] 주문 테이블 그룹에서 주문 테이블을 분리할 수 없다.
  - [x] 주문 정보의 상태가 COOKING 혹은 MEAL이면 주문 테이블 그룹에서 주문 테이블을 분리할 수 없다.
## 용어 사전

| 한글명 | 영문명 | 설명 |
| --- | --- | --- |
| 상품 | product | 메뉴를 관리하는 기준이 되는 데이터 |
| 메뉴 그룹 | menu group | 메뉴 묶음, 분류 |
| 메뉴 | menu | 메뉴 그룹에 속하는 실제 주문 가능 단위 |
| 메뉴 상품 | menu product | 메뉴에 속하는 수량이 있는 상품 |
| 금액 | amount | 가격 * 수량 |
| 주문 테이블 | order table | 매장에서 주문이 발생하는 영역 |
| 빈 테이블 | empty table | 주문을 등록할 수 없는 주문 테이블 |
| 주문 | order | 매장에서 발생하는 주문 |
| 주문 상태 | order status | 주문은 조리 ➜ 식사 ➜ 계산 완료 순서로 진행된다. |
| 방문한 손님 수 | number of guests | 필수 사항은 아니며 주문은 0명으로 등록할 수 있다. |
| 단체 지정 | table group | 통합 계산을 위해 개별 주문 테이블을 그룹화하는 기능 |
| 주문 항목 | order line item | 주문에 속하는 수량이 있는 메뉴 |
| 매장 식사 | eat in | 포장하지 않고 매장에서 식사하는 것 |

## 리팩토링
- [ ] 오타 수정하기
- [ ] null 검증하는 테스트 추가하기
- [ ] 테스트 fixture 추가하기
