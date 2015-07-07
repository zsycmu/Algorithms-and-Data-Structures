import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Solution_179_Largest_Number {
	public static String largestNumber(List<Integer> num) {
        if (num == null || num.size() == 0) {
            return null;
        }
        
        class Sort implements Comparator<String> {
            public int compare(String a, String b) {
                double a1 = Double.parseDouble(a + b);
                double b1 = Double.parseDouble(b + a);
                
                if (a1 > b1) {
                    return -1;
                } else if (a1 < b1) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
        
        String[] str = new String[num.size()];
        for (int i = 0; i < num.size(); i++) {
            String temp = Integer.toString(num.get(i));
            str[i] = temp;
        }
        
        Arrays.sort(str, new Sort());
        
        String result = "";
        for (int i = 0; i < str.length; i++) {
            String temp = str[i];
            result = result + temp;
        }
        
        int i = 0;
        
        while (i < result.length() && result.charAt(i) == '0') {
            i++;
        }
        
        if (i == result.length()) {
            return "0";
        }
        
        return result.substring(i);
    }
	
	public static void main(String[] args) {
		int[] num = {3, 30, 34, 5, 9};
		List<Integer> list = new ArrayList<Integer>();
		list.add(999999998);
		list.add(999999999);
		list.add(999999997);
//		list.add(5);
//		list.add(9);
		String result = largestNumber(list);
		System.out.println(result);
	}
}
