import java.util.*;

public class Constraint {
	Variable[] scope;
	Relation rel;
	
	public Constraint(Relation r, Variable[] sc) {
		rel = r;
		scope = sc;
	}
	
	public boolean satisfied() {
		return rel.test(scope);
	}
	
}

