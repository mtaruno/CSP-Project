import java.util.*;

public class CSPApplication {
	
	public static void main(String[] args) {
		
		AusCSP aus = new AusCSP();
		Solver solve1 = new Solver(aus);
		solve1.backTracking(aus);
		System.out.println(aus.toString());
		
		System.out.println("\n\n\n");
		
		JobCSP job = new JobCSP();
		Solver solve2 = new Solver(job);
		solve2.backTracking(job);
		System.out.println(job.toString());
	}
}
