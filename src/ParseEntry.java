
public class ParseEntry{
	/**topStack is for matching to the top of the parse stack 
	in order to tell if this entree is the one to use
	*/
	String topStack;
	/**the look ahead must be one of these in order for the entree to be used*/
	String[] lookAhead;
	/**which production to use*/
	int production;

	public ParseEntry(String topStack, String[] lookAhead, int production){
		this.topStack = topStack;
		this.lookAhead = lookAhead;
		this.production = production;
	}
}