package usermanagement.server.controller;

import usermanagement.dto.ResponseDto;
import usermanagement.entity.User;

public class AccountController {

    private static AccountController instance;
    private AccountController() {}

    public static AccountController getInstance() {
        if (instance == null) {
            instance = new AccountController();
        }
        return instance;
    }

    public ResponseDto<?> register (User user) {

        return new ResponseDto<String>("ok", "회원가입 성공");
    }
}
