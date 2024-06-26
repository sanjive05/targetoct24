package com.ecommerce.project.service;
import java.util.ArrayList;
import java.util.List;
import com.ecommerce.project.model.Category;
import org.springframework.stereotype.Service;

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
    public void deleteCategory(Long id) {
        for(Category category:categories){
            if(category.getCategoryId()==id){
                System.out.println("checked...");
               categories.remove(category);
            }
        }
    }
}
