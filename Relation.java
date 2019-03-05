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
		JobVariable p1 = (JobVariable) scope[0];
		JobVariable p2 = (JobVariable) scope[1];
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
	@Override
	public boolean test(Variable[] scope) {
		JobVariable p1 = (JobVariable) scope[0];
		JobVariable p2 = (JobVariable) scope[1];
		if (p1.assignment() < 0 || p2.assignment() < 0) {
			return true;
		}
		if (p1.assignment() + p1.duration() <= p2.assignment() || p2.assignment() + p2.duration() < p1.assignment()) {
			return true;
		}
		return false;
	}
}

class QRelation extends Relation {
	@Override
	public boolean test(Variable[] scope) {
		QueenVariable queen = (QueenVariable) scope[0];
		int[][] board = queen.getBoard();
		int counter = 0;
		// Vertical check
		for (int i = 0; i < 8; i++) {
			if(queen.assignment > 0) {
				if (board[i][queen.assignment()] == 1) {
					counter += 1;
					if (counter != 1) {
						return false;
					} else {
						System.out.println("Qs at column " + queen.assignment() + " is " + counter);
					}
				}
			}
			
		}
		counter = 0;

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
				column++;
			}

		} catch (ArrayIndexOutOfBoundsException e) {
		}
		counter = 0;
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
		
		counter = 0;
		
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
		
		// Vertical check not needed
		// Down Diagonal check
		// Up Diagonal check

		return true;
	}

}