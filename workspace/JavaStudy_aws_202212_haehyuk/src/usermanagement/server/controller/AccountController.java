package usermanagement.server.controller;

import usermanagement.dto.ResponseDto;
import usermanagement.service.UserService;

import java.util.Map;

public class AccountController {

    private static AccountController instance;
    private UserService userService;

    private AccountController() {
        userService = UserService.getInstance();
    }

    public static AccountController getInstance() {
        if (instance == null) {
            instance = new AccountController();
        }
        return instance;
    }


    public ResponseDto<?> register (String userJson) {

        Map<String, String> resultMap = userService.register(userJson);

        if(resultMap.containsKey("error")) {
            return new ResponseDto<String>("error", resultMap.get("error"));
        }

        return new ResponseDto<String>("ok", resultMap.get("ok"));
    }
}
