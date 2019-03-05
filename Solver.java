import java.util.*;

public class Solver {
	
	private Deque<Variable> stack = new ArrayDeque<Variable>();
	
	public Solver(CSP csp) {	// No heuristic (linear)
		for (Variable v : csp.var()) {
			stack.push(v);
		}
	}
	
	public boolean backTracking(CSP csp) {
		
		// Base case:
		if (csp.isComplete()) {
			System.out.println("Solved");
			return true;
		} 

		Variable v = stack.pop(); // Select one unassigned variable.
		System.out.println("Checking " + v.name() + ", stack size: " + stack.size());
		
		for (int temp : v.domain()) {
			System.out.println("Assigned " + temp);
			v.assign(temp);
			
			if (csp.isConsistent()) {
				boolean a = backTracking(csp);
				if (a) {
					return true;
				}
			} else {
				v.assign(-1); // Remove the assignment
				
			}
		}
		stack.push(v); // If backtrack, add the variable back to the stack
		return false; // Failure
	}
}
