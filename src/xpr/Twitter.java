package xpr;
//import java.io.Console;

public class Twitter{

	private static final String POSTING = " -> ";
	private Console console;
	private Users users;

	public Twitter(Console console) {
		this.console = console;
		users = new Users(this, console);
	}

	public static void main(String[] args) {
		Console console = new SystemConsole();
	    String username = null;
	    while(!"quit".equals(username)){
		    username = console.readLine("Please enter user name : ");   
		    console.println("You entered : " + username);
	    }
	}

	public void send(String string) {
		User user = users.get(string.split(" ")[0]);
		
		if(string.contains(POSTING))
			user.posting(string.split(POSTING)[1]);
	}
}
