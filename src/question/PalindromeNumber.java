package question;

public class PalindromeNumber {

	public static boolean checkPalindrome1(int n){
		if( n < 0)
				return false;
		int head = 0;
		int m = n, temp = n;
		while(temp/10 !=0){
			temp /= 10;
			head ++;
		}
		while(head >= 0){
			int headDigit = n/(int)Math.pow(10,head);
			int tailDigit = m%10;
			if(headDigit!=tailDigit)
				return false;
			n -= headDigit * Math.pow(10,head);
			m /= 10;
			head -- ;
		}
		return true;
	}
	
	public static boolean checkPalindrome2(int n){
		if(n < 0)
			return false;
		int div = 1;
		while( n/div >= 10)
			div *= 10;
		while( n != 0 ){
			int head = n /div;
			int tail = n % 10;
			if(head != tail)
				return false;
			n = (n%div)/10;
			div /= 100;
		}
		return true;
	}
	
	public static boolean checkPalindrome3(int n){
		if(n < 0)
			return false;
		int div = 1;
		while( n / div >= 10)
			div *= 10;
		int m = 0, temp = n;
		while(temp!=0){
			m += (temp%10) * div;
			div/= 10;
			temp /= 10;
		}

		if( n != m)
			return false;
		return true;
		
	}
	
	
	public static void main(String[] args) {
		int n = 1234554321;
		System.out.println(checkPalindrome1(n));
		System.out.println(checkPalindrome2(n));
		System.out.println(checkPalindrome3(n));
	}
	
}
