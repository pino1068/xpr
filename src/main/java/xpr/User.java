package xpr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
	String name;
	Posts posts = new Posts();
	private List<User> followed;

	public User(String name) {
		this.name = name;
		this.followed = new ArrayList<>();
	}

	public void posting(Post post) {
		this.posts.add(post);
	}

	public boolean hasName(String name) {
		return this.name.equals(name);
	}

	public void follows(User user) {
		followed.add(user);
	}

	public void wallTo(Console console) {
		allPosts().wallTo(console);
	}

	public void readingTo(Console console) {
		posts.readingTo(console);
	}

	private Posts allPosts() {
		return new Posts(allOfUs());
	}

	private List<User> allOfUs() {
		List<User> allUsers = new ArrayList<>(followed);
		allUsers.add(this);
		return allUsers;
	}
}
