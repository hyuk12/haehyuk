package j_exam;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Furniture> furniture = new ArrayList<Furniture>();
		FurnitureRepository repository = new FurnitureRepository(furniture);
		ReservationService service = new ReservationService(repository);



		service.reservation();

	}
}
