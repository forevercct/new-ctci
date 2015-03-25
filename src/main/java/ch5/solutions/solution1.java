package ch5.solutions;

public class solution1 {

	public static void main(String[] args) {
		String N = "10000000";
		String M = "10011";
		int i = 2;
		int j = 6;
				
		System.out.println(padding(updateBits(N, M, i, j)));
	}
 
	public static void mergeBit(String n, String m, int start, int end) {
		int length = m.length();
		int space = end - start + 1;

		if (space < length) {
			System.out.println("Don't have enough space to fill all of M");
		} else {
			int nValue = Integer.parseInt(n, 2);
			for (int i = end; i >= start; i--) {
				nValue = updateBit(nValue, i, m.charAt(end - i) - 48);
			}

			System.out.println("The merge result is:"
					+ Integer.toBinaryString(nValue));
		}
	}

	public static int updateBits(String n, String m, int start, int end) {
		int allOnes = ~0;

		// 1s before position end
		int left = (allOnes << (end + 1));

		// 1s after position start
		int right = ((1 << start) - 1);

		int mask = left | right;
		
		int nBinary = Integer.parseInt(n, 2);
		int mBinary = Integer.parseInt(m, 2);
		int n_cleared = nBinary & mask;
		int m_shifted = mBinary << start;
		
		return n_cleared | m_shifted;
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
