package com.example.MyBookShopApp.repository;

import com.example.MyBookShopApp.data.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {

}
