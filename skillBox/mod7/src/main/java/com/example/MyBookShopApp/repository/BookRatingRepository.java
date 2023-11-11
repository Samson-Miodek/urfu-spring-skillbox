package com.example.MyBookShopApp.repository;

import com.example.MyBookShopApp.data.book.Book;
import com.example.MyBookShopApp.data.book.BookRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRatingRepository extends JpaRepository<BookRating, Long> {
    List<BookRating> findByBook(Book book);


    @Query(value = "select sum(rating)/count(user_id) as value_rating  from book_rating where book_id = :bookid group by book_id", nativeQuery = true)
    Optional<Integer> getBookRating(@Param("bookid") Integer bookid);

    @Query(value = "select count(user_id) as countUsers from book_rating where book_id= :bookid and rating= :ratingvalue", nativeQuery = true)
    Optional<Integer> countUsersByRating(@Param("bookid") Integer bookid, @Param("ratingvalue") Integer ratingvalue);
}
