//time object takes two inputs of time and becomes a difference between the 2

public class time{
	
		private int totalH = 0;
		private int totalM = 0;
		private int totalS = 0;
		
		/*
		 *Same Logic as setTotalM
		 *We simply subract the 2 times, however if the Second carries over to the next minute
		 *We take the In second, take the distance till the next whole minute, and add it to the totalMinute plus
         *total second worked
		 *  
		 * @param sIn - Seconds In
		 * @param sOut - Seconds Out
		 *
		 * @returns void
		 *
		 */
		public void setTotalS(int sIn, int sOut) {
			int wholeSec;
			int min = 60;
			
			if(sIn == 0 || sOut == 0) {
				totalS = 0;
			}
			
			else if(sOut < sIn) {
				wholeSec = min - sIn;
				//totalM--;
				totalS = wholeSec + sOut;
			}
			
			else {
				totalS = Math.abs(sIn - sOut);
			}
			
		}
		
		/*
 		 *See Documentation for setTotalS for Description for this.method
     	 *
		 *  
		 * @param mIn - Minute In
		 * @param sOut - Minute Out
		 *
		 * @returns void
		 *
		 */
		public void setTotalM(int mIn, int mOut) {
			int wholeHour;
			int hour = 60;
			if (mOut < mIn) {
				wholeHour = hour - mIn;
				totalH--;
				totalM = wholeHour +  mOut;
			}
			else {
				totalM = Math.abs(mIn - mOut);
			}
		}

		
		/*
 	     *Computes total hours by subtracting the two @param
 		 * Since we are working with 24 Hours, if someone worked the grave yard shift
 		 * 
 		 * If someone clocks in at hour 23:00 and leaves at 4:00,
 		 * If you simply subtract the 2 hours, you'll get 19 hours which is incorrect
 		 * In line 89, we add 24 to 4:00 to get 28:00
 		 * 28:00 - 23:00 is 5 hours which is correct
 		 *
		 *  
		 * @param mIn - Minute In
		 * @param sOut - Minute Out
		 *
		 * @returns void
		 *
		 */
		public void setTotalH(int hIn, int hOut) {
			//If Employee worked into the next day
			if(hIn > hOut) {
				hOut += 24;
			}
			//Finds difference of hours worked
			totalH = Math.abs(hOut - hIn);
		}

		

		public int getTotalH() {
			return totalH;
		}

		public int getTotalM() {
			return totalM;
		}

		public int getTotalS() {
			return totalS;
		}
	}


