package usermanagement.repository;

import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import usermanagement.entity.User;

public class UserRepository {
	private List<User> userDataList;

	private static UserRepository instance;

	public static UserRepository getInstance() {
		if (instance == null) {
			instance = new UserRepository();
		}
		return instance;
	}

	private UserRepository() {
		userDataList = new ArrayList<>();
		userDataList.add(User.builder()
				.username("aaa")
				.password(BCrypt.hashpw("1234", BCrypt.gensalt()))
				.name("홍길동")
				.email("admin@example.com")
				.build());
	}

	public void saveUser(User user) {
		userDataList.add(user);
	}

	public User findUserByUsername(String username) {
		User user = null;

		for (User u : userDataList) {
			if(u.getUsername().equals(username)) {
				user = u;
				break;
			}
		}
		return user;
	}

	public User findUserByEmail(String email) {
		User user = null;

		for (User u : userDataList) {
			if(u.getEmail().equals(email)) {
				user = u;
				break;
			}
		}
		return user;
	}


}
