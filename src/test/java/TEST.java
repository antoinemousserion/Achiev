import java.util.ArrayList;

import fr.achiev.aut.CheckUser;
import fr.achiev.bean.Event;
import fr.achiev.bean.UserAchiev;
import fr.achiev.dal.GenericDao;
import fr.achiev.dal.GenericDaoImpl;

public class TEST {

	public static void main(String[] args) {
		
		UserAchiev u = new UserAchiev();
		u.setBattleTag("test#1212");
		u.setEvent(new ArrayList<Event>());
		u.setPassword("blabla");
		u.setUsername("UsernameTest");
		
		

	}

}
