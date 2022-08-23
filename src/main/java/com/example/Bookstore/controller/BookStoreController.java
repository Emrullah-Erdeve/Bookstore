package com.example.Bookstore.controller;


import com.example.Bookstore.dto.BookDto;
import com.example.Bookstore.dto.BookStoreDto;
import com.example.Bookstore.entities.Book;
import com.example.Bookstore.entities.BookStore;

import com.example.Bookstore.services.BooksService;
import com.example.Bookstore.services.BookstoreService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins= {"http://localhost:4200/"}, maxAge = 4800, allowCredentials = "false" )
@RestController
@RequestMapping("/bookstore")
public class BookStoreController {

    private final BookstoreService bookstoreService;
    private final ModelMapper modelMapper;


    public BookStoreController(BookstoreService bookstore_service, ModelMapper modelMapper, BooksService booksService) {
        this.bookstoreService = bookstore_service;
        this.modelMapper = modelMapper;
        this.booksService = booksService;
    }

    private final BooksService booksService;


    @PostMapping("/add")
    public BookStoreDto saveBookstore(@RequestBody BookStoreDto bookStoreDto) {
        bookStoreDto = modelMapper.map(bookStoreDto, BookStoreDto.class);
        return bookstoreService.saveBookStore(bookStoreDto);
    }

    @GetMapping("/getbook/{id}")
    public BookStoreDto BookStorefindBookInRepository(@PathVariable Long id) {
        return bookstoreService.findByid(id);
    }

    @PutMapping("/put/{bookStoreId}/books/{bookId}")
    public BookStoreDto bookToBookStore(@PathVariable Long bookStoreId, @PathVariable Long bookId) {
        BookStoreDto bookStore = bookstoreService.findByid(bookStoreId);
        BookDto book = booksService.findByid(bookId);
        bookStore.getBookstorebook().add(modelMapper.map(book, Book.class));
        book.getBookstores().add(modelMapper.map(bookStore, BookStore.class));
        booksService.updateById(bookId, book);
        return bookstoreService.updateById(bookStoreId, bookStore);
    }
    @PutMapping ("/delete/{bookStoreId}/books/{bookId}")
    BookStoreDto deleteBookBookStore(@PathVariable Long bookStoreId, @PathVariable Long bookId) {
     return bookstoreService.bookstoredelete(bookStoreId,bookId);

    }
    @GetMapping("/getall")
    public List<BookStoreDto> getallbook() {
        return bookstoreService.getAllBookstore();
    }


}
