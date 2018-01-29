package xpr;

import java.util.ArrayList;
import java.util.List;

public class TestConsole implements Console {

	private static final String SHELL = "> ";
	private final List<String> out = new ArrayList<>();
	private final String time;

	public TestConsole(String time) {
		this.time = time;
	}

	@Override
	public String readLine(String line) {
		return line;
	}

	@Override
	public void println(long time, String line) {
		String timeAgo = this.time + " ago";
		out.add(SHELL + line + " (" + timeAgo + ")");
	}

	public List<String> lines() {
		return out;
	}

}
