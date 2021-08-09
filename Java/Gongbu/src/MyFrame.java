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
	private JLabel label;	/* ���̺� */
	private JLabel label2;
	JButton button[] = new JButton[16];

	String actionCommand2 = ""; /* ���̺� �״�� ǥ���ؼ� �����ֱ� ���� String ���� ���� */
	long newnum;		/* String ���ڸ� int������ ��ȯ���� ������ ���� ���� */
	long oldnum; /* newnum�� ����� ���ڸ� ��� �����ص� ���� ���� */
	long result; /* ��� ���� ������ ���� ���� */
	String operator = ""; /* �����ڸ� �����ص� ���� ���� */
	
	/* ���� ���� */
	@Override
	public void actionPerformed(ActionEvent e) {	/* ������ �⺻���� ������ ��� */
		
		String actionCommand = e.getActionCommand(); /*�����ȣ�� �Է��ߴ��� ����ġ ������ Ȯ���ϱ� ���� ���� �ֱٿ� �Էµ� ���ڸ� ������*/
		
		switch (actionCommand) {
		case "+":
			oldnum = newnum;
			operator = "+";
			actionCommand2 =""; /*�����ȣ�� ������ ��, ���ο� ���ڸ� �޾ƿ��� ���� ���� �ʱ�ȭ ����*/	
			System.out.println("���ϱ�");
			break;
		case "-":
			oldnum = newnum;
			operator = "-";
			actionCommand2 ="";
			System.out.println("����");
			break;
		case "x":
			oldnum = newnum;
			operator = "x";
			actionCommand2 ="";
			System.out.println("����");
			break;
		case "/":
			oldnum = newnum;
			operator = "/";
			actionCommand2 ="";
			System.out.println("������");
			break;


		case "=": 
			if(operator == "+") {
				result = oldnum + newnum;	/* oldnum�� newnum�� ���ؼ� result������ ���� */
//				label.setText(String.valueOf(oldnum + " + " + newnum + " = " + result)); /* label�� ��Ʈ�� ���� ����� �� ��� ��Ʈ������ ��ȯ�� ��� */
				label.setText(String.valueOf(result));
			}else if (operator == "-") {
				result = oldnum - newnum;	/* oldnum�� newnum�� ���� result������ ���� */
//				label.setText(String.valueOf(oldnum + " - " + newnum + " = " + result)); /* label�� ��Ʈ�� ���� ����� �� ��� ��Ʈ������ ��ȯ�� ��� */
				label.setText(String.valueOf(result));
			}else if(operator == "x") {
				result = oldnum * newnum;	/* oldnum�� newnum�� ���ؼ� result������ ���� */
//				label.setText(String.valueOf(oldnum + " X " + newnum + " = " + result)); /* label�� ��Ʈ�� ���� ����� �� ��� ��Ʈ������ ��ȯ�� ��� */
				label.setText(String.valueOf(result));
			}else if (operator == "/") {
				result = oldnum / newnum;	/* oldnum�� newnum�� ����� result������ ���� */
//				label.setText(String.valueOf(oldnum + " / " + newnum + " = " + result)); /* label�� ��Ʈ�� ���� ����� �� ��� ��Ʈ������ ��ȯ�� ��� */
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
			label.setText(actionCommand2); // ���̺� ���� ���� + �ֱٿ� �Էµ� ����
			
			newnum = Integer.parseInt(actionCommand2);			
			break;
		}

	};
	
	/* UI ���� */
	public MyFrame() {
				
		Color BackColor = new Color(220,223,228);
		Color FontColor = new Color(23,24,30);
		
		/* �г� ���� ���� */
		JPanel NP = new JPanel();
		add(NP);
		JPanel CP = new JPanel();
		add(CP);
		
		/* ������ ���� ���� */
		setTitle("����");
		setLayout(new GridLayout(2,2));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setSize(320, 450);			/* ���� ũ�� */
		setVisible(true);			
		
		/* label ���� ���� */
		label = new JLabel("0", SwingConstants.RIGHT);		/* ���̺� ���� */
		
		label.setFont(new Font("���� ���", 0, 35)); /* ���̺� ��Ʈ */
		label.setOpaque(true);					/* true�� �����ؾ� ������ ����� */
		label.setBackground(BackColor);		/* ���̺� ��� ���� */
		label.setForeground(FontColor);		/* ���̺� ��Ʈ ���� */
		
//		JLabel j = new JLabel("<html><body style='text-align:center;'>�ȳ���ϼ���<br />��ô �ݰ����ϴ�.</body></html>", JLabel.CENTER);
		
		label2 = new JLabel("9", JLabel.LEFT);
		
		
//		NP.add(j);
		NP.add(label);				/* NorthPanel�� ���̺� �߰� */		
		NP.add(label2);
		NP.setBackground(BackColor);		
		
		/* ��ư �� �迭 ���� */
		String buttonValue[] = {"7", "8", "9", "/", "4", "5", "6", "x", "1", "2", "3", "-", "C", "0", "=", "+"};
		/* ��ư ��ġ �� Ŭ���� �̺�Ʈ �ߵ� */
		for (int i = 0; i <= 15; i++) {
			button[i] = new JButton(buttonValue[i]);
			
			CP.add(button[i]);					/* CenterPanel�� ��ư �߰� */
			button[i].setBackground(Color.WHITE); /* ��ư ���� ȭ��Ʈ */
			button[i].setFont(new Font("����",Font.BOLD,25)); /* ��ư ��Ʈ ���� */
			button[i].setForeground(Color.BLACK); /* ��ư ���ڻ� ������ */
			
			button[i].addActionListener(this);	/* ��ư Ŭ������ �� �����ϰԲ� */
			
		}
		
		CP.setLayout(new GridLayout(0,4));		/* CenterPanel�� �׸��巹�̾ƿ����� ��ġ 0�� �����ϸ� auto */
	}
		
}
