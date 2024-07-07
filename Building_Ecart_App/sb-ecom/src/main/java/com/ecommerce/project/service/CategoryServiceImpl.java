package com.ecommerce.project.service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.ecommerce.project.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CategoryServiceImpl implements CategoryService {
    public CategoryServiceImpl() {

    }

    private List<Category> categories = new ArrayList<>();
    private static long id = 1l;

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(id++);
        categories.add(category);
    }

    @Override
    public String deleteCategory(Long id) {
        Category category = categories.stream()
                .filter(category1 -> category1.getCategoryId()==id)
                .findFirst()
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource not found..."));
        categories.remove(category);
        return "Catergory "+id+"  founded and deleted...";
    }

    @Override
    public String updateCategory(Category category,Long id) {
         Optional<Category> optionalCategory = categories.stream()
                .filter(category1 -> id.equals(category1.getCategoryId()))
                .findFirst();
         if(optionalCategory.isPresent()) {
             Category updateCategory = optionalCategory.get();
             updateCategory.setCategoryName(category.getCategoryName());
             return "Category Deleted Successfully...";
         }
         else{
             throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Category not found...");
         }
    }

}
