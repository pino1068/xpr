package xpr;

import java.util.ArrayList;
import java.util.List;

public class User {

	private String name;
	List<Post> posts;

	public User(String name) {
		this.name = name;
		this.posts = new ArrayList<>();
	}

	public void posting(Post post) {
		this.posts.add(post);
	}

	public boolean hasName(String name) {
		return this.name.equals(name);
	}
}
