package j_exam;

public interface MakeFurniture {
	
	public void make(Furniture f); // 가구를 만드는 메소드 ( 가구를 만든다 만들 때 항상 제품코드가 만들어진다.)
	public void pave(Furniture f); // 가구를 포장하는 메소드 (가구를 포장을 할 때 어떤 가구를 포장하는지 중요하다)
	public void deliver(Furniture f); // 가구를 배달하는 메소드 (어떠한 가구가 포장이 되어서 어떤 가구를 배달을 하는지  어디에 배달을 이용하는 사용자 객체가 필요하다)
}
