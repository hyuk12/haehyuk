package j_exam;

public class Main {

	public static void main(String[] args) {
		Bed b1 = new Bed();
		b1.productName = "침대";
		FurnitureFactory factory = new FurnitureFactory(b1.productName);
		System.out.println(factory.make(b1));

	}
}
