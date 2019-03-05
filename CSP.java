
/*
 * CSC 242 Project 2: Constraint Satisfaction
 * Group members: Linzan Ye, Matthew Taruno
 * NetID: lye11, mtaruno
 */

import java.util.*;

// Abstract class for all CSP problems
public abstract class CSP {
	protected ArrayList<Variable> var; // List of variables involved in the CSP
	protected ArrayList<Constraint> constraints; // List of constraints involved in the CSP
	protected Relation rel; // The specific relation involved in the specific CSP
	protected String problem; // The name for the specific CSP problem

	public boolean isComplete() { // Check if the assignment is complete
		for (Variable v : var) { // Loop through all the variables:
			if (v.assignment() < 0) { // If one assignment is smaller than 0,
				return false; // there is at least one unassigned variable
			}
		}
		return true; // Or the assignment is complete
	}

	public boolean isConsistent() { // Check if the assignment is consistent
		for (Constraint c : constraints) { // Loop through all the constraints
			if (!c.satisfied()) { // If not satisfied
				return false; // There is an inconsistency detected.
			}
		}
		return true;
	}

	public ArrayList<Variable> var() { // Return the list of variables involved
		return var;
	}

	public String problem() { // Return the name of the CSP problem
		return "";
	}

	public String toString() { // toString method to return the answer for the CSP
		return "";
	}
}

// Implementation for Australia Map Coloring problem
class AusCSP extends CSP {

	// Variables: states of Australia
	AusVariable WA = new AusVariable("WA");
	AusVariable NT = new AusVariable("NT");
	AusVariable NSW = new AusVariable("NSW");
	AusVariable Q = new AusVariable("Q");
	AusVariable SA = new AusVariable("SA");
	AusVariable T = new AusVariable("T");
	AusVariable V = new AusVariable("V");

	// Create arrays which specifies the specific scope of variables involved in a
	// constraint
	// All binary constraints
	Variable[] v0 = { WA, SA };
	Variable[] v1 = { WA, NT };
	Variable[] v2 = { NT, SA };
	Variable[] v3 = { NT, Q };
	Variable[] v4 = { SA, Q };
	Variable[] v5 = { SA, NSW };
	Variable[] v6 = { SA, V };
	Variable[] v7 = { Q, NSW };
	Variable[] v8 = { NSW, V };

	// Constructor
	public AusCSP() {
		// Initialize the set of variables
		var = new ArrayList<Variable>();
		// Add variables to the set
		var.add(WA);
		var.add(NT);
		var.add(Q);
		var.add(NSW);
		var.add(SA);
		var.add(T);
		var.add(V);

		// Initialize the relation
		rel = new AusRelation(); // In this case, the AusRelation is the only relation wanted.

		// Initialize the constraint set
		constraints = new ArrayList<Constraint>();

		// Add the scopes of variables and relation to the constraint set
		constraints.add(new Constraint(rel, v0));
		constraints.add(new Constraint(rel, v1));
		constraints.add(new Constraint(rel, v2));
		constraints.add(new Constraint(rel, v3));
		constraints.add(new Constraint(rel, v4));
		constraints.add(new Constraint(rel, v5));
		constraints.add(new Constraint(rel, v6));
		constraints.add(new Constraint(rel, v7));
		constraints.add(new Constraint(rel, v8));
	}

	@Override
	public String problem() { // Return the name of the problem
		return "Australia Map Coloring problem";
	}

	@Override
	public String toString() {
		String answer = "Answer: \n";
		String color = "";
		for (Variable v : var) {
			if (v.assignment == 0)
				color = "Red";
			if (v.assignment == 1)
				color = "Green";
			if (v.assignment == 2)
				color = "Blue";
			answer += v.name() + ": " + color + "\n";
		}
		return answer;
	}
}

class JobCSP extends CSP {

	JobVariable AF = new JobVariable(0, 0);
	JobVariable AB = new JobVariable(0, 1);
	JobVariable WLF = new JobVariable(1, 2);
	JobVariable WLB = new JobVariable(1, 3);
	JobVariable WRF = new JobVariable(1, 4);
	JobVariable WRB = new JobVariable(1, 5);
	JobVariable NLF = new JobVariable(2, 2);
	JobVariable NLB = new JobVariable(2, 3);
	JobVariable NRF = new JobVariable(2, 4);
	JobVariable NRB = new JobVariable(2, 5);
	JobVariable CLF = new JobVariable(3, 2);
	JobVariable CLB = new JobVariable(3, 3);
	JobVariable CRF = new JobVariable(3, 4);
	JobVariable CRB = new JobVariable(3, 5);
	JobVariable Ins = new JobVariable(4, 6);

	Variable[] p0 = { AF, WRF };
	Variable[] p1 = { AF, WLF };
	Variable[] p2 = { AB, WRB };
	Variable[] p3 = { AB, WLB };
	Variable[] p4 = { WRF, NRF };
	Variable[] p5 = { WLF, NLF };
	Variable[] p6 = { WRB, NRB };
	Variable[] p7 = { WLB, NLB };
	Variable[] p8 = { NRF, CRF };
	Variable[] p9 = { NLF, CLF };
	Variable[] p10 = { NRB, CRB };
	Variable[] p11 = { NLB, CLB };
	Variable[] d0 = { AF, AB };

	public JobCSP() {
		var = new ArrayList<Variable>();
		var.add(CRB);
		var.add(CRF);
		var.add(CLB);
		var.add(CLF);
		var.add(NRB);
		var.add(NRF);
		var.add(NLB);
		var.add(NLF);
		var.add(WLF);
		var.add(WRB);
		var.add(WRF);
		var.add(WLB);
		var.add(AB);
		var.add(AF);

		rel = new PConstraint();
		Relation rel2 = new DConstraint();

		constraints = new ArrayList<Constraint>();

		constraints.add(new Constraint(rel, p0));
		constraints.add(new Constraint(rel, p1));
		constraints.add(new Constraint(rel, p2));
		constraints.add(new Constraint(rel, p3));
		constraints.add(new Constraint(rel, p4));
		constraints.add(new Constraint(rel, p5));
		constraints.add(new Constraint(rel, p6));
		constraints.add(new Constraint(rel, p7));
		constraints.add(new Constraint(rel, p8));
		constraints.add(new Constraint(rel, p9));
		constraints.add(new Constraint(rel, p10));
		constraints.add(new Constraint(rel, p11));
		constraints.add(new Constraint(rel2, d0));

	}

	@Override
	public String problem() {
		return "Job Shop Scheduling problem";
	}

	@Override
	public String toString() {
		String answer = "Answer: \n";
		String time = "";
		for (Variable v : var) {
			time = Integer.toString(v.assignment());
			answer += v.name() + ": " + time + "\n";
		}
		return answer;
	}
}

class QueenCSP extends CSP {

	QueenVariable q1 = new QueenVariable(0);
	QueenVariable q2 = new QueenVariable(1);
	QueenVariable q3 = new QueenVariable(2);
	QueenVariable q4 = new QueenVariable(3);
	QueenVariable q5 = new QueenVariable(4);
	QueenVariable q6 = new QueenVariable(5);
	QueenVariable q7 = new QueenVariable(6);
	QueenVariable q8 = new QueenVariable(7);

	public QueenCSP() {

		var = new ArrayList<Variable>();
		var.add(q1);
		var.add(q2);
		var.add(q3);
		var.add(q4);
		var.add(q5);
		var.add(q6);
		var.add(q7);
		var.add(q8);

		Variable[] v1 = { q1 };
		Variable[] v2 = { q2 };
		Variable[] v3 = { q3 };
		Variable[] v4 = { q4 };
		Variable[] v5 = { q5 };
		Variable[] v6 = { q6 };
		Variable[] v7 = { q7 };
		Variable[] v8 = { q8 };

		rel = new QRelation();

		constraints = new ArrayList<Constraint>();

		constraints.add(new Constraint(rel, v1));
		constraints.add(new Constraint(rel, v2));
		constraints.add(new Constraint(rel, v3));
		constraints.add(new Constraint(rel, v4));
		constraints.add(new Constraint(rel, v5));
		constraints.add(new Constraint(rel, v6));
		constraints.add(new Constraint(rel, v7));
		constraints.add(new Constraint(rel, v8));

	}

	@Override
	public String problem() {
		return "n-Queens problem";
	}

	@Override
	public String toString() {
		return q1.toString();
	}

}
