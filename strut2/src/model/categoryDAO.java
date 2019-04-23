package model;

import java.util.List;

import entity.Category;

public interface categoryDAO {
	public List<Category> listCategory();

	public void saveOrUpdateCategory(Category category);

	public Category listCategoryById(Long Id);

	public void deleteCategory(Long Id);
}
