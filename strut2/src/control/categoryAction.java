package control;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Category;
import entity.Users;
import model.categoryDAO;
import model.categoryDAOImpl;

@SuppressWarnings("serial")
public class categoryAction extends ActionSupport implements ModelDriven<Category> {
	private Category category = new Category();
	private List<Category> categoryList = new ArrayList<Category>();
	private categoryDAO categoryDAO = new categoryDAOImpl();

	public Category getModel() {
		return category;
	}

	public String list() {
		categoryList = categoryDAO.listCategory();
		return SUCCESS;
	}

	public String saveOrUpdate() {
		if(!category.getTenchude().equals("")||!category.getTenchude().isEmpty()){
			System.out.println(category.getTenchude()+"inside SavaOrUpdate");
			categoryDAO.saveOrUpdateCategory(category);
			return SUCCESS;	
		}else {
			
			 addFieldError("tenchude", "Ten chu de is required");
			 return INPUT;
		}
	}

	public String delete() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		categoryDAO.deleteCategory(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}

	public String edit() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		category = categoryDAO.listCategoryById(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public categoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public void setCategoryDAO(categoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	
	 public void validate() {
	        if (category.getTenchude().length() == 0||category.getTenchude().equals("")) {
	            addFieldError("tenchude", "ten chu de is required");
	        } 
	        
	     
	    }
}
