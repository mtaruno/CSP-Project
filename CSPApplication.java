
/*
 * CSC 242 Project 2: Constraint Satisfaction
 * Group members: Linzan Ye, Matthew Taruno
 * NetID: lye11, mtaruno
 */

//Main class
public class CSPApplication {

	public static void main(String[] args) {

		// Australia Map Coloring problem
		AusCSP aus = new AusCSP();
		Solver solve1 = new Solver(aus);
		if (!solve1.backTracking(aus)) { // Print out solution if there is a solution
			System.out.println("No possible solution can be found."); // Else, print no possible solution can be found
		}
		System.out.println(aus.toString());

		System.out.println("\n\n\n");

		// Job Shop Scheduling problem
		JobCSP job = new JobCSP();
		Solver solve2 = new Solver(job);
		if (!solve2.backTracking(job)) {
			System.out.println("No possible solution can be found.");
		}
		System.out.println(job.toString());

		System.out.println("\n\n\n");

		// n-Queen problem
		QueenCSP queen = new QueenCSP();
		Solver solve3 = new Solver(queen);
		if (!solve3.backTracking(queen)) {
			System.out.println("No possible solution can be found.");
		}
		System.out.println(queen.toString());

	}
}
