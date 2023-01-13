package j19_컬렉션;

import java.util.*;

public class ListStringMain {

    public static void main(String[] args) {
        String[] strArray = new String[] { "java", "python", "C++"};
        String[] newArray = new String[strArray.length + 1];

        for (int i = 0; i < strArray.length; i++) {
            newArray[i] = strArray[i];
        }
        newArray[strArray.length] = "html";

        System.out.println("[strArray]");
        for (String str : strArray) {
            System.out.println(str);
        }
        System.out.println();

        System.out.println("[newStrArray]");
        for (String str : newArray) {
            System.out.println(str);
        }
        System.out.println();
        //////////////////////////////////////////////////////////////////////////

        ArrayList<String> strList = new ArrayList<String>();
        strList.add("java");
        strList.add("python");
        strList.add("python");
        strList.add("python");
        strList.add("python");
        strList.add("python");
        strList.remove("java");
        strList.add(1, "java");
        strList.remove(1);

        for (String str : strList) {
            System.out.println(str);
        }
    }
}
