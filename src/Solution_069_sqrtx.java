/**
 * 
 * Sqrt(x)
 * 
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 *
 */
/*
 * Notice: 要用long。再看看，不是很理解。
 */
public class Solution_069_sqrtx {
	public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        
        long start = 0;
        long end = x;
        long mid = 0;
        
        while (start <= end) {
            mid = (start + end) / 2;
            if (mid * mid == x) {
                return (int)mid;
            } else if (mid * mid < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return (int)end;
    }
}
