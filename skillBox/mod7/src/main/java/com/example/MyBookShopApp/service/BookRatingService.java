package com.example.MyBookShopApp.service;

import com.example.MyBookShopApp.data.book.Book;
import com.example.MyBookShopApp.data.dto.BookRatingDTO;
import com.example.MyBookShopApp.repository.BookRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookRatingService {

    private BookRatingRepository bookRatingRepository;


    @Autowired
    public BookRatingService(BookRatingRepository bookRatingRepository) {
        this.bookRatingRepository = bookRatingRepository;
    }

    public BookRatingDTO getBookRating(Book book) {
        var bookRating = bookRatingRepository.getBookRating(book.getId());
        var sum = 0;
        var bookRatingDTO = new BookRatingDTO();

        System.out.println(book.getId());
        System.out.println(book.getId());
        System.out.println(book.getId());

        bookRatingDTO.setRating(bookRating.orElse(0));
        for (int i = 1; i <= 5; i++) {
            var bookRatingForX = bookRatingRepository.countUsersByRating(book.getId(), i);
            bookRatingDTO.getUsersCountByRating().put(i, bookRatingForX.orElse(0));
            sum += bookRatingForX.orElse(0);
        }
        bookRatingDTO.setCountSum(sum);

        System.out.println(bookRatingDTO);

        return bookRatingDTO;
    }

}
