package com.example.MyBookShopApp.data.book;

import com.example.MyBookShopApp.data.author.Author;
import com.example.MyBookShopApp.data.book.links.Book2AuthorEntity;
import com.example.MyBookShopApp.data.book.links.Book2UserEntity;
import com.example.MyBookShopApp.data.book.links.Book2UserTypeEntity;
import com.fasterxml.jackson.annotation.*;
import liquibase.pro.packaged.A;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "DATE NOT NULL", name = "pub_date")
    private Date pubDate;

    @Column(columnDefinition = "SMALLINT NOT NULL", name = "is_bestseller")
    private short isBestseller;
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String slug;
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String title;
    @Column(columnDefinition = "VARCHAR(255)")
    private String image;

    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(columnDefinition = "INT NOT NULL")
    private Integer price;
    @JsonProperty("discountPrice")
    @Column(columnDefinition = "SMALLINT NOT NULL DEFAULT 0")
    private short discount;

    @JsonIgnore
    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private Set<Book2UserEntity> book2UserEntitySet;

    @JsonManagedReference
    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
    private Set<Book2AuthorEntity> book2AuthorEntities;


    public Book() {
    }

    @JsonGetter("authors")
    public List<String> getAuthors() {
        var authors = new ArrayList<String>();
        for (var b2a : this.book2AuthorEntities) {
            authors.add(b2a.getAuthor().getName());
        }
        return authors;
    }

    public Set<Book2AuthorEntity> getBook2AuthorEntities() {
        return book2AuthorEntities;
    }

    public void setBook2AuthorEntities(Set<Book2AuthorEntity> book2AuthorEntities) {
        this.book2AuthorEntities = book2AuthorEntities;
    }

    public Set<Book2UserEntity> getBook2UserEntitySet() {
        return book2UserEntitySet;
    }

    public void setBook2UserEntitySet(Set<Book2UserEntity> book2UserEntitySet) {
        this.book2UserEntitySet = book2UserEntitySet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public short getIsBestseller() {
        return isBestseller;
    }

    public void setIsBestseller(short isBestseller) {
        this.isBestseller = isBestseller;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public short getDiscount() {
        return discount;
    }

    public void setDiscount(short discount) {
        this.discount = discount;
    }


}

