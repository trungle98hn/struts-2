package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class sach {
	@Id
	@GeneratedValue
	private Long id;
	private String tieude;
	@ManyToOne
	@JoinColumn(name = "idDanhmuc")
	private Category chude;
	private String tacgia;
	private Integer namxuatban;
	private Boolean phienban;
	@ManyToOne
	@JoinColumn(name = "idNhaxuatban")
	private Pubhouse nhaxb;
	@ManyToOne
	@JoinColumn(name = "idNgonngu")
	private Language ngonngu;
	private Integer sotrang;
	private Float gia;
	private Integer sobanluu;
	private Boolean bandientu;
	private Boolean duocmuon;

	public sach() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTieude() {
		return tieude;
	}

	public void setTieude(String tieude) {
		this.tieude = tieude;
	}

	public Category getChude() {
		return chude;
	}

	public void setChude(Category chude) {
		this.chude = chude;
	}

	public String getTacgia() {
		return tacgia;
	}

	public void setTacgia(String tacgia) {
		this.tacgia = tacgia;
	}

	public Integer getNamxuatban() {
		return namxuatban;
	}

	public void setNamxuatban(Integer namxuatban) {
		this.namxuatban = namxuatban;
	}

	public Boolean getPhienban() {
		return phienban;
	}

	public void setPhienban(Boolean phienban) {
		this.phienban = phienban;
	}

	public Pubhouse getNhaxb() {
		return nhaxb;
	}

	public void setNhaxb(Pubhouse nhaxb) {
		this.nhaxb = nhaxb;
	}

	public Language getNgonngu() {
		return ngonngu;
	}

	public void setNgonngu(Language ngonngu) {
		this.ngonngu = ngonngu;
	}

	public Integer getSotrang() {
		return sotrang;
	}

	public void setSotrang(Integer sotrang) {
		this.sotrang = sotrang;
	}

	public Float getGia() {
		return gia;
	}

	public void setGia(Float gia) {
		this.gia = gia;
	}

	public Integer getSobanluu() {
		return sobanluu;
	}

	public void setSobanluu(Integer sobanluu) {
		this.sobanluu = sobanluu;
	}

	public Boolean getBandientu() {
		return bandientu;
	}

	public void setBandientu(Boolean bandientu) {
		this.bandientu = bandientu;
	}

	public Boolean getDuocmuon() {
		return duocmuon;
	}

	public void setDuocmuon(Boolean duocmuon) {
		this.duocmuon = duocmuon;
	}

}
