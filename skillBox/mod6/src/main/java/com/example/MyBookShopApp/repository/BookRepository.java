package com.example.MyBookShopApp.repository;

import com.example.MyBookShopApp.data.book.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;


public interface BookRepository extends JpaRepository<Book,Integer> {
    Page<Book> findBookByTitleContainingIgnoreCase(String bookTitle, Pageable nextPage);
    Page<Book> findAllByPubDateBetweenOrderByPubDateDesc(Date from, Date to, Pageable nextPage);
//    Page<Book> findAllBy(Pageable nextPage);
}
