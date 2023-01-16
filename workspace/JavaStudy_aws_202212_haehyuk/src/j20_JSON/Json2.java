package j20_JSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

public class Json2 {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("a", "test1");
        map.put("b", 10.5);
        map.put("c", new int[] {10, 20, 30, 40, 50});

        System.out.println(map);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String mapJson = gson.toJson(map);

        System.out.println(mapJson);
    }
}
