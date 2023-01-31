package j24_람다;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Lambda2 {

    public static void main(String[] args) {

        // 1. Runnable - void run()
        Runnable r1 = () -> System.out.println("실행");
        Runnable r2 = () -> {
            System.out.println("여");
            System.out.println("러");
            System.out.println("명");
            System.out.println("령");
            System.out.println("실");
            System.out.println("행");
        };

        r1.run();
        r2.run();

        // 2. Supplier<T> - T get()
        Supplier<LocalDate> s1 = LocalDate::now;
        Supplier<String> s2 = () -> {
            LocalDate now = LocalDate.now();
            return now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
        };

        System.out.println(s1.get());
        System.out.println(s2.get());

        // 3. Consumer<T> - void accept(T, t)
        // 메소드 참조 표현식 ([인스턴스] :: [메소드명 또는 new])
        Consumer<String> c1 = name -> {

            System.out.println("이름: " + name);
            System.out.println("오늘 날짜: " + s2.get());
        };

        c1.accept("홍길동");

        List<String> names = new ArrayList<>();
        names.add("손오공");
        names.add("손오반");
        names.add("손오천");
        names.add("베지터");

        Consumer<String> c2 = name -> System.out.println("이름: " + name + "님");
        names.forEach(c2);

        names.forEach(name -> {
            System.out.println("이름을 출력합니다.");
            System.out.println("이름: " + name + "님");
            System.out.println();
        });

        names.forEach(System.out::println);

        Map<String, String> userMap = new HashMap<>();
        userMap.put("username", "aaa");
        userMap.put("password", "1234");

        userMap.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
    }
}
