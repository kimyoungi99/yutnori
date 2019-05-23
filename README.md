yutnori
=======
자바 GUI 윷놀이 게임

# Specification

* MVC 모델을 사용하여 구현한다. (Model - View - Controller)
* Classes : Board, Piece, Player, Yut, View
* Class View와 Player가 MVC 모델에서 View와 Controller 역활을 수행
* 추가적인 기능은 모든 기본 요구사항의 구현이 끝난 뒤 구현

# Classes

* Board
    - 말들의 위치와 게임의 현제 상태를 저장한다.

* Piece
    - 윷 놀이의 말.

* Player
    - MVC 모델에서 Controller 역활을 할 Class. 사용자로 부터 입력을 받아 조종한다.

* Yut
    - 윷 놀이의 윷. Random 함수를 사용하여 윷의 던짐을 구현한다.

* View
    - Class Board에 있는 정보를 GUI를 통해 화면에 출력한다. 
