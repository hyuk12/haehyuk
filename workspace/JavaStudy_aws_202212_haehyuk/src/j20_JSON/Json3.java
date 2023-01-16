package j20_JSON;

import com.google.gson.Gson;

public class Json3 {

    public static void main(String[] args) {

        Gson gson = new Gson();
        gson.toJson(null); // object 를 json 으로 변환
        gson.fromJson("", Object.class); // json 을 object 로 변환
    }
}
