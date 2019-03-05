import java.util.*;

public class Constraint {
	protected Variable[] scope;
	protected Relation rel;
	
	public Constraint(Relation r, Variable[] sc) {
		rel = r;
		scope = sc;
	}
	
	public boolean satisfied() {
		return rel.test(scope);
	}
	
}

