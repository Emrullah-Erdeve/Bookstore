package com.example.Bookstore.services;
import com.example.Bookstore.entities.Book;
import com.example.Bookstore.Repository.BookRepository;
import com.example.Bookstore.entities.BookStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    @Autowired
    private BookRepository bookRepository ;




    public Book addBook(Book book){

       return bookRepository.save(book);
    }

    public  Book findByid(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("kitabınız bulunamadı" + id));
    }
    public List<Book> getAllBook()
    {

        return bookRepository.findAll();
    }

    public Book updateById(Long id, Book book) {
        Book yeniBook = this.findByid(id);
        yeniBook.setBookName(book.getBookName());
        yeniBook.setAuthor(book.getAuthor());
        yeniBook.setDescription(book.getDescription());
        yeniBook.setPrice(book.getPrice());
        yeniBook.setImage(book.getImage());
        yeniBook.setCategory(book.getCategory());
        yeniBook.setBookstores(book.getBookstores());
        return bookRepository.save(yeniBook);
    }


    public void deleteBook(Long id) {

        Book yeniBook =this.findByid(id);
       bookRepository.delete(yeniBook);

    }

}

