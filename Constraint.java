import java.util.*;

public class Constraint {
	Variable[] scope;
	Relation rel;
	
	public Constraint(Relation r, int consistencyType) {
		rel = r;
		scope = new Variable[consistencyType];
	}
	
	public boolean satisfied() {
		return rel.test(scope);
	}
	
}
