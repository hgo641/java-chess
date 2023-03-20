# 체스게임(ChessGame)
- [x] 아직 시작하지 않은 상태에서 move, end하면 예외 발생
- [x] 이미 시작한 상태에서 start 하면 예외발생

## 보드(Board)
- [x] 체스 기물이 놓여진 위치를 저장한다
- [x] 체스 기물을 이동시킨다

## 위치(Position)
- [x] File은 체스 기물의 가로 위치를 왼쪽부터 a ~ h로 나타낸다.
- [x] Rank는 체스 기물의 세로 위치를 아래부터 위로 1 ~ 8로 구현한다.
- [x] 특정 위치와 같은 직선상에 있는지 검사한다.
- [x] 특정 위치와 같은 대각선상에 있는지 검사한다.

## 기물(Piece)
- [x] 기물은 흑/백의 색을 가진다.
- [x] 기물의 진영은 검은색과 흰색편으로 구분한다.
- [x] 기물의 이름 표기는 진영에 따라 대문자(검은색), 소문자(흰색)로 구분한다.
- [x] 기물은 상대 팀의 기물을 잡을 수 있다.

## 이동규칙(MoveRule)
- [x] 체스 기물의 움직임이 올바른지 검사한다.
  - [x] King: 모든 방향으로 한 칸씩 움직일 수 있다.
  - [x] Rook: 전후좌우로 원하는 만큼 직선으로 움직일 수 있다.
  - [x] Bishop: 대각선으로 원하는 만큼 움직일 수 있다.
  - [x] Queen: 모든 방향으로 원하는 만큼 직선으로 움직일 수 있다.
  - [x] Knight: 한 방향으로 두 칸 이동하고 90도를 이루게 한칸 이동한다.
      - [x] 기물을 뛰어넘을 수 있다.
  - [x] Pawn:
      - [x] 처음에는 두칸 이동할 수 있다.
      - [x] 일반적으로는 앞으로 한 칸 이동할 수 있다.
      - [x] 상대 기물을 잡을 때에는 대각선으로 한 칸 이동 가능하다.
      - [x] 뒤로 움직일 수 없다.
- [x] 체스 기물을 이동시킨다.

## 입력
- [x] 게임을 시작하는 명령어 start를 입력받는다.
- [x] 게임을 종료하는 명령어 end를 입력받는다.
- [x] move source위치 target위치 로 체스말을 이동시키는 명령어를 입력받는다.

## 출력
- [x] 게임 명령어 안내 메시지를 출력한다.
- [x] 보드의 현재 상태를 출력한다.


