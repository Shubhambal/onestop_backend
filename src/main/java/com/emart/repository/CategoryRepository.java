package com.emart.repository;

import com.emart.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Repository interface for managing Category entities.
 * @author  Shubham
 * @version 3.9.10
 * @since   24-05-2023
 */
@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    /**
     * Retrieves a list of top-level categories.
     *
     * @return The list of top-level categories.
     */
    @Modifying
    @Query("from Category c where c.parentcategory_Id = 0")
    List<Category> listCategory();

    /**
     * Retrieves a list of subcategories for a given category ID.
     *
     * @param category_Id The category ID.
     * @return The list of subcategories.
     */
    @Query("from Category c where c.parentcategory_Id = :category_Id")
    List<Category> getSubCategories(@Param("category_Id") int category_Id);

    // The update method has been commented out as it is currently not used.
    // Uncomment and modify it as needed.
    /*
    @Modifying
    @Query("update Category c set c.category_Name = :name, c.parentcategory_Id = :c_Id, c.category_Img_Path = :img, c.flag = :flag where c.category_Id = :id")
    void update(@Param("name") String name, @Param("c_Id") int c_Id, @Param("img") String img, @Param("flag") boolean flag, @Param("id") int id);
    */
}
