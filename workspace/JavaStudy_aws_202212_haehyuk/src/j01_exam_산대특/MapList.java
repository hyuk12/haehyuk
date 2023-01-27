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

        for (Map<String, Object> customer : customers) {
            System.out.println("name=" + customer.get("name") + "\n"
                            + "rating=" + customer.get("rating") + "\n"
                            + "age=" + customer.get("age"));
            
            for (Map.Entry<String, Object> entry : customer.entrySet()) {

                if(entry.getKey().equals("name")) {
                    entry.setValue("김기영");

                }

                if(entry.getKey().equals("rating")) {
                    entry.setValue("gold");

                }

                if(entry.getKey().equals("age")) {
                    entry.setValue(35);

                }
            }
            System.out.println("name=" + customer.get("name") + "\n"
                    + "rating=" + customer.get("rating") + "\n"
                    + "age=" + customer.get("age"));
        }
    }
}
