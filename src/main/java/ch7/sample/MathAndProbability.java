package ch7.sample;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.org.apache.xml.internal.security.Init;

public class MathAndProbability {

	private static final Logger logger = LoggerFactory
			.getLogger(MathAndProbability.class);

	public static void main(String[] args) {
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

//	public static boolean[] sieveOfEratosthenes(int max) {
//		boolean[] flags = new boolean[max + 1];
//
//		// set all flags to true
//		Arrays.fill(flags, Boolean.TRUE);
//		int prime = 2;
//
//		while (prime <= Math.sqrt(max)) {
//
//		}
//
//	}

	public static void crossOff(boolean[] flags, int prime) {
		for (int i = prime * prime; i < flags.length; i += prime) {

		}
	}

}
