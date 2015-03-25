package ch5.solutions;

public class solution3 {

	public static void main(String[] args) {
		// getNextSmallest(38);
		// getNextLargest(38);
		System.out.println("The Original: " + "38, Binary: " + padding(38));
		int value1 = getNext(38);
		System.out.println("The Next Largest: " + value1 + ", Binary: "
				+ padding(value1));
		int value2 = getPrev(131);
		System.out.println("The Next Smallest: " + value2 + ", Binary: "
				+ padding(value2));
	}

	// using brute force
	public static void getNextSmallest(int num) {
		if (num <= 0) {
			System.out.println("ERROR");
			return;
		}

		String value = Integer.toBinaryString(num);
		StringBuilder result = new StringBuilder();
		int length = value.length() - 1;
		int toOne = 0;
		int toZero = 0;
		boolean leave = false;

		for (int i = length; i >= 0; i--) {
			char bit1 = value.charAt(i);

			if (bit1 == '1') {
				toZero = i;

				for (int j = toZero; j <= length; j++) {
					char bit2 = value.charAt(j);

					if (bit2 == '0') {
						toOne = j;
						leave = true;
						break;
					}
				}
			}

			if (leave == true)
				break;
		}

		System.out.println("Orignal value: " + value + " "
				+ Integer.parseInt(value, 2));

		if (toZero < toOne) {
			for (int i = 0; i <= length; i++) {
				if (i == toZero) {
					result.append('0');
				} else if (i == toOne) {
					result.append('1');
				} else {
					result.append(value.charAt(i));
				}
			}

			System.out.println("Next smallest: " + result.toString() + " "
					+ Integer.parseInt(result.toString(), 2));
		} else {
			System.out.println("Next smallest: " + value + " "
					+ Integer.parseInt(value, 2));
		}
	}

	// using brute force (validated)
	public static void getNextLargest(int num) {
		if (num <= 0) {
			System.out.println("ERROR");
			return;
		}

		String value = padding(num);
		StringBuilder result = new StringBuilder();
		int length = value.length() - 1;
		int toOne = 0;
		int toZero = 0;
		boolean leave = false;

		for (int i = length; i >= 0; i--) {
			char bit1 = value.charAt(i);

			if (bit1 == '0') {
				toOne = i;

				for (int j = i + 1; j <= length; j++) {
					char bit2 = value.charAt(j);

					if (bit2 == '1') {
						toZero = j;
						leave = true;
						break;
					}
				}
			}

			if (leave == true)
				break;
		}

		System.out.println("Original value: " + value + " "
				+ Integer.parseInt(value, 2));

		if (toOne < toZero) {
			for (int i = 0; i <= length; i++) {
				if (i == toZero) {
					result.append('0');
				} else if (i == toOne) {
					result.append('1');
				} else {
					result.append(value.charAt(i));
				}
			}

			System.out.println("Next largest: " + result.toString() + " "
					+ Integer.parseInt(result.toString(), 2));
		} else {
			System.out.println("Next largest: " + value + " "
					+ Integer.parseInt(value, 2));
		}
	}

	public static int getNext(int number) {
		int c0 = 0;
		int c1 = 0;
		int n = number;

		while (((n & 1) == 0) && (n != 0)) {
			c0++;
			n >>= 1;
		}

		while ((n & 1) == 1) {
			c1++;
			n >>= 1;
		}

		if (c0 + c1 == 31 || c0 + c1 == 0) {
			return -1;
		}

		int p = c0 + c1;

		number |= (1 << p);
		number &= ~((1 << p) - 1);
		number |= ((1 << (c1 - 1)) - 1);

		return number;
	}

	public static int getPrev(int number) {
		int c0 = 0;
		int c1 = 0;
		int n = number;

		while ((n & 1) == 1) {
			c1++;
			n >>= 1;
		}

		if (n == 0)
			return -1;

		while (((n & 1) == 0) && n != 0) {
			c0++;
			n >>= 1;
		}

		int p = c0 + c1;
		number &= ((~0) << (p + 1));
		int mask = (1 << (c1 + 1)) - 1;
		number |= mask << (c0 - 1);

		return number;

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
