package xpr;

import java.util.ArrayList;
import java.util.List;

public class User {

	String name;
	private Posts posts2 = new Posts();
	private List<User> follows;

	public User(String name) {
		this.name = name;
		this.follows = new ArrayList<>();
	}

	public void posting(Post post) {
		this.posts2.add(post);
	}

	public boolean hasName(String name) {
		return this.name.equals(name);
	}

	public Iterable<Post> posts() {
		return posts2;
	}

	public void follows(User user) {
		follows.add(user);
	}

	public void wallTo(Console console) {
		wallPosts(allPosts(), console);
	}

	private Iterable<Post> allPosts() {
		Posts posts = new Posts(posts());
		for (User user : follows) {
			posts.addAll(user.posts());
		}
		return posts;
	}

	private void wallPosts(Iterable<Post> posts, Console console) {
		for (Post post : posts) {
			post.wallTo(console);
		}
	}

	public void readingTo(Console console) {
		for (Post post : posts()) {
			post.readTo(console);
		}
	}
}
