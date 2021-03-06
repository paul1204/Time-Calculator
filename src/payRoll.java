import java.util.ArrayList;
import java.util.Scanner;

public class payRoll{

	
	private static double grossPay(int h, int m, Double wage) {
		double s = (wage * ( h + (m/60))); 
		return s;
	}
	
	     

	public static void weeklyPay(ArrayList<Integer> h,ArrayList<Integer> m, ArrayList<Integer> s ,Double wage) {
		int weeklyH = 0;
		int weeklyM = 0;
		int weeklyS = 0;
		int carryOverH = 0;
		int carryoverM = 0;

		
		for(Integer c: s) {
			weeklyH += c;
		}
		
		for(Integer b: m) {
			weeklyM += b;
		}
		for(Integer a: h) {
			weeklyH += a;
		}
	
		
		while(weeklyS >= 59) {
			weeklyS -= 60;
			carryoverM++;
		}
		
		while(weeklyM > 59) {
			weeklyM -= 60;
			carryOverH++;
		}
		
		System.out.println(weeklyM);
		
		
		weeklyH += carryOverH;

		
		double gross = grossPay(weeklyH, weeklyM, wage);

		System.out.printf("Total Hours " + weeklyH + ":" + "%02d" + ":" + "%02d%n" ,weeklyM, weeklyS);
		System.out.printf("Gross Pay: $" + "%.4f" , gross);
	}
	
	
	
	

	public static void main(String[] args){
		System.out.println("Hello     ");
		double ssss = (30%60);
		System.out.printf("%.4f" , ssss);
		
		
		int day = 0;
		ArrayList<Integer> h = new ArrayList<Integer>();
		ArrayList<Integer> m = new ArrayList<Integer>();
		ArrayList<Integer> s = new ArrayList<Integer>();
		
		Scanner in = new Scanner(System.in);
		try {
		//double wage = in.nextDouble();
		double wage = 10.00;
		if(wage < 7.25) {
			in.close();
			throw new Exception();
		
		}
		
		while(day != 1) {
		
			//	System.out.println("Enter Hour In");
			int hourIn = in.nextInt();
			//	System.out.println("Enter Min In");
			int minIn = in.nextInt();
			//System.out.println("Enter Sec In");
			int secIn = in.nextInt();
			//	System.out.println("Enter Hour Out");
			int hourOut = in.nextInt();
			//	System.out.println("Enter Min Out");
			int minOut = in.nextInt();
			//System.out.println("Enter Sec Out");
			int secOut = in.nextInt();
			
			
			time workDay = new time();
			
			workDay.setTotalH(hourIn, hourOut);
			workDay.setTotalM(minIn, minOut);
			workDay.setTotalS(secIn, secOut);
			s.add(day, workDay.getTotalS());
			m.add(day, workDay.getTotalM());
			h.add(day, workDay.getTotalH());
			
			
			
			day++;
		
		}
		for(Integer a : h) {
			//System.out.println("Hours worked on this day");
			//System.out.println(a);
		}
		for(Integer b : m) {
			//System.out.println("Minutes worked on this day");
			//System.out.println(b);
		}
		System.out.printf("Hourly Pay: $" + "%.2f\n" , wage);
		weeklyPay(h,m,s,wage);
		}
		catch(Exception e) {
			System.out.print("Minimum Wage is $7.25");
		}
		in.close();
	}
}


