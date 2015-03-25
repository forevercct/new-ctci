package ch5.solutions;

public class solution2 {

	public static void main(String[] args) {
		convertToBinary(0.75);
	}

	public static void convertToBinary(double num) {
		StringBuilder result = new StringBuilder();
		if (num <= 0 || num >= 1) {
			System.out.println("ERROR!");
			return;
		}

		int count = 0;
		while (num != 0 && count <= 32) {
			num *= 2;
			if (num >= 1) {
				num -= 1;
				result.append(1);
			} else {
				result.append(0);
			}

			count++;
		}

		if (count > 32) {
			System.out.println("ERROR!");
			return;
		}

		result.insert(0, "0.");
		System.out.println(result.toString());
	}

}
