public class time{
	
		private int totalH;
		private int totalM;
		private int totalS;

		//Take mIn, Subtract from a Whole Hour to find difference
		//Take difference and add to mOut
		public void setTotalM(int mIn, int mOut) {
			int wholeHour;
			int hour = 60;
			if (mOut < mIn) {
				wholeHour = hour - mIn;
				totalH = totalH - 1;
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

		//Implement me 
		public int setTotalS(int sIn, int sOut) {
			return -1;
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