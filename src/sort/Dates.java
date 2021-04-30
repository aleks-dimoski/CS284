//package sort;

public class Dates implements Comparable<Dates> {
	int date;
	
	public Dates(int date) {
		this.date = date;
	}
	
	public int compareTo(Dates that) {
		if(this.date < that.date)
			return -1;
		else if(this.date > that.date)
			return 1;
		return 0;
	}
	public String toString() {
		return String.valueOf(date);
	}
}
