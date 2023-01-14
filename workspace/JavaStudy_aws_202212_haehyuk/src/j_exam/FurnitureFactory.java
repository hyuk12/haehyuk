package j_exam;

public class FurnitureFactory implements MakeFurniture{
	
	private Furniture f;
    private static final int CODE = 20230000;
    private static int ai = 1;

    private int furnitureCode;
    private String productName;

    public FurnitureFactory(Furniture f) {
        furnitureCode = CODE + ai;
        ai++;
        this.f = f;
    }

    @Override
    public int make() {

        System.out.println(f.getClass().getSimpleName());
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
