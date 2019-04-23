package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

import entity.Category;

public class categoryDAOImpl implements categoryDAO {
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;


	@SuppressWarnings("unchecked")
	public List<Category> listCategory() {
		List<Category> courses = null;
		try {
			courses = session.createQuery("from Category").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}


	public void saveOrUpdateCategory(Category category) {
		try {
			session.saveOrUpdate(category);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}


	public Category listCategoryById(Long Id) {
		Category category= null;
		try {
			category=(Category) session.get(Category.class, Id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return category;
	}

	
	public void deleteCategory(Long Id) {
		try {
			Category category=(Category) session.get(Category.class, Id);
			session.delete(category);
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
		}		
	}
	
}
