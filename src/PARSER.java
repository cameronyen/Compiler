import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;


public class PARSER {
	static Stack<String> parseStack = new Stack();
	static String[] lookAhead;
	static ArrayList<ParseEntry> parseTable;
	static SCANNER scan;

	public PARSER() {
		
	}
	
	/**returns result of the production number (right hand side),
	 * results ordered in array in order they need to be pushed in
	 */
	private static String[] getProduction(int production) {
		if(production == 1){
			return new String[] {"<more-blocks>","<block>"};
		}
		else if(production == 2){
			return new String[] {};
		}
		else if(production == 3){
			return new String[] {"<more-blocks>","<block>"};
		}
		else if(production == 4){
			return new String[] {"<class>"};
		}
		else if(production == 5){
			return new String[] {"<method>"};
		}
		else if(production == 6){
			return new String[] {"ssalc","<methods>",")","<id-list>","(","<modifier>","[id]","class"};
		}
		else if(production == 7){
			return new String[] {"forall"};
		}
		else if(production == 8){
			return new String[] {"formyselfonly"};
		}
		else if(production == 9){
			return new String[] {"<more-ids>","[id]"};
		}
		else if(production == 10){
			return new String[] {};
		}
		else if(production == 11){
			return new String[] {"<more-ids>","[id]"};
		}
		else if(production == 12){
			return new String[] {"<more-methods>","<method>"};
		}
		else if(production == 13){
			return new String[] {};
		}
		else if(production == 14){
			return new String[] {"<more-methods>","<method>"};
		}
		else if(production == 15){
			return new String[] {"dohtem","<stmts>","[id]","method"};
		}
		else if(production == 16){
			return new String[] {"<more-stmts>",";","<stmt>"};
		}
		else if(production == 17){
			return new String[] {};
		}
		else if(production == 18){
			return new String[] {"<more-stmts>",";","<stmt>"};
		}
		else if(production == 19){
			return new String[] {"<decl>"};
		}
		else if(production == 20){
			return new String[] {"<input>"};
		}
		else if(production == 21){
			return new String[] {"<output>"};
		}
		else if(production == 22){
			return new String[] {"<cond>"};
		}
		else if(production == 23){
			return new String[] {"<loop>"};
		}
		else if(production == 24){
			return new String[] {"<asmt>"};
		}
		else if(production == 25){
			return new String[] {"<exit>"};
		}
		else if(production == 26){
			return new String[] {"<id-list>","<type>"};
		}
		else if(production == 27){
			return new String[] {"number"};
		}
		else if(production == 28){
			return new String[] {"boolean"};
		}
		else if(production == 29){
			return new String[] {"<id-list>","see"};
		}
		else if(production == 30){
			return new String[] {"<id-list>","show"};
		}
		else if(production == 31){
			return new String[] {"<bool-expr>","onlyif","<stmts>","otherwise","<stmts>","<bool-expr>","if"};
		}
		else if(production == 32){
			return new String[] {"pool","<stmts>","loop"};
		}
		else if(production == 33){
			return new String[] {"<id-list>","into","<expr","copy"};
		}
		else if(production == 34){
			return new String[] {"<bool-expr>","ifnot","exit"};
		}
		else if(production == 35){
			return new String[] {"<bool-expr>"};
		}
		else if(production == 36){
			return new String[] {"<arith-expr>"};
		}
		else if(production == 37){
			return new String[] {"<bool-expr>","nono"};
		}
		else if(production == 38){
			return new String[] {"<bool-tail>","notfalse"};
		}
		else if(production == 39){
			return new String[] {"<bool-tail>","nottrue"};
		}
		else if(production == 40){
			return new String[] {"<arith-expr>","<arith-expr>","<test>"};
		}
		else if(production == 41){
			return new String[] {};
		}
		else if(production == 42){
			return new String[] {"<bool-expr>","and"};
		}
		else if(production == 43){
			return new String[] {"<bool-expr>","or"};
		}
		else if(production == 44){
			return new String[] {"less"};
		}
		else if(production == 45){
			return new String[] {"notequal"};
		}
		else if(production == 46){
			return new String[] {"<arith-expr>","<arith-expr>","<add>"};
		}
		else if(production == 47){
			return new String[] {"<arith-expr>","<arith-expr>","*"};
		}
		else if(production == 48){
			return new String[] {")","[id]","("};
		}
		else if(production == 49){
			return new String[] {"[id]"};
		}
		else if(production == 50){
			return new String[] {"[const]"};
		}
		return null;
	}
	
	/**Parses through source code and determines if it is acceptable or not
	 */
	public static void parse() throws FileNotFoundException, IOException{
		initializeParseTable();
		parseStack.push("Z0");
		int stepNumber = 1;
		scan = new SCANNER();
		BufferedReader br = new BufferedReader(new FileReader("source.txt"));
		//lookAhead = scan.scanning(br);
		System.out.println("Step: " + stepNumber + " Stack top: " + parseStack.peek() + 
				" Lookahead: " + "-" + " Action: PUSH " + "<SS> into stack");
		stepNumber++;
		//parseStack.push(lookAhead[0]);
		parseStack.push("<SS>");

		lookAhead = scan.scanning(br);
		

		while(true) {
			//variable to determine if nonterminal is at top of stack
			boolean inStack = false;
			//if parseStack only has bottom of stack symbol, then source code is accepted
			if(parseStack.peek().equals("Z0"))
			{
				System.out.println("Source code is accepted by PARSER()");
				return;
			}
			//Look through the parse table for a stack top matching top of parseStack
			outerloop:
			for( int i = 0; i < parseTable.size(); i ++)
			{
				//if parsetable has stack top symbol (nonterminal), go in this
				if(parseStack.peek().equals(parseTable.get(i).topStack)){
					inStack = true;
					//Look through the possible lookaheads of the specific production for lookAhead
					for(int j = 0; j < parseTable.get(i).lookAhead.length; j++)
					{
						//ID case
						if(parseTable.get(i).lookAhead[j].equals("[id]") && lookAhead[1].equals("ID"))
						{
							int production = parseTable.get(i).production;

							System.out.println("Step: " + stepNumber + " Stack top: " + parseStack.peek() + 
									" Lookahead: " + lookAhead[0] + " Action: Use rule " + production);
							stepNumber++;
							
							String[] toStack = getProduction(production);
							//parse through toStack to push productions into parseStack
							for(int k = 0; k < toStack.length; k++)
							{
								parseStack.push(toStack[k]);
							}
							break outerloop;
						}
						//constant case
						else if(parseTable.get(i).lookAhead[j].equals("[constant]") && lookAhead[1].equals("Constant"))
						{
							int production = parseTable.get(i).production;
							
							System.out.println("Step: " + stepNumber + " Stack top: " + parseStack.peek() + 
									" Lookahead: " + lookAhead[0] + " Action: Use rule " + production);
							stepNumber++;
							
							String[] toStack = getProduction(production);
							//parse through toStack to push productions into parseStack
							for(int k = 0; k < toStack.length; k++)
							{
								parseStack.push(toStack[k]);
							}
							break outerloop;
						}
						//Keyword AND SS case
						else if(parseTable.get(i).lookAhead[j].equals(lookAhead[0]))
						{
							int production = parseTable.get(i).production;
							
							System.out.println("Step: " + stepNumber + " Stack top: " + parseStack.peek() + 
									" Lookahead: " + lookAhead[0] + " Action: Use rule " + production);
							stepNumber++;
							
							String[] toStack = getProduction(production);
							//parse through toStack to push productions into parseStack
							for(int k = 0; k < toStack.length; k++)
							{
								parseStack.push(toStack[k]);
							}
							break outerloop;
						}
						
					}
				}
			}
			//terminal at top of stack case
			if(inStack == false)
			{
				//Non-constant/ID terminal case
				if(parseStack.peek().equals(lookAhead[0]))
				{
					System.out.println("Step: " + stepNumber + " Stack top: " + parseStack.peek() + 
							" Lookahead: " + lookAhead[0] + " Action: POP and CONSUME ");
					stepNumber++;
					parseStack.pop();
					lookAhead = scan.scanning(br);
				}
				//ID case
				else if(lookAhead[1].equals("ID") && parseStack.peek().equals("[id]"))
				{
					System.out.println("Step: " + stepNumber + " Stack top: " + parseStack.peek() + 
							" Lookahead: " + lookAhead[1] + " Action: POP and CONSUME ");
					stepNumber++;
					parseStack.pop();
					lookAhead = scan.scanning(br);
				}
				//constant case
				else if(lookAhead[1].equals("Constant") && parseStack.peek().equals("[constant]"))
				{
					System.out.println("Step: " + stepNumber + " Stack top: " + parseStack.peek() + 
							" Lookahead: " + lookAhead[1] + " Action: POP and CONSUME ");
					stepNumber++;
					parseStack.pop();
					lookAhead = scan.scanning(br);
				}
				else
				{
					System.out.println("Error on step " + stepNumber + ". Top of parse stack is not a valid token.");
				}
			}
		}
		
		
		
		
		
		
//		while (br.ready()) {
//
//			switch ((String)parseStack.peek())
//			{
//				case "Z0":
//					parseStack.push(lookAhead);
//					lookAhead = scan.scanning(br);
//				case "<SS>":
//					//if(lookAhead == "class" || lookAhead == )
//					
//			}
//
//		}


	}
	
	
	public static void initializeParseTable(){
		parseTable = new ArrayList<ParseEntry>();

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
