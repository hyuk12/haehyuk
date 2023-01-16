package j20_JSON;

import com.google.gson.GsonBuilder;

public class Json1 {

    public static void main(String[] args) {

        /*

            json 형식
            {
                "key" : "value",
                "key" : "value",
                "key" : "value"

            }

            [user]
            "{
                "username" : "aaa",
                "password" : "1234",
                "name" : "홍길동",
                "email" : "aaa@example.com",
                "age" : 20,
                "hobby" : [
                    "골프",
                    "농구",
                    "축구"
                ],
                "school" : {
                    "schoolName" : "부산무협대학",
                    "address" : "부산시"
                }
            }"

         */
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
    }
}
