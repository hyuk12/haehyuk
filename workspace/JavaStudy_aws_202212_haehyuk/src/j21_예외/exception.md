# 예외처리

- 자바의 예외에는 일반 예외와 실행 예외가 있다.
- 각각 Checked Exception 과 Unchecked Exception 으로 부를 수 있다.

- 실행 예외는 굳이 개발자가 예외처리를 직접하지 않아도 된다.
- 일반 예외는 개발자가 꼭 예외처리를 해줘야 한다.

runtimeException 을 상속받는 애들은 unchecked 이고 아니면 checked 이다.

finally 는 try 가 잘 진행되도 실행이 되고 catch 가 실행이되도 실행이 된다.

finally 를 쓰는 이유는 catch 에서 우리가 예상한 exception 을 잡지못하고 예외가 터져도
무조건 실행되어야 할 때 지금까지 실행한 정보를 저장하는 로직등을 넣을 수 있다.

예외를 생성할 떄 메세지를 줄 수 있다.

예외의 최상위 클래스는 Throwable 이다.