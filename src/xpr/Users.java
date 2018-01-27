package xpr;

public class Users {

	private Twitter twitter;
	private Console console;

	public Users(Twitter twitter, Console console) {
		this.twitter = twitter;
		this.console = console;
	}

	public User get(String name) {
		return new User(name, console);
	}

}
