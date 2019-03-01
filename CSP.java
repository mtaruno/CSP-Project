import java.util.*;

public abstract class CSP {
	protected ArrayList<Variable> var;
	protected ArrayList<Constraint> constraints;
	protected Relation rel;

	public boolean isComplete() {
		for (Variable v : var) {
			if (v.assignment() < 0) {
				return false;
			}
		}
		return true;
	}

	public boolean isConsistent() {
		for (Constraint c : constraints) {
			if (!c.satisfied()) {
				return false;
			}
		}
		return true;
	}

	public ArrayList<Variable> var() {
		return var;
	}

	public String toString() {
		return "";
	}
}

class AusCSP extends CSP {

	private AusRelation rel;
	
	public AusCSP() {
		var = new ArrayList<Variable>();
		AusVariable WA = new AusVariable("WA");
		var.add(WA);
		AusVariable NT = new AusVariable("NT");
		var.add(NT);
		AusVariable Q = new AusVariable("Q");
		var.add(Q);
		AusVariable NSW = new AusVariable("NSW");
		var.add(NSW);
		AusVariable SA = new AusVariable("SA");
		var.add(SA);
		AusVariable T = new AusVariable("T");
		var.add(T);
		AusVariable V = new AusVariable("V");
		var.add(V);
		
		rel = new AusRelation();
		Variable[] v0 = {WA, SA};
		Variable[] v1 = {WA, NT};
		Variable[] v2 = {NT, SA};
		Variable[] v3 = {NT, Q};
		Variable[] v4 = {SA, Q};
		Variable[] v5 = {SA, NSW};
		Variable[] v6 = {SA, V};
		Variable[] v7 = {Q, NSW};
		Variable[] v8 = {NSW, V};
		
		constraints = new ArrayList<Constraint>();
		
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
	
	
	
}