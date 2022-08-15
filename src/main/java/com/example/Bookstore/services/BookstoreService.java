package com.example.Bookstore.services;

import com.example.Bookstore.Repository.BookStoreRepository;
import com.example.Bookstore.entities.BookStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreService {

    @Autowired
    private  BookStoreRepository bookStoreRepository;


    public BookStore saveBookStore(BookStore bookStore)
    {
        return bookStoreRepository.save(bookStore);
    }



    public BookStore findByid(Long id) {
        return bookStoreRepository.findById(id).orElseThrow(() -> new RuntimeException("Kitablık bulunamadı " + id));
    }

    public BookStore updateById(Long id, BookStore bookStore) {
        BookStore currentBookStore = this.findByid(id);
        currentBookStore.setBookStoreName(bookStore.getBookStoreName());
        currentBookStore.setCity(bookStore.getCity());
        currentBookStore.setBookstorebook(bookStore.getBookstorebook());
        return bookStoreRepository.save(currentBookStore);
    }


    public List<BookStore> getAllBookstore() {
        return bookStoreRepository.findAll();
    }
}
