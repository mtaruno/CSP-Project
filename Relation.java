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
	@Override
	public boolean test(Variable[] scope) {
		JobVariable p1 = (JobVariable)scope[0];
		JobVariable p2 = (JobVariable)scope[1];
		if (p1.assignment() < 0 || p2.assignment() < 0) {
			return true;
		}
		if (p1.assignment() + p1.duration() <= p2.assignment()) {
			return true;
		}
		return false;
	}
}

class DConstraint extends Relation {
	public boolean test(Variable[] scope) {
		JobVariable p1 = (JobVariable)scope[0];
		JobVariable p2 = (JobVariable)scope[1];
		if (p1.assignment() < 0 || p2.assignment() < 0) {
			return true;
		}
		if (p1.assignment() + p1.duration() <= p2.assignment() || p2.assignment() + p2.duration() < p1.assignment()) {
			return true;
		}
		return false;
	}
}