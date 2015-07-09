package Collected_Questions;

public class BullsAndCows {
	public static void bullsAndCows(String p1, String p2){
		if(p1 == null || p2 ==null)
			throw new NullPointerException();
		
		int[] p1Counts = new int[256];
		int[] p2Counts = new int[256];
		int n=p1.length();
		int m=p2.length();
		
		// find the bulls at the same location k
		int k=0, bulls=0;
		while (k<m && k<n) {
			if (p1.toLowerCase().charAt(k) == p2.toLowerCase().charAt(k)) {
				bulls++;
			}			
			k++;
		}
		
		// store each char in array 
		for(int i=0; i < n; i++){
			p1Counts[p1.toLowerCase().charAt(i)]++;		
		}
		
		for(int j=0; j < m; j++){
			p2Counts[p2.toLowerCase().charAt(j)]++;
		}
		
		
		int cows = 0;
		for(int i = 0; i < 256; i++){
			cows += Math.min(p1Counts[i], p2Counts[i]);
		}
		cows -= bulls;
		System.out.println("Bulls = "+bulls+", Cows = "+cows);
	}
	public static void main (String[] args ) {
		bullsAndCows("Picture","Epic");
		bullsAndCows("forum","four");		
	}
}
