package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> getAllCategories();
    public void createCategory(Category category);

    String deleteCategory(Long id);

    String updateCategory(Category category,Long id);
}
