
/*
 * CSC 242 Project 2: Constraint Satisfaction
 * Group members: Linzan Ye, Matthew Taruno
 * NetID: lye11, mtaruno
 */

import java.util.*;

// Variable implementation
public abstract class Variable {
	protected ArrayList<Integer> domain; // ArrayList to store domain of the problem
	protected int assignment = -1; // Initialized as -1. We use integer to represent all assignments

	public Variable() {
		// Default constructor
	}

	public void assign(int a) {
		assignment = a;
	}

	public int assignment() {
		return assignment;
	}

	public String name() { // Return name of the variable
		return "";
	}

	public ArrayList<Integer> domain() { // Return array list of domain 
		return domain;
	}
}

// Australia map variables
class AusVariable extends Variable {
	private String territory; // Name of he state

	public AusVariable(String t) {
		domain = new ArrayList<Integer>();
		domain.add(0); // Red as 0
		domain.add(1); // Green as 1
		domain.add(2); // Blue as 2
		territory = t; // The name of the state
	}

	public String name() {
		return territory;
	}
}

// Job scheduling variables
class JobVariable extends Variable {
	private int task; // Start time of the task
	private int side; // Side of the gadget
	private int duration; // Duration of each specific task

	private String[] taskKey = { "Axle", "Wheel", "Nuts", "Cap", "Inspect" };
	private String[] sideKey = { "F", "B", "LF", "LB", "RF", "RB", "" };
	// F for front, B for back, L for left, R for right
	// We use string array and positions in it to represent different parts of the job

	public JobVariable(int t, int s) {
		domain = new ArrayList<Integer>();
		for (int i = 1; i < 28; i++) { // 27 values so that it meets the last constraint:
			domain.add(i); 	// In total, smaller than 30 minutes
		}
		task = t;
		side = s;
		switch (task) {
		case 0:
			duration = 10; // Axle
			break;
		case 1:
			duration = 1; // Wheel
			break;
		case 2:
			duration = 2; // Nuts
			break;
		case 3:
			duration = 1; // Cap
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

// QueenVariable
class QueenVariable extends Variable {
	private int row; // The specific row which the queen stays in 
	private static int[][] board; // The 2D chess board represented through integer
	private static int nQueen = 8; // Assume there are initially 8 queens on the board.
	private static final int maxQueen = 24; // The maximum number of queens are 24.

	public QueenVariable(int row, int num) {

		if (num > maxQueen) { // Ignore cases bigger than 24
			return;
		} else { 
			board = new int[num][num];
		}

		this.row = row;
		domain = new ArrayList<Integer>();

		for (int i = 0; i < board.length; i++) {
			domain.add(i); // Add the values to the domain
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
					chessboard += "Q"; // For queen
				} else {
					chessboard += "*"; // For empty slot
				}
				chessboard += " ";
			}
			chessboard += "\n";
		}
		return chessboard;

	}

}