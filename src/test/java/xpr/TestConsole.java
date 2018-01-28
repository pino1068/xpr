package xpr;

import java.util.ArrayList;
import java.util.List;

public class TestConsole implements Console {

	private static final String SHELL = "> ";
	private List<String> out = new ArrayList<>();
	private String time = "( 0 seconds ago)";

	@Override
	public String readLine(String line) {
		return line;
	}

	@Override
	public void println(String line) {
		String timeAgo = time+" ago";
		out.add(SHELL+line +" ("+timeAgo+")");
	}

	public List<String> lines() {
		return out;
	}

	public void addTime(String time) {
		this.time = time;
	}

}