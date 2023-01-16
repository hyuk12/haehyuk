package j20_JSON.builder;


import lombok.Builder;
import lombok.Data;

@Builder // AllArgumentsConstructor 포함
@Data
public class User {
    private String username;
    private String password;
    private String name;
    private String email;
//
//    public static UserBuilder builder() {
//        return new UserBuilder();
//    }
//
//    @Data
//    public static class UserBuilder {
//        private String username;
//        private String password;
//        private String name;
//        private String email;
//
//        public UserBuilder username(String username) {
//            this.username = username;
//            return this;
//        }
//
//        public UserBuilder password(String password) {
//            this.password = password;
//            return this;
//        }
//
//        public UserBuilder name(String name) {
//            this.name = name;
//            return this;
//        }
//
//        public UserBuilder email(String email) {
//            this.email = email;
//            return this;
//        }
//
//        public User build() {
//            return new User(username, password, name, email);
//        }
//    }

}

