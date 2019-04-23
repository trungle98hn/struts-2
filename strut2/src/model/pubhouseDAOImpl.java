package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import entity.Pubhouse;

public class pubhouseDAOImpl implements pubhouseDAO{
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;

	@SuppressWarnings("unchecked")
	public List<Pubhouse> listPubhouse() {
		List<Pubhouse> courses = null;
		try {
			courses = session.createQuery("from Pubhouse").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}

	
	public void saveOrUpdatePubhouse(Pubhouse pubhouse) {
		try {
			session.saveOrUpdate(pubhouse);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		
	}

	
	public Pubhouse listPubhouseById(Long Id) {
		Pubhouse pubhouse= null;
		try {
			pubhouse=(Pubhouse) session.get(Pubhouse.class, Id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return pubhouse;
	}

	@Override
	public void deletePubhouse(Long Id) {
		try {
			Pubhouse pubhouse=(Pubhouse) session.get(Pubhouse.class, Id);
			session.delete(pubhouse);
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
		}		
	}

}
