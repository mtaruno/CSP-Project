import java.util.*;

public class CSPApplication {
	
	public static void main(String[] args) {
		
		ArrayList<Variable> var = new ArrayList<Variable>();
		var.add(new Variable(2));
		var.add(new Variable(3));
		var.add(new Variable(4));
		
		CSPTest c = new CSPTest(var);
		
	}
}
