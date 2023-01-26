package usermanagement.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class User {
	private int userId;
	private String username;
	private String password;
	private String name;
	private String email;

	List<RoleDtl> roleDtls;
}
