package com.infobell.one_stop.service;

import com.infobell.one_stop.model.Category;

import java.util.List;

public interface CategoryService {

	/**
	 * Retrieves all categories.
	 *
	 * @return A list of categories.
	 */
	List<Category> getAllCategories();

	/**
	 * Retrieves a category by its ID.
	 *
	 * @param id The ID of the category to retrieve.
	 * @return The retrieved category, or null if not found.
	 */
	Category getCategoryById(int id);

	/**
	 * Creates a new category.
	 *
	 * @param category The category to create.
	 * @return The created category.
	 */
	Category createCategory(Category category);

	/**
	 * Updates an existing category.
	 *
	 * @param id       The ID of the category to update.
	 * @param category The updated category.
	 * @return The updated category, or null if not found.
	 */
	Category updateCategory(int id, Category category);

	/**
	 * Deletes a category by its ID.
	 *
	 * @param id The ID of the category to delete.
	 * @return true if the category was successfully deleted, false otherwise.
	 */
	boolean deleteCategory(int id);
}
