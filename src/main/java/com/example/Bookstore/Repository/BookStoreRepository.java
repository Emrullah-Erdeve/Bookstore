package com.example.Bookstore.Repository;

import com.example.Bookstore.entities.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookStoreRepository extends JpaRepository<BookStore,Long> {

}