package usermanagement.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import usermanagement.entity.User;
import usermanagement.repository.UserRepository;

import java.util.Map;

public class UserService {

    private Gson gson;
    private UserRepository userRepository;

    private static UserService instance;

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    private UserService() {
        userRepository = UserRepository.getInstance();
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

//    public Map<String, String> register(String userJson) {
//        User user = gson.fromJson(userJson, User.class);
//
//        if(duplicatedUsername(user.getUsername())) {
//            System.out.println("중복입니다.");
//        }
//    }

    private boolean duplicatedUsername (String username) {
        return userRepository.findUserByUsername(username) != null;
    }
}
