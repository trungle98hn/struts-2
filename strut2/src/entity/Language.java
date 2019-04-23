package entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;

@Entity
@Table(name="language")
public class Language {
	@Id
	@GeneratedValue
	private Long id;
	private String tenngonngu;
	@OneToMany(mappedBy="ngonngu", fetch= FetchType.LAZY)
	private Collection<sach> sachs;
	
	public Language() {
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

	public String getTenngonngu() {
		return tenngonngu;
	}
	@RequiredFieldValidator(message="khong duoc de trong")
	public void setTenngonngu(String tenngonngu) {
		this.tenngonngu = tenngonngu;
	}
}
