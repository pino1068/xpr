package xpr;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TwitterTest {

	private Twitter twitter;
	private TestConsole console;

	@Before
	public void setup() {
		console = new TestConsole("5 minutes");
		twitter = new Twitter(console);
	}

	@Test
	public void silence() throws Exception {
		send("Alice");

		assertTrue(console.lines().isEmpty());
	}

	@Test
	public void posting() throws Exception {
		send("Alice -> I love the weather today");
		send("Bob -> Damn! We lost!");
		send("Bob -> Good game though.");

		send("Alice");
		send("Bob");
		assertEquals(3, console.lines().size());
		assertEquals("> I love the weather today (5 minutes ago)", console.lines().get(0));
		assertEquals("> Good game though. (5 minutes ago)", console.lines().get(1));
		assertEquals("> Damn! We lost! (5 minutes ago)", console.lines().get(2));
	}

	@Test
	public void aliceWall() throws Exception {
		send("Alice -> I love the weather today");
		send("Alice -> it's nice");

		send("Alice wall");
		assertEquals(2, console.lines().size());
		assertEquals("> Alice - it's nice (5 minutes ago)", console.lines().get(0));
		assertEquals("> Alice - I love the weather today (5 minutes ago)", console.lines().get(1));
	}

	@Test
	public void aliceFollowsBob() throws Exception {
		send("Alice -> I love the weather today");
		send("Bob -> heila!");

		send("Alice follows Bob");
		
		send("Alice wall");
		assertEquals(2, console.lines().size());
		assertEquals("> Bob - heila! (5 minutes ago)", console.lines().get(0));
		assertEquals("> Alice - I love the weather today (5 minutes ago)", console.lines().get(1));
	}

	private void send(String text) throws Exception {
		twitter.send(text);
		Thread.sleep(2);// not too fast!
	}
}
