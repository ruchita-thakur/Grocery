package com.cg.grocerydeliveryapplication.service;
/**
 * desc:This is a categoryService interface having all services listed here.
 * @author Suparna Arya
**/
import com.cg.grocerydeliveryapplication.domain.Category;

public interface CategoryService {
	
	public Category saveOrUpdate(Category category) ;
	public Category findByCategoryByCategoryID(Long categoryId);
	public Iterable<Category> findAllCategories();
	public void deleteCategoryByCategoryId(Long categoryId);
}
