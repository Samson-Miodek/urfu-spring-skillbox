package com.example.MyBookShopApp.service;

import com.example.MyBookShopApp.data.book.Book;
import com.example.MyBookShopApp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;


    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooksData() {
        return bookRepository.findAll();
    }

    public Page<Book> getPageOfBooksData(Integer offset, Integer limit) {
        var nextPage = PageRequest.of(offset, limit);
        return bookRepository.findAll(nextPage);
    }
    public Page<Book> getPageOfBooksDataByPubDate(Date from, Date to, Integer offset, Integer limit) {
        var nextPage = PageRequest.of(offset, limit);
        return bookRepository.findBookByPubDateBetween(from,to, nextPage);
    }

    public Page<Book> getPageOfSearchResultBooks(String searchWord, Integer offset, Integer limit) {
        var nextPage = PageRequest.of(offset, limit);
        return bookRepository.findBookByTitleContainingIgnoreCase(searchWord, nextPage);
    }
}
