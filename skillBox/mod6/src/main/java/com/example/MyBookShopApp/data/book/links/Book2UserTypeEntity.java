package com.example.MyBookShopApp.data.book.links;


import javax.persistence.*;
import java.util.Set;


/*
*
* book2user_type — типы привязок книг к юзерам
    id INT NOT NULL AUTO_INCREMENT
    code VARCHAR(255) NOT NULL — код типа привязки (см. ниже список)
    name VARCHAR(255) NOT NULL — наименование типа привязки (см. ниже список)
            Отложена — KEPT
(name)      В корзине — CART   (code)
            Куплена — PAID
            В архиве — ARCHIVED
*
* */

@Entity
@Table(name = "book2user_type")
public class Book2UserTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String code;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Book2UserEntity> book2UserEntitySet;

    public Set<Book2UserEntity> getBook2UserEntitySet() {
        return book2UserEntitySet;
    }

    public void setBook2UserEntitySet(Set<Book2UserEntity> book2UserEntitySet) {
        this.book2UserEntitySet = book2UserEntitySet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
