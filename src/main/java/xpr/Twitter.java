package xpr;

public class Twitter{

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
	    while(true){
		    String text = console.readLine("> ");
		    if("quit".equals(text))
		    	break;
		    twitter.send(text);
	    }
	}

	public void send(String string) {
		User user = users.get(string.split(" ")[0]);
		if(string.contains(POSTING)) 
			posting(user, string.split(POSTING)[1]);
		else if(string.contains(WALL)) 
			wall(user);
		else if(string.contains(FOLLOWS)) 
			follows(user, users.get(string.split(FOLLOWS)[1]));
		else
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
