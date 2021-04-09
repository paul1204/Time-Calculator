import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class payRollTest {

	payRoll p1;
	time t = new time();
	
	private static Stream<?> inputStream() {
	
		return Stream.of(
		Arguments.of(5 ,30 ,00 ,10 ,00 ,00, 45.00)
				);		
	}
	
	
	
	
	@ParameterizedTest
	@MethodSource("inputStream")
	void testWeeklyPay(int hIn, int minIn, int secIn, int hOut, int mOut, int sOut, double grossPay) {
		p1 = new payRoll();
		p1.weeklyPay(null, null, null, null);
	}

	@Test
	void testMain() {
		payRoll  p = new payRoll();
	}

}
