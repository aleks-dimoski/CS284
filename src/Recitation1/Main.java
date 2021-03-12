package Recitation1;

import java.util.Arrays;
import main.IDLList;

public class Main {

	public static void main(String[] args) {
		IDLList idll = new IDLList();
		idll.add(new Integer(5));
		idll.add(new Integer(10));
		idll.add(new Integer(2));
		idll.append(new Integer(7));
		idll.removeAt(4);
		System.out.println(idll.toString());
	}
}
