/**
 * 
 * Excel Sheet Column Title
 * 
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * 
 * For example:
 * 
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB 
 *
 */
/*
 * Notice: char c = (char)(n % 26 + 'A');
 */
public class Solution_168_Excel_Sheet_Column_Title {
	public String convertToTitle(int n) {
        if (n == 0) {
            return null;
        }
        
        String result = "";
        
        while (n > 0) {
            n--;
            char c = (char)(n % 26 + 'A');
            result = result + c;
            n = n / 26;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = result.length() - 1; i >=0; i--) {
            sb.append(result.charAt(i));
        }
        
        return sb.toString();
    }
}
