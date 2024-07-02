package com.ecommerce.project.service;
import java.util.ArrayList;
import java.util.Iterator;
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
        Iterator iterator=categories.iterator();
        while (iterator.hasNext()){
            Category temp = (Category) iterator.next();
            if(temp.getCategoryId()==id){
                iterator.remove();
            }
        }
    }
}
