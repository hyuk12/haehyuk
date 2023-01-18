package usermanagement.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.mindrot.jbcrypt.BCrypt;
import usermanagement.entity.User;
import usermanagement.repository.UserRepository;

import java.util.HashMap;
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

    public Map<String, String> register(String userJson) {
        // response 응답
        Map<String, String> response = new HashMap<>();

        // 일반 user 객체에 있는 일반 변수들은 반복을 돌릴 수 가 없다. 그래서 우리는 Map 으로 바꿔서 for 문을 돌린다.
        Map<String, String> userMap = gson.fromJson(userJson, Map.class);

        for (Map.Entry<String, String> userEntry : userMap.entrySet()) {

            if(userEntry.getValue().isBlank()) {
                response.put("error", userEntry.getKey() + " 은(는) 공백일 수 없습니다.");
                return response;
            }
        }

        User user = gson.fromJson(userJson, User.class);
        System.out.println("서비스에 넘어옴! User 객체로 변환");
        System.out.println(user);

        if(duplicatedUsername(user.getUsername())) {
            response.put("error", "이미 사용중인 사용자 이름입니다.");
            return response;
        }

        if(duplicatedEmail(user.getEmail())) {
            response.put("error", "이미 가입된 이메일입니다.");
            return response;
        }

        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        
        userRepository.saveUser(user);
        response.put("ok", "회원가입 성공");

        return response;
    }
    
    

    private boolean duplicatedUsername (String username) {
        return userRepository.findUserByUsername(username) != null;
    }

    private boolean duplicatedEmail (String email) {
        return userRepository.findUserByEmail(email) != null;
    }

//    private boolean isBlank(User user) {
//        
//    }
}
