package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

import entity.sach;

public class SachDAOImpl implements sachDAO {
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;


	@SuppressWarnings("unchecked")
	public List<sach> listSach() {
		List<sach> courses = null;
		try {
			courses = session.createQuery("From sach").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}


	public void saveOrUpdateSach(sach sach) {
		try {
			session.saveOrUpdate(sach);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	
	public sach listSachById(Long Id) {
		sach sach= null;
		try {
			sach=(sach) session.get(sach.class, Id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return sach;
	}


	public void deleteSach(Long Id) {
		try {
			sach sach=(sach) session.get(sach.class, Id);
			session.delete(sach);
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
		}		
	}
}
