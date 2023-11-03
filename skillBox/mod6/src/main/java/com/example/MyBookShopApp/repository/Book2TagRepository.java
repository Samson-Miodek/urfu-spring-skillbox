package com.example.MyBookShopApp.repository;

import com.example.MyBookShopApp.data.book.links.Book2Tag;
import com.example.MyBookShopApp.data.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Book2TagRepository extends JpaRepository<Book2Tag,Long> {
    Long countByTag(Tag tag);

}
