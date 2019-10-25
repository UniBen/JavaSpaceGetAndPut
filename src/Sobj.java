import net.jini.core.entry.*;

public class Sobj implements Entry {
	public String contents;
	public String author;

	public Sobj() {
		// No Arg constructor
	}

	public Sobj ( String s, String a ) {
		contents = s;
		author = a;
	}    
}
