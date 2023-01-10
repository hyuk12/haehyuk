package j13_상속.casting;

public class UpdateView extends View {

    @Override
    public void show() {
        System.out.println("[ 수정 메뉴 ]");
        System.out.println("1. [수정] 메뉴 1번");
        System.out.println("2. [수정] 메뉴 2번");
        System.out.println("exit. 영역 종료");
        System.out.println("=========================");
    }

    @Override
    public boolean menu(String select) {

        if(select.equals("exit") || select.equals("Exit")){
            System.out.println("해당 영역 종료");
            return false;
        }

        if(select.equals("1")){
            System.out.println("[수정] 메뉴에서 1번 선택");
        }else if(select.equals("2")){
            System.out.println("[수정] 메뉴에서 2번 선택");
        }else {
            System.out.println("다시 입력하세요.");
        }
        return true;
    }
}
