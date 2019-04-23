package control;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Category;
import entity.Language;
import entity.Pubhouse;
import entity.sach;
import model.SachDAOImpl;
import model.UserDAO;
import model.categoryDAO;
import model.categoryDAOImpl;
import model.languageDAO;
import model.languageDAOImpl;
import model.pubhouseDAO;
import model.pubhouseDAOImpl;
import model.sachDAO;

@SuppressWarnings("serial")
public class sachAction extends ActionSupport implements ModelDriven<sach> {
	private sach sach = new sach();
	private UserDAO userDAO;
	private List<sach> sachList = new ArrayList<sach>();
	private sachDAO sachDAO = new SachDAOImpl();
	
	private List<Language> languageList= new ArrayList<Language>();
	private languageDAO languageDAO= new languageDAOImpl();
	
	private List<Category> categoryList= new ArrayList<Category>();
	private categoryDAO categoryDao= new categoryDAOImpl();
	
	private List<Pubhouse> pubhouseList= new ArrayList<Pubhouse>();
	private pubhouseDAO pubDAO= new pubhouseDAOImpl();

	public sach getModel() {
		return sach;
	}

	public String list() {
		sachList = sachDAO.listSach();
		languageList= languageDAO.listLanguage();
		categoryList= categoryDao.listCategory();
		pubhouseList= pubDAO.listPubhouse();
		return SUCCESS;
	}

	public String saveOrUpdate() {
		sachDAO.saveOrUpdateSach(sach);
		return SUCCESS;
	}

	public String delete() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		sachDAO.deleteSach(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}

	public String edit() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		sach = sachDAO.listSachById(Long.parseLong(request.getParameter("id")));
		languageList= languageDAO.listLanguage();
		categoryList= categoryDao.listCategory();
		pubhouseList= pubDAO.listPubhouse();
		return SUCCESS;
	}
	public String login() {
//		if (userDAO.checklogin(username, password)) {
//			return SUCCESS;
//		}
		return ERROR;
	}
	public sach getSach() {
		return sach;
	}

	public void setSach(sach sach) {
		this.sach = sach;
	}

	public List<sach> getSachList() {
		return sachList;
	}

	public void setSachList(List<sach> sachList) {
		this.sachList = sachList;
	}

	public sachDAO getSachDAO() {
		return sachDAO;
	}

	public void setSachDAO(sachDAO sachDAO) {
		this.sachDAO = sachDAO;
	}

	public List<Language> getLanguageList() {
		return languageList;
	}

	public void setLanguageList(List<Language> languageList) {
		this.languageList = languageList;
	}

	public languageDAO getLanguageDAO() {
		return languageDAO;
	}

	public void setLanguageDAO(languageDAO languageDAO) {
		this.languageDAO = languageDAO;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public categoryDAO getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(categoryDAO categoryDao) {
		this.categoryDao = categoryDao;
	}

	public List<Pubhouse> getPubhouseList() {
		return pubhouseList;
	}

	public void setPubhouseList(List<Pubhouse> pubhouseList) {
		this.pubhouseList = pubhouseList;
	}

	public pubhouseDAO getPubDAO() {
		return pubDAO;
	}

	public void setPubDAO(pubhouseDAO pubDAO) {
		this.pubDAO = pubDAO;
	}
}
