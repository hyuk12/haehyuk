package j20_JSON.builder;

public class User2 {
    private String username;
    private String password;
    private String name;
    private String email;

    public User2(String username, String password, String name, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }



    @Override
    public String toString() {
        return "User2{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static class UserBuilder {
        private String username;
        private String password;
        private String name;
        private String email;

        public UserBuilder() {
        }



        public UserBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public User2 build() {
            return new User2(username, password, name, email);
        }


    }
}
