package com.example.Bookstore.controller;

import com.example.Bookstore.entities.Book;

import com.example.Bookstore.services.BooksService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;
import java.util.concurrent.RecursiveTask;

@RestController
@RequestMapping("/book")
public class BookController {


    private final BooksService books_service;

    public BookController(BooksService books_service) {
        this.books_service = books_service;
    }


    @PostMapping("/add")
    public Book saveBook(@RequestBody Book book) {
       return books_service.addBook(book);

    }

    @GetMapping("/categoryget")
    public Book getCategory(@RequestBody Book book){

        return books_service.findByid(book.getId());
    }

    @GetMapping("/getall")
    public List<Book> getallbook (){
    return books_service.getAllBook();
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id)
    {

        books_service.deleteBook(id);
        return "successfully";

    }



}
