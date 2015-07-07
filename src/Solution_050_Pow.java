/**
 * 
 * Pow(x, n)
 * 
 * Implement pow(x, n).
 *
 */
/*
 * Notice: n == 0 return 1.
 */

public class Solution_050_Pow {
	public double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        
        double helf = pow(x, n / 2);
        
        if (n % 2 == 0) {
            return helf * helf;
        }
        
        if (n > 0) {
            return helf * helf * x;
        } else {
            return helf * helf / x;
        }
    }
}
