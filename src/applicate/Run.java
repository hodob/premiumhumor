package applicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Run {
	// �ʵ�
	Quizs quizs = new Quizs();
	Random random = new Random();
	
	Scanner scanner = new Scanner(System.in);
	String userAnswer;
	boolean gameStatus = false;
	List<String> quizsList = new ArrayList<String>();
	List<String> answerList = new ArrayList<String>();
	int randomNum=2;
	
	
	// ������
	// ��ü�� �����Ǹ� �������� �ϳ� �����.
	public Run() {

		for (String s : quizs.quizs) {
			quizsList.add(s);
		}
		for (String s : quizs.answers) {
			answerList.add(s);
		}
		
		do {
			if(quizsList.size()>0) {
				randomNum = random.nextInt(quizsList.size());
				System.out.println("test");
			}else System.out.println(quizsList.size());
			startQuizs();
			getUserInput();
		} while (gameStatus == true);
	}
	// ���� �޼ҵ�
	public void run() {
	}
	// ���� ���� �޼ҵ�
	public void startQuizs() {
		System.out.println(quizsList.get(randomNum));
	}
	public void getUserInput() {
		userAnswer = scanner.nextLine();
		if (answerList.get(randomNum).equals(userAnswer)) {
			System.out.println("����");
			quizsList.remove(randomNum);
			answerList.remove(randomNum);
			try {
				randomNum = random.nextInt(quizsList.size());
			} catch (Exception e) {
				
			}
			if (quizsList.size() == 0) {
				System.out.println("�ٸ��� ��������");
			} else {
				gameStatus = true;
			}
		} else {
			System.out.println("Ʋ��");
		}
	}
}
