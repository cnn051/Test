import java.util.*;

public class Calculator {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
	Scanner scan = new Scanner(System.in);
	
	System.out.print("정수를 입력하세요 > ");
	String input = scan.nextLine();
	int num = Integer.parseInt(input);
	
	System.out.print("연산 기호를 쓰시오 > ");
	String input2 = scan.nextLine();
	String Symbol = input2;
	
	System.out.print("정수를 입력하세요 > ");
	String input3 = scan.nextLine();
	int num2 = Integer.parseInt(input3);
	
	int Result; // 결과값
	double DR; // Decimal Result (소수)
	
		switch (Symbol) {
			case "x" :
				Result = num * num2;
				System.out.printf("입력내용 : %d * %d = %d", num, num2, Result);	
				break;
			case "+" :
				Result = num + num2;
				System.out.printf("입력내용 : %d + %d = %d", num, num2, Result);
				break;
			case "-" :
				Result = num - num2;
				System.out.printf("입력내용 : %d - %d = %d", num, num2, Result);
				break;
			case "/" :
				DR = (double) num / num2;
				System.out.printf("입력내용 : %d / %d = %f",num, num2, DR);
				break;
		}
	}
}