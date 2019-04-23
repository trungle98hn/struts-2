package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import entity.Language;

public class languageDAOImpl implements languageDAO{
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;

	
	@SuppressWarnings("unchecked")
	public List<Language> listLanguage() {
		List<Language> courses = null;
		try {
			courses = session.createQuery("from Language").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}

	
	public void saveOrUpdateLanguage(Language language) {
		try {
			session.saveOrUpdate(language);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		
	}

	public Language listLanguageById(Long Id) {
		Language language= null;
		try {
			language=(Language) session.get(Language.class, Id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return language;
	}

	public void deleteLanguage(Long Id) {
		// TODO Auto-generated method stub
		try {
			Language language=(Language) session.get(Language.class, Id);
			session.delete(language);
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
			e.printStackTrace();
		}
	}

}
