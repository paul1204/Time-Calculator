import java.util.ArrayList;
import java.util.Scanner;

public class payRoll extends time{

	//Be sure to pass in Seconds
	public static void weeklyPay(ArrayList<Integer> h,ArrayList<Integer> m, Double wage) {
		int weeklyH = 0;
		int weeklyM = 0;
		int weeklyS = 0;
		int carryOver = 0;
		
		for(Integer b: m) {
			weeklyM += b;
		}
		for(Integer a: h) {
			weeklyH += a;
		}
		while(weeklyM >= 59) {
			weeklyM -= 60;
			carryOver++;
		}
		weeklyH += carryOver;
		
		double grossPay = wage * (weeklyH + (weeklyM/60));

		System.out.printf("Total Hours " + weeklyH + ":" + "%02d%n" ,weeklyM);
		System.out.printf("Gross Pay: $" + "%.2f" ,grossPay);
	}
	
	
	
	

	public static void main(String[] args){
		int day = 0;
		ArrayList<Integer> h = new ArrayList<Integer>();
		ArrayList<Integer> m = new ArrayList<Integer>();
		//ArrayList<Integer> s = new ArrayList<Integer>();
		Scanner in = new Scanner(System.in);
		try {
		double wage = in.nextDouble();
		if(wage < 7.25) {
			in.close();
			throw new Exception();
		
		}
		
		while(day != 5) {
		
			//	System.out.println("Enter Hour In");
			int hourIn = in.nextInt();
			//	System.out.println("Enter Min In");
			int minIn = in.nextInt();
			//	System.out.println("Enter Hour Out");
			int hourOut = in.nextInt();
			//	System.out.println("Enter Min Out");
			int minOut = in.nextInt();
			
			time workDay = new time();
			
			workDay.setTotalH(hourIn, hourOut);
			workDay.setTotalM(minIn, minOut);
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
		weeklyPay(h,m,wage);
		}
		catch(Exception e) {
			System.out.print("Minimum Wage is $7.25");
		}
		in.close();
	}
}