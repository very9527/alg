package alg.bloom;

import java.util.BitSet;


public class BloomFilter {
	private static int[] seeds = {3,7,13,17,19,23};
	private static String invalidStr = "tom@gmail.com";
	private static int LENGHT = 2<<24;
	private static BitSet sets = new BitSet(LENGHT);
	
	public static void main(String[] args) {
		setValue();
		check();
	}
	
	public static void setValue() {
		for (int i = 0; i < seeds.length; i++) {
			int hashCode = hash(invalidStr, seeds[i]);
			sets.set(hashCode,true);
		}
	}
	
	public static void check() {
		String checkValue = "tom1@gmail.com";
		for (int i = 0; i < seeds.length; i++) {
			int hashCode = hash(checkValue, seeds[i]);
			boolean existed = sets.get(hashCode);
			if (!existed) {
				System.out.println("不存在");
				break;
			}
		}
	}
	
	public static int hash(String hashStr, int seed) {
		int result = 0;
		for(int i=0;i<hashStr.length(); i++) {
			result = seed*result + hashStr.charAt(i);
		}
		return (LENGHT -1) & result;
	}
}	
