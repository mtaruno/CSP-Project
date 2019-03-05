
/*
 * CSC 242 Project 2: Constraint Satisfaction
 * Group members: Linzan Ye, Matthew Taruno
 * NetID: lye11, mtaruno
 */

import java.util.*;

public abstract class Variable {
	protected ArrayList<Integer> domain;
	protected int assignment = -1;

	public Variable() {

	}

	public Variable(int a) {
		assignment = a;
	}

	public void assign(int a) {
		assignment = a;
	}

	public int assignment() {
		return assignment;
	}

	public String name() {
		return "";
	}

	public ArrayList<Integer> domain() {
		return domain;
	}
}

class AusVariable extends Variable {
	private String territory;

	public AusVariable(String t) {
		domain = new ArrayList<Integer>();
		domain.add(0); // Red
		domain.add(1); // Green
		domain.add(2); // Blue
		territory = t;
	}

	public String name() {
		return territory;
	}
}

class JobVariable extends Variable {
	private int task;
	private int side;
	private int duration;

	private String[] taskKey = { "Axle", "Wheel", "Nuts", "Cap", "Inspect" };
	private String[] sideKey = { "F", "B", "LF", "LB", "RF", "RB", "" };

	public JobVariable(int t, int s) {
		domain = new ArrayList<Integer>();
		for (int i = 1; i < 28; i++) { // 27 values
			domain.add(i);
		}
		task = t;
		side = s;
		switch (task) {
		case 0:
			duration = 10;
			break;
		case 1:
			duration = 1;
			break;
		case 2:
			duration = 2;
			break;
		case 3:
			duration = 1;
			break;
		case 4:
			assignment = 3; // Inspect case, no need for duration
			break;
		default:
			System.out.println("Error task input.");
		}
	}

	public int task() {
		return task;
	}

	public int side() {
		return side;
	}

	public int duration() {
		return duration;
	}

	public String name() {
		return taskKey[task] + sideKey[side];

	}
}

class QueenVariable extends Variable {
	private int row;
	private static int[][] board;
	private static int nQueen = 8;
	private static final int maxQueen = 24;

	public QueenVariable(int row, int num) {

		if (num > maxQueen) {
			return;
		} else { // Ignore cases bigger than 30 UC
			board = new int[num][num];
		}

		this.row = row;
		domain = new ArrayList<Integer>();

		for (int i = 0; i < board.length; i++) {
			domain.add(i);
		}
		nQueen = num;
	}

	@Override
	public void assign(int a) {
		if (a > board.length) {
			System.out.println("Outside column range");
		} else {
			assignment = a;
			if (a >= 0) {
				board[row][a] = 1; // 1 means occupied
			} else {
				for (int i = 0; i < board[0].length; i++) {
					board[row][i] = 0;
				}
			}
		}
	}

	public int nQueen() {
		return nQueen;
	}

	public int maxQueen() {
		return maxQueen;
	}
	
	public int[][] getBoard() {
		return board;
	}

	public int getRow() {
		return row;
	}

	@Override
	public String name() {
		return "Chess at row; " + row;
	}

	public String toString() {
		String chessboard = "";
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == 1) {
					chessboard += "Q";
				} else {
					chessboard += "*";
				}
				chessboard += " ";
			}
			chessboard += "\n";
		}
		return chessboard;

	}

}