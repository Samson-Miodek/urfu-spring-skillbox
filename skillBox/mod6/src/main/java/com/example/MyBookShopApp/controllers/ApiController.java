package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.dto.BooksPageDTO;
import com.example.MyBookShopApp.data.dto.SearchWordDTO;
import com.example.MyBookShopApp.service.BookService;
import com.example.MyBookShopApp.service.BooksRatingAndPopulatityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private BookService bookService;
    @Autowired
    private BooksRatingAndPopulatityService booksRatingAndPopulatityService;

    @GetMapping("/books/popular")
    @ResponseBody
    public BooksPageDTO popular(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit) {
        return new BooksPageDTO(booksRatingAndPopulatityService.getPageOfPopularBooks(offset, limit).getContent());
    }

    @GetMapping("/books/recommended")
    @ResponseBody
    public BooksPageDTO recommended(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit) {
        return new BooksPageDTO(bookService.getPageOfBooksData(offset, limit).getContent());
    }

    @GetMapping("/books/recent")
    @ResponseBody
    public BooksPageDTO getNextRecentPage(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit, @RequestParam("from") String fromPattern, @RequestParam("to") String toPattern) throws ParseException {
        var simpleDateFormat = new SimpleDateFormat("dd.MM.yyy");
        var from = simpleDateFormat.parse(fromPattern);
        var to = simpleDateFormat.parse(toPattern);
        return new BooksPageDTO(bookService.getPageOfBooksDataByPubDate(from, to, offset, limit).getContent());
    }

    @GetMapping("/search/{searchWord}")
    @ResponseBody
    public BooksPageDTO getNextSearchPage(@PathVariable(required = true, value = "searchWord") SearchWordDTO searchWordDTO, @RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit){
        return new BooksPageDTO(bookService.getPageOfSearchResultBooks(searchWordDTO.getExample(),offset,limit).getContent());
    }
}
