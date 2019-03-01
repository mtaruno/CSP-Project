import java.util.*;

public abstract class CSP {
	protected ArrayList<Variable> var;
	protected ArrayList<Constraint> constraints;
	
	public CSP(ArrayList<Variable> v) {
		var = v;
	}
	
	public CSP(ArrayList<Variable> v, ArrayList<Constraint> c) {
		var = v;
		constraints = c;
	}
	
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
}

class CSPTest extends CSP {

	public CSPTest(ArrayList<Variable> v) {
		super(v);
	}
	
	public CSPTest (ArrayList<Variable> v, ArrayList<Constraint> c) {
		super(v, c);
	}
	
}