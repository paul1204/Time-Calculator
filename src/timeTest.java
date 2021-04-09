import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


//All Input Error Handling Testing will be performed in payRollTest 
class timeTest {
	
	time t;

	
	@ParameterizedTest
	@MethodSource("streamOfMinandSec")
	void testSetTotalS(int sIn, int sOut, int ans) {
		t = new time();
		t.setTotalS(sIn, sOut);
		assertEquals(t.getTotalS(), ans);
	}
    
	//Calculating Minutes and Seconds have the same Logic,
	@ParameterizedTest
	@MethodSource("streamOfMinandSec")
	void testSetTotalM(int mIn, int mOut, int ans) {
		t = new time();
		t.setTotalM(mIn, mOut);
		assertEquals(t.getTotalM(), ans);
	}

	@ParameterizedTest
	@MethodSource("streamOfHours")
	void testSetTotalH(int hIn, int hOut, int ans) {
		t = new time();
		t.setTotalH(hIn, hOut);
		assertEquals(t.getTotalH(), ans);
	}

	//Explicitly Testing Getters are not necessary \n
	//as they are called in the Setters
	
	/*
	@Test
	void testGetTotalH() {
	
	}

	@Test
	void testGetTotalM() {
		fail("Not yet implemented");
	}

	@Test
	void testGetTotalS() {
		fail("Not yet implemented");
	}
*/
	
	//This.stream is used for both Minute and Seconds Calculations
	private static Stream<?> streamOfMinandSec() {
		return Stream.of(
		//Same Minute Time Frame
		Arguments.of(15, 45, 30),

		//Into the Next Minute Time Frame
		Arguments.of(45, 15, 30),
		Arguments.of(59, 05 , 6)
				);		
	}
	
	private static Stream<?> streamOfHours() {
		return Stream.of(
		//AM -> AM
		Arguments.of(0, 11, 11),
		//PM -> PM
		Arguments.of(12, 11, 11),
		
		//AM -> PM
		Arguments.of(9, 5, 8),
		Arguments.of(9, 17, 8),
		
		//PM -> AM
		Arguments.of(23, 6, 7)
				);		
	}
	
	
}
