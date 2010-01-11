/**
 * @author Schuyler Thompson
 *
 */
import java.util.*;

public class BinarySearcher implements Searchable {

	/* (non-Javadoc)
	 * @see Searchable#find(int)
	 */
	int[] nums;
	String[] strings;
	
	@SuppressWarnings("unchecked")
	BinarySearcher(int[] nums, String[] strings) {
		this.nums = nums;
		this.strings = strings;
		if (nums.length != strings.length)
			throw new Error();
		ArrayList numsList = new ArrayList(Arrays.asList(nums));
		for(int i : nums) {
			if (numsList.indexOf(i) != numsList.lastIndexOf(i))
				throw new Error();
		}
		ArrayList stringsList = new ArrayList(Arrays.asList(strings));
		for(String i : strings) {
			if (stringsList.indexOf(i) != stringsList.lastIndexOf(i))
				throw new Error();
		}
		/*for (int i = nums.length-1; i>=1; i--) {
			int currentMax = nums[0];
			int currentMaxIndex = 0;
			
			 for (int j = 1; j<=i; j++) {
				if (currentMax < nums[j]) {
					currentMax = nums[j];
				}
			}
			
			if (currentMaxIndex != i){
				nums[currentMaxIndex] = nums[i];
				strings[currentMaxIndex] = strings[i];
				nums[i] = currentMax;
			}
		}*/
		//Algo. Adopted from Intro to Java by Liang
		for (int i = 1; i < nums.length; i++) {
		      /** insert list[i] into a sorted sublist list[0..i-1] so that
		           list[0..i] is sorted. */
		      int currentElement = nums[i];
		      int k;
		      for (k = i - 1; k >= 0 && nums[k] > currentElement; k--) {
		        nums[k + 1] = nums[k];
		        strings[k+1] = strings[k];
		      }

		      // Insert the current element into list[k+1]
		      nums[k + 1] = currentElement;
		    }

	}
	public String find(int key) {
		long startTime = System.nanoTime();
		int low = 0;
		int hi = nums.length-1;
		double i;
		while (low <= hi){
			i = Math.floor((low+hi)/2.0);
			if (key == nums[(int)i]) {
				long elapsedTime = System.nanoTime() - startTime;
				System.out.println("The elapsed time for the Binary Search was: " + elapsedTime);
				return strings[(int)i];
			}
			else if (key < nums[(int)i])
				hi = (int) (i-1);
			else
				low = (int) (i+1);
		}
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println("The elapsed time for the Binary Search was: " + elapsedTime);
		return null;
	}

}
