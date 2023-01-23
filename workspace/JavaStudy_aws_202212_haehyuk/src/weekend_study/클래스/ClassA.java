package weekend_study.클래스;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

//@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class ClassA {

    // 클래스는 뭐다?
    // 객체야 class  게임 무슨클래스 전사클래스 궁수 클래스 전사클래스 무기는 뭘사용한다 도끼를사용할수잇고 장검을사용할수잇다.
    // 궁수클래스는 따로따로 다른객체라는거야

    // 전사클래스  - 레벨이 일정부분이되면 전직을할수가있어  장검 도끼를 쓰는아이로나뉘어
    // 전사클래스는 상속을하게되지  장검클래스와 도끼클래스로 나뉘게되지 부모클래스가 전사클래스가되고 장검과 도끼가 자식클래스가되는거야
    // 모험가 - 10 도적 전사 마법사 궁수  모험가는 부모클래스인거야

    // 변수와 메소드
    // 전역 변수  멤버 변수

    final int num;
    String name;



    // 기본 생성자 (무조건 생성된다.) X NoArgsConstructor
//    ClassA(int num) {
//        // 이러한 생성자를 무슨 생성자라고 할까 필수 생성자  int num 을 필수로 가져야하는 생성자 requiredArgsConstructor
//        this.num = num;
//    }
    // 메소드 오버로딩

    // allArgsConstructor 전역변수를 매개변수로 다가지고있는 생성자

}
