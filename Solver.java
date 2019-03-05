import java.util.*;

public class Solver {
	
	private Deque<Variable> stack = new ArrayDeque<Variable>();
	
	public Solver(CSP csp) {	// No heuristic (linear)
		for (Variable v : csp.var()) {
			stack.push(v);
		}
	}
	
	public boolean AC3(CSP csp) {
		Queue<Constraint> q = new LinkedList<>();
		for (Constraint c : csp.constraints) {
			q.add(c);
		}
		Constraint c;
		while (!q.isEmpty()) {
			c = q.remove();

		}
		return false;
	}

	public boolean revised(Constraint c, Variable v1, Variable v2) {
		boolean revised = false;
		
		ArrayList<Integer> dom1 = new ArrayList<Integer>();
		
		for (int i = 0; i < v1.domain().size(); i++) {
			dom1.add(v1.domain().get(i));
		}
		
		v1.assign(-1);
		v2.assign(-1);
		return revised;
	}
	
	public boolean backTracking(CSP csp) {
		
		// Base case:
		if (csp.isComplete()) {
			System.out.println("Solved");
			return true;
		} 

		Variable v = stack.pop(); // Select one unassigned variable.
		
		for (int temp : v.domain()) {
			v.assign(temp);
			
			if (csp.isConsistent()) {
				boolean a = backTracking(csp);
				if (a) {
					return true;
				} else {
					v.assign(-1);
				}
			} else {
				v.assign(-1); // Remove the assignment
				
			}
		}
		stack.push(v); // If backtrack, add the variable back to the stack
		return false; // Failure
	}
}
