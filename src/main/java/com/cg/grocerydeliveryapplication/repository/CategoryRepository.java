package com.cg.grocerydeliveryapplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.grocerydeliveryapplication.domain.Category;
/**
 * desc:This is a categoryRepository class having default implemented jdbc Crud operations 
 * and custom findByCategoryId method
 * @author Suparna Arya
**/
@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {

	Category findByCategoryId(Long cId);

	

}
