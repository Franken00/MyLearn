import java.util.Random;
import java.util.Scanner;
public class GuessNumber{
	public static void main(String[] args){
		Random ran = new Random();
		int i = ran.nextInt(10)+1;
		System.out.println("������֣�");
		Scanner sc = new Scanner(System.in);
		while(true){
			int s = sc.nextInt();
			if(s!=i)
			{
				if(s>i)
					System.out.println("�´���");
				else
					System.out.println("��С��");
			}
			else
			{
				System.out.println("��ȷ����Ϸ������");
				break;
			}
		}
	}
}