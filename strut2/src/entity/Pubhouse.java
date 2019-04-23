package entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.opensymphony.xwork2.ActionSupport;

@Entity
@Table(name = "pubhouse")
public class Pubhouse extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	private String tennhaxb;
	@OneToMany(mappedBy="nhaxb", fetch=FetchType.LAZY)
	private Collection<sach> sachs;

	public Pubhouse() {
		// TODO Auto-generated constructor stub
	}

	public Collection<sach> getSachs() {
		return sachs;
	}

	public void setSachs(Collection<sach> sachs) {
		this.sachs = sachs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTennhaxb() {
		return tennhaxb;
	}

	public void setTennhaxb(String tennhaxb) {
		this.tennhaxb = tennhaxb;
	}
	public String execute()
	{		
		return "success";
	}
	public void validate() {
		if (getTennhaxb().length()==0) {
			 addFieldError("tennhaxb", "User Name is required");
		}
	}
}
