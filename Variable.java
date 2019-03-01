import java.util.*;

public /*abstract*/ class Variable {
	protected ArrayList<Integer> domain;
	protected int assignment = -1;
	
	public Variable() {
		
	}
	
	public Variable(int a) {
		assignment = a;
	}
	
	public void assign(int a) {
		assignment = a;
	}
	
	public int assignment() {
		return assignment;
	}
	
	public ArrayList<Integer> domain() {
		return domain;
	}
}
