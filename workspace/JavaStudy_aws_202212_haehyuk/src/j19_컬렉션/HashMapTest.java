package j19_컬렉션;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapTest {

    public static void main(String[] args) {
        Map<String, Object> dataMap = new HashMap<String, Object>();

        dataMap.put("username", "aaa");
        dataMap.put("password", "1234");
        dataMap.put("name", "홍길동");
        dataMap.put("email", "aaa@gmail.com");

        List<String> hobby = new ArrayList<>();
        hobby.add("골프");
        hobby.add("야구");
        hobby.add("축구");
        hobby.add("게임하기");

        dataMap.put("hobbies", hobby);


        // 작은 객체라고 생각을 한다 변수명을 key 라 생각을하고 value 를 값이라고 생각을한다. get 해서 가지고오는건 getter 를 사용해 들고 온다고 생각을한다.
        System.out.println(dataMap);
        List<String> hobbyList = (List<String>) dataMap.get("hobbies");
        System.out.println(hobbyList.get(0));
    }
}
