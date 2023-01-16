package j19_컬렉션;

import java.util.HashMap;

import java.util.Map;
import java.util.Set;

public class MapStringMain {

    public static void main(String[] args) {
        Map<String, String> strMap = new HashMap<String, String>();


        strMap.put("김유신", "a");
        strMap.put("홍길동", "b");
        strMap.put("이순신", "c");
        strMap.put("한석봉", "d");



        System.out.println(strMap);

        // map 은 get 을 쓸 때 안에 키값을 넣어 value 값을 뽑아낼수 있다.
        System.out.println(strMap.get("a"));
        // key 값에 value 값이 없으므로 return 을 null 로 해준다.
        System.out.println(strMap.get("e"));

        for (String key : strMap.keySet()) {
//            System.out.println(strMap.get(key));
            System.out.println("key: " + key);
//            System.out.println();
        }

        for (String value : strMap.values()) {
            System.out.println("value: " + value);
        }

        System.out.println(strMap.entrySet());

//        Set<Map.Entry<String, String>> s = null;

        for (Map.Entry<String, String> strEntry: strMap.entrySet()) {
            System.out.println(strEntry);
            // entry 를 쓰게 되면 한쌍으로 값을 빼서 get 을 이용해서 key 와 value 값을 각각 뽑아낼수 있다.
            System.out.println("key: " + strEntry.getKey());
            System.out.println("value: " + strEntry.getValue());
        }

        System.out.println("================================================================");
        strMap.forEach((k,v) -> {
            System.out.println("key: " + k);
            System.out.println("value: " + v);
        });

    }
}
