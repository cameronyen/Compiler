import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SCANNER {
	String token;
	//To keep track of line number
	static int lineNumber = 1;
	
	static SymTabEntry[] symTab = new SymTabEntry[100];
	//keep track of index of symTab
	static int index = 0;
	
	public SCANNER() {

	}
	
	//ERRORHANDLER routine
	public static void errorHandler(BufferedReader br, String message, String token) throws IOException
	{
		while (true)
		{
			br.mark(0);
			char input = (char) br.read();
			if (isSpecial(input)) {
				System.out.println("Error on token: " + token + " on line "
						+ lineNumber + ". Error message: " + message);
				br.reset();
				return;
			}
			else if(input == ' ' || input == '\n')
			{
				
				System.out.println("Error on token: " + token + " on line "
						+ lineNumber + ". Error message: " + message);
				if(input == '\n')
					lineNumber++;
				return;
			}
			else 
			{
				token += input;
			}
		}
	}
	//prints out token information
	public static void print(String cToken, String type, int line)
	{
		System.out.println(cToken + ", " + type+ ", line number " + line);
	}
	
	//checks to see if input character is a special symbol
	public static boolean isSpecial(char input)
	{
		if (input == '(' || input == ')' || input == ';'
				|| input == '*')
			return true;
		else return false;
	}
	
	//end character checker
	public static boolean endCharacter(char input, String state, String type,BufferedReader br) throws IOException
	{
		if(isSpecial(input))
		{
			print(state, type, lineNumber);
			br.reset();
			return true;
		}
		else if(input == ' ' || input == '\n' || input == '\r')
		{
			
			print(state, type, lineNumber);
			if(input == '\n')
				lineNumber++;
			return true;
		}
		else return false;
	}
	
	//BOOKKEEPER function
	public static void bookKeeper(String name, String classification)
	{
		for (int i = 0; i < index; i++)
		{
			if(symTab[i].getName().equals(name))
			{
				return;
			}
		}
		SymTabEntry newEntry = new SymTabEntry(name, classification);
		symTab[index] = newEntry;
		index++;
	}
	
	//dfa of scanner
	public static void scanning(BufferedReader br) throws FileNotFoundException,IOException
	{	
		String state = "";
		char input = (char) br.read();
		state = state + input;

		while (true) {
			br.mark(0);
			int endCheck = br.read();
			if(endCheck == -1)
			{
				input = ' ';
			}
			else 
			{
				input = (char) endCheck;
			}
			switch(state)
			{
				//Keyword cases
				case "c":
					if(input == 'l')
						state += input;
					else if (input =='o')
						state +=input;
					break;
				case "cl":			
					if(input =='a')
						state += input;
					break;
				case "cla":
					
					if(input =='s')
						state += input;
					break;
				case "clas":
					if(input =='s')
						state += input;
					break;
				case "class":
					if(endCharacter(input, state,"Keyword",br))
						return;
					break;
				case "co":
					if(input =='p')
						state += input;
					break;
				case "cop":
					if(input =='y')
						state += input;
					break;
				case "copy":
					if(endCharacter(input, state,"Keyword",br))
						return;
					break;
				case "s":
					if(input == 's')
						state += input;
					else if (input =='e')
						state +=input;
					else if (input == 'h')
						state +=input;
					break;
				case "ss":
					if(input =='a')
						state += input;
					break;
				case "ssa":
					if(input =='l')
						state += input;
					break;
				case "ssal":
					if(input =='c')
						state += input;
					break;
				case "ssalc":
					if(endCharacter(input, state,"Keyword",br))
						return;
					break;
				case "se":
					if(input =='e')
						state += input;
					break;
				case "see":
					if(endCharacter(input, state,"Keyword",br))
						return;
					break;
				case "sh":
					if(input =='o')
						state += input;
					break;
				case "sho":
					if(input =='w')
						state += input;
					break;
				case "show":
					if(endCharacter(input, state,"Keyword",br))
						return;
					break;
				case "f":
					if(input =='o')
						state += input;
					break;
				case "fo":
					if(input =='r')
						state += input;
					break;
				case "for":
					if(input == 'a')
						state += input;
					else if (input =='m')
						state +=input;
					break;
				case "fora":
					if(input =='l')
						state += input;
					break;
				case "foral":
					if(input =='l')
						state += input;
					break;
				case "forall":
					if(endCharacter(input, state,"Keyword",br))
						return;
					break;
				case "form":
					if(input =='y')
						state += input;
					break;
				case "formy":
					if(input =='s')
						state += input;
					break;
				case "formys":
					if(input =='e')
						state += input;
					break;
				case "formyse":
					if(input =='l')
						state += input;
					break;
				case "formysel":
					if(input =='f')
						state += input;
					break;
				case "formyself":
					if(input =='o')
						state += input;
					break;
				case "formyselfo":
					if(input =='n')
						state += input;
					break;
				case "formyselfon":
					if(input =='l')
						state += input;
					break;
				case "formyselfonl":
					if(input =='y')
						state += input;
					break;
				case "formyselfonly":
					if(endCharacter(input, state,"Keyword",br))
						return;
					break;
				case "m":
					if(input =='e')
						state += input;
					break;
				case "me":
					if(input =='t')
						state += input;
					break;
				case "met":
					if(input =='h')
						state += input;
					break;
				case "meth":
					if(input =='o')
						state += input;
					break;
				case "metho":
					if(input =='d')
						state += input;
					break;
				case "method":
					if(endCharacter(input, state,"Keyword",br))
						return;
					break;
				case "d":
					if(input =='o')
						state += input;
					break;
				case "do":
					if(input =='h')
						state += input;
					break;
				case "doh":
					if(input =='t')
						state += input;
					break;
				case "doht":
					if(input =='e')
						state += input;
					break;
				case "dohte":
					if(input =='m')
						state += input;
					break;
				case "dohtem":
					if(endCharacter(input, state,"Keyword",br))
						return;
					break;
				case "n":
					if(input == 'u')
						state += input;
					else if (input =='o')
						state +=input;
					break;
				case "nu":
					if(input =='m')
						state += input;
					break;
				case "num":
					if(input =='b')
						state += input;
					break;
				case "numb":
					if(input =='e')
						state += input;
					break;
				case "numbe":
					if(input =='r')
						state += input;
					break;
				case "number":
					if(endCharacter(input, state,"Keyword",br))
						return;
					break;
				case "no":
					if(input == 'n')
						state += input;
					else if (input =='t')
						state +=input;
					break;
				case "non":
					if(input =='o')
						state += input;
					break;
				case "nono":
					if(endCharacter(input, state,"Keyword",br))
						return;
					break;
				case "not":
					if(input == 'f')
						state += input;
					else if (input =='t')
						state +=input;
					else if (input =='e')
						state +=input;
					break;
				case "notf":
					if(input =='a')
						state += input;
					break;
				case "notfa":
					if(input =='l')
						state += input;
					break;
				case "notfal":
					if(input =='s')
						state += input;
					break;
				case "notfals":
					if(input =='e')
						state += input;
					break;
				case "notfalse":
					if(endCharacter(input, state,"Keyword",br))
						return;
					break;
				case "nott":
					if(input =='r')
						state += input;
					break;
				case "nottr":
					if(input =='u')
						state += input;
					break;
				case "nottru":
					if(input =='e')
						state += input;
					break;
				case "nottrue":
					if(endCharacter(input, state,"Keyword",br))
						return;
					break;
				case "note":
					if(input =='q')
						state += input;
					break;
				case "noteq":
					if(input =='u')
						state += input;
					break;
				case "notequ":
					if(input =='a')
						state += input;
					break;
				case "notequa":
					if(input =='l')
						state += input;
					break;
				case "notequal":
					if(endCharacter(input, state,"Keyword",br))
						return;
					break;
				case "b":
					if(input =='o')
						state += input;
					break;
				case "bo":
					if(input =='o')
						state += input;
					break;
				case "boo":
					if(input =='l')
						state += input;
					break;
				case "bool":
					if(input =='e')
						state += input;
					break;
				case "boole":
					if(input =='a')
						state += input;
					break;
				case "boolea":
					if(input =='n')
						state += input;
					break;
				case "boolean":
					if(endCharacter(input, state,"Keyword",br))
						return;
					break;
				case "i":
					if(input == 'f')
						state += input;
					else if (input =='n')
						state +=input;
					break;
				case "if":
					if(endCharacter(input, state,"Keyword",br))
						return;
					else if(input == 'n')
						state += input;
					break;
				case "ifn":
					if(input =='o')
						state += input;
					break;
				case "ifno":
					if(input =='t')
						state += input;
					break;
				case "ifnot":
					if(endCharacter(input, state,"Keyword",br))
						return;
					break;
				case "in":
					if(input =='t')
						state += input;
					break;
				case "int":
					if(input =='o')
						state += input;
					break;
				case "into":
					if(endCharacter(input, state,"Keyword",br))
						return;
					break;
				case "o":
					if(input == 't')
						state += input;
					else if (input =='n')
						state +=input;
					else if (input =='r')
						state +=input;
					break;
				case "ot":
					if(input =='h')
						state += input;
					break;
				case "oth":
					if(input =='e')
						state += input;
					break;
				case "othe":
					if(input =='r')
						state += input;
					break;
				case "other":
					if(input =='w')
						state += input;
					break;
				case "otherw":
					if(input =='i')
						state += input;
					break;
				case "otherwi":
					if(input =='s')
						state += input;
					break;
				case "otherwis":
					if(input =='e')
						state += input;
					break;
				case "otherwise":
					if(endCharacter(input, state,"Keyword",br))
						return;
					break;
				case "on":
					if(input =='l')
						state += input;
					break;
				case "onl":
					if(input =='y')
						state += input;
					break;
				case "only":
					if(input =='i')
						state += input;
					break;
				case "onlyi":
					if(input =='f')
						state += input;
					break;
				case "onlyif":
					if(endCharacter(input, state,"Keyword",br))
						return;
					break;
				case "or":
					if(endCharacter(input, state,"Keyword",br))
						return;
					break;
				case "l":
					if(input == 'o')
						state += input;
					else if (input =='e')
						state+=input;
					break;
				case "lo":
					if(input =='o')
						state += input;
					break;
				case "loo":
					if(input =='p')
						state += input;
					break;
				case "loop":
					if(endCharacter(input, state,"Keyword",br))
						return;
					break;
				case "le":
					if(input =='s')
						state += input;
					break;
				case "les":
					if(input =='s')
						state += input;
					break;
				case "less":
					if(endCharacter(input, state,"Keyword",br))
						return;
					break;
				case "p":
					if(input =='o')
						state += input;
					break;
				case "po":
					if(input =='o')
						state += input;
					break;
				case "poo":
					if(input =='l')
						state += input;
					break;
				case "pool":
					if(endCharacter(input, state,"Keyword",br))
						return;
					break;
				case "e":
					if(input =='x')
						state += input;
					break;
				case "ex":
					if(input =='i')
						state += input;
					break;
				case "exi":
					if(input =='t')
						state += input;
					break;
				case "exit":
					if(endCharacter(input, state,"Keyword",br))
						return;
					break;
				case "a":
					if(input == 'n')
						state += input;
					else if (input =='d')
						state+=input;
					break;
				case "an":
					if(input =='d')
						state += input;
					break;
				case "and":
					if(endCharacter(input, state,"Keyword",br))
						return;
					break;
				case "ad":
					if(input =='d')
						state += input;
					break;
				case "add":
					if(endCharacter(input, state,"Keyword",br))
						return;
					break;
					
				//Identifier cases
				case "0": case "1": case "2": case"3": case "4":
				case "5": case "6": case "7": case"8": case "9":
					
					while(true)
					{
						
						if(endCharacter(input, state,"ID",br))
						{
							bookKeeper(state, "ID");
							return;
						}
						
						else if("0123456789".contains("" + input)){
							state += input;
						}
						else if(input == '_')
						{
							state += input;
							br.mark(0);
							input = (char) br.read();
							if(input == '_')
							{
								
								br.reset();
								errorHandler(br, "Two underscores in a row not allowed", state);
								return;
							}	
							br.reset();
						}
						else 
						{
							br.reset();
							errorHandler(br, "Not a valid identifier", state);
							return;
						}
						br.mark(0);
						input = (char) br.read();
						
					}
					
				//Constant cases
				case "Q": case "W": case "E": case"R": case "T":
				case "Y": case "U": case "I": case"O": case "P":
				case "A": case "S": case "D": case"F": case "G":
				case "H": case "J": case "K": case"L": case "Z":
				case "X": case "C": case "V": case"B": case "N":
				case "M": 
					while(true)
					{
						if(endCharacter(input, state,"Constant",br))
						{
							bookKeeper(state, "Constant");
							return;
						}
						else if (input == '.')
						{
							state += input;
							input = (char) br.read();
							while(true)
							{
								if(endCharacter(input, state,"Constant",br))
								{
									bookKeeper(state, "Constant");
									return;
								}
								else if("QWERTYUIOPASDFGHJKLZXCVBNM".contains("" + input)){
									state += input;
								}
								else 
								{
									br.reset();
									errorHandler(br, "Not a valid constant", state);
									return;
								}
									
								input = (char) br.read();
							}
						}
						
						else if("QWERTYUIOPASDFGHJKLZXCVBNM".contains("" + input)){
							state += input;
						}
						else 
						{
							br.reset();
							errorHandler(br, "Not a valid constant", state);
							return;
						}
						input = (char) br.read();
					}
				case ".":
					
					while(true)
					{
						if("QWERTYUIOPASDFGHJKLZXCVBNM".contains("" + input)){
							state += input;
							input = (char) br.read();
							while(true)
							{
								if(endCharacter(input, state,"Constant",br))
								{
									bookKeeper(state, "Constant");
									return;
								}
								else if("QWERTYUIOPASDFGHJKLZXCVBNM".contains("" + input)){
									state += input;
								}
								input = (char) br.read();
							}
						}
						
						input = (char) br.read();
						
					}
				case "(": case ")": case ";": case "*": 
					print(state, "Special Symbol", lineNumber);
					br.reset();
					return;
				case "\n":
					lineNumber++;
					state = input + "";
					break;
				case " ":
					state = input + "";
					break;
					
				//case for comments (ignore them)
				case "/":
					if(input == '/')
					{
						while((char) br.read() != '\n')
						{
							br.mark(0);
						}
						state = "\n";
					}
					break;
				case "\r":
					state = input + "";
					break;
				//default case to catch errors
				default: 
					br.reset();
					errorHandler(br, "Not a valid token", state);
					return;	
			}			
		}
	}
}
