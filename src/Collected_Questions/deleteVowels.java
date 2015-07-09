package Collected_Questions;

public class deleteVowels {
	public static String eliminateAEIOU(String input) {
		StringBuilder sb = new StringBuilder();
		String v = "aeiouAEIOU";
		
		for (int i = 0; i < input.length(); i++) {
			if (v.indexOf(input.charAt(i)) > -1) {
				continue;
			}
			sb.append(input.charAt((i)));
		}
		
		return sb.toString();
	}
	
	public static String eliminateAEIOU2(String input) {
		StringBuilder sb = new StringBuilder();
		String v = "aeiouAEIOU";
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (v.indexOf(c) == -1) {
				sb.append(c);
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String input = "apple";
		String output = eliminateAEIOU(input);
		System.out.println(output);
	}
}
