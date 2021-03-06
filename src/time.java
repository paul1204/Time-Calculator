//time class takes two inputs of time and becomes a difference between the 2

public class time{
	
		private int totalH = 0;
		private int totalM = 0;
		private int totalS = 0;
		
		

		//Same Logic as setTotalM
		//We simply subract the 2 times, however if the Second carries over to the next minute
		//We take the In second, take the distance till the next whole minute, and add it to the totalMinute plus
		//total second worked
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
		
		//Take mIn, Subtract from a Whole Hour to find difference
		//Take difference and add to mOut
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

		public void setTotalH(int hIn, int hOut) {
			//If Employee worked into the next day
			if(hIn > hOut) {
				hOut += 24;
			}
			//Finds difference of hours worked
			totalH = Math.abs(hIn - hOut);
			//return totalHoursWorked;
			//return totalH;
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


