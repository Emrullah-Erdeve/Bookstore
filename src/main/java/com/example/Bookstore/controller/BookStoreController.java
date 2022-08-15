package com.example.Bookstore.controller;


import com.example.Bookstore.entities.Book;
import com.example.Bookstore.entities.BookStore;

import com.example.Bookstore.services.BooksService;
import com.example.Bookstore.services.BookstoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/bookstore")
public class BookStoreController {

    private final BookstoreService  bookstore_service;


    public BookStoreController(BookstoreService bookstore_service, BooksService booksService) {
        this.bookstore_service = bookstore_service;
        this.booksService = booksService;
    }
    private final BooksService booksService;


    @PostMapping("/add")
    public BookStore saveBookstore(@RequestBody BookStore bookStore) {
        return bookstore_service.saveBookStore(bookStore);
    }

    @GetMapping("/getbook")
     public BookStore BookStorefindBookInRepository(@RequestBody BookStore bookStore)
        {

        return bookstore_service.findByid(bookStore.getId());
        }

      @PutMapping("/put/{bookStoreId}/books/{bookId}")
     public BookStore bookToBookStore(@PathVariable Long bookStoreId, @PathVariable Long bookId) {
          BookStore bookStore = bookstore_service.findByid(bookStoreId);
         Book book = booksService.findByid(bookId);
          bookStore.getBookstorebook().add(book);
          book.getBookstores().add(bookStore);
         booksService.updateById(bookId,book);
          return bookstore_service.updateById(bookStoreId, bookStore);

      }

    @GetMapping("/getall")
    public List<BookStore> getallbook (){
        return bookstore_service.getAllBookstore();
    }


}
