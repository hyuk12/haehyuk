package j20_JSON.builder;

public class UserMain {

    public static void main(String[] args) {
//        User user = new User();
//        User.UserBuilder userBuilder = new User.UserBuilder();

        User user2 = User.builder()
                .username("aaa")
                .name("John")
                .password("1234")
                .build();

        System.out.println(user2);


    }
}
