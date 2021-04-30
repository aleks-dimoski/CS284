//package sort;

public class Firstnames implements Comparable<Firstnames> {
	String name;
	
	public Firstnames(String name) {
		this.name = name;
	}
	
	public int compareTo(Firstnames that) {
		int i = 0;
		while(i < name.length() && i < that.name.length() && name.charAt(i) == that.name.charAt(i)) {
			i++;
		}
		if(this.name.equals(that.name))
			return 0;
		if(i >= that.name.length())
			return 1;
		else if (i >= this.name.length())
			return -1;
		if(i == name.length() || name.charAt(i) < that.name.charAt(i))
			return 1;
		if(i == that.name.length() || name.charAt(i) > that.name.charAt(i))
			return -1;
		return 0;
	}
	
	public String toString() {
		return name;
	}
}
