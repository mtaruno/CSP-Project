import java.util.*;

public class Solver {
	
	Deque<Variable> stack = new ArrayDeque<Variable>();
	
	public Solver(CSP csp) {	// No heuristic (linear)
		for (Variable v : csp.var()) {
			stack.push(v);
		}
	}

	public boolean backTracking(CSP csp) {
		if (csp.isComplete()) {
			return true;
		} 
		Variable v;
		
		return false; // Failure
	}
}
