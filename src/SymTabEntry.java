//class to hold Symbol table entry information
public class SymTabEntry {
	String name;
	String classification;
	
	public SymTabEntry(String name, String classification)
	{
		this.name = name;
		this.classification = classification;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}
}
