package j12_배열.복습;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Data
class User {
    private String username;
    private String password;
}

public class Array2 {

    public static void main(String[] args) {

        User user1 = new User("aaa", "1234");
        User user2 = new User("bbb", "1212");
        User user3 = new User("ccc", "1313");

        User[] users = new User[3];
        users[0] = new User("aaa", "1234");
        users[1] = new User("bbb", "1212");
        users[2] = new User("ccc", "1313");

        User[] users2 = new User[] {
            new User("aaa", "1234"),
            new User("bbb", "1212"),
            new User("ccc", "1313")
        };

        for (int i = 0; i < users.length; i++) {
            System.out.println(users[i].getUsername());
        }

        for (User user : users2) {
            System.out.println(user.getUsername());
        }

        List<User> userList = Arrays.asList(users);

        System.out.println(userList);

    }
}
