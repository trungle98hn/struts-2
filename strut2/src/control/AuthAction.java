package control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

import entity.Users;
import model.UserDAO;
import model.UserDAOImpl;

public class AuthAction extends ActionSupport implements SessionAware, ModelDriven<Users> {
	private static final long serialVersionUID = -3369875299120377549L;
	UserDAOImpl userDAO = new UserDAOImpl();
	
	Map<String, Object> session;
	HttpSession http;

	@SuppressWarnings("null")
	@EmailValidator(type = ValidatorType.SIMPLE, message = "Please enter a valid email address 4", fieldName = "username")
	public String login() {

		System.out.println("inside execute: " + user.getUsername());
		String u = user.getUsername();
		String p = user.getPassword();
		boolean check = userDAO.checklogin(u, p);

		if (check) {
			// session.put("USER", user.getUsername());
			
			System.out.println(user.getUsername());
			return SUCCESS;
		} else {
			addFieldError("username", "User Name or password invalid");
			return INPUT;
		}

	}

	private Users user = new Users();
//		private Map<String, Object> sessionAttributes = null;

	@Override
	public void setSession(Map<String, Object> sessionAttributes) {
		this.session = sessionAttributes;
	}

	@Override
	public Users getModel() {
		return user;
	}

	public void validate() {
		if (user.getUsername().length() == 0) {
			addFieldError("username", "User Name is required");
		}
		if (user.getPassword().length() == 0) {
			addFieldError("password", getText("password is required"));
		}

	}

}
