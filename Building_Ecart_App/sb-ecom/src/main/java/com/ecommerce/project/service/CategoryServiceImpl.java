package com.ecommerce.project.service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CategoryServiceImpl implements CategoryService {
    public CategoryServiceImpl() {

    }

    @Autowired
    private CategoryRepository categoryRepository;



    public CategoryRepository getCategoryRepository() {
        return categoryRepository;
    }

    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public static long getId() {
        return id;
    }

    public static void setId(long id) {
        CategoryServiceImpl.id = id;
    }

    private static long id = 1l;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();

    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(id++);
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Category not found"));
        categoryRepository.delete(category);
        return "Catergory "+id+"  founded and deleted...";
    }

    @Override
    public String updateCategory(Category category,Long id) {
        Optional<Category> savedCategoryOptional = categoryRepository.findById(id);
        Category savedCategory = savedCategoryOptional.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Category not found"));

         if(savedCategoryOptional.isPresent()) {
             category.setCategoryId(id);
             categoryRepository.save(category);
             return "Category updated Successfully...";
         }
         else{
             throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Category not found...");
         }
    }

}
