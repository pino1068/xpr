package xpr;

public class User {

	private Console users;

	public User(String name, Console console) {
		this.users = console;
	}

	public void posting(String post) {
		users.println(post);
	}
}
