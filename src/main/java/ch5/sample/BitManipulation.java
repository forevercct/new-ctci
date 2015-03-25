package ch5.sample;

public class BitManipulation {

	public static void main(String[] args) {

		int value = 23;
		int result1 = clearBitsMSBthroughI(value, 4);
		int result2 = clearBitsIthrough0(value, 4);
		int result3 = updateBit(result2, 0, 1);
		String test = "100";

		System.out.println("The result1 is: " + result1);
		System.out.println("The result2 is: " + padding(result2));
		System.out.println("The result3 is: " + padding(result3));
		System.out.println("The testing is: " + (test.charAt(1) - 48));
	}

	public static boolean getBit(int num, int i) {
		return ((num & (1 << i)) != 0);
	}

	public static int setBit(int num, int i) {
		return num | (1 << i);
	}

	public static int clearBit(int num, int i) {
		int mask = ~(1 << i);

		return num & mask;
	}

	public static int clearBitsMSBthroughI(int num, int i) {
		int mask = (1 << i) - 1;
		return num & mask;
	}

	public static int clearBitsIthrough0(int num, int i) {
		int mask = ~((1 << (i + 1)) - 1);
		return num & mask;
	}

	public static int updateBit(int num, int i, int v) {
		int mask = ~(1 << i);
		return (num & mask) | (v << i);
	}

	public static String padding(int number) {

		// 8-bits
		String padding = "00000000";

		// left-pad the value with zeros
		String result = padding + Integer.toBinaryString(number);

		result = result.substring(result.length() - 8, result.length());

		return result;
	}
}
