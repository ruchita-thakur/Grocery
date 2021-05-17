package com.cg.grocerydeliveryapplication.controller;

import static org.assertj.core.api.Assertions.assertThat;
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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.cg.grocerydeliveryapplication.domain.Category;
import com.cg.grocerydeliveryapplication.exception.CategoryIDException;
import com.cg.grocerydeliveryapplication.service.CategoryServiceImpl;
import com.cg.grocerydeliveryapplication.service.MapValidationErrorService;

@SpringBootTest
class CategoryControllerTest {

	@InjectMocks
	CategoryController categoryController;

	@Mock
	CategoryServiceImpl categoryService;

	@MockBean
	private BindingResult bindingResult;
	
	@Mock
	private MapValidationErrorService mapValidateErrorService;

	@Test
	void addCategory() {
		Category category = new Category(1L, "Fruits", "All fresh fruits are available here");
		Mockito.when(categoryService.saveOrUpdate(category)).thenReturn(category);
		Mockito.when(bindingResult.hasErrors()).thenReturn(false);
		//Mockito.when(mapValidateErrorService.mapValidationError(bindingResult)).thenReturn(null);
		ResponseEntity<?> ctg = categoryController.addCategory(category, bindingResult);
		assertThat(ctg.getStatusCodeValue()).isEqualTo(201);

	}
	@Test
	void updateCategory() throws Exception {
		Category category = new Category(1L, "Fruits", "All fresh fruits are available here");
		Mockito.when(categoryService.findByCategoryByCategoryID(1L)).thenReturn(category);
		Category ucategory = new Category(1L,null,null);
		Mockito.when(categoryController.update(1L, ucategory)).thenThrow(new CategoryIDException());
		//Mockito.when(mapValidateErrorService.mapValidationError(bindingResult)).thenReturn(null);
		
		ResponseEntity<?> ctg = categoryController.addCategory(category, bindingResult);
		assertThat(ctg.getStatusCodeValue()).isEqualTo(201);

	}
	@Test
	void addCategoryValidationError() {
		Category category = new Category(1L, "", "All fresh fruits are available here");
		Mockito.when(categoryService.saveOrUpdate(category)).thenReturn(category);
		Mockito.when(bindingResult.hasErrors()).thenReturn(false);
		//Mockito.when(mapValidateErrorService.mapValidationError(bindingResult)).thenReturn(null);
		ResponseEntity<?> ctg = categoryController.addCategory(category, bindingResult);
		assertThat(ctg.getStatusCodeValue()).isEqualTo(201);

	}
	@Test
	void getCategoryByCategoryIdTest() {

		Category category = new Category(2L, "Vegetables", "All fresh and green vegetables are available here");

		Long categoryId = category.getCategoryId();
		Mockito.when(categoryService.findByCategoryByCategoryID(categoryId)).thenReturn(category);
		ResponseEntity<?> responseEntity = categoryController.getCategoryByCId(categoryId);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}

	@Test
	void findAllCategories() throws Exception {
		List<Category> categoryList = new ArrayList<>();
		Category category = new Category(2L, "Vegetables", "All fresh and green vegetables are available here");
		categoryList.add(category);
		Mockito.when(categoryService.findAllCategories()).thenReturn(categoryList);
		assertEquals(categoryList, categoryController.getAllCategories());
	}

	@Test
	void findCategoryByCategoryIdNotFoundTest() {
		Category category = new Category(2L, "Vegetables", "All fresh and green vegetables are available here");
		Long id = 3L;
		BDDMockito.given(categoryService.findByCategoryByCategoryID(id)).willThrow(new CategoryIDException());
		assertThrows(CategoryIDException.class, () -> categoryController.getCategoryByCId(id));
	}

	@Test
	void deleteCategoryifExists()
	{
		Category category=new Category(2L,"Vegetables","All fresh and green vegetables are available here");
		Mockito.when(categoryService.findByCategoryByCategoryID(2L)).thenReturn(category);
		doNothing().when(categoryService).deleteCategoryByCategoryId(2L);;
		categoryController.deleteCategory(2L);
		assertDoesNotThrow(()->categoryController.deleteCategory(2L));
	 }
}
