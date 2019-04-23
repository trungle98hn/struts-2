package control;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Language;
import model.languageDAO;
import model.languageDAOImpl;

@SuppressWarnings("serial")
public class languageAction extends ActionSupport implements ModelDriven<Language> {
	private Language language = new Language();
	private List<Language> languageList = new ArrayList<Language>();
	private languageDAO languageDAO = new languageDAOImpl();

	public Language getModel() {
		return language;
	}

	public String list() {
		languageList = languageDAO.listLanguage();
		return SUCCESS;
	}

	public String saveOrUpdate() {
		if(!language.getTenngonngu().equals("")||!language.getTenngonngu().isEmpty()||StringUtils.isNotEmpty(language.getTenngonngu())){
		languageDAO.saveOrUpdateLanguage(language);
		return SUCCESS;	
	}else {
		
		 addFieldError("tenngonngu", "Ten ngon ngu is required");
		 return INPUT;
	}
		
	}

	public String delete() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		languageDAO.deleteLanguage(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}

	public String edit() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		language = languageDAO.listLanguageById(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public List<Language> getLanguageList() {
		return languageList;
	}

	public void setLanguageList(List<Language> languageList) {
		this.languageList = languageList;
	}

	public model.languageDAO getLanguageDAO() {
		return languageDAO;
	}

	public void setLanguageDAO(model.languageDAO languageDAO) {
		this.languageDAO = languageDAO;
	}
	 public void validate() {
	        if (language.getTenngonngu().isEmpty()) {
	            addFieldError("tenngonngu", "Ten ngon ngu is required");
	        } 
	       
	    }
}
