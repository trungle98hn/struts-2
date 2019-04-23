package model;

import java.util.List;
import entity.sach;

public interface sachDAO {
	public List<sach> listSach();

	public void saveOrUpdateSach(sach sach);

	public sach listSachById(Long Id);

	public void deleteSach(Long Id);
}
