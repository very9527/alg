package alg.bloom;

import java.util.BitSet;

/**
 * 
 * @author very9527
 * 一个用布隆过滤器过滤垃圾邮箱的例子
 *
 */
public class BloomFilter {
	private static int[] seeds = {3,7,13,17,19,23};
	private static String invalidStr = "tom@gmail.com";
	private static int LENGHT = 2<<24;
	private static BitSet sets = new BitSet(LENGHT);
	
	/**
	 * 将垃圾邮箱放入BloomFilter里面
	 */
	public static void setVaildEmail() {
		for (int i = 0; i < seeds.length; i++) {
			int hashCode = hashEmail(invalidStr, seeds[i]);
			sets.set(hashCode,true);
		}
	}
	
	/**
	 * 检查某邮箱是否在过滤器中。
	 */
	public static void checkEmail(String email) {
		
		boolean existed = true;
		for (int i = 0; i < seeds.length; i++) {
			int hashCode = hashEmail(email, seeds[i]);
			existed = sets.get(hashCode);
			if (!existed) {
				break;
			}
		}
		
		if (existed){
			System.out.println("存在");
		} else {
			System.out.println("不存在");
		}
	}
	
	/**
	 * 对字符串进行 hash
	 * @param str
	 * @param seed
	 * @return
	 */
	public static int hashEmail(String str, int seed) {
		int result = 0;
		for(int i=0;i<str.length(); i++) {
			result = seed*result + str.charAt(i);
		}
		return (LENGHT -1) & result;
	}
	
	
	public static void main(String[] args) {
		setVaildEmail();
		String email = "tom@gmail.com";
		checkEmail(email);
	}
}	
