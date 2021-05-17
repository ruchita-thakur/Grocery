package com.cg.grocerydeliveryapplication.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.grocerydeliveryapplication.domain.Category;
import com.cg.grocerydeliveryapplication.exception.CategoryIDException;
import com.cg.grocerydeliveryapplication.repository.CategoryRepository;

@SpringBootTest
class CategoryServiceImplTest {

	@InjectMocks
	CategoryServiceImpl categoryService;

	@Mock
	private CategoryRepository categoryRepo;

	@Test
	void addCategoryTest(){

		Category category=new Category(1L,"Fruits","All fresh fruits are available here");
		Mockito.when(categoryRepo.save(category)).thenReturn(category);
		Category ctg=categoryService.saveOrUpdate(category);
		assertEquals(category.getCategoryName(),ctg.getCategoryName());
		
	}

	@Test
	void findCategoryByCategoryId()throws Exception{
		Category category=new Category(2L,"Vegetables","All fresh and green vegetables are available here");	 
		Long categoryId=category.getCategoryId();
		Mockito.when(categoryRepo.findByCategoryId(categoryId)).thenReturn(category);
		assertEquals(categoryId,categoryService.findByCategoryByCategoryID(categoryId).getCategoryId());
	}
	@Test
	void findAllCategories()throws Exception{
		List<Category> categoryList=new ArrayList<>();
		Category category=new Category(2L,"Vegetables","All fresh and green vegetables are available here");
		categoryList.add(category);
		Mockito.when(categoryRepo.findAll()).thenReturn(categoryList);
		assertEquals(categoryList,categoryService.findAllCategories());	
	}
	@Test
	void findCategoryByCategoryIdNotFoundTest() {
		Category category=new Category(2L,"Vegetables","All fresh and green vegetables are available here");
		Long id=3L;
		BDDMockito.given(categoryRepo.findByCategoryId(id)).willThrow(new CategoryIDException());
		assertThrows(CategoryIDException.class,()->categoryService.findByCategoryByCategoryID(id));
	 }
	
	
	@Test
	void findCategoryByCategoryIdNotFoundTest2() {
		Category category=new Category(2L,"Vegetables","All fresh and green vegetables are available here");
		Long id=3L;
		Mockito.when(categoryRepo.findByCategoryId(id)).thenReturn(null);
		assertThrows(CategoryIDException.class,()->categoryService.findByCategoryByCategoryID(id));
	 }
	
	@Test
	void deleteCategoryifExists()
	{
		Category category=new Category(2L,"Vegetables","All fresh and green vegetables are available here");
		Mockito.when(categoryRepo.findByCategoryId(2L)).thenReturn(category);
		doNothing().when(categoryRepo).delete(category);
		categoryService.deleteCategoryByCategoryId(2L);
		assertDoesNotThrow(()->categoryService.deleteCategoryByCategoryId(2L));
	 }
		
	
	}


