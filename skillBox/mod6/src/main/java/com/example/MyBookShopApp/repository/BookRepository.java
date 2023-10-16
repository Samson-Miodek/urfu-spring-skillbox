package com.example.MyBookShopApp.repository;

import com.example.MyBookShopApp.data.book.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book,Integer> {
    Page<Book> findBookByTitleContainingIgnoreCase(String bookTitle, Pageable nextPage);
}
