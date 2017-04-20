

public class ParseEntry{
	String topStack;
	String[] lookAhead;
	int production;

	public ParseEntry(String topStack, String[] lookAhead, int production){
		this.topStack = topStack;
		this.lookAhead = lookAhead;
		this.production = production;
	}
}