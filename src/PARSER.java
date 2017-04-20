import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;


public class PARSER {
	Stack parseStack = new Stack();
	String[] lookAhead;
	
	public PARSER() throws FileNotFoundException, IOException{
		parseStack.push("Z0");
		SCANNER scan = new SCANNER();
		

		try (BufferedReader br = new BufferedReader(new FileReader("source.txt"))) {
			System.out.println("\nTokens: \n");
			while (br.ready()) {
				
				lookAhead = scan.scanning(br);
			}
		}

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
		parseTable.add(new ParseEntry("<decl>",new String[] {"number","boolean"} , 26));

		parseTable.add(new ParseEntry("<type>",new String[] {"number"} , 27));
		parseTable.add(new ParseEntry("<type>",new String[] {"boolean"} , 28));
		parseTable.add(new ParseEntry("<input>",new String[] {"see"} , 29));
		parseTable.add(new ParseEntry("<output>",new String[] {"show"} , 30));
		parseTable.add(new ParseEntry("<cond>",new String[] {"if"} , 31));
		parseTable.add(new ParseEntry("<loop>",new String[] {"loop"} , 32));
		parseTable.add(new ParseEntry("<asmt>",new String[] {"copy"} , 33));
		parseTable.add(new ParseEntry("<exit>",new String[] {"exit"} , 34));
		parseTable.add(new ParseEntry("<expr>",new String[] {"nono","notfalse","nottrue","less","notequal"} , 35));
		parseTable.add(new ParseEntry("<expr>",new String[] {"add","*","(","[id]","[const]"} , 36));

		parseTable.add(new ParseEntry("<bool-expr>",new String[] {"nono"} , 37));
		parseTable.add(new ParseEntry("<bool-expr>",new String[] {"notfalse"} , 38));
		parseTable.add(new ParseEntry("<bool-expr>",new String[] {"nottrue"} , 39));
		parseTable.add(new ParseEntry("<bool-expr>",new String[] {"less", "notequal"} , 40));

		parseTable.add(new ParseEntry("<bool-tail>",new String[] {"number", "boolean","see","show","if","loop","copy","exit",";","into"} , 41));
		parseTable.add(new ParseEntry("<bool-tail>",new String[] {"and"} , 42));
		parseTable.add(new ParseEntry("<bool-tail>",new String[] {"or"} , 43));

		parseTable.add(new ParseEntry("<test>",new String[] {"less","boolean"} , 44));
		parseTable.add(new ParseEntry("<test>",new String[] {"notequal","boolean"} , 45));

		parseTable.add(new ParseEntry("<arith-expr>",new String[] {"add"} , 46));
		parseTable.add(new ParseEntry("<arith-expr>",new String[] {"*"} , 47));
		parseTable.add(new ParseEntry("<arith-expr>",new String[] {"("} , 48));
		parseTable.add(new ParseEntry("<arith-expr>",new String[] {"[id]"} , 49));
		parseTable.add(new ParseEntry("<arith-expr>",new String[] {"[const]"} , 50));
		//test 1



	}
	
	public static void parsing(){
		
	}
}
