package entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	@Id
	@GeneratedValue
	private Long id;
	private String tenchude;
	@OneToMany(fetch= FetchType.LAZY, mappedBy="chude")
	private Collection<sach> sachs;
	
	public Category() {
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
	public String getTenchude() {
		return tenchude;
	}
	public void setTenchude(String tenchude) {
		this.tenchude = tenchude;
	}
}
