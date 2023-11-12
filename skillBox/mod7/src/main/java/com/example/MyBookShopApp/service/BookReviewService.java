package com.example.MyBookShopApp.service;

import com.example.MyBookShopApp.data.book.Book;
import com.example.MyBookShopApp.data.book.review.BookReviewEntity;
import com.example.MyBookShopApp.repository.BookReviewEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookReviewService {

    private final BookReviewEntityRepository bookReviewEntityRepository;

    @Autowired
    public BookReviewService(BookReviewEntityRepository bookReviewEntityRepository) {
        this.bookReviewEntityRepository = bookReviewEntityRepository;
    }


    public List<BookReviewEntity> getReviewByBook(Book book) {
        return bookReviewEntityRepository.findAllByBook(book);
    }

}


