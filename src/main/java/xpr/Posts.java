package xpr;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Posts implements Iterable<Post> {
	private List<Post> posts = new ArrayList<>();

	public Posts(List<User> followed) {
		for (User user : followed) {
			addAll(user.posts);
		}
	}

	public Posts() {
	}

	public void add(Post post) {
		posts.add(post);
	}

	@Override
	public Iterator<Post> iterator() {
		posts.sort(Comparator.comparing(Post::getTime).reversed());
		return posts.iterator();
	}

	public void addAll(Iterable<Post> others) {
		for (Post post : others) {
			add(post);
		}
	}

	public void wallTo(Console console) {
		for (Post post : this) {
			post.wallTo(console);
		}
	}

	public void readingTo(Console console) {
		for (Post post : this) {
			post.readTo(console);
		}
	}

}
