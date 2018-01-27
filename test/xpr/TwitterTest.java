package xpr;


import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TwitterTest {
	
	private Twitter twitter;
	private TestConsole console;

	@Before
	public void setup() {
		console = new TestConsole();
		twitter = new Twitter(console);
	}
	
	@Test
	public void silence() throws Exception {
		assertTrue(console.lines().isEmpty());
		twitter.send("Alice");
		assertTrue(console.lines().isEmpty());
	}
	
	@Test
	public void alicePosts() throws Exception {
		console.addTime("5 minutes");
		twitter.send("Alice -> I love the weather today");
		twitter.send("Alice");
		assertEquals("> I love the weather today (5 minutes ago)",console.lines().get(0));
	}
}
