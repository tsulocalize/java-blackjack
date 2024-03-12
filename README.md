# 기능 명세

## 플레이어
- [x] 이름을 가진다.
- [x] 카드를 여러 장 가진다.
- [x] 카드를 받을 수 있다.
    - [x] 버스트가 아닌 경우에만 카드를 받을 수 있다.
- [x] 버스트(점수가 22점 이상)인지 여부를 알 수 있다.
- [x] 딜러와 점수 차이를 비교할 수 있다.

## 딜러
- [x] `딜러`라는 이름을 가진다.
- [x] 카드를 여러 장 가진다.
- [x] 카드를 받을 수 있다.
    - [x] 점수가 16점 이하인 경우 카드를 받아야 한다.
    - [x] 점수가 17점 이상인 경우 카드를 받을 수 없다.
- [x] 버스트(점수가 22점 이상)인지 여부를 알 수 있다.
- [x] 플레이어와 점수 차이를 비교할 수 있다.

## 플레이어의 이름
- [x] 1~5자만 허용한다.
- [x] 한글, 영어, 숫자만 허용한다.

## 플레이어 or 딜러가 보유한 카드들
- [x] 카드의 점수 합을 계산할 수 있다.
    - [x] A가 있는 경우 버스트가 안 되는 선에서 최댓값을 반환한다.
- [x] 보유 카드들을 반환할 수 있다.

## 카드
- [x] 랭크(K, Q, J, 10, …, 2, A)를 가진다.
- [x] 심볼(CLUB, DIAMOND, HEART, SPADE)을 가진다.
- [x] 점수를 반환할 수 있다.
    - [x] `K`, `Q`, `J`는 각각 10점이다.
    - [x] 숫자 카드는 숫자와 같은 점수를 가진다.
    - [x] `A`는 1점 혹은 11점이다.

## 덱의 카드들
- [x] 카드 52장을 가진다.
    - [x] 13개의 랭크와 4개의 심볼로 조합된다.
    - [x] 카드는 한 장씩만 존재한다.
- [x] 카드를 랜덤하게 섞을 수 있다.
- [x] 카드를 1장 뺄 수 있다.
    - [x] 덱에 카드가 없으면 예외를 발생시킨다.

## 배팅
- [x] 플레이어는 배팅을 할 수 있다.
  - [x] 배팅 액수는 양수이다.
- [x] 게임 종료 후 결과에 따라 상금이 지급된다.
  - [x] 승리 시, 해당 액수만큼 얻는다.
  - [x] 패배 시, 해당 액수만큼 잃는다.
  - [x] 무승부 시, 돈을 얻지도 잃지도 않는다.
  - [x] 블랙잭으로 승리 시, 해당 액수의 1.5배만큼 얻는다.

---
## 게임의 진행
- [x] 플레이어 이름을 입력받는다.
- [x] 각 플레이어의 배팅 금액을 입력받는다.
- [x] 전체 참가자에게 카드를 2장씩 나눠 준다.
- [x] 전체 참가자의 보유 카드를 출력한다.
    - [x] 딜러의 카드는 1장만 출력된다.
- [x] 각 플레이어에게 카드를 더 받을지 여부를 `y` or `n`으로 입력받는다.
    - [x] `y`면 플레이어는 카드를 1장 받고, `n`이면 다음 플레이어로 넘긴다.
- [x] 모든 플레이어의 차례가 끝나면 딜러의 차례이다.
    - [x] 딜러의 점수가 16점 이하면 딜러는 카드를 1장 받는다.
    - [x] 딜러의 점수가 17점 이상이면 딜러는 카드를 받지 않는다.
- [x] 전체 참가자의 점수의 합을 출력한다.
- [x] 전체 참가자의 최종 수익을 출력한다.
