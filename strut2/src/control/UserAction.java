package control;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

import entity.Users;
import model.UserDAO;

public class UserAction extends ActionSupport implements ModelDriven<Users>,  SessionAware {
	private static final long serialVersionUID = -3369875299120377549L;
	private UserDAO userDAO;
	 Map<String, Object> session;		
	 @EmailValidator(type = ValidatorType.SIMPLE,
	    message = "Please enter a valid email address 4",
	    fieldName = "username")
		public String login(){
			System.out.println("inside execute: "+user.getUsername());
			String u=user.getUsername();
			String p=user.getPassword();
			boolean check=userDAO.checklogin(u, p);
		
			if(check){
				//session.put("USER", user.getUsername());
				session.put("USER", user.getUsername());
				return SUCCESS;
			}else {
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
