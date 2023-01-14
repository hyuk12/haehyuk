package j_exam;

public class Main {

	public static void main(String[] args) {
		Furniture f1 = new Bed();
		Furniture f2 = new Bed();



		FurnitureFactory.getInstance().make(f1);
		FurnitureFactory.getInstance().make(f2);
		FurnitureFactory.getInstance().pave(f1);
		FurnitureFactory.getInstance().deliver(f1);

	}
}
