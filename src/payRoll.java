import java.util.ArrayList;
import java.util.Scanner;

public class payRoll{

	/*
	 * Helper Method to calculate Gross Pay
	 * 
	 * @param h - total Hours
	 * @param m - total Minutes
	 * @param s - total Seconds
	 * @param wage - Hourly Pay
	 * @returns Gross Pay
	 *
	 */
	private static double grossPay(int h, int m, Double wage) {
		double tM = (wage * ((double) m/60));	
		double tH = (wage * h);
		//double tS = wage * ((double)(s/60));		
		double gross = tM + tH;	
		return gross;
	}
	
	     
	/*
	 *  
	 * Computes weekly hours, minutes, and seconds worked \n 
	 * and passes those values into a helper method to do the \n
	 * actual Gross Calculation
	 * 
	 * @param h - A list of all Hours worked
	 * @param m - A list of all Minutes worked
	 * @param s - A list of all Seconds worked
	 * @returns Gross Pay as a String
	 *
	 */
	public static double weeklyPay(ArrayList<Integer> h,ArrayList<Integer> m, ArrayList<Integer> s ,Double wage) {
		String grossPay = "";
		int weeklyH = 0;
		int weeklyM = 0;
		int weeklyS = 0;
		int carryOverH = 0;
		int carryoverM = 0;

		for(Integer c: s) {
			weeklyS += c;
		}
		
		for(Integer b: m) {
			weeklyM += b;
		}
		for(Integer a: h) {
			weeklyH += a;
		}
	
		
	//	while(weeklyS >= 59) {
		//	weeklyS -= 60;
			//carryoverM++;
	//	}
		
		while(weeklyM > 59) {
			carryOverH++;
			weeklyM -= 60;
		}
		weeklyH += carryOverH;	
		//double gross = grossPay(weeklyH, weeklyM, weeklyS, wage);
		double gross = grossPay(weeklyH, weeklyM,  wage);

		grossPay = Double.toString(gross);
		return gross;
	}
	
	
	
	

	public static void main(String[] args){
		
		System.out.println("Hello and Welcome,");
		System.out.println("Please Enter the Following Information Followed By a Space:");
		System.out.println("Hourly Wage");
		System.out.println("Hours In, Minute In, Seconds In ");
		System.out.println("Hours Out, Minute Out, Seconds Out ");
		
		int day = 0;
		
		ArrayList<Integer> h = new ArrayList<Integer>();
		ArrayList<Integer> m = new ArrayList<Integer>();
		ArrayList<Integer> s = new ArrayList<Integer>();
		
		Scanner in = new Scanner(System.in);
			
		try {	
		double wage = in.nextDouble();		
		//double wage = 10.00;
		if(wage < 7.25) {
			in.close();
			//Throws an Exception if Wage is less than 7.25 per Federal Laws
			throw new Exception();
		
		}	
		//This will loop over N amount of days, depending on how many days you worked in 1 week
		//So this while loop will have 2 days on Payroll
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
		
		System.out.printf("Gross Pay: $" + "%.2f\n", weeklyPay(h,m,s,wage));
		}
		
		catch(Exception e) {
			System.out.print("Minimum Wage is $7.25");
		}
		
		in.close();
	}
}


//Code not needed, will delete when finished
//for(Integer a : h) {
//	//System.out.println("Hours worked on this day");
//	//System.out.println(a);
//}
//for(Integer b : m) {
//	//System.out.println("Minutes worked on this day");
//	//System.out.println(b);
//}

//	System.out.printf("Hourly Pay: $" + "%.2f\n" , wage);



