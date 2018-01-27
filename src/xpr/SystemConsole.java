package xpr;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class SystemConsole implements Console {
    BufferedReader br;
    PrintStream ps;

    public SystemConsole(){
        br = new BufferedReader(new InputStreamReader(System.in));
        ps = System.out;
    }

    @Override
	public String readLine(String out){
        ps.format(out);
        try{
            return br.readLine();
        }catch(IOException e)
        {
            return null;
        }
    }
    @Override
	public void println(String line){
        ps.println(line);
    }
}