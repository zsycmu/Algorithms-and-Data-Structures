/**
 * Jump Game
 * 
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array. Each element in the array represents your maximum
 * jump length at that position. Determine if you are able to reach the last
 * index. For example: A = [2,3,1,1,4], return true. A = [3,2,1,0,4], return
 * false.
 * 
 */
/*
 * Notice: 1. Need to do it again. You can solve this by draw a picture. 
 *         2. Even if the first one is 0, it can also be a correct answer. 
 *         3. 用Math.max比直接判断大小慢，会超时。
 *         4. 可以算出每一个点得范围，找到最大值。
 */
class Solution_055_Jump_Game {
	public boolean canJump(int[] A) {
		if (A == null || A.length == 0) {
			return false;
		}
		int maxRange = A[0];
		for (int i = 1; i < A.length; i++) {
			if (maxRange == 0) {
				return false;
			}
			maxRange--;
			if (A[i] > maxRange) {
				maxRange = A[i];
			}
			if (i + A[i] >= A.length - 1) {
				return true;
			}
		}

		return true;
	}

	public boolean canJump2(int[] A) {
		if (A == null || A.length == 0)
			return false;
		int reach = 0;
		for (int i = 0; i <= reach && i < A.length; i++) {
			reach = Math.max(A[i] + i, reach);
		}
		if (reach < A.length - 1)
			return false;
		return true;
	}

	public static void main(String[] args) {
		int[] A = { 2, 3, 1, 1, 4 };
	}
}
