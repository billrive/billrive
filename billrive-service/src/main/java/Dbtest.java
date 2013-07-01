




import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.uhsarp.billrive.domain.Bill;
import com.uhsarp.billrive.domain.BillFinances;
import com.uhsarp.billrive.domain.BillItemEntry;
import com.uhsarp.billrive.domain.Group;
import com.uhsarp.billrive.domain.User;
import com.uhsarp.billrive.domain.UserIdAndLiableCost;

public class Dbtest {

	/**
	 * @param args
	 */
	@SuppressWarnings("null")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration cfg=new Configuration();
	    cfg.configure("hibernate.cfg.xml");	        
	 
	    SessionFactory factory = cfg.buildSessionFactory();
	    Session session = factory.openSession();
		
	    
		Bill bill = new Bill();
		User user = new User();
		Group group = new Group();
		BillFinances billFinances = new BillFinances();
		BillItemEntry billItemEntry = new BillItemEntry();
		UserIdAndLiableCost userIdAndLiab = new UserIdAndLiableCost();
		
		
		Transaction  tx = session.beginTransaction();
		session.save(bill);
		session.save(user);
		session.save(group);
		session.save(billFinances);
		session.save(billItemEntry);
		session.save(userIdAndLiab);
		
		tx.commit();
		session.close();
		System.out.println("One to One with annotations is done..!!!!");
		factory.close();
	}

}
