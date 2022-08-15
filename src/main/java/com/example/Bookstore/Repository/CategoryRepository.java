package com.example.Bookstore.Repository;

import com.example.Bookstore.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Category deleteByCid(Integer Cid);

}

