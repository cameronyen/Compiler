import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class main {
	String token;
	
	public static void main(String[] args) throws FileNotFoundException,IOException 
	{
		SCANNER scan = new SCANNER();
		
		//print out the source code
		try (BufferedReader source = new BufferedReader(new FileReader("source.txt"))) {
			System.out.println("Source code printout: \n");
			while (source.ready()) {
				String output = source.readLine();
				System.out.println(output);
			}
		}
		
		//Scanner
		try (BufferedReader br = new BufferedReader(new FileReader("source.txt"))) {
			System.out.println("\nTokens: \n");
			while (br.ready()) {
				
				scan.scanning(br);
			}
		}
		
		//SymTab printout
		System.out.println("\nSymbol Table printout (Name, Classification):\n");
		for (int i = 0; i < scan.index; i++)
		{
			System.out.println(scan.symTab[i].getName() + " ,"
					+ scan.symTab[i].getClassification());
		}
		//String input = System.console().readLine();

	}

}
