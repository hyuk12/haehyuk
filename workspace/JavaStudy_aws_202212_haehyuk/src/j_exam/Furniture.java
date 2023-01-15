package j_exam;

import lombok.Data;

@Data
public abstract class Furniture {


	private int furnitureCode;// 가구 예약번호,
	private String type;// 가구종류
	private String color;// 색깔
	private String productName; // 제품 이름

}
