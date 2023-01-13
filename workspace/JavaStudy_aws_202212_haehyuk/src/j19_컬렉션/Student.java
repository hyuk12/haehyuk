package j19_컬렉션;

import lombok.AllArgsConstructor;
import lombok.Data;

//@RequiredArgsConstructor // 필수생성자
//@NoArgsConstructor // 기본 생성자

@AllArgsConstructor // 전체 생성자
@Data
public class Student {

	private String name;
	private int year;
//	private final String address;
}
