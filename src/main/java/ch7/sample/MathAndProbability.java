package ch7.sample;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MathAndProbability {

	private static final Logger logger = LoggerFactory
			.getLogger(MathAndProbability.class);

	public static void main(String[] args) {
		//System.out.println(primeBetter(8));
		logger.info("The Prime number {}", primeBetter(8));
	}

	public static boolean primeBetter(int n) {
		if (n < 2)
			return false;

		int sqrt = (int) Math.sqrt(n);
		for (int i = 2; i <= sqrt; i++) {
			if (n % i == 0)
				return false;
		}

		return true;
	}
}
