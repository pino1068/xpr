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
	
	@Test
	public void bobPosts() throws Exception {
		console.addTime("5 minutes");
		
		twitter.send("Bob -> Damn! We lost!");
		twitter.send("Bob -> Good game though.");
		
		twitter.send("Bob");
		assertEquals(2, console.lines().size());
		assertEquals("> Damn! We lost! (5 minutes ago)",console.lines().get(0));
		assertEquals("> Good game though. (5 minutes ago)",console.lines().get(1));
	}
	
	@Test
	public void aliceAndBobPost() throws Exception {
		console.addTime("5 minutes");
		
		twitter.send("Alice -> I love the weather today");
		twitter.send("Bob -> Damn! We lost!");
		twitter.send("Bob -> Good game though.");
		
		twitter.send("Alice");
		twitter.send("Bob");
		assertEquals(3, console.lines().size());
		assertEquals("> I love the weather today (5 minutes ago)",console.lines().get(0));
		assertEquals("> Damn! We lost! (5 minutes ago)",console.lines().get(1));
		assertEquals("> Good game though. (5 minutes ago)",console.lines().get(2));
	}
}
