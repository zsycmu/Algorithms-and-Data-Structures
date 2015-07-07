/**
 * 
 * Regular Expression Matching
 * 
 * Implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 * 
 */

/*
 * Note: use these links to learn: 
 * http://simpleandstupid.com/2014/10/14/regular-expression-matching-leetcode-%E8%A7%A3%E9%A2%98%E7%AC%94%E8%AE%B0/
 * http://blog.csdn.net/linhuanmars/article/details/21145563
 * http://articles.leetcode.com/2011/09/regular-expression-matching.html
 * http://blog.csdn.net/linhuanmars/article/details/21198049
 * http://harrifeng.github.io/algo/leetcode/regular-expression-matching.html
 * http://harrifeng.github.io/algo/leetcode/regular-expression-matching.html
 * 
 * 
 * http://www.cnblogs.com/jdflyfly/p/3810681.html
 * 
 */

public class Solution_010_Regular_Expression_Matching {
	public static boolean isMatch(String s, String p) {
        //base case
        if(p.length() == 0){
            return s.length() == 0;
        }
         
        //special case
         
        //case 1: when the second char of p is not '*', easy case.
        if(p.length() == 1 || p.charAt(1) != '*'){
            if(s.length() < 1){
            	return false;
            }
            if((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')){
                return false;
            }
            else{
                return isMatch(s.substring(1), p.substring(1));
            }
        }
         
        //case 2: when the second char of p is '*', complex case.
        else{
             
            //when the '*' stands for 0 preceding element
            if(isMatch(s, p.substring(2))){
                return true;
            }
             
            /*when the '*' stands for 1 or more preceding element,
            try every possible number*/
            int i = 0;
            while(i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')){
                if(isMatch(s.substring(i+1), p.substring(2))){
                    return true;
                }
                i++;
            }
            return false;
        }
    }
	
	public static boolean isMatch2(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }

        // length == 1 is the case that is easy to forget.
        // as p is subtracted 2 each time, so if original
        // p is odd, then finally it will face the length 1
        if (p.length() == 1) {
            return (s.length() == 1)
                    && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
        }

        // next char is not '*': must match current character
        if (p.charAt(1) != '*') {
            if (s.length() < 1) {
                return false;
            } else {
                return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
                        && isMatch2(s.substring(1), p.substring(1));
            }
        }
        // next char is *
        while (s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
            if (isMatch2(s, p.substring(2))) {
                return true;
            }
            s = s.substring(1);
        }
        return isMatch2(s, p.substring(2));
    }
	
	public static void main(String[] args) {
		String a = "cab";
		String b = "a*b";
		System.out.print(isMatch2(a, b));
	}
}
