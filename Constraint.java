
/*
 * CSC 242 Project 2: Constraint Satisfaction
 * Group members: Linzan Ye, Matthew Taruno
 * NetID: lye11, mtaruno
 */

import java.util.*;

// The ultimate class for the implementation of constraints
public class Constraint {
	protected Variable[] scope; // Scope of variables involved in one constraint
	protected Relation rel; // Specific relation for this constraint

	// Constructor
	public Constraint(Relation r, Variable[] sc) {
		rel = r;
		scope = sc;
	}

	// Check if the constraint is satisfied
	public boolean satisfied() {
		return rel.test(scope); // Calls the test function from Relation class.
								// The relation class is implemented according to different CSP problems
	}

}
