package j_exam;

public class FurnitureFactory implements MakeFurniture{
	
	private Furniture f;
    private static final int CODE = 20230000;
    private static int ai = 1;

    private int furnitureCode;
    private String productName;

    public FurnitureFactory(String productName) {
        furnitureCode = CODE + ai;
        ai++;
        this.productName = productName;
    }

    @Override
    public int make(Furniture furniture) {
        Furniture f ;
        f = furniture;
        System.out.println(furniture.getClass().getSimpleName());
        return furnitureCode;
    }

    @Override
	public void pave(int furnitureCode) {

		
	}

	@Override
	public void deliver() {
		// TODO Auto-generated method stub
		
	}
	

}
