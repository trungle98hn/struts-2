package control;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.Pubhouse;
import model.pubhouseDAO;
import model.pubhouseDAOImpl;

@SuppressWarnings("serial")
public class pubhouseAction extends ActionSupport implements ModelDriven<Pubhouse> {
	private Pubhouse pubhouse = new Pubhouse();
	private List<Pubhouse> pubhouseList = new ArrayList<Pubhouse>();
	private pubhouseDAO pubhouseDAO = new pubhouseDAOImpl();

	public Pubhouse getModel() {
		return pubhouse;
	}

	public String list() {
		pubhouseList = pubhouseDAO.listPubhouse();
		return SUCCESS;
	}
	
	public String saveOrUpdate() {
		if(!pubhouse.getTennhaxb().equals("")||!pubhouse.getTennhaxb().isEmpty()){
			pubhouseDAO.saveOrUpdatePubhouse(pubhouse);
			return SUCCESS;
		}else {
			
			 addFieldError("tennhaxb", "Ten NXB is required");
			 return INPUT;
		}
		
	}

	public String delete() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		pubhouseDAO.deletePubhouse(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}

	public String edit() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		pubhouse = pubhouseDAO.listPubhouseById(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}

	public Pubhouse getPubhouse() {
		return pubhouse;
	}

	public void setPubhouse(Pubhouse pubhouse) {
		this.pubhouse = pubhouse;
	}

	public List<Pubhouse> getPubhouseList() {
		return pubhouseList;
	}

	public void setPubhouseList(List<Pubhouse> pubhouseList) {
		this.pubhouseList = pubhouseList;
	}

	public pubhouseDAO getPubhouseDAO() {
		return pubhouseDAO;
	}

	public void setPubhouseDAO(pubhouseDAO pubhouseDAO) {
		this.pubhouseDAO = pubhouseDAO;
	}
	 public void validate() {
	        if (pubhouse.getTennhaxb().length() == 0) {
	            addFieldError("tennhaxb", "Ten NXB is required");
	        } 
	       
	    }
}
