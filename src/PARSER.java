import java.util.ArrayList;


public class PARSER {
	
	public PARSER(){
		
	}
	
	public static void initializeParseTable(){
		ArrayList<ParseEntry> parseTable = new ArrayList<ParseEntry>();
		//parseTable.add( new parseEntry("<SS>",new String[] {"class","method"} , 1));
		parseTable.add(new ParseEntry("<SS>",new String[] {"class","method"} , 1));
		parseTable.add(new ParseEntry("<move-blocks>",new String[] {"$"} , 2));
		parseTable.add(new ParseEntry("<move-blocks>",new String[] {"class","method"} , 3));

		parseTable.add(new ParseEntry("<block>",new String[] {"class"} , 4));
		parseTable.add(new ParseEntry("<block>",new String[] {"method"} , 5));

		parseTable.add(new ParseEntry("<class>",new String[] {"class"} , 6));
		parseTable.add(new ParseEntry("<modifier>",new String[] {"forall"} , 7));
		parseTable.add(new ParseEntry("<modifier>",new String[] {"formyselfonly"} , 8));
		parseTable.add(new ParseEntry("<id-list>",new String[] {"[id]"} , 9));
		parseTable.add(new ParseEntry("<more-ids>",new String[] {")",";"} , 10));
		parseTable.add(new ParseEntry("<more-ids>",new String[] {"[id]"} , 11));

		parseTable.add(new ParseEntry("<methods>",new String[] {"method"} , 12));
		parseTable.add(new ParseEntry("<move-method>",new String[] {"ssalc"} , 13));
		parseTable.add(new ParseEntry("<move-method>",new String[] {"method"} , 14));

		parseTable.add(new ParseEntry("<method>",new String[] {"method"} , 15));
		parseTable.add(new ParseEntry("<stmts>",new String[] {"number", "boolean","see","show","if","loop","copy","exit"} , 16));
		parseTable.add(new ParseEntry("<more-stmts>",new String[] {"dohtem","otherwise", "onlyif","pool"} , 17));
		parseTable.add(new ParseEntry("<more-stmts>",new String[] {"number", "boolean","see","show","if","loop","copy","exit"} , 18));

		parseTable.add(new ParseEntry("<stmt>",new String[] {"number","boolean"} , 19));
		parseTable.add(new ParseEntry("<stmt>",new String[] {"see"} , 20));
		parseTable.add(new ParseEntry("<stmt>",new String[] {"show"} , 21));
		parseTable.add(new ParseEntry("<stmt>",new String[] {"if"} , 22));
		parseTable.add(new ParseEntry("<stmt>",new String[] {"loop"} , 23));
		parseTable.add(new ParseEntry("<stmt>",new String[] {"copy"} , 24));
		parseTable.add(new ParseEntry("<stmt>",new String[] {"exit"} , 25));

		parseTable.add(new ParseEntry("<SS>",new String[] {"class","method"} , 1));
		parseTable.add(new ParseEntry("<SS>",new String[] {"class","method"} , 1));
		parseTable.add(new ParseEntry("<SS>",new String[] {"class","method"} , 1));
		parseTable.add(new ParseEntry("<SS>",new String[] {"class","method"} , 1));
		parseTable.add(new ParseEntry("<SS>",new String[] {"class","method"} , 1));
		parseTable.add(new ParseEntry("<SS>",new String[] {"class","method"} , 1));
		parseTable.add(new ParseEntry("<SS>",new String[] {"class","method"} , 1));
		parseTable.add(new ParseEntry("<SS>",new String[] {"class","method"} , 1));
		parseTable.add(new ParseEntry("<SS>",new String[] {"class","method"} , 1));
		parseTable.add(new ParseEntry("<SS>",new String[] {"class","method"} , 1));
		parseTable.add(new ParseEntry("<SS>",new String[] {"class","method"} , 1));
		parseTable.add(new ParseEntry("<SS>",new String[] {"class","method"} , 1));
		parseTable.add(new ParseEntry("<SS>",new String[] {"class","method"} , 1));
		parseTable.add(new ParseEntry("<SS>",new String[] {"class","method"} , 1));
		parseTable.add(new ParseEntry("<SS>",new String[] {"class","method"} , 1));
		parseTable.add(new ParseEntry("<SS>",new String[] {"class","method"} , 1));
		parseTable.add(new ParseEntry("<SS>",new String[] {"class","method"} , 1));

	}

}
