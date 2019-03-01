import java.util.*;

public abstract class Relation {

	public boolean test(Variable[] scope) {
		return false;
	}
}

class AusRelation extends Relation {
	@Override
	public boolean test(Variable[] scope) {
		if (scope[0].assignment() == scope[1].assignment() && scope[0].assignment() > -1) {
			return false;
		}
		return true;
	}
}

class PConstraint extends Relation {
	public boolean test(Variable[] scope) {
		
		return true;
	}
}

class DConstraint extends Relation {
	
}