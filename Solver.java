import java.util.*;

public class Solver {
	
	private Deque<Variable> stack = new ArrayDeque<Variable>();
	
	public Solver(CSP csp) {	// No heuristic (linear)
		for (Variable v : csp.var()) {
			stack.push(v);
		}
		System.out.println("Added");
	}
	
	public boolean backTracking(CSP csp) {
		
		// Base case:
		if (csp.isComplete()) {
			return true;
		} 
		
		Variable v = stack.pop(); // Select one unassigned variable, need more work to include bigger cases
		
		for (int temp : v.domain()) {
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
		
		return false; // Failure
	}
}
