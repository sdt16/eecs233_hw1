
/**
 * @author Schuyler Thompson
 *
 */
public class LinearSearcher implements Searchable {

	/* (non-Javadoc)
	 * @see Searchable#find(int)
	 */
	int[] nums; 
	String[] strings;
	LinearSearcher(int[] nums, String[] strings){
		this.nums = nums;
		this.strings = strings;
	}
	public String find(int key) {
		long startTime = System.nanoTime();
		for (int i = 0; i<nums.length; i++){
			if (nums[i] == key){
				long elapsedTime = System.nanoTime() - startTime;
				System.out.println("The elapsed time for the Linear Search was: " + elapsedTime);
				return strings[i];
			}
		}
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println("The elapsed time for the Linear Search was: " + elapsedTime);
		return null;
	}

}
