package xpr;

public class Twitter {

	private static final String POSTING = " -> ";
	private static final String WALL = " wall";
	private static final String FOLLOWS = " follows ";
	private Console console;
	private Users users;

	public Twitter(Console console) {
		this.console = console;
		users = new Users();
	}

	public static void main(String[] args) {
		Console console = new SystemConsole();
		Twitter twitter = new Twitter(console);
		while (true) {
			String text = console.readLine("> ");
			if ("quit".equals(text))
				break;
			if (("help").equals(text)){
				console.println(0, "\nposting: <user name> -> <message>\n" + 
						"reading: <user name>\n" + 
						"following: <user name> follows <another user>\n" + 
						"wall: <user name> wall\n" + 
						"help: this message\n" + 
						"quit: to exit\n" + 
						"");
			}else
			twitter.send(text);
		}
	}

	public void send(String string) {
		User user = users.get(string.split(" ")[0]);
		if (string.contains(POSTING))
			posting(user, string.split(POSTING)[1]);
		else if (string.contains(WALL))
			wall(user);
		else if (string.contains(FOLLOWS)) {
			User followed = users.get(string.split(FOLLOWS)[1]);
			follows(user, followed);
		} else
			reading(user);
	}

	private void posting(User user, String text) {
		user.posting(new Post(user, text));
	}

	private void reading(User user) {
		user.readingTo(console);
	}

	private void wall(User user) {
		user.wallTo(console);
	}

	private void follows(User follower, User user) {
		follower.follows(user);
	}
}
