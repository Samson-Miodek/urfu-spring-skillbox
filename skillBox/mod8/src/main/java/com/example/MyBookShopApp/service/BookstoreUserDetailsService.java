package com.example.MyBookShopApp.service;

import com.example.MyBookShopApp.data.book.BookRating;
import com.example.MyBookShopApp.security.BookstoreUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BookstoreUserDetailsService implements UserDetailsService {
    @Autowired
    private BookstoreUserRepository bookStoreUserRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        var bookStoreUser = bookStoreUserRepository.findBookstoreUserByEmail(s);

        if(bookStoreUser==null)
            throw new UsernameNotFoundException("throw new UsernameNotFoundException");

        return new BookStoreUserDetails(bookStoreUser);
    }
}
