
/*
 * CSC 242 Project 2: Constraint Satisfaction
 * Group members: Linzan Ye, Matthew Taruno
 * NetID: lye11, mtaruno
 */

import java.util.*;

// Solver class which implements the backtracking algorithm
public class Solver {

	private Deque<Variable> stack = new ArrayDeque<Variable>(); // Set which stores all the variables in the CSP

	// Constructor
	public Solver(CSP csp) {
		for (Variable v : csp.var()) {
			stack.push(v); // Copy all the elements from csp's variable set to the solver.
		}
	}

	// Backtracking algorithm
	public boolean backTracking(CSP csp) {

		// Base case:
		if (csp.isComplete()) {
			System.out.println("Solved: " + csp.problem()); // Print out problem name
			return true;
		}

		Variable v = stack.pop(); // Select one unassigned variable. Currently no heuristic applied.

		// Values:
		// All types of values are represented through integers.
		// Values are initialized to -1 as unassigned.
		// Values can range from 0 to 2, 1 to 27, 0 to 7 depending on different CSP
		// problems.
 
		for (int temp : v.domain()) { // Loop through values in the variable's domain
			v.assign(temp); // Assign the variable with the selected value to check consistency

			if (csp.isConsistent()) { // If the current assignment is consistent
				boolean a = backTracking(csp); // Get the boolean value of the last recursion.
				if (a) { // If succeeded (complete and consistent)
					return true; // Pass true to all the previous recursive calls
				} else { // If an inconsistency is detected
					v.assign(-1); // Remove the assigned value and continue the for loop through all values in the
									// domain
				}
			} else { // If the current assignment is not consistent
				v.assign(-1); // Remove the assigned value and continue the for loop
			}
		}
		// If it reaches this step, it means that there are no consistent assignments
		// for this variable.
		// Therefore, the algorithm tracks backward to the previous recursion.
		stack.push(v); // Add the variable back to the stack so that it can be revisited to check
						// consistency.
		return false; // Failure
	}

	// Under construction (UC)
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

	// UC
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
}
