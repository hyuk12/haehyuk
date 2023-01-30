package j01_exam_산대특;

import java.util.*;

public class MapList {
    public static void main(String[] args) {
        List<Map<String, Object>> customers = new ArrayList<Map<String, Object>>();

        Map<String, Object> customerMap = new HashMap<String, Object>();

        customerMap.put("name", "홍길동");
        customerMap.put("rating", "vip");
        customerMap.put("age", 30);
        customers.add(customerMap);

        Map<String, Object> customerMap2 = new HashMap<String, Object>();

        customerMap2.put("name", "김기영");
        customerMap2.put("rating", "gold");
        customerMap2.put("age", 35);
        customers.add(customerMap2);

        for (Map<String, Object> customer : customers) {

            for (Map.Entry<String, Object> entry : customer.entrySet()) {
                System.out.println(entry);

            }

        }
    }
}
