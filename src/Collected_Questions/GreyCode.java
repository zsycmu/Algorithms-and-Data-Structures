package Collected_Questions;

public class GreyCode {
	public static int greyCode(byte term1, byte term2) {
		byte x = (byte)(term1 ^ term2);
		int total = 0;
		while (x != 0) {
			x = (byte)(x & (x - 1));
			total++;
		}
		if (total == 1) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static int greyCode2(byte element1, byte element2) {
		byte res = (byte)(element1 ^ element2);
		for (int i = 0; i <= 7; i++) {
			byte temp = (byte)(1 << i);
			if (temp == res) {
				return 1;
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		byte a = (byte) 0001000;
		byte b = (byte) 10000000;
		System.out.println(greyCode(a, b));
	}
}
