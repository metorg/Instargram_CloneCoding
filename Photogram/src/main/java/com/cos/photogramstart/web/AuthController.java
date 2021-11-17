package com.cos.photogramstart.web;


import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.web.dto.auth.SignupDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@RequiredArgsConstructor//final 필드를 DI 할때 사용
@Controller//1.Ioc 2.파일을 리턴하는 컨트롤러
public class AuthController {


    private final AuthService authService;

    @GetMapping("/auth/signin")
    public String signinForm() {
        return "auth/signin";
    }

    @GetMapping("/auth/signup")
    public String signupForm() {
        return "auth/signup";
    }

    //회원가입버튼->/auth/signup->/auth/signin
    @PostMapping("/auth/signup")
    public String signup(@Valid SignupDto signupDto, BindingResult bindingResult) { // key =
        // value(x-www.form-urlencoded)
        User user = signupDto.toEntity();
        authService.회원가입(user);
        return "auth/signin";
    }
}
