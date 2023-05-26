package com.infobell.one_stop.service;

import com.infobell.one_stop.exception.ResourceNotFoundException;
import com.infobell.one_stop.model.Category;
import com.infobell.one_stop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Retrieves all categories.
     *
     * @return A list of categories.
     */
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    /**
     * Retrieves a category by its ID.
     *
     * @param id The ID of the category to retrieve.
     * @return The retrieved category.
     * @throws ResourceNotFoundException if the category with the specified ID is not found.
     */
    @Override
    public Category getCategoryById(int id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        return optionalCategory.orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
    }

    /**
     * Creates a new category.
     *
     * @param category The category to create.
     * @return The created category.
     */
    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    /**
     * Updates an existing category.
     *
     * @param id       The ID of the category to update.
     * @param category The updated category.
     * @return The updated category.
     * @throws ResourceNotFoundException if the category with the specified ID is not found.
     */
    @Override
    public Category updateCategory(int id, Category category) {
        Category existingCategory = getCategoryById(id);
        existingCategory.setCategoryImgPath(category.getCategoryImgPath());
        existingCategory.setCategoryName(category.getCategoryName());
        existingCategory.setFlag(category.isFlag());
        existingCategory.setParentCategoryId(category.getParentCategoryId());
        existingCategory.setProducts(category.getProducts());

        return categoryRepository.save(existingCategory);
    }

    /**
     * Deletes a category by its ID.
     *
     * @param id The ID of the category to delete.
     * @return true if the category was successfully deleted, false otherwise.
     * @throws ResourceNotFoundException if the category with the specified ID is not found.
     */
    @Override
    public boolean deleteCategory(int id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        }
        throw new ResourceNotFoundException("Category", "id", id);
    }
}
