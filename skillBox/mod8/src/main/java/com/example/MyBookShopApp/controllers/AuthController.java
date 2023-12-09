package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.security.BookStoreUserRegisterService;
import com.example.MyBookShopApp.security.ContactConfirmationPayload;
import com.example.MyBookShopApp.security.ContactConfirmationResponse;
import com.example.MyBookShopApp.security.RegistrationForm;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthController {

    @Autowired
    private BookStoreUserRegisterService registrationService;
    @Autowired
    private AuthenticationManager authenticationManager;


    @GetMapping("/signin")
    public String signinPage(){
        return "signin";
    }

    @GetMapping("/signup")
    public String signupPage(Model model){
        model.addAttribute("regForm", new RegistrationForm());
        return "signup";
    }

    @PostMapping("/requestContactConfirmation")
    @ResponseBody
    public ContactConfirmationResponse handlerequestContactConfirmation(@RequestBody ContactConfirmationPayload payload){
        var response = new ContactConfirmationResponse();
        response.setResult(true);
        return response;
    }
    @PostMapping("/approveContact")
    @ResponseBody
    public ContactConfirmationResponse hadleApproveContact(@RequestBody ContactConfirmationPayload payload){
        var response = new ContactConfirmationResponse();
        response.setResult(true);
        return response;
    }

    @PostMapping("/reg")
    public String hadleUserRegistration(RegistrationForm registrationForm, Model model){
        registrationService.registerNewUser(registrationForm);
        model.addAttribute("regOk",true);
        return "signin";
    }


    @PostMapping("login")
    @ResponseBody
    public ContactConfirmationResponse handleLogin(@RequestBody ContactConfirmationPayload payload){
        var auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(payload.getContact(),payload.getCode()));
        SecurityContextHolder.getContext().setAuthentication(auth);
        var response = new ContactConfirmationResponse();
        response.setResult(true);
        return response;
    }


    @GetMapping("/my")
    public String handleMy(Model model){
        model.addAttribute("curUsr",registrationService.getCurrentUser());

        return "my";
    }
    @GetMapping("/profile")
    public String handleProfile(Model model){
        model.addAttribute("curUsr",registrationService.getCurrentUser());
        return "profile";
    }


    @GetMapping("/logout")
    public String logout(HttpServletRequest httpServletRequest){
        var session = httpServletRequest.getSession();
        SecurityContextHolder.clearContext();
        if(session!=null)
        {
            session.invalidate();
        }

        for(var cookie : httpServletRequest.getCookies())
            cookie.setMaxAge(0);


        return "redirect:/";
    }

}
