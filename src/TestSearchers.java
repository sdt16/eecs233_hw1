
/**
 * @author Schuyler Thompson
 *
 */
import java.util.ArrayList;
import java.util.*;


public class TestSearchers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numList = new ArrayList<Integer>(1000);
		String[] strings = new String[1000];
		Random generator = new Random();
		int generatedInt = 0;
		for (int i = 0; i<1000; i++) {
			
			generatedInt = generator.nextInt();
			if(!numList.contains(generatedInt)){
					numList.add(i, Math.abs(generatedInt));
					strings[i] = Long.toString(Math.abs(generator.nextLong()), 36);
				}
			}
		int[] nums = new int[numList.size()];
		for (int i=0; i<numList.size(); i++) {
			nums[i]=numList.get(i);
		}
		
		BinarySearcher bs = new BinarySearcher(Arrays.copyOf(nums,nums.length), strings);
		LinearSearcher ls = new LinearSearcher(Arrays.copyOf(nums,nums.length), strings);
		if (test(bs, nums, strings) == true) {
			System.out.println("The Binary Search test succeeded.");
		}
		else
			System.out.println("The Binary Search test failed.");
		if (test(ls, nums, strings) == true) {
			System.out.println("The Linear Search test succeeded.");
		}
		else
			System.out.println("The Linear Search test failed.");
	}
	
	public static boolean test(Searchable s, int[] nums, String[] strings) {
		Random generator = new Random();
		int i = 0;
		int j = 0;
		List<Integer> testList = new ArrayList<Integer>(100); 
		/*while (i<=50) {
			j = nums[generator.nextInt(nums.length)];
			if (!testList.contains(j)) {
				testList.add(j);
				i++;
			}
		}*/
		
		List<Integer> numsList = new ArrayList<Integer>(nums.length);
		for (int n : nums) {
			numsList.add(n);	
		}
		while (i<=100) {
			j = generator.nextInt();
			if (!(testList.contains(j) && numsList.contains(j))) {
				testList.add(j);
				i++;
			}
		}
		boolean testSuccess = true;
		for (int n = 0; n < testList.size(); n++) {
			//for (int k )
			if (!((numsList.indexOf(n) == -1 && s.find(n)==null) || (strings[numsList.indexOf(n)] == s.find(n))))
				testSuccess = false;
		}
		return testSuccess;
		
	}

}
