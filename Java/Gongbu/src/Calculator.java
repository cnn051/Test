import java.util.*;

public class Calculator {

	public static void main(String[] args) {
		// TODO �ڵ� ������ �޼ҵ� ����
	Scanner scan = new Scanner(System.in);
	
	System.out.print("������ �Է��ϼ��� > ");
	String input = scan.nextLine();
	int num = Integer.parseInt(input);
	
	System.out.print("���� ��ȣ�� ���ÿ� > ");
	String input2 = scan.nextLine();
	String Symbol = input2;
	
	System.out.print("������ �Է��ϼ��� > ");
	String input3 = scan.nextLine();
	int num2 = Integer.parseInt(input3);
	
	int Result; // �����
	double DR; // Decimal Result (�Ҽ�)
	
		switch (Symbol) {
			case "x" :
				Result = num * num2;
				System.out.printf("�Է³��� : %d * %d = %d", num, num2, Result);	
				break;
			case "+" :
				Result = num + num2;
				System.out.printf("�Է³��� : %d + %d = %d", num, num2, Result);
				break;
			case "-" :
				Result = num - num2;
				System.out.printf("�Է³��� : %d - %d = %d", num, num2, Result);
				break;
			case "/" :
				DR = (double) num / num2;
				System.out.printf("�Է³��� : %d / %d = %f",num, num2, DR);
				break;
		}
	}
}