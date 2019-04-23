package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class UserDAOImpl implements UserDAO {

	@SessionTarget
	Session session;

	@TransactionTarget
	Transaction transaction;

	@Override
	public boolean checklogin(String username, String password) {

		String sql = "from Users where username='" + username + "' and password='" + password + "'";
		System.out.println("Insite DAO");
		try {

			if (session.createQuery(sql).list() != null) {
				System.out.println(sql);
				return true;
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return false;
	}

}
