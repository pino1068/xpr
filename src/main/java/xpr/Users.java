package xpr;

import java.util.ArrayList;
import java.util.List;

public class Users {

	private List<User> users = new ArrayList<>();

	public User get(String name) {
		for (User user : users ) {
			if(user.hasName(name))
				return user;
		}
		User user = new User(name);
		users.add(user);
		return user;
	}

}
