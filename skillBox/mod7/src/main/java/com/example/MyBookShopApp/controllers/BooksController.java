package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.book.Book;
import com.example.MyBookShopApp.data.dto.BooksPageDTO;
import com.example.MyBookShopApp.service.BookRatingService;
import com.example.MyBookShopApp.service.BookService;
import com.example.MyBookShopApp.service.BooksRatingAndPopulatityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BooksController {

    private BookService bookService;

    @Autowired
    private BookRatingService bookRatingService;

    @Autowired
    private BooksRatingAndPopulatityService booksRatingAndPopulatityService;


    @Autowired
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("recent")
    public String recentPage(Model model) throws ParseException {
        model.addAttribute("recentBookList",recentBookList());
        return "books/recent";
    }

    @GetMapping("popular")
    public String popularPage(Model model) {
        model.addAttribute("booksList",booksRatingAndPopulatityService.getPageOfPopularBooks(0, 5).getContent());
        return "books/popular";
    }



    public List<Book> recentBookList() throws ParseException {
        var simpleDateFormat = new SimpleDateFormat("dd.MM.yyy");
        var from = simpleDateFormat.parse("01.01.2000");
        var to = simpleDateFormat.parse("01.01.2016");
        return bookService.getPageOfBooksDataByPubDate(from, to, 0, 10).getContent();
    }

    @GetMapping("/{slug}")
    private String getBookBySlug(@PathVariable(required = true) String slug, Model model){
        var bookOpt = bookService.findBySlug(slug);

        if(bookOpt.isEmpty())
            return "redirect:/";

        var book = bookOpt.get();
        var bookRatingDTO = bookRatingService.getBookRating(book);

        model.addAttribute("book",book);
        model.addAttribute("IsTagsEmpty",book.getBook2Tags()==null);
        model.addAttribute("rating",bookRatingDTO);
        return "books/slug";
    }
}
