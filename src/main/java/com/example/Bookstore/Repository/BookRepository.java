package com.example.Bookstore.Repository;

import com.example.Bookstore.entities.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
List<Book> findByCategory_Cid(Integer cid);
}
