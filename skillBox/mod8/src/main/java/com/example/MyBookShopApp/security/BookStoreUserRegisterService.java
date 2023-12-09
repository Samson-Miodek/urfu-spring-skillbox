package com.example.MyBookShopApp.security;

import com.example.MyBookShopApp.service.BookStoreUserDetails;
import com.example.MyBookShopApp.service.BookstoreUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BookStoreUserRegisterService {

    private final BookstoreUserRepository bookstoreUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public BookStoreUserRegisterService(BookstoreUserRepository bookstoreUserRepository, PasswordEncoder passwordEncoder) {
        this.bookstoreUserRepository = bookstoreUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerNewUser(RegistrationForm registrationForm) {

        if(bookstoreUserRepository.findBookstoreUserByEmail(registrationForm.getEmail()) != null)
            throw new IllegalArgumentException();

        var user = new BookstoreUser();
        user.setEmail(registrationForm.getEmail());
        user.setName(registrationForm.getName());
        user.setPhone(registrationForm.getPhone());
        user.setPassword(passwordEncoder.encode(registrationForm.getPassword()));
        bookstoreUserRepository.save(user);
    }

    public BookstoreUser getCurrentUser() {
        if(SecurityContextHolder.getContext() !=null && SecurityContextHolder.getContext().getAuthentication()!=null && SecurityContextHolder.getContext().getAuthentication().getPrincipal()!=null ) {
           if(SecurityContextHolder.getContext().getAuthentication().isAuthenticated()){
           if(!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
               try{
                   var userDetails = (BookStoreUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                   return userDetails.getBookstoreUser();
               }catch (Exception e){
                   return null;
               }
           }
           }
        }
        return null;
    }
}
