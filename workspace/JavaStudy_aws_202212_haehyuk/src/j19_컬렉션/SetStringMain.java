package j19_컬렉션;

import java.util.*;

public class SetStringMain {

    public static void main(String[] args) {
        Set<String> setStr = new HashSet<String>();
        List<String> listStr = new ArrayList<String>();

        listStr.add("신사임당");
        listStr.add("세종대왕");
        listStr.add("신사임당");
        listStr.add("신사임당");

        System.out.println(listStr);

        setStr.add("홍길동");
        setStr.add("김유신");
        setStr.add("한석봉");
        setStr.add("이순신"); // add 를 같은값을 여러번 한다해도 한번만 들어간다 set 의 특징
//        setStr.add("이순신");
        setStr.addAll(listStr);

        System.out.println(setStr);
        String searchName = "홍길동";
        for (String name : setStr) {
            if ((name.equals(searchName))){
                System.out.println(name);
            }
//            System.out.println(name);
        }

        Iterator<String> iterator = setStr.iterator();
        while (iterator.hasNext()) {
            String n = iterator.next();
            if (n.equals(searchName)){
                System.out.println(n);
            }
        }
    }
}
