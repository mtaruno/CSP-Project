
/*
 * CSC 242 Project 2: Constraint Satisfaction
 * Group members: Linzan Ye, Matthew Taruno
 * NetID: lye11, mtaruno
 */

// Abstract class for relations between variables in a constraint.
// Is called by the Constraint class for function isSatisfied()
public abstract class Relation {

	// Abstract method
	public boolean test(Variable[] scope) {
		return false;
	}
}

// Australia
class AusRelation extends Relation {
	@Override
	public boolean test(Variable[] scope) {
		// Simple not equal relation
		// Ignore unassigned cases
		if (scope[0].assignment() == scope[1].assignment() && scope[0].assignment() > -1) {
			return false;
		}
		return true;
	}
}

// Two classes for job problem
class PConstraint extends Relation { // Precedence constraint
	@Override
	public boolean test(Variable[] scope) {
		// Get the two JobVariables in the scope
		JobVariable p1 = (JobVariable) scope[0];
		JobVariable p2 = (JobVariable) scope[1];
		// Ignore unassigned cases
		if (p1.assignment() < 0 || p2.assignment() < 0) {
			return true;
		}
		// The first task should not precede the second task
		if (p1.assignment() + p1.duration() <= p2.assignment()) {
			return true;
		}
		return false;
	}
}

class DConstraint extends Relation { // Disjunctive constraint
	@Override
	public boolean test(Variable[] scope) {
		JobVariable p1 = (JobVariable) scope[0];
		JobVariable p2 = (JobVariable) scope[1];
		// Ignore unassigned
		if (p1.assignment() < 0 || p2.assignment() < 0) {
			return true;
		}
		// Either the first task precedes the second or the second precedes the first.
		if (p1.assignment() + p1.duration() <= p2.assignment() || p2.assignment() + p2.duration() < p1.assignment()) {
			return true;
		}
		return false;
	}
}

// n-Queen problem
class QRelation extends Relation {
	@Override
	public boolean test(Variable[] scope) { // Our implementation only involves unary constraint
		// Get the single queen involved
		QueenVariable queen = (QueenVariable) scope[0];
		int[][] board = queen.getBoard(); // Get the board stored in the variable
		int counter = 0; // Count the numbers of chess in the same column/diagonal of the given chess

		// Vertical check
		for (int i = 0; i < board.length; i++) {
			if (queen.assignment >= 0) { // If the location is assigned with a queen
				if (board[i][queen.assignment()] == 1) { // If there is a queen
					counter += 1; // Count one queen
					if (counter > 1) { // If more than one queen in the row
						return false;
					}
				}
			}

		}

		// Reset counter
		counter = 0;

		// Descending diagonal check 1
		try { // Use try catch to visit all the directions of the board until out of array
				// bound
			int row = queen.getRow(); // From the specific row the give chess stays.
			int column = queen.assignment(); // From the specific column the give chess stays.

			while (true) {

				if (board[row][column] == 1) { // Scan through the diagonal
					counter += 1;
					if (counter > 1) {
						return false;
					}
				}
				row++;
				column++;
			}

		} catch (ArrayIndexOutOfBoundsException e) { // Exit when reaching the end of array
		}
		counter = 0; // Reset
		
		// Descending diagonal check 2, since the chess may be in the middle of a diagonal
		try {
			int row = queen.getRow();
			int column = queen.assignment();
			while (true) {

				if (board[row][column] == 1) {
					counter += 1;
					if (counter > 1) {
						return false;
					}
				}
				row--;
				column--;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
		}

		counter = 0; // Reset

		// Ascending diagonal check 1
		try {
			int row = queen.getRow();
			int column = queen.assignment();

			while (true) {

				if (board[row][column] == 1) {
					counter += 1;
					if (counter > 1) {
						return false;
					}
				}
				row++;
				column--;
			}

		} catch (ArrayIndexOutOfBoundsException e) {
		}

		counter = 0;

		// Ascending diagonal check 2
		try {
			int row = queen.getRow();
			int column = queen.assignment();

			while (true) {
				if (board[row][column] == 1) {
					counter += 1;
					if (counter > 1) {
						return false;
					}
				}
				row--;
				column++;
			}

		} catch (ArrayIndexOutOfBoundsException e) {
		}

		// Vertical check not needed since we structured the domain as 
		// the position of column which the chess is assigned
		// Initially, each chess occupies each of the row on the board
		
		// If passed all the tests, return true
		return true;
	}

}