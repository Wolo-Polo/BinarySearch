package utils;

public class RandomUtil {
	public static int randomNumber(int min, int max) {
		return (int)(Math.random()*(max-min)) +min; //random trong khoang 0-100
	}

	public static String randomString() {
		String alpha="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";
		int length=randomNumber(1, 15);//leng name 0-15
		StringBuilder result= new StringBuilder();
		for(int i=0; i<length; i++) {
			int localChar=randomNumber(0, 52);
			result.append(alpha.charAt(localChar));
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		for(int i=0; i<50; i++) {
			System.out.println("num: " + randomNumber(0, 100) + " string: " + randomString());
		}
		//System.out.println(randomNumber(0, 50));
	}
}