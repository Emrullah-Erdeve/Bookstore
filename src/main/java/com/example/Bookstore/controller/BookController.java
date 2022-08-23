package com.example.Bookstore.controller;

import com.example.Bookstore.dto.BookDto;

import com.example.Bookstore.services.BooksService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins= {"http://localhost:4200/"}, maxAge = 4800, allowCredentials = "false" )
@RestController
@RequestMapping("/book")
public class BookController {


    private final BooksService booksService;
    private final ModelMapper modelMapper;

    public BookController(BooksService books_service, ModelMapper modelMapper) {
        this.booksService = books_service;
        this.modelMapper = modelMapper;
    }

// BOŞLUKLAR CAMEL CASE
    @PostMapping("/add")
    public BookDto saveBook(@RequestBody BookDto bookdto) {

        return booksService.addBook(bookdto);

    }
//kebapca-se
    @GetMapping("/get-book/{id}")
    public BookDto getBook(@PathVariable Long id) {

        return booksService.findByid(id);
    }
//kebap-case
    @GetMapping("/getall")
    public List<BookDto> getallbook() {
        return booksService.getAllBook();
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {

        booksService.deleteBook(id);
        return "successfully";

    }


}
