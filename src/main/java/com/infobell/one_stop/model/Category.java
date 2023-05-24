package com.infobell.one_stop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represents a category in the system.
 */
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    
    private String categoryImgPath;
    private String categoryName;
    private boolean flag;
    private int parentCategoryId;

    /**
     * Gets the category ID.
     *
     * @return The category ID.
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * Sets the category ID.
     *
     * @param categoryId The category ID to set.
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * Gets the image path of the category.
     *
     * @return The category image path.
     */
    public String getCategoryImgPath() {
        return categoryImgPath;
    }

    /**
     * Sets the image path of the category.
     *
     * @param categoryImgPath The category image path to set.
     */
    public void setCategoryImgPath(String categoryImgPath) {
        this.categoryImgPath = categoryImgPath;
    }

    /**
     * Gets the name of the category.
     *
     * @return The category name.
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Sets the name of the category.
     *
     * @param categoryName The category name to set.
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * Checks if the category is flagged.
     *
     * @return True if the category is flagged, false otherwise.
     */
    public boolean isFlag() {
        return flag;
    }

    /**
     * Sets the flag status of the category.
     *
     * @param flag The flag status to set.
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    /**
     * Gets the parent category ID.
     *
     * @return The parent category ID.
     */
    public int getParentCategoryId() {
        return parentCategoryId;
    }

    /**
     * Sets the parent category ID.
     *
     * @param parentCategoryId The parent category ID to set.
     */
    public void setParentCategoryId(int parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }
}
