package xpr;

public class Post {

	private String text;
	private User user;
	private long time;

	public Post(User user, String text) {
		this.time = System.currentTimeMillis();
		this.user = user;
		this.text = text;
	}

	public void readTo(Console console) {
		console.println(text);
	}

	public void wallTo(Console console) {
		console.println(user.name+" - "+ text);
	}
	
	public long getTime() {
		return time;
	}

}
