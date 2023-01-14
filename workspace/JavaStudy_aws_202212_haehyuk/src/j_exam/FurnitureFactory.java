package j_exam;

public class FurnitureFactory implements MakeFurniture{
	private static FurnitureFactory instance = null;


    private FurnitureFactory() {}

    public static FurnitureFactory getInstance() {
        if (instance == null) {
            instance = new FurnitureFactory();
        }
        return instance;
    }

    @Override
    public void make(Furniture f) {
        System.out.println(f.getType() + " 제품 " + f.getProductName() + " 를 생산합니다 예약번호는 " + f.getFurnitureCode() + " 입니다.");
    }

    @Override
	public void pave(Furniture f) {

        System.out.println("예약번호 " + f.getFurnitureCode() + " 인 제품 " + f.getProductName() + " 을 포장합니다.");
	}

	@Override
	public void deliver(Furniture f) {

        System.out.println("예약번호 " + f.getFurnitureCode() + " 인 제품 " + f.getProductName() + " 을 배달합니다.");
	}


	

}
