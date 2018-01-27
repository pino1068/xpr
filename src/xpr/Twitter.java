package xpr;
//import java.io.Console;

public class Twitter{

	private static final String POSTING = " -> ";
	private Console console;
	private Users users;

	public Twitter(Console console) {
		this.console = console;
		users = new Users();
	}

	public static void main(String[] args) {
		Console console = new SystemConsole();
		Twitter twitter = new Twitter(console);
	    String text = null;
	    while(!"quit".equals(text)){
		    text = console.readLine("> ");
		    twitter.send(text);
	    }
	}

	public void send(String string) {
		User user = users.get(string.split(" ")[0]);
		
		if(string.contains(POSTING)) {
			Post post = new Post(string.split(POSTING)[1]);
			user.posting(post);
			return;
		}
		else{
			for (Post post : user.posts) {
				console.println("> "+post.text);
			}
		}
	}
}