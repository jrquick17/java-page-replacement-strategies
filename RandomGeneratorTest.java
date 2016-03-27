import java.util.Random;


public class RandomGeneratorTest {
	public static void main (String[]args) {
		Random gen = new Random();
		long count = 10000000000L;
		long nums[] = new long[100];
		
		while (count > 0){
			nums[gen.nextInt(100)]++;
			if (count % 100000000 == 0) {
				System.out.println(count);
			}
			count--;
		}
		
		for (int i = 0; i < nums.length; i++)
			System.out.println(i + ": " + nums[i] + "\t" + ((double)nums[i]/count) + "%");
	}
}
