import java.util.Stack;

/**
 * 
 * Simplify Path
 * 
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * 
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 * 
 */
/*
 * Notice: 1. 这几种情况都要跳过去：s == null || s.length() == 0 || s.equals(".") || s.equals("/")
 * 		   2. 利用栈的特性，如果sub string element
 * 		   1. 等于“/”，跳过，直接开始寻找下一个element
 * 		   2. 等于“.”，什么都不需要干，直接开始寻找下一个element
 * 		   3. 等于“..”，弹出栈顶元素，寻找下一个element
 * 		   4. 等于其他，插入当前element为新的栈顶，寻找下一个element
 * 		   最后，再根据栈的内容，重新拼path。这样可以避免处理连续多个“/”的问题。
 */
	

public class Solution_071_Simplify_Path {
	public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] split = path.split("/");
        
        for (String s : split) {
            if (s == null || s.length() == 0 || s.equals("/") || s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
            	if(stack.size() > 0){
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }
        
        if (stack.isEmpty()) {
            return "/";
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        
        return sb.toString();
    }
	
	public static void main(String[] args) {
		String input = "/a/./b/../../c/";
		System.out.println(simplifyPath(input));
	}
}
