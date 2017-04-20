import java.util.ArrayList;


public class PARSER {
	public class parseEntry{
		String topStack;
		String[] lookAhead;
		int production;
		
		public parseEntry(String topStack, String[] lookAhead, int production){
			this.topStack = topStack;
			this.lookAhead = lookAhead;
			this.production = production;
		}
	}
	parseEntry[] parseTable = new parseEntry[50];
	String[] lookAhead = {"class","method"};
	parseTable[0] = new  parseEntry("<SS>",lookAhead , 1);
	//parseEntry[0] = tim;

}
