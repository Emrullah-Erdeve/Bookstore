package com.example.Bookstore.services;


import com.example.Bookstore.Repository.BookRepository;
import com.example.Bookstore.Repository.CategoryRepository;
import com.example.Bookstore.entities.Book;
import com.example.Bookstore.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {


    private final BookRepository bookRepository ;

    private final CategoryRepository category_repositor;


    public CategoryService(CategoryRepository category_repositor, BookRepository bookRepository, BookRepository bookRepository1) {
        this.category_repositor = category_repositor;
        this.bookRepository = bookRepository1;
    }

public Optional <Category> findById(Integer id)
{
    return category_repositor.findById(id);
}
public Category saveCategory(Category category)
{
    return category_repositor.save(category);
}



    public List<Book> bookListByCategory(Integer id) {

        return bookRepository.findByCategory_Cid(id);


    }

    public List<Category> getAllCategory() {return category_repositor.findAll();
    }

    public void deleteCategory(Integer id) {

        category_repositor.deleteByCid(id);
    }
}
