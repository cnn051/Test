import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener {
	private JLabel label;	/* 레이블 */
	private JLabel label2;
	JButton button[] = new JButton[16];

	String actionCommand2 = ""; /* 레이블에 그대로 표시해서 보여주기 위해 String 변수 선언 */
	long newnum;		/* String 문자를 int형으로 변환시켜 저장할 변수 선언 */
	long oldnum; /* newnum에 저장된 숫자를 잠시 저장해둘 변수 선언 */
	long result; /* 결과 값을 보여줄 변수 선언 */
	String operator = ""; /* 연산자를 저장해둘 변수 선언 */
	
	/* 동작 관련 */
	@Override
	public void actionPerformed(ActionEvent e) {	/* 계산기의 기본적인 동작을 담당 */
		
		String actionCommand = e.getActionCommand(); /*연산기호를 입력했는지 스위치 문에서 확인하기 위해 가장 최근에 입력된 문자만 저장함*/
		
		switch (actionCommand) {
		case "+":
			oldnum = newnum;
			operator = "+";
			actionCommand2 =""; /*연산기호를 눌렀을 때, 새로운 숫자를 받아오기 위해 값을 초기화 해줌*/	
			System.out.println("더하기");
			break;
		case "-":
			oldnum = newnum;
			operator = "-";
			actionCommand2 ="";
			System.out.println("빼기");
			break;
		case "x":
			oldnum = newnum;
			operator = "x";
			actionCommand2 ="";
			System.out.println("곱셈");
			break;
		case "/":
			oldnum = newnum;
			operator = "/";
			actionCommand2 ="";
			System.out.println("나눗셈");
			break;


		case "=": 
			if(operator == "+") {
				result = oldnum + newnum;	/* oldnum와 newnum를 더해서 result변수에 저장 */
//				label.setText(String.valueOf(oldnum + " + " + newnum + " = " + result)); /* label에 인트형 값은 출력할 수 없어서 스트링으로 변환후 출력 */
				label.setText(String.valueOf(result));
			}else if (operator == "-") {
				result = oldnum - newnum;	/* oldnum와 newnum를 빼서 result변수에 저장 */
//				label.setText(String.valueOf(oldnum + " - " + newnum + " = " + result)); /* label에 인트형 값은 출력할 수 없어서 스트링으로 변환후 출력 */
				label.setText(String.valueOf(result));
			}else if(operator == "x") {
				result = oldnum * newnum;	/* oldnum와 newnum를 곱해서 result변수에 저장 */
//				label.setText(String.valueOf(oldnum + " X " + newnum + " = " + result)); /* label에 인트형 값은 출력할 수 없어서 스트링으로 변환후 출력 */
				label.setText(String.valueOf(result));
			}else if (operator == "/") {
				result = oldnum / newnum;	/* oldnum와 newnum를 나누어서 result변수에 저장 */
//				label.setText(String.valueOf(oldnum + " / " + newnum + " = " + result)); /* label에 인트형 값은 출력할 수 없어서 스트링으로 변환후 출력 */
				label.setText(String.valueOf(result));
			}
			break;
		case "C":
			label.setText("");
			actionCommand2 = "";
			oldnum = 0;
			newnum = 0;
			result = 0;
			break;
			
		default:
			actionCommand2 += e.getActionCommand();
			label.setText(actionCommand2); // 레이블에 적힌 문자 + 최근에 입력된 문자
			
			newnum = Integer.parseInt(actionCommand2);			
			break;
		}

	};
	
	/* UI 관련 */
	public MyFrame() {
				
		Color BackColor = new Color(220,223,228);
		Color FontColor = new Color(23,24,30);
		
		/* 패널 관련 설정 */
		JPanel NP = new JPanel();
		add(NP);
		JPanel CP = new JPanel();
		add(CP);
		
		/* 프레임 관련 설정 */
		setTitle("계산기");
		setLayout(new GridLayout(2,2));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setSize(320, 450);			/* 계산기 크기 */
		setVisible(true);			
		
		/* label 관련 설정 */
		label = new JLabel("0", SwingConstants.RIGHT);		/* 레이블 세팅 */
		
		label.setFont(new Font("맑은 고딕", 0, 35)); /* 레이블 폰트 */
		label.setOpaque(true);					/* true로 설정해야 배경색이 적용됨 */
		label.setBackground(BackColor);		/* 레이블 배경 색상 */
		label.setForeground(FontColor);		/* 레이블 폰트 색상 */
		
//		JLabel j = new JLabel("<html><body style='text-align:center;'>안녕녕하세요<br />무척 반갑습니다.</body></html>", JLabel.CENTER);
		
		label2 = new JLabel("9", JLabel.LEFT);
		
		
//		NP.add(j);
		NP.add(label);				/* NorthPanel에 레이블 추가 */		
		NP.add(label2);
		NP.setBackground(BackColor);		
		
		/* 버튼 값 배열 선언 */
		String buttonValue[] = {"7", "8", "9", "/", "4", "5", "6", "x", "1", "2", "3", "-", "C", "0", "=", "+"};
		/* 버튼 배치 및 클릭시 이벤트 발동 */
		for (int i = 0; i <= 15; i++) {
			button[i] = new JButton(buttonValue[i]);
			
			CP.add(button[i]);					/* CenterPanel에 버튼 추가 */
			button[i].setBackground(Color.WHITE); /* 버튼 배경색 화이트 */
			button[i].setFont(new Font("굴림",Font.BOLD,25)); /* 버튼 폰트 세팅 */
			button[i].setForeground(Color.BLACK); /* 버튼 글자색 검정색 */
			
			button[i].addActionListener(this);	/* 버튼 클릭했을 때 동착하게끔 */
			
		}
		
		CP.setLayout(new GridLayout(0,4));		/* CenterPanel을 그리드레이아웃으로 배치 0을 기입하면 auto */
	}
		
}
