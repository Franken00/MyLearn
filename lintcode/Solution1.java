package K;

public class Solution1 {
	public long nNumber(long n){//�ݹ���׳�
        if(n == 1){
            return 1;
        }
        else{
            return n*nNumber(n-1);
        }
    }
	
	public long zeros(long i){//��0���ֵĸ���
        int zero = 0;//0�ĸ���
        for(long j = 10; j < i ; j=j*10){
        	if(i % j ==0) {
        		zero++;
        	}
        }
        return zero;
    }
	
	//�����Ժ���㷨����5�ı����ĸ������ɡ�
	public class Solution {
	    /*
	     * @param n: An integer
	     * @return: An integer, denote the number of trailing zeros in n!
	     */
	    public long trailingZeros(long n) {
	        // write your code here, try to do it without arithmetic operators.
			long count = 0;
	            while (n > 0) {
	                count += (n / 5);
	                n /= 5;
	            }
	            return count;
	    }
	}
	public static void main(String[] args) {
		Solution1 s = new Solution1();
		long k = s.nNumber(26);
		System.out.println(k);		
		long result = s.zeros(k);
		System.out.println(result);
	}
}
