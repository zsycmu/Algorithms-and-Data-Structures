package Collected_Questions;

public class RecersiveReverse {
	public static String Reverse(String input) {
		if (input == null || input.length() == 0) {
			return null;
		}
		
		String[] split = input.split(" ");
		
		StringBuilder sb = new StringBuilder();
		
		helper(split, sb, split.length - 1);
		
		return sb.toString();
	}
	
	public static void helper(String[] split, StringBuilder sb, int index) {
		if (index < 0) {
			return;
		}
		sb.append(split[index]);
		sb.append(" ");
		helper(split, sb, index - 1);
	}
	
	public static void main(String[] args) {
		String result = Reverse("This is a good day");
		System.out.println(result);
	}
}
