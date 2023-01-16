package j19_컬렉션;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Data
class User {
    private String username;
    private String name;
}


public class ArrayUserMain {

    public static void main(String[] args) {

        User[] userArray = {
                new User("aaa", "홍길동"),
                new User("bbb", "이순신"),
                new User("ccc", "강감찬"),
                new User("ddd", "김유신")

        };

        // 배열을 리스트로 만들기
        List<User> userList = Arrays.asList(userArray);

        String searchUsername = "ddd";
        User user = searchUser(userList, searchUsername);

        if(user == null) {
            System.out.println("검색 실패!");
            System.out.println("존재하지 않는 계정입니다.");
        }else {
            System.out.println("검색성공!");
            System.out.println(searchUsername + "계정의 회원 이름은 " + user.getName() + "입니다.");
        }

        boolean check = true;

        for (User value : userList) {
            if (value.getUsername().equals(searchUsername)) {
                User u = new User(value.getUsername(), value.getName());
                System.out.println("검색성공! " +  searchUsername + "계정의 회원 이름은 " + u.getName() + "입니다.");
                check = false;
                break;
            }
        }
        if (check) {
            System.out.println("검색실패! 존재하지 않는 계정입니다.");
        }

    }

    private static User searchUser(List<User> userList, String username) {
        User user = null;

        for (User value : userList) {
            if (value.getUsername().equals(username)) {
                user = value;
                break;
            }
        }
        return user;
    }
}
