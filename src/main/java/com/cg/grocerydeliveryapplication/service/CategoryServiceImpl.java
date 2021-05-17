package com.cg.grocerydeliveryapplication.service;
/**
 * desc:This is a categoryService Implemented class having all services listed here.
 * @author Suparna Arya
**/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.grocerydeliveryapplication.domain.Category;
import com.cg.grocerydeliveryapplication.exception.CategoryIDException;
import com.cg.grocerydeliveryapplication.repository.CategoryRepository;


@Service
public class CategoryServiceImpl {
	
@Autowired
private CategoryRepository categoryRepo;

/**
 * This method will save and update category details
 * @param category
 * @return
 */
public Category saveOrUpdate(Category category) {
		return categoryRepo.save(category);
   }

/**
 * This method will find category by it's categoryId
 * @param categoryId
 * @return
 */
public Category findByCategoryByCategoryID(Long categoryId) {

	Category category = categoryRepo.findByCategoryId(categoryId);
	if (category == null) {
		throw new CategoryIDException("Category ID " + categoryId + " does not exists");
	}
	return category;
}
/**
 * This method will find all the categories present in the database
 * @return
 */
public Iterable<Category> findAllCategories() {
	return categoryRepo.findAll();
}
/**
 * This method will delete category by it's categoryId.
 * @param categoryId
 */
public void deleteCategoryByCategoryId(Long categoryId) {
	Category category= findByCategoryByCategoryID(categoryId);
	categoryRepo.delete(category);

}
}
